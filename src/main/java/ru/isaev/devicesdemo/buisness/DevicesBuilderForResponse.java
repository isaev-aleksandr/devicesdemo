package ru.isaev.devicesdemo.buisness;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.isaev.devicesdemo.model.Device;
import ru.isaev.devicesdemo.model.Event;
import ru.isaev.devicesdemo.model.Project;
import ru.isaev.devicesdemo.model.Type;
import ru.isaev.devicesdemo.viev.ResponseDevices;
import ru.isaev.devicesdemo.viev.ResponseSummaryImfo;

import java.util.HashMap;
import java.util.List;

@Data
@Component
public class DevicesBuilderForResponse {
    private Project project;
    private List<Device> devices;
    private HashMap<String, ResponseDevices> response;


    public HashMap<String, ResponseDevices> getDevicesResponse(Project project){
        this.project = project;
        this.devices = project.getDevices();

        return buildDeviceResponse();
    }

    private HashMap<String, ResponseDevices> buildDeviceResponse(){
        response = new HashMap<>();
        for (Device device: devices){
            response.put(device.getSerialNumber(), new ResponseDevices(
                    device.getId(),
                    device.getSerialNumber(),
                    project.getId(),
                    hashErrors(device),
                    getSummaryInfo(device)
                    ));
        }


        return response;
    }

    private boolean hashErrors(Device deviceForErrors){
        for (Event event: deviceForErrors.getEvents()) {
            if (event.getType() == Type.error) {
                return true;
            }
        }
        return false;
    }

    private ResponseSummaryImfo getSummaryInfo(Device device){
        ResponseSummaryImfo summaryInfo = new ResponseSummaryImfo(
                getCountEvent(device),
                getCountWarning(device),
                getCountErrors(device)
        );
        return summaryInfo;
    }

    private int getCountEvent(Device dev){
        int events = 0;
        for (Event e : dev.getEvents()){
            if (e.getType() == Type.event){
                events++;
            }
        }
        return events;
    }

    private int getCountWarning(Device dev){
        int warnings = 0;
        for (Event e : dev.getEvents()){
            if (e.getType() == Type.warning){
                warnings++;
            }
        }
        return warnings;
    }

    private int getCountErrors(Device dev){
        int errors = 0;
        for (Event e : dev.getEvents()){
            if (e.getType() == Type.error){
                errors++;
            }
        }
        return errors;
    }

}

package ru.isaev.devicesdemo.buisness;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.isaev.devicesdemo.model.Device;
import ru.isaev.devicesdemo.model.Event;
import ru.isaev.devicesdemo.model.Project;
import ru.isaev.devicesdemo.model.Type;
import ru.isaev.devicesdemo.viev.ResponseProject;
import ru.isaev.devicesdemo.viev.ResponseStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class ProjectsBuilderForResponse {
    private List<Project> projects;
    private List<ResponseProject> responses;

    public List<ResponseProject> getProjectResponse(List<Project> projects){
        this.projects = projects;

        return buildProjectResponse();
    }

    private List<ResponseProject> buildProjectResponse(){
        responses = new ArrayList();
            for(Project project: projects){
                responses.add(new ResponseProject(
                        project.getId(),
                        project.getName(),
                        getResponseStatus(project.getDevices()),
                        getDevices(project)
                ));
            }

                return responses;
    }

    private ResponseStatus getResponseStatus(List<Device> devices){
        ResponseStatus responseStatus = new ResponseStatus(
                getDeviceCount(devices),
                getDeviceWithErrors(devices),
                getStableDevices(devices)
        );
        return  responseStatus;
    }

    private int getDeviceCount(List<Device> devices){
        return devices.size();
    }

    private int getDeviceWithErrors(List<Device> devices){
        LocalDate date = LocalDate.now();
        int warningOrErrors = 0;
        for (Device device: devices) {
            for (Event event: device.getEvents()){
                if (
                        (event.getType() != Type.event)
                        &&
                        (event.getDate().getDayOfYear() == date.getDayOfYear()
                            & event.getDate().getYear() == date.getYear()
                        )
                ){
                    warningOrErrors++;
                }
            }
        }
        return warningOrErrors;
    }

    private int getStableDevices(List<Device> devices){
        int stableDevices = 0;
        for (Device device: devices){
            int notStable = 0;
                for (Event event: device.getEvents()){
                    if (event.getType() != Type.event){
                        notStable++;
                    }
                }
                if (notStable == 0){
                    stableDevices++;
                }
            }
        return stableDevices;
    }

    private List<String> getDevices(Project project){
        List<String> devicesSerialNumber = new ArrayList();
        for (Device device: project.getDevices()){
                devicesSerialNumber.add(device.getSerialNumber());
            }
        return devicesSerialNumber;
    }
}

package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classRoomId;
    @NotBlank
    private String buildingName;
    @NotBlank
    private String roomNumber;

    public ClassRoom(Integer classRoomId, String buildingName, String roomNumber) {
        this.classRoomId = classRoomId;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }
    public ClassRoom(){}

    public Integer getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(Integer classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


    @Override
    public String toString() {
        return "Classroom{" +
                "classRoomId=" + classRoomId +
                ", buildingName='" + buildingName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}

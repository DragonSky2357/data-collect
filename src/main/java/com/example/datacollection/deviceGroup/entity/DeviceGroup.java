package com.example.datacollection.deviceGroup.entity;

import com.example.datacollection.deviceGroup.dto.request.AddDeviceGroup;
import com.example.datacollection.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class DeviceGroup extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String stationGroupSerial;

    public DeviceGroup(AddDeviceGroup request) {
        this.stationGroupSerial = request.getStationGroupSerial();
    }
}

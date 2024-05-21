package com.example.datacollection.device.entity;

import com.example.datacollection.device.dto.request.AddDevice;
import com.example.datacollection.deviceGroup.entity.DeviceGroup;
import com.example.datacollection.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Device extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false)
    private String serialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="device_group_id")
    private DeviceGroup deviceGroup;

    public Device(AddDevice request, DeviceGroup deviceGroup) {
        this.serialNumber = request.getSerialNumber();
        this.deviceGroup = deviceGroup;
    }
}

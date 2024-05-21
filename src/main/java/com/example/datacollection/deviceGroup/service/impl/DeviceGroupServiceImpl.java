package com.example.datacollection.deviceGroup.service.impl;

import com.example.datacollection.deviceGroup.dto.request.AddDeviceGroup;
import com.example.datacollection.deviceGroup.entity.DeviceGroup;
import com.example.datacollection.deviceGroup.repository.DeviceGroupRepository;
import com.example.datacollection.deviceGroup.service.DeviceGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceGroupServiceImpl implements DeviceGroupService {
    private final DeviceGroupRepository deviceGroupRepository;

    @Override
    public DeviceGroup addDeviceGroup(AddDeviceGroup request) {

        boolean isExistsStationGroupSerial = deviceGroupRepository.existsByStationGroupSerial(request.getStationGroupSerial());

        if (isExistsStationGroupSerial) {
            throw new IllegalArgumentException("이미 존재하는 디바이스 그룹입니다.");
        }

        DeviceGroup deviceGroup = new DeviceGroup(request);

        return deviceGroupRepository.save(deviceGroup);
    }

    @Override
    public DeviceGroup getDeviceGroup(Long id) {
        return deviceGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 디바이스 그룹입니다."));
    }

    @Override
    public DeviceGroup getDeviceGroupByStationGroupSerial(String stationGroupSerial) {
        return deviceGroupRepository.findByStationGroupSerial(stationGroupSerial)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 디바이스 그룹입니다."));
    }
}

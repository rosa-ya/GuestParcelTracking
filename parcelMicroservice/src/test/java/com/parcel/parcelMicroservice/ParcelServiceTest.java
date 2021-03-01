package com.parcel.parcelMicroservice;

import com.parcel.parcelMicroservice.model.dto.ParcelDto;
import com.parcel.parcelMicroservice.model.entity.ParcelEntity;
import com.parcel.parcelMicroservice.model.mapper.ParcelMapper;
import com.parcel.parcelMicroservice.repository.ParcelRepository;
import com.parcel.parcelMicroservice.service.ParcelService;
import com.parcel.parcelMicroservice.service.impl.ParcelServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

/**
 * @author Rose
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class ParcelServiceTest {

    @Mock
    private ParcelMapper parcelMapper;

    @Mock
    private ParcelRepository parcelRepository;

    @InjectMocks
    private ParcelService parcelService = new ParcelServiceImpl(parcelRepository, parcelMapper);

    @Test
    public void addParcelTest() {

        ParcelEntity parcelEntity = ParcelEntity.builder().id(0).guestId(2).parcelCode("test").build();
        ParcelDto parcelDto = new ParcelDto();
        parcelDto.setParcelCode("test");
        parcelDto.setGuestId(2);

        when(parcelRepository.save(any(ParcelEntity.class))).thenReturn(parcelEntity);
        when(parcelMapper.mapDtoToEntity(any(ParcelDto.class))).thenReturn(parcelEntity);
        when(parcelMapper.mapEntityToDto(any(ParcelEntity.class))).thenReturn(parcelDto);
        ParcelDto parcel = parcelService.addParcel(parcelDto);


        assertThat(parcel.getParcelCode()).isSameAs(parcelEntity.getParcelCode());
    }

    @Test
    public void findParcelsByGuestIdTest() {

        ParcelEntity parcelEntity = ParcelEntity.builder().parcelCode("parcel1").id(1).guestId(2).build();
        ParcelEntity parcelEntity2 = ParcelEntity.builder().parcelCode("parcel2").id(2).guestId(2).build();
        ParcelDto parcelDto = new ParcelDto();
        parcelDto.setParcelCode("parcel1");
        parcelDto.setGuestId(2);
        ParcelDto parcelDto2 = new ParcelDto();
        parcelDto.setParcelCode("parcel2");
        parcelDto.setGuestId(2);


        when(parcelService.addParcel(any(ParcelDto.class))).thenReturn(parcelDto);
        when(parcelMapper.mapDtoToEntity(any(ParcelDto.class))).thenReturn(parcelEntity);
        when(parcelMapper.mapEntityToDto(any(ParcelEntity.class))).thenReturn(parcelDto);


        when(parcelService.addParcel(any(ParcelDto.class))).thenReturn(parcelDto2);
        when(parcelMapper.mapDtoToEntity(any(ParcelDto.class))).thenReturn(parcelEntity2);
        when(parcelMapper.mapEntityToDto(any(ParcelEntity.class))).thenReturn(parcelDto2);


        when(parcelRepository.findByGuestId(2)).thenReturn(Arrays.asList(parcelEntity, parcelEntity2));
        when(parcelMapper.mapEntityToDtoList(anyList())).thenReturn(Arrays.asList(parcelDto, parcelDto2));
        List<ParcelDto> parcelDtos = parcelService.findParcelsByGuestId(2);

        assertThat(parcelDtos.get(0).getParcelCode()).isSameAs(parcelDto.getParcelCode());
    }


    @Test
    public void findAndUpdateParcelsTest() {

        ParcelEntity parcelEntity = ParcelEntity.builder().parcelCode("parcel1").id(1).guestId(2).build();
        ParcelEntity parcelEntity2 = ParcelEntity.builder().parcelCode("parcel2").id(2).guestId(2).build();
        ParcelDto parcelDto = new ParcelDto();
        parcelDto.setParcelCode("parcel1");
        parcelDto.setGuestId(2);
        ParcelDto parcelDto2 = new ParcelDto();
        parcelDto2.setParcelCode("parcel2");
        parcelDto2.setGuestId(2);


        when(parcelService.addParcel(any(ParcelDto.class))).thenReturn(parcelDto);
        when(parcelMapper.mapDtoToEntity(any(ParcelDto.class))).thenReturn(parcelEntity);
        when(parcelMapper.mapEntityToDto(any(ParcelEntity.class))).thenReturn(parcelDto);


        when(parcelService.addParcel(any(ParcelDto.class))).thenReturn(parcelDto2);
        when(parcelMapper.mapDtoToEntity(any(ParcelDto.class))).thenReturn(parcelEntity2);
        when(parcelMapper.mapEntityToDto(any(ParcelEntity.class))).thenReturn(parcelDto2);


        when(parcelService.findParcelsByGuestId(2)).thenReturn(Arrays.asList(parcelDto, parcelDto2));
        when(parcelMapper.mapEntityToDtoList(anyList())).thenReturn(Arrays.asList(parcelDto, parcelDto2));
        parcelDto.setDelivered(true);
        parcelDto2.setDelivered(true);
        when(parcelRepository.saveAll(anyList())).thenReturn(Arrays.asList(parcelEntity, parcelEntity2));
        when(parcelMapper.mapDtoToEntityList(anyList())).thenReturn(Arrays.asList(parcelEntity, parcelEntity2));
        when(parcelMapper.mapEntityToDtoList(anyList())).thenReturn(Arrays.asList(parcelDto, parcelDto2));


        List<ParcelDto> parcelDtos = parcelService.findAndUpdateParcels(2);

        assertThat(parcelDtos.get(0).getParcelCode()).isSameAs(parcelDto.getParcelCode());
    }

}

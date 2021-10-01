package com.nibblebytes.postgresql.service.impl;

import com.nibblebytes.postgresql.dto.UserDto;
import com.nibblebytes.postgresql.entity.Address;
import com.nibblebytes.postgresql.entity.User;
import com.nibblebytes.postgresql.repository.AddressRepository;
import com.nibblebytes.postgresql.repository.UserRepository;
import com.nibblebytes.postgresql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Transactional
    @Override
    public UserDto save(UserDto userDto) {
        User kisi = new User();
        kisi.setName(userDto.getName());
        kisi.setSurname(userDto.getSurname());
        final User kisiDb = userRepository.save(kisi);

        List<Address> liste = new ArrayList<>();
        userDto.getAddresses().forEach(item -> {
            Address adres = new Address();
            adres.setAddress(item);
            adres.setAddressType(Address.AddressType.OTHER_ADRESS);
            adres.setActive(true);
            adres.setUser(kisiDb);
            liste.add(adres);
        });
        addressRepository.saveAll(liste);
        userDto.setId(kisiDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        users.forEach(it -> {
            UserDto kisiDto = new UserDto();
            kisiDto.setId(it.getId());
            kisiDto.setName(it.getName());
            kisiDto.setSurname(it.getSurname());
            kisiDto.setAddresses(
                    it.getAddresses() != null ?
                            it.getAddresses().stream().map(Address::getAddress).collect(Collectors.toList())
                            : null);
            userDtoList.add(kisiDto);
        });
        return userDtoList;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}

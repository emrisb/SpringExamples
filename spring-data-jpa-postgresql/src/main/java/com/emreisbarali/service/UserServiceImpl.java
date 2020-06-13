package com.emreisbarali.service;

import com.emreisbarali.dto.UserDto;
import com.emreisbarali.entity.Address;
import com.emreisbarali.entity.User;
import com.emreisbarali.repository.AddressRepository;
import com.emreisbarali.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        Assert.notNull(userDto.getName(), "Name must be filled");
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        final User userDb = userRepository.save(user);

        List<Address> addressList = new ArrayList<>();
        userDto.getAddressList().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(Boolean.TRUE);
            address.setUser(userDb);
            addressList.add(address);

        });
        addressRepository.saveAll(addressList);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        userList.forEach(item -> {
            UserDto userDto = new UserDto();
            userDto.setId(item.getId());
            userDto.setName(item.getName());
            userDto.setSurname(item.getSurname());
            userDto.setAddressList(
                    item.getAddressList()!=null ?
                    item.getAddressList().stream().map(Address::getAddress).collect(Collectors.toList())
                    : null);

            userDtoList.add(userDto);
        });

        return userDtoList;
    }


    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}

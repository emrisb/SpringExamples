package com.emreisbarali.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class UserDto {

    private long id;

    private String name;

    private String surname;

    private List<String> addressList;
}

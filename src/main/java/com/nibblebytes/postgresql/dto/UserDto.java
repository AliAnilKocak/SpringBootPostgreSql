package com.nibblebytes.postgresql.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {//entityleri direkt dış dünyaya açılmaz. entitydeki bir alan değşirse eklenirse vs burayı kullanan clientların sağlığı açısında dto üzerinden işlem yapılır

    private Long id;
    private String name;
    private String surname;
    private List<String> addresses;

}

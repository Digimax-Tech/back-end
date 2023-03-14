package com.sipress.apiRest.message;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String url;
    private String type;
    private long size;



}

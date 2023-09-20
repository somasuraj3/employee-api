package com.cybage.myjavaapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GroupResponse {
    List<Employee> employees;
    InfraDetails infraDetails;
}

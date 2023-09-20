package com.cybage.myjavaapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InfraDetails {
    private String podIp;
    private String podNodeIp;
    private String dateTime; 
    private String clusterName;
    private String nodeName;
}
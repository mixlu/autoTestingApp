package com.example.qinlu.autotesting.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by qinlu on 9/6/2016.
 */

// TODO: Add detail VehicleModel info
@NoArgsConstructor
public class VehicleModel {
    @Getter
    @Setter
    private int plateNumber;

    @Getter
    @Setter
    private String platePrefix;

    @Getter
    @Setter
    private String engineNumber;

    @Getter
    @Setter
    private String makeModel;

    @Getter
    @Setter
    private String vinNumber;

    @Getter
    @Setter
    private String owner;

    @Getter
    @Setter
    private String vehType;

    //TODO: Might need consider to update to date type
    @Getter
    @Setter
    private String registerDate;

    @Getter
    @Setter
    private String fuleType;

    @Getter
    @Setter
    private int seatNumber;

    @Getter
    @Setter
    private int baseWeight;

    @Getter
    @Setter
    private int wholeWeight;

    @Getter
    @Setter
    private String conditionLevel;

    @Getter
    @Setter
    private String lightType;

    @Getter
    @Setter
    private String plateType;

    @Getter
    @Setter
    private String licenseNumber;

    @Getter
    @Setter
    private String brakeType;
}

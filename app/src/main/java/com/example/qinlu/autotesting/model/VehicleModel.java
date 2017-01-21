package com.example.qinlu.autotesting.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * Created by qinlu on 9/6/2016.
 */

// TODO: Add detail VehicleModel info
@NoArgsConstructor
public class VehicleModel {
    @Getter
    @Setter
    @NonNull
    private String plateNumber;

    @Getter
    @Setter
    @NonNull
    private String platePrefix;

    @Getter
    @Setter
    @NonNull
    private String vehType;

    @Getter
    @Setter
    @NonNull
    private String engineNumber;

    @Getter
    @Setter
    @NonNull
    private String makeModel;

    @Getter
    @Setter
    @NonNull
    private String vinNumber;

    @Getter
    @Setter
    @NonNull
    private String owner;

    //TODO: Might need consider to update to date type
    @Getter
    @Setter
    @NonNull
    private String registerDate;

    @Getter
    @Setter
    @NonNull
    private String fuelType;

    @Getter
    @Setter
    @NonNull
    private int seatNumber;

    @Getter
    @Setter
    @NonNull
    private int baseWeight;

    @Getter
    @Setter
    @NonNull
    private int wholeWeight;

    @Getter
    @Setter
    @NonNull
    private String conditionLevel;

    @Getter
    @Setter
    @NonNull
    private String lightType;

    @Getter
    @Setter
    @NonNull
    private String plateType;

    @Getter
    @Setter
    @NonNull
    private String licenseNumber;

    @Getter
    @Setter
    @NonNull
    private String brakeType;
}

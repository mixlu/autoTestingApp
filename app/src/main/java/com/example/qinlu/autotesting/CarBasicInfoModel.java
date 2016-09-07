package com.example.qinlu.autotesting;

/**
 * Created by qinlu on 8/14/16.
 * This class contains basic car info:
 * 车牌号码前缀
 * 车牌号码
 * 号牌种类
 */
public class CarBasicInfoModel {
    String platePrefix;
    String plateNumber;
    String plateType;
    private InspectionDataBaseAdapter dbManager;

    public CarBasicInfoModel(String prefix, String num, String type) {
        this.platePrefix = prefix;
        this.plateNumber = num;
        this.plateType = type;
    }
    public String getPrefix(){
        return this.platePrefix;
    }
    public String getNumber(){
        return this.plateNumber;
    }
    public String getType(){
        return this.plateType;
    }
}
package com.example.nikunjramani.automaticirrigationandcropminitoringsystem;

public class url_list {
    static String domain="192.168.43.97";
    static String login_url=domain+"/aicms/login.php";
    public static String mqtt_url="tcp://soldier.cloudmqtt.com:15651";
    public  static String mqtt_username="vtxapwpp";
    public static String mqtt_password="8-TU2fl-dTUr";
    static String fcm_register_device=domain+"/aicms/FcmExample/RegisterDevice.php";
    public static String get_notification=domain+"/aicms/index.php";
    public static String crop_suggestion=domain+"/aicms/suggestion.php?cid=1";
    public static String get_crop_prize=domain+"/aicms/show_crop_prize.php";
}

package utils;

import org.openqa.selenium.WebDriver;

public class AddressDataHelper {

        private String country;
        private String fullName;
        private String phoneNumber;
        private String streetName;
        private String buildingNameOrNumber;
        private String city;
        private String area;

        public AddressDataHelper() {

        }


        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }
        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }
        public String getPhoneNumber() { return phoneNumber; }
        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
        public String getStreetName() { return streetName; }
        public void setStreetName(String streetName) { this.streetName = streetName; }
        public String getBuildingNameOrNumber() { return buildingNameOrNumber; }
        public void setBuildingNameOrNumber(String buildingNameOrNumber) { this.buildingNameOrNumber = buildingNameOrNumber; }
        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }
        public String getArea() { return area; }
        public void setArea(String area) { this.area = area; }
    }



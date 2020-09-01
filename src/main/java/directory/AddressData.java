package directory;

/*
 *  created by Yuliya Posiseeva 20.08.2020
 */


// Класс для хранения данных считанных с address.xml
public class AddressData {
    private String city;
    private String street;
    private String house;
    private int floor;

    public AddressData() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String toString() {
        return "Адрес|" +
                "Город='" + city + '\'' +
                ", Улица='" + street + '\'' +
                ", Дом=" + house +
                ", Этаж=" + floor +
                '|';
    }
}



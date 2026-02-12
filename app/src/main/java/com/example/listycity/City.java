package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructor for City
     * @param city The name of the city
     * @param province The province the city belongs to
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name
     * @return The name of the city
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Gets the province name
     * @return The name of the province
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this city to another city by name for sorting
     * @param o The object to compare to
     * @return negative if this comes first, positive if this comes after, 0 if equal
     */
    @Override
    public int compareTo(City o){
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Checks if this city is equal to another city
     * Two cities are equal if they have the same name and province
     * @param o The object to compare with
     * @return true if the cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City otherCity = (City) o;
        return Objects.equals(city, otherCity.city) &&
                Objects.equals(province, otherCity.province);
    }

    /**
     * Generates a hash code for this city
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}


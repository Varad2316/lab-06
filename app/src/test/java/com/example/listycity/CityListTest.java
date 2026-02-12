package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity(){
        return new City("Edmonton","City");
    }

    @Test
    void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));

    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();

        City edmontonCity = mockCity();
        assertTrue(cityList.hasCity(edmontonCity));

        City anotherEdmonton = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(anotherEdmonton));

        City calgaryCity = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(calgaryCity));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City edmontonCity = new City("Edmonton", "Alberta");
        assertEquals(1, cityList.getCities().size());
        assertTrue(cityList.hasCity(edmontonCity));

        cityList.delete(edmontonCity);
        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.hasCity(edmontonCity));
    }
    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City calgaryCity = new City("Calgary", "Alberta");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(calgaryCity);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();

        assertEquals(0, cityList.countCities());
        cityList.add(new City("Edmonton", "Alberta"));
        assertEquals(1, cityList.countCities());

        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countCities());

        cityList.add(new City("Vancouver", "British Columbia"));
        assertEquals(3, cityList.countCities());

        cityList.delete(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countCities());
    }


}
package demoqa.utils;

import com.github.javafaker.Faker;


public class TestsRandomData {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            currentAddress = faker.address().fullAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            birthdayDay = String.format("%02d", faker.number().numberBetween(1, 28)),
            birthdayMonth = faker.options().option("May", "February", "December", "June", "July"),
            birthdayYear = String.valueOf(faker.number().numberBetween(1900, 2100)),
            subject = faker.options().option("Math", "Chemistry", "Arts", "History", "English"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getRandomCity(state);

    private String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
            default:
                city = "";
        }
        return city;
    }
}

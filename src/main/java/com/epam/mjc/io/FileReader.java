package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = fileContent.toString();
        String[] lines = content.split("\n");

        String name = null;
        Integer age = null;
        String email = null;
        Long phone = null;

        for (String line : lines) {
            String[] keyValue = line.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                switch (key) {
                    case "Name":
                        name = value;
                        break;
                    case "Age":
                        age = Integer.parseInt(value);
                        break;
                    case "Email":
                        email = value;
                        break;
                    case "Phone":
                        phone = Long.parseLong(value);
                        break;
                    default:
                        break;
                }
            }
        }

        return new Profile(name, age, email, phone);
    }
}

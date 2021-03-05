package com.company;

public class Validators {


        // will check if the id is between 1 to 100
        public static Boolean isValidateID (int id){
            boolean result = false;
            if (id >= 1 && id <= 100) {
                result = true;
            }
            return result;
        }

        // will check for a valid name using regular expression
        public static Boolean isValidateName (String name){
            return name.matches("[A-Z][a-z]*");
        }
    }


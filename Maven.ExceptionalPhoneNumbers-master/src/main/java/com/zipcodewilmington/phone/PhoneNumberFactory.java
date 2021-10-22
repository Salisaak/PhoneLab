package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {

    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] phoArray = new PhoneNumber[phoneNumberCount];
        for (int i = 0; i < phoArray.length; i++){
            phoArray[i] = createRandomPhoneNumber();
        }
        return phoArray;

    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        int centralOfficeCode = RandomNumberFactory.createInteger(500,999);
        int phoneLineCode = RandomNumberFactory.createInteger(1000,9999);
        int areaCode = RandomNumberFactory.createInteger(100,999);

        PhoneNumber phonenumber = createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);;
        return phonenumber;
    }

    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String result = "(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode;
        PhoneNumber phoneNumber;
        try {
            phoneNumber = new PhoneNumber(result);
        } catch (InvalidPhoneNumberFormatException e){

            logger.info(result + "InvalidPhoneNumberFormatException");
            return null;
        }
        return phoneNumber;
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        return new PhoneNumber(phoneNumberString);
    }

    public static void main(String[] args) {

        //test array method
        PhoneNumber[] numbers = createRandomPhoneNumberArray(5);
        System.out.println(Arrays.toString(numbers));
    }
}

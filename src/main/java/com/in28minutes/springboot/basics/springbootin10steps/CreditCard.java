class CreditCard {
    public static String maskify(String creditCardNumber) {
        // Add code here
        StringBuilder maskedCreditCardNumber = new StringBuilder();
        if (creditCardNumber.length() < 6 || creditCardNumber.isEmpty()) { //Handle boundary conditions
            return creditCardNumber;
        } else {
            maskedCreditCardNumber.append(creditCardNumber.charAt(0)); // Adding first character without any change.
            for (int index = 1; index < creditCardNumber.length() - 4; index++) {
                if (creditCardNumber.charAt(index) >= 48 && creditCardNumber.charAt(index) <= 57) { // Checking if char is a digit
                    maskedCreditCardNumber.append("#");
                } else {
                    maskedCreditCardNumber.append(creditCardNumber.charAt(index));
                }
            }
            maskedCreditCardNumber.append(creditCardNumber.substring(creditCardNumber.length() - 4)); //Appending last 4 characters un-masked.
            return maskedCreditCardNumber.toString();
        }

    }

    public static void main(String[] args) {
        System.out.println(CreditCard.maskify("    "));
    }
}
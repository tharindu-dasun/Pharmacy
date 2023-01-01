package lk.ijse.pharmacy.util;

import java.util.regex.Pattern;

public class RegExPatterns {

        private static Pattern namePattern = Pattern.compile("^[a-zA-Z '.-]{4,}$");
        private static Pattern sponsorPattern = Pattern.compile("[SP]+[0-9]{1,}");

        public static void setItemPattern(Pattern itemPattern) {
                RegExPatterns.itemPattern = itemPattern;
        }

        private static Pattern itemPattern = Pattern.compile("[I]+[0-9]{1,}");

        public static void setMedicinePattern(Pattern medicinePattern) {
                RegExPatterns.medicinePattern = medicinePattern;
        }

        private static Pattern medicinePattern = Pattern.compile("[M]+[0-9]{1,}");

        public static Pattern getSponsorPattern() {
                return sponsorPattern;
        }

        private static Pattern customerPattern = Pattern.compile("[C]+[0-9]{1,}");

        public static Pattern getCustomerPattern() {
                return customerPattern;
        }

        private static Pattern employeePattern = Pattern.compile("[E]+[0-9]{1,}");

        public static Pattern getEmployeePattern() {
                return employeePattern;
        }

        private static Pattern supplierPattern = Pattern.compile("[S]+[0-9]{1,}");

        public static Pattern getSupplierPattern() {
                return supplierPattern;
        }

    //    private static Pattern medicinePattern = Pattern.compile("[M]+[0-9]{1,}");

        public static Pattern getMedicinePattern() {
                return medicinePattern;
        }

   //     private static Pattern itemPattern = Pattern.compile("[I]+[0-9]{1,}");

        public static Pattern getItemPattern() {
                return itemPattern;
        }

        private static Pattern idPattern = Pattern.compile("^([0-9]{9}[x|X|v|V]|[0-9]{12})$");
        private static Pattern emailPattern = Pattern.compile("(^[a-zA-Z0-9_.-]+)@([a-zA-Z]+)([\\.])([a-zA-Z]+)$");
        private static Pattern cityPattern = Pattern.compile("[a-zA-Z]{4,}$");
        private static Pattern mobilePattern = Pattern.compile("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$");
        private static Pattern addressPattern = Pattern.compile("^[A-Za-z0-9'\\/\\.\\,]{5,}$");

        private static final Pattern postalCodePattern = Pattern.compile("^\\d{5}$");
        private static Pattern oldIDPattern = Pattern.compile("^[0-9]{9}[vVxX]$");

        public static Pattern getOldIDPattern() {return oldIDPattern;}
        public static Pattern getPostalCodePattern() {return postalCodePattern;}
        public static Pattern getAddressPattern() {return addressPattern;}
        public static Pattern getMobilePattern() {return mobilePattern;
        }
        public static Pattern getCityPattern() {
            return cityPattern;
        }
        public static Pattern getEmailPattern() {
            return emailPattern;
        }
        public static Pattern getNamePattern() {
            return namePattern;
        }
        public static Pattern getIdPattern() {
            return idPattern;
    }
}

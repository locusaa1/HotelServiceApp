package hotelServiceApp.backEndCode;

public enum SupplySections {

    FOOD, SODA, DRINKS, EXTRASERVICES, SPECIALROOMS;

    /**
     * public static SupplySections convertString(String data)
     * This method returns a SupplySection type based on a String type.
     */
    public static SupplySections convertString(String data) {

        SupplySections section;
        if (data.equals(SPECIALROOMS)) {

            section = SPECIALROOMS;
        } else if (data.equals(EXTRASERVICES)) {

            section = EXTRASERVICES;
        } else if (data.equals(DRINKS)) {

            section = DRINKS;
        } else if (data.equals(SODA)) {

            section = SODA;
        } else {

            section = FOOD;
        }
        return section;
    }
}

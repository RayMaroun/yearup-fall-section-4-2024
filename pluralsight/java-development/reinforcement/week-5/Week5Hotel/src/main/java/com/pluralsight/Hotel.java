package com.pluralsight;

public class Hotel {
    private static int totalBookings = 0;

    public static int getTotalBookings() {
        return totalBookings;
    }

    public static void increaseTotalBookings() {
        totalBookings++;
    }

    public static void decreaseTotalBookings() {
        if (totalBookings > 0) {
            totalBookings--;
        }
    }
}

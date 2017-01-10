package com.another1dd.carhelper;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FirebaseHandler {
    private Context context;
    private DatabaseReference databaseReference;
    private static boolean isPersistenceEnabled = false;

    private static String homel = "Homel";
    private static String fillingStation = "FillingStations";
    private static String carWash = "CarWashes";
    private static String serviceStation = "ServiceStations";

    public FirebaseHandler(Context context)
    {
        this.context = context;
        if (!isPersistenceEnabled)
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            isPersistenceEnabled = true;
        }

        databaseReference = FirebaseDatabase.getInstance().getReference(homel);
    }

    public DatabaseReference getFillingStations()
    {
        return databaseReference.child(fillingStation);
    }

    public DatabaseReference getCarWashes()
    {
        return databaseReference.child(carWash);
    }

    public DatabaseReference getServiceStations()
    {
        return databaseReference.child(serviceStation);
    }

}

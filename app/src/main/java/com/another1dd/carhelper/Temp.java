package com.another1dd.carhelper;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.google.android.gms.internal.zzs.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class Temp extends Fragment {


    public Temp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temp, null);
        final TextView textView = (TextView) view.findViewById(R.id.temp_text);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        TempClass tempClass = new TempClass("AZS","Opisalovo",5);
        final String tempClassId = "1";
        myRef.child("tempClasses").child(tempClassId).setValue(tempClass);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TempClass tempClass1 = dataSnapshot.child("tempClasses").child(tempClassId).getValue(TempClass.class);
                String text = tempClass1.getText() + " " + tempClass1.getTitle();
                int rating = tempClass1.getRating();
                textView.append(text);
                textView.append(String.valueOf(rating));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.");
            }
        });




        return view;
    }

}

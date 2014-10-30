package com.example.friendcircle.location;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class TurnOnGPS extends Activity {

	public TurnOnGPS() {
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TurnOnGPS.this);

        alertDialogBuilder.setTitle("The GPS is off!");

        alertDialogBuilder
                .setMessage("Turn on the GPS?")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent1 = new Intent();
                                intent1.setClassName(
                                        "com.android.settings",
                                        "com.android.settings.SecuritySettings");
                                startActivity(intent1);
                                dialog.cancel();
                            }
                        })
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
        
		

	}
}

package com.example.friendcircle.form;

import com.example.friendcircle.R;
import com.example.friendcircle.page.TimeLine;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;

public class SignUp extends Activity {

	int flag_gender = 0; // **m=1, f=2
	int date, month, year;
	String firstNameStr, lastNameStr, emailStr, passwordStr;
	String [] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	
	Button birthdayButton, createAccountButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);
		setTitle(R.string.signUpForFriendCircle);

		addListenerOnButton();
	}

	public void addListenerOnButton() {

		firstNameStr = (String) findViewById(R.id.firstNameEditText).toString();
		lastNameStr = (String) findViewById(R.id.lastNameEditText).toString();
		emailStr = (String) findViewById(R.id.emailEditText).toString();
		passwordStr = (String) findViewById(R.id.passwordEditText).toString();

		createAccountButton = (Button) findViewById(R.id.createAccountButton1);

		
		createAccountButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View V) {

				functionCreateAccount();
			}
		});
	}

	public void onRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();

		switch (view.getId()) {
		case R.id.maleRadioButton:
			if (checked) {
				flag_gender = 1;
				break;
			}
		case R.id.femaleRadioButton:
			if (checked) {
				flag_gender = 2;
				break;
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void setDate(View V) {
		showDialog(888);
		//Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		if (id == 888) {
			return new DatePickerDialog(this, myDateListener, year, month, date);
		} 
		return null;
	}

	private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
			showDate(arg1, arg2, arg3);
		}
	};

	private void showDate(int year, int month, int day) {
		
		String str = day + " " + monthNames[month] + ", " + year;
		
		Button button1 = (Button) findViewById(R.id.birthdayButton);
		button1.setText(str);
	}
	
	private void functionCreateAccount() {
		 AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SignUp.this);
	     
		 alertDialogBuilder.setTitle("Successful registration!!!");
		 alertDialogBuilder.setMessage("Have a tour in Friend Circle");
		 
		 // set positive button: Yes message
		 alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {

					Intent positveActivity = new Intent(getApplicationContext(), TimeLine.class);
		            startActivity(positveActivity);	
				}
			  });
		 
		 AlertDialog alertDialog = alertDialogBuilder.create();
		 // show alert
		 alertDialog.show();
	}
}

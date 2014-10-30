package com.example.friendcircle.fragment;

import java.util.Calendar;

import android.R;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

/*public class DiaFragment extends DialogFragment implements
 TimePickerDialog.OnTimeSetListener {

 @Override
 public Dialog onCreateDialog(Bundle savedInstanceState) {
 // Use the current time as the default values for the picker
 final Calendar c = Calendar.getInstance();
 int hour = c.get(Calendar.HOUR_OF_DAY);
 int minute = c.get(Calendar.MINUTE);

 // Create a new instance of TimePickerDialog and return it
 return new TimePickerDialog(getActivity(), this, hour, minute,
 DateFormat.is24HourFormat(getActivity()));
 }

 public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
 // Do something with the time chosen by the user
 }
 }*/

/*public class DiaFragment extends DialogFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,	Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.dialog_fragment, container, false);
		getDialog().setTitle("Successful Registration!!!"); // Do something else
		return rootView;
	}
}*/


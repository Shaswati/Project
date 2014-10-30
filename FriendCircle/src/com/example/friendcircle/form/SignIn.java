package com.example.friendcircle.form;

import com.example.friendcircle.R;

import android.app.Activity;
import android.os.Bundle;

public class SignIn extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        setTitle(R.string.signIn);
        
        addListenerOnButton();
    }
	
	public void addListenerOnButton() {
		
	}
	
	
	/*public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radio_pirates:
	            if (checked)
	            	break;
	        case R.id.radio_ninjas:
	            if (checked)
	            	break;
	    }
	}*/
}

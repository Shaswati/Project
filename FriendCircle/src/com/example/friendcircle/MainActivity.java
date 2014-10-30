package com.example.friendcircle;

import com.example.friendcircle.form.SignIn;
import com.example.friendcircle.form.SignUp;
import com.example.friendcircle.map.TestMap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button signUpButton, signInButton, testButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addListenerOnButton();
	}
	
	public void addListenerOnButton() {
   	 
		final Context context = this;
 
		signUpButton = (Button) findViewById(R.id.signUpButton);
		signInButton = (Button) findViewById(R.id.signInButton);
		testButton = (Button) findViewById(R.id.testButton);
 
		signUpButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View V) {
 
			    Intent intent = new Intent(context, SignUp.class);
                startActivity(intent);
			}
		});
		
		signInButton.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View V) {
 
			    Intent intent = new Intent(context, SignIn.class);
                startActivity(intent);
			}
		});
		
		testButton.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View V) {
 
			    Intent intent = new Intent(context, TestMap.class);
                startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

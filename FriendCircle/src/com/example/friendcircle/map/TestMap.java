package com.example.friendcircle.map;

import com.example.friendcircle.R;
import com.example.friendcircle.location.TurnOnGPS;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.MapFragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class TestMap extends Activity {

	// Google Map
	private GoogleMap googleMap;
	
	// Location Manager
	LocationManager locationManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_map);

		Context context=this;
		
		try {
			// Loading map
			initilizeMap();

			//locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		    //boolean gpsStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

			@SuppressWarnings("deprecation")
			String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

			Toast.makeText(context, "gpsStatus="+provider.contains("gps"), Toast.LENGTH_SHORT).show();
		    if (!provider.contains("gps")) {
		    	//TurnOnGPS turnOnGPS = new TurnOnGPS();
		    	
		    	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestMap.this);

		        alertDialogBuilder.setTitle("The GPS is off!");

		        alertDialogBuilder
		                .setMessage("Turn on the GPS?")
		                .setCancelable(false)
		                .setPositiveButton("Yes",
		                        new DialogInterface.OnClickListener() {
		                            public void onClick(DialogInterface dialog, int id) {
		                                Intent intent1 = new Intent();
		                                intent1.setClassName(
		                                        //"com.android.settings.Location services",
		                                		//"com.android.settings.SecuritySettings");
		                                		"com.android.settings",
		                                		"com.android.settings.widget.SettingsAppWidgetProvider");
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
		    //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 500.0f, locationListener);
			
			
			// Changing map type
			//googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			// googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			 googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			// googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
			// googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);

			// Showing / hiding your current location
			googleMap.setMyLocationEnabled(true);

			// Enable / Disable zooming controls
			googleMap.getUiSettings().setZoomControlsEnabled(false);

			// Enable / Disable my location button
			googleMap.getUiSettings().setMyLocationButtonEnabled(true);

			// Enable / Disable Compass icon
			googleMap.getUiSettings().setCompassEnabled(true);

			// Enable / Disable Rotate gesture
			googleMap.getUiSettings().setRotateGesturesEnabled(true);

			// Enable / Disable zooming functionality
			googleMap.getUiSettings().setZoomGesturesEnabled(true);

			double latitude = 17.385044;
			double longitude = 78.486671;

			// lets place some 10 random markers
			for (int i = 0; i < 10; i++) {
				// random latitude and logitude
				double[] randomLocation = createRandLocation(latitude, longitude);

				// Adding a marker
				MarkerOptions marker = new MarkerOptions().position(new LatLng(randomLocation[0], randomLocation[1]))
						.title("Hello Maps " + i);

				Log.e("Random", "> " + randomLocation[0] + ", "
						+ randomLocation[1]);

				// changing marker color
				if (i == 0)
					marker.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
				if (i == 1)
					marker.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
				if (i == 2)
					marker.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
				if (i == 3)
					marker.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
				if (i == 4)
					marker.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
				if (i == 5)
					marker.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
				if (i == 6)
					marker.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_RED));
				if (i == 7)
					marker.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
				if (i == 8)
					marker.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
				if (i == 9)
					marker.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

				googleMap.addMarker(marker);

				// Move the camera to last position with a zoom level
				if (i == 9) {
					CameraPosition cameraPosition = new CameraPosition.Builder()
							.target(new LatLng(randomLocation[0],
									randomLocation[1])).zoom(15).build();

					googleMap.animateCamera(CameraUpdateFactory
							.newCameraPosition(cameraPosition));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	LocationListener locationListener = new LocationListener() {

	    @Override
	    public void onLocationChanged(Location location) { // update
	        if (location != null) {

	            //msg_r.setLatitude(location.getLatitude());
	            //msg_r.setLongitude(location.getLongitude());
	        }
	    }

	    @Override
	    public void onProviderDisabled(String provider) {
	    }

	    @Override
	    public void onProviderEnabled(String provider) {
	    }

	    @Override
	    public void onStatusChanged(String provider, int status, Bundle extras) {
	    }
	};
	
	@Override
	protected void onResume() {
		super.onResume();
		initilizeMap();
	}

	/**
	 * function to load map If map is not created it will create it for you
	 * */
	private void initilizeMap() {
		if (googleMap == null) {
			googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

			// check if map is created successfully or not
			if (googleMap == null) {
				Toast.makeText(getApplicationContext(),	"Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
			}
		}
	}

	/*
	 * creating random postion around a location for testing purpose only
	 */
	private double[] createRandLocation(double latitude, double longitude) {

		return new double[] { latitude + ((Math.random() - 0.5) / 500),
				longitude + ((Math.random() - 0.5) / 500),
				150 + ((Math.random() - 0.5) * 10) };
	}
}

package com.example.android_u2_tema2_miconductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity  extends AppCompatActivity implements OnMapReadyCallback {
  LatLng pos;
  GoogleMap mapa;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    SupportMapFragment mapFragment = (SupportMapFragment)
        getSupportFragmentManager().findFragmentById(R.id.mapa);
    mapFragment.getMapAsync(this);
  }
  @Override
  public void onMapReady(GoogleMap googleMap) {
    mapa = googleMap;
    pos = new LatLng(-18.011737, -70.253529);
    mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,17));
    if (ContextCompat.checkSelfPermission(this,
        android.Manifest.permission.ACCESS_FINE_LOCATION) ==
        PackageManager.PERMISSION_GRANTED) {
      mapa.setMyLocationEnabled(true);
      mapa.getUiSettings().setZoomControlsEnabled(false);
      mapa.getUiSettings().setCompassEnabled(true);
    }
  }
  public void pedir(View view) {
  }
}

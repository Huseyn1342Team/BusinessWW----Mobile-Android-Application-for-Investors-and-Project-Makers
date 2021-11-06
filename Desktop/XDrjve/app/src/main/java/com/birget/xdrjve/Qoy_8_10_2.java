package com.birget.xdrjve;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.birget.xdrjve.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Qoy_8_10_2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner Gender;
    private Button Submit;
    private String PredictTime,Cigar, CarYear, Price, FromPlace, ToPlace, Time, Month, Day, Year, MaxYer, CarNumber, CarBrand, Talk, Number,Music,Pet;
    private AdView mAdView;
    private AdView mAdView2;
    private AdView mAdView3,mAdView4,mAdView5,mAdView6,mAdView7,mAdView8,mAdView9,mAdView10,mAdView11,mAdView12,mAdView13;
    private InterstitialAd interstitial;
    private String time,day,month,fromplace,toplace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qoy_8_10_2);
        final BottomNavigationView nav1 = (BottomNavigationView)findViewById(R.id.navigation);
        nav1.getMenu().getItem(2).setChecked(true);
        nav1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        Intent i =new Intent(Qoy_8_10_2.this,Activity_3.class);
                        startActivity(i);
                        break;
                    case R.id.contact:
                        Intent b = new Intent(Qoy_8_10_2.this,Search_2.class);
                        startActivity(b);
                        break;
                    case R.id.info:
                        Intent c = new Intent(Qoy_8_10_2.this,Qoy_1.class);
                        startActivity(c);
                        break;
                    case R.id.message:
                        Intent d = new Intent(Qoy_8_10_2.this,Message_1.class);
                        startActivity(d);
                        break;
                    case R.id.profilim:
                        Intent e = new Intent(Qoy_8_10_2.this,Info.class);
                        startActivity(e);
                        break;
                }
                return true;
            }
        });
        Submit = (Button) findViewById(R.id.submit);
        ArrayList<String> cigarOptions = new ArrayList<String>();
        cigarOptions.add("Sərnişinlərə cinsiyyət tələbiniz");
        cigarOptions.add("Yalnız qadın");
        cigarOptions.add("Yalnız kişi");
        cigarOptions.add("Fərqi yoxdur");
        ArrayAdapter<String> cigarAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cigarOptions);
        cigarAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Gender= (Spinner) findViewById(R.id.cigar);
        Gender.setOnItemSelectedListener(this);
        Gender.setAdapter(cigarAdapter);
        Music = getIntent().getStringExtra("Music");
        PredictTime = getIntent().getStringExtra("PredictTime");
        Pet = getIntent().getStringExtra("Pet");
        Cigar = getIntent().getStringExtra("Cigar");
        CarYear = getIntent().getStringExtra("CarYear");
        Price = getIntent().getStringExtra("Price");
        Talk = getIntent().getStringExtra("Talk");
        FromPlace = getIntent().getStringExtra("FromPlace");
        ToPlace = getIntent().getStringExtra("ToPlace");
        Time = getIntent().getStringExtra("Time");
        Month = getIntent().getStringExtra("Month");
        Day = getIntent().getStringExtra("Day");
        Year = getIntent().getStringExtra("Year");
        MaxYer = getIntent().getStringExtra("MaxYer");
        CarNumber = getIntent().getStringExtra("CarNumber");
        CarBrand = getIntent().getStringExtra("CarBrand");
        Number = getIntent().getStringExtra("Number");
        MobileAds.initialize(this, "ca-app-pub-4810068176185955~8190980825");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-4810068176185955/4151663464");
        //
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //
        mAdView2 = findViewById(R.id.adView2);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest1);
        if (Number == null) {
            //Name,Surname,Date,From,To,Time,MaxYer,Gender,CarName,CarNumber,CarYear,Number
            Submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String MusicText = Gender.getSelectedItem().toString();
                    if (MusicText.matches("")) {
                        Toast.makeText(Qoy_8_10_2.this, "Zəhmət olmasa, seçimi qeyd edin!", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent i = new Intent(Qoy_8_10_2.this, Qoy_8_9_2.class);
                        i.putExtra("Cigar", Cigar);
                        i.putExtra("Gender",MusicText);
                        i.putExtra("Pet",Pet);
                        i.putExtra("PredictTime",PredictTime);
                        i.putExtra("Music",Music);
                        i.putExtra("Talk", Talk);
                        i.putExtra("CarYear", CarYear);
                        i.putExtra("Price", Price);
                        i.putExtra("FromPlace", FromPlace);
                        i.putExtra("ToPlace", ToPlace);
                        i.putExtra("Time", Time);
                        i.putExtra("Month", Month);
                        i.putExtra("Day", Day);
                        i.putExtra("Year", Year);
                        i.putExtra("MaxYer", MaxYer);
                        i.putExtra("CarNumber", CarNumber);
                        i.putExtra("CarBrand", CarBrand);
                        i.putExtra("Number", Number);
                        startActivity(i);
                    }
                }
            });
        } else {
            if (Number.matches("0")) {
                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String MusicText = Gender.getSelectedItem().toString();
                        if (MusicText.matches("")) {
                            Toast.makeText(Qoy_8_10_2.this, "Zəhmət olmasa, seçimi qeyd edin!", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent i = new Intent(Qoy_8_10_2.this, Qoy_8_9_2.class);
                            i.putExtra("Cigar", Cigar);
                            i.putExtra("Gender",MusicText);
                            i.putExtra("Pet",Pet);
                            i.putExtra("PredictTime",PredictTime);
                            i.putExtra("Music",Music);
                            i.putExtra("Talk", Talk);
                            i.putExtra("CarYear", CarYear);
                            i.putExtra("Price", Price);
                            i.putExtra("FromPlace", FromPlace);
                            i.putExtra("ToPlace", ToPlace);
                            i.putExtra("Time", Time);
                            i.putExtra("Month", Month);
                            i.putExtra("Day", Day);
                            i.putExtra("Year", Year);
                            i.putExtra("MaxYer", MaxYer);
                            i.putExtra("CarNumber", CarNumber);
                            i.putExtra("CarBrand", CarBrand);
                            i.putExtra("Number", Number);
                            startActivity(i);
                        }
                    }
                });
            }
            if (Number.matches("1")) {
                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String MusicText = Gender.getSelectedItem().toString();
                        if (MusicText.matches("")) {
                            Toast.makeText(Qoy_8_10_2.this, "Zəhmət olmasa, seçimi qeyd edin!", Toast.LENGTH_SHORT).show();
                        } else {
                            String Place1 = getIntent().getStringExtra("Place1");
                            Intent i = new Intent(Qoy_8_10_2.this, Qoy_8_9_2.class);
                            i.putExtra("Cigar", Cigar);
                            i.putExtra("Gender",MusicText);
                            i.putExtra("Pet",Pet);
                            i.putExtra("PredictTime",PredictTime);
                            i.putExtra("Talk", Talk);
                            i.putExtra("Music",Music);
                            i.putExtra("CarYear", CarYear);
                            i.putExtra("Price", Price);
                            i.putExtra("FromPlace", FromPlace);
                            i.putExtra("ToPlace", ToPlace);
                            i.putExtra("Time", Time);
                            i.putExtra("Month", Month);
                            i.putExtra("Day", Day);
                            i.putExtra("Year", Year);
                            i.putExtra("MaxYer", MaxYer);
                            i.putExtra("CarNumber", CarNumber);
                            i.putExtra("CarBrand", CarBrand);
                            i.putExtra("Number", Number);
                            i.putExtra("Place1", Place1);
                            startActivity(i);
                        }
                    }
                });
            }
            if (Number.matches("2")) {
                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String MusicText = Gender.getSelectedItem().toString();
                        if (MusicText.matches("")) {
                            Toast.makeText(Qoy_8_10_2.this, "Zəhmət olmasa, seçimi qeyd edin!", Toast.LENGTH_SHORT).show();
                        } else {
                            String Place2 = getIntent().getStringExtra("Place2");
                            String Place1 = getIntent().getStringExtra("Place1");
                            Intent i = new Intent(Qoy_8_10_2.this, Qoy_8_9_2.class);
                            i.putExtra("Cigar", Cigar);
                            i.putExtra("Gender",MusicText);
                            i.putExtra("Pet",Pet);
                            i.putExtra("PredictTime",PredictTime);
                            i.putExtra("Music",Music);
                            i.putExtra("Talk", Talk);
                            i.putExtra("CarYear", CarYear);
                            i.putExtra("Price", Price);
                            i.putExtra("FromPlace", FromPlace);
                            i.putExtra("ToPlace", ToPlace);
                            i.putExtra("Time", Time);
                            i.putExtra("Month", Month);
                            i.putExtra("Day", Day);
                            i.putExtra("Year", Year);
                            i.putExtra("MaxYer", MaxYer);
                            i.putExtra("CarNumber", CarNumber);
                            i.putExtra("CarBrand", CarBrand);
                            i.putExtra("Number", Number);
                            i.putExtra("Place1", Place1);
                            i.putExtra("Place2",Place2);
                            startActivity(i);
                        }
                    }
                });
            }
            if (Number.matches("3")) {
                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String MusicText = Gender.getSelectedItem().toString();
                        if (MusicText.matches("")) {
                            Toast.makeText(Qoy_8_10_2.this, "Zəhmət olmasa, seçimi qeyd edin!", Toast.LENGTH_SHORT).show();
                        } else {
                            String Place3 = getIntent().getStringExtra("Place3");
                            String Place2 = getIntent().getStringExtra("Place2");
                            String Place1 = getIntent().getStringExtra("Place1");
                            Intent i = new Intent(Qoy_8_10_2.this, Qoy_8_9_2.class);
                            i.putExtra("Cigar", Cigar);
                            i.putExtra("Gender",MusicText);
                            i.putExtra("Pet",Pet);
                            i.putExtra("PredictTime",PredictTime);
                            i.putExtra("Music",Music);
                            i.putExtra("Talk", Talk);
                            i.putExtra("CarYear", CarYear);
                            i.putExtra("Price", Price);
                            i.putExtra("FromPlace", FromPlace);
                            i.putExtra("ToPlace", ToPlace);
                            i.putExtra("Time", Time);
                            i.putExtra("Month", Month);
                            i.putExtra("Day", Day);
                            i.putExtra("Year", Year);
                            i.putExtra("MaxYer", MaxYer);
                            i.putExtra("CarNumber", CarNumber);
                            i.putExtra("CarBrand", CarBrand);
                            i.putExtra("Number", Number);
                            i.putExtra("Place1", Place1);
                            i.putExtra("Place2",Place2);
                            i.putExtra("Place3",Place3);
                            startActivity(i);
                        }
                    }
                });
            }
            if (Number.matches("4")) {
                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String MusicText = Gender.getSelectedItem().toString();
                        if (MusicText.matches("")) {
                            Toast.makeText(Qoy_8_10_2.this, "Zəhmət olmasa, seçimi qeyd edin!", Toast.LENGTH_SHORT).show();
                        } else {
                            String Place4 = getIntent().getStringExtra("Place4");
                            String Place3 = getIntent().getStringExtra("Place3");
                            String Place2 = getIntent().getStringExtra("Place2");
                            String Place1 = getIntent().getStringExtra("Place1");
                            Intent i = new Intent(Qoy_8_10_2.this, Qoy_8_9_2.class);
                            i.putExtra("Cigar", Cigar);
                            i.putExtra("Gender",MusicText);
                            i.putExtra("Pet",Pet);
                            i.putExtra("PredictTime",PredictTime);
                            i.putExtra("Talk", Talk);
                            i.putExtra("Music",Music);
                            i.putExtra("CarYear", CarYear);
                            i.putExtra("Price", Price);
                            i.putExtra("FromPlace", FromPlace);
                            i.putExtra("ToPlace", ToPlace);
                            i.putExtra("Time", Time);
                            i.putExtra("Month", Month);
                            i.putExtra("Day", Day);
                            i.putExtra("Year", Year);
                            i.putExtra("MaxYer", MaxYer);
                            i.putExtra("CarNumber", CarNumber);
                            i.putExtra("CarBrand", CarBrand);
                            i.putExtra("Number", Number);
                            i.putExtra("Place1", Place1);
                            i.putExtra("Place2",Place2);
                            i.putExtra("Place3",Place3);
                            i.putExtra("Place4",Place4);
                            startActivity(i);
                        }
                    }
                });
            }
            if (Number.matches("5")) {
                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String MusicText = Gender.getSelectedItem().toString();
                        if (MusicText.matches("")) {
                            Toast.makeText(Qoy_8_10_2.this, "Zəhmət olmasa, seçimi qeyd edin!", Toast.LENGTH_SHORT).show();
                        } else {
                            String Place5 = getIntent().getStringExtra("Place5");
                            String Place4 = getIntent().getStringExtra("Place4");
                            String Place3 = getIntent().getStringExtra("Place3");
                            String Place2 = getIntent().getStringExtra("Place2");
                            String Place1 = getIntent().getStringExtra("Place1");
                            Intent i = new Intent(Qoy_8_10_2.this, Qoy_8_9_2.class);
                            i.putExtra("Cigar", Cigar);
                            i.putExtra("Gender",MusicText);
                            i.putExtra("Pet",Pet);
                            i.putExtra("PredictTime",PredictTime);
                            i.putExtra("Talk", Talk);
                            i.putExtra("Music",Music);
                            i.putExtra("CarYear", CarYear);
                            i.putExtra("Price", Price);
                            i.putExtra("FromPlace", FromPlace);
                            i.putExtra("ToPlace", ToPlace);
                            i.putExtra("Time", Time);
                            i.putExtra("Month", Month);
                            i.putExtra("Day", Day);
                            i.putExtra("Year", Year);
                            i.putExtra("MaxYer", MaxYer);
                            i.putExtra("CarNumber", CarNumber);
                            i.putExtra("CarBrand", CarBrand);
                            i.putExtra("Number", Number);
                            i.putExtra("Place1", Place1);
                            i.putExtra("Place2",Place2);
                            i.putExtra("Place3",Place3);
                            i.putExtra("Place4",Place4);
                            i.putExtra("Place5",Place5);
                            startActivity(i);
                        }
                    }
                });
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void displayInterstitial()
    {
        // If Interstitial Ads are loaded then show else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}

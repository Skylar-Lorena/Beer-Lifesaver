package com.skylar.beer_lifesaver;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeerStyleDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private BeerStylePagerAdapter adapterViewPager;
    ArrayList<BeerStyle> mBeerStyles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_style_detail);
        ButterKnife.bind(this);

        mBeerStyles = Parcels.unwrap(getIntent().getParcelableExtra("beerStyles"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new BeerStylePagerAdapter(getSupportFragmentManager(), mBeerStyles);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
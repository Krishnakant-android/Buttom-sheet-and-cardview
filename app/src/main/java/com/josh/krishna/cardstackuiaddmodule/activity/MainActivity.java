package com.josh.krishna.cardstackuiaddmodule.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.josh.krishna.cardstackuiaddmodule.adapter.MyCardStackAdapter;
import com.josh.krishna.cardstackuiaddmodule.R;
import com.josh.krishna.cardstackuiaddmodule.utils.Logger;
import com.mutualmobile.cardstack.CardStackLayout;
import com.mutualmobile.cardstack.utils.Units;

public class MainActivity extends AppCompatActivity{

    private CardStackLayout mCardStackLayout;
    private Logger log = new Logger(MainActivity.class.getSimpleName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardStackLayout = (CardStackLayout) findViewById(R.id.cardStack);
        setupAdapter();
    }

    private void setupAdapter() {
        mCardStackLayout.setShowInitAnimation(true);
        mCardStackLayout.setParallaxEnabled(true);
        mCardStackLayout.setParallaxScale(-4);
        mCardStackLayout.setCardGap(Units.dpToPx(this, 50));
        mCardStackLayout.setCardGapBottom(Units.dpToPx(this, 5));
        mCardStackLayout.setSelected(true);
        mCardStackLayout.setAdapter(new MyCardStackAdapter(this));
    }

    @Override
    public void onBackPressed() {
        if (mCardStackLayout.isCardSelected()) {
            mCardStackLayout.restoreCards();
        } else {
            super.onBackPressed();
        }
    }


}

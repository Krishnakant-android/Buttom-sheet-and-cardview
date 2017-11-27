package com.josh.krishna.cardstackuiaddmodule.activity;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.josh.krishna.cardstackuiaddmodule.R;

public class Main2Activity extends AppCompatActivity {
    // BottomSheetBehavior variable
    private BottomSheetBehavior bottomSheetBehavior;
    LinearLayout ll_content;

    // TextView variable
    private TextView bottomSheetHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initViews();
    }

    private void initViews() {

         ll_content =(LinearLayout)findViewById(R.id.ll_content);

        Button btnView = (Button) findViewById(R.id.btnView);

        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheetLayout));
        bottomSheetHeading = (TextView) findViewById(R.id.bottomSheetHeading);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    //bottomSheetHeading.setText(getString(R.string.text_collapse_me));
                } else {
                   // bottomSheetHeading.setText(getString(R.string.text_expand_me));
                }

                // Check Logs to see how bottom sheets behaves
                switch (newState) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //Log.e("Bottom Sheet Behaviour", "STATE_COLLAPSED");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        //Log.e("Bottom Sheet Behaviour", "STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        //Log.e("Bottom Sheet Behaviour", "STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        //Log.e("Bottom Sheet Behaviour", "STATE_HIDDEN");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        //Log.e("Bottom Sheet Behaviour", "STATE_SETTLING");
                        break;
                }
            }



            @Override
            public void onSlide(View bottomSheet, float slideOffset) {

            }
        });


        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });

        boolean status = true;
        bottomSheetHeading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutTransition transition = new LayoutTransition();

                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    ll_content.setLayoutTransition(transition);
                }else {
                    ll_content.setLayoutTransition(transition);
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                }

            }
        });




    }




}

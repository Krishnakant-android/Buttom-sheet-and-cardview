package com.josh.krishna.cardstackuiaddmodule.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.josh.krishna.cardstackuiaddmodule.R;
import com.josh.krishna.cardstackuiaddmodule.activity.MainActivity;
import com.josh.krishna.cardstackuiaddmodule.utils.Logger;
import com.mutualmobile.cardstack.CardStackAdapter;

public class MyCardStackAdapter extends CardStackAdapter /*implements CompoundButton.OnCheckedChangeListener*/ {
    private static int[] bgColorIds;
    private final LayoutInflater mInflater;
    private final Context mContext;
    private Logger log = new Logger(MyCardStackAdapter.class.getSimpleName());
    //private OnRestartRequest mCallback;
    //private Runnable updateSettingsView;

    public MyCardStackAdapter(MainActivity activity) {
        super(activity);
        mContext = activity;
        mInflater = LayoutInflater.from(activity);
        // mCallback = activity;
        bgColorIds = new int[]{
                R.color.card1_bg,
                R.color.card2_bg,
                R.color.card3_bg,
                R.color.card4_bg,
                R.color.card5_bg,
        };
    }

    @Override
    public int getCount() {
        return bgColorIds.length;
    }


    @Override
    public View createView(int position, ViewGroup container) {

        CardView root = (CardView) mInflater.inflate(R.layout.card, container, false);
        root.setCardBackgroundColor(ContextCompat.getColor(mContext, bgColorIds[position]));
        TextView cardTitle = (TextView) root.findViewById(R.id.card_title);
        switch (position){
            case 0:
                cardTitle.setText("Setting");
                cardTitle.setBackgroundResource(bgColorIds[position]);
                break;
            case 1:
                cardTitle.setText("Card 1");
                cardTitle.setBackgroundResource(bgColorIds[position]);
                break;
            case 2:
                cardTitle.setText("Card 2");
                cardTitle.setBackgroundResource(bgColorIds[position]);
                break;
            case 3:
                cardTitle.setText("Card 3");
                cardTitle.setBackgroundResource(bgColorIds[position]);
                break;
            case 4:
                cardTitle.setText("Card 4");
                cardTitle.setBackgroundResource(bgColorIds[position]);
                break;

        }

        return root;
    }

    @Override
    protected Animator getAnimatorForView(View view, int currentCardPosition, int selectedCardPosition) {
           int offsetTop = getScrollOffset();
            //System.out.println("offsetTop =>>"+offsetTop +"currentCardPosition =>> "+currentCardPosition+"selectedCardPosition==  "+ selectedCardPosition);
            if (currentCardPosition > selectedCardPosition) {
                return ObjectAnimator.ofFloat(view, View.Y, view.getY(), offsetTop + getCardFinalY(currentCardPosition));
            } else {
                return ObjectAnimator.ofFloat(view, View.Y, view.getY(), offsetTop + getCardOriginalY(0) + (currentCardPosition * getCardGapBottom()));
            }
    }



}

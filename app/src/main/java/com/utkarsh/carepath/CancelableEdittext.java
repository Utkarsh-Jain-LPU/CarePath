package com.utkarsh.carepath;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;
import java.util.Objects;

public class CancelableEdittext extends AppCompatEditText {

    Drawable clearbutton,clearbutton1;

    public CancelableEdittext(Context context) {
        super(context);
        init();
    }

    public CancelableEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CancelableEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init() {

        clearbutton = ResourcesCompat.getDrawable(getResources(),R.drawable.black_close,null);
        clearbutton1 = ResourcesCompat.getDrawable(getResources(),R.drawable.white_close,null);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        setOnTouchListener(new OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility", "NewApi"})
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float clearbuttonstart;
                boolean isclicked = false;
                clearbuttonstart = getWidth()-getPaddingEnd()-clearbutton.getIntrinsicWidth();
                if (event.getX() > clearbuttonstart) {
                    isclicked = true;
                }
                if (isclicked) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            Objects.requireNonNull(getText()).clear();
                            break;
                        case MotionEvent.ACTION_UP:
                            hideButton();
                    }
                }
                return false;
            }
        });
    }

    @SuppressLint("NewApi")
    void showButton() {

        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,clearbutton,null);
    }

    @SuppressLint("NewApi")
    void hideButton() {

        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,clearbutton1,null);
    }
}

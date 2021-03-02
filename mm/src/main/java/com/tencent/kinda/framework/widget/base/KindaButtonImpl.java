package com.tencent.kinda.framework.widget.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class KindaButtonImpl extends FrameLayout {
    private static final String TAG = "KindaButtonImpl";
    private boolean mIsPressed;
    private ImageView mKButtonImageView;
    private KindaTextViewImpl mKButtonTextView;

    public KindaButtonImpl(Context context) {
        super(context);
        AppMethodBeat.i(18856);
        init(context);
        AppMethodBeat.o(18856);
    }

    public KindaButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(18857);
        init(context);
        AppMethodBeat.o(18857);
    }

    public KindaButtonImpl(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(18858);
        init(context);
        AppMethodBeat.o(18858);
    }

    private void init(Context context) {
        AppMethodBeat.i(18859);
        this.mKButtonImageView = new ImageView(context);
        this.mKButtonImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mKButtonImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(this.mKButtonImageView);
        this.mKButtonTextView = new KindaTextViewImpl(context);
        this.mKButtonTextView.setKindaButton(this);
        this.mKButtonTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mKButtonTextView.setBackgroundResource(R.color.ac_);
        this.mKButtonTextView.setGravity(17);
        addView(this.mKButtonTextView);
        super.setId(R.id.e6k);
        AppMethodBeat.o(18859);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(18860);
        if (this.mKButtonImageView == null) {
            AppMethodBeat.o(18860);
            return;
        }
        this.mKButtonImageView.setImageDrawable(drawable);
        AppMethodBeat.o(18860);
    }

    public void setText(String str) {
        AppMethodBeat.i(18861);
        this.mKButtonTextView.setText(str);
        AppMethodBeat.o(18861);
    }

    public CharSequence getText() {
        AppMethodBeat.i(18862);
        CharSequence text = this.mKButtonTextView.getText();
        AppMethodBeat.o(18862);
        return text;
    }

    public void setTextColor(ColorStateList colorStateList) {
        AppMethodBeat.i(18863);
        this.mKButtonTextView.setTextColor(colorStateList);
        AppMethodBeat.o(18863);
    }

    public int getTextColor() {
        AppMethodBeat.i(18864);
        int currentTextColor = this.mKButtonTextView.getCurrentTextColor();
        AppMethodBeat.o(18864);
        return currentTextColor;
    }

    public void setTextSize(int i2, float f2) {
        AppMethodBeat.i(18865);
        this.mKButtonTextView.setTextSize(i2, f2);
        AppMethodBeat.o(18865);
    }

    public float getTextSize() {
        AppMethodBeat.i(18866);
        float textSize = this.mKButtonTextView.getTextSize();
        AppMethodBeat.o(18866);
        return textSize;
    }

    public void setTextFont(Typeface typeface) {
        AppMethodBeat.i(18867);
        if (typeface != null) {
            this.mKButtonTextView.setTypeface(typeface);
            this.mKButtonTextView.requestLayout();
        }
        AppMethodBeat.o(18867);
    }

    public boolean isKindaPressed() {
        return this.mIsPressed;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(18868);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (!isEnabled()) {
            AppMethodBeat.o(18868);
        } else {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mIsPressed = true;
                    break;
                case 1:
                    this.mIsPressed = false;
                    break;
            }
            AppMethodBeat.o(18868);
        }
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(18869);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        View.MeasureSpec.getSize(i2);
        View.MeasureSpec.getSize(i3);
        if (getHeight() > 0 && getWidth() > 0) {
            if (mode == Integer.MIN_VALUE) {
                i2 = getWidth() + 1073741824;
            }
            if (mode2 == Integer.MIN_VALUE) {
                i3 = getHeight() + 1073741824;
            }
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(18869);
    }

    public void setId(int i2) {
        AppMethodBeat.i(18870);
        this.mKButtonTextView.setId(i2);
        AppMethodBeat.o(18870);
    }

    public void setContentDescription(CharSequence charSequence) {
        AppMethodBeat.i(18871);
        this.mKButtonTextView.setContentDescription(charSequence);
        AppMethodBeat.o(18871);
    }

    public KindaTextViewImpl getKButtonTextView() {
        return this.mKButtonTextView;
    }
}

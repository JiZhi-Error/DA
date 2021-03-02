package com.tencent.mm.plugin.game.ui;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.smtt.sdk.TbsListener;

public final class w implements View.OnTouchListener {
    private int mColor;

    public w() {
        this(Color.argb((int) TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, (int) r.CTRL_INDEX, (int) r.CTRL_INDEX, (int) r.CTRL_INDEX));
        AppMethodBeat.i(42416);
        AppMethodBeat.o(42416);
    }

    private w(int i2) {
        this.mColor = i2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(42417);
        int action = motionEvent.getAction();
        if (action == 0) {
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                Drawable drawable = imageView.getDrawable();
                if (drawable != null) {
                    drawable.setColorFilter(this.mColor, PorterDuff.Mode.MULTIPLY);
                    imageView.setImageDrawable(drawable);
                }
            } else if (view.getBackground() != null) {
                view.getBackground().setColorFilter(this.mColor, PorterDuff.Mode.MULTIPLY);
            }
        } else if (action == 1 || action == 3) {
            if (view instanceof ImageView) {
                Drawable drawable2 = ((ImageView) view).getDrawable();
                if (drawable2 != null) {
                    drawable2.clearColorFilter();
                }
            } else {
                Drawable background = view.getBackground();
                if (background != null) {
                    background.clearColorFilter();
                }
            }
        }
        AppMethodBeat.o(42417);
        return false;
    }
}

package com.tencent.kinda.framework.widget.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class LayoutWrapper extends LinearLayout {
    public LayoutWrapper(Context context, View view) {
        super(context);
        AppMethodBeat.i(214511);
        setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        addView(view, layoutParams);
        setClickable(true);
        setLongClickable(true);
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.kinda.framework.widget.base.LayoutWrapper.AnonymousClass1 */

            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(214510);
                this.onTouchEvent(motionEvent);
                AppMethodBeat.o(214510);
                return false;
            }
        });
        AppMethodBeat.o(214511);
    }
}

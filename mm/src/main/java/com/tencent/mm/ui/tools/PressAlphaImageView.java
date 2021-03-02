package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import junit.framework.Assert;

public class PressAlphaImageView extends WeImageView {
    private float QvL = 0.7f;

    public PressAlphaImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143206);
        super.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.tools.PressAlphaImageView.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(143205);
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setAlpha(PressAlphaImageView.this.QvL);
                        break;
                    case 1:
                    case 3:
                        view.setAlpha(1.0f);
                        break;
                }
                if (PressAlphaImageView.this.isClickable() || PressAlphaImageView.this.isLongClickable()) {
                    AppMethodBeat.o(143205);
                    return false;
                }
                AppMethodBeat.o(143205);
                return true;
            }
        });
        AppMethodBeat.o(143206);
    }

    @Deprecated
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(143207);
        Assert.assertTrue(false);
        AppMethodBeat.o(143207);
    }

    public void setPressAlpha(float f2) {
        this.QvL = f2;
    }
}

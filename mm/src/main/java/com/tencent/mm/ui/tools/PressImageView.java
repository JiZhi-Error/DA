package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import junit.framework.Assert;

public class PressImageView extends ImageView {
    private MMHandler Eok = new MMHandler();
    private Runnable Eol = new Runnable() {
        /* class com.tencent.mm.ui.tools.PressImageView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(143211);
            PressImageView.this.setPressed(false);
            PressImageView.this.invalidate();
            AppMethodBeat.o(143211);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f1555a = 90;

    /* renamed from: b  reason: collision with root package name */
    private int f1556b = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f1557g = 0;
    private int r = 0;

    public PressImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143213);
        super.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.tools.PressImageView.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(143212);
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        PressImageView.this.Eok.removeCallbacks(PressImageView.this.Eol);
                        break;
                    case 1:
                    case 3:
                        PressImageView.this.Eok.post(PressImageView.this.Eol);
                        break;
                }
                if (PressImageView.this.isClickable() || PressImageView.this.isLongClickable()) {
                    AppMethodBeat.o(143212);
                    return false;
                }
                AppMethodBeat.o(143212);
                return true;
            }
        });
        AppMethodBeat.o(143213);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(143214);
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.f1555a, this.r, this.f1557g, this.f1556b);
        }
        AppMethodBeat.o(143214);
    }

    @Deprecated
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(143215);
        Assert.assertTrue(false);
        AppMethodBeat.o(143215);
    }
}

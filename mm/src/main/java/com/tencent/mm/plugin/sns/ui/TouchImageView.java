package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class TouchImageView extends ImageView {
    private RectF ERR = new RectF();
    private Paint ERS = new Paint();
    MMHandler Eok;
    Runnable Eol;

    /* renamed from: a  reason: collision with root package name */
    private int f1516a = 90;

    /* renamed from: b  reason: collision with root package name */
    private int f1517b = 0;
    private boolean enable = true;

    /* renamed from: g  reason: collision with root package name */
    private int f1518g = 0;
    private int r = 0;

    public TouchImageView(Context context) {
        super(context);
        AppMethodBeat.i(99770);
        init();
        AppMethodBeat.o(99770);
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(99771);
        init();
        AppMethodBeat.o(99771);
    }

    public void settouchEnable(boolean z) {
        this.enable = z;
    }

    private void init() {
        AppMethodBeat.i(99772);
        this.Eok = new MMHandler();
        this.Eol = new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.TouchImageView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(99768);
                TouchImageView.this.setPressed(false);
                TouchImageView.this.invalidate();
                AppMethodBeat.o(99768);
            }
        };
        super.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.TouchImageView.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(99769);
                if (!TouchImageView.this.enable) {
                    AppMethodBeat.o(99769);
                    return false;
                }
                TouchImageView touchImageView = TouchImageView.this;
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        touchImageView.Eok.removeCallbacks(touchImageView.Eol);
                        break;
                    case 1:
                    case 3:
                        touchImageView.Eok.post(touchImageView.Eol);
                        break;
                }
                if (touchImageView.isClickable() || touchImageView.isLongClickable()) {
                    AppMethodBeat.o(99769);
                    return false;
                }
                AppMethodBeat.o(99769);
                return true;
            }
        });
        AppMethodBeat.o(99772);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(99773);
        super.onDraw(canvas);
        if (isPressed()) {
            this.ERR.left = (float) getPaddingLeft();
            this.ERR.top = (float) getPaddingTop();
            this.ERR.right = (float) (getWidth() - getPaddingRight());
            this.ERR.bottom = (float) (getHeight() - getPaddingBottom());
            this.ERS.setARGB(this.f1516a, this.r, this.f1518g, this.f1517b);
            canvas.drawRoundRect(this.ERR, (float) (getWidth() / 10), (float) (getHeight() / 10), this.ERS);
        }
        AppMethodBeat.o(99773);
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(99774);
        AppMethodBeat.o(99774);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(99775);
        super.onAttachedToWindow();
        Log.d("MicroMsg.MaskImageView", "onAttachedToWindow");
        AppMethodBeat.o(99775);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(99776);
        super.onDetachedFromWindow();
        Log.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
        AppMethodBeat.o(99776);
    }
}

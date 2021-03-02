package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class MaskImageButton extends ImageView {
    private MMHandler Eok;
    private Runnable Eol;
    private RectF Qvk;
    private int Qvl;
    private int Qvm;

    /* renamed from: a  reason: collision with root package name */
    private int f1552a;

    /* renamed from: b  reason: collision with root package name */
    private int f1553b;

    /* renamed from: g  reason: collision with root package name */
    private int f1554g;
    public Object ico;
    private Paint paint;
    private int r;

    public MaskImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143201);
        this.Qvk = new RectF();
        this.paint = null;
        this.f1552a = 90;
        this.r = 0;
        this.f1554g = 0;
        this.f1553b = 0;
        this.Qvl = 0;
        this.Qvm = 0;
        this.paint = new Paint();
        this.paint.setColor(Color.argb(this.f1552a, this.r, this.f1554g, this.f1553b));
        this.Eok = new MMHandler(Looper.getMainLooper());
        this.Eol = new Runnable() {
            /* class com.tencent.mm.ui.tools.MaskImageButton.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(143199);
                MaskImageButton.this.setPressed(false);
                MaskImageButton.this.invalidate();
                AppMethodBeat.o(143199);
            }
        };
        super.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.tools.MaskImageButton.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(143200);
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        MaskImageButton.this.Eok.removeCallbacks(MaskImageButton.this.Eol);
                        break;
                    case 1:
                    case 3:
                        MaskImageButton.this.Eok.post(MaskImageButton.this.Eol);
                        break;
                }
                if (MaskImageButton.this.isClickable() || MaskImageButton.this.isLongClickable()) {
                    AppMethodBeat.o(143200);
                    return false;
                }
                AppMethodBeat.o(143200);
                return true;
            }
        });
        AppMethodBeat.o(143201);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(143202);
        super.onDraw(canvas);
        if (isPressed()) {
            this.Qvk.set((float) (getPaddingLeft() + 0), (float) (getPaddingTop() + 0), (float) (this.Qvl - getPaddingRight()), (float) (this.Qvm - getPaddingBottom()));
            canvas.drawRoundRect(this.Qvk, (float) (getMeasuredHeight() / 10), (float) (getMeasuredHeight() / 10), this.paint);
        }
        AppMethodBeat.o(143202);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(143203);
        super.onMeasure(i2, i3);
        this.Qvl = getMeasuredWidth();
        this.Qvm = getMeasuredHeight();
        AppMethodBeat.o(143203);
    }
}

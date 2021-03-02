package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import junit.framework.Assert;

public class AsyncMaskImageView extends ImageView {
    MMHandler Eok = new MMHandler();
    Runnable Eol = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.AsyncMaskImageView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(97753);
            AsyncMaskImageView.this.setPressed(false);
            AsyncMaskImageView.this.invalidate();
            AppMethodBeat.o(97753);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f1510a = 90;

    /* renamed from: b  reason: collision with root package name */
    private int f1511b = 0;
    private boolean enable = true;

    /* renamed from: g  reason: collision with root package name */
    private int f1512g = 0;
    private int r = 0;

    public AsyncMaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(97755);
        super.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.AsyncMaskImageView.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(97754);
                if (!AsyncMaskImageView.this.enable) {
                    AppMethodBeat.o(97754);
                    return false;
                }
                AsyncMaskImageView asyncMaskImageView = AsyncMaskImageView.this;
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        asyncMaskImageView.Eok.removeCallbacks(asyncMaskImageView.Eol);
                        break;
                    case 1:
                    case 3:
                        asyncMaskImageView.Eok.post(asyncMaskImageView.Eol);
                        break;
                }
                if (asyncMaskImageView.isClickable() || asyncMaskImageView.isLongClickable()) {
                    AppMethodBeat.o(97754);
                    return false;
                }
                AppMethodBeat.o(97754);
                return true;
            }
        });
        AppMethodBeat.o(97755);
    }

    public void settouchEnable(boolean z) {
        this.enable = z;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(97756);
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.f1510a, this.r, this.f1512g, this.f1511b);
        }
        AppMethodBeat.o(97756);
    }

    @Deprecated
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(97757);
        Assert.assertTrue(false);
        AppMethodBeat.o(97757);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(97758);
        super.onAttachedToWindow();
        Log.d("MicroMsg.MaskImageView", "onAttachedToWindow");
        AppMethodBeat.o(97758);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(97759);
        super.onDetachedFromWindow();
        Log.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
        AppMethodBeat.o(97759);
    }
}

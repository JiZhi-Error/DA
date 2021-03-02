package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.view.View;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;

@TargetApi(21)
public final class l extends Drawable {
    private final Paint mPaint = new Paint();
    private final Rect mTempRect = new Rect();
    private int olA = 0;
    public int olB = 0;
    final Rect olz = new Rect();

    public l() {
        AppMethodBeat.i(49371);
        AppMethodBeat.o(49371);
    }

    public static void a(Activity activity, View view) {
        AppMethodBeat.i(49372);
        if (view == null || activity == null) {
            AppMethodBeat.o(49372);
            return;
        }
        l lVar = new l();
        final View decorView = activity.getWindow().getDecorView();
        view.setBackground(lVar);
        AnonymousClass1 r2 = new View.OnApplyWindowInsetsListener(lVar) {
            /* class com.tencent.mm.plugin.appbrand.widget.l.AnonymousClass1 */
            final /* synthetic */ l olC;

            {
                this.olC = r1;
            }

            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                AppMethodBeat.i(49370);
                this.olC.olz.set(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                u.X(view);
                if (decorView == view) {
                    AppMethodBeat.o(49370);
                    return windowInsets;
                }
                WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                AppMethodBeat.o(49370);
                return onApplyWindowInsets;
            }
        };
        if (decorView == view) {
            ap.bn(activity).a(r2);
        } else {
            view.setOnApplyWindowInsetsListener(r2);
        }
        lVar.olA = 0;
        lVar.olB = activity.getWindow().getNavigationBarColor();
        AppMethodBeat.o(49372);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(49373);
        Rect bounds = getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0) {
            AppMethodBeat.o(49373);
            return;
        }
        int min = Math.min(bounds.top + this.olz.top, bounds.bottom);
        int min2 = Math.min(bounds.left + this.olz.left, bounds.right);
        int max = Math.max(bounds.right - this.olz.right, bounds.left);
        int max2 = Math.max(bounds.bottom - this.olz.bottom, bounds.top);
        if (this.olA != 0 && this.olz.top > 0) {
            this.mTempRect.set(min2, bounds.top, max, min);
            this.mPaint.setColor(this.olA);
            canvas.drawRect(this.mTempRect, this.mPaint);
        }
        if (this.olB != 0) {
            if (this.olz.left > 0) {
                this.mTempRect.set(bounds.left, min, min2, max2);
                this.mPaint.setColor(this.olB);
                canvas.drawRect(this.mTempRect, this.mPaint);
            }
            if (this.olz.right > 0) {
                this.mTempRect.set(max, min, bounds.right, max2);
                this.mPaint.setColor(this.olB);
                canvas.drawRect(this.mTempRect, this.mPaint);
            }
            if (this.olz.bottom > 0) {
                this.mTempRect.set(min2, max2, max, bounds.bottom);
                this.mPaint.setColor(this.olB);
                canvas.drawRect(this.mTempRect, this.mPaint);
            }
        }
        AppMethodBeat.o(49373);
    }

    public final void setAlpha(int i2) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -3;
    }
}

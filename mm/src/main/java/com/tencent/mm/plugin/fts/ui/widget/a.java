package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends Drawable {
    private Context context;
    int currentState = 2;
    private Paint paint = new Paint(1);
    private Drawable xfa;
    private Drawable xfb;
    private int xfc = 0;
    private int xfd = 0;
    private int xfe;
    private int xff;
    private int xfg;
    private int xfh;
    private int xfi = 0;
    boolean xfj = false;
    private int xfk;
    int xfl = 0;
    private int xfm = 0;

    public a(Context context2) {
        AppMethodBeat.i(112284);
        this.context = context2;
        this.xfc = com.tencent.mm.cb.a.n(context2, R.color.afp);
        this.xfd = com.tencent.mm.cb.a.n(context2, R.color.afz);
        this.xfa = context2.getResources().getDrawable(R.drawable.c_1);
        this.xfb = context2.getResources().getDrawable(R.drawable.c_2);
        this.xfi = com.tencent.mm.cb.a.fromDPToPix(context2, 24);
        this.xfe = com.tencent.mm.cb.a.n(context2, R.color.ad7);
        this.xfh = com.tencent.mm.cb.a.n(context2, R.color.ad8);
        this.xfk = com.tencent.mm.cb.a.fromDPToPix(context2, 47);
        this.xff = com.tencent.mm.cb.a.fromDPToPix(context2, 47);
        this.xfg = com.tencent.mm.cb.a.fromDPToPix(context2, 60);
        this.xfm = 4;
        Log.d("MicroMsg.FTSVoiceInputDrawable", "waveStep %s", Integer.valueOf(this.xfm));
        AppMethodBeat.o(112284);
    }

    public final void dPL() {
        AppMethodBeat.i(112285);
        Log.d("MicroMsg.FTSVoiceInputDrawable", "readyState %s", Integer.valueOf(this.currentState));
        this.currentState = 2;
        this.xfl = 0;
        invalidateSelf();
        AppMethodBeat.o(112285);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(112286);
        if ((this.currentState == 6 || this.currentState == 7) && !s(canvas)) {
            int width = canvas.getWidth() >> 1;
            int height = canvas.getHeight() >> 1;
            this.paint.setShader(null);
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(this.xfe);
            if (this.currentState == 7) {
                if (this.xfj) {
                    this.xfk -= this.xfm;
                } else {
                    this.xfk += this.xfm;
                }
                this.xfk = Math.min(Math.max(this.xff, this.xfk), this.xfg);
                canvas.drawCircle((float) width, (float) height, (float) this.xfk, this.paint);
            } else {
                canvas.drawCircle((float) width, (float) height, (float) this.xff, this.paint);
            }
        }
        if (this.currentState == 6 || this.currentState == 7) {
            d(canvas, true);
        } else {
            d(canvas, false);
        }
        if ((this.currentState == 6 || this.currentState == 7) && !s(canvas)) {
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(this.xfh);
            canvas.drawCircle((float) (canvas.getWidth() >> 1), (float) (canvas.getHeight() >> 1), (float) this.xfi, this.paint);
        }
        AppMethodBeat.o(112286);
    }

    private void d(Canvas canvas, boolean z) {
        Drawable drawable;
        int i2;
        AppMethodBeat.i(112287);
        if (this.xfa == null || s(canvas)) {
            AppMethodBeat.o(112287);
            return;
        }
        if (z) {
            drawable = this.xfb;
            i2 = this.xfc;
        } else {
            drawable = this.xfa;
            i2 = this.xfd;
        }
        int width = canvas.getWidth() / 2;
        int height = canvas.getHeight() / 2;
        int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
        int intrinsicHeight = drawable.getIntrinsicHeight() / 2;
        this.paint.setShader(null);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(i2);
        canvas.drawCircle((float) width, (float) height, (float) this.xfi, this.paint);
        drawable.setBounds(width - intrinsicWidth, height - intrinsicHeight, width + intrinsicWidth, height + intrinsicHeight);
        drawable.draw(canvas);
        AppMethodBeat.o(112287);
    }

    public final void setAlpha(int i2) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.i(112288);
        if (this.context == null) {
            AppMethodBeat.o(112288);
            return 0;
        }
        int jn = com.tencent.mm.cb.a.jn(this.context);
        AppMethodBeat.o(112288);
        return jn;
    }

    public final int getIntrinsicHeight() {
        return this.xfi * 2;
    }

    public final int getOpacity() {
        return -3;
    }

    private static boolean s(Canvas canvas) {
        AppMethodBeat.i(112289);
        if (canvas == null || canvas.getWidth() == 0 || canvas.getHeight() == 0) {
            AppMethodBeat.o(112289);
            return true;
        }
        AppMethodBeat.o(112289);
        return false;
    }

    public static boolean Nw(int i2) {
        if (i2 < 10) {
            return true;
        }
        return false;
    }
}

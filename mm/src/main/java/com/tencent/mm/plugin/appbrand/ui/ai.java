package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai extends Drawable {
    private int SE;
    private Paint SG;
    private int mOffsetX;
    private int mOffsetY;
    private Paint nYR;
    private int nYS;
    private int nYT;
    private int[] nYU;
    private RectF nYV;

    /* synthetic */ ai(int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7, byte b2) {
        this(i2, iArr, i3, i4, i5, i6, i7);
    }

    private ai(int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(176778);
        this.nYS = i2;
        this.nYU = iArr;
        this.nYT = i3;
        this.SE = i5;
        this.mOffsetX = i6;
        this.mOffsetY = i7;
        this.SG = new Paint();
        this.SG.setColor(0);
        this.SG.setAntiAlias(true);
        this.SG.setShadowLayer((float) i5, (float) i6, (float) i7, i4);
        this.SG.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.nYR = new Paint();
        this.nYR.setAntiAlias(true);
        AppMethodBeat.o(176778);
    }

    public final void setBounds(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(176779);
        super.setBounds(i2, i3, i4, i5);
        this.nYV = new RectF((float) ((this.SE + i2) - this.mOffsetX), (float) ((this.SE + i3) - this.mOffsetY), (float) ((i4 - this.SE) - this.mOffsetX), (float) ((i5 - this.SE) - this.mOffsetY));
        AppMethodBeat.o(176779);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(176780);
        if (this.nYU != null) {
            if (this.nYU.length == 1) {
                this.nYR.setColor(this.nYU[0]);
            } else {
                this.nYR.setShader(new LinearGradient(this.nYV.left, this.nYV.height() / 2.0f, this.nYV.right, this.nYV.height() / 2.0f, this.nYU, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.nYS == 1) {
            canvas.drawRoundRect(this.nYV, (float) this.nYT, (float) this.nYT, this.SG);
            canvas.drawRoundRect(this.nYV, (float) this.nYT, (float) this.nYT, this.nYR);
            AppMethodBeat.o(176780);
            return;
        }
        canvas.drawCircle(this.nYV.centerX(), this.nYV.centerY(), Math.min(this.nYV.width(), this.nYV.height()) / 2.0f, this.SG);
        canvas.drawCircle(this.nYV.centerX(), this.nYV.centerY(), Math.min(this.nYV.width(), this.nYV.height()) / 2.0f, this.nYR);
        AppMethodBeat.o(176780);
    }

    public final void setAlpha(int i2) {
        AppMethodBeat.i(176781);
        this.SG.setAlpha(i2);
        AppMethodBeat.o(176781);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(176782);
        this.SG.setColorFilter(colorFilter);
        AppMethodBeat.o(176782);
    }

    public final int getOpacity() {
        return -3;
    }

    public static void b(View view, Drawable drawable) {
        AppMethodBeat.i(176783);
        view.setLayerType(1, null);
        u.a(view, drawable);
        AppMethodBeat.o(176783);
    }

    public static class a {
        public int SE;
        public int mOffsetX;
        public int mOffsetY;
        private int nYS;
        public int nYT;
        private int[] nYU;
        public int nYW;

        public a() {
            AppMethodBeat.i(176776);
            this.mOffsetX = 0;
            this.mOffsetY = 0;
            this.nYS = 1;
            this.nYT = 12;
            this.nYW = Color.parseColor("#4d000000");
            this.SE = 18;
            this.mOffsetX = 0;
            this.mOffsetY = 0;
            this.nYU = new int[1];
            this.nYU[0] = 0;
            AppMethodBeat.o(176776);
        }

        public final ai bXO() {
            AppMethodBeat.i(176777);
            ai aiVar = new ai(this.nYS, this.nYU, this.nYT, this.nYW, this.SE, this.mOffsetX, this.mOffsetY, (byte) 0);
            AppMethodBeat.o(176777);
            return aiVar;
        }
    }
}

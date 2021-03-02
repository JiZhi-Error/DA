package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements d {
    private static int mAe;
    private static int mAf;
    private int QD = -1;
    private int ahm;
    private int ahu;
    private StaticLayout huH;
    private SpannableString mAg;
    private int mAh;
    private int mAi;
    private int mAj = -1;
    private int mAk;
    private int mAl;
    private float mAm;
    private Context mContext;

    public a(Context context, SpannableString spannableString, int i2, int i3) {
        AppMethodBeat.i(137851);
        this.mContext = context;
        this.mAg = spannableString;
        this.mAk = b.N(this.mContext, b.mAn);
        this.QD = i2;
        this.mAm = 3.0f;
        this.mAl = i3;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.QD);
        textPaint.setTextSize((float) this.mAk);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        this.ahu = ((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.top))) + 2;
        this.huH = new StaticLayout(this.mAg, textPaint, ((int) Layout.getDesiredWidth(this.mAg, 0, this.mAg.length(), textPaint)) + 1, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.ahm = this.huH.getWidth();
        AppMethodBeat.o(137851);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d
    public final void b(Canvas canvas, boolean z) {
        AppMethodBeat.i(137852);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (!(width == mAe && height == mAf)) {
            mAe = width;
            mAf = height;
        }
        canvas.save();
        canvas.translate((float) this.mAh, (float) this.mAi);
        this.huH.draw(canvas);
        canvas.restore();
        if (!z) {
            this.mAh = (int) (((float) this.mAh) - (((float) b.bKl()) * this.mAm));
        }
        AppMethodBeat.o(137852);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d
    public final void eh(int i2, int i3) {
        this.mAh = i2;
        this.mAi = i3;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d
    public final float bKi() {
        return this.mAm;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d
    public final boolean bKj() {
        AppMethodBeat.i(137853);
        if (this.mAh >= 0 || Math.abs(this.mAh) <= this.ahm) {
            AppMethodBeat.o(137853);
            return false;
        }
        AppMethodBeat.o(137853);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d
    public final int getWidth() {
        return this.ahm;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d
    public final int getCurrX() {
        return this.mAh;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d
    public final int bKk() {
        return this.mAl;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d
    public final boolean xC(int i2) {
        if (i2 >= this.mAl && i2 - this.mAl <= b.mAo) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d
    public final boolean xD(int i2) {
        return i2 - this.mAl > b.mAo;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d
    public final boolean a(d dVar) {
        AppMethodBeat.i(137854);
        if (dVar.getWidth() + dVar.getCurrX() > mAe) {
            AppMethodBeat.o(137854);
            return true;
        }
        if (this.mAj < 0) {
            this.mAj = b.N(this.mContext, 20);
        }
        if (dVar.bKi() >= this.mAm) {
            if (dVar.bKi() != this.mAm || ((float) (mAe - (dVar.getCurrX() + dVar.getWidth()))) >= ((float) this.mAj)) {
                AppMethodBeat.o(137854);
                return false;
            }
            AppMethodBeat.o(137854);
            return true;
        } else if (((double) ((((float) (dVar.getCurrX() + dVar.getWidth())) / (dVar.bKi() * ((float) b.bKl()))) * this.mAm * ((float) b.bKl()))) > ((double) mAe) - (((double) this.mAj) * 1.5d)) {
            AppMethodBeat.o(137854);
            return true;
        } else {
            AppMethodBeat.o(137854);
            return false;
        }
    }
}

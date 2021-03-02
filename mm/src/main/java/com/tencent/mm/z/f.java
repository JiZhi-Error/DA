package com.tencent.mm.z;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.PhotoEditText;

public final class f extends c {
    private static TextPaint ayn;
    private static final float hoF = MMApplicationContext.getResources().getDimension(R.dimen.a0w);
    private static final int hoG = ((int) MMApplicationContext.getResources().getDimension(R.dimen.a_q));
    private static final int hoH = ((int) MMApplicationContext.getResources().getDimension(R.dimen.afn));
    public SpannableString hoI;
    public int mBgColor = -65536;
    public int mColor = -1;

    static {
        AppMethodBeat.i(9275);
        TextPaint textPaint = new TextPaint(1);
        ayn = textPaint;
        textPaint.setStrokeCap(Paint.Cap.ROUND);
        ayn.setStyle(Paint.Style.FILL);
        ayn.setDither(true);
        ayn.setTextSize(hoF);
        AppMethodBeat.o(9275);
    }

    public f(Context context, Matrix matrix, String str, Rect rect, SpannableString spannableString, int i2, int i3) {
        super(context, matrix, str, rect);
        this.mColor = i2;
        this.hoI = spannableString;
        this.mBgColor = i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.z.c
    public final Bitmap ayx() {
        AppMethodBeat.i(9273);
        ayn.setColor(this.mColor);
        if (this.hoI == null) {
            AppMethodBeat.o(9273);
            return null;
        }
        PhotoEditText photoEditText = new PhotoEditText(this.mContext);
        int aG = a.aG(this.mContext, R.dimen.a0u);
        photoEditText.setPadding(aG, 0, aG, 0);
        photoEditText.setTextBackground(this.mBgColor);
        photoEditText.setTextColor(this.mColor);
        photoEditText.setTextSize((float) Math.round(hoF / this.mContext.getResources().getDisplayMetrics().density));
        photoEditText.setText(l.b(this.mContext, this.hoI, hoF / 1.3f));
        photoEditText.setSingleLine(false);
        photoEditText.setMaxWidth((int) (((float) this.mContext.getResources().getDisplayMetrics().widthPixels) - (this.mContext.getResources().getDimension(R.dimen.a0u) * 2.0f)));
        if (this.mBgColor == 0 && this.mColor != -16777216) {
            photoEditText.setShadowLayer((float) a.fromDPToPix(photoEditText.getContext(), 3), 0.0f, (float) a.fromDPToPix(photoEditText.getContext(), 1), Integer.MIN_VALUE);
        }
        photoEditText.measure(0, 0);
        Bitmap createBitmap = Bitmap.createBitmap(photoEditText.getMeasuredWidth() - aG, photoEditText.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        photoEditText.getLayout().getPaint().setColor(this.mColor);
        canvas.save();
        canvas.translate(-0.5f * ((float) aG), 0.0f);
        photoEditText.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(((float) aG) * 0.5f, 0.0f);
        photoEditText.getLayout().draw(canvas);
        canvas.restore();
        AppMethodBeat.o(9273);
        return createBitmap;
    }

    @Override // com.tencent.mm.z.c
    public final void setSelected(boolean z) {
        AppMethodBeat.i(9274);
        super.setSelected(z);
        if (!z) {
            this.hop = false;
        }
        AppMethodBeat.o(9274);
    }
}

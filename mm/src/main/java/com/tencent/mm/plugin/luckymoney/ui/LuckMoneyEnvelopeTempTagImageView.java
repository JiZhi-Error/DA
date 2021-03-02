package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.mm.plugin.wxpay.a;

public class LuckMoneyEnvelopeTempTagImageView extends ImageView {
    private String mText = "";
    private Path xT = new Path();
    private Paint zbt = new Paint();

    public LuckMoneyEnvelopeTempTagImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(65417);
        this.zbt.setAntiAlias(true);
        c(context, attributeSet, -1);
        AppMethodBeat.o(65417);
    }

    public LuckMoneyEnvelopeTempTagImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(65418);
        this.zbt.setAntiAlias(true);
        c(context, attributeSet, i2);
        AppMethodBeat.o(65418);
    }

    private void c(Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(65419);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C2011a.LuckMoneyEnvelopeTempTagImageView, i2, 0);
        this.mText = obtainStyledAttributes.getString(0);
        this.zbt.setColor(obtainStyledAttributes.getColor(1, 0));
        this.zbt.setTextSize((float) obtainStyledAttributes.getDimensionPixelSize(2, 0));
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(65419);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(65420);
        super.onDraw(canvas);
        this.xT.moveTo(0.0f, 0.0f);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 98);
        this.xT.lineTo((float) fromDPToPix, (float) fromDPToPix);
        canvas.drawTextOnPath(this.mText, this.xT, (float) ((int) ((((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), (int) b.CTRL_INDEX)) - this.zbt.measureText(this.mText)) / 2.0f)), -30.0f, this.zbt);
        AppMethodBeat.o(65420);
    }
}

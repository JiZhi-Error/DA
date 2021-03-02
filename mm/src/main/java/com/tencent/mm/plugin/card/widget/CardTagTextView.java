package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class CardTagTextView extends TextView {
    private int fillColor = 0;
    private int pYb = 3;
    private Paint qgr = new Paint();
    private RectF qll = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private int qlm = 9;
    private int qln = 0;

    public CardTagTextView(Context context) {
        super(context);
        AppMethodBeat.i(113879);
        init();
        AppMethodBeat.o(113879);
    }

    public CardTagTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113880);
        init();
        AppMethodBeat.o(113880);
    }

    public CardTagTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(113881);
        init();
        AppMethodBeat.o(113881);
    }

    private void init() {
        AppMethodBeat.i(113882);
        this.pYb = Math.round(a.getDensity(getContext()) * 0.5f);
        this.qlm = a.fromDPToPix(getContext(), 3);
        this.qln = getCurrentTextColor();
        AppMethodBeat.o(113882);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        AppMethodBeat.i(113883);
        this.qln = i2;
        super.setTextColor(i2);
        AppMethodBeat.o(113883);
    }

    public void setFillColor(int i2) {
        this.fillColor = i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(113884);
        this.qll.left = (float) this.qlm;
        this.qll.top = (float) this.pYb;
        this.qll.right = (float) (getWidth() - this.qlm);
        this.qll.bottom = (float) (getHeight() - this.pYb);
        this.qgr.setAntiAlias(true);
        if (this.fillColor != 0) {
            this.qgr.setColor(this.fillColor);
            this.qgr.setStyle(Paint.Style.FILL);
            canvas.drawRoundRect(this.qll, (float) ((getHeight() / 2) - this.pYb), (float) ((getHeight() / 2) - this.pYb), this.qgr);
        }
        this.qgr.setColor(this.qln);
        this.qgr.setStrokeWidth((float) this.pYb);
        this.qgr.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(this.qll, (float) ((getHeight() / 2) - this.pYb), (float) ((getHeight() / 2) - this.pYb), this.qgr);
        super.onDraw(canvas);
        AppMethodBeat.o(113884);
    }
}

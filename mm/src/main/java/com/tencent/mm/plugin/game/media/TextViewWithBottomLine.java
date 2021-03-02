package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.at;

public class TextViewWithBottomLine extends AppCompatTextView {
    private Paint mPaint;
    private boolean xCM;

    public TextViewWithBottomLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(41179);
        init();
        AppMethodBeat.o(41179);
    }

    public TextViewWithBottomLine(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(41180);
        init();
        AppMethodBeat.o(41180);
    }

    private void init() {
        AppMethodBeat.i(41181);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(getResources().getColor(R.color.a2x));
        AppMethodBeat.o(41181);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(41182);
        super.onDraw(canvas);
        if (this.xCM) {
            canvas.drawRoundRect(0.0f, (float) (getHeight() - at.fromDPToPix(getContext(), 2)), (float) getWidth(), (float) getHeight(), (float) at.fromDPToPix(getContext(), 1), (float) at.fromDPToPix(getContext(), 1), this.mPaint);
        }
        AppMethodBeat.o(41182);
    }

    public void setSelected(boolean z) {
        AppMethodBeat.i(41183);
        this.xCM = z;
        if (z) {
            setTextColor(getResources().getColor(R.color.a2x));
        } else {
            setTextColor(getResources().getColor(R.color.l4));
        }
        invalidate();
        AppMethodBeat.o(41183);
    }
}

package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PhotoEditText extends AppCompatEditText {
    private Xfermode Rkg;
    private int mBgColor;
    private Paint mPaint = new Paint(1);

    public PhotoEditText(Context context) {
        super(context);
        AppMethodBeat.i(9365);
        init();
        AppMethodBeat.o(9365);
    }

    public PhotoEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(9366);
        init();
        AppMethodBeat.o(9366);
    }

    private void init() {
        AppMethodBeat.i(9367);
        new TextView(getContext()).setTextSize(getTextSize());
        this.Rkg = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        AppMethodBeat.o(9367);
    }

    public void setTextBackground(int i2) {
        AppMethodBeat.i(9368);
        this.mBgColor = i2;
        invalidate();
        AppMethodBeat.o(9368);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(9369);
        if (this.mBgColor == 0) {
            super.onDraw(canvas);
            AppMethodBeat.o(9369);
            return;
        }
        canvas.saveLayerAlpha(null, (int) (getAlpha() * 255.0f), 31);
        this.mPaint.setColor(this.mBgColor);
        this.mPaint.setAntiAlias(true);
        Rect rect = new Rect();
        getLineBounds(0, rect);
        if (getLineCount() == 1) {
            rect.right = (int) (getLayout().getLineWidth(0) + ((float) rect.left));
        } else {
            float f2 = 0.0f;
            for (int i2 = 0; i2 < getLineCount(); i2++) {
                float lineWidth = getLayout().getLineWidth(i2);
                if (f2 < lineWidth) {
                    f2 = lineWidth;
                }
            }
            rect.right = (int) (((float) rect.left) + f2);
            rect.bottom = rect.top + getLayout().getLineBottom(getLineCount() - 1);
        }
        rect.left = (int) (((float) rect.left) - 18.0f);
        rect.right = (int) (((float) rect.right) + 18.0f);
        if (getLineCount() != 1) {
            this.mPaint.setXfermode(null);
            this.mPaint.setColor(this.mBgColor);
            canvas.drawRoundRect(new RectF(rect), 12.0f, 12.0f, this.mPaint);
            if (getLayout().getLineWidth(getLineCount() - 1) < getLayout().getLineWidth(getLineCount() - 2)) {
                this.mPaint.setXfermode(this.Rkg);
                RectF rectF = new RectF();
                rectF.left = ((float) rect.left) + 36.0f + getLayout().getLineWidth(getLineCount() - 1);
                rectF.top = (float) (rect.bottom - getLineHeight());
                rectF.right = ((float) rect.right) + 18.0f;
                rectF.bottom = ((float) rect.bottom) + 18.0f;
                canvas.drawRoundRect(rectF, 12.0f, 12.0f, this.mPaint);
                this.mPaint.setXfermode(this.Rkg);
                canvas.drawRect(new Rect((int) (rectF.left - (getTextSize() / 2.0f)), (int) (rectF.bottom - (getTextSize() / 2.0f)), (int) rectF.left, (int) rectF.bottom), this.mPaint);
                canvas.drawRect(new Rect((int) (((float) rect.right) - (getTextSize() / 2.0f)), (int) (((float) (rect.top + getLayout().getLineBottom(getLineCount() - 2))) - (getTextSize() / 2.0f)), rect.right, rect.top + getLayout().getLineBottom(getLineCount() - 2) + 3), this.mPaint);
                this.mPaint.setXfermode(null);
                float textSize = rectF.left - getTextSize();
                if (textSize < ((float) rect.left)) {
                    textSize = (float) rect.left;
                }
                canvas.drawRoundRect(new RectF(new Rect((int) textSize, (int) (((float) rect.bottom) - (getTextSize() / 2.0f)), (int) rectF.left, rect.bottom)), 12.0f, 12.0f, this.mPaint);
                canvas.drawRoundRect(new RectF(new Rect((int) (((float) rect.right) - getTextSize()), (int) (((float) (rect.bottom - getLineHeight())) - getTextSize()), rect.right, rect.bottom - getLineHeight())), 12.0f, 12.0f, this.mPaint);
            }
        } else if (!TextUtils.isEmpty(getText())) {
            this.mPaint.setXfermode(null);
            canvas.drawRoundRect(new RectF(rect), 12.0f, 12.0f, this.mPaint);
        }
        canvas.restore();
        super.onDraw(canvas);
        AppMethodBeat.o(9369);
    }
}

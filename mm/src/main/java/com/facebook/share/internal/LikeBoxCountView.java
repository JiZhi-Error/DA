package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

@Deprecated
public class LikeBoxCountView extends FrameLayout {
    private int additionalTextPadding;
    private Paint borderPaint;
    private float borderRadius;
    private float caretHeight;
    private LikeBoxCountViewCaretPosition caretPosition = LikeBoxCountViewCaretPosition.LEFT;
    private float caretWidth;
    private TextView likeCountLabel;
    private int textPadding;

    public enum LikeBoxCountViewCaretPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM;

        public static LikeBoxCountViewCaretPosition valueOf(String str) {
            AppMethodBeat.i(8098);
            LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition = (LikeBoxCountViewCaretPosition) Enum.valueOf(LikeBoxCountViewCaretPosition.class, str);
            AppMethodBeat.o(8098);
            return likeBoxCountViewCaretPosition;
        }

        static {
            AppMethodBeat.i(8099);
            AppMethodBeat.o(8099);
        }
    }

    @Deprecated
    public LikeBoxCountView(Context context) {
        super(context);
        AppMethodBeat.i(8100);
        initialize(context);
        AppMethodBeat.o(8100);
    }

    @Deprecated
    public void setText(String str) {
        AppMethodBeat.i(8101);
        this.likeCountLabel.setText(str);
        AppMethodBeat.o(8101);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Deprecated
    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        AppMethodBeat.i(8102);
        this.caretPosition = likeBoxCountViewCaretPosition;
        switch (likeBoxCountViewCaretPosition) {
            case LEFT:
                setAdditionalTextPadding(this.additionalTextPadding, 0, 0, 0);
                AppMethodBeat.o(8102);
                return;
            case TOP:
                setAdditionalTextPadding(0, this.additionalTextPadding, 0, 0);
                AppMethodBeat.o(8102);
                return;
            case RIGHT:
                setAdditionalTextPadding(0, 0, this.additionalTextPadding, 0);
                AppMethodBeat.o(8102);
                return;
            case BOTTOM:
                setAdditionalTextPadding(0, 0, 0, this.additionalTextPadding);
                break;
        }
        AppMethodBeat.o(8102);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(8103);
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        switch (this.caretPosition) {
            case LEFT:
                paddingLeft = (int) (((float) paddingLeft) + this.caretHeight);
                break;
            case TOP:
                paddingTop = (int) (((float) paddingTop) + this.caretHeight);
                break;
            case RIGHT:
                width = (int) (((float) width) - this.caretHeight);
                break;
            case BOTTOM:
                height = (int) (((float) height) - this.caretHeight);
                break;
        }
        drawBorder(canvas, (float) paddingLeft, (float) paddingTop, (float) width, (float) height);
        AppMethodBeat.o(8103);
    }

    private void initialize(Context context) {
        AppMethodBeat.i(8104);
        setWillNotDraw(false);
        this.caretHeight = getResources().getDimension(R.dimen.xs);
        this.caretWidth = getResources().getDimension(R.dimen.xt);
        this.borderRadius = getResources().getDimension(R.dimen.xq);
        this.borderPaint = new Paint();
        this.borderPaint.setColor(getResources().getColor(R.color.k4));
        this.borderPaint.setStrokeWidth(getResources().getDimension(R.dimen.xr));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        initializeLikeCountLabel(context);
        addView(this.likeCountLabel);
        setCaretPosition(this.caretPosition);
        AppMethodBeat.o(8104);
    }

    private void initializeLikeCountLabel(Context context) {
        AppMethodBeat.i(8105);
        this.likeCountLabel = new TextView(context);
        this.likeCountLabel.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.likeCountLabel.setGravity(17);
        this.likeCountLabel.setTextSize(0, getResources().getDimension(R.dimen.xv));
        this.likeCountLabel.setTextColor(getResources().getColor(R.color.k5));
        this.textPadding = getResources().getDimensionPixelSize(R.dimen.xu);
        this.additionalTextPadding = getResources().getDimensionPixelSize(R.dimen.xs);
        AppMethodBeat.o(8105);
    }

    private void setAdditionalTextPadding(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(8106);
        this.likeCountLabel.setPadding(this.textPadding + i2, this.textPadding + i3, this.textPadding + i4, this.textPadding + i5);
        AppMethodBeat.o(8106);
    }

    private void drawBorder(Canvas canvas, float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(8107);
        Path path = new Path();
        float f6 = this.borderRadius * 2.0f;
        path.addArc(new RectF(f2, f3, f2 + f6, f3 + f6), -180.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.TOP) {
            path.lineTo((((f4 - f2) - this.caretWidth) / 2.0f) + f2, f3);
            path.lineTo(((f4 - f2) / 2.0f) + f2, f3 - this.caretHeight);
            path.lineTo((((f4 - f2) + this.caretWidth) / 2.0f) + f2, f3);
        }
        path.lineTo(f4 - this.borderRadius, f3);
        path.addArc(new RectF(f4 - f6, f3, f4, f3 + f6), -90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.RIGHT) {
            path.lineTo(f4, (((f5 - f3) - this.caretWidth) / 2.0f) + f3);
            path.lineTo(this.caretHeight + f4, ((f5 - f3) / 2.0f) + f3);
            path.lineTo(f4, (((f5 - f3) + this.caretWidth) / 2.0f) + f3);
        }
        path.lineTo(f4, f5 - this.borderRadius);
        path.addArc(new RectF(f4 - f6, f5 - f6, f4, f5), 0.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.BOTTOM) {
            path.lineTo((((f4 - f2) + this.caretWidth) / 2.0f) + f2, f5);
            path.lineTo(((f4 - f2) / 2.0f) + f2, this.caretHeight + f5);
            path.lineTo((((f4 - f2) - this.caretWidth) / 2.0f) + f2, f5);
        }
        path.lineTo(this.borderRadius + f2, f5);
        path.addArc(new RectF(f2, f5 - f6, f6 + f2, f5), 90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.LEFT) {
            path.lineTo(f2, (((f5 - f3) + this.caretWidth) / 2.0f) + f3);
            path.lineTo(f2 - this.caretHeight, ((f5 - f3) / 2.0f) + f3);
            path.lineTo(f2, (((f5 - f3) - this.caretWidth) / 2.0f) + f3);
        }
        path.lineTo(f2, this.borderRadius + f3);
        canvas.drawPath(path, this.borderPaint);
        AppMethodBeat.o(8107);
    }
}

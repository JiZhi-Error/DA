package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class ChattingImageBGView extends ImageView {
    private int ovI = 0;
    private Bitmap xqp;

    public ChattingImageBGView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(34558);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        AppMethodBeat.o(34558);
    }

    public ChattingImageBGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(34559);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        AppMethodBeat.o(34559);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(34560);
        super.onLayout(z, i2, i3, i4, i5);
        if (z && this.ovI != i4 - i2) {
            this.ovI = i4 - i2;
            Log.d("MicroMsg.ChattingImageBGView", "on layout changed, %d, %d, %d, %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            gNQ();
        }
        AppMethodBeat.o(34560);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(34561);
        this.xqp = bitmap;
        super.setImageBitmap(bitmap);
        gNQ();
        AppMethodBeat.o(34561);
    }

    private void gNQ() {
        AppMethodBeat.i(34562);
        post(new Runnable() {
            /* class com.tencent.mm.ui.chatting.ChattingImageBGView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(34557);
                if (ChattingImageBGView.this.xqp == null) {
                    Log.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but bmp is null");
                    AppMethodBeat.o(34557);
                    return;
                }
                if (ChattingImageBGView.this.xqp.getWidth() == 0) {
                    Log.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but measured width error");
                }
                Matrix matrix = new Matrix();
                float measuredWidth = ((float) ChattingImageBGView.this.getMeasuredWidth()) / ((float) ChattingImageBGView.this.xqp.getWidth());
                float measuredHeight = ((float) ChattingImageBGView.this.getMeasuredHeight()) / ((float) ChattingImageBGView.this.xqp.getHeight());
                Log.d("MicroMsg.ChattingImageBGView", "scaleW[%f], scaleH[%f] measured width[%d] measured height[%d]", Float.valueOf(measuredWidth), Float.valueOf(measuredHeight), Integer.valueOf(ChattingImageBGView.this.getMeasuredWidth()), Integer.valueOf(ChattingImageBGView.this.getMeasuredHeight()));
                if (measuredWidth > measuredHeight) {
                    matrix.setScale(measuredWidth, measuredWidth);
                } else {
                    matrix.setScale(measuredHeight, measuredHeight);
                    matrix.postTranslate((((float) ChattingImageBGView.this.getMeasuredWidth()) - (((float) ChattingImageBGView.this.xqp.getWidth()) * measuredHeight)) / 2.0f, 0.0f);
                }
                ChattingImageBGView.this.setImageMatrix(matrix);
                AppMethodBeat.o(34557);
            }
        });
        AppMethodBeat.o(34562);
    }
}

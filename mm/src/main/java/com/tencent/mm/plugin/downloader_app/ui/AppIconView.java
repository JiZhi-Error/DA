package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class AppIconView extends AppCompatImageView {
    private static final PorterDuffXfermode qLS = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    private Bitmap bitmap;
    private RectF hO;
    private Bitmap qLR;
    private Rect rect;

    static {
        AppMethodBeat.i(8969);
        AppMethodBeat.o(8969);
    }

    public AppIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int saveLayer;
        AppMethodBeat.i(8966);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        if (this.rect == null) {
            this.rect = new Rect(0, 0, getWidth(), getHeight());
        }
        if (this.hO == null) {
            this.hO = new RectF(this.rect);
        }
        if (!(this.bitmap == null || this.qLR == null)) {
            if (Build.VERSION.SDK_INT >= 21) {
                saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null);
            } else {
                saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
            }
            canvas.drawBitmap(this.qLR, this.rect, this.rect, paint);
            paint.setXfermode(qLS);
            canvas.drawBitmap(this.bitmap, (Rect) null, this.rect, paint);
            canvas.restoreToCount(saveLayer);
            paint.setXfermode(null);
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint.setColor(getResources().getColor(R.color.ec));
        canvas.drawRoundRect(this.hO, 32.0f, 32.0f, paint);
        AppMethodBeat.o(8966);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(8967);
        this.hO = new RectF(0.0f, 0.0f, (float) i2, (float) i3);
        this.rect = new Rect(0, 0, i2, i3);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(getResources().getColor(R.color.eb));
        canvas.drawRoundRect(this.hO, 32.0f, 32.0f, paint);
        this.qLR = createBitmap;
        AppMethodBeat.o(8967);
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public void setImageBitmap(Bitmap bitmap2) {
        AppMethodBeat.i(8968);
        this.bitmap = bitmap2;
        super.setImageBitmap(bitmap2);
        AppMethodBeat.o(8968);
    }
}

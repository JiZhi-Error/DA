package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class GameRoundImageView extends AppCompatImageView {
    private static final PorterDuffXfermode qLS = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    private Bitmap bitmap;
    private RectF hO;
    private Bitmap qLR;
    private Rect rect;

    static {
        AppMethodBeat.i(42367);
        AppMethodBeat.o(42367);
    }

    public GameRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(42364);
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
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
            canvas.drawBitmap(this.qLR, this.rect, this.rect, paint);
            paint.setXfermode(qLS);
            canvas.drawBitmap(this.bitmap, (Rect) null, this.rect, paint);
            canvas.restoreToCount(saveLayer);
            paint.setXfermode(null);
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint.setColor(getResources().getColor(R.color.sa));
        canvas.drawRoundRect(this.hO, 18.0f, 18.0f, paint);
        AppMethodBeat.o(42364);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(42365);
        this.hO = new RectF(0.0f, 0.0f, (float) i2, (float) i3);
        this.rect = new Rect(0, 0, i2, i3);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawRoundRect(this.hO, 18.0f, 18.0f, paint);
        this.qLR = createBitmap;
        AppMethodBeat.o(42365);
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public void setImageBitmap(Bitmap bitmap2) {
        AppMethodBeat.i(42366);
        this.bitmap = bitmap2;
        super.setImageBitmap(bitmap2);
        AppMethodBeat.o(42366);
    }
}

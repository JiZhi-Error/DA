package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CircularImageView extends ImageView {
    private Paint paint;

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(113727);
        this.paint = new Paint();
        AppMethodBeat.o(113727);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(113728);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(rect);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
            this.paint.setFlags(1);
            canvas2.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas2.drawARGB(0, 0, 0, 0);
            canvas2.drawRoundRect(rectF, 20.0f, 20.0f, this.paint);
            this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas2.drawBitmap(bitmap, rect, rect, this.paint);
            Rect rect2 = new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
            Rect rect3 = new Rect(0, 0, getWidth(), getHeight());
            this.paint.reset();
            canvas.drawBitmap(createBitmap, rect2, rect3, this.paint);
            canvas.save();
            AppMethodBeat.o(113728);
            return;
        }
        super.onDraw(canvas);
        AppMethodBeat.o(113728);
    }
}

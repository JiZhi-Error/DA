package com.tencent.mm.z;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;

public final class e implements Cloneable {
    private static Paint hoB;
    private static int hoz = com.tencent.mm.cl.a.ao(12.0f);
    private float dhh;
    private LinkedList<b> dtx;
    public a dty;
    private Bitmap hoA;
    private Path xT;

    static {
        AppMethodBeat.i(9272);
        Paint paint = new Paint();
        hoB = paint;
        paint.setAntiAlias(true);
        hoB.setStyle(Paint.Style.STROKE);
        hoB.setColor(-16776961);
        hoB.setStrokeCap(Paint.Cap.ROUND);
        AppMethodBeat.o(9272);
    }

    public enum a {
        ONE,
        TWO;

        public static a valueOf(String str) {
            AppMethodBeat.i(9267);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(9267);
            return aVar;
        }

        static {
            AppMethodBeat.i(9268);
            AppMethodBeat.o(9268);
        }
    }

    public e(a aVar, Path path, float f2, Bitmap bitmap) {
        AppMethodBeat.i(9269);
        this.dty = aVar;
        this.hoA = bitmap;
        this.xT = path;
        this.dhh = f2;
        hoB.setStrokeWidth(((float) com.tencent.mm.cl.a.ao(24.0f)) * f2);
        AppMethodBeat.o(9269);
    }

    public e(a aVar, LinkedList<b> linkedList, float f2) {
        AppMethodBeat.i(9270);
        this.dty = aVar;
        this.dtx = linkedList;
        this.dhh = f2;
        hoB.setStrokeWidth(((float) com.tencent.mm.cl.a.ao(24.0f)) * f2);
        AppMethodBeat.o(9270);
    }

    public final void draw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        AppMethodBeat.i(9271);
        if (this.dty == a.ONE) {
            Bitmap bitmap = this.hoA;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.saveLayer(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), null, 31);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.drawPath(this.xT, hoB);
                hoB.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, hoB);
                hoB.setXfermode(null);
                canvas.restore();
            }
            AppMethodBeat.o(9271);
            return;
        }
        if (this.dty == a.TWO) {
            if (this.dtx.size() <= 0) {
                AppMethodBeat.o(9271);
                return;
            }
            b last = this.dtx.getLast();
            float f5 = last.scale;
            int i2 = last.color;
            int random = (int) (Math.random() * 100.0d);
            float f6 = ((float) hoz) * f5;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.aj5, options);
            options.inSampleSize = com.tencent.mm.cl.a.a(options, Math.round(((float) options.outWidth) * f5 * 0.7f), Math.round(f5 * ((float) options.outHeight) * 0.7f));
            options.inJustDecodeBounds = false;
            Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.aj5, options);
            hoB.setStyle(Paint.Style.FILL);
            hoB.setColorFilter(new LightingColorFilter(i2, 1));
            if (decodeResource != null) {
                f3 = last.centerX - ((((float) decodeResource.getWidth()) * 1.0f) / 2.0f);
                f2 = last.centerY - ((((float) decodeResource.getHeight()) * 1.0f) / 2.0f);
            } else {
                f2 = 0.0f;
                f3 = 0.0f;
            }
            if (random > 0 && random <= 20) {
                f3 += f6;
                f4 = f2 + f6;
            } else if (80 < random) {
                f3 -= f6;
                f4 = f2 - f6;
            } else {
                f4 = f2;
            }
            canvas.save();
            canvas.rotate(-last.rotation, last.centerX, last.centerY);
            if (decodeResource != null) {
                canvas.drawBitmap(decodeResource, f3, f4, hoB);
            }
            canvas.restore();
            hoB.setStyle(Paint.Style.STROKE);
            hoB.setColorFilter(null);
        }
        AppMethodBeat.o(9271);
    }

    public static class b {
        public float centerX;
        public float centerY;
        public int color = 0;
        public float rotation = 0.0f;
        public float scale = 0.0f;

        public b(float f2, int i2, float f3, float f4, float f5) {
            this.scale = f2;
            this.color = i2;
            this.rotation = f3;
            this.centerX = f4;
            this.centerY = f5;
        }
    }
}

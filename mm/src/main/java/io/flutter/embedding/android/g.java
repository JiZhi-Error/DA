package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.c;

@SuppressLint({"ViewConstructor"})
@TargetApi(19)
public final class g extends View implements c {
    private Image SMR;
    private Image SMS;
    private io.flutter.embedding.engine.b.a SMT;
    private a SMU;
    private int SMV = 0;
    private boolean SMW = false;
    private ImageReader hiC;
    private Bitmap zUW;

    public enum a {
        background,
        overlay;

        public static a valueOf(String str) {
            AppMethodBeat.i(215046);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(215046);
            return aVar;
        }

        static {
            AppMethodBeat.i(215047);
            AppMethodBeat.o(215047);
        }
    }

    public g(Context context, int i2, int i3, a aVar) {
        super(context, null);
        AppMethodBeat.i(215101);
        this.hiC = mR(i2, i3);
        this.SMU = aVar;
        setAlpha(0.0f);
        AppMethodBeat.o(215101);
    }

    @TargetApi(19)
    private static ImageReader mR(int i2, int i3) {
        AppMethodBeat.i(215102);
        if (Build.VERSION.SDK_INT >= 29) {
            ImageReader newInstance = ImageReader.newInstance(i2, i3, 1, 3, 768);
            AppMethodBeat.o(215102);
            return newInstance;
        }
        ImageReader newInstance2 = ImageReader.newInstance(i2, i3, 1, 3);
        AppMethodBeat.o(215102);
        return newInstance2;
    }

    public final Surface getSurface() {
        AppMethodBeat.i(215103);
        Surface surface = this.hiC.getSurface();
        AppMethodBeat.o(215103);
        return surface;
    }

    @Override // io.flutter.embedding.engine.b.c
    public final io.flutter.embedding.engine.b.a getAttachedRenderer() {
        return this.SMT;
    }

    @Override // io.flutter.embedding.engine.b.c
    public final void a(io.flutter.embedding.engine.b.a aVar) {
        AppMethodBeat.i(215104);
        if (this.SMW) {
            AppMethodBeat.o(215104);
            return;
        }
        switch (this.SMU) {
            case background:
                aVar.p(this.hiC.getSurface());
                break;
        }
        setAlpha(1.0f);
        this.SMT = aVar;
        this.SMW = true;
        AppMethodBeat.o(215104);
    }

    @Override // io.flutter.embedding.engine.b.c
    public final void hwu() {
        AppMethodBeat.i(215105);
        if (!this.SMW) {
            AppMethodBeat.o(215105);
            return;
        }
        setAlpha(0.0f);
        hwv();
        this.SMV = 0;
        this.zUW = null;
        if (this.SMR != null) {
            this.SMR.close();
            this.SMR = null;
        }
        if (this.SMS != null) {
            this.SMS.close();
            this.SMS = null;
        }
        invalidate();
        this.SMW = false;
        AppMethodBeat.o(215105);
    }

    @Override // io.flutter.embedding.engine.b.c
    public final void pause() {
    }

    @TargetApi(19)
    public final boolean hwv() {
        AppMethodBeat.i(215106);
        if (!this.SMW) {
            AppMethodBeat.o(215106);
            return false;
        }
        if (this.SMV < this.hiC.getMaxImages()) {
            this.SMR = this.hiC.acquireLatestImage();
            if (this.SMR != null) {
                this.SMV++;
            }
        }
        invalidate();
        if (this.SMR != null) {
            AppMethodBeat.o(215106);
            return true;
        }
        AppMethodBeat.o(215106);
        return false;
    }

    public final void mS(int i2, int i3) {
        AppMethodBeat.i(215107);
        if (this.SMT == null) {
            AppMethodBeat.o(215107);
        } else if (i2 == this.hiC.getWidth() && i3 == this.hiC.getHeight()) {
            AppMethodBeat.o(215107);
        } else {
            if (this.SMR != null) {
                this.SMR.close();
                this.SMR = null;
            }
            if (this.SMS != null) {
                this.SMS.close();
                this.SMS = null;
            }
            this.hiC.close();
            this.hiC = mR(i2, i3);
            this.SMV = 0;
            AppMethodBeat.o(215107);
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(215108);
        super.onDraw(canvas);
        if (this.SMR != null) {
            if (this.SMS != null) {
                this.SMS.close();
                this.SMV--;
            }
            this.SMS = this.SMR;
            this.SMR = null;
            if (Build.VERSION.SDK_INT >= 29) {
                this.zUW = Bitmap.wrapHardwareBuffer(this.SMS.getHardwareBuffer(), ColorSpace.get(ColorSpace.Named.SRGB));
            } else {
                Image.Plane[] planes = this.SMS.getPlanes();
                if (planes.length == 1) {
                    Image.Plane plane = planes[0];
                    int rowStride = plane.getRowStride() / plane.getPixelStride();
                    int height = this.SMS.getHeight();
                    if (!(this.zUW != null && this.zUW.getWidth() == rowStride && this.zUW.getHeight() == height)) {
                        this.zUW = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
                    }
                    this.zUW.copyPixelsFromBuffer(plane.getBuffer());
                }
            }
        }
        if (this.zUW != null) {
            canvas.drawBitmap(this.zUW, 0.0f, 0.0f, (Paint) null);
        }
        AppMethodBeat.o(215108);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(215109);
        if (i2 == this.hiC.getWidth() && i3 == this.hiC.getHeight()) {
            AppMethodBeat.o(215109);
            return;
        }
        if (this.SMU == a.background && this.SMW) {
            mS(i2, i3);
            this.SMT.p(this.hiC.getSurface());
        }
        AppMethodBeat.o(215109);
    }
}

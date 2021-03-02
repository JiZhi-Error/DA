package com.tencent.mm.e;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.c;
import com.tencent.mm.cache.i;
import com.tencent.mm.cl.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.z.e;
import com.tencent.rtmp.TXLiveConstants;
import java.util.LinkedList;

public final class h extends b<i> {
    private float ayd;
    private float aye;
    private boolean dsX = true;
    private boolean dsY = false;
    private float dsy;
    private float dsz;
    private Bitmap dtw;
    private LinkedList<e.b> dtx = new LinkedList<>();
    public e.a dty = e.a.ONE;
    private Path xT = new Path();

    public h() {
        AppMethodBeat.i(9168);
        AppMethodBeat.o(9168);
    }

    @Override // com.tencent.mm.e.b
    public final a XS() {
        return a.MOSAIC;
    }

    @Override // com.tencent.mm.e.b
    public final void onAlive() {
        Bitmap bitmap;
        int i2;
        AppMethodBeat.i(9169);
        super.onAlive();
        if (((i) super.XU()) != null) {
            t(((i) super.XU()).alK());
        }
        Bitmap gtm = this.drS.gtm();
        if (gtm == null) {
            Log.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
            bitmap = null;
        } else {
            int width = gtm.getWidth();
            int height = gtm.getHeight();
            int ao = a.ao(6.0f);
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            int ceil = (int) Math.ceil((double) (((float) width) / ((float) ao)));
            int ceil2 = (int) Math.ceil((double) (((float) height) / ((float) ao)));
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            for (int i3 = 0; i3 < ceil; i3++) {
                for (int i4 = 0; i4 < ceil2; i4++) {
                    int i5 = ao * i3;
                    int i6 = ao * i4;
                    int i7 = i5 + ao;
                    if (i7 > width) {
                        i2 = width;
                    } else {
                        i2 = i7;
                    }
                    int i8 = i6 + ao;
                    if (i8 > height) {
                        i8 = height;
                    }
                    int pixel = gtm.getPixel(i5, i6);
                    Rect rect = new Rect(i5, i6, i2, i8);
                    paint.setColor(pixel);
                    canvas.drawRect(rect, paint);
                }
            }
            bitmap = createBitmap;
        }
        this.dtw = bitmap;
        AppMethodBeat.o(9169);
    }

    @Override // com.tencent.mm.e.b
    public final void onDestroy() {
        AppMethodBeat.i(9170);
        super.onDestroy();
        if (this.dtw != null && !this.dtw.isRecycled()) {
            this.dtw.recycle();
        }
        AppMethodBeat.o(9170);
    }

    @Override // com.tencent.mm.e.b
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(9171);
        canvas.save();
        canvas.clipRect(this.drU);
        if (this.dty == e.a.ONE) {
            d(canvas);
            new e(this.dty, this.xT, 1.0f / getScale(), this.dtw).draw(canvas);
        } else if (this.dty == e.a.TWO) {
            new e(this.dty, new LinkedList(this.dtx), 1.0f / getScale()).draw(new Canvas(XY()));
            d(canvas);
        }
        canvas.restore();
        AppMethodBeat.o(9171);
    }

    @Override // com.tencent.mm.e.b
    public final boolean q(MotionEvent motionEvent) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(9172);
        if (!XZ()) {
            AppMethodBeat.o(9172);
            return false;
        }
        if (this.dsb != null) {
            this.dsb.q(motionEvent);
        }
        float[] v = v(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.drU.contains((int) v[0], (int) v[1])) {
                    float f2 = v[0];
                    this.dsy = f2;
                    this.ayd = f2;
                    float f3 = v[1];
                    this.dsz = f3;
                    this.aye = f3;
                    this.dsX = true;
                } else {
                    this.dsX = false;
                }
                this.dsY = false;
                break;
            case 1:
            case 5:
                if (this.dsX && this.dsY) {
                    if (((i) super.XU()) == null) {
                        Log.e("MicroMsg.MosaicArtist", "getCache is null???");
                        AppMethodBeat.o(9172);
                        return true;
                    }
                    if (this.dty == e.a.ONE) {
                        ((i) super.XU()).a(new e(this.dty, new Path(this.xT), 1.0f / getScale(), this.dtw));
                        cT(false);
                    } else if (this.dty == e.a.TWO) {
                        ((i) super.XU()).a(new e(this.dty, new LinkedList(this.dtx), 1.0f / getScale()));
                        cT(false);
                    }
                    c.alF().b(com.tencent.mm.api.h.MOSAIC);
                    Yc();
                }
                this.dtx.clear();
                this.xT.reset();
                this.dsY = false;
                this.dsX = false;
                break;
            case 2:
                if (!this.dsX || !this.dsY) {
                    if (this.dsX && !this.dsY) {
                        if (this.dty == e.a.ONE) {
                            this.xT.moveTo(v[0], v[1]);
                        }
                        this.dsY = true;
                        break;
                    }
                } else {
                    this.dsy = this.ayd;
                    this.dsz = this.aye;
                    this.ayd = v[0];
                    this.aye = v[1];
                    if (this.dty == e.a.ONE) {
                        this.xT.quadTo(this.dsy, this.dsz, (this.ayd + this.dsy) / 2.0f, (this.aye + this.dsz) / 2.0f);
                    } else if (this.dty == e.a.TWO) {
                        double degrees = Math.toDegrees(Math.atan((double) ((this.ayd - this.dsy) / (this.aye - this.dsz))));
                        if (getRotation() == 180.0f) {
                            i2 = TXLiveConstants.RENDER_ROTATION_180;
                        } else {
                            i2 = 0;
                        }
                        float f4 = ((float) (((double) i2) + degrees)) % 360.0f;
                        LinkedList<e.b> linkedList = this.dtx;
                        float scale = 1.0f / getScale();
                        float f5 = this.ayd;
                        float f6 = this.aye;
                        Bitmap gtm = this.drS.gtm();
                        if (gtm == null || f5 >= ((float) gtm.getWidth()) || f6 >= ((float) gtm.getHeight()) || f5 <= 0.0f || f6 <= 0.0f) {
                            Log.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", Float.valueOf(f5), Float.valueOf(f6));
                        } else {
                            i3 = gtm.getPixel((int) f5, (int) f6);
                        }
                        linkedList.add(new e.b(scale, i3, f4, this.ayd, this.aye));
                    }
                    Yb();
                    break;
                }
                break;
        }
        boolean z = this.dsX;
        AppMethodBeat.o(9172);
        return z;
    }

    @Override // com.tencent.mm.e.b
    public final void cT(boolean z) {
        AppMethodBeat.i(9173);
        super.cT(z);
        ((i) super.XU()).u(XY());
        AppMethodBeat.o(9173);
    }

    @Override // com.tencent.mm.e.b
    public final void XT() {
        AppMethodBeat.i(9174);
        if (XY() != null && !XY().isRecycled()) {
            XY().recycle();
        }
        t(((i) super.XU()).alK());
        AppMethodBeat.o(9174);
    }

    /* Return type fixed from 'com.tencent.mm.cache.f' to match base method */
    @Override // com.tencent.mm.e.b
    public final /* bridge */ /* synthetic */ i XU() {
        AppMethodBeat.i(9175);
        i iVar = (i) super.XU();
        AppMethodBeat.o(9175);
        return iVar;
    }
}

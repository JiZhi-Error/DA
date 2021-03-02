package com.tencent.mm.e;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.f;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class b<T extends f> {
    public static final b drW = new b() {
        /* class com.tencent.mm.e.b.AnonymousClass1 */

        @Override // com.tencent.mm.e.b
        public final a XS() {
            return a.DEFAULT;
        }

        @Override // com.tencent.mm.e.b
        public final void XT() {
        }

        @Override // com.tencent.mm.e.b
        public final void onDraw(Canvas canvas) {
        }
    };
    public boolean dbG;
    private boolean dbi;
    public com.tencent.mm.bt.b drS;
    private Matrix drT;
    Rect drU;
    public Bitmap drV;
    private Canvas drX = new Canvas();
    private Runnable drY;
    PointF drZ = new PointF();
    private PointF dsa = new PointF();
    protected a dsb;
    float[] values = new float[9];

    public interface a {
        boolean q(MotionEvent motionEvent);
    }

    public abstract a XS();

    public abstract void XT();

    public abstract void onDraw(Canvas canvas);

    public void d(Canvas canvas) {
        if (this.drV != null && !this.drV.isRecycled()) {
            canvas.drawBitmap(this.drV, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void a(com.tencent.mm.bt.b bVar, Matrix matrix, Rect rect) {
        Log.i("MicroMsg.BaseArtist" + XS(), "[onCreate]");
        this.dbG = true;
        this.drS = bVar;
        this.drT = matrix;
        this.drU = rect;
    }

    public void onAlive() {
        Log.i("MicroMsg.BaseArtist" + XS(), "[onAlive] isAlive:%s", Boolean.valueOf(this.dbi));
        if (!this.dbi) {
            this.dbi = true;
            T XU = XU();
            if (XU != null) {
                XU.alC();
                XU.dl(false);
            } else {
                Log.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", XS());
            }
            this.drV = XY();
        }
    }

    public void XV() {
        Log.i("MicroMsg.BaseArtist" + XS(), "[onSelected] ");
    }

    public final void onFinish() {
        Log.i("MicroMsg.BaseArtist", "[onFinish] type:%s", XS());
        this.dbi = false;
        this.dbG = false;
        T XU = XU();
        if (XU != null) {
            XU.dl(true);
        } else {
            Log.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", XS());
        }
        XW();
    }

    public void onDestroy() {
        this.dbG = false;
        this.dbi = false;
        Log.i("MicroMsg.BaseArtist" + XS(), "[onDestroy]");
        XW();
    }

    public final void XW() {
        if (this.drV != null && !this.drV.isRecycled()) {
            this.drV.recycle();
        }
    }

    public boolean XX() {
        try {
            return XU().ai(true) > 0;
        } catch (Exception e2) {
            return false;
        }
    }

    public void cT(boolean z) {
        this.drX.setBitmap(XY());
        T XU = XU();
        if (XU != null) {
            XU.a(this.drX, z);
        } else {
            Log.i("MicroMsg.BaseArtist", "updateCache: cache is null");
        }
    }

    /* access modifiers changed from: protected */
    public final Bitmap XY() {
        int i2;
        int i3;
        if (this.drV == null || this.drV.isRecycled()) {
            Rect imageBitmapRect = this.drS.gth().getBaseBoardView().getImageBitmapRect();
            if (imageBitmapRect.isEmpty() || !this.drS.gth().getBaseBoardView().hgb()) {
                i3 = this.drS.gth().getBaseBoardView().getBoardRect().width();
                i2 = this.drS.gth().getBaseBoardView().getBoardRect().height();
            } else {
                i3 = imageBitmapRect.width();
                i2 = imageBitmapRect.height();
            }
            if (i3 <= 0 || i2 <= 0) {
                return null;
            }
            this.drV = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_4444);
        }
        return this.drV;
    }

    /* access modifiers changed from: protected */
    public final void t(Bitmap bitmap) {
        if (XY() != null && !XY().isRecycled()) {
            XY().recycle();
        }
        this.drV = bitmap;
    }

    public final boolean isAlive() {
        return this.dbG && this.dbi;
    }

    public final com.tencent.mm.bt.b getPresenter() {
        return this.drS;
    }

    public final void Ya() {
        if (XU().pop() != null) {
            XU().Ya();
        }
        this.drS.gth().removeCallbacks(this.drY);
        com.tencent.mm.view.a gth = this.drS.gth();
        AnonymousClass2 r1 = new Runnable() {
            /* class com.tencent.mm.e.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(9118);
                b.this.XT();
                b.this.Yb();
                b.this.drY = null;
                AppMethodBeat.o(9118);
            }
        };
        this.drY = r1;
        gth.postDelayed(r1, 66);
    }

    public boolean q(MotionEvent motionEvent) {
        if (!u(motionEvent)) {
            return false;
        }
        t(motionEvent);
        return false;
    }

    public final float getScale() {
        float a2 = a(this.drT, 3);
        float a3 = a(this.drT, 0);
        return (float) Math.sqrt((double) ((a2 * a2) + (a3 * a3)));
    }

    public final float getRotation() {
        return (float) Math.round(Math.atan2((double) a(this.drT, 1), (double) a(this.drT, 0)) * 57.29577951308232d);
    }

    public final float b(Matrix matrix) {
        return (float) Math.round(Math.atan2((double) a(matrix, 1), (double) a(matrix, 0)) * 57.29577951308232d);
    }

    private float a(Matrix matrix, int i2) {
        matrix.getValues(this.values);
        return this.values[i2];
    }

    /* access modifiers changed from: protected */
    public final float[] v(float f2, float f3) {
        Matrix matrix = new Matrix(this.drT);
        this.drT.invert(matrix);
        float[] fArr = {f2, f3};
        matrix.mapPoints(fArr);
        return fArr;
    }

    /* access modifiers changed from: protected */
    public final float[] w(float f2, float f3) {
        float[] fArr = {f2, f3};
        this.drT.mapPoints(fArr);
        return fArr;
    }

    protected static int r(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1) {
            return 0;
        }
        int x = (int) (motionEvent.getX(0) - motionEvent.getX(1));
        int y = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        return (int) Math.sqrt((double) ((y * y) + (x * x)));
    }

    protected static int[] s(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        if (motionEvent.getPointerCount() > 1) {
            iArr[0] = (int) (motionEvent.getX(0) - motionEvent.getX(1));
            iArr[1] = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public final void t(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            this.dsa.x = motionEvent.getX(1);
            this.dsa.y = motionEvent.getY(1);
        } else if (motionEvent.getPointerCount() == 1) {
            this.drZ.x = motionEvent.getX(0);
            this.drZ.y = motionEvent.getY(0);
        }
        if (motionEvent.getActionMasked() != 6) {
            return;
        }
        if (motionEvent.getPointerCount() <= 1 || 1 - motionEvent.getActionIndex() < 0 || 1 - motionEvent.getActionIndex() >= motionEvent.getPointerCount()) {
            this.drZ.x = motionEvent.getX(0);
            this.drZ.y = motionEvent.getY(0);
            return;
        }
        this.drZ.x = motionEvent.getX(1 - motionEvent.getActionIndex());
        this.drZ.y = motionEvent.getY(1 - motionEvent.getActionIndex());
    }

    /* access modifiers changed from: protected */
    public final boolean u(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return Math.abs(this.drZ.x - motionEvent.getX(0)) > 3.0f || Math.abs(this.drZ.y - motionEvent.getY(0)) > 3.0f || Math.abs(this.dsa.x - motionEvent.getX(1)) > 3.0f || Math.abs(this.dsa.y - motionEvent.getY(1)) > 3.0f;
        }
        if (motionEvent.getPointerCount() == 1) {
            return Math.abs(this.drZ.x - motionEvent.getX(0)) > 3.0f || Math.abs(this.drZ.y - motionEvent.getY(0)) > 3.0f;
        }
        return false;
    }

    public final void a(a aVar) {
        this.dsb = aVar;
    }

    public T XU() {
        return (T) this.drS.a(XS());
    }

    public final void setOneFingerMoveEnable(boolean z) {
        this.drS.gth().getBaseBoardView().setOneFingerMoveEnable(z);
    }

    /* access modifiers changed from: protected */
    public final boolean XZ() {
        return this.drS.gti().XS() == XS();
    }

    /* access modifiers changed from: protected */
    public final Rect getBoardRect() {
        return this.drS.gth().getBaseBoardView().getBoardRect();
    }

    public final Matrix getMainMatrix() {
        return this.drS.gth().getBaseBoardView().getMainMatrix();
    }

    public final void Yb() {
        this.drS.gth().getBaseBoardView().postInvalidate();
    }

    public final void Yc() {
        this.drS.gth().getBaseFooterView().postInvalidate();
    }
}

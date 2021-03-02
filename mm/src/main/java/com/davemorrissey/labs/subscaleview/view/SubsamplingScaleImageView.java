package com.davemorrissey.labs.subscaleview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.davemorrissey.labs.subscaleview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SubsamplingScaleImageView extends View {
    private static final List<Integer> aXb = Arrays.asList(0, 90, Integer.valueOf((int) TXLiveConstants.RENDER_ROTATION_180), 270, -1);
    private static final List<Integer> aXc = Arrays.asList(1, 2, 3);
    private static final List<Integer> aXd = Arrays.asList(2, 1);
    private static final List<Integer> aXe = Arrays.asList(1, 2, 3);
    private static final List<Integer> aXf = Arrays.asList(2, 1, 3, 4);
    public static int aXy = Integer.MAX_VALUE;
    private static Bitmap.Config aYI = Bitmap.Config.ARGB_8888;
    private static com.davemorrissey.labs.subscaleview.c.a aYJ = new com.davemorrissey.labs.subscaleview.b.a();
    private static com.davemorrissey.labs.subscaleview.c.d aYK = new com.davemorrissey.labs.subscaleview.b.c();
    private static com.davemorrissey.labs.subscaleview.c.c aYL = new com.davemorrissey.labs.subscaleview.b.b();
    public final String TAG = (SubsamplingScaleImageView.class.getSimpleName() + hashCode());
    private final ReadWriteLock aWE = new ReentrantReadWriteLock(true);
    private com.davemorrissey.labs.subscaleview.a.d aWL;
    public int aWX;
    public int aWY;
    private Rect aWZ;
    private int aXA = aXy;
    private boolean aXB = true;
    private boolean aXC = true;
    private boolean aXD = true;
    private boolean aXE = true;
    private float aXF = 2.0f;
    private int aXG = 1;
    public int aXH = 200;
    private int aXI = 200;
    private GestureDetector.OnDoubleTapListener aXJ = null;
    private boolean aXK = true;
    private boolean aXL = false;
    private MotionEvent aXM = null;
    private float aXN;
    public PointF aXO;
    private PointF aXP;
    private PointF aXQ;
    private float[] aXR = new float[9];
    private float aXS = 0.0f;
    private Float aXT;
    private PointF aXU;
    private PointF aXV;
    private boolean aXW;
    private a aXX;
    private a aXY;
    private int aXZ;
    private boolean aXg;
    private boolean aXh;
    private boolean aXi;
    private boolean aXj;
    private int aXk;
    private boolean aXl = true;
    private long aXm = -1;
    private long aXn = -1;
    private Bitmap aXo;
    private boolean aXp = false;
    private boolean aXq = false;
    private Map<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> aXr;
    private boolean aXs = false;
    private float aXt = 2.0f;
    private float aXu = rZ();
    private int aXv = -1;
    private int aXw = 1;
    private int aXx = 3;
    private int aXz = aXy;
    private Paint aYA;
    private Paint aYB;
    private Paint aYC;
    private g aYD;
    private RectF aYE;
    private float[] aYF = new float[8];
    private float[] aYG = new float[8];
    private Matrix aYH;
    private LinkedList<com.davemorrissey.labs.subscaleview.c.b> aYM = new LinkedList<>();
    private int aYN;
    private int aYO;
    private float aYP;
    private float aYQ;
    public float aYR;
    private float aYS;
    private float aYT;
    private float aYU = 1.0f;
    private float aYV = 20.0f;
    private boolean aYW = true;
    private boolean aYX = false;
    private PointF aYY;
    private View.OnAttachStateChangeListener aYZ;
    private int aYa = 0;
    private Rect aYb;
    private boolean aYc;
    private boolean aYd;
    private boolean aYe;
    private int aYf;
    private GestureDetector aYg;
    private GestureDetector.SimpleOnGestureListener aYh;
    private GestureDetector aYi;
    private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aYj = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aYk = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    private PointF aYl;
    private float aYm;
    private final float aYn;
    private float aYo;
    private boolean aYp;
    private PointF aYq;
    private PointF aYr;
    private PointF aYs;
    private a aYt;
    private boolean aYu;
    private boolean aYv;
    private e aYw;
    private f aYx;
    private View.OnLongClickListener aYy;
    private Paint aYz;
    public View.OnTouchListener aZa;
    private com.davemorrissey.labs.subscaleview.d.a aZb = new com.davemorrissey.labs.subscaleview.d.a();
    private c aZc = new c() {
        /* class com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.AnonymousClass1 */
    };
    private boolean aZd = false;
    private boolean aZe = false;
    private boolean aZf = false;
    private float aZg;
    private float aZh;
    private Bitmap bitmap;
    private boolean cancelled = false;
    private float density = getResources().getDisplayMetrics().density;
    public Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
    private Matrix gT;
    private Handler handler;
    private int orientation = -1;
    private int previewHeight;
    private int previewWidth;
    public float scale;
    private Uri uri;

    public interface c {
    }

    public interface d {
    }

    public interface e {
        void a(com.davemorrissey.labs.subscaleview.a.c cVar);

        void b(com.davemorrissey.labs.subscaleview.a.c cVar);

        void c(com.davemorrissey.labs.subscaleview.a.c cVar);

        void n(Bitmap bitmap);

        void sb();

        void sc();
    }

    public interface f {
        void r(float f2, float f3);
    }

    static /* synthetic */ float a(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, PointF pointF2) {
        AppMethodBeat.i(208729);
        float a2 = subsamplingScaleImageView.a(pointF, pointF2);
        AppMethodBeat.o(208729);
        return a2;
    }

    static /* synthetic */ void a(SubsamplingScaleImageView subsamplingScaleImageView, Context context) {
        AppMethodBeat.i(208728);
        subsamplingScaleImageView.setGestureDetector(context);
        AppMethodBeat.o(208728);
    }

    static /* synthetic */ void a(SubsamplingScaleImageView subsamplingScaleImageView, View.OnLongClickListener onLongClickListener) {
        AppMethodBeat.i(157466);
        super.setOnLongClickListener(onLongClickListener);
        AppMethodBeat.o(157466);
    }

    static /* synthetic */ void a(SubsamplingScaleImageView subsamplingScaleImageView, g gVar) {
        AppMethodBeat.i(208732);
        subsamplingScaleImageView.a(true, gVar);
        AppMethodBeat.o(208732);
    }

    static /* synthetic */ float b(SubsamplingScaleImageView subsamplingScaleImageView, float f2) {
        AppMethodBeat.i(208730);
        float aa = subsamplingScaleImageView.aa(f2);
        AppMethodBeat.o(208730);
        return aa;
    }

    static /* synthetic */ void d(SubsamplingScaleImageView subsamplingScaleImageView) {
        AppMethodBeat.i(157467);
        super.setOnLongClickListener(null);
        AppMethodBeat.o(157467);
    }

    static {
        AppMethodBeat.i(157473);
        AppMethodBeat.o(157473);
    }

    public final synchronized void dx(int i2) {
        AppMethodBeat.i(157388);
        if (this.aZb != null) {
            com.davemorrissey.labs.subscaleview.d.a aVar = this.aZb;
            aVar.aWT += i2;
            Log.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileInitTime: %d, total: %d", Integer.valueOf(i2), Integer.valueOf(aVar.aWT));
        }
        AppMethodBeat.o(157388);
    }

    public final synchronized void dy(int i2) {
        AppMethodBeat.i(157389);
        if (this.aZb != null) {
            com.davemorrissey.labs.subscaleview.d.a aVar = this.aZb;
            aVar.aWS += i2;
            Log.d("MicroMsg.ImageDecodeRecord", "alvinluo addPreviewLoadedTime: %d, total: %d", Integer.valueOf(i2), Integer.valueOf(aVar.aWS));
        }
        AppMethodBeat.o(157389);
    }

    public final synchronized void dz(int i2) {
        AppMethodBeat.i(157390);
        if (this.aZb != null) {
            com.davemorrissey.labs.subscaleview.d.a aVar = this.aZb;
            aVar.aWU += i2;
            Log.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileDecodeTime: %d, total: %d", Integer.valueOf(i2), Integer.valueOf(aVar.aWU));
        }
        AppMethodBeat.o(157390);
    }

    public synchronized com.davemorrissey.labs.subscaleview.d.a getImageDecodeRecord() {
        return this.aZb;
    }

    public void setEdgeSwipeListener(c cVar) {
        this.aZc = cVar;
    }

    public void setOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        this.aYZ = onAttachStateChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(157391);
        super.onAttachedToWindow();
        if (this.aYZ != null) {
            this.aYZ.onViewAttachedToWindow(this);
        }
        this.cancelled = false;
        AppMethodBeat.o(157391);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(157392);
        super.onDetachedFromWindow();
        if (!this.cancelled) {
            this.cancelled = true;
            Log.i(this.TAG, "alvinluo cancelAllTileLoadTask, task size: %d", Integer.valueOf(this.aYM.size()));
            Iterator<com.davemorrissey.labs.subscaleview.c.b> it = this.aYM.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.aYM.clear();
        }
        if (this.aYZ != null) {
            this.aYZ.onViewDetachedFromWindow(this);
        }
        AppMethodBeat.o(157392);
    }

    private void a(com.davemorrissey.labs.subscaleview.c.e eVar) {
        AppMethodBeat.i(157393);
        if (this.cancelled) {
            Log.i(this.TAG, "alvinluo newLoadTask, has cancelled and ignore");
            AppMethodBeat.o(157393);
            return;
        }
        com.davemorrissey.labs.subscaleview.c.b a2 = aYK.a(this, this.aWL, eVar);
        a2.rJ();
        this.aYM.add(a2);
        AppMethodBeat.o(157393);
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        AppMethodBeat.i(157394);
        setDoubleTapZoomScale(2.0f);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.aYH = new Matrix();
        this.handler = new Handler(new Handler.Callback() {
            /* class com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.AnonymousClass2 */

            public final boolean handleMessage(Message message) {
                AppMethodBeat.i(157375);
                if (message.what == 1 && SubsamplingScaleImageView.this.aYy != null) {
                    SubsamplingScaleImageView.this.aYf = 0;
                    SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.aYy);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.d(SubsamplingScaleImageView.this);
                }
                AppMethodBeat.o(157375);
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0081a.SubsamplingScaleImageView);
            if (obtainStyledAttributes.hasValue(0) && (string = obtainStyledAttributes.getString(0)) != null && string.length() > 0) {
                if (string == null) {
                    NullPointerException nullPointerException = new NullPointerException("Asset name must not be null");
                    AppMethodBeat.o(157394);
                    throw nullPointerException;
                }
                setImage(a.aP("assets:///".concat(String.valueOf(string))).rM());
            }
            if (obtainStyledAttributes.hasValue(3) && (resourceId = obtainStyledAttributes.getResourceId(3, 0)) > 0) {
                setImage(new a(resourceId).rM());
            }
            if (obtainStyledAttributes.hasValue(1)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(1, true));
            }
            if (obtainStyledAttributes.hasValue(5)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(5, true));
            }
            if (obtainStyledAttributes.hasValue(2)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(2, true));
            }
            if (obtainStyledAttributes.hasValue(4)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(4, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.aYn = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
        float f2 = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
        if (f2 > 1.0f) {
            this.aYU = f2;
        }
        AppMethodBeat.o(157394);
    }

    public ReadWriteLock getDecoderLock() {
        return this.aWE;
    }

    public int getFullImageSampleSize() {
        return this.aXk;
    }

    public Bitmap getFullImageBitmap() {
        return this.aXo;
    }

    public PointF getImageViewMatrixScale() {
        AppMethodBeat.i(208721);
        if (Float.isNaN(this.scale) || Float.isInfinite(this.scale)) {
            PointF pointF = new PointF(1.0f, 1.0f);
            AppMethodBeat.o(208721);
            return pointF;
        }
        PointF pointF2 = new PointF(this.scale, this.scale);
        AppMethodBeat.o(208721);
        return pointF2;
    }

    public PointF getImageViewMatrixTranslation() {
        AppMethodBeat.i(208722);
        if (this.aXO != null) {
            PointF pointF = new PointF(this.aXO.x, this.aXO.y);
            AppMethodBeat.o(208722);
            return pointF;
        }
        AppMethodBeat.o(208722);
        return null;
    }

    public void setPreviewDone(boolean z) {
        AppMethodBeat.i(157395);
        this.aYW = z;
        invalidate();
        AppMethodBeat.o(157395);
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return aYI;
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        aYI = config;
    }

    public final void setOrientation(int i2) {
        AppMethodBeat.i(157396);
        if (!aXb.contains(Integer.valueOf(i2))) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid orientation: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(157396);
            throw illegalArgumentException;
        }
        this.orientation = i2;
        reset(false);
        invalidate();
        requestLayout();
        AppMethodBeat.o(157396);
    }

    public Rect getsRegion() {
        return this.aWZ;
    }

    public void setsRegion(Rect rect) {
        this.aWZ = rect;
    }

    public void setScaleRate(float f2) {
        AppMethodBeat.i(157397);
        this.aYR = f2;
        this.aXt = 2.0f;
        this.aXu = 1.0f;
        rP();
        rQ();
        AppMethodBeat.o(157397);
    }

    private void rN() {
        AppMethodBeat.i(157398);
        Log.i(this.TAG, "alvinluo initScaleRate: %f", Float.valueOf(this.aYR));
        rP();
        rQ();
        AppMethodBeat.o(157398);
    }

    private void rO() {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(208723);
        if (this.bitmap == null) {
            AppMethodBeat.o(208723);
        } else if (!this.aXg) {
            AppMethodBeat.o(208723);
        } else {
            int rX = rX();
            int rY = rY();
            this.aXq = ((float) rX) > ((float) rY) * 2.2f;
            if (((float) rY) > ((float) rX) * 2.2f) {
                z = true;
            } else {
                z = false;
            }
            this.aXp = z;
            if (!this.aXq || rX <= this.aYN) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.aXq = z2;
            if (!this.aXp || rY <= this.aYO) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.aXp = z3;
            rN();
            if (this.aXp) {
                this.aYS = (((float) this.aYN) * 1.0f) / ((float) rV());
                this.aYT = (((float) this.aYO) * 1.0f) / ((float) rW());
            } else if (this.aXq) {
                this.aYS = (((float) this.aYN) * 1.0f) / ((float) rV());
                this.aYT = (this.aYR * ((float) rY())) / ((float) rW());
            } else {
                this.aYS = (this.aYR * ((float) rX())) / ((float) rV());
                this.aYT = (this.aYR * ((float) rY())) / ((float) rW());
            }
            Log.i(this.TAG, "alvinluo initPreviewScaleRate previewWidthScale: %f, previewHeightScale: %f, previewHeight: %d, previewWidth: %d, verticalLong: %b, horizontalLong: %b, %s", Float.valueOf(this.aYS), Float.valueOf(this.aYT), Integer.valueOf(rW()), Integer.valueOf(rV()), Boolean.valueOf(this.aXp), Boolean.valueOf(this.aXq), this.aXX.getUri().toString());
            AppMethodBeat.o(208723);
        }
    }

    private void rP() {
        AppMethodBeat.i(157399);
        this.aXt = getDoubleTapZoomScale() * 2.0f * this.aYU;
        AppMethodBeat.o(157399);
    }

    private void rQ() {
        AppMethodBeat.i(157400);
        this.aXu = Math.min(rZ(), this.aYR * 0.75f);
        AppMethodBeat.o(157400);
    }

    public void setImageViewMatrix(Matrix matrix) {
        AppMethodBeat.i(208724);
        if (this.aXO == null) {
            this.aXO = new PointF();
        }
        matrix.getValues(this.aXR);
        this.aXO.set(this.aXR[2], this.aXR[5]);
        float f2 = this.scale;
        this.scale = this.aXR[0];
        if (this.aYx != null) {
            this.aYx.r(this.scale, f2);
        }
        aK(false);
        invalidate();
        AppMethodBeat.o(208724);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.aXJ = onDoubleTapListener;
    }

    public void setAllowInterceptTouchEvent(boolean z) {
        this.aXK = z;
    }

    public final void setImage(a aVar) {
        AppMethodBeat.i(157402);
        a(aVar, (a) null);
        AppMethodBeat.o(157402);
    }

    public static void setBitmapLoaderImp(com.davemorrissey.labs.subscaleview.c.a aVar) {
        aYJ = aVar;
    }

    public static void setTileInitLoaderImp(com.davemorrissey.labs.subscaleview.c.c cVar) {
        aYL = cVar;
    }

    public static void setTileLoaderImp(com.davemorrissey.labs.subscaleview.c.d dVar) {
        aYK = dVar;
    }

    public final void a(a aVar, a aVar2) {
        AppMethodBeat.i(157403);
        if (aVar == null) {
            NullPointerException nullPointerException = new NullPointerException("imageSource must not be null");
            AppMethodBeat.o(157403);
            throw nullPointerException;
        }
        this.aXX = aVar;
        this.aXY = aVar2;
        reset(true);
        if (aVar.getUri() != null) {
            this.aXZ = e(getContext(), aVar.getUri());
        }
        if (aVar2 != null) {
            if (aVar.aWX <= 0 || aVar.aWY <= 0) {
                Log.e(this.TAG, "alvinluo Preview image cannot be used unless dimensions are provided for the main image");
            } else {
                this.aWX = aVar.aWX;
                this.aWY = aVar.aWY;
                this.aYb = aVar2.aWZ;
                if (aVar2.bitmap != null) {
                    this.aXj = aVar2.aXa;
                    a(aVar2.bitmap, (Integer) 0);
                } else {
                    Uri uri2 = aVar2.getUri();
                    if (uri2 == null && aVar2.aWV != null) {
                        uri2 = Uri.parse("android.resource://" + getContext().getPackageName() + FilePathGenerator.ANDROID_DIR_SEP + aVar2.aWV);
                    }
                    aYJ.a(this, getContext(), this.aYj, uri2, true).rJ();
                }
            }
        }
        if (aVar.bitmap != null && aVar.aWZ != null) {
            b(Bitmap.createBitmap(aVar.bitmap, aVar.aWZ.left, aVar.aWZ.top, aVar.aWZ.width(), aVar.aWZ.height()), 0, false);
            AppMethodBeat.o(157403);
        } else if (aVar.bitmap != null) {
            b(aVar.bitmap, 0, aVar.aXa);
            AppMethodBeat.o(157403);
        } else {
            this.aWZ = aVar.aWZ;
            this.uri = aVar.getUri();
            if (this.uri == null && aVar.aWV != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + FilePathGenerator.ANDROID_DIR_SEP + aVar.aWV);
            }
            if (aVar.aWW || this.aWZ != null) {
                aYL.a(this, getContext(), this.aYk, this.uri).rJ();
                AppMethodBeat.o(157403);
                return;
            }
            aYJ.a(this, getContext(), this.aYj, this.uri, false).rJ();
            AppMethodBeat.o(157403);
        }
    }

    private void reset(boolean z) {
        AppMethodBeat.i(157404);
        h("reset newImage=".concat(String.valueOf(z)), new Object[0]);
        this.scale = 0.0f;
        this.aXN = 0.0f;
        this.aXO = null;
        this.aXP = null;
        this.aXQ = null;
        this.aXT = Float.valueOf(0.0f);
        this.aXU = null;
        this.aXV = null;
        this.aYc = false;
        this.aYd = false;
        this.aYe = false;
        this.aYf = 0;
        this.aXk = 0;
        this.aYl = null;
        this.aYm = 0.0f;
        this.aYo = 0.0f;
        this.aYp = false;
        this.aYr = null;
        this.aYq = null;
        this.aYs = null;
        this.aYt = null;
        this.aYD = null;
        this.gT = null;
        this.aYE = null;
        if (z) {
            if (this.aZb != null) {
                com.davemorrissey.labs.subscaleview.d.a aVar = this.aZb;
                aVar.aWU = 0;
                aVar.aWS = 0;
                aVar.aWU = 0;
            }
            this.uri = null;
            this.aWE.writeLock().lock();
            try {
                if (this.aWL != null) {
                    this.aWL.recycle();
                    this.aWL = null;
                }
                this.aWE.writeLock().unlock();
                if (this.bitmap != null && !this.aXj) {
                    this.bitmap.recycle();
                }
                if (!(this.bitmap == null || !this.aXj || this.aYw == null)) {
                    this.aYw.sc();
                }
                this.aWX = 0;
                this.aWY = 0;
                this.aXZ = 0;
                this.aWZ = null;
                this.aYb = null;
                this.aYu = false;
                this.aYv = false;
                this.bitmap = null;
                this.aXg = false;
                this.aXj = false;
                this.aXh = false;
                this.aXi = false;
                this.aXl = true;
            } catch (Throwable th) {
                this.aWE.writeLock().unlock();
                AppMethodBeat.o(157404);
                throw th;
            }
        }
        if (this.aXr != null) {
            for (Map.Entry<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> entry : this.aXr.entrySet()) {
                for (com.davemorrissey.labs.subscaleview.c.e eVar : entry.getValue()) {
                    eVar.visible = false;
                    if (eVar.bitmap != null) {
                        if (this.aXY == null || this.aXY.bitmap != eVar.bitmap) {
                            eVar.bitmap.recycle();
                            eVar.bitmap = null;
                        } else {
                            Log.i(this.TAG, "alvinluo reset tile bitmap not need to recycle: %d", Integer.valueOf(eVar.bitmap.hashCode()));
                        }
                    }
                }
            }
            this.aXr = null;
        }
        setGestureDetector(getContext());
        AppMethodBeat.o(157404);
    }

    public e getOnImageEventListener() {
        return this.aYw;
    }

    public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.aYh = simpleOnGestureListener;
    }

    private void setGestureDetector(final Context context) {
        AppMethodBeat.i(157405);
        this.aYg = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            /* class com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.AnonymousClass3 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(208716);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(208716);
                return onContextClick;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(208715);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(208715);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(208714);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(208714);
                return onSingleTapUp;
            }

            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                AppMethodBeat.i(157376);
                if (!SubsamplingScaleImageView.this.aXC || !SubsamplingScaleImageView.this.aYu || SubsamplingScaleImageView.this.aXO == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f2) <= 500.0f && Math.abs(f3) <= 500.0f) || SubsamplingScaleImageView.this.aYc))) {
                    boolean onFling = super.onFling(motionEvent, motionEvent2, f2, f3);
                    AppMethodBeat.o(157376);
                    return onFling;
                }
                PointF pointF = new PointF(SubsamplingScaleImageView.this.aXO.x + (f2 * 0.25f), SubsamplingScaleImageView.this.aXO.y + (0.25f * f3));
                b bVar = new b(SubsamplingScaleImageView.this, new PointF((((float) (SubsamplingScaleImageView.this.getWidth() / 2)) - pointF.x) / SubsamplingScaleImageView.this.scale, (((float) (SubsamplingScaleImageView.this.getHeight() / 2)) - pointF.y) / SubsamplingScaleImageView.this.scale), (byte) 0);
                if (!SubsamplingScaleImageView.aXd.contains(1)) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown easing type: 1");
                    AppMethodBeat.o(157376);
                    throw illegalArgumentException;
                }
                bVar.aZv = 1;
                bVar.aZB = false;
                bVar.aZw = 3;
                bVar.start();
                AppMethodBeat.o(157376);
                return true;
            }

            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                boolean onSingleTapConfirmed;
                AppMethodBeat.i(157377);
                if (SubsamplingScaleImageView.this.aXJ != null && SubsamplingScaleImageView.this.aXJ.onSingleTapConfirmed(motionEvent)) {
                    AppMethodBeat.o(157377);
                    return true;
                } else if (SubsamplingScaleImageView.this.aYh == null || !(onSingleTapConfirmed = SubsamplingScaleImageView.this.aYh.onSingleTapConfirmed(motionEvent))) {
                    SubsamplingScaleImageView.this.performClick();
                    AppMethodBeat.o(157377);
                    return true;
                } else {
                    AppMethodBeat.o(157377);
                    return onSingleTapConfirmed;
                }
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(157378);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                if (SubsamplingScaleImageView.this.aXJ != null && SubsamplingScaleImageView.this.aXJ.onDoubleTap(motionEvent)) {
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(157378);
                    return true;
                } else if (!SubsamplingScaleImageView.this.aXD || !SubsamplingScaleImageView.this.aYu || SubsamplingScaleImageView.this.aXO == null) {
                    boolean onDoubleTapEvent = super.onDoubleTapEvent(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.a(onDoubleTapEvent, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(157378);
                    return onDoubleTapEvent;
                } else {
                    SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, context);
                    Log.i(SubsamplingScaleImageView.this.TAG, "alvinluo onDoubleTap, quickScaledEnabled: %b", Boolean.valueOf(SubsamplingScaleImageView.this.aXE));
                    if (SubsamplingScaleImageView.this.aXE) {
                        SubsamplingScaleImageView.this.aYl = new PointF(motionEvent.getX(), motionEvent.getY());
                        SubsamplingScaleImageView.this.aXP = new PointF(SubsamplingScaleImageView.this.aXO.x, SubsamplingScaleImageView.this.aXO.y);
                        SubsamplingScaleImageView.this.aXN = SubsamplingScaleImageView.this.scale;
                        SubsamplingScaleImageView.this.aYe = true;
                        SubsamplingScaleImageView.this.aYc = true;
                        SubsamplingScaleImageView.this.aYo = -1.0f;
                        SubsamplingScaleImageView.this.aYr = SubsamplingScaleImageView.this.a(SubsamplingScaleImageView.this.aYl);
                        SubsamplingScaleImageView.this.aYs = new PointF(motionEvent.getX(), motionEvent.getY());
                        SubsamplingScaleImageView.this.aYq = new PointF(SubsamplingScaleImageView.this.aYr.x, SubsamplingScaleImageView.this.aYr.y);
                        SubsamplingScaleImageView.this.aYp = false;
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                        AppMethodBeat.o(157378);
                        return false;
                    }
                    SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.a(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(157378);
                    return true;
                }
            }
        });
        this.aYi = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            /* class com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.AnonymousClass4 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(208720);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(208720);
                return onContextClick;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(208719);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(208719);
                return onDoubleTap;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(208718);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(208718);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(208717);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(208717);
                return onSingleTapUp;
            }

            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                AppMethodBeat.i(157379);
                SubsamplingScaleImageView.this.performClick();
                AppMethodBeat.o(157379);
                return true;
            }
        });
        AppMethodBeat.o(157405);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(157406);
        h("onSizeChanged %dx%d -> %dx%d scale: %f, pendingScale: %f, needPendingScale: %b", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(this.scale), this.aXT, Boolean.valueOf(this.aXW));
        rN();
        PointF center = getCenter();
        if ((this.aYu || this.aXW) && center != null) {
            this.aYt = null;
            if (!this.aXW) {
                this.aXT = Float.valueOf(this.scale);
                this.aXU = center;
            }
        }
        AppMethodBeat.o(157406);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z;
        int i4;
        AppMethodBeat.i(157407);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z2 = mode != 1073741824;
        if (mode2 != 1073741824) {
            z = true;
        } else {
            z = false;
        }
        if (this.aWX > 0 && this.aWY > 0) {
            if (!z2 || !z) {
                if (z) {
                    i4 = (int) ((((double) rY()) / ((double) rX())) * ((double) size));
                } else if (z2) {
                    size = (int) ((((double) rX()) / ((double) rY())) * ((double) size2));
                    i4 = size2;
                }
                int max = Math.max(size, getSuggestedMinimumWidth());
                int max2 = Math.max(i4, getSuggestedMinimumHeight());
                setMeasuredDimension(max, max2);
                this.aYN = max;
                this.aYO = max2;
                Log.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", Integer.valueOf(this.aYN), Integer.valueOf(this.aYN));
                AppMethodBeat.o(157407);
            }
            int rX = rX();
            i4 = rY();
            size = rX;
            int max3 = Math.max(size, getSuggestedMinimumWidth());
            int max22 = Math.max(i4, getSuggestedMinimumHeight());
            setMeasuredDimension(max3, max22);
            this.aYN = max3;
            this.aYO = max22;
            Log.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", Integer.valueOf(this.aYN), Integer.valueOf(this.aYN));
            AppMethodBeat.o(157407);
        }
        i4 = size2;
        int max32 = Math.max(size, getSuggestedMinimumWidth());
        int max222 = Math.max(i4, getSuggestedMinimumHeight());
        setMeasuredDimension(max32, max222);
        this.aYN = max32;
        this.aYO = max222;
        Log.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", Integer.valueOf(this.aYN), Integer.valueOf(this.aYN));
        AppMethodBeat.o(157407);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(157408);
        Log.d(this.TAG, "alvinluo SubsamplingScaleImageView dispatchTouchEvent");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(157408);
        return dispatchTouchEvent;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x019e, code lost:
        if (com.tencent.mm.hellhoundlib.a.a.a(r2, r2.onTouchEvent((android.view.MotionEvent) r10.pG(0)), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z") != false) goto L_0x01a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
        // Method dump skipped, instructions count: 2836
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void requestDisallowInterceptTouchEvent(boolean z) {
        AppMethodBeat.i(157410);
        ViewParent parent = getParent();
        if (parent != null) {
            Log.i(this.TAG, "alvinluo requestDisallowInterceptTouchEvent disallow: %b, allowInterceptTouch: %s", Boolean.valueOf(z), Boolean.valueOf(this.aXK));
            if (!this.aXK) {
                this.aXL = true;
                parent.requestDisallowInterceptTouchEvent(false);
                AppMethodBeat.o(157410);
                return;
            }
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.o(157410);
    }

    private float getDoubleTapZoomScale() {
        float f2;
        float f3 = this.aYR;
        if (this.aYP * 0.7f > f3) {
            f2 = this.aYP;
        } else if (this.aYQ * 0.7f > f3) {
            f2 = this.aYQ;
        } else {
            f2 = this.aYR * this.aXF;
        }
        if (((double) f2) < 1.0d) {
            f2 = 1.0f;
        }
        if (f2 > this.aXt) {
            return this.aXt;
        }
        return f2;
    }

    public final float a(PointF pointF, PointF pointF2) {
        boolean z;
        AppMethodBeat.i(208725);
        if (!this.aXC) {
            if (this.aXV != null) {
                pointF.x = this.aXV.x;
                pointF.y = this.aXV.y;
            } else {
                pointF.x = (float) (rX() / 2);
                pointF.y = (float) (rY() / 2);
            }
        }
        float doubleTapZoomScale = getDoubleTapZoomScale();
        Log.i(this.TAG, "alvinluo doubleTapZoom %f, scale: %s, mScaleRate: %s", Float.valueOf(doubleTapZoomScale), Float.valueOf(this.scale), Float.valueOf(this.aYR));
        if (((double) this.scale) <= ((double) doubleTapZoomScale) * 0.9d || this.scale == this.aYR) {
            z = true;
        } else {
            z = false;
        }
        float f2 = z ? doubleTapZoomScale : this.aYR;
        if (this.aXG == 3) {
            a(f2, pointF);
        } else if (this.aXG == 2 || !z || !this.aXC) {
            b bVar = new b(this, f2, pointF, (byte) 0);
            bVar.aZu = false;
            bVar.duration = (long) this.aXH;
            bVar.aZw = 4;
            bVar.start();
        } else if (this.aXG == 1) {
            b bVar2 = new b(this, doubleTapZoomScale, pointF, pointF2, (byte) 0);
            bVar2.aZu = false;
            bVar2.duration = (long) this.aXH;
            bVar2.aZw = 4;
            bVar2.start();
        }
        invalidate();
        AppMethodBeat.o(208725);
        return f2;
    }

    private void a(PointF pointF, PointF pointF2, float f2) {
        AppMethodBeat.i(157412);
        b bVar = new b(this, f2, pointF, pointF2, (byte) 0);
        bVar.aZu = false;
        bVar.duration = (long) this.aXI;
        bVar.aZw = 2;
        bVar.start();
        AppMethodBeat.o(157412);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z;
        AppMethodBeat.i(157413);
        super.onDraw(canvas);
        System.currentTimeMillis();
        if (this.aYz == null) {
            this.aYz = new Paint();
            this.aYz.setAntiAlias(true);
            this.aYz.setFilterBitmap(true);
            this.aYz.setDither(true);
        }
        if ((this.aYA == null || this.aYB == null) && this.aXs) {
            this.aYA = new Paint();
            this.aYA.setTextSize((float) px(20));
            this.aYA.setColor(-65281);
            this.aYA.setStyle(Paint.Style.FILL);
            this.aYB = new Paint();
            this.aYB.setColor(-65281);
            this.aYB.setStyle(Paint.Style.STROKE);
            this.aYB.setStrokeWidth((float) px(1));
        }
        if (this.aWX == 0 || this.aWY == 0 || getWidth() == 0 || getHeight() == 0) {
            AppMethodBeat.o(157413);
            return;
        }
        if (this.aXr == null && this.aWL != null) {
            int min = Math.min(canvas.getMaximumBitmapWidth(), this.aXz);
            int min2 = Math.min(canvas.getMaximumBitmapHeight(), this.aXA);
            if (min > 10000) {
                min = 10000;
            }
            if (min2 > 10000) {
                min2 = 10000;
            }
            Log.i(this.TAG, "alvinluo getMaxBitmapDimensions %d, %d", Integer.valueOf(min), Integer.valueOf(min2));
            a(new Point(min, min2));
        }
        if (!rS()) {
            AppMethodBeat.o(157413);
            return;
        }
        rU();
        if (!(this.aYt == null || this.aYt.aZs == null)) {
            float f2 = this.scale;
            if (this.aXQ == null) {
                this.aXQ = new PointF(0.0f, 0.0f);
            }
            this.aXQ.set(this.aXO);
            long currentTimeMillis = System.currentTimeMillis() - this.aYt.time;
            boolean z2 = currentTimeMillis > this.aYt.duration;
            long min3 = Math.min(currentTimeMillis, this.aYt.duration);
            this.scale = a(this.aYt.aZv, min3, this.aYt.aXN, this.aYt.aZo - this.aYt.aXN, this.aYt.duration);
            float a2 = a(this.aYt.aZv, min3, this.aYt.aZs.x, this.aYt.aZt.x - this.aYt.aZs.x, this.aYt.duration);
            float a3 = a(this.aYt.aZv, min3, this.aYt.aZs.y, this.aYt.aZt.y - this.aYt.aZs.y, this.aYt.duration);
            this.aXO.x -= Y(this.aYt.aZq.x) - a2;
            this.aXO.y -= Z(this.aYt.aZq.y) - a3;
            aK(z2 || this.aYt.aXN == this.aYt.aZo);
            b(f2, this.aXQ);
            aJ(z2);
            if (z2) {
                this.aYt = null;
            }
            invalidate();
        }
        if (this.aXr != null && rR() && this.aYW) {
            int min4 = Math.min(this.aXk, V(this.scale));
            boolean z3 = false;
            Iterator<Map.Entry<Integer, List<com.davemorrissey.labs.subscaleview.c.e>>> it = this.aXr.entrySet().iterator();
            while (true) {
                z = z3;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> next = it.next();
                if (next.getKey().intValue() == min4) {
                    for (com.davemorrissey.labs.subscaleview.c.e eVar : next.getValue()) {
                        if (eVar.visible && (eVar.aWP || eVar.bitmap == null)) {
                            z = true;
                        }
                    }
                }
                z3 = z;
            }
            for (Map.Entry<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> entry : this.aXr.entrySet()) {
                if (entry.getKey().intValue() == min4 || z) {
                    for (com.davemorrissey.labs.subscaleview.c.e eVar2 : entry.getValue()) {
                        Rect rect = eVar2.aWO;
                        eVar2.aWQ.set((int) Y((float) rect.left), (int) Z((float) rect.top), (int) Y((float) rect.right), (int) Z((float) rect.bottom));
                        if (!eVar2.aWP && eVar2.bitmap != null) {
                            if (this.aYC != null) {
                                canvas.drawRect(eVar2.aWQ, this.aYC);
                            }
                            if (this.gT == null) {
                                this.gT = new Matrix();
                            }
                            this.gT.reset();
                            a(this.aYF, 0.0f, 0.0f, (float) eVar2.bitmap.getWidth(), 0.0f, (float) eVar2.bitmap.getWidth(), (float) eVar2.bitmap.getHeight(), 0.0f, (float) eVar2.bitmap.getHeight());
                            if (getRequiredRotation() == 0) {
                                a(this.aYG, (float) eVar2.aWQ.left, (float) eVar2.aWQ.top, (float) eVar2.aWQ.right, (float) eVar2.aWQ.top, (float) eVar2.aWQ.right, (float) eVar2.aWQ.bottom, (float) eVar2.aWQ.left, (float) eVar2.aWQ.bottom);
                            } else if (getRequiredRotation() == 90) {
                                a(this.aYG, (float) eVar2.aWQ.right, (float) eVar2.aWQ.top, (float) eVar2.aWQ.right, (float) eVar2.aWQ.bottom, (float) eVar2.aWQ.left, (float) eVar2.aWQ.bottom, (float) eVar2.aWQ.left, (float) eVar2.aWQ.top);
                            } else if (getRequiredRotation() == 180) {
                                a(this.aYG, (float) eVar2.aWQ.right, (float) eVar2.aWQ.bottom, (float) eVar2.aWQ.left, (float) eVar2.aWQ.bottom, (float) eVar2.aWQ.left, (float) eVar2.aWQ.top, (float) eVar2.aWQ.right, (float) eVar2.aWQ.top);
                            } else if (getRequiredRotation() == 270) {
                                a(this.aYG, (float) eVar2.aWQ.left, (float) eVar2.aWQ.bottom, (float) eVar2.aWQ.left, (float) eVar2.aWQ.top, (float) eVar2.aWQ.right, (float) eVar2.aWQ.top, (float) eVar2.aWQ.right, (float) eVar2.aWQ.bottom);
                            }
                            this.gT.setPolyToPoly(this.aYF, 0, this.aYG, 0, 4);
                            if (!eVar2.bitmap.isRecycled()) {
                                canvas.drawBitmap(eVar2.bitmap, this.gT, this.aYz);
                            }
                            if (this.aXs) {
                                canvas.drawRect(eVar2.aWQ, this.aYB);
                            }
                        } else if (eVar2.aWP && this.aXs) {
                            canvas.drawText("LOADING", (float) (eVar2.aWQ.left + px(5)), (float) (eVar2.aWQ.top + px(35)), this.aYA);
                        }
                        if (eVar2.visible && this.aXs) {
                            canvas.drawText("ISS " + eVar2.sampleSize + " RECT " + eVar2.aWO.top + "," + eVar2.aWO.left + "," + eVar2.aWO.bottom + "," + eVar2.aWO.right, (float) (eVar2.aWQ.left + px(5)), (float) (eVar2.aWQ.top + px(15)), this.aYA);
                        }
                    }
                }
            }
        } else if (this.bitmap != null && !this.bitmap.isRecycled()) {
            Log.d(this.TAG, "alvinluo onDraw bitmap scale: %f", Float.valueOf(this.scale));
            if (!this.aXg || this.aXi) {
                if (this.gT == null) {
                    this.gT = new Matrix();
                }
                this.gT.reset();
                int width = this.bitmap.getWidth();
                int height = this.bitmap.getHeight();
                if (this.aYa == 90 || this.aYa == 270) {
                    width = this.bitmap.getHeight();
                    height = this.bitmap.getWidth();
                }
                if (this.aXg) {
                    rO();
                    this.gT.postScale(this.aYS, this.aYT, ((float) width) / 2.0f, ((float) height) / 2.0f);
                }
                float width2 = (float) ((this.aYN - this.bitmap.getWidth()) / 2);
                float height2 = (float) ((this.aYO - this.bitmap.getHeight()) / 2);
                this.gT.postTranslate(width2, height2);
                Log.d(this.TAG, "alvinluo onDraw offsetX: %f, offsetY: %f", Float.valueOf(width2), Float.valueOf(height2));
                if (this.aYC != null) {
                    if (this.aYE == null) {
                        this.aYE = new RectF();
                    }
                    this.aYE.set(0.0f, 0.0f, this.aXg ? (float) this.bitmap.getWidth() : (float) this.aWX, this.aXg ? (float) this.bitmap.getHeight() : (float) this.aWY);
                    this.gT.mapRect(this.aYE);
                    canvas.drawRect(this.aYE, this.aYC);
                }
                canvas.drawBitmap(this.bitmap, this.gT, this.aYz);
            }
        }
        if (this.aXs) {
            Log.d(this.TAG, "alvinluo onDraw debug vTranslate %f, %f", Float.valueOf(this.aXO.x), Float.valueOf(this.aXO.y));
            canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.scale)) + " (" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(rZ())) + " - " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.aXt)) + ")", (float) px(5), (float) px(15), this.aYA);
            canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.aXO.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.aXO.y)), (float) px(5), (float) px(30), this.aYA);
            PointF center = getCenter();
            canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.y)), (float) px(5), (float) px(45), this.aYA);
            if (this.aYt != null) {
                PointF b2 = b(this.aYt.aZp);
                PointF b3 = b(this.aYt.aZr);
                PointF b4 = b(this.aYt.aZq);
                canvas.drawCircle(b2.x, b2.y, (float) px(10), this.aYB);
                this.aYB.setColor(-65536);
                canvas.drawCircle(b3.x, b3.y, (float) px(20), this.aYB);
                this.aYB.setColor(-16776961);
                canvas.drawCircle(b4.x, b4.y, (float) px(25), this.aYB);
                this.aYB.setColor(-16711936);
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) px(30), this.aYB);
            }
            if (this.aYl != null) {
                this.aYB.setColor(-65536);
                canvas.drawCircle(this.aYl.x, this.aYl.y, (float) px(20), this.aYB);
            }
            if (this.aYr != null) {
                this.aYB.setColor(-16776961);
                canvas.drawCircle(Y(this.aYr.x), Z(this.aYr.y), (float) px(35), this.aYB);
            }
            if (this.aYs != null && this.aYe) {
                this.aYB.setColor(-12303292);
                canvas.drawCircle(this.aYs.x, this.aYs.y, (float) px(30), this.aYB);
            }
            this.aYB.setColor(-65281);
        }
        AppMethodBeat.o(157413);
    }

    private static void a(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f7;
        fArr[6] = f8;
        fArr[7] = f9;
    }

    private boolean rR() {
        boolean z = true;
        AppMethodBeat.i(157414);
        if (this.bitmap != null && !this.aXg) {
            AppMethodBeat.o(157414);
            return true;
        } else if (this.aXr != null) {
            Iterator<Map.Entry<Integer, List<com.davemorrissey.labs.subscaleview.c.e>>> it = this.aXr.entrySet().iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    Map.Entry<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> next = it.next();
                    if (next.getKey().intValue() == this.aXk) {
                        for (com.davemorrissey.labs.subscaleview.c.e eVar : next.getValue()) {
                            if (eVar.aWP || eVar.bitmap == null) {
                                z2 = false;
                            }
                        }
                    }
                    z = z2;
                } else {
                    AppMethodBeat.o(157414);
                    return z2;
                }
            }
        } else {
            AppMethodBeat.o(157414);
            return false;
        }
    }

    private boolean rS() {
        AppMethodBeat.i(157415);
        boolean z = getWidth() > 0 && getHeight() > 0 && this.aWX > 0 && this.aWY > 0 && (this.bitmap != null || rR());
        if (!this.aYu && z) {
            rU();
            this.aYu = true;
        }
        AppMethodBeat.o(157415);
        return z;
    }

    private boolean rT() {
        AppMethodBeat.i(157416);
        boolean rR = rR();
        if (!this.aYv && rR) {
            rU();
            this.aYv = true;
            Log.i(this.TAG, "alvinluo onImageLoaded");
            rN();
            a(this.aYR, new PointF(0.0f, 0.0f));
            if (this.aXm != -1) {
                this.aXn = System.currentTimeMillis();
                dz((int) (this.aXn - this.aXm));
            }
            ThreadPool.post(new Runnable() {
                /* class com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(157384);
                    if (SubsamplingScaleImageView.this.aXo != null && !SubsamplingScaleImageView.this.aXo.isRecycled()) {
                        Log.i(SubsamplingScaleImageView.this.TAG, "alvinluo rotateAndScale fullImageBitmap");
                        SubsamplingScaleImageView.this.aXo = SubsamplingScaleImageView.this.a(SubsamplingScaleImageView.this.aXo, SubsamplingScaleImageView.this.aXZ);
                    }
                    SubsamplingScaleImageView.this.post(new Runnable() {
                        /* class com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(157383);
                            if (SubsamplingScaleImageView.this.aYw != null) {
                                SubsamplingScaleImageView.this.aYw.n(SubsamplingScaleImageView.this.aXo);
                            }
                            AppMethodBeat.o(157383);
                        }
                    });
                    AppMethodBeat.o(157384);
                }
            }, "rotateAndScaleFullImageBitmap");
        }
        AppMethodBeat.o(157416);
        return rR;
    }

    private synchronized void a(Point point) {
        AppMethodBeat.i(157417);
        h("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.aYD = new g(0.0f, new PointF(0.0f, 0.0f), (byte) 0);
        a(true, this.aYD);
        this.aXk = V(this.aYD.scale);
        b(point);
        for (com.davemorrissey.labs.subscaleview.c.e eVar : this.aXr.get(Integer.valueOf(this.aXk))) {
            Log.i(this.TAG, "alvinluo tile fullSampleSize: %d", Integer.valueOf(this.aXk));
            a(eVar);
        }
        aJ(true);
        AppMethodBeat.o(157417);
    }

    private void aJ(boolean z) {
        AppMethodBeat.i(157418);
        if (this.aWL == null || this.aXr == null) {
            AppMethodBeat.o(157418);
            return;
        }
        int min = Math.min(this.aXk, V(this.scale));
        for (Map.Entry<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> entry : this.aXr.entrySet()) {
            for (com.davemorrissey.labs.subscaleview.c.e eVar : entry.getValue()) {
                if (eVar.sampleSize < min || (eVar.sampleSize > min && eVar.sampleSize != this.aXk)) {
                    eVar.visible = false;
                    if (eVar.bitmap != null) {
                        eVar.bitmap.recycle();
                        eVar.bitmap = null;
                    }
                }
                if (eVar.sampleSize == min) {
                    if (W(0.0f) <= ((float) eVar.aWO.right) && ((float) eVar.aWO.left) <= W((float) getWidth()) && X(0.0f) <= ((float) eVar.aWO.bottom) && ((float) eVar.aWO.top) <= X((float) getHeight())) {
                        eVar.visible = true;
                        if (!eVar.aWP && eVar.bitmap == null && z) {
                            a(eVar);
                        }
                    } else if (eVar.sampleSize != this.aXk) {
                        eVar.visible = false;
                        if (eVar.bitmap != null) {
                            eVar.bitmap.recycle();
                            eVar.bitmap = null;
                        }
                    }
                } else if (eVar.sampleSize == this.aXk) {
                    eVar.visible = true;
                }
            }
        }
        AppMethodBeat.o(157418);
    }

    private void rU() {
        AppMethodBeat.i(157419);
        if (getWidth() == 0 || getHeight() == 0 || this.aWX <= 0 || this.aWY <= 0) {
            AppMethodBeat.o(157419);
            return;
        }
        if (!(this.aXU == null || this.aXT == null)) {
            this.scale = this.aXT.floatValue();
            if (this.aXO == null) {
                this.aXO = new PointF();
            }
            this.aXO.x = ((float) (getWidth() / 2)) - (this.scale * this.aXU.x);
            this.aXO.y = ((float) (getHeight() / 2)) - (this.scale * this.aXU.y);
            this.aXU = null;
            this.aXT = null;
            this.aXW = false;
            aK(true);
            aJ(true);
        }
        aK(false);
        AppMethodBeat.o(157419);
    }

    private int V(float f2) {
        int i2;
        AppMethodBeat.i(157420);
        if (this.aXv > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= ((float) this.aXv) / ((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f);
        }
        int rX = (int) (((float) rX()) * f2);
        int rY = (int) (((float) rY()) * f2);
        if (rX == 0 || rY == 0) {
            AppMethodBeat.o(157420);
            return 32;
        }
        if (rY() > rY || rX() > rX) {
            i2 = Math.round(((float) rY()) / ((float) rY));
            int round = Math.round(((float) rX()) / ((float) rX));
            if (i2 >= round) {
                i2 = round;
            }
        } else {
            i2 = 1;
        }
        int i3 = 1;
        while (i3 * 2 < i2) {
            i3 *= 2;
        }
        AppMethodBeat.o(157420);
        return i3;
    }

    private void a(boolean z, g gVar) {
        float f2;
        float max;
        float max2;
        float f3 = 0.5f;
        AppMethodBeat.i(157421);
        if (this.aXw == 2 && this.aYu) {
            z = false;
        }
        PointF pointF = gVar.aXO;
        float aa = aa(gVar.scale);
        float rX = aa * ((float) rX());
        float rY = aa * ((float) rY());
        if (this.aXw == 3 && this.aYu) {
            pointF.x = Math.max(pointF.x, ((float) (getWidth() / 2)) - rX);
            pointF.y = Math.max(pointF.y, ((float) (getHeight() / 2)) - rY);
        } else if (z) {
            pointF.x = Math.max(pointF.x, ((float) getWidth()) - rX);
            pointF.y = Math.max(pointF.y, ((float) getHeight()) - rY);
        } else {
            pointF.x = Math.max(pointF.x, -rX);
            pointF.y = Math.max(pointF.y, -rY);
        }
        if (getPaddingLeft() > 0 || getPaddingRight() > 0) {
            f2 = ((float) getPaddingLeft()) / ((float) (getPaddingLeft() + getPaddingRight()));
        } else {
            f2 = 0.5f;
        }
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f3 = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
        }
        if (this.aXw == 3 && this.aYu) {
            max = (float) Math.max(0, getWidth() / 2);
            max2 = (float) Math.max(0, getHeight() / 2);
        } else if (z) {
            max = Math.max(0.0f, (((float) getWidth()) - rX) * f2);
            max2 = Math.max(0.0f, (((float) getHeight()) - rY) * f3);
        } else {
            max = (float) Math.max(0, getWidth());
            max2 = (float) Math.max(0, getHeight());
        }
        pointF.x = Math.min(pointF.x, max);
        pointF.y = Math.min(pointF.y, max2);
        gVar.scale = aa;
        AppMethodBeat.o(157421);
    }

    private void aK(boolean z) {
        boolean z2;
        AppMethodBeat.i(157422);
        if (this.aXO == null) {
            z2 = true;
            this.aXO = new PointF(0.0f, 0.0f);
        } else {
            z2 = false;
        }
        if (this.aYD == null) {
            this.aYD = new g(0.0f, new PointF(0.0f, 0.0f), (byte) 0);
        }
        this.aYD.scale = this.scale;
        this.aYD.aXO.set(this.aXO);
        a(z, this.aYD);
        this.scale = this.aYD.scale;
        this.aXO.set(this.aYD.aXO);
        if (z2 && this.aXx != 4) {
            this.aXO.set(j((float) (rX() / 2), (float) (rY() / 2), this.scale));
        }
        AppMethodBeat.o(157422);
    }

    private void b(Point point) {
        int i2;
        AppMethodBeat.i(157423);
        h("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.aXr = new LinkedHashMap();
        int i3 = this.aXk;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int rX = rX() / i4;
            int rY = rY() / i5;
            int i6 = rX / i3;
            int i7 = rY / i3;
            while (true) {
                if (i6 + i4 + 1 > point.x || (((double) i6) > ((double) getWidth()) * 1.25d && i3 < this.aXk)) {
                    i4++;
                    rX = rX() / i4;
                    i6 = rX / i3;
                }
            }
            int i8 = i7;
            while (true) {
                if (i8 + i5 + 1 > point.y || (((double) i8) > ((double) getHeight()) * 1.25d && i3 < this.aXk)) {
                    i5++;
                    int rY2 = rY() / i5;
                    i8 = rY2 / i3;
                    rY = rY2;
                }
            }
            ArrayList arrayList = new ArrayList(i4 * i5);
            int i9 = 0;
            while (i9 < i4) {
                for (int i10 = 0; i10 < i5; i10++) {
                    com.davemorrissey.labs.subscaleview.c.e eVar = new com.davemorrissey.labs.subscaleview.c.e();
                    eVar.sampleSize = i3;
                    eVar.visible = i3 == this.aXk;
                    int i11 = i9 * rX;
                    int i12 = i10 * rY;
                    int rX2 = i9 == i4 + -1 ? rX() : (i9 + 1) * rX;
                    if (i10 == i5 - 1) {
                        i2 = rY();
                    } else {
                        i2 = (i10 + 1) * rY;
                    }
                    eVar.aWO = new Rect(i11, i12, rX2, i2);
                    eVar.aWQ = new Rect(0, 0, 0, 0);
                    eVar.aWR = new Rect(eVar.aWO);
                    arrayList.add(eVar);
                }
                i9++;
            }
            this.aXr.put(Integer.valueOf(i3), arrayList);
            if (i3 != 1) {
                i3 /= 2;
            } else {
                AppMethodBeat.o(157423);
                return;
            }
        }
    }

    public final synchronized void a(com.davemorrissey.labs.subscaleview.a.d dVar, int i2, int i3, int i4) {
        AppMethodBeat.i(157424);
        h("alvinluo onTilesInited sWidth: %d, sHeight: %d, this.sWidth: %d, this.sHeight: %d, sOrientation: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.aWX), Integer.valueOf(this.aWY), Integer.valueOf(i4));
        if (this.aWX > 0 && this.aWY > 0 && !(this.aWX == i2 && this.aWY == i3)) {
            reset(false);
            if (this.bitmap != null) {
                if (!this.aXj) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                if (this.aYw != null && this.aXj) {
                    this.aYw.sc();
                }
                this.aXg = false;
                this.aXj = false;
            }
        }
        this.aWL = dVar;
        this.aWX = i2;
        this.aWY = i3;
        this.aXZ = i4;
        rS();
        if (!rT() && this.aXz > 0 && this.aXz != aXy && this.aXA > 0 && this.aXA != aXy && getWidth() > 0 && getHeight() > 0) {
            a(new Point(this.aXz, this.aXA));
        }
        invalidate();
        requestLayout();
        System.currentTimeMillis();
        AppMethodBeat.o(157424);
    }

    private void setFullImageBitmap(final Bitmap bitmap2) {
        AppMethodBeat.i(157425);
        ThreadPool.post(new Runnable() {
            /* class com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(157380);
                if (bitmap2 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SubsamplingScaleImageView.this.aXo = SubsamplingScaleImageView.this.a(bitmap2, SubsamplingScaleImageView.this.aXZ);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.i(SubsamplingScaleImageView.this.TAG, "alvinluo rotate and scale fullImageBitmap cost: %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                }
                AppMethodBeat.o(157380);
            }
        }, "rotateAndScaleBitmap");
        AppMethodBeat.o(157425);
    }

    public final synchronized void b(com.davemorrissey.labs.subscaleview.c.e eVar) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(157426);
            this.aXm = System.currentTimeMillis();
            String str = this.TAG;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(eVar.sampleSize);
            if (eVar.bitmap != null) {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            Log.d(str, "alvinluo onTileLoaded sampleSize: %d, bitmap == null: %b", objArr);
            if (eVar.sampleSize == this.aXk && eVar.bitmap != null && this.aXl) {
                Log.i(this.TAG, "alvinluo onTileLoaded set fullImageBitmap");
                this.aXl = false;
                this.aXo = eVar.bitmap;
            }
            rS();
            rT();
            if (rR() && this.bitmap != null) {
                if (!this.aXj) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                if (this.aYw != null && this.aXj) {
                    this.aYw.sc();
                }
                this.aXg = false;
                this.aXj = false;
            }
            invalidate();
            AppMethodBeat.o(157426);
        }
    }

    public final Bitmap a(Bitmap bitmap2, int i2) {
        AppMethodBeat.i(157427);
        if (bitmap2 == null) {
            Log.e(this.TAG, "alvinluo rotateAndScaleBitmap bitmap is null");
            AppMethodBeat.o(157427);
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, 1.0f);
        if (i2 != 0) {
            matrix.postRotate((float) i2);
        }
        Log.d(this.TAG, "alvinluo rotateAndScaleBitmap matrix.isIdentify: %b", Boolean.valueOf(matrix.isIdentity()));
        if (bitmap2.getWidth() <= 0 || bitmap2.getHeight() <= 0) {
            AppMethodBeat.o(157427);
            return null;
        } else if (matrix.isIdentity()) {
            AppMethodBeat.o(157427);
            return bitmap2;
        } else {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
                AppMethodBeat.o(157427);
                return createBitmap;
            } catch (OutOfMemoryError e2) {
                Log.printErrStackTrace(this.TAG, e2, "alvinluo createBitmap oom", new Object[0]);
                aYI = Bitmap.Config.RGB_565;
                AppMethodBeat.o(157427);
                return null;
            }
        }
    }

    public final synchronized void a(Bitmap bitmap2, Integer num) {
        AppMethodBeat.i(157428);
        Log.i(this.TAG, "alvinluo onPreviewLoaded");
        if (bitmap2 != null) {
            Log.i(this.TAG, "alvinluo onPreviewLoaded %d, recycle: %b", Integer.valueOf(bitmap2.hashCode()), Boolean.valueOf(bitmap2.isRecycled()));
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aYv) {
            if (this.bitmap != null) {
                this.bitmap.recycle();
            }
            AppMethodBeat.o(157428);
        } else {
            if (this.aYb == null) {
                if (num != null) {
                    this.aYa = num.intValue();
                }
                this.bitmap = bitmap2;
            } else if (this.aYb.width() > 0 && this.aYb.height() > 0) {
                this.bitmap = Bitmap.createBitmap(bitmap2, this.aYb.left, this.aYb.top, this.aYb.width(), this.aYb.height());
                this.aYa = 0;
            }
            this.aXg = true;
            this.aXi = false;
            this.previewWidth = this.bitmap.getWidth();
            this.previewHeight = this.bitmap.getHeight();
            rO();
            this.aXi = true;
            if (rS()) {
                invalidate();
                requestLayout();
            }
            dy((int) (System.currentTimeMillis() - currentTimeMillis));
            Log.i(this.TAG, "alvinluo onPreviewLoaded");
            if (!this.aXh && this.aYw != null) {
                this.aYw.sb();
            }
            AppMethodBeat.o(157428);
        }
    }

    public int getPreviewOrientation() {
        return this.aYa;
    }

    public int getPreviewWidth() {
        return this.previewWidth;
    }

    public int getPreviewHeight() {
        return this.previewHeight;
    }

    public final synchronized void b(final Bitmap bitmap2, final int i2, boolean z) {
        AppMethodBeat.i(157429);
        h("onImageLoaded has bitmap", new Object[0]);
        if (this.aWX > 0 && this.aWY > 0 && !(this.aWX == bitmap2.getWidth() && this.aWY == bitmap2.getHeight())) {
            reset(false);
        }
        if (this.bitmap != null && !this.aXj) {
            this.bitmap.recycle();
        }
        if (!(this.bitmap == null || !this.aXj || this.aYw == null)) {
            this.aYw.sc();
        }
        this.aXg = false;
        this.aXj = z;
        this.bitmap = bitmap2;
        this.aWX = bitmap2.getWidth();
        this.aWY = bitmap2.getHeight();
        this.aXZ = i2;
        final boolean rS = rS();
        final boolean rT = rT();
        ThreadPool.post(new Runnable() {
            /* class com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(157382);
                long currentTimeMillis = System.currentTimeMillis();
                if (i2 != 0) {
                    SubsamplingScaleImageView.this.bitmap = SubsamplingScaleImageView.this.a(bitmap2, i2);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i(SubsamplingScaleImageView.this.TAG, "alvinluo onImageLoaded rotaeAndScaleBitmap %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                SubsamplingScaleImageView.this.post(new Runnable() {
                    /* class com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.AnonymousClass6.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(157381);
                        if (rS || rT) {
                            SubsamplingScaleImageView.this.invalidate();
                            SubsamplingScaleImageView.this.requestLayout();
                        }
                        AppMethodBeat.o(157381);
                    }
                });
                AppMethodBeat.o(157382);
            }
        }, "rotateAndScaleBitmap");
        AppMethodBeat.o(157429);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int e(android.content.Context r10, android.net.Uri r11) {
        /*
        // Method dump skipped, instructions count: 261
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e(android.content.Context, android.net.Uri):int");
    }

    /* access modifiers changed from: package-private */
    public static class a {
        float aXN;
        float aZo;
        PointF aZp;
        PointF aZq;
        PointF aZr;
        PointF aZs;
        PointF aZt;
        boolean aZu;
        int aZv;
        int aZw;
        d aZx;
        long duration;
        long time;

        private a() {
            AppMethodBeat.i(157385);
            this.duration = 200;
            this.aZu = true;
            this.aZv = 2;
            this.aZw = 1;
            this.time = System.currentTimeMillis();
            AppMethodBeat.o(157385);
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class g {
        PointF aXO;
        float scale;

        /* synthetic */ g(float f2, PointF pointF, byte b2) {
            this(f2, pointF);
        }

        private g(float f2, PointF pointF) {
            this.scale = f2;
            this.aXO = pointF;
        }
    }

    public void setMaxTileSize(int i2) {
        this.aXz = i2;
        this.aXA = i2;
    }

    private int rV() {
        AppMethodBeat.i(157431);
        if (this.bitmap == null || !this.aXg) {
            AppMethodBeat.o(157431);
            return 0;
        }
        int i2 = this.aYa;
        if (i2 == 90 || i2 == 270) {
            int height = this.bitmap.getHeight();
            AppMethodBeat.o(157431);
            return height;
        }
        int width = this.bitmap.getWidth();
        AppMethodBeat.o(157431);
        return width;
    }

    private int rW() {
        AppMethodBeat.i(157432);
        if (this.bitmap == null || !this.aXg) {
            AppMethodBeat.o(157432);
            return 0;
        }
        int i2 = this.aYa;
        if (i2 == 90 || i2 == 270) {
            int width = this.bitmap.getWidth();
            AppMethodBeat.o(157432);
            return width;
        }
        int height = this.bitmap.getHeight();
        AppMethodBeat.o(157432);
        return height;
    }

    private int rX() {
        AppMethodBeat.i(157433);
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            int i2 = this.aWY;
            AppMethodBeat.o(157433);
            return i2;
        }
        int i3 = this.aWX;
        AppMethodBeat.o(157433);
        return i3;
    }

    private int rY() {
        AppMethodBeat.i(157434);
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            int i2 = this.aWX;
            AppMethodBeat.o(157434);
            return i2;
        }
        int i3 = this.aWY;
        AppMethodBeat.o(157434);
        return i3;
    }

    public int getRequiredRotation() {
        if (this.orientation == -1) {
            return this.aXZ;
        }
        return this.orientation;
    }

    private static float e(float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(157435);
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        float sqrt = (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
        AppMethodBeat.o(157435);
        return sqrt;
    }

    private float W(float f2) {
        if (this.aXO == null) {
            return Float.NaN;
        }
        return (f2 - this.aXO.x) / this.scale;
    }

    private float X(float f2) {
        if (this.aXO == null) {
            return Float.NaN;
        }
        return (f2 - this.aXO.y) / this.scale;
    }

    public final PointF a(PointF pointF) {
        AppMethodBeat.i(157436);
        PointF a2 = a(pointF.x, pointF.y, new PointF());
        AppMethodBeat.o(157436);
        return a2;
    }

    private PointF a(float f2, float f3, PointF pointF) {
        AppMethodBeat.i(157437);
        if (this.aXO == null) {
            AppMethodBeat.o(157437);
            return null;
        }
        pointF.set(W(f2), X(f3));
        AppMethodBeat.o(157437);
        return pointF;
    }

    public final float Y(float f2) {
        if (this.aXO == null) {
            return Float.NaN;
        }
        return (this.scale * f2) + this.aXO.x;
    }

    public final float Z(float f2) {
        if (this.aXO == null) {
            return Float.NaN;
        }
        return (this.scale * f2) + this.aXO.y;
    }

    public final PointF b(PointF pointF) {
        AppMethodBeat.i(157438);
        PointF b2 = b(pointF.x, pointF.y, new PointF());
        AppMethodBeat.o(157438);
        return b2;
    }

    private PointF b(float f2, float f3, PointF pointF) {
        AppMethodBeat.i(157439);
        if (this.aXO == null) {
            AppMethodBeat.o(157439);
            return null;
        }
        pointF.set(Y(f2), Z(f3));
        AppMethodBeat.o(157439);
        return pointF;
    }

    private PointF j(float f2, float f3, float f4) {
        AppMethodBeat.i(157440);
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.aYD == null) {
            this.aYD = new g(0.0f, new PointF(0.0f, 0.0f), (byte) 0);
        }
        this.aYD.scale = f4;
        this.aYD.aXO.set(((float) paddingLeft) - (f2 * f4), ((float) paddingTop) - (f3 * f4));
        a(true, this.aYD);
        PointF pointF = this.aYD.aXO;
        AppMethodBeat.o(157440);
        return pointF;
    }

    private float rZ() {
        AppMethodBeat.i(157441);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        if (this.aXx == 2 || this.aXx == 4) {
            float max = Math.max(((float) (getWidth() - paddingLeft)) / ((float) rX()), ((float) (getHeight() - paddingBottom)) / ((float) rY()));
            AppMethodBeat.o(157441);
            return max;
        } else if (this.aXx != 3 || this.aXu <= 0.0f) {
            float min = Math.min(((float) (getWidth() - paddingLeft)) / ((float) rX()), ((float) (getHeight() - paddingBottom)) / ((float) rY()));
            AppMethodBeat.o(157441);
            return min;
        } else {
            float f2 = this.aXu;
            AppMethodBeat.o(157441);
            return f2;
        }
    }

    private float aa(float f2) {
        AppMethodBeat.i(157442);
        float max = Math.max(rZ(), f2);
        AppMethodBeat.o(157442);
        return max;
    }

    private static float a(int i2, long j2, float f2, float f3, long j3) {
        AppMethodBeat.i(157443);
        switch (i2) {
            case 1:
                float a2 = a(j2, f2, f3, j3);
                AppMethodBeat.o(157443);
                return a2;
            case 2:
                float b2 = b(j2, f2, f3, j3);
                AppMethodBeat.o(157443);
                return b2;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Unexpected easing type: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(157443);
                throw illegalStateException;
        }
    }

    private static float a(long j2, float f2, float f3, long j3) {
        float f4 = ((float) j2) / ((float) j3);
        return ((f4 - 2.0f) * (-f3) * f4) + f2;
    }

    private static float b(long j2, float f2, float f3, long j3) {
        float f4 = ((float) j2) / (((float) j3) / 2.0f);
        if (f4 < 1.0f) {
            return (f4 * (f3 / 2.0f) * f4) + f2;
        }
        float f5 = f4 - 1.0f;
        return (((f5 * (f5 - 2.0f)) - 1.0f) * ((-f3) / 2.0f)) + f2;
    }

    public final void h(String str, Object... objArr) {
        AppMethodBeat.i(157444);
        Log.d(this.TAG, String.format(str, objArr));
        AppMethodBeat.o(157444);
    }

    private int px(int i2) {
        return (int) (this.density * ((float) i2));
    }

    public final void setRegionDecoderClass(Class<? extends com.davemorrissey.labs.subscaleview.a.d> cls) {
        AppMethodBeat.i(157445);
        if (cls == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Decoder class cannot be set to null");
            AppMethodBeat.o(157445);
            throw illegalArgumentException;
        }
        this.aYk = new com.davemorrissey.labs.subscaleview.a.a(cls);
        AppMethodBeat.o(157445);
    }

    public final void setRegionDecoderFactory(com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> bVar) {
        AppMethodBeat.i(157446);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Decoder factory cannot be set to null");
            AppMethodBeat.o(157446);
            throw illegalArgumentException;
        }
        this.aYk = bVar;
        AppMethodBeat.o(157446);
    }

    public final void setBitmapDecoderClass(Class<? extends com.davemorrissey.labs.subscaleview.a.d> cls) {
        AppMethodBeat.i(157447);
        if (cls == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Decoder class cannot be set to null");
            AppMethodBeat.o(157447);
            throw illegalArgumentException;
        }
        this.aYj = new com.davemorrissey.labs.subscaleview.a.a(cls);
        AppMethodBeat.o(157447);
    }

    public final void setBitmapDecoderFactory(com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> bVar) {
        AppMethodBeat.i(157448);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Decoder factory cannot be set to null");
            AppMethodBeat.o(157448);
            throw illegalArgumentException;
        }
        this.aYj = bVar;
        AppMethodBeat.o(157448);
    }

    public final void setPanLimit(int i2) {
        AppMethodBeat.i(157449);
        if (!aXe.contains(Integer.valueOf(i2))) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid pan limit: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(157449);
            throw illegalArgumentException;
        }
        this.aXw = i2;
        if (this.aYu) {
            aK(true);
            invalidate();
        }
        AppMethodBeat.o(157449);
    }

    public final void setMinimumScaleType(int i2) {
        AppMethodBeat.i(157450);
        if (!aXf.contains(Integer.valueOf(i2))) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid scale type: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(157450);
            throw illegalArgumentException;
        }
        this.aXx = i2;
        if (this.aYu) {
            aK(true);
            invalidate();
        }
        AppMethodBeat.o(157450);
    }

    public final void setMaxScale(float f2) {
        this.aXt = f2;
    }

    public final void setMinScale(float f2) {
        this.aXu = f2;
    }

    public final void setMinimumDpi(int i2) {
        AppMethodBeat.i(157451);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i2));
        AppMethodBeat.o(157451);
    }

    public final void setMaximumDpi(int i2) {
        AppMethodBeat.i(157452);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i2));
        AppMethodBeat.o(157452);
    }

    public float getMaxScale() {
        return this.aXt;
    }

    public final float getMinScale() {
        AppMethodBeat.i(157453);
        float rZ = rZ();
        AppMethodBeat.o(157453);
        return rZ;
    }

    public void setMinimumTileDpi(int i2) {
        AppMethodBeat.i(157454);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aXv = (int) Math.min((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f, (float) i2);
        if (this.aYu) {
            reset(false);
            invalidate();
        }
        AppMethodBeat.o(157454);
    }

    public final PointF getCenter() {
        AppMethodBeat.i(157455);
        PointF a2 = a((float) (getWidth() / 2), (float) (getHeight() / 2), new PointF());
        AppMethodBeat.o(157455);
        return a2;
    }

    public final float getScale() {
        return this.scale;
    }

    public final void a(float f2, PointF pointF) {
        AppMethodBeat.i(157456);
        this.aYt = null;
        this.aXW = true;
        this.aXT = Float.valueOf(f2);
        this.aXU = pointF;
        this.aXV = pointF;
        invalidate();
        AppMethodBeat.o(157456);
    }

    public final int getSWidth() {
        return this.aWX;
    }

    public final int getSHeight() {
        return this.aWY;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getAppliedOrientation() {
        AppMethodBeat.i(157457);
        int requiredRotation = getRequiredRotation();
        AppMethodBeat.o(157457);
        return requiredRotation;
    }

    public final b getState() {
        AppMethodBeat.i(157458);
        if (this.aXO == null || this.aWX <= 0 || this.aWY <= 0) {
            AppMethodBeat.o(157458);
            return null;
        }
        b bVar = new b(getScale(), getCenter(), getOrientation());
        AppMethodBeat.o(157458);
        return bVar;
    }

    public final void setZoomEnabled(boolean z) {
        this.aXD = z;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.aXE = z;
    }

    public final void setPanEnabled(boolean z) {
        AppMethodBeat.i(157459);
        this.aXC = z;
        if (!z && this.aXO != null) {
            this.aXO.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (rX() / 2)));
            this.aXO.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (rY() / 2)));
            if (this.aYu) {
                aJ(true);
                invalidate();
            }
        }
        AppMethodBeat.o(157459);
    }

    public final void setTileBackgroundColor(int i2) {
        AppMethodBeat.i(157460);
        if (Color.alpha(i2) == 0) {
            this.aYC = null;
        } else {
            this.aYC = new Paint();
            this.aYC.setStyle(Paint.Style.FILL);
            this.aYC.setColor(i2);
        }
        invalidate();
        AppMethodBeat.o(157460);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.aXF = f2;
    }

    public final void setDoubleTapZoomDpi(int i2) {
        AppMethodBeat.i(157461);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i2));
        AppMethodBeat.o(157461);
    }

    public final void setDoubleTapZoomStyle(int i2) {
        AppMethodBeat.i(157462);
        if (!aXc.contains(Integer.valueOf(i2))) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid zoom style: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(157462);
            throw illegalArgumentException;
        }
        this.aXG = i2;
        AppMethodBeat.o(157462);
    }

    public final void setDoubleTapZoomDuration(int i2) {
        AppMethodBeat.i(157463);
        this.aXH = Math.max(0, i2);
        AppMethodBeat.o(157463);
    }

    public void setExecutor(Executor executor2) {
        AppMethodBeat.i(157464);
        if (executor2 == null) {
            NullPointerException nullPointerException = new NullPointerException("Executor must not be null");
            AppMethodBeat.o(157464);
            throw nullPointerException;
        }
        this.executor = executor2;
        AppMethodBeat.o(157464);
    }

    public void setEagerLoadingEnabled(boolean z) {
        this.aXB = z;
    }

    public final void setDebug(boolean z) {
        this.aXs = z;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aYy = onLongClickListener;
    }

    public void setOnImageEventListener(e eVar) {
        this.aYw = eVar;
    }

    public void setOnStateChangedListener(f fVar) {
        this.aYx = fVar;
    }

    private void b(float f2, PointF pointF) {
        AppMethodBeat.i(208727);
        Log.i(this.TAG, "alvinluo sendStateChanged oldScale: %s, %s", Float.valueOf(f2), Float.valueOf(this.scale));
        if (!(this.aYx == null || this.scale == f2)) {
            this.aYx.r(this.scale, f2);
        }
        if (this.aYx != null && !this.aXO.equals(pointF)) {
            getCenter();
        }
        AppMethodBeat.o(208727);
    }

    public final class b {
        private final PointF aZA;
        boolean aZB;
        public boolean aZu;
        int aZv;
        public int aZw;
        private d aZx;
        private final float aZy;
        private final PointF aZz;
        public long duration;

        public /* synthetic */ b(SubsamplingScaleImageView subsamplingScaleImageView, float f2, PointF pointF, byte b2) {
            this(f2, pointF);
        }

        /* synthetic */ b(SubsamplingScaleImageView subsamplingScaleImageView, float f2, PointF pointF, PointF pointF2, byte b2) {
            this(f2, pointF, pointF2);
        }

        /* synthetic */ b(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, byte b2) {
            this(pointF);
        }

        private b(PointF pointF) {
            AppMethodBeat.i(157386);
            this.duration = 500;
            this.aZv = 2;
            this.aZw = 1;
            this.aZu = true;
            this.aZB = true;
            this.aZy = SubsamplingScaleImageView.this.scale;
            this.aZz = pointF;
            this.aZA = null;
            AppMethodBeat.o(157386);
        }

        private b(float f2, PointF pointF) {
            this.duration = 500;
            this.aZv = 2;
            this.aZw = 1;
            this.aZu = true;
            this.aZB = true;
            this.aZy = f2;
            this.aZz = pointF;
            this.aZA = null;
        }

        private b(float f2, PointF pointF, PointF pointF2) {
            this.duration = 500;
            this.aZv = 2;
            this.aZw = 1;
            this.aZu = true;
            this.aZB = true;
            this.aZy = f2;
            this.aZz = pointF;
            this.aZA = pointF2;
        }

        public final void start() {
            AppMethodBeat.i(157387);
            if (!(SubsamplingScaleImageView.this.aYt == null || SubsamplingScaleImageView.this.aYt.aZx == null)) {
                try {
                    a unused = SubsamplingScaleImageView.this.aYt;
                } catch (Exception e2) {
                    Log.w(SubsamplingScaleImageView.this.TAG, "Error thrown by animation listener", e2);
                }
            }
            int width = (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2) + SubsamplingScaleImageView.this.getPaddingLeft();
            int height = (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2) + SubsamplingScaleImageView.this.getPaddingTop();
            float b2 = SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, this.aZy);
            PointF a2 = this.aZB ? SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, this.aZz.x, this.aZz.y, b2, new PointF()) : this.aZz;
            SubsamplingScaleImageView.this.aYt = new a((byte) 0);
            SubsamplingScaleImageView.this.aYt.aXN = SubsamplingScaleImageView.this.scale;
            SubsamplingScaleImageView.this.aYt.aZo = b2;
            SubsamplingScaleImageView.this.aYt.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.aYt.aZr = a2;
            SubsamplingScaleImageView.this.aYt.aZp = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.aYt.aZq = a2;
            SubsamplingScaleImageView.this.aYt.aZs = SubsamplingScaleImageView.this.b(a2);
            SubsamplingScaleImageView.this.aYt.aZt = new PointF((float) width, (float) height);
            SubsamplingScaleImageView.this.aYt.duration = this.duration;
            SubsamplingScaleImageView.this.aYt.aZu = this.aZu;
            SubsamplingScaleImageView.this.aYt.aZv = this.aZv;
            SubsamplingScaleImageView.this.aYt.aZw = this.aZw;
            SubsamplingScaleImageView.this.aYt.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.aYt.aZx = this.aZx;
            if (this.aZA != null) {
                float f2 = this.aZA.x - (SubsamplingScaleImageView.this.aYt.aZp.x * b2);
                float f3 = this.aZA.y - (SubsamplingScaleImageView.this.aYt.aZp.y * b2);
                g gVar = new g(b2, new PointF(f2, f3), (byte) 0);
                SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, gVar);
                SubsamplingScaleImageView.this.aYt.aZt = new PointF((gVar.aXO.x - f2) + this.aZA.x, (gVar.aXO.y - f3) + this.aZA.y);
            }
            SubsamplingScaleImageView.this.invalidate();
            AppMethodBeat.o(157387);
        }
    }

    static /* synthetic */ PointF a(SubsamplingScaleImageView subsamplingScaleImageView, float f2, float f3, float f4, PointF pointF) {
        AppMethodBeat.i(208731);
        PointF j2 = subsamplingScaleImageView.j(f2, f3, f4);
        pointF.set((((float) (subsamplingScaleImageView.getPaddingLeft() + (((subsamplingScaleImageView.getWidth() - subsamplingScaleImageView.getPaddingRight()) - subsamplingScaleImageView.getPaddingLeft()) / 2))) - j2.x) / f4, (((float) (subsamplingScaleImageView.getPaddingTop() + (((subsamplingScaleImageView.getHeight() - subsamplingScaleImageView.getPaddingBottom()) - subsamplingScaleImageView.getPaddingTop()) / 2))) - j2.y) / f4);
        AppMethodBeat.o(208731);
        return pointF;
    }
}

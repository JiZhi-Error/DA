package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public class SphereImageView extends GLTextureView {
    private float EjV;
    private float EjW;
    private float EjX;
    private float EjY;
    private b EjZ;
    private Sensor Eka;
    private float[] Ekb = new float[3];
    private float Ekc = 0.4f;
    private long Ekd = 0;
    private float Eke;
    private boolean Ekf = false;
    private a Ekg;
    private int Ekh;
    private int Eki;
    private boolean Ekj = true;
    private boolean Ekk = false;
    private boolean Ekl = false;
    protected GestureDetector.OnGestureListener Ekm = new GestureDetector.OnGestureListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.AnonymousClass2 */

        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(97251);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView$2", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            if (SphereImageView.this.Ekn != null) {
                SphereImageView.this.Ekn.onClick(SphereImageView.this);
                Log.i("SphereImageView.SphereView", "onClick, hash=" + hashCode());
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView$2", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(97251);
            return true;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(97252);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView$2", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            if (SphereImageView.this.Eko != null) {
                SphereImageView.this.Eko.onLongClick(SphereImageView.this);
                Log.i("SphereImageView.SphereView", "onLongPress, hash=" + hashCode());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView$2", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(97252);
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }
    };
    protected View.OnClickListener Ekn;
    protected View.OnLongClickListener Eko;
    protected Bitmap Ekp = null;
    protected boolean Ekq = false;
    protected b Ekr;
    protected String lBO = "";
    private Context mContext;
    private GestureDetector mDJ;
    protected TextureView.SurfaceTextureListener mEq = new TextureView.SurfaceTextureListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.AnonymousClass4 */

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(97255);
            Log.i("SphereImageView.SphereView", "onSurfaceTextureAvailable, hasPendingImage=" + SphereImageView.this.Ekq);
            if (SphereImageView.this.Ekq) {
                SphereImageView.this.queueEvent(SphereImageView.this.h(SphereImageView.this.Ekp, SphereImageView.this.lBO));
                SphereImageView.this.Ekp = null;
                SphereImageView.this.Ekq = false;
                SphereImageView.this.lBO = "";
            }
            AppMethodBeat.o(97255);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    Handler mHandler = new Handler() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.AnonymousClass1 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(97250);
            switch (message.what) {
                case 1:
                    c cVar = (c) message.obj;
                    float f2 = cVar.Ekx;
                    float f3 = cVar.Ekw;
                    float f4 = f2 - SphereImageView.this.EjV;
                    float f5 = f3 - SphereImageView.this.EjX;
                    SphereImageView.this.EjZ.EkH += f5 * 1.5f;
                    SphereImageView.this.EjZ.EkG += (f4 * 1.5f) / 2.0f;
                    if (SphereImageView.this.EjZ.EkG < -50.0f) {
                        SphereImageView.this.EjZ.EkG = -50.0f;
                    } else if (SphereImageView.this.EjZ.EkG > 50.0f) {
                        SphereImageView.this.EjZ.EkG = 50.0f;
                    }
                    SphereImageView.this.EjV = f2;
                    SphereImageView.this.EjX = f3;
                    if (Math.abs(f5) > 0.01f || Math.abs(f4) > 0.01f) {
                        long currentTimeMillis = System.currentTimeMillis();
                        SphereImageView.this.Ejd.requestRender();
                        if ((Math.abs(f5) > 0.1f || Math.abs(f4) > 0.1f) && currentTimeMillis - SphereImageView.this.Ekd > 500 && SphereImageView.this.Ekr != null) {
                            SphereImageView.this.Ekr.fdK();
                            SphereImageView.this.Ekd = currentTimeMillis;
                            break;
                        }
                    }
            }
            AppMethodBeat.o(97250);
        }
    };
    private SensorManager mSensorManager;
    private int mTouchSlop;
    private boolean pbB = true;

    public interface b {
        void aQa(String str);

        void fdK();

        void fdL();

        void fdM();

        void onDetachedFromWindow();
    }

    public SphereImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(97258);
        this.mContext = context;
        setEGLContextClientVersion(2);
        this.Ejm.add(this.mEq);
        this.EjZ = new b(this.mContext);
        setRenderer(this.EjZ);
        setRenderMode(0);
        this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.Eka = this.mSensorManager.getDefaultSensor(4);
        if (this.Eka == null) {
            Log.e("SphereImageView.SphereView", "device has no Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND);
        } else {
            Log.i("SphereImageView.SphereView", "has Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND + ", sensor=" + this.Eka);
        }
        this.Ekg = new a(this);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() / 4;
        if (this.mTouchSlop < 4) {
            this.mTouchSlop = 4;
        }
        this.mDJ = new GestureDetector(context, this.Ekm);
        this.Eke = context.getResources().getDisplayMetrics().density;
        Log.i("SphereImageView.SphereView", "init, displayDensity=" + this.Eke + ", apiLevel=" + Build.VERSION.SDK_INT + ", touchSlop=" + this.mTouchSlop);
        AppMethodBeat.o(97258);
    }

    public final void an(float f2, float f3) {
        AppMethodBeat.i(97259);
        this.EjZ.an(f2, f3);
        AppMethodBeat.o(97259);
    }

    public static class a implements SensorEventListener {
        public boolean Eku = true;
        WeakReference<SphereImageView> Ekv;
        public long timestamp = 0;

        public a(SphereImageView sphereImageView) {
            AppMethodBeat.i(97256);
            this.Ekv = new WeakReference<>(sphereImageView);
            AppMethodBeat.o(97256);
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.i(97257);
            SphereImageView sphereImageView = this.Ekv.get();
            if (sphereImageView == null) {
                AppMethodBeat.o(97257);
            } else if (Build.VERSION.SDK_INT >= 24 || this.Eku) {
                if (sensorEvent.sensor.getType() == 4) {
                    if (this.timestamp != 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        float f2 = ((float) (currentTimeMillis - this.timestamp)) / 1000.0f;
                        if (((double) f2) < 0.012d) {
                            AppMethodBeat.o(97257);
                            return;
                        }
                        this.timestamp = currentTimeMillis;
                        float[] fArr = sphereImageView.Ekb;
                        fArr[0] = fArr[0] + (sensorEvent.values[0] * f2);
                        float[] fArr2 = sphereImageView.Ekb;
                        fArr2[1] = fArr2[1] + (sensorEvent.values[1] * f2);
                        float[] fArr3 = sphereImageView.Ekb;
                        fArr3[2] = (f2 * sensorEvent.values[2]) + fArr3[2];
                        float degrees = (float) Math.toDegrees((double) sphereImageView.Ekb[0]);
                        float degrees2 = (float) Math.toDegrees((double) sphereImageView.Ekb[2]);
                        c cVar = new c();
                        cVar.Ekw = (float) Math.toDegrees((double) sphereImageView.Ekb[1]);
                        cVar.Ekx = degrees;
                        cVar.Eky = degrees2;
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        obtain.obj = cVar;
                        sphereImageView.mHandler.sendMessage(obtain);
                        AppMethodBeat.o(97257);
                        return;
                    }
                    this.timestamp = System.currentTimeMillis();
                }
                AppMethodBeat.o(97257);
            } else {
                AppMethodBeat.o(97257);
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }
    }

    public void setOnlyHorizontalScroll(boolean z) {
        this.Ekl = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(97260);
        GestureDetector gestureDetector = this.mDJ;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (this.pbB) {
            float y = motionEvent.getY();
            float x = motionEvent.getX();
            getParent().requestDisallowInterceptTouchEvent(true);
            switch (motionEvent.getAction()) {
                case 0:
                    this.Ekh = (int) x;
                    this.Eki = (int) y;
                    if (this.Ekl) {
                        this.Ekk = false;
                        this.Ekj = true;
                    }
                    if (this.Ekr != null) {
                        this.Ekr.fdL();
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (this.Ekl) {
                        this.Ekk = false;
                        this.Ekj = true;
                    }
                    if (this.Ekr != null) {
                        this.Ekr.fdM();
                        break;
                    }
                    break;
                case 2:
                    float f2 = y - this.EjW;
                    float f3 = x - this.EjY;
                    if (this.Ekl) {
                        if (!this.Ekj && this.Ekk) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                            AppMethodBeat.o(97260);
                            return false;
                        } else if (!this.Ekk && ((int) Math.sqrt((double) (((y - ((float) this.Eki)) * (y - ((float) this.Eki))) + ((x - ((float) this.Ekh)) * (x - ((float) this.Ekh)))))) >= this.mTouchSlop) {
                            this.Ekk = true;
                            if (Math.abs(y - ((float) this.Eki)) > Math.abs(x - ((float) this.Ekh))) {
                                this.Ekj = false;
                                getParent().requestDisallowInterceptTouchEvent(false);
                                AppMethodBeat.o(97260);
                                return false;
                            }
                            this.Ekj = true;
                        }
                    }
                    b bVar = this.EjZ;
                    bVar.EkH = bW(f3) + bVar.EkH;
                    b bVar2 = this.EjZ;
                    bVar2.EkG = bW(f2) + bVar2.EkG;
                    if (this.EjZ.EkG >= -50.0f) {
                        if (this.EjZ.EkG > 50.0f) {
                            this.EjZ.EkG = 50.0f;
                            break;
                        }
                    } else {
                        this.EjZ.EkG = -50.0f;
                        break;
                    }
                    break;
            }
            this.EjW = y;
            this.EjY = x;
            this.Ejd.requestRender();
        }
        AppMethodBeat.o(97260);
        return true;
    }

    private float bW(float f2) {
        AppMethodBeat.i(97261);
        if (this.Eke == 0.0f) {
            this.Eke = 3.0f;
            Log.e("SphereImageView.SphereView", "px2Angle , mDisplayDensity==0");
        }
        float f3 = (f2 / this.Eke) * this.Ekc;
        AppMethodBeat.o(97261);
        return f3;
    }

    public void setTouchSensitivity(float f2) {
        if (f2 > 0.0f) {
            this.Ekc = f2;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Ekn = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Eko = onLongClickListener;
    }

    public final void g(Bitmap bitmap, String str) {
        AppMethodBeat.i(97262);
        boolean isAvailable = isAvailable();
        Log.i("SphereImageView.SphereView", "updateImage, isAvailable=" + isAvailable + ", hasPendingImage=" + this.Ekq);
        if (isAvailable) {
            this.Ekp = null;
            this.Ekq = false;
            this.lBO = "";
            queueEvent(h(bitmap, str));
            AppMethodBeat.o(97262);
            return;
        }
        this.Ekp = bitmap;
        this.Ekq = true;
        this.lBO = str;
        AppMethodBeat.o(97262);
    }

    /* access modifiers changed from: protected */
    public final Runnable h(final Bitmap bitmap, final String str) {
        AppMethodBeat.i(97263);
        AnonymousClass3 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.AnonymousClass3 */

            public final void run() {
                int width;
                int i2 = 0;
                AppMethodBeat.i(97254);
                StringBuilder sb = new StringBuilder("updateImage in GLThread, bmp.w=");
                if (bitmap == null) {
                    width = 0;
                } else {
                    width = bitmap.getWidth();
                }
                StringBuilder append = sb.append(width).append(", h=");
                if (bitmap != null) {
                    i2 = bitmap.getHeight();
                }
                Log.i("SphereImageView.SphereView", append.append(i2).toString());
                b bVar = SphereImageView.this.EjZ;
                Bitmap bitmap = bitmap;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (bVar.EkF != 0) {
                        GLES20.glDeleteTextures(1, new int[]{bVar.EkF}, 0);
                        Log.i("SphereImageView.SphereRender", "delete old texture");
                    }
                    int aA = c.aA(bitmap);
                    Log.i("SphereImageView.SphereRender", "updateImage, oldId=" + bVar.EkF + ", newId=" + aA + ", timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
                    bVar.EkF = aA;
                } catch (Throwable th) {
                    Log.e("SphereImageView.SphereRender", "updateImage, exp:" + th.toString());
                }
                SphereImageView.this.Ejd.requestRender();
                if (SphereImageView.this.Ekr != null) {
                    SphereImageView.this.mHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(97253);
                            SphereImageView.this.Ekr.aQa(str);
                            Log.i("SphereImageView.SphereView", "onUpdateImage, isAvailable=" + SphereImageView.this.isAvailable());
                            AppMethodBeat.o(97253);
                        }
                    });
                }
                AppMethodBeat.o(97254);
            }
        };
        AppMethodBeat.o(97263);
        return r0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView
    public void onAttachedToWindow() {
        AppMethodBeat.i(97264);
        super.onAttachedToWindow();
        this.Ekf = false;
        Log.i("SphereImageView.SphereView", "onAttachedToWindow, hash=" + hashCode() + ", apiLevel=" + Build.VERSION.SDK_INT);
        feu();
        AppMethodBeat.o(97264);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView
    public void onDetachedFromWindow() {
        AppMethodBeat.i(97265);
        super.onDetachedFromWindow();
        this.Ekf = true;
        Log.i("SphereImageView.SphereView", "onDetachedFromWindow, hash=" + hashCode());
        this.Ekp = null;
        this.Ekq = false;
        this.lBO = "";
        setSensorEnabled(false);
        queueEvent(h(null, ""));
        feu();
        if (this.Ekr != null) {
            this.Ekr.onDetachedFromWindow();
        }
        AppMethodBeat.o(97265);
    }

    public void onFinishTemporaryDetach() {
        AppMethodBeat.i(97266);
        if (Build.VERSION.SDK_INT < 24) {
            Log.i("SphereImageView.SphereView", "onFinishTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
            feu();
            this.Ekg.timestamp = 0;
            this.Ekg.Eku = true;
        }
        AppMethodBeat.o(97266);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.i(97267);
        if (Build.VERSION.SDK_INT < 24) {
            Log.i("SphereImageView.SphereView", "onStartTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
            feu();
            this.Ekg.timestamp = 0;
            this.Ekg.Eku = false;
        }
        AppMethodBeat.o(97267);
    }

    public void setSensorEnabled(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(97268);
        if (!z || !this.Ekf) {
            StringBuilder append = new StringBuilder("enableSensor, enabled=").append(z).append(", hash=").append(hashCode()).append(", hasSensor=");
            if (this.Eka != null) {
                z2 = true;
            }
            Log.i("SphereImageView.SphereView", append.append(z2).toString());
            try {
                if (this.Eka != null) {
                    if (z) {
                        this.Ekg.timestamp = 0;
                        this.mSensorManager.registerListener(this.Ekg, this.Eka, 0);
                        AppMethodBeat.o(97268);
                        return;
                    }
                    this.mSensorManager.unregisterListener(this.Ekg);
                    this.Ekg.timestamp = 0;
                }
                AppMethodBeat.o(97268);
            } catch (Exception e2) {
                Log.e("SphereImageView.SphereView", "setSensorEnabled exp:" + e2.toString());
                AppMethodBeat.o(97268);
            }
        } else {
            Log.e("SphereImageView.SphereView", "setSensorEnabled when isDetachedFromWindow");
            AppMethodBeat.o(97268);
        }
    }

    public void setTouchEnabled(boolean z) {
        AppMethodBeat.i(97269);
        Log.i("SphereImageView.SphereView", "setTouchEnabled：" + z + ", hash=" + hashCode());
        this.pbB = z;
        AppMethodBeat.o(97269);
    }

    protected static class c {
        float Ekw;
        float Ekx;
        float Eky;

        protected c() {
        }
    }

    public final void feu() {
        AppMethodBeat.i(97270);
        Log.i("SphereImageView.SphereView", "zero, hash=" + hashCode());
        this.EjZ.EkH = 90.0f;
        this.EjZ.EkG = 0.0f;
        AppMethodBeat.o(97270);
    }

    public PointF getCurAngle() {
        AppMethodBeat.i(97271);
        PointF pointF = new PointF();
        pointF.x = this.EjZ.EkG;
        pointF.y = this.EjZ.EkH;
        AppMethodBeat.o(97271);
        return pointF;
    }

    public void setEventListener(b bVar) {
        this.Ekr = bVar;
    }
}

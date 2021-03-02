package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.camera.l;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.media.t;
import com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.qbar.QbarNative;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.wxmm.v2helper;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class AppBrandCameraView extends RelativeLayout implements f, i.b, i.c, i.d {
    private String cHZ = "back";
    private ImageView dKU;
    private String irP;
    private f lOZ;
    private long lPA = -1;
    private long lPB = -1;
    private d lPC;
    private boolean lPD;
    private float lPE;
    private long lPF;
    private boolean lPG;
    private ad.a lPH = ad.a.LANDSCAPE;
    private AtomicBoolean lPI = new AtomicBoolean(false);
    private List<Runnable> lPJ;
    private ad lPK = new ad(MMApplicationContext.getContext(), new ad.b() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.utils.ad.b
        public final void a(ad.a aVar, ad.a aVar2) {
            AppMethodBeat.i(226712);
            if (!AppBrandCameraView.a(AppBrandCameraView.this) || !AppBrandCameraView.b(AppBrandCameraView.this)) {
                if (aVar2 == ad.a.LANDSCAPE && AppBrandCameraView.this.lPH == ad.a.REVERSE_LANDSCAPE) {
                    AppBrandCameraView.this.lPH = aVar2;
                    AppBrandCameraView.d(AppBrandCameraView.this);
                }
                if (aVar2 == ad.a.REVERSE_LANDSCAPE && AppBrandCameraView.this.lPH == ad.a.LANDSCAPE) {
                    AppBrandCameraView.this.lPH = aVar2;
                    AppBrandCameraView.d(AppBrandCameraView.this);
                }
                AppMethodBeat.o(226712);
                return;
            }
            AppMethodBeat.o(226712);
        }
    });
    private String lPa = JsApiScanCode.NAME;
    private int lPb;
    private a lPc;
    private int lPd;
    private String lPe = "auto";
    private String lPf = "high";
    private String lPg;
    private boolean lPh = false;
    private boolean lPi = false;
    private boolean lPj;
    private boolean lPk = false;
    private int lPl = 1080;
    private int lPm = 1920;
    private int lPn = 1080;
    private int lPo = 1920;
    private Rect lPp;
    private int lPq;
    private Size lPr;
    private boolean lPs;
    private c lPt;
    private b lPu;
    private MMSightRecordView lPv;
    private String lPw;
    private String lPx;
    int lPy = -1;
    private boolean lPz = false;
    private String mAppId;
    private Context mContext;
    private WindowManager mWindowManager = ((WindowManager) MMApplicationContext.getContext().getSystemService("window"));

    public interface a {
        void C(byte[] bArr, int i2, int i3);

        void bFK();

        void bFT();

        void bFU();

        void init();

        void release();
    }

    static /* synthetic */ void A(AppBrandCameraView appBrandCameraView) {
        AppMethodBeat.i(226729);
        appBrandCameraView.bFQ();
        AppMethodBeat.o(226729);
    }

    static /* synthetic */ void E(AppBrandCameraView appBrandCameraView) {
        AppMethodBeat.i(226730);
        appBrandCameraView.bFP();
        AppMethodBeat.o(226730);
    }

    static {
        AppMethodBeat.i(46215);
        j.bur();
        AppMethodBeat.o(46215);
    }

    public static void bFJ() {
        AppMethodBeat.i(46179);
        l.lQf = new l.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.l.a
            public final /* synthetic */ f dN(Context context) {
                AppMethodBeat.i(226713);
                AppBrandCameraView appBrandCameraView = new AppBrandCameraView(context);
                AppMethodBeat.o(226713);
                return appBrandCameraView;
            }
        };
        AppMethodBeat.o(46179);
    }

    public AppBrandCameraView(Context context) {
        super(context);
        AppMethodBeat.i(46180);
        init(context);
        AppMethodBeat.o(46180);
    }

    public AppBrandCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(46181);
        init(context);
        AppMethodBeat.o(46181);
    }

    public AppBrandCameraView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(46182);
        init(context);
        AppMethodBeat.o(46182);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setOperateCallBack(c cVar) {
        this.lPt = cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setOutPutCallBack(b bVar) {
        this.lPu = bVar;
    }

    private void init(Context context) {
        AppMethodBeat.i(46183);
        this.mContext = context;
        this.lPI.set(false);
        LayoutInflater.from(context).inflate(R.layout.dd, this);
        AppMethodBeat.o(46183);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public final void initView() {
        AppMethodBeat.i(46184);
        Log.i("MicroMsg.AppBrandCameraView", "initView");
        if (!a.C0654a.lOY.bFH()) {
            AppMethodBeat.o(46184);
            return;
        }
        bFP();
        bFO();
        bFL();
        bFM();
        this.lPI.compareAndSet(false, true);
        if (this.lPs) {
            this.lPK.jHZ = 60;
            this.lPK.enable();
        }
        AppMethodBeat.o(46184);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setPage(h hVar) {
        this.lOZ = hVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setMode(String str) {
        this.lPa = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setFrameLimitSize(int i2) {
        AppMethodBeat.i(46185);
        Log.i("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", Integer.valueOf(i2));
        this.lPb = i2;
        AppMethodBeat.o(46185);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setAppId(String str) {
        this.mAppId = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public final void ar(String str, boolean z) {
        AppMethodBeat.i(46186);
        if (Util.isEqual(this.cHZ, str)) {
            AppMethodBeat.o(46186);
        } else if (Util.isEqual(this.lPa, JsApiScanCode.NAME)) {
            AppMethodBeat.o(46186);
        } else {
            this.cHZ = str;
            if (!z && this.lPv != null) {
                this.lPv.zsX.switchCamera();
            }
            AppMethodBeat.o(46186);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setCameraId(int i2) {
        this.lPd = i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public int getCameraId() {
        return this.lPd;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setFlash(String str) {
        AppMethodBeat.i(46187);
        if (Util.isEqual(this.lPe, str)) {
            AppMethodBeat.o(46187);
            return;
        }
        this.lPe = str;
        AppMethodBeat.o(46187);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setQuality(String str) {
        AppMethodBeat.i(46188);
        if (Util.isEqual(this.lPf, str)) {
            AppMethodBeat.o(46188);
            return;
        }
        this.lPf = str;
        AppMethodBeat.o(46188);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setResolution(String str) {
        AppMethodBeat.i(46189);
        if (Util.isEqual(this.lPg, str)) {
            AppMethodBeat.o(46189);
            return;
        }
        Log.i("MicroMsg.AppBrandCameraView", "setPreviewResolution: %s", str);
        this.lPg = str;
        AppMethodBeat.o(46189);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setCompressRecord(boolean z) {
        this.lPi = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setPreviewCenterCrop(boolean z) {
        this.lPh = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setDisplayScreenSize(Size size) {
        AppMethodBeat.i(226723);
        if (size == null || size.getHeight() <= 0 || size.getWidth() <= 0) {
            AppMethodBeat.o(226723);
            return;
        }
        this.lPr = size;
        AppMethodBeat.o(226723);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setPageOrientation(boolean z) {
        AppMethodBeat.i(226724);
        this.lPs = z;
        Log.i("MicroMsg.AppBrandCameraView", "setPageOrientation: %b", Boolean.valueOf(z));
        AppMethodBeat.o(226724);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public final boolean dZ(int i2, int i3) {
        AppMethodBeat.i(46190);
        if (this.lPl == i2 && this.lPm == i3) {
            AppMethodBeat.o(46190);
            return false;
        }
        Log.i("MicroMsg.AppBrandCameraView", "setViewSize");
        this.lPl = i2;
        this.lPm = i3;
        AppMethodBeat.o(46190);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setNeedOutput(boolean z) {
        this.lPj = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
    public final void onDestroy() {
        AppMethodBeat.i(46193);
        if (this.lPC != null) {
            this.lPC.a(this.lPv);
        }
        release();
        this.lPI.compareAndSet(true, false);
        AppMethodBeat.o(46193);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public final void release() {
        AppMethodBeat.i(46194);
        Log.i("MicroMsg.AppBrandCameraView", "release");
        synchronized (AppBrandCameraView.class) {
            try {
                this.lPF = Util.currentTicks();
                if (this.lPs) {
                    this.lPK.disable();
                }
                if (this.lPv != null) {
                    this.lPv.zsX.release();
                    removeView(this.lPv);
                    this.lPy = -1;
                    this.lPv.setFrameDataCallback(null);
                    this.lPv.setInitErrorCallback(null);
                    this.lPv.setInitDoneCallback(null);
                    this.lPv = null;
                }
                if (this.dKU != null) {
                    this.dKU.setImageBitmap(null);
                }
                if (this.lPJ != null) {
                    this.lPJ.clear();
                }
                this.lPE = 0.0f;
            } catch (Throwable th) {
                AppMethodBeat.o(46194);
                throw th;
            }
        }
        bFS();
        AppMethodBeat.o(46194);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public final void bFK() {
        AppMethodBeat.i(46195);
        if (this.lPc != null) {
            this.lPc.bFK();
        }
        AppMethodBeat.o(46195);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public final float aJ(float f2) {
        AppMethodBeat.i(46196);
        if (this.lPv == null) {
            AppMethodBeat.o(46196);
            return 0.0f;
        } else if (f2 < 1.0f) {
            AppMethodBeat.o(46196);
            return f2;
        } else {
            if (f2 > this.lPE) {
                f2 = this.lPE;
            }
            while (!this.lPv.zsX.aD(f2) && f2 > 0.0f) {
                f2 -= 0.1f;
            }
            AppMethodBeat.o(46196);
            return f2;
        }
    }

    private void bFL() {
        int i2 = 0;
        AppMethodBeat.i(46197);
        Log.i("MicroMsg.AppBrandCameraView", "initCamera.");
        if (!a.C0654a.lOY.bFH()) {
            Toast.makeText(this.mContext, (int) R.string.f10, 1).show();
            Log.w("MicroMsg.AppBrandCameraView", "no permission");
            AppMethodBeat.o(46197);
        } else if (this.lPv != null) {
            Log.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
            AppMethodBeat.o(46197);
        } else {
            int[] bFG = a.C0654a.lOY.bFG();
            if (bFG.length > 0) {
                for (int i3 : bFG) {
                    if (i3 != this.lPd) {
                        a.C0654a.lOY.M(i3, false);
                        Log.i("MicroMsg.AppBrandCameraView", "release camera before init new camera, id: %d", Integer.valueOf(i3));
                    }
                }
            }
            if (this.dKU == null) {
                this.dKU = new ImageView(this.mContext);
                this.dKU.setScaleType(ImageView.ScaleType.FIT_XY);
                addView(this.dKU, new ViewGroup.LayoutParams(-1, -1));
            } else {
                this.dKU.setImageBitmap(null);
            }
            this.lPv = d(this.mContext, this.lPl, this.lPm);
            if (this.lPv == null) {
                this.lPv = new MMSightRecordView(this.mContext);
            }
            this.lPD = false;
            addView(this.lPv);
            bFV();
            this.lPv.setRGBSizeLimit(this.lPb);
            this.lPv.zsX.bqO();
            this.lPv.setDisplayRatio((((float) this.lPl) * 1.0f) / ((float) this.lPm));
            MMSightRecordView mMSightRecordView = this.lPv;
            if (this.lPh) {
                i2 = 1;
            }
            mMSightRecordView.setPreviewMode(i2);
            this.lPv.setVideoPara$2e715812(600000);
            this.lPv.setVideoFilePath(this.lPw);
            this.lPv.setClipPictureSize(true);
            this.lPv.setClipVideoSize(true);
            this.lPv.setDisplayScreenSize(this.lPr);
            this.lPv.setUseBackCamera("back".equals(this.cHZ));
            this.lPv.setFrameDataCallback(new MMSightRecordView.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a
                public final void C(byte[] bArr, int i2, int i3) {
                    AppMethodBeat.i(226714);
                    if (AppBrandCameraView.this.lPc != null) {
                        AppBrandCameraView.this.lPc.C(bArr, i2, i3);
                    }
                    AppMethodBeat.o(226714);
                }
            });
            this.lPv.setInitErrorCallback(new MMSightRecordView.d() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d
                public final void bFW() {
                    AppMethodBeat.i(226715);
                    Log.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
                    HashMap hashMap = new HashMap();
                    hashMap.put("cameraId", Integer.valueOf(AppBrandCameraView.this.lPd));
                    new i().h(AppBrandCameraView.this.lOZ).Zh(new JSONObject(hashMap).toString()).bEo();
                    AppMethodBeat.o(226715);
                }
            });
            this.lPv.setInitDoneCallback(new MMSightRecordView.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c
                public final void bFX() {
                    AppMethodBeat.i(226716);
                    AppBrandCameraView.this.lPD = true;
                    Log.i("MicroMsg.AppBrandCameraView", "InitDoneCallback");
                    h hVar = new h();
                    HashMap hashMap = new HashMap();
                    hashMap.put("cameraId", Integer.valueOf(AppBrandCameraView.this.lPd));
                    float[] supportZoomMultiple = AppBrandCameraView.this.lPv != null ? AppBrandCameraView.this.lPv.getSupportZoomMultiple() : null;
                    if (supportZoomMultiple != null && supportZoomMultiple.length > 0) {
                        AppBrandCameraView.this.lPE = supportZoomMultiple[supportZoomMultiple.length - 1];
                    }
                    hashMap.put("maxZoom", Float.valueOf(AppBrandCameraView.this.lPE));
                    hVar.Zh(new JSONObject(hashMap).toString());
                    AppBrandCameraView.this.lOZ.a(hVar, (int[]) null);
                    if (AppBrandCameraView.this.lPJ != null) {
                        for (Runnable runnable : AppBrandCameraView.this.lPJ) {
                            runnable.run();
                        }
                        AppBrandCameraView.this.lPJ.clear();
                    }
                    AppMethodBeat.o(226716);
                }
            });
            this.lPv.zsX.startPreview();
            this.lPv.zsX.bqI();
            this.lPy = 1;
            AppMethodBeat.o(46197);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public final void bFM() {
        AppMethodBeat.i(46198);
        if (this.lPv == null) {
            Log.i("MicroMsg.AppBrandCameraView", "recordView is null");
            AppMethodBeat.o(46198);
            return;
        }
        bFR();
        bFQ();
        AppMethodBeat.o(46198);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public final void o(f fVar) {
        AppMethodBeat.i(46199);
        Log.i("MicroMsg.AppBrandCameraView", "listenFrameChange");
        if (this.lPt == null) {
            AppMethodBeat.o(46199);
        } else if (this.lPv == null) {
            Log.w("MicroMsg.AppBrandCameraView", "listenFrameChange recordView null");
            this.lPt.h("camera illegal state", -1, -1, -1);
            AppMethodBeat.o(46199);
        } else {
            if (this.lPC == null) {
                this.lPC = new d(fVar);
            }
            AnonymousClass6 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.AnonymousClass6 */

                public final void run() {
                    int i2;
                    AppMethodBeat.i(226717);
                    int i3 = AppBrandCameraView.this.lPv.getDrawSizePoint().x;
                    int i4 = AppBrandCameraView.this.lPv.getDrawSizePoint().y;
                    d dVar = AppBrandCameraView.this.lPC;
                    MMSightRecordView mMSightRecordView = AppBrandCameraView.this.lPv;
                    if (mMSightRecordView == null) {
                        Log.w("MicroMsg.FrameDataCallbackHelper", "listenFrameChange recordView null");
                        i2 = -1;
                    } else if (dVar.lPY == null) {
                        i2 = -2;
                    } else {
                        if (dVar.lQa != Integer.MIN_VALUE) {
                            Log.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", Integer.valueOf(dVar.lQa));
                            dVar.lPY.xZ(dVar.lQa);
                        }
                        dVar.lQa = dVar.lPY.yb(i3 * i4 * 4);
                        Log.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", Integer.valueOf(dVar.lQa), Integer.valueOf(i4), Integer.valueOf(i3));
                        dVar.lPZ = true;
                        mMSightRecordView.a(dVar.lPY.ya(dVar.lQa), dVar);
                        i2 = dVar.lQa;
                    }
                    if (i2 < 0) {
                        AppBrandCameraView.this.lPt.h(String.format(Locale.US, "illegal state:%d", Integer.valueOf(i2)), -1, -1, -1);
                        AppMethodBeat.o(226717);
                        return;
                    }
                    AppBrandCameraView.this.lPt.h(null, i2, i3, i4);
                    AppMethodBeat.o(226717);
                }
            };
            if (!this.lPD) {
                if (this.lPJ == null) {
                    this.lPJ = new ArrayList();
                }
                Log.i("MicroMsg.AppBrandCameraView", "listen frame change before camera init done");
                this.lPJ.add(r0);
                AppMethodBeat.o(46199);
                return;
            }
            r0.run();
            AppMethodBeat.o(46199);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public final void bFN() {
        AppMethodBeat.i(46200);
        if (this.lPt == null) {
            AppMethodBeat.o(46200);
        } else if (this.lPC == null) {
            AppMethodBeat.o(46200);
        } else {
            this.lPC.a(this.lPv);
            this.lPC = null;
            AppMethodBeat.o(46200);
        }
    }

    private void bFO() {
        AppMethodBeat.i(46201);
        this.irP = AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg");
        AppMethodBeat.o(46201);
    }

    private void bFP() {
        AppMethodBeat.i(46202);
        String str = "MicroMsg_" + System.currentTimeMillis();
        if (!s.YS(com.tencent.mm.loader.j.b.aKH())) {
            s.boN(com.tencent.mm.loader.j.b.aKH());
        }
        this.lPw = com.tencent.mm.loader.j.b.aKH() + str + ".mp4";
        this.lPx = com.tencent.mm.loader.j.b.aKH() + str + ".jpeg";
        if (this.lPv != null) {
            this.lPv.setVideoFilePath(this.lPw);
        }
        AppMethodBeat.o(46202);
    }

    private void bFQ() {
        AppMethodBeat.i(46203);
        if (this.lPv == null || this.lPe == null) {
            AppMethodBeat.o(46203);
            return;
        }
        AnonymousClass7 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(226718);
                if (AppBrandCameraView.this.lPe.equals("auto")) {
                    AppBrandCameraView.this.lPv.setFlashMode(3);
                    AppMethodBeat.o(226718);
                } else if (AppBrandCameraView.this.lPe.equals("torch")) {
                    AppBrandCameraView.this.lPv.setFlashMode(1);
                    AppMethodBeat.o(226718);
                } else {
                    if (AppBrandCameraView.this.lPe.equals("on")) {
                        if (AppBrandCameraView.this.lPy == 2 || AppBrandCameraView.this.lPy == 4 || !AppBrandCameraView.this.lPe.equals("on")) {
                            AppBrandCameraView.this.lPv.setFlashMode(1);
                            AppMethodBeat.o(226718);
                            return;
                        }
                    } else if (AppBrandCameraView.this.lPe.equals("torch")) {
                        AppBrandCameraView.this.lPv.setFlashMode(1);
                        AppMethodBeat.o(226718);
                        return;
                    }
                    AppBrandCameraView.this.lPv.setFlashMode(2);
                    AppMethodBeat.o(226718);
                }
            }
        };
        if (!this.lPD) {
            if (this.lPJ == null) {
                this.lPJ = new ArrayList();
            }
            this.lPJ.add(r0);
            Log.i("MicroMsg.AppBrandCameraView", "set flash mode before camera init done");
            AppMethodBeat.o(46203);
            return;
        }
        r0.run();
        AppMethodBeat.o(46203);
    }

    private void bFR() {
        AppMethodBeat.i(46204);
        Log.i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", this.lPa);
        bFS();
        this.lPc = ZI(this.lPa);
        this.lPc.init();
        AppMethodBeat.o(46204);
    }

    /* access modifiers changed from: protected */
    public a ZI(String str) {
        a bVar;
        AppMethodBeat.i(46205);
        if (Util.isNullOrNil(str) || !str.equals(JsApiScanCode.NAME)) {
            bVar = new b(this, (byte) 0);
        } else {
            bVar = new c(this);
        }
        AppMethodBeat.o(46205);
        return bVar;
    }

    private void bFS() {
        AppMethodBeat.i(46206);
        if (this.lPc != null) {
            this.lPc.release();
            this.lPc = null;
        }
        AppMethodBeat.o(46206);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public void setScanFreq(int i2) {
        AppMethodBeat.i(46207);
        Log.i("MicroMsg.AppBrandCameraView", "scanFreq:%d", Integer.valueOf(i2));
        if (i2 <= 0) {
            Log.e("MicroMsg.AppBrandCameraView", "scanFreq is err");
            AppMethodBeat.o(46207);
            return;
        }
        this.lPq = i2;
        AppMethodBeat.o(46207);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public final void x(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(46208);
        Log.i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        if (i4 <= 0 || i5 <= 0) {
            AppMethodBeat.o(46208);
            return;
        }
        this.lPp = new Rect(i2, i3, i2 + i4, i3 + i5);
        AppMethodBeat.o(46208);
    }

    /* access modifiers changed from: protected */
    public MMSightRecordView d(Context context, int i2, int i3) {
        return null;
    }

    /* access modifiers changed from: protected */
    public MMSightRecordView getRecordView() {
        return this.lPv;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public final void bFT() {
        AppMethodBeat.i(46209);
        if (this.lPc != null) {
            this.lPc.bFT();
        }
        AppMethodBeat.o(46209);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
    public final void bFU() {
        AppMethodBeat.i(46210);
        if (this.lPc != null) {
            this.lPc.bFU();
        }
        AppMethodBeat.o(46210);
    }

    private void bFV() {
        int i2 = TAVExporter.VIDEO_EXPORT_WIDTH;
        AppMethodBeat.i(46211);
        if (!Util.isNullOrNil(this.lPg)) {
            String str = this.lPg;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1078030475:
                    if (str.equals(FirebaseAnalytics.b.MEDIUM)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 107348:
                    if (str.equals("low")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3202466:
                    if (str.equals("high")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    i2 = 1080;
                    break;
                case 1:
                    i2 = 480;
                    break;
            }
        }
        if (this.lPb > i2) {
            Log.i("MicroMsg.AppBrandCameraView", "framesize is : %d, large than preview size: %d", Integer.valueOf(this.lPb), Integer.valueOf(i2));
            i2 = this.lPb;
        }
        this.lPv.setPreviewSizeLimit(i2);
        AppMethodBeat.o(46211);
    }

    /* access modifiers changed from: package-private */
    public class b implements a {
        private b() {
        }

        /* synthetic */ b(AppBrandCameraView appBrandCameraView, byte b2) {
            this();
        }

        static /* synthetic */ void a(b bVar, String str) {
            AppMethodBeat.i(226720);
            bVar.d(-1, str, null, null);
            AppMethodBeat.o(226720);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a
        public final void init() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a
        public final void C(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(46157);
            if (!AppBrandCameraView.this.lPj) {
                AppMethodBeat.o(46157);
            } else {
                AppMethodBeat.o(46157);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a
        public final void bFK() {
            AppMethodBeat.i(46158);
            Log.i("MicroMsg.AppBrandCameraView", "takePicture.");
            if (AppBrandCameraView.this.lPv == null) {
                Log.i("MicroMsg.AppBrandCameraView", "recordView is null");
                AppMethodBeat.o(46158);
            } else if (AppBrandCameraView.this.lPy == 2) {
                Log.w("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
                AppMethodBeat.o(46158);
            } else if (AppBrandCameraView.this.lPz || Util.ticksToNow(AppBrandCameraView.this.lPA) < 300) {
                Log.i("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
                AppMethodBeat.o(46158);
            } else if (!AppBrandCameraView.this.lPD) {
                Log.w("MicroMsg.AppBrandCameraView", "takePicture err, isn't init done");
                AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "camera has not been initialized");
                AppMethodBeat.o(46158);
            } else {
                AppBrandCameraView.this.lPA = Util.currentTicks();
                AppBrandCameraView.this.lPz = true;
                AppBrandCameraView.this.lPy = 3;
                AppBrandCameraView.this.lPv.a(new MMSightRecordView.g() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g
                    public final void R(Bitmap bitmap) {
                        AppMethodBeat.i(46151);
                        if (bitmap == null) {
                            AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "bitmap is null");
                            AppMethodBeat.o(46151);
                        } else if (b.this.a(bitmap, AppBrandCameraView.this.irP)) {
                            AppBrandCameraView.a(AppBrandCameraView.this, 0, b.f(AppBrandCameraView.this.lOZ, AppBrandCameraView.this.irP), "");
                            AppMethodBeat.o(46151);
                        } else {
                            AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "save fail");
                            AppMethodBeat.o(46151);
                        }
                    }

                    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g
                    public final void bFZ() {
                        AppMethodBeat.i(46152);
                        AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "take picture error");
                        AppMethodBeat.o(46152);
                    }
                }, "on".equals(AppBrandCameraView.this.lPe));
                AppMethodBeat.o(46158);
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean a(Bitmap bitmap, String str) {
            AppMethodBeat.i(46159);
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    AppBrandCameraView.this.lPn = bitmap.getWidth();
                    AppBrandCameraView.this.lPo = bitmap.getHeight();
                    int i2 = 90;
                    if ("normal".equals(AppBrandCameraView.this.lPf)) {
                        i2 = 44;
                    } else if ("low".equals(AppBrandCameraView.this.lPf)) {
                        i2 = 25;
                    }
                    BitmapUtil.saveBitmapToImage(bitmap, i2, Bitmap.CompressFormat.JPEG, str, true);
                    Log.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", Long.valueOf(s.boW(str)));
                    AppMethodBeat.o(46159);
                    return true;
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", e2.getMessage());
                }
            }
            AppMethodBeat.o(46159);
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a
        public final void bFT() {
            boolean z;
            AppMethodBeat.i(46160);
            Log.i("MicroMsg.AppBrandCameraView", "startRecord.");
            a aVar = a.C0654a.lOY;
            if (!aVar.lOV || !aVar.lOW) {
                Log.i("MicroMsg.AppBrandCameraMrg", "no all permission");
            }
            if (!aVar.lOV || !aVar.lOW) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                Toast.makeText(AppBrandCameraView.this.mContext, (int) R.string.f10, 1).show();
                Log.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
                aj(-1, "permission");
                AppMethodBeat.o(46160);
            } else if (AppBrandCameraView.this.lPy == 2) {
                Log.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
                aj(-1, "is recording");
                AppMethodBeat.o(46160);
            } else if (!AppBrandCameraView.this.lPD) {
                Log.w("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
                aj(-1, "camera has not been initialized");
                AppMethodBeat.o(46160);
            } else if (AppBrandCameraView.this.lPv.zsX.aai()) {
                AppBrandCameraView.this.lPB = Util.currentTicks();
                AppBrandCameraView.this.lPy = 2;
                aj(0, "");
                AppBrandCameraView.A(AppBrandCameraView.this);
                AppMethodBeat.o(46160);
            } else {
                Log.w("MicroMsg.AppBrandCameraView", "startRecord fail !!");
                aj(-1, "startRecord fail");
                AppMethodBeat.o(46160);
            }
        }

        private void aj(int i2, String str) {
            AppMethodBeat.i(46161);
            if (AppBrandCameraView.this.lPt != null) {
                AppBrandCameraView.this.lPt.aj(i2, str);
            }
            AppMethodBeat.o(46161);
        }

        public final void stopRecord() {
            AppMethodBeat.i(46162);
            Log.i("MicroMsg.AppBrandCameraView", JsApiStopRecordVoice.NAME);
            if (AppBrandCameraView.this.lPv == null) {
                Log.i("MicroMsg.AppBrandCameraView", "recordView is null");
                d(-1, "camera is null", null, null);
                AppMethodBeat.o(46162);
            } else if (AppBrandCameraView.this.lPy != 2) {
                Log.w("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
                d(-1, "is not recording", null, null);
                AppMethodBeat.o(46162);
            } else if (AppBrandCameraView.this.lPk) {
                Log.i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
                d(-1, "is stopping", null, null);
                AppMethodBeat.o(46162);
            } else {
                AppBrandCameraView.this.lPk = true;
                AppBrandCameraView.this.lPv.a(new MMSightRecordView.h() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h
                    public final void hs(boolean z) {
                        AppMethodBeat.i(46153);
                        Log.i("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", Boolean.valueOf(z));
                        if (AppBrandCameraView.this.lPv == null) {
                            Log.i("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
                            b.a(b.this, "camera is null");
                            AppMethodBeat.o(46153);
                            return;
                        }
                        AppBrandCameraView.this.lPy = 1;
                        if (z) {
                            b.a(b.this, "stop error");
                            b.this.bFY();
                            AppMethodBeat.o(46153);
                        } else if (AppBrandCameraView.this.lPi) {
                            com.tencent.f.h.RTc.aX(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(46155);
                                    final String str = null;
                                    try {
                                        str = t.aaf(AppBrandCameraView.this.lPv.getVideoFilePath());
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.AppBrandCameraView", "stopRecord, remux failed, callback with origin videoexp = %s", Util.stackTraceToString(e2));
                                    }
                                    m.runOnUiThread(new Runnable() {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b.AnonymousClass3.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(46154);
                                            b.b(b.this, str);
                                            AppMethodBeat.o(46154);
                                        }
                                    });
                                    AppMethodBeat.o(46155);
                                }
                            });
                            AppMethodBeat.o(46153);
                        } else {
                            b.b(b.this, AppBrandCameraView.this.lPv.getVideoFilePath());
                            AppMethodBeat.o(46153);
                        }
                    }
                });
                AppMethodBeat.o(46162);
            }
        }

        /* access modifiers changed from: package-private */
        public final void bFY() {
            AppMethodBeat.i(46163);
            AppBrandCameraView.E(AppBrandCameraView.this);
            AppBrandCameraView.this.lPk = false;
            AppMethodBeat.o(46163);
        }

        private void d(int i2, String str, String str2, String str3) {
            int i3;
            int i4;
            int i5;
            AppMethodBeat.i(46164);
            if (AppBrandCameraView.this.lPt != null) {
                long j2 = 0;
                if (i2 == 0) {
                    int[] iArr = new int[3];
                    c(str3, iArr);
                    i5 = (int) Math.round((((double) iArr[0]) * 1.0d) / 1000.0d);
                    j2 = s.boW(str3);
                    i4 = iArr[1];
                    i3 = iArr[2];
                } else {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                }
                AppBrandCameraView.this.lPt.a(i2, str, f(AppBrandCameraView.this.lOZ, str2), f(AppBrandCameraView.this.lOZ, str3), i5, j2, i4, i3);
            }
            AppBrandCameraView.A(AppBrandCameraView.this);
            AppMethodBeat.o(46164);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a
        public final void bFU() {
            AppMethodBeat.i(46165);
            long ticksToNow = Util.ticksToNow(AppBrandCameraView.this.lPB);
            if (ticksToNow < 1500) {
                Log.i("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", Long.valueOf(1500 - ticksToNow));
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(46156);
                        b.this.stopRecord();
                        AppMethodBeat.o(46156);
                    }
                }, 1500 - ticksToNow);
                AppMethodBeat.o(46165);
                return;
            }
            stopRecord();
            AppMethodBeat.o(46165);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x008c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void c(java.lang.String r5, int[] r6) {
            /*
            // Method dump skipped, instructions count: 150
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b.c(java.lang.String, int[]):void");
        }

        static String f(f fVar, String str) {
            AppMethodBeat.i(46167);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(46167);
                return str;
            }
            com.tencent.mm.plugin.appbrand.ac.i<String> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
            if (fVar.getFileSystem().a(new o(str), "", true, iVar) == com.tencent.mm.plugin.appbrand.appstorage.m.OK) {
                T t = iVar.value;
                AppMethodBeat.o(46167);
                return t;
            }
            AppMethodBeat.o(46167);
            return null;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a
        public final void release() {
        }

        static /* synthetic */ void b(b bVar, String str) {
            AppMethodBeat.i(226721);
            if (Util.isNullOrNil(str)) {
                bVar.d(-1, "record file not exist", AppBrandCameraView.this.lPx, str);
            } else {
                bVar.a(d.PF(str), AppBrandCameraView.this.lPx);
                bVar.d(0, "", AppBrandCameraView.this.lPx, str);
            }
            bVar.bFY();
            AppMethodBeat.o(226721);
        }
    }

    /* access modifiers changed from: protected */
    public class c implements a, c.a {
        private int duration = this.lPS;
        private float ilP = ((((float) this.lPL.lPl) * 1.0f) / ((float) this.lPL.lPm));
        private Point kyC;
        final /* synthetic */ AppBrandCameraView lPL;
        private com.tencent.mm.plugin.appbrand.jsapi.camera.a.c lPQ;
        AtomicBoolean lPR = new AtomicBoolean(false);
        private int lPS = 200;
        private Rect lPT;
        private int lPU;
        int lPV;
        private int lPW;
        private int previewHeight;
        private int previewWidth;

        protected c(AppBrandCameraView appBrandCameraView) {
            int i2 = 0;
            this.lPL = appBrandCameraView;
            AppMethodBeat.i(46171);
            this.lPV = this.lPL.lPh ? 1 : i2;
            AppMethodBeat.o(46171);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a
        public void init() {
            AppMethodBeat.i(46172);
            this.lPQ = new com.tencent.mm.plugin.appbrand.jsapi.camera.a.d();
            this.lPQ.init();
            this.lPQ.lQL = this;
            this.lPL.lPy = 4;
            if (this.lPL.lPq > 0) {
                this.duration = 1000 / this.lPL.lPq;
            }
            this.lPW = 0;
            AppMethodBeat.o(46172);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a
        public final void C(byte[] bArr, int i2, int i3) {
            int i4;
            Point point;
            Rect rect;
            boolean z = false;
            AppMethodBeat.i(46173);
            if (!(this.previewWidth == this.lPL.lPl && this.previewHeight == this.lPL.lPm)) {
                switch (this.lPL.mWindowManager.getDefaultDisplay().getRotation()) {
                    case 1:
                        i4 = 90;
                        break;
                    case 2:
                        i4 = TXLiveConstants.RENDER_ROTATION_180;
                        break;
                    case 3:
                        i4 = 270;
                        break;
                    default:
                        i4 = 0;
                        break;
                }
                int cameraRotation = this.lPL.lPv.getCameraRotation();
                if ("front".equals(this.lPL.cHZ)) {
                    this.lPU = cameraRotation % v2helper.VOIP_ENC_HEIGHT_LV1;
                    this.lPU = (360 - this.lPU) % v2helper.VOIP_ENC_HEIGHT_LV1;
                } else {
                    this.lPU = ((cameraRotation - i4) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
                }
                if (this.lPL.lPv != null) {
                    this.previewWidth = this.lPL.lPl;
                    this.previewHeight = this.lPL.lPm;
                }
                int unused = this.lPL.lPl;
                int unused2 = this.lPL.lPm;
                int i5 = this.lPU;
                float f2 = this.ilP;
                if (i2 <= 0 || i3 <= 0) {
                    point = null;
                } else {
                    if (i5 == 90 || i5 == 270) {
                        f2 = 1.0f / f2;
                    }
                    if (((float) i3) * f2 < ((float) i2)) {
                        z = true;
                    }
                    float f3 = 1.0f / f2;
                    if (!z) {
                        this.lPV = 1;
                        int max = Math.max(i3, i2);
                        int i6 = (int) (f3 * ((float) max));
                        if (i5 == 90 || i5 == 270) {
                            point = new Point(i6, max);
                        } else {
                            point = new Point(max, i6);
                        }
                    } else {
                        int min = Math.min(i3, i2);
                        int i7 = (int) (((float) min) / f3);
                        if (i5 == 90 || i5 == 270) {
                            point = new Point(min, i7);
                        } else {
                            point = new Point(i7, min);
                        }
                    }
                }
                this.kyC = point;
                if (this.kyC != null) {
                    Rect rect2 = this.lPL.lPp;
                    int i8 = this.lPL.lPl;
                    int i9 = this.kyC.x;
                    if (rect2 == null) {
                        rect = null;
                    } else {
                        float f4 = (((float) i8) * 1.0f) / ((float) i9);
                        rect = new Rect(Math.round(((float) rect2.left) / f4), Math.round(((float) rect2.top) / f4), Math.round(((float) rect2.right) / f4), Math.round(((float) rect2.bottom) / f4));
                    }
                    this.lPT = rect;
                }
            }
            if (this.lPR.get()) {
                Log.d("MicroMsg.AppBrandCameraView", "[onFrameData] isScanPause, return");
                AppMethodBeat.o(46173);
                return;
            }
            if (!(this.lPQ == null || this.lPL.lPv == null)) {
                this.lPQ.b(bArr, i2, i3, this.lPL.lPl, this.lPL.lPm, this.kyC, this.lPT, this.lPU, this.lPV);
            }
            AppMethodBeat.o(46173);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.a
        public final void a(int i2, int i3, String str, byte[] bArr, QbarNative.QBarPoint qBarPoint) {
            AppMethodBeat.i(226722);
            if (this.lPR.compareAndSet(false, true)) {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(46170);
                        c.this.lPR.set(false);
                        AppMethodBeat.o(46170);
                    }
                }, (long) this.duration);
                Log.d("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d, codeVersion:%d", str, Integer.valueOf(i2), Integer.valueOf(i3));
                if (qBarPoint != null && this.lPW % 4 == 0) {
                    Log.i("MicroMsg.AppBrandCameraView", "x: %f, y: %f, w: %f, h: %f; x0:%f, x1:%f, x2:%f, x3:%f, y0:%f, y1:%f, y2:%f, y3:%f", Float.valueOf(qBarPoint.x0), Float.valueOf(qBarPoint.y0), Float.valueOf(qBarPoint.x1 - qBarPoint.x0), Float.valueOf(qBarPoint.y3 - qBarPoint.y0), Float.valueOf(qBarPoint.x0), Float.valueOf(qBarPoint.x1), Float.valueOf(qBarPoint.x2), Float.valueOf(qBarPoint.x3), Float.valueOf(qBarPoint.y0), Float.valueOf(qBarPoint.y1), Float.valueOf(qBarPoint.y2), Float.valueOf(qBarPoint.y3));
                    this.lPW++;
                }
                switch (i2) {
                    case 1:
                        j.a(this.lPL.lOZ, this.lPL.getCameraId(), "qrcode", i3, str, bArr, qBarPoint);
                        AppMethodBeat.o(226722);
                        return;
                    case 2:
                        j.a(this.lPL.lOZ, this.lPL.getCameraId(), "barcode", i3, str, bArr, qBarPoint);
                        AppMethodBeat.o(226722);
                        return;
                    default:
                        Log.w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
                        break;
                }
            }
            AppMethodBeat.o(226722);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a
        public final void bFK() {
            AppMethodBeat.i(46175);
            Log.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
            AppMethodBeat.o(46175);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a
        public final void bFT() {
            AppMethodBeat.i(46176);
            Log.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
            AppMethodBeat.o(46176);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a
        public final void bFU() {
            AppMethodBeat.i(46177);
            Log.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
            AppMethodBeat.o(46177);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a
        public final void release() {
            AppMethodBeat.i(46178);
            if (this.lPQ != null) {
                this.lPQ.release();
            }
            this.kyC = null;
            this.lPW = 0;
            AppMethodBeat.o(46178);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
    public final void onBackground() {
        Bitmap currentFramePicture;
        AppMethodBeat.i(46191);
        Log.i("MicroMsg.AppBrandCameraView", "onUIPause");
        if (this.lPs) {
            this.lPK.disable();
        }
        if (this.lPy == 2) {
            Log.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
            HashMap hashMap = new HashMap();
            hashMap.put("cameraId", Integer.valueOf(this.lPd));
            hashMap.put("errMsg", "stop on record");
            new m().h(this.lOZ).Zh(new JSONObject(hashMap).toString()).bEo();
        }
        if (!(this.lPv == null || (currentFramePicture = this.lPv.getCurrentFramePicture()) == null)) {
            this.dKU.setImageBitmap(currentFramePicture);
        }
        if (this.lPC != null) {
            d dVar = this.lPC;
            MMSightRecordView mMSightRecordView = this.lPv;
            Log.i("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", Boolean.valueOf(dVar.lPZ));
            if (mMSightRecordView == null) {
                Log.w("MicroMsg.FrameDataCallbackHelper", "onUIPause recordView null");
            } else {
                mMSightRecordView.a((ByteBuffer) null, (MMSightRecordView.f) null);
            }
        }
        release();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("cameraId", Integer.valueOf(getCameraId()));
        new k().h(this.lOZ).Zh(new JSONObject(hashMap2).toString()).bEo();
        AppMethodBeat.o(46191);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
    public final void onForeground() {
        AppMethodBeat.i(46192);
        Log.i("MicroMsg.AppBrandCameraView", "onUIResume");
        synchronized (AppBrandCameraView.class) {
            try {
                if (this.lPs) {
                    this.lPK.jHZ = 60;
                    this.lPK.enable();
                }
                if (!this.lPI.get()) {
                    Log.w("MicroMsg.AppBrandCameraView", "no execute initView");
                    return;
                }
                bFL();
                bFM();
                if (this.lPC != null) {
                    d dVar = this.lPC;
                    MMSightRecordView mMSightRecordView = this.lPv;
                    Log.i("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", Boolean.valueOf(dVar.lPZ));
                    if (dVar.lPZ) {
                        if (mMSightRecordView == null) {
                            Log.w("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
                        } else if (dVar.lQa == Integer.MIN_VALUE) {
                            Log.w("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
                        } else if (dVar.lPY == null) {
                            Log.w("MicroMsg.FrameDataCallbackHelper", "onUIResume mSharedBufferAddon null");
                        } else {
                            mMSightRecordView.a(dVar.lPY.ya(dVar.lQa), dVar);
                        }
                    }
                }
                AppMethodBeat.o(46192);
            } finally {
                AppMethodBeat.o(46192);
            }
        }
    }

    static /* synthetic */ boolean a(AppBrandCameraView appBrandCameraView) {
        AppMethodBeat.i(226725);
        if (Settings.System.getInt(appBrandCameraView.getContext().getContentResolver(), "accelerometer_rotation", 0) == 0) {
            AppMethodBeat.o(226725);
            return true;
        }
        AppMethodBeat.o(226725);
        return false;
    }

    static /* synthetic */ boolean b(AppBrandCameraView appBrandCameraView) {
        AppMethodBeat.i(226726);
        if (!(appBrandCameraView.mContext instanceof Activity)) {
            AppMethodBeat.o(226726);
            return true;
        }
        Activity activity = (Activity) appBrandCameraView.mContext;
        if (activity.getRequestedOrientation() == 0 || activity.getRequestedOrientation() == 1) {
            AppMethodBeat.o(226726);
            return true;
        }
        AppMethodBeat.o(226726);
        return false;
    }

    static /* synthetic */ void d(AppBrandCameraView appBrandCameraView) {
        AppMethodBeat.i(226727);
        if (appBrandCameraView.lPG) {
            Log.i("MicroMsg.AppBrandCameraView", "camera already in pre rotate mode");
            AppMethodBeat.o(226727);
            return;
        }
        appBrandCameraView.lPG = true;
        final ad.a aVar = appBrandCameraView.lPH;
        Log.i("MicroMsg.AppBrandCameraView", "wait for another release called");
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(226719);
                Log.i("MicroMsg.AppBrandCameraView", "currentOrientationRecord %s, lateOrientationState: %s", aVar.toString(), AppBrandCameraView.this.lPH.toString());
                if (Util.ticksToNow(AppBrandCameraView.this.lPF) >= 750 && AppBrandCameraView.this.lPI.get() && aVar == AppBrandCameraView.this.lPH) {
                    Log.i("MicroMsg.AppBrandCameraView", "reopen camera");
                    AppBrandCameraView.this.release();
                    AppBrandCameraView.this.initView();
                }
                AppBrandCameraView.this.lPG = false;
                AppMethodBeat.o(226719);
            }
        }, 750);
        AppMethodBeat.o(226727);
    }

    static /* synthetic */ void a(AppBrandCameraView appBrandCameraView, int i2, String str, String str2) {
        AppMethodBeat.i(226728);
        Log.i("MicroMsg.AppBrandCameraView", "onTakePhoto.ret:%d, path:%s, errMsg:%s", Integer.valueOf(i2), str, str2);
        if (appBrandCameraView.lPt != null) {
            appBrandCameraView.lPt.a(i2, str, str2, appBrandCameraView.lPn, appBrandCameraView.lPo);
        }
        appBrandCameraView.lPz = false;
        appBrandCameraView.bFO();
        appBrandCameraView.lPy = 1;
        AppMethodBeat.o(226728);
    }
}

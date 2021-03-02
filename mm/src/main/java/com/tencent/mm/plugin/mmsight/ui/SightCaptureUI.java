package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.pm;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.jsapi.audio.g;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.a.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.l;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.b;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.s;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.wxmm.v2helper;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import org.json.JSONObject;

@a(3)
public class SightCaptureUI extends MMActivity implements d.a, d.a {
    private com.tencent.f.i.d dwt;
    private String ebj = "";
    private com.tencent.mm.remoteservice.d gVN = new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext());
    private ImageView hQv;
    private VideoTransPara irT;
    private ViewGroup jLy;
    private b jvG;
    private com.tencent.mm.plugin.mmsight.model.a.d kxS;
    private ObservableTextureView kyv;
    private long lPA = -1;
    private int lPy = -1;
    private boolean lPz = false;
    private ViewGroup oot;
    private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
    private MMSightCaptureTouchView rsW;
    private View ygS;
    private int zCN = 1;
    private boolean zCO = true;
    private f zCP;
    private MMSightRecordButton zCQ;
    private View zCR;
    private View zCS;
    private ViewGroup zCT;
    private ImageView zCU;
    private SurfaceTexture zCV;
    CameraFrontSightView zCW;
    private ViewGroup zCX;
    private ImageView zCY;
    private MMSightCameraGLSurfaceView zCZ;
    private String zDA;
    private String zDB;
    private boolean zDC;
    private Bundle zDD;
    private Runnable zDE = new Runnable() {
        /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass19 */

        public final void run() {
            AppMethodBeat.i(94663);
            if (SightCaptureUI.this.lPy != 4) {
                Log.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
                SightCaptureUI.b(SightCaptureUI.this, 9);
            }
            AppMethodBeat.o(94663);
        }
    };
    private com.tencent.mm.plugin.mmsight.ui.cameraglview.a zDa;
    private TextView zDb;
    private View zDc;
    private MMSightTopCountdownCoverView zDd;
    private b zDe;
    private boolean zDf = true;
    private cly zDg = new cly();
    private byte[] zDh;
    private int zDi;
    private int zDj;
    private int zDk;
    private int zDl;
    private byte[] zDm;
    private int zDn;
    private boolean zDo = false;
    private boolean zDp = false;
    private boolean zDq = false;
    private int zDr = 0;
    private int zDs = 0;
    private long zDt = -1;
    private boolean zDu = false;
    private boolean zDv = false;
    private Boolean zDw = Boolean.FALSE;
    private Point zDx;
    private IListener zDy = new IListener<ko>() {
        /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass12 */

        {
            AppMethodBeat.i(161731);
            this.__eventId = ko.class.getName().hashCode();
            AppMethodBeat.o(161731);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ko koVar) {
            AppMethodBeat.i(94650);
            ko koVar2 = koVar;
            if (!(koVar2 == null || koVar2.dPG == null)) {
                Log.i("MicroMsg.SightCaptureUI", "summerhardcoder system event [%s] backCamera[%s]", Integer.valueOf(koVar2.dPG.keycode), Boolean.valueOf(SightCaptureUI.this.zDf));
                if (koVar2.dPG.keycode == 1 && SightCaptureUI.this.zDf) {
                    SightCaptureUI.d(SightCaptureUI.this);
                }
            }
            AppMethodBeat.o(94650);
            return false;
        }
    };
    private Runnable zDz = new Runnable() {
        /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass18 */

        public final void run() {
            AppMethodBeat.i(94662);
            if (SightCaptureUI.this.lPy == 7 && SightCaptureUI.this.zCQ != null) {
                Log.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
                SightCaptureUI.this.zCQ.showLoading();
            }
            AppMethodBeat.o(94662);
        }
    };
    private int zsH = 2;
    private SightParams zwk;
    private VideoPlayerTextureView zyd;
    private VideoSeekBarEditorView zye;
    private j.a zyk = new j.a() {
        /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass20 */

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void onError(int i2, int i3) {
            AppMethodBeat.i(94666);
            Log.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", Integer.valueOf(SightCaptureUI.this.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(94666);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void tf() {
            AppMethodBeat.i(94667);
            if (SightCaptureUI.this.zyd != null) {
                SightCaptureUI.this.zyd.start();
                SightCaptureUI.this.zyd.setLoop(true);
            }
            MMHandlerThread.removeRunnable(SightCaptureUI.this.zDE);
            SightCaptureUI.this.zyd.setOneTimeVideoTextureUpdateCallback(new j.e() {
                /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass20.AnonymousClass1 */

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.e
                public final void bLh() {
                    AppMethodBeat.i(94665);
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass20.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(94664);
                            Log.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
                            if (SightCaptureUI.this.zyd == null) {
                                AppMethodBeat.o(94664);
                                return;
                            }
                            SightCaptureUI.this.zyd.setAlpha(1.0f);
                            SightCaptureUI.b(SightCaptureUI.this, 4);
                            SightCaptureUI.F(SightCaptureUI.this);
                            AppMethodBeat.o(94664);
                        }
                    }, 50);
                    if (SightCaptureUI.this.zwk.zsP) {
                        SightCaptureUI.this.zCU.setVisibility(0);
                    }
                    AppMethodBeat.o(94665);
                }
            });
            AppMethodBeat.o(94667);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void onCompletion() {
            AppMethodBeat.i(94668);
            SightCaptureUI.this.zyd.d(0.0d, true);
            AppMethodBeat.o(94668);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final int fh(int i2, int i3) {
            return 0;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void eo(int i2, int i3) {
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SightCaptureUI() {
        AppMethodBeat.i(94679);
        AppMethodBeat.o(94679);
    }

    static /* synthetic */ void B(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(184543);
        sightCaptureUI.elb();
        AppMethodBeat.o(184543);
    }

    static /* synthetic */ boolean I(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94724);
        boolean rn = sightCaptureUI.rn(false);
        AppMethodBeat.o(94724);
        return rn;
    }

    static /* synthetic */ String QV(int i2) {
        AppMethodBeat.i(94725);
        String QU = QU(i2);
        AppMethodBeat.o(94725);
        return QU;
    }

    static /* synthetic */ void a(SightCaptureUI sightCaptureUI, boolean z) {
        AppMethodBeat.i(94717);
        sightCaptureUI.ro(z);
        AppMethodBeat.o(94717);
    }

    static /* synthetic */ void b(SightCaptureUI sightCaptureUI, int i2) {
        AppMethodBeat.i(184542);
        sightCaptureUI.BH(i2);
        AppMethodBeat.o(184542);
    }

    static /* synthetic */ void d(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94706);
        sightCaptureUI.ekT();
        AppMethodBeat.o(94706);
    }

    static /* synthetic */ int m(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94709);
        int ekW = sightCaptureUI.ekW();
        AppMethodBeat.o(94709);
        return ekW;
    }

    static /* synthetic */ void r(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94713);
        sightCaptureUI.stopRecord();
        AppMethodBeat.o(94713);
    }

    static /* synthetic */ void s(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94714);
        sightCaptureUI.ekV();
        AppMethodBeat.o(94714);
    }

    static /* synthetic */ boolean w(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94718);
        boolean eld = sightCaptureUI.eld();
        AppMethodBeat.o(94718);
        return eld;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(94680);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        this.zwk = (SightParams) getIntent().getParcelableExtra("KEY_SIGHT_PARAMS");
        if (this.zwk == null) {
            Log.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
            AppMethodBeat.o(94680);
            return;
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.gVN));
        final long currentTicks = Util.currentTicks();
        this.gVN.connect(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(94632);
                Log.i("MicroMsg.SightCaptureUI", "connect cost %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
                k.d(SightCaptureUI.this.zwk.irT);
                SightCaptureUI.b(SightCaptureUI.this);
                AppMethodBeat.o(94632);
            }
        });
        EventCenter.instance.addListener(this.zDy);
        AppMethodBeat.o(94680);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(94681);
        if (ae.gKt.gFC == 1 && i2 == 700 && this.zDf) {
            ekT();
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(94681);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(94682);
        super.onPause();
        Log.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", QU(this.lPy));
        if (this.lPy == 2) {
            stopRecord();
            AppMethodBeat.o(94682);
        } else if (this.lPy == 1) {
            elb();
            AppMethodBeat.o(94682);
        } else {
            if (this.lPy == 4 && this.zyd != null) {
                this.zyd.pause();
            }
            AppMethodBeat.o(94682);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        boolean z = false;
        AppMethodBeat.i(94683);
        super.onResume();
        setSelfNavigationBarVisible(8);
        Object[] objArr = new Object[2];
        objArr[0] = QU(this.lPy);
        if (this.kyv != null && this.kyv.isAvailable()) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        Log.i("MicroMsg.SightCaptureUI", "onResume, currentState: %s, textureview available: %s", objArr);
        if (this.lPy == 2 || this.lPy == 1) {
            ekV();
            AppMethodBeat.o(94683);
            return;
        }
        if (this.lPy == 4) {
            if (this.kyv != null) {
                if (this.kyv.isAvailable()) {
                    this.zDa.aEy();
                } else {
                    this.kyv.setTextureChangeCallback(new com.tencent.mm.plugin.video.b() {
                        /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass21 */

                        @Override // com.tencent.mm.plugin.video.b
                        public final void f(SurfaceTexture surfaceTexture) {
                            AppMethodBeat.i(94669);
                            SightCaptureUI.this.zDa.aEy();
                            SightCaptureUI.this.kyv.setTextureChangeCallback(null);
                            AppMethodBeat.o(94669);
                        }
                    });
                }
            }
            if (this.zyd != null) {
                this.zyd.start();
                AppMethodBeat.o(94683);
                return;
            }
        } else if (this.lPy == 3) {
            if (this.kyv != null) {
                this.kyv.setTextureChangeCallback(null);
            }
            this.zDa.a(this.zDm, this.zDq, this.zDn);
        }
        AppMethodBeat.o(94683);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(94684);
        super.onConfigurationChanged(configuration);
        if (this.zDw.booleanValue() && com.tencent.mm.compatible.util.d.oD(13)) {
            Point point = new Point(configuration.screenWidthDp, configuration.screenHeightDp);
            if (this.zDx == null || !this.zDx.equals(point)) {
                this.zDx = point;
                ekV();
            }
        }
        AppMethodBeat.o(94684);
    }

    private void ekT() {
        AppMethodBeat.i(94685);
        if (this.zDt <= 0 || Util.ticksToNow(this.zDt) > 500) {
            Log.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", Util.getStack().toString(), Integer.valueOf(this.lPy));
            ekZ();
            this.zDo = true;
            if (this.lPy == 2) {
                if (this.kxS == null || !this.kxS.aQR()) {
                    Log.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
                } else {
                    elc();
                    this.zDp = true;
                }
            } else if (this.lPy == 1) {
                BH(6);
                if (rn(true)) {
                    BH(1);
                }
            }
            ela();
            this.zDt = Util.currentTicks();
            AppMethodBeat.o(94685);
            return;
        }
        Log.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
        AppMethodBeat.o(94685);
    }

    private void stopRecord() {
        AppMethodBeat.i(94686);
        Log.printInfoStack("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", Integer.valueOf(this.lPy));
        if (this.lPy == 2) {
            ekY();
        }
        AppMethodBeat.o(94686);
    }

    private void ekU() {
        AppMethodBeat.i(94687);
        try {
            ViewGroup.LayoutParams layoutParams = this.zyd.getLayoutParams();
            this.oot.removeView(this.zyd);
            this.oot.addView(this.zyd, 0, layoutParams);
            AppMethodBeat.o(94687);
        } catch (Exception e2) {
            Log.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", e2.getMessage());
            AppMethodBeat.o(94687);
        }
    }

    private void ekV() {
        AppMethodBeat.i(94688);
        BH(0);
        this.zDs = 0;
        this.lPz = false;
        this.zDv = false;
        if (this.zyd != null) {
            this.zyd.stop();
            this.zyd.setVideoCallback(null);
            ekU();
        }
        if (this.zDe != null) {
            this.zDe.release();
            this.zDe = null;
        }
        if (this.zCZ != null) {
            this.zCZ.setVisibility(0);
        }
        this.zCY.setImageBitmap(null);
        elb();
        this.zCP = new f(this.irT, this.zwk.scene);
        this.zCP.a(this.zDa.iqW);
        this.zDd.setVisibility(8);
        if (!this.zCP.D(this, this.zDf)) {
            BH(8);
            AppMethodBeat.o(94688);
            return;
        }
        if (this.kyv.isAvailable()) {
            this.zCV = this.kyv.getSurfaceTexture();
            Log.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", this.zCV);
            if (rn(false)) {
                BH(1);
            } else {
                BH(8);
            }
        } else {
            this.kyv.setTextureChangeCallback(new com.tencent.mm.plugin.video.b() {
                /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass8 */

                @Override // com.tencent.mm.plugin.video.b
                public final void f(SurfaceTexture surfaceTexture) {
                    AppMethodBeat.i(94644);
                    Log.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", surfaceTexture);
                    SightCaptureUI.this.zCV = surfaceTexture;
                    if (SightCaptureUI.I(SightCaptureUI.this)) {
                        SightCaptureUI.b(SightCaptureUI.this, 1);
                        AppMethodBeat.o(94644);
                        return;
                    }
                    SightCaptureUI.b(SightCaptureUI.this, 8);
                    AppMethodBeat.o(94644);
                }
            });
        }
        if (this.zDb != null && this.zCO) {
            this.zDb.setAlpha(1.0f);
            this.zDb.setVisibility(0);
        }
        this.orientationEventListener.reset();
        this.zDo = false;
        this.zDp = false;
        AppMethodBeat.o(94688);
    }

    private boolean rn(boolean z) {
        AppMethodBeat.i(94689);
        Log.printDebugStack("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", this.zCV);
        this.zDv = false;
        if (this.kxS != null) {
            if (this.zCP != null) {
                this.zCP.b(this.kxS.getFrameDataCallback());
            }
            this.kxS.cancel();
        }
        if (this.zCP == null) {
            AppMethodBeat.o(94689);
            return false;
        }
        this.zDg = new cly();
        this.zDg.Mrn = true;
        this.zDg.Mrm = k.zuy.zuN;
        if (this.zwk != null) {
            this.zDg.Mro = this.zwk.scene;
        }
        if (z) {
            boolean a2 = this.zCP.a((Context) this, this.zCV, true);
            this.zDf = this.zCP.aPB();
            if (!a2) {
                AppMethodBeat.o(94689);
                return false;
            }
        } else if (this.zCP.a(this.zCV, true) < 0) {
            AppMethodBeat.o(94689);
            return false;
        }
        if (this.zCP.getEncodeVideoBestSize() == null) {
            AppMethodBeat.o(94689);
            return false;
        }
        l.ekc();
        this.kxS = l.q(this.irT);
        if (this.kxS == null) {
            Log.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
            this.zDv = true;
            AppMethodBeat.o(94689);
            return false;
        }
        com.tencent.mm.plugin.mmsight.d.a(this.kxS, this.zwk);
        this.kxS.a(this);
        this.zCP.a(this.kxS.getFrameDataCallback());
        if (this.zDa != null) {
            this.zDa.aq(this.zCP.getPreviewWidth(), this.zCP.getPreviewHeight(), this.zCP.getOrientation());
        }
        if (this.zwk != null && this.zwk.scene == 3 && ((this.zwk.mode == 2 || this.zwk.mode == 0) && !Util.isNullOrNil(this.zwk.zsL) && !Util.isNullOrNil(this.zwk.zsK))) {
            this.kxS.HB(this.zwk.zsL + this.zwk.zsK);
        }
        this.kxS.s(this.zCP.getPreviewWidth(), this.zCP.getPreviewHeight(), this.zCP.getEncodeVideoBestSize().x, this.zCP.getEncodeVideoBestSize().y);
        boolean rC = this.kxS.rC(this.zCP.getOrientation());
        Log.i("MicroMsg.SightCaptureUI", "preInit result: %s", Boolean.valueOf(rC));
        if (!rC) {
            this.zDv = true;
        }
        AppMethodBeat.o(94689);
        return rC;
    }

    private int ekW() {
        AppMethodBeat.i(94690);
        Log.i("MicroMsg.SightCaptureUI", "startRecordImpl");
        int b2 = this.kxS.b(this.zCP.getOrientation(), this.orientationEventListener.isLandscape(), this.orientationEventListener.getOrientation());
        Log.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", Integer.valueOf(b2));
        if (b2 >= 0) {
            this.zCP.a(f.a.Recording);
        }
        AppMethodBeat.o(94690);
        return b2;
    }

    private void ekX() {
        AppMethodBeat.i(94691);
        this.zDv = true;
        BH(8);
        if (this.kxS != null) {
            try {
                this.kxS.cancel();
                this.kxS = null;
                AppMethodBeat.o(94691);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SightCaptureUI", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(94691);
    }

    private void ekY() {
        AppMethodBeat.i(94692);
        BH(7);
        this.zCQ.setTouchEnable(false);
        if (this.zwk.zsQ) {
            this.zDd.ekL();
        }
        final int previewWidth = this.zCP.getPreviewWidth();
        final int previewHeight = this.zCP.getPreviewHeight();
        this.kxS.E(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(94647);
                Log.printInfoStack("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", SightCaptureUI.QV(SightCaptureUI.this.lPy));
                SightCaptureUI.this.zCP.a(f.a.Stoping);
                SightCaptureUI.B(SightCaptureUI.this);
                final long aFo = com.tencent.mm.plugin.mmsight.d.aFo("TIME_RECODER_2_PLAY");
                h.RTc.aX(new com.tencent.f.i.h() {
                    /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass10.AnonymousClass1 */

                    @Override // com.tencent.f.i.h, com.tencent.f.i.g
                    public final String getKey() {
                        return "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat";
                    }

                    public final void run() {
                        int i2;
                        int i3;
                        int i4;
                        int i5;
                        int i6;
                        AppMethodBeat.i(94646);
                        String filePath = SightCaptureUI.this.kxS.getFilePath();
                        cly cly = SightCaptureUI.this.zDg;
                        int i7 = k.zuy.gIP;
                        int i8 = k.zuy.ilT;
                        try {
                            if (!Util.isNullOrNil(filePath) && s.YS(filePath)) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 87, 1, false);
                                JSONObject jSONObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(filePath));
                                int i9 = (int) jSONObject.getDouble("videoFPS");
                                int optInt = jSONObject.optInt("videoBitrate");
                                Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", Integer.valueOf(i9), Integer.valueOf(optInt), Integer.valueOf(i7), Integer.valueOf(i8));
                                com.tencent.mm.plugin.mmsight.model.b ejt = com.tencent.mm.plugin.mmsight.model.b.ejt();
                                ejt.ztt = k.zuy.gIP;
                                ejt.videoBitrate = k.zuy.videoBitrate;
                                ejt.gIQ = k.zuy.isQ ? 1 : 0;
                                ejt.ztu = k.zuy.zuL ? 1 : 0;
                                ejt.ilT = k.zuy.ilT;
                                ejt.ztv = i9;
                                ejt.fileSize = s.boW(filePath);
                                com.tencent.mm.plugin.sight.base.a aNx = e.aNx(filePath);
                                if (aNx != null) {
                                    ejt.zty = aNx.width;
                                    ejt.ztz = aNx.height;
                                    ejt.ztA = aNx.videoBitrate;
                                    ejt.ztw = aNx.videoDuration;
                                }
                                if (i7 == 1) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 89, 1, false);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 49, (long) i9, false);
                                    i2 = 93;
                                    i3 = 73;
                                    i4 = 69;
                                } else {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 88, 1, false);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 48, (long) i9, false);
                                    i2 = 90;
                                    i3 = 54;
                                    i4 = 50;
                                }
                                if (i8 == 720) {
                                    i2++;
                                    i5 = i3 + 6;
                                    i6 = i4 + 6;
                                } else if (k.zuy.ejS() || i8 == 1080) {
                                    i2 += 2;
                                    i5 = i3 + 12;
                                    i6 = i4 + 12;
                                } else {
                                    i5 = i3;
                                    i6 = i4;
                                }
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, (long) i5, (long) i9, false);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, (long) i2, 1, false);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 47, (long) i9, false);
                                Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", filePath, Integer.valueOf(i6));
                                if (i9 >= 0 && i9 <= 10) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, (long) i6, 1, false);
                                } else if (i9 > 10 && i9 <= 15) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, (long) (i6 + 1), 1, false);
                                } else if (i9 > 15 && i9 <= 20) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, (long) (i6 + 2), 1, false);
                                } else if (i9 > 20 && i9 <= 30) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, (long) (i6 + 3), 1, false);
                                }
                                if (optInt > 0) {
                                    if (i7 == 2) {
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 175, (long) optInt, false);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 176, 1, false);
                                        if (cly != null) {
                                            if (cly.Mro == 1) {
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 184, (long) optInt, false);
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 185, 1, false);
                                            } else if (cly.Mro == 2) {
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 194, (long) optInt, false);
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 195, 1, false);
                                            }
                                        }
                                    } else {
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 179, (long) optInt, false);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 180, 1, false);
                                        if (cly != null) {
                                            if (cly.Mro == 1) {
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 189, (long) optInt, false);
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 190, 1, false);
                                            } else if (cly.Mro == 2) {
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 199, (long) optInt, false);
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(440, 200, 1, false);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            Log.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", e2.getMessage());
                        }
                        com.tencent.mm.plugin.mmsight.model.l.h(false, aFo);
                        AppMethodBeat.o(94646);
                    }
                });
                Log.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", Util.getStack().toString());
                Log.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", SightCaptureUI.this.kxS.getFilePath(), Long.valueOf(s.boW(SightCaptureUI.this.kxS.getFilePath())), Long.valueOf(aFo));
                SightCaptureUI.this.ebj = SightCaptureUI.this.kxS.getMd5();
                SightCaptureUI.A(SightCaptureUI.this);
                SightCaptureUI.K(SightCaptureUI.this);
                SightCaptureUI.L(SightCaptureUI.this);
                MMHandlerThread.postToMainThreadDelayed(SightCaptureUI.this.zDE, 1000);
                if (SightCaptureUI.this.zwk.scene == 1 || SightCaptureUI.this.zwk.scene == 2 || SightCaptureUI.this.zwk.scene == 7) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13819, 2, Integer.valueOf(SightCaptureUI.this.zwk.scene), SightCaptureUI.this.zwk.vPa, Long.valueOf(Util.nowSecond()));
                }
                AppMethodBeat.o(94647);
            }
        });
        AppMethodBeat.o(94692);
    }

    private void ekZ() {
        AppMethodBeat.i(94693);
        l.ekc();
        if (!l.KB()) {
            AppMethodBeat.o(94693);
            return;
        }
        TextView textView = (TextView) findViewById(R.id.j4b);
        textView.setVisibility(8);
        textView.setText("");
        AppMethodBeat.o(94693);
    }

    private void ela() {
        AppMethodBeat.i(94694);
        l.ekc();
        if (!l.KB()) {
            AppMethodBeat.o(94694);
            return;
        }
        Log.i("MicroMsg.SightCaptureUI", "test for debug " + Util.getStack().toString());
        com.tencent.mm.plugin.mmsight.model.j.ak(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(94652);
                SightCaptureUI.N(SightCaptureUI.this);
                AppMethodBeat.o(94652);
            }
        });
        AppMethodBeat.o(94694);
    }

    private String bP(String str, boolean z) {
        String exportImagePath;
        AppMethodBeat.i(94695);
        boolean z2 = CaptureMMProxy.getInstance().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
        boolean z3 = CaptureMMProxy.getInstance().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true);
        if (z) {
            exportImagePath = com.tencent.mm.plugin.mmsight.d.getExportImagePath("jpg");
        } else {
            exportImagePath = com.tencent.mm.plugin.mmsight.d.getExportImagePath("mp4");
        }
        if ((z2 && z) || (z3 && !z)) {
            Log.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", str, exportImagePath, Boolean.valueOf(z2), Boolean.valueOf(z3));
            s.nw(str, exportImagePath);
            AndroidMediaUtil.refreshMediaScanner(exportImagePath, this);
        }
        AppMethodBeat.o(94695);
        return exportImagePath;
    }

    private void elb() {
        AppMethodBeat.i(94696);
        if (this.kyv != null) {
            this.kyv.setTextureChangeCallback(null);
        }
        if (this.zCP != null) {
            this.zDf = this.zCP.aPB();
            this.zCP.ejD();
            this.zDt = -1;
            this.lPA = -1;
        }
        AppMethodBeat.o(94696);
    }

    private void elc() {
        AppMethodBeat.i(94697);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.lPy);
        objArr[1] = this.kxS != null ? this.kxS.aQN() : "";
        Log.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s", objArr);
        if (this.lPy == 2 && this.kxS != null && this.kxS.aQN() == d.c.Start) {
            this.kxS.pause();
            this.zCP.a((Context) this, this.zCV, false);
            this.zDf = this.zCP.aPB();
            if (this.zDa != null) {
                this.zDa.aq(this.zCP.getPreviewWidth(), this.zCP.getPreviewHeight(), this.zCP.getOrientation());
            }
            if (this.kxS.aQN() != d.c.Pause) {
                Log.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", this.kxS.aQN());
                AppMethodBeat.o(94697);
                return;
            }
            int previewWidth = this.zCP.getPreviewWidth();
            int previewHeight = this.zCP.getPreviewHeight();
            int orientation = this.zCP.getOrientation();
            Point aQP = this.kxS.aQP();
            int aQQ = this.kxS.aQQ();
            Log.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", Integer.valueOf(previewWidth), Integer.valueOf(previewHeight), aQP, Integer.valueOf(orientation), Integer.valueOf(aQQ));
            if (!(aQQ == orientation && aQP.x == previewWidth && aQP.y == previewHeight)) {
                Log.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
            }
            this.kxS.s(this.zCP.getPreviewWidth(), this.zCP.getPreviewHeight(), this.zCP.getEncodeVideoBestSize().x, this.zCP.getEncodeVideoBestSize().y);
            this.kxS.M(orientation, this.zCP.getEncodeVideoBestSize().x, this.zCP.getEncodeVideoBestSize().y);
        }
        AppMethodBeat.o(94697);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        boolean z;
        AppMethodBeat.i(94698);
        super.onDestroy();
        Log.i("MicroMsg.SightCaptureUI", "onDestroy");
        this.gVN.release();
        if (this.kxS != null) {
            this.kxS.a(null);
            this.kxS.E(null);
            this.kxS.clear();
        }
        if (this.lPy == -1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            elb();
            if (this.zyd != null) {
                this.zyd.stop();
                this.zyd.setVideoCallback(null);
            }
            if (this.jvG != null) {
                this.jvG.apm();
            }
            if (this.zDe != null) {
                this.zDe.release();
                this.zDe = null;
            }
        }
        if (this.orientationEventListener != null) {
            this.orientationEventListener.disable();
            this.orientationEventListener.ztH = null;
            this.orientationEventListener = null;
        }
        com.tencent.mm.plugin.mmsight.model.a.k.zwi.aRR();
        EventCenter.instance.removeListener(this.zDy);
        AppMethodBeat.o(94698);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.it;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(94699);
        super.onActivityResult(i2, i3, intent);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(intent == null);
        Log.i("MicroMsg.SightCaptureUI", "[onActivityResult] requestCode:%s  resultCode:%s data is null?:", objArr);
        switch (i2) {
            case 4369:
                Log.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", Integer.valueOf(i3));
                if (!(i3 != -1 || intent == null || this.kxS == null)) {
                    this.zDC = true;
                    this.zDD = intent.getBundleExtra("report_info");
                    this.zDA = intent.getStringExtra("raw_photo_path");
                    this.zDB = intent.getStringExtra("after_photo_edit");
                    boolean z = CaptureMMProxy.getInstance().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
                    Log.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", this.zDA, this.zDB, Boolean.valueOf(z));
                    if (!z) {
                        String k = s.k("wcf://temp/photoEdited_" + System.currentTimeMillis(), true);
                        Log.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", k);
                        s.nw(this.zDB, k);
                        s.deleteFile(this.zDB);
                        AndroidMediaUtil.refreshMediaScanner(this.zDB, this);
                        this.kxS.HB(k);
                        this.zDB = k;
                    } else {
                        this.kxS.HB(this.zDB);
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapUtil.decodeFile(this.zDB, options);
                    Log.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    Bitmap createThumbBitmap = BitmapUtil.createThumbBitmap(this.zDB, options.outHeight, options.outWidth, true, false);
                    this.zCY.setVisibility(0);
                    this.zCY.setImageBitmap(createThumbBitmap);
                    this.zCZ.setVisibility(8);
                    break;
                }
        }
        AppMethodBeat.o(94699);
    }

    private static String QU(int i2) {
        if (i2 == -1) {
            return "CAPTURE_STATE_BINGDING";
        }
        if (i2 == 0) {
            return "CAPTURE_STATE_INIT";
        }
        if (i2 == 1) {
            return "CAPTURE_STATE_CAPTURING";
        }
        if (i2 == 2) {
            return "CAPTURE_STATE_RECORDING";
        }
        if (i2 == 3) {
            return "CAPTURE_STATE_PREVIEW_PICTURE";
        }
        if (i2 == 4) {
            return "CAPTURE_STATE_PREVIEW_VIDEO";
        }
        if (i2 == 6) {
            return "CAPTURE_STATE_SUPERMAN";
        }
        if (i2 == 7) {
            return "CAPTURE_STATE_WAIT_TO_PREVIEW";
        }
        if (i2 == 8) {
            return "CAPTURE_STATE_INIT_ERROR";
        }
        if (i2 == 9) {
            return "CAPTURE_STATE_STOP_ERROR";
        }
        return "UNKNOW";
    }

    private void BH(int i2) {
        AppMethodBeat.i(94700);
        Log.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", Integer.valueOf(this.lPy), QU(this.lPy), Integer.valueOf(i2), QU(i2));
        Log.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", Integer.valueOf(this.lPy), QU(this.lPy), Integer.valueOf(i2), QU(i2), Util.getStack().toString());
        if (i2 == this.lPy) {
            AppMethodBeat.o(94700);
        } else if (this.oot == null) {
            AppMethodBeat.o(94700);
        } else {
            com.tencent.mm.plugin.mmsight.d.aFn("TIME_RECODER_2_PLAY");
            this.lPy = i2;
            if (this.lPy != 7) {
                MMHandlerThread.removeRunnable(this.zDz);
            }
            if (this.lPy == 0) {
                this.oot.setVisibility(8);
                this.zCU.setVisibility(8);
                this.zCT.setVisibility(8);
                this.zCY.setVisibility(8);
                this.zCX.setVisibility(0);
                if (this.zDr > 1) {
                    this.hQv.setVisibility(0);
                }
                if (this.zCP != null) {
                    this.zCP.a(f.a.Preview);
                }
                com.tencent.mm.plugin.mmsight.model.b.reset();
                if (this.dwt != null) {
                    try {
                        this.dwt.cancel(true);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SightCaptureUI", e2, "update to state init, interrupt failed: %s", e2.getMessage());
                    }
                    this.dwt = null;
                    AppMethodBeat.o(94700);
                    return;
                }
            } else if (this.lPy == 1 || this.lPy == 2) {
                this.oot.setVisibility(0);
                this.zCU.setVisibility(8);
                this.zCT.setVisibility(0);
                this.zCT.setClipChildren(false);
                this.zCR.setVisibility(8);
                this.ygS.setVisibility(8);
                this.zCS.setVisibility(0);
                this.zCQ.setVisibility(0);
                this.zyd.setVisibility(8);
                if (this.lPy == 1) {
                    this.zCQ.reset();
                } else {
                    this.zCQ.setTouchEnable(true);
                    this.zCQ.ekF();
                }
                this.zDc.setVisibility(8);
                this.zCY.setVisibility(8);
                this.rsW.setVisibility(0);
                if (this.zDr > 1) {
                    this.hQv.setVisibility(0);
                }
                this.rsW.bringToFront();
                this.hQv.bringToFront();
                ekZ();
                ela();
                AppMethodBeat.o(94700);
                return;
            } else if (this.lPy == 4 || this.lPy == 3) {
                this.oot.setVisibility(0);
                this.zCT.setVisibility(8);
                this.zCT.setClipChildren(false);
                this.zCR.setVisibility(0);
                this.ygS.setVisibility(0);
                this.zCS.setVisibility(8);
                this.zCQ.setVisibility(8);
                if (this.lPy == 3) {
                    if (this.zwk.zsP) {
                        this.zCU.setVisibility(0);
                    }
                    this.zCY.setVisibility(0);
                    this.zyd.setVisibility(8);
                } else {
                    this.zCY.setVisibility(8);
                    this.zyd.setVisibility(0);
                    this.zyd.setForceScaleFullScreen(true);
                    ViewGroup.LayoutParams layoutParams = this.zyd.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.zyd.setLayoutParams(layoutParams);
                    if (this.kxS.isLandscape()) {
                        this.zDa.aEy();
                    }
                    this.zCX.setVisibility(8);
                }
                this.rsW.setVisibility(8);
                AppMethodBeat.o(94700);
                return;
            } else if (this.lPy == 6) {
                this.zCR.setVisibility(8);
                this.ygS.setVisibility(8);
                this.zCU.setVisibility(8);
                this.zCS.setVisibility(8);
                this.zCQ.setVisibility(8);
                AppMethodBeat.o(94700);
                return;
            } else if (this.lPy == 7) {
                this.zCR.setVisibility(8);
                this.ygS.setVisibility(8);
                this.zCS.setVisibility(8);
                this.hQv.setVisibility(8);
                this.zCU.setVisibility(8);
                this.zCQ.setTouchEnable(false);
                MMHandlerThread.postToMainThreadDelayed(this.zDz, 1500);
                this.zCQ.hideProgress();
                AppMethodBeat.o(94700);
                return;
            } else if (this.lPy == 8) {
                this.oot.setVisibility(0);
                this.zCT.setVisibility(0);
                this.zCT.setClipChildren(false);
                this.zCR.setVisibility(8);
                this.ygS.setVisibility(8);
                this.zCU.setVisibility(8);
                this.zCS.setVisibility(0);
                if (this.zDr > 1) {
                    this.hQv.setVisibility(0);
                }
                this.zCQ.setVisibility(0);
                this.rsW.setVisibility(0);
                this.zyd.setVisibility(8);
                this.zDc.setVisibility(8);
                this.zCY.setVisibility(8);
                if (this.zDv) {
                    Toast.makeText(this, (int) R.string.f0v, 1).show();
                } else {
                    Toast.makeText(this, (int) R.string.f10, 1).show();
                }
                this.zCQ.setTouchEnable(false);
                this.zCQ.setEnabled(false);
                AppMethodBeat.o(94700);
                return;
            } else if (this.lPy == 9) {
                this.zCR.setVisibility(8);
                this.ygS.setVisibility(8);
                this.zCU.setVisibility(8);
                this.zCS.setVisibility(0);
                this.hQv.setVisibility(8);
                this.zCQ.reset();
                this.zCQ.setTouchEnable(false);
                this.zCQ.setEnabled(false);
                Toast.makeText(this, (int) R.string.f0w, 1).show();
            }
            AppMethodBeat.o(94700);
        }
    }

    private void ro(boolean z) {
        AppMethodBeat.i(94701);
        Log.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", Boolean.valueOf(z), this.zDB, this.zDA);
        if (!Util.isNullOrNil(this.zDB) && z) {
            s.deleteFile(this.zDB);
        }
        if (!Util.isNullOrNil(this.zDA)) {
            s.deleteFile(this.zDA);
        }
        this.zDB = null;
        this.zDA = null;
        pm pmVar = new pm();
        pmVar.dVE.dDe = 0;
        EventCenter.instance.publish(pmVar);
        AppMethodBeat.o(94701);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(94702);
        Log.i("MicroMsg.SightCaptureUI", "onBackPressed %d", Integer.valueOf(this.lPy));
        if (this.zDe != null && this.zDe.onBackPressed()) {
            AppMethodBeat.o(94702);
        } else if (this.zDe != null) {
            this.zDe.release();
            this.zDe = null;
            setSelfNavigationBarVisible(8);
            this.zCR.setVisibility(0);
            this.ygS.setVisibility(0);
            this.zCU.setVisibility(0);
            AppMethodBeat.o(94702);
        } else {
            if (eld()) {
                super.onBackPressed();
                overridePendingTransition(-1, R.anim.ej);
                ro(true);
            }
            AppMethodBeat.o(94702);
        }
    }

    private boolean eld() {
        return this.lPy == 4 || this.lPy == 3 || this.lPy == 1 || this.lPy == 8 || this.lPy == 9;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.d.a
    public void onOrientationChange(int i2) {
        float f2;
        AppMethodBeat.i(94703);
        if (this.zDr <= 1) {
            AppMethodBeat.o(94703);
        } else if (this.lPy == 2) {
            AppMethodBeat.o(94703);
        } else {
            Log.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", Integer.valueOf(i2));
            if (i2 < 0) {
                AppMethodBeat.o(94703);
                return;
            }
            if (i2 != 90 && i2 != 270) {
                f2 = (float) i2;
            } else if (i2 == 270) {
                f2 = 90.0f;
            } else {
                f2 = -90.0f;
            }
            if (this.hQv.getRotation() == f2) {
                AppMethodBeat.o(94703);
                return;
            }
            this.hQv.animate().rotation(f2).setDuration(100).start();
            AppMethodBeat.o(94703);
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d.a
    public final void bqP() {
        AppMethodBeat.i(94704);
        Log.i("MicroMsg.SightCaptureUI", "onError: %s", 1);
        try {
            if (this.kxS != null) {
                this.kxS.reset();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", e2.getMessage());
        }
        BH(9);
        AppMethodBeat.o(94704);
    }

    static /* synthetic */ void b(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94705);
        sightCaptureUI.setSelfNavigationBarColor(-637534208);
        sightCaptureUI.setSelfNavigationBarVisible(8);
        if (sightCaptureUI.zwk == null) {
            Log.e("MicroMsg.SightCaptureUI", "sightParams error!");
            AppMethodBeat.o(94705);
            return;
        }
        sightCaptureUI.zDr = com.tencent.mm.compatible.deviceinfo.d.getNumberOfCameras();
        Log.i("MicroMsg.SightCaptureUI", "initOnCreate, numCamera: %s", Integer.valueOf(sightCaptureUI.zDr));
        sightCaptureUI.jvG = new b(sightCaptureUI);
        sightCaptureUI.zCO = sightCaptureUI.zwk.zsN;
        sightCaptureUI.zsH = sightCaptureUI.zwk.zsH;
        sightCaptureUI.zDf = sightCaptureUI.zsH == 2;
        l.ekc().zwk = sightCaptureUI.zwk;
        sightCaptureUI.zCN = sightCaptureUI.zwk.mode;
        Log.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, captureMode: %s, showHint: %s, defaultCamera: %s, scene: %s", Integer.valueOf(sightCaptureUI.zCN), Boolean.valueOf(sightCaptureUI.zCO), Integer.valueOf(sightCaptureUI.zsH), Integer.valueOf(sightCaptureUI.zwk.scene));
        sightCaptureUI.irT = sightCaptureUI.zwk.irT;
        if (sightCaptureUI.irT == null) {
            Log.e("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, cannot get videoParams");
            AppMethodBeat.o(94705);
            return;
        }
        Log.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, videoParams: %s", sightCaptureUI.irT);
        sightCaptureUI.getWindow().addFlags(2097280);
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            sightCaptureUI.getWindow().setFlags(201327616, 201327616);
            com.tencent.mm.plugin.mmsight.d.rb(true);
            com.tencent.mm.ui.b.e(sightCaptureUI, false);
        } else {
            sightCaptureUI.getWindow().setFlags(1024, 1024);
            com.tencent.mm.plugin.mmsight.d.rb(false);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            sightCaptureUI.getWindow().addFlags(67108864);
        }
        sightCaptureUI.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(sightCaptureUI, (byte) 0);
        sightCaptureUI.orientationEventListener.ztH = sightCaptureUI;
        sightCaptureUI.orientationEventListener.enable();
        sightCaptureUI.jLy = (ViewGroup) sightCaptureUI.findViewById(R.id.h8v);
        sightCaptureUI.oot = (ViewGroup) sightCaptureUI.findViewById(R.id.bf8);
        sightCaptureUI.zCT = (ViewGroup) sightCaptureUI.findViewById(R.id.bfu);
        sightCaptureUI.zCW = (CameraFrontSightView) sightCaptureUI.findViewById(R.id.db7);
        sightCaptureUI.kyv = (ObservableTextureView) sightCaptureUI.findViewById(R.id.ggt);
        sightCaptureUI.zCQ = (MMSightRecordButton) sightCaptureUI.findViewById(R.id.gwq);
        sightCaptureUI.zCR = sightCaptureUI.findViewById(R.id.hri);
        sightCaptureUI.ygS = sightCaptureUI.findViewById(R.id.hrj);
        sightCaptureUI.zCS = sightCaptureUI.findViewById(R.id.b48);
        sightCaptureUI.zCX = (ViewGroup) sightCaptureUI.findViewById(R.id.j67);
        sightCaptureUI.zDb = (TextView) sightCaptureUI.findViewById(R.id.aje);
        if (sightCaptureUI.zCN == 2) {
            sightCaptureUI.zDb.setText(R.string.f0y);
        } else if (sightCaptureUI.zCN == 1) {
            sightCaptureUI.zDb.setText(R.string.f0z);
        } else if (sightCaptureUI.zCN == 0) {
            sightCaptureUI.zDb.setText(R.string.f0x);
        }
        sightCaptureUI.zyd = (VideoPlayerTextureView) sightCaptureUI.findViewById(R.id.gfx);
        sightCaptureUI.hQv = (ImageView) sightCaptureUI.findViewById(R.id.if9);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) sightCaptureUI.hQv.getLayoutParams();
        int i2 = layoutParams.topMargin;
        if (ao.aQ(sightCaptureUI.getContext())) {
            i2 += ao.aP(sightCaptureUI.getContext());
        }
        layoutParams.setMargins(layoutParams.leftMargin, i2, layoutParams.rightMargin, layoutParams.bottomMargin);
        sightCaptureUI.hQv.setLayoutParams(layoutParams);
        sightCaptureUI.zCU = (ImageView) sightCaptureUI.findViewById(R.id.bw0);
        sightCaptureUI.zCU.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass22 */

            public final void onClick(View view) {
                AppMethodBeat.i(94670);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SightCaptureUI.this.lPy == 3) {
                    SightCaptureUI.h(SightCaptureUI.this);
                } else if (SightCaptureUI.this.lPy == 4) {
                    SightCaptureUI.i(SightCaptureUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(94670);
            }
        });
        if (!sightCaptureUI.zwk.zsP) {
            sightCaptureUI.zCU.setVisibility(8);
        }
        sightCaptureUI.zCY = (ImageView) sightCaptureUI.findViewById(R.id.ihm);
        sightCaptureUI.zCZ = (MMSightCameraGLSurfaceView) sightCaptureUI.findViewById(R.id.bv0);
        sightCaptureUI.rsW = (MMSightCaptureTouchView) sightCaptureUI.findViewById(R.id.f6q);
        sightCaptureUI.zDc = sightCaptureUI.findViewById(R.id.gxt);
        sightCaptureUI.zDd = (MMSightTopCountdownCoverView) sightCaptureUI.findViewById(R.id.iss);
        if (ao.aQ(sightCaptureUI.getContext())) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) sightCaptureUI.zDd.getLayoutParams();
            layoutParams2.height = ao.aP(sightCaptureUI.getContext()) + sightCaptureUI.getContext().getResources().getDimensionPixelSize(R.dimen.ad3);
            sightCaptureUI.zDd.setLayoutParams(layoutParams2);
        }
        sightCaptureUI.zDa = new com.tencent.mm.plugin.mmsight.ui.cameraglview.a(sightCaptureUI.zCZ);
        if (!sightCaptureUI.zCO) {
            sightCaptureUI.zDb.setVisibility(8);
        } else {
            sightCaptureUI.zDb.setVisibility(0);
        }
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) sightCaptureUI.getContext(), 120);
        sightCaptureUI.zCW.hd(fromDPToPix, fromDPToPix);
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            int max = Math.max(au.aD(sightCaptureUI), au.aB(sightCaptureUI));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) sightCaptureUI.zCQ.getLayoutParams();
            marginLayoutParams.bottomMargin += max;
            sightCaptureUI.zCQ.setLayoutParams(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) sightCaptureUI.zCS.getLayoutParams();
            marginLayoutParams2.bottomMargin += max;
            sightCaptureUI.zCS.setLayoutParams(marginLayoutParams2);
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) sightCaptureUI.zCR.getLayoutParams();
            marginLayoutParams3.bottomMargin += max;
            sightCaptureUI.zCR.setLayoutParams(marginLayoutParams3);
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) sightCaptureUI.zCU.getLayoutParams();
            marginLayoutParams4.bottomMargin += max;
            sightCaptureUI.zCU.setLayoutParams(marginLayoutParams4);
            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) sightCaptureUI.ygS.getLayoutParams();
            marginLayoutParams5.bottomMargin = max + marginLayoutParams5.bottomMargin;
            sightCaptureUI.ygS.setLayoutParams(marginLayoutParams5);
        }
        if (sightCaptureUI.zCN == 1 || sightCaptureUI.zCN == 0) {
            sightCaptureUI.zCQ.setLongPressCallback(new MMSightRecordButton.b() {
                /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass23 */

                @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b
                public final void cJJ() {
                    AppMethodBeat.i(94671);
                    Log.i("MicroMsg.SightCaptureUI", "onPressDown, currentStatus: %s", Integer.valueOf(SightCaptureUI.this.lPy));
                    if (SightCaptureUI.this.lPy == 0 || SightCaptureUI.this.zCP == null || !SightCaptureUI.this.zCP.dEO()) {
                        AppMethodBeat.o(94671);
                        return;
                    }
                    int[] iArr = new int[2];
                    SightCaptureUI.this.zCQ.getLocationOnScreen(iArr);
                    SightCaptureUI.this.zCP.rw(iArr[1]);
                    if (SightCaptureUI.this.zCN == 0) {
                        SightCaptureUI.this.zDs = SightCaptureUI.m(SightCaptureUI.this);
                    }
                    AppMethodBeat.o(94671);
                }

                @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b
                public final void jK() {
                    AppMethodBeat.i(94672);
                    if (SightCaptureUI.this.lPy == 0 || SightCaptureUI.this.zCP == null || !SightCaptureUI.this.zCP.dEO()) {
                        AppMethodBeat.o(94672);
                        return;
                    }
                    SightCaptureUI.n(SightCaptureUI.this);
                    Log.i("MicroMsg.TestCaptureUiEvent", "onLongPress %s", Util.getStack().toString());
                    SightCaptureUI.o(SightCaptureUI.this);
                    AppMethodBeat.o(94672);
                }

                @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b
                public final void cJI() {
                    AppMethodBeat.i(94673);
                    Object[] objArr = new Object[3];
                    objArr[0] = Util.getStack().toString();
                    objArr[1] = SightCaptureUI.this.kxS;
                    objArr[2] = Long.valueOf(SightCaptureUI.this.kxS != null ? SightCaptureUI.this.kxS.aQM() : 0);
                    Log.i("MicroMsg.TestCaptureUiEvent", "onLongPressFinish %s, recorder: %s, recordTime: %s", objArr);
                    if (SightCaptureUI.this.zCN == 0) {
                        if (SightCaptureUI.this.kxS == null || SightCaptureUI.this.kxS.aQM() > 1000 || SightCaptureUI.this.kxS.aQN() != d.c.Start) {
                            SightCaptureUI.r(SightCaptureUI.this);
                            AppMethodBeat.o(94673);
                            return;
                        }
                        Log.i("MicroMsg.SightCaptureUI", "video record too short, cancel and convert to takepicture");
                        SightCaptureUI.this.kxS.cancel();
                        if (SightCaptureUI.this.zCN == 0) {
                            SightCaptureUI.q(SightCaptureUI.this);
                            AppMethodBeat.o(94673);
                            return;
                        }
                    } else if (SightCaptureUI.this.zCN == 1) {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = SightCaptureUI.this.kxS == null ? BuildConfig.COMMAND : SightCaptureUI.this.kxS.getClass().getSimpleName();
                        objArr2[1] = Long.valueOf(SightCaptureUI.this.kxS == null ? -1 : SightCaptureUI.this.kxS.aQM());
                        Log.i("MicroMsg.TestCaptureUiEvent", "onLongPressFinish, MODE_SIGHT, recorder=%s, recordTime=%d", objArr2);
                        if ((SightCaptureUI.this.kxS == null || SightCaptureUI.this.kxS.aQM() > 1000) && SightCaptureUI.this.kxS != null) {
                            SightCaptureUI.r(SightCaptureUI.this);
                        } else {
                            Log.i("MicroMsg.SightCaptureUI", "video record too short");
                            Toast.makeText(SightCaptureUI.this, (int) R.string.f11, 1).show();
                            SightCaptureUI.s(SightCaptureUI.this);
                            AppMethodBeat.o(94673);
                            return;
                        }
                    }
                    AppMethodBeat.o(94673);
                }
            });
            sightCaptureUI.zCQ.setErrorPressCallback(new MMSightRecordButton.a() {
                /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass24 */

                @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.a
                public final void ekJ() {
                    AppMethodBeat.i(94674);
                    Log.i("MicroMsg.TestCaptureUiEvent", "onErrorUp: %s", Util.getStack().toString());
                    if (SightCaptureUI.this.kxS != null) {
                        SightCaptureUI.this.kxS.cancel();
                        if (SightCaptureUI.this.zCN == 0) {
                            SightCaptureUI.q(SightCaptureUI.this);
                        }
                    }
                    AppMethodBeat.o(94674);
                }
            });
            sightCaptureUI.zCQ.setLongPressScrollCallback(new MMSightRecordButton.c() {
                /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass25 */

                @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c
                public final void Gt(int i2) {
                    AppMethodBeat.i(94675);
                    if (SightCaptureUI.this.zCP != null) {
                        SightCaptureUI.this.zCP.d(true, true, i2);
                    }
                    AppMethodBeat.o(94675);
                }

                @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c
                public final void Gu(int i2) {
                    AppMethodBeat.i(94676);
                    if (SightCaptureUI.this.zCP != null) {
                        SightCaptureUI.this.zCP.d(false, true, i2);
                    }
                    AppMethodBeat.o(94676);
                }
            });
        }
        if (sightCaptureUI.zCN == 0 || sightCaptureUI.zCN == 2) {
            sightCaptureUI.zCQ.setSimpleTapCallback(new MMSightRecordButton.d() {
                /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass26 */

                @Override // com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d
                public final void cJK() {
                    AppMethodBeat.i(94677);
                    Log.v("MicroMsg.TestCaptureUiEvent", "onSimpleTap %s", Util.getStack().toString());
                    if (SightCaptureUI.this.kxS != null) {
                        Log.i("MicroMsg.SightCaptureUI", "onSimpleTap, mediaRecorder.status: %s", SightCaptureUI.this.kxS.aQN());
                        SightCaptureUI.this.kxS.cancel();
                    }
                    com.tencent.mm.plugin.mmsight.d.aFn("TIME_RECODER_2_PLAY");
                    SightCaptureUI.q(SightCaptureUI.this);
                    AppMethodBeat.o(94677);
                }
            });
        }
        if (sightCaptureUI.zDr > 1) {
            sightCaptureUI.hQv.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass27 */

                public final void onClick(View view) {
                    AppMethodBeat.i(94678);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (SightCaptureUI.this.zCP != null) {
                        SightCaptureUI.d(SightCaptureUI.this);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(94678);
                }
            });
        } else {
            sightCaptureUI.hQv.setVisibility(8);
        }
        sightCaptureUI.ygS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(94633);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SightCaptureUI.this.lPy == 4) {
                    SightCaptureUI.t(SightCaptureUI.this);
                } else if (SightCaptureUI.this.lPy == 3) {
                    SightCaptureUI.u(SightCaptureUI.this);
                    SightCaptureUI.a(SightCaptureUI.this, false);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(94633);
            }
        });
        sightCaptureUI.zCR.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(94634);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SightCaptureUI.this.jvG != null) {
                    SightCaptureUI.this.jvG.apm();
                }
                SightCaptureUI.s(SightCaptureUI.this);
                SightCaptureUI.a(SightCaptureUI.this, true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(94634);
            }
        });
        sightCaptureUI.zCS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(94635);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!SightCaptureUI.w(SightCaptureUI.this)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(94635);
                    return;
                }
                SightCaptureUI.this.finish();
                SightCaptureUI.this.overridePendingTransition(-1, R.anim.ej);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/SightCaptureUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(94635);
            }
        });
        sightCaptureUI.rsW.setTouchCallback(new MMSightCaptureTouchView.a() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void I(float f2, float f3) {
                AppMethodBeat.i(94636);
                if (!(SightCaptureUI.this.lPy == 0 || SightCaptureUI.this.lPy == 3 || SightCaptureUI.this.lPy == 4 || SightCaptureUI.this.zCZ == null)) {
                    SightCaptureUI.this.zCP.b(f2, f3, SightCaptureUI.this.zCZ.getWidth(), SightCaptureUI.this.zCZ.getHeight());
                    SightCaptureUI sightCaptureUI = SightCaptureUI.this;
                    if (sightCaptureUI.zCW != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) sightCaptureUI.zCW.getLayoutParams();
                        layoutParams.leftMargin = ((int) f2) - (sightCaptureUI.zCW.mWidth / 2);
                        layoutParams.topMargin = ((int) f3) - (sightCaptureUI.zCW.mHeight / 2);
                        sightCaptureUI.zCW.setLayoutParams(layoutParams);
                        sightCaptureUI.zCW.ekE();
                    }
                }
                AppMethodBeat.o(94636);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void cJL() {
                AppMethodBeat.i(94637);
                if (SightCaptureUI.this.lPy != 0 && SightCaptureUI.this.zDr > 1) {
                    SightCaptureUI.this.zCP.zue.removeMessages(4354);
                    SightCaptureUI.d(SightCaptureUI.this);
                }
                AppMethodBeat.o(94637);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void bqQ() {
                AppMethodBeat.i(94638);
                if (!(SightCaptureUI.this.lPy == 0 || SightCaptureUI.this.zCP == null)) {
                    SightCaptureUI.this.zCP.d(true, false, 1);
                }
                AppMethodBeat.o(94638);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void bqR() {
                AppMethodBeat.i(94639);
                if (!(SightCaptureUI.this.lPy == 0 || SightCaptureUI.this.zCP == null)) {
                    SightCaptureUI.this.zCP.d(false, false, 1);
                }
                AppMethodBeat.o(94639);
            }
        });
        sightCaptureUI.BH(0);
        sightCaptureUI.ekV();
        sightCaptureUI.zDw = Boolean.TRUE;
        AppMethodBeat.o(94705);
    }

    static /* synthetic */ void h(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94707);
        Log.i("MicroMsg.SightCaptureUI", "[gotoPhotoEditUI]");
        if (sightCaptureUI.kxS == null) {
            Log.e("MicroMsg.SightCaptureUI", "mediaRecorder == NULL");
            AppMethodBeat.o(94707);
            return;
        }
        String stringExtra = sightCaptureUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = sightCaptureUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        if (sightCaptureUI.zwk.scene == 1) {
            intent.putExtra("from_scene", g.CTRL_INDEX);
        } else if (sightCaptureUI.zwk.scene == 2) {
            intent.putExtra("from_scene", 289);
        }
        intent.putExtra("raw_photo_path", Util.isNullOrNil(sightCaptureUI.zDA) ? sightCaptureUI.kxS.aQK() : sightCaptureUI.zDA);
        intent.putExtra("after_photo_edit", sightCaptureUI.zDB);
        intent.setClass(sightCaptureUI, MMNewPhotoEditUI.class);
        sightCaptureUI.startActivityForResult(intent, 4369);
        AppMethodBeat.o(94707);
    }

    static /* synthetic */ void i(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94708);
        if (au.aA(sightCaptureUI)) {
            sightCaptureUI.setSelfNavigationBarVisible(0);
        }
        sightCaptureUI.zye = (VideoSeekBarEditorView) sightCaptureUI.findViewById(R.id.j6g);
        if (au.aA(sightCaptureUI)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) sightCaptureUI.zye.getLayoutParams();
            marginLayoutParams.bottomMargin = Math.max(au.aD(sightCaptureUI), au.aB(sightCaptureUI));
            sightCaptureUI.zye.setLayoutParams(marginLayoutParams);
        }
        sightCaptureUI.zDe = new b();
        sightCaptureUI.zDe.zCv = 2;
        sightCaptureUI.zDe.zCs = true;
        sightCaptureUI.zDe.a(sightCaptureUI, sightCaptureUI.zwk.scene, sightCaptureUI.kxS.getFilePath(), sightCaptureUI.zye, sightCaptureUI.zyd, sightCaptureUI.oot, sightCaptureUI.irT, false);
        sightCaptureUI.zDe.zCq = new b.a() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass15 */

            @Override // com.tencent.mm.plugin.mmsight.ui.b.a
            public final void eks() {
                AppMethodBeat.i(94655);
                Log.i("MicroMsg.SightCaptureUI", "on video edit finish");
                if (SightCaptureUI.this.zDe != null) {
                    SightCaptureUI.this.ebj = Util.nullAs(SightCaptureUI.this.zDe.md5, "");
                    SightCaptureUI.this.zDe.y(false, SightCaptureUI.this.zwk.vPa);
                    SightCaptureUI.this.zDe.release();
                    SightCaptureUI.this.zDe = null;
                }
                SightCaptureUI.this.zCR.setVisibility(0);
                SightCaptureUI.this.ygS.setVisibility(0);
                SightCaptureUI.this.zCU.setVisibility(0);
                SightCaptureUI.this.zyd.stop();
                SightCaptureUI.this.zyd.setVideoPath(SightCaptureUI.this.kxS.getFilePath());
                SightCaptureUI.this.zyd.setLoop(true);
                SightCaptureUI.this.zyd.setForceScaleFullScreen(true);
                SightCaptureUI.this.zyd.setVideoCallback(SightCaptureUI.this.zyk);
                SightCaptureUI.this.setSelfNavigationBarVisible(8);
                h.RTc.aX(new com.tencent.f.i.h() {
                    /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass15.AnonymousClass1 */

                    @Override // com.tencent.f.i.h, com.tencent.f.i.g
                    public final String getKey() {
                        return "SightCaptureUI_edit_finish_save_new_thumb";
                    }

                    public final void run() {
                        AppMethodBeat.i(94653);
                        SightCaptureUI.U(SightCaptureUI.this);
                        AppMethodBeat.o(94653);
                    }
                });
                SightCaptureUI.this.zDu = true;
                AppMethodBeat.o(94655);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.b.a
            public final void ekt() {
                AppMethodBeat.i(94656);
                Log.i("MicroMsg.SightCaptureUI", "on video edit exit");
                if (SightCaptureUI.this.zDe != null) {
                    SightCaptureUI.this.zDe.y(true, SightCaptureUI.this.zwk.vPa);
                    SightCaptureUI.this.zDe.release();
                    SightCaptureUI.this.zDe = null;
                }
                SightCaptureUI.this.setSelfNavigationBarVisible(8);
                SightCaptureUI.this.zCR.setVisibility(0);
                SightCaptureUI.this.ygS.setVisibility(0);
                SightCaptureUI.this.zCU.setVisibility(0);
                AppMethodBeat.o(94656);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.b.a
            public final void onError() {
                AppMethodBeat.i(94657);
                Log.i("MicroMsg.SightCaptureUI", "on video edit error");
                if (SightCaptureUI.this.zDe != null) {
                    SightCaptureUI.this.zDe.release();
                    SightCaptureUI.this.zDe = null;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass15.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(94654);
                        Toast.makeText(SightCaptureUI.this, (int) R.string.f12, 1).show();
                        SightCaptureUI.this.setSelfNavigationBarVisible(8);
                        SightCaptureUI.this.zCR.setVisibility(0);
                        SightCaptureUI.this.ygS.setVisibility(0);
                        SightCaptureUI.this.zCU.setVisibility(0);
                        AppMethodBeat.o(94654);
                    }
                });
                AppMethodBeat.o(94657);
            }
        };
        sightCaptureUI.zCR.setVisibility(8);
        sightCaptureUI.ygS.setVisibility(8);
        sightCaptureUI.zCU.setVisibility(8);
        AppMethodBeat.o(94708);
    }

    static /* synthetic */ void n(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94710);
        if (sightCaptureUI.zDb != null && sightCaptureUI.zCO) {
            sightCaptureUI.zDb.animate().alpha(0.0f).setDuration(100).setListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass7 */

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(94643);
                    SightCaptureUI.this.zDb.setVisibility(8);
                    AppMethodBeat.o(94643);
                }
            }).start();
        }
        AppMethodBeat.o(94710);
    }

    static /* synthetic */ void o(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94711);
        if (sightCaptureUI.kxS != null) {
            Log.v("MicroMsg.TestCaptureUiEvent", "startRecord, mediaRecorder.status: %s, %s", sightCaptureUI.kxS.aQN(), Util.getStack().toString());
            sightCaptureUI.BH(6);
            if (sightCaptureUI.kxS.aQN() == d.c.Stop) {
                sightCaptureUI.zDs = sightCaptureUI.ekW();
                if (sightCaptureUI.zDs < 0) {
                    sightCaptureUI.ekX();
                    AppMethodBeat.o(94711);
                    return;
                }
            } else if (sightCaptureUI.zDs < 0) {
                sightCaptureUI.ekX();
                AppMethodBeat.o(94711);
                return;
            }
            sightCaptureUI.BH(2);
            if (sightCaptureUI.zCP != null) {
                sightCaptureUI.zCP.ejy();
            }
            if (sightCaptureUI.zwk.zsQ) {
                MMSightTopCountdownCoverView mMSightTopCountdownCoverView = sightCaptureUI.zDd;
                long j2 = (long) sightCaptureUI.irT.duration;
                mMSightTopCountdownCoverView.setVisibility(0);
                mMSightTopCountdownCoverView.zBY = 0;
                mMSightTopCountdownCoverView.zBZ = 1000 * j2;
                mMSightTopCountdownCoverView.ekM();
                mMSightTopCountdownCoverView.zBU.setVisibility(8);
                mMSightTopCountdownCoverView.zBX.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mMSightTopCountdownCoverView.zBW.getLayoutParams();
                layoutParams.removeRule(2);
                layoutParams.addRule(13);
                mMSightTopCountdownCoverView.requestLayout();
                mMSightTopCountdownCoverView.invalidate();
                mMSightTopCountdownCoverView.zCc.start();
                mMSightTopCountdownCoverView.zCb.run();
                mMSightTopCountdownCoverView.mHandler.postDelayed(mMSightTopCountdownCoverView.zCa, Math.max(0L, (j2 * 1000) - 5000));
            }
            sightCaptureUI.zCQ.a((sightCaptureUI.irT.duration * 1000) - 500, 0, new MMSightCircularProgressBar.a() {
                /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass9 */

                @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a
                public final void lK(boolean z) {
                    AppMethodBeat.i(187097);
                    SightCaptureUI.r(SightCaptureUI.this);
                    AppMethodBeat.o(187097);
                }

                @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a
                public final void Z(ArrayList<Float> arrayList) {
                }
            });
        }
        AppMethodBeat.o(94711);
    }

    static /* synthetic */ void q(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94712);
        if (sightCaptureUI.zCP != null && sightCaptureUI.zCP.dEO() && sightCaptureUI.orientationEventListener != null && !sightCaptureUI.lPz && (sightCaptureUI.lPA < 0 || Util.ticksToNow(sightCaptureUI.lPA) >= 300)) {
            sightCaptureUI.lPz = true;
            if (sightCaptureUI.zDb != null && sightCaptureUI.zCO) {
                sightCaptureUI.zDb.setVisibility(8);
            }
            final int i2 = sightCaptureUI.lPy;
            sightCaptureUI.BH(7);
            sightCaptureUI.zCQ.setTouchEnable(false);
            sightCaptureUI.zDq = sightCaptureUI.orientationEventListener.isLandscape();
            sightCaptureUI.zDm = null;
            sightCaptureUI.zDn = -1;
            sightCaptureUI.zCP.a(new f.b() {
                /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.mmsight.model.f.b
                public final void a(byte[] bArr, int i2, int i3, int i4, int i5) {
                    int i6;
                    AppMethodBeat.i(94642);
                    if (bArr == null || i2 < 0 || i3 < 0 || i4 < 0) {
                        Log.e("MicroMsg.SightCaptureUI", "onPictureYuvTaken, data is null!! current state: %d", Integer.valueOf(SightCaptureUI.this.lPy));
                        SightCaptureUI.this.lPz = false;
                        if (SightCaptureUI.this.lPy == 7) {
                            SightCaptureUI.b(SightCaptureUI.this, i2);
                        }
                        AppMethodBeat.o(94642);
                        return;
                    }
                    Log.i("MicroMsg.SightCaptureUI", "data frameWidth %s frameHeight %s rotate %s deviceDegree %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
                    SightCaptureUI.A(SightCaptureUI.this);
                    SightCaptureUI.B(SightCaptureUI.this);
                    SightCaptureUI.this.zDi = i2;
                    SightCaptureUI.this.zDj = i3;
                    SightCaptureUI.this.zDk = i4;
                    SightCaptureUI.this.zDl = i5;
                    if (SightCaptureUI.this.zDh != null) {
                        com.tencent.mm.plugin.mmsight.model.a.k.zwi.k(SightCaptureUI.this.zDh);
                        SightCaptureUI.this.zDh = null;
                    }
                    SightCaptureUI.this.zDh = com.tencent.mm.plugin.mmsight.model.a.k.zwi.h(Integer.valueOf(bArr.length));
                    System.arraycopy(bArr, 0, SightCaptureUI.this.zDh, 0, bArr.length);
                    SightCaptureUI.this.dwt = h.RTc.aX(new com.tencent.f.i.h() {
                        /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass6.AnonymousClass1 */

                        @Override // com.tencent.f.i.h, com.tencent.f.i.g
                        public final String getKey() {
                            return "SightCaptureUI_saveCaptureBitmap";
                        }

                        public final void run() {
                            AppMethodBeat.i(94640);
                            SightCaptureUI.D(SightCaptureUI.this);
                            AppMethodBeat.o(94640);
                        }
                    });
                    com.tencent.mm.plugin.mmsight.model.l.h(true, com.tencent.mm.plugin.mmsight.d.aFo("TIME_RECODER_2_PLAY"));
                    if (SightCaptureUI.this.zDq) {
                        if (Math.abs(i4 - i5) == 0) {
                            i6 = TXLiveConstants.RENDER_ROTATION_180;
                        } else {
                            i6 = 0;
                        }
                        bArr = com.tencent.mm.plugin.mmsight.d.e(bArr, i2, i3, i6 % v2helper.VOIP_ENC_HEIGHT_LV1);
                        SightCaptureUI.this.zDa.a(bArr, true, 0);
                    } else {
                        if (i5 == 180) {
                            i6 = i4 + i5;
                        } else {
                            i6 = i4;
                        }
                        if (i6 > 360) {
                            i6 -= 360;
                        }
                        SightCaptureUI.this.zDa.a(bArr, false, i6);
                    }
                    SightCaptureUI.this.zDm = bArr;
                    SightCaptureUI.this.zDn = i6;
                    SightCaptureUI.b(SightCaptureUI.this, 3);
                    SightCaptureUI.this.zCR.post(new Runnable() {
                        /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass6.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(94641);
                            SightCaptureUI.F(SightCaptureUI.this);
                            AppMethodBeat.o(94641);
                        }
                    });
                    if (SightCaptureUI.this.zwk.scene == 1 || SightCaptureUI.this.zwk.scene == 2 || SightCaptureUI.this.zwk.scene == 7) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13819, 1, Integer.valueOf(SightCaptureUI.this.zwk.scene), SightCaptureUI.this.zwk.vPa, Long.valueOf(Util.nowSecond()));
                    }
                    AppMethodBeat.o(94642);
                }
            }, sightCaptureUI.zDq, sightCaptureUI.orientationEventListener.getOrientation());
            sightCaptureUI.lPA = Util.currentTicks();
        }
        AppMethodBeat.o(94712);
    }

    static /* synthetic */ void t(SightCaptureUI sightCaptureUI) {
        com.tencent.mm.plugin.sight.base.a aNx;
        int i2;
        AppMethodBeat.i(94715);
        if (sightCaptureUI.zwk.scene == 1 || sightCaptureUI.zwk.scene == 2 || sightCaptureUI.zwk.scene == 7) {
            if (sightCaptureUI.zDo) {
                i2 = sightCaptureUI.zDp ? 2 : 1;
            } else {
                i2 = 0;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13820, Integer.valueOf(i2), Integer.valueOf(sightCaptureUI.zwk.scene), sightCaptureUI.zwk.vPa, Long.valueOf(Util.nowSecond()));
        }
        if (sightCaptureUI.zwk != null && sightCaptureUI.zDu) {
            com.tencent.mm.plugin.mmsight.a.a.a(new a.C1478a(sightCaptureUI.zwk.scene));
        }
        Intent intent = new Intent();
        String filePath = sightCaptureUI.kxS.getFilePath();
        String aFl = e.aFl(filePath);
        if (sightCaptureUI.zwk.zsO) {
            sightCaptureUI.bP(filePath, false);
        }
        if (com.tencent.mm.plugin.mmsight.model.b.ejt() != null) {
            sightCaptureUI.zDg.Mrp = com.tencent.mm.plugin.mmsight.model.b.ejt().eju();
        }
        int aQO = sightCaptureUI.kxS.aQO();
        if (sightCaptureUI.zDu && (aNx = e.aNx(sightCaptureUI.kxS.getFilePath())) != null) {
            aQO = Math.round(((float) aNx.videoDuration) / 1000.0f);
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.zCP.aPB(), filePath, aFl, sightCaptureUI.kxS.getFileName(), sightCaptureUI.ebj, aQO, sightCaptureUI.zDg));
        intent.putExtra("KSessionID", sightCaptureUI.zwk.vPa);
        intent.putExtra("latitude", sightCaptureUI.getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 91.0d));
        intent.putExtra("longitude", sightCaptureUI.getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 181.0d));
        sightCaptureUI.setResult(-1, intent);
        sightCaptureUI.finish();
        AppMethodBeat.o(94715);
    }

    static /* synthetic */ void u(SightCaptureUI sightCaptureUI) {
        boolean z;
        AppMethodBeat.i(94716);
        if (sightCaptureUI.dwt != null && !sightCaptureUI.dwt.isDone()) {
            try {
                sightCaptureUI.dwt.get();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SightCaptureUI", e2, "wait saveCaptureImageThread error: %s", e2.getMessage());
            }
        }
        if (sightCaptureUI.zwk.scene == 1 || sightCaptureUI.zwk.scene == 2 || sightCaptureUI.zwk.scene == 7) {
            int i2 = 0;
            if (sightCaptureUI.zDo) {
                i2 = 1;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13820, Integer.valueOf(i2), Integer.valueOf(sightCaptureUI.zwk.scene), sightCaptureUI.zwk.vPa, Long.valueOf(Util.nowSecond()));
        }
        if (sightCaptureUI.zwk.scene == 1) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13858, 1, 1, 1, 0);
        } else if (sightCaptureUI.zwk.scene == 2) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13858, 2, 1, 1, 0);
        }
        Intent intent = new Intent();
        if (Util.isNullOrNil(sightCaptureUI.zDB) || sightCaptureUI.kxS == null || !sightCaptureUI.zDB.equals(sightCaptureUI.kxS.aQK())) {
            z = false;
        } else {
            z = true;
        }
        if (!z && sightCaptureUI.zwk.zsO) {
            Log.i("MicroMsg.SightCaptureUI", "is not Photo editted!");
            sightCaptureUI.bP(sightCaptureUI.kxS.aQK(), true);
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.zCP.aPB(), sightCaptureUI.kxS.aQK()));
        intent.putExtra("KSessionID", sightCaptureUI.zwk.vPa);
        intent.putExtra("latitude", sightCaptureUI.getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 91.0d));
        intent.putExtra("longitude", sightCaptureUI.getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 181.0d));
        sightCaptureUI.setResult(-1, intent);
        Bundle bundle = sightCaptureUI.zDD;
        if (bundle == null) {
            Log.e("MicroMsg.SightCaptureUI", "[reportPhotoEdit] date == null");
        } else if (!sightCaptureUI.zDC) {
            Log.i("MicroMsg.SightCaptureUI", "[reportPhotoEdit] reportPhotoEdit == false");
        } else {
            int i3 = bundle.getInt("report_info_emotion_count");
            int i4 = bundle.getInt("report_info_text_count");
            int i5 = bundle.getInt("report_info_mosaic_count");
            int i6 = bundle.getInt("report_info_doodle_count");
            boolean z2 = bundle.getBoolean("report_info_iscrop");
            int i7 = bundle.getInt("report_info_undo_count");
            boolean z3 = bundle.getBoolean("report_info_is_rotation");
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = Integer.valueOf(i4);
            objArr[2] = Integer.valueOf(i5);
            objArr[3] = Integer.valueOf(i6);
            objArr[4] = Integer.valueOf(z2 ? 1 : 0);
            objArr[5] = Integer.valueOf(i7);
            objArr[6] = Boolean.valueOf(z3);
            Log.i("MicroMsg.SightCaptureUI", "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s", objArr);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr2 = new Object[12];
            objArr2[0] = 1;
            objArr2[1] = 1;
            objArr2[2] = Integer.valueOf(i3);
            objArr2[3] = Integer.valueOf(i4);
            objArr2[4] = Integer.valueOf(i5);
            objArr2[5] = Integer.valueOf(i6);
            objArr2[6] = Integer.valueOf(z2 ? 1 : 0);
            objArr2[7] = Integer.valueOf(i7);
            objArr2[8] = 3;
            objArr2[9] = Integer.valueOf(z3 ? 1 : 0);
            objArr2[10] = sightCaptureUI.zwk.vPa;
            objArr2[11] = Long.valueOf(Util.nowSecond());
            hVar.a(13857, objArr2);
        }
        sightCaptureUI.finish();
        AppMethodBeat.o(94716);
    }

    static /* synthetic */ void A(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94720);
        Log.i("MicroMsg.SightCaptureUI", "setRevertAndSendBtnPos");
        if (sightCaptureUI.zCU.getVisibility() == 8) {
            sightCaptureUI.rsW.setVisibility(8);
        } else {
            sightCaptureUI.rsW.setVisibility(0);
        }
        Point gx = com.tencent.mm.plugin.mmsight.d.gx(sightCaptureUI);
        int dimensionPixelSize = sightCaptureUI.getResources().getDimensionPixelSize(R.dimen.acz);
        int dimensionPixelSize2 = sightCaptureUI.getResources().getDimensionPixelSize(R.dimen.ad1);
        sightCaptureUI.zCQ.getX();
        sightCaptureUI.zCR.setTranslationX(((((float) gx.x) / 2.0f) - ((float) dimensionPixelSize2)) - (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.ygS.setTranslationX((((float) (-gx.x)) / 2.0f) + ((float) dimensionPixelSize2) + (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.zCR.setEnabled(false);
        sightCaptureUI.ygS.setEnabled(false);
        AppMethodBeat.o(94720);
    }

    static /* synthetic */ void D(SightCaptureUI sightCaptureUI) {
        Bitmap bitmap;
        AppMethodBeat.i(184544);
        if (Util.isNullOrNil(sightCaptureUI.zDh) || sightCaptureUI.zDj <= 0 || sightCaptureUI.zDi <= 0) {
            Log.e("MicroMsg.SightCaptureUI", "saveCaptureYuvDataToBitmap error");
        } else {
            try {
                YuvImage yuvImage = new YuvImage(sightCaptureUI.zDh, 17, sightCaptureUI.zDi, sightCaptureUI.zDj, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, sightCaptureUI.zDi, sightCaptureUI.zDj), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                if (!sightCaptureUI.zDq || sightCaptureUI.zDl == 180) {
                    int i2 = sightCaptureUI.zDk;
                    if (sightCaptureUI.zDl == 180 && (i2 = i2 + TXLiveConstants.RENDER_ROTATION_180) > 360) {
                        i2 -= 360;
                    }
                    bitmap = BitmapUtil.rotate(decodeByteArray, (float) i2);
                    decodeByteArray.recycle();
                } else if (Math.abs(sightCaptureUI.zDk - sightCaptureUI.zDl) == 0) {
                    bitmap = BitmapUtil.rotate(decodeByteArray, 180.0f);
                    decodeByteArray.recycle();
                } else {
                    bitmap = decodeByteArray;
                }
                try {
                    String aQK = sightCaptureUI.kxS.aQK();
                    BitmapUtil.saveBitmapToImage(bitmap, 90, Bitmap.CompressFormat.JPEG, aQK, false);
                    Log.i("MicroMsg.SightCaptureUI", "bitmap filelen %s", Long.valueOf(s.boW(aQK)));
                } catch (Exception e2) {
                    Log.e("MicroMsg.SightCaptureUI", "error for saveBitmapToImage %s", e2.getMessage());
                }
                com.tencent.mm.plugin.mmsight.model.a.k.zwi.k(sightCaptureUI.zDh);
                sightCaptureUI.zDj = 0;
                sightCaptureUI.zDi = 0;
                sightCaptureUI.zDl = 0;
                sightCaptureUI.zDk = 0;
                sightCaptureUI.zDh = null;
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.SightCaptureUI", e3, "saveCaptureYuvDataToBitmap error: %s", e3.getMessage());
            }
        }
        sightCaptureUI.lPz = false;
        AppMethodBeat.o(184544);
    }

    static /* synthetic */ void F(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94723);
        sightCaptureUI.zCR.animate().translationX(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass16 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(94658);
                SightCaptureUI.this.zCR.setEnabled(true);
                AppMethodBeat.o(94658);
            }

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(94659);
                SightCaptureUI.this.zCR.setEnabled(false);
                AppMethodBeat.o(94659);
            }
        }).start();
        sightCaptureUI.ygS.animate().translationX(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass17 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(94660);
                SightCaptureUI.this.ygS.setEnabled(true);
                AppMethodBeat.o(94660);
            }

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(94661);
                SightCaptureUI.this.ygS.setEnabled(false);
                AppMethodBeat.o(94661);
            }
        }).start();
        AppMethodBeat.o(94723);
    }

    static /* synthetic */ void K(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94726);
        com.tencent.mm.plugin.mmsight.model.j.aj(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(94649);
                String aFm = com.tencent.mm.plugin.mmsight.d.aFm(SightCaptureUI.this.kxS.getFilePath());
                if (Util.isNullOrNil(aFm)) {
                    AppMethodBeat.o(94649);
                    return;
                }
                final String str = ((aFm + "\n" + String.format("FPS: %s", Float.valueOf(SightCaptureUI.this.kxS.aQL()))) + "\n" + String.format("TIME_RECODER_2_PLAY: %s", Long.valueOf(com.tencent.mm.plugin.mmsight.d.aFo("TIME_RECODER_2_PLAY")))) + "\n" + String.format("CPU: cur %s max:%s", m.aop(), m.aoo());
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass11.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(94648);
                        Log.i("MicroMsg.SightCaptureUI", "DEBUG showDebugInfo %s", str);
                        l.ekc();
                        if (!l.KB()) {
                            AppMethodBeat.o(94648);
                            return;
                        }
                        TextView textView = (TextView) SightCaptureUI.this.findViewById(R.id.j4b);
                        textView.setVisibility(0);
                        textView.setText(str);
                        AppMethodBeat.o(94648);
                    }
                });
                AppMethodBeat.o(94649);
            }
        });
        AppMethodBeat.o(94726);
    }

    static /* synthetic */ void L(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94727);
        Log.i("MicroMsg.SightCaptureUI", "start preview");
        if (sightCaptureUI.jvG != null) {
            sightCaptureUI.jvG.requestFocus();
        }
        sightCaptureUI.zyd.setVisibility(0);
        sightCaptureUI.zyd.setAlpha(0.0f);
        sightCaptureUI.zyd.setVideoPath(sightCaptureUI.kxS.getFilePath());
        sightCaptureUI.zyd.setLoop(true);
        sightCaptureUI.zyd.setForceScaleFullScreen(true);
        sightCaptureUI.zyd.setVideoCallback(sightCaptureUI.zyk);
        AppMethodBeat.o(94727);
    }

    static /* synthetic */ void N(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(94728);
        if (sightCaptureUI.lPy == 1 || sightCaptureUI.lPy == 2) {
            String ejA = sightCaptureUI.zCP.ejA();
            if (!Util.isNullOrNil(ejA)) {
                StringBuilder append = new StringBuilder().append(ejA + "\n" + String.format("CPU: cur %s max:%s", m.aop(), m.aoo())).append("\n");
                l.ekc();
                final String str = append.append(String.format("RecorderType %s", l.ekg())).toString() + "\n" + String.format("MemoryClass: %sMB, TotalMem: %sMB", Integer.valueOf(((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getLargeMemoryClass()), Integer.valueOf(com.tencent.mm.plugin.mmsight.d.gy(sightCaptureUI)));
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.AnonymousClass13 */

                    public final void run() {
                        AppMethodBeat.i(94651);
                        Log.i("MicroMsg.SightCaptureUI", "DEBUG showCameraInfoImpl: %s", str);
                        l.ekc();
                        if (!l.KB()) {
                            AppMethodBeat.o(94651);
                            return;
                        }
                        TextView textView = (TextView) SightCaptureUI.this.findViewById(R.id.j4b);
                        textView.setVisibility(0);
                        textView.setText(str);
                        AppMethodBeat.o(94651);
                    }
                });
            }
        }
        AppMethodBeat.o(94728);
    }

    static /* synthetic */ void U(SightCaptureUI sightCaptureUI) {
        int i2;
        int i3;
        AppMethodBeat.i(94729);
        try {
            Bitmap PF = com.tencent.mm.plugin.mmsight.d.PF(sightCaptureUI.kxS.getFilePath());
            if (!(PF == null || sightCaptureUI.irT == null || Math.min(PF.getWidth(), PF.getHeight()) <= sightCaptureUI.irT.iTf)) {
                int width = PF.getWidth();
                int height = PF.getHeight();
                int i4 = sightCaptureUI.irT.iTf > 0 ? sightCaptureUI.irT.iTf : sightCaptureUI.irT.width;
                if (width < height) {
                    i3 = (int) (((float) height) / ((((float) width) * 1.0f) / ((float) i4)));
                    i2 = i4;
                } else {
                    i2 = (int) (((float) width) / ((((float) height) * 1.0f) / ((float) i4)));
                    i3 = i4;
                }
                BitmapUtil.saveBitmapToImage(Bitmap.createScaledBitmap(PF, i2, i3, true), 60, Bitmap.CompressFormat.JPEG, sightCaptureUI.kxS.aQn(), true);
            }
            AppMethodBeat.o(94729);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SightCaptureUI", e2, "saveNewThumbAfterEdit error: %s", e2.getMessage());
            AppMethodBeat.o(94729);
        }
    }
}

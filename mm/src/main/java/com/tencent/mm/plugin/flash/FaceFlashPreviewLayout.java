package com.tencent.mm.plugin.flash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.flash.a.a;
import com.tencent.mm.plugin.flash.b;
import com.tencent.mm.plugin.flash.b.c;
import com.tencent.mm.plugin.flash.b.d;
import com.tencent.mm.plugin.flash.b.g;
import com.tencent.mm.plugin.flash.d.b;
import com.tencent.mm.plugin.flash.view.FaceNumberLayout;
import com.tencent.mm.plugin.flash.view.FaceReflectMask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YtCameraSetting;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceFlashPreviewLayout extends RelativeLayout implements TextureView.SurfaceTextureListener, YtSDKKitFramework.IYTBaseFunctionListener, YtSDKKitFramework.IYTReflectListener, YtSDKKitFramework.IYtSDKKitFrameworkEventListener {
    private static final int wGW = a.dKW();
    private Context context;
    private int dYn;
    private boolean kkA;
    SurfaceTexture ltm;
    private ImageView sYj;
    private FaceReflectMask wGF;
    TextView wGG;
    TextView wGH;
    private TextView wGI;
    private MMTextureView wGJ;
    ProgressBar wGK;
    private FaceNumberLayout wGL;
    private TextView wGM;
    private View wGN;
    b wGO;
    private FaceFlashUI wGP;
    private a wGQ;
    g wGR;
    private d wGS;
    private YtSDKKitFramework.YtSDKKitFrameworkWorkMode wGT;
    private Animation wGU;
    private Animation wGV;
    private boolean wGX;
    private boolean wGY;
    private int wGZ;
    private int wHa;
    int wHb;
    com.tencent.f.i.d wHc;
    private com.tencent.f.i.d wHd;
    private com.tencent.f.i.d wHe;
    private float wHf;
    private long wHg;
    private boolean wHh;
    CountDownTimer wHi;

    static /* synthetic */ void G(FaceFlashPreviewLayout faceFlashPreviewLayout) {
        AppMethodBeat.i(186463);
        faceFlashPreviewLayout.dKL();
        AppMethodBeat.o(186463);
    }

    static /* synthetic */ void a(FaceFlashPreviewLayout faceFlashPreviewLayout, TextView textView, String str) {
        AppMethodBeat.i(186460);
        faceFlashPreviewLayout.b(textView, str);
        AppMethodBeat.o(186460);
    }

    static /* synthetic */ void a(FaceFlashPreviewLayout faceFlashPreviewLayout, String str) {
        AppMethodBeat.i(186461);
        faceFlashPreviewLayout.axd(str);
        AppMethodBeat.o(186461);
    }

    static /* synthetic */ void c(FaceFlashPreviewLayout faceFlashPreviewLayout) {
        AppMethodBeat.i(186458);
        faceFlashPreviewLayout.dKO();
        AppMethodBeat.o(186458);
    }

    static /* synthetic */ void q(FaceFlashPreviewLayout faceFlashPreviewLayout) {
        AppMethodBeat.i(186459);
        faceFlashPreviewLayout.dKK();
        AppMethodBeat.o(186459);
    }

    public FaceFlashPreviewLayout(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public FaceFlashPreviewLayout(Context context2, AttributeSet attributeSet, int i2) {
        this(context2, attributeSet, i2, (byte) 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FaceFlashPreviewLayout(Context context2, AttributeSet attributeSet, int i2, byte b2) {
        super(context2, attributeSet, i2, 0);
        float f2;
        int i3 = 4;
        AppMethodBeat.i(186439);
        this.wGO = new b(getContext());
        this.wGP = (FaceFlashUI) getContext();
        this.wGQ = new a();
        this.context = getContext();
        this.wGS = new d();
        this.wGT = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
        this.wGU = new TranslateAnimation(0.0f, (float) (-com.tencent.mm.cb.a.jn(getContext())), 0.0f, 0.0f);
        this.wGV = new TranslateAnimation((float) com.tencent.mm.cb.a.jn(getContext()), 0.0f, 0.0f, 0.0f);
        this.wGX = false;
        this.kkA = false;
        this.wGY = false;
        this.wGZ = 0;
        this.wHa = 0;
        this.dYn = -1;
        this.wHb = -1;
        this.wHf = 0.0f;
        this.wHg = 0;
        this.wHh = false;
        this.wHi = new CountDownTimer() {
            /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass1 */

            public final void onTick(long j2) {
            }

            public final void onFinish() {
                AppMethodBeat.i(186421);
                Log.i("MicroMsg.FaceFlashManager", "onFinish");
                FaceFlashPreviewLayout.this.wHh = true;
                if (!FaceFlashPreviewLayout.this.kkA && FaceFlashPreviewLayout.this.getVisibility() == 0) {
                    Log.i("MicroMsg.FaceFlashManager", "onFinish break face detect!");
                    FaceFlashPreviewLayout.c(FaceFlashPreviewLayout.this);
                    FaceFlashPreviewLayout.this.wGO.stopPreview();
                    YtSDKKitFramework.getInstance().fireEvent(YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS, null);
                    FaceFlashPreviewLayout.this.wGP.axf(FaceFlashPreviewLayout.this.wGR.dT(com.tencent.mm.cb.a.aI(FaceFlashPreviewLayout.this.getContext(), R.string.c6z), 90032).toString());
                }
                AppMethodBeat.o(186421);
            }
        };
        LayoutInflater.from(getContext()).inflate(R.layout.a5x, (ViewGroup) this, true);
        this.wGF = (FaceReflectMask) findViewById(R.id.d5z);
        this.wGG = (TextView) findViewById(R.id.d62);
        this.wGH = (TextView) findViewById(R.id.d61);
        this.wGI = (TextView) findViewById(R.id.d63);
        this.sYj = (ImageView) findViewById(R.id.c8g);
        this.wGK = (ProgressBar) findViewById(R.id.c9p);
        this.wGL = (FaceNumberLayout) findViewById(R.id.d5v);
        this.wGN = findViewById(R.id.d5s);
        this.wGM = (TextView) findViewById(R.id.c_d);
        Intent intent = ((Activity) getContext()).getIntent();
        int intExtra = intent.getIntExtra("check_alive_type", 4);
        switch (intExtra) {
            case 1:
                this.wGT = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_REFLECT_TYPE;
                Log.i("MicroMsg.FaceFlashManager", "biz choose REFLECTION");
                this.dYn = 2;
                i3 = intExtra;
                break;
            case 2:
                Log.i("MicroMsg.FaceFlashManager", "biz choose CHOOSE_BY_LUX");
                b bVar = b.C1358b.wIN;
                MMApplicationContext.getContext();
                bVar.dLl();
                if (bVar.wIL != null) {
                    new StringBuilder("Light lux: ").append(bVar.wIL.lux);
                    f2 = bVar.wIL.lux;
                } else {
                    f2 = -1.0f;
                }
                bVar.stop();
                if (f2 >= intent.getFloatExtra("mLight_threshold", -1.0f)) {
                    this.wGT = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE;
                    this.dYn = 6;
                    Log.i("MicroMsg.FaceFlashManager", "biz choose CHOOSE_BY_LUX  READ_NUMBER");
                    i3 = 0;
                    break;
                } else {
                    this.wGT = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_REFLECT_TYPE;
                    this.dYn = 5;
                    Log.i("MicroMsg.FaceFlashManager", "biz choose CHOOSE_BY_LUX  REFLECTION");
                    i3 = 1;
                    break;
                }
            case 3:
            default:
                this.wGT = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE;
                this.dYn = 3;
                Log.i("MicroMsg.FaceFlashManager", "biz choose READ_NUMBER");
                i3 = 0;
                break;
            case 4:
                Log.i("MicroMsg.FaceFlashManager", "biz choose CHOOSE_BY_LUX  ACTREFLECT");
                this.wGT = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
                this.dYn = 4;
                break;
        }
        com.tencent.mm.plugin.flash.c.b.dLi().eqQ = (long) this.dYn;
        this.wGR = com.tencent.mm.plugin.flash.b.b.MR(i3);
        this.wGR.h(intent, (Activity) getContext());
        this.wGS.e(intent, i3);
        Log.i("MicroMsg.FaceFlashManager", "face detect type:%s  after type:%s", this.wGT, Integer.valueOf(i3));
        String stringExtra = intent.getStringExtra("business_tips");
        if (TextUtils.isEmpty(stringExtra)) {
            this.wGI.setVisibility(8);
        } else {
            this.wGI.setText(stringExtra);
        }
        b(this.wGG, com.tencent.mm.cb.a.aI(getContext(), R.string.fl_pose_not_in_rect));
        this.wGJ = (MMTextureView) findViewById(R.id.d5t);
        if (!a.dKR()) {
            com.tencent.mm.plugin.flash.c.b.s("initSdk", -1);
            this.wGP.bm(90013, "init lib failed");
            AppMethodBeat.o(186439);
            return;
        }
        com.tencent.mm.plugin.flash.c.b.axn("initSdk");
        com.tencent.mm.plugin.flash.c.b.MY(10);
        if (this.wGJ.isAvailable()) {
            onSurfaceTextureAvailable(this.wGJ.getSurfaceTexture(), this.wGJ.getWidth(), this.wGJ.getHeight());
        }
        this.wGJ.setSurfaceTextureListener(this);
        this.wHi.start();
        AppMethodBeat.o(186439);
    }

    static {
        AppMethodBeat.i(186464);
        AppMethodBeat.o(186464);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener
    public void onReflectEvent(final ColorMatrixColorFilter colorMatrixColorFilter, float f2) {
        AppMethodBeat.i(186440);
        Log.i("MicroMsg.FaceFlashManager", "change color :%s isVerifying:%s", colorMatrixColorFilter, Boolean.valueOf(this.kkA));
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(186423);
                if (!FaceFlashPreviewLayout.this.kkA) {
                    AppMethodBeat.o(186423);
                    return;
                }
                FaceFlashPreviewLayout.this.wGP.MP(com.tencent.mm.cb.a.n(FaceFlashPreviewLayout.this.getContext(), R.color.am));
                FaceFlashPreviewLayout.this.wGH.setTextColor(com.tencent.mm.cb.a.n(FaceFlashPreviewLayout.this.getContext(), R.color.BW_100_Alpha_0_8));
                FaceFlashPreviewLayout.this.wGF.setColorMatrixColorFilter(colorMatrixColorFilter);
                AppMethodBeat.o(186423);
            }
        });
        AppMethodBeat.o(186440);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener
    public float onGetAppBrightness() {
        return 1.0f;
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener
    public void onReflectStart(long j2) {
        AppMethodBeat.i(186441);
        com.tencent.mm.plugin.flash.c.b.axn("reflect");
        this.wHf = (float) j2;
        this.wHg = System.currentTimeMillis();
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(186424);
                FaceFlashPreviewLayout.this.wGH.setText(com.tencent.mm.cb.a.aI(FaceFlashPreviewLayout.this.getContext(), R.string.c6f));
                AppMethodBeat.o(186424);
            }
        });
        Log.i("MicroMsg.FaceFlashManager", "onReflectStart duration:%s", Long.valueOf(j2));
        AppMethodBeat.o(186441);
    }

    public void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(186442);
        Log.i("MicroMsg.FaceFlashManager", "onSurfaceTextureAvailable width:%s,height:%s", Integer.valueOf(i2), Integer.valueOf(i3));
        dKK();
        this.ltm = surfaceTexture;
        if (this.wGO.sZd || this.kkA || getVisibility() != 0) {
            Log.i("MicroMsg.FaceFlashManager", "jump start preview again. isPreviewing:%s isVerifying:%s", Boolean.valueOf(this.wGO.sZd), Boolean.valueOf(this.kkA));
            AppMethodBeat.o(186442);
            return;
        }
        this.wGF.setVisibility(0);
        this.wGO.a(this.wGJ, new b.a() {
            /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.flash.b.a
            public final void a(Boolean bool, b bVar) {
                final int i2;
                final int aspectRatio;
                AppMethodBeat.i(186427);
                if (!bool.booleanValue()) {
                    Log.e("MicroMsg.FaceFlashManagerError", "open camera failed");
                    com.tencent.mm.plugin.flash.c.b.s("openCamera", -1);
                    FaceFlashPreviewLayout.this.wGP.bm(90035, "open camera failed");
                    AppMethodBeat.o(186427);
                    return;
                }
                com.tencent.mm.plugin.flash.c.b.axn("openCamera");
                a unused = FaceFlashPreviewLayout.this.wGQ;
                if (!a.a(bVar.sZb.gII, bVar.sZh)) {
                    com.tencent.mm.plugin.flash.c.b.s("sdkCamera", -1);
                    FaceFlashPreviewLayout.this.wGP.bm(90013, "init yt camera failed");
                    AppMethodBeat.o(186427);
                    return;
                }
                com.tencent.mm.plugin.flash.c.b.axn("sdkCamera");
                int min = Math.min(au.az(FaceFlashPreviewLayout.this.getContext()).x, au.az(FaceFlashPreviewLayout.this.getContext()).y);
                if (au.az(FaceFlashPreviewLayout.this.getContext()).x > au.az(FaceFlashPreviewLayout.this.getContext()).y) {
                    aspectRatio = (int) (((float) min) * 0.27f * 2.0f);
                    i2 = (int) (((float) aspectRatio) * bVar.getAspectRatio());
                } else {
                    i2 = (int) (((float) min) * 0.27f * 2.0f);
                    aspectRatio = (int) (((float) i2) * bVar.getAspectRatio());
                }
                YtSDKKitFramework.YtSDKPlatformContext platformContext = YtSDKKitFramework.getInstance().getPlatformContext();
                platformContext.reflectListener = FaceFlashPreviewLayout.this;
                platformContext.baseFunctionListener = FaceFlashPreviewLayout.this;
                a unused2 = FaceFlashPreviewLayout.this.wGQ;
                if (!a.a(FaceFlashPreviewLayout.this.wGT, FaceFlashPreviewLayout.this)) {
                    com.tencent.mm.plugin.flash.c.b.s("sdkFaceType", -1);
                    FaceFlashPreviewLayout.this.wGP.bm(90013, "init yt framework failed");
                    AppMethodBeat.o(186427);
                    return;
                }
                com.tencent.mm.plugin.flash.c.b.axn("sdkFaceType");
                h.RTc.aV(new Runnable(i2, aspectRatio) {
                    /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass5.AnonymousClass1 */
                    final /* synthetic */ int wHm;
                    final /* synthetic */ int wHn;

                    {
                        this.wHm = r2;
                        this.wHn = r3;
                    }

                    public final void run() {
                        AppMethodBeat.i(186425);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) FaceFlashPreviewLayout.this.wGJ.getLayoutParams();
                        layoutParams.width = this.wHm;
                        layoutParams.height = this.wHn;
                        int i2 = (this.wHn - this.wHm) / 2;
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        layoutParams.topMargin = com.tencent.mm.cb.a.aG(FaceFlashPreviewLayout.this.getContext(), R.dimen.a3r) - i2;
                        FaceFlashPreviewLayout.this.wGJ.setLayoutParams(layoutParams);
                        FaceFlashPreviewLayout.this.sYj.setVisibility(8);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) FaceFlashPreviewLayout.this.wGM.getLayoutParams();
                        layoutParams2.topMargin = (com.tencent.mm.cb.a.aG(FaceFlashPreviewLayout.this.getContext(), R.dimen.a3r) + (Math.min(i2, aspectRatio) / 2)) - (FaceFlashPreviewLayout.this.wGM.getHeight() / 2);
                        FaceFlashPreviewLayout.this.wGM.setLayoutParams(layoutParams2);
                        AppMethodBeat.o(186425);
                    }
                });
                bVar.k(surfaceTexture);
                final Point previewSize = bVar.getPreviewSize();
                Log.i("MicroMsg.FaceFlashManager", "set sdk preview size:%sx%s", Integer.valueOf(previewSize.x), Integer.valueOf(previewSize.y));
                int rotate = YtCameraSetting.getRotate(FaceFlashPreviewLayout.this.getContext(), bVar.sZh, 1);
                int i3 = previewSize.x;
                int i4 = previewSize.y;
                if (rotate >= 5) {
                    i3 = previewSize.y;
                    i4 = previewSize.x;
                }
                Log.i("MicroMsg.FaceFlashManager", "setPreviewRect width:%d,height:%d", Integer.valueOf(i3), Integer.valueOf(i4));
                com.tencent.mm.plugin.flash.c.b.s("detect", i3 + "x" + i4);
                YtSDKKitFramework.getInstance().setPreviewRect(new Rect(0, 0, i3, i4));
                YtSDKKitFramework.getInstance().setDetectRect(new Rect(0, 0, i3, i4));
                FaceFlashPreviewLayout.this.wGS.b(bVar.sZb.getParameters());
                bVar.setPreviewCallback(new Camera.PreviewCallback() {
                    /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass5.AnonymousClass2 */

                    public final void onPreviewFrame(byte[] bArr, Camera camera) {
                        AppMethodBeat.i(186426);
                        if (FaceFlashPreviewLayout.this.wHf > 0.0f) {
                            FaceFlashPreviewLayout.this.wGF.setProgress(((float) (System.currentTimeMillis() - FaceFlashPreviewLayout.this.wHg)) / FaceFlashPreviewLayout.this.wHf);
                        }
                        YtSDKKitFramework.getInstance().updateWithFrameData(bArr, previewSize.x, previewSize.y, 1);
                        com.tencent.mm.plugin.facedetect.model.d.cSR().bB(bArr);
                        AppMethodBeat.o(186426);
                    }
                });
                com.tencent.mm.plugin.flash.c.b.MY(11);
                AppMethodBeat.o(186427);
            }
        });
        AppMethodBeat.o(186442);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(186443);
        Log.i("MicroMsg.FaceFlashManager", "onSurfaceTextureSizeChanged width:%s,height:%s", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(186443);
    }

    private void dKK() {
        AppMethodBeat.i(186444);
        if (this.wGF.getCircleY() <= 0.0f) {
            this.wGF.setCallback(new FaceReflectMask.a() {
                /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.flash.view.FaceReflectMask.a
                public final void dKQ() {
                    AppMethodBeat.i(186428);
                    FaceFlashPreviewLayout.q(FaceFlashPreviewLayout.this);
                    AppMethodBeat.o(186428);
                }
            });
            AppMethodBeat.o(186444);
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.sYj.getLayoutParams();
        marginLayoutParams.topMargin = (int) (this.wGF.getCircleY() - ((float) (this.sYj.getHeight() / 2)));
        this.sYj.setLayoutParams(marginLayoutParams);
        Log.d("MicroMsg.FaceFlashManager", "mFaceLoadingDot topMargin:%s  verifyLoadingBar height:%s", Integer.valueOf(marginLayoutParams.topMargin), Integer.valueOf(this.wGK.getHeight()));
        AppMethodBeat.o(186444);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(186445);
        Log.i("MicroMsg.FaceFlashManager", "onSurfaceTextureDestroyed");
        this.ltm = null;
        this.wGO.stopPreview();
        AppMethodBeat.o(186445);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    private void axd(String str) {
        AppMethodBeat.i(186446);
        Log.i("MicroMsg.FaceFlashManager", "resetTranslateAnimation prepareVerifying:%s", Boolean.valueOf(this.wGX));
        if (this.wHc != null) {
            this.wHc.cancel(true);
            this.wHc = null;
        }
        if (this.wHd != null) {
            this.wHd.cancel(true);
            this.wHd = null;
        }
        if (this.wHe != null) {
            this.wHe.cancel(true);
            this.wHe = null;
        }
        b(this.wGG, str);
        this.wGG.setTextColor(Color.parseColor("#000000"));
        this.wGH.setTextColor(Color.parseColor("#000000"));
        this.wGV.setAnimationListener(null);
        this.wGU.setAnimationListener(null);
        this.wGG.clearAnimation();
        this.wGH.clearAnimation();
        this.wGG.setVisibility(0);
        this.wGH.setVisibility(4);
        this.wGL.setVisibility(4);
        AppMethodBeat.o(186446);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener
    public void onFrameworkEvent(final HashMap<String, Object> hashMap) {
        AppMethodBeat.i(186447);
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass9 */

            public final void run() {
                int i2;
                AppMethodBeat.i(186437);
                if (hashMap.containsKey(StateEvent.Name.UI_TIPS)) {
                    Log.i("MicroMsg.FaceFlashManager", "onFrameworkEvent tips:%s isVerifying:%s,prepareVerifying:%s", hashMap.get(StateEvent.Name.UI_TIPS), Boolean.valueOf(FaceFlashPreviewLayout.this.kkA), Boolean.valueOf(FaceFlashPreviewLayout.this.wGX));
                    if (!FaceFlashPreviewLayout.this.kkA && !FaceFlashPreviewLayout.this.wGX) {
                        if (FaceFlashPreviewLayout.this.wGH.getVisibility() == 0) {
                            FaceFlashPreviewLayout.this.wGR.c(FaceFlashPreviewLayout.this.wGH, (String) hashMap.get(StateEvent.Name.UI_TIPS));
                        } else {
                            FaceFlashPreviewLayout.this.wGR.c(FaceFlashPreviewLayout.this.wGG, (String) hashMap.get(StateEvent.Name.UI_TIPS));
                        }
                    }
                }
                if (hashMap.containsKey(StateEvent.Name.UI_ACTION)) {
                    Log.i("MicroMsg.FaceFlashManager", "onFrameworkEvent actions:" + hashMap.get(StateEvent.Name.UI_ACTION));
                    if (Objects.equals(hashMap.get(StateEvent.Name.UI_ACTION), StateEvent.ActionValue.NET_REQ)) {
                        com.tencent.mm.plugin.flash.c.b.dLk().eqI = System.currentTimeMillis();
                        FaceFlashPreviewLayout.this.wHg = 0;
                        FaceFlashPreviewLayout.this.wGF.setProgress(0.0f);
                        FaceFlashPreviewLayout.c(FaceFlashPreviewLayout.this);
                        FaceFlashPreviewLayout.this.wGO.stopPreview();
                        FaceFlashPreviewLayout.this.wGL.setVisibility(4);
                        FaceFlashPreviewLayout.a(FaceFlashPreviewLayout.this, FaceFlashPreviewLayout.this.wGH, com.tencent.mm.cb.a.aI(FaceFlashPreviewLayout.this.getContext(), R.string.net_reporting));
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) FaceFlashPreviewLayout.this.wGK.getLayoutParams();
                        layoutParams.topMargin = (int) (FaceFlashPreviewLayout.this.wGF.getCircleY() - ((float) (com.tencent.mm.cb.a.aG(FaceFlashPreviewLayout.this.context, R.dimen.a3q) / 2)));
                        FaceFlashPreviewLayout.this.wGK.setLayoutParams(layoutParams);
                        FaceFlashPreviewLayout.this.wGK.setVisibility(0);
                        FaceFlashPreviewLayout.this.wGN.setBackgroundColor(Color.parseColor("#80000000"));
                        FaceFlashPreviewLayout.this.wGN.setVisibility(0);
                    } else if (Objects.equals(hashMap.get(StateEvent.Name.UI_ACTION), StateEvent.ActionValue.STAGE_NOTPASS)) {
                        FaceFlashPreviewLayout.this.wHa++;
                        Log.i("MicroMsg.FaceFlashManager", "STAGE_NOTPASS %s", Integer.valueOf(FaceFlashPreviewLayout.this.wHa));
                        if (FaceFlashPreviewLayout.this.wHa > 10) {
                            if (FaceFlashPreviewLayout.this.wGX && FaceFlashPreviewLayout.this.wGY) {
                                Log.i("MicroMsg.FaceFlashManager", "prepareVerifying and out rect time:%s", Integer.valueOf(FaceFlashPreviewLayout.this.wGZ));
                                FaceFlashPreviewLayout.this.wGZ++;
                                if (FaceFlashPreviewLayout.this.wGZ >= 4) {
                                    YtSDKKitFramework.getInstance().fireEvent(YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS, null);
                                    FaceFlashPreviewLayout.c(FaceFlashPreviewLayout.this);
                                    FaceFlashPreviewLayout.this.wGO.stopPreview();
                                    FaceFlashPreviewLayout.this.wGP.axf(FaceFlashPreviewLayout.this.wGR.dT(com.tencent.mm.cb.a.aI(FaceFlashPreviewLayout.this.getContext(), R.string.c5x), 90031).toString());
                                }
                            }
                            if (!FaceFlashPreviewLayout.this.kkA && FaceFlashPreviewLayout.this.wGY) {
                                FaceFlashPreviewLayout.this.wGM.setVisibility(4);
                                FaceFlashPreviewLayout.this.wGN.setVisibility(4);
                                FaceFlashPreviewLayout.this.setOnClickListener(null);
                                FaceFlashPreviewLayout.a(FaceFlashPreviewLayout.this, com.tencent.mm.plugin.flash.d.a.aH(FaceFlashPreviewLayout.this.context, (String) hashMap.get(StateEvent.Name.UI_TIPS)));
                                FaceFlashPreviewLayout.this.wGX = false;
                            }
                            FaceFlashPreviewLayout.this.wGY = false;
                        }
                    } else if (Objects.equals(hashMap.get(StateEvent.Name.UI_ACTION), StateEvent.ActionValue.STAGE_PASS)) {
                        com.tencent.mm.plugin.flash.c.b.axo("faceRecognized");
                        FaceFlashPreviewLayout.this.wHa = 0;
                        FaceFlashPreviewLayout.this.wGY = true;
                        if (!FaceFlashPreviewLayout.this.wGX) {
                            FaceFlashPreviewLayout.this.wGX = true;
                            if (FaceFlashPreviewLayout.this.wGT == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE && FaceFlashPreviewLayout.this.wGL.getChildCount() == 0) {
                                FaceFlashPreviewLayout.this.wGL.setNumbers(((c) FaceFlashPreviewLayout.this.wGR).wIt);
                                FaceFlashPreviewLayout.this.wGL.measure(0, 0);
                                int circleY = ((int) FaceFlashPreviewLayout.this.wGF.getCircleY()) - (FaceFlashPreviewLayout.this.wGL.getMeasuredHeight() / 2);
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) FaceFlashPreviewLayout.this.wGL.getLayoutParams();
                                layoutParams2.width = ((int) ((((float) FaceFlashPreviewLayout.this.getWidth()) * 0.27f) * 2.0f)) - com.tencent.mm.cb.a.aG(FaceFlashPreviewLayout.this.context, R.dimen.ci);
                                layoutParams2.topMargin = circleY;
                                FaceFlashPreviewLayout.this.wGL.setLayoutParams(layoutParams2);
                            }
                            if (FaceFlashPreviewLayout.this.wHd != null) {
                                FaceFlashPreviewLayout.this.wHd.cancel(true);
                                FaceFlashPreviewLayout.this.wHd = null;
                            }
                            FaceFlashPreviewLayout.a(FaceFlashPreviewLayout.this, FaceFlashPreviewLayout.this.wGG, com.tencent.mm.cb.a.aI(FaceFlashPreviewLayout.this.getContext(), R.string.fl_pose_incorrect));
                            FaceFlashPreviewLayout.this.wHd = h.RTc.n(new Runnable() {
                                /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass9.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(186436);
                                    FaceFlashPreviewLayout.D(FaceFlashPreviewLayout.this);
                                    AppMethodBeat.o(186436);
                                }
                            }, (long) FaceFlashPreviewLayout.wGW);
                        }
                    }
                }
                if (hashMap.containsKey(StateEvent.Name.PROCESS_RESULT) && FaceFlashPreviewLayout.this.getVisibility() == 0) {
                    Log.i("MicroMsg.FaceFlashManager", "onFrameworkEvent result:" + hashMap.get(StateEvent.Name.PROCESS_RESULT));
                    FaceFlashPreviewLayout.this.wHi.cancel();
                    FaceFlashPreviewLayout.c(FaceFlashPreviewLayout.this);
                    FaceFlashPreviewLayout.this.wGO.stopPreview();
                    FaceFlashPreviewLayout.this.kkA = false;
                    if (Objects.equals(hashMap.get(StateEvent.Name.PROCESS_RESULT), StateEvent.ProcessResult.SUCCEED)) {
                        com.tencent.mm.plugin.flash.c.b.axn("sdkResult");
                        Log.i("MicroMsg.FaceFlashManager", "onFrameworkEvent result:SUCCEED ,param:%s", hashMap);
                        FaceFlashPreviewLayout.this.wGS.dLf();
                        FaceFlashUI faceFlashUI = FaceFlashPreviewLayout.this.wGP;
                        String str = (String) hashMap.get("message");
                        Log.i("MicroMsg.FaceFlashManager", "[%s]FaceFlashActivity showSuccessLayout", Integer.valueOf(faceFlashUI.hashCode()));
                        faceFlashUI.wHM = 90025;
                        faceFlashUI.wHO = str;
                        com.tencent.mm.plugin.flash.c.b.axl(str);
                        faceFlashUI.MP(com.tencent.mm.cb.a.n(faceFlashUI.getContext(), R.color.fo));
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.optBoolean("selfHandle", false)) {
                                faceFlashUI.axg(str);
                                AppMethodBeat.o(186437);
                                return;
                            }
                            faceFlashUI.wHK.setVisibility(8);
                            faceFlashUI.wHL.setVisibility(0);
                            FaceFlashProcessLayout faceFlashProcessLayout = faceFlashUI.wHL;
                            Log.i(FaceFlashProcessLayout.TAG, "showSuccessAnimation");
                            faceFlashProcessLayout.wHw.setText(com.tencent.mm.cb.a.aI(faceFlashProcessLayout.getContext(), R.string.c70));
                            faceFlashProcessLayout.wHy.setImageResource(R.drawable.uf);
                            faceFlashProcessLayout.wHx.setImageDrawable(com.tencent.mm.cb.a.l(faceFlashProcessLayout.getContext(), R.raw.icons_filled_done3));
                            faceFlashProcessLayout.wHx.startAnimation(faceFlashProcessLayout.wHC);
                            faceFlashProcessLayout.wHy.startAnimation(faceFlashProcessLayout.wHB);
                            faceFlashProcessLayout.wHz.setVisibility(4);
                            h.RTc.n(new Runnable(jSONObject) {
                                /* class com.tencent.mm.plugin.flash.FaceFlashUI.AnonymousClass5 */
                                final /* synthetic */ JSONObject wHE;

                                {
                                    this.wHE = r2;
                                }

                                public final void run() {
                                    AppMethodBeat.i(186483);
                                    FaceFlashUI.this.aN(this.wHE);
                                    AppMethodBeat.o(186483);
                                }
                            }, 1000);
                            AppMethodBeat.o(186437);
                            return;
                        } catch (JSONException e2) {
                            Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", e2, "parse face success result error.%s", str);
                            AppMethodBeat.o(186437);
                            return;
                        }
                    } else if (Objects.equals(hashMap.get(StateEvent.Name.PROCESS_RESULT), StateEvent.ProcessResult.FAILED)) {
                        HashMap hashMap = hashMap;
                        if (hashMap.containsKey("error_code")) {
                            i2 = ((Integer) hashMap.get("error_code")).intValue();
                        } else {
                            i2 = -1;
                        }
                        com.tencent.mm.plugin.flash.c.b.s("sdkResult", Integer.valueOf(i2));
                        Log.i("MicroMsg.FaceFlashManager", "onFrameworkEvent result:FAILED ,param:%s", hashMap);
                        if (com.tencent.mm.plugin.flash.d.a.a(hashMap, "error_code", ErrorCode.YT_SDK_VERIFY_TIMEOUT)) {
                            hashMap.put("message", com.tencent.mm.cb.a.aI(FaceFlashPreviewLayout.this.context, R.string.c6z));
                        } else if (com.tencent.mm.plugin.flash.d.a.a(hashMap, "error_code", ErrorCode.YT_SDK_NETWORK_ERROR)) {
                            hashMap.put("message", com.tencent.mm.cb.a.aI(FaceFlashPreviewLayout.this.context, R.string.net_fetch_failed));
                        } else if (com.tencent.mm.plugin.flash.d.a.a(hashMap, "error_code", 4194304) && hashMap.containsKey("message")) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(hashMap.get("message").toString());
                                if ((jSONObject2.optString("errormsg").equals(StringCode.FL_NO_FACE) || jSONObject2.optString("errormsg").equals(StringCode.FL_INCOMPLETE_FACE)) && !FaceFlashPreviewLayout.this.wHh) {
                                    com.tencent.mm.plugin.flash.c.b.dLi().eqY++;
                                    FaceFlashPreviewLayout.G(FaceFlashPreviewLayout.this);
                                    FaceFlashPreviewLayout.a(FaceFlashPreviewLayout.this, FaceFlashPreviewLayout.this.wGG, com.tencent.mm.cb.a.aI(FaceFlashPreviewLayout.this.getContext(), R.string.fl_pose_not_in_rect));
                                    AppMethodBeat.o(186437);
                                    return;
                                }
                            } catch (Exception e3) {
                                Log.e("MicroMsg.FaceFlashManagerError", "get message error,message:%s", hashMap.get("message"));
                            }
                        }
                        com.tencent.mm.plugin.flash.d.a.a(FaceFlashPreviewLayout.this.getContext(), hashMap);
                        FaceFlashPreviewLayout.this.wGP.axf((String) hashMap.get("message"));
                        AppMethodBeat.o(186437);
                        return;
                    } else {
                        Log.i("MicroMsg.FaceFlashManager", "onFrameworkEvent result:UNKNOWN ,param:%s", hashMap);
                        FaceFlashPreviewLayout.this.wGP.axf((String) hashMap.get("message"));
                    }
                }
                AppMethodBeat.o(186437);
            }
        });
        AppMethodBeat.o(186447);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener
    public void onNetworkRequestEvent(String str, String str2, HashMap<String, String> hashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser) {
        AppMethodBeat.i(186448);
        this.wGR.onNetworkRequestEvent(str, str2, hashMap, iYtSDKKitNetResponseParser);
        AppMethodBeat.o(186448);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener
    public String base64Encode(byte[] bArr, int i2) {
        return null;
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener
    public byte[] getVoiceData() {
        AppMethodBeat.i(186449);
        dKO();
        byte[] cTo = ((c) this.wGR).sSq.cTo();
        com.tencent.mm.plugin.flash.c.b.s("voiceData", Integer.valueOf((cTo == null || cTo.length <= 0) ? -1 : 0));
        AppMethodBeat.o(186449);
        return cTo;
    }

    public final void reset() {
        AppMethodBeat.i(186450);
        Log.i("MicroMsg.FaceFlashManager", "reset");
        this.wGZ = 0;
        this.wHi.cancel();
        this.wHi.start();
        this.wHh = false;
        com.tencent.mm.plugin.flash.c.b.MY(12);
        com.tencent.mm.plugin.flash.c.b.dLi().erb = 1;
        com.tencent.mm.plugin.flash.c.b.dLi().eqQ = (long) this.dYn;
        dKL();
        AppMethodBeat.o(186450);
    }

    private void dKL() {
        AppMethodBeat.i(186451);
        this.wGM.setVisibility(4);
        if (!(this.ltm == null || this.wGO == null)) {
            final Point previewSize = this.wGO.getPreviewSize();
            this.wGO.a(this.ltm, new Camera.PreviewCallback() {
                /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass2 */

                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    AppMethodBeat.i(186422);
                    if (FaceFlashPreviewLayout.this.wHf > 0.0f && FaceFlashPreviewLayout.this.wHg > 0) {
                        FaceFlashPreviewLayout.this.wGF.setProgress(((float) (System.currentTimeMillis() - FaceFlashPreviewLayout.this.wHg)) / FaceFlashPreviewLayout.this.wHf);
                    }
                    YtSDKKitFramework.getInstance().updateWithFrameData(bArr, previewSize.x, previewSize.y, 1);
                    com.tencent.mm.plugin.facedetect.model.d.cSR().bB(bArr);
                    AppMethodBeat.o(186422);
                }
            });
        }
        dKM();
        AppMethodBeat.o(186451);
    }

    private void dKM() {
        AppMethodBeat.i(186452);
        Log.i("MicroMsg.FaceFlashManager", "resetWithoutPreview");
        com.tencent.mm.plugin.flash.c.a.b(this.wGT);
        dKN();
        this.wGX = false;
        this.kkA = false;
        this.wHg = 0;
        this.wHa = 0;
        this.wGF.setProgress(0.0f);
        this.wGK.setVisibility(8);
        this.wGL.release();
        this.wGL.removeAllViews();
        this.wGN.setVisibility(4);
        this.wGS.aQf();
        this.wGR.reset();
        a.reset();
        this.wGP.MP(com.tencent.mm.cb.a.n(getContext(), R.color.fm));
        axd(com.tencent.mm.cb.a.aI(getContext(), R.string.fl_pose_incorrect));
        AppMethodBeat.o(186452);
    }

    private void dKN() {
        AppMethodBeat.i(186453);
        this.wGF.dLo();
        this.wGP.MP(com.tencent.mm.cb.a.n(getContext(), R.color.fm));
        this.wGH.setTextColor(com.tencent.mm.cb.a.n(getContext(), R.color.fm));
        this.wGG.setTextColor(com.tencent.mm.cb.a.n(getContext(), R.color.fm));
        AppMethodBeat.o(186453);
    }

    private void b(TextView textView, String str) {
        AppMethodBeat.i(186454);
        textView.setText(str);
        this.wGR.dLd();
        AppMethodBeat.o(186454);
    }

    /* access modifiers changed from: package-private */
    public final void dKO() {
        AppMethodBeat.i(186455);
        this.wGL.release();
        this.wGS.GA(this.wGR.cSK());
        com.tencent.mm.plugin.flash.c.b.dLi().iF(String.valueOf(this.wGR.cSK()));
        if (this.wGR instanceof c) {
            ((c) this.wGR).stopRecord();
        }
        AppMethodBeat.o(186455);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(186456);
        this.wGJ.setRotation((float) (-(getDegree() - this.wHb)));
        AppMethodBeat.o(186456);
    }

    /* access modifiers changed from: package-private */
    public int getDegree() {
        int i2;
        AppMethodBeat.i(186457);
        switch (((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation()) {
            case 0:
                i2 = 0;
                break;
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = TXLiveConstants.RENDER_ROTATION_180;
                break;
            case 3:
                i2 = 270;
                break;
            default:
                i2 = 0;
                break;
        }
        AppMethodBeat.o(186457);
        return i2;
    }

    static /* synthetic */ void D(FaceFlashPreviewLayout faceFlashPreviewLayout) {
        AppMethodBeat.i(186462);
        faceFlashPreviewLayout.wGU.cancel();
        faceFlashPreviewLayout.wGU.setDuration(500);
        faceFlashPreviewLayout.wGU.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass7 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(186429);
                FaceFlashPreviewLayout.this.wGG.setVisibility(4);
                AppMethodBeat.o(186429);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        faceFlashPreviewLayout.wGG.startAnimation(faceFlashPreviewLayout.wGU);
        faceFlashPreviewLayout.wGV.cancel();
        faceFlashPreviewLayout.wGV.setDuration(500);
        faceFlashPreviewLayout.wGV.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass8 */

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(186434);
                Log.i("MicroMsg.FaceFlashManager", "after onAnimationStart ");
                FaceFlashPreviewLayout.this.wGR.r(FaceFlashPreviewLayout.this.wGH);
                FaceFlashPreviewLayout.this.wGH.setVisibility(0);
                if (FaceFlashPreviewLayout.this.wGT == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE) {
                    FaceFlashPreviewLayout.this.wGN.setBackgroundColor(Color.parseColor("#99000000"));
                    FaceFlashPreviewLayout.this.wGN.setVisibility(0);
                    FaceFlashPreviewLayout.this.wGM.setVisibility(0);
                    com.tencent.mm.plugin.flash.c.b.MY(6);
                    FaceFlashPreviewLayout.this.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass8.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(186432);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/FaceFlashPreviewLayout$7$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            FaceFlashPreviewLayout.this.kkA = true;
                            FaceFlashPreviewLayout.this.setOnClickListener(null);
                            FaceFlashPreviewLayout.this.wGM.setVisibility(4);
                            FaceFlashPreviewLayout.this.wGL.setVisibility(0);
                            ((c) FaceFlashPreviewLayout.this.wGR).reset();
                            ((c) FaceFlashPreviewLayout.this.wGR).a(new c.a() {
                                /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass8.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.flash.b.c.a
                                public final void j(com.tencent.mm.plugin.facedetect.d.a aVar) {
                                    AppMethodBeat.i(186430);
                                    Log.i("MicroMsg.FaceFlashManager", "number verify start record voice");
                                    if (FaceFlashPreviewLayout.this.wGS.dLe()) {
                                        aVar.b(com.tencent.mm.plugin.facedetect.e.a.cTF().cTG());
                                        FaceFlashPreviewLayout.this.wGS.bFT();
                                    }
                                    AppMethodBeat.o(186430);
                                }
                            });
                            FaceFlashPreviewLayout.this.wHe = h.RTc.n(new Runnable() {
                                /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass8.AnonymousClass1.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(186431);
                                    FaceFlashPreviewLayout.this.wGL.dLn();
                                    com.tencent.mm.plugin.flash.c.b.dLi().erg = System.currentTimeMillis();
                                    YtSDKKitFramework.getInstance().fireEvent(YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_BEGIN_LIVENESS, null);
                                    AppMethodBeat.o(186431);
                                }
                            }, (long) a.dKY());
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashPreviewLayout$7$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(186432);
                        }
                    });
                }
                AppMethodBeat.o(186434);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(186435);
                if (FaceFlashPreviewLayout.this.wHc != null) {
                    FaceFlashPreviewLayout.this.wHc.cancel(true);
                    FaceFlashPreviewLayout.this.wHc = null;
                }
                FaceFlashPreviewLayout.this.wHc = h.RTc.n(new Runnable() {
                    /* class com.tencent.mm.plugin.flash.FaceFlashPreviewLayout.AnonymousClass8.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(186433);
                        if (!FaceFlashPreviewLayout.this.wGX) {
                            Log.i("MicroMsg.FaceFlashManager", "prepareVerifying = false ,face not in rect.");
                            AppMethodBeat.o(186433);
                            return;
                        }
                        Log.i("MicroMsg.FaceFlashManager", "onAnimationEnd end......... start face verity.");
                        com.tencent.mm.plugin.flash.c.b.MY(3);
                        com.tencent.mm.plugin.flash.c.b.axn("sdkVerify");
                        if (FaceFlashPreviewLayout.this.wGT != YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE) {
                            if (FaceFlashPreviewLayout.this.wGT == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
                                com.tencent.mm.plugin.flash.c.b.MY(7);
                            } else if (FaceFlashPreviewLayout.this.wGT == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_REFLECT_TYPE) {
                                com.tencent.mm.plugin.flash.c.b.MY(5);
                            }
                            com.tencent.mm.plugin.flash.c.b.dLi().erg = System.currentTimeMillis();
                            YtSDKKitFramework.getInstance().fireEvent(YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_BEGIN_LIVENESS, null);
                            FaceFlashPreviewLayout.this.kkA = true;
                            FaceFlashPreviewLayout.this.wGS.bFT();
                        }
                        AppMethodBeat.o(186433);
                    }
                }, (long) FaceFlashPreviewLayout.wGW);
                AppMethodBeat.o(186435);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        faceFlashPreviewLayout.wGH.startAnimation(faceFlashPreviewLayout.wGV);
        AppMethodBeat.o(186462);
    }
}

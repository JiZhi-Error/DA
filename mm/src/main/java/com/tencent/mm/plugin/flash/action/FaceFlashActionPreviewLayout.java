package com.tencent.mm.plugin.flash.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.CountDownTimer;
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
import com.tencent.mm.plugin.flash.view.FaceNumberLayout;
import com.tencent.mm.plugin.flash.view.FaceReflectMask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YtCameraSetting;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceFlashActionPreviewLayout extends RelativeLayout implements TextureView.SurfaceTextureListener, YtSDKKitFramework.IYTBaseFunctionListener, YtSDKKitFramework.IYtSDKKitFrameworkEventListener {
    private static final int wGW = a.dKW();
    private Context context;
    private boolean kkA;
    SurfaceTexture ltm;
    private ImageView sYj;
    private FaceReflectMask wGF;
    private TextView wGG;
    private TextView wGH;
    private MMTextureView wGJ;
    ProgressBar wGK;
    private FaceNumberLayout wGL;
    private View wGN;
    b wGO;
    private com.tencent.mm.plugin.flash.a wGQ;
    private g wGR;
    private d wGS;
    private YtSDKKitFramework.YtSDKKitFrameworkWorkMode wGT;
    private Animation wGU;
    private Animation wGV;
    private boolean wGX;
    private boolean wGY;
    private int wGZ;
    private FaceFlashActionUI wHY;
    private int wHa;
    private com.tencent.f.i.d wHc;
    private com.tencent.f.i.d wHd;
    private float wHf;
    private long wHg;
    private boolean wHh;
    private CountDownTimer wHi;

    static /* synthetic */ void F(FaceFlashActionPreviewLayout faceFlashActionPreviewLayout) {
        AppMethodBeat.i(186571);
        faceFlashActionPreviewLayout.dKL();
        AppMethodBeat.o(186571);
    }

    static /* synthetic */ void a(FaceFlashActionPreviewLayout faceFlashActionPreviewLayout, TextView textView, String str) {
        AppMethodBeat.i(258263);
        faceFlashActionPreviewLayout.b(textView, str);
        AppMethodBeat.o(258263);
    }

    static /* synthetic */ void a(FaceFlashActionPreviewLayout faceFlashActionPreviewLayout, String str) {
        AppMethodBeat.i(258264);
        faceFlashActionPreviewLayout.axd(str);
        AppMethodBeat.o(258264);
    }

    static /* synthetic */ void n(FaceFlashActionPreviewLayout faceFlashActionPreviewLayout) {
        AppMethodBeat.i(186566);
        faceFlashActionPreviewLayout.dKK();
        AppMethodBeat.o(186566);
    }

    static /* synthetic */ void v(FaceFlashActionPreviewLayout faceFlashActionPreviewLayout) {
        AppMethodBeat.i(258262);
        faceFlashActionPreviewLayout.dKO();
        AppMethodBeat.o(258262);
    }

    public FaceFlashActionPreviewLayout(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public FaceFlashActionPreviewLayout(Context context2, AttributeSet attributeSet, int i2) {
        this(context2, attributeSet, i2, (byte) 0);
    }

    private FaceFlashActionPreviewLayout(Context context2, AttributeSet attributeSet, int i2, byte b2) {
        super(context2, attributeSet, i2, 0);
        AppMethodBeat.i(186550);
        this.wGO = new b(getContext());
        this.wHY = (FaceFlashActionUI) getContext();
        this.wGQ = new com.tencent.mm.plugin.flash.a();
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
        this.wHf = 0.0f;
        this.wHg = 0;
        this.wHh = false;
        this.wHi = new CountDownTimer() {
            /* class com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.AnonymousClass1 */

            public final void onTick(long j2) {
            }

            public final void onFinish() {
                AppMethodBeat.i(186536);
                FaceFlashActionPreviewLayout.this.wHh = true;
                if (!FaceFlashActionPreviewLayout.this.kkA && FaceFlashActionPreviewLayout.this.getVisibility() == 0) {
                    FaceFlashActionPreviewLayout.this.wGO.stopPreview();
                    YtSDKKitFramework.getInstance().fireEvent(YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS, null);
                    FaceFlashActionPreviewLayout.this.wHY.axf(FaceFlashActionPreviewLayout.this.wGR.dT(com.tencent.mm.cb.a.aI(FaceFlashActionPreviewLayout.this.getContext(), R.string.c6z), 90032).toString());
                }
                AppMethodBeat.o(186536);
            }
        };
        LayoutInflater.from(getContext()).inflate(R.layout.a5x, (ViewGroup) this, true);
        this.wGF = (FaceReflectMask) findViewById(R.id.d5z);
        this.wGG = (TextView) findViewById(R.id.d62);
        this.wGH = (TextView) findViewById(R.id.d61);
        this.sYj = (ImageView) findViewById(R.id.c8g);
        this.wGK = (ProgressBar) findViewById(R.id.c9p);
        this.wGL = (FaceNumberLayout) findViewById(R.id.d5v);
        this.wGN = findViewById(R.id.d5s);
        Intent intent = ((Activity) getContext()).getIntent();
        com.tencent.mm.plugin.flash.c.b.dLj().eqQ = 2;
        this.wGT = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE;
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "biz choose ACTION_TYPE");
        this.wGR = com.tencent.mm.plugin.flash.b.b.MR(3);
        this.wGR.h(intent, (Activity) getContext());
        this.wGS.e(intent, 3);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "face detect type:%s  after type:%s", this.wGT, 3);
        b(this.wGG, com.tencent.mm.cb.a.aI(getContext(), R.string.fl_pose_not_in_rect));
        this.wGJ = (MMTextureView) findViewById(R.id.d5t);
        if (!com.tencent.mm.plugin.flash.a.dKR()) {
            com.tencent.mm.plugin.flash.c.b.s("initSdk", -1);
            this.wHY.bm(90013, "init lib failed");
            AppMethodBeat.o(186550);
            return;
        }
        com.tencent.mm.plugin.flash.c.b.axn("initSdk");
        if (this.wGJ.isAvailable()) {
            onSurfaceTextureAvailable(this.wGJ.getSurfaceTexture(), this.wGJ.getWidth(), this.wGJ.getHeight());
        }
        this.wGJ.setSurfaceTextureListener(this);
        this.wHi.start();
        AppMethodBeat.o(186550);
    }

    static {
        AppMethodBeat.i(186572);
        AppMethodBeat.o(186572);
    }

    public void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(186551);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onSurfaceTextureAvailable width:%s,height:%s", Integer.valueOf(i2), Integer.valueOf(i3));
        dKK();
        this.ltm = surfaceTexture;
        if (this.wGO.sZd || this.kkA || getVisibility() != 0) {
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "jump start preview again. isPreviewing:%s isVerifying:%s", Boolean.valueOf(this.wGO.sZd), Boolean.valueOf(this.kkA));
            AppMethodBeat.o(186551);
            return;
        }
        this.wGF.setVisibility(0);
        this.wGO.a(this.wGJ, new b.a() {
            /* class com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.flash.b.a
            public final void a(Boolean bool, b bVar) {
                AppMethodBeat.i(186539);
                if (!bool.booleanValue()) {
                    Log.e("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "open camera failed");
                    com.tencent.mm.plugin.flash.c.b.s("openCamera", -1);
                    FaceFlashActionPreviewLayout.this.wHY.bm(90013, "open camera failed");
                    AppMethodBeat.o(186539);
                    return;
                }
                com.tencent.mm.plugin.flash.c.b.axn("openCamera");
                com.tencent.mm.plugin.flash.a unused = FaceFlashActionPreviewLayout.this.wGQ;
                if (!com.tencent.mm.plugin.flash.a.a(bVar.sZb.gII, bVar.sZh)) {
                    com.tencent.mm.plugin.flash.c.b.s("sdkCamera", -1);
                    FaceFlashActionPreviewLayout.this.wHY.bm(90013, "init yt camera failed");
                    AppMethodBeat.o(186539);
                    return;
                }
                com.tencent.mm.plugin.flash.c.b.axn("sdkCamera");
                final int i2 = (int) (((float) au.az(FaceFlashActionPreviewLayout.this.getContext()).x) * 0.27f * 2.0f);
                final int aspectRatio = (int) (((float) i2) * bVar.getAspectRatio());
                YtSDKKitFramework.getInstance().getPlatformContext().baseFunctionListener = FaceFlashActionPreviewLayout.this;
                com.tencent.mm.plugin.flash.a unused2 = FaceFlashActionPreviewLayout.this.wGQ;
                if (!com.tencent.mm.plugin.flash.a.a(FaceFlashActionPreviewLayout.this.wGT, FaceFlashActionPreviewLayout.this)) {
                    com.tencent.mm.plugin.flash.c.b.s("sdkFaceType", -1);
                    FaceFlashActionPreviewLayout.this.wHY.bm(90013, "init yt framework failed");
                    AppMethodBeat.o(186539);
                    return;
                }
                com.tencent.mm.plugin.flash.c.b.axn("sdkFaceType");
                h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(186537);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) FaceFlashActionPreviewLayout.this.wGJ.getLayoutParams();
                        layoutParams.width = i2;
                        layoutParams.height = aspectRatio;
                        layoutParams.topMargin = com.tencent.mm.cb.a.aG(FaceFlashActionPreviewLayout.this.getContext(), R.dimen.a3r) - ((aspectRatio - i2) / 2);
                        FaceFlashActionPreviewLayout.this.wGJ.setLayoutParams(layoutParams);
                        FaceFlashActionPreviewLayout.this.sYj.setVisibility(8);
                        AppMethodBeat.o(186537);
                    }
                });
                bVar.k(surfaceTexture);
                final Point previewSize = bVar.getPreviewSize();
                Log.i("MicroMsg.FaceFlashManager", "set sdk preview size:%sx%s", Integer.valueOf(previewSize.x), Integer.valueOf(previewSize.y));
                int rotate = YtCameraSetting.getRotate(FaceFlashActionPreviewLayout.this.getContext(), bVar.sZh, 1);
                int i3 = previewSize.x;
                int i4 = previewSize.y;
                if (rotate >= 5) {
                    i3 = previewSize.y;
                    i4 = previewSize.x;
                }
                Log.i("MicroMsg.FaceFlashManager", "setPreviewRect width:%d,height:%d", Integer.valueOf(i3), Integer.valueOf(i4));
                YtSDKKitFramework.getInstance().setPreviewRect(new Rect(0, 0, i3, i4));
                YtSDKKitFramework.getInstance().setDetectRect(new Rect(0, 0, i3, i4));
                FaceFlashActionPreviewLayout.this.wGS.b(bVar.sZb.getParameters());
                bVar.setPreviewCallback(new Camera.PreviewCallback() {
                    /* class com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.AnonymousClass2.AnonymousClass2 */

                    public final void onPreviewFrame(byte[] bArr, Camera camera) {
                        AppMethodBeat.i(186538);
                        if (FaceFlashActionPreviewLayout.this.wHf > 0.0f && FaceFlashActionPreviewLayout.this.wHg > 0) {
                            FaceFlashActionPreviewLayout.this.wGF.setProgress(((float) (System.currentTimeMillis() - FaceFlashActionPreviewLayout.this.wHg)) / FaceFlashActionPreviewLayout.this.wHf);
                        }
                        YtSDKKitFramework.getInstance().updateWithFrameData(bArr, previewSize.x, previewSize.y, 1);
                        com.tencent.mm.plugin.facedetect.model.d.cSR().bB(bArr);
                        AppMethodBeat.o(186538);
                    }
                });
                AppMethodBeat.o(186539);
            }
        });
        AppMethodBeat.o(186551);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(186552);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onSurfaceTextureSizeChanged width:%s,height:%s", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(186552);
    }

    private void dKK() {
        AppMethodBeat.i(186553);
        if (this.wGF.getCircleY() <= 0.0f) {
            this.wGF.setCallback(new FaceReflectMask.a() {
                /* class com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.flash.view.FaceReflectMask.a
                public final void dKQ() {
                    AppMethodBeat.i(186540);
                    FaceFlashActionPreviewLayout.n(FaceFlashActionPreviewLayout.this);
                    AppMethodBeat.o(186540);
                }
            });
            AppMethodBeat.o(186553);
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.sYj.getLayoutParams();
        marginLayoutParams.topMargin = (int) (this.wGF.getCircleY() - ((float) (this.sYj.getHeight() / 2)));
        this.sYj.setLayoutParams(marginLayoutParams);
        Log.d("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "mFaceLoadingDot topMargin:%s  verifyLoadingBar height:%s", Integer.valueOf(marginLayoutParams.topMargin), Integer.valueOf(this.wGK.getHeight()));
        AppMethodBeat.o(186553);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(186554);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onSurfaceTextureDestroyed");
        this.ltm = null;
        this.wGO.stopPreview();
        AppMethodBeat.o(186554);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    private void axd(String str) {
        AppMethodBeat.i(186555);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "resetTranslateAnimation prepareVerifying:%s", Boolean.valueOf(this.wGX));
        if (this.wHc != null) {
            this.wHc.cancel(true);
            this.wHc = null;
        }
        if (this.wHd != null) {
            this.wHd.cancel(true);
            this.wHd = null;
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
        AppMethodBeat.o(186555);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener
    public void onFrameworkEvent(final HashMap<String, Object> hashMap) {
        AppMethodBeat.i(186556);
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(186547);
                if (hashMap.containsKey(StateEvent.Name.UI_TIPS)) {
                    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onFrameworkEvent preview tips:%s isVerifying:%s,prepareVerifying:%s", hashMap.get(StateEvent.Name.UI_TIPS), Boolean.valueOf(FaceFlashActionPreviewLayout.this.kkA), Boolean.valueOf(FaceFlashActionPreviewLayout.this.wGX));
                    if (!FaceFlashActionPreviewLayout.this.kkA && !FaceFlashActionPreviewLayout.this.wGX) {
                        if (FaceFlashActionPreviewLayout.this.wGH.getVisibility() == 0) {
                            FaceFlashActionPreviewLayout.this.wGR.c(FaceFlashActionPreviewLayout.this.wGH, (String) hashMap.get(StateEvent.Name.UI_TIPS));
                        } else {
                            FaceFlashActionPreviewLayout.this.wGR.c(FaceFlashActionPreviewLayout.this.wGG, (String) hashMap.get(StateEvent.Name.UI_TIPS));
                        }
                    }
                }
                if (hashMap.containsKey(StateEvent.Name.UI_ACTION)) {
                    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onFrameworkEvent acting:" + hashMap.get(StateEvent.Name.UI_ACTION));
                    if (Objects.equals(hashMap.get(StateEvent.Name.UI_ACTION), StateEvent.ActionValue.NET_REQ)) {
                        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onFrameworkEvent acting ：network_request ");
                        FaceFlashActionPreviewLayout.this.wHg = 0;
                        FaceFlashActionPreviewLayout.this.wGF.setProgress(0.0f);
                        FaceFlashActionPreviewLayout.v(FaceFlashActionPreviewLayout.this);
                        FaceFlashActionPreviewLayout.this.wGO.stopPreview();
                        FaceFlashActionPreviewLayout.this.wGL.setVisibility(4);
                        FaceFlashActionPreviewLayout.a(FaceFlashActionPreviewLayout.this, FaceFlashActionPreviewLayout.this.wGH, com.tencent.mm.cb.a.aI(FaceFlashActionPreviewLayout.this.getContext(), R.string.net_reporting));
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) FaceFlashActionPreviewLayout.this.wGK.getLayoutParams();
                        layoutParams.topMargin = (int) (FaceFlashActionPreviewLayout.this.wGF.getCircleY() - ((float) (com.tencent.mm.cb.a.aG(FaceFlashActionPreviewLayout.this.context, R.dimen.a3q) / 2)));
                        FaceFlashActionPreviewLayout.this.wGK.setLayoutParams(layoutParams);
                        FaceFlashActionPreviewLayout.this.wGK.setVisibility(0);
                        FaceFlashActionPreviewLayout.this.wGN.setVisibility(0);
                    } else if (Objects.equals(hashMap.get(StateEvent.Name.UI_ACTION), StateEvent.ActionValue.STAGE_NOTPASS)) {
                        FaceFlashActionPreviewLayout.this.wHa++;
                        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onFrameworkEvent acting ：not_pass，faceOutRectFrames：%s", Integer.valueOf(FaceFlashActionPreviewLayout.this.wHa));
                        if (FaceFlashActionPreviewLayout.this.wHa > 10) {
                            if (FaceFlashActionPreviewLayout.this.wGX && FaceFlashActionPreviewLayout.this.wGY) {
                                Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "prepareVerifying and out rect time:%s", Integer.valueOf(FaceFlashActionPreviewLayout.this.wGZ));
                                FaceFlashActionPreviewLayout.this.wGZ++;
                                if (FaceFlashActionPreviewLayout.this.wGZ >= 4) {
                                    YtSDKKitFramework.getInstance().fireEvent(YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS, null);
                                    FaceFlashActionPreviewLayout.v(FaceFlashActionPreviewLayout.this);
                                    FaceFlashActionPreviewLayout.this.wGO.stopPreview();
                                    FaceFlashActionPreviewLayout.this.wHY.axf(FaceFlashActionPreviewLayout.this.wGR.dT(com.tencent.mm.cb.a.aI(FaceFlashActionPreviewLayout.this.getContext(), R.string.c5x), 90031).toString());
                                }
                            }
                            if (!FaceFlashActionPreviewLayout.this.kkA && FaceFlashActionPreviewLayout.this.wGY) {
                                FaceFlashActionPreviewLayout.a(FaceFlashActionPreviewLayout.this, com.tencent.mm.plugin.flash.d.a.aH(FaceFlashActionPreviewLayout.this.context, (String) hashMap.get(StateEvent.Name.UI_TIPS)));
                                FaceFlashActionPreviewLayout.this.wGX = false;
                            }
                            FaceFlashActionPreviewLayout.this.wGY = false;
                        }
                    } else if (Objects.equals(hashMap.get(StateEvent.Name.UI_ACTION), StateEvent.ActionValue.STAGE_PASS)) {
                        com.tencent.mm.plugin.flash.c.b.axo("faceRecognized");
                        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onFrameworkEvent acting ：pass");
                        FaceFlashActionPreviewLayout.this.wHa = 0;
                        FaceFlashActionPreviewLayout.this.wGY = true;
                        if (!FaceFlashActionPreviewLayout.this.wGX) {
                            FaceFlashActionPreviewLayout.this.wGX = true;
                            if (FaceFlashActionPreviewLayout.this.wGT == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE && FaceFlashActionPreviewLayout.this.wGL.getChildCount() == 0) {
                                FaceFlashActionPreviewLayout.this.wGL.setNumbers(((c) FaceFlashActionPreviewLayout.this.wGR).wIt);
                                FaceFlashActionPreviewLayout.this.wGL.measure(0, 0);
                                int circleY = ((int) FaceFlashActionPreviewLayout.this.wGF.getCircleY()) - (FaceFlashActionPreviewLayout.this.wGL.getMeasuredHeight() / 2);
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) FaceFlashActionPreviewLayout.this.wGL.getLayoutParams();
                                layoutParams2.width = ((int) ((((float) FaceFlashActionPreviewLayout.this.getWidth()) * 0.27f) * 2.0f)) - com.tencent.mm.cb.a.aG(FaceFlashActionPreviewLayout.this.context, R.dimen.ci);
                                layoutParams2.topMargin = circleY;
                                FaceFlashActionPreviewLayout.this.wGL.setLayoutParams(layoutParams2);
                            }
                            if (FaceFlashActionPreviewLayout.this.wHd != null) {
                                FaceFlashActionPreviewLayout.this.wHd.cancel(true);
                                FaceFlashActionPreviewLayout.this.wHd = null;
                            }
                            FaceFlashActionPreviewLayout.a(FaceFlashActionPreviewLayout.this, FaceFlashActionPreviewLayout.this.wGG, com.tencent.mm.cb.a.aI(FaceFlashActionPreviewLayout.this.getContext(), R.string.fl_pose_incorrect));
                            FaceFlashActionPreviewLayout.this.wHd = h.RTc.n(new Runnable() {
                                /* class com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.AnonymousClass6.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(186546);
                                    FaceFlashActionPreviewLayout.C(FaceFlashActionPreviewLayout.this);
                                    AppMethodBeat.o(186546);
                                }
                            }, (long) FaceFlashActionPreviewLayout.wGW);
                        }
                    }
                }
                if (hashMap.containsKey(StateEvent.Name.PROCESS_RESULT) && FaceFlashActionPreviewLayout.this.getVisibility() == 0) {
                    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onFrameworkEvent result:" + hashMap.get(StateEvent.Name.PROCESS_RESULT));
                    FaceFlashActionPreviewLayout.this.wHi.cancel();
                    FaceFlashActionPreviewLayout.v(FaceFlashActionPreviewLayout.this);
                    FaceFlashActionPreviewLayout.this.wGO.stopPreview();
                    FaceFlashActionPreviewLayout.this.kkA = false;
                    if (Objects.equals(hashMap.get(StateEvent.Name.PROCESS_RESULT), StateEvent.ProcessResult.SUCCEED)) {
                        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onFrameworkEvent result:SUCCEED ,param:%s", hashMap);
                        FaceFlashActionPreviewLayout.this.wGS.dLf();
                        FaceFlashActionUI faceFlashActionUI = FaceFlashActionPreviewLayout.this.wHY;
                        String str = (String) hashMap.get("message");
                        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionUI", "[%s]FaceFlashActivity showSuccessLayout", Integer.valueOf(faceFlashActionUI.hashCode()));
                        faceFlashActionUI.wHM = 90025;
                        faceFlashActionUI.wHO = str;
                        com.tencent.mm.plugin.flash.c.b.s("msgVerify", "ok");
                        com.tencent.mm.plugin.flash.c.b.axm(str);
                        faceFlashActionUI.MP(com.tencent.mm.cb.a.n(faceFlashActionUI.getContext(), R.color.fo));
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.optBoolean("selfHandle", false)) {
                                faceFlashActionUI.axg(str);
                                AppMethodBeat.o(186547);
                                return;
                            }
                            faceFlashActionUI.wIg.setVisibility(8);
                            faceFlashActionUI.wIh.setVisibility(0);
                            FaceFlashActionProcessLayout faceFlashActionProcessLayout = faceFlashActionUI.wIh;
                            Log.i(FaceFlashActionProcessLayout.TAG, "showSuccessAnimation");
                            faceFlashActionProcessLayout.wHw.setText(com.tencent.mm.cb.a.aI(faceFlashActionProcessLayout.getContext(), R.string.c70));
                            faceFlashActionProcessLayout.wHy.setImageResource(R.drawable.uf);
                            faceFlashActionProcessLayout.wHx.setImageDrawable(com.tencent.mm.cb.a.l(faceFlashActionProcessLayout.getContext(), R.raw.icons_filled_done3));
                            faceFlashActionProcessLayout.wHx.startAnimation(faceFlashActionProcessLayout.wHC);
                            faceFlashActionProcessLayout.wHy.startAnimation(faceFlashActionProcessLayout.wHB);
                            faceFlashActionProcessLayout.wHz.setVisibility(4);
                            faceFlashActionProcessLayout.wHA.setVisibility(4);
                            h.RTc.n(new Runnable(jSONObject) {
                                /* class com.tencent.mm.plugin.flash.action.FaceFlashActionUI.AnonymousClass4 */
                                final /* synthetic */ JSONObject wHE;

                                {
                                    this.wHE = r2;
                                }

                                public final void run() {
                                    AppMethodBeat.i(186584);
                                    FaceFlashActionUI.this.aN(this.wHE);
                                    AppMethodBeat.o(186584);
                                }
                            }, 1500);
                            AppMethodBeat.o(186547);
                            return;
                        } catch (JSONException e2) {
                            Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", e2, "parse face success result error.%s", str);
                            AppMethodBeat.o(186547);
                            return;
                        }
                    } else if (Objects.equals(hashMap.get(StateEvent.Name.PROCESS_RESULT), StateEvent.ProcessResult.FAILED)) {
                        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onFrameworkEvent result:FAILED ,param:%s", hashMap);
                        if (com.tencent.mm.plugin.flash.d.a.a(hashMap, "error_code", ErrorCode.YT_SDK_VERIFY_TIMEOUT)) {
                            hashMap.put("message", com.tencent.mm.cb.a.aI(FaceFlashActionPreviewLayout.this.context, R.string.c6z));
                        } else if (com.tencent.mm.plugin.flash.d.a.a(hashMap, "error_code", ErrorCode.YT_SDK_NETWORK_ERROR)) {
                            hashMap.put("message", com.tencent.mm.cb.a.aI(FaceFlashActionPreviewLayout.this.context, R.string.net_fetch_failed));
                        } else if (com.tencent.mm.plugin.flash.d.a.a(hashMap, "error_code", 4194304) && hashMap.containsKey("message")) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(hashMap.get("message").toString());
                                if ((jSONObject2.optString("errormsg").equals(StringCode.FL_NO_FACE) || jSONObject2.optString("errormsg").equals(StringCode.FL_INCOMPLETE_FACE)) && !FaceFlashActionPreviewLayout.this.wHh) {
                                    com.tencent.mm.plugin.flash.c.b.dLj().eqY++;
                                    FaceFlashActionPreviewLayout.F(FaceFlashActionPreviewLayout.this);
                                    FaceFlashActionPreviewLayout.a(FaceFlashActionPreviewLayout.this, FaceFlashActionPreviewLayout.this.wGG, com.tencent.mm.cb.a.aI(FaceFlashActionPreviewLayout.this.getContext(), R.string.fl_pose_not_in_rect));
                                    AppMethodBeat.o(186547);
                                    return;
                                }
                            } catch (Exception e3) {
                                Log.e("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "get message error,message:%s", hashMap.get("message"));
                            }
                        }
                        com.tencent.mm.plugin.flash.d.a.a(FaceFlashActionPreviewLayout.this.getContext(), hashMap);
                        FaceFlashActionPreviewLayout.this.wHY.axf((String) hashMap.get("message"));
                        AppMethodBeat.o(186547);
                        return;
                    } else {
                        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onFrameworkEvent result:UNKNOWN ,param:%s", hashMap);
                        FaceFlashActionPreviewLayout.this.wHY.axf((String) hashMap.get("message"));
                    }
                }
                AppMethodBeat.o(186547);
            }
        });
        AppMethodBeat.o(186556);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener
    public void onNetworkRequestEvent(String str, String str2, HashMap<String, String> hashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser) {
        AppMethodBeat.i(186557);
        this.wGR.onNetworkRequestEvent(str, str2, hashMap, iYtSDKKitNetResponseParser);
        AppMethodBeat.o(186557);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener
    public String base64Encode(byte[] bArr, int i2) {
        return null;
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener
    public byte[] getVoiceData() {
        AppMethodBeat.i(186558);
        dKO();
        byte[] cTo = ((c) this.wGR).sSq.cTo();
        AppMethodBeat.o(186558);
        return cTo;
    }

    public final void reset() {
        AppMethodBeat.i(186559);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "reset");
        this.wGZ = 0;
        this.wHi.cancel();
        this.wHi.start();
        this.wHh = false;
        dKL();
        com.tencent.mm.plugin.flash.c.b.dLj().erb = 1;
        com.tencent.mm.plugin.flash.c.b.dLj().eqQ = 2;
        AppMethodBeat.o(186559);
    }

    private void dKL() {
        AppMethodBeat.i(186560);
        if (!(this.ltm == null || this.wGO == null)) {
            final Point previewSize = this.wGO.getPreviewSize();
            this.wGO.a(this.ltm, new Camera.PreviewCallback() {
                /* class com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.AnonymousClass8 */

                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    AppMethodBeat.i(186549);
                    if (FaceFlashActionPreviewLayout.this.wHf > 0.0f && FaceFlashActionPreviewLayout.this.wHg > 0) {
                        FaceFlashActionPreviewLayout.this.wGF.setProgress(((float) (System.currentTimeMillis() - FaceFlashActionPreviewLayout.this.wHg)) / FaceFlashActionPreviewLayout.this.wHf);
                    }
                    YtSDKKitFramework.getInstance().updateWithFrameData(bArr, previewSize.x, previewSize.y, 1);
                    com.tencent.mm.plugin.facedetect.model.d.cSR().bB(bArr);
                    AppMethodBeat.o(186549);
                }
            });
        }
        dKM();
        AppMethodBeat.o(186560);
    }

    private void dKM() {
        AppMethodBeat.i(186561);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "resetWithoutPreview");
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
        com.tencent.mm.plugin.flash.a.reset();
        this.wHY.MP(com.tencent.mm.cb.a.n(getContext(), R.color.fm));
        axd(com.tencent.mm.cb.a.aI(getContext(), R.string.fl_pose_incorrect));
        AppMethodBeat.o(186561);
    }

    private void dKN() {
        AppMethodBeat.i(186562);
        this.wGF.dLo();
        this.wHY.MP(com.tencent.mm.cb.a.n(getContext(), R.color.fm));
        this.wGH.setTextColor(com.tencent.mm.cb.a.n(getContext(), R.color.fm));
        this.wGG.setTextColor(com.tencent.mm.cb.a.n(getContext(), R.color.fm));
        AppMethodBeat.o(186562);
    }

    private void b(TextView textView, String str) {
        AppMethodBeat.i(186563);
        textView.setText(str);
        this.wGR.dLd();
        AppMethodBeat.o(186563);
    }

    /* access modifiers changed from: package-private */
    public final void dKO() {
        AppMethodBeat.i(186564);
        this.wGS.GA(this.wGR.cSK());
        AppMethodBeat.o(186564);
    }

    public final void release() {
        AppMethodBeat.i(186565);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "release");
        this.wGG.clearAnimation();
        this.wGH.clearAnimation();
        com.tencent.mm.plugin.flash.a.dKS();
        this.wGO.dKU();
        this.wGR.release();
        this.wHi.cancel();
        if (this.wHc != null) {
            this.wHc.cancel(true);
            this.wHc = null;
        }
        AppMethodBeat.o(186565);
    }

    static /* synthetic */ void C(FaceFlashActionPreviewLayout faceFlashActionPreviewLayout) {
        AppMethodBeat.i(258265);
        faceFlashActionPreviewLayout.wGU.cancel();
        faceFlashActionPreviewLayout.wGU.setDuration(500);
        faceFlashActionPreviewLayout.wGU.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.AnonymousClass4 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(186541);
                FaceFlashActionPreviewLayout.this.wGG.setVisibility(4);
                AppMethodBeat.o(186541);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        faceFlashActionPreviewLayout.wGG.startAnimation(faceFlashActionPreviewLayout.wGU);
        faceFlashActionPreviewLayout.wGV.cancel();
        faceFlashActionPreviewLayout.wGV.setDuration(500);
        faceFlashActionPreviewLayout.wGV.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.AnonymousClass5 */

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(186544);
                Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "after onAnimationStart ");
                FaceFlashActionPreviewLayout.this.wGR.r(FaceFlashActionPreviewLayout.this.wGH);
                FaceFlashActionPreviewLayout.this.wGH.setVisibility(0);
                AppMethodBeat.o(186544);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(186545);
                if (FaceFlashActionPreviewLayout.this.wHc != null) {
                    FaceFlashActionPreviewLayout.this.wHc.cancel(true);
                    FaceFlashActionPreviewLayout.this.wHc = null;
                }
                FaceFlashActionPreviewLayout.this.wHc = h.RTc.n(new Runnable() {
                    /* class com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(186543);
                        if (!FaceFlashActionPreviewLayout.this.wGX) {
                            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "prepareVerifying = false ,face not in rect.");
                            AppMethodBeat.o(186543);
                            return;
                        }
                        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "onAnimationEnd end......... start face verity.");
                        com.tencent.mm.plugin.flash.c.b.axn("sdkVerify");
                        YtSDKKitFramework.getInstance().fireEvent(YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_BEGIN_LIVENESS, null);
                        FaceFlashActionPreviewLayout.this.kkA = true;
                        if (FaceFlashActionPreviewLayout.this.wGT == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE) {
                            FaceFlashActionPreviewLayout.this.wGN.setVisibility(0);
                            FaceFlashActionPreviewLayout.this.wGL.setVisibility(0);
                            FaceFlashActionPreviewLayout.this.wGL.dLn();
                            ((c) FaceFlashActionPreviewLayout.this.wGR).a(new c.a() {
                                /* class com.tencent.mm.plugin.flash.action.FaceFlashActionPreviewLayout.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.flash.b.c.a
                                public final void j(com.tencent.mm.plugin.facedetect.d.a aVar) {
                                    AppMethodBeat.i(186542);
                                    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionPreviewLayout", "number verify start record voice");
                                    if (FaceFlashActionPreviewLayout.this.wGS.dLe()) {
                                        aVar.b(com.tencent.mm.plugin.facedetect.e.a.cTF().cTG());
                                        FaceFlashActionPreviewLayout.this.wGS.bFT();
                                    }
                                    AppMethodBeat.o(186542);
                                }
                            });
                            AppMethodBeat.o(186543);
                            return;
                        }
                        FaceFlashActionPreviewLayout.this.wGS.bFT();
                        AppMethodBeat.o(186543);
                    }
                }, 300);
                AppMethodBeat.o(186545);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        faceFlashActionPreviewLayout.wGH.startAnimation(faceFlashActionPreviewLayout.wGV);
        AppMethodBeat.o(258265);
    }
}

package com.tencent.mm.plugin.voip.video.camera.b;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.media.widget.a.d;
import com.tencent.mm.media.widget.a.f;
import com.tencent.mm.media.widget.b.e;
import com.tencent.mm.media.widget.camerarecordview.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.p.an;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.a.c;
import com.tencent.mm.plugin.voip.video.camera.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020:H\u0016J\b\u0010D\u001a\u00020BH\u0016J\u001a\u0010E\u001a\u00020B2\b\u0010F\u001a\u0004\u0018\u0001012\u0006\u0010G\u001a\u00020\u001cH\u0016J\u0006\u0010H\u001a\u00020\u0019J\b\u0010I\u001a\u00020\u0006H\u0016J\b\u0010J\u001a\u00020\u001cH\u0016J\b\u0010K\u001a\u00020\u0006H\u0016J\n\u0010L\u001a\u0004\u0018\u000108H\u0016J\b\u0010M\u001a\u00020\u0006H\u0016J\b\u0010N\u001a\u00020\u0006H\u0016J\b\u0010O\u001a\u00020\u0006H\u0016J \u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010R\u001a\u00020BH\u0016J\u0018\u0010S\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020\u001cH\u0016J\u000e\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0006J\u0006\u0010Y\u001a\u00020ZJ\b\u0010[\u001a\u00020\\H\u0016J\u000e\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u0006J\b\u0010`\u001a\u00020\u001cH\u0016J\b\u0010a\u001a\u00020\u001cH\u0016J\b\u0010b\u001a\u00020\u001cH\u0016J\u0010\u0010c\u001a\u00020B2\u0006\u0010d\u001a\u00020\u0006H\u0016J\b\u0010e\u001a\u00020BH\u0016J\b\u0010f\u001a\u00020\u0006H\u0016J\b\u0010g\u001a\u00020BH\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\"\"\u0004\b)\u0010$R\u001a\u0010*\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001a\u0010-\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u00106\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000f¨\u0006i"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/camera/v2/CommonCaptureRenderer;", "Lcom/tencent/mm/plugin/voip/video/camera/common/BaseCaptureRenderer;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "context", "Landroid/content/Context;", "w", "", "h", "(Landroid/content/Context;II)V", "cameraFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "displayOrientation", "getH", "()I", "setH", "(I)V", "mAutoFocusTimeOut", "", "getMAutoFocusTimeOut", "()J", "setMAutoFocusTimeOut", "(J)V", "mCamera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "mCameraDeviceConfig", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "mCameraErr", "mCameraOpen", "", "mCameraOpenFaild", "mGetCameraDataCallback", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "()Z", "setMIsCameraNoParamAutoFocus", "(Z)V", "mIsCameraRemote180", "mIsContinuousVideoMode", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mIsLastAutoFocusFaceCamera", "getMIsLastAutoFocusFaceCamera", "setMIsLastAutoFocusFaceCamera", "mLastAutoFocusTimestamp", "getMLastAutoFocusTimestamp", "setMLastAutoFocusTimestamp", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mScreenRotation", "mSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getMSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setMSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getW", "setW", "bind", "", "surfaceTexture", "exchangeCapture", "focusOnFace", "faceLocation", "isClickScreen", "getCameraConfig", "getCameraErrCode", "getCurrentCameraIsFace", "getDisplayOrientation", "getPreviewSize", "getRecordScene", "getResolutionLimit", "getRotateAngle", "initCamera", "bFace", "initCameraConfig", "initCapture", "dataCallback", "bFaceFirst", "initFocusStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "cameraId", "initFormatStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "initFpsStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "initSizeStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "mCameraId", "isCameraRemote180", "isMirror", "isPreviewing", "onOrientationChange", "rotation", an.NAME, "startCapture", "stopCapture", "Companion", "plugin-voip_release"})
public final class a extends com.tencent.mm.plugin.voip.video.camera.a.a implements com.tencent.mm.media.widget.camerarecordview.d.b {
    public static final C1891a Hki = new C1891a((byte) 0);
    private boolean HjJ;
    private boolean HjK;
    private boolean HjL;
    private long HjN;
    private int HjO;
    private ac HjP;
    private int[] HjS;
    private int Hkd;
    private d Hkf;
    private b.a Hkg;
    private g Hkh = new b(this);
    private Context context;

    /* renamed from: h  reason: collision with root package name */
    private int f1525h;
    private boolean imy;
    private SurfaceTexture mSurfaceTexture;
    private int w;
    private long zNW;
    private boolean zOb;
    private boolean zOc;
    private com.tencent.mm.plugin.voip.video.camera.a.b zOe;
    private int zOj;
    private boolean zOm;

    static {
        AppMethodBeat.i(236166);
        AppMethodBeat.o(236166);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/camera/v2/CommonCaptureRenderer$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
    /* renamed from: com.tencent.mm.plugin.voip.video.camera.b.a$a  reason: collision with other inner class name */
    public static final class C1891a {
        private C1891a() {
        }

        public /* synthetic */ C1891a(byte b2) {
            this();
        }
    }

    public a(Context context2, int i2, int i3) {
        p.h(context2, "context");
        AppMethodBeat.i(236165);
        this.context = context2;
        this.w = i2;
        this.f1525h = i3;
        c.hH(this.context);
        aDz();
        Log.d("MicroMsg.CommonCaptureRenderer", "width: %d, height: %d", Integer.valueOf(this.w), Integer.valueOf(this.f1525h));
        this.imy = true;
        this.zNW = 30000;
        AppMethodBeat.o(236165);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onFrameData"})
    static final class b implements g {
        final /* synthetic */ a Hkj;

        b(a aVar) {
            this.Hkj = aVar;
        }

        @Override // com.tencent.mm.plugin.mmsight.model.g
        public final boolean ai(byte[] bArr) {
            com.tencent.mm.plugin.voip.video.camera.a.b bVar;
            int i2;
            boolean z;
            int i3;
            Integer num;
            com.tencent.mm.plugin.voip.video.camera.a.b bVar2;
            Integer num2;
            Integer num3 = null;
            boolean z2 = false;
            AppMethodBeat.i(236144);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    if (this.Hkj.fKY()) {
                        i2 = c.Hjz;
                        if (ae.gKt.gFF && ae.gKt.gFE.dYT != 0) {
                            z = true;
                        }
                        z = false;
                    } else {
                        i2 = c.HjA;
                        if (ae.gKt.gFH && ae.gKt.gFG.dYT != 0) {
                            z = true;
                        }
                        z = false;
                    }
                    if (i2 > 0) {
                        i3 = 32;
                    } else {
                        i3 = 0;
                    }
                    a aVar = this.Hkj;
                    if (!z && i2 > 0) {
                        z2 = true;
                    }
                    aVar.HjJ = z2;
                    if (!(this.Hkj.zOe == null || this.Hkj.Hkf == null)) {
                        HashMap<Integer, b.a.d> hashMap = this.Hkj.fLv().ird;
                        d dVar = this.Hkj.Hkf;
                        if (dVar != null) {
                            num = Integer.valueOf(dVar.aPu());
                        } else {
                            num = null;
                        }
                        if (!(hashMap.get(num) == null || this.Hkj.fLc() == null || (bVar2 = this.Hkj.zOe) == null)) {
                            long length = (long) bArr.length;
                            ac fLc = this.Hkj.fLc();
                            if (fLc == null) {
                                p.hyc();
                            }
                            int i4 = fLc.width;
                            ac fLc2 = this.Hkj.fLc();
                            if (fLc2 == null) {
                                p.hyc();
                            }
                            int i5 = fLc2.height;
                            HashMap<Integer, b.a.d> hashMap2 = this.Hkj.fLv().ird;
                            d dVar2 = this.Hkj.Hkf;
                            if (dVar2 != null) {
                                num2 = Integer.valueOf(dVar2.aPu());
                            } else {
                                num2 = null;
                            }
                            b.a.d dVar3 = hashMap2.get(num2);
                            if (dVar3 != null) {
                                num3 = dVar3.irk;
                            }
                            if (num3 == null) {
                                p.hyc();
                            }
                            bVar2.a(bArr, length, i4, i5, num3.intValue(), i3);
                        }
                    }
                    AppMethodBeat.o(236144);
                    return true;
                }
            }
            h.INSTANCE.idkeyStat(159, 0, 1, false);
            h.INSTANCE.idkeyStat(159, 3, 1, false);
            if (!(this.Hkj.zOe == null || (bVar = this.Hkj.zOe) == null)) {
                bVar.cza();
            }
            AppMethodBeat.o(236144);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final void q(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(236145);
        p.h(surfaceTexture, "surfaceTexture");
        this.mSurfaceTexture = surfaceTexture;
        AppMethodBeat.o(236145);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final boolean dEO() {
        AppMethodBeat.i(236146);
        d dVar = this.Hkf;
        if (dVar != null) {
            boolean aPc = dVar.aPc();
            AppMethodBeat.o(236146);
            return aPc;
        }
        AppMethodBeat.o(236146);
        return false;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final int a(com.tencent.mm.plugin.voip.video.camera.a.b bVar, boolean z) {
        int h2;
        AppMethodBeat.i(236147);
        p.h(bVar, "dataCallback");
        com.tencent.mm.plugin.voip.video.camera.prev.b bVar2 = c.Hjw;
        p.g(bVar2, "VoipCameraCompatible.gVoipCameraInfo");
        if (bVar2.aRA() <= 0) {
            this.HjO = 1;
            AppMethodBeat.o(236147);
            return -1;
        }
        if (z) {
            com.tencent.mm.plugin.voip.video.camera.prev.b bVar3 = c.Hjw;
            p.g(bVar3, "VoipCameraCompatible.gVoipCameraInfo");
            if (!bVar3.fLt()) {
                z = false;
            }
        } else {
            com.tencent.mm.plugin.voip.video.camera.prev.b bVar4 = c.Hjw;
            p.g(bVar4, "VoipCameraCompatible.gVoipCameraInfo");
            if (!bVar4.fLu()) {
                z = true;
            }
        }
        this.zOe = bVar;
        if (h(z, this.w, this.f1525h) > 0 || (h2 = h(z, this.w, this.f1525h)) > 0) {
            if (com.tencent.mm.plugin.voip.b.g.fKg() || com.tencent.mm.media.widget.d.b.rG(getRecordScene())) {
                j.fKE();
            } else {
                d dVar = this.Hkf;
                if (dVar != null) {
                    dVar.a(this.Hkh);
                }
            }
            this.HjO = 0;
            AppMethodBeat.o(236147);
            return 1;
        }
        this.HjO = 1;
        AppMethodBeat.o(236147);
        return h2;
    }

    private final int h(boolean z, int i2, int i3) {
        boolean z2;
        int i4;
        Integer num;
        boolean z3;
        d dVar;
        Integer num2 = null;
        AppMethodBeat.i(236148);
        Log.i("MicroMsg.CommonCaptureRenderer", "try open camera, face: ".concat(String.valueOf(z)));
        this.zOc = false;
        if (this.Hkf == null) {
            z2 = true;
        } else if (fKY() != z) {
            d dVar2 = this.Hkf;
            if (dVar2 != null) {
                dVar2.release();
                z2 = true;
            } else {
                z2 = true;
            }
        } else {
            z2 = this.zOm;
        }
        if (z2) {
            if (com.tencent.mm.media.widget.d.b.rG(getRecordScene()) || com.tencent.mm.plugin.voip.b.g.fKf()) {
                this.Hkf = new e(this.context, i2, i3);
                if (com.tencent.mm.media.widget.d.b.rH(getRecordScene()) && (dVar = this.Hkf) != null) {
                    dVar.aPd();
                }
            } else {
                this.Hkf = new f(this.context, i2, i3);
            }
            d dVar3 = this.Hkf;
            if (dVar3 != null) {
                dVar3.a(fLv());
            }
            if (this.Hkf == null) {
                this.zOb = false;
                AppMethodBeat.o(236148);
                return -1;
            }
            this.zOm = false;
        }
        d dVar4 = this.Hkf;
        if (dVar4 != null) {
            dVar4.v(this.context, !z);
        }
        d dVar5 = this.Hkf;
        if (dVar5 != null) {
            Boolean valueOf = Boolean.valueOf(dVar5.rp(getRecordScene()));
            if (!valueOf.booleanValue()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                valueOf = null;
            }
            if (valueOf != null) {
                valueOf.booleanValue();
                h.INSTANCE.idkeyStat(159, 0, 1, false);
                if (this.zOe != null) {
                    try {
                        com.tencent.mm.plugin.voip.video.camera.a.b bVar = this.zOe;
                        if (bVar == null) {
                            p.hyc();
                        }
                        bVar.cza();
                        this.zOm = true;
                        d dVar6 = this.Hkf;
                        if (dVar6 != null) {
                            dVar6.release();
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.CommonCaptureRenderer", e2, "Camera open failed2, error:%s", e2.getMessage());
                    }
                }
                AppMethodBeat.o(236148);
                return -1;
            }
        }
        this.zOb = true;
        try {
            d dVar7 = this.Hkf;
            i4 = dVar7 != null ? dVar7.aPf() : 0;
        } catch (Exception e3) {
            Log.e("MicroMsg.CommonCaptureRenderer", "getPreviewFrameRate failed: %s", e3.getMessage());
            i4 = 0;
        }
        try {
            fLg();
        } catch (Exception e4) {
            Log.e("MicroMsg.CommonCaptureRenderer", "setDisplayOrientation failed: %s", e4.getMessage());
        }
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i4);
        ac acVar = this.HjP;
        if (acVar != null) {
            num = Integer.valueOf(acVar.width);
        } else {
            num = null;
        }
        objArr[1] = num;
        ac acVar2 = this.HjP;
        if (acVar2 != null) {
            num2 = Integer.valueOf(acVar2.height);
        }
        objArr[2] = num2;
        objArr[3] = Integer.valueOf(c.Hjz);
        objArr[4] = Integer.valueOf(this.zOj);
        Log.i("MicroMsg.CommonCaptureRenderer", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d,  IsRotate180: %d, displayOrientation: %d", objArr);
        AppMethodBeat.o(236148);
        return 1;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final void fLg() {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        AppMethodBeat.i(236149);
        d dVar = this.Hkf;
        if (dVar != null) {
            i2 = dVar.df(fKY() ? c.Hjx : c.Hjy, this.Hkd);
        } else {
            i2 = 0;
        }
        this.zOj = i2;
        Log.i("MicroMsg.CommonCaptureRenderer", "mIsCurrentFaceCamera is %s, %s,%s,", Integer.valueOf(this.Hkd), Boolean.valueOf(fKY()), Integer.valueOf(this.zOj));
        if (fKY()) {
            i3 = c.Hjz;
            if (ae.gKt.gFF && ae.gKt.gFE.dYT != 0) {
                z = true;
            }
            z = false;
        } else {
            i3 = c.HjA;
            if (ae.gKt.gFH && ae.gKt.gFG.dYT != 0) {
                z = true;
            }
            z = false;
        }
        if (z || i3 <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.HjJ = z2;
        if (this.zOj != 90 && z) {
            this.HjJ = false;
        }
        AppMethodBeat.o(236149);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final int fLh() {
        return this.zOj;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final boolean fKY() {
        AppMethodBeat.i(236150);
        d dVar = this.Hkf;
        if (dVar == null || dVar.aPu() != 1) {
            AppMethodBeat.o(236150);
            return false;
        }
        AppMethodBeat.o(236150);
        return true;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.b
    public final int getRecordScene() {
        return 12;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.b
    public final int getResolutionLimit() {
        AppMethodBeat.i(236151);
        if (v2protocal.Har) {
            Log.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
            d.a aVar = com.tencent.mm.plugin.voip.video.camera.a.d.HjH;
            int i2 = com.tencent.mm.plugin.voip.video.camera.a.d.HjF;
            AppMethodBeat.o(236151);
            return i2;
        }
        d.a aVar2 = com.tencent.mm.plugin.voip.video.camera.a.d.HjH;
        int i3 = com.tencent.mm.plugin.voip.video.camera.a.d.HjE;
        AppMethodBeat.o(236151);
        return i3;
    }

    public final b.a fLv() {
        b.a aVar;
        AppMethodBeat.i(236152);
        if (this.Hkg != null) {
            aVar = this.Hkg;
            if (aVar == null) {
                p.hyc();
                AppMethodBeat.o(236152);
            }
            AppMethodBeat.o(236152);
        } else {
            aDz();
            aVar = this.Hkg;
            if (aVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(236152);
        }
        return aVar;
    }

    private void aDz() {
        AppMethodBeat.i(236153);
        b.a.C0435a aVar = new b.a.C0435a();
        com.tencent.mm.compatible.c.a aVar2 = com.tencent.mm.compatible.c.a.gDs;
        int anJ = com.tencent.mm.compatible.c.a.anJ();
        if (anJ >= 0) {
            int i2 = 0;
            while (true) {
                aVar.a(new o<>(Integer.valueOf(i2), adV(i2)));
                aVar.b(new o<>(Integer.valueOf(i2), fLx()));
                aVar.c(new o<>(Integer.valueOf(i2), adW(i2)));
                aVar.d(new o<>(Integer.valueOf(i2), fLw()));
                if (!com.tencent.mm.plugin.voip.b.g.fKg()) {
                    aVar.j(b.C0437b.aQE());
                    Log.i("MicroMsg.CommonCaptureRenderer", "current device and user were set to previewCallback");
                } else {
                    aVar.j(b.C0437b.aQD());
                    Log.i("MicroMsg.CommonCaptureRenderer", "current device and user were set to remove previewCallback");
                }
                if (i2 == anJ) {
                    break;
                }
                i2++;
            }
        }
        aVar.scene = 12;
        this.Hkg = aVar.aQz();
        AppMethodBeat.o(236153);
    }

    private static b.a.d fLw() {
        int valueOf;
        AppMethodBeat.i(236154);
        b.a.d dVar = new b.a.d();
        if (c.HjB <= 0) {
            valueOf = 7;
        } else {
            valueOf = Integer.valueOf(c.HjB);
        }
        dVar.irk = valueOf;
        AppMethodBeat.o(236154);
        return dVar;
    }

    private static b.a.C0436b adV(int i2) {
        AppMethodBeat.i(236155);
        b.a.C0436b bVar = new b.a.C0436b((byte) 0);
        if (ae.gKt.gGg == 0 && i2 == 1) {
            ArrayList<String> arrayList = bVar.irf;
            if (arrayList != null) {
                arrayList.add(b.C0437b.aQC());
            }
            ArrayList<String> arrayList2 = bVar.irf;
            if (arrayList2 != null) {
                arrayList2.add(b.C0437b.aQA());
            }
        } else if (ae.gKt.gGg == 1 || i2 == 0) {
            ArrayList<String> arrayList3 = bVar.irf;
            if (arrayList3 != null) {
                arrayList3.add(b.C0437b.aQA());
            }
            ArrayList<String> arrayList4 = bVar.irf;
            if (arrayList4 != null) {
                arrayList4.add(b.C0437b.aQC());
            }
        }
        AppMethodBeat.o(236155);
        return bVar;
    }

    private static b.a.c fLx() {
        int i2;
        int i3;
        boolean z;
        AppMethodBeat.i(236156);
        b.a.c cVar = new b.a.c();
        com.tencent.mm.plugin.voip.video.camera.prev.b bVar = c.Hjw;
        p.g(bVar, "VoipCameraCompatible.gVoipCameraInfo");
        int fLs = bVar.fLs();
        Log.i("MicroMsg.CommonCaptureRenderer", "safeSetFps: %s", Integer.valueOf(fLs));
        if (MMApplicationContext.isMainProcess()) {
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
            p.g(af, "MMKernel.service(IConfigService::class.java)");
            i2 = ((com.tencent.mm.plugin.zero.b.a) af).aqJ().getInt("VoipCaptureRenderFpsRangeMinApiLevel", 26);
        } else {
            i2 = 26;
        }
        Log.i("MicroMsg.CommonCaptureRenderer", "setFpsRange minApiLevel:%s", Integer.valueOf(i2));
        if (k.alh() || com.tencent.mm.compatible.util.d.oD(i2)) {
            int i4 = -1;
            if (ae.gKt != null) {
                i4 = ae.gKt.gGk * 1000;
                i3 = ae.gKt.gGl * 1000;
            } else {
                i3 = 0;
            }
            if (i4 > 0 && i3 > 0 && i3 >= i4) {
                cVar.irj = Boolean.FALSE;
                cVar.irg = Integer.valueOf(i4);
                cVar.irh = Integer.valueOf(i3);
                cVar.iri = Integer.valueOf(fLs);
                z = true;
            } else if (i4 == 0 && i3 == 0) {
                cVar.irj = Boolean.TRUE;
                cVar.irg = Integer.valueOf(fLs);
                cVar.irh = Integer.valueOf(fLs);
                cVar.iri = Integer.valueOf(fLs);
                z = false;
                i3 = Integer.MIN_VALUE;
                i4 = Integer.MIN_VALUE;
            } else {
                cVar.iri = Integer.valueOf(fLs);
                cVar.irh = Integer.valueOf(Math.min(fLs + 5, 30));
                cVar.irg = Integer.valueOf(Math.max(fLs - 5, 5));
                z = false;
                i3 = Integer.MIN_VALUE;
                i4 = Integer.MIN_VALUE;
            }
            Log.i("MicroMsg.CommonCaptureRenderer", "steve: dkfps get fit  [%d %d], target fps %d, matchTargetFPS:%b", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(fLs), Boolean.valueOf(z));
        } else {
            cVar.irj = Boolean.TRUE;
            cVar.irg = Integer.valueOf(fLs);
            cVar.irh = Integer.valueOf(fLs);
            cVar.iri = Integer.valueOf(fLs);
        }
        AppMethodBeat.o(236156);
        return cVar;
    }

    private static b.a.e adW(int i2) {
        Point fLr;
        AppMethodBeat.i(236157);
        b.a.e eVar = new b.a.e();
        if (i2 == 1) {
            com.tencent.mm.plugin.voip.video.camera.prev.b bVar = c.Hjw;
            p.g(bVar, "VoipCameraCompatible.gVoipCameraInfo");
            fLr = bVar.fLq();
        } else {
            com.tencent.mm.plugin.voip.video.camera.prev.b bVar2 = c.Hjw;
            p.g(bVar2, "VoipCameraCompatible.gVoipCameraInfo");
            fLr = bVar2.fLr();
        }
        if (fLr != null) {
            eVar.irl = Integer.valueOf(fLr.x);
            eVar.irm = Integer.valueOf(fLr.y);
            Log.i("MicroMsg.CommonCaptureRenderer", "getCameraSize from table:" + eVar.irl + "," + eVar.irm);
        }
        AppMethodBeat.o(236157);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final void onOrientationChange(int i2) {
        this.Hkd = i2;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final boolean fKZ() {
        return this.HjJ;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final void fLi() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(236158);
        if (ae.gKt.gGg != 1 || !this.zOc) {
            if (ae.gKt.gGf > 2000) {
                this.zNW = (long) ae.gKt.gGf;
            }
            Log.e("MicroMsg.CommonCaptureRenderer", "focusOnFace error, faceLocation is null");
            boolean z3 = System.currentTimeMillis() - this.HjN > this.zNW;
            if (this.HjK && !z3) {
                fKY();
            }
            StringBuilder sb = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
            if (!this.HjK) {
                z = true;
            } else {
                z = false;
            }
            StringBuilder append = sb.append(z).append(",isAutoFocusTimeout: ").append(z3).append(",mAutoFocusTimeOut:").append(this.zNW).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
            if (this.HjL == fKY()) {
                z2 = false;
            }
            Log.i("MicroMsg.CommonCaptureRenderer", append.append(z2).append(",isClickScreen :true").toString());
            try {
                com.tencent.mm.media.widget.a.d dVar = this.Hkf;
                if (dVar != null) {
                    Boolean valueOf = Boolean.valueOf(dVar.aPg());
                    if (!valueOf.booleanValue()) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        valueOf.booleanValue();
                        this.HjS = null;
                        this.HjN = System.currentTimeMillis();
                        this.HjK = true;
                        this.HjL = fKY();
                        AppMethodBeat.o(236158);
                        return;
                    }
                }
                AppMethodBeat.o(236158);
            } catch (Exception e2) {
                Log.e("MicroMsg.CommonCaptureRenderer", "mCamera.getParameters() or autoFocus fail!".concat(String.valueOf(e2)));
                AppMethodBeat.o(236158);
            }
        } else {
            AppMethodBeat.o(236158);
        }
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final void eoc() {
        com.tencent.mm.media.widget.a.d dVar;
        com.tencent.mm.media.widget.a.d dVar2;
        AppMethodBeat.i(236159);
        StringBuilder sb = new StringBuilder("StopCapture....mIsInCapture = ");
        com.tencent.mm.media.widget.a.d dVar3 = this.Hkf;
        Log.d("MicroMsg.CommonCaptureRenderer", sb.append(dVar3 != null ? Boolean.valueOf(dVar3.aPc()) : null).toString());
        com.tencent.mm.media.widget.a.d dVar4 = this.Hkf;
        if (!(dVar4 == null || !dVar4.aPc() || this.Hkf == null || (dVar2 = this.Hkf) == null)) {
            dVar2.release();
        }
        if (1 == this.HjO) {
            pl plVar = new pl();
            plVar.dVC.type = 2;
            EventCenter.instance.publish(plVar);
        }
        Log.d("MicroMsg.CommonCaptureRenderer", "UnInitCapture....mCameraOpen = " + this.zOb);
        if (this.zOb) {
            this.HjO = 0;
            com.tencent.mm.media.widget.a.d dVar5 = this.Hkf;
            if (dVar5 != null) {
                dVar5.release();
            }
        } else if (!(this.Hkf == null || (dVar = this.Hkf) == null)) {
            dVar.release();
        }
        this.zOc = false;
        AppMethodBeat.o(236159);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final int fLa() {
        return this.HjO;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final int fLb() {
        Point fa;
        AppMethodBeat.i(236160);
        if (!this.zOb) {
            Log.e("MicroMsg.CommonCaptureRenderer", "StartCapture: failed without open camera");
            this.HjO = 1;
            AppMethodBeat.o(236160);
            return -1;
        }
        com.tencent.mm.media.widget.a.d dVar = this.Hkf;
        if (dVar == null || !dVar.aPc()) {
            if (this.mSurfaceTexture != null) {
                try {
                    com.tencent.mm.media.widget.a.d dVar2 = this.Hkf;
                    if (dVar2 != null) {
                        dVar2.a(this.mSurfaceTexture, false, getResolutionLimit());
                    }
                } catch (Exception e2) {
                    h.INSTANCE.idkeyStat(159, 0, 1, false);
                    h.INSTANCE.idkeyStat(159, 2, 1, false);
                    this.HjO = 1;
                    Log.e("MicroMsg.CommonCaptureRenderer", "StartCapture:error:".concat(String.valueOf(e2)));
                }
                try {
                    com.tencent.mm.media.widget.a.d dVar3 = this.Hkf;
                    if (!(dVar3 == null || (fa = dVar3.fa(false)) == null)) {
                        this.HjP = new ac(fa.x, fa.y);
                        com.tencent.mm.plugin.voip.video.camera.a.b bVar = this.zOe;
                        if (bVar != null) {
                            bVar.fs(fa.x, fa.y);
                        }
                        StringBuilder append = new StringBuilder("Camera Open Success, try set size: w,h:").append(this.w).append(',').append(this.f1525h).append(" and size is ");
                        ac acVar = this.HjP;
                        StringBuilder append2 = append.append(acVar != null ? Integer.valueOf(acVar.width) : null).append(" and ");
                        ac acVar2 = this.HjP;
                        Log.i("MicroMsg.CommonCaptureRenderer", append2.append(acVar2 != null ? Integer.valueOf(acVar2.height) : null).append(' ').toString());
                    }
                } catch (Exception e3) {
                    h.INSTANCE.idkeyStat(159, 0, 1, false);
                    Log.e("MicroMsg.CommonCaptureRenderer", "try getParameters and getPreviewSize fail, error:%s", e3.getMessage());
                    AppMethodBeat.o(236160);
                    return -1;
                }
            }
            AppMethodBeat.o(236160);
            return 1;
        }
        Log.e("MicroMsg.CommonCaptureRenderer", "StartCapture: is in capture already ");
        AppMethodBeat.o(236160);
        return -1;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final ac fLc() {
        ac acVar;
        AppMethodBeat.i(236161);
        if (this.HjP != null) {
            acVar = this.HjP;
            if (acVar == null) {
                p.hyc();
                AppMethodBeat.o(236161);
            }
            AppMethodBeat.o(236161);
        } else {
            acVar = new ac(this.w, this.f1525h);
            AppMethodBeat.o(236161);
        }
        return acVar;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final int fLe() {
        int i2;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(236162);
        if (fKY()) {
            i2 = c.Hjz;
            if (ae.gKt.gFF && ae.gKt.gFE.dYT != 0) {
                z = true;
            }
            z = false;
        } else {
            i2 = c.HjA;
            if (ae.gKt.gFH && ae.gKt.gFG.dYT != 0) {
                z = true;
            }
            z = false;
        }
        if (z || i2 <= 0) {
            z2 = false;
        }
        this.HjJ = z2;
        if ((this.HjJ ? OpenGlRender.FLAG_Angle270 : OpenGlRender.FLAG_Angle90) == OpenGlRender.FLAG_Angle270) {
            AppMethodBeat.o(236162);
            return 90;
        }
        AppMethodBeat.o(236162);
        return 270;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final boolean fLf() {
        int i2;
        AppMethodBeat.i(236163);
        if (fKY()) {
            i2 = OpenGlRender.FLAG_Mirror;
        } else {
            i2 = 0;
        }
        if (i2 == OpenGlRender.FLAG_Mirror) {
            AppMethodBeat.o(236163);
            return true;
        }
        AppMethodBeat.o(236163);
        return false;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final void fLd() {
        AppMethodBeat.i(236164);
        com.tencent.mm.plugin.voip.video.camera.prev.b bVar = c.Hjw;
        p.g(bVar, "VoipCameraCompatible.gVoipCameraInfo");
        if (bVar.aRA() < 2) {
            StringBuilder sb = new StringBuilder("ExchangeCapture...gCameraNum= ");
            com.tencent.mm.plugin.voip.video.camera.prev.b bVar2 = c.Hjw;
            p.g(bVar2, "VoipCameraCompatible.gVoipCameraInfo");
            Log.e("MicroMsg.CommonCaptureRenderer", sb.append(bVar2.aRA()).toString());
            AppMethodBeat.o(236164);
            return;
        }
        StringBuilder sb2 = new StringBuilder("ExchangeCapture start, gCameraNum= ");
        com.tencent.mm.plugin.voip.video.camera.prev.b bVar3 = c.Hjw;
        p.g(bVar3, "VoipCameraCompatible.gVoipCameraInfo");
        Log.i("MicroMsg.CommonCaptureRenderer", sb2.append(bVar3.aRA()).toString());
        com.tencent.mm.media.widget.a.d dVar = this.Hkf;
        if (dVar != null) {
            dVar.aPb();
        }
        com.tencent.mm.plugin.voip.c.fFg().adn(this.HjO);
        this.imy = true;
        AppMethodBeat.o(236164);
    }
}

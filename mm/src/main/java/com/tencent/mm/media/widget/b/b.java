package com.tencent.mm.media.widget.b;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.a.a.a;
import com.tencent.mm.media.widget.b.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b)\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010|\u001a\u00020q2\u0006\u0010}\u001a\u00020~J\u0010\u0010\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001J#\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0001J\u0011\u0010\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001J\u0011\u0010\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001J\u0011\u0010\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001J\u0011\u0010\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001J\u0011\u0010\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001J\"\u0010\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0004J\u0012\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\nH\u0002J\u0012\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\u0004H\u0002J\u0010\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\nJ\u0011\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u0001J\u0012\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\u0004H\u0002J\u0012\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\u0004H\u0002J\u0014\u0010\u0001\u001a\u0004\u0018\u00010P2\u0007\u0010\u0001\u001a\u00020\nH\u0002J)\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010T2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0003\u0010\u0001J \u0010\u0001\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010T2\u0007\u0010\u0001\u001a\u00020\nH\u0002¢\u0006\u0003\u0010\u0001J \u0010\u0001\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010T2\u0007\u0010\u0001\u001a\u00020\nH\u0002¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020qH\u0002J\u0007\u0010\u0001\u001a\u00020qJ\u0007\u0010\u0001\u001a\u00020!J\u0012\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020\nH\u0002J\u0012\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020\nH\u0002J\u0012\u0010 \u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020\nH\u0002J\u0012\u0010¡\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020\nH\u0002J\u0012\u0010¢\u0001\u001a\u00020q2\u0007\u0010£\u0001\u001a\u00020PH\u0002J'\u0010¤\u0001\u001a\u00020q2\r\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020U0T2\u0007\u0010¦\u0001\u001a\u00020\nH\u0002¢\u0006\u0003\u0010§\u0001J\u0011\u0010¨\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001J\u001a\u0010©\u0001\u001a\u00020q2\u0007\u0010ª\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u0001J\u001a\u0010«\u0001\u001a\u00020q2\u0007\u0010¬\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030\u0001R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\u00048\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u000e\u0010\u001b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001a\u0010'\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001a\u0010)\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u0012\u0010+\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0004\n\u0002\u0010,R\u001a\u0010-\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001a\u0010/\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u0011\u00101\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b1\u0010\"R\u0011\u00102\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b3\u0010\fR\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010;\u001a\u0004\u0018\u00010\n2\b\u0010:\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\f\"\u0004\b=\u0010\u001fR\u001a\u0010>\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010AR\u0011\u0010B\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bC\u0010\fR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0006\"\u0004\bL\u0010AR\u0011\u0010M\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bN\u0010\u0006R\u0011\u0010O\u001a\u00020P8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020U0T8F¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020U0T8F¢\u0006\u0006\u001a\u0004\bY\u0010WR\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020U0T8F¢\u0006\u0006\u001a\u0004\b[\u0010WR.\u0010\\\u001a\u0016\u0012\u0004\u0012\u00020^\u0018\u00010]j\n\u0012\u0004\u0012\u00020^\u0018\u0001`_X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR.\u0010d\u001a\u0016\u0012\u0004\u0012\u00020e\u0018\u00010]j\n\u0012\u0004\u0012\u00020e\u0018\u0001`_X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR.\u0010h\u001a\u0016\u0012\u0004\u0012\u00020i\u0018\u00010]j\n\u0012\u0004\u0012\u00020i\u0018\u0001`_X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010a\"\u0004\bk\u0010cR7\u0010l\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\bn\u0012\b\bo\u0012\u0004\b\b(p\u0012\u0004\u0012\u00020q\u0018\u00010mX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001a\u0010v\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0006\"\u0004\bx\u0010AR\u001a\u0010y\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0006\"\u0004\b{\u0010A¨\u0006­\u0001"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/CameraUtil;", "", "()V", "BACK_CAMERA", "", "getBACK_CAMERA", "()I", "FRONT_CAMERA", "getFRONT_CAMERA", "IMAGE_STREAM", "", "getIMAGE_STREAM", "()Ljava/lang/String;", "ORIENTATION_0", "getORIENTATION_0", "ORIENTATION_180", "getORIENTATION_180", "ORIENTATION_270", "getORIENTATION_270", "ORIENTATION_90", "getORIENTATION_90", "OTHER_CAMERA", "getOTHER_CAMERA", "PREVIEW_STREAM", "getPREVIEW_STREAM", "RECORD_STREAM", "getRECORD_STREAM", "TAG", "fbLevel", "getFbLevel", "setFbLevel", "(Ljava/lang/String;)V", "isDebugFaceBeauty", "", "()Z", "setDebugFaceBeauty", "(Z)V", "isDenoisyVendorOn", "setDenoisyVendorOn", "isFaceBeautyVendorOn", "setFaceBeautyVendorOn", "isHDRCheckerVendorOn", "setHDRCheckerVendorOn", "isHDRRetOn", "Ljava/lang/Boolean;", "isHDRVendorOn", "setHDRVendorOn", "isStabilizationOn", "setStabilizationOn", "isUseBackCamera", "mBackCameraId", "getMBackCameraId", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "getMCameraManager", "()Landroid/hardware/camera2/CameraManager;", "setMCameraManager", "(Landroid/hardware/camera2/CameraManager;)V", "value", "mCurrentCameraId", "getMCurrentCameraId", "setMCurrentCameraId", "mCurrentImageFormat", "getMCurrentImageFormat", "setMCurrentImageFormat", "(I)V", "mFrontCameraId", "getMFrontCameraId", "mScreenSize", "Landroid/graphics/Point;", "getMScreenSize", "()Landroid/graphics/Point;", "setMScreenSize", "(Landroid/graphics/Point;)V", "mSensorOrientation", "getMSensorOrientation", "setMSensorOrientation", "mSupportHardWardLevel", "getMSupportHardWardLevel", "mSupportImageFormats", "", "getMSupportImageFormats", "()[I", "mSupportImageSizes", "", "Landroid/util/Size;", "getMSupportImageSizes", "()[Landroid/util/Size;", "mSupportPreviewSizes", "getMSupportPreviewSizes", "mSupportRecordSizes", "getMSupportRecordSizes", "mSupportRequestVendorTags", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "getMSupportRequestVendorTags", "()Ljava/util/ArrayList;", "setMSupportRequestVendorTags", "(Ljava/util/ArrayList;)V", "mSupportResultVendorTags", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "getMSupportResultVendorTags", "setMSupportResultVendorTags", "mSupportSessionVendorType", "Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "getMSupportSessionVendorType", "setMSupportSessionVendorType", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "skinRate", "getSkinRate", "setSkinRate", "slimRate", "getSlimRate", "setSlimRate", "checkHDRValue", "result", "Landroid/hardware/camera2/CaptureResult;", "configAllFaceBeautyTag", "builder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "configCaptureSessionType", "requestList", "", "configDenoisy", "configFaceBeauty", "configHDR", "configHDRChecker", "configStabilization", "configVendorTagValue", "tag", "getCamera2SupportHardWardLevel", "id", "getCameraId", "getCameraOrientation", "getFlashMode", "getFormatNames", "format", "getHardWardSupportLevelNames", "level", "getSupportImageFormat", "getSupportImageSize", "(Ljava/lang/String;I)[Landroid/util/Size;", "getSupportPreviewSize", "(Ljava/lang/String;)[Landroid/util/Size;", "getSupportRecordSize", "initAllParameters", "initConfigParameters", "isSettleBySessionType", "isVendorDenoisySupported", "isVendorFaceBeautySupported", "isVendorHDRCheckerSupported", "isVendorHDRSupported", "printSupportFormat", "formats", "printSupportSize", "sizes", "type", "([Landroid/util/Size;Ljava/lang/String;)V", "resumeAllCameraEffect", "setFlashMode", "mode", "setFlashOn", "isOn", "plugin-mediaeditor_release"})
public final class b {
    private static final String TAG = TAG;
    private static kotlin.g.a.b<? super Boolean, x> imw = null;
    private static Boolean inA = null;
    private static ArrayList<a> inB = null;
    private static ArrayList<com.tencent.mm.media.widget.b.a.b.a> inC = null;
    private static ArrayList<com.tencent.mm.media.widget.b.a.c.a> inD = null;
    public static final b inE = new b();
    static CameraManager inc = null;
    static final int ind = 1;
    static final int ine = 0;
    private static final int inf = 2;
    private static final int ing = 0;
    private static final int inh = 90;
    private static final int ini = 180;
    private static final int inj = 270;
    private static final String ink = ink;
    private static final String inl = inl;
    private static final String inm = "image";
    static String inn;
    private static int ino = 35;
    static int inp = ing;
    private static Point inq;
    private static boolean inr = true;
    private static boolean ins;

    /* renamed from: int  reason: not valid java name */
    private static boolean f3int = true;
    private static boolean inu = com.tencent.mm.media.widget.d.b.aRE();
    private static boolean inv = true;
    private static String inw;
    private static int inx = 40;
    private static int iny = 40;
    private static boolean inz;

    static {
        AppMethodBeat.i(94114);
        AppMethodBeat.o(94114);
    }

    private b() {
    }

    public static void a(CameraManager cameraManager) {
        inc = cameraManager;
    }

    public static String aPA() {
        return inn;
    }

    public static boolean aPB() {
        AppMethodBeat.i(94097);
        boolean j2 = p.j(inn, ry(ind));
        AppMethodBeat.o(94097);
        return j2;
    }

    public static int aPC() {
        return ino;
    }

    public static int aPD() {
        return inp;
    }

    public static Point aPE() {
        return inq;
    }

    public static void d(Point point) {
        inq = point;
    }

    public static void fc(boolean z) {
        inr = z;
    }

    public static void fd(boolean z) {
        ins = z;
    }

    public static void fe(boolean z) {
        f3int = z;
    }

    public static void ff(boolean z) {
        inu = z;
    }

    public static void fg(boolean z) {
        inv = z;
    }

    public static void o(kotlin.g.a.b<? super Boolean, x> bVar) {
        imw = bVar;
    }

    public static void aPF() {
        inr = true;
        ins = false;
        f3int = true;
        inv = true;
        inw = null;
        inx = 40;
        iny = 40;
        inz = false;
        inA = null;
    }

    public static Size[] aPG() {
        Size[] sizeArr;
        CameraCharacteristics cameraCharacteristics;
        AppMethodBeat.i(94098);
        String str = inn;
        if (str == null) {
            str = ry(ind);
        }
        CameraManager cameraManager = inc;
        StreamConfigurationMap streamConfigurationMap = (cameraManager == null || (cameraCharacteristics = cameraManager.getCameraCharacteristics(str)) == null) ? null : (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            sizeArr = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        } else {
            sizeArr = null;
        }
        if (sizeArr == null) {
            p.hyc();
        }
        a(sizeArr, ink);
        if (sizeArr == null) {
            p.hyc();
        }
        AppMethodBeat.o(94098);
        return sizeArr;
    }

    public static Size[] aPH() {
        Size[] sizeArr;
        CameraCharacteristics cameraCharacteristics;
        AppMethodBeat.i(94099);
        String str = inn;
        if (str == null) {
            str = ry(ind);
        }
        int i2 = ino;
        CameraManager cameraManager = inc;
        StreamConfigurationMap streamConfigurationMap = (cameraManager == null || (cameraCharacteristics = cameraManager.getCameraCharacteristics(str)) == null) ? null : (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            sizeArr = streamConfigurationMap.getOutputSizes(i2);
        } else {
            sizeArr = null;
        }
        if (sizeArr == null) {
            p.hyc();
        }
        a(sizeArr, inm);
        if (sizeArr == null) {
            p.hyc();
        }
        AppMethodBeat.o(94099);
        return sizeArr;
    }

    public static void o(ArrayList<a> arrayList) {
        inB = arrayList;
    }

    public static void p(ArrayList<com.tencent.mm.media.widget.b.a.b.a> arrayList) {
        inC = arrayList;
    }

    public static void q(ArrayList<com.tencent.mm.media.widget.b.a.c.a> arrayList) {
        inD = arrayList;
    }

    static String ry(int i2) {
        String str;
        String str2;
        CameraCharacteristics cameraCharacteristics;
        Integer num;
        AppMethodBeat.i(94100);
        CameraManager cameraManager = inc;
        String[] cameraIdList = cameraManager != null ? cameraManager.getCameraIdList() : null;
        if (cameraIdList != null) {
            int length = cameraIdList.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    str2 = null;
                    break;
                }
                String str3 = cameraIdList[i3];
                String str4 = str3;
                CameraManager cameraManager2 = inc;
                if (cameraManager2 != null) {
                    cameraCharacteristics = cameraManager2.getCameraCharacteristics(str4);
                } else {
                    cameraCharacteristics = null;
                }
                if (cameraCharacteristics != null) {
                    num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                } else {
                    num = null;
                }
                if (num != null && num.intValue() == i2) {
                    str2 = str3;
                    break;
                }
                i3++;
            }
            str = str2;
        } else {
            str = null;
        }
        if (str != null) {
            AppMethodBeat.o(94100);
            return str;
        }
        Log.e(TAG, "can not find the id: %s in camera manage", Integer.valueOf(i2));
        String valueOf = String.valueOf(i2);
        AppMethodBeat.o(94100);
        return valueOf;
    }

    private static void a(Size[] sizeArr, String str) {
        AppMethodBeat.i(94101);
        StringBuffer stringBuffer = new StringBuffer();
        for (Size size : sizeArr) {
            stringBuffer.append("size: " + size.getHeight() + ',' + size.getWidth() + " ratios " + ((((double) size.getHeight()) * 1.0d) / ((double) size.getWidth())) + "||");
        }
        Log.i(TAG, "Print currentCamera " + inn + " support " + str + " sizes " + stringBuffer);
        AppMethodBeat.o(94101);
    }

    public static int a(CaptureRequest.Builder builder) {
        AppMethodBeat.i(94102);
        p.h(builder, "builder");
        Integer num = (Integer) builder.get(CaptureRequest.CONTROL_AE_MODE);
        if (num != null && num.intValue() == 2) {
            AppMethodBeat.o(94102);
            return 3;
        }
        Integer num2 = (Integer) builder.get(CaptureRequest.FLASH_MODE);
        if ((num2 != null && num2.intValue() == 0) || ((num2 == null || num2.intValue() != 2) && (num2 == null || num2.intValue() != 1))) {
            AppMethodBeat.o(94102);
            return 2;
        }
        AppMethodBeat.o(94102);
        return 1;
    }

    public static void a(boolean z, CaptureRequest.Builder builder) {
        AppMethodBeat.i(94103);
        p.h(builder, "builder");
        if (com.tencent.mm.media.widget.d.b.aRF()) {
            if (z) {
                builder.set(CaptureRequest.FLASH_MODE, 1);
                AppMethodBeat.o(94103);
                return;
            }
            builder.set(CaptureRequest.FLASH_MODE, 0);
            AppMethodBeat.o(94103);
        } else if (z) {
            builder.set(CaptureRequest.FLASH_MODE, 2);
            AppMethodBeat.o(94103);
        } else {
            builder.set(CaptureRequest.FLASH_MODE, 0);
            AppMethodBeat.o(94103);
        }
    }

    public static void b(CaptureRequest.Builder builder) {
        AppMethodBeat.i(94104);
        p.h(builder, "builder");
        String str = inn;
        if (str == null) {
            p.hyc();
        }
        com.tencent.mm.media.widget.b.a.a.b bVar = new com.tencent.mm.media.widget.b.a.a.b(builder, str, inB);
        b.a aVar = com.tencent.mm.media.widget.b.a.a.b.ipa;
        String aQb = com.tencent.mm.media.widget.b.a.a.b.aQb();
        com.tencent.mm.media.widget.b.a.b bVar2 = com.tencent.mm.media.widget.b.a.b.iop;
        if (bVar.af(aQb, com.tencent.mm.media.widget.b.a.b.aPR())) {
            String str2 = inn;
            if (str2 == null) {
                p.hyc();
            }
            com.tencent.mm.media.widget.b.a.a.b bVar3 = new com.tencent.mm.media.widget.b.a.a.b(builder, str2, inB);
            b.a aVar2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
            String aQb2 = com.tencent.mm.media.widget.b.a.a.b.aQb();
            boolean z = inr;
            com.tencent.mm.media.widget.b.a.b bVar4 = com.tencent.mm.media.widget.b.a.b.iop;
            bVar3.b(aQb2, z, com.tencent.mm.media.widget.b.a.b.aPR());
        }
        AppMethodBeat.o(94104);
    }

    public static void c(CaptureRequest.Builder builder) {
        AppMethodBeat.i(94105);
        p.h(builder, "builder");
        if (!inz) {
            String str = inn;
            if (str == null) {
                p.hyc();
            }
            com.tencent.mm.media.widget.b.a.a.b bVar = new com.tencent.mm.media.widget.b.a.a.b(builder, str, inB);
            b.a aVar = com.tencent.mm.media.widget.b.a.a.b.ipa;
            String aPW = com.tencent.mm.media.widget.b.a.a.b.aPW();
            com.tencent.mm.media.widget.b.a.b bVar2 = com.tencent.mm.media.widget.b.a.b.iop;
            if (bVar.af(aPW, com.tencent.mm.media.widget.b.a.b.aPQ())) {
                String str2 = inn;
                if (str2 == null) {
                    p.hyc();
                }
                com.tencent.mm.media.widget.b.a.a.b bVar3 = new com.tencent.mm.media.widget.b.a.a.b(builder, str2, inB);
                b.a aVar2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
                String aPW2 = com.tencent.mm.media.widget.b.a.a.b.aPW();
                boolean z = inv;
                com.tencent.mm.media.widget.b.a.b bVar4 = com.tencent.mm.media.widget.b.a.b.iop;
                bVar3.b(aPW2, z, com.tencent.mm.media.widget.b.a.b.aPQ());
                AppMethodBeat.o(94105);
                return;
            }
        } else {
            p.h(builder, "builder");
            String str3 = inn;
            if (str3 == null) {
                p.hyc();
            }
            com.tencent.mm.media.widget.b.a.a.b bVar5 = new com.tencent.mm.media.widget.b.a.a.b(builder, str3, inB);
            b.a aVar3 = com.tencent.mm.media.widget.b.a.a.b.ipa;
            String aPW3 = com.tencent.mm.media.widget.b.a.a.b.aPW();
            b.a aVar4 = com.tencent.mm.media.widget.b.a.a.b.ipa;
            String aPX = com.tencent.mm.media.widget.b.a.a.b.aPX();
            boolean z2 = inv;
            String str4 = inw;
            if (str4 == null) {
                p.hyc();
            }
            com.tencent.mm.media.widget.b.a.b bVar6 = com.tencent.mm.media.widget.b.a.b.iop;
            int aPQ = com.tencent.mm.media.widget.b.a.b.aPQ();
            p.h(aPW3, "key");
            p.h(aPX, "child");
            bVar5.a(aPW3, aPX, z2, str4, aPQ);
            String str5 = inn;
            if (str5 == null) {
                p.hyc();
            }
            com.tencent.mm.media.widget.b.a.a.b bVar7 = new com.tencent.mm.media.widget.b.a.a.b(builder, str5, inB);
            b.a aVar5 = com.tencent.mm.media.widget.b.a.a.b.ipa;
            String aPW4 = com.tencent.mm.media.widget.b.a.a.b.aPW();
            b.a aVar6 = com.tencent.mm.media.widget.b.a.a.b.ipa;
            String aPY = com.tencent.mm.media.widget.b.a.a.b.aPY();
            boolean z3 = inv;
            int i2 = inx;
            com.tencent.mm.media.widget.b.a.b bVar8 = com.tencent.mm.media.widget.b.a.b.iop;
            bVar7.a(aPW4, aPY, z3, i2, com.tencent.mm.media.widget.b.a.b.aPQ());
            String str6 = inn;
            if (str6 == null) {
                p.hyc();
            }
            com.tencent.mm.media.widget.b.a.a.b bVar9 = new com.tencent.mm.media.widget.b.a.a.b(builder, str6, inB);
            b.a aVar7 = com.tencent.mm.media.widget.b.a.a.b.ipa;
            String aPW5 = com.tencent.mm.media.widget.b.a.a.b.aPW();
            b.a aVar8 = com.tencent.mm.media.widget.b.a.a.b.ipa;
            String aPZ = com.tencent.mm.media.widget.b.a.a.b.aPZ();
            boolean z4 = inv;
            int i3 = iny;
            com.tencent.mm.media.widget.b.a.b bVar10 = com.tencent.mm.media.widget.b.a.b.iop;
            bVar9.a(aPW5, aPZ, z4, i3, com.tencent.mm.media.widget.b.a.b.aPQ());
        }
        AppMethodBeat.o(94105);
    }

    public static void d(CaptureRequest.Builder builder) {
        AppMethodBeat.i(94106);
        p.h(builder, "builder");
        String str = inn;
        if (str == null) {
            p.hyc();
        }
        com.tencent.mm.media.widget.b.a.a.b bVar = new com.tencent.mm.media.widget.b.a.a.b(builder, str, inB);
        b.a aVar = com.tencent.mm.media.widget.b.a.a.b.ipa;
        String aQa = com.tencent.mm.media.widget.b.a.a.b.aQa();
        com.tencent.mm.media.widget.b.a.b bVar2 = com.tencent.mm.media.widget.b.a.b.iop;
        if (bVar.af(aQa, com.tencent.mm.media.widget.b.a.b.aPR())) {
            String str2 = inn;
            if (str2 == null) {
                p.hyc();
            }
            com.tencent.mm.media.widget.b.a.a.b bVar3 = new com.tencent.mm.media.widget.b.a.a.b(builder, str2, inB);
            b.a aVar2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
            String aQa2 = com.tencent.mm.media.widget.b.a.a.b.aQa();
            boolean z = ins;
            com.tencent.mm.media.widget.b.a.b bVar4 = com.tencent.mm.media.widget.b.a.b.iop;
            bVar3.b(aQa2, z, com.tencent.mm.media.widget.b.a.b.aPR());
        }
        AppMethodBeat.o(94106);
    }

    public static void e(CaptureRequest.Builder builder) {
        AppMethodBeat.i(94107);
        p.h(builder, "builder");
        String str = inn;
        if (str == null) {
            p.hyc();
        }
        com.tencent.mm.media.widget.b.a.a.b bVar = new com.tencent.mm.media.widget.b.a.a.b(builder, str, inB);
        b.a aVar = com.tencent.mm.media.widget.b.a.a.b.ipa;
        String aQd = com.tencent.mm.media.widget.b.a.a.b.aQd();
        com.tencent.mm.media.widget.b.a.b bVar2 = com.tencent.mm.media.widget.b.a.b.iop;
        if (bVar.af(aQd, com.tencent.mm.media.widget.b.a.b.aPQ())) {
            String str2 = inn;
            if (str2 == null) {
                p.hyc();
            }
            com.tencent.mm.media.widget.b.a.a.b bVar3 = new com.tencent.mm.media.widget.b.a.a.b(builder, str2, inB);
            b.a aVar2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
            String aQd2 = com.tencent.mm.media.widget.b.a.a.b.aQd();
            boolean z = f3int;
            com.tencent.mm.media.widget.b.a.b bVar4 = com.tencent.mm.media.widget.b.a.b.iop;
            bVar3.b(aQd2, z, com.tencent.mm.media.widget.b.a.b.aPQ());
        }
        AppMethodBeat.o(94107);
    }

    public static void f(CaptureRequest.Builder builder) {
        AppMethodBeat.i(94108);
        p.h(builder, "builder");
        String str = inn;
        if (str == null) {
            p.hyc();
        }
        com.tencent.mm.media.widget.b.a.a.b bVar = new com.tencent.mm.media.widget.b.a.a.b(builder, str, inB);
        b.a aVar = com.tencent.mm.media.widget.b.a.a.b.ipa;
        String aQc = com.tencent.mm.media.widget.b.a.a.b.aQc();
        com.tencent.mm.media.widget.b.a.b bVar2 = com.tencent.mm.media.widget.b.a.b.iop;
        if (bVar.af(aQc, com.tencent.mm.media.widget.b.a.b.aPS())) {
            String str2 = inn;
            if (str2 == null) {
                p.hyc();
            }
            com.tencent.mm.media.widget.b.a.a.b bVar3 = new com.tencent.mm.media.widget.b.a.a.b(builder, str2, inB);
            b.a aVar2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
            String aQc2 = com.tencent.mm.media.widget.b.a.a.b.aQc();
            boolean z = inu;
            com.tencent.mm.media.widget.b.a.b bVar4 = com.tencent.mm.media.widget.b.a.b.iop;
            bVar3.b(aQc2, z, com.tencent.mm.media.widget.b.a.b.aPS());
        }
        AppMethodBeat.o(94108);
    }

    public static void g(CaptureRequest.Builder builder) {
        AppMethodBeat.i(94109);
        p.h(builder, "builder");
        ArrayList<a> arrayList = inB;
        if (arrayList != null) {
            for (T t : arrayList) {
                Log.i(TAG, "close effect :  " + t.ioN);
                com.tencent.mm.media.widget.b.a.b.a(builder, t, false);
            }
            AppMethodBeat.o(94109);
            return;
        }
        AppMethodBeat.o(94109);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.hardware.camera2.CaptureResult r12) {
        /*
        // Method dump skipped, instructions count: 558
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.b.b.a(android.hardware.camera2.CaptureResult):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x008a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.hardware.camera2.CaptureRequest.Builder r12, java.lang.String r13, int r14) {
        /*
        // Method dump skipped, instructions count: 233
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.b.b.a(android.hardware.camera2.CaptureRequest$Builder, java.lang.String, int):void");
    }

    public static int a(CaptureRequest.Builder builder, List<String> list) {
        T t;
        AppMethodBeat.i(94112);
        p.h(builder, "builder");
        ArrayList<String> arrayList = new ArrayList<>();
        String str = inn;
        if (str == null) {
            p.hyc();
        }
        for (T t2 : new com.tencent.mm.media.widget.b.a.a.b(builder, str, inB).ak(list)) {
            Log.i(TAG, "request tag %s", t2);
            arrayList.add(t2);
        }
        ArrayList<com.tencent.mm.media.widget.b.a.c.a> arrayList2 = inD;
        if (arrayList2 != null) {
            Iterator<T> it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (next.r(arrayList)) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                int i2 = t3.ipp;
                AppMethodBeat.o(94112);
                return i2;
            }
        }
        AppMethodBeat.o(94112);
        return 0;
    }

    public static boolean aPI() {
        AppMethodBeat.i(94113);
        ArrayList<com.tencent.mm.media.widget.b.a.c.a> arrayList = inD;
        if (arrayList == null) {
            AppMethodBeat.o(94113);
            return false;
        } else if (!arrayList.isEmpty()) {
            AppMethodBeat.o(94113);
            return true;
        } else {
            AppMethodBeat.o(94113);
            return false;
        }
    }
}

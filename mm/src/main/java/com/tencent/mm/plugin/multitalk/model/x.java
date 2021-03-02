package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.plugin.appbrand.jsapi.p.an;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.video.camera.a.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018\u0000 £\u00012\u00020\u0001:\u0004¢\u0001£\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010oJ\u0012\u0010\u0001\u001a\u00020\u00032\t\u0010\u0001\u001a\u0004\u0018\u00010-J\b\u0010\u0001\u001a\u00030\u0001J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0011J\"\u0010\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001b\u0010\u0001\u001a\u00020\u00032\t\u0010\u0001\u001a\u0004\u0018\u00010<2\u0007\u0010\u0001\u001a\u00020\u0011J\u0014\u0010\u0001\u001a\u0004\u0018\u00010-2\u0007\u0010\u0001\u001a\u00020\u0011H\u0002J\u001e\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010-2\u0007\u0010\u0001\u001a\u00020\u0003H\u0002J\u0014\u0010\u0010\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010-H\u0002J\t\u0010{\u001a\u00030\u0001H\u0002J\u0007\u0010\u0001\u001a\u00020\u0003J\b\u0010\u0001\u001a\u00030\u0001J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020-H\u0002J$\u0010\u0001\u001a\u00020\u00112\t\u0010\u0001\u001a\u0004\u0018\u00010-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001d\u0010 \u0001\u001a\u00020\u00112\t\u0010\u0001\u001a\u0004\u0018\u00010-2\u0007\u0010¡\u0001\u001a\u00020\u0011H\u0002R$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR*\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0011@DX\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001bR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u0010\u001bR\u001a\u00105\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0018\"\u0004\b7\u0010\u001bR\u001a\u00108\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\t\"\u0004\b:\u0010\u000bR\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\t\"\u0004\bC\u0010\u000bR\u001a\u0010D\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0018\"\u0004\bF\u0010\u001bR\u001a\u0010G\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0018\"\u0004\bI\u0010\u001bR\u001a\u0010J\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0018\"\u0004\bL\u0010\u001bR\u001a\u0010M\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0018\"\u0004\bO\u0010\u001bR\u001a\u0010P\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0018\"\u0004\bR\u0010\u001bR\u001a\u0010S\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0018\"\u0004\bU\u0010\u001bR\u001a\u0010V\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0018\"\u0004\bX\u0010\u001bR\u001a\u0010Y\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010#\"\u0004\b[\u0010%R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR \u0010b\u001a\b\u0018\u00010cR\u00020dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010i\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001c\u0010n\u001a\u0004\u0018\u00010oX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\t\"\u0004\bv\u0010\u000bR\u001a\u0010w\u001a\u00020xX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R+\u0010~\u001a\u0004\u0018\u00010}2\b\u0010\u0006\u001a\u0004\u0018\u00010}@DX\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\t\"\u0005\b\u0001\u0010\u000bR\u001d\u0010\u0001\u001a\u00020\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\t\"\u0005\b\u0001\u0010\u000bR\u001d\u0010\u0001\u001a\u00020\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\t\"\u0005\b\u0001\u0010\u000b¨\u0006¤\u0001"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer;", "", "w", "", "h", "(II)V", "<set-?>", "cameraErrCode", "getCameraErrCode", "()I", "setCameraErrCode", "(I)V", "dispatchFrameData", "", "displayOrientation", "getDisplayOrientation", an.NAME, "", "isCameraRemote180", "()Ljava/lang/Boolean;", "setCameraRemote180", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isCloudVoip", "()Z", "isCurrentFaceCamera", "setCurrentFaceCamera", "(Z)V", "isPreviewing", "setPreviewing", "isUesSurfacePreivew", "setUesSurfacePreivew", "mAutoFocusTimeOut", "", "getMAutoFocusTimeOut", "()J", "setMAutoFocusTimeOut", "(J)V", "mCallbackBufList", "", "getMCallbackBufList", "()Ljava/util/List;", "setMCallbackBufList", "(Ljava/util/List;)V", "mCamera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "getMCamera", "()Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "setMCamera", "(Lcom/tencent/mm/compatible/deviceinfo/MCamera;)V", "mCameraOpen", "getMCameraOpen", "setMCameraOpen", "mCameraOpenFaild", "getMCameraOpenFaild", "setMCameraOpenFaild", "mFormat", "getMFormat", "setMFormat", "mGetCameraDataCallback", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "getMGetCameraDataCallback", "()Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "setMGetCameraDataCallback", "(Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;)V", "mHeight", "getMHeight", "setMHeight", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "setMIsCameraNoParamAutoFocus", "mIsContinuousVideoMode", "getMIsContinuousVideoMode", "setMIsContinuousVideoMode", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mIsInCapture", "getMIsInCapture", "setMIsInCapture", "mIsLastAutoFocusFaceCamera", "getMIsLastAutoFocusFaceCamera", "setMIsLastAutoFocusFaceCamera", "mIsLastFocusFaceCamera", "getMIsLastFocusFaceCamera", "setMIsLastFocusFaceCamera", "mIsShouldStartCapture", "getMIsShouldStartCapture", "setMIsShouldStartCapture", "mLastAutoFocusTimestamp", "getMLastAutoFocusTimestamp", "setMLastAutoFocusTimestamp", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mParameters", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getMParameters", "()Landroid/hardware/Camera$Parameters;", "setMParameters", "(Landroid/hardware/Camera$Parameters;)V", "mRotateTmpBuffer", "getMRotateTmpBuffer", "()[B", "setMRotateTmpBuffer", "([B)V", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getMSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setMSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "mWidth", "getMWidth", "setMWidth", "previewCallback", "Landroid/hardware/Camera$PreviewCallback;", "getPreviewCallback", "()Landroid/hardware/Camera$PreviewCallback;", "setPreviewCallback", "(Landroid/hardware/Camera$PreviewCallback;)V", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "previewSize", "getPreviewSize", "()Lcom/tencent/mm/compatible/deviceinfo/Size;", "setPreviewSize", "(Lcom/tencent/mm/compatible/deviceinfo/Size;)V", "supportMaxPixel", "getSupportMaxPixel", "setSupportMaxPixel", "supportMaxSizeHeight", "getSupportMaxSizeHeight", "setSupportMaxSizeHeight", "supportMaxSizeWidth", "getSupportMaxSizeWidth", "setSupportMaxSizeWidth", "bind", "", "surfaceTexture", "dumpCapInfo", "camera", "exchangeCapture", "exchangeToHignCapture", "is1280", "initCamera", "bFace", "initCapture", "dataCallback", "bFaceFirst", "safeOpenCamera", "safeSetFps", "cuFps", "startCaptureUseSurfaceHolder", "stopCapture", "testSupportFps", "tryPreviewSize", "trySetAutoFocus", "isFrontCamera", "CaptureRenderStatIDKey", "Companion", "plugin-multitalk_release"})
public final class x {
    private static final Pattern zOp = Pattern.compile(",");
    public static final a zOq = new a((byte) 0);
    public boolean imy;
    private int mHeight;
    SurfaceTexture mSurfaceTexture;
    private int mWidth;
    volatile v sZb;
    private boolean sZd;
    public boolean zNU;
    Boolean zNV;
    private long zNW;
    public int zNX;
    private Camera.Parameters zNY;
    ac zNZ;
    int zOa;
    private boolean zOb;
    private boolean zOc;
    private boolean zOd;
    public com.tencent.mm.plugin.voip.video.camera.a.b zOe;
    private boolean zOf;
    private boolean zOg;
    byte[] zOh;
    private List<byte[]> zOi;
    private int zOj;
    private int zOk;
    private int zOl;
    private boolean zOm;
    private byte[] zOn;
    private Camera.PreviewCallback zOo;

    public x() {
        AppMethodBeat.i(239651);
        this.zNW = 30000;
        this.mWidth = 320;
        this.mHeight = 240;
        this.imy = true;
        this.zOo = new b(this);
        this.mWidth = 640;
        this.mHeight = 480;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        c.hH(context.getApplicationContext());
        Log.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight));
        AppMethodBeat.o(239651);
    }

    public final int a(com.tencent.mm.plugin.voip.video.camera.a.b bVar, boolean z) {
        int h2;
        AppMethodBeat.i(239642);
        com.tencent.mm.plugin.voip.video.camera.prev.b bVar2 = c.Hjw;
        p.g(bVar2, "VoipCameraCompatible.gVoipCameraInfo");
        if (bVar2.aRA() <= 0) {
            this.zNX = 1;
            AppMethodBeat.o(239642);
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
        if (h(z, this.mWidth, this.mHeight) > 0 || (h2 = h(z, this.mWidth, this.mHeight)) > 0) {
            this.zNU = z;
            eoa();
            this.zNX = 0;
            AppMethodBeat.o(239642);
            return 1;
        }
        this.zNX = 1;
        AppMethodBeat.o(239642);
        return h2;
    }

    private final void eoa() {
        AppMethodBeat.i(239643);
        try {
            if (this.sZb != null && this.zOb) {
                if (this.zNZ != null) {
                    ac acVar = this.zNZ;
                    if (acVar == null) {
                        p.hyc();
                    }
                    if (acVar.height > 0) {
                        ac acVar2 = this.zNZ;
                        if (acVar2 == null) {
                            p.hyc();
                        }
                        if (acVar2.width > 0) {
                            ac acVar3 = this.zNZ;
                            if (acVar3 == null) {
                                p.hyc();
                            }
                            int i2 = acVar3.height;
                            ac acVar4 = this.zNZ;
                            if (acVar4 == null) {
                                p.hyc();
                            }
                            int i3 = ((i2 * acVar4.width) * 3) / 2;
                            if (this.zOi == null) {
                                this.zOi = new ArrayList(3);
                                for (int i4 = 0; i4 < 3; i4++) {
                                    List<byte[]> list = this.zOi;
                                    if (list != null) {
                                        list.add(new byte[i3]);
                                    }
                                }
                            }
                            List<byte[]> list2 = this.zOi;
                            if (list2 == null) {
                                p.hyc();
                            }
                            int size = list2.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                if (this.sZb != null) {
                                    v vVar = this.sZb;
                                    if (vVar == null) {
                                        p.hyc();
                                    }
                                    List<byte[]> list3 = this.zOi;
                                    if (list3 == null) {
                                        p.hyc();
                                    }
                                    vVar.addCallbackBuffer(list3.get(i5));
                                }
                            }
                            v vVar2 = this.sZb;
                            if (vVar2 == null) {
                                p.hyc();
                            }
                            vVar2.setPreviewCallbackWithBuffer(this.zOo);
                            AppMethodBeat.o(239643);
                            return;
                        }
                    }
                }
                v vVar3 = this.sZb;
                if (vVar3 == null) {
                    p.hyc();
                }
                vVar3.setPreviewCallback(this.zOo);
                AppMethodBeat.o(239643);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", e2, "setPreviewCallback error: %s", e2.getMessage());
        }
        AppMethodBeat.o(239643);
    }

    private final v rO(boolean z) {
        v vVar;
        List<Integer> list;
        AppMethodBeat.i(239644);
        v rP = a.rP(z);
        if (rP == null) {
            try {
                v vVar2 = new v(Camera.open());
                this.zNU = false;
                h.INSTANCE.idkeyStat(159, 0, 1, false);
                vVar = vVar2;
            } catch (Exception e2) {
                Log.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:".concat(String.valueOf(e2)));
                h.INSTANCE.idkeyStat(159, 0, 1, false);
                h.INSTANCE.idkeyStat(159, 1, 1, false);
                if (this.zOe != null) {
                    com.tencent.mm.plugin.voip.video.camera.a.b bVar = this.zOe;
                    if (bVar == null) {
                        p.hyc();
                    }
                    bVar.cza();
                }
                AppMethodBeat.o(239644);
                return null;
            }
        } else {
            this.zNU = z;
            vVar = rP;
        }
        try {
            Camera.Parameters parameters = vVar.getParameters();
            p.g(parameters, "camera.parameters");
            list = parameters.getSupportedPreviewFrameRates();
        } catch (Exception e3) {
            Log.d("MicroMsg.Voip.CaptureRender", "getSupportedPreviewFrameRates:error:".concat(String.valueOf(e3)));
            list = null;
        }
        String str = "supportFps:";
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                str = str + list.get(i2).intValue() + ',';
            }
        }
        Log.i("MicroMsg.Voip.CaptureRender", str);
        f(vVar);
        AppMethodBeat.o(239644);
        return vVar;
    }

    private static boolean a(v vVar, int i2, int i3) {
        AppMethodBeat.i(239645);
        if (vVar == null) {
            AppMethodBeat.o(239645);
            return false;
        }
        try {
            Camera.Parameters parameters = vVar.getParameters();
            if (i2 > 0 && i3 > 0) {
                parameters.setPreviewSize(i2, i3);
            }
            vVar.setParameters(parameters);
            AppMethodBeat.o(239645);
            return true;
        } catch (Exception e2) {
            h.INSTANCE.idkeyStat(159, 0, 1, false);
            Log.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:".concat(String.valueOf(e2)));
            AppMethodBeat.o(239645);
            return false;
        }
    }

    private final boolean b(v vVar, boolean z) {
        AppMethodBeat.i(239646);
        if (vVar == null) {
            AppMethodBeat.o(239646);
            return false;
        }
        try {
            Log.i("MicroMsg.Voip.CaptureRender", "trySetAutoFocus, isFrontCamera:%s", Boolean.valueOf(z));
            Camera.Parameters parameters = vVar.getParameters();
            p.g(parameters, "parameters");
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                Log.i("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + supportedFocusModes.size());
                for (String str : supportedFocusModes) {
                    Log.i("MicroMsg.Voip.CaptureRender", "supported focus modes : ".concat(String.valueOf(str)));
                }
                if (ae.gKt.gGg != 0 || !z) {
                    if (ae.gKt.gGg == 1 || !z) {
                        if (supportedFocusModes.contains("continuous-video")) {
                            Log.i("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                            parameters.setFocusMode("continuous-video");
                            this.zOc = true;
                        } else if (supportedFocusModes.contains("auto")) {
                            Log.i("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                            parameters.setFocusMode("auto");
                            this.zOc = false;
                        }
                    }
                } else if (supportedFocusModes.contains("auto")) {
                    Log.i("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                    parameters.setFocusMode("auto");
                    this.zOc = false;
                } else if (supportedFocusModes.contains("continuous-video")) {
                    Log.i("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                    parameters.setFocusMode("continuous-video");
                    this.zOc = true;
                }
                vVar.setParameters(parameters);
            }
            AppMethodBeat.o(239646);
            return true;
        } catch (Exception e2) {
            h.INSTANCE.idkeyStat(159, 0, 1, false);
            Log.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:".concat(String.valueOf(e2)));
            AppMethodBeat.o(239646);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:169:0x04d6  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0555 A[Catch:{ Exception -> 0x0635 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0566 A[Catch:{ Exception -> 0x0635 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x056c A[Catch:{ Exception -> 0x0635 }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x057f  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0594  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x05a8 A[Catch:{ Exception -> 0x05c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x05ba A[Catch:{ Exception -> 0x05c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0632  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x065e  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0662  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0666  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0274  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int h(boolean r21, int r22, int r23) {
        /*
        // Method dump skipped, instructions count: 1742
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.x.h(boolean, int, int):int");
    }

    public final int eob() {
        AppMethodBeat.i(239648);
        if (!this.zOb) {
            Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
            this.zNX = 1;
            AppMethodBeat.o(239648);
            return -1;
        } else if (this.zOf) {
            Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
            AppMethodBeat.o(239648);
            return -1;
        } else {
            Log.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", Boolean.valueOf(this.zOd));
            if (this.mSurfaceTexture != null) {
                try {
                    v vVar = this.sZb;
                    if (vVar == null) {
                        p.hyc();
                    }
                    vVar.setPreviewTexture(this.mSurfaceTexture);
                } catch (Exception e2) {
                    h.INSTANCE.idkeyStat(159, 0, 1, false);
                    h.INSTANCE.idkeyStat(159, 2, 1, false);
                    this.zNX = 1;
                    Log.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:".concat(String.valueOf(e2)));
                }
            }
            try {
                v vVar2 = this.sZb;
                if (vVar2 == null) {
                    p.hyc();
                }
                vVar2.startPreview();
                this.sZd = true;
            } catch (Exception e3) {
                h.INSTANCE.idkeyStat(159, 0, 1, false);
                h.INSTANCE.idkeyStat(159, 2, 1, false);
                this.zNX = 1;
                if (this.zOe != null) {
                    com.tencent.mm.plugin.voip.video.camera.a.b bVar = this.zOe;
                    if (bVar == null) {
                        p.hyc();
                    }
                    bVar.cza();
                }
                Log.e("MicroMsg.Voip.CaptureRender", "startPreview:error".concat(String.valueOf(e3)));
            }
            if (this.sZb != null) {
                v vVar3 = this.sZb;
                if (vVar3 == null) {
                    p.hyc();
                }
                vVar3.setPreviewCallback(this.zOo);
            }
            this.zOf = true;
            AppMethodBeat.o(239648);
            return 1;
        }
    }

    public final void eoc() {
        AppMethodBeat.i(239649);
        Log.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.zOf);
        if (this.zOf && this.sZb != null) {
            this.zOg = false;
            v vVar = this.sZb;
            if (vVar == null) {
                p.hyc();
            }
            if (!vVar.gIJ) {
                v vVar2 = this.sZb;
                if (vVar2 == null) {
                    p.hyc();
                }
                vVar2.setPreviewCallback(null);
            }
            try {
                v vVar3 = this.sZb;
                if (vVar3 == null) {
                    p.hyc();
                }
                vVar3.stopPreview();
                this.sZd = false;
            } catch (Exception e2) {
                Log.e("MicroMsg.Voip.CaptureRender", "stopPreview:error".concat(String.valueOf(e2)));
            }
            this.zOf = false;
        }
        if (1 == this.zNX) {
            pl plVar = new pl();
            plVar.dVC.type = 2;
            EventCenter.instance.publish(plVar);
        }
        Log.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.zOb);
        if (this.zOb) {
            this.zNX = 0;
            this.zOg = false;
            if (this.sZb != null) {
                v vVar4 = this.sZb;
                if (vVar4 == null) {
                    p.hyc();
                }
                if (!vVar4.gIJ) {
                    v vVar5 = this.sZb;
                    if (vVar5 == null) {
                        p.hyc();
                    }
                    vVar5.setPreviewCallback(null);
                    v vVar6 = this.sZb;
                    if (vVar6 == null) {
                        p.hyc();
                    }
                    vVar6.release();
                }
            }
            this.sZb = null;
            this.zOb = false;
        } else if (this.sZb != null) {
            v vVar7 = this.sZb;
            if (vVar7 == null) {
                p.hyc();
            }
            if (!vVar7.gIJ) {
                v vVar8 = this.sZb;
                if (vVar8 == null) {
                    p.hyc();
                }
                vVar8.setPreviewCallback(null);
            }
            v vVar9 = this.sZb;
            if (vVar9 == null) {
                p.hyc();
            }
            vVar9.release();
            this.sZb = null;
            this.zOb = false;
        }
        this.zOh = null;
        if (this.zOi != null) {
            List<byte[]> list = this.zOi;
            if (list == null) {
                p.hyc();
            }
            list.clear();
        }
        this.zOi = null;
        this.zOc = false;
        AppMethodBeat.o(239649);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer$previewCallback$1", "Landroid/hardware/Camera$PreviewCallback;", "onPreviewFrame", "", "data", "", "arg1", "Landroid/hardware/Camera;", "plugin-multitalk_release"})
    public static final class b implements Camera.PreviewCallback {
        final /* synthetic */ x zOr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(x xVar) {
            this.zOr = xVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x008b, code lost:
            if (r2.length != r17.length) goto L_0x008d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPreviewFrame(byte[] r17, android.hardware.Camera r18) {
            /*
            // Method dump skipped, instructions count: 557
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.x.b.onPreviewFrame(byte[], android.hardware.Camera):void");
        }
    }

    private int f(v vVar) {
        int i2;
        AppMethodBeat.i(239650);
        if (vVar == null) {
            AppMethodBeat.o(239650);
            return 0;
        }
        try {
            Camera.Parameters parameters = vVar.getParameters();
            p.g(parameters, "camera.parameters");
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                i2 = 0;
            } else {
                i2 = 0;
                for (Camera.Size size : supportedPreviewSizes) {
                    try {
                        Log.d("MicroMsg.Voip.CaptureRender", "support Size:" + size.width + "," + size.height);
                        if (i2 == 0) {
                            this.zOk = size.width;
                            this.zOl = size.height;
                        }
                        i2++;
                    } catch (Exception e2) {
                        e = e2;
                        Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", e, "", new Object[0]);
                        AppMethodBeat.o(239650);
                        return i2;
                    }
                }
            }
            Camera.Parameters parameters2 = vVar.getParameters();
            p.g(parameters2, "camera.parameters");
            List<Integer> supportedPreviewFormats = parameters2.getSupportedPreviewFormats();
            if (!(supportedPreviewFormats == null || supportedPreviewFormats.size() == 0)) {
                for (Integer num : supportedPreviewFormats) {
                    Log.i("MicroMsg.Voip.CaptureRender", "support Format:".concat(String.valueOf(num)));
                }
            }
        } catch (Exception e3) {
            e = e3;
            i2 = 0;
            Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", e, "", new Object[0]);
            AppMethodBeat.o(239650);
            return i2;
        }
        AppMethodBeat.o(239650);
        return i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\"\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u0004\u0018\u00010\"2\u0006\u0010&\u001a\u00020'R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer$Companion;", "", "()V", "CALLBACK_BUFFER_COUNT", "", "COMMA_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "ENUM_VideoDevStartFailed", "ENUM_VideoDevStartNormal", "FOCUS_FACE_LOC_DIFF_THREASHOLD", "METER_FACE_LOC_DIFF_THRESHOLD", "TAG", "", "VFMT_420SP", "VFMT_D530", "VFMT_LOCAL", "VFMT_NV12", "VFMT_RGB24", "VFMT_RGB32", "VFMT_RGB565", "VFMT_ROTATE", "VFMT_UYVY", "VFMT_YUV420", "VFMT_YUY2", "VFMT_YV12", "findBestPreviewSizeValue", "Landroid/graphics/Point;", "previewSizeValueString", "", "screenResolution", "getCameraResolution", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "w", "h", "openCameraByHighApiLvl", "bFace", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static v rP(boolean z) {
            d.a.C0301a B;
            v vVar = null;
            AppMethodBeat.i(239639);
            com.tencent.mm.plugin.voip.video.camera.prev.b bVar = c.Hjw;
            p.g(bVar, "VoipCameraCompatible.gVoipCameraInfo");
            if (bVar.aRA() <= 0) {
                AppMethodBeat.o(239639);
            } else if (!c.HjC) {
                AppMethodBeat.o(239639);
            } else {
                if (z) {
                    try {
                        B = d.B(MMApplicationContext.getContext(), c.Hjx);
                        Log.i("Camera", "Use front");
                    } catch (Exception e2) {
                        h.INSTANCE.idkeyStat(159, 0, 1, false);
                        h.INSTANCE.idkeyStat(159, 1, 1, false);
                        Log.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:".concat(String.valueOf(e2)));
                    }
                } else {
                    B = d.B(MMApplicationContext.getContext(), c.Hjy);
                    Log.i("Camera", "Use back");
                }
                if (B != null) {
                    vVar = B.gGr;
                }
                AppMethodBeat.o(239639);
            }
            return vVar;
        }

        static Point a(CharSequence charSequence, Point point) {
            int i2;
            int i3;
            int abs;
            boolean z;
            AppMethodBeat.i(239640);
            int i4 = 0;
            int i5 = 0;
            int i6 = Integer.MAX_VALUE;
            String[] split = x.zOp.split(charSequence);
            int length = split.length;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    i2 = i5;
                    i3 = i4;
                    break;
                }
                String str = split[i7];
                p.g(str, "previewSize");
                String str2 = str;
                int i8 = 0;
                int length2 = str2.length() - 1;
                boolean z2 = false;
                while (i8 <= length2) {
                    if (str2.charAt(!z2 ? i8 : length2) <= ' ') {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2) {
                        if (!z) {
                            break;
                        }
                        length2--;
                    } else if (!z) {
                        z2 = true;
                    } else {
                        i8++;
                    }
                }
                String obj = str2.subSequence(i8, length2 + 1).toString();
                int a2 = n.a((CharSequence) obj, 'x', 0, false, 6);
                if (a2 < 0) {
                    Log.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: ".concat(String.valueOf(obj)));
                    abs = i6;
                    i2 = i5;
                    i3 = i4;
                } else if (obj == null) {
                    try {
                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(239640);
                        throw tVar;
                    } catch (NumberFormatException e2) {
                        Log.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: ".concat(String.valueOf(obj)));
                        abs = i6;
                        i2 = i5;
                        i3 = i4;
                    }
                } else {
                    String substring = obj.substring(0, a2);
                    p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    i3 = Util.getInt(substring, 0);
                    int i9 = a2 + 1;
                    if (obj == null) {
                        t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(239640);
                        throw tVar2;
                    }
                    String substring2 = obj.substring(i9);
                    p.g(substring2, "(this as java.lang.String).substring(startIndex)");
                    i2 = Util.getInt(substring2, 0);
                    abs = Math.abs(i3 - point.x) + Math.abs(i2 - point.y);
                    if (abs == 0) {
                        break;
                    } else if (abs >= i6 || i3 == i2) {
                        abs = i6;
                        i2 = i5;
                        i3 = i4;
                    }
                }
                i7++;
                i6 = abs;
                i5 = i2;
                i4 = i3;
            }
            if (i3 <= 0 || i2 <= 0) {
                AppMethodBeat.o(239640);
                return null;
            }
            Point point2 = new Point(i3, i2);
            AppMethodBeat.o(239640);
            return point2;
        }
    }

    static {
        AppMethodBeat.i(239652);
        AppMethodBeat.o(239652);
    }
}

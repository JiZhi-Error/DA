package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Size;
import android.view.SurfaceHolder;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.media.widget.camerarecordview.d.b;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0002\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010j\u001a\u00020;2\u0006\u0010k\u001a\u00020\u0006H\u0016J\u001a\u0010l\u001a\u00020;2\b\u0010m\u001a\u0004\u0018\u00010n2\u0006\u0010o\u001a\u00020;H\u0016J\b\u0010p\u001a\u00020\u0006H\u0016J\b\u0010q\u001a\u00020;H&J\u0006\u0010r\u001a\u00020,J\u0015\u0010s\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010tH&¢\u0006\u0002\u0010uJ\u0018\u0010v\u001a\u00020;2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010w\u001a\u00020;H\u0016J\u0010\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020\u001dH\u0016J\u0006\u0010{\u001a\u00020;J\b\u0010|\u001a\u00020;H\u0016J\b\u0010}\u001a\u00020yH\u0016J\b\u0010~\u001a\u00020yH\u0016J\u0010\u0010\u001a\u00020;2\u0006\u0010J\u001a\u00020\u0006H\u0016J\u001b\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u0006H\u0016J\u0014\u0010\u0001\u001a\u00020y2\t\u0010\u0001\u001a\u0004\u0018\u000102H\u0016J\u0012\u0010\u0001\u001a\u00020;2\u0007\u0010\u0001\u001a\u00020\fH\u0016J\u001b\u0010\u0001\u001a\u00020;2\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u0006H&J\u0012\u0010\u0001\u001a\u00020y2\u0007\u0010\u0001\u001a\u00020;H\u0016J\t\u0010\u0001\u001a\u00020yH\u0004J#\u0010\u0001\u001a\u00020y2\b\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010g\u001a\u00020;2\u0006\u0010J\u001a\u00020\u0006H\u0017J$\u0010\u0001\u001a\u00020y2\t\u0010\u0001\u001a\u0004\u0018\u00010Y2\u0006\u0010g\u001a\u00020;2\u0006\u0010J\u001a\u00020\u0006H\u0017J\t\u0010\u0001\u001a\u00020;H\u0016J\u0011\u0010\u0001\u001a\u00020;2\u0006\u0010^\u001a\u00020_H\u0016J\t\u0010\u0001\u001a\u00020;H\u0016J2\u0010\u0001\u001a\u00020;2'\u0010\u0001\u001a\"\u0012\u0017\u0012\u00150\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020y0\u0001H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0012XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0004R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010\u0010R\u000e\u0010:\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010=\"\u0004\bA\u0010?R\u001a\u0010B\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010=\"\u0004\bC\u0010?R\u001a\u0010D\u001a\u00020EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\b\"\u0004\bL\u0010MR\u001a\u0010N\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\b\"\u0004\bP\u0010MR\u0014\u0010Q\u001a\u00020RX\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\b\"\u0004\bW\u0010MR\u001c\u0010X\u001a\u0004\u0018\u00010YX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001c\u0010^\u001a\u0004\u0018\u00010_X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010=\"\u0004\bf\u0010?R\u001a\u0010g\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010=\"\u0004\bi\u0010?¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CROP_PREVIEW_THRESHOLD", "", "getCROP_PREVIEW_THRESHOLD", "()I", "DEFAULT_UPPER_BOUND", "getDEFAULT_UPPER_BOUND", "SMALL_ZOOM_STEP_VAL", "", "getSMALL_ZOOM_STEP_VAL", "()F", "setSMALL_ZOOM_STEP_VAL", "(F)V", "TAG", "", "TAG_SETTING", "getTAG_SETTING", "()Ljava/lang/String;", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "cameraDeviceConfig", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "getCameraDeviceConfig", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "setCameraDeviceConfig", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;)V", "cameraStatus", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "getCameraStatus", "()Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "setCameraStatus", "(Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "cropSize", "Landroid/graphics/Point;", "getCropSize", "()Landroid/graphics/Point;", "setCropSize", "(Landroid/graphics/Point;)V", "customDisplayScreenSize", "Landroid/util/Size;", "getCustomDisplayScreenSize", "()Landroid/util/Size;", "setCustomDisplayScreenSize", "(Landroid/util/Size;)V", "displayRatio", "getDisplayRatio", "setDisplayRatio", "hasShownErrorTip", "", "isCameraOpen", "()Z", "setCameraOpen", "(Z)V", "isReturnFrameCallbackAny", "setReturnFrameCallbackAny", "isZooming", "setZooming", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "getParams", "()Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "setParams", "(Lcom/tencent/mm/plugin/mmsight/model/RecordParams;)V", "resolutionLimit", "getResolutionLimit", "setResolutionLimit", "(I)V", "scrollSmallZoomStep", "getScrollSmallZoomStep", "setScrollSmallZoomStep", "sightHandler", "Lcom/tencent/mm/media/widget/camera/common/CameraHandler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera/common/CameraHandler;", "smallZoomStep", "getSmallZoomStep", "setSmallZoomStep", "surfaceHolder", "Landroid/view/SurfaceHolder;", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "(Landroid/view/SurfaceHolder;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "useBackCamera", "getUseBackCamera", "setUseBackCamera", "useCpuCrop", "getUseCpuCrop", "setUseCpuCrop", "checkCameraOpenSucc", "scene", "focusOnFace", "faceLocation", "", "isClickScreen", "getCameraPreviewFps", "getCameraSensorRotate", "getDisplaySize", "getSupportPreviewSize", "", "()[Landroid/util/Size;", "initCamera", "useBack", "initCameraDeviceConfig", "", "deviceConfig", "isBackCamera", "isCameraPreviewing", "onDestroy", "release", "selectNoCropPreviewSize", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setDisplayScreenSize", "screenSize", "setPreviewDisplayRatio", "ratio", "setPreviewSize", "width", "height", "setReturnFrameCallback", "value", "showCameraErrorTips", "startPreview", "surface", "switchCamera", "switchRecordStream", "takePhoto", "dataCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "CameraStatus", "plugin-mediaeditor_release"})
public abstract class a implements d {
    private final String TAG = "MicroMsg.BaseCommonCamera";
    protected boolean aYc;
    private SurfaceHolder beb;
    protected Context context;
    protected b hAu;
    protected final String ilH = "MicroMsg.MMSightCameraSetting";
    protected final int ilI = 2100;
    private final int ilJ = 8;
    public final com.tencent.mm.media.widget.a.a.a ilK;
    private boolean ilL;
    protected boolean ilM;
    private EnumC0424a ilN;
    protected boolean ilO;
    float ilP;
    boolean ilQ;
    protected q ilR;
    protected b.a ilS;
    private int ilT;
    Size ilU;
    protected Point ilV;
    protected int ilW;
    int ilX;
    protected boolean ilY;
    protected SurfaceTexture surfaceTexture;

    public abstract boolean aPh();

    public abstract Size[] aPi();

    public abstract boolean dg(int i2, int i3);

    public a(Context context2) {
        p.h(context2, "context");
        this.context = context2;
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        this.ilK = new com.tencent.mm.media.widget.a.a.a(mainLooper, this.context, this);
        this.ilM = true;
        this.ilN = EnumC0424a.CAMERA_IS_DEFAULT;
        this.ilO = true;
        q ejT = q.ejT();
        p.g(ejT, "RecordParams.getBigSightDefault()");
        this.ilR = ejT;
        this.hAu = b.imh;
        this.ilT = 40000;
        this.ilW = -1;
        this.ilX = -1;
    }

    /* access modifiers changed from: protected */
    public final void a(EnumC0424a aVar) {
        p.h(aVar, "<set-?>");
        this.ilN = aVar;
    }

    /* access modifiers changed from: protected */
    public final void aPa() {
        if (!this.ilL && this.context != null) {
            if (!n.I(Build.MANUFACTURER, "meizu", true) || com.tencent.mm.compatible.e.b.apj()) {
                pl plVar = new pl();
                plVar.dVC.type = 2;
                EventCenter.instance.publish(plVar);
                if (plVar.dVD.dVB) {
                    this.ilL = true;
                    return;
                }
                d n = h.n(this.context, R.string.h16, R.string.zb);
                if (n != null) {
                    n.setCancelable(false);
                    n.setCanceledOnTouchOutside(false);
                    n.show();
                    this.ilL = true;
                }
            }
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public boolean v(Context context2, boolean z) {
        p.h(context2, "context");
        this.ilM = z;
        return true;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public void a(SurfaceTexture surfaceTexture2, boolean z, int i2) {
        this.surfaceTexture = surfaceTexture2;
        this.ilO = z;
        this.ilT = i2;
    }

    public void a(SurfaceHolder surfaceHolder, boolean z, int i2) {
        this.beb = surfaceHolder;
        this.ilO = z;
        this.ilT = i2;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final boolean aPb() {
        boolean z = false;
        if (this.surfaceTexture == null && this.beb == null) {
            Log.e(this.TAG, " do you forget override func startPreview");
            return false;
        } else if (!aPc()) {
            Log.e(this.TAG, " now is cpature image and refuse to switchCamera");
            return false;
        } else {
            release();
            Context context2 = this.context;
            if (context2 == null) {
                p.hyc();
            }
            if (!this.ilM) {
                z = true;
            }
            v(context2, z);
            Log.i(this.TAG, "useCpuCrop : " + this.ilO + " , resolutionLimit: " + this.ilT);
            if (this.surfaceTexture == null) {
                SurfaceHolder surfaceHolder = this.beb;
                if (surfaceHolder == null) {
                    p.hyc();
                }
                a(surfaceHolder, this.ilO, this.ilT);
                return this.ilM;
            }
            SurfaceTexture surfaceTexture2 = this.surfaceTexture;
            if (surfaceTexture2 == null) {
                p.hyc();
            }
            a(surfaceTexture2, this.ilO, this.ilT);
            return this.ilM;
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public void release() {
        this.ilN = EnumC0424a.CAMERA_IS_DEFAULT;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void onDestroy() {
        com.tencent.mm.media.widget.a.a.a aVar = this.ilK;
        com.tencent.mm.media.widget.b.d dVar = aVar.imN;
        if (dVar != null) {
            dVar.release();
        }
        HandlerThread handlerThread = aVar.imL;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final boolean aPc() {
        return this.ilN == EnumC0424a.CAMERA_IS_PREVIEWING;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public boolean n(kotlin.g.a.b<? super Bitmap, x> bVar) {
        p.h(bVar, "dataCallback");
        return false;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public boolean aPd() {
        return false;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void setDisplayScreenSize(Size size) {
        this.ilU = size;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void aPe() {
        this.ilQ = true;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void a(b.a aVar) {
        p.h(aVar, "deviceConfig");
        this.ilS = aVar;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public int aPf() {
        return 0;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public boolean rp(int i2) {
        return false;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public int df(int i2, int i3) {
        return 0;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public boolean aPg() {
        return false;
    }

    public boolean rq(int i2) {
        try {
            boolean aPh = aPh();
            Point aPj = aPj();
            Size[] aPi = aPi();
            if (aPi == null) {
                Log.e(this.TAG, "fuck, preview size null!!");
                return false;
            }
            h.c b2 = com.tencent.mm.plugin.mmsight.model.h.b(aPi, aPj, i2, aPh);
            if (b2.zum == null) {
                Log.e(this.TAG, "fuck, preview size still null!!");
                b2 = com.tencent.mm.plugin.mmsight.model.h.a(aPi, new Point(Math.min(aPj.x, aPj.y), Math.max(aPj.x, aPj.y)), this.ilI, aPh);
            }
            if (b2.zum == null) {
                Log.i(this.TAG, "checkMore start %s", b2.toString());
                b2.zum = b2.zup;
                b2.zun = b2.zuq;
                b2.zuo = b2.zur;
            }
            Size size = new Size(b2.zum.x, b2.zum.y);
            this.ilR.sUz = size.getWidth();
            this.ilR.sUA = size.getHeight();
            if (b2.zuo != null) {
                this.ilV = b2.zuo;
            }
            dg(size.getWidth(), size.getHeight());
            Log.i(this.TAG, "final set camera preview size: " + size + ", cropSize: " + this.ilV);
            return true;
        } catch (CameraAccessException e2) {
            Log.printErrStackTrace(this.TAG, e2, "selectNoCropPreviewSize Exception by camera access exception, %s, %s", Looper.myLooper(), e2.getMessage());
            return false;
        } catch (Exception e3) {
            Log.printErrStackTrace(this.TAG, e3, "selectNoCropPreviewSize Exception, %s, %s", Looper.myLooper(), e3.getMessage());
            return false;
        }
    }

    public final Point aPj() {
        if (this.ilU == null) {
            Point gx = com.tencent.mm.plugin.mmsight.d.gx(this.context);
            p.g(gx, "MMSightUtil.getDisplaySize(context)");
            return gx;
        }
        Size size = this.ilU;
        if (size == null) {
            p.hyc();
        }
        int width = size.getWidth();
        Size size2 = this.ilU;
        if (size2 == null) {
            p.hyc();
        }
        return new Point(width, size2.getHeight());
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "CAMERA_IS_DEFAULT", "CAMERA_IS_PREVIEWING", "CAMERA_IS_CAPTURING", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.a.a$a  reason: collision with other inner class name */
    public enum EnumC0424a {
        CAMERA_IS_DEFAULT(-1),
        CAMERA_IS_PREVIEWING(0),
        CAMERA_IS_CAPTURING(1);
        
        private final int status;

        public static EnumC0424a valueOf(String str) {
            AppMethodBeat.i(94007);
            EnumC0424a aVar = (EnumC0424a) Enum.valueOf(EnumC0424a.class, str);
            AppMethodBeat.o(94007);
            return aVar;
        }

        private EnumC0424a(int i2) {
            this.status = i2;
        }

        static {
            AppMethodBeat.i(94005);
            AppMethodBeat.o(94005);
        }
    }
}

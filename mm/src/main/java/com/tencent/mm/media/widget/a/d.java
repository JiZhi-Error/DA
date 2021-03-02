package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.d.b;
import com.tencent.mm.plugin.mmsight.model.g;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 h2\u00020\u0001:\u0001hJ\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H&J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H&J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0012H&J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H&J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015H&J\u001a\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u0004H&J\n\u0010)\u001a\u0004\u0018\u00010*H&J\b\u0010+\u001a\u00020 H&J\b\u0010,\u001a\u00020\u0012H&J\b\u0010-\u001a\u00020\u0012H&J\b\u0010.\u001a\u00020\u0012H&J\b\u0010/\u001a\u00020\u0012H&J\u0012\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u00020\u0004H&J\n\u00103\u001a\u0004\u0018\u000104H&J\u0018\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0004H&J\u0010\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020;H&J\b\u0010<\u001a\u00020\u0004H&J\b\u0010=\u001a\u00020\bH&J0\u0010>\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@H&J\b\u0010A\u001a\u00020\bH&J\b\u0010B\u001a\u00020\bH&J\u0012\u0010C\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0018\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\u0012H&J\u0010\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u0012H&J\u0012\u0010I\u001a\u00020\b2\b\u0010J\u001a\u0004\u0018\u00010KH&J\u0010\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u0012H&J\u0010\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\u0004H&J\u0010\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\u0017H&J\u0010\u0010R\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u0017H&J\u0010\u0010S\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0004H&J&\u0010T\u001a\u00020\b2\b\u0010U\u001a\u0004\u0018\u00010V2\b\b\u0002\u0010W\u001a\u00020\u00042\b\b\u0002\u0010X\u001a\u00020\u0012H&J&\u0010T\u001a\u00020\b2\b\u0010Y\u001a\u0004\u0018\u00010Z2\b\b\u0002\u0010W\u001a\u00020\u00042\b\b\u0002\u0010X\u001a\u00020\u0012H&J\b\u0010[\u001a\u00020\u0004H&J\u0010\u0010[\u001a\u00020\u00042\u0006\u0010U\u001a\u00020VH&J\b\u0010\\\u001a\u00020\u0004H&J\u0018\u0010]\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010^\u001a\u00020\u0004H&J+\u0010_\u001a\u00020\u00042!\u0010`\u001a\u001d\u0012\u0013\u0012\u00110a¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020\b0\u0003H&J\b\u0010c\u001a\u00020\u0004H&J \u0010d\u001a\u00020\b2\u0006\u0010e\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\u0012H&R5\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006i"}, hxF = {"Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "", "onHDRCheckerResult", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "", "stepInterval", "calculateTapArea", "Landroid/graphics/Rect;", "x", "", "y", "coefficient", "surfaceWidth", "surfaceHeight", "checkCameraOpenSucc", "scene", "configVendorTagValue", "tag", "", "value", "focusOnArea", "focusArea", "meteringArea", "focusOnFace", "faceLocation", "", "isClickScreen", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraCurrentFocusMode", "getCameraOrientation", "getCameraPreviewFps", "getCurrentCameraId", "getFlashMode", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getSupportZoomRatios", "", "initCamera", "context", "Landroid/content/Context;", "useBack", "initCameraDeviceConfig", "deviceConfig", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "isCameraPreviewing", "onDestroy", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setCameraPreviewFps", "fpsValue", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setPreviewDisplayRatio", "setReturnFrameCallback", "startPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "useCpuCrop", "resolutionLimit", "surface", "Landroid/view/SurfaceHolder;", "switchCamera", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public interface d {
    public static final a imA = a.imB;

    void B(String str, boolean z);

    Rect a(float f2, float f3, float f4, int i2, int i3);

    void a(SurfaceTexture surfaceTexture, boolean z, int i2);

    void a(b.a aVar);

    void a(g gVar);

    boolean aPb();

    boolean aPc();

    boolean aPd();

    void aPe();

    int aPf();

    boolean aPg();

    void aPq();

    b aPr();

    int aPu();

    int aPv();

    String aPw();

    boolean aPx();

    void ad(String str, int i2);

    void b(float f2, float f3, int i2, int i3);

    void b(g gVar);

    boolean b(Rect rect, Rect rect2);

    int df(int i2, int i3);

    Point fa(boolean z);

    void fb(boolean z);

    int getFlashMode();

    float[] getSupportZoomRatios();

    void i(boolean z, int i2);

    boolean n(kotlin.g.a.b<? super Bitmap, x> bVar);

    void o(kotlin.g.a.b<? super Boolean, x> bVar);

    void onDestroy();

    void release();

    boolean rp(int i2);

    void rw(int i2);

    void setDisplayScreenSize(Size size);

    void setFlashMode(int i2);

    void setForceZoomTargetRatio(float f2);

    boolean v(Context context, boolean z);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/widget/camera/ICommonCamera$Companion;", "", "()V", "MAX_RESOLUTION", "", "plugin-mediaeditor_release"})
    public static final class a {
        static final /* synthetic */ a imB = new a();

        static {
            AppMethodBeat.i(94060);
            AppMethodBeat.o(94060);
        }

        private a() {
        }
    }
}

package com.tencent.mm.plugin.voip.video.camera.a;

import android.graphics.SurfaceTexture;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.plugin.appbrand.jsapi.p.an;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H&J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\u000eH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0013\u001a\u00020\u000eH&J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH&J\b\u0010\u0018\u001a\u00020\fH&J\b\u0010\u0019\u001a\u00020\fH&J\b\u0010\u001a\u001a\u00020\fH&J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000eH&J\b\u0010\u001d\u001a\u00020\u0004H&J\b\u0010\u001e\u001a\u00020\u000eH&J\b\u0010\u001f\u001a\u00020\u0004H&¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/voip/video/camera/common/BaseCaptureRenderer;", "", "()V", "bind", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "exchangeCapture", "focusOnFace", "faceLocation", "", "isClickScreen", "", "getCameraErrCode", "", "getCurrentCameraIsFace", "getDisplayOrientation", "getPreviewSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "getRotateAngle", "initCapture", "dataCallback", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "bFaceFirst", "isCameraRemote180", "isMirror", "isPreviewing", "onOrientationChange", "rotation", an.NAME, "startCapture", "stopCapture", "plugin-voip_release"})
public abstract class a {
    public abstract int a(b bVar, boolean z);

    public abstract boolean dEO();

    public abstract void eoc();

    public abstract boolean fKY();

    public abstract boolean fKZ();

    public abstract int fLa();

    public abstract int fLb();

    public abstract ac fLc();

    public abstract void fLd();

    public abstract int fLe();

    public abstract boolean fLf();

    public abstract void fLg();

    public abstract int fLh();

    public abstract void fLi();

    public abstract void onOrientationChange(int i2);

    public abstract void q(SurfaceTexture surfaceTexture);
}

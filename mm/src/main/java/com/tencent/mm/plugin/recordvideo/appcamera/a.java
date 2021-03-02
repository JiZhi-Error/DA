package com.tencent.mm.plugin.recordvideo.appcamera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.api.recordView.g;
import com.tencent.mm.plugin.api.recordView.i;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.rtmp.TXLiveConstants;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 x2\u00020\u00012\u00020\u0002:\u0001xB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u00100\u001a\u00020\u0007J\b\u00101\u001a\u0004\u0018\u000102J\u0006\u00103\u001a\u00020\u0011J\u0006\u00104\u001a\u00020\u0007J\u0006\u00105\u001a\u00020\u0011J\u0006\u00106\u001a\u00020\u0011J\b\u00107\u001a\u00020\u0007H\u0002J\b\u00108\u001a\u0004\u0018\u000109J\u0006\u0010:\u001a\u00020\u0011J \u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BJ\u0018\u0010;\u001a\u00020<2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\u0016\u0010G\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010H\u001a\u00020IJ0\u0010G\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010J\u001a\u00020I2\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007J\u0006\u0010O\u001a\u00020\u0019J\u0010\u0010P\u001a\u00020\u00192\b\u0010Q\u001a\u0004\u0018\u00010RJ\b\u0010S\u001a\u00020<H\u0016J\b\u0010T\u001a\u00020<H\u0016J\b\u0010U\u001a\u00020<H\u0016J\u000e\u0010V\u001a\u00020<2\u0006\u0010=\u001a\u00020>J\u000e\u0010W\u001a\u00020<2\u0006\u0010X\u001a\u00020@J\u000e\u0010Y\u001a\u00020<2\u0006\u0010Z\u001a\u00020\u0007J\u000e\u0010[\u001a\u00020<2\u0006\u0010\\\u001a\u00020\u000bJ\u001a\u0010]\u001a\u00020<2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010`\u001a\u0004\u0018\u00010aJ\u0010\u0010b\u001a\u00020<2\b\u0010c\u001a\u0004\u0018\u00010\u0013J\u0010\u0010d\u001a\u00020<2\b\u0010c\u001a\u0004\u0018\u00010\u0015J\u0010\u0010e\u001a\u00020<2\b\u0010c\u001a\u0004\u0018\u00010\u0017J\u0018\u0010f\u001a\u00020<2\b\u0010c\u001a\u0004\u0018\u00010\u001c2\u0006\u0010g\u001a\u00020\u0019J\u000e\u0010h\u001a\u00020<2\u0006\u0010i\u001a\u00020\u0007J\u000e\u0010j\u001a\u00020<2\u0006\u0010k\u001a\u00020\u0007J\u0010\u0010l\u001a\u00020<2\b\u0010m\u001a\u0004\u0018\u00010\u001eJ\b\u0010n\u001a\u00020<H\u0002J\u000e\u0010o\u001a\u00020<2\u0006\u0010c\u001a\u00020pJ\u000e\u0010q\u001a\u00020<2\u0006\u0010r\u001a\u00020\u0019J\u001a\u0010s\u001a\u00020<2\u0006\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010wH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MODE_CROP_CENTER", "", "MODE_CROP_TOP", "cropMode", "displayRatio", "", "getDisplayRatio", "()F", "setDisplayRatio", "(F)V", "drawSizePoint", "Landroid/graphics/Point;", "frameDataImageCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$CameraFrameDataCallback;", "initDoneCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitDoneCallback;", "initErrorCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitErrorCallback;", "mIsUseBackCamera", "", "mOpenFlash", "mPictureCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$PictureTakenCallback;", "mRecordStopCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$StopRecordCallback;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "process", "Lcom/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess;", "recordTextureView", "Lcom/tencent/mm/plugin/api/recordView/MMSightCameraGLSurfaceView;", "renderToRBGBufferThread", "Lcom/tencent/mm/plugin/api/recordView/YUVDateRenderToRBGBufferThread;", "rgbSizeLimit", "touchListener", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener;", "windowManager", "Landroid/view/WindowManager;", "getCameraRotation", "getCurrentFramePicture", "Landroid/graphics/Bitmap;", "getDrawSizePoint", "getFlashMode", "getPictureSize", "getPreviewSize", "getScreenRotation", "getSupportZoomRatios", "", "getVideoSize", "initLogic", "", "para", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "videoPath", "", "displayScreenSize", "Landroid/util/Size;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "initView", "viewGroup", "Landroid/view/ViewGroup;", "view", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "isFrontCamera", "onFrameData", "data", "", "onPause", "onResume", "release", "resetVideoPara", "resetVideoPath", "path", "setFlashMode", "flashMode", "setForceZoomTargetRatio", "ratio", "setFrameBuffer", "buffer", "Ljava/nio/ByteBuffer;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$OnDateUpdateListener;", "setFrameDataCallback", "callback", "setInitDoneCallback", "setInitErrorCallback", "setPictureCallback", "openFlash", "setPreviewMode", "mode", "setRGBSizeLimit", "limit", "setRecordCallback", "stopCallback", "setRenderThreadFrameInfo", "setTouchListener", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener$TouchCallback;", "setUseBackCamera", "back", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class a extends BasePluginLayout implements com.tencent.mm.plugin.recordvideo.plugin.parent.d {
    public static final C1636a BJO = new C1636a((byte) 0);
    static final String TAG = TAG;
    private final int BJF;
    private final int BJG = 1;
    com.tencent.mm.plugin.recordvideo.b.a BJH;
    com.tencent.mm.media.widget.camerarecordview.a BJI;
    MMSightRecordView.g BJJ;
    private MMSightRecordView.h BJK;
    private MMSightRecordView.a BJL;
    boolean BJM = true;
    boolean BJN;
    private float ilP;
    com.tencent.mm.plugin.api.recordView.g kyH;
    private MMSightRecordView.d kyI;
    private MMSightRecordView.c kyJ;
    com.tencent.mm.plugin.api.recordView.h kyM;
    private final Point kyN = new Point(0, 0);
    private int kyr;
    private int kys = this.BJF;
    MMSightCameraGLSurfaceView kyw;
    com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
    CameraPreviewGLSurfaceView wcV;
    private WindowManager windowManager;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Bitmap, x> {
        final /* synthetic */ a BJP;
        final /* synthetic */ z.f BJQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, z.f fVar) {
            super(1);
            this.BJP = aVar;
            this.BJQ = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bitmap bitmap) {
            AppMethodBeat.i(75079);
            T t = (T) bitmap;
            if (t != null) {
                com.tencent.mm.plugin.mmsight.model.d dVar = this.BJP.orientationEventListener;
                if (dVar == null) {
                    p.hyc();
                }
                float ejw = (float) dVar.ejw();
                boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_photo_align_long_side, true);
                if (ae.gKA.gJq != -1) {
                    if (ae.gKA.gJq == 0) {
                        a2 = false;
                    } else if (ae.gKA.gJq == 1) {
                        a2 = true;
                    }
                }
                if (a2) {
                    if (t.getHeight() > t.getWidth()) {
                        if (((float) t.getHeight()) > 1920.0f) {
                            float height = 1920.0f / ((float) t.getHeight());
                            t = (T) BitmapUtil.rotateAndScale(t, ejw, height, height);
                        } else if (ejw != 0.0f) {
                            t = (T) BitmapUtil.rotate(t, ejw);
                        }
                    } else if (((float) t.getWidth()) > 1920.0f) {
                        float width = 1920.0f / ((float) t.getWidth());
                        t = (T) BitmapUtil.rotateAndScale(t, ejw, width, width);
                    } else if (ejw != 0.0f) {
                        t = (T) BitmapUtil.rotate(t, ejw);
                    }
                } else if (t.getHeight() > t.getWidth()) {
                    if (((float) t.getWidth()) > 1080.0f) {
                        float width2 = 1080.0f / ((float) t.getWidth());
                        t = (T) BitmapUtil.rotateAndScale(t, ejw, width2, width2);
                    } else if (ejw != 0.0f) {
                        t = (T) BitmapUtil.rotate(t, ejw);
                    }
                } else if (((float) t.getHeight()) > 1080.0f) {
                    float height2 = 1080.0f / ((float) t.getHeight());
                    t = (T) BitmapUtil.rotateAndScale(t, ejw, height2, height2);
                } else if (ejw != 0.0f) {
                    t = (T) BitmapUtil.rotate(t, ejw);
                }
                this.BJQ.SYG = t;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75079);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "data", "", "invoke"})
    static final class c extends q implements kotlin.g.a.b {
        final /* synthetic */ a BJP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(1);
            this.BJP = aVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Object invoke(Object obj) {
            AppMethodBeat.i(75080);
            byte[] bArr = (byte[]) obj;
            p.h(bArr, "data");
            this.BJP.ai(bArr);
            AppMethodBeat.o(75080);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class d extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ a BJP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(1);
            this.BJP = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            EGLContext eGLContext = null;
            AppMethodBeat.i(75083);
            if (bool.booleanValue()) {
                a.a(this.BJP);
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.BJP.kyw;
                if ((mMSightCameraGLSurfaceView != null ? mMSightCameraGLSurfaceView.getEglContext() : null) == null) {
                    MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView2 = this.BJP.kyw;
                    if (mMSightCameraGLSurfaceView2 != null) {
                        mMSightCameraGLSurfaceView2.setOnEglEnableListener(new MMSightCameraGLSurfaceView.c(this) {
                            /* class com.tencent.mm.plugin.recordvideo.appcamera.a.d.AnonymousClass1 */
                            final /* synthetic */ d BJR;

                            {
                                this.BJR = r1;
                            }

                            @Override // com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView.c
                            public final void enable() {
                                AppMethodBeat.i(75081);
                                if (this.BJR.BJP.kyM != null) {
                                    com.tencent.mm.plugin.api.recordView.h hVar = this.BJR.BJP.kyM;
                                    if (hVar != null) {
                                        MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.BJR.BJP.kyw;
                                        hVar.b(mMSightCameraGLSurfaceView != null ? mMSightCameraGLSurfaceView.getEglContext() : null);
                                    }
                                    MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView2 = this.BJR.BJP.kyw;
                                    if (mMSightCameraGLSurfaceView2 != null) {
                                        mMSightCameraGLSurfaceView2.setVisibility(0);
                                    }
                                } else {
                                    MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView3 = this.BJR.BJP.kyw;
                                    if (mMSightCameraGLSurfaceView3 != null) {
                                        mMSightCameraGLSurfaceView3.setVisibility(8);
                                    }
                                }
                                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView4 = this.BJR.BJP.kyw;
                                if (mMSightCameraGLSurfaceView4 != null) {
                                    mMSightCameraGLSurfaceView4.setOnEglEnableListener(null);
                                    AppMethodBeat.o(75081);
                                    return;
                                }
                                AppMethodBeat.o(75081);
                            }
                        });
                    }
                } else if (this.BJP.kyM != null) {
                    com.tencent.mm.plugin.api.recordView.h hVar = this.BJP.kyM;
                    if (hVar != null) {
                        MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView3 = this.BJP.kyw;
                        if (mMSightCameraGLSurfaceView3 != null) {
                            eGLContext = mMSightCameraGLSurfaceView3.getEglContext();
                        }
                        hVar.b(eGLContext);
                    }
                    MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView4 = this.BJP.kyw;
                    if (mMSightCameraGLSurfaceView4 != null) {
                        mMSightCameraGLSurfaceView4.setVisibility(0);
                    }
                } else {
                    MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView5 = this.BJP.kyw;
                    if (mMSightCameraGLSurfaceView5 != null) {
                        mMSightCameraGLSurfaceView5.setVisibility(8);
                    }
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable(this) {
                    /* class com.tencent.mm.plugin.recordvideo.appcamera.a.d.AnonymousClass2 */
                    final /* synthetic */ d BJR;

                    {
                        this.BJR = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(75082);
                        MMSightRecordView.c cVar = this.BJR.BJP.kyJ;
                        if (cVar != null) {
                            cVar.bFX();
                            AppMethodBeat.o(75082);
                            return;
                        }
                        AppMethodBeat.o(75082);
                    }
                }, 100);
            } else {
                MMSightRecordView.d dVar = this.BJP.kyI;
                if (dVar != null) {
                    dVar.bFW();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75083);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "data", "", "invoke"})
    static final class e extends q implements kotlin.g.a.b {
        final /* synthetic */ a BJP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar) {
            super(1);
            this.BJP = aVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Object invoke(Object obj) {
            AppMethodBeat.i(75084);
            byte[] bArr = (byte[]) obj;
            p.h(bArr, "data");
            this.BJP.ai(bArr);
            AppMethodBeat.o(75084);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class f extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ a BJP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar) {
            super(1);
            this.BJP = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(75085);
            if (bool.booleanValue()) {
                a.a(this.BJP);
                if (com.tencent.mm.plugin.recordvideo.b.g.isInit()) {
                    com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJP.BJI;
                    if (aVar == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.recordvideo.b.g.j(aVar.fi(true));
                }
            } else {
                MMSightRecordView.d dVar = this.BJP.kyI;
                if (dVar != null) {
                    dVar.bFW();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75085);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
    static final class i extends q implements kotlin.g.a.b<Bitmap, x> {
        final /* synthetic */ a BJP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(a aVar) {
            super(1);
            this.BJP = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bitmap bitmap) {
            AppMethodBeat.i(75089);
            Bitmap bitmap2 = bitmap;
            com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJP.BJI;
            if (aVar == null) {
                p.hyc();
            }
            aVar.fj(false);
            if (bitmap2 == null) {
                MMSightRecordView.g gVar = this.BJP.BJJ;
                if (gVar != null) {
                    gVar.bFZ();
                }
                Log.e(a.TAG, "record picture error cause null bitmap ");
            } else if (this.BJP.kys != this.BJP.BJG) {
                com.tencent.mm.plugin.mmsight.model.d dVar = this.BJP.orientationEventListener;
                if (dVar == null) {
                    p.hyc();
                }
                float ejw = (float) dVar.ejw();
                boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_photo_align_long_side, true);
                if (ae.gKA.gJq != -1) {
                    if (ae.gKA.gJq == 0) {
                        a2 = false;
                    } else if (ae.gKA.gJq == 1) {
                        a2 = true;
                    }
                }
                if (a2) {
                    if (bitmap2.getHeight() > bitmap2.getWidth()) {
                        if (((float) bitmap2.getHeight()) > 1920.0f) {
                            float height = 1920.0f / ((float) bitmap2.getHeight());
                            bitmap2 = BitmapUtil.rotateAndScale(bitmap2, ejw, height, height);
                        } else if (ejw != 0.0f) {
                            bitmap2 = BitmapUtil.rotate(bitmap2, ejw);
                        }
                    } else if (((float) bitmap2.getWidth()) > 1920.0f) {
                        float width = 1920.0f / ((float) bitmap2.getWidth());
                        bitmap2 = BitmapUtil.rotateAndScale(bitmap2, ejw, width, width);
                    } else if (ejw != 0.0f) {
                        bitmap2 = BitmapUtil.rotate(bitmap2, ejw);
                    }
                } else if (bitmap2.getHeight() > bitmap2.getWidth()) {
                    if (((float) bitmap2.getWidth()) > 1080.0f) {
                        float width2 = 1080.0f / ((float) bitmap2.getWidth());
                        bitmap2 = BitmapUtil.rotateAndScale(bitmap2, ejw, width2, width2);
                    } else if (ejw != 0.0f) {
                        bitmap2 = BitmapUtil.rotate(bitmap2, ejw);
                    }
                } else if (((float) bitmap2.getHeight()) > 1080.0f) {
                    float height2 = 1080.0f / ((float) bitmap2.getHeight());
                    bitmap2 = BitmapUtil.rotateAndScale(bitmap2, ejw, height2, height2);
                } else if (ejw != 0.0f) {
                    bitmap2 = BitmapUtil.rotate(bitmap2, ejw);
                }
                MMSightRecordView.g gVar2 = this.BJP.BJJ;
                if (gVar2 != null) {
                    gVar2.R(bitmap2);
                }
            } else {
                MMSightRecordView.g gVar3 = this.BJP.BJJ;
                if (gVar3 != null) {
                    gVar3.R(bitmap2);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75089);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
    static final class j extends q implements kotlin.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, x> {
        final /* synthetic */ a BJP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(a aVar) {
            super(1);
            this.BJP = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
            AppMethodBeat.i(75090);
            p.h(bVar, LocaleUtil.ITALIAN);
            MMSightRecordView.h hVar = this.BJP.BJK;
            if (hVar != null) {
                hVar.hs(false);
            }
            com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJP.BJI;
            if (aVar != null) {
                aVar.aQf();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(75090);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, null);
        p.h(context, "context");
        AppMethodBeat.i(75109);
        AppMethodBeat.o(75109);
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(75111);
        aVar.bqS();
        AppMethodBeat.o(75111);
    }

    public final float getDisplayRatio() {
        return this.ilP;
    }

    public final void setDisplayRatio(float f2) {
        this.ilP = f2;
    }

    /* access modifiers changed from: package-private */
    public final void bqS() {
        AppMethodBeat.i(75091);
        Point previewSize = getPreviewSize();
        this.kyN.y = this.kyr;
        this.kyN.x = (previewSize.x * this.kyr) / previewSize.y;
        if (getScreenRotation() == 0 || getScreenRotation() == 180) {
            int i2 = this.kyN.y;
            this.kyN.y = this.kyN.x;
            this.kyN.x = i2;
        }
        com.tencent.mm.plugin.api.recordView.h hVar = this.kyM;
        if (hVar != null) {
            int i3 = previewSize.x;
            int i4 = previewSize.y;
            com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJI;
            hVar.i(i3, i4, aVar != null ? aVar.aQh() : 0, this.kyN.x, this.kyN.y);
            AppMethodBeat.o(75091);
            return;
        }
        AppMethodBeat.o(75091);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public final void a(d.c cVar, Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(75092);
        p.h(cVar, "status");
        switch (b.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJI;
                if (aVar == null) {
                    p.hyc();
                }
                com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
                if (dVar == null) {
                    p.hyc();
                }
                boolean isLandscape = dVar.isLandscape();
                com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
                if (dVar2 == null) {
                    p.hyc();
                }
                if (!aVar.j(isLandscape, dVar2.getOrientation())) {
                    MMSightRecordView.d dVar3 = this.kyI;
                    if (dVar3 != null) {
                        dVar3.bFW();
                        AppMethodBeat.o(75092);
                        return;
                    }
                    AppMethodBeat.o(75092);
                    return;
                }
                break;
            case 2:
                com.tencent.mm.media.widget.camerarecordview.a aVar2 = this.BJI;
                if (aVar2 == null) {
                    p.hyc();
                }
                if (!aVar2.p(new j(this))) {
                    MMSightRecordView.h hVar = this.BJK;
                    if (hVar != null) {
                        hVar.hs(true);
                    }
                    com.tencent.mm.media.widget.camerarecordview.a aVar3 = this.BJI;
                    if (aVar3 != null) {
                        aVar3.aQf();
                        AppMethodBeat.o(75092);
                        return;
                    }
                    AppMethodBeat.o(75092);
                    return;
                }
                break;
            case 3:
                if (bundle != null) {
                    com.tencent.mm.media.widget.camerarecordview.a aVar4 = this.BJI;
                    if (aVar4 == null) {
                        p.hyc();
                    }
                    aVar4.rz(bundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT"));
                    AppMethodBeat.o(75092);
                    return;
                }
                break;
            case 4:
                if (bundle != null) {
                    com.tencent.mm.media.widget.camerarecordview.a aVar5 = this.BJI;
                    if (aVar5 == null) {
                        p.hyc();
                    }
                    boolean z2 = bundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
                    bundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
                    aVar5.i(z2, bundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT"));
                    AppMethodBeat.o(75092);
                    return;
                }
                break;
            case 5:
                if (bundle != null) {
                    z = bundle.getBoolean("PARAM_PREPARE_CAMERA_IGNORE_FLIP_CHECK_BOOLEAN", false);
                }
                com.tencent.mm.media.widget.camerarecordview.a aVar6 = this.BJI;
                if (aVar6 == null) {
                    p.hyc();
                }
                aVar6.fh(z);
                bqS();
                AppMethodBeat.o(75092);
                return;
            case 6:
                if (bundle != null) {
                    float f2 = bundle.getFloat("PARAM_POINT_X");
                    float f3 = bundle.getFloat("PARAM_POINT_Y");
                    com.tencent.mm.media.widget.camerarecordview.a aVar7 = this.BJI;
                    if (aVar7 == null) {
                        p.hyc();
                    }
                    CameraPreviewGLSurfaceView cameraPreviewGLSurfaceView = this.wcV;
                    if (cameraPreviewGLSurfaceView == null) {
                        p.hyc();
                    }
                    int width = cameraPreviewGLSurfaceView.getWidth();
                    CameraPreviewGLSurfaceView cameraPreviewGLSurfaceView2 = this.wcV;
                    if (cameraPreviewGLSurfaceView2 == null) {
                        p.hyc();
                    }
                    aVar7.b(f2, f3, width, cameraPreviewGLSurfaceView2.getHeight());
                    AppMethodBeat.o(75092);
                    return;
                }
                break;
            case 7:
                com.tencent.mm.media.widget.camerarecordview.a aVar8 = this.BJI;
                if (aVar8 == null) {
                    p.hyc();
                }
                aVar8.fj(this.BJN);
                com.tencent.mm.media.widget.camerarecordview.a aVar9 = this.BJI;
                if (aVar9 == null) {
                    p.hyc();
                }
                aVar9.r(new i(this));
                break;
        }
        AppMethodBeat.o(75092);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onResume() {
        AppMethodBeat.i(75093);
        super.onResume();
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar == null) {
            p.hyc();
        }
        dVar.enable();
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJI;
        if (aVar != null) {
            aVar.q(new e(this));
        }
        com.tencent.mm.media.widget.camerarecordview.a aVar2 = this.BJI;
        if (aVar2 == null) {
            p.hyc();
        }
        aVar2.a(this.BJM, new f(this));
        AppMethodBeat.o(75093);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onPause() {
        AppMethodBeat.i(75094);
        super.onPause();
        Log.i(TAG, "onPause");
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJI;
        if (aVar == null) {
            p.hyc();
        }
        aVar.stopPreview();
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar == null) {
            p.hyc();
        }
        dVar.disable();
        AppMethodBeat.o(75094);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void release() {
        AppMethodBeat.i(75095);
        super.release();
        CameraPreviewGLSurfaceView cameraPreviewGLSurfaceView = this.wcV;
        if (cameraPreviewGLSurfaceView != null) {
            cameraPreviewGLSurfaceView.setOnTouchListener(null);
        }
        CameraPreviewGLSurfaceView cameraPreviewGLSurfaceView2 = this.wcV;
        if (cameraPreviewGLSurfaceView2 != null) {
            cameraPreviewGLSurfaceView2.release();
        }
        this.wcV = null;
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJI;
        if (aVar != null) {
            aVar.release();
        }
        this.BJI = null;
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar != null) {
            dVar.a(null);
        }
        com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
        if (dVar2 != null) {
            dVar2.disable();
        }
        this.orientationEventListener = null;
        this.BJH = null;
        AppMethodBeat.o(75095);
    }

    public final void setRecordCallback(MMSightRecordView.h hVar) {
        this.BJK = hVar;
    }

    public final int getCameraRotation() {
        AppMethodBeat.i(75096);
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJI;
        if (aVar != null) {
            int aQh = aVar.aQh();
            AppMethodBeat.o(75096);
            return aQh;
        }
        AppMethodBeat.o(75096);
        return 90;
    }

    public final void setTouchListener(g.a aVar) {
        AppMethodBeat.i(75097);
        p.h(aVar, "callback");
        this.kyH = new com.tencent.mm.plugin.api.recordView.g();
        com.tencent.mm.plugin.api.recordView.g gVar = this.kyH;
        if (gVar != null) {
            gVar.a(aVar);
            AppMethodBeat.o(75097);
            return;
        }
        AppMethodBeat.o(75097);
    }

    public final void setFrameDataCallback(MMSightRecordView.a aVar) {
        this.BJL = aVar;
    }

    public final void setInitErrorCallback(MMSightRecordView.d dVar) {
        this.kyI = dVar;
    }

    public final void setInitDoneCallback(MMSightRecordView.c cVar) {
        this.kyJ = cVar;
    }

    public final Bitmap getCurrentFramePicture() {
        AppMethodBeat.i(75098);
        z.f fVar = new z.f();
        fVar.SYG = null;
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJI;
        if (aVar == null) {
            p.hyc();
        }
        aVar.r(new b(this, fVar));
        T t = fVar.SYG;
        AppMethodBeat.o(75098);
        return t;
    }

    public final float[] getSupportZoomRatios() {
        AppMethodBeat.i(75099);
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJI;
        if (aVar == null) {
            AppMethodBeat.o(75099);
            return null;
        } else if (aVar.currentState == 0) {
            float[] supportZoomRatios = aVar.hAt.getSupportZoomRatios();
            AppMethodBeat.o(75099);
            return supportZoomRatios;
        } else {
            AppMethodBeat.o(75099);
            return null;
        }
    }

    public final void setForceZoomTargetRatio(float f2) {
        AppMethodBeat.i(75100);
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJI;
        if (aVar != null) {
            if (aVar.currentState == 0) {
                aVar.hAt.setForceZoomTargetRatio(f2);
            }
            AppMethodBeat.o(75100);
            return;
        }
        AppMethodBeat.o(75100);
    }

    public final void setUseBackCamera(boolean z) {
        this.BJM = z;
    }

    public final Point getPictureSize() {
        int i2;
        com.tencent.mm.media.j.a previewRenderer;
        com.tencent.mm.media.j.a previewRenderer2;
        int i3 = 0;
        AppMethodBeat.i(75101);
        com.tencent.mm.plugin.recordvideo.b.a aVar = this.BJH;
        if (aVar == null || (previewRenderer2 = aVar.getPreviewRenderer()) == null) {
            i2 = 0;
        } else {
            i2 = previewRenderer2.hEp;
        }
        com.tencent.mm.plugin.recordvideo.b.a aVar2 = this.BJH;
        if (!(aVar2 == null || (previewRenderer = aVar2.getPreviewRenderer()) == null)) {
            i3 = previewRenderer.hEq;
        }
        Point point = new Point(i2, i3);
        AppMethodBeat.o(75101);
        return point;
    }

    public final Point getVideoSize() {
        int i2;
        com.tencent.mm.media.j.a recordRenderer;
        com.tencent.mm.media.j.a recordRenderer2;
        int i3 = 0;
        AppMethodBeat.i(75102);
        com.tencent.mm.plugin.recordvideo.b.a aVar = this.BJH;
        if (aVar == null || (recordRenderer2 = aVar.getRecordRenderer()) == null) {
            i2 = 0;
        } else {
            i2 = recordRenderer2.hEp;
        }
        com.tencent.mm.plugin.recordvideo.b.a aVar2 = this.BJH;
        if (!(aVar2 == null || (recordRenderer = aVar2.getRecordRenderer()) == null)) {
            i3 = recordRenderer.hEq;
        }
        Point point = new Point(i2, i3);
        AppMethodBeat.o(75102);
        return point;
    }

    public final Point getPreviewSize() {
        Point point;
        AppMethodBeat.i(75103);
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJI;
        if (aVar == null || (point = com.tencent.mm.media.widget.camerarecordview.a.c(aVar)) == null) {
            point = new Point();
        }
        AppMethodBeat.o(75103);
        return point;
    }

    public final Point getDrawSizePoint() {
        return this.kyN;
    }

    public final void setFlashMode(int i2) {
        AppMethodBeat.i(75104);
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJI;
        if (aVar != null) {
            aVar.hAt.setFlashMode(i2);
            AppMethodBeat.o(75104);
            return;
        }
        AppMethodBeat.o(75104);
    }

    public final int getFlashMode() {
        AppMethodBeat.i(75105);
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.BJI;
        if (aVar != null) {
            int flashMode = aVar.hAt.getFlashMode();
            AppMethodBeat.o(75105);
            return flashMode;
        }
        AppMethodBeat.o(75105);
        return 0;
    }

    public final void setRGBSizeLimit(int i2) {
        this.kyr = i2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(75106);
        p.h(aVar, "navigator");
        p.h(recordConfigProvider, "configProvider");
        AppMethodBeat.o(75106);
    }

    public final void setPreviewMode(int i2) {
        this.kys = i2;
    }

    public final boolean ai(byte[] bArr) {
        AppMethodBeat.i(75107);
        if (bArr == null) {
            AppMethodBeat.o(75107);
            return false;
        }
        if (this.kyM != null) {
            int screenRotation = getScreenRotation();
            com.tencent.mm.plugin.api.recordView.h hVar = this.kyM;
            if (hVar != null) {
                hVar.E(bArr, screenRotation);
            }
        }
        if (this.BJL != null) {
            Point previewSize = getPreviewSize();
            MMSightRecordView.a aVar = this.BJL;
            if (aVar != null) {
                aVar.C(bArr, previewSize.x, previewSize.y);
            }
        }
        AppMethodBeat.o(75107);
        return true;
    }

    private final int getScreenRotation() {
        Display display;
        Integer num;
        AppMethodBeat.i(75108);
        if (this.windowManager == null) {
            Object systemService = MMApplicationContext.getContext().getSystemService("window");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.WindowManager");
                AppMethodBeat.o(75108);
                throw tVar;
            }
            this.windowManager = (WindowManager) systemService;
        }
        if (this.windowManager == null) {
            AppMethodBeat.o(75108);
            return 0;
        }
        WindowManager windowManager2 = this.windowManager;
        if (windowManager2 != null) {
            display = windowManager2.getDefaultDisplay();
        } else {
            display = null;
        }
        if (display != null) {
            num = Integer.valueOf(display.getRotation());
        } else {
            num = null;
        }
        if (num == null || num.intValue() != 0) {
            if (num != null && num.intValue() == 1) {
                AppMethodBeat.o(75108);
                return 90;
            } else if (num != null && num.intValue() == 2) {
                AppMethodBeat.o(75108);
                return TXLiveConstants.RENDER_ROTATION_180;
            } else if (num != null && num.intValue() == 3) {
                AppMethodBeat.o(75108);
                return 270;
            }
        }
        AppMethodBeat.o(75108);
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout$setFrameBuffer$1", "Lcom/tencent/mm/plugin/api/recordView/YUVDateRenderToRGBBufferRenderer$DrawRGBABufferCallback;", "getBuffer", "Ljava/nio/ByteBuffer;", "onFrameDraw", "", "plugin-recordvideo_release"})
    public static final class h implements i.a {
        final /* synthetic */ MMSightRecordView.f BJT;
        final /* synthetic */ ByteBuffer BJU;

        h(MMSightRecordView.f fVar, ByteBuffer byteBuffer) {
            this.BJT = fVar;
            this.BJU = byteBuffer;
        }

        @Override // com.tencent.mm.plugin.api.recordView.i.a
        public final void bqT() {
            AppMethodBeat.i(75087);
            MMSightRecordView.f fVar = this.BJT;
            if (fVar != null) {
                fVar.bGa();
                AppMethodBeat.o(75087);
                return;
            }
            AppMethodBeat.o(75087);
        }

        @Override // com.tencent.mm.plugin.api.recordView.i.a
        public final ByteBuffer getBuffer() {
            AppMethodBeat.i(75088);
            ByteBuffer byteBuffer = this.BJU;
            if (byteBuffer == null) {
                p.hyc();
            }
            AppMethodBeat.o(75088);
            return byteBuffer;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "enable", "com/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout$setFrameBuffer$2$1"})
    static final class g implements MMSightCameraGLSurfaceView.c {
        final /* synthetic */ a BJP;
        final /* synthetic */ MMSightCameraGLSurfaceView BJS;

        g(MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView, a aVar) {
            this.BJS = mMSightCameraGLSurfaceView;
            this.BJP = aVar;
        }

        @Override // com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView.c
        public final void enable() {
            AppMethodBeat.i(75086);
            com.tencent.mm.plugin.api.recordView.h hVar = this.BJP.kyM;
            if (hVar != null) {
                hVar.b(this.BJS.getEglContext());
            }
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.BJP.kyw;
            if (mMSightCameraGLSurfaceView != null) {
                mMSightCameraGLSurfaceView.setOnEglEnableListener(null);
                AppMethodBeat.o(75086);
                return;
            }
            AppMethodBeat.o(75086);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.appcamera.a$a  reason: collision with other inner class name */
    public static final class C1636a {
        private C1636a() {
        }

        public /* synthetic */ C1636a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(75110);
        AppMethodBeat.o(75110);
    }
}

package com.tencent.mm.plugin.recordvideo.appcamera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.media.widget.camerarecordview.b;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.api.recordView.g;
import com.tencent.mm.plugin.api.recordView.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.recordvideo.appcamera.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0012\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 |2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001|B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u0015H\u0002J\n\u0010$\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u001fH\u0016J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0018\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J2\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0015H\u0016J\b\u00104\u001a\u00020(H\u0016J\b\u00105\u001a\u00020\u000bH\u0016J\b\u00106\u001a\u00020\u000bH\u0016J\b\u00107\u001a\u00020\u000bH\u0016J\b\u00108\u001a\u00020\u000bH\u0016J\b\u00109\u001a\u00020\u000bH\u0016J\b\u0010:\u001a\u00020(H\u0016J\u0010\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u0015H\u0016J\u0012\u0010=\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0018\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\tH\u0016J\b\u0010C\u001a\u00020(H\u0016J\b\u0010D\u001a\u00020(H\u0016J\u0010\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020*H\u0002J\b\u0010G\u001a\u00020(H\u0016J\b\u0010H\u001a\u00020(H\u0016J\u0010\u0010I\u001a\u00020(2\u0006\u0010J\u001a\u00020\u000bH\u0016J\u0010\u0010K\u001a\u00020(2\u0006\u0010J\u001a\u00020\u000bH\u0016J\u0010\u0010L\u001a\u00020(2\u0006\u0010M\u001a\u00020\tH\u0016J\u0012\u0010N\u001a\u00020(2\b\u0010O\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020\u000bH\u0016J\u0010\u0010R\u001a\u00020(2\u0006\u0010Q\u001a\u00020\u000bH\u0016J\u0010\u0010S\u001a\u00020(2\u0006\u0010T\u001a\u00020\u0015H\u0016J\u001c\u0010U\u001a\u00020(2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u0012\u0010Z\u001a\u00020(2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\b\u0010]\u001a\u00020(H\u0016J\u0012\u0010^\u001a\u00020(2\b\u0010[\u001a\u0004\u0018\u00010_H\u0016J\u0012\u0010`\u001a\u00020(2\b\u0010[\u001a\u0004\u0018\u00010aH\u0016J\u0010\u0010b\u001a\u00020(2\u0006\u0010c\u001a\u00020\u0015H\u0016J\u0010\u0010d\u001a\u00020(2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010f\u001a\u00020(2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010g\u001a\u00020(2\u0006\u0010h\u001a\u00020\u000bH\u0016J\u0012\u0010i\u001a\u00020(2\b\u0010j\u001a\u0004\u0018\u00010\u0017H\u0016J0\u0010k\u001a\u00020(2\u0006\u0010l\u001a\u00020\u00152\u0006\u0010m\u001a\u00020\u00152\u0006\u0010n\u001a\u00020\u00152\u0006\u0010o\u001a\u00020\u00152\u0006\u0010p\u001a\u00020\u0015H\u0016J\u0010\u0010q\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\tH\u0016J\b\u0010s\u001a\u00020(H\u0016J\b\u0010t\u001a\u00020\u000bH\u0016J\u0012\u0010u\u001a\u00020(2\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J\b\u0010x\u001a\u00020(H\u0016J\u001a\u0010y\u001a\u00020(2\b\u0010[\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u00020\u000bH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006}"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppRecordViewImpl;", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$MMSightRecordViewDelegate;", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightMediaRecorder$ErrorCallback;", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener$TouchCallback;", "()V", "cameraPluginLayout", "Lcom/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout;", "displayRatio", "", "isDragZoomEnable", "", "isTouchFocusEnable", "lastPointerDistance", "lastTouchDownTime", "", "mDisplayScreenSize", "Landroid/util/Size;", "mZoomMultipleToRatio", "", "previewSizeLimit", "", "videoPath", "", "videoSizeRatio", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getCameraRotation", "getCurrentFramePicture", "Landroid/graphics/Bitmap;", "getDrawSizePoint", "Landroid/graphics/Point;", "getFlashMode", "getPictureSize", "getPreviewSize", "getScreenRotation", "getSupportZoomMultiple", "getVideoFilePath", "getVideoSize", "handlePluginTouch", "", "motionEvent", "Landroid/view/MotionEvent;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "context", "Landroid/content/Context;", "view", "Landroid/view/ViewGroup;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "initRecorder", "isClipPictureSize", "isClipVideoSize", "isEnableDragZoom", "isEnableTouchFocus", "isFrontCamera", "onDoubleClick", "onError", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "onFrameData", "data", "", "onTouchDown", "x", "y", "onZoomIn", "onZoomOut", "pointerDistance", "event", "release", "set34PreviewVideoSize", "setClipPictureSize", "clip", "setClipVideoSize", "setDisplayRatio", "size", "setDisplayScreenSize", "screenSize", "setEnableDragZoom", "enable", "setEnableTouchFocus", "setFlashMode", "flashMode", "setFrameBuffer", "buffer", "Ljava/nio/ByteBuffer;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$OnDateUpdateListener;", "setFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$CameraFrameDataCallback;", "setHalfPreviewVideoSize", "setInitDoneCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitDoneCallback;", "setInitErrorCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitErrorCallback;", "setPreviewMode", "mode", "setPreviewSizeLimit", "limit", "setRGBSizeLimit", "setUseBackCamera", "back", "setVideoFilePath", "filePath", "setVideoPara", "maxDuration", "videoBitrate", "fps", "audioBitrate", "audioSampleRate", "setZoomMultiple", "multiple", "startPreview", JsApiStartRecordVoice.NAME, JsApiStopRecordVoice.NAME, "stopCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$StopRecordCallback;", "switchCamera", "takePicture", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$PictureTakenCallback;", "openFlash", "Companion", "plugin-recordvideo_release"})
public final class d extends MMSightRecordView.e implements g.a, d.a, com.tencent.mm.plugin.mmsight.model.g {
    private static final int BJX = 400;
    private static final int BJY = 15;
    public static final a BJZ = new a((byte) 0);
    private static final String TAG = TAG;
    private a BJV;
    private float[] BJW;
    private float ilP;
    private boolean kyE = true;
    private boolean kyF = true;
    private float kyL = 1.0f;
    private long kyW = -1;
    private float kyX = -1.0f;
    private int kyq;
    private Size lPr;
    private String videoPath;
    private VideoTransPara zua;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppRecordViewImpl$Companion;", "", "()V", "DOUBLE_CLICK_TIME_LIMIT", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "ZOOM_DISTANCE_THREASHOLD", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(75151);
        AppMethodBeat.o(75151);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void b(Context context, ViewGroup viewGroup) {
        AppMethodBeat.i(75113);
        p.h(context, "context");
        p.h(viewGroup, "view");
        this.BJV = new a(context);
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.setTouchListener(this);
        }
        a aVar2 = this.BJV;
        if (aVar2 != null) {
            p.h(context, "context");
            p.h(viewGroup, "viewGroup");
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
            aVar2.wcV = new CameraPreviewGLSurfaceView(context, null);
            CameraPreviewGLSurfaceView cameraPreviewGLSurfaceView = aVar2.wcV;
            if (cameraPreviewGLSurfaceView != null) {
                cameraPreviewGLSurfaceView.setOnTouchListener(aVar2.kyH);
            }
            viewGroup.addView(aVar2.wcV, marginLayoutParams);
            aVar2.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(context, (byte) 0);
            com.tencent.mm.plugin.mmsight.model.d dVar = aVar2.orientationEventListener;
            if (dVar == null) {
                p.hyc();
            }
            dVar.enable();
            aVar2.kyw = new MMSightCameraGLSurfaceView(context);
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = aVar2.kyw;
            if (mMSightCameraGLSurfaceView != null) {
                mMSightCameraGLSurfaceView.setBackgroundColor(Color.argb(0, 0, 0, 0));
            }
            viewGroup.addView(aVar2.kyw, new ViewGroup.MarginLayoutParams(1, 1));
        }
        this.zua = new VideoTransPara();
        AppMethodBeat.o(75113);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void a(Context context, ViewGroup viewGroup, SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(75114);
        p.h(context, "context");
        p.h(viewGroup, "view");
        this.BJV = new a(context);
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i2, i3);
        }
        a aVar = this.BJV;
        if (aVar != null) {
            p.h(context, "context");
            p.h(viewGroup, "view");
            Log.i(a.TAG, "surface is %s", surfaceTexture);
            if (surfaceTexture == null) {
                p.hyc();
            }
            aVar.wcV = new b(context, surfaceTexture, i2, i3);
            aVar.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(context, (byte) 0);
            com.tencent.mm.plugin.mmsight.model.d dVar = aVar.orientationEventListener;
            if (dVar == null) {
                p.hyc();
            }
            dVar.enable();
            aVar.kyw = new MMSightCameraGLSurfaceView(context);
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = aVar.kyw;
            if (mMSightCameraGLSurfaceView != null) {
                mMSightCameraGLSurfaceView.setBackgroundColor(Color.argb(0, 0, 0, 0));
            }
            viewGroup.addView(aVar.kyw, new ViewGroup.MarginLayoutParams(-1, -1));
        }
        this.zua = new VideoTransPara();
        AppMethodBeat.o(75114);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setInitErrorCallback(MMSightRecordView.d dVar) {
        AppMethodBeat.i(75115);
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.setInitErrorCallback(dVar);
            AppMethodBeat.o(75115);
            return;
        }
        AppMethodBeat.o(75115);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setInitDoneCallback(MMSightRecordView.c cVar) {
        AppMethodBeat.i(75116);
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.setInitDoneCallback(cVar);
            AppMethodBeat.o(75116);
            return;
        }
        AppMethodBeat.o(75116);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setPreviewSizeLimit(int i2) {
        AppMethodBeat.i(75118);
        Log.i(TAG, "setPreviewSizeLimit: %s", Integer.valueOf(i2));
        this.kyq = i2;
        AppMethodBeat.o(75118);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setRGBSizeLimit(int i2) {
        AppMethodBeat.i(75119);
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.setRGBSizeLimit(i2);
            AppMethodBeat.o(75119);
            return;
        }
        AppMethodBeat.o(75119);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void startPreview() {
        boolean z;
        AppMethodBeat.i(75120);
        if (this.ilP > 0.0f && this.kyq > 0) {
            VideoTransPara videoTransPara = this.zua;
            if (videoTransPara != null) {
                videoTransPara.width = this.kyq;
            }
            VideoTransPara videoTransPara2 = this.zua;
            if (videoTransPara2 != null) {
                videoTransPara2.height = (int) (((float) this.kyq) / this.ilP);
            }
        }
        a aVar = this.BJV;
        if (aVar != null) {
            VideoTransPara videoTransPara3 = this.zua;
            if (videoTransPara3 == null) {
                p.hyc();
            }
            String str = this.videoPath;
            if (str == null) {
                p.hyc();
            }
            Size size = this.lPr;
            p.h(videoTransPara3, "para");
            p.h(str, "videoPath");
            CameraPreviewGLSurfaceView cameraPreviewGLSurfaceView = aVar.wcV;
            if (cameraPreviewGLSurfaceView == null) {
                p.hyc();
            }
            aVar.BJH = new com.tencent.mm.plugin.recordvideo.b.a(videoTransPara3, cameraPreviewGLSurfaceView, str);
            com.tencent.mm.plugin.recordvideo.b.a aVar2 = aVar.BJH;
            if (aVar2 == null) {
                p.hyc();
            }
            aVar.BJI = new com.tencent.mm.media.widget.camerarecordview.a(aVar2);
            com.tencent.mm.media.widget.camerarecordview.a aVar3 = aVar.BJI;
            if (!(aVar3 == null || true == aVar3.ipD)) {
                aVar3.ipD = true;
                if (!aVar3.ipD) {
                    com.tencent.mm.media.widget.camerarecordview.c.a aVar4 = aVar3.ipB;
                    if (aVar3.ipt || !aVar3.ipH.aQx()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    aVar4.a(z, aVar3.hAt.aPr());
                }
            }
            com.tencent.mm.media.widget.camerarecordview.a aVar5 = aVar.BJI;
            if (aVar5 != null) {
                aVar5.hAt.setDisplayScreenSize(size);
            }
            com.tencent.mm.media.widget.camerarecordview.a aVar6 = aVar.BJI;
            if (aVar6 != null) {
                aVar6.q(new a.c(aVar));
            }
            com.tencent.mm.media.widget.camerarecordview.a aVar7 = aVar.BJI;
            if (aVar7 == null) {
                p.hyc();
            }
            aVar7.a(aVar.BJM, new a.d(aVar));
            AppMethodBeat.o(75120);
            return;
        }
        AppMethodBeat.o(75120);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setVideoPara$2e715812(int i2) {
        a aVar;
        AppMethodBeat.i(75121);
        VideoTransPara videoTransPara = this.zua;
        if (videoTransPara != null) {
            videoTransPara.duration = i2;
        }
        VideoTransPara videoTransPara2 = this.zua;
        if (videoTransPara2 != null) {
            videoTransPara2.videoBitrate = 4800000;
        }
        VideoTransPara videoTransPara3 = this.zua;
        if (videoTransPara3 != null) {
            videoTransPara3.fps = 30;
        }
        VideoTransPara videoTransPara4 = this.zua;
        if (videoTransPara4 != null) {
            videoTransPara4.audioBitrate = 64000;
        }
        VideoTransPara videoTransPara5 = this.zua;
        if (videoTransPara5 != null) {
            videoTransPara5.audioSampleRate = 44100;
        }
        if (this.zua == null || (aVar = this.BJV) == null) {
            AppMethodBeat.o(75121);
            return;
        }
        VideoTransPara videoTransPara6 = this.zua;
        if (videoTransPara6 == null) {
            p.hyc();
        }
        p.h(videoTransPara6, "para");
        com.tencent.mm.plugin.recordvideo.b.a aVar2 = aVar.BJH;
        if (aVar2 != null) {
            p.h(videoTransPara6, "<set-?>");
            aVar2.BMK = videoTransPara6;
            AppMethodBeat.o(75121);
            return;
        }
        AppMethodBeat.o(75121);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setVideoFilePath(String str) {
        a aVar;
        AppMethodBeat.i(75122);
        this.videoPath = str;
        if (!(str == null || (aVar = this.BJV) == null)) {
            p.h(str, "path");
            com.tencent.mm.plugin.recordvideo.b.a aVar2 = aVar.BJH;
            if (aVar2 != null) {
                p.h(str, "<set-?>");
                aVar2.videoPath = str;
            }
        }
        Log.i(TAG, "video path has been set %s", str);
        AppMethodBeat.o(75122);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final String getVideoFilePath() {
        String str = this.videoPath;
        return str == null ? "" : str;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void bqI() {
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final boolean aai() {
        AppMethodBeat.i(75123);
        a aVar = this.BJV;
        if (aVar != null) {
            d.b.a(aVar, d.c.BUv);
        }
        AppMethodBeat.o(75123);
        return true;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void a(MMSightRecordView.h hVar) {
        AppMethodBeat.i(75124);
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.setRecordCallback(hVar);
        }
        a aVar2 = this.BJV;
        if (aVar2 != null) {
            d.b.a(aVar2, d.c.BUw);
            AppMethodBeat.o(75124);
            return;
        }
        AppMethodBeat.o(75124);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void a(MMSightRecordView.g gVar, boolean z) {
        AppMethodBeat.i(75125);
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.BJJ = gVar;
            aVar.BJN = z;
        }
        a aVar2 = this.BJV;
        if (aVar2 != null) {
            d.b.a(aVar2, d.c.BUD);
            AppMethodBeat.o(75125);
            return;
        }
        AppMethodBeat.o(75125);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setUseBackCamera(boolean z) {
        AppMethodBeat.i(75126);
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.setUseBackCamera(z);
            AppMethodBeat.o(75126);
            return;
        }
        AppMethodBeat.o(75126);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final Point getPictureSize() {
        Point point;
        AppMethodBeat.i(75127);
        a aVar = this.BJV;
        if (aVar == null || (point = aVar.getPictureSize()) == null) {
            point = new Point();
        }
        AppMethodBeat.o(75127);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final Point getVideoSize() {
        Point point;
        AppMethodBeat.i(75128);
        a aVar = this.BJV;
        if (aVar == null || (point = aVar.getVideoSize()) == null) {
            point = new Point();
        }
        AppMethodBeat.o(75128);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final Point getPreviewSize() {
        Point point;
        AppMethodBeat.i(75129);
        a aVar = this.BJV;
        if (aVar == null || (point = aVar.getPreviewSize()) == null) {
            point = new Point();
        }
        AppMethodBeat.o(75129);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final Point getDrawSizePoint() {
        Point point;
        AppMethodBeat.i(75130);
        a aVar = this.BJV;
        if (aVar == null || (point = aVar.getDrawSizePoint()) == null) {
            point = new Point();
        }
        AppMethodBeat.o(75130);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setFrameDataCallback(MMSightRecordView.a aVar) {
        AppMethodBeat.i(75131);
        a aVar2 = this.BJV;
        if (aVar2 != null) {
            aVar2.setFrameDataCallback(aVar);
            AppMethodBeat.o(75131);
            return;
        }
        AppMethodBeat.o(75131);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final int getCameraRotation() {
        AppMethodBeat.i(75132);
        if (this.BJV != null) {
            a aVar = this.BJV;
            if (aVar == null) {
                p.hyc();
            }
            int cameraRotation = aVar.getCameraRotation();
            AppMethodBeat.o(75132);
            return cameraRotation;
        }
        AppMethodBeat.o(75132);
        return 0;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void switchCamera() {
        AppMethodBeat.i(75133);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_PREPARE_CAMERA_IGNORE_FLIP_CHECK_BOOLEAN", true);
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.a(d.c.BUt, bundle);
            AppMethodBeat.o(75133);
            return;
        }
        AppMethodBeat.o(75133);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setClipVideoSize(boolean z) {
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setClipPictureSize(boolean z) {
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setFlashMode(int i2) {
        AppMethodBeat.i(75134);
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.setFlashMode(i2);
            AppMethodBeat.o(75134);
            return;
        }
        AppMethodBeat.o(75134);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final int getFlashMode() {
        AppMethodBeat.i(75135);
        a aVar = this.BJV;
        if (aVar != null) {
            int flashMode = aVar.getFlashMode();
            AppMethodBeat.o(75135);
            return flashMode;
        }
        AppMethodBeat.o(75135);
        return 0;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setEnableDragZoom(boolean z) {
        this.kyE = z;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final float[] getSupportZoomMultiple() {
        AppMethodBeat.i(75136);
        if (this.BJW == null && this.BJV != null) {
            a aVar = this.BJV;
            if (aVar == null) {
                p.hyc();
            }
            this.BJW = aVar.getSupportZoomRatios();
        }
        float[] fArr = this.BJW;
        AppMethodBeat.o(75136);
        return fArr;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final boolean aD(float f2) {
        float[] fArr;
        Integer num;
        AppMethodBeat.i(75137);
        if (this.BJW != null && ((fArr = this.BJW) == null || fArr.length != 0)) {
            float[] fArr2 = this.BJW;
            if (fArr2 != null) {
                p.h(fArr2, "$this$indexOf");
                int length = fArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (f2 == fArr2[i2]) {
                        break;
                    } else {
                        i2++;
                    }
                }
                num = Integer.valueOf(i2);
            } else {
                num = null;
            }
            if (num == null) {
                p.hyc();
            }
            if (num.intValue() >= 0) {
                a aVar = this.BJV;
                if (aVar != null) {
                    aVar.setForceZoomTargetRatio(f2);
                }
                AppMethodBeat.o(75137);
                return true;
            }
        }
        AppMethodBeat.o(75137);
        return false;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setEnableTouchFocus(boolean z) {
        this.kyF = z;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void bqN() {
        AppMethodBeat.i(75138);
        Log.i(TAG, "setHalfPreviewVideoSize");
        this.kyL = 0.5f;
        AppMethodBeat.o(75138);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void bqO() {
        AppMethodBeat.i(75139);
        Log.i(TAG, "set34PreviewVideoSize");
        this.kyL = 0.75f;
        AppMethodBeat.o(75139);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final Bitmap getCurrentFramePicture() {
        AppMethodBeat.i(75140);
        a aVar = this.BJV;
        if (aVar != null) {
            Bitmap currentFramePicture = aVar.getCurrentFramePicture();
            AppMethodBeat.o(75140);
            return currentFramePicture;
        }
        AppMethodBeat.o(75140);
        return null;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void release() {
        AppMethodBeat.i(75141);
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.release();
        }
        this.BJW = null;
        AppMethodBeat.o(75141);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void a(ByteBuffer byteBuffer, MMSightRecordView.f fVar) {
        MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView;
        AppMethodBeat.i(75142);
        a aVar = this.BJV;
        if (aVar == null) {
            AppMethodBeat.o(75142);
        } else if (fVar == null && byteBuffer == null) {
            if (aVar.kyM != null) {
                h hVar = aVar.kyM;
                if (hVar != null) {
                    hVar.release();
                }
                aVar.kyM = null;
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView2 = aVar.kyw;
                if (mMSightCameraGLSurfaceView2 != null) {
                    mMSightCameraGLSurfaceView2.setVisibility(8);
                    AppMethodBeat.o(75142);
                    return;
                }
            }
            AppMethodBeat.o(75142);
        } else {
            if (aVar.kyM == null) {
                aVar.kyM = new h();
                aVar.bqS();
                h hVar2 = aVar.kyM;
                if (hVar2 != null) {
                    hVar2.a(new a.h(fVar, byteBuffer));
                }
                com.tencent.mm.media.widget.camerarecordview.a aVar2 = aVar.BJI;
                Boolean valueOf = aVar2 != null ? Boolean.valueOf(aVar2.hAt.aPc()) : null;
                if (valueOf == null) {
                    p.hyc();
                }
                if (valueOf.booleanValue() && (mMSightCameraGLSurfaceView = aVar.kyw) != null) {
                    if (mMSightCameraGLSurfaceView.getEglContext() != null) {
                        h hVar3 = aVar.kyM;
                        if (hVar3 != null) {
                            hVar3.b(mMSightCameraGLSurfaceView.getEglContext());
                        }
                    } else {
                        MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView3 = aVar.kyw;
                        if (mMSightCameraGLSurfaceView3 != null) {
                            mMSightCameraGLSurfaceView3.setOnEglEnableListener(new a.g(mMSightCameraGLSurfaceView, aVar));
                        }
                    }
                    MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView4 = aVar.kyw;
                    if (mMSightCameraGLSurfaceView4 != null) {
                        mMSightCameraGLSurfaceView4.setVisibility(0);
                        AppMethodBeat.o(75142);
                        return;
                    }
                    AppMethodBeat.o(75142);
                    return;
                }
            }
            AppMethodBeat.o(75142);
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.g
    public final boolean ai(byte[] bArr) {
        AppMethodBeat.i(75143);
        a aVar = this.BJV;
        if (aVar != null) {
            boolean ai = aVar.ai(bArr);
            AppMethodBeat.o(75143);
            return ai;
        }
        AppMethodBeat.o(75143);
        return false;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d.a
    public final void bqP() {
        AppMethodBeat.i(75144);
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.reset();
            AppMethodBeat.o(75144);
            return;
        }
        AppMethodBeat.o(75144);
    }

    @Override // com.tencent.mm.plugin.api.recordView.g.a
    public final void I(float f2, float f3) {
        AppMethodBeat.i(75145);
        if (this.kyF) {
            Bundle bundle = new Bundle();
            bundle.putFloat("PARAM_POINT_X", f2);
            bundle.putFloat("PARAM_POINT_Y", f3);
            a aVar = this.BJV;
            if (aVar != null) {
                aVar.a(d.c.BUu, bundle);
                AppMethodBeat.o(75145);
                return;
            }
        }
        AppMethodBeat.o(75145);
    }

    @Override // com.tencent.mm.plugin.api.recordView.g.a
    public final void bqQ() {
        AppMethodBeat.i(75146);
        if (this.kyE) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
            bundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
            bundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
            a aVar = this.BJV;
            if (aVar != null) {
                aVar.a(d.c.BUs, bundle);
                AppMethodBeat.o(75146);
                return;
            }
        }
        AppMethodBeat.o(75146);
    }

    @Override // com.tencent.mm.plugin.api.recordView.g.a
    public final void bqR() {
        AppMethodBeat.i(75147);
        if (this.kyE) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
            bundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
            bundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
            a aVar = this.BJV;
            if (aVar != null) {
                aVar.a(d.c.BUs, bundle);
                AppMethodBeat.o(75147);
                return;
            }
        }
        AppMethodBeat.o(75147);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setDisplayScreenSize(Size size) {
        this.lPr = size;
    }

    private static float x(MotionEvent motionEvent) {
        AppMethodBeat.i(75148);
        try {
            float x = motionEvent.getX(0);
            float y = motionEvent.getY(0);
            float abs = Math.abs(x - motionEvent.getX(1)) + Math.abs(y - motionEvent.getY(1));
            AppMethodBeat.o(75148);
            return abs;
        } catch (Exception e2) {
            Log.e(TAG, "pointerDistance error: %s", e2.getMessage());
            AppMethodBeat.o(75148);
            return 0.0f;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void o(MotionEvent motionEvent) {
        AppMethodBeat.i(75149);
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            Log.d(TAG, "ACTION_DOWN");
            if (this.kyW <= 0 || SystemClock.elapsedRealtime() - this.kyW >= ((long) BJX)) {
                I(motionEvent.getX(), motionEvent.getY());
            }
            this.kyW = SystemClock.elapsedRealtime();
            this.kyX = -1.0f;
            AppMethodBeat.o(75149);
        } else if (valueOf != null && valueOf.intValue() == 5) {
            Log.d(TAG, "ACTION_POINTER_DOWN");
            AppMethodBeat.o(75149);
        } else if (valueOf != null && valueOf.intValue() == 6) {
            Log.d(TAG, "ACTION_POINTER_UP");
            AppMethodBeat.o(75149);
        } else if (valueOf != null && valueOf.intValue() == 1) {
            Log.d(TAG, "ACTION_UP");
            this.kyX = -1.0f;
            AppMethodBeat.o(75149);
        } else if (valueOf == null) {
            AppMethodBeat.o(75149);
        } else {
            if (valueOf.intValue() == 2 && motionEvent.getPointerCount() >= 2) {
                float x = x(motionEvent);
                Log.v(TAG, "distance: %s", Float.valueOf(x));
                if (x > 0.0f) {
                    if (this.kyX > 0.0f) {
                        if (Math.abs(x - this.kyX) > ((float) BJY)) {
                            if (x > this.kyX) {
                                Log.d(TAG, "zoom out");
                                bqQ();
                            } else {
                                Log.d(TAG, "zoom in");
                                bqR();
                            }
                        }
                    }
                    this.kyX = x;
                }
            }
            AppMethodBeat.o(75149);
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setPreviewMode(int i2) {
        AppMethodBeat.i(75150);
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.setPreviewMode(i2);
            AppMethodBeat.o(75150);
            return;
        }
        AppMethodBeat.o(75150);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setDisplayRatio(float f2) {
        int i2;
        AppMethodBeat.i(75117);
        Object systemService = MMApplicationContext.getContext().getSystemService("window");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(75117);
            throw tVar;
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        p.g(defaultDisplay, ServerProtocol.DIALOG_PARAM_DISPLAY);
        switch (defaultDisplay.getRotation()) {
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
        Log.i(TAG, "setDisplayRatio: %s, screenRotation: %s", Float.valueOf(f2), Integer.valueOf(i2));
        this.ilP = f2;
        if (i2 == 90 || i2 == 270) {
            this.ilP = 1.0f / this.ilP;
        }
        a aVar = this.BJV;
        if (aVar != null) {
            aVar.setDisplayRatio(this.ilP);
            AppMethodBeat.o(75117);
            return;
        }
        AppMethodBeat.o(75117);
    }
}

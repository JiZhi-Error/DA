package com.tencent.mm.media.widget.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Looper;
import android.util.Size;
import android.view.SurfaceHolder;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.media.k.e;
import com.tencent.mm.media.widget.a.a;
import com.tencent.mm.media.widget.a.a.a;
import com.tencent.mm.media.widget.camerarecordview.d.b;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b/\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010k\u001a\u00020U2\b\u0010l\u001a\u0004\u0018\u000100H\u0016J\u0018\u0010m\u001a\u00020U2\u0006\u0010n\u001a\u00020\u000f2\u0006\u0010o\u001a\u00020\u000fH\u0016J\u0018\u0010p\u001a\u00020\u000f2\u0006\u0010q\u001a\u00020E2\u0006\u0010r\u001a\u00020EH\u0002J0\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u00062\u0006\u0010v\u001a\u00020\u00062\u0006\u0010w\u001a\u00020\u00062\u0006\u0010x\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020\u000fH\u0016J\u0010\u0010z\u001a\u00020\u00132\u0006\u0010{\u001a\u00020\u000fH\u0016J\u0018\u0010|\u001a\u00020U2\u0006\u0010}\u001a\u00020\f2\u0006\u0010~\u001a\u00020\u000fH\u0016J\u0011\u0010\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020'H\u0004J!\u0010\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001b\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020t2\u0007\u0010\u0001\u001a\u00020tH\u0016J\u001d\u0010\u0001\u001a\u00020\u00132\t\u0010\u0001\u001a\u0004\u0018\u00010E2\u0007\u0010\u0001\u001a\u00020\u0013H\u0016J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0019\u0010\u0010\u001a\u00020U2\u000f\u0010\u0001\u001a\n\u0018\u00010\u0001R\u00030\u0001H\u0004J\t\u0010\u0001\u001a\u00020\fH\u0016J\t\u0010\u0001\u001a\u00020\u000fH\u0016J\t\u0010\u0001\u001a\u00020\u000fH\u0016J\t\u0010\u0001\u001a\u00020\u0013H\u0016J\t\u0010\u0001\u001a\u00020\u000fH\u0016J\t\u0010\u0001\u001a\u00020\u000fH\u0016J\t\u0010\u0001\u001a\u00020\u000fH\u0014J\t\u0010\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0013H\u0016J\t\u0010\u0001\u001a\u00020\u000fH\u0016J\u0019\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0001H\u0016¢\u0006\u0003\u0010 \u0001J\f\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0016J\u001a\u0010£\u0001\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0007\u0010¤\u0001\u001a\u00020\u0013H\u0016J\t\u0010¥\u0001\u001a\u00020UH\u0004J3\u0010¦\u0001\u001a\u00020U2\u0006\u0010u\u001a\u00020\u00062\u0006\u0010v\u001a\u00020\u00062\u0006\u0010x\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020\u000f2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0016J\t\u0010©\u0001\u001a\u00020UH\u0016J\t\u0010ª\u0001\u001a\u00020UH\u0016J\u0013\u0010«\u0001\u001a\u00020U2\b\u0010l\u001a\u0004\u0018\u000100H\u0016J\t\u0010¬\u0001\u001a\u00020UH\u0004J\u0013\u0010­\u0001\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0013\u0010®\u0001\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0005J\u0013\u0010¯\u0001\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010°\u0001\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0007\u0010±\u0001\u001a\u00020\u0013H\u0014J\u0012\u0010²\u0001\u001a\u00020\u00132\u0007\u0010³\u0001\u001a\u00020\u000fH\u0002J\u001b\u0010´\u0001\u001a\u00020\u00132\u0007\u0010µ\u0001\u001a\u00020\u000f2\u0007\u0010¶\u0001\u001a\u00020\u0006H\u0016J\u0013\u0010·\u0001\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0004J\u001b\u0010¸\u0001\u001a\u00020\u000f2\u0007\u0010¹\u0001\u001a\u00020\u000f2\u0007\u0010º\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010»\u0001\u001a\u00020U2\u0007\u0010¼\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010½\u0001\u001a\u00020U2\u0007\u0010¾\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010¿\u0001\u001a\u00020U2\u0007\u0010À\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010Á\u0001\u001a\u00020U2\u0007\u0010Â\u0001\u001a\u00020\u0006H\u0016J\t\u0010Ã\u0001\u001a\u00020UH\u0002J\t\u0010Ä\u0001\u001a\u00020UH\u0016J\u001b\u0010Å\u0001\u001a\u00020\u00132\u0007\u0010Æ\u0001\u001a\u00020\u000f2\u0007\u0010Ç\u0001\u001a\u00020\u000fH\u0016J\t\u0010È\u0001\u001a\u00020UH\u0016J'\u0010É\u0001\u001a\u00020U2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010Ê\u0001\u001a\u00020\u00132\u0007\u0010³\u0001\u001a\u00020\u000fH\u0016J'\u0010É\u0001\u001a\u00020U2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010Ê\u0001\u001a\u00020\u00132\u0007\u0010³\u0001\u001a\u00020\u000fH\u0016J*\u0010Ë\u0001\u001a\u00020U2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010³\u0001\u001a\u00020\u000fH\u0002J*\u0010Ì\u0001\u001a\u00020U2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010³\u0001\u001a\u00020\u000fH\u0014J\u001a\u0010Í\u0001\u001a\u00020U2\u0006\u0010}\u001a\u00020\f2\u0007\u0010Î\u0001\u001a\u00020\u0013H\u0016J\t\u0010Ï\u0001\u001a\u00020\u0013H\u0016J$\u0010Ð\u0001\u001a\u00020U2\u0007\u0010Ñ\u0001\u001a\u00020\u00132\u0007\u0010Ò\u0001\u001a\u00020\u00132\u0007\u0010Ó\u0001\u001a\u00020\u000fH\u0016J\"\u0010Ô\u0001\u001a\u00020U2\r\u0010Õ\u0001\u001a\b0\u0001R\u00030\u00012\b\b\u0002\u00109\u001a\u00020\u000fH\u0014J$\u0010Ö\u0001\u001a\u00020U2\u000f\u0010Õ\u0001\u001a\n\u0018\u00010\u0001R\u00030\u00012\b\b\u0002\u00109\u001a\u00020\u000fH\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R \u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00105\u001a\u000206X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0015\"\u0004\b@\u0010\u0017R\u001a\u0010A\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0015\"\u0004\bC\u0010\u0017R\u001c\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR7\u0010P\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(T\u0012\u0004\u0012\u00020U\u0018\u00010QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001c\u0010Z\u001a\u0004\u0018\u00010[X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0014\u0010`\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010!R\u001a\u0010b\u001a\u00020cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001a\u0010h\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0015\"\u0004\bj\u0010\u0017¨\u0006×\u0001"}, hxF = {"Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "SMALL_ZOOM_STEP_VAL", "", "getSMALL_ZOOM_STEP_VAL", "()F", "setSMALL_ZOOM_STEP_VAL", "(F)V", "TAG", "", "availableZoomRatioIndexList", "Ljava/util/ArrayList;", "", "getAvailableZoomRatioIndexList", "()Ljava/util/ArrayList;", "bCameraReleased", "", "getBCameraReleased$plugin_mediaeditor_release", "()Z", "setBCameraReleased$plugin_mediaeditor_release", "(Z)V", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "getCamera", "()Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "setCamera", "(Lcom/tencent/mm/compatible/deviceinfo/MCamera;)V", "cameraCallback", "Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "getCameraCallback", "()Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "cameraCropCallback", "getCameraCropCallback", "cameraPreviewCallback", "getCameraPreviewCallback", "currentFrameData", "", "getCurrentFrameData", "()[B", "setCurrentFrameData", "([B)V", "finishCallbackTimeCallback", "getFinishCallbackTimeCallback", "frameDataCallbackList", "", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getFrameDataCallbackList", "()Ljava/util/List;", "setFrameDataCallbackList", "(Ljava/util/List;)V", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "mCameraFps", "getMCameraFps", "()I", "setMCameraFps", "(I)V", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "setMIsCameraNoParamAutoFocus", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mZoomTimesToRatio", "Lcom/tencent/tinker/android/utils/SparseIntArray;", "getMZoomTimesToRatio", "()Lcom/tencent/tinker/android/utils/SparseIntArray;", "setMZoomTimesToRatio", "(Lcom/tencent/tinker/android/utils/SparseIntArray;)V", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "openCameraRes", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "getOpenCameraRes", "()Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "setOpenCameraRes", "(Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;)V", "prevcameraCallback", "getPrevcameraCallback", "sAutoFocusCallback", "Landroid/hardware/Camera$AutoFocusCallback;", "getSAutoFocusCallback", "()Landroid/hardware/Camera$AutoFocusCallback;", "setSAutoFocusCallback", "(Landroid/hardware/Camera$AutoFocusCallback;)V", "takePictureLock", "getTakePictureLock", "setTakePictureLock", "addFrameDataCallback", "callback", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "calculateLocDiff", "loc1", "loc2", "calculateTapArea", "Landroid/graphics/Rect;", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "checkCameraOpenSucc", "scene", "configVendorTagValue", "tag", "value", "dispatchCameraFrame", "frame", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "focusOnArea", "focusArea", "meteringArea", "focusOnFace", "faceLocation", "isClickScreen", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "parameters", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getCameraCurrentFocusMode", "getCameraOrientation", "getCameraPreviewFps", "getCameraSensorRotate", "getCurrentCameraId", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getPreviewWidth", "getSupportPreviewSize", "", "Landroid/util/Size;", "()[Landroid/util/Size;", "getSupportZoomRatios", "", "initCamera", "useBack", "initRawRatios", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "safeResetZoom", "safeSetFocusMode", "safeSetMetering", "safeSetPreviewFormat", "safeSetPreviewFrameRate", "useFixMode", "safeSetPreviewSize", "resolutionLimit", "safeSetPreviewSizeWithLimitAndRatio", "sizeLimit", "displayRatio", "safeSetStabilization", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setPreviewCallbackImpl", "setPreviewCallbackImplInGPUCrop", "setPreviewSize", "width", "height", "setSafeConfig", "startPreview", "useCpuCrop", "startPreviewWithCPU", "startPreviewWithGPU", "switchVendorTag", "isChecked", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "p", "trySetPreviewFrameRateParameters", "plugin-mediaeditor_release"})
public class c extends a {
    private final String TAG = "MicroMsg.CommonCamera1";
    v gGr;
    private float imi = 10.0f;
    List<g> imj = new ArrayList();
    d.a.C0301a imk;
    private Camera.AutoFocusCallback iml = new a(this);
    final com.tencent.mm.plugin.mmsight.model.c imm = new com.tencent.mm.plugin.mmsight.model.c("prevcameraCallback");
    final com.tencent.mm.plugin.mmsight.model.c imn = new com.tencent.mm.plugin.mmsight.model.c("cameraCallback");
    final com.tencent.mm.plugin.mmsight.model.c imo = new com.tencent.mm.plugin.mmsight.model.c("cameraPreviewCallback");
    final com.tencent.mm.plugin.mmsight.model.c imp = new com.tencent.mm.plugin.mmsight.model.c("cameraCropCallback");
    final com.tencent.mm.plugin.mmsight.model.c imq = new com.tencent.mm.plugin.mmsight.model.c("finishCallbackTimeCallback");
    volatile boolean imr;
    volatile byte[] ims;
    private com.tencent.tinker.a.c.b imt;
    private final ArrayList<Integer> imu = new ArrayList<>();
    boolean imv;
    private kotlin.g.a.b<? super Boolean, x> imw;
    int imx;
    boolean imy = true;
    private final Object lock = new Object();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(94058);
        AppMethodBeat.o(94058);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "success", "", "camera", "Landroid/hardware/Camera;", "kotlin.jvm.PlatformType", "onAutoFocus"})
    static final class a implements Camera.AutoFocusCallback {
        final /* synthetic */ c imz;

        a(c cVar) {
            this.imz = cVar;
        }

        public final void onAutoFocus(boolean z, Camera camera) {
            AppMethodBeat.i(218812);
            Log.v(this.imz.TAG, "auto focus callback success ".concat(String.valueOf(z)));
            this.imz.ilK.imQ = true;
            if (!this.imz.imv) {
                try {
                    p.g(camera, "camera");
                    Camera.Parameters parameters = camera.getParameters();
                    p.g(parameters, "camera.parameters");
                    if (!(parameters.getFocusMode() == null || this.imz.ilK.imR == null)) {
                        parameters.setFocusMode(this.imz.ilK.imR);
                        camera.setParameters(parameters);
                        AppMethodBeat.o(218812);
                        return;
                    }
                } catch (Exception e2) {
                    Log.e(this.imz.TAG, "auto focus return while camera is release");
                }
            }
            AppMethodBeat.o(218812);
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void a(g gVar) {
        AppMethodBeat.i(94020);
        Log.printInfoStack(this.TAG, "addFrameDataCallback ".concat(String.valueOf(gVar)), new Object[0]);
        if (gVar == null) {
            AppMethodBeat.o(94020);
            return;
        }
        synchronized (this.lock) {
            try {
                this.imj.add(gVar);
            } finally {
                AppMethodBeat.o(94020);
            }
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void b(g gVar) {
        AppMethodBeat.i(94021);
        Log.printInfoStack(this.TAG, "removeFrameDataCallback ".concat(String.valueOf(gVar)), new Object[0]);
        if (gVar == null) {
            AppMethodBeat.o(94021);
            return;
        }
        synchronized (this.lock) {
            try {
                this.imj.remove(gVar);
            } finally {
                AppMethodBeat.o(94021);
            }
        }
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final void a(SurfaceTexture surfaceTexture, boolean z, int i2) {
        AppMethodBeat.i(94022);
        super.a(surfaceTexture, z, i2);
        if (z) {
            a(surfaceTexture, (SurfaceHolder) null, i2);
            AppMethodBeat.o(94022);
            return;
        }
        b(surfaceTexture, null, i2);
        AppMethodBeat.o(94022);
    }

    @Override // com.tencent.mm.media.widget.a.a
    public final void a(SurfaceHolder surfaceHolder, boolean z, int i2) {
        AppMethodBeat.i(94023);
        super.a(surfaceHolder, z, i2);
        if (z) {
            a((SurfaceTexture) null, surfaceHolder, i2);
            AppMethodBeat.o(94023);
            return;
        }
        b(null, surfaceHolder, i2);
        AppMethodBeat.o(94023);
    }

    private final void a(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder, int i2) {
        AppMethodBeat.i(94024);
        long currentTicks = Util.currentTicks();
        Log.i(this.TAG, "start startPreviewWithCPU,Looper.myLooper(): " + Looper.myLooper() + ",surfaceTexture:" + surfaceTexture + ", surface:" + surfaceHolder);
        if (aPc()) {
            Log.i(this.TAG, "startPreviewWithCPU, camera previewing");
            AppMethodBeat.o(94024);
            return;
        }
        try {
            rx(i2);
            aPp();
            aPs();
            if (a(surfaceTexture, surfaceHolder)) {
                a(a.EnumC0424a.CAMERA_IS_PREVIEWING);
            }
        } catch (Exception e2) {
            Log.e(this.TAG, "start preview FAILED, %s, %s", Looper.myLooper(), e2.getMessage());
            e eVar = e.ilC;
            e.aNm();
        }
        Log.i(this.TAG, "start preview end, use %dms %s", Long.valueOf(Util.ticksToNow(currentTicks)), Looper.myLooper());
        AppMethodBeat.o(94024);
    }

    /* access modifiers changed from: protected */
    public void b(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder, int i2) {
        AppMethodBeat.i(94025);
        long currentTicks = Util.currentTicks();
        Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + surfaceTexture + ", surface:" + surfaceHolder);
        if (aPc()) {
            Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
            AppMethodBeat.o(94025);
            return;
        }
        try {
            if (this.ilQ) {
                j(i2, this.ilP);
                aPt();
            } else {
                rq(i2);
            }
            aPp();
            if (a(surfaceTexture, surfaceHolder)) {
                a(a.EnumC0424a.CAMERA_IS_PREVIEWING);
            }
        } catch (Exception e2) {
            Log.e(this.TAG, "start preview FAILED, %s, %s", Looper.myLooper(), e2.getMessage());
            e eVar = e.ilC;
            e.aNm();
        }
        Log.i(this.TAG, "start preview end, use %dms %s", Long.valueOf(Util.ticksToNow(currentTicks)), Looper.myLooper());
        AppMethodBeat.o(94025);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b0 A[Catch:{ Exception -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b4 A[Catch:{ Exception -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e2 A[Catch:{ Exception -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e6 A[Catch:{ Exception -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean j(int r14, float r15) {
        /*
        // Method dump skipped, instructions count: 371
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.a.c.j(int, float):boolean");
    }

    public final boolean a(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(94027);
        v vVar = this.gGr;
        if (vVar == null) {
            AppMethodBeat.o(94027);
            return false;
        } else if (surfaceTexture == null && surfaceHolder == null) {
            Log.i(this.TAG, "doStartPreview error, surfaceTexture and surface is null");
            e eVar = e.ilC;
            e.aNm();
            AppMethodBeat.o(94027);
            return false;
        } else {
            if (surfaceTexture != null) {
                vVar.setPreviewTexture(surfaceTexture);
            } else {
                vVar.setPreviewDisplay(surfaceHolder);
            }
            vVar.startPreview();
            Log.i(this.TAG, "doStartPreview finish");
            e eVar2 = e.ilC;
            e.aNl();
            AppMethodBeat.o(94027);
            return true;
        }
    }

    public void aPp() {
        Integer num;
        String str;
        boolean z;
        List<Integer> zoomRatios;
        float f2;
        List<Integer> zoomRatios2;
        Integer num2;
        b.a aVar;
        HashMap<Integer, b.a.c> hashMap;
        b.a.c cVar;
        HashMap<Integer, b.a.c> hashMap2;
        int i2 = 0;
        AppMethodBeat.i(94043);
        com.tencent.mm.plugin.mmsight.model.a.l ekc = com.tencent.mm.plugin.mmsight.model.a.l.ekc();
        p.g(ekc, "MMSightController.getInstance()");
        if (ekc.ekd() != null) {
            com.tencent.mm.plugin.mmsight.model.a.l ekc2 = com.tencent.mm.plugin.mmsight.model.a.l.ekc();
            p.g(ekc2, "MMSightController.getInstance()");
            num = Integer.valueOf(ekc2.ekd().zsR);
        } else {
            num = 0;
        }
        String str2 = this.TAG;
        Object[] objArr = new Object[6];
        objArr[0] = num;
        if (ae.gKt.gFU == 1) {
            str = "Range";
        } else {
            str = ae.gKt.gFT == 1 ? "Fix" : "Error";
        }
        objArr[1] = str;
        objArr[2] = Boolean.valueOf(ae.gKt.gFV == 1);
        objArr[3] = Boolean.valueOf(ae.gKt.gFW == 1);
        objArr[4] = Boolean.valueOf(ae.gKt.gFX == 1);
        objArr[5] = Boolean.valueOf(ae.gKt.gFY == 1);
        Log.i(str2, "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", objArr);
        if (ae.gKt.gFU == 1 && (num.intValue() == 0 || num.intValue() == 1)) {
            z = false;
        } else if (ae.gKt.gFT == 1 && (num.intValue() == 0 || num.intValue() == 5)) {
            z = true;
        } else {
            z = false;
        }
        if (this.ilS != null) {
            b.a aVar2 = this.ilS;
            if ((aVar2 != null ? aVar2.irc : null) != null) {
                b.a aVar3 = this.ilS;
                if (!(((aVar3 == null || (hashMap2 = aVar3.irc) == null) ? null : hashMap2.get(Integer.valueOf(aPu()))) == null || (aVar = this.ilS) == null || (hashMap = aVar.irc) == null || (cVar = hashMap.get(Integer.valueOf(aPu()))) == null)) {
                    Integer num3 = cVar.iri;
                    if (num3 != null) {
                        this.imx = num3.intValue();
                    }
                    Boolean bool = cVar.irj;
                    if (bool != null) {
                        z = bool.booleanValue();
                    }
                }
            }
        }
        a(this.gGr, z);
        if (ae.gKt.gFV == 1 && (num.intValue() == 0 || num.intValue() == 2)) {
            b(this.gGr);
        }
        if (ae.gKA.gIX != -1 && ae.gKA.gIX == 1 && com.tencent.mm.compatible.util.d.oF(14)) {
            c(this.gGr);
        }
        if (ae.gKt.gFX == 1 && (num.intValue() == 0 || num.intValue() == 4)) {
            a(this.gGr);
        }
        if (ae.gKt.gFY == 1 && num.intValue() != 0) {
            num.intValue();
        }
        try {
            v vVar = this.gGr;
            Camera.Parameters parameters = vVar != null ? vVar.getParameters() : null;
            if (parameters != null && parameters.isZoomSupported()) {
                parameters.setZoom(0);
            }
            v vVar2 = this.gGr;
            if (vVar2 != null) {
                vVar2.setParameters(parameters);
            }
        } catch (Exception e2) {
            Log.e(this.TAG, "safeResetZoom error: %s", e2.getMessage());
        }
        try {
            v vVar3 = this.gGr;
            Camera.Parameters parameters2 = vVar3 != null ? vVar3.getParameters() : null;
            int intValue = (parameters2 == null || (zoomRatios2 = parameters2.getZoomRatios()) == null || (num2 = (Integer) j.ks(zoomRatios2)) == null) ? 0 : num2.intValue();
            this.imu.clear();
            this.imu.add(0);
            float f3 = this.imi + ((float) intValue);
            if (parameters2 == null || (zoomRatios = parameters2.getZoomRatios()) == null) {
                AppMethodBeat.o(94043);
                return;
            }
            for (T t : zoomRatios) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                if (Float.compare((float) t.intValue(), f3) > 0) {
                    f2 = this.imi + f3;
                    this.imu.add(Integer.valueOf(i2));
                } else {
                    f2 = f3;
                }
                i2 = i3;
                f3 = f2;
            }
            AppMethodBeat.o(94043);
        } catch (Exception e3) {
            Log.i(this.TAG, "current get parameters is null");
            AppMethodBeat.o(94043);
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public void b(float f2, float f3, int i2, int i3) {
        AppMethodBeat.i(94029);
        if (!aPc()) {
            AppMethodBeat.o(94029);
        } else if (com.tencent.mm.compatible.util.d.oE(14)) {
            AppMethodBeat.o(94029);
        } else {
            com.tencent.mm.media.widget.a.a.a aVar = this.ilK;
            a.C0425a aVar2 = com.tencent.mm.media.widget.a.a.a.imU;
            aVar.removeMessages(com.tencent.mm.media.widget.a.a.a.aPz());
            this.ilK.gZZ = f2;
            this.ilK.haa = f3;
            this.ilK.imO = i2;
            this.ilK.imP = i3;
            com.tencent.mm.media.widget.a.a.a aVar3 = this.ilK;
            com.tencent.mm.media.widget.a.a.a aVar4 = this.ilK;
            a.C0425a aVar5 = com.tencent.mm.media.widget.a.a.a.imU;
            aVar3.sendMessageDelayed(aVar4.obtainMessage(com.tencent.mm.media.widget.a.a.a.aPz(), this.gGr), 400);
            AppMethodBeat.o(94029);
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public void aPq() {
        AppMethodBeat.i(94030);
        if (!aPc()) {
            AppMethodBeat.o(94030);
            return;
        }
        com.tencent.mm.media.widget.a.a.a aVar = this.ilK;
        a.C0425a aVar2 = com.tencent.mm.media.widget.a.a.a.imU;
        aVar.removeMessages(com.tencent.mm.media.widget.a.a.a.aPz());
        AppMethodBeat.o(94030);
    }

    @Override // com.tencent.mm.media.widget.a.d
    public void i(boolean z, int i2) {
        Camera.Parameters parameters;
        int intValue;
        AppMethodBeat.i(94032);
        if (this.gGr == null || !aPc()) {
            AppMethodBeat.o(94032);
            return;
        }
        try {
            Log.d(this.TAG, "triggerSmallZoom, zoom: %s", Boolean.valueOf(z));
            if (this.aYc) {
                Log.d(this.TAG, "triggerSmallZoom, zooming, ignore");
                return;
            }
            v vVar = this.gGr;
            if (vVar != null) {
                parameters = vVar.getParameters();
            } else {
                parameters = null;
            }
            if (parameters != null && parameters.isZoomSupported()) {
                this.aYc = true;
                int zoom = parameters.getZoom();
                int indexOf = this.imu.indexOf(Integer.valueOf(zoom));
                int maxZoom = parameters.getMaxZoom();
                Log.d(this.TAG, "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", Integer.valueOf(zoom), Integer.valueOf(maxZoom), Integer.valueOf(this.ilX), Integer.valueOf(this.ilW), Integer.valueOf(i2));
                if (z) {
                    if (zoom >= maxZoom) {
                        this.aYc = false;
                        AppMethodBeat.o(94032);
                        return;
                    } else if (indexOf == this.imu.size() - 1) {
                        intValue = ((Number) j.ku(this.imu)).intValue();
                    } else {
                        Integer num = this.imu.get(indexOf + 1);
                        p.g(num, "availableZoomRatioIndexList[currentZoomIndex + 1]");
                        intValue = num.intValue();
                    }
                } else if (zoom == 0) {
                    this.aYc = false;
                    AppMethodBeat.o(94032);
                    return;
                } else if (indexOf == 0) {
                    intValue = ((Number) j.ks(this.imu)).intValue();
                } else {
                    Integer num2 = this.imu.get(indexOf - 1);
                    p.g(num2, "availableZoomRatioIndexList[currentZoomIndex - 1]");
                    intValue = num2.intValue();
                }
                Log.d(this.TAG, "triggerSmallZoom, nextZoom: %s, smoothZoomSupported: %s", Integer.valueOf(intValue), Boolean.valueOf(parameters.isSmoothZoomSupported()));
                parameters.setZoom(intValue);
                v vVar2 = this.gGr;
                if (vVar2 != null) {
                    vVar2.setParameters(parameters);
                }
            }
            this.aYc = false;
            AppMethodBeat.o(94032);
        } catch (Exception e2) {
            Log.e(this.TAG, "triggerSmallZoom error: %s", e2.getMessage());
        } finally {
            this.aYc = false;
            AppMethodBeat.o(94032);
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final float[] getSupportZoomRatios() {
        List<Integer> list;
        List<Integer> list2 = null;
        AppMethodBeat.i(94033);
        if (this.imt == null) {
            if (this.gGr != null) {
                try {
                    v vVar = this.gGr;
                    if (vVar == null) {
                        p.hyc();
                    }
                    Camera.Parameters parameters = vVar.getParameters();
                    if (parameters == null) {
                        p.hyc();
                    }
                    if (parameters.isZoomSupported()) {
                        list2 = parameters.getZoomRatios();
                    }
                    list = list2;
                } catch (Exception e2) {
                    Log.e(this.TAG, "getZoom error: %s", e2.getMessage());
                }
                if (list != null || list.isEmpty()) {
                    this.imt = new com.tencent.tinker.a.c.b();
                } else {
                    int intValue = list.get(list.size() - 1).intValue();
                    int i2 = 1;
                    for (int i3 = intValue; i3 / 10 >= 10; i3 /= 10) {
                        i2 *= 10;
                    }
                    int i4 = intValue / i2;
                    if ((intValue + 4) / i2 > i4) {
                        i4++;
                    }
                    this.imt = new com.tencent.tinker.a.c.b(i4);
                    if (10 <= i4) {
                        int i5 = 10;
                        while (true) {
                            if (list.indexOf(Integer.valueOf(i5 * i2)) < 0) {
                                int i6 = 1;
                                while (true) {
                                    if (i6 > 4) {
                                        break;
                                    } else if (list.indexOf(Integer.valueOf((i5 * i2) - i6)) > 0) {
                                        com.tencent.tinker.a.c.b bVar = this.imt;
                                        if (bVar == null) {
                                            p.hyc();
                                        }
                                        bVar.append(i5, (i5 * i2) - i6);
                                    } else if (list.indexOf(Integer.valueOf((i5 * i2) + i6)) > 0) {
                                        com.tencent.tinker.a.c.b bVar2 = this.imt;
                                        if (bVar2 == null) {
                                            p.hyc();
                                        }
                                        bVar2.append(i5, i6 + (i5 * i2));
                                    } else {
                                        i6++;
                                    }
                                }
                            } else {
                                com.tencent.tinker.a.c.b bVar3 = this.imt;
                                if (bVar3 == null) {
                                    p.hyc();
                                }
                                bVar3.append(i5, i5 * i2);
                            }
                            if (i5 == i4) {
                                break;
                            }
                            i5++;
                        }
                    }
                }
            }
            list = null;
            if (list != null) {
            }
            this.imt = new com.tencent.tinker.a.c.b();
        }
        com.tencent.tinker.a.c.b bVar4 = this.imt;
        if (bVar4 == null) {
            p.hyc();
        }
        float[] fArr = new float[bVar4.size()];
        com.tencent.tinker.a.c.b bVar5 = this.imt;
        if (bVar5 == null) {
            p.hyc();
        }
        int size = bVar5.size();
        for (int i7 = 0; i7 < size; i7++) {
            com.tencent.tinker.a.c.b bVar6 = this.imt;
            if (bVar6 == null) {
                p.hyc();
            }
            fArr[i7] = (((float) bVar6.keyAt(i7)) * 1.0f) / 10.0f;
        }
        AppMethodBeat.o(94033);
        return fArr;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public b aPr() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(94036);
        Log.printInfoStack(this.TAG, "generateCameraConfig", new Object[0]);
        if (this.gGr == null) {
            Log.i(this.TAG, "generateCameraConfig, camera is null!!");
            AppMethodBeat.o(94036);
            return null;
        } else if (!aPc()) {
            Log.i(this.TAG, "generateCameraConfig, camera not previewing");
            AppMethodBeat.o(94036);
            return null;
        } else {
            b.rs(getPreviewWidth());
            b.rr(getPreviewHeight());
            d.a.C0301a aVar = this.imk;
            if (aVar != null) {
                z = aVar.dYT == 90 || aVar.dYT == 270;
            } else {
                z = false;
            }
            b.ru(this.ilR.sUz);
            b.rv(this.ilR.sUA);
            if (z) {
                int aPl = b.aPl();
                b.ru(b.aPm());
                b.rv(aPl);
            }
            b.rt(getOrientation());
            if (this.ilM) {
                z2 = false;
            }
            b.setFrontCamera(z2);
            b.eZ(this.ilO);
            b bVar = this.hAu;
            AppMethodBeat.o(94036);
            return bVar;
        }
    }

    public int getPreviewHeight() {
        AppMethodBeat.i(94037);
        if (this.gGr == null) {
            AppMethodBeat.o(94037);
            return 0;
        }
        if (this.imk != null) {
            try {
                if (!this.ilO || this.ilV == null) {
                    int i2 = this.ilR.sUA;
                    AppMethodBeat.o(94037);
                    return i2;
                }
                Point point = this.ilV;
                if (point == null) {
                    p.hyc();
                }
                int i3 = point.y;
                AppMethodBeat.o(94037);
                return i3;
            } catch (Exception e2) {
                Log.e(this.TAG, "getPreviewHeight: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(94037);
        return 0;
    }

    public int getPreviewWidth() {
        AppMethodBeat.i(94038);
        if (this.gGr == null) {
            AppMethodBeat.o(94038);
            return 0;
        }
        if (this.imk != null) {
            try {
                if (!this.ilO || this.ilV == null) {
                    int i2 = this.ilR.sUz;
                    AppMethodBeat.o(94038);
                    return i2;
                }
                Point point = this.ilV;
                if (point == null) {
                    p.hyc();
                }
                int i3 = point.x;
                AppMethodBeat.o(94038);
                return i3;
            } catch (Exception e2) {
                Log.e(this.TAG, "getPreviewWidth: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(94038);
        return 0;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public Point fa(boolean z) {
        Point point;
        AppMethodBeat.i(94039);
        if (!z) {
            Point point2 = new Point(this.ilR.sUz, this.ilR.sUA);
            AppMethodBeat.o(94039);
            return point2;
        }
        if (this.ilV != null) {
            point = this.ilV;
            if (point == null) {
                p.hyc();
                AppMethodBeat.o(94039);
                return point;
            }
        } else {
            point = new Point(this.ilR.sUz, this.ilR.sUA);
        }
        AppMethodBeat.o(94039);
        return point;
    }

    /* access modifiers changed from: protected */
    public final int getOrientation() {
        AppMethodBeat.i(94040);
        if (this.imk == null || !aPc()) {
            AppMethodBeat.o(94040);
            return -1;
        }
        d.a.C0301a aVar = this.imk;
        if (aVar != null) {
            int i2 = aVar.dYT;
            AppMethodBeat.o(94040);
            return i2;
        }
        AppMethodBeat.o(94040);
        return 0;
    }

    /* access modifiers changed from: protected */
    public final boolean a(v vVar, boolean z) {
        int min;
        AppMethodBeat.i(94041);
        if (vVar == null) {
            AppMethodBeat.o(94041);
            return false;
        }
        try {
            Camera.Parameters parameters = vVar.getParameters();
            if (z) {
                int i2 = this.imx;
                if (ae.gKt.gFP > 0) {
                    Log.i(this.ilH, "set frame rate > 0, do not try set preview frame rate");
                } else if (parameters == null) {
                    Log.e(this.TAG, "trySetPreviewFrameRateParameters error, p is null!");
                } else {
                    try {
                        List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
                        if (supportedPreviewFrameRates != null && supportedPreviewFrameRates.size() > 0) {
                            if (i2 != 0) {
                                Object max = Collections.max(supportedPreviewFrameRates);
                                p.g(max, "Collections.max(fr)");
                                min = Math.min(i2, ((Number) max).intValue());
                            } else {
                                Object max2 = Collections.max(supportedPreviewFrameRates);
                                p.g(max2, "Collections.max(fr)");
                                min = Math.min(30, ((Number) max2).intValue());
                            }
                            parameters.setPreviewFrameRate(min);
                            Log.i(this.ilH, "set preview frame rate %d", Integer.valueOf(min));
                        }
                    } catch (Exception e2) {
                        Log.i(this.ilH, "trySetPreviewFrameRateParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
                    }
                }
            } else {
                p.g(parameters, "p");
                a(parameters, this.imx);
            }
            p.g(parameters, "p");
            List<Integer> supportedPreviewFrameRates2 = parameters.getSupportedPreviewFrameRates();
            Log.i(this.ilH, "use fix mode %B, supported preview frame rates %s", Boolean.valueOf(z), supportedPreviewFrameRates2);
            vVar.setParameters(parameters);
            AppMethodBeat.o(94041);
            return true;
        } catch (Exception e3) {
            Log.i(this.ilH, "setPreviewFrameRate Exception, %s, %s", Looper.myLooper(), e3.getMessage());
            AppMethodBeat.o(94041);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void a(Camera.Parameters parameters, int i2) {
        boolean z;
        AppMethodBeat.i(218813);
        p.h(parameters, "p");
        if (ae.gKt.gFP > 0) {
            Log.i(this.ilH, "set frame rate > 0, do not try set preview fps range");
            AppMethodBeat.o(218813);
            return;
        }
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0) {
            AppMethodBeat.o(218813);
            return;
        }
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MIN_VALUE;
        boolean z2 = false;
        int size = supportedPreviewFpsRange.size();
        int i5 = 0;
        while (i5 < size) {
            int[] iArr = supportedPreviewFpsRange.get(i5);
            if (iArr == null || iArr.length <= 1) {
                z = z2;
            } else {
                int i6 = iArr[0];
                int i7 = iArr[1];
                Log.i(this.TAG, "dkfps %d:[%d %d]", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
                if (i6 < 0 || i7 < i6) {
                    z = z2;
                } else {
                    if (i7 >= i4 && !z2) {
                        i4 = i7;
                        i3 = i6;
                    }
                    if (i2 != 0) {
                        if (i7 >= i2 * 1000) {
                            z = true;
                        }
                    } else if (i7 >= 30000) {
                        z = true;
                    }
                    z = z2;
                }
            }
            i5++;
            z2 = z;
        }
        Log.i(this.ilH, "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i3), Integer.valueOf(i4), 30);
        if (i3 == Integer.MAX_VALUE || i4 == Integer.MAX_VALUE) {
            AppMethodBeat.o(218813);
            return;
        }
        try {
            parameters.setPreviewFpsRange(i3, i4);
            Log.i(this.ilH, "set fps range %d %d", Integer.valueOf(i3), Integer.valueOf(i4));
            AppMethodBeat.o(218813);
        } catch (Exception e2) {
            Log.i(this.ilH, "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(218813);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(v vVar) {
        AppMethodBeat.i(94042);
        if (vVar == null) {
            AppMethodBeat.o(94042);
            return false;
        }
        try {
            Camera.Parameters parameters = vVar.getParameters();
            p.g(parameters, "p");
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                Log.i(this.TAG, "support continuous picture");
                parameters.setFocusMode("continuous-picture");
            } else if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                Log.i(this.TAG, "support continuous video");
                parameters.setFocusMode("continuous-video");
            } else if (supportedFocusModes == null || !supportedFocusModes.contains("auto")) {
                Log.i(this.TAG, "not support continuous video or auto focus");
            } else {
                Log.i(this.TAG, "support auto focus");
                parameters.setFocusMode("auto");
            }
            this.ilK.imR = parameters.getFocusMode();
            vVar.setParameters(parameters);
            AppMethodBeat.o(94042);
            return true;
        } catch (Exception e2) {
            Log.i(this.TAG, "setFocusMode Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(94042);
            return false;
        }
    }

    public boolean b(v vVar) {
        AppMethodBeat.i(94044);
        if (vVar == null) {
            AppMethodBeat.o(94044);
            return false;
        }
        try {
            Log.i(this.TAG, "safeSetPreviewFormat");
            Camera.Parameters parameters = vVar.getParameters();
            p.g(parameters, "p");
            List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(17)) {
                Log.e(this.TAG, "not support YCbCr_420_SP");
            }
            parameters.setPreviewFormat(17);
            vVar.setParameters(parameters);
            AppMethodBeat.o(94044);
            return true;
        } catch (Exception e2) {
            Log.i(this.TAG, "setPreviewFormat Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(94044);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(14)
    public final boolean c(v vVar) {
        AppMethodBeat.i(94045);
        if (vVar == null) {
            AppMethodBeat.o(94045);
            return false;
        }
        try {
            Log.i(this.TAG, "safeSetMetering");
            Camera.Parameters parameters = vVar.getParameters();
            p.g(parameters, NativeProtocol.WEB_DIALOG_PARAMS);
            if (parameters.getMaxNumMeteringAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(new Rect(-1000, -1000, 1000, 1000), 600));
                parameters.setMeteringAreas(arrayList);
            }
            vVar.setParameters(parameters);
            AppMethodBeat.o(94045);
            return true;
        } catch (Exception e2) {
            Log.i(this.TAG, "safeSetMetering Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(94045);
            return false;
        }
    }

    private final void aPs() {
        Camera.Parameters parameters;
        AppMethodBeat.i(94046);
        if (this.gGr == null) {
            AppMethodBeat.o(94046);
            return;
        }
        try {
            if (this.gGr != null) {
                v vVar = this.gGr;
                if (vVar == null || (parameters = vVar.getParameters()) == null) {
                    AppMethodBeat.o(94046);
                    return;
                }
                int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (this.ilR.sUz * this.ilR.sUA)) / 8;
                Log.i(this.TAG, "setPreviewCallbackImpl  size: ".concat(String.valueOf(bitsPerPixel)));
                for (int i2 = 0; i2 < 5; i2++) {
                    byte[] h2 = k.zwi.h(Integer.valueOf(bitsPerPixel));
                    v vVar2 = this.gGr;
                    if (vVar2 != null) {
                        vVar2.addCallbackBuffer(h2);
                    }
                }
                this.imm.reset();
                this.imn.reset();
                this.imo.reset();
                this.imp.reset();
                this.imq.reset();
                v vVar3 = this.gGr;
                if (vVar3 != null) {
                    vVar3.setPreviewCallbackWithBuffer(new b(this));
                    AppMethodBeat.o(94046);
                    return;
                }
                AppMethodBeat.o(94046);
                return;
            }
            AppMethodBeat.o(94046);
        } catch (Exception e2) {
            Log.e(this.TAG, "setPreviewCallbackImpl error: %s", e2.getMessage());
            AppMethodBeat.o(94046);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/hardware/Camera;", "onPreviewFrame", "com/tencent/mm/media/widget/camera/CommonCamera1$setPreviewCallbackImpl$1$1"})
    public static final class b implements Camera.PreviewCallback {
        final /* synthetic */ c imz;

        b(c cVar) {
            this.imz = cVar;
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            byte[] bArr2;
            Point point;
            AppMethodBeat.i(94017);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    if (this.imz.imj.size() <= 0) {
                        v vVar = this.imz.gGr;
                        if (vVar != null) {
                            vVar.addCallbackBuffer(bArr);
                            AppMethodBeat.o(94017);
                            return;
                        }
                        AppMethodBeat.o(94017);
                        return;
                    }
                    if (!this.imz.imr && this.imz.imj.size() > 0 && this.imz.ilV != null) {
                        Point point2 = this.imz.ilV;
                        if (point2 == null || point2.x != this.imz.ilR.sUz || (point = this.imz.ilV) == null || point.y != this.imz.ilR.sUA) {
                            k kVar = k.zwi;
                            int i2 = this.imz.ilR.sUz;
                            Point point3 = this.imz.ilV;
                            if (point3 == null) {
                                p.hyc();
                            }
                            byte[] h2 = kVar.h(Integer.valueOf(((i2 * point3.y) * 3) / 2));
                            this.imz.imo.Hi(1);
                            long currentTicks = Util.currentTicks();
                            int i3 = this.imz.ilR.sUz;
                            int i4 = this.imz.ilR.sUA;
                            Point point4 = this.imz.ilV;
                            if (point4 == null) {
                                p.hyc();
                            }
                            SightVideoJNI.cropCameraData(bArr, h2, i3, i4, point4.y);
                            Point point5 = this.imz.ilV;
                            if (point5 == null) {
                                p.hyc();
                            }
                            if (point5.x < this.imz.ilR.sUz) {
                                k kVar2 = k.zwi;
                                Point point6 = this.imz.ilV;
                                if (point6 == null) {
                                    p.hyc();
                                }
                                int i5 = point6.x;
                                Point point7 = this.imz.ilV;
                                if (point7 == null) {
                                    p.hyc();
                                }
                                bArr2 = kVar2.h(Integer.valueOf(((i5 * point7.y) * 3) / 2));
                                int i6 = this.imz.ilR.sUz;
                                Point point8 = this.imz.ilV;
                                if (point8 == null) {
                                    p.hyc();
                                }
                                int i7 = point8.x;
                                Point point9 = this.imz.ilV;
                                if (point9 == null) {
                                    p.hyc();
                                }
                                SightVideoJNI.cropCameraDataLongEdge(h2, bArr2, i6, i7, point9.y);
                                k.zwi.k(h2);
                            } else {
                                bArr2 = h2;
                            }
                            this.imz.imp.Hi(Util.ticksToNow(currentTicks));
                            c cVar = this.imz;
                            p.g(bArr2, "curFrameData");
                            boolean ah = cVar.ah(bArr2);
                            long ticksToNow = Util.ticksToNow(currentTicks);
                            if (ah) {
                                this.imz.imq.Hi(ticksToNow);
                            }
                        } else {
                            long currentTicks2 = Util.currentTicks();
                            boolean ah2 = this.imz.ah(bArr);
                            long ticksToNow2 = Util.ticksToNow(currentTicks2);
                            if (ah2) {
                                this.imz.imq.Hi(ticksToNow2);
                            }
                            if (ah2) {
                                bArr = k.zwi.h(Integer.valueOf(bArr.length));
                            }
                        }
                    }
                    v vVar2 = this.imz.gGr;
                    if (vVar2 != null) {
                        vVar2.addCallbackBuffer(bArr);
                        AppMethodBeat.o(94017);
                        return;
                    }
                    AppMethodBeat.o(94017);
                    return;
                }
            }
            Log.e(this.imz.TAG, "onPreviewFrame, frame data is null!!");
            AppMethodBeat.o(94017);
        }
    }

    public void aPt() {
        AppMethodBeat.i(94047);
        if (this.gGr != null) {
            try {
                v vVar = this.gGr;
                if (vVar == null) {
                    p.hyc();
                }
                Camera.Parameters parameters = vVar.getParameters();
                Log.i(this.TAG, "setPreviewCallbackImpl");
                int i2 = this.ilR.sUz * this.ilR.sUA;
                if (parameters == null) {
                    p.hyc();
                }
                int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * i2) / 8;
                for (int i3 = 0; i3 < 5; i3++) {
                    byte[] h2 = k.zwi.h(Integer.valueOf(bitsPerPixel));
                    v vVar2 = this.gGr;
                    if (vVar2 == null) {
                        p.hyc();
                    }
                    vVar2.addCallbackBuffer(h2);
                }
                this.imm.reset();
                this.imn.reset();
                this.imo.reset();
                this.imp.reset();
                this.imq.reset();
                v vVar3 = this.gGr;
                if (vVar3 == null) {
                    p.hyc();
                }
                vVar3.setPreviewCallbackWithBuffer(new C0426c(this));
                AppMethodBeat.o(94047);
                return;
            } catch (Exception e2) {
                Log.e(this.TAG, "setPreviewCallbackImpl error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(94047);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "ca", "Landroid/hardware/Camera;", "onPreviewFrame"})
    /* renamed from: com.tencent.mm.media.widget.a.c$c  reason: collision with other inner class name */
    public static final class C0426c implements Camera.PreviewCallback {
        final /* synthetic */ c imz;

        C0426c(c cVar) {
            this.imz = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:82:0x0190, code lost:
            if (r4.dYT == 90) goto L_0x0192;
         */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x0159  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPreviewFrame(byte[] r13, android.hardware.Camera r14) {
            /*
            // Method dump skipped, instructions count: 417
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.a.c.C0426c.onPreviewFrame(byte[], android.hardware.Camera):void");
        }
    }

    private final boolean rx(int i2) {
        boolean z;
        Point point;
        Camera.Parameters parameters;
        h.c cVar;
        d.a.C0301a aVar;
        AppMethodBeat.i(94048);
        if (this.gGr == null || this.imk == null) {
            Log.d(this.TAG, "maybe sth. is wrong ,camera is null");
            AppMethodBeat.o(94048);
            return false;
        }
        d.a.C0301a aVar2 = this.imk;
        if ((aVar2 == null || aVar2.dYT != 90) && ((aVar = this.imk) == null || aVar.dYT != 270)) {
            z = false;
        } else {
            z = true;
        }
        try {
            if (this.ilU == null) {
                point = com.tencent.mm.plugin.mmsight.d.gx(this.context);
            } else {
                Size size = this.ilU;
                if (size == null) {
                    p.hyc();
                }
                int width = size.getWidth();
                Size size2 = this.ilU;
                if (size2 == null) {
                    p.hyc();
                }
                point = new Point(width, size2.getHeight());
            }
            v vVar = this.gGr;
            if (vVar == null || (parameters = vVar.getParameters()) == null) {
                AppMethodBeat.o(94048);
                return false;
            }
            h.c c2 = h.c(parameters, point, i2, z);
            if ((c2 != null ? c2.zum : null) == null) {
                Log.e(this.TAG, "fuck, preview size still null!!");
                cVar = h.d(parameters, new Point(Math.min(point.x, point.y), Math.max(point.x, point.y)), this.ilI, z);
            } else {
                cVar = c2;
            }
            if (cVar.zum == null) {
                Log.i(this.TAG, "checkMore start %s", cVar.toString());
                cVar.zum = cVar.zup;
                cVar.zun = cVar.zuq;
                cVar.zuo = cVar.zur;
            }
            Point point2 = cVar.zum;
            if (point2 == null) {
                com.tencent.mm.plugin.mmsight.model.l.ejN();
                AppMethodBeat.o(94048);
                return false;
            }
            this.ilR.sUz = point2.x;
            this.ilR.sUA = point2.y;
            this.ilV = point2;
            if (cVar.zun != null) {
                this.ilV = cVar.zun;
            }
            Log.i(this.TAG, "final set camera preview size: " + point2 + ", cropSize: " + this.ilV);
            parameters.setPreviewSize(point2.x, point2.y);
            v vVar2 = this.gGr;
            if (vVar2 != null) {
                vVar2.setParameters(parameters);
            }
            AppMethodBeat.o(94048);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "setPreviewSize Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(94048);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.a.a
    public final boolean aPh() {
        d.a.C0301a aVar = this.imk;
        if (aVar == null) {
            return false;
        }
        if (aVar.dYT == 90 || aVar.dYT == 270) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.media.widget.a.a
    public final Size[] aPi() {
        Camera.Parameters parameters;
        List<Camera.Size> supportedPreviewSizes;
        AppMethodBeat.i(218814);
        v vVar = this.gGr;
        if (vVar == null || (parameters = vVar.getParameters()) == null || (supportedPreviewSizes = parameters.getSupportedPreviewSizes()) == null) {
            AppMethodBeat.o(218814);
            return null;
        }
        int size = supportedPreviewSizes.size();
        Size[] sizeArr = new Size[size];
        for (int i2 = 0; i2 < size; i2++) {
            Camera.Size size2 = supportedPreviewSizes.get(i2);
            sizeArr[i2] = new Size(size2.width, size2.height);
        }
        AppMethodBeat.o(218814);
        return sizeArr;
    }

    @Override // com.tencent.mm.media.widget.a.a
    public final boolean dg(int i2, int i3) {
        AppMethodBeat.i(218815);
        try {
            v vVar = this.gGr;
            Camera.Parameters parameters = vVar != null ? vVar.getParameters() : null;
            if (parameters != null) {
                parameters.setPreviewSize(i2, i3);
            }
            v vVar2 = this.gGr;
            if (vVar2 != null) {
                vVar2.setParameters(parameters);
            }
            AppMethodBeat.o(218815);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(218815);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final int aPv() {
        AppMethodBeat.i(94050);
        int orientation = getOrientation();
        AppMethodBeat.o(94050);
        return orientation;
    }

    /* access modifiers changed from: protected */
    public final boolean ah(byte[] bArr) {
        AppMethodBeat.i(94051);
        p.h(bArr, "frame");
        Util.currentTicks();
        synchronized (this.lock) {
            try {
                if (this.imj == null || this.imj.size() == 0) {
                    return false;
                }
                boolean z = false;
                for (g gVar : this.imj) {
                    z |= gVar.ai(bArr);
                }
                AppMethodBeat.o(94051);
                return z;
            } finally {
                AppMethodBeat.o(94051);
            }
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void B(String str, boolean z) {
        AppMethodBeat.i(94052);
        p.h(str, "tag");
        AppMethodBeat.o(94052);
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void ad(String str, int i2) {
        AppMethodBeat.i(94053);
        p.h(str, "tag");
        AppMethodBeat.o(94053);
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void o(kotlin.g.a.b<? super Boolean, x> bVar) {
        this.imw = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ac A[Catch:{ Exception -> 0x00f2 }] */
    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
        // Method dump skipped, instructions count: 259
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.a.c.release():void");
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void fb(boolean z) {
        AppMethodBeat.i(94055);
        try {
            v vVar = this.gGr;
            Camera.Parameters parameters = vVar != null ? vVar.getParameters() : null;
            if (z) {
                if (parameters != null) {
                    parameters.setFlashMode("torch");
                }
            } else if (parameters != null) {
                parameters.setFlashMode("off");
            }
            v vVar2 = this.gGr;
            if (vVar2 != null) {
                vVar2.setParameters(parameters);
                AppMethodBeat.o(94055);
                return;
            }
            AppMethodBeat.o(94055);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "set flash mode error", new Object[0]);
            AppMethodBeat.o(94055);
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final int getFlashMode() {
        Camera.Parameters parameters;
        AppMethodBeat.i(94056);
        v vVar = this.gGr;
        String flashMode = (vVar == null || (parameters = vVar.getParameters()) == null) ? null : parameters.getFlashMode();
        if (flashMode != null) {
            switch (flashMode.hashCode()) {
                case 3551:
                    if (flashMode.equals("on")) {
                        AppMethodBeat.o(94056);
                        return 1;
                    }
                    break;
                case 109935:
                    if (flashMode.equals("off")) {
                        AppMethodBeat.o(94056);
                        return 2;
                    }
                    break;
                case 3005871:
                    if (flashMode.equals("auto")) {
                        AppMethodBeat.o(94056);
                        return 3;
                    }
                    break;
            }
        }
        AppMethodBeat.o(94056);
        return 2;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void setFlashMode(int i2) {
        AppMethodBeat.i(94057);
        switch (i2) {
            case 2:
                fb(false);
                AppMethodBeat.o(94057);
                return;
            case 1:
                fb(true);
                break;
        }
        AppMethodBeat.o(94057);
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final boolean rp(int i2) {
        AppMethodBeat.i(218816);
        try {
            v vVar = this.gGr;
            if (vVar != null) {
                vVar.getParameters();
            }
            AppMethodBeat.o(218816);
            return true;
        } catch (Exception e2) {
            Log.e(this.TAG, "open scene " + i2 + " open failed, error:%s", e2.getMessage());
            AppMethodBeat.o(218816);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final int aPf() {
        Camera.Parameters parameters;
        AppMethodBeat.i(218817);
        v vVar = this.gGr;
        if (vVar == null || (parameters = vVar.getParameters()) == null) {
            AppMethodBeat.o(218817);
            return 0;
        }
        int previewFrameRate = parameters.getPreviewFrameRate();
        AppMethodBeat.o(218817);
        return previewFrameRate;
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final int df(int i2, int i3) {
        int i4;
        AppMethodBeat.i(218818);
        try {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            switch (i3) {
                case 0:
                    i4 = 0;
                    break;
                case 1:
                    i4 = 90;
                    break;
                case 2:
                    i4 = TXLiveConstants.RENDER_ROTATION_180;
                    break;
                case 3:
                    i4 = 270;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (!this.ilM) {
                int i5 = (360 - ((i4 + cameraInfo.orientation) % v2helper.VOIP_ENC_HEIGHT_LV1)) % v2helper.VOIP_ENC_HEIGHT_LV1;
                AppMethodBeat.o(218818);
                return i5;
            }
            int i6 = ((cameraInfo.orientation - i4) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
            AppMethodBeat.o(218818);
            return i6;
        } catch (Exception e2) {
            Log.e(this.TAG, "setCameraDisplayOrientation failed cause " + e2.getMessage());
            AppMethodBeat.o(218818);
            return 0;
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final boolean b(Rect rect, Rect rect2) {
        int i2;
        int i3;
        List<String> list = null;
        AppMethodBeat.i(218820);
        p.h(rect, "focusArea");
        p.h(rect2, "meteringArea");
        try {
            Log.i(this.TAG, "focus on area :: focus rect %s, meter rect %s", rect, rect2);
            v vVar = this.gGr;
            Camera.Parameters parameters = vVar != null ? vVar.getParameters() : null;
            if (parameters != null) {
                list = parameters.getSupportedFocusModes();
            }
            if (list != null && list.contains("auto")) {
                parameters.setFocusMode("auto");
            }
            if (parameters != null) {
                i2 = parameters.getMaxNumFocusAreas();
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(new Camera.Area(rect, 1000));
                if (parameters != null) {
                    parameters.setFocusAreas(arrayList);
                }
            }
            if (parameters != null) {
                i3 = parameters.getMaxNumMeteringAreas();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(new Camera.Area(rect2, 1000));
                if (parameters != null) {
                    parameters.setMeteringAreas(arrayList2);
                }
            }
            v vVar2 = this.gGr;
            if (vVar2 != null) {
                vVar2.setParameters(parameters);
            }
            v vVar3 = this.gGr;
            if (vVar3 != null) {
                vVar3.autoFocus(this.iml);
            }
            AppMethodBeat.o(218820);
            return true;
        } catch (Exception e2) {
            Log.w(this.TAG, "autofocus with area fail, exception %s", e2.getMessage());
            AppMethodBeat.o(218820);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final Rect a(float f2, float f3, float f4, int i2, int i3) {
        AppMethodBeat.i(218821);
        float f5 = 80.0f * f4;
        float f6 = (((f2 / ((float) i2)) * 2000.0f) - 1000.0f) - (f5 / 2.0f);
        float f7 = (((f3 / ((float) i3)) * 2000.0f) - 1000.0f) - (f5 / 2.0f);
        RectF rectF = new RectF();
        rectF.set(f6, f7, f6 + f5, f5 + f7);
        Rect rect = new Rect(android.support.v4.b.a.clamp(kotlin.h.a.cR(rectF.left), -1000, 1000), android.support.v4.b.a.clamp(kotlin.h.a.cR(rectF.top), -1000, 1000), android.support.v4.b.a.clamp(kotlin.h.a.cR(rectF.right), -1000, 1000), android.support.v4.b.a.clamp(kotlin.h.a.cR(rectF.bottom), -1000, 1000));
        AppMethodBeat.o(218821);
        return rect;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final String aPw() {
        String str;
        Camera.Parameters parameters;
        AppMethodBeat.i(218822);
        v vVar = this.gGr;
        if (vVar == null || (parameters = vVar.getParameters()) == null || (str = parameters.getFocusMode()) == null) {
            str = "auto";
        }
        switch (str.hashCode()) {
            case -194628547:
                if (str.equals("continuous-video")) {
                    b.C0437b bVar = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
                    String aQA = b.C0437b.aQA();
                    AppMethodBeat.o(218822);
                    return aQA;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    b.C0437b bVar2 = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
                    String aQC = b.C0437b.aQC();
                    AppMethodBeat.o(218822);
                    return aQC;
                }
                break;
            case 910005312:
                if (str.equals("continuous-picture")) {
                    b.C0437b bVar3 = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
                    String aQB = b.C0437b.aQB();
                    AppMethodBeat.o(218822);
                    return aQB;
                }
                break;
        }
        b.C0437b bVar4 = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
        String aQC2 = b.C0437b.aQC();
        AppMethodBeat.o(218822);
        return aQC2;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final boolean aPx() {
        AppMethodBeat.i(218823);
        try {
            Log.i(this.TAG, "triggerAutoFocus");
            v vVar = this.gGr;
            if (vVar != null) {
                vVar.cancelAutoFocus();
            }
            v vVar2 = this.gGr;
            if (vVar2 != null) {
                vVar2.autoFocus(this.iml);
            }
            AppMethodBeat.o(218823);
            return true;
        } catch (Exception e2) {
            Log.w(this.TAG, "autofocus fail, exception %s", e2.getMessage());
            AppMethodBeat.o(218823);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final boolean v(Context context, boolean z) {
        int aoh;
        int i2;
        AppMethodBeat.i(94019);
        p.h(context, "context");
        try {
            if (this.ilY) {
                Log.i(this.TAG, "initCamera, already open");
                AppMethodBeat.o(94019);
                return true;
            }
            e eVar = e.ilC;
            e.aNk();
            super.v(context, z);
            release();
            if (z) {
                aoh = d.aog();
            } else {
                aoh = d.aoh();
            }
            Log.printInfoStack(this.TAG, "use camera id %d, SrvDeviceInfo id %d", Integer.valueOf(aoh), Integer.valueOf(ae.gKt.gGa));
            this.imk = new e().a(context, aoh, Looper.getMainLooper());
            Log.i(this.TAG, "open camera end, %s", Looper.myLooper());
            if (this.imk == null) {
                Log.i(this.TAG, "open camera FAILED, %s", Looper.myLooper());
                aPa();
                AppMethodBeat.o(94019);
                return false;
            }
            d.a.C0301a aVar = this.imk;
            this.gGr = aVar != null ? aVar.gGr : null;
            this.imv = false;
            q qVar = this.ilR;
            d.a.C0301a aVar2 = this.imk;
            if (aVar2 != null) {
                i2 = aVar2.dYT;
            } else {
                i2 = 0;
            }
            qVar.dYT = i2;
            if (this.gGr == null) {
                Log.e(this.TAG, "start camera FAILED!");
                aPa();
                AppMethodBeat.o(94019);
                return false;
            }
            this.ilY = true;
            AppMethodBeat.o(94019);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "init camera failed!", new Object[0]);
            e eVar2 = e.ilC;
            e.aNm();
            AppMethodBeat.o(94019);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void rw(int i2) {
        int i3;
        AppMethodBeat.i(94031);
        if (this.ilW > 0) {
            AppMethodBeat.o(94031);
            return;
        }
        Point az = ao.az(MMApplicationContext.getContext());
        int i4 = az.y;
        Log.i(this.TAG, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", Integer.valueOf(i2), az);
        if (i4 / 2 >= i2) {
            AppMethodBeat.o(94031);
            return;
        }
        try {
            if (this.gGr != null) {
                v vVar = this.gGr;
                Camera.Parameters parameters = vVar != null ? vVar.getParameters() : null;
                if (parameters != null) {
                    i3 = parameters.getMaxZoom();
                } else {
                    i3 = 0;
                }
                double d2 = ((double) i3) / ((((double) i2) / 3.0d) / 10.0d);
                if (d2 > 0.0d) {
                    this.ilW = ((int) d2) + 1;
                }
                Log.i(this.TAG, "scrollSmallZoomStep: %s, maxZoom: %s", Integer.valueOf(this.ilW), Integer.valueOf(i3));
                AppMethodBeat.o(94031);
                return;
            }
        } catch (Exception e2) {
            Log.e(this.TAG, "calcScrollZoomStep error: %s", e2.getMessage());
        }
        AppMethodBeat.o(94031);
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void setForceZoomTargetRatio(float f2) {
        AppMethodBeat.i(94034);
        if (this.aYc) {
            Log.d(this.TAG, "setForceZoomTargetRatio, zooming, ignore");
            AppMethodBeat.o(94034);
        } else if (this.gGr != null) {
            try {
                v vVar = this.gGr;
                if (vVar == null) {
                    p.hyc();
                }
                Camera.Parameters parameters = vVar.getParameters();
                if (parameters == null) {
                    p.hyc();
                }
                if (parameters.isZoomSupported()) {
                    if (this.imt == null) {
                        Log.d(this.TAG, "setForceZoomTargetRatio before init zoom info, ignore");
                        this.aYc = false;
                        AppMethodBeat.o(94034);
                        return;
                    }
                    List<Integer> zoomRatios = parameters.getZoomRatios();
                    com.tencent.tinker.a.c.b bVar = this.imt;
                    if (bVar == null) {
                        p.hyc();
                    }
                    int indexOf = zoomRatios.indexOf(Integer.valueOf(bVar.get(kotlin.h.a.cR(10.0f * f2))));
                    if (indexOf < 0 || indexOf > parameters.getMaxZoom()) {
                        this.aYc = false;
                        AppMethodBeat.o(94034);
                        return;
                    }
                    this.aYc = true;
                    parameters.setZoom(indexOf);
                    v vVar2 = this.gGr;
                    if (vVar2 == null) {
                        p.hyc();
                    }
                    vVar2.setParameters(parameters);
                    this.aYc = false;
                    AppMethodBeat.o(94034);
                }
            } catch (Exception e2) {
                Log.e(this.TAG, "setForceZoomTargetRatio error: %s", e2.getMessage());
            } finally {
                this.aYc = false;
                AppMethodBeat.o(94034);
            }
        } else {
            AppMethodBeat.o(94034);
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final int aPu() {
        return this.ilM ? 0 : 1;
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final boolean aPg() {
        AppMethodBeat.i(218819);
        if (!p.j(this.ilK.imR, "auto")) {
            AppMethodBeat.o(218819);
            return false;
        }
        v vVar = this.gGr;
        if (vVar != null) {
            vVar.autoFocus(null);
        }
        AppMethodBeat.o(218819);
        return true;
    }
}

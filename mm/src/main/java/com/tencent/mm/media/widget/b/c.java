package com.tencent.mm.media.widget.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.media.ImageReader;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.util.Range;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.media.widget.a.a;
import com.tencent.mm.media.widget.a.a.a;
import com.tencent.mm.media.widget.b.a.a.b;
import com.tencent.mm.media.widget.b.a.c;
import com.tencent.mm.media.widget.camerarecordview.d.b;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\n*\u0002$_\b\u0016\u0018\u0000 ú\u00012\u00020\u0001:\u0002ú\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0007\u0010\u0001\u001a\u00020rJ\u0015\u0010\u0001\u001a\u00020r2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001b\u0010\u0001\u001a\u00020r2\u0007\u0010\u0001\u001a\u00020'2\u0007\u0010\u0001\u001a\u00020'H\u0016J\u001b\u0010\u0001\u001a\u00020'2\u0007\u0010\u0001\u001a\u00020S2\u0007\u0010\u0001\u001a\u00020SH\u0002J7\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020'2\u0007\u0010\u0001\u001a\u00020'H\u0016J\t\u0010\u0001\u001a\u00020rH\u0002J\u0012\u0010\u0001\u001a\u00020\u00192\u0007\u0010\u0001\u001a\u00020'H\u0016J$\u0010\u0001\u001a\u00020'2\u0007\u0010\u0001\u001a\u00020'2\u0007\u0010\u0001\u001a\u00020'2\u0007\u0010\u0001\u001a\u00020'H\u0002J\t\u0010\u0001\u001a\u00020rH\u0002J\u001a\u0010\u0001\u001a\u00020r2\u0007\u0010\u0001\u001a\u00020\u00062\u0006\u0010m\u001a\u00020'H\u0016J!\u0010 \u0001\u001a\u00020\u00192\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001H\u0014J\u001d\u0010¥\u0001\u001a\u00020\u00192\b\u0010¦\u0001\u001a\u00030\u00012\b\u0010§\u0001\u001a\u00030\u0001H\u0016J\u001d\u0010¨\u0001\u001a\u00020\u00192\t\u0010©\u0001\u001a\u0004\u0018\u00010S2\u0007\u0010ª\u0001\u001a\u00020\u0019H\u0016J\f\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0016J\t\u0010­\u0001\u001a\u00020\u0006H\u0016J\t\u0010®\u0001\u001a\u00020'H\u0016J\t\u0010¯\u0001\u001a\u00020'H\u0016J\t\u0010°\u0001\u001a\u00020\u0019H\u0016J\t\u0010±\u0001\u001a\u00020'H\u0016J\t\u0010²\u0001\u001a\u00020'H\u0016J\t\u0010³\u0001\u001a\u00020'H\u0004J\t\u0010´\u0001\u001a\u00020'H\u0014J\u0013\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010·\u0001\u001a\u00020\u0019H\u0016J\t\u0010¸\u0001\u001a\u00020'H\u0014J\u0019\u0010¹\u0001\u001a\f\u0012\u0005\u0012\u00030»\u0001\u0018\u00010º\u0001H\u0016¢\u0006\u0003\u0010¼\u0001J\u000b\u0010½\u0001\u001a\u0004\u0018\u00010hH\u0016J\u001a\u0010¾\u0001\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0007\u0010¿\u0001\u001a\u00020\u0019H\u0016J\t\u0010À\u0001\u001a\u00020rH\u0002J\u0012\u0010Á\u0001\u001a\u00020r2\u0007\u0010Â\u0001\u001a\u00020YH\u0002J\t\u0010Ã\u0001\u001a\u00020rH\u0002J\u0012\u0010Ä\u0001\u001a\u00020r2\u0007\u0010Å\u0001\u001a\u00020\u0006H\u0002J7\u0010Æ\u0001\u001a\u00020r2\u0007\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020'2\u0007\u0010\u0001\u001a\u00020'2\b\u0010Ç\u0001\u001a\u00030È\u0001H\u0016J\t\u0010É\u0001\u001a\u00020rH\u0016J\t\u0010Ê\u0001\u001a\u00020rH\u0016J\u0015\u0010Ë\u0001\u001a\u00020r2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010Ì\u0001\u001a\u00020rH\u0002J\t\u0010Í\u0001\u001a\u00020rH\u0002J\t\u0010Î\u0001\u001a\u00020rH\u0004J\u0014\u0010Ï\u0001\u001a\u00020\u00192\t\u0010Ð\u0001\u001a\u0004\u0018\u00010AH\u0014J\u0014\u0010Ñ\u0001\u001a\u00020\u00192\t\u0010Ð\u0001\u001a\u0004\u0018\u00010AH\u0005J\t\u0010Ò\u0001\u001a\u00020rH\u0002J\u001d\u0010Ó\u0001\u001a\u00020\u00192\t\u0010Ð\u0001\u001a\u0004\u0018\u00010A2\u0007\u0010Ô\u0001\u001a\u00020\u0019H\u0014J\u0013\u0010Õ\u0001\u001a\u00020\u00192\b\u0010@\u001a\u0004\u0018\u00010AH\u0004J\u0012\u0010Ö\u0001\u001a\u00020r2\u0007\u0010Â\u0001\u001a\u00020YH\u0002J\u0012\u0010×\u0001\u001a\u00020\u00192\u0007\u0010Ø\u0001\u001a\u00020'H\u0016J\u001b\u0010Ù\u0001\u001a\u00020'2\u0007\u0010Ú\u0001\u001a\u00020'2\u0007\u0010Û\u0001\u001a\u00020'H\u0016J\u0012\u0010Ü\u0001\u001a\u00020r2\u0007\u0010Ý\u0001\u001a\u00020'H\u0016J\u0012\u0010Þ\u0001\u001a\u00020r2\u0007\u0010ß\u0001\u001a\u00020'H\u0016J\u0012\u0010à\u0001\u001a\u00020r2\u0007\u0010á\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010â\u0001\u001a\u00020r2\u0007\u0010ã\u0001\u001a\u00020\u000bH\u0016J\u001b\u0010ä\u0001\u001a\u00020\u00192\u0007\u0010å\u0001\u001a\u00020'2\u0007\u0010æ\u0001\u001a\u00020'H\u0016J\t\u0010ç\u0001\u001a\u00020rH\u0014J\t\u0010è\u0001\u001a\u00020rH\u0002J'\u0010è\u0001\u001a\u00020r2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\u0007\u0010é\u0001\u001a\u00020\u00192\u0007\u0010Ø\u0001\u001a\u00020'H\u0016J'\u0010è\u0001\u001a\u00020r2\n\u0010ê\u0001\u001a\u0005\u0018\u00010¤\u00012\u0007\u0010é\u0001\u001a\u00020\u00192\u0007\u0010Ø\u0001\u001a\u00020'H\u0016J*\u0010ë\u0001\u001a\u00020r2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\n\u0010ê\u0001\u001a\u0005\u0018\u00010¤\u00012\u0007\u0010Ø\u0001\u001a\u00020'H\u0014J\t\u0010ì\u0001\u001a\u00020\u0019H\u0016J\u001b\u0010í\u0001\u001a\u00020r2\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010î\u0001\u001a\u00020\u0019H\u0016J/\u0010ï\u0001\u001a\u00020\u00192$\u0010ð\u0001\u001a\u001f\u0012\u0015\u0012\u00130ñ\u0001¢\u0006\r\bo\u0012\t\bp\u0012\u0005\b\b(ò\u0001\u0012\u0004\u0012\u00020r0nH\u0016J\t\u0010ó\u0001\u001a\u00020\u0019H\u0016J$\u0010ô\u0001\u001a\u00020r2\u0007\u0010õ\u0001\u001a\u00020\u00192\u0007\u0010ö\u0001\u001a\u00020\u00192\u0007\u0010÷\u0001\u001a\u00020'H\u0016J\u001e\u0010ø\u0001\u001a\u00020r2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010A2\b\b\u0002\u0010&\u001a\u00020'H\u0014J\u001e\u0010ù\u0001\u001a\u00020r2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010A2\b\b\u0002\u0010&\u001a\u00020'H\u0002R\u0016\u0010\u0005\u001a\u00020\u0006XD¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0006XD¢\u0006\u0004\n\u0002\b\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u00020$X\u0004¢\u0006\u0004\n\u0002\u0010%R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00102\u001a\u000203X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u000207X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001a\"\u0004\bH\u0010\u001cR\u001a\u0010I\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001a\"\u0004\bK\u0010\u001cR\u001a\u0010L\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001a\"\u0004\bN\u0010\u001cR\u001a\u0010O\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001a\"\u0004\bQ\u0010\u001cR\u001c\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001c\u0010X\u001a\u0004\u0018\u00010YX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0010\u0010^\u001a\u00020_X\u0004¢\u0006\u0004\n\u0002\u0010`R\u001c\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001c\u0010g\u001a\u0004\u0018\u00010hX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR^\u0010s\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\bo\u0012\b\bp\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020r\u0018\u00010n2#\u0010m\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\bo\u0012\b\bp\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020r\u0018\u00010n@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001a\u0010x\u001a\u00020yX.¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001b\u0010~\u001a\u00020'X\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u0010)\"\u0005\b\u0001\u0010+R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006û\u0001"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/CommonCamera2;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "FOCUS_TAG", "", "getFOCUS_TAG", "()Ljava/lang/String;", "FOCUS_TAG$1", "SMALL_ZOOM_STEP_VAL", "", "getSMALL_ZOOM_STEP_VAL", "()F", "setSMALL_ZOOM_STEP_VAL", "(F)V", "TAG", "TAG$1", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "isUseRecordStream", "", "()Z", "setUseRecordStream", "(Z)V", "mCameraDevice", "Landroid/hardware/camera2/CameraDevice;", "getMCameraDevice", "()Landroid/hardware/camera2/CameraDevice;", "setMCameraDevice", "(Landroid/hardware/camera2/CameraDevice;)V", "mCameraDeviceCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1;", "mCameraFps", "", "getMCameraFps", "()I", "setMCameraFps", "(I)V", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "getMCameraManager", "()Landroid/hardware/camera2/CameraManager;", "setMCameraManager", "(Landroid/hardware/camera2/CameraManager;)V", "mCameraOpenCloseLock", "Ljava/util/concurrent/Semaphore;", "getMCameraOpenCloseLock", "()Ljava/util/concurrent/Semaphore;", "mCaptureCallback", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "getMCaptureCallback", "()Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "mCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "getMCaptureSession", "()Landroid/hardware/camera2/CameraCaptureSession;", "setMCaptureSession", "(Landroid/hardware/camera2/CameraCaptureSession;)V", "mCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "getMCharacteristics", "()Landroid/hardware/camera2/CameraCharacteristics;", "setMCharacteristics", "(Landroid/hardware/camera2/CameraCharacteristics;)V", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "setMIsCameraNoParamAutoFocus", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mIsNoAFRun", "getMIsNoAFRun", "setMIsNoAFRun", "mIsSessionClose", "getMIsSessionClose", "setMIsSessionClose", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mPreviewBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "getMPreviewBuilder", "()Landroid/hardware/camera2/CaptureRequest$Builder;", "setMPreviewBuilder", "(Landroid/hardware/camera2/CaptureRequest$Builder;)V", "mStateCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1;", "mSurface", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mZoomTimesToRatio", "", "getMZoomTimesToRatio", "()[F", "setMZoomTimesToRatio", "([F)V", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "previewRequest", "Landroid/hardware/camera2/CaptureRequest;", "getPreviewRequest", "()Landroid/hardware/camera2/CaptureRequest;", "setPreviewRequest", "(Landroid/hardware/camera2/CaptureRequest;)V", "state", "getState", "setState", "zoomOutRect", "Landroid/graphics/Rect;", "getZoomOutRect", "()Landroid/graphics/Rect;", "setZoomOutRect", "(Landroid/graphics/Rect;)V", "abandonFocus", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "calculateLocDiff", "loc1", "loc2", "calculateTapArea", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "captureStillPicture", "checkCameraOpenSucc", "scene", "clamp", "min", "max", "closeCamera", "configVendorTagValue", "tag", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "focusOnArea", "focusArea", "meteringArea", "focusOnFace", "faceLocation", "isClickScreen", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraCurrentFocusMode", "getCameraOrientation", "getCameraPreviewFps", "getCameraSensorRotate", "getCurrentCameraId", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getPreviewWidth", "getSupportPreviewSize", "", "Landroid/util/Size;", "()[Landroid/util/Size;", "getSupportZoomRatios", "initCamera", "useBack", "initRawRatios", "lock3AParams", "builder", "lockFocus", "openCamera", "nowCameraId", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "resumePreview", "runPrecaptureSequence", "safeResetZoom", "safeSetFocusMode", "characteristics", "safeSetMetering", "safeSetOIS", "safeSetPreviewFrameRate", "useFixMode", "safeSetStabilization", "safeSetVendorEffect", "selectNoCropPreviewSize", "resolutionLimit", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setPreviewSize", "width", "height", "setSafeConfig", "startPreview", "useCpuCrop", "surface", "startPreviewWithGPU", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "trySetPreviewFrameRateParameters", "Companion", "plugin-mediaeditor_release"})
public class c extends com.tencent.mm.media.widget.a.a {
    private static final SparseIntArray inU;
    public static final a inV = new a((byte) 0);
    private final String gVB = "MicroMsg.CommonCamera2";
    ImageReader hiC;
    private float imi = 0.1f;
    private kotlin.g.a.b<? super Boolean, x> imw;
    int imx;
    private boolean imy;
    final String inF = "MicroMsg.CommonCamera2.FoucsTag";
    final Semaphore inG = new Semaphore(1);
    CameraDevice inH;
    CaptureRequest.Builder inI;
    CameraCaptureSession inJ;
    protected CaptureRequest inK;
    CameraCharacteristics inL;
    boolean inM;
    boolean inN;
    private boolean inO;
    private Rect inP;
    private float[] inQ;
    private final e inR;
    private final C0429c inS;
    private final CameraCaptureSession.CaptureCallback inT;
    private CameraManager inc;
    private Surface mSurface;
    int state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(94167);
        if (com.tencent.mm.media.widget.d.b.aRG()) {
            com.tencent.mm.media.widget.b.a.c cVar = new com.tencent.mm.media.widget.b.a.c(context);
            AnonymousClass1 r0 = AnonymousClass1.inW;
            p.h(r0, "mSupportWCKeyAvailable");
            new Thread(new c.a(cVar, new c.b(cVar, r0))).start();
            b bVar = b.inE;
            b.aPF();
        }
        this.inR = new e(this);
        this.inS = new C0429c(this);
        this.inT = new d(this);
        this.imy = true;
        AppMethodBeat.o(94167);
    }

    public static final /* synthetic */ void c(c cVar) {
        AppMethodBeat.i(94170);
        cVar.aPL();
        AppMethodBeat.o(94170);
    }

    /* access modifiers changed from: protected */
    public final void a(CaptureRequest captureRequest) {
        AppMethodBeat.i(218847);
        p.h(captureRequest, "<set-?>");
        this.inK = captureRequest;
        AppMethodBeat.o(218847);
    }

    /* access modifiers changed from: protected */
    public final CaptureRequest aPJ() {
        AppMethodBeat.i(218846);
        CaptureRequest captureRequest = this.inK;
        if (captureRequest == null) {
            p.btv("previewRequest");
        }
        AppMethodBeat.o(218846);
        return captureRequest;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onClosed", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigureFailed", "onConfigured", "plugin-mediaeditor_release"})
    public static final class e extends CameraCaptureSession.StateCallback {
        final /* synthetic */ c inX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(c cVar) {
            this.inX = cVar;
        }

        public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
            AppMethodBeat.i(94125);
            p.h(cameraCaptureSession, "session");
            Log.i(this.inX.gVB, "session on onConfigured");
            if (this.inX.inH == null) {
                AppMethodBeat.o(94125);
                return;
            }
            this.inX.inM = false;
            this.inX.inJ = cameraCaptureSession;
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNl();
            com.tencent.mm.media.widget.d.a aVar = com.tencent.mm.media.widget.d.a.itg;
            com.tencent.mm.media.widget.d.a.aRc();
            c.b(this.inX);
            AppMethodBeat.o(94125);
        }

        public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            AppMethodBeat.i(94126);
            p.h(cameraCaptureSession, "session");
            Log.i(this.inX.gVB, "configure failed ");
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNm();
            com.tencent.mm.media.widget.d.a aVar = com.tencent.mm.media.widget.d.a.itg;
            com.tencent.mm.media.widget.d.a.aRd();
            AppMethodBeat.o(94126);
        }

        public final void onClosed(CameraCaptureSession cameraCaptureSession) {
            AppMethodBeat.i(94127);
            p.h(cameraCaptureSession, "session");
            super.onClosed(cameraCaptureSession);
            Log.i(this.inX.gVB, "session on close");
            this.inX.inM = true;
            AppMethodBeat.o(94127);
        }
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final boolean v(Context context, boolean z) {
        String ry;
        CameraCharacteristics cameraCharacteristics;
        AppMethodBeat.i(94128);
        p.h(context, "context");
        try {
            Object systemService = MMApplicationContext.getContext().getSystemService("camera");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
                AppMethodBeat.o(94128);
                throw tVar;
            }
            this.inc = (CameraManager) systemService;
            b bVar = b.inE;
            b.a(this.inc);
            if (this.ilY) {
                Log.i(this.gVB, "initCamera, already open");
                AppMethodBeat.o(94128);
                return true;
            }
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNk();
            super.v(context, z);
            release();
            aPK();
            if (z) {
                b bVar2 = b.inE;
                ry = b.ry(b.ind);
            } else {
                b bVar3 = b.inE;
                ry = b.ry(b.ine);
            }
            Log.printInfoStack(this.gVB, "use camera id %s, SrvDeviceInfo id %d", ry, Integer.valueOf(ae.gKt.gGa));
            com.tencent.mm.media.widget.d.a aVar = com.tencent.mm.media.widget.d.a.itg;
            com.tencent.mm.media.widget.d.a.aRb();
            Context context2 = this.context;
            if (context2 == null) {
                p.hyc();
            }
            if (!Util.checkPermission(context2, "android.permission.CAMERA")) {
                Log.e(this.gVB, "it was lack of the camera permision to open camera");
            } else {
                try {
                    if (!this.inG.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                        RuntimeException runtimeException = new RuntimeException("Time out waiting to lock camera opening");
                        AppMethodBeat.o(94128);
                        throw runtimeException;
                    }
                    try {
                        CameraManager cameraManager = this.inc;
                        if (cameraManager == null) {
                            p.hyc();
                        }
                        cameraManager.openCamera(ry, this.inS, this.ilK.imK);
                    } catch (CameraAccessException e2) {
                    }
                    b bVar4 = b.inE;
                    b.inn = ry;
                    if (ry == null) {
                        p.hyc();
                    }
                    p.h(ry, "id");
                    CameraManager cameraManager2 = b.inc;
                    if (cameraManager2 != null) {
                        cameraCharacteristics = cameraManager2.getCameraCharacteristics(ry);
                    } else {
                        cameraCharacteristics = null;
                    }
                    if (cameraCharacteristics == null) {
                        p.hyc();
                    }
                    Object obj = cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                    if (obj == null) {
                        p.hyc();
                    }
                    b.inp = ((Number) obj).intValue();
                } catch (InterruptedException e3) {
                    RuntimeException runtimeException2 = new RuntimeException("interrupt while  trying to lock camera opening", e3);
                    AppMethodBeat.o(94128);
                    throw runtimeException2;
                }
            }
            AppMethodBeat.o(94128);
            return true;
        } catch (Exception e4) {
            Log.printErrStackTrace(this.gVB, e4, "init camera failed!", new Object[0]);
            com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNm();
            AppMethodBeat.o(94128);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onDisconnected", "", "camera", "Landroid/hardware/camera2/CameraDevice;", "onError", "error", "", "onOpened", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.b.c$c  reason: collision with other inner class name */
    public static final class C0429c extends CameraDevice.StateCallback {
        final /* synthetic */ c inX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0429c(c cVar) {
            this.inX = cVar;
        }

        public final void onOpened(CameraDevice cameraDevice) {
            AppMethodBeat.i(94119);
            p.h(cameraDevice, "camera");
            this.inX.inG.release();
            this.inX.inH = cameraDevice;
            AppMethodBeat.o(94119);
        }

        public final void onDisconnected(CameraDevice cameraDevice) {
            AppMethodBeat.i(94120);
            p.h(cameraDevice, "camera");
            this.inX.inG.release();
            cameraDevice.close();
            this.inX.inH = null;
            AppMethodBeat.o(94120);
        }

        public final void onError(CameraDevice cameraDevice, int i2) {
            AppMethodBeat.i(94121);
            p.h(cameraDevice, "camera");
            onDisconnected(cameraDevice);
            AppMethodBeat.o(94121);
        }
    }

    private final void aPK() {
        AppMethodBeat.i(94129);
        try {
            if (this.inI != null) {
                b bVar = b.inE;
                CaptureRequest.Builder builder = this.inI;
                if (builder == null) {
                    p.hyc();
                }
                b.g(builder);
            }
            this.inG.acquire();
            CameraCaptureSession cameraCaptureSession = this.inJ;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
            }
            this.inJ = null;
            CameraDevice cameraDevice = this.inH;
            if (cameraDevice != null) {
                cameraDevice.close();
            }
            this.inH = null;
            ImageReader imageReader = this.hiC;
            if (imageReader != null) {
                imageReader.setOnImageAvailableListener(null, this.ilK.imK);
            }
            ImageReader imageReader2 = this.hiC;
            if (imageReader2 != null) {
                imageReader2.close();
            }
            this.hiC = null;
            this.inG.release();
            AppMethodBeat.o(94129);
        } catch (InterruptedException e2) {
            RuntimeException runtimeException = new RuntimeException("Interrupt while trying to lock camera closing", e2);
            AppMethodBeat.o(94129);
            throw runtimeException;
        } catch (Throwable th) {
            this.inG.release();
            AppMethodBeat.o(94129);
            throw th;
        }
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final void a(SurfaceTexture surfaceTexture, boolean z, int i2) {
        AppMethodBeat.i(94130);
        this.inG.acquire();
        this.inG.release();
        super.a(surfaceTexture, z, i2);
        b(surfaceTexture, null, i2);
        AppMethodBeat.o(94130);
    }

    @Override // com.tencent.mm.media.widget.a.a
    public final void a(SurfaceHolder surfaceHolder, boolean z, int i2) {
        AppMethodBeat.i(94131);
        this.inG.acquire();
        this.inG.release();
        super.a(surfaceHolder, z, i2);
        b(null, surfaceHolder, i2);
        AppMethodBeat.o(94131);
    }

    /* access modifiers changed from: protected */
    public void b(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder, int i2) {
        CaptureRequest.Builder builder = null;
        AppMethodBeat.i(94132);
        long currentTicks = Util.currentTicks();
        Log.i(this.gVB, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + surfaceTexture + ", surface:" + surfaceHolder);
        if (aPc()) {
            Log.i(this.gVB, "startPreviewWithGPU, camera previewing");
            AppMethodBeat.o(94132);
            return;
        }
        try {
            if (this.inN) {
                CameraDevice cameraDevice = this.inH;
                if (cameraDevice != null) {
                    builder = cameraDevice.createCaptureRequest(3);
                }
            } else {
                CameraDevice cameraDevice2 = this.inH;
                if (cameraDevice2 != null) {
                    builder = cameraDevice2.createCaptureRequest(1);
                }
            }
            this.inI = builder;
            rq(i2);
            aPp();
            if (a(surfaceTexture, surfaceHolder)) {
                a(a.EnumC0424a.CAMERA_IS_PREVIEWING);
                this.state = 0;
            }
        } catch (Exception e2) {
            Log.e(this.gVB, "start preview FAILED, %s, %s", Looper.myLooper(), e2.getMessage());
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNm();
        }
        Log.i(this.gVB, "start preview end, use %dms %s", Long.valueOf(Util.ticksToNow(currentTicks)), Looper.myLooper());
        AppMethodBeat.o(94132);
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void o(kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(94133);
        this.imw = bVar;
        b bVar2 = b.inE;
        b.o(bVar);
        AppMethodBeat.o(94133);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0011"}, hxF = {"com/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "capturePicture", "", "result", "Landroid/hardware/camera2/CaptureResult;", "checkFocusEnd", "", "onCaptureCompleted", "session", "Landroid/hardware/camera2/CameraCaptureSession;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Landroid/hardware/camera2/CaptureRequest;", "Landroid/hardware/camera2/TotalCaptureResult;", "onCaptureProgressed", "partialResult", "process", "plugin-mediaeditor_release"})
    public static final class d extends CameraCaptureSession.CaptureCallback {
        final /* synthetic */ c inX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(c cVar) {
            this.inX = cVar;
        }

        private final void b(CaptureResult captureResult) {
            boolean z;
            Integer num;
            AppMethodBeat.i(94122);
            switch (this.inX.state) {
                case 0:
                    b bVar = b.inE;
                    b.a(captureResult);
                    AppMethodBeat.o(94122);
                    return;
                case 1:
                    Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                    if (num2 == null || 2 == num2.intValue() || 6 == num2.intValue()) {
                        c.c(this.inX);
                        AppMethodBeat.o(94122);
                        return;
                    }
                    if (4 == num2.intValue() || 5 == num2.intValue()) {
                        Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                        if (num3 == null || num3.intValue() == 2) {
                            c.c(this.inX);
                            AppMethodBeat.o(94122);
                            return;
                        }
                        c.d(this.inX);
                    }
                    AppMethodBeat.o(94122);
                    return;
                case 2:
                    Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num4 == null || num4.intValue() == 5 || num4.intValue() == 4) {
                        this.inX.state = 3;
                        AppMethodBeat.o(94122);
                        return;
                    }
                case 3:
                    Integer num5 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num5 == null || num5.intValue() != 5) {
                        c.c(this.inX);
                        AppMethodBeat.o(94122);
                        return;
                    }
                case 5:
                    if (this.inX.aPc()) {
                        p.h(captureResult, "result");
                        Integer num6 = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                        if ((num6 != null && num6.intValue() == 4) || ((num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE)) != null && num.intValue() == 5)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && !this.inX.inM) {
                            Log.i(this.inX.inF, "STATE_TOUCH_CAF_WAITING and state is  " + ((Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE)));
                            this.inX.a(this.inX.inL);
                            CaptureRequest.Builder builder = this.inX.inI;
                            if (builder != null) {
                                builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                            }
                            c cVar = this.inX;
                            CaptureRequest.Builder builder2 = this.inX.inI;
                            CaptureRequest build = builder2 != null ? builder2.build() : null;
                            if (build == null) {
                                p.hyc();
                            }
                            cVar.a(build);
                            try {
                                CameraCaptureSession cameraCaptureSession = this.inX.inJ;
                                if (cameraCaptureSession != null) {
                                    cameraCaptureSession.setRepeatingRequest(this.inX.aPJ(), this, this.inX.ilK.imK);
                                }
                            } catch (CameraAccessException e2) {
                                Log.e(this.inX.gVB, "setRepeatingRequest failed, errMsg: ");
                            }
                            this.inX.state = 6;
                            AppMethodBeat.o(94122);
                            return;
                        }
                    }
                    Log.e(this.inX.gVB, "current is not allowed to do anything casue capturing");
                    AppMethodBeat.o(94122);
                    return;
                case 6:
                    if (!this.inX.aPc() || this.inX.inM) {
                        Log.e(this.inX.gVB, "current is not allowed to do anything casue capturing");
                        break;
                    } else {
                        Log.i(this.inX.inF, "STATE_TOUCH_FOCUSING and state is  " + ((Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE)));
                        CaptureRequest.Builder builder3 = this.inX.inI;
                        if (builder3 != null) {
                            builder3.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                        }
                        CaptureRequest.Builder builder4 = this.inX.inI;
                        if (builder4 != null) {
                            builder4.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
                        }
                        c cVar2 = this.inX;
                        CaptureRequest.Builder builder5 = this.inX.inI;
                        CaptureRequest build2 = builder5 != null ? builder5.build() : null;
                        if (build2 == null) {
                            p.hyc();
                        }
                        cVar2.a(build2);
                        try {
                            CameraCaptureSession cameraCaptureSession2 = this.inX.inJ;
                            if (cameraCaptureSession2 != null) {
                                cameraCaptureSession2.setRepeatingRequest(this.inX.aPJ(), this, this.inX.ilK.imK);
                            }
                        } catch (CameraAccessException e3) {
                            Log.e(this.inX.gVB, "setRepeatingRequest failed, errMsg: ");
                        }
                        this.inX.ilK.imQ = true;
                        this.inX.state = 0;
                        AppMethodBeat.o(94122);
                        return;
                    }
            }
            AppMethodBeat.o(94122);
        }

        public final void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            AppMethodBeat.i(94123);
            p.h(cameraCaptureSession, "session");
            p.h(captureRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(captureResult, "partialResult");
            b(captureResult);
            AppMethodBeat.o(94123);
        }

        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            AppMethodBeat.i(94124);
            p.h(cameraCaptureSession, "session");
            p.h(captureRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(totalCaptureResult, "result");
            b(totalCaptureResult);
            AppMethodBeat.o(94124);
        }
    }

    private final void aPL() {
        Rect rect;
        CaptureRequest.Builder builder;
        c cVar;
        CaptureRequest.Builder createCaptureRequest;
        boolean z;
        int[] iArr;
        CaptureRequest captureRequest = null;
        AppMethodBeat.i(94134);
        try {
            if (this.state == 4) {
                Log.printInfoStack(this.gVB, "capture still picture more than twice", new Object[0]);
                AppMethodBeat.o(94134);
                return;
            }
            this.state = 4;
            Log.i(this.gVB, "captureStillPicture");
            if (this.inH == null) {
                AppMethodBeat.o(94134);
                return;
            }
            CaptureRequest.Builder builder2 = this.inI;
            if (builder2 != null) {
                rect = (Rect) builder2.get(CaptureRequest.SCALER_CROP_REGION);
            } else {
                rect = null;
            }
            if (this.inH == null || this.inM) {
                AppMethodBeat.o(94134);
                return;
            }
            CameraDevice cameraDevice = this.inH;
            if (cameraDevice == null || (createCaptureRequest = cameraDevice.createCaptureRequest(2)) == null) {
                builder = null;
                cVar = this;
            } else {
                createCaptureRequest.set(CaptureRequest.SCALER_CROP_REGION, rect);
                ImageReader imageReader = this.hiC;
                Surface surface = imageReader != null ? imageReader.getSurface() : null;
                if (surface == null) {
                    p.hyc();
                }
                createCaptureRequest.addTarget(surface);
                ImageReader imageReader2 = this.hiC;
                if (imageReader2 != null) {
                    imageReader2.setOnImageAvailableListener(this.ilK.imS, this.ilK.imK);
                }
                p.g(createCaptureRequest, "this");
                createCaptureRequest.set(CaptureRequest.CONTROL_MODE, 1);
                CameraCharacteristics cameraCharacteristics = this.inL;
                Float f2 = cameraCharacteristics != null ? (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE) : null;
                if (f2 == null || p.a(f2)) {
                    z = true;
                } else {
                    z = false;
                }
                this.inO = z;
                if (!this.inO) {
                    CameraCharacteristics cameraCharacteristics2 = this.inL;
                    if (cameraCharacteristics2 != null) {
                        iArr = (int[]) cameraCharacteristics2.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
                    } else {
                        iArr = null;
                    }
                    if (com.tencent.mm.compatible.loader.a.contains(iArr, 4)) {
                        createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 4);
                    } else {
                        createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 1);
                    }
                }
                createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 1);
                CameraCharacteristics cameraCharacteristics3 = this.inL;
                if (com.tencent.mm.compatible.loader.a.contains(cameraCharacteristics3 != null ? (int[]) cameraCharacteristics3.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES) : null, 1)) {
                    createCaptureRequest.set(CaptureRequest.CONTROL_AWB_MODE, 1);
                }
                createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 4);
                h(createCaptureRequest);
                builder = createCaptureRequest;
                cVar = this;
            }
            cVar.inI = builder;
            CameraCaptureSession cameraCaptureSession = this.inJ;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.stopRepeating();
                Log.i(this.inF, "this time happened a cancel auto foucs while capture");
                CaptureRequest.Builder builder3 = this.inI;
                if (builder3 != null) {
                    builder3.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                }
                CaptureRequest.Builder builder4 = this.inI;
                if (builder4 != null) {
                    captureRequest = builder4.build();
                }
                if (captureRequest == null) {
                    p.hyc();
                }
                cameraCaptureSession.capture(captureRequest, new b(this), null);
                AppMethodBeat.o(94134);
                return;
            }
            AppMethodBeat.o(94134);
        } catch (Exception e2) {
            b bVar = b.inE;
            if (!b.aPB()) {
                com.tencent.mm.media.widget.d.a aVar = com.tencent.mm.media.widget.d.a.itg;
                com.tencent.mm.media.widget.d.a.aRi();
            }
            Log.e(this.gVB, e2.toString());
            AppMethodBeat.o(94134);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n¸\u0006\u0000"}, hxF = {"com/tencent/mm/media/widget/camera2/CommonCamera2$captureStillPicture$2$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "onCaptureCompleted", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Landroid/hardware/camera2/CaptureRequest;", "result", "Landroid/hardware/camera2/TotalCaptureResult;", "plugin-mediaeditor_release"})
    public static final class b extends CameraCaptureSession.CaptureCallback {
        final /* synthetic */ c inX;

        b(c cVar) {
            this.inX = cVar;
        }

        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            AppMethodBeat.i(94118);
            p.h(cameraCaptureSession, "session");
            p.h(captureRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(totalCaptureResult, "result");
            b bVar = b.inE;
            CaptureRequest.Builder builder = this.inX.inI;
            if (builder == null) {
                p.hyc();
            }
            b.g(builder);
            AppMethodBeat.o(94118);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean a(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder) {
        int i2;
        int i3;
        Surface surface;
        Surface surface2;
        Surface surface3 = null;
        AppMethodBeat.i(94135);
        CaptureRequest.Builder builder = this.inI;
        if (builder == null) {
            AppMethodBeat.o(94135);
            return false;
        } else if (surfaceTexture == null && surfaceHolder == null) {
            Log.i(this.gVB, "doStartPreview error, surfaceTexture and surface is null");
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNm();
            com.tencent.mm.media.widget.d.a aVar = com.tencent.mm.media.widget.d.a.itg;
            com.tencent.mm.media.widget.d.a.aRd();
            AppMethodBeat.o(94135);
            return false;
        } else {
            if (surfaceTexture != null) {
                this.mSurface = new Surface(surfaceTexture);
            } else if (surfaceHolder != null) {
                this.mSurface = surfaceHolder.getSurface();
            }
            Surface surface4 = this.mSurface;
            if (surface4 == null) {
                p.hyc();
            }
            builder.addTarget(surface4);
            b bVar = b.inE;
            if (b.aPI()) {
                if (this.inN) {
                    b bVar2 = b.inE;
                    CaptureRequest.Builder builder2 = this.inI;
                    if (builder2 == null) {
                        p.hyc();
                    }
                    b.a aVar2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
                    i2 = b.a(builder2, j.listOf(com.tencent.mm.media.widget.b.a.a.b.aQc()));
                    if (Build.VERSION.SDK_INT >= 28) {
                        Surface surface5 = this.mSurface;
                        if (surface5 == null) {
                            p.hyc();
                        }
                        SessionConfiguration sessionConfiguration = new SessionConfiguration(i2, j.listOf(new OutputConfiguration(surface5)), AsyncTask.THREAD_POOL_EXECUTOR, this.inR);
                        CameraDevice cameraDevice = this.inH;
                        if (cameraDevice == null) {
                            p.hyc();
                        }
                        cameraDevice.createCaptureSession(sessionConfiguration);
                        i3 = i2;
                    }
                    i3 = i2;
                } else {
                    b bVar3 = b.inE;
                    CaptureRequest.Builder builder3 = this.inI;
                    if (builder3 == null) {
                        p.hyc();
                    }
                    b.a aVar3 = com.tencent.mm.media.widget.b.a.a.b.ipa;
                    b.a aVar4 = com.tencent.mm.media.widget.b.a.a.b.ipa;
                    b.a aVar5 = com.tencent.mm.media.widget.b.a.a.b.ipa;
                    i2 = b.a(builder3, j.listOf((Object[]) new String[]{com.tencent.mm.media.widget.b.a.a.b.aQb(), com.tencent.mm.media.widget.b.a.a.b.aQa(), com.tencent.mm.media.widget.b.a.a.b.aQd()}));
                    if (Build.VERSION.SDK_INT >= 28) {
                        OutputConfiguration[] outputConfigurationArr = new OutputConfiguration[2];
                        Surface surface6 = this.mSurface;
                        if (surface6 == null) {
                            p.hyc();
                        }
                        outputConfigurationArr[0] = new OutputConfiguration(surface6);
                        ImageReader imageReader = this.hiC;
                        if (imageReader != null) {
                            surface = imageReader.getSurface();
                        } else {
                            surface = null;
                        }
                        if (surface == null) {
                            p.hyc();
                        }
                        outputConfigurationArr[1] = new OutputConfiguration(surface);
                        SessionConfiguration sessionConfiguration2 = new SessionConfiguration(i2, j.listOf((Object[]) outputConfigurationArr), AsyncTask.THREAD_POOL_EXECUTOR, this.inR);
                        CameraDevice cameraDevice2 = this.inH;
                        if (cameraDevice2 == null) {
                            p.hyc();
                        }
                        cameraDevice2.createCaptureSession(sessionConfiguration2);
                    }
                    i3 = i2;
                }
                if (i3 == 0) {
                    CameraDevice cameraDevice3 = this.inH;
                    if (cameraDevice3 == null) {
                        p.hyc();
                    }
                    Surface[] surfaceArr = new Surface[2];
                    surfaceArr[0] = this.mSurface;
                    ImageReader imageReader2 = this.hiC;
                    if (imageReader2 != null) {
                        surface2 = imageReader2.getSurface();
                    } else {
                        surface2 = null;
                    }
                    surfaceArr[1] = surface2;
                    cameraDevice3.createCaptureSession(j.listOf((Object[]) surfaceArr), this.inR, this.ilK.imK);
                }
            } else {
                CameraDevice cameraDevice4 = this.inH;
                if (cameraDevice4 == null) {
                    p.hyc();
                }
                Surface[] surfaceArr2 = new Surface[2];
                surfaceArr2[0] = this.mSurface;
                ImageReader imageReader3 = this.hiC;
                if (imageReader3 != null) {
                    surface3 = imageReader3.getSurface();
                }
                surfaceArr2[1] = surface3;
                cameraDevice4.createCaptureSession(j.listOf((Object[]) surfaceArr2), this.inR, this.ilK.imK);
            }
            Log.i(this.gVB, "doStartPreview finish");
            AppMethodBeat.o(94135);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void aPp() {
        Integer num;
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int[] iArr;
        boolean z6;
        HashMap<Integer, b.a.c> hashMap;
        b.a.c cVar;
        b.a aVar;
        HashMap<Integer, b.a.c> hashMap2;
        b.a.c cVar2;
        HashMap<Integer, b.a.c> hashMap3;
        AppMethodBeat.i(94136);
        com.tencent.mm.plugin.mmsight.model.a.l ekc = com.tencent.mm.plugin.mmsight.model.a.l.ekc();
        p.g(ekc, "MMSightController.getInstance()");
        if (ekc.ekd() != null) {
            com.tencent.mm.plugin.mmsight.model.a.l ekc2 = com.tencent.mm.plugin.mmsight.model.a.l.ekc();
            p.g(ekc2, "MMSightController.getInstance()");
            num = Integer.valueOf(ekc2.ekd().zsR);
        } else {
            num = 0;
        }
        String str2 = this.gVB;
        Object[] objArr = new Object[6];
        objArr[0] = num;
        if (ae.gKt.gFU == 1) {
            str = "Range";
        } else {
            str = ae.gKt.gFT == 1 ? "Fix" : "Error";
        }
        objArr[1] = str;
        if (ae.gKt.gFV == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        if (ae.gKt.gFW == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[3] = Boolean.valueOf(z2);
        if (ae.gKt.gFX == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        objArr[4] = Boolean.valueOf(z3);
        if (ae.gKt.gFY == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        objArr[5] = Boolean.valueOf(z4);
        Log.i(str2, "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", objArr);
        if (ae.gKt.gFU == 1 && (num.intValue() == 0 || num.intValue() == 1)) {
            z5 = false;
        } else if (ae.gKt.gFT == 1 && (num.intValue() == 0 || num.intValue() == 5)) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.ilS != null) {
            b.a aVar2 = this.ilS;
            if (aVar2 != null) {
                hashMap = aVar2.irc;
            } else {
                hashMap = null;
            }
            if (hashMap != null) {
                b.a aVar3 = this.ilS;
                if (aVar3 == null || (hashMap3 = aVar3.irc) == null) {
                    cVar = null;
                } else {
                    cVar = hashMap3.get(Integer.valueOf(aPu()));
                }
                if (!(cVar == null || (aVar = this.ilS) == null || (hashMap2 = aVar.irc) == null || (cVar2 = hashMap2.get(Integer.valueOf(aPu()))) == null)) {
                    Integer num2 = cVar2.iri;
                    if (num2 != null) {
                        this.imx = num2.intValue();
                    }
                    Boolean bool = cVar2.irj;
                    if (bool != null) {
                        z5 = bool.booleanValue();
                    }
                }
            }
        }
        a(this.inL, z5);
        if (ae.gKt.gFV == 1 && num.intValue() != 0) {
            num.intValue();
        }
        if (ae.gKA.gIX != -1 && ae.gKA.gIX == 1 && com.tencent.mm.compatible.util.d.oF(14)) {
            b(this.inL);
        }
        if (ae.gKt.gFX == 1 && (num.intValue() == 0 || num.intValue() == 4)) {
            a(this.inL);
        }
        if (ae.gKt.gFY == 1 && num.intValue() != 0) {
            num.intValue();
        }
        CameraCharacteristics cameraCharacteristics = this.inL;
        Rect rect = cameraCharacteristics != null ? (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE) : null;
        if (rect != null) {
            Rect rect2 = new Rect(rect.left * 1, rect.top * 1, rect.right * 1, rect.bottom * 1);
            CaptureRequest.Builder builder = this.inI;
            if (builder != null) {
                builder.set(CaptureRequest.SCALER_CROP_REGION, rect2);
            }
        }
        CameraCharacteristics cameraCharacteristics2 = this.inL;
        if (cameraCharacteristics2 != null) {
            iArr = (int[]) cameraCharacteristics2.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
        } else {
            iArr = null;
        }
        if (iArr != null) {
            Log.i(this.gVB, "oisMode:" + Arrays.toString(iArr));
            if (iArr.length == 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            if ((!z6) && kotlin.a.e.contains(iArr, 1)) {
                com.tencent.mm.media.widget.d.a aVar4 = com.tencent.mm.media.widget.d.a.itg;
                com.tencent.mm.media.widget.d.a.aRj();
                b bVar = b.inE;
                b.ff(false);
                CaptureRequest.Builder builder2 = this.inI;
                if (builder2 != null) {
                    builder2.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
                }
            }
        }
        CaptureRequest.Builder builder3 = this.inI;
        if (builder3 == null) {
            p.hyc();
        }
        h(builder3);
        AppMethodBeat.o(94136);
    }

    @Override // com.tencent.mm.media.widget.a.d
    public void b(float f2, float f3, int i2, int i3) {
        AppMethodBeat.i(94137);
        if (com.tencent.mm.compatible.util.d.oE(14)) {
            AppMethodBeat.o(94137);
        } else if (this.inH == null || this.inJ == null) {
            AppMethodBeat.o(94137);
        } else if (!aPc()) {
            AppMethodBeat.o(94137);
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
            aVar3.sendMessageDelayed(aVar4.obtainMessage(com.tencent.mm.media.widget.a.a.a.aPz()), 400);
            AppMethodBeat.o(94137);
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public void aPq() {
        AppMethodBeat.i(94138);
        if (!aPc()) {
            AppMethodBeat.o(94138);
            return;
        }
        com.tencent.mm.media.widget.a.a.a aVar = this.ilK;
        a.C0425a aVar2 = com.tencent.mm.media.widget.a.a.a.imU;
        aVar.removeMessages(com.tencent.mm.media.widget.a.a.a.aPz());
        AppMethodBeat.o(94138);
    }

    @Override // com.tencent.mm.media.widget.a.d
    public void i(boolean z, int i2) {
        Rect rect;
        AppMethodBeat.i(94140);
        if (this.inH == null || !aPc()) {
            AppMethodBeat.o(94140);
            return;
        }
        try {
            Log.d(this.gVB, "triggerSmallZoom, zoom: %s", Boolean.valueOf(z));
            if (this.aYc) {
                Log.d(this.gVB, "triggerSmallZoom, zooming, ignore");
                return;
            }
            this.aYc = true;
            CaptureRequest.Builder builder = this.inI;
            Rect rect2 = builder != null ? (Rect) builder.get(CaptureRequest.SCALER_CROP_REGION) : null;
            CameraCharacteristics cameraCharacteristics = this.inL;
            if (cameraCharacteristics != null) {
                rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            } else {
                rect = null;
            }
            if (rect == null) {
                p.hyc();
            }
            float width = (float) rect.width();
            if (rect2 == null) {
                p.hyc();
            }
            float width2 = width / ((float) rect2.width());
            CameraCharacteristics cameraCharacteristics2 = this.inL;
            if (cameraCharacteristics2 == null) {
                p.hyc();
            }
            Float f2 = (Float) cameraCharacteristics2.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
            if (f2 == null) {
                f2 = Float.valueOf(0.0f);
            }
            p.g(f2, "mCharacteristics!!.get(C…_MAX_DIGITAL_ZOOM)?: 0.0f");
            float floatValue = f2.floatValue();
            if (z) {
                if (width2 >= floatValue) {
                    this.aYc = false;
                    AppMethodBeat.o(94140);
                    return;
                }
                float f3 = this.imi + width2;
                if (f3 < floatValue) {
                    floatValue = f3;
                }
            } else if (width2 == 1.0f) {
                this.aYc = false;
                AppMethodBeat.o(94140);
                return;
            } else {
                floatValue = width2 - this.imi;
                if (floatValue <= 1.0f) {
                    floatValue = 1.0f;
                }
            }
            Log.d(this.gVB, "triggerSmallZoom, nextZoom: %s", Float.valueOf(floatValue));
            float width3 = ((float) rect.width()) / floatValue;
            float height = ((float) rect.height()) / floatValue;
            float width4 = (((float) rect.width()) - width3) / 2.0f;
            float height2 = (((float) rect.height()) - height) / 2.0f;
            Rect rect3 = new Rect((int) width4, (int) height2, (int) (width3 + width4), (int) (height + height2));
            CaptureRequest.Builder builder2 = this.inI;
            if (builder2 != null) {
                builder2.set(CaptureRequest.SCALER_CROP_REGION, rect3);
            }
            if (!this.inM) {
                try {
                    CameraCaptureSession cameraCaptureSession = this.inJ;
                    if (cameraCaptureSession != null) {
                        CaptureRequest.Builder builder3 = this.inI;
                        if (builder3 == null) {
                            p.hyc();
                        }
                        cameraCaptureSession.setRepeatingRequest(builder3.build(), this.inT, this.ilK.imK);
                    }
                } catch (CameraAccessException e2) {
                }
            }
            this.aYc = false;
            AppMethodBeat.o(94140);
        } catch (Exception e3) {
            Log.e(this.gVB, "triggerSmallZoom error: %s", e3.getMessage());
        } finally {
            this.aYc = false;
            AppMethodBeat.o(94140);
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final float[] getSupportZoomRatios() {
        AppMethodBeat.i(94141);
        if (this.inQ == null && this.inL != null) {
            CameraCharacteristics cameraCharacteristics = this.inL;
            if (cameraCharacteristics == null) {
                p.hyc();
            }
            Float f2 = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
            if (f2 == null) {
                f2 = Float.valueOf(0.0f);
            }
            p.g(f2, "mCharacteristics!!.get(C…_MAX_DIGITAL_ZOOM)?: 0.0f");
            float floatValue = (((float) ((int) (f2.floatValue() * 10.0f))) * 1.0f) / 10.0f;
            this.inQ = new float[((int) (floatValue * 10.0f))];
            int i2 = (int) (floatValue * 10.0f);
            for (int i3 = 0; i3 < i2; i3++) {
                float[] fArr = this.inQ;
                if (fArr == null) {
                    p.hyc();
                }
                fArr[i3] = ((((float) i3) * 1.0f) / 10.0f) + 1.0f;
            }
        }
        float[] fArr2 = this.inQ;
        AppMethodBeat.o(94141);
        return fArr2;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public com.tencent.mm.media.widget.a.b aPr() {
        boolean z;
        Integer num;
        boolean z2 = true;
        AppMethodBeat.i(94143);
        Log.printInfoStack(this.gVB, "generateCameraConfig", new Object[0]);
        if (this.inH == null) {
            Log.i(this.gVB, "generateCameraConfig, camera is null!!");
            AppMethodBeat.o(94143);
            return null;
        } else if (!aPc()) {
            Log.i(this.gVB, "generateCameraConfig, camera not previewing");
            AppMethodBeat.o(94143);
            return null;
        } else {
            com.tencent.mm.media.widget.a.b bVar = com.tencent.mm.media.widget.a.b.imh;
            com.tencent.mm.media.widget.a.b.rs(getPreviewWidth());
            com.tencent.mm.media.widget.a.b bVar2 = com.tencent.mm.media.widget.a.b.imh;
            com.tencent.mm.media.widget.a.b.rr(getPreviewHeight());
            CameraCharacteristics cameraCharacteristics = this.inL;
            if (cameraCharacteristics != null) {
                Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                z = (num2 != null && num2.intValue() == 90) || ((num = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)) != null && num.intValue() == 270);
            } else {
                z = false;
            }
            com.tencent.mm.media.widget.a.b bVar3 = com.tencent.mm.media.widget.a.b.imh;
            com.tencent.mm.media.widget.a.b.ru(this.ilR.sUz);
            com.tencent.mm.media.widget.a.b bVar4 = com.tencent.mm.media.widget.a.b.imh;
            com.tencent.mm.media.widget.a.b.rv(this.ilR.sUA);
            if (z) {
                com.tencent.mm.media.widget.a.b bVar5 = com.tencent.mm.media.widget.a.b.imh;
                int aPl = com.tencent.mm.media.widget.a.b.aPl();
                com.tencent.mm.media.widget.a.b bVar6 = com.tencent.mm.media.widget.a.b.imh;
                com.tencent.mm.media.widget.a.b bVar7 = com.tencent.mm.media.widget.a.b.imh;
                com.tencent.mm.media.widget.a.b.ru(com.tencent.mm.media.widget.a.b.aPm());
                com.tencent.mm.media.widget.a.b bVar8 = com.tencent.mm.media.widget.a.b.imh;
                com.tencent.mm.media.widget.a.b.rv(aPl);
            }
            com.tencent.mm.media.widget.a.b bVar9 = com.tencent.mm.media.widget.a.b.imh;
            com.tencent.mm.media.widget.a.b.rt(getOrientation());
            com.tencent.mm.media.widget.a.b bVar10 = com.tencent.mm.media.widget.a.b.imh;
            if (this.ilM) {
                z2 = false;
            }
            com.tencent.mm.media.widget.a.b.setFrontCamera(z2);
            com.tencent.mm.media.widget.a.b bVar11 = com.tencent.mm.media.widget.a.b.imh;
            com.tencent.mm.media.widget.a.b.eZ(this.ilO);
            com.tencent.mm.media.widget.a.b bVar12 = this.hAu;
            AppMethodBeat.o(94143);
            return bVar12;
        }
    }

    /* access modifiers changed from: protected */
    public int getPreviewHeight() {
        AppMethodBeat.i(94144);
        if (this.inH == null) {
            AppMethodBeat.o(94144);
            return 0;
        }
        try {
            if (!this.ilO || this.ilV == null) {
                int i2 = this.ilR.sUA;
                AppMethodBeat.o(94144);
                return i2;
            }
            Point point = this.ilV;
            if (point == null) {
                p.hyc();
            }
            int i3 = point.y;
            AppMethodBeat.o(94144);
            return i3;
        } catch (Exception e2) {
            Log.e(this.gVB, "getPreviewHeight: %s", e2.getMessage());
            AppMethodBeat.o(94144);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public int getPreviewWidth() {
        AppMethodBeat.i(94145);
        if (this.inH == null) {
            AppMethodBeat.o(94145);
            return 0;
        }
        if (this.inc != null) {
            try {
                if (!this.ilO || this.ilV == null) {
                    int i2 = this.ilR.sUz;
                    AppMethodBeat.o(94145);
                    return i2;
                }
                Point point = this.ilV;
                if (point == null) {
                    p.hyc();
                }
                int i3 = point.x;
                AppMethodBeat.o(94145);
                return i3;
            } catch (Exception e2) {
                Log.e(this.gVB, "getPreviewWidth: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(94145);
        return 0;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public Point fa(boolean z) {
        AppMethodBeat.i(94146);
        if (!z) {
            Point point = new Point(this.ilR.sUz, this.ilR.sUA);
            AppMethodBeat.o(94146);
            return point;
        } else if (this.ilV != null) {
            Point point2 = this.ilV;
            if (point2 == null) {
                p.hyc();
            }
            AppMethodBeat.o(94146);
            return point2;
        } else {
            Point point3 = new Point(this.ilR.sUz, this.ilR.sUA);
            AppMethodBeat.o(94146);
            return point3;
        }
    }

    /* access modifiers changed from: protected */
    public final int getOrientation() {
        AppMethodBeat.i(218848);
        if (aPc()) {
            b bVar = b.inE;
            int aPD = b.aPD();
            AppMethodBeat.o(218848);
            return aPD;
        }
        AppMethodBeat.o(218848);
        return -1;
    }

    /* access modifiers changed from: protected */
    public final boolean a(CameraCharacteristics cameraCharacteristics, boolean z) {
        Range range;
        int i2;
        int min;
        int i3;
        AppMethodBeat.i(94147);
        if (cameraCharacteristics == null) {
            AppMethodBeat.o(94147);
            return false;
        }
        if (z) {
            try {
                int i4 = this.imx;
                if (ae.gKt.gFP > 0) {
                    Log.i(this.ilH, "set frame rate > 0, do not try set preview frame rate");
                } else if (cameraCharacteristics == null) {
                    Log.e(this.gVB, "trySetPreviewFrameRateParameters error, p is null!");
                } else {
                    try {
                        Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                        if (rangeArr != null) {
                            int length = rangeArr.length;
                            int i5 = 0;
                            i2 = 0;
                            while (i5 < length) {
                                Range range2 = rangeArr[i5];
                                p.g(range2, LocaleUtil.ITALIAN);
                                Comparable upper = range2.getUpper();
                                p.g(upper, "it.upper");
                                if (p.compare(i2, ((Number) upper).intValue()) < 0) {
                                    Comparable upper2 = range2.getUpper();
                                    p.g(upper2, "it.upper");
                                    i3 = ((Number) upper2).intValue();
                                } else {
                                    i3 = i2;
                                }
                                i5++;
                                i2 = i3;
                            }
                        } else {
                            i2 = 0;
                        }
                        if (i4 == 0) {
                            min = Math.min(30, i2);
                        } else {
                            min = Math.min(i4, i2);
                        }
                        Range range3 = new Range(Integer.valueOf(min), Integer.valueOf(min));
                        CaptureRequest.Builder builder = this.inI;
                        if (builder != null) {
                            builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range3);
                        }
                    } catch (Exception e2) {
                        Log.i(this.ilH, "trySetPreviewFrameRateParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
                    }
                }
            } catch (Exception e3) {
                Log.i(this.ilH, "setPreviewFrameRate Exception, %s, %s", Looper.myLooper(), e3.getMessage());
                AppMethodBeat.o(94147);
                return false;
            }
        } else {
            a(cameraCharacteristics, this.imx);
        }
        CaptureRequest.Builder builder2 = this.inI;
        if (builder2 != null) {
            range = (Range) builder2.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
        } else {
            range = null;
        }
        Log.i(this.ilH, "use fix mode %B, supported preview frame rates %s", Boolean.valueOf(z), range);
        AppMethodBeat.o(94147);
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(CameraCharacteristics cameraCharacteristics, int i2) {
        boolean z;
        int i3;
        int i4;
        AppMethodBeat.i(218849);
        if (ae.gKt.gFP > 0) {
            Log.i(this.ilH, "set frame rate > 0, do not try set preview fps range");
            AppMethodBeat.o(218849);
            return;
        }
        Range[] rangeArr = cameraCharacteristics != null ? (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES) : null;
        if (rangeArr != null) {
            if (!(rangeArr.length == 0)) {
                int i5 = Integer.MIN_VALUE;
                int i6 = Integer.MIN_VALUE;
                boolean z2 = false;
                int length = rangeArr.length;
                int i7 = 0;
                while (i7 < length) {
                    Range range = rangeArr[i7];
                    if (range == null) {
                        z = z2;
                        i3 = i6;
                    } else {
                        Integer num = (Integer) range.getLower();
                        Integer num2 = (Integer) range.getUpper();
                        Log.i(this.gVB, "dkfps %d:[%d %d]", Integer.valueOf(i7), num, num2);
                        if (p.compare(num.intValue(), 0) >= 0) {
                            int intValue = num2.intValue();
                            p.g(num, "min");
                            if (p.compare(intValue, num.intValue()) >= 0) {
                                int i8 = i2 == 0 ? 30 : i2;
                                if (p.compare(num2.intValue(), i6) < 0 || z2 || p.compare(num2.intValue(), i8) > 0) {
                                    i4 = i6;
                                } else {
                                    i5 = num.intValue();
                                    p.g(num2, "max");
                                    i4 = num2.intValue();
                                }
                                if (i2 != 0) {
                                    if (num2 == null) {
                                        z = z2;
                                        i3 = i4;
                                    } else if (num2.intValue() == i2) {
                                        z = true;
                                        i3 = i4;
                                    }
                                } else if (num2 == null) {
                                    z = z2;
                                    i3 = i4;
                                } else if (num2.intValue() == 30) {
                                    z = true;
                                    i3 = i4;
                                }
                                z = z2;
                                i3 = i4;
                            }
                        }
                        z = z2;
                        i3 = i6;
                    }
                    i7++;
                    z2 = z;
                    i6 = i3;
                }
                Log.i(this.ilH, "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i5), Integer.valueOf(i6), 30);
                if (i5 == Integer.MAX_VALUE || i6 == Integer.MAX_VALUE) {
                    AppMethodBeat.o(218849);
                    return;
                }
                try {
                    CaptureRequest.Builder builder = this.inI;
                    if (builder != null) {
                        builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range(Integer.valueOf(i5), Integer.valueOf(i6)));
                    }
                    Log.i(this.ilH, "set fps range %d %d", Integer.valueOf(i5), Integer.valueOf(i6));
                    AppMethodBeat.o(218849);
                    return;
                } catch (Exception e2) {
                    Log.i(this.ilH, "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
                    AppMethodBeat.o(218849);
                    return;
                }
            }
        }
        AppMethodBeat.o(218849);
    }

    /* access modifiers changed from: protected */
    public boolean a(CameraCharacteristics cameraCharacteristics) {
        int[] iArr;
        AppMethodBeat.i(94149);
        if (this.inH == null) {
            AppMethodBeat.o(94149);
            return false;
        }
        if (cameraCharacteristics != null) {
            try {
                iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
            } catch (Exception e2) {
                Log.i(this.gVB, "setFocusMode Exception, %s, %s", Looper.myLooper(), e2.getMessage());
                AppMethodBeat.o(94149);
                return false;
            }
        } else {
            iArr = null;
        }
        if (iArr != null && kotlin.a.e.contains(iArr, 4)) {
            Log.i(this.gVB, "support continuous picture");
            CaptureRequest.Builder builder = this.inI;
            if (builder != null) {
                builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
            }
        } else if (iArr != null && kotlin.a.e.contains(iArr, 3)) {
            Log.i(this.gVB, "support continuous video");
            CaptureRequest.Builder builder2 = this.inI;
            if (builder2 != null) {
                builder2.set(CaptureRequest.CONTROL_AF_MODE, 3);
            }
        } else if (iArr == null || !kotlin.a.e.contains(iArr, 1)) {
            Log.i(this.gVB, "not support continuous video or auto focus");
        } else {
            Log.i(this.gVB, "support auto focus");
            CaptureRequest.Builder builder3 = this.inI;
            if (builder3 != null) {
                builder3.set(CaptureRequest.CONTROL_AF_MODE, 1);
            }
        }
        AppMethodBeat.o(94149);
        return true;
    }

    private static void h(CaptureRequest.Builder builder) {
        AppMethodBeat.i(94152);
        b bVar = b.inE;
        b.b(builder);
        b bVar2 = b.inE;
        b.d(builder);
        b bVar3 = b.inE;
        b.e(builder);
        b bVar4 = b.inE;
        b.c(builder);
        b bVar5 = b.inE;
        b.f(builder);
        AppMethodBeat.o(94152);
    }

    /* access modifiers changed from: protected */
    @TargetApi(14)
    public final boolean b(CameraCharacteristics cameraCharacteristics) {
        AppMethodBeat.i(94153);
        if (cameraCharacteristics == null) {
            AppMethodBeat.o(94153);
            return false;
        }
        try {
            Log.i(this.gVB, "safeSetMetering");
            Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            MeteringRectangle[] meteringRectangleArr = new MeteringRectangle[1];
            Integer valueOf = rect != null ? Integer.valueOf(rect.right) : null;
            if (valueOf == null) {
                p.hyc();
            }
            meteringRectangleArr[0] = new MeteringRectangle((valueOf.intValue() / 2) - 500, (rect.bottom / 2) - 500, 1000, 1000, 0);
            CaptureRequest.Builder builder = this.inI;
            if (builder != null) {
                builder.set(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr);
            }
            CaptureRequest.Builder builder2 = this.inI;
            if (builder2 != null) {
                builder2.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
            }
            CaptureRequest.Builder builder3 = this.inI;
            if (builder3 != null) {
                builder3.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            }
            CaptureRequest.Builder builder4 = this.inI;
            if (builder4 != null) {
                builder4.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            }
            AppMethodBeat.o(94153);
            return true;
        } catch (Exception e2) {
            Log.i(this.gVB, "safeSetMetering Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(94153);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.a.a
    public final boolean aPh() {
        AppMethodBeat.i(218850);
        b bVar = b.inE;
        if (b.aPD() != 90) {
            b bVar2 = b.inE;
            if (b.aPD() != 270) {
                AppMethodBeat.o(218850);
                return false;
            }
        }
        AppMethodBeat.o(218850);
        return true;
    }

    @Override // com.tencent.mm.media.widget.a.a
    public final Size[] aPi() {
        CameraCharacteristics cameraCharacteristics;
        AppMethodBeat.i(218851);
        try {
            CameraManager cameraManager = this.inc;
            if (cameraManager != null) {
                b bVar = b.inE;
                String aPA = b.aPA();
                if (aPA == null) {
                    p.hyc();
                }
                cameraCharacteristics = cameraManager.getCameraCharacteristics(aPA);
            } else {
                cameraCharacteristics = null;
            }
            this.inL = cameraCharacteristics;
            b bVar2 = b.inE;
            Size[] aPG = b.aPG();
            AppMethodBeat.o(218851);
            return aPG;
        } catch (Exception e2) {
            AppMethodBeat.o(218851);
            return null;
        }
    }

    @Override // com.tencent.mm.media.widget.a.a
    public final boolean rq(int i2) {
        AppMethodBeat.i(94154);
        try {
            super.rq(i2);
            boolean aPh = aPh();
            Point aPj = aPj();
            b bVar = b.inE;
            h.c b2 = h.b(b.aPH(), aPj, i2, aPh);
            if (b2.zum == null) {
                Point point = new Point(Math.min(aPj().x, aPj().y), Math.max(aPj().x, aPj().y));
                b bVar2 = b.inE;
                b2 = h.a(b.aPH(), point, this.ilI, aPh);
            }
            if (b2.zum == null) {
                com.tencent.mm.media.widget.d.a aVar = com.tencent.mm.media.widget.d.a.itg;
                com.tencent.mm.media.widget.d.a.aRk();
                Log.i(this.gVB, "checkMore start %s", b2.toString());
                b2.zum = b2.zup;
                b2.zun = b2.zuq;
                b2.zuo = b2.zur;
            }
            b bVar3 = b.inE;
            b.d(aPj);
            Size size = new Size(b2.zum.x, b2.zum.y);
            int width = size.getWidth();
            int height = size.getHeight();
            b bVar4 = b.inE;
            ImageReader newInstance = ImageReader.newInstance(width, height, b.aPC(), 1);
            newInstance.setOnImageAvailableListener(this.ilK.imS, this.ilK.imK);
            this.hiC = newInstance;
            AppMethodBeat.o(94154);
            return true;
        } catch (CameraAccessException e2) {
            Log.printErrStackTrace(this.gVB, e2, "selectNoCropPreviewSize Exception by camera access exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(94154);
            return false;
        } catch (Exception e3) {
            Log.printErrStackTrace(this.gVB, e3, "selectNoCropPreviewSize Exception, %s, %s", Looper.myLooper(), e3.getMessage());
            AppMethodBeat.o(94154);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final void release() {
        AppMethodBeat.i(94155);
        super.release();
        if (this.inH != null) {
            long currentTicks = Util.currentTicks();
            Log.i(this.gVB, "release camera beg, %s", Looper.myLooper());
            this.ilK.removeCallbacksAndMessages(null);
            aPK();
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
            }
            Log.i(this.gVB, "release camera end, use %dms, %s", Long.valueOf(Util.ticksToNow(currentTicks)), Looper.myLooper());
        }
        this.ilV = null;
        this.ilY = false;
        com.tencent.mm.media.widget.d.a aVar = com.tencent.mm.media.widget.d.a.itg;
        com.tencent.mm.media.widget.d.a.aRe();
        AppMethodBeat.o(94155);
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final boolean n(kotlin.g.a.b<? super Bitmap, x> bVar) {
        CameraCaptureSession cameraCaptureSession;
        CaptureRequest captureRequest = null;
        AppMethodBeat.i(94157);
        p.h(bVar, "dataCallback");
        Log.i(this.gVB, "takePhoto");
        a(a.EnumC0424a.CAMERA_IS_CAPTURING);
        b bVar2 = b.inE;
        String aPA = b.aPA();
        b bVar3 = b.inE;
        if (p.j(aPA, b.ry(b.ind))) {
            com.tencent.mm.media.widget.d.a aVar = com.tencent.mm.media.widget.d.a.itg;
            com.tencent.mm.media.widget.d.a.aRg();
            try {
                if (this.state != 0) {
                    a(this.inL);
                    CaptureRequest.Builder builder = this.inI;
                    if (builder != null) {
                        builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                    }
                    CaptureRequest.Builder builder2 = this.inI;
                    if (builder2 != null) {
                        builder2.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                    }
                    CaptureRequest.Builder builder3 = this.inI;
                    if (builder3 != null) {
                        builder3.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
                    }
                    CaptureRequest.Builder builder4 = this.inI;
                    CaptureRequest build = builder4 != null ? builder4.build() : null;
                    if (build == null) {
                        p.hyc();
                    }
                    this.inK = build;
                    if (!this.inM) {
                        try {
                            CameraCaptureSession cameraCaptureSession2 = this.inJ;
                            if (cameraCaptureSession2 != null) {
                                CaptureRequest captureRequest2 = this.inK;
                                if (captureRequest2 == null) {
                                    p.btv("previewRequest");
                                }
                                cameraCaptureSession2.setRepeatingRequest(captureRequest2, this.inT, this.ilK.imK);
                            }
                        } catch (CameraAccessException e2) {
                            Log.e(this.gVB, "setRepeatingRequest failed, errMsg: ");
                        }
                    }
                    this.state = 0;
                }
                this.ilK.removeCallbacksAndMessages(null);
                CaptureRequest.Builder builder5 = this.inI;
                if (builder5 != null) {
                    builder5.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                }
                this.state = 1;
                if (!this.inM) {
                    CaptureRequest.Builder builder6 = this.inI;
                    if (!((builder6 != null ? builder6.build() : null) == null || (cameraCaptureSession = this.inJ) == null)) {
                        CaptureRequest.Builder builder7 = this.inI;
                        if (builder7 != null) {
                            captureRequest = builder7.build();
                        }
                        if (captureRequest == null) {
                            p.hyc();
                        }
                        cameraCaptureSession.capture(captureRequest, this.inT, this.ilK.imK);
                    }
                }
            } catch (Exception e3) {
                com.tencent.mm.media.widget.d.a aVar2 = com.tencent.mm.media.widget.d.a.itg;
                com.tencent.mm.media.widget.d.a.aRh();
                Log.printInfoStack(this.gVB, "take photo in back camera error", e3);
            }
        } else {
            com.tencent.mm.media.widget.d.a aVar3 = com.tencent.mm.media.widget.d.a.itg;
            com.tencent.mm.media.widget.d.a.aRf();
            aPL();
        }
        this.ilK.imM = bVar;
        AppMethodBeat.o(94157);
        return true;
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final boolean aPd() {
        AppMethodBeat.i(94158);
        this.inN = true;
        b bVar = b.inE;
        b.ff(true);
        com.tencent.mm.media.widget.d.a aVar = com.tencent.mm.media.widget.d.a.itg;
        com.tencent.mm.media.widget.d.a.aRp();
        AppMethodBeat.o(94158);
        return true;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final boolean aPx() {
        AppMethodBeat.i(218854);
        try {
            CaptureRequest.Builder builder = this.inI;
            if (builder != null) {
                builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            }
            CaptureRequest.Builder builder2 = this.inI;
            if (builder2 != null) {
                builder2.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            }
            AppMethodBeat.o(218854);
            return true;
        } catch (Exception e2) {
            Log.i(this.gVB, "triggerAutoFocus failed");
            AppMethodBeat.o(218854);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final String aPw() {
        AppMethodBeat.i(218855);
        CaptureRequest captureRequest = this.inK;
        if (captureRequest == null) {
            p.btv("previewRequest");
        }
        Integer num = captureRequest != null ? (Integer) captureRequest.get(CaptureRequest.CONTROL_AF_MODE) : null;
        if (num != null && num.intValue() == 1) {
            b.C0437b bVar = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
            String aQC = b.C0437b.aQC();
            AppMethodBeat.o(218855);
            return aQC;
        } else if (num != null && num.intValue() == 4) {
            b.C0437b bVar2 = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
            String aQB = b.C0437b.aQB();
            AppMethodBeat.o(218855);
            return aQB;
        } else if (num != null && num.intValue() == 3) {
            b.C0437b bVar3 = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
            String aQA = b.C0437b.aQA();
            AppMethodBeat.o(218855);
            return aQA;
        } else {
            b.C0437b bVar4 = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
            String aQC2 = b.C0437b.aQC();
            AppMethodBeat.o(218855);
            return aQC2;
        }
    }

    private static int di(int i2, int i3) {
        if (i2 > i3) {
            return i3;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void a(g gVar) {
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void b(g gVar) {
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void B(String str, boolean z) {
        AppMethodBeat.i(94159);
        p.h(str, "tag");
        b.a aVar = com.tencent.mm.media.widget.b.a.a.b.ipa;
        if (p.j(str, com.tencent.mm.media.widget.b.a.a.b.aPW())) {
            b bVar = b.inE;
            b.fg(z);
        } else {
            b.a aVar2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
            if (p.j(str, com.tencent.mm.media.widget.b.a.a.b.aQb())) {
                b bVar2 = b.inE;
                b.fc(z);
            } else {
                b.a aVar3 = com.tencent.mm.media.widget.b.a.a.b.ipa;
                if (p.j(str, com.tencent.mm.media.widget.b.a.a.b.aQa())) {
                    b bVar3 = b.inE;
                    b.fd(z);
                } else {
                    b.a aVar4 = com.tencent.mm.media.widget.b.a.a.b.ipa;
                    if (p.j(str, com.tencent.mm.media.widget.b.a.a.b.aQd())) {
                        b bVar4 = b.inE;
                        b.fe(z);
                    } else {
                        b.a aVar5 = com.tencent.mm.media.widget.b.a.a.b.ipa;
                        if (p.j(str, com.tencent.mm.media.widget.b.a.a.b.aQc())) {
                            b bVar5 = b.inE;
                            b.ff(z);
                        }
                    }
                }
            }
        }
        aPM();
        AppMethodBeat.o(94159);
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void ad(String str, int i2) {
        AppMethodBeat.i(94160);
        p.h(str, "tag");
        b bVar = b.inE;
        CaptureRequest.Builder builder = this.inI;
        if (builder == null) {
            p.hyc();
        }
        b.a(builder, str, i2);
        aPM();
        AppMethodBeat.o(94160);
    }

    private final void aPM() {
        AppMethodBeat.i(94161);
        if (this.inI == null) {
            AppMethodBeat.o(94161);
            return;
        }
        if (this.inH != null && !this.inM) {
            CaptureRequest.Builder builder = this.inI;
            if (builder != null) {
                builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
            }
            CaptureRequest.Builder builder2 = this.inI;
            if (builder2 == null) {
                p.hyc();
            }
            h(builder2);
            CameraCaptureSession cameraCaptureSession = this.inJ;
            if (cameraCaptureSession != null) {
                CaptureRequest.Builder builder3 = this.inI;
                CaptureRequest build = builder3 != null ? builder3.build() : null;
                if (build == null) {
                    p.hyc();
                }
                cameraCaptureSession.setRepeatingRequest(build, this.inT, this.ilK.imK);
                AppMethodBeat.o(94161);
                return;
            }
        }
        AppMethodBeat.o(94161);
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final int aPu() {
        AppMethodBeat.i(94162);
        b bVar = b.inE;
        if (b.aPB()) {
            AppMethodBeat.o(94162);
            return 0;
        }
        AppMethodBeat.o(94162);
        return 1;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final int aPv() {
        AppMethodBeat.i(94163);
        b bVar = b.inE;
        int aPD = b.aPD();
        AppMethodBeat.o(94163);
        return aPD;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void fb(boolean z) {
        AppMethodBeat.i(94164);
        b bVar = b.inE;
        CaptureRequest.Builder builder = this.inI;
        if (builder == null) {
            p.hyc();
        }
        b.a(z, builder);
        AppMethodBeat.o(94164);
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final int getFlashMode() {
        AppMethodBeat.i(94165);
        b bVar = b.inE;
        CaptureRequest.Builder builder = this.inI;
        if (builder == null) {
            p.hyc();
        }
        int a2 = b.a(builder);
        AppMethodBeat.o(94165);
        return a2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.media.widget.a.d
    public final void setFlashMode(int i2) {
        CameraCharacteristics cameraCharacteristics;
        AppMethodBeat.i(94166);
        CaptureRequest.Builder builder = this.inI;
        if (builder != null) {
            b bVar = b.inE;
            p.h(builder, "builder");
            switch (i2) {
                case 1:
                    b.a(true, builder);
                    AppMethodBeat.o(94166);
                    return;
                case 2:
                    b.a(false, builder);
                    AppMethodBeat.o(94166);
                    return;
                case 3:
                    CameraManager cameraManager = b.inc;
                    if (com.tencent.mm.compatible.loader.a.contains((cameraManager == null || (cameraCharacteristics = cameraManager.getCameraCharacteristics(String.valueOf(b.inn))) == null) ? null : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES), 2)) {
                        builder.set(CaptureRequest.CONTROL_AE_MODE, 2);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(94166);
            return;
        }
        AppMethodBeat.o(94166);
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final int aPf() {
        Range range;
        AppMethodBeat.i(218856);
        CaptureRequest.Builder builder = this.inI;
        if (builder == null || (range = (Range) builder.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE)) == null) {
            AppMethodBeat.o(218856);
            return 0;
        }
        p.g(range, LocaleUtil.ITALIAN);
        int intValue = ((Number) range.getLower()).intValue();
        Comparable upper = range.getUpper();
        p.g(upper, "it.upper");
        int intValue2 = (((Number) upper).intValue() + intValue) / 2;
        AppMethodBeat.o(218856);
        return intValue2;
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final boolean rp(int i2) {
        AppMethodBeat.i(218857);
        try {
            CameraCaptureSession cameraCaptureSession = this.inJ;
            if ((cameraCaptureSession != null ? cameraCaptureSession.getDevice() : null) != null) {
            }
            AppMethodBeat.o(218857);
            return true;
        } catch (Exception e2) {
            Log.e(this.gVB, "open scene " + i2 + " open failed, error:%s", e2.getMessage());
            AppMethodBeat.o(218857);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final int df(int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(218858);
        switch (i3) {
            case 1:
                i4 = 90;
                break;
            case 2:
                i4 = TXLiveConstants.RENDER_ROTATION_180;
                break;
            case 3:
                i4 = 270;
                break;
        }
        if (!this.ilM) {
            b bVar = b.inE;
            int aPD = (360 - ((i4 + b.aPD()) % v2helper.VOIP_ENC_HEIGHT_LV1)) % v2helper.VOIP_ENC_HEIGHT_LV1;
            AppMethodBeat.o(218858);
            return aPD;
        }
        b bVar2 = b.inE;
        int aPD2 = ((b.aPD() - i4) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        AppMethodBeat.o(218858);
        return aPD2;
    }

    @Override // com.tencent.mm.media.widget.a.a, com.tencent.mm.media.widget.a.d
    public final boolean aPg() {
        AppMethodBeat.i(218859);
        CaptureRequest captureRequest = this.inK;
        if (captureRequest == null) {
            p.btv("previewRequest");
        }
        Integer num = captureRequest != null ? (Integer) captureRequest.get(CaptureRequest.CONTROL_AF_MODE) : null;
        if (num != null && num.intValue() == 1) {
            CaptureRequest.Builder builder = this.inI;
            if (builder != null) {
                builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            }
            CaptureRequest.Builder builder2 = this.inI;
            if (builder2 != null) {
                builder2.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            }
            AppMethodBeat.o(218859);
            return true;
        }
        AppMethodBeat.o(218859);
        return false;
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final boolean b(Rect rect, Rect rect2) {
        AppMethodBeat.i(218860);
        p.h(rect, "focusArea");
        p.h(rect2, "meteringArea");
        Log.i(this.gVB, "focus on area :: focus rect %s, meter rect %s", rect, rect2);
        if (aPc()) {
            Log.i(this.inF, "a focus action happened");
            CaptureRequest.Builder builder = this.inI;
            if (builder != null) {
                builder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect, 200)});
            }
            CaptureRequest.Builder builder2 = this.inI;
            if (builder2 != null) {
                builder2.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, v2helper.VOIP_ENC_HEIGHT_LV1)});
            }
            CaptureRequest.Builder builder3 = this.inI;
            if (builder3 != null) {
                builder3.set(CaptureRequest.CONTROL_AF_MODE, 1);
            }
            CaptureRequest.Builder builder4 = this.inI;
            if (builder4 != null) {
                builder4.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            }
            CaptureRequest.Builder builder5 = this.inI;
            if (builder5 != null) {
                builder5.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            }
            try {
                if (!this.inM) {
                    Log.i(this.inF, "params set and try focus");
                    CameraCaptureSession cameraCaptureSession = this.inJ;
                    if (cameraCaptureSession != null) {
                        CaptureRequest.Builder builder6 = this.inI;
                        if (builder6 == null) {
                            p.hyc();
                        }
                        cameraCaptureSession.setRepeatingRequest(builder6.build(), this.inT, this.ilK.imK);
                    }
                    this.state = 5;
                } else {
                    Log.i(this.inF, "something happened casue focus no request");
                    Log.e(this.gVB, "this has been camera session close");
                    AppMethodBeat.o(218860);
                    return false;
                }
            } catch (CameraAccessException e2) {
                Log.e(this.gVB, "setRepeatingRequest failed, ");
                AppMethodBeat.o(218860);
                return false;
            }
        }
        AppMethodBeat.o(218860);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/CommonCamera2$Companion;", "", "()V", "FOCUS_TAG", "", "ORIENTATIONS", "Landroid/util/SparseIntArray;", "SMALL_ZOOM_STEP_NUM", "", "SMALL_ZOOM_STEP_UPPER_BOUND", "TAG", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(94168);
        SparseIntArray sparseIntArray = new SparseIntArray();
        inU = sparseIntArray;
        sparseIntArray.append(0, 90);
        inU.append(1, 0);
        inU.append(2, 270);
        inU.append(3, TXLiveConstants.RENDER_ROTATION_180);
        AppMethodBeat.o(94168);
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void rw(int i2) {
        AppMethodBeat.i(94139);
        if (this.ilW > 0) {
            AppMethodBeat.o(94139);
            return;
        }
        Point az = ao.az(MMApplicationContext.getContext());
        int i3 = az.y;
        Log.i(this.gVB, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", Integer.valueOf(i2), az);
        if (i3 / 2 >= i2) {
            AppMethodBeat.o(94139);
            return;
        }
        try {
            CameraCharacteristics cameraCharacteristics = this.inL;
            if (cameraCharacteristics == null) {
                p.hyc();
            }
            Float f2 = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
            if (f2 == null) {
                f2 = Float.valueOf(0.0f);
            }
            p.g(f2, "mCharacteristics!!.get(C…_MAX_DIGITAL_ZOOM)?: 0.0f");
            float floatValue = f2.floatValue();
            double d2 = ((double) floatValue) / ((((double) i2) / 3.0d) / 10.0d);
            if (d2 > 0.0d) {
                this.ilW = ((int) d2) + 1;
            }
            Log.i(this.gVB, "scrollSmallZoomStep: %s, maxZoom: %s", Integer.valueOf(this.ilW), Float.valueOf(floatValue));
            AppMethodBeat.o(94139);
        } catch (Exception e2) {
            Log.e(this.gVB, "calcScrollZoomStep error: %s", e2.getMessage());
            AppMethodBeat.o(94139);
        }
    }

    @Override // com.tencent.mm.media.widget.a.d
    public final void setForceZoomTargetRatio(float f2) {
        AppMethodBeat.i(94142);
        if (this.aYc) {
            Log.d(this.gVB, "setForceZoomTargetRatio, zooming, ignore");
            AppMethodBeat.o(94142);
        } else if (this.inL == null || this.inI == null) {
            AppMethodBeat.o(94142);
        } else {
            try {
                CameraCharacteristics cameraCharacteristics = this.inL;
                if (cameraCharacteristics == null) {
                    p.hyc();
                }
                Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                if (rect == null) {
                    p.hyc();
                }
                int width = rect.width() - kotlin.h.a.cR(((float) rect.width()) / f2);
                int height = rect.height() - kotlin.h.a.cR(((float) rect.height()) / f2);
                this.inP = new Rect(width / 2, height / 2, rect.width() - (width / 2), rect.height() - (height / 2));
                CaptureRequest.Builder builder = this.inI;
                if (builder == null) {
                    p.hyc();
                }
                builder.set(CaptureRequest.SCALER_CROP_REGION, this.inP);
                if (!this.inM) {
                    try {
                        CameraCaptureSession cameraCaptureSession = this.inJ;
                        if (cameraCaptureSession != null) {
                            CaptureRequest.Builder builder2 = this.inI;
                            if (builder2 == null) {
                                p.hyc();
                            }
                            cameraCaptureSession.setRepeatingRequest(builder2.build(), this.inT, this.ilK.imK);
                        }
                    } catch (CameraAccessException e2) {
                    }
                }
            } catch (Exception e3) {
                Log.e(this.gVB, "setForceZoomTargetRatio error: %s", e3.getMessage());
            } finally {
                this.aYc = false;
                AppMethodBeat.o(94142);
            }
        }
    }

    @Override // com.tencent.mm.media.widget.a.a
    public final boolean dg(int i2, int i3) {
        AppMethodBeat.i(218852);
        try {
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture == null) {
                p.hyc();
            }
            surfaceTexture.setDefaultBufferSize(i2, i3);
            AppMethodBeat.o(218852);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(218852);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0034  */
    @Override // com.tencent.mm.media.widget.a.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Rect a(float r15, float r16, float r17, int r18, int r19) {
        /*
        // Method dump skipped, instructions count: 382
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.b.c.a(float, float, float, int, int):android.graphics.Rect");
    }

    public static final /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(94169);
        try {
            CaptureRequest.Builder builder = cVar.inI;
            if (builder == null) {
                p.hyc();
            }
            CaptureRequest build = builder.build();
            p.g(build, "mPreviewBuilder!!.build()");
            cVar.inK = build;
            if (cVar.inN) {
                CameraCaptureSession cameraCaptureSession = cVar.inJ;
                if (cameraCaptureSession != null) {
                    CaptureRequest captureRequest = cVar.inK;
                    if (captureRequest == null) {
                        p.btv("previewRequest");
                    }
                    cameraCaptureSession.setRepeatingRequest(captureRequest, cVar.inT, cVar.ilK.imK);
                    AppMethodBeat.o(94169);
                    return;
                }
                AppMethodBeat.o(94169);
                return;
            }
            CameraCaptureSession cameraCaptureSession2 = cVar.inJ;
            if (cameraCaptureSession2 != null) {
                CaptureRequest captureRequest2 = cVar.inK;
                if (captureRequest2 == null) {
                    p.btv("previewRequest");
                }
                cameraCaptureSession2.setRepeatingRequest(captureRequest2, cVar.inT, cVar.ilK.imK);
                AppMethodBeat.o(94169);
                return;
            }
            AppMethodBeat.o(94169);
        } catch (CameraAccessException e2) {
            AppMethodBeat.o(94169);
        }
    }

    public static final /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(94171);
        if (!cVar.inM) {
            try {
                CaptureRequest.Builder builder = cVar.inI;
                if (builder != null) {
                    builder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
                }
                cVar.state = 2;
                CameraCaptureSession cameraCaptureSession = cVar.inJ;
                if (cameraCaptureSession != null) {
                    CaptureRequest.Builder builder2 = cVar.inI;
                    CaptureRequest build = builder2 != null ? builder2.build() : null;
                    if (build == null) {
                        p.hyc();
                    }
                    cameraCaptureSession.capture(build, cVar.inT, cVar.ilK.imK);
                    AppMethodBeat.o(94171);
                    return;
                }
                AppMethodBeat.o(94171);
            } catch (CameraAccessException e2) {
                Log.e(cVar.gVB, e2.toString());
                AppMethodBeat.o(94171);
            }
        } else {
            Log.e(cVar.gVB, "capture session has been close, abandon this capture");
            AppMethodBeat.o(94171);
        }
    }
}

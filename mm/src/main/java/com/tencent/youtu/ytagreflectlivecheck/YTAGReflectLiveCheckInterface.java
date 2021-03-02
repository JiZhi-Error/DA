package com.tencent.youtu.ytagreflectlivecheck;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawYuvData;
import com.tencent.youtu.ytagreflectlivecheck.notice.YTReflectNotice;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class YTAGReflectLiveCheckInterface {
    private static int ERRCODE_GET_ACTREFLECTDATA_FAILED = 4;
    private static int ERRCODE_JNI_DETECT_FAILED = 3;
    private static int ERRCODE_JSON_DECODE_FAILED = 2;
    private static int ERRCODE_NET_RETURN_PARSE_NULL = 0;
    private static int ERRCODE_UPLOAD_VIDEO_FAILED = 1;
    private static final String TAG = "YoutuLightLiveCheck";
    public static final String VERSION = "3.6.4.3";
    private static GetLiveStyleResult getLiveStyleResultHandler = null;
    private static Lock initLock = new ReentrantLock();
    public static YTAGReflectSettings mAGSettings = new YTAGReflectSettings();
    public static String mAppId = "";
    private static Camera mCamera;
    private static int mCameraRotatedTag;
    private static LightLiveCheckResult mCheckResult;
    private static String mColorSeq;
    private static TimerWorker mGetValueTimer;
    private static int mInitModel = 0;
    private static int mOnGetValueCount;
    private static IYTReflectListener mReflectListener;
    public static YTReflectNotice mReflectNotice;
    private static int mState;

    public interface GetLiveStyleResult {
        void onFailed(int i2, String str, String str2);

        void onSuccess(LiveStyleRequester.YTLiveStyleReq yTLiveStyleReq, LiveStyleResponse liveStyleResponse);
    }

    public interface IYTReflectListener {
        float onGetAppBrightness();

        void onReflectEvent(ColorMatrixColorFilter colorMatrixColorFilter, float f2);

        void onReflectStart(long j2);
    }

    public interface LightLiveCheckResult {
        public static final int AUTH_FAILED = 1;
        public static final int FINISH_ERRORBASE = 300;
        public static final int INIT_ERRORBASE = 100;
        public static final int NOT_INIT_MODEL = 2;
        public static final int NOT_SET_RGBREQUEST = 4;
        public static final int NOT_SET_UPLOADREQUEST = 5;
        public static final int REFLECT_ERRORBASE = 200;
        public static final int SUCCESS = 0;
        public static final int USER_CANCEL = 3;

        void onFailed(int i2, String str, String str2);

        void onSuccess(FullPack fullPack);
    }

    public interface LightLiveProcessState {
        public static final int GET_RGBCONFIG = 1;
        public static final int HANGUP = 0;
        public static final int REFLECTING = 2;
        public static final int UPLOAD = 3;
    }

    public interface YTSAFETYLEVEL {
        public static final int SAFETY_HIGH = 2;
        public static final int SAFETY_LOW = 1;
        public static final int SAFETY_RECOMMEND = 0;
    }

    static /* synthetic */ int access$008() {
        int i2 = mOnGetValueCount;
        mOnGetValueCount = i2 + 1;
        return i2;
    }

    static {
        AppMethodBeat.i(43327);
        AppMethodBeat.o(43327);
    }

    public static synchronized int initModel(String str) {
        int i2;
        synchronized (YTAGReflectLiveCheckInterface.class) {
            AppMethodBeat.i(43312);
            i2 = 0;
            try {
                initLock.lock();
                if (mInitModel > 0) {
                    YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "initModel repeated calls.");
                } else {
                    mAppId = str;
                    if (str == null) {
                        mAppId = "";
                    }
                }
                mInitModel++;
                initLock.unlock();
            } catch (Exception e2) {
                YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "initModel failed. message: " + e2.getMessage());
                i2 = -1;
                initLock.unlock();
            } catch (Throwable th) {
                initLock.unlock();
                AppMethodBeat.o(43312);
                throw th;
            }
            AppMethodBeat.o(43312);
        }
        return i2;
    }

    public static synchronized void releaseModel() {
        synchronized (YTAGReflectLiveCheckInterface.class) {
            AppMethodBeat.i(43313);
            try {
                initLock.lock();
                int i2 = mInitModel - 1;
                mInitModel = i2;
                if (i2 <= 0) {
                    mInitModel = 0;
                    mReflectNotice = null;
                    mReflectListener = null;
                    if (mGetValueTimer != null) {
                        mGetValueTimer.cancel();
                        mGetValueTimer = null;
                    }
                    getLiveStyleResultHandler = null;
                }
                initLock.unlock();
                YTAGReflectLiveCheckJNIInterface.clearInstance();
                AppMethodBeat.o(43313);
            } catch (Throwable th) {
                initLock.unlock();
                AppMethodBeat.o(43313);
                throw th;
            }
        }
    }

    public static int getLiveCheckType(Context context, GetLiveStyleResult getLiveStyleResult) {
        int i2 = 1;
        AppMethodBeat.i(43314);
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- start");
        if (getLiveStyleResult != null) {
            if (context == null) {
                getLiveStyleResult.onFailed(1, "Input context is null.", "You can try to input getActivity().getApplicationContext() and test again.");
                i2 = 2;
            } else {
                if (getLiveStyleResultHandler != null) {
                    YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[YTAGReflectLiveCheckInterface.getLiveCheckType] repeated calls. this may cause the previous call lost callback.");
                }
                getLiveStyleResultHandler = getLiveStyleResult;
                mOnGetValueCount = 0;
                int start = SensorManagerWorker.getInstance().start(context, new SensorManagerWorker.OnGetValue() {
                    /* class com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.AnonymousClass1 */

                    @Override // com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker.OnGetValue
                    public final void onGetValue(float f2) {
                        AppMethodBeat.i(43307);
                        YTAGReflectLiveCheckInterface.access$008();
                        YTAGReflectLiveCheckJNIInterface.nativeLog(YTAGReflectLiveCheckInterface.TAG, "[YTAGReflectLiveCheckInterface.getLiveCheckType.onGetValue] get value: " + f2 + " mOnGetValueCount: " + YTAGReflectLiveCheckInterface.mOnGetValueCount);
                        if (YTAGReflectLiveCheckInterface.mOnGetValueCount > 1) {
                            YTAGReflectLiveCheckJNIInterface.nativeLog(YTAGReflectLiveCheckInterface.TAG, "[YTAGReflectLiveCheckInterface.getLiveCheckType.onGetValue] get value: ".concat(String.valueOf(f2)));
                            if (YTAGReflectLiveCheckInterface.mGetValueTimer != null) {
                                YTAGReflectLiveCheckInterface.mGetValueTimer.cancel();
                                TimerWorker unused = YTAGReflectLiveCheckInterface.mGetValueTimer = null;
                            }
                            if (YTAGReflectLiveCheckInterface.getLiveStyleResultHandler != null) {
                                YTAGReflectLiveCheckInterface.getLiveStyleResultHandler.onSuccess(new LiveStyleRequester.YTLiveStyleReq(f2, YTAGReflectLiveCheckInterface.mAppId), new LiveStyleResponse());
                                GetLiveStyleResult unused2 = YTAGReflectLiveCheckInterface.getLiveStyleResultHandler = null;
                            }
                            SensorManagerWorker.getInstance().stop();
                        }
                        AppMethodBeat.o(43307);
                    }
                });
                if (start == 1) {
                    YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[YTAGReflectLiveCheckInterface.getLiveCheckType] Can't find light sensor.");
                    if (getLiveStyleResultHandler != null) {
                        getLiveStyleResultHandler.onSuccess(new LiveStyleRequester.YTLiveStyleReq(-1.0f, mAppId), new LiveStyleResponse());
                        getLiveStyleResultHandler = null;
                    }
                    i2 = 0;
                } else if (start != 0) {
                    if (getLiveStyleResultHandler != null) {
                        getLiveStyleResultHandler.onSuccess(new LiveStyleRequester.YTLiveStyleReq(SensorManagerWorker.getInstance().getLux(), mAppId), new LiveStyleResponse());
                        getLiveStyleResultHandler = null;
                    }
                    i2 = 0;
                } else {
                    AnonymousClass2 r0 = new TimerWorker(3000, 3000) {
                        /* class com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.AnonymousClass2 */

                        @Override // com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker
                        public final void onTick(long j2) {
                            AppMethodBeat.i(43308);
                            YTAGReflectLiveCheckJNIInterface.nativeLog(YTAGReflectLiveCheckInterface.TAG, "[YTAGReflectLiveCheckInterface.getLiveCheckType.onTick] onTick");
                            AppMethodBeat.o(43308);
                        }

                        @Override // com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker
                        public final void onFinish() {
                            AppMethodBeat.i(43309);
                            YTAGReflectLiveCheckJNIInterface.nativeLog(YTAGReflectLiveCheckInterface.TAG, "[YTAGReflectLiveCheckInterface.getLiveCheckType.onFinish] ");
                            if (YTAGReflectLiveCheckInterface.getLiveStyleResultHandler != null) {
                                YTAGReflectLiveCheckInterface.getLiveStyleResultHandler.onSuccess(new LiveStyleRequester.YTLiveStyleReq(-2.0f, YTAGReflectLiveCheckInterface.mAppId), new LiveStyleResponse());
                                GetLiveStyleResult unused = YTAGReflectLiveCheckInterface.getLiveStyleResultHandler = null;
                            }
                            AppMethodBeat.o(43309);
                        }
                    };
                    mGetValueTimer = r0;
                    r0.start();
                    i2 = 0;
                }
            }
        }
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- finish. ret: ".concat(String.valueOf(i2)));
        AppMethodBeat.o(43314);
        return i2;
    }

    public static void setSafetyLevel(int i2) {
        AppMethodBeat.i(43318);
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[YTAGReflectLiveCheckInterface.setSafetyLevel] --- level: ".concat(String.valueOf(i2)));
        mAGSettings.safetylevel = i2;
        AppMethodBeat.o(43318);
    }

    public static YTAGReflectSettings getAGSettings() {
        return mAGSettings;
    }

    public static void setAGSettings(YTAGReflectSettings yTAGReflectSettings) {
        mAGSettings = yTAGReflectSettings;
    }

    public static void setReflectNotice(YTReflectNotice yTReflectNotice) {
        mReflectNotice = yTReflectNotice;
    }

    public static void setReflectListener(IYTReflectListener iYTReflectListener) {
        mReflectListener = iYTReflectListener;
    }

    public static IYTReflectListener getReflectListener() {
        return mReflectListener;
    }

    public static void start(Context context, Camera camera, int i2, String str, LightLiveCheckResult lightLiveCheckResult) {
        AppMethodBeat.i(193624);
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[YTAGReflectLiveCheckInterface.start] ---");
        if (lightLiveCheckResult == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "On reflection start failed:checkResult is null");
            AppMethodBeat.o(193624);
            return;
        }
        mCheckResult = lightLiveCheckResult;
        if (mInitModel <= 0) {
            mCheckResult.onFailed(2, "Not init model.", "Call YTAGReflectLiveCheckInterface.initModel() before.");
            AppMethodBeat.o(193624);
            return;
        }
        mCameraRotatedTag = i2;
        mColorSeq = str;
        mCamera = camera;
        long[] jArr = new long[2];
        float f2 = -1.0f;
        if (mReflectListener == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "On reflection start failed:mReflectListener is null");
        }
        if (mReflectListener != null) {
            f2 = mReflectListener.onGetAppBrightness();
        }
        YTAGReflectLiveCheckJNIInterface.getInstance().FRInit(false, str, mAGSettings.safetylevel, jArr, f2);
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "output duration ms" + jArr[0] + " " + jArr[1]);
        if (mReflectListener != null) {
            mReflectListener.onReflectStart(jArr[0]);
        }
        AppMethodBeat.o(193624);
    }

    public static void cancel() {
        AppMethodBeat.i(43321);
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[YTAGReflectLiveCheckInterface.cancel] --- ");
        YTAGReflectLiveCheckJNIInterface.getInstance().FRRelease();
        AppMethodBeat.o(43321);
    }

    public static void onFinish() {
        AppMethodBeat.i(193625);
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "on finished");
        int FRDoDetectionYuvs = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, mCameraRotatedTag);
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "on finished ".concat(String.valueOf(FRDoDetectionYuvs)));
        if (FRDoDetectionYuvs == 0) {
            mCheckResult.onSuccess(YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin());
            AppMethodBeat.o(193625);
            return;
        }
        mCheckResult.onFailed(-1, "JNI return failed.[" + FRDoDetectionYuvs + "]", "Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: ".concat(String.valueOf(FRDoDetectionYuvs)));
        AppMethodBeat.o(193625);
    }

    public static void onScreenChanged(int i2, int i3, int i4, int i5, float f2) {
        AppMethodBeat.i(193626);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, (float) i3, 0.0f, 0.0f, 0.0f, 0.0f, (float) i4, 0.0f, 0.0f, 0.0f, 0.0f, (float) i5, 0.0f, 0.0f, 0.0f, 0.0f, (float) i2});
        if (mReflectListener == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "On reflection screen change failed:mReflectListener is null");
            AppMethodBeat.o(193626);
            return;
        }
        mReflectListener.onReflectEvent(colorMatrixColorFilter, f2);
        AppMethodBeat.o(193626);
    }

    public static void onStateChanged(int i2) {
        AppMethodBeat.i(193627);
        mState = i2;
        new StringBuilder("on state changed call ").append(mState);
        if (i2 == 0) {
            try {
                Camera.Parameters parameters = mCamera.getParameters();
                parameters.setAutoWhiteBalanceLock(true);
                mCamera.setParameters(parameters);
                AppMethodBeat.o(193627);
            } catch (Exception e2) {
                new StringBuilder("on state changed failed:").append(e2.getLocalizedMessage());
                AppMethodBeat.o(193627);
            }
        } else {
            if (i2 == 1) {
                if (mReflectNotice != null) {
                    mReflectNotice.onDelayCalc();
                    AppMethodBeat.o(193627);
                    return;
                }
            } else if (i2 == 2) {
                Camera.Parameters parameters2 = mCamera.getParameters();
                parameters2.setAutoWhiteBalanceLock(false);
                mCamera.setParameters(parameters2);
                onFinish();
            }
            AppMethodBeat.o(193627);
        }
    }

    public static void pushImageData(byte[] bArr, int i2, int i3, long j2, int i4, float[] fArr, float f2, float f3, float f4) {
        AppMethodBeat.i(193628);
        if (mState == 0) {
            int FRGetConfigBegin = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin() - 2;
            int FRGetConfigEnd = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd() + 4;
            int FRGetTriggerTime = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetTriggerTime();
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "onPreviewFrameReceived. beginFrame: " + FRGetConfigBegin + " endFrame: " + FRGetConfigEnd + " currentFrame: " + FRGetTriggerTime);
            if (FRGetTriggerTime > FRGetConfigBegin && FRGetTriggerTime < FRGetConfigEnd) {
                System.currentTimeMillis();
                YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "onPreviewFrameReceived. insertYuv and time");
                YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(bArr, i2, i3, j2, i4, fArr);
                YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval(j2));
            }
            AppMethodBeat.o(193628);
            return;
        }
        if (mState == 1) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[ReflectController.onPreviewFrameReceived] record ios");
            YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOImgYuv(bArr, i2, i3);
            YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOCaptureTime(JNIUtils.getTimeval(j2));
        }
        AppMethodBeat.o(193628);
    }

    public static void onCameraChanged(int i2) {
        AppMethodBeat.i(193629);
        try {
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setExposureCompensation(i2);
            mCamera.setParameters(parameters);
            AppMethodBeat.o(193629);
        } catch (Exception e2) {
            new StringBuilder("on camera changed failed:").append(e2.getLocalizedMessage());
            AppMethodBeat.o(193629);
        }
    }

    public static int[] onFetchCameraInfo() {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(193630);
        try {
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.getExposureCompensation();
            try {
                i3 = Integer.parseInt(parameters.get("iso"));
            } catch (Exception e2) {
                new StringBuilder("on fectch camera compoensation failed:").append(e2.getLocalizedMessage());
            }
            try {
                i2 = parameters.getMinExposureCompensation();
            } catch (Exception e3) {
                e = e3;
                i2 = 0;
                new StringBuilder("on fectch camera info failed:").append(e.getLocalizedMessage());
                i4 = 0;
                new StringBuilder("on fetch camera exp:").append(i3).append(" min:").append(i2).append(" max:").append(i4);
                int[] iArr = {i3, i2, i4};
                AppMethodBeat.o(193630);
                return iArr;
            }
            try {
                i4 = parameters.getMaxExposureCompensation();
            } catch (Exception e4) {
                e = e4;
                new StringBuilder("on fectch camera info failed:").append(e.getLocalizedMessage());
                i4 = 0;
                new StringBuilder("on fetch camera exp:").append(i3).append(" min:").append(i2).append(" max:").append(i4);
                int[] iArr2 = {i3, i2, i4};
                AppMethodBeat.o(193630);
                return iArr2;
            }
        } catch (Exception e5) {
            e = e5;
            i2 = 0;
            i3 = 0;
            new StringBuilder("on fectch camera info failed:").append(e.getLocalizedMessage());
            i4 = 0;
            new StringBuilder("on fetch camera exp:").append(i3).append(" min:").append(i2).append(" max:").append(i4);
            int[] iArr22 = {i3, i2, i4};
            AppMethodBeat.o(193630);
            return iArr22;
        }
        new StringBuilder("on fetch camera exp:").append(i3).append(" min:").append(i2).append(" max:").append(i4);
        int[] iArr222 = {i3, i2, i4};
        AppMethodBeat.o(193630);
        return iArr222;
    }

    public static RawYuvData[] getRawYuvDatas() {
        AppMethodBeat.i(193631);
        RawYuvData[] FRGetRawYuvDatas = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetRawYuvDatas();
        AppMethodBeat.o(193631);
        return FRGetRawYuvDatas;
    }
}

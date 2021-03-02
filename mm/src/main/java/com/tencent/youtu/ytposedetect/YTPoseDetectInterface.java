package com.tencent.youtu.ytposedetect;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager;

public class YTPoseDetectInterface {
    private static final String TAG = "YoutuFaceDetect";
    public static final String VERSION = "3.5.6.3";
    private static PoseDetectResult mCheckResult;
    private static int mInitModel = 0;
    private static boolean mIsStarted = false;
    public static int mModelRetainCount = 0;
    private static PoseDetectProcessManager mPoseDetectProcessManager;

    public interface PoseDetectGetBestImage {
        void onGetBestImage(byte[] bArr, int i2, int i3);
    }

    public interface PoseDetectGetImage {
        void onGetImage(byte[] bArr, int i2, int i3);
    }

    public interface PoseDetectLiveType {
        public static final int LIVETYPE_BLINK_EYE = 1;
        public static final int LIVETYPE_NOD_HEAD = 3;
        public static final int LIVETYPE_OPEN_MOUTH = 2;
        public static final int LIVETYPE_SHAKE_HEAD = 4;
        public static final int LIVETYPE_SILENCE = 5;
    }

    public interface PoseDetectOnFrame {
        public static final int DETECT_AUTH_FAILED = 1;
        public static final int DETECT_NOT_CALL_START = 3;
        public static final int DETECT_NOT_INIT_MODEL = 2;
        public static final int DETECT_SUCCESS = 0;

        void onCanReflect();

        void onFailed(int i2, String str, String str2);

        void onRecordingDone(byte[][] bArr, int i2, int i3);

        void onSuccess(int i2);
    }

    public interface PoseDetectResult {
        public static final int ERROR_AUTH_FAILED = 1;
        public static final int ERROR_NOT_INIT_MODEL = 2;
        public static final int SUCCESS = 0;

        void onFailed(int i2, String str, String str2);

        void onSuccess();
    }

    public interface PoseDetectSafetyLevel {
        public static final int SAFETY_COUNT = 3;
        public static final int SAFETY_HIGH = 2;
        public static final int SAFETY_LOW = 1;
        public static final int SAFETY_RECOMMAND = 0;
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(62512);
        noticeSuccess();
        AppMethodBeat.o(62512);
    }

    static /* synthetic */ void access$100(int i2, String str, String str2) {
        AppMethodBeat.i(62513);
        noticeFailed(i2, str, str2);
        AppMethodBeat.o(62513);
    }

    public class PoseImage {
        byte[] data;
        int height;
        int width;

        public PoseImage() {
        }
    }

    public static String getVersion() {
        AppMethodBeat.i(192526);
        String str = "jar3.5.6.3_native" + YTPoseDetectJNIInterface.getVersion();
        AppMethodBeat.o(192526);
        return str;
    }

    public static int initModel() {
        AppMethodBeat.i(62500);
        try {
            YTPoseDetectJNIInterface.nativeLog(TAG, "[YTFacePreviewInterface.initModel] ---");
            if (mInitModel > 0) {
                YTPoseDetectJNIInterface.nativeLog(TAG, "[YTFacePreviewInterface.initModel] has already inited.");
                mInitModel++;
                AppMethodBeat.o(62500);
                return 0;
            }
            int initModel = YTPoseDetectJNIInterface.initModel("");
            if (initModel == 0) {
                PoseDetectProcessManager poseDetectProcessManager = new PoseDetectProcessManager();
                mPoseDetectProcessManager = poseDetectProcessManager;
                poseDetectProcessManager.initAll();
                mInitModel++;
                AppMethodBeat.o(62500);
                return 0;
            }
            AppMethodBeat.o(62500);
            return initModel;
        } catch (Exception e2) {
            YTPoseDetectJNIInterface.nativeLog(TAG, "initModel failed. message: " + e2.getMessage());
            YTException.report(e2);
            AppMethodBeat.o(62500);
            return 10;
        }
    }

    public static void releaseModel() {
        AppMethodBeat.i(62501);
        YTPoseDetectJNIInterface.nativeLog(TAG, "[YTFacePreviewInterface.finalize] ---");
        int i2 = mInitModel - 1;
        mInitModel = i2;
        if (i2 <= 0) {
            if (mPoseDetectProcessManager != null) {
                mPoseDetectProcessManager.clearAll();
            }
            YTPoseDetectJNIInterface.releaseAll();
            mInitModel = 0;
        }
        AppMethodBeat.o(62501);
    }

    public static void setSafetyLevel(int i2) {
        AppMethodBeat.i(62502);
        if (i2 >= 0 && i2 < 3) {
            YTPoseDetectJNIInterface.setSafetyLevel(i2);
        }
        AppMethodBeat.o(62502);
    }

    public static void poseDetect(float[] fArr, float[] fArr2, int i2, byte[] bArr, Camera camera, float f2, float f3, float f4, PoseDetectOnFrame poseDetectOnFrame, int i3) {
        AppMethodBeat.i(192527);
        if (mInitModel <= 0) {
            poseDetectOnFrame.onFailed(2, "Not init model on poseDetect.", "Call YTPoseDetectInterface.initModel() before.");
            AppMethodBeat.o(192527);
        } else if (!mIsStarted) {
            poseDetectOnFrame.onFailed(3, "Not call start() interface before.", "Call YTPoseDetectInterface.start() before.");
            AppMethodBeat.o(192527);
        } else {
            poseDetectOnFrame.onSuccess(mPoseDetectProcessManager.poseDetect(fArr, fArr2, i2, bArr, f2, f3, f4, i3));
            if (YTPoseDetectJNIInterface.canReflect()) {
                poseDetectOnFrame.onCanReflect();
            }
            if (YTPoseDetectJNIInterface.isRecordingDone()) {
                byte[][] frameList = YTPoseDetectJNIInterface.getFrameList();
                int rotateTag = YTCameraSetting.getRotateTag(mPoseDetectProcessManager.mCameraRotate, 1);
                YTPoseDetectJNIInterface.nativeLog(TAG, "[YTPoseDetectInterface.poseDetect] list num: " + frameList.length);
                int i4 = mPoseDetectProcessManager.mDesiredPreviewWidth;
                int i5 = mPoseDetectProcessManager.mDesiredPreviewHeight;
                if (i3 == 1 && (rotateTag == 5 || rotateTag == 6 || rotateTag == 7 || rotateTag == 8)) {
                    i4 = mPoseDetectProcessManager.mDesiredPreviewHeight;
                    i5 = mPoseDetectProcessManager.mDesiredPreviewWidth;
                }
                poseDetectOnFrame.onRecordingDone(frameList, i4, i5);
            }
            AppMethodBeat.o(192527);
        }
    }

    public static YTActRefData getActReflectData() {
        AppMethodBeat.i(192528);
        YTActRefData actionReflectData = YTPoseDetectJNIInterface.getActionReflectData(YTCameraSetting.getRotateTag(mPoseDetectProcessManager.mCameraRotate, 1));
        AppMethodBeat.o(192528);
        return actionReflectData;
    }

    public static void getBestImage(PoseDetectGetBestImage poseDetectGetBestImage, boolean z) {
        int i2 = 1;
        AppMethodBeat.i(62504);
        if (z) {
            i2 = YTCameraSetting.getRotateTag(mPoseDetectProcessManager.mCameraRotate, 1);
        }
        byte[] bestImage = YTPoseDetectJNIInterface.getBestImage(i2);
        if (i2 == 5 || i2 == 6 || i2 == 7 || i2 == 8) {
            poseDetectGetBestImage.onGetBestImage(bestImage, mPoseDetectProcessManager.mDesiredPreviewHeight, mPoseDetectProcessManager.mDesiredPreviewWidth);
            AppMethodBeat.o(62504);
            return;
        }
        poseDetectGetBestImage.onGetBestImage(bestImage, mPoseDetectProcessManager.mDesiredPreviewWidth, mPoseDetectProcessManager.mDesiredPreviewHeight);
        AppMethodBeat.o(62504);
    }

    public static YTPoseImage getBestImage(int i2) {
        AppMethodBeat.i(192529);
        YTPoseImage yTPoseImage = new YTPoseImage();
        yTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getBestImage(i2);
        if (i2 == 5 || i2 == 6 || i2 == 7 || i2 == 8) {
            yTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewHeight;
            yTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewWidth;
        } else {
            yTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewWidth;
            yTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewHeight;
        }
        AppMethodBeat.o(192529);
        return yTPoseImage;
    }

    public static YTPoseImage getEyeImage(int i2) {
        AppMethodBeat.i(192530);
        YTPoseImage yTPoseImage = new YTPoseImage();
        yTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getEyeImage(i2);
        if (i2 == 5 || i2 == 6 || i2 == 7 || i2 == 8) {
            yTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewHeight;
            yTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewWidth;
        } else {
            yTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewWidth;
            yTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewHeight;
        }
        AppMethodBeat.o(192530);
        return yTPoseImage;
    }

    public static YTPoseImage getMouthImage(int i2) {
        AppMethodBeat.i(192531);
        YTPoseImage yTPoseImage = new YTPoseImage();
        yTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getMouthImage(i2);
        if (i2 == 5 || i2 == 6 || i2 == 7 || i2 == 8) {
            yTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewHeight;
            yTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewWidth;
        } else {
            yTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewWidth;
            yTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewHeight;
        }
        AppMethodBeat.o(192531);
        return yTPoseImage;
    }

    public static int start(Context context, Camera camera, int i2, PoseDetectResult poseDetectResult) {
        AppMethodBeat.i(62505);
        YTPoseDetectJNIInterface.nativeLog(TAG, "[YTPoseDetectInterface.start] ---");
        if (poseDetectResult == null) {
            AppMethodBeat.o(62505);
            return -1;
        }
        mCheckResult = poseDetectResult;
        if (mInitModel > 0) {
            mPoseDetectProcessManager.start(context, camera, i2, new PoseDetectResult() {
                /* class com.tencent.youtu.ytposedetect.YTPoseDetectInterface.AnonymousClass1 */

                @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult
                public final void onSuccess() {
                    AppMethodBeat.i(62498);
                    YTPoseDetectInterface.access$000();
                    AppMethodBeat.o(62498);
                }

                @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult
                public final void onFailed(int i2, String str, String str2) {
                    AppMethodBeat.i(62499);
                    YTPoseDetectInterface.access$100(i2, str, str2);
                    AppMethodBeat.o(62499);
                }
            });
        } else {
            noticeFailed(2, "Not init model.", "Call YTPoseDetectInterface.initModel() before.");
        }
        AppMethodBeat.o(62505);
        return 0;
    }

    public static void reset() {
        AppMethodBeat.i(62506);
        YTPoseDetectJNIInterface.resetDetect();
        AppMethodBeat.o(62506);
    }

    public static void stop() {
        AppMethodBeat.i(62507);
        YTPoseDetectJNIInterface.nativeLog(TAG, "[YTPoseDetectInterface.stop] ---");
        if (mPoseDetectProcessManager != null) {
            mPoseDetectProcessManager.stop();
        }
        mIsStarted = false;
        AppMethodBeat.o(62507);
    }

    public static boolean isDetecting() {
        return mPoseDetectProcessManager != null && mPoseDetectProcessManager.mIsDetecting;
    }

    private static void noticeSuccess() {
        AppMethodBeat.i(62510);
        YTPoseDetectJNIInterface.nativeLog(TAG, "[YTPoseDetectInterface.noticeSuccess] ---");
        mCheckResult.onSuccess();
        mCheckResult = null;
        mIsStarted = true;
        AppMethodBeat.o(62510);
    }

    private static void noticeFailed(int i2, String str, String str2) {
        AppMethodBeat.i(62511);
        YTPoseDetectJNIInterface.nativeLog(TAG, "[YTPoseDetectInterface.noticeFailed] resultCode: " + i2 + " \r\nmessage: " + str + " \r\ntips: " + str2);
        mPoseDetectProcessManager.restoreCamera();
        mCheckResult.onFailed(i2, str, str2);
        mCheckResult = null;
        mIsStarted = false;
        AppMethodBeat.o(62511);
    }
}

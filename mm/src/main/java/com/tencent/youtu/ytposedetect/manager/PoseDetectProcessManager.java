package com.tencent.youtu.ytposedetect.manager;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;

public class PoseDetectProcessManager {
    private static final String TAG = "FaceDetectProcess";
    private Camera mCamera = null;
    private Camera.Parameters mCameraParameters = null;
    public int mCameraRotate;
    public int mDesiredPreviewHeight = 480;
    public int mDesiredPreviewWidth = 640;
    public boolean mIsDetecting = false;

    public void initAll() {
    }

    public void clearAll() {
        AppMethodBeat.i(62515);
        restoreCamera();
        AppMethodBeat.o(62515);
    }

    public void start(Context context, Camera camera, int i2, YTPoseDetectInterface.PoseDetectResult poseDetectResult) {
        AppMethodBeat.i(62516);
        if (this.mIsDetecting) {
            YTPoseDetectJNIInterface.nativeLog(TAG, "Restart FaceDetect process. YTPoseDetectInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
        }
        int camera2 = setCamera(context, camera, i2);
        if (camera2 != 0) {
            poseDetectResult.onFailed(camera2, "set camera failed", "reset again");
            AppMethodBeat.o(62516);
            return;
        }
        this.mCameraRotate = YTCameraSetting.getVideoRotate(context, i2);
        this.mIsDetecting = true;
        poseDetectResult.onSuccess();
        AppMethodBeat.o(62516);
    }

    public void stop() {
        AppMethodBeat.i(62517);
        if (this.mIsDetecting) {
            this.mIsDetecting = false;
            restoreCamera();
            YTPoseDetectJNIInterface.resetDetect();
        }
        AppMethodBeat.o(62517);
    }

    public int poseDetect(float[] fArr, float[] fArr2, int i2, byte[] bArr, float f2, float f3, float f4, int i3) {
        AppMethodBeat.i(192534);
        int poseDetect = YTPoseDetectJNIInterface.poseDetect(fArr, fArr2, i2, bArr, this.mDesiredPreviewWidth, this.mDesiredPreviewHeight, YTCameraSetting.getRotateTag(this.mCameraRotate, 1), f2, f3, f4, i3);
        AppMethodBeat.o(192534);
        return poseDetect;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(62519);
        super.finalize();
        AppMethodBeat.o(62519);
    }

    private int setCamera(Context context, Camera camera, int i2) {
        AppMethodBeat.i(192535);
        this.mCamera = camera;
        int i3 = 0;
        int i4 = 3;
        while (i4 > 0) {
            try {
                this.mCameraParameters = camera.getParameters();
                this.mDesiredPreviewHeight = this.mCameraParameters.getPreviewSize().height;
                this.mDesiredPreviewWidth = this.mCameraParameters.getPreviewSize().width;
                YTPoseDetectJNIInterface.nativeLog(TAG, "[PoseDetectProcessManager.setCamera] mDesiredPreviewWidth: " + this.mDesiredPreviewWidth + " mDesiredPreviewHeight: " + this.mDesiredPreviewHeight);
                i4 = 0;
            } catch (Exception e2) {
                YTPoseDetectJNIInterface.nativeLog(TAG, "[PoseDetectProcessManager.setCamera] failed:" + e2 + " retry " + i4);
                int i5 = i4 - 1;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e3) {
                    YTPoseDetectJNIInterface.nativeLog(TAG, "[PoseDetectProcessManager.setCamera] sleep failed:".concat(String.valueOf(e3)));
                }
                if (i5 == 0) {
                    i3 = 3;
                }
                i4 = i5;
            }
        }
        AppMethodBeat.o(192535);
        return i3;
    }

    public void restoreCamera() {
        AppMethodBeat.i(62521);
        if (this.mCamera == null || this.mCameraParameters == null) {
            AppMethodBeat.o(62521);
            return;
        }
        try {
            this.mCamera.setParameters(this.mCameraParameters);
        } catch (Exception e2) {
            YTPoseDetectJNIInterface.nativeLog(TAG, "restoreCamera failed. ");
            YTException.report(e2);
        } finally {
            this.mCamera = null;
            this.mCameraParameters = null;
            AppMethodBeat.o(62521);
        }
    }
}

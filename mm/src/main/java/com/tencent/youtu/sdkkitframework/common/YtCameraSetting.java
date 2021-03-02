package com.tencent.youtu.sdkkitframework.common;

import android.content.Context;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;
import java.util.List;

public class YtCameraSetting {
    private static final String TAG = "YtCameraSetting";
    public static int mCameraFacing = 1;
    static int mDesiredPreviewHeight = 480;
    static int mDesiredPreviewWidth = 640;
    public static int mRotate = 0;

    public static void setCameraFacing(int i2) {
        mCameraFacing = i2;
    }

    public static void setCameraRotate(int i2) {
        mRotate = i2;
    }

    public static int getDesiredPreviewWidth() {
        return mDesiredPreviewWidth;
    }

    public static int getDesiredPreviewHeight() {
        return mDesiredPreviewHeight;
    }

    public static int getRotate(Context context, int i2, int i3) {
        AppMethodBeat.i(192565);
        int rotateTag = getRotateTag(getVideoRotate(context, i2), i3);
        AppMethodBeat.o(192565);
        return rotateTag;
    }

    public static int transBackFacingCameraRatateTag(int i2) {
        AppMethodBeat.i(192566);
        if (i2 == 1) {
            AppMethodBeat.o(192566);
            return 2;
        } else if (i2 == 2) {
            AppMethodBeat.o(192566);
            return 1;
        } else if (i2 == 3) {
            AppMethodBeat.o(192566);
            return 4;
        } else if (i2 == 4) {
            AppMethodBeat.o(192566);
            return 3;
        } else if (i2 == 5) {
            AppMethodBeat.o(192566);
            return 8;
        } else if (i2 == 6) {
            AppMethodBeat.o(192566);
            return 7;
        } else if (i2 == 7) {
            AppMethodBeat.o(192566);
            return 6;
        } else if (i2 == 8) {
            AppMethodBeat.o(192566);
            return 5;
        } else {
            YtLogger.w(TAG, "[YtCameraSetting.transBackFacingCameraRatateTag] unsurported rotateTag: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(192566);
            return 0;
        }
    }

    public static int getRotateTag(int i2, int i3) {
        int i4;
        AppMethodBeat.i(192567);
        if (i2 == 90) {
            i4 = 7;
        } else if (i2 == 180) {
            i4 = 3;
        } else if (i2 == 270) {
            i4 = 5;
        } else {
            YtLogger.i(TAG, "camera rotate not 90degree or 180degree, input: ".concat(String.valueOf(i2)));
            i4 = 1;
        }
        if (i3 == 1) {
            AppMethodBeat.o(192567);
            return i4;
        }
        int transBackFacingCameraRatateTag = transBackFacingCameraRatateTag(i4);
        AppMethodBeat.o(192567);
        return transBackFacingCameraRatateTag;
    }

    public static int getVideoRotate(Context context, int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(192568);
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                i3 = 0;
                break;
            case 1:
                i3 = 90;
                break;
            case 2:
                i3 = TXLiveConstants.RENDER_ROTATION_180;
                break;
            case 3:
                i3 = 270;
                break;
            default:
                i3 = 0;
                break;
        }
        if (cameraInfo.facing == 1) {
            i4 = (360 - ((cameraInfo.orientation + i3) % v2helper.VOIP_ENC_HEIGHT_LV1)) % v2helper.VOIP_ENC_HEIGHT_LV1;
        } else {
            i4 = ((cameraInfo.orientation - i3) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        }
        YtLogger.i(TAG, "debug camera orientation is " + cameraInfo.orientation + " ui degrees is " + i3);
        AppMethodBeat.o(192568);
        return i4;
    }

    public static int initCamera(Context context, Camera camera, int i2) {
        AppMethodBeat.i(192569);
        initCamera(context, camera, i2, 4);
        AppMethodBeat.o(192569);
        return 0;
    }

    public static int initCamera(Context context, Camera camera, int i2, int i3) {
        Camera.Parameters parameters;
        CamcorderProfile camcorderProfile;
        AppMethodBeat.i(192570);
        try {
            Camera.Parameters parameters2 = camera.getParameters();
            List<String> supportedFocusModes = parameters2.getSupportedFocusModes();
            for (int i4 = 0; i4 < supportedFocusModes.size(); i4++) {
                YtLogger.v(TAG, "suporrtedFocusModes " + i4 + " :" + supportedFocusModes.get(i4));
            }
            if (supportedFocusModes != null && supportedFocusModes.indexOf("continuous-video") >= 0) {
                parameters2.setFocusMode("continuous-video");
                YtLogger.d(TAG, "set camera focus mode continuous video");
            } else if (supportedFocusModes == null || supportedFocusModes.indexOf("auto") < 0) {
                YtLogger.d(TAG, "NOT set camera focus mode");
            } else {
                parameters2.setFocusMode("auto");
                YtLogger.d(TAG, "set camera focus mode auto");
            }
            try {
                camera.setParameters(parameters2);
                parameters = camera.getParameters();
            } catch (Exception e2) {
                YtLogger.e(TAG, "Camera.setParameters.setPreviewSize failed!!: " + e2.getLocalizedMessage());
                parameters = camera.getParameters();
            } catch (Throwable th) {
                camera.getParameters();
                AppMethodBeat.o(192570);
                throw th;
            }
            int videoRotate = getVideoRotate(context, i2);
            camera.setDisplayOrientation(videoRotate);
            YtLogger.d(TAG, "videoOrietation is".concat(String.valueOf(videoRotate)));
            if (CamcorderProfile.hasProfile(i2, i3)) {
                CamcorderProfile camcorderProfile2 = CamcorderProfile.get(i2, i3);
                YtLogger.d(TAG, "custom camcorderProfile:" + camcorderProfile2.videoFrameWidth + "x" + camcorderProfile2.videoFrameHeight);
                camcorderProfile = camcorderProfile2;
            } else if (CamcorderProfile.hasProfile(i2, 4)) {
                CamcorderProfile camcorderProfile3 = CamcorderProfile.get(i2, 4);
                YtLogger.d(TAG, "480P camcorderProfile:" + camcorderProfile3.videoFrameWidth + "x" + camcorderProfile3.videoFrameHeight);
                camcorderProfile = camcorderProfile3;
            } else if (CamcorderProfile.hasProfile(i2, 5)) {
                CamcorderProfile camcorderProfile4 = CamcorderProfile.get(i2, 5);
                YtLogger.d(TAG, "720P camcorderProfile:" + camcorderProfile4.videoFrameWidth + "x" + camcorderProfile4.videoFrameHeight);
                camcorderProfile = camcorderProfile4;
            } else {
                CamcorderProfile camcorderProfile5 = CamcorderProfile.get(i2, 1);
                YtLogger.d(TAG, "High camcorderProfile:" + camcorderProfile5.videoFrameWidth + "x" + camcorderProfile5.videoFrameHeight);
                camcorderProfile = camcorderProfile5;
            }
            List<Camera.Size> supportedPictureSizes = camera.getParameters().getSupportedPictureSizes();
            List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
            for (int i5 = 0; i5 < supportedPictureSizes.size(); i5++) {
                Camera.Size size = supportedPictureSizes.get(i5);
                YtLogger.d("pictureSize", size.width + " x " + size.height);
            }
            for (int i6 = 0; i6 < supportedPreviewSizes.size(); i6++) {
                Camera.Size size2 = supportedPreviewSizes.get(i6);
                YtLogger.d("previewSize", size2.width + " x " + size2.height);
            }
            setVideoSize(parameters, camcorderProfile);
            mDesiredPreviewWidth = camcorderProfile.videoFrameWidth;
            mDesiredPreviewHeight = camcorderProfile.videoFrameHeight;
            YtLogger.d(TAG, "mDesiredPreviewWidth: " + mDesiredPreviewWidth + ", mDesiredPreviewHeight: " + mDesiredPreviewHeight);
            parameters.setPreviewSize(mDesiredPreviewWidth, mDesiredPreviewHeight);
            parameters.setPreviewFormat(17);
            try {
                camera.setParameters(parameters);
            } catch (Exception e3) {
                YtLogger.e(TAG, "Camera.setParameters.setPreviewSize failed!!: " + e3.getLocalizedMessage());
            }
            Camera.Parameters parameters3 = camera.getParameters();
            YtLogger.d(TAG, "choose camera fps is : ".concat(String.valueOf(chooseFixedPreviewFps(parameters3, CommonUtils.MAX_TIMEOUT_MS))));
            try {
                camera.setParameters(parameters3);
            } catch (Exception e4) {
                YtLogger.e(TAG, "Camera.setParameters.preview fps failed!!: " + e4.getLocalizedMessage());
            }
            Camera.Parameters parameters4 = camera.getParameters();
            int[] iArr = new int[2];
            parameters4.getPreviewFpsRange(iArr);
            YtLogger.d(TAG, "after set parameters getPreviewFpsRange=" + iArr[0] + "-" + iArr[1] + " ;after set parameter fps=" + parameters4.getPreviewFrameRate());
            Camera.Size previewSize = parameters4.getPreviewSize();
            YtLogger.d(TAG, "camera preview size is " + previewSize.width + " " + previewSize.height);
            AppMethodBeat.o(192570);
            return 0;
        } catch (Exception e5) {
            YtLogger.e(TAG, "get camera parameters failed. 1. Check Camera.getParameters() interface. 2. Get logs for more detail.");
            AppMethodBeat.o(192570);
            return 1;
        }
    }

    public static void setVideoSize(Camera.Parameters parameters, CamcorderProfile camcorderProfile) {
        AppMethodBeat.i(192571);
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (parameters.getSupportedVideoSizes() == null) {
            YtLogger.d(TAG, "video size from profile is : " + camcorderProfile.videoFrameWidth + " " + camcorderProfile.videoFrameHeight);
            if (getOptimalPreviewSize(supportedPreviewSizes, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight) == null) {
                YtLogger.d(TAG, "do not find proper preview size, use default");
                camcorderProfile.videoFrameWidth = 640;
                camcorderProfile.videoFrameHeight = 480;
            }
        }
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            boolean z = false;
            for (int i2 = 0; i2 < supportedVideoSizes.size(); i2++) {
                Camera.Size size = supportedVideoSizes.get(i2);
                if (size.width == camcorderProfile.videoFrameWidth && size.height == camcorderProfile.videoFrameHeight) {
                    z = true;
                }
            }
            if (!z) {
                camcorderProfile.videoFrameWidth = 640;
                camcorderProfile.videoFrameHeight = 480;
            }
        }
        YtLogger.d(TAG, "select video size camcorderProfile:" + camcorderProfile.videoFrameWidth + "x" + camcorderProfile.videoFrameHeight);
        AppMethodBeat.o(192571);
    }

    private static Camera.Size getOptimalPreviewSize(List<Camera.Size> list, int i2, int i3) {
        AppMethodBeat.i(192572);
        if (list == null) {
            AppMethodBeat.o(192572);
            return null;
        }
        Camera.Size size = null;
        double d2 = Double.MAX_VALUE;
        int max = Math.max(i2, i3);
        int min = Math.min(i2, i3);
        double d3 = ((double) max) / ((double) min);
        YtLogger.d(TAG, "sizes size=" + list.size());
        for (Camera.Size size2 : list) {
            if (Math.abs((((double) size2.width) / ((double) size2.height)) - d3) > 0.001d || ((double) Math.abs(size2.height - min)) >= d2) {
                size2 = size;
            } else {
                d2 = (double) Math.abs(size2.height - min);
            }
            size = size2;
        }
        if (size == null) {
            YtLogger.d(TAG, "No preview size match the aspect ratio");
            double d4 = Double.MAX_VALUE;
            for (Camera.Size size3 : list) {
                if (((double) Math.abs(size3.height - min)) < d4) {
                    d4 = (double) Math.abs(size3.height - min);
                    size = size3;
                }
            }
        }
        AppMethodBeat.o(192572);
        return size;
    }

    private static int chooseFixedPreviewFps(Camera.Parameters parameters, int i2) {
        int parseInt;
        AppMethodBeat.i(192573);
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            YtLogger.d(TAG, "entry: " + iArr[0] + " - " + iArr[1]);
            if (iArr[0] == iArr[1] && iArr[0] == i2) {
                parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                YtLogger.d(TAG, "use preview fps range: " + iArr[0] + " " + iArr[1]);
                int i3 = iArr[0];
                AppMethodBeat.o(192573);
                return i3;
            }
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (iArr2[0] == iArr2[1]) {
            i2 = iArr2[0];
        } else {
            if (i2 > iArr2[1]) {
                i2 = iArr2[1];
            }
            if (i2 < iArr2[0]) {
                i2 = iArr2[0];
            }
        }
        String str = parameters.get("preview-frame-rate-values");
        if (!TextUtils.isEmpty(str) && !str.contains(new StringBuilder().append(i2 / 1000).toString())) {
            String[] split = str.split(",");
            for (String str2 : split) {
                int parseInt2 = Integer.parseInt(str2) * 1000;
                if (i2 < parseInt2) {
                    parameters.setPreviewFrameRate(parseInt2 / 1000);
                    AppMethodBeat.o(192573);
                    return parseInt2;
                }
            }
            if (split.length > 0 && i2 > (parseInt = Integer.parseInt(split[split.length - 1]) * 1000)) {
                i2 = parseInt;
            }
        }
        parameters.setPreviewFrameRate(i2 / 1000);
        AppMethodBeat.o(192573);
        return i2;
    }
}

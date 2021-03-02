package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.TimeoutCounter;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.ytcommon.tools.YTFaceUtils;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.param.YTFaceAlignParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SilentLivenessState extends YtFSMBaseState {
    private static final int CONTINUOUS_DETECT_COUNT = 3;
    private static int FIX_EYE_MOUTH = 5;
    private static int REFINE_CONFIG_OFF = 8197;
    private static final String TAG = SilentLivenessState.class.getSimpleName();
    private float bigFaceThresholdBuffer = 0.05f;
    private float bigfaceThreshold = 1.0f;
    private float blurDetectThreshold = 0.3f;
    private int cameraRotateState;
    private int continueCloseEyeCount = 0;
    private int continueNoValidFaceCount = 0;
    private int continueNovalidFaceCountThreshold = 5;
    private int continueShelterJudgeCount = 0;
    private TimeoutCounter countdowner = new TimeoutCounter("Liveness timeout counter");
    private FacePreviewingAdvise currentAdviseTip = FacePreviewingAdvise.ADVISE_PASS;
    private int currentShelterJudge = -1;
    private int detectAvailableCount = 0;
    private int detectIntervalCount = 5;
    private String extraTips = "";
    private float eyeOpenThreshold = 0.22f;
    private int frameNum = 0;
    private float inRectThreshold = 0.7f;
    float intersectRatio = -1.0E10f;
    private int invalidPointCount;
    private boolean isFirstStablePass = false;
    private boolean isLoadResourceOnline = false;
    private float maskHeightRatio;
    private float maskWidthRatio;
    private float maxEyeScore = -1.0E10f;
    private float maxInRectRatio = -1.0E10f;
    private float maxMouthScore = -1.0E10f;
    private float maxShelterScore = -1.0E10f;
    private float minEyeScore = 1.0E10f;
    private float minMouthScore = 1.0E10f;
    private boolean needBigFaceMode = true;
    private boolean needCheckEyeOpen = false;
    private boolean needCheckMultiFaces = false;
    private boolean needCheckPose = false;
    private boolean needCheckShelter = true;
    private boolean needManualTrigger = false;
    private boolean needTimeoutTimer = false;
    private int pitchThreshold = 30;
    private float poseThresholdBuffer = 0.05f;
    private TimeoutCounter predetectCountdowner = new TimeoutCounter("Predetect timeout counter");
    private FacePreviewingAdvise prevAdvise = FacePreviewingAdvise.ADVISE_NAN;
    private int prevJudge = -1;
    private int previewHeight;
    private int previewWidth;
    private Rect previousFaceRect = null;
    private int previousShelterJudge = 0;
    private String resourceDownloadPath = "";
    private int rollThreshold = 25;
    private int sameFaceTipCount = 0;
    private float smallFaceThresholdBuffer = 0.05f;
    private float smallfaceThreshold = 0.5f;
    private int stableCountNum = 5;
    private int stableFaceCount = 0;
    private float stableRoiThreshold = 0.9f;
    private boolean tipFilterFlag = true;
    private boolean triggerLiveBeginEventFlag = false;
    private int unstableCount = 0;
    private int yawThreshold = 25;

    public SilentLivenessState() {
        AppMethodBeat.i(187267);
        AppMethodBeat.o(187267);
    }

    static {
        AppMethodBeat.i(187291);
        AppMethodBeat.o(187291);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void loadStateWith(String str, JSONObject jSONObject) {
        AppMethodBeat.i(187268);
        super.loadStateWith(str, jSONObject);
        try {
            if (jSONObject.has("resource_online")) {
                this.isLoadResourceOnline = jSONObject.getBoolean("resource_online");
            }
            if (jSONObject.has("resource_download_path")) {
                this.resourceDownloadPath = jSONObject.getString("resource_download_path");
            }
            if (jSONObject.has("timeout_countdown_ms")) {
                this.countdowner.init((long) Math.max(0, Math.min((int) CommonUtils.MAX_TIMEOUT_MS, jSONObject.getInt("timeout_countdown_ms"))), true);
            }
            if (jSONObject.has("predetect_countdown_ms")) {
                this.predetectCountdowner.init((long) jSONObject.getInt("predetect_countdown_ms"), true);
            } else {
                this.predetectCountdowner.init(25000, true);
            }
            if (jSONObject.has("same_tips_filter")) {
                this.tipFilterFlag = jSONObject.getBoolean("same_tips_filter");
            }
            if (jSONObject.has("manual_trigger")) {
                this.needManualTrigger = jSONObject.getBoolean("manual_trigger");
            }
            this.needCheckMultiFaces = jSONObject.optBoolean("need_check_multiface", false);
            updateSDKSetting(jSONObject);
        } catch (JSONException e2) {
            YtLogger.e(TAG, "Failed to parse json:" + e2.getLocalizedMessage());
        }
        if (!this.isLoadResourceOnline) {
            FileUtils.loadLibrary("YTFaceTrackPro2");
        }
        Camera.Size previewSize = YtFSM.getInstance().getContext().currentCamera.getParameters().getPreviewSize();
        this.cameraRotateState = YtFSM.getInstance().getContext().currentRotateState;
        if (this.cameraRotateState >= 5) {
            this.previewWidth = previewSize.height;
            this.previewHeight = previewSize.width;
        } else {
            this.previewWidth = previewSize.width;
            this.previewHeight = previewSize.height;
        }
        this.maskWidthRatio = ((float) YtSDKKitFramework.getInstance().getPreviewRect().width()) / ((float) this.previewWidth);
        this.maskHeightRatio = ((float) YtSDKKitFramework.getInstance().getPreviewRect().height()) / ((float) this.previewHeight);
        initYoutuInstance();
        reset();
        AppMethodBeat.o(187268);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void unload() {
        AppMethodBeat.i(187269);
        super.unload();
        try {
            YTFaceTrack.GlobalRelease();
            AppMethodBeat.o(187269);
        } catch (Exception e2) {
            YtLogger.e(TAG, "SDK inner bug");
            AppMethodBeat.o(187269);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void reset() {
        AppMethodBeat.i(187270);
        this.prevAdvise = FacePreviewingAdvise.ADVISE_NAN;
        this.detectAvailableCount = 0;
        this.continueCloseEyeCount = 0;
        this.frameNum = 0;
        this.triggerLiveBeginEventFlag = false;
        this.sameFaceTipCount = 0;
        this.maxEyeScore = -1.0E10f;
        this.minMouthScore = 1.0E10f;
        this.minEyeScore = 1.0E10f;
        this.maxMouthScore = -1.0E10f;
        this.maxShelterScore = -1.0E10f;
        this.isFirstStablePass = false;
        this.continueNoValidFaceCount = 0;
        this.invalidPointCount = 0;
        this.unstableCount = 0;
        this.maxInRectRatio = -1.0E10f;
        this.countdowner.cancel();
        this.predetectCountdowner.cancel();
        this.stableFaceCount = 0;
        this.currentShelterJudge = -1;
        this.previousFaceRect = null;
        if (!this.needManualTrigger) {
            this.countdowner.reset();
        } else {
            this.predetectCountdowner.reset();
        }
        super.reset();
        AppMethodBeat.o(187270);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
        AppMethodBeat.i(187271);
        if (!this.needManualTrigger) {
            this.countdowner.start();
            AppMethodBeat.o(187271);
            return;
        }
        this.predetectCountdowner.start();
        AppMethodBeat.o(187271);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        AppMethodBeat.i(187272);
        super.enter();
        AppMethodBeat.o(187272);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void exit() {
        AppMethodBeat.i(187273);
        super.exit();
        AppMethodBeat.o(187273);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void update(byte[] bArr, int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(187274);
        super.update(bArr, i2, i3, i4, j2);
        if (this.countdowner.checkTimeout() || (this.needManualTrigger && this.predetectCountdowner.checkTimeout())) {
            moveToNextState();
            AppMethodBeat.o(187274);
            return;
        }
        YTFaceTrack instance = YTFaceTrack.getInstance();
        if (instance == null) {
            YtLogger.e(TAG, "Tracker is null, please check facetrack init result");
            AppMethodBeat.o(187274);
            return;
        }
        this.frameNum++;
        YTFaceTrack.YTImage yTImage = new YTFaceTrack.YTImage();
        yTImage.width = i2;
        yTImage.height = i3;
        float[] fArr = new float[1];
        CommonUtils.benchMarkBegin("detect");
        YTFaceTrack.FaceStatus[] DoDetectionProcessYUVWithBlur = instance.DoDetectionProcessYUVWithBlur(bArr, i2, i3, this.cameraRotateState, true, fArr, yTImage);
        CommonUtils.benchMarkEnd("detect");
        YtLogger.d(TAG, CommonUtils.getBenchMarkTime("detect"));
        YtLogger.d(TAG, "Blur score:" + Arrays.toString(fArr));
        if (DoDetectionProcessYUVWithBlur != null) {
            YtLogger.i(TAG, "face status count " + DoDetectionProcessYUVWithBlur.length);
            if (DoDetectionProcessYUVWithBlur.length > 1) {
                int i5 = Integer.MIN_VALUE;
                int i6 = 0;
                for (int i7 = 0; i7 < DoDetectionProcessYUVWithBlur.length; i7++) {
                    Rect faceRect = getFaceRect(DoDetectionProcessYUVWithBlur[i7]);
                    int height = faceRect.height() * faceRect.width();
                    if (height >= i5) {
                        i6 = i7;
                        i5 = height;
                    }
                }
                if (i6 != 0) {
                    YtLogger.i(TAG, "Found max face id:".concat(String.valueOf(i6)));
                    DoDetectionProcessYUVWithBlur[0] = DoDetectionProcessYUVWithBlur[i6];
                }
            }
        } else {
            YtLogger.i(TAG, "face status is null");
        }
        sendUITipEvent(DoDetectionProcessYUVWithBlur);
        this.stateData.put("pose_state", this.prevAdvise);
        this.stateData.put("shelter_state", Integer.valueOf(this.prevJudge));
        this.stateData.put("face_status", DoDetectionProcessYUVWithBlur);
        this.stateData.put("continuous_detect_count", Integer.valueOf(this.detectAvailableCount));
        YuvImage yuvImage = new YuvImage(yTImage.data, 17, i3, i2, null);
        this.stateData.put("last_face_status", DoDetectionProcessYUVWithBlur);
        this.stateData.put("last_frame", yuvImage);
        if (this.prevAdvise == FacePreviewingAdvise.ADVISE_PASS || this.prevAdvise == FacePreviewingAdvise.ADVISE_INBUFFER_PASS) {
            checkBestImage(DoDetectionProcessYUVWithBlur[0], yuvImage, fArr[0]);
        }
        if (this.stateData.get("best_image") != null && (!this.needManualTrigger || (this.needManualTrigger && this.triggerLiveBeginEventFlag))) {
            moveToNextState();
        }
        AppMethodBeat.o(187274);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void updateSDKSetting(JSONObject jSONObject) {
        AppMethodBeat.i(187275);
        try {
            if (jSONObject.has("check_eye_open")) {
                this.needCheckEyeOpen = jSONObject.getBoolean("check_eye_open");
            }
            if (jSONObject.has("open_eye_threshold")) {
                this.eyeOpenThreshold = (float) jSONObject.getDouble("open_eye_threshold");
            }
            if (jSONObject.has("pitch_threshold")) {
                this.pitchThreshold = jSONObject.getInt("pitch_threshold");
            }
            if (jSONObject.has("yaw_threshold")) {
                this.yawThreshold = jSONObject.getInt("yaw_threshold");
            }
            if (jSONObject.has("roll_threshold")) {
                this.rollThreshold = jSONObject.getInt("roll_threshold");
            }
            if (jSONObject.has("smallface_ratio_threshold")) {
                this.smallfaceThreshold = (float) jSONObject.getDouble("smallface_ratio_threshold");
            }
            if (jSONObject.has("bigface_ratio_threshold")) {
                this.bigfaceThreshold = (float) jSONObject.getDouble("bigface_ratio_threshold");
            }
            if (jSONObject.has("blur_detect_threshold")) {
                this.blurDetectThreshold = (float) jSONObject.getDouble("blur_detect_threshold");
            }
            if (jSONObject.has("need_big_face_mode")) {
                this.needBigFaceMode = jSONObject.getBoolean("need_big_face_mode");
            }
            if (jSONObject.has("detect_interval")) {
                this.detectIntervalCount = jSONObject.getInt("detect_interval");
            }
            if (jSONObject.has("stable_frame_num")) {
                this.stableCountNum = jSONObject.getInt("stable_frame_num");
            }
            if (jSONObject.has("net_request_timeout_ms")) {
                YtSDKKitFramework.getInstance().setNetworkRequestTimeoutMS(jSONObject.getInt("net_request_timeout_ms"));
            }
            if (jSONObject.has("force_pose_check")) {
                this.needCheckPose = jSONObject.getBoolean("force_pose_check");
            }
            if (jSONObject.has("novalid_face_count")) {
                this.continueNovalidFaceCountThreshold = jSONObject.getInt("novalid_face_count");
            }
            if (jSONObject.has("in_rect_ratio_threshold")) {
                this.inRectThreshold = (float) jSONObject.getDouble("in_rect_ratio_threshold");
            }
            if (jSONObject.has("need_check_shelter")) {
                this.needCheckShelter = jSONObject.getBoolean("need_check_shelter");
            }
            if (jSONObject.has("stable_roi_threshold")) {
                this.stableRoiThreshold = (float) jSONObject.getDouble("stable_roi_threshold");
            }
            this.bigFaceThresholdBuffer = (float) jSONObject.optDouble("bigface_ratio_buffer", (double) this.bigFaceThresholdBuffer);
            this.smallFaceThresholdBuffer = (float) jSONObject.optDouble("smallface_ratio_buffer", (double) this.smallFaceThresholdBuffer);
            this.poseThresholdBuffer = (float) jSONObject.optDouble("pose_ratio_buffer", (double) this.poseThresholdBuffer);
            this.stableRoiThreshold = (float) jSONObject.optDouble("stable_roi_threshold", (double) this.stableRoiThreshold);
            AppMethodBeat.o(187275);
        } catch (JSONException e2) {
            YtLogger.e(TAG, "Failed to parse json:" + e2.getLocalizedMessage());
            AppMethodBeat.o(187275);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void moveToNextState() {
        AppMethodBeat.i(187276);
        super.moveToNextState();
        if (!this.needManualTrigger || ((!this.needCheckPose || this.prevAdvise == FacePreviewingAdvise.ADVISE_PASS || this.prevAdvise == FacePreviewingAdvise.ADVISE_INBUFFER_PASS) && !((this.needCheckMultiFaces && this.prevAdvise == FacePreviewingAdvise.ADVISE_TOO_MANY_FACE) || this.prevAdvise == FacePreviewingAdvise.ADVISE_INCOMPLETE_FACE || this.prevAdvise == FacePreviewingAdvise.ADVISE_NO_FACE))) {
            this.continueNoValidFaceCount = 0;
        } else {
            this.continueNoValidFaceCount++;
            if (this.continueNoValidFaceCount > this.continueNovalidFaceCountThreshold) {
                String convertAdvise = convertAdvise(this.prevAdvise);
                String makeMessageJson = CommonUtils.makeMessageJson(4194304, convertAdvise, "action check failed");
                YtSDKStats.getInstance().reportError(4194304, convertAdvise);
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                hashMap.put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                hashMap.put("error_code", 4194304);
                hashMap.put(StateEvent.Name.ERROR_REASON_CODE, 4194304);
                hashMap.put("message", makeMessageJson);
                YtFSM.getInstance().sendFSMEvent(hashMap);
                YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                AppMethodBeat.o(187276);
                return;
            }
        }
        if (this.needManualTrigger && this.predetectCountdowner.checkTimeout()) {
            YtLogger.d(TAG, "predectcountdowner.checkTimeout(): " + this.predetectCountdowner.checkTimeout());
            this.predetectCountdowner.cancel();
            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_VERIFY_TIMEOUT, "yt_verify_step_timeout");
            YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
            AppMethodBeat.o(187276);
        } else if (this.countdowner.checkTimeout()) {
            this.countdowner.cancel();
            YtLogger.d(TAG, "liveness timeout");
            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_VERIFY_TIMEOUT, "yt_verify_step_timeout");
            YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
            AppMethodBeat.o(187276);
        } else {
            if (this.needManualTrigger || this.isFirstStablePass || this.detectAvailableCount > this.stableCountNum) {
                this.isFirstStablePass = true;
                this.predetectCountdowner.cancel();
                switch (YtFSM.getInstance().getWorkMode()) {
                    case YT_FW_SILENT_TYPE:
                    case YT_FW_ACTION_TYPE:
                    case YT_FW_ACTREFLECT_TYPE:
                        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
                        AppMethodBeat.o(187276);
                        return;
                    case YT_FW_REFLECT_TYPE:
                        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
                        AppMethodBeat.o(187276);
                        return;
                    case YT_FW_LIPREAD_TYPE:
                        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.LIPREAD_STATE));
                        break;
                }
            }
            AppMethodBeat.o(187276);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void handleStateAction(String str, Object obj) {
        AppMethodBeat.i(187277);
        super.handleStateAction(str, obj);
        if (str.equals("reset_timeout")) {
            YtLogger.d(TAG, "predetect status:" + this.predetectCountdowner.isRunning());
            if (!this.predetectCountdowner.isRunning()) {
                resetTimeout();
                AppMethodBeat.o(187277);
                return;
            }
        } else if (str.equals("reset_manual_trigger")) {
            this.triggerLiveBeginEventFlag = false;
            this.countdowner.cancel();
        }
        AppMethodBeat.o(187277);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
        AppMethodBeat.i(187278);
        super.handleEvent(ytFrameworkFireEventType, obj);
        if (this.needManualTrigger) {
            if (ytFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_BEGIN_LIVENESS) {
                this.detectAvailableCount = 0;
                this.triggerLiveBeginEventFlag = true;
                resetTimeout();
                AppMethodBeat.o(187278);
                return;
            } else if (ytFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS) {
                this.detectAvailableCount = 0;
                this.triggerLiveBeginEventFlag = false;
                this.countdowner.cancel();
                this.predetectCountdowner.reset();
            }
        }
        AppMethodBeat.o(187278);
    }

    public void resetTimeout() {
        AppMethodBeat.i(187279);
        this.countdowner.reset();
        AppMethodBeat.o(187279);
    }

    public enum FacePreviewingAdvise {
        ADVISE_PASS,
        ADVISE_NO_FACE,
        ADVISE_TOO_FAR,
        ADVISE_TOO_CLOSE,
        ADVISE_NOT_IN_RECT,
        ADVISE_INCORRECT_POSTURE,
        ADVISE_EYE_CLOSE,
        ADVISE_TOO_MANY_FACE,
        ADVISE_INCOMPLETE_FACE,
        ADVISE_INBUFFER_PASS,
        ADVISE_NAN;

        public static FacePreviewingAdvise valueOf(String str) {
            AppMethodBeat.i(187265);
            FacePreviewingAdvise facePreviewingAdvise = (FacePreviewingAdvise) Enum.valueOf(FacePreviewingAdvise.class, str);
            AppMethodBeat.o(187265);
            return facePreviewingAdvise;
        }

        static {
            AppMethodBeat.i(187266);
            AppMethodBeat.o(187266);
        }
    }

    private void checkBestImage(YTFaceTrack.FaceStatus faceStatus, YuvImage yuvImage, float f2) {
        AppMethodBeat.i(187280);
        float calcEyeScore = YtSDKKitCommon.ProcessHelper.calcEyeScore(faceStatus.xys);
        float calcMouthScore = YtSDKKitCommon.ProcessHelper.calcMouthScore(faceStatus.xys);
        float f3 = 0.0f;
        for (int i2 = 0; i2 < faceStatus.pointsVis.length; i2++) {
            f3 += faceStatus.pointsVis[i2];
        }
        if (this.stableFaceCount < this.stableCountNum) {
            YtLogger.e(TAG, "stable count " + this.stableFaceCount);
            AppMethodBeat.o(187280);
            return;
        }
        if (((double) this.intersectRatio) >= ((double) this.maxInRectRatio) - 0.05d) {
            this.maxInRectRatio = this.intersectRatio;
            if (this.needCheckShelter) {
                if (this.maxShelterScore <= f3) {
                    this.maxShelterScore = f3;
                } else {
                    YtLogger.d(TAG, "test1 shelter score " + f3 + " inRectThreshold " + this.intersectRatio + " eye " + calcEyeScore + " mouth " + calcMouthScore);
                    AppMethodBeat.o(187280);
                    return;
                }
            }
            YtLogger.d(TAG, "test2 shelter score " + f3 + " inRectThreshold " + this.intersectRatio + " eye " + calcEyeScore + " mouth " + calcMouthScore);
            if (((double) calcEyeScore) >= ((double) this.maxEyeScore) - 0.05d && calcMouthScore <= Math.max(this.minMouthScore, 15.0f)) {
                YtLogger.d(TAG, "best shelter score " + f3 + " inRectThreshold " + this.intersectRatio);
                this.maxEyeScore = calcEyeScore;
                this.minMouthScore = calcMouthScore;
                this.stateData.put("best_image", yuvImage);
                this.stateData.put("best_shape", faceStatus.xys);
                this.stateData.put("best_face_status", faceStatus);
            }
            if (calcEyeScore < this.minEyeScore) {
                this.minEyeScore = calcEyeScore;
                this.stateData.put("closeeye_image", yuvImage);
                this.stateData.put("closeeye_shape", faceStatus.xys);
                this.stateData.put("closeeye_face_status", faceStatus);
            }
            if (calcMouthScore > this.maxMouthScore) {
                this.maxMouthScore = calcMouthScore;
                this.stateData.put("openmouth_image", yuvImage);
                this.stateData.put("openmouth_shape", faceStatus.xys);
                this.stateData.put("openmouth_face_status", faceStatus);
                AppMethodBeat.o(187280);
                return;
            }
        } else {
            YtLogger.d(TAG, "test3 shelter score " + f3 + " inRectThreshold " + this.intersectRatio + " (" + this.maxInRectRatio + ") eye " + calcEyeScore + " mouth " + calcMouthScore);
        }
        AppMethodBeat.o(187280);
    }

    private void initYoutuInstance() {
        AppMethodBeat.i(187281);
        YTFaceTrack.setLoggerListener(new YTFaceTrack.IYtLoggerListener() {
            /* class com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState.AnonymousClass1 */

            @Override // com.tencent.youtu.ytfacetrack.YTFaceTrack.IYtLoggerListener
            public void log(String str, String str2) {
                AppMethodBeat.i(187261);
                YtLogger.i(str, str2);
                AppMethodBeat.o(187261);
            }
        });
        Context context = YtFSM.getInstance().getContext().currentAppContext;
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (this.isLoadResourceOnline) {
            absolutePath = this.resourceDownloadPath;
            YtLogger.i(TAG, "Use online path:".concat(String.valueOf(absolutePath)));
        } else {
            YtLogger.i(TAG, "Use local path:".concat(String.valueOf(absolutePath)));
        }
        String[] strArr = {"net1_18.rpnmodel", "net1_18_bin.rpnproto", "net2_36.rpnmodel", "net2_36_bin.rpnproto"};
        if (!this.isLoadResourceOnline) {
            for (int i2 = 0; i2 < 4; i2++) {
                String str = strArr[i2];
                FileUtils.copyAsset(context.getAssets(), "FaceTrackModels/detector/".concat(String.valueOf(str)), absolutePath + FilePathGenerator.ANDROID_DIR_SEP + str);
            }
        }
        String[] strArr2 = {"align.rpdm", "align.stb", "align_bin.rpdc", "eye.rpdm", "eye_bin.rpdc"};
        if (!this.isLoadResourceOnline) {
            for (int i3 = 0; i3 < 5; i3++) {
                String str2 = strArr2[i3];
                FileUtils.copyAsset(context.getAssets(), "FaceTrackModels/ufa/".concat(String.valueOf(str2)), absolutePath + FilePathGenerator.ANDROID_DIR_SEP + str2);
            }
        }
        String[] strArr3 = {"rotBasis.bin"};
        if (!this.isLoadResourceOnline) {
            for (int i4 = 0; i4 <= 0; i4++) {
                String str3 = strArr3[i4];
                FileUtils.copyAsset(context.getAssets(), "FaceTrackModels/poseest/".concat(String.valueOf(str3)), absolutePath + FilePathGenerator.ANDROID_DIR_SEP + str3);
            }
        }
        final int GlobalInit = YTFaceTrack.GlobalInit(absolutePath + FilePathGenerator.ANDROID_DIR_SEP);
        if (GlobalInit != 0) {
            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_VERIFY_MODEL_INIT_FAIL, "模式初始化失败");
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState.AnonymousClass2 */

                {
                    AppMethodBeat.i(187262);
                    put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                    put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_FACETRACE_INIT_FAILED));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_FACETRACE_INIT_FAILED, StringCode.MSG_PARAM_ERROR, "Init YTFaceTrack SDK failed with " + GlobalInit));
                    AppMethodBeat.o(187262);
                }
            });
            AppMethodBeat.o(187281);
            return;
        }
        YTFaceAlignParam GetFaceAlignParam = YTFaceTrack.getInstance().GetFaceAlignParam();
        GetFaceAlignParam.net_fix_config = FIX_EYE_MOUTH;
        GetFaceAlignParam.refine_config = REFINE_CONFIG_OFF;
        YTFaceTrack.getInstance().SetFaceAlignParam(GetFaceAlignParam);
        YTFaceDetectParam GetFaceDetectParam = YTFaceTrack.getInstance().GetFaceDetectParam();
        YtLogger.i(TAG, "big face mode" + this.needBigFaceMode);
        GetFaceDetectParam.bigger_face_mode = this.needBigFaceMode;
        GetFaceDetectParam.min_face_size = Math.max(Math.min(this.previewWidth, this.previewHeight) / 5, 40);
        YTFaceTrack.getInstance().SetFaceDetectParam(GetFaceDetectParam);
        YTFaceTrackParam GetFaceTrackParam = YTFaceTrack.getInstance().GetFaceTrackParam();
        GetFaceTrackParam.need_pose_estimate = true;
        GetFaceTrackParam.detect_interval = this.detectIntervalCount;
        YTFaceTrack.getInstance().SetFaceTrackParam(GetFaceTrackParam);
        YtLogger.i(TAG, "Detect version:" + YTFaceTrack.Version);
        AppMethodBeat.o(187281);
    }

    private Rect getFaceRect(YTFaceTrack.FaceStatus faceStatus) {
        float f2;
        int i2 = 0;
        float f3 = 0.0f;
        AppMethodBeat.i(187282);
        float f4 = faceStatus.xys[0];
        float f5 = faceStatus.xys[0];
        float f6 = faceStatus.xys[1];
        float f7 = faceStatus.xys[1];
        while (i2 < 180) {
            f4 = Math.min(f4, faceStatus.xys[i2]);
            f5 = Math.max(f5, faceStatus.xys[i2]);
            int i3 = i2 + 1;
            f6 = Math.min(f6, faceStatus.xys[i3]);
            f7 = Math.max(f7, faceStatus.xys[i3]);
            i2 = i3 + 1;
        }
        float f8 = ((float) (this.previewWidth - 1)) - f4;
        float f9 = ((float) (this.previewWidth - 1)) - f5;
        float f10 = (float) (((double) f9) - ((((double) (f8 - f9)) * 0.1d) / 2.0d));
        float f11 = (float) (((double) f8) + ((((double) (f8 - f10)) * 0.1d) / 2.0d));
        float f12 = (float) (((double) f6) - ((((double) (f7 - f6)) * 0.1d) / 2.0d));
        float f13 = (float) (((double) f7) + ((((double) (f7 - f12)) * 0.1d) / 2.0d));
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f10 > ((float) (this.previewWidth - 1))) {
            f10 = (float) (this.previewWidth - 1);
        }
        float f14 = f11 > ((float) (this.previewWidth + -1)) ? (float) (this.previewWidth - 1) : f11;
        if (f12 < 0.0f) {
            f2 = 0.0f;
        } else {
            f2 = f12;
        }
        if (f13 >= 0.0f) {
            f3 = f13;
        }
        if (f2 > ((float) (this.previewHeight - 1))) {
            f2 = (float) (this.previewHeight - 1);
        }
        if (f3 > ((float) (this.previewHeight - 1))) {
            f3 = (float) (this.previewHeight - 1);
        }
        Rect rect = new Rect();
        rect.left = (int) f10;
        rect.top = (int) f2;
        rect.right = (int) f14;
        rect.bottom = (int) f3;
        AppMethodBeat.o(187282);
        return rect;
    }

    private FacePreviewingAdvise getPoseJudge(YTFaceTrack.FaceStatus[] faceStatusArr) {
        AppMethodBeat.i(187283);
        YTFaceTrack.FaceStatus faceStatus = faceStatusArr[0];
        Rect faceRect = getFaceRect(faceStatus);
        if (this.previousFaceRect == null) {
            this.previousFaceRect = faceRect;
            this.stableFaceCount = 0;
        } else {
            Rect intersectionRect = getIntersectionRect(faceRect, this.previousFaceRect);
            if (!(faceRect.height() == 0 || faceRect.width() == 0)) {
                float abs = Math.abs(((((float) intersectionRect.height()) * ((float) intersectionRect.width())) / ((float) faceRect.height())) / ((float) faceRect.width()));
                YtLogger.d(TAG, "pose ratio ".concat(String.valueOf(abs)));
                if (abs < this.stableRoiThreshold) {
                    this.extraTips = StringCode.FL_ACT_SCREEN_SHAKING;
                    this.stableFaceCount = 0;
                } else {
                    this.extraTips = "";
                    this.stableFaceCount++;
                }
            }
            this.previousFaceRect = faceRect;
        }
        YtLogger.d(TAG, "rect is: " + faceRect.left + ", " + faceRect.top + ", " + faceRect.right + ", " + faceRect.bottom);
        FacePreviewingAdvise facePreviewAdvise = getFacePreviewAdvise(YtSDKKitFramework.getInstance().getDetectRect(), faceRect, faceStatus);
        AppMethodBeat.o(187283);
        return facePreviewAdvise;
    }

    private int getShelterJudge(YTFaceTrack.FaceStatus[] faceStatusArr) {
        AppMethodBeat.i(187284);
        int shelterJudge = YTFaceUtils.shelterJudge(faceStatusArr[0].pointsVis);
        if (this.currentShelterJudge != shelterJudge) {
            this.continueShelterJudgeCount = 0;
            this.currentShelterJudge = shelterJudge;
        } else {
            this.continueShelterJudgeCount++;
        }
        if (this.frameNum < 7 || this.continueShelterJudgeCount >= 7) {
            this.previousShelterJudge = this.currentShelterJudge;
        } else {
            shelterJudge = this.previousShelterJudge;
        }
        AppMethodBeat.o(187284);
        return shelterJudge;
    }

    public static String convertAdvise(FacePreviewingAdvise facePreviewingAdvise) {
        if (facePreviewingAdvise == FacePreviewingAdvise.ADVISE_PASS || facePreviewingAdvise == FacePreviewingAdvise.ADVISE_INBUFFER_PASS) {
            return StringCode.FL_POSE_KEEP;
        }
        if (facePreviewingAdvise == FacePreviewingAdvise.ADVISE_NOT_IN_RECT) {
            return StringCode.FL_POSE_NOT_IN_RECT;
        }
        if (facePreviewingAdvise == FacePreviewingAdvise.ADVISE_TOO_FAR) {
            return StringCode.FL_POSE_CLOSER;
        }
        if (facePreviewingAdvise == FacePreviewingAdvise.ADVISE_TOO_CLOSE) {
            return StringCode.FL_POSE_FARER;
        }
        if (facePreviewingAdvise == FacePreviewingAdvise.ADVISE_INCORRECT_POSTURE) {
            return StringCode.FL_POSE_INCORRECT;
        }
        if (facePreviewingAdvise == FacePreviewingAdvise.ADVISE_NO_FACE) {
            return StringCode.FL_NO_FACE;
        }
        if (facePreviewingAdvise == FacePreviewingAdvise.ADVISE_EYE_CLOSE) {
            return StringCode.FL_POSE_OPEN_EYE;
        }
        if (facePreviewingAdvise == FacePreviewingAdvise.ADVISE_INCOMPLETE_FACE) {
            return StringCode.FL_INCOMPLETE_FACE;
        }
        return StringCode.FL_ACT_SILENCE;
    }

    private void sendFaceStatusUITips(FacePreviewingAdvise facePreviewingAdvise, int i2) {
        AppMethodBeat.i(187285);
        HashMap<String, Object> hashMap = new HashMap<>();
        if ((facePreviewingAdvise == FacePreviewingAdvise.ADVISE_PASS || facePreviewingAdvise == FacePreviewingAdvise.ADVISE_INBUFFER_PASS) && i2 == 0) {
            this.detectAvailableCount++;
        } else {
            hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.STAGE_NOTPASS);
            this.detectAvailableCount = 0;
        }
        if (facePreviewingAdvise == this.prevAdvise && i2 == this.prevJudge) {
            this.sameFaceTipCount++;
        } else {
            this.sameFaceTipCount = 0;
        }
        if (!this.tipFilterFlag || this.sameFaceTipCount <= 3 || this.currentAdviseTip != facePreviewingAdvise) {
            this.prevAdvise = facePreviewingAdvise;
            this.prevJudge = i2;
            YtLogger.d(TAG, " tips:" + convertAdvise(this.currentAdviseTip));
            if (this.currentAdviseTip != FacePreviewingAdvise.ADVISE_PASS && this.currentAdviseTip != FacePreviewingAdvise.ADVISE_INBUFFER_PASS) {
                hashMap.put(StateEvent.Name.UI_TIPS, convertAdvise(this.currentAdviseTip));
            } else if (i2 == 1) {
                hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_LEFT_FACE);
            } else if (i2 == 2) {
                hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_CHIN);
            } else if (i2 == 3) {
                hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_MOUTH);
            } else if (i2 == 4) {
                hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_RIGHT_FACE);
            } else if (i2 == 5) {
                hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_NOSE);
            } else if (i2 == 6) {
                hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_RIGHT_EYE);
            } else if (i2 == 7) {
                hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_LEFT_EYE);
            } else if (i2 == 0 && this.sameFaceTipCount > 2 && this.sameFaceTipCount < 5) {
                hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_POSE_KEEP);
                hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.STAGE_PASS);
            }
            if (this.extraTips != "") {
                hashMap.put(StateEvent.Name.UI_EXTRA_TIPS, this.extraTips);
            }
            sendFSMEvent(hashMap);
            AppMethodBeat.o(187285);
            return;
        }
        AppMethodBeat.o(187285);
    }

    private void sendUITipEvent(YTFaceTrack.FaceStatus[] faceStatusArr) {
        AppMethodBeat.i(187286);
        Boolean bool = Boolean.FALSE;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (faceStatusArr == null) {
            hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_FACE);
            hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.STAGE_NOTPASS);
            this.detectAvailableCount = 0;
            FacePreviewingAdvise facePreviewingAdvise = FacePreviewingAdvise.ADVISE_NO_FACE;
            this.prevAdvise = facePreviewingAdvise;
            this.currentAdviseTip = facePreviewingAdvise;
        } else if (faceStatusArr.length > 1) {
            hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_TOO_MANY_FACES);
            hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.STAGE_NOTPASS);
            hashMap.put("ui_error", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED);
            if (this.needCheckMultiFaces) {
                this.detectAvailableCount = 0;
                this.prevAdvise = FacePreviewingAdvise.ADVISE_TOO_MANY_FACE;
            }
            this.currentAdviseTip = FacePreviewingAdvise.ADVISE_TOO_MANY_FACE;
        } else {
            FacePreviewingAdvise poseJudge = getPoseJudge(faceStatusArr);
            YtLogger.i(TAG, "advise ".concat(String.valueOf(poseJudge)));
            sendFaceStatusUITips(poseJudge, getShelterJudge(faceStatusArr));
        }
        if (hashMap.size() > 0) {
            sendFSMEvent(hashMap);
        }
        AppMethodBeat.o(187286);
    }

    /* access modifiers changed from: package-private */
    public Rect getIntersectionRect(Rect rect, Rect rect2) {
        AppMethodBeat.i(187287);
        Rect rect3 = new Rect(Math.max(rect.left, rect2.left), Math.max(rect.top, rect2.top), Math.min(rect.right, rect2.right), Math.min(rect.bottom, rect2.bottom));
        AppMethodBeat.o(187287);
        return rect3;
    }

    private FacePreviewingAdvise getFacePreviewAdvise(Rect rect, Rect rect2, YTFaceTrack.FaceStatus faceStatus) {
        FacePreviewingAdvise facePreviewingAdvise;
        Object stateDataBy;
        int intValue;
        boolean z = false;
        AppMethodBeat.i(187288);
        if (faceStatus == null) {
            facePreviewingAdvise = FacePreviewingAdvise.ADVISE_NO_FACE;
        } else {
            Rect rect3 = new Rect(0, 0, 0, 0);
            YtLogger.d(TAG, "camera" + this.previewWidth + "x" + this.previewHeight + " ratio " + this.maskWidthRatio + "x" + this.maskHeightRatio);
            YtLogger.d(TAG, "detectrect :" + rect.left + " " + rect.top + " " + rect.right + " " + rect.bottom);
            rect3.left = (int) (((float) rect2.left) * this.maskWidthRatio);
            rect3.right = (int) (((float) rect2.right) * this.maskWidthRatio);
            rect3.top = (int) (((float) rect2.top) * this.maskHeightRatio);
            rect3.bottom = (int) (((float) rect2.bottom) * this.maskHeightRatio);
            this.invalidPointCount = 0;
            for (int i2 = 0; i2 < faceStatus.xys.length / 2; i2++) {
                if (faceStatus.xys[i2 * 2] > ((float) this.previewWidth) || faceStatus.xys[i2 * 2] < 0.0f || faceStatus.xys[(i2 * 2) + 1] < 0.0f || faceStatus.xys[(i2 * 2) + 1] > ((float) this.previewHeight)) {
                    this.invalidPointCount++;
                }
            }
            Rect intersectionRect = getIntersectionRect(rect, rect3);
            this.intersectRatio = Math.abs(((((float) intersectionRect.height()) * ((float) intersectionRect.width())) / ((float) rect3.width())) / ((float) rect3.height()));
            YtLogger.d(TAG, "faceInMask : " + rect3.left + " " + rect3.top + " " + rect3.right + " " + rect3.bottom + " in rect ratio" + this.intersectRatio);
            float abs = Math.abs(((float) (rect2.right - rect2.left)) / (((float) this.previewWidth) * 1.0f));
            YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
            boolean z2 = stateByName == null || (stateDataBy = stateByName.getStateDataBy("current_action_type")) == null || !((intValue = ((Integer) stateDataBy).intValue()) == 3 || intValue == 4);
            YtLogger.d(TAG, "face area ratio:".concat(String.valueOf(abs)));
            if (this.invalidPointCount >= 3) {
                YtLogger.w(TAG, "face incomplete invalid point count:" + this.invalidPointCount);
                facePreviewingAdvise = FacePreviewingAdvise.ADVISE_INCOMPLETE_FACE;
            } else if (abs > this.bigfaceThreshold) {
                YtLogger.w(TAG, "face too big:".concat(String.valueOf(abs)));
                facePreviewingAdvise = FacePreviewingAdvise.ADVISE_TOO_CLOSE;
                if (abs <= this.bigfaceThreshold + this.bigFaceThresholdBuffer) {
                    z = true;
                }
            } else if (this.intersectRatio < this.inRectThreshold) {
                YtLogger.w(TAG, "face not in rect ratio:" + this.intersectRatio);
                facePreviewingAdvise = FacePreviewingAdvise.ADVISE_NOT_IN_RECT;
            } else if (abs < this.smallfaceThreshold) {
                YtLogger.w(TAG, "face too small:".concat(String.valueOf(abs)));
                facePreviewingAdvise = FacePreviewingAdvise.ADVISE_TOO_FAR;
                if (abs >= this.smallfaceThreshold - this.smallFaceThresholdBuffer) {
                    z = true;
                }
            } else if (z2 && (Math.abs(faceStatus.pitch) > ((float) this.pitchThreshold) || Math.abs(faceStatus.yaw) > ((float) this.yawThreshold) || Math.abs(faceStatus.roll) > ((float) this.rollThreshold))) {
                YtLogger.w(TAG, "face pose not right (" + faceStatus.pitch + "," + faceStatus.yaw + "," + faceStatus.roll + ")");
                facePreviewingAdvise = FacePreviewingAdvise.ADVISE_INCORRECT_POSTURE;
                if (Math.abs(faceStatus.pitch) <= ((float) this.pitchThreshold) + this.poseThresholdBuffer && Math.abs(faceStatus.yaw) <= ((float) this.yawThreshold) + this.poseThresholdBuffer && Math.abs(faceStatus.roll) <= ((float) this.rollThreshold) + this.poseThresholdBuffer) {
                    z = true;
                }
            } else if (!this.needCheckEyeOpen || isActionStage()) {
                facePreviewingAdvise = FacePreviewingAdvise.ADVISE_PASS;
            } else {
                float preCheckCloseEyeScore = YtSDKKitCommon.ProcessHelper.preCheckCloseEyeScore(faceStatus.xys);
                YtLogger.d(TAG, "eye score:" + preCheckCloseEyeScore + " cnt:" + this.continueCloseEyeCount);
                if (preCheckCloseEyeScore < this.eyeOpenThreshold) {
                    this.continueCloseEyeCount++;
                    this.detectAvailableCount--;
                    if (this.detectAvailableCount < 0) {
                        this.detectAvailableCount = 0;
                    }
                } else {
                    this.continueCloseEyeCount = 0;
                }
                if (this.continueCloseEyeCount >= (YtFSM.getInstance().getWorkMode() != YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE ? 10 : 4)) {
                    facePreviewingAdvise = FacePreviewingAdvise.ADVISE_EYE_CLOSE;
                    this.continueCloseEyeCount = 0;
                } else {
                    facePreviewingAdvise = FacePreviewingAdvise.ADVISE_PASS;
                }
            }
        }
        this.currentAdviseTip = facePreviewingAdvise;
        if (z) {
            facePreviewingAdvise = FacePreviewingAdvise.ADVISE_INBUFFER_PASS;
        }
        AppMethodBeat.o(187288);
        return facePreviewingAdvise;
    }

    private boolean isActionStage() {
        AppMethodBeat.i(187289);
        if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE || YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
            AppMethodBeat.o(187289);
            return true;
        }
        AppMethodBeat.o(187289);
        return false;
    }

    private void sendFSMEvent(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(187290);
        YtFSM.getInstance().sendFSMEvent(hashMap);
        AppMethodBeat.o(187290);
    }
}

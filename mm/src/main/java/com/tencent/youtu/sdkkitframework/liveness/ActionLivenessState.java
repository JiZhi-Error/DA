package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.YuvImage;
import android.os.Environment;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.common.YtVideoEncoder;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ActionLivenessState extends YtFSMBaseState {
    private static final String TAG = ActionLivenessState.class.getSimpleName();
    private YTActRefData actReflectData;
    int actReflectUXMode = 0;
    private int actionContinuousFailedCount = 0;
    private int actionCurrentIndex;
    private String[] actionDataParsed;
    private YTPoseDetectInterface.PoseDetectOnFrame actionFrameHandler;
    private int actionLiveType = 1;
    private ArrayList<BestFrame> bestFrames;
    private int codecSettingBitRate = TPMediaCodecProfileLevel.HEVCHighTierLevel6;
    private int codecSettingFrameRate = 30;
    private int codecSettingiFrameInterval = 1;
    private int continuousDetectCount = 0;
    private String controlConfig = "";
    private int currentRotateState;
    private String extraTips = "";
    private YTFaceTrack.FaceStatus[] faceStatus;
    private String innerMp4Path = (Environment.getExternalStorageDirectory().getPath() + "/temp.mp4");
    private boolean isActionFinished = false;
    private boolean isLoadResourceOnline = false;
    private String legitimatePoseVersion = "3.5.4";
    private YTFaceTrackParam mOriginParam;
    private boolean needCheckMultiFaces = false;
    private boolean needLocalConfig = false;
    private boolean needManualTrigger = false;
    private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
    private int poseReadyCount = 0;
    private SilentLivenessState.FacePreviewingAdvise poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    private int securityLevel = 1;
    private int stableCountNum = 5;
    private YtVideoEncoder videoEncoder;

    public ActionLivenessState() {
        AppMethodBeat.i(187133);
        AppMethodBeat.o(187133);
    }

    static /* synthetic */ String access$2300(ActionLivenessState actionLivenessState, int i2) {
        AppMethodBeat.i(187149);
        String tipsByPoseType = actionLivenessState.getTipsByPoseType(i2);
        AppMethodBeat.o(187149);
        return tipsByPoseType;
    }

    static /* synthetic */ boolean access$500(ActionLivenessState actionLivenessState, String[] strArr, int i2) {
        AppMethodBeat.i(187148);
        boolean changeToNextAction = actionLivenessState.changeToNextAction(strArr, i2);
        AppMethodBeat.o(187148);
        return changeToNextAction;
    }

    static /* synthetic */ int access$808(ActionLivenessState actionLivenessState) {
        int i2 = actionLivenessState.actionContinuousFailedCount;
        actionLivenessState.actionContinuousFailedCount = i2 + 1;
        return i2;
    }

    static {
        AppMethodBeat.i(187150);
        AppMethodBeat.o(187150);
    }

    class BestFrameEyeRating implements Comparator<BestFrame> {
        BestFrameEyeRating() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(BestFrame bestFrame, BestFrame bestFrame2) {
            AppMethodBeat.i(187132);
            int compare = compare(bestFrame, bestFrame2);
            AppMethodBeat.o(187132);
            return compare;
        }

        public int compare(BestFrame bestFrame, BestFrame bestFrame2) {
            float f2 = bestFrame2.eyeScore - bestFrame.eyeScore;
            if (f2 > 0.0f) {
                return 1;
            }
            if (f2 < 0.0f) {
                return -1;
            }
            return 0;
        }
    }

    public class BestFrame {
        public float eyeScore;
        public float[] f5p;
        public YuvImage frame;
        public float pitch;
        public float roll;
        public float yaw;

        public BestFrame() {
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void loadStateWith(String str, JSONObject jSONObject) {
        AppMethodBeat.i(187134);
        super.loadStateWith(str, jSONObject);
        YtFSM.getInstance().getContext().currentAppContext.getFilesDir().getAbsolutePath();
        try {
            if (jSONObject.has("resource_online")) {
                this.isLoadResourceOnline = jSONObject.getBoolean("resource_online");
            }
            if (jSONObject.has("video_path")) {
                this.innerMp4Path = jSONObject.getString("video_path");
            }
            if (jSONObject.has("local_config_flag")) {
                this.needLocalConfig = jSONObject.getBoolean("local_config_flag");
            }
            if (jSONObject.has("video_bitrate")) {
                this.codecSettingBitRate = jSONObject.getInt("video_bitrate");
            }
            if (jSONObject.has("video_framerate")) {
                this.codecSettingFrameRate = jSONObject.getInt("video_framerate");
            }
            if (jSONObject.has("video_iframeinterval")) {
                this.codecSettingiFrameInterval = jSONObject.getInt("video_iframeinterval");
            }
            if (jSONObject.has("manual_trigger")) {
                this.needManualTrigger = jSONObject.getBoolean("manual_trigger");
            }
            if (jSONObject.has("stable_frame_num")) {
                this.stableCountNum = jSONObject.getInt("stable_frame_num");
            }
            if (jSONObject.has("control_config")) {
                this.controlConfig = jSONObject.getString("control_config");
            }
            this.needCheckMultiFaces = jSONObject.optBoolean("need_check_multiface", false);
        } catch (JSONException e2) {
            YtLogger.e(TAG, "action load failed1:" + e2.getLocalizedMessage());
        }
        if (!this.isLoadResourceOnline) {
            FileUtils.loadLibrary("YTPoseDetect");
        }
        final String version = YTPoseDetectJNIInterface.getVersion();
        YtLogger.i(TAG, "YTPose Version: ".concat(String.valueOf(version)));
        String[] split = version.split("\\.");
        String str2 = this.legitimatePoseVersion;
        YtLogger.i(TAG, "Wanted YTPose Version: ".concat(String.valueOf(str2)));
        String[] split2 = str2.split("\\.");
        if (Integer.parseInt(split[0]) != Integer.parseInt(split2[0])) {
            sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.AnonymousClass1 */

                {
                    AppMethodBeat.i(187117);
                    put(StateEvent.Name.WARNING_TIPS, "动作库版本异常！目标版本：" + ActionLivenessState.this.legitimatePoseVersion + " 当前版本：" + version);
                    AppMethodBeat.o(187117);
                }
            });
        } else if (Integer.parseInt(split[1]) != Integer.parseInt(split2[1])) {
            sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.AnonymousClass2 */

                {
                    AppMethodBeat.i(187118);
                    put(StateEvent.Name.WARNING_TIPS, "动作库版本异常！目标版本：" + ActionLivenessState.this.legitimatePoseVersion + " 当前版本：" + version);
                    AppMethodBeat.o(187118);
                }
            });
        } else if (Integer.parseInt(split[2]) < Integer.parseInt(split2[2])) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.AnonymousClass3 */

                {
                    AppMethodBeat.i(187119);
                    put(StateEvent.Name.WARNING_TIPS, "动作库版本过低！目标版本：" + ActionLivenessState.this.legitimatePoseVersion + " 当前版本：" + version);
                    AppMethodBeat.o(187119);
                }
            });
        }
        final int initModel = YTPoseDetectInterface.initModel();
        if (initModel != 0) {
            YtLogger.e(TAG, "action load failed2: ".concat(String.valueOf(initModel)));
            YtSDKStats.getInstance().reportError(initModel, "failed to init pose sdk");
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.AnonymousClass4 */

                {
                    AppMethodBeat.i(187120);
                    put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                    put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_POSEDETECT_INIT_FAILED));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_POSEDETECT_INIT_FAILED, StringCode.MSG_PARAM_ERROR, "Init YtPose SDK failed with " + initModel));
                    AppMethodBeat.o(187120);
                }
            });
            AppMethodBeat.o(187134);
            return;
        }
        this.continuousDetectCount = 0;
        this.stateData.put(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, Integer.valueOf(this.actionLiveType));
        try {
            if (jSONObject.has("action_security_level")) {
                this.securityLevel = jSONObject.getInt("action_security_level");
            }
            JSONArray jSONArray = jSONObject.getJSONArray("action_default_seq");
            if (jSONArray == null) {
                YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_PARAM_ERROR, "yt_param_error");
                AppMethodBeat.o(187134);
                return;
            }
            this.actionDataParsed = new String[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.actionDataParsed[i2] = jSONArray.getString(i2);
            }
            YtLogger.d(TAG, "load action sequence from sdkconfig " + jSONObject.getString("action_default_seq") + " size :" + this.actionDataParsed.length);
            try {
                if (jSONObject.has("action_inner_settings")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("action_inner_settings");
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        YTPoseDetectJNIInterface.updateParam(next, jSONObject2.getString(next));
                    }
                }
            } catch (JSONException e3) {
                YtLogger.d(TAG, "action load failed4: " + e3.getLocalizedMessage());
            }
            YTPoseDetectJNIInterface.configNativeLog(true);
            YTPoseDetectJNIInterface.updateParam("log_level", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            YTPoseDetectJNIInterface.setLoggerListener(new YTPoseDetectJNIInterface.IYtLoggerListener() {
                /* class com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.AnonymousClass5 */

                @Override // com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface.IYtLoggerListener
                public void log(String str, String str2) {
                    AppMethodBeat.i(187121);
                    YtLogger.d(str, str2);
                    AppMethodBeat.o(187121);
                }
            });
            this.currentRotateState = YtFSM.getInstance().getContext().currentRotateState;
            this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
            this.videoEncoder = new YtVideoEncoder(null, true);
            this.mOriginParam = YTFaceTrack.getInstance().GetFaceTrackParam();
            YTPoseDetectJNIInterface.setSafetyLevel(this.securityLevel);
            this.bestFrames = new ArrayList<>();
            reset();
            AppMethodBeat.o(187134);
        } catch (JSONException e4) {
            YtLogger.e(TAG, "action load failed3: " + e4.getLocalizedMessage());
            this.actionDataParsed = AppEventsConstants.EVENT_PARAM_VALUE_NO.split(" ");
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void unload() {
        AppMethodBeat.i(187135);
        super.unload();
        if (YTPoseDetectInterface.isDetecting()) {
            YTPoseDetectInterface.stop();
        }
        YTPoseDetectInterface.releaseModel();
        if (this.videoEncoder != null) {
            this.videoEncoder.abortEncoding();
            this.videoEncoder = null;
        }
        AppMethodBeat.o(187135);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
        AppMethodBeat.i(187136);
        YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
        YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
        if (stateByName != null) {
            try {
                Object stateDataBy = stateByName.getStateDataBy("video_bitrate");
                if (stateDataBy != null) {
                    this.codecSettingBitRate = ((Integer) stateDataBy).intValue();
                }
                Object stateDataBy2 = stateByName.getStateDataBy("video_framerate");
                if (stateDataBy2 != null) {
                    this.codecSettingFrameRate = ((Integer) stateDataBy2).intValue();
                }
                Object stateDataBy3 = stateByName.getStateDataBy("video_iframeinterval");
                if (stateDataBy3 != null) {
                    this.codecSettingiFrameInterval = ((Integer) stateDataBy3).intValue();
                }
                String str = (String) stateByName.getStateDataBy("control_config");
                if (str != null) {
                    this.controlConfig = str;
                }
            } catch (Exception e2) {
                YtLogger.e(TAG, "action enter first failed:" + e2.getLocalizedMessage());
            }
        }
        if (!this.controlConfig.isEmpty()) {
            String[] split = this.controlConfig.split("&");
            if (split.length > 0) {
                for (String str2 : split) {
                    String[] split2 = str2.split("=");
                    if (split2.length > 1 && split2[0].equals("actref_ux_mode")) {
                        this.actReflectUXMode = Integer.parseInt(split2[1]);
                    }
                }
            }
        }
        YTFaceTrackParam yTFaceTrackParam = this.mOriginParam;
        yTFaceTrackParam.detect_interval = 30;
        YTFaceTrack.getInstance().SetFaceTrackParam(yTFaceTrackParam);
        AppMethodBeat.o(187136);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        AppMethodBeat.i(187137);
        super.enter();
        try {
            YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
            this.continuousDetectCount = ((Integer) stateByName.getStateDataBy("continuous_detect_count")).intValue();
            this.faceStatus = (YTFaceTrack.FaceStatus[]) stateByName.getStateDataBy("face_status");
            this.poseState = (SilentLivenessState.FacePreviewingAdvise) stateByName.getStateDataBy("pose_state");
            YtFSMBaseState stateByName2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
            if (stateByName2 != null && !this.needLocalConfig) {
                String str = (String) stateByName2.getStateDataBy("action_data");
                YtLogger.d(TAG, "action data :".concat(String.valueOf(str)));
                this.actionDataParsed = str.split(",");
                if (this.actionDataParsed.length > this.actionCurrentIndex) {
                    int parseInt = Integer.parseInt(this.actionDataParsed[this.actionCurrentIndex]);
                    switch (parseInt) {
                        case 0:
                        case 1:
                            this.actionLiveType = 1;
                            break;
                        case 2:
                            this.actionLiveType = 2;
                            break;
                        case 3:
                            this.actionLiveType = 3;
                            break;
                        case 4:
                            this.actionLiveType = 4;
                            break;
                        case 5:
                            this.actionLiveType = 5;
                            break;
                    }
                    this.stateData.put("current_action_type", Integer.valueOf(parseInt));
                }
            }
            if (this.actReflectUXMode == 1) {
                this.actionLiveType = 5;
                this.actionDataParsed = new String[]{"5"};
            }
            this.stateData.put("action_seq", this.actionDataParsed);
            AppMethodBeat.o(187137);
        } catch (Exception e2) {
            YtLogger.e(TAG, "action enter failed " + e2.getLocalizedMessage());
            CommonUtils.reportException("action enter failed ", e2);
            AppMethodBeat.o(187137);
        }
    }

    private void clearData() {
        AppMethodBeat.i(187138);
        this.bestFrames = new ArrayList<>();
        this.actionContinuousFailedCount = 0;
        this.isActionFinished = false;
        this.actionCurrentIndex = -1;
        this.poseReadyCount = 0;
        this.poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
        changeToNextAction(this.actionDataParsed, this.actionCurrentIndex + 1);
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        this.videoEncoder.abortEncoding();
        startPose();
        AppMethodBeat.o(187138);
    }

    private void startPose() {
        AppMethodBeat.i(187139);
        this.actionFrameHandler = new YTPoseDetectInterface.PoseDetectOnFrame() {
            /* class com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.AnonymousClass6 */

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame
            public void onSuccess(int i2) {
                AppMethodBeat.i(187124);
                ActionLivenessState.this.extraTips = "";
                if (i2 == 1) {
                    YtLogger.d(ActionLivenessState.TAG, "Detect pose with sequence " + ActionLivenessState.this.actionDataParsed.length);
                    if (ActionLivenessState.access$500(ActionLivenessState.this, ActionLivenessState.this.actionDataParsed, ActionLivenessState.this.actionCurrentIndex + 1)) {
                        YtLogger.i(ActionLivenessState.TAG, "start check pose: " + ActionLivenessState.this.actionLiveType);
                    } else {
                        YtLogger.i(ActionLivenessState.TAG, "action seq all done");
                        ActionLivenessState.this.isActionFinished = true;
                    }
                } else if (i2 == -4) {
                    YtLogger.w(ActionLivenessState.TAG, "Act failed ".concat(String.valueOf(i2)));
                    ActionLivenessState.this.extraTips = StringCode.FL_ACT_LIGHT_NOT_RIGHT;
                } else if (i2 == -5) {
                    YtLogger.w(ActionLivenessState.TAG, "Act failed ".concat(String.valueOf(i2)));
                    ActionLivenessState.this.extraTips = StringCode.FL_ACT_SCREEN_SHAKING;
                } else if (!(i2 == -1 || i2 == 0)) {
                    YtLogger.w(ActionLivenessState.TAG, "Act failed ".concat(String.valueOf(i2)));
                }
                YtSDKStats.getInstance().reportInfo("pose state ".concat(String.valueOf(i2)));
                AppMethodBeat.o(187124);
            }

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame
            public void onFailed(int i2, String str, String str2) {
                AppMethodBeat.i(187125);
                YtSDKStats.getInstance().reportInfo("pose state ".concat(String.valueOf(i2)));
                YtLogger.d(ActionLivenessState.TAG, "YTPoseDetectInterface.poseDetect.onFailed: " + i2 + " s: " + str);
                ActionLivenessState.access$808(ActionLivenessState.this);
                int unused = ActionLivenessState.this.actionContinuousFailedCount;
                AppMethodBeat.o(187125);
            }

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame
            public void onCanReflect() {
                AppMethodBeat.i(187126);
                ActionLivenessState.this.actReflectData = YTPoseDetectInterface.getActReflectData();
                AppMethodBeat.o(187126);
            }

            /* JADX WARNING: Removed duplicated region for block: B:19:0x01ab  */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x01d5  */
            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onRecordingDone(byte[][] r11, int r12, int r13) {
                /*
                // Method dump skipped, instructions count: 535
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.AnonymousClass6.onRecordingDone(byte[][], int, int):void");
            }
        };
        YTPoseDetectInterface.start(YtFSM.getInstance().getContext().currentAppContext, YtFSM.getInstance().getContext().currentCamera, YtFSM.getInstance().getContext().currentCameraId, new YTPoseDetectInterface.PoseDetectResult() {
            /* class com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.AnonymousClass7 */

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult
            public void onSuccess() {
                AppMethodBeat.i(187129);
                YtLogger.d(ActionLivenessState.TAG, "start success");
                AppMethodBeat.o(187129);
            }

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult
            public void onFailed(final int i2, String str, String str2) {
                AppMethodBeat.i(187130);
                YtSDKStats.getInstance().reportError(i2, "failed to init pose sdk");
                YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                    /* class com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.AnonymousClass7.AnonymousClass1 */

                    {
                        AppMethodBeat.i(187128);
                        put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                        put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_POSEDETECT_INIT_FAILED));
                        put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_POSEDETECT_INIT_FAILED, StringCode.MSG_PARAM_ERROR, "Init YtPose SDK failed with " + i2));
                        AppMethodBeat.o(187128);
                    }
                });
                ActionLivenessState.this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE;
                AppMethodBeat.o(187130);
            }
        });
        AppMethodBeat.o(187139);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void reset() {
        AppMethodBeat.i(187140);
        clearData();
        super.reset();
        AppMethodBeat.o(187140);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
        AppMethodBeat.i(187141);
        super.handleEvent(ytFrameworkFireEventType, obj);
        if (this.needManualTrigger && ytFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS) {
            clearData();
        }
        AppMethodBeat.o(187141);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void update(byte[] bArr, int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(187142);
        super.update(bArr, i2, i3, i4, j2);
        if (this.faceStatus != null && this.faceStatus.length > 0 && this.continuousDetectCount > 0) {
            if (this.continuousDetectCount <= 1 || (this.needCheckMultiFaces && this.faceStatus.length > 1)) {
                this.poseReadyCount = this.stableCountNum;
                YTPoseDetectInterface.reset();
            }
            if (this.actionFrameHandler == null) {
                YtLogger.e(TAG, "FrameHandle is null, check init first");
                AppMethodBeat.o(187142);
                return;
            }
            if (this.poseReadyCount > this.stableCountNum + 10 && !this.isActionFinished) {
                sendFSMEvent(new HashMap<String, Object>() {
                    /* class com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.AnonymousClass8 */

                    {
                        AppMethodBeat.i(187131);
                        put(StateEvent.Name.UI_EXTRA_TIPS, ActionLivenessState.this.extraTips);
                        put(StateEvent.Name.UI_TIPS, ActionLivenessState.access$2300(ActionLivenessState.this, ActionLivenessState.this.actionLiveType));
                        put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.STAGE_PASS);
                        AppMethodBeat.o(187131);
                    }
                });
            }
            this.poseReadyCount++;
            YTPoseDetectInterface.poseDetect(this.faceStatus[0].xys, this.faceStatus[0].pointsVis, this.actionLiveType, bArr, YtFSM.getInstance().getContext().currentCamera, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll, this.actionFrameHandler, 1);
            AddOptPose(bArr, i2, i3, this.faceStatus[0].xys, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
        }
        moveToNextState();
        AppMethodBeat.o(187142);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void moveToNextState() {
        AppMethodBeat.i(187143);
        super.moveToNextState();
        if (this.nextStateName == YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE) {
            YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
            AppMethodBeat.o(187143);
            return;
        }
        YTFaceTrack.getInstance().SetFaceTrackParam(this.mOriginParam);
        YTPoseDetectInterface.stop();
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
        AppMethodBeat.o(187143);
    }

    private String getTipsByPoseType(int i2) {
        AppMethodBeat.i(187144);
        if (i2 == 1) {
            AppMethodBeat.o(187144);
            return StringCode.FL_ACT_BLINK;
        } else if (i2 == 2) {
            AppMethodBeat.o(187144);
            return StringCode.FL_ACT_OPEN_MOUTH;
        } else if (i2 == 4) {
            AppMethodBeat.o(187144);
            return StringCode.FL_ACT_SHAKE_HEAD;
        } else if (i2 == 3) {
            AppMethodBeat.o(187144);
            return StringCode.FL_ACT_NOD_HEAD;
        } else if (i2 == 5) {
            AppMethodBeat.o(187144);
            return StringCode.FL_ACT_SILENCE;
        } else {
            String concat = StringCode.FL_ACT_ERROR.concat(String.valueOf(i2));
            AppMethodBeat.o(187144);
            return concat;
        }
    }

    private boolean changeToNextAction(String[] strArr, int i2) {
        AppMethodBeat.i(187145);
        if (strArr.length == 0) {
            AppMethodBeat.o(187145);
            return false;
        }
        this.actionCurrentIndex = i2;
        if (this.actionCurrentIndex >= strArr.length) {
            AppMethodBeat.o(187145);
            return false;
        }
        int parseInt = Integer.parseInt(strArr[this.actionCurrentIndex]);
        switch (parseInt) {
            case 0:
            case 1:
                this.actionLiveType = 1;
                break;
            case 2:
                this.actionLiveType = 2;
                break;
            case 3:
                this.actionLiveType = 3;
                break;
            case 4:
                this.actionLiveType = 4;
                break;
            case 5:
                this.actionLiveType = 5;
                break;
        }
        this.stateData.put("current_action_type", Integer.valueOf(parseInt));
        YtLogger.i(TAG, "action check rounds: " + this.actionCurrentIndex + "start check pose: " + this.actionLiveType);
        YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
        this.poseReadyCount = 0;
        AppMethodBeat.o(187145);
        return true;
    }

    private void sendFSMEvent(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(187146);
        YtFSM.getInstance().sendFSMEvent(hashMap);
        AppMethodBeat.o(187146);
    }

    private void AddOptPose(byte[] bArr, int i2, int i3, float[] fArr, float f2, float f3, float f4) {
        AppMethodBeat.i(187147);
        float preCheckCloseEyeScore = YtSDKKitCommon.ProcessHelper.preCheckCloseEyeScore(fArr);
        BestFrame bestFrame = new BestFrame();
        bestFrame.eyeScore = preCheckCloseEyeScore;
        bestFrame.pitch = f2;
        bestFrame.yaw = f3;
        bestFrame.roll = f4;
        bestFrame.f5p = YtSDKKitCommon.ProcessHelper.convert90PTo5P(fArr);
        bestFrame.frame = new YuvImage(bArr, 17, i2, i3, null);
        this.bestFrames.add(bestFrame);
        if (this.bestFrames.size() > 20) {
            this.bestFrames.remove(0);
        }
        AppMethodBeat.o(187147);
    }
}

package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Environment;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import com.tencent.youtu.lipreader.jni.YTLipReader;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LipReadLivenessState extends YtFSMBaseState {
    private static final String TAG = LipReadLivenessState.class.getSimpleName();
    private String[] actionDataParsed;
    private int audioBitRate = 64000;
    private int audioSampleRate = 44100;
    private int backendProtoType = 0;
    long beginTimeMs;
    private YTFaceTrack.FaceStatus bestFaceStatus;
    private YuvImage bestFrame;
    private boolean canTransit;
    private int codecSettingBitRate = TPMediaCodecProfileLevel.HEVCHighTierLevel6;
    private int codecSettingFrameRate = 30;
    private int codecSettingiFrameInterval = 1;
    private int continuousDetectCount = 0;
    private int currentRotateState = YtFSM.getInstance().getContext().currentRotateState;
    long endTimeMs;
    private YTFaceTrack.FaceStatus[] faceStatus;
    private String innerAudioPath = (Environment.getExternalStorageDirectory().getPath() + "/tmpaudio.spx");
    private String innerMp4Path = (Environment.getExternalStorageDirectory().getPath() + "/lipreadtemp.mp4");
    private boolean isFinished;
    private boolean isLoadResourceOnline = false;
    private YuvImage lastFrame;
    private boolean needCheckMultiFaces = false;
    private boolean needCheckPose = true;
    private boolean needManualTrigger = false;
    private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
    private int numIntervalMs = 1000;
    private SilentLivenessState.FacePreviewingAdvise poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    private YtVideoEncoder videoEncoder;
    YTLipReader ytLipReader;

    public LipReadLivenessState() {
        AppMethodBeat.i(187157);
        AppMethodBeat.o(187157);
    }

    static {
        AppMethodBeat.i(187169);
        AppMethodBeat.o(187169);
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
        AppMethodBeat.i(187158);
        super.loadStateWith(str, jSONObject);
        try {
            if (jSONObject.has("force_pose_check")) {
                this.needCheckPose = jSONObject.getBoolean("force_pose_check");
            }
            if (jSONObject.has("manual_trigger")) {
                this.needManualTrigger = jSONObject.getBoolean("manual_trigger");
            }
            if (jSONObject.has("video_path")) {
                this.innerMp4Path = jSONObject.getString("video_path");
            }
            if (jSONObject.has("backend_proto_type")) {
                this.backendProtoType = jSONObject.getInt("backend_proto_type");
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
            if (jSONObject.has("audio_bitrate")) {
                this.audioBitRate = jSONObject.getInt("audio_bitrate");
            }
            if (jSONObject.has("audio_samplerate")) {
                this.audioSampleRate = jSONObject.getInt("audio_samplerate");
            }
            this.needCheckMultiFaces = jSONObject.optBoolean("need_check_multiface", false);
            JSONArray optJSONArray = jSONObject.optJSONArray("action_default_seq");
            if (optJSONArray == null) {
                YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_PARAM_ERROR, "yt_param_error");
                YtLogger.e(TAG, "Failed to load action data");
                this.actionDataParsed = AppEventsConstants.EVENT_PARAM_VALUE_NO.split(",");
            } else {
                this.actionDataParsed = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.actionDataParsed[i2] = optJSONArray.getString(i2);
                }
            }
            YtLogger.d(TAG, "load action sequence from sdkconfig " + jSONObject.getString("action_default_seq") + " size :" + this.actionDataParsed.length);
        } catch (JSONException e2) {
            YtLogger.e(TAG, "lipread load failed1:" + e2.getLocalizedMessage());
            this.actionDataParsed = AppEventsConstants.EVENT_PARAM_VALUE_NO.split(",");
        }
        this.isFinished = false;
        this.canTransit = false;
        YtFSM.getInstance().getContext().currentAppContext.getFilesDir().getAbsolutePath();
        try {
            if (jSONObject.has("resource_online")) {
                this.isLoadResourceOnline = jSONObject.getBoolean("resource_online");
            }
            if (jSONObject.has("audio_path")) {
                this.innerAudioPath = jSONObject.getString("audio_path");
            }
            if (jSONObject.has("num_interval_ms")) {
                this.numIntervalMs = jSONObject.getInt("num_interval_ms");
            }
        } catch (Exception e3) {
            YtLogger.e(TAG, "lipread load failed2:" + e3.getLocalizedMessage());
        }
        if (!this.isLoadResourceOnline) {
            FileUtils.loadLibrary("YTLipReader");
        }
        this.ytLipReader = new YTLipReader();
        this.ytLipReader.init();
        YtLogger.i(TAG, "YTLipReader Version: " + this.ytLipReader.getVersion());
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        this.stateData.put("action_seq", this.actionDataParsed);
        AppMethodBeat.o(187158);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void unload() {
        AppMethodBeat.i(187159);
        if (this.ytLipReader != null) {
            this.ytLipReader = null;
        }
        if (!(this.backendProtoType == 2 || this.videoEncoder == null)) {
            this.videoEncoder.abortEncoding();
            this.videoEncoder = null;
        }
        super.unload();
        AppMethodBeat.o(187159);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void reset() {
        AppMethodBeat.i(187160);
        clearData();
        super.reset();
        AppMethodBeat.o(187160);
    }

    private void clearData() {
        AppMethodBeat.i(187161);
        this.isFinished = false;
        this.canTransit = false;
        this.poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        if (!(this.backendProtoType == 2 || this.videoEncoder == null)) {
            this.videoEncoder.abortEncoding();
            this.videoEncoder = null;
        }
        if (this.ytLipReader != null) {
            this.ytLipReader.reset();
        }
        AppMethodBeat.o(187161);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
        int i2;
        int i3;
        AppMethodBeat.i(187162);
        this.beginTimeMs = System.currentTimeMillis();
        if (this.backendProtoType != 2) {
            Camera.Size previewSize = YtFSM.getInstance().getContext().currentCamera.getParameters().getPreviewSize();
            if (YtFSM.getInstance().getContext().currentRotateState >= 5) {
                i2 = previewSize.height;
                i3 = previewSize.width;
            } else {
                i2 = previewSize.width;
                i3 = previewSize.height;
            }
            this.videoEncoder = new YtVideoEncoder(null, true);
            this.videoEncoder.startAudioVideoEncoding(i2, i3, new File(this.innerMp4Path), this.codecSettingBitRate, this.codecSettingFrameRate, this.codecSettingiFrameInterval, this.audioSampleRate, this.audioBitRate);
        }
        AppMethodBeat.o(187162);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        AppMethodBeat.i(187163);
        super.enter();
        try {
            YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
            this.poseState = (SilentLivenessState.FacePreviewingAdvise) stateByName.getStateDataBy("pose_state");
            this.continuousDetectCount = ((Integer) stateByName.getStateDataBy("continuous_detect_count")).intValue();
            this.faceStatus = (YTFaceTrack.FaceStatus[]) stateByName.getStateDataBy("face_status");
            this.bestFaceStatus = (YTFaceTrack.FaceStatus) stateByName.getStateDataBy("best_face_status");
            this.bestFrame = (YuvImage) stateByName.getStateDataBy("best_image");
            this.lastFrame = (YuvImage) stateByName.getStateDataBy("last_frame");
            YtFSMBaseState stateByName2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
            if (stateByName2 != null) {
                String str = (String) stateByName2.getStateDataBy("action_data");
                YtLogger.d(TAG, "action data :".concat(String.valueOf(str)));
                this.actionDataParsed = str.split(",");
                this.stateData.put("action_seq", this.actionDataParsed);
            }
            AppMethodBeat.o(187163);
        } catch (Exception e2) {
            YtLogger.e(TAG, "lipread enter failed " + e2.getLocalizedMessage());
            CommonUtils.reportException("lipread enter failed ", e2);
            AppMethodBeat.o(187163);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void update(byte[] bArr, int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(187164);
        super.update(bArr, i2, i3, i4, j2);
        if (this.backendProtoType != 2) {
            this.videoEncoder.queueFrame(this.lastFrame);
            this.videoEncoder.encode();
        }
        if (!this.isFinished) {
            if ((!this.needCheckPose || this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS || this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_INBUFFER_PASS) && ((!this.needCheckMultiFaces || this.poseState != SilentLivenessState.FacePreviewingAdvise.ADVISE_TOO_MANY_FACE) && this.poseState != SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE)) {
                this.ytLipReader.feed(this.faceStatus[0].xys, bArr, i2, i3, this.currentRotateState, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
            } else {
                this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE;
                YtLogger.d(TAG, "lipread cancel with pose type " + this.poseState);
                sendCancelFailEvent();
            }
            moveToNextState();
            AppMethodBeat.o(187164);
            return;
        }
        if (this.canTransit) {
            YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
        }
        AppMethodBeat.o(187164);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void updateSDKSetting(JSONObject jSONObject) {
        AppMethodBeat.i(187165);
        try {
            this.needCheckPose = jSONObject.optBoolean("force_pose_check", this.needCheckPose);
            this.needCheckMultiFaces = jSONObject.optBoolean("need_check_multiface", this.needCheckMultiFaces);
            AppMethodBeat.o(187165);
        } catch (Exception e2) {
            YtLogger.e(TAG, e2.getLocalizedMessage());
            AppMethodBeat.o(187165);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void moveToNextState() {
        AppMethodBeat.i(187166);
        super.moveToNextState();
        this.endTimeMs = System.currentTimeMillis();
        if (this.endTimeMs - this.beginTimeMs > ((long) (this.actionDataParsed.length * this.numIntervalMs))) {
            this.isFinished = true;
            byte[] bArr = null;
            if (this.backendProtoType == 2) {
                if (YtFSM.getInstance().getContext().baseFunctionListener != null) {
                    bArr = YtFSM.getInstance().getContext().baseFunctionListener.getVoiceData();
                } else {
                    YtLogger.w(TAG, "Base function listener for getting voice data not found");
                }
                if (bArr == null) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(new File(this.innerAudioPath));
                        if (fileInputStream.available() != 0) {
                            bArr = new byte[fileInputStream.available()];
                        }
                        fileInputStream.read(bArr);
                        fileInputStream.close();
                    } catch (IOException e2) {
                        YtLogger.e(TAG, "fetch audio data failed:" + e2.getLocalizedMessage());
                    }
                }
            } else {
                this.videoEncoder.stopEncoding();
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(new File(this.innerMp4Path));
                    if (fileInputStream2.available() != 0) {
                        bArr = new byte[fileInputStream2.available()];
                    }
                    fileInputStream2.read(bArr);
                    fileInputStream2.close();
                } catch (IOException e3) {
                    YtLogger.e(TAG, "Failed fetch action video " + e3.getLocalizedMessage());
                }
            }
            if (bArr == null) {
                YtLogger.e(TAG, "fetch audio data failed");
            }
            this.stateData.put("audio_data", bArr);
            String feature = this.ytLipReader.feature();
            if (feature == null) {
                YtLogger.e(TAG, "feature is null");
            }
            this.stateData.put("feature", feature);
            String lipReadingFeature = this.ytLipReader.lipReadingFeature();
            if (lipReadingFeature == null) {
                YtLogger.e(TAG, "lipread feature is null");
            }
            this.stateData.put("lipreading_feature", lipReadingFeature);
            this.stateData.put("last_frame", this.bestFrame);
            this.stateData.put("face_extra_list", this.ytLipReader.getImageListJsonStr());
            if (this.bestFaceStatus == null) {
                YtLogger.e(TAG, "last frame landmark is null");
            } else {
                this.stateData.put("last_frame_landmark", this.bestFaceStatus.xys5p);
            }
            this.canTransit = true;
            AppMethodBeat.o(187166);
            return;
        }
        YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
        AppMethodBeat.o(187166);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
        AppMethodBeat.i(187167);
        super.handleEvent(ytFrameworkFireEventType, obj);
        if (this.needManualTrigger && ytFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS) {
            clearData();
        }
        AppMethodBeat.o(187167);
    }

    private void sendCancelFailEvent() {
        AppMethodBeat.i(187168);
        String convertAdvise = SilentLivenessState.convertAdvise(this.poseState);
        String makeMessageJson = CommonUtils.makeMessageJson(4194304, convertAdvise, "LipRead check failed");
        YtSDKStats.getInstance().reportError(4194304, convertAdvise);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
        hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
        hashMap.put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
        hashMap.put("error_code", 4194304);
        hashMap.put(StateEvent.Name.ERROR_REASON_CODE, 4194304);
        hashMap.put("message", makeMessageJson);
        YtFSM.getInstance().sendFSMEvent(hashMap);
        AppMethodBeat.o(187168);
    }
}

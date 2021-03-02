package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
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
import com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectSettings;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectData;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectImage;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.DataPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import com.tencent.youtu.ytagreflectlivecheck.notice.YTReflectNotice;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ReflectLivenessState extends YtFSMBaseState {
    private static final String TAG = ReflectLivenessState.class.getSimpleName();
    private YTActRefData actRefData;
    private int actReflectUXMode = 0;
    private String appId;
    private int backendProtoType = 0;
    private int changePointNum = 2;
    private String colorData;
    private int continuousDetectCount = 0;
    private String controlConfig = "";
    private ReflectProcessType currentProcessType = ReflectProcessType.RPT_TIPWAIT;
    private String extraConfig = "";
    private YTFaceTrack.FaceStatus[] faceStatus;
    private boolean isLoadResourceOnline = false;
    private String legitimateReflectVersion = "3.6.2";
    private YTFaceTrackParam mOriginParam;
    private boolean needCheckFaces = true;
    private boolean needCheckMultiFaces = false;
    private boolean needCheckPose = false;
    private boolean needLocalConfig = false;
    private boolean needManualTrigger = false;
    private boolean needRandom = false;
    private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    private SilentLivenessState.FacePreviewingAdvise poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    private String randomColorData;
    private int securityLevel = 2;
    private LiveStyleRequester.SeleceData seleceData;
    private int simiThreshold = 70;
    private int stableFrameCount = 5;
    private TimeoutCounter tipsTimer = new TimeoutCounter("reflect tips timeout counter");

    public ReflectLivenessState() {
        AppMethodBeat.i(187236);
        AppMethodBeat.o(187236);
    }

    static /* synthetic */ void access$500(ReflectLivenessState reflectLivenessState, FullPack fullPack) {
        AppMethodBeat.i(187258);
        reflectLivenessState.handleSuccess(fullPack);
        AppMethodBeat.o(187258);
    }

    static /* synthetic */ void access$600(ReflectLivenessState reflectLivenessState, int i2, String str, String str2) {
        AppMethodBeat.i(187259);
        reflectLivenessState.handleFailure(i2, str, str2);
        AppMethodBeat.o(187259);
    }

    static {
        AppMethodBeat.i(187260);
        AppMethodBeat.o(187260);
    }

    /* access modifiers changed from: package-private */
    public enum ReflectProcessType {
        RPT_TIPWAIT,
        RPT_INIT,
        RPT_REFLECT,
        RPT_FINISH;

        public static ReflectProcessType valueOf(String str) {
            AppMethodBeat.i(187234);
            ReflectProcessType reflectProcessType = (ReflectProcessType) Enum.valueOf(ReflectProcessType.class, str);
            AppMethodBeat.o(187234);
            return reflectProcessType;
        }

        static {
            AppMethodBeat.i(187235);
            AppMethodBeat.o(187235);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void loadStateWith(String str, JSONObject jSONObject) {
        AppMethodBeat.i(187237);
        super.loadStateWith(str, jSONObject);
        try {
            if (jSONObject.has("resource_online")) {
                this.isLoadResourceOnline = jSONObject.getBoolean("resource_online");
            }
            if (jSONObject.has("similarity_threshold")) {
                this.simiThreshold = jSONObject.getInt("similarity_threshold");
            } else {
                this.simiThreshold = 70;
            }
            if (jSONObject.has("reflect_security_level")) {
                this.securityLevel = jSONObject.getInt("reflect_security_level");
            }
            if (jSONObject.has("local_config_flag")) {
                this.needLocalConfig = jSONObject.getBoolean("local_config_flag");
            }
            if (jSONObject.has("color_data")) {
                this.colorData = jSONObject.getString("color_data");
            }
            if (jSONObject.has("stable_frame_num")) {
                this.stableFrameCount = jSONObject.getInt("stable_frame_num");
            }
            if (jSONObject.has("backend_proto_type")) {
                this.backendProtoType = jSONObject.getInt("backend_proto_type");
            }
            if (jSONObject.has("force_pose_check")) {
                this.needCheckPose = jSONObject.getBoolean("force_pose_check");
            }
            if (jSONObject.has("manual_trigger")) {
                this.needManualTrigger = jSONObject.getBoolean("manual_trigger");
            }
            if (jSONObject.has("reflect_tips_countdown_ms")) {
                this.tipsTimer.init((long) Math.max(0, Math.min(10000, jSONObject.getInt("reflect_tips_countdown_ms"))), false);
            }
            if (jSONObject.has("control_config")) {
                this.controlConfig = jSONObject.getString("control_config");
            }
        } catch (JSONException e2) {
            YtLogger.e(TAG, "Failed to parse json:" + e2.getLocalizedMessage());
        }
        if (!this.isLoadResourceOnline) {
            FileUtils.loadLibrary("YTAGReflectLiveCheck");
        }
        YtLogger.i(TAG, "Reflection version:3.6.4.3");
        String[] split = YTAGReflectLiveCheckInterface.VERSION.split("\\.");
        String str2 = this.legitimateReflectVersion;
        YtLogger.i(TAG, "Wanted Reflection Version: ".concat(String.valueOf(str2)));
        String[] split2 = str2.split("\\.");
        if (Integer.parseInt(split[0]) != Integer.parseInt(split2[0])) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.AnonymousClass1 */

                {
                    AppMethodBeat.i(187218);
                    put(StateEvent.Name.WARNING_TIPS, "反光库版本异常！目标版本：" + ReflectLivenessState.this.legitimateReflectVersion + " 当前版本：3.6.4.3");
                    AppMethodBeat.o(187218);
                }
            });
        } else if (Integer.parseInt(split[1]) != Integer.parseInt(split2[1])) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.AnonymousClass2 */

                {
                    AppMethodBeat.i(187223);
                    put(StateEvent.Name.WARNING_TIPS, "反光库版本异常！目标版本：" + ReflectLivenessState.this.legitimateReflectVersion + " 当前版本：3.6.4.3");
                    AppMethodBeat.o(187223);
                }
            });
        } else if (Integer.parseInt(split[2]) < Integer.parseInt(split2[2])) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.AnonymousClass3 */

                {
                    AppMethodBeat.i(187224);
                    put(StateEvent.Name.WARNING_TIPS, "反光库版本过低！目标版本：" + ReflectLivenessState.this.legitimateReflectVersion + " 当前版本：3.6.4.3");
                    AppMethodBeat.o(187224);
                }
            });
        }
        try {
            this.appId = jSONObject.getString("app_id");
            if (jSONObject.has("extra_config")) {
                this.extraConfig = jSONObject.getString("extra_config");
            }
            if (jSONObject.has("change_point_num")) {
                this.changePointNum = jSONObject.getInt("change_point_num");
            }
            if (jSONObject.has("need_random_flag")) {
                this.needRandom = jSONObject.getBoolean("need_random_flag");
            }
            this.needCheckMultiFaces = jSONObject.optBoolean("need_check_multiface", false);
        } catch (JSONException e3) {
            YtLogger.e(TAG, "Failed to parse json:" + e3.getLocalizedMessage());
        }
        final int initModel = YTAGReflectLiveCheckInterface.initModel(this.appId);
        if (initModel != 0) {
            YtLogger.e(TAG, "failed to init reflect sdk ".concat(String.valueOf(initModel)));
            YtSDKStats.getInstance().reportError(initModel, "failed to init reflect sdk");
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.AnonymousClass4 */

                {
                    AppMethodBeat.i(187225);
                    put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                    put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_REFLECT_INIT_FAILED));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_REFLECT_INIT_FAILED, StringCode.MSG_PARAM_ERROR, "Init YTReflect SDK failed with " + initModel));
                    AppMethodBeat.o(187225);
                }
            });
        }
        this.mOriginParam = YTFaceTrack.getInstance().GetFaceTrackParam();
        if (this.needRandom) {
            this.randomColorData = YTAGReflectLiveCheckJNIInterface.FRGenConfigData(this.changePointNum, this.extraConfig);
        }
        YTAGReflectLiveCheckInterface.setReflectNotice(new YTReflectNotice() {
            /* class com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.AnonymousClass5 */

            @Override // com.tencent.youtu.ytagreflectlivecheck.notice.YTReflectNotice
            public void onDelayCalc() {
                AppMethodBeat.i(187226);
                ReflectLivenessState.this.needCheckFaces = false;
                AppMethodBeat.o(187226);
            }
        });
        if (YtFSM.getInstance().getContext().reflectListener != null) {
            YTAGReflectLiveCheckInterface.setReflectListener(new YTAGReflectLiveCheckInterface.IYTReflectListener() {
                /* class com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.AnonymousClass6 */

                @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.IYTReflectListener
                public void onReflectEvent(ColorMatrixColorFilter colorMatrixColorFilter, float f2) {
                    AppMethodBeat.i(187227);
                    try {
                        if (!ReflectLivenessState.this.stateData.containsKey("refcontrol_begin")) {
                            ReflectLivenessState.this.stateData.put("refcontrol_begin", String.valueOf(System.currentTimeMillis() * 1000));
                        }
                        YtFSM.getInstance().getContext().reflectListener.onReflectEvent(colorMatrixColorFilter, f2);
                        AppMethodBeat.o(187227);
                    } catch (Exception e2) {
                        YtLogger.e(ReflectLivenessState.TAG, e2.getLocalizedMessage());
                        AppMethodBeat.o(187227);
                    }
                }

                @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.IYTReflectListener
                public void onReflectStart(long j2) {
                    AppMethodBeat.i(187228);
                    try {
                        YtFSM.getInstance().getContext().reflectListener.onReflectStart(j2);
                        AppMethodBeat.o(187228);
                    } catch (Exception e2) {
                        YtLogger.e(ReflectLivenessState.TAG, e2.getLocalizedMessage());
                        AppMethodBeat.o(187228);
                    }
                }

                @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.IYTReflectListener
                public float onGetAppBrightness() {
                    AppMethodBeat.i(187229);
                    float f2 = -1.0f;
                    try {
                        f2 = YtFSM.getInstance().getContext().reflectListener.onGetAppBrightness();
                    } catch (Exception e2) {
                        YtLogger.e(ReflectLivenessState.TAG, e2.getLocalizedMessage());
                    }
                    AppMethodBeat.o(187229);
                    return f2;
                }
            });
        } else {
            YTAGReflectLiveCheckInterface.setReflectListener(null);
        }
        YTAGReflectLiveCheckJNIInterface.configNativeLog(true);
        YTAGReflectLiveCheckJNIInterface.updateParam("log_level", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        YTAGReflectLiveCheckJNIInterface.setLoggerListener(new YTAGReflectLiveCheckJNIInterface.IYtLoggerListener() {
            /* class com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.AnonymousClass7 */

            @Override // com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface.IYtLoggerListener
            public void log(String str, String str2) {
                AppMethodBeat.i(187230);
                YtLogger.d(str, str2);
                AppMethodBeat.o(187230);
            }
        });
        AppMethodBeat.o(187237);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void updateSDKSetting(JSONObject jSONObject) {
        AppMethodBeat.i(187238);
        try {
            this.needCheckPose = jSONObject.optBoolean("force_pose_check", this.needCheckPose);
            this.needCheckMultiFaces = jSONObject.optBoolean("need_check_multiface", this.needCheckMultiFaces);
            AppMethodBeat.o(187238);
        } catch (Exception e2) {
            YtLogger.e(TAG, e2.getLocalizedMessage());
            AppMethodBeat.o(187238);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void unload() {
        AppMethodBeat.i(187239);
        super.unload();
        YTAGReflectLiveCheckInterface.cancel();
        YTAGReflectLiveCheckInterface.releaseModel();
        AppMethodBeat.o(187239);
    }

    private void clearData() {
        AppMethodBeat.i(187240);
        this.currentProcessType = ReflectProcessType.RPT_TIPWAIT;
        this.continuousDetectCount = 0;
        this.poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
        this.needCheckFaces = true;
        YTAGReflectLiveCheckInterface.cancel();
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        AppMethodBeat.o(187240);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void reset() {
        AppMethodBeat.i(187241);
        clearData();
        super.reset();
        AppMethodBeat.o(187241);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
        AppMethodBeat.i(187242);
        super.handleEvent(ytFrameworkFireEventType, obj);
        if (this.needManualTrigger && ytFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS) {
            clearData();
        }
        AppMethodBeat.o(187242);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
        AppMethodBeat.i(187243);
        YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
        this.tipsTimer.reset();
        YtFSM.getInstance().cleanUpQueue();
        AppMethodBeat.o(187243);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        AppMethodBeat.i(187244);
        super.enter();
        YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        try {
            this.poseState = (SilentLivenessState.FacePreviewingAdvise) stateByName.getStateDataBy("pose_state");
            this.continuousDetectCount = ((Integer) stateByName.getStateDataBy("continuous_detect_count")).intValue();
            this.faceStatus = (YTFaceTrack.FaceStatus[]) stateByName.getStateDataBy("face_status");
            YtFSMBaseState stateByName2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
            if (stateByName2 != null) {
                this.seleceData = (LiveStyleRequester.SeleceData) stateByName2.getStateDataBy("select_data");
                if (!this.needLocalConfig) {
                    this.colorData = (String) stateByName2.getStateDataBy("color_data");
                } else if (this.needRandom) {
                    this.colorData = this.randomColorData;
                }
                String str = (String) stateByName2.getStateDataBy("control_config");
                if (str != null) {
                    this.controlConfig = str;
                }
            }
            if (!this.controlConfig.isEmpty()) {
                String[] split = this.controlConfig.split("&");
                if (split.length > 0) {
                    int length = split.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        String[] split2 = split[i2].split("=");
                        if (split2.length > 1 && split2[0].equals("actref_ux_mode")) {
                            this.actReflectUXMode = Integer.parseInt(split2[1]);
                            break;
                        }
                        i2++;
                    }
                }
            }
            YtFSMBaseState stateByName3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
            if (stateByName3 != null) {
                this.actRefData = (YTActRefData) stateByName3.getStateDataBy("act_reflect_data");
            }
            if (this.continuousDetectCount > this.stableFrameCount && this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS && this.faceStatus != null && this.faceStatus.length > 0) {
                YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                    /* class com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.AnonymousClass8 */

                    {
                        AppMethodBeat.i(187231);
                        put(StateEvent.Name.UI_TIPS, StringCode.FL_POSE_KEEP);
                        AppMethodBeat.o(187231);
                    }
                });
            }
            if (this.actReflectUXMode == 2) {
                this.currentProcessType = ReflectProcessType.RPT_FINISH;
                handleSuccess(null);
            }
            AppMethodBeat.o(187244);
        } catch (Exception e2) {
            YtLogger.e(TAG, "reflection enter failed " + e2.getLocalizedMessage());
            CommonUtils.reportException("reflection enter failed ", e2);
            AppMethodBeat.o(187244);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void update(byte[] bArr, int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(187245);
        super.update(bArr, i2, i3, i4, j2);
        switch (this.currentProcessType) {
            case RPT_TIPWAIT:
                if (this.tipsTimer.isRunning() && !this.tipsTimer.checkTimeout()) {
                    if (this.continuousDetectCount > 1) {
                        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                            /* class com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.AnonymousClass9 */

                            {
                                AppMethodBeat.i(187232);
                                put(StateEvent.Name.UI_TIPS, StringCode.FL_REFLECT_PREPARE);
                                AppMethodBeat.o(187232);
                            }
                        });
                        break;
                    } else {
                        this.tipsTimer.reset();
                        break;
                    }
                } else {
                    this.tipsTimer.cancel();
                    this.currentProcessType = ReflectProcessType.RPT_INIT;
                    break;
                }
                break;
            case RPT_INIT:
                if (this.continuousDetectCount > this.stableFrameCount && ((this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS || this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_INBUFFER_PASS) && this.faceStatus != null && this.faceStatus.length > 0)) {
                    startReflect();
                }
                this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
                break;
            case RPT_REFLECT:
                YtLogger.d(TAG, "reflect continuous_detect_count " + this.continuousDetectCount + "pass flag " + (this.poseState != SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS));
                YtLogger.d(TAG, "reflect pose state " + this.poseState);
                if (this.needCheckFaces && (!(!this.needCheckPose || this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS || this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_INBUFFER_PASS) || ((this.needCheckMultiFaces && this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE) || this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE))) {
                    YtLogger.i(TAG, "reflect cancel:" + this.continuousDetectCount);
                    YTAGReflectLiveCheckInterface.cancel();
                    handleFailure(-1, "检测异常", "请保持姿态");
                }
                if (this.faceStatus != null) {
                    YTAGReflectLiveCheckInterface.pushImageData(bArr, i2, i3, j2, YtFSM.getInstance().getContext().currentRotateState, this.faceStatus[0].xys, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
                    break;
                }
                break;
        }
        moveToNextState();
        AppMethodBeat.o(187245);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void exit() {
        AppMethodBeat.i(187246);
        super.exit();
        AppMethodBeat.o(187246);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void onPause() {
        AppMethodBeat.i(187247);
        super.onPause();
        AppMethodBeat.o(187247);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void onResume() {
        AppMethodBeat.i(187248);
        super.onResume();
        AppMethodBeat.o(187248);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void moveToNextState() {
        AppMethodBeat.i(187249);
        super.moveToNextState();
        if (this.nextStateName == YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE) {
            YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
            AppMethodBeat.o(187249);
            return;
        }
        YTFaceTrack.getInstance().SetFaceTrackParam(this.mOriginParam);
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
        AppMethodBeat.o(187249);
    }

    private static Bitmap imageScale(Bitmap bitmap, int i2, int i3) {
        AppMethodBeat.i(187250);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i2) / ((float) width), ((float) i3) / ((float) height));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        AppMethodBeat.o(187250);
        return createBitmap;
    }

    private void startReflect() {
        boolean z = false;
        AppMethodBeat.i(187251);
        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
            /* class com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.AnonymousClass10 */

            {
                AppMethodBeat.i(187219);
                put(StateEvent.Name.UI_TIPS, StringCode.FL_POSE_KEEP);
                AppMethodBeat.o(187219);
            }
        });
        YTFaceTrackParam yTFaceTrackParam = this.mOriginParam;
        yTFaceTrackParam.detect_interval = -1;
        YTFaceTrack.getInstance().SetFaceTrackParam(yTFaceTrackParam);
        this.currentProcessType = ReflectProcessType.RPT_REFLECT;
        setupRequset();
        YTAGReflectSettings aGSettings = YTAGReflectLiveCheckInterface.getAGSettings();
        aGSettings.safetylevel = this.securityLevel;
        aGSettings.isEncodeReflectData = false;
        if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
            z = true;
        }
        aGSettings.isActionReflect = z;
        YTAGReflectLiveCheckInterface.setAGSettings(aGSettings);
        YtLogger.i(TAG, "Settings: safetyLevel " + aGSettings.safetylevel);
        YtLogger.i(TAG, "Settings: isEncodeReflectData " + aGSettings.isEncodeReflectData);
        YtLogger.i(TAG, "Settings: isActionReflect " + aGSettings.isActionReflect);
        YtSDKKitFramework.YtSDKPlatformContext context = YtFSM.getInstance().getContext();
        YTAGReflectLiveCheckInterface.start(context.currentAppContext, context.currentCamera, context.currentCameraId, this.colorData, new YTAGReflectLiveCheckInterface.LightLiveCheckResult() {
            /* class com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.AnonymousClass11 */

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult
            public void onSuccess(FullPack fullPack) {
                AppMethodBeat.i(187220);
                YtLogger.i(ReflectLivenessState.TAG, "on start succeed!!!!!");
                ReflectLivenessState.access$500(ReflectLivenessState.this, fullPack);
                AppMethodBeat.o(187220);
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult
            public void onFailed(int i2, String str, String str2) {
                AppMethodBeat.i(187221);
                ReflectLivenessState.access$600(ReflectLivenessState.this, i2, str, str2);
                AppMethodBeat.o(187221);
            }
        });
        AppMethodBeat.o(187251);
    }

    private void setupRequset() {
    }

    private void handleSuccess(FullPack fullPack) {
        AppMethodBeat.i(187252);
        if (this.currentProcessType == ReflectProcessType.RPT_TIPWAIT) {
            AppMethodBeat.o(187252);
            return;
        }
        if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
            try {
                ActionReflectReq actionReflectLiveReq = getActionReflectLiveReq(fullPack, new YTActReflectData(new YTActReflectImage(this.actRefData.best.image, this.actRefData.best.xys, this.actRefData.best.checksum), new YTActReflectImage(this.actRefData.eye.image, this.actRefData.eye.xys, this.actRefData.eye.checksum), new YTActReflectImage(this.actRefData.mouth.image, this.actRefData.mouth.xys, this.actRefData.mouth.checksum), this.seleceData), this.colorData);
                actionReflectLiveReq.app_id = this.appId;
                Bitmap bitmap = YtFSM.getInstance().getContext().imageToCompare;
                if (bitmap != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    int i2 = width > height ? width : height;
                    if (i2 > 640) {
                        bitmap = imageScale(bitmap, (width * 640) / i2, (height * 640) / i2);
                        YtLogger.d(TAG, "resize image. from w:" + width + " h:" + height + " to w:" + bitmap.getWidth() + " h:" + bitmap.getHeight());
                    }
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream);
                    actionReflectLiveReq.compare_image = new YTImageInfo(new YTActReflectImage(byteArrayOutputStream.toByteArray(), null, null));
                }
                actionReflectLiveReq.color_data = this.colorData;
                this.stateData.put("reflect_request_object", actionReflectLiveReq);
            } catch (Exception e2) {
                YtLogger.e(TAG, "handle success failed: " + e2.getLocalizedMessage());
            }
        } else {
            ReflectLiveReq reflectLiveReq = getReflectLiveReq(fullPack, this.colorData);
            Bitmap bitmap2 = YtFSM.getInstance().getContext().imageToCompare;
            if (bitmap2 != null) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                int width2 = bitmap2.getWidth();
                int height2 = bitmap2.getHeight();
                int i3 = width2 > height2 ? width2 : height2;
                if (i3 > 640) {
                    bitmap2 = imageScale(bitmap2, (width2 * 640) / i3, (height2 * 640) / i3);
                    YtLogger.d(TAG, "resize image. from w:" + width2 + " h:" + height2 + " to w:" + bitmap2.getWidth() + " h:" + bitmap2.getHeight());
                }
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream2);
                reflectLiveReq.compare_image = new String(Base64.encode(byteArrayOutputStream2.toByteArray(), 2));
            }
            YtLogger.d(TAG, "on Request...");
            reflectLiveReq.color_data = this.colorData;
            reflectLiveReq.select_data = this.seleceData;
            this.stateData.put("reflect_request_object", reflectLiveReq);
        }
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE;
        AppMethodBeat.o(187252);
    }

    private void handleFailure(int i2, String str, String str2) {
        AppMethodBeat.i(187253);
        YtLogger.e(TAG, "failed :".concat(String.valueOf("message:" + str + "\ntips:" + str2 + "\ncode:" + i2)));
        String convertAdvise = SilentLivenessState.convertAdvise(this.poseState);
        String makeMessageJson = CommonUtils.makeMessageJson(4194304, convertAdvise, str);
        YtSDKStats.getInstance().reportError(i2, convertAdvise);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
        hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
        hashMap.put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
        hashMap.put("error_code", 4194304);
        hashMap.put(StateEvent.Name.ERROR_REASON_CODE, Integer.valueOf(i2));
        hashMap.put("message", makeMessageJson);
        YtFSM.getInstance().sendFSMEvent(hashMap);
        this.currentProcessType = ReflectProcessType.RPT_FINISH;
        AppMethodBeat.o(187253);
    }

    private ActionReflectReq getActionReflectLiveReq(FullPack fullPack, YTActReflectData yTActReflectData, String str) {
        AppMethodBeat.i(187254);
        ActionReflectReq actionReflectReq = new ActionReflectReq();
        actionReflectReq.app_id = YTAGReflectLiveCheckInterface.mAppId;
        actionReflectReq.color_data = str;
        actionReflectReq.platform = 2;
        actionReflectReq.select_data = yTActReflectData.select_data;
        if (fullPack != null) {
            actionReflectReq.reflect_data = translation(fullPack.AGin);
        }
        actionReflectReq.live_image = new YTImageInfo(yTActReflectData.best);
        actionReflectReq.eye_image = new YTImageInfo(yTActReflectData.eye);
        actionReflectReq.mouth_image = new YTImageInfo(yTActReflectData.mouth);
        actionReflectReq.compare_image = null;
        actionReflectReq.mode = 0;
        actionReflectReq.session_id = null;
        AppMethodBeat.o(187254);
        return actionReflectReq;
    }

    private ReflectLiveReq getReflectLiveReq(FullPack fullPack, String str) {
        AppMethodBeat.i(187255);
        ReflectLiveReq reflectLiveReq = new ReflectLiveReq();
        reflectLiveReq.color_data = str;
        reflectLiveReq.platform = 2;
        if (fullPack != null) {
            reflectLiveReq.reflect_data = translation(fullPack.AGin);
            reflectLiveReq.live_image = null;
        }
        reflectLiveReq.compare_image = null;
        reflectLiveReq.session_id = null;
        reflectLiveReq.app_id = YTAGReflectLiveCheckInterface.mAppId;
        AppMethodBeat.o(187255);
        return reflectLiveReq;
    }

    private ReflectColorData translation(DataPack dataPack) {
        AppMethodBeat.i(187256);
        ReflectColorData reflectColorData = new ReflectColorData();
        ArrayList<ColorImgData> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < dataPack.videoData.length; i2++) {
            arrayList.add(translation(dataPack.videoData[i2]));
        }
        reflectColorData.setImages_data(arrayList);
        reflectColorData.setBegin_time(dataPack.beginTime);
        reflectColorData.setChangepoint_time(dataPack.changePointTime);
        reflectColorData.changepoint_time_list = new ArrayList<>();
        for (int i3 = 0; i3 < dataPack.changePointTimeList.length; i3++) {
            reflectColorData.changepoint_time_list.add(Long.valueOf(dataPack.changePointTimeList[i3]));
        }
        reflectColorData.setOffset_sys(dataPack.offsetSys);
        reflectColorData.setFrame_num(dataPack.frameNum);
        reflectColorData.setLandmark_num(dataPack.landMarkNum);
        reflectColorData.setWidth(dataPack.width);
        reflectColorData.setHeight(dataPack.height);
        reflectColorData.version = YTAGReflectLiveCheckInterface.VERSION;
        try {
            reflectColorData.setLog(new String(dataPack.log, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e2) {
        }
        reflectColorData.setConfig_begin(dataPack.config_begin);
        AppMethodBeat.o(187256);
        return reflectColorData;
    }

    private ColorImgData translation(RawImgData rawImgData) {
        AppMethodBeat.i(187257);
        ColorImgData colorImgData = new ColorImgData();
        colorImgData.setImage(new String(Base64.encode(rawImgData.frameBuffer, 2)));
        colorImgData.checksum = rawImgData.checksum;
        colorImgData.setCapture_time(rawImgData.captureTime);
        colorImgData.setX(rawImgData.x);
        colorImgData.setY(rawImgData.y);
        AppMethodBeat.o(187257);
        return colorImgData;
    }
}

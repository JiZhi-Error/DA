package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Environment;
import android.util.Base64;
import com.facebook.AccessToken;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState;
import com.tencent.youtu.sdkkitframework.liveness.YtLivenessNetProtoHelper;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class NetLivenessReqResultState extends YtFSMBaseState {
    private static final String TAG = NetLivenessReqResultState.class.getSimpleName();
    private int actRefUXMode = 0;
    private int actReflectType = 0;
    private String appId;
    private int backendProtoType = 0;
    private YuvImage bestImage;
    private int changePointNum = 2;
    private String controlConfig = "";
    private String extraConfig = "";
    private int finalConfidenceThreshold;
    private boolean needManualTrigger = false;
    boolean needVideoData = true;
    private HashMap<String, String> requestOptions = new HashMap<>();
    private String resultUrl;
    private String secretId;
    private String secretKey;
    private int simiThreshold = 70;
    private String userId;

    public NetLivenessReqResultState() {
        AppMethodBeat.i(187201);
        AppMethodBeat.o(187201);
    }

    static /* synthetic */ void access$100(NetLivenessReqResultState netLivenessReqResultState, HashMap hashMap, Exception exc) {
        AppMethodBeat.i(187215);
        netLivenessReqResultState.handleResponseEvent(hashMap, exc);
        AppMethodBeat.o(187215);
    }

    static /* synthetic */ void access$200(NetLivenessReqResultState netLivenessReqResultState) {
        AppMethodBeat.i(187216);
        netLivenessReqResultState.onCheckResponseManual();
        AppMethodBeat.o(187216);
    }

    static {
        AppMethodBeat.i(187217);
        AppMethodBeat.o(187217);
    }

    public class Version {
        public String faction_sdk_version = "";
        public String freflect_sdk_version = "";
        public String ftrack_sdk_version = "";
        public String sdk_version = "";

        public Version() {
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void loadStateWith(String str, JSONObject jSONObject) {
        AppMethodBeat.i(187202);
        super.loadStateWith(str, jSONObject);
        try {
            this.appId = jSONObject.getString("app_id");
            this.resultUrl = jSONObject.getString("result_api_url");
            if (this.resultUrl == null) {
                YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_PARAM_ERROR, "yt_param_error");
                YtLogger.e(TAG, "parse url failed");
                AppMethodBeat.o(187202);
                return;
            }
            if (jSONObject.has("secret_key")) {
                this.secretKey = jSONObject.getString("secret_key");
            }
            if (jSONObject.has("secret_id")) {
                this.secretId = jSONObject.getString("secret_id");
            }
            if (jSONObject.has(AccessToken.USER_ID_KEY)) {
                this.userId = jSONObject.getString(AccessToken.USER_ID_KEY);
            }
            if (jSONObject.has("similarity_threshold")) {
                this.simiThreshold = jSONObject.getInt("similarity_threshold");
            }
            if (jSONObject.has("final_liveness_confidence_threshold")) {
                this.finalConfidenceThreshold = jSONObject.getInt("final_liveness_confidence_threshold");
            } else {
                this.finalConfidenceThreshold = 85;
            }
            if (jSONObject.has("extra_config")) {
                this.extraConfig = jSONObject.getString("extra_config");
            } else {
                this.extraConfig = " version 2";
            }
            if (jSONObject.has("control_config")) {
                this.controlConfig = jSONObject.getString("control_config");
            }
            if (jSONObject.has("change_point_num")) {
                this.changePointNum = jSONObject.getInt("change_point_num");
            }
            if (jSONObject.has("manual_trigger")) {
                this.needManualTrigger = jSONObject.getBoolean("manual_trigger");
            }
            if (jSONObject.has("request_options")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("request_options");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.requestOptions.put(next, jSONObject2.getString(next));
                }
            }
            if (jSONObject.has("backend_proto_type")) {
                this.backendProtoType = jSONObject.getInt("backend_proto_type");
            }
            AppMethodBeat.o(187202);
        } catch (JSONException e2) {
            YtLogger.e(TAG, "Failed to parse json:" + e2.getLocalizedMessage());
            AppMethodBeat.o(187202);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void unload() {
        AppMethodBeat.i(187203);
        super.unload();
        AppMethodBeat.o(187203);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        AppMethodBeat.i(187204);
        super.enter();
        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
            /* class com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.AnonymousClass1 */

            {
                AppMethodBeat.i(187188);
                put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.NET_REQ);
                AppMethodBeat.o(187188);
            }
        });
        switch (YtFSM.getInstance().getWorkMode()) {
            case YT_FW_SILENT_TYPE:
            case YT_FW_ACTION_TYPE:
                onActionRequest();
                AppMethodBeat.o(187204);
                return;
            case YT_FW_REFLECT_TYPE:
                onReflectRequest();
                AppMethodBeat.o(187204);
                return;
            case YT_FW_ACTREFLECT_TYPE:
                if (this.actReflectType == 0) {
                    onActReflectRequest();
                    AppMethodBeat.o(187204);
                    return;
                }
                onActReflectRequest2();
                AppMethodBeat.o(187204);
                return;
            case YT_FW_LIPREAD_TYPE:
                onLipReadRequest();
                break;
        }
        AppMethodBeat.o(187204);
    }

    private void onCheckResponseManual() {
        AppMethodBeat.i(187205);
        if (this.needManualTrigger) {
            try {
                YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_manual_trigger", null);
                YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
                AppMethodBeat.o(187205);
                return;
            } catch (Exception e2) {
                String str = "on Check response manual failed " + e2.getLocalizedMessage();
                YtLogger.e(TAG, str);
                YtSDKStats.getInstance().reportInfo(str);
            }
        }
        AppMethodBeat.o(187205);
    }

    private void onSilentRequest() {
        AppMethodBeat.i(187206);
        this.bestImage = (YuvImage) YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).getStateDataBy("best_image");
        int width = this.bestImage.getWidth();
        int height = this.bestImage.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.bestImage.compressToJpeg(new Rect(0, 0, width, height), 95, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        YtLivenessNetProtoHelper.PictureLiveReqData pictureLiveReqData = new YtLivenessNetProtoHelper.PictureLiveReqData();
        pictureLiveReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
        pictureLiveReqData.baseInfo.sessionId = UUID.randomUUID().toString();
        pictureLiveReqData.baseInfo.appId = this.appId;
        pictureLiveReqData.imageInfo = new YtLivenessNetProtoHelper.ImageInfo(byteArray, (float[]) null, (String) null);
        YtFSM.getInstance().sendNetworkRequest(StringCode.NET_REPORTING, this.resultUrl, YtLivenessNetProtoHelper.makePictureLiveReq(pictureLiveReqData), null, new YtSDKKitFramework.IYtSDKKitNetResponseParser() {
            /* class com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.AnonymousClass2 */

            @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
            public void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc) {
                AppMethodBeat.i(187193);
                YtLogger.i(NetLivenessReqResultState.TAG, "Parse silent response");
                NetLivenessReqResultState.access$100(NetLivenessReqResultState.this, hashMap, exc);
                NetLivenessReqResultState.access$200(NetLivenessReqResultState.this);
                AppMethodBeat.o(187193);
            }
        });
        AppMethodBeat.o(187206);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ef A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleResponseEvent(java.util.HashMap<java.lang.String, java.lang.String> r12, java.lang.Exception r13) {
        /*
        // Method dump skipped, instructions count: 558
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.handleResponseEvent(java.util.HashMap, java.lang.Exception):void");
    }

    private void onLipReadRequest() {
        String makeFourLiveReq;
        int i2 = 0;
        AppMethodBeat.i(187208);
        try {
            YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
            YtFSMBaseState stateByName2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.LIPREAD_STATE));
            if (stateByName2 == null) {
                YtSDKStats.getInstance().reportInfo("lipread request action state is null");
                YtLogger.e(TAG, "lipread request action state is null");
                AppMethodBeat.o(187208);
                return;
            }
            this.bestImage = (YuvImage) stateByName2.getStateDataBy("last_frame");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.bestImage.compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, byteArrayOutputStream);
            byte[] encode = Base64.encode(byteArrayOutputStream.toByteArray(), 2);
            Arrays.toString((String[]) stateByName2.getStateDataBy("action_seq"));
            if (this.backendProtoType == 2) {
                YtLivenessNetProtoHelper.LipReadReqData lipReadReqData = new YtLivenessNetProtoHelper.LipReadReqData();
                lipReadReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
                lipReadReqData.baseInfo.appId = this.appId;
                lipReadReqData.baseInfo.sessionId = UUID.randomUUID().toString();
                lipReadReqData.baseInfo.businessId = this.requestOptions.containsKey("business_id") ? this.requestOptions.get("business_id") : "wx_default";
                lipReadReqData.baseInfo.personId = this.requestOptions.containsKey("person_id") ? this.requestOptions.get("person_id") : "wx_default0";
                lipReadReqData.baseInfo.personType = this.requestOptions.containsKey("person_type") ? this.requestOptions.get("person_type") : "youtu";
                lipReadReqData.baseInfo.reqType = this.requestOptions.containsKey("req_type") ? this.requestOptions.get("req_type") : WeChatBrands.Business.GROUP_LIVE;
                YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData = lipReadReqData.baseInfo;
                netBaseInfoData.liveType = this.requestOptions.containsKey("live_type") ? Integer.parseInt(this.requestOptions.get("live_type")) : 0;
                lipReadReqData.liveImage = new String(encode);
                lipReadReqData.liveFivePoint = (float[]) stateByName2.getStateDataBy("last_frame_landmark");
                lipReadReqData.faceExtraInfo = (String) stateByName2.getStateDataBy("face_extra_list");
                String[] strArr = (String[]) stateByName2.getStateDataBy("action_seq");
                String str = "";
                while (i2 < strArr.length) {
                    str = str + strArr[i2];
                    i2++;
                }
                YtLogger.d(TAG, "action_seq: ".concat(String.valueOf(str)));
                lipReadReqData.validate_data = str;
                lipReadReqData.voice = new String(Base64.encode((byte[]) stateByName2.getStateDataBy("audio_data"), 2));
                lipReadReqData.mouth_lip_reading = (String) stateByName2.getStateDataBy("lipreading_feature");
                lipReadReqData.mouth_move = (String) stateByName2.getStateDataBy("feature");
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                ((YuvImage) stateByName.getStateDataBy("best_image")).compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, byteArrayOutputStream2);
                lipReadReqData.bestImage = new YtLivenessNetProtoHelper.ImageInfo(byteArrayOutputStream2.toByteArray(), (float[]) stateByName.getStateDataBy("best_shape"), (String) null);
                makeFourLiveReq = YtLivenessNetProtoHelper.makeLipReadReq(lipReadReqData);
            } else {
                String[] strArr2 = (String[]) stateByName2.getStateDataBy("action_seq");
                String str2 = "";
                while (i2 < strArr2.length) {
                    str2 = str2 + strArr2[i2];
                    i2++;
                }
                YtLogger.d(TAG, "action_seq: ".concat(String.valueOf(str2)));
                YtLivenessNetProtoHelper.FourLiveReqData fourLiveReqData = new YtLivenessNetProtoHelper.FourLiveReqData();
                fourLiveReqData.baseInfoData = new YtLivenessNetProtoHelper.NetBaseInfoData();
                fourLiveReqData.baseInfoData.appId = this.appId;
                fourLiveReqData.validateData = str2;
                fourLiveReqData.video = new String(Base64.encode((byte[]) stateByName2.getStateDataBy("audio_data"), 2));
                makeFourLiveReq = YtLivenessNetProtoHelper.makeFourLiveReq(fourLiveReqData);
                if (this.requestOptions.size() > 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(makeFourLiveReq);
                        for (Map.Entry<String, String> entry : this.requestOptions.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                        makeFourLiveReq = jSONObject.toString();
                    } catch (JSONException e2) {
                        YtLogger.e(TAG, "lipread net request parse json failed " + e2.getLocalizedMessage());
                    }
                }
            }
            YtFSM.getInstance().sendNetworkRequest(StringCode.NET_REPORTING, this.resultUrl, makeFourLiveReq, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser() {
                /* class com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.AnonymousClass4 */

                @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
                public void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc) {
                    AppMethodBeat.i(187195);
                    YtLogger.i(NetLivenessReqResultState.TAG, "Handle lipread response");
                    NetLivenessReqResultState.access$100(NetLivenessReqResultState.this, hashMap, exc);
                    NetLivenessReqResultState.access$200(NetLivenessReqResultState.this);
                    AppMethodBeat.o(187195);
                }
            });
            AppMethodBeat.o(187208);
        } catch (Exception e3) {
            YtLogger.e(TAG, "lipread request failed" + e3.getLocalizedMessage());
            YtSDKStats.getInstance().reportInfo("lipreading request failed: " + e3.getLocalizedMessage());
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.AnonymousClass5 */

                {
                    AppMethodBeat.i(187196);
                    put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                    put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                    put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                    put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_PARAM_ERROR));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_PARAM_ERROR, StringCode.RST_FAILED, e3.getLocalizedMessage()));
                    AppMethodBeat.o(187196);
                }
            });
            AppMethodBeat.o(187208);
        }
    }

    private void parseControlConfig() {
        AppMethodBeat.i(187209);
        if (!this.controlConfig.isEmpty()) {
            String[] split = this.controlConfig.split("&");
            if (split.length > 0) {
                for (String str : split) {
                    String[] split2 = str.split("=");
                    if (split2.length > 1) {
                        if (split2[0].equals("need_action_video") && split2[1].equals("false")) {
                            this.needVideoData = false;
                        }
                        if (split2[0].equals("actref_ux_mode")) {
                            this.actRefUXMode = Integer.parseInt(split2[1]);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(187209);
    }

    private void onActionRequest() {
        byte[] bArr = null;
        AppMethodBeat.i(187210);
        try {
            YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
            if (stateByName == null) {
                YtSDKStats.getInstance().reportInfo("action request action state is null");
                YtLogger.e(TAG, "action request action state is null");
                AppMethodBeat.o(187210);
                return;
            }
            this.bestImage = (YuvImage) stateByName.getStateDataBy("best_frame");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.bestImage.compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, byteArrayOutputStream);
            byte[] bArr2 = (byte[]) stateByName.getStateDataBy("frames");
            if (bArr2 == null) {
                YtLogger.e(TAG, "action data is null");
            }
            if (bArr2 != null) {
                bArr = Base64.encode(bArr2, 2);
            }
            String makeActionStr = makeActionStr((String[]) stateByName.getStateDataBy("action_seq"));
            parseControlConfig();
            YtLivenessNetProtoHelper.ActionLiveReqData actionLiveReqData = new YtLivenessNetProtoHelper.ActionLiveReqData();
            actionLiveReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
            actionLiveReqData.baseInfo.appId = this.appId;
            actionLiveReqData.baseInfo.sessionId = UUID.randomUUID().toString();
            actionLiveReqData.bestImage = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 2));
            actionLiveReqData.actionStr = makeActionStr;
            if (this.needVideoData) {
                actionLiveReqData.actionVideo = new String(bArr);
            } else {
                actionLiveReqData.actionVideo = "";
            }
            actionLiveReqData.needEyeDetect = true;
            actionLiveReqData.needMouthDetect = true;
            actionLiveReqData.reflectConfig = this.extraConfig;
            actionLiveReqData.controlConfig = this.controlConfig;
            actionLiveReqData.colorNum = this.changePointNum;
            YtFSM.getInstance().sendNetworkRequest(StringCode.NET_REPORTING, this.resultUrl, YtLivenessNetProtoHelper.makeActionLiveReq(actionLiveReqData), null, new YtSDKKitFramework.IYtSDKKitNetResponseParser() {
                /* class com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.AnonymousClass6 */

                @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
                public void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc) {
                    AppMethodBeat.i(187197);
                    YtLogger.i(NetLivenessReqResultState.TAG, "Handle action response");
                    NetLivenessReqResultState.access$100(NetLivenessReqResultState.this, hashMap, exc);
                    NetLivenessReqResultState.access$200(NetLivenessReqResultState.this);
                    AppMethodBeat.o(187197);
                }
            });
            AppMethodBeat.o(187210);
        } catch (Exception e2) {
            YtLogger.e(TAG, "action request failed" + e2.getLocalizedMessage());
            YtSDKStats.getInstance().reportInfo("action request failed: " + e2.getLocalizedMessage());
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.AnonymousClass7 */

                {
                    AppMethodBeat.i(187198);
                    put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                    put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                    put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                    put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_PARAM_ERROR));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_PARAM_ERROR, StringCode.RST_FAILED, e2.getLocalizedMessage()));
                    AppMethodBeat.o(187198);
                }
            });
            AppMethodBeat.o(187210);
        }
    }

    private void onReflectRequest() {
        String str;
        String str2;
        String str3;
        int i2;
        String makeReflectLiveReq;
        AppMethodBeat.i(187211);
        CommonUtils.benchMarkBegin("reflect_request_s1");
        try {
            YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
            this.bestImage = (YuvImage) stateByName.getStateDataBy("best_image");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.bestImage.compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, byteArrayOutputStream);
            byte[] encode = Base64.encode(byteArrayOutputStream.toByteArray(), 2);
            this.stateData.put("best_frame", this.bestImage);
            YtFSMBaseState stateByName2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
            YtFSMBaseState stateByName3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
            ReflectLiveReq reflectLiveReq = (ReflectLiveReq) stateByName2.getStateDataBy("reflect_request_object");
            String str4 = (String) stateByName3.getStateDataBy("extra_config");
            if (str4 != null) {
                this.extraConfig = str4;
            }
            String str5 = (String) stateByName2.getStateDataBy("refcontrol_begin");
            if (str5 != null) {
                this.extraConfig = (this.extraConfig != null ? this.extraConfig : "") + " refcontrol_begin " + str5;
            }
            String str6 = (String) stateByName3.getStateDataBy("cp_num");
            if (str6 != null) {
                this.changePointNum = Integer.parseInt(str6);
            }
            reflectLiveReq.session_id = UUID.randomUUID().toString();
            YtLivenessNetProtoHelper.ReflectLiveReqData reflectLiveReqData = new YtLivenessNetProtoHelper.ReflectLiveReqData();
            reflectLiveReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
            reflectLiveReqData.baseInfo.appId = this.appId;
            reflectLiveReqData.baseInfo.sessionId = UUID.randomUUID().toString();
            reflectLiveReqData.baseInfo.businessId = this.requestOptions.containsKey("business_id") ? this.requestOptions.get("business_id") : null;
            YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData = reflectLiveReqData.baseInfo;
            if (this.requestOptions.containsKey("person_id")) {
                str = this.requestOptions.get("person_id");
            } else {
                str = null;
            }
            netBaseInfoData.personId = str;
            YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData2 = reflectLiveReqData.baseInfo;
            if (this.requestOptions.containsKey("person_type")) {
                str2 = this.requestOptions.get("person_type");
            } else {
                str2 = null;
            }
            netBaseInfoData2.personType = str2;
            YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData3 = reflectLiveReqData.baseInfo;
            if (this.requestOptions.containsKey("req_type")) {
                str3 = this.requestOptions.get("req_type");
            } else {
                str3 = null;
            }
            netBaseInfoData3.reqType = str3;
            YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData4 = reflectLiveReqData.baseInfo;
            if (this.requestOptions.containsKey("live_type")) {
                i2 = Integer.parseInt(this.requestOptions.get("live_type"));
            } else {
                i2 = 0;
            }
            netBaseInfoData4.liveType = i2;
            reflectLiveReqData.colorData = reflectLiveReq.color_data;
            reflectLiveReqData.liveImage = new String(encode);
            reflectLiveReqData.reflectData = reflectLiveReq.reflect_data;
            reflectLiveReqData.config = this.extraConfig;
            reflectLiveReqData.colorNum = this.changePointNum;
            if (this.backendProtoType == 2) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                ((YuvImage) stateByName.getStateDataBy("best_image")).compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, byteArrayOutputStream2);
                reflectLiveReqData.bestImage = new YtLivenessNetProtoHelper.ImageInfo(byteArrayOutputStream2.toByteArray(), (float[]) stateByName.getStateDataBy("best_shape"), (String) null);
                YuvImage yuvImage = (YuvImage) stateByName.getStateDataBy("openmouth_image");
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 95, byteArrayOutputStream3);
                reflectLiveReqData.openMouthImage = new YtLivenessNetProtoHelper.ImageInfo(byteArrayOutputStream3.toByteArray(), (float[]) stateByName.getStateDataBy("openmouth_shape"), (String) null);
                YuvImage yuvImage2 = (YuvImage) stateByName.getStateDataBy("closeeye_image");
                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                yuvImage2.compressToJpeg(new Rect(0, 0, yuvImage2.getWidth(), yuvImage2.getHeight()), 95, byteArrayOutputStream4);
                reflectLiveReqData.closeEyeImage = new YtLivenessNetProtoHelper.ImageInfo(byteArrayOutputStream4.toByteArray(), (float[]) stateByName.getStateDataBy("closeeye_shape"), (String) null);
                makeReflectLiveReq = YtLivenessNetProtoHelper.makePersonLiveReq(reflectLiveReqData);
            } else {
                makeReflectLiveReq = YtLivenessNetProtoHelper.makeReflectLiveReq(reflectLiveReqData);
            }
            YtLogger.d(TAG, "begin request...uploadsize " + makeReflectLiveReq.length());
            CommonUtils.benchMarkEnd("reflect_request_s1");
            CommonUtils.benchMarkBegin("reflect_request_s2");
            YtFSM.getInstance().sendNetworkRequest(StringCode.NET_REPORTING, this.resultUrl, makeReflectLiveReq, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser() {
                /* class com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.AnonymousClass8 */

                @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
                public void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc) {
                    AppMethodBeat.i(187199);
                    CommonUtils.benchMarkEnd("reflect_request_s2");
                    CommonUtils.benchMarkBegin("reflect_request_s3");
                    YtLogger.i(NetLivenessReqResultState.TAG, "handle reflection response");
                    NetLivenessReqResultState.access$100(NetLivenessReqResultState.this, hashMap, exc);
                    CommonUtils.benchMarkEnd("reflect_request_s3");
                    NetLivenessReqResultState.access$200(NetLivenessReqResultState.this);
                    AppMethodBeat.o(187199);
                }
            });
            AppMethodBeat.o(187211);
        } catch (Exception e2) {
            YtLogger.e(TAG, "reflection request failed" + e2.getLocalizedMessage());
            YtSDKStats.getInstance().reportInfo("reflection request failed: " + e2.getLocalizedMessage());
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.AnonymousClass9 */

                {
                    AppMethodBeat.i(187200);
                    put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                    put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                    put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                    put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_PARAM_ERROR));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_PARAM_ERROR, StringCode.RST_FAILED, e2.getLocalizedMessage()));
                    AppMethodBeat.o(187200);
                }
            });
            AppMethodBeat.o(187211);
        }
    }

    private String makeActionStr(String[] strArr) {
        AppMethodBeat.i(187212);
        String str = "";
        for (int i2 = 0; i2 < strArr.length; i2++) {
            switch (Integer.parseInt(strArr[i2])) {
                case 0:
                case 1:
                    str = str + "blink";
                    break;
                case 2:
                    str = str + "mouth";
                    break;
                case 3:
                    str = str + "node";
                    break;
                case 4:
                    str = str + "shake";
                    break;
                case 5:
                    str = str + "silence";
                    break;
            }
            if (i2 != strArr.length - 1) {
                str = str + ",";
            }
        }
        AppMethodBeat.o(187212);
        return str;
    }

    private void onActReflectRequest() {
        AppMethodBeat.i(187213);
        try {
            YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
            YtFSMBaseState stateByName2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
            this.bestImage = (YuvImage) stateByName2.getStateDataBy("best_frame");
            this.stateData.put("best_frame", this.bestImage);
            YtFSMBaseState stateByName3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
            ActionReflectReq actionReflectReq = (ActionReflectReq) stateByName3.getStateDataBy("reflect_request_object");
            byte[] encode = Base64.encode((byte[]) stateByName2.getStateDataBy("frames"), 2);
            String str = (String) stateByName.getStateDataBy("control_config");
            if (str != null) {
                this.controlConfig = str;
            }
            String str2 = (String) stateByName.getStateDataBy("extra_config");
            if (str2 != null) {
                this.extraConfig = str2;
                YtLogger.d(TAG, "extraconfig:" + this.extraConfig);
            }
            String str3 = (String) stateByName3.getStateDataBy("refcontrol_begin");
            if (str3 != null) {
                this.extraConfig = (this.extraConfig != null ? this.extraConfig : "") + " refcontrol_begin " + str3;
            }
            String str4 = (String) stateByName.getStateDataBy("cp_num");
            if (str4 != null) {
                this.changePointNum = Integer.parseInt(str4);
                YtLogger.d(TAG, "cpnum:" + this.changePointNum);
            }
            parseControlConfig();
            String makeActionStr = makeActionStr((String[]) stateByName2.getStateDataBy("action_seq"));
            YtLivenessNetProtoHelper.ActionReflectLiveReqData actionReflectLiveReqData = new YtLivenessNetProtoHelper.ActionReflectLiveReqData();
            actionReflectLiveReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
            actionReflectLiveReqData.baseInfo.sessionId = UUID.randomUUID().toString();
            actionReflectLiveReqData.baseInfo.appId = this.appId;
            actionReflectLiveReqData.baseInfo.businessId = "";
            actionReflectLiveReqData.colorData = actionReflectReq.color_data;
            if (this.needVideoData || this.actRefUXMode != 1) {
                actionReflectLiveReqData.actionVideo = new String(encode);
            } else {
                actionReflectLiveReqData.actionVideo = "";
            }
            actionReflectLiveReqData.actionStr = makeActionStr;
            actionReflectLiveReqData.eyeImage = new YtLivenessNetProtoHelper.ImageInfo(actionReflectReq.eye_image.image, actionReflectReq.eye_image.five_points, actionReflectReq.eye_image.checksum);
            actionReflectLiveReqData.mouthImage = new YtLivenessNetProtoHelper.ImageInfo(actionReflectReq.mouth_image.image, actionReflectReq.mouth_image.five_points, actionReflectReq.mouth_image.checksum);
            actionReflectLiveReqData.liveImage = new YtLivenessNetProtoHelper.ImageInfo(actionReflectReq.live_image.image, actionReflectReq.live_image.five_points, actionReflectReq.live_image.checksum);
            actionReflectLiveReqData.reflectData = actionReflectReq.reflect_data;
            actionReflectLiveReqData.baseInfo.lux = actionReflectReq.select_data.android_data.lux;
            actionReflectLiveReqData.reflectConfig = this.extraConfig;
            actionReflectLiveReqData.controlConfig = this.controlConfig;
            actionReflectLiveReqData.colorNum = this.changePointNum;
            YtFSM.getInstance().sendNetworkRequest(StringCode.NET_REPORTING, this.resultUrl, YtLivenessNetProtoHelper.makeActionReflectLiveReq(actionReflectLiveReqData), null, new YtSDKKitFramework.IYtSDKKitNetResponseParser() {
                /* class com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.AnonymousClass10 */

                @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
                public void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc) {
                    AppMethodBeat.i(187189);
                    YtLogger.i(NetLivenessReqResultState.TAG, "handle actreflect response");
                    NetLivenessReqResultState.access$100(NetLivenessReqResultState.this, hashMap, exc);
                    NetLivenessReqResultState.access$200(NetLivenessReqResultState.this);
                    AppMethodBeat.o(187189);
                }
            });
            AppMethodBeat.o(187213);
        } catch (Exception e2) {
            YtLogger.e(TAG, "actrefl request failed" + e2.getLocalizedMessage());
            YtSDKStats.getInstance().reportInfo("actrefl request failed: " + e2.getLocalizedMessage());
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.AnonymousClass11 */

                {
                    AppMethodBeat.i(187190);
                    put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                    put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                    put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                    put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_NETWORK_ERROR));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_NETWORK_ERROR, StringCode.MSG_NET_ERROR, e2.getLocalizedMessage()));
                    AppMethodBeat.o(187190);
                }
            });
            AppMethodBeat.o(187213);
        }
    }

    public class Pointf {
        public float x;
        public float y;

        public Pointf() {
        }
    }

    public class FivePoints {
        public ArrayList<Pointf> points;

        public FivePoints() {
        }
    }

    public class ActionReflectReq2 {
        public ArrayList<FivePoints> five_points;
        public ArrayList<String> images;
        public ActionReflectReq live_req;
        public String session_id;
        public String video;

        public ActionReflectReq2() {
        }
    }

    private void onActReflectRequest2() {
        byte[] bArr;
        int i2;
        int i3;
        AppMethodBeat.i(187214);
        YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
        this.bestImage = (YuvImage) stateByName.getStateDataBy("best_frame");
        this.stateData.put("best_frame", this.bestImage);
        ArrayList arrayList = (ArrayList) stateByName.getStateDataBy("frame_list");
        YtLogger.d(TAG, "action request 2 frame size:" + arrayList.size());
        ActionReflectReq actionReflectReq = (ActionReflectReq) YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE)).getStateDataBy("reflect_request_object");
        ActionReflectReq2 actionReflectReq2 = new ActionReflectReq2();
        byte[] encode = Base64.encode((byte[]) stateByName.getStateDataBy("frames"), 2);
        Version version = new Version();
        version.sdk_version = YtSDKKitFramework.getInstance().version();
        version.ftrack_sdk_version = YTFaceTrack.Version;
        version.faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
        version.freflect_sdk_version = YTAGReflectLiveCheckInterface.VERSION;
        actionReflectReq.action_video = new String(encode);
        new WeJson();
        actionReflectReq.client_version = String.format("sdk_version:%s;ftrack_sdk_version:%s;freflect_sdk_version:%s;faction_sdk_version:%s", version.sdk_version, version.ftrack_sdk_version, version.freflect_sdk_version, version.faction_sdk_version);
        actionReflectReq.session_id = "12345";
        actionReflectReq2.live_req = actionReflectReq;
        actionReflectReq2.session_id = UUID.randomUUID().toString();
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(Environment.getExternalStorageDirectory().getPath() + "/test.mp4"));
            YtLogger.d(TAG, "encode video size:" + fileInputStream.available());
            bArr = fileInputStream.available() != 0 ? new byte[fileInputStream.available()] : null;
            try {
                fileInputStream.read(bArr);
                fileInputStream.close();
            } catch (IOException e2) {
            }
        } catch (IOException e3) {
            bArr = null;
        }
        if (bArr == null) {
            actionReflectReq2.video = "";
        } else {
            actionReflectReq2.video = new String(Base64.encode(bArr, 2));
        }
        YtLogger.d(TAG, "encode video size:" + actionReflectReq2.video.length());
        actionReflectReq2.images = new ArrayList<>();
        actionReflectReq2.five_points = new ArrayList<>();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            int width = ((ActionLivenessState.BestFrame) arrayList.get(i4)).frame.getWidth();
            int height = ((ActionLivenessState.BestFrame) arrayList.get(i4)).frame.getHeight();
            YtLogger.d(TAG, "Eye score " + ((ActionLivenessState.BestFrame) arrayList.get(i4)).eyeScore);
            if (YtFSM.getInstance().getContext().currentRotateState >= 5) {
                i2 = width;
                i3 = height;
            } else {
                i2 = height;
                i3 = width;
            }
            byte[] yuvData = ((ActionLivenessState.BestFrame) arrayList.get(i4)).frame.getYuvData();
            YtLogger.d(TAG, "Rotated size:" + yuvData.length);
            YuvImage yuvImage = new YuvImage(yuvData, 17, i3, i2, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 95, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byte[] encode2 = Base64.encode(byteArray, 2);
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArrayOutputStream.size());
                FileOutputStream fileOutputStream = new FileOutputStream(new File(Environment.getExternalStorageDirectory().getPath() + "/bestbmp" + i4 + ".jpg"));
                decodeByteArray.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e4) {
            }
            actionReflectReq2.images.add(new String(encode2));
            FivePoints fivePoints = new FivePoints();
            fivePoints.points = new ArrayList<>();
            YtLogger.d(TAG, "f5p size:" + (((ActionLivenessState.BestFrame) arrayList.get(i4)).f5p.length / 2));
            for (int i5 = 0; i5 < ((ActionLivenessState.BestFrame) arrayList.get(i4)).f5p.length / 2; i5++) {
                Pointf pointf = new Pointf();
                pointf.x = ((ActionLivenessState.BestFrame) arrayList.get(i4)).f5p[i5 * 2];
                pointf.y = ((ActionLivenessState.BestFrame) arrayList.get(i4)).f5p[(i5 * 2) + 1];
                fivePoints.points.add(pointf);
                YtLogger.d(TAG, "f5p[" + i5 + "] " + pointf.x + "," + pointf.y);
            }
            actionReflectReq2.five_points.add(fivePoints);
        }
        YtLogger.d(TAG, "f5p count" + actionReflectReq2.five_points.size());
        String json = new WeJson().toJson(actionReflectReq2);
        YtLogger.d(TAG, "upload string size:" + json.length());
        YtFSM.getInstance().sendNetworkRequest(StringCode.NET_REPORTING, this.resultUrl, json, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser() {
            /* class com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.AnonymousClass12 */

            @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
            public void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc) {
                AppMethodBeat.i(187191);
                NetLivenessReqResultState.access$100(NetLivenessReqResultState.this, hashMap, exc);
                NetLivenessReqResultState.access$200(NetLivenessReqResultState.this);
                AppMethodBeat.o(187191);
            }
        });
        AppMethodBeat.o(187214);
    }
}

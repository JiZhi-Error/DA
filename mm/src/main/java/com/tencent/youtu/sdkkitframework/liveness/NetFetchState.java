package com.tencent.youtu.sdkkitframework.liveness;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.youtu.sdkkitframework.liveness.YtLivenessNetProtoHelper;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetFetchState extends YtFSMBaseState {
    private static final String TAG = NetFetchState.class.getSimpleName();
    private String actionSeqData = "";
    private String appId;
    private int backendProtoType = 0;
    private int changePointNum = 2;
    private String configUrl;
    private String controlConfig = "";
    private String extraConfig = "";
    private String localColorData = "";
    private boolean needLocalConfig = false;
    private JSONObject selectData = null;

    interface NetworkCallback {
        void onFailed(int i2, String str);

        void onSucceed(String str);
    }

    static {
        AppMethodBeat.i(187187);
        AppMethodBeat.o(187187);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void loadStateWith(String str, JSONObject jSONObject) {
        AppMethodBeat.i(187180);
        super.loadStateWith(str, jSONObject);
        try {
            this.appId = jSONObject.getString("app_id");
            if (this.appId == null) {
                YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_PARAM_ERROR, "yt_param_error");
            }
            if (jSONObject.has("config_api_url")) {
                this.configUrl = jSONObject.getString("config_api_url");
            }
            if (jSONObject.has("color_data")) {
                this.localColorData = jSONObject.getString("color_data");
            }
            if (jSONObject.has("local_config_flag")) {
                this.needLocalConfig = jSONObject.getBoolean("local_config_flag");
            }
            if (jSONObject.has("action_default_seq")) {
                JSONArray jSONArray = jSONObject.getJSONArray("action_default_seq");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.actionSeqData += jSONArray.getString(i2);
                    if (i2 < jSONArray.length() - 1) {
                        this.actionSeqData += ",";
                    }
                }
            } else {
                this.actionSeqData = AppEventsConstants.EVENT_PARAM_VALUE_NO;
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
            if (jSONObject.has("select_data")) {
                this.selectData = jSONObject.getJSONObject("select_data");
            }
            if (jSONObject.has("backend_proto_type")) {
                this.backendProtoType = jSONObject.getInt("backend_proto_type");
            }
            if (jSONObject.has("net_request_timeout_ms")) {
                YtSDKKitFramework.getInstance().setNetworkRequestTimeoutMS(jSONObject.getInt("net_request_timeout_ms"));
            }
            AppMethodBeat.o(187180);
        } catch (JSONException e2) {
            YtLogger.e(TAG, "Failed to parse json:" + e2.getLocalizedMessage());
            AppMethodBeat.o(187180);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void unload() {
        AppMethodBeat.i(187181);
        super.unload();
        AppMethodBeat.o(187181);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        AppMethodBeat.i(187182);
        super.enter();
        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
            /* class com.tencent.youtu.sdkkitframework.liveness.NetFetchState.AnonymousClass1 */

            {
                AppMethodBeat.i(187170);
                put(StateEvent.Name.UI_TIPS, StringCode.NET_FETCH_DATA);
                AppMethodBeat.o(187170);
            }
        });
        switch (YtFSM.getInstance().getWorkMode()) {
            case YT_FW_OCR_TYPE:
                AppMethodBeat.o(187182);
                return;
            case YT_FW_SILENT_TYPE:
            case YT_FW_ACTION_TYPE:
            case YT_FW_REFLECT_TYPE:
            case YT_FW_LIPREAD_TYPE:
            case YT_FW_ACTREFLECT_TYPE:
                onReflectRequest();
                break;
        }
        AppMethodBeat.o(187182);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void reset() {
        AppMethodBeat.i(187183);
        super.reset();
        AppMethodBeat.o(187183);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void exit() {
        AppMethodBeat.i(187184);
        super.exit();
        AppMethodBeat.o(187184);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void moveToNextState() {
        AppMethodBeat.i(187185);
        super.moveToNextState();
        try {
            switch (YtFSM.getInstance().getWorkMode()) {
                case YT_FW_SILENT_TYPE:
                case YT_FW_ACTION_TYPE:
                case YT_FW_REFLECT_TYPE:
                case YT_FW_LIPREAD_TYPE:
                case YT_FW_ACTREFLECT_TYPE:
                    YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
                    AppMethodBeat.o(187185);
                    return;
                default:
                    final String str = "Unknown work mode " + YtFSM.getInstance().getWorkMode();
                    YtSDKStats.getInstance().reportError(4194304, str);
                    YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                        /* class com.tencent.youtu.sdkkitframework.liveness.NetFetchState.AnonymousClass2 */

                        {
                            AppMethodBeat.i(187171);
                            put("ui_error", 4194304);
                            put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                            put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                            put("error_code", 4194304);
                            put("message", CommonUtils.makeMessageJson(4194304, StringCode.MSG_PARAM_ERROR, str));
                            AppMethodBeat.o(187171);
                        }
                    });
                    AppMethodBeat.o(187185);
                    return;
            }
        } catch (Exception e2) {
            YtLogger.e(TAG, "move to next stat failed " + e2.getLocalizedMessage());
            AppMethodBeat.o(187185);
        }
    }

    private void onReflectRequest() {
        AppMethodBeat.i(187186);
        YTAGReflectLiveCheckInterface.getLiveCheckType(YtFSM.getInstance().getContext().currentAppContext, new YTAGReflectLiveCheckInterface.GetLiveStyleResult() {
            /* class com.tencent.youtu.sdkkitframework.liveness.NetFetchState.AnonymousClass3 */

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.GetLiveStyleResult
            public void onSuccess(LiveStyleRequester.YTLiveStyleReq yTLiveStyleReq, LiveStyleResponse liveStyleResponse) {
                String makeGetLiveTypeReq;
                AppMethodBeat.i(187177);
                NetFetchState.this.stateData.put("select_data", yTLiveStyleReq.select_data);
                if ((NetFetchState.this.localColorData.isEmpty() || !NetFetchState.this.needLocalConfig) && NetFetchState.this.configUrl != null) {
                    if (NetFetchState.this.backendProtoType == 2 || YtFSM.getInstance().getWorkMode() != YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE) {
                        YtLivenessNetProtoHelper.GetLiveTypeReqData getLiveTypeReqData = new YtLivenessNetProtoHelper.GetLiveTypeReqData();
                        getLiveTypeReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
                        getLiveTypeReqData.baseInfo.appId = NetFetchState.this.appId;
                        getLiveTypeReqData.baseInfo.businessId = "wx_default";
                        getLiveTypeReqData.baseInfo.lux = yTLiveStyleReq.select_data.android_data.lux;
                        getLiveTypeReqData.reflectConfig = NetFetchState.this.extraConfig;
                        getLiveTypeReqData.controlConfig = NetFetchState.this.controlConfig;
                        getLiveTypeReqData.colorNum = NetFetchState.this.changePointNum;
                        makeGetLiveTypeReq = YtLivenessNetProtoHelper.makeGetLiveTypeReq(getLiveTypeReqData);
                    } else {
                        YtLivenessNetProtoHelper.GetFourLiveTypeReqData getFourLiveTypeReqData = new YtLivenessNetProtoHelper.GetFourLiveTypeReqData();
                        getFourLiveTypeReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
                        getFourLiveTypeReqData.baseInfo.appId = NetFetchState.this.appId;
                        makeGetLiveTypeReq = YtLivenessNetProtoHelper.makeGetFourLiveReq(getFourLiveTypeReqData);
                    }
                    YtLogger.i(NetFetchState.TAG, "Use online data ---> on get config info: ".concat(String.valueOf(makeGetLiveTypeReq)));
                    YtFSM.getInstance().sendNetworkRequest(StringCode.NET_FETCH_DATA, NetFetchState.this.configUrl, makeGetLiveTypeReq, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser() {
                        /* class com.tencent.youtu.sdkkitframework.liveness.NetFetchState.AnonymousClass3.AnonymousClass1 */

                        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0098, code lost:
                            r4 = r3.getString("validate_data");
                         */
                        @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void onNetworkResponseEvent(java.util.HashMap<java.lang.String, java.lang.String> r11, final java.lang.Exception r12) {
                            /*
                            // Method dump skipped, instructions count: 775
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.sdkkitframework.liveness.NetFetchState.AnonymousClass3.AnonymousClass1.onNetworkResponseEvent(java.util.HashMap, java.lang.Exception):void");
                        }
                    });
                    AppMethodBeat.o(187177);
                    return;
                }
                YtLogger.i(NetFetchState.TAG, "Use local data");
                NetFetchState.this.stateData.put("color_data", NetFetchState.this.localColorData);
                NetFetchState.this.stateData.put("action_data", NetFetchState.this.actionSeqData);
                YtLogger.d(NetFetchState.TAG, "select data:" + NetFetchState.this.selectData);
                if (NetFetchState.this.selectData != null) {
                    try {
                        if (NetFetchState.this.selectData.has("config")) {
                            NetFetchState.this.stateData.put("control_config", NetFetchState.this.selectData.getString("config"));
                        }
                        if (NetFetchState.this.selectData.has("reflect_param")) {
                            NetFetchState.this.stateData.put("extra_config", NetFetchState.this.selectData.getString("reflect_param"));
                        }
                        if (NetFetchState.this.selectData.has("change_point_num")) {
                            NetFetchState.this.stateData.put("cp_num", NetFetchState.this.selectData.getString("change_point_num"));
                        }
                    } catch (JSONException e2) {
                        String str = "Select data parse failed " + e2.getLocalizedMessage();
                        YtLogger.e(NetFetchState.TAG, str);
                        YtSDKStats.getInstance().reportInfo(str);
                    }
                } else {
                    YtLogger.e(NetFetchState.TAG, "select data is null");
                    YtSDKStats.getInstance().reportInfo("select data is null");
                }
                NetFetchState.this.moveToNextState();
                AppMethodBeat.o(187177);
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.GetLiveStyleResult
            public void onFailed(final int i2, final String str, final String str2) {
                AppMethodBeat.i(187178);
                YtLogger.e(NetFetchState.TAG, "network failed " + str + " fix " + str2);
                YtSDKStats.getInstance().reportError(i2, str);
                YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                    /* class com.tencent.youtu.sdkkitframework.liveness.NetFetchState.AnonymousClass3.AnonymousClass2 */

                    {
                        AppMethodBeat.i(187176);
                        put("ui_error", Integer.valueOf(i2));
                        put(StateEvent.Name.UI_TIPS, StringCode.NET_FETCH_FAILED);
                        put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
                        put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_NETWORK_ERROR));
                        put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_NETWORK_ERROR, StringCode.MSG_NET_ERROR, "msg_net_error " + str + " " + str2));
                        AppMethodBeat.o(187176);
                    }
                });
                AppMethodBeat.o(187178);
            }
        });
        AppMethodBeat.o(187186);
    }
}

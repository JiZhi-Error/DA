package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class YtSDKKitConfigHelper {
    private static final HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String> SDK_SETTINGS = new HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String>() {
        /* class com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.AnonymousClass1 */

        {
            AppMethodBeat.i(192663);
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_OCR_TYPE, "ocr_settings");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE, "silent_settings");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE, "action_settings");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_REFLECT_TYPE, "reflect_settings");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE, "action+reflect_settings");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE, "lipread_settings");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_DETECTONLY_TYPE, "detectonly_settings");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_OCR_VIID_TYPE, "ocr_video_ident_settings");
            AppMethodBeat.o(192663);
        }
    };
    private static final String TAG = YtSDKKitConfigHelper.class.getSimpleName();
    private static final HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String> UI_SETTINGS = new HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String>() {
        /* class com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.AnonymousClass2 */

        {
            AppMethodBeat.i(192665);
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_OCR_TYPE, "ocr_card_ui");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE, "silent_ui");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE, "action_ui");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_REFLECT_TYPE, "reflect_ui");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE, "action+reflect_ui");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE, "lipread_ui");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_DETECTONLY_TYPE, "detectonly_ui");
            put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_OCR_VIID_TYPE, "ocr_video_ident_ui");
            AppMethodBeat.o(192665);
        }
    };

    static {
        AppMethodBeat.i(192679);
        AppMethodBeat.o(192679);
    }

    public static JSONObject getSDKConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, JSONObject jSONObject) {
        JSONObject jSONObject2;
        AppMethodBeat.i(192673);
        try {
            jSONObject2 = jSONObject.getJSONObject(SDK_SETTINGS.get(ytSDKKitFrameworkWorkMode));
        } catch (JSONException e2) {
            YtLogger.e(TAG, e2.getMessage());
            jSONObject2 = null;
        }
        AppMethodBeat.o(192673);
        return jSONObject2;
    }

    public static void setSDKConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, JSONObject jSONObject, JSONObject jSONObject2) {
        AppMethodBeat.i(192674);
        try {
            jSONObject.put(SDK_SETTINGS.get(ytSDKKitFrameworkWorkMode), jSONObject2);
            AppMethodBeat.o(192674);
        } catch (JSONException e2) {
            YtLogger.e(TAG, e2.getMessage());
            AppMethodBeat.o(192674);
        }
    }

    public static void setUIConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, JSONObject jSONObject, JSONObject jSONObject2) {
        AppMethodBeat.i(192675);
        try {
            jSONObject.put(UI_SETTINGS.get(ytSDKKitFrameworkWorkMode), jSONObject2);
            AppMethodBeat.o(192675);
        } catch (JSONException e2) {
            YtLogger.e(TAG, e2.getMessage());
            AppMethodBeat.o(192675);
        }
    }

    public static JSONObject getUIConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, JSONObject jSONObject) {
        JSONObject jSONObject2;
        AppMethodBeat.i(192676);
        try {
            jSONObject2 = jSONObject.getJSONObject(UI_SETTINGS.get(ytSDKKitFrameworkWorkMode));
        } catch (JSONException e2) {
            YtLogger.e(TAG, e2.getMessage());
            jSONObject2 = null;
        }
        AppMethodBeat.o(192676);
        return jSONObject2;
    }

    public static ArrayList<String> getPipleStateNames(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode) {
        AppMethodBeat.i(192677);
        ArrayList<String> arrayList = null;
        switch (ytSDKKitFrameworkWorkMode) {
            case YT_FW_OCR_TYPE:
                arrayList = new ArrayList<String>() {
                    /* class com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.AnonymousClass3 */

                    {
                        AppMethodBeat.i(192666);
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_AUTO_DETECT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_MANUAL_DETECT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_OCR_REQ_RESULT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
                        AppMethodBeat.o(192666);
                    }
                };
                break;
            case YT_FW_SILENT_TYPE:
            case YT_FW_ACTION_TYPE:
                arrayList = new ArrayList<String>() {
                    /* class com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.AnonymousClass4 */

                    {
                        AppMethodBeat.i(192667);
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
                        AppMethodBeat.o(192667);
                    }
                };
                break;
            case YT_FW_REFLECT_TYPE:
                arrayList = new ArrayList<String>() {
                    /* class com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.AnonymousClass5 */

                    {
                        AppMethodBeat.i(192668);
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
                        AppMethodBeat.o(192668);
                    }
                };
                break;
            case YT_FW_ACTREFLECT_TYPE:
                arrayList = new ArrayList<String>() {
                    /* class com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.AnonymousClass6 */

                    {
                        AppMethodBeat.i(192669);
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
                        AppMethodBeat.o(192669);
                    }
                };
                break;
            case YT_FW_LIPREAD_TYPE:
                arrayList = new ArrayList<String>() {
                    /* class com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.AnonymousClass7 */

                    {
                        AppMethodBeat.i(192670);
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.LIPREAD_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
                        AppMethodBeat.o(192670);
                    }
                };
                break;
            case YT_FW_DETECTONLY_TYPE:
                arrayList = new ArrayList<String>() {
                    /* class com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.AnonymousClass8 */

                    {
                        AppMethodBeat.i(192671);
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.DETECTONLY_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                        AppMethodBeat.o(192671);
                    }
                };
                break;
            case YT_FW_OCR_VIID_TYPE:
                arrayList = new ArrayList<String>() {
                    /* class com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.AnonymousClass9 */

                    {
                        AppMethodBeat.i(192672);
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_VIID_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_OCR_REQ_RESULT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                        AppMethodBeat.o(192672);
                    }
                };
                break;
        }
        AppMethodBeat.o(192677);
        return arrayList;
    }

    public static String getConfigStringBy(JSONObject jSONObject, String str, boolean z) {
        AppMethodBeat.i(192678);
        String str2 = null;
        try {
            str2 = jSONObject.getString(str);
        } catch (JSONException e2) {
            YtLogger.e(TAG, "Parse json object failed " + e2.getLocalizedMessage());
        }
        if (z && (str2 == null || str2.equals(""))) {
            YtLogger.e(TAG, "Parse json object failed " + str + "参数解析失败, 不存在或者不能为空");
            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_JSON_PARAM_ERROR, StringCode.MSG_PARAM_ERROR);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.FAILED);
            hashMap.put("error_code", Integer.valueOf((int) ErrorCode.YT_SDK_JSON_PARAM_ERROR));
            hashMap.put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_JSON_PARAM_ERROR, StringCode.MSG_PARAM_ERROR, str + "参数解析失败, 不存在或者不能为空"));
            YtFSM.getInstance().sendFSMEvent(hashMap);
        }
        AppMethodBeat.o(192678);
        return str2;
    }
}

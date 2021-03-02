package com.tencent.mm.hardcoder;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.hardcoder.c;
import com.tencent.mm.hardcoder.d;
import com.tencent.mm.hardcoder.e;
import com.tencent.mm.hardcoder.h;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WXHardCoderJNI extends g {
    public static final Map<Integer, Integer> APP_SCENE_ID_MAP = new HashMap();
    public static final int FUNC_GET_PARAMETERS = 1019;
    public static final int GETPARAMETERS_TYPE_BASE = 0;
    public static final int GETPARAMETERS_TYPE_CAMERA_VENDOR_TAG = 2;
    public static final int GETPARAMETERS_TYPE_CODECDESP = 3;
    public static final int GETPARAMETERS_TYPE_QP_MEDIACODEC = 1;
    public static final boolean HC_ENABLE_FOR_TEST = false;
    public static final String KEY_HC_BEGIN_TIME_HOUR = "KEY_HC_BEGIN_TIME_HOUR";
    public static final String KEY_HC_BEGIN_TIME_MIN = "KEY_HC_BEGIN_TIME_MIN";
    public static final String KEY_HC_BG_ENABLE = "KEY_HC_BG_ENABLE";
    public static final String KEY_HC_DEBUG = "KEY_HC_DEBUG";
    public static final String KEY_HC_ENABLE = "KEY_HC_ENABLE";
    public static final String KEY_HC_END_TIME_HOUR = "KEY_HC_END_TIME_HOUR";
    public static final String KEY_HC_END_TIME_MIN = "KEY_HC_END_TIME_MIN";
    public static final String KEY_HC_KV_FT = "KEY_HC_KV_FT";
    public static final String KEY_HC_KV_PER = "KEY_HC_KV_PER";
    public static final String KEY_HC_RETRY_INTERVAL = "KEY_HC_RETRY_INTERVAL";
    public static final String KEY_HC_TIMEOUT_MARGIN = "KEY_HC_TIMEOUT_MARGIN";
    public static final String KEY_HC_TIME_LIMIT = "KEY_HC_TIME_LIMIT";
    public static final String KEY_HC_UIN_HASH = "KEY_HC_UIN_HASH";
    public static final Map<Integer, Integer> SCENE_ID_MAP = new HashMap();
    public static final String SETTING_SP_FILE = "hardcoder_setting";
    public static final String SETTING_UI_ACTION = "com.tencent.mm.action.HARDCODER_SETTING";
    public static final boolean SETTING_UI_ENABLE = false;
    public static final int SYSTEM_EVENT_BASE = 0;
    public static final int SYSTEM_EVENT_BLUETOOTH_ACCEPTCALL = 3;
    public static final int SYSTEM_EVENT_BLUETOOTH_HANGUPCALL = 4;
    public static final String SYSTEM_EVENT_CODE = "system_event_code";
    public static final int SYSTEM_EVENT_SLIDE_CLOSE = 2;
    public static final int SYSTEM_EVENT_SLIDE_OPEN = 1;
    public static final boolean S_HCDEBUG = false;
    private static final String TAG = "MicroMsg.WXHardCoderJNI";
    public static HashMap<Long, String> flagKeyMap = new HashMap<>();
    public static boolean foreground = false;
    private static c.b funcRet = new c.b() {
        /* class com.tencent.mm.hardcoder.WXHardCoderJNI.AnonymousClass4 */

        @Override // com.tencent.mm.hardcoder.c.b
        public final void onFuncRet(int i2, long j2, int i3, int i4, int i5, byte[] bArr) {
            JSONException e2;
            JSONObject jSONObject;
            int i6 = 0;
            AppMethodBeat.i(155950);
            Log.i(WXHardCoderJNI.TAG, "FuncRetCallback callbackType:" + i2 + ", requestId:" + j2 + ", retCode:" + i3 + ", funcId:" + i4 + ", dataType:" + i5);
            if (i2 == 2) {
                switch (i4) {
                    case HardCoderJNI.FUNC_REG_SYSTEM_EVENT_CALLBACK:
                        if (WXHardCoderJNI.systemEventCallback != null) {
                            try {
                                int optInt = new JSONObject(new String(bArr)).optInt(WXHardCoderJNI.SYSTEM_EVENT_CODE, 0);
                                Log.i(WXHardCoderJNI.TAG, "onData SYSTEM_EVENT_CODE: ".concat(String.valueOf(optInt)));
                                WXHardCoderJNI.systemEventCallback.onEvent(optInt);
                                AppMethodBeat.o(155950);
                                return;
                            } catch (JSONException e3) {
                                Log.i(WXHardCoderJNI.TAG, "onData parse system event e:" + e3.getMessage());
                                AppMethodBeat.o(155950);
                                return;
                            }
                        }
                        break;
                    case 1019:
                        if (WXHardCoderJNI.getParametersCallback != null) {
                            try {
                                jSONObject = new JSONObject(new String(bArr));
                                try {
                                    i6 = jSONObject.getInt("getparameterstype");
                                } catch (JSONException e4) {
                                    e2 = e4;
                                    Log.i(WXHardCoderJNI.TAG, "onData parse get parameters e:" + e2.getMessage());
                                    Log.i(WXHardCoderJNI.TAG, "onData GET_PARAMETERS: " + jSONObject + ", type:" + i6);
                                    WXHardCoderJNI.getParametersCallback.onGetParameters(i6, jSONObject);
                                    AppMethodBeat.o(155950);
                                }
                            } catch (JSONException e5) {
                                e2 = e5;
                                jSONObject = null;
                                Log.i(WXHardCoderJNI.TAG, "onData parse get parameters e:" + e2.getMessage());
                                Log.i(WXHardCoderJNI.TAG, "onData GET_PARAMETERS: " + jSONObject + ", type:" + i6);
                                WXHardCoderJNI.getParametersCallback.onGetParameters(i6, jSONObject);
                                AppMethodBeat.o(155950);
                            }
                            Log.i(WXHardCoderJNI.TAG, "onData GET_PARAMETERS: " + jSONObject + ", type:" + i6);
                            WXHardCoderJNI.getParametersCallback.onGetParameters(i6, jSONObject);
                        }
                }
            }
            AppMethodBeat.o(155950);
        }
    };
    private static GetParametersCallback getParametersCallback = null;
    private static h.a hardCoderReporterInfo = null;
    public static int hcBeginTimeHour = 8;
    public static int hcBeginTimeMin = 0;
    public static boolean hcBgEnable = true;
    public static int hcEndTimeHour = 23;
    public static int hcEndTimeMin = 0;
    public static boolean hcKVFtReport = sHCREPORT;
    public static boolean hcKVPerReport = false;
    public static int hcRetryInterval = 30;
    public static boolean hcTimeLimit = false;
    public static int hcTimeoutMargin = 0;
    public static int hcUinHash = 0;
    private static boolean needMapAPPScene = false;
    private static Method sGetStringPropsMethod = null;
    public static final int sHCBEGINHOUR = 8;
    public static final int sHCBEGINMIN = 0;
    public static final boolean sHCBGENABLE = true;
    public static final boolean sHCENABLE = true;
    public static final int sHCENDHOUR = 23;
    public static final int sHCENDMIN = 0;
    public static boolean sHCREPORT = false;
    public static final boolean sHCTIMELIMIT = false;
    public static final int sHCUINHASH = 0;
    public static final int sRETRYINTERVAL = 30;
    private static volatile Class<?> sSystemPropertiesClazz = null;
    public static final int sTIMEOUTMARGIN = 0;
    private static c.d sceneReportCallback = new c.d() {
        /* class com.tencent.mm.hardcoder.WXHardCoderJNI.AnonymousClass3 */

        @Override // com.tencent.mm.hardcoder.c.d
        public final void sceneReport(int i2, long j2) {
            AppMethodBeat.i(155949);
            if (WXHardCoderJNI.needMapAPPScene) {
                AppMethodBeat.o(155949);
                return;
            }
            Integer num = WXHardCoderJNI.SCENE_ID_MAP.get(Integer.valueOf(i2));
            if (num == null) {
                AppMethodBeat.o(155949);
                return;
            }
            WXHardCoderJNI.access$100(new j(num.intValue()));
            AppMethodBeat.o(155949);
        }
    };
    private static SystemEventCallback systemEventCallback;
    private static d.a wxHardCoderLog = new d.a() {
        /* class com.tencent.mm.hardcoder.WXHardCoderJNI.AnonymousClass1 */

        @Override // com.tencent.mm.hardcoder.d.a
        public final void i(String str, String str2) {
            AppMethodBeat.i(155944);
            Log.i(str, str2);
            AppMethodBeat.o(155944);
        }

        @Override // com.tencent.mm.hardcoder.d.a
        public final void d(String str, String str2) {
            AppMethodBeat.i(155945);
            Log.d(str, str2);
            AppMethodBeat.o(155945);
        }

        @Override // com.tencent.mm.hardcoder.d.a
        public final void e(String str, String str2) {
            AppMethodBeat.i(155946);
            Log.e(str, str2);
            AppMethodBeat.o(155946);
        }

        @Override // com.tencent.mm.hardcoder.d.a
        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.i(155947);
            Log.printErrStackTrace(str, th, str2, objArr);
            AppMethodBeat.o(155947);
        }
    };

    public interface GetParametersCallback {
        void onGetParameters(int i2, JSONObject jSONObject);
    }

    public interface SystemEventCallback {
        void onEvent(int i2);
    }

    static /* synthetic */ void access$100(h hVar) {
        AppMethodBeat.i(155975);
        reportInfo(hVar);
        AppMethodBeat.o(155975);
    }

    static {
        AppMethodBeat.i(155976);
        initSceneAndFlagMap();
        reloadSPConfig(RELOAD_SCENE_INIT);
        AppMethodBeat.o(155976);
    }

    public static boolean isCheckEnv() {
        AppMethodBeat.i(155951);
        boolean isCheckEnv = HardCoderJNI.isCheckEnv();
        AppMethodBeat.o(155951);
        return isCheckEnv;
    }

    public static boolean getDebug() {
        AppMethodBeat.i(155952);
        boolean isHcDebug = HardCoderJNI.isHcDebug();
        AppMethodBeat.o(155952);
        return isHcDebug;
    }

    public static boolean getEnable() {
        AppMethodBeat.i(155953);
        boolean isHcEnable = HardCoderJNI.isHcEnable();
        AppMethodBeat.o(155953);
        return isHcEnable;
    }

    public static void setHcEnable(boolean z) {
        AppMethodBeat.i(155954);
        HardCoderJNI.setHcEnable(z);
        AppMethodBeat.o(155954);
    }

    public static void setDebug(boolean z) {
        AppMethodBeat.i(155955);
        HardCoderJNI.setHcDebug(z);
        AppMethodBeat.o(155955);
    }

    public static long terminateApp(int i2, long j2) {
        AppMethodBeat.i(155956);
        long terminateApp = HardCoderJNI.terminateApp(i2, j2);
        AppMethodBeat.o(155956);
        return terminateApp;
    }

    public static void setRetryConnectInterval(int i2) {
        AppMethodBeat.i(155957);
        HardCoderJNI.setRetryConnectInterval(i2);
        AppMethodBeat.o(155957);
    }

    public static int isRunning() {
        AppMethodBeat.i(155958);
        int isRunning = HardCoderJNI.isRunning();
        AppMethodBeat.o(155958);
        return isRunning;
    }

    public static int startPerformance(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, long j2, String str) {
        int i8;
        Integer num;
        AppMethodBeat.i(155959);
        if (!z) {
            AppMethodBeat.o(155959);
            return -3;
        } else if (hcBgEnable || foreground) {
            if (!needMapAPPScene || (num = APP_SCENE_ID_MAP.get(Integer.valueOf(i7))) == null) {
                i8 = i7;
            } else {
                i8 = num.intValue();
            }
            int startPerformance = HardCoderJNI.startPerformance(i2, i3, i4, i5, i6 + hcTimeoutMargin, i8, j2, Process.myTid(), str);
            AppMethodBeat.o(155959);
            return startPerformance;
        } else {
            AppMethodBeat.o(155959);
            return -4;
        }
    }

    public static int stopPerformance(boolean z, int i2) {
        AppMethodBeat.i(155960);
        if (!z) {
            AppMethodBeat.o(155960);
            return -3;
        }
        int stopPerformance = HardCoderJNI.stopPerformance(i2);
        AppMethodBeat.o(155960);
        return stopPerformance;
    }

    private WXHardCoderJNI() {
    }

    public static void reloadSPConfig(int i2) {
        boolean z;
        AppMethodBeat.i(155961);
        boolean checkHardCoderEnv = checkHardCoderEnv();
        HardCoderJNI.setCheckEnv(checkHardCoderEnv);
        if (!checkHardCoderEnv) {
            Log.e(TAG, "reloadSPConfig hcEnv is false.");
            AppMethodBeat.o(155961);
            return;
        }
        setDebug(false);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences(SETTING_SP_FILE, 0);
        HardCoderJNI.setHcEnable(sharedPreferences.getBoolean(KEY_HC_ENABLE, true));
        hcBgEnable = sharedPreferences.getBoolean(KEY_HC_BG_ENABLE, true);
        hcUinHash = sharedPreferences.getInt(KEY_HC_UIN_HASH, 0);
        HardCoderJNI.setHcDebug(sharedPreferences.getBoolean(KEY_HC_DEBUG, false));
        Log.i(TAG, "reloadSPConfig scene:%d, hcDebug:%b, hcEnable:%b, hcUinHash:%d, checkEnv:%b, stack[%s]", Integer.valueOf(i2), Boolean.valueOf(HardCoderJNI.isHcDebug()), Boolean.valueOf(HardCoderJNI.isHcEnable()), Integer.valueOf(hcUinHash), Boolean.valueOf(HardCoderJNI.isCheckEnv()), Util.getStack());
        hcRetryInterval = sharedPreferences.getInt(KEY_HC_RETRY_INTERVAL, 30);
        hcKVPerReport = sharedPreferences.getInt(KEY_HC_KV_PER, 0) < hcUinHash;
        if (sharedPreferences.getInt(KEY_HC_KV_FT, 0) < hcUinHash) {
            z = true;
        } else {
            z = false;
        }
        hcKVFtReport = z;
        hcTimeoutMargin = sharedPreferences.getInt(KEY_HC_TIMEOUT_MARGIN, 0);
        hcTimeLimit = sharedPreferences.getBoolean(KEY_HC_TIME_LIMIT, false);
        hcBeginTimeHour = sharedPreferences.getInt(KEY_HC_BEGIN_TIME_HOUR, 8);
        hcBeginTimeMin = sharedPreferences.getInt(KEY_HC_BEGIN_TIME_MIN, 0);
        hcEndTimeHour = sharedPreferences.getInt(KEY_HC_END_TIME_HOUR, 23);
        hcEndTimeMin = sharedPreferences.getInt(KEY_HC_END_TIME_MIN, 0);
        hcBootEnable = sharedPreferences.getBoolean(g.KEY_HC_BOOT_ENABLE, true);
        hcBootDelay = sharedPreferences.getInt(g.KEY_HC_BOOT_DELEY, 0);
        hcBootCPU = sharedPreferences.getInt(g.KEY_HC_BOOT_CPU, 1);
        hcBootIO = sharedPreferences.getInt(g.KEY_HC_BOOT_IO, 0);
        hcBootThr = sharedPreferences.getBoolean(g.KEY_HC_BOOT_THR, false);
        hcBootTimeout = sharedPreferences.getInt(g.KEY_HC_BOOT_TIMEOUT, 5000);
        hcBootAction = sharedPreferences.getLong(g.KEY_HC_BOOT_ACTION, 4);
        hcEnterChattingEnable = sharedPreferences.getBoolean(g.KEY_HC_ENTER_CHATTING_ENABLE, true);
        hcEnterChattingDelay = sharedPreferences.getInt(g.KEY_HC_ENTER_CHATTING_DELEY, 0);
        hcEnterChattingCPU = sharedPreferences.getInt(g.KEY_HC_ENTER_CHATTING_CPU, 1);
        hcEnterChattingIO = sharedPreferences.getInt(g.KEY_HC_ENTER_CHATTING_IO, 1);
        hcEnterChattingThr = sharedPreferences.getBoolean(g.KEY_HC_ENTER_CHATTING_THR, false);
        hcEnterChattingTimeout = sharedPreferences.getInt(g.KEY_HC_ENTER_CHATTING_TIMEOUT, 1000);
        hcEnterChattingAction = sharedPreferences.getLong(g.KEY_HC_ENTER_CHATTING_ACTION, g.sHCENTERCHATTINGACTION);
        hcQuitChattingEnable = sharedPreferences.getBoolean(g.KEY_HC_QUIT_CHATTING_ENABLE, true);
        hcQuitChattingDelay = sharedPreferences.getInt(g.KEY_HC_QUIT_CHATTING_DELEY, 0);
        hcQuitChattingCPU = sharedPreferences.getInt(g.KEY_HC_QUIT_CHATTING_CPU, 2);
        hcQuitChattingIO = sharedPreferences.getInt(g.KEY_HC_QUIT_CHATTING_IO, 2);
        hcQuitChattingThr = sharedPreferences.getBoolean(g.KEY_HC_QUIT_CHATTING_THR, false);
        hcQuitChattingTimeout = sharedPreferences.getInt(g.KEY_HC_QUIT_CHATTING_TIMEOUT, 800);
        hcQuitChattingAction = sharedPreferences.getLong(g.KEY_HC_QUIT_CHATTING_ACTION, g.sHCQUITCHATTINGACTION);
        hcSendMsgEnable = sharedPreferences.getBoolean(g.KEY_HC_SEND_MSG_ENABLE, true);
        hcSendMsgDelay = sharedPreferences.getInt(g.KEY_HC_SEND_MSG_DELEY, 0);
        hcSendMsgCPU = sharedPreferences.getInt(g.KEY_HC_SEND_MSG_CPU, 3);
        hcSendMsgIO = sharedPreferences.getInt(g.KEY_HC_SEND_MSG_IO, 0);
        hcSendMsgThr = sharedPreferences.getBoolean(g.KEY_HC_SEND_MSG_THR, true);
        hcSendMsgTimeout = sharedPreferences.getInt(g.KEY_HC_SEND_MSG_TIMEOUT, 1000);
        hcSendMsgAction = sharedPreferences.getLong(g.KEY_HC_SEND_MSG_ACTION, 12288);
        hcSendPicMsgEnable = sharedPreferences.getBoolean(g.KEY_HC_SEND_PIC_MSG_ENABLE, true);
        hcSendPicMsgDelay = sharedPreferences.getInt(g.KEY_HC_SEND_PIC_MSG_DELEY, 0);
        hcSendPicMsgCPU = sharedPreferences.getInt(g.KEY_HC_SEND_PIC_MSG_CPU, 1);
        hcSendPicMsgIO = sharedPreferences.getInt(g.KEY_HC_SEND_PIC_MSG_IO, 2);
        hcSendPicMsgThr = sharedPreferences.getBoolean(g.KEY_HC_SEND_PIC_MSG_THR, true);
        hcSendPicMsgTimeout = sharedPreferences.getInt(g.KEY_HC_SEND_PIC_MSG_TIMEOUT, 500);
        hcSendPicMsgAction = sharedPreferences.getLong(g.KEY_HC_SEND_PIC_MSG_ACTION, g.sHCSENDPICMSGACTION);
        hcReceiveMsgEnable = sharedPreferences.getBoolean(g.KEY_HC_RECEIVE_MSG_ENABLE, true);
        hcReceiveMsgDelay = sharedPreferences.getInt(g.KEY_HC_RECEIVE_MSG_DELEY, 500);
        hcReceiveMsgCPU = sharedPreferences.getInt(g.KEY_HC_RECEIVE_MSG_CPU, 2);
        hcReceiveMsgIO = sharedPreferences.getInt(g.KEY_HC_RECEIVE_MSG_IO, 2);
        hcReceiveMsgThr = sharedPreferences.getBoolean(g.KEY_HC_RECEIVE_MSG_THR, true);
        hcReceiveMsgTimeout = sharedPreferences.getInt(g.KEY_HC_RECEIVE_MSG_TIMEOUT, 1000);
        hcReceiveMsgAction = sharedPreferences.getLong(g.KEY_HC_RECEIVE_MSG_ACTION, 127040);
        hcUpdateChatroomEnable = sharedPreferences.getBoolean(g.KEY_HC_UPDATE_CHATROOM_ENABLE, true);
        hcUpdateChatroomDelay = sharedPreferences.getInt(g.KEY_HC_UPDATE_CHATROOM_DELEY, 0);
        hcUpdateChatroomCPU = sharedPreferences.getInt(g.KEY_HC_UPDATE_CHATROOM_CPU, 2);
        hcUpdateChatroomIO = sharedPreferences.getInt(g.KEY_HC_UPDATE_CHATROOM_IO, 2);
        hcUpdateChatroomThr = sharedPreferences.getBoolean(g.KEY_HC_UPDATE_CHATROOM_THR, true);
        hcUpdateChatroomTimeout = sharedPreferences.getInt(g.KEY_HC_UPDATE_CHATROOM_TIMEOUT, 1000);
        hcUpdateChatroomAction = sharedPreferences.getLong(g.KEY_HC_UPDATE_CHATROOM_ACTION, 127040);
        hcUpdateChatroomMemberCount = sharedPreferences.getLong(g.KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT, 50);
        hcDBEnable = sharedPreferences.getBoolean(g.KEY_HC_DB_ENABLE, false);
        hcDBDelayQuery = sharedPreferences.getInt(g.KEY_HC_DB_DELEY_QUERY, 100);
        hcDBDelayWrite = sharedPreferences.getInt(g.KEY_HC_DB_DELEY_WRITE, 200);
        hcDBCPU = sharedPreferences.getInt(g.KEY_HC_DB_CPU, 2);
        hcDBIO = sharedPreferences.getInt(g.KEY_HC_DB_IO, 2);
        hcDBThr = sharedPreferences.getBoolean(g.KEY_HC_DB_THR, false);
        hcDBTimeout = sharedPreferences.getInt(g.KEY_HC_DB_TIMEOUT, 500);
        hcDBTimeoutBusy = sharedPreferences.getInt(g.KEY_HC_DB_TIMEOUT_BUSY, 5000);
        hcDBActionQuery = sharedPreferences.getLong(g.KEY_HC_DB_ACTION_QUERY, 4096);
        hcDBActionWrite = sharedPreferences.getLong(g.KEY_HC_DB_ACTION_WRITE, 12288);
        hcEncodeVideoEnable = sharedPreferences.getBoolean(g.KEY_HC_ENCODE_VIDEO_ENABLE, true);
        hcEncodeVideoDelay = sharedPreferences.getInt(g.KEY_HC_ENCODE_VIDEO_DELEY, 0);
        hcEncodeVideoCPU = sharedPreferences.getInt(g.KEY_HC_ENCODE_VIDEO_CPU, 1);
        hcEncodeVideoIO = sharedPreferences.getInt(g.KEY_HC_ENCODE_VIDEO_IO, 1);
        hcEncodeVideoThr = sharedPreferences.getBoolean(g.KEY_HC_ENCODE_VIDEO_THR, false);
        hcEncodeVideoTimeout = sharedPreferences.getInt(g.KEY_HC_ENCODE_VIDEO_TIMEOUT, g.sHCENCODEVIDEOTIMEOUT);
        hcEncodeVideoAction = sharedPreferences.getLong(g.KEY_HC_ENCODE_VIDEO_ACTION, 81984);
        hcDecodePicEnable = sharedPreferences.getBoolean(g.KEY_HC_DECODE_PIC_ENABLE, false);
        hcDecodePicDelay = sharedPreferences.getInt(g.KEY_HC_DECODE_PIC_DELEY, 100);
        hcDecodePicCPU = sharedPreferences.getInt(g.KEY_HC_DECODE_PIC_CPU, 2);
        hcDecodePicIO = sharedPreferences.getInt(g.KEY_HC_DECODE_PIC_IO, 2);
        hcDecodePicThr = sharedPreferences.getBoolean(g.KEY_HC_DECODE_PIC_THR, false);
        hcDecodePicTimeout = sharedPreferences.getInt(g.KEY_HC_DECODE_PIC_TIMEOUT, 500);
        hcDecodePicAction = sharedPreferences.getLong(g.KEY_HC_DECODE_PIC_ACTION, g.sHCDECODEPICACTION);
        hcGifEnable = sharedPreferences.getBoolean(g.KEY_HC_GIF_ENABLE, true);
        hcGifDelay = sharedPreferences.getInt(g.KEY_HC_GIF_DELEY, 0);
        hcGifCPU = sharedPreferences.getInt(g.KEY_HC_GIF_CPU, 3);
        hcGifIO = sharedPreferences.getInt(g.KEY_HC_GIF_IO, 2);
        hcGifThr = sharedPreferences.getBoolean(g.KEY_HC_GIF_THR, false);
        hcGifTimeout = sharedPreferences.getInt(g.KEY_HC_GIF_TIMEOUT, 500);
        hcGifAction = sharedPreferences.getLong(g.KEY_HC_GIF_ACTION, 81984);
        hcGifFrameEnable = sharedPreferences.getBoolean(g.KEY_HC_GIF_FRAME_ENABLE, true);
        hcGifFrameDelay = sharedPreferences.getInt(g.KEY_HC_GIF_FRAME_DELEY, 0);
        hcGifFrameCPU = sharedPreferences.getInt(g.KEY_HC_GIF_FRAME_CPU, 2);
        hcGifFrameIO = sharedPreferences.getInt(g.KEY_HC_GIF_FRAME_IO, 0);
        hcGifFrameThr = sharedPreferences.getBoolean(g.KEY_HC_GIF_FRAME_THR, false);
        hcGifFrameTimeout = sharedPreferences.getInt(g.KEY_HC_GIF_FRAME_TIMEOUT, 1000);
        hcGifFrameAction = sharedPreferences.getLong(g.KEY_HC_GIF_FRAME_ACTION, g.sHCGIFFRAMEACTION);
        hcSNSScrollEnable = sharedPreferences.getBoolean(g.KEY_HC_SNS_SCROLL_ENABLE, true);
        hcSNSScrollDelay = sharedPreferences.getInt(g.KEY_HC_SNS_SCROLL_DELEY, 0);
        hcSNSScrollCPU = sharedPreferences.getInt(g.KEY_HC_SNS_SCROLL_CPU, 2);
        hcSNSScrollIO = sharedPreferences.getInt(g.KEY_HC_SNS_SCROLL_IO, 2);
        hcSNSScrollThr = sharedPreferences.getBoolean(g.KEY_HC_SNS_SCROLL_THR, false);
        hcSNSScrollTimeout = sharedPreferences.getInt(g.KEY_HC_SNS_SCROLL_TIMEOUT, 1500);
        hcSNSScrollAction = sharedPreferences.getLong(g.KEY_HC_SNS_SCROLL_ACTION, 96);
        hcSNSUserScrollEnable = sharedPreferences.getBoolean(g.KEY_HC_SNS_USER_SCROLL_ENABLE, true);
        hcSNSUserScrollDelay = sharedPreferences.getInt(g.KEY_HC_SNS_USER_SCROLL_DELEY, 0);
        hcSNSUserScrollCPU = sharedPreferences.getInt(g.KEY_HC_SNS_USER_SCROLL_CPU, 3);
        hcSNSUserScrollIO = sharedPreferences.getInt(g.KEY_HC_SNS_USER_SCROLL_IO, 2);
        hcSNSUserScrollThr = sharedPreferences.getBoolean(g.KEY_HC_SNS_USER_SCROLL_THR, false);
        hcSNSUserScrollTimeout = sharedPreferences.getInt(g.KEY_HC_SNS_USER_SCROLL_TIMEOUT, 1500);
        hcSNSUserScrollAction = sharedPreferences.getLong(g.KEY_HC_SNS_USER_SCROLL_ACTION, 96);
        hcSNSMsgScrollEnable = sharedPreferences.getBoolean(g.KEY_HC_SNS_MSG_SCROLL_ENABLE, true);
        hcSNSMsgScrollDelay = sharedPreferences.getInt(g.KEY_HC_SNS_MSG_SCROLL_DELEY, 0);
        hcSNSMsgScrollCPU = sharedPreferences.getInt(g.KEY_HC_SNS_MSG_SCROLL_CPU, 3);
        hcSNSMsgScrollIO = sharedPreferences.getInt(g.KEY_HC_SNS_MSG_SCROLL_IO, 2);
        hcSNSMsgScrollThr = sharedPreferences.getBoolean(g.KEY_HC_SNS_MSG_SCROLL_THR, false);
        hcSNSMsgScrollTimeout = sharedPreferences.getInt(g.KEY_HC_SNS_MSG_SCROLL_TIMEOUT, 1500);
        hcSNSMsgScrollAction = sharedPreferences.getLong(g.KEY_HC_SNS_MSG_SCROLL_ACTION, 96);
        hcMediaGalleryScrollEnable = sharedPreferences.getBoolean(g.KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE, true);
        hcMediaGalleryScrollDelay = sharedPreferences.getInt(g.KEY_HC_MEDIA_GALLERY_SCROLL_DELEY, 0);
        hcMediaGalleryScrollCPU = sharedPreferences.getInt(g.KEY_HC_MEDIA_GALLERY_SCROLL_CPU, 3);
        hcMediaGalleryScrollIO = sharedPreferences.getInt(g.KEY_HC_MEDIA_GALLERY_SCROLL_IO, 2);
        hcMediaGalleryScrollThr = sharedPreferences.getBoolean(g.KEY_HC_MEDIA_GALLERY_SCROLL_THR, false);
        hcMediaGalleryScrollTimeout = sharedPreferences.getInt(g.KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT, 1500);
        hcMediaGalleryScrollAction = sharedPreferences.getLong(g.KEY_HC_MEDIA_GALLERY_SCROLL_ACTION, 96);
        hcAlbumScrollEnable = sharedPreferences.getBoolean(g.KEY_HC_ALBUM_SCROLL_ENABLE, true);
        hcAlbumScrollDelay = sharedPreferences.getInt(g.KEY_HC_ALBUM_SCROLL_DELEY, 0);
        hcAlbumScrollCPU = sharedPreferences.getInt(g.KEY_HC_ALBUM_SCROLL_CPU, 3);
        hcAlbumScrollIO = sharedPreferences.getInt(g.KEY_HC_ALBUM_SCROLL_IO, 2);
        hcAlbumScrollThr = sharedPreferences.getBoolean(g.KEY_HC_ALBUM_SCROLL_THR, false);
        hcAlbumScrollTimeout = sharedPreferences.getInt(g.KEY_HC_ALBUM_SCROLL_TIMEOUT, 1500);
        hcAlbumScrollAction = sharedPreferences.getLong(g.KEY_HC_ALBUM_SCROLL_ACTION, 96);
        hcMiniProgramLaunchEnable = sharedPreferences.getBoolean(g.KEY_HC_MINI_PROGRAM_LAUNCH_ENABLE, true);
        hcMiniProgramLaunchDelay = sharedPreferences.getInt(g.KEY_HC_MINI_PROGRAM_LAUNCH_DELEY, 500);
        hcMiniProgramLaunchCPU = sharedPreferences.getInt(g.KEY_HC_MINI_PROGRAM_LAUNCH_CPU, 1);
        hcMiniProgramLaunchIO = sharedPreferences.getInt(g.KEY_HC_MINI_PROGRAM_LAUNCH_IO, 1);
        hcMiniProgramLaunchThr = sharedPreferences.getBoolean(g.KEY_HC_MINI_PROGRAM_LAUNCH_THR, false);
        hcMiniProgramLaunchTimeout = sharedPreferences.getInt(g.KEY_HC_MINI_PROGRAM_LAUNCH_TIMEOUT, 5000);
        hcMiniProgramLaunchAction = sharedPreferences.getLong(g.KEY_HC_MINI_PROGRAM_LAUNCH_ACTION, g.sHCMINIPROGRAMLAUNCHACTION);
        Log.i(TAG, "reloadSPConfig Boot[%b] EnterChatting[%b] QuitChatting[%b] SendMsg[%b] SendPicMsg[%b] ReceiveMsg[%b] UpdateChatroom[%b] DB[%b] EncodeVideo[%b] DecodePic[%b] Gif[%b] GifFrame[%b] SNS[%b] MediaGallery[%b] Album[%b] SNSUser[%b] SNSMsg[%b] MiniProgramLaunch[%b]", Boolean.valueOf(hcBootEnable), Boolean.valueOf(hcEnterChattingEnable), Boolean.valueOf(hcQuitChattingEnable), Boolean.valueOf(hcSendMsgEnable), Boolean.valueOf(hcSendPicMsgEnable), Boolean.valueOf(hcReceiveMsgEnable), Boolean.valueOf(hcUpdateChatroomEnable), Boolean.valueOf(hcDBEnable), Boolean.valueOf(hcEncodeVideoEnable), Boolean.valueOf(hcDecodePicEnable), Boolean.valueOf(hcGifEnable), Boolean.valueOf(hcGifFrameEnable), Boolean.valueOf(hcSNSScrollEnable), Boolean.valueOf(hcMediaGalleryScrollEnable), Boolean.valueOf(hcAlbumScrollEnable), Boolean.valueOf(hcSNSUserScrollEnable), Boolean.valueOf(hcSNSMsgScrollEnable), Boolean.valueOf(hcMiniProgramLaunchEnable));
        AppMethodBeat.o(155961);
    }

    public static synchronized String readServerAddr(boolean z) {
        String str;
        synchronized (WXHardCoderJNI.class) {
            AppMethodBeat.i(155962);
            try {
                if (sSystemPropertiesClazz == null) {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    sSystemPropertiesClazz = cls;
                    Method declaredMethod = cls.getDeclaredMethod("get", String.class, String.class);
                    sGetStringPropsMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                str = (String) sGetStringPropsMethod.invoke(null, HardCoderJNI.SERVER_PROP_KEY, "");
                Log.i(TAG, "readServerAddr, serverprop[%s], result[%s], stack[%s]", HardCoderJNI.SERVER_PROP_KEY, str, Util.getStack());
                if (z) {
                    if (Util.isNullOrNil(str)) {
                        reportInfo(new j(true, 1, 1, false));
                    } else {
                        reportInfo(new j(true, 2, 1, false));
                        reportInfo(new k());
                    }
                }
                AppMethodBeat.o(155962);
            } catch (Throwable th) {
                Log.printErrStackTrace(TAG, th, "readServerAddr", new Object[0]);
                if (z) {
                    reportInfo(new j(true, 3, 1, false));
                }
                str = "";
                AppMethodBeat.o(155962);
            }
        }
        return str;
    }

    public static boolean isHCEnable() {
        AppMethodBeat.i(155963);
        boolean isCheckEnv = isCheckEnv() & getEnable();
        AppMethodBeat.o(155963);
        return isCheckEnv;
    }

    public static int initHardCoder(e.a aVar, h.a aVar2, c.a aVar3) {
        AppMethodBeat.i(155964);
        HardCoderJNI.setHcEnable(isHCEnable());
        String readServerAddr = readServerAddr(false);
        if (readServerAddr == null || readServerAddr.isEmpty()) {
            Object[] objArr = new Object[1];
            if (readServerAddr == null) {
                readServerAddr = BuildConfig.COMMAND;
            }
            objArr[0] = readServerAddr;
            Log.w(TAG, "initHardCoder serverSock is null or empty, skip init and reguard as disabled, serverSock:%s.", objArr);
            HardCoderJNI.setCheckEnv(false);
            AppMethodBeat.o(155964);
            return -3;
        }
        if (readServerAddr != null && readServerAddr.contains("|")) {
            needMapAPPScene = true;
        }
        e.a(aVar);
        hardCoderReporterInfo = aVar2;
        d.a(wxHardCoderLog);
        HardCoderJNI.setSceneReportCallback(sceneReportCallback);
        Log.i(TAG, "initHardCoder hcDebug[%b] hcEnable[%b] checkEnv[%b] TICK_RATE[%d]", Boolean.valueOf(HardCoderJNI.isHcDebug()), Boolean.valueOf(HardCoderJNI.isHcEnable()), Boolean.valueOf(HardCoderJNI.isCheckEnv()), Integer.valueOf(HardCoderJNI.tickRate));
        int initHardCoder = HardCoderJNI.initHardCoder(readServerAddr, 0, MMApplicationContext.getPackageName() + HardCoderJNI.CLIENT_SOCK, new HardCoderJNI.HCPerfManagerThread() {
            /* class com.tencent.mm.hardcoder.WXHardCoderJNI.AnonymousClass2 */

            @Override // com.tencent.mm.hardcoder.HardCoderJNI.HCPerfManagerThread
            public final Thread newThread(Runnable runnable, String str, int i2) {
                AppMethodBeat.i(155948);
                Thread b2 = com.tencent.f.c.d.b(str, runnable, i2);
                AppMethodBeat.o(155948);
                return b2;
            }
        }, aVar3);
        AppMethodBeat.o(155964);
        return initHardCoder;
    }

    private static boolean checkHardCoderEnv() {
        AppMethodBeat.i(155965);
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        String readServerAddr = readServerAddr(false);
        Log.i(TAG, "checkHardCoderEnv manufacture[%s], model[%s], remote[%s]", str, str2, readServerAddr);
        if (!Util.isNullOrNil(readServerAddr)) {
            AppMethodBeat.o(155965);
            return true;
        }
        AppMethodBeat.o(155965);
        return false;
    }

    public static long registerANRCallback(HardCoderJNI.AnrCallback anrCallback) {
        AppMethodBeat.i(155966);
        if (!HardCoderJNI.isCheckEnv()) {
            AppMethodBeat.o(155966);
            return -2;
        }
        long registerANRCallback = HardCoderJNI.registerANRCallback(anrCallback);
        AppMethodBeat.o(155966);
        return registerANRCallback;
    }

    public static void reportIDKey(boolean z, int i2, int i3, boolean z2) {
        AppMethodBeat.i(155967);
        reportInfo(new j(z, i2, i3, z2));
        AppMethodBeat.o(155967);
    }

    public static void reportFPS(int i2, long j2, int i3, long j3, long j4) {
        AppMethodBeat.i(155968);
        reportInfo(new i(i2, j2, i3, j3, j4));
        AppMethodBeat.o(155968);
    }

    private static void reportInfo(h hVar) {
        AppMethodBeat.i(155969);
        if (hardCoderReporterInfo != null) {
            hardCoderReporterInfo.reportInfo(hVar);
        }
        AppMethodBeat.o(155969);
    }

    private static void initSceneAndFlagMap() {
        AppMethodBeat.i(155970);
        SCENE_ID_MAP.clear();
        APP_SCENE_ID_MAP.clear();
        SCENE_ID_MAP.put(101, 1);
        SCENE_ID_MAP.put(201, 2);
        SCENE_ID_MAP.put(202, 3);
        SCENE_ID_MAP.put(203, 4);
        SCENE_ID_MAP.put(301, 5);
        SCENE_ID_MAP.put(302, 6);
        SCENE_ID_MAP.put(401, 7);
        SCENE_ID_MAP.put(501, 8);
        SCENE_ID_MAP.put(601, 9);
        SCENE_ID_MAP.put(602, 10);
        SCENE_ID_MAP.put(603, 11);
        SCENE_ID_MAP.put(701, 12);
        SCENE_ID_MAP.put(702, 13);
        SCENE_ID_MAP.put(703, 14);
        SCENE_ID_MAP.put(704, 15);
        SCENE_ID_MAP.put(705, 16);
        SCENE_ID_MAP.put(801, 17);
        SCENE_ID_MAP.put(901, 18);
        SCENE_ID_MAP.put(902, 19);
        SCENE_ID_MAP.put(903, 20);
        SCENE_ID_MAP.put(706, 21);
        SCENE_ID_MAP.put(707, 22);
        APP_SCENE_ID_MAP.put(101, 1);
        APP_SCENE_ID_MAP.put(201, 6);
        APP_SCENE_ID_MAP.put(202, 6);
        APP_SCENE_ID_MAP.put(203, 5);
        APP_SCENE_ID_MAP.put(301, 2);
        APP_SCENE_ID_MAP.put(302, 2);
        APP_SCENE_ID_MAP.put(401, 6);
        APP_SCENE_ID_MAP.put(501, 4);
        APP_SCENE_ID_MAP.put(601, 5);
        APP_SCENE_ID_MAP.put(602, 5);
        APP_SCENE_ID_MAP.put(603, 5);
        APP_SCENE_ID_MAP.put(701, 3);
        APP_SCENE_ID_MAP.put(702, 3);
        APP_SCENE_ID_MAP.put(703, 3);
        APP_SCENE_ID_MAP.put(704, 3);
        APP_SCENE_ID_MAP.put(705, 3);
        APP_SCENE_ID_MAP.put(801, 1);
        APP_SCENE_ID_MAP.put(901, 2);
        APP_SCENE_ID_MAP.put(902, 2);
        APP_SCENE_ID_MAP.put(903, 3);
        APP_SCENE_ID_MAP.put(706, 2);
        APP_SCENE_ID_MAP.put(707, 7);
        flagKeyMap.put(2L, g.KEY_HC_BOOT_ENABLE);
        flagKeyMap.put(4L, g.KEY_HC_RECEIVE_MSG_ENABLE);
        flagKeyMap.put(8L, g.KEY_HC_SEND_MSG_ENABLE);
        flagKeyMap.put(16L, g.KEY_HC_SEND_PIC_MSG_ENABLE);
        flagKeyMap.put(32L, g.KEY_HC_ENTER_CHATTING_ENABLE);
        flagKeyMap.put(64L, g.KEY_HC_QUIT_CHATTING_ENABLE);
        flagKeyMap.put(128L, g.KEY_HC_UPDATE_CHATROOM_ENABLE);
        flagKeyMap.put(256L, g.KEY_HC_DB_ENABLE);
        flagKeyMap.put(512L, g.KEY_HC_DECODE_PIC_ENABLE);
        flagKeyMap.put(1024L, g.KEY_HC_GIF_ENABLE);
        flagKeyMap.put(2048L, g.KEY_HC_GIF_FRAME_ENABLE);
        flagKeyMap.put(4096L, g.KEY_HC_ENCODE_VIDEO_ENABLE);
        flagKeyMap.put(8192L, g.KEY_HC_SNS_SCROLL_ENABLE);
        flagKeyMap.put(16384L, g.KEY_HC_ALBUM_SCROLL_ENABLE);
        flagKeyMap.put(32768L, g.KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE);
        flagKeyMap.put(65536L, g.KEY_HC_SNS_USER_SCROLL_ENABLE);
        flagKeyMap.put(131072L, g.KEY_HC_SNS_MSG_SCROLL_ENABLE);
        flagKeyMap.put(262144L, g.KEY_HC_MINI_PROGRAM_LAUNCH_ENABLE);
        AppMethodBeat.o(155970);
    }

    public static int registerGetParametersCallback(int i2, GetParametersCallback getParametersCallback2, String... strArr) {
        Object obj;
        AppMethodBeat.i(155971);
        if (!HardCoderJNI.isCheckEnv()) {
            AppMethodBeat.o(155971);
            return -2;
        }
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        if (getParametersCallback2 == null) {
            obj = BuildConfig.COMMAND;
        } else {
            obj = getParametersCallback2;
        }
        objArr[1] = obj;
        objArr[2] = Util.getStack();
        Log.i(TAG, "registerGetParametersCallback, type:%d, callback:%s, stack[%s]", objArr);
        getParameters(i2, getParametersCallback2, strArr);
        AppMethodBeat.o(155971);
        return 0;
    }

    public static long getParameters(int i2, GetParametersCallback getParametersCallback2, String... strArr) {
        AppMethodBeat.i(155972);
        long j2 = -1;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("getparameterstype", i2);
            JSONArray jSONArray = new JSONArray();
            for (String str : strArr) {
                jSONArray.put(str);
            }
            jSONObject.put("getparameterskeys", jSONArray);
            j2 = getParameters(i2, getParametersCallback2, jSONObject);
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(155972);
        return j2;
    }

    public static long getParameters(int i2, GetParametersCallback getParametersCallback2, JSONObject jSONObject) {
        AppMethodBeat.i(155973);
        String jSONObject2 = jSONObject.toString();
        getParametersCallback = getParametersCallback2;
        long parameters = HardCoderJNI.getParameters(jSONObject2.getBytes(), Process.myTid(), SystemClock.elapsedRealtimeNanos());
        HardCoderJNI.putFuncRetHashMap(parameters, funcRet);
        Log.i(TAG, "getParameters type:" + i2 + ", len: " + jSONObject2.length());
        try {
            Thread.sleep(20);
        } catch (InterruptedException e2) {
        }
        AppMethodBeat.o(155973);
        return parameters;
    }

    public static long registerSystemEventCallback(SystemEventCallback systemEventCallback2) {
        AppMethodBeat.i(155974);
        if (!HardCoderJNI.isCheckEnv()) {
            AppMethodBeat.o(155974);
            return -2;
        }
        Log.i(TAG, "registerSystemEventCallback, stack[%s]", Util.getStack());
        systemEventCallback = systemEventCallback2;
        long registerSystemEventCallback = HardCoderJNI.registerSystemEventCallback(Process.myTid(), SystemClock.elapsedRealtime());
        HardCoderJNI.putFuncRetHashMap(registerSystemEventCallback, funcRet);
        AppMethodBeat.o(155974);
        return registerSystemEventCallback;
    }
}

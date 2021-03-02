package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

public class aw {
    private static aw xIh;
    private static TMQQDownloaderOpenSDK xIi;

    private aw() {
    }

    public static aw dVY() {
        AppMethodBeat.i(41653);
        if (xIh == null) {
            synchronized (aw.class) {
                try {
                    if (xIh == null) {
                        xIh = new aw();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(41653);
                    throw th;
                }
            }
        }
        aw awVar = xIh;
        AppMethodBeat.o(41653);
        return awVar;
    }

    private static TMQQDownloaderOpenSDK dVZ() {
        AppMethodBeat.i(41654);
        if (xIi == null) {
            TMQQDownloaderOpenSDK instance = TMQQDownloaderOpenSDK.getInstance();
            xIi = instance;
            instance.initQQDownloaderOpenSDK(MMApplicationContext.getContext());
        }
        TMQQDownloaderOpenSDK tMQQDownloaderOpenSDK = xIi;
        AppMethodBeat.o(41654);
        return tMQQDownloaderOpenSDK;
    }

    public static void dWa() {
        boolean z = false;
        AppMethodBeat.i(41655);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(xIi == null);
        if (xIh == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        Log.i("MicroMsg.QQDownloaderSDKWrapper", "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]", objArr);
        if (xIi != null) {
            xIi.destroyQQDownloaderOpenSDK();
        }
        xIi = null;
        xIh = null;
        AppMethodBeat.o(41655);
    }

    public static void aP(Context context, String str) {
        AppMethodBeat.i(41656);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
            AppMethodBeat.o(41656);
        } else if (context == null) {
            Log.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
            AppMethodBeat.o(41656);
        } else {
            Log.i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", str);
            TMQQDownloaderOpenSDKParam aAp = new a((byte) 0).aAp(str);
            try {
                dVY();
                dVZ().startToDownloadTaskList(context, aAp, true, true);
                AppMethodBeat.o(41656);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.QQDownloaderSDKWrapper", e2, "", new Object[0]);
                AppMethodBeat.o(41656);
            }
        }
    }

    public static int a(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        AppMethodBeat.i(41657);
        try {
            dVY();
            TMAssistantDownloadTaskInfo downloadTaskState = dVZ().getDownloadTaskState(tMQQDownloaderOpenSDKParam);
            if (downloadTaskState != null) {
                int i2 = downloadTaskState.mState;
                AppMethodBeat.o(41657);
                return i2;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", e2.getMessage());
        }
        AppMethodBeat.o(41657);
        return -1;
    }

    public static int k(Context context, String str, int i2) {
        int i3 = -1;
        AppMethodBeat.i(41658);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
            AppMethodBeat.o(41658);
        } else {
            try {
                PackageInfo packageInfo = b.getPackageInfo(context, str);
                if (packageInfo == null) {
                    i3 = 1;
                } else {
                    Log.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", Integer.valueOf(packageInfo.versionCode));
                    i3 = packageInfo.versionCode >= i2 ? 0 : 2;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", e2.getMessage());
            }
            Log.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", Integer.valueOf(i3));
            AppMethodBeat.o(41658);
        }
        return i3;
    }

    public static void startToAuthorized(Context context, String str) {
        AppMethodBeat.i(41659);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
            AppMethodBeat.o(41659);
            return;
        }
        TMQQDownloaderOpenSDKParam aAp = new a((byte) 0).aAp(str);
        try {
            dVY();
            dVZ().startToAuthorized(context, aAp, "1");
            AppMethodBeat.o(41659);
        } catch (Exception e2) {
            Log.e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", e2.getMessage());
            AppMethodBeat.o(41659);
        }
    }

    public static final class a {
        public String SNGAppId;
        public String actionFlag;
        public String taskApkId;
        public String taskAppId;
        public String taskPackageName;
        public int taskVersion;
        public String uin;
        public String uinType;
        public String via;
        public String xIj;

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        private void aAo(String str) {
            AppMethodBeat.i(41651);
            Log.i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", str);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
                AppMethodBeat.o(41651);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.taskApkId = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_APKID);
                this.via = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_VIA);
                this.taskVersion = jSONObject.optInt(OpenSDKTool4Assistant.EXTRA_TASK_VERSION);
                this.xIj = jSONObject.optString("channelID");
                this.uin = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_UIN);
                this.SNGAppId = jSONObject.optString("SNGAppId");
                this.taskAppId = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_APPID);
                this.uinType = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_UINTYPE);
                this.taskPackageName = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_PACKAGENAME);
                this.actionFlag = jSONObject.optString("actionFlag");
                AppMethodBeat.o(41651);
            } catch (Exception e2) {
                Log.e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", e2.getMessage());
                AppMethodBeat.o(41651);
            }
        }

        public final TMQQDownloaderOpenSDKParam aAp(String str) {
            AppMethodBeat.i(41652);
            aAo(str);
            TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.xIj, this.actionFlag);
            AppMethodBeat.o(41652);
            return tMQQDownloaderOpenSDKParam;
        }
    }
}

package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.aj;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public final class d {
    static a SFG;
    static boolean SFH = false;

    static {
        AppMethodBeat.i(157148);
        aj.initInterface();
        AppMethodBeat.o(157148);
    }

    public static void a(a aVar) {
        SFG = aVar;
    }

    public static void reset(Context context) {
        AppMethodBeat.i(157135);
        if (SFG != null) {
            SFG.reset(context);
            AppMethodBeat.o(157135);
            return;
        }
        Log.e("TbsDownloader", "reset: sImp is null");
        AppMethodBeat.o(157135);
    }

    public static boolean getTBSInstalling() {
        AppMethodBeat.i(157136);
        if (SFG != null) {
            boolean tBSInstalling = SFG.getTBSInstalling();
            AppMethodBeat.o(157136);
            return tBSInstalling;
        }
        Log.e("TbsDownloader", "getTBSInstalling: sImp is null");
        AppMethodBeat.o(157136);
        return false;
    }

    public static int getTbsVersion(Context context) {
        AppMethodBeat.i(157137);
        if (SFG != null) {
            int tbsVersion = SFG.getTbsVersion(context);
            AppMethodBeat.o(157137);
            return tbsVersion;
        }
        Log.e("TbsDownloader", "getTbsVersion: sImp is null");
        AppMethodBeat.o(157137);
        return 0;
    }

    public static void a(h hVar) {
        AppMethodBeat.i(157138);
        if (SFG != null) {
            SFG.a(hVar);
            AppMethodBeat.o(157138);
            return;
        }
        Log.e("TbsDownloader", "setTbsListener: sImp is null");
        AppMethodBeat.o(157138);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(157139);
        if (SFG != null) {
            int startMiniQBToLoadUrl = SFG.startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
            AppMethodBeat.o(157139);
            return startMiniQBToLoadUrl;
        }
        Log.e("TbsDownloader", "startMiniQBToLoadUrl: sImp is null");
        AppMethodBeat.o(157139);
        return 0;
    }

    public static boolean a(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(157140);
        if (SFG != null) {
            boolean a2 = SFG.a(context, str, hashMap, valueCallback);
            AppMethodBeat.o(157140);
            return a2;
        }
        Log.e("TbsDownloader", "startQbOrMiniQBToLoadUrl: sImp is null");
        AppMethodBeat.o(157140);
        return false;
    }

    public static void a(Context context, String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(157141);
        if (SFG != null) {
            SFG.a(context, str, valueCallback);
            AppMethodBeat.o(157141);
            return;
        }
        Log.e("TbsDownloader", "canOpenFile: sImp is null");
        AppMethodBeat.o(157141);
    }

    public static void disableAutoCreateX5Webview() {
        AppMethodBeat.i(219098);
        if (SFG != null) {
            SFG.disableAutoCreateX5Webview();
            AppMethodBeat.o(219098);
            return;
        }
        Log.e("TbsDownloader", "disableAutoCreateX5Webview: sImp is null");
        AppMethodBeat.o(219098);
    }

    public static void initTbsSettings(Map<String, Object> map) {
        AppMethodBeat.i(157143);
        if (SFG != null) {
            SFG.initTbsSettings(map);
            AppMethodBeat.o(157143);
            return;
        }
        Log.e("TbsDownloader", "initTbsSettings: sImp is null");
        AppMethodBeat.o(157143);
    }

    public static boolean canOpenWebPlus(Context context) {
        AppMethodBeat.i(157144);
        if (SFG != null) {
            boolean canOpenWebPlus = SFG.canOpenWebPlus(context);
            AppMethodBeat.o(157144);
            return canOpenWebPlus;
        }
        Log.e("TbsDownloader", "canOpenWebPlus: sImp is null");
        AppMethodBeat.o(157144);
        return false;
    }

    public static void closeFileReader(Context context) {
        AppMethodBeat.i(157145);
        if (SFG != null) {
            SFG.closeFileReader(context);
            AppMethodBeat.o(157145);
            return;
        }
        Log.e("TbsDownloader", "closeFileReader: sImp is null");
        AppMethodBeat.o(157145);
    }

    public static void forceSysWebView() {
        AppMethodBeat.i(157146);
        SFH = true;
        if (SFG != null) {
            SFG.forceSysWebView();
            AppMethodBeat.o(157146);
            return;
        }
        Log.e("TbsDownloader", "forceSysWebView: sImp is null");
        AppMethodBeat.o(157146);
    }

    public static String getMiniQBVersion(Context context) {
        AppMethodBeat.i(219099);
        if (SFG != null) {
            String miniQBVersion = SFG.getMiniQBVersion(context);
            AppMethodBeat.o(219099);
            return miniQBVersion;
        }
        Log.e("TbsDownloader", "forceSysWebView: sImp is null");
        AppMethodBeat.o(219099);
        return null;
    }

    public static void setUploadCode(Context context, int i2) {
        AppMethodBeat.i(157147);
        if (SFG != null) {
            SFG.setUploadCode(context, i2);
            AppMethodBeat.o(157147);
            return;
        }
        Log.e("TbsDownloader", "forceSysWebView: sImp is null");
        AppMethodBeat.o(157147);
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        AppMethodBeat.i(219100);
        if (SFG != null) {
            SFG.setWebContentsDebuggingEnabled(z);
            AppMethodBeat.o(219100);
            return;
        }
        Log.e("TbsDownloader", "setWebContentsDebuggingEnabled: sImp is null");
        AppMethodBeat.o(219100);
    }

    public static boolean huK() {
        return true;
    }

    public static void setNewDnsHostList(String str) {
        AppMethodBeat.i(219101);
        if (SFG != null) {
            SFG.setNewDnsHostList(str);
            AppMethodBeat.o(219101);
            return;
        }
        Log.e("TbsDownloader", "setNewDnsHostList: sImp is null");
        AppMethodBeat.o(219101);
    }
}

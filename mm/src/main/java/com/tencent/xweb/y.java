package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Debug;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView;
import com.tencent.xweb.f;
import com.tencent.xweb.internal.l;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class y {
    private static y SzP = null;
    public boolean SAa = false;
    public boolean SAb = false;
    public Context SzQ;
    WebView.c SzR = WebView.c.WV_KIND_NONE;
    public boolean SzS = false;
    public boolean SzT = false;
    public boolean SzU = false;
    public boolean SzV = false;
    boolean SzW = false;
    public boolean SzX = false;
    public boolean SzY = false;
    public JsRuntime.JsRuntimeType SzZ = JsRuntime.JsRuntimeType.RT_TYPE_AUTO;

    public static void lC(Context context) {
        String string;
        AppMethodBeat.i(156781);
        if (SzP != null) {
            AppMethodBeat.o(156781);
            return;
        }
        y yVar = new y();
        SzP = yVar;
        yVar.SzQ = context.getApplicationContext();
        XWalkEnvironment.init(context);
        SzP.SzT = context.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
        SzP.SzU = context.getSharedPreferences("wcwebview", 0).getBoolean("bShowX5Version", false);
        SzP.SzV = context.getSharedPreferences("wcwebview", 0).getBoolean("bShowSavePage", false);
        try {
            SzP.SzZ = JsRuntime.JsRuntimeType.valueOf(context.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO"));
        } catch (Exception e2) {
        }
        SzP.SzS = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
        String testDownLoadUrl = XWalkEnvironment.getTestDownLoadUrl(context);
        SzP.SAa = testDownLoadUrl != null && !testDownLoadUrl.isEmpty();
        SzP.SzX = context.getSharedPreferences("wcwebview", 0).getBoolean("bWaitforDebugger", false);
        if (SzP.SzX && (string = SzP.SzQ.getSharedPreferences("wcwebview", 4).getString("strDebugProcess", "")) != null && string.equals(XWalkEnvironment.getProcessName())) {
            Debug.waitForDebugger();
            Log.w("WebDebugCfg", "strDebugProcess is ".concat(String.valueOf(string)));
        }
        SzP.SzY = context.getSharedPreferences("wcwebview", 0).getBoolean("ignore_crashwatch", false);
        SzP.SAb = context.getSharedPreferences("wcwebview", 0).getBoolean("show_fps", false);
        AppMethodBeat.o(156781);
    }

    public static y hsF() {
        return SzP;
    }

    public final WebView.c bsk(String str) {
        AppMethodBeat.i(156782);
        if (str == null || str.isEmpty() || this.SzQ == null) {
            WebView.c cVar = WebView.c.WV_KIND_NONE;
            AppMethodBeat.o(156782);
            return cVar;
        }
        SharedPreferences mMKVSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
        if (mMKVSharedPreferences == null) {
            WebView.c cVar2 = WebView.c.WV_KIND_NONE;
            AppMethodBeat.o(156782);
            return cVar2;
        }
        String string = mMKVSharedPreferences.getString("HardCodeWebView".concat(String.valueOf(str)), "");
        if (string != null && !string.isEmpty()) {
            XWalkEnvironment.addXWalkInitializeLog("has hardcode type = ".concat(String.valueOf(string)));
        }
        if ((string == null || string.isEmpty() || string.equals(WebView.c.WV_KIND_NONE.toString())) && (string = mMKVSharedPreferences.getString("ABTestWebView".concat(String.valueOf(str)), "")) != null && !string.isEmpty()) {
            XWalkEnvironment.addXWalkInitializeLog("has abtest type = ".concat(String.valueOf(string)));
        }
        if (string == null || string.isEmpty()) {
            this.SzR = WebView.c.WV_KIND_NONE;
        } else {
            try {
                this.SzR = WebView.c.valueOf(string);
            } catch (Exception e2) {
                this.SzR = WebView.c.WV_KIND_NONE;
            }
        }
        WebView.c cVar3 = this.SzR;
        AppMethodBeat.o(156782);
        return cVar3;
    }

    public final WebView.c dI(String str, boolean z) {
        String string;
        AppMethodBeat.i(175638);
        if (str == null || str.isEmpty() || this.SzQ == null) {
            WebView.c cVar = WebView.c.WV_KIND_NONE;
            AppMethodBeat.o(175638);
            return cVar;
        }
        SharedPreferences mMKVSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
        if (mMKVSharedPreferences == null) {
            WebView.c cVar2 = WebView.c.WV_KIND_NONE;
            AppMethodBeat.o(175638);
            return cVar2;
        }
        if (z) {
            string = mMKVSharedPreferences.getString("ABTestWebView".concat(String.valueOf(str)), "");
        } else {
            string = mMKVSharedPreferences.getString("HardCodeWebView".concat(String.valueOf(str)), "");
        }
        if (string == null || string.isEmpty()) {
            this.SzR = WebView.c.WV_KIND_NONE;
        } else {
            try {
                this.SzR = WebView.c.valueOf(string);
            } catch (Exception e2) {
                this.SzR = WebView.c.WV_KIND_NONE;
            }
        }
        WebView.c cVar3 = this.SzR;
        AppMethodBeat.o(175638);
        return cVar3;
    }

    public final void a(String str, WebView.c cVar) {
        AppMethodBeat.i(156783);
        if (this.SzQ == null || str == null || str.isEmpty()) {
            AppMethodBeat.o(156783);
            return;
        }
        XWalkEnvironment.getMMKVSharedPreferences("xweb_debug").edit().putString("HardCodeWebView".concat(String.valueOf(str)), cVar.toString()).commit();
        AppMethodBeat.o(156783);
    }

    public final void b(String str, WebView.c cVar) {
        AppMethodBeat.i(156784);
        if (this.SzQ == null || str.isEmpty()) {
            AppMethodBeat.o(156784);
            return;
        }
        XWalkEnvironment.getMMKVSharedPreferences("xweb_debug").edit().putString("ABTestWebView".concat(String.valueOf(str)), cVar.toString()).commit();
        AppMethodBeat.o(156784);
    }

    public final void setDebugEnable(boolean z) {
        AppMethodBeat.i(156785);
        if (z == this.SzS) {
            AppMethodBeat.o(156785);
            return;
        }
        this.SzS = z;
        XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", z).commit();
        AppMethodBeat.o(156785);
    }

    public final void setShowFps(boolean z) {
        AppMethodBeat.i(156786);
        if (z == this.SAb) {
            AppMethodBeat.o(156786);
            return;
        }
        this.SAb = z;
        this.SzQ.getSharedPreferences("wcwebview", 0).edit().putBoolean("show_fps", z).commit();
        AppMethodBeat.o(156786);
    }

    public final void Ei(boolean z) {
        AppMethodBeat.i(156787);
        if (z == this.SzV) {
            AppMethodBeat.o(156787);
            return;
        }
        this.SzV = z;
        this.SzQ.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowSavePage", this.SzV).commit();
        AppMethodBeat.o(156787);
    }

    public final f.a bsl(String str) {
        AppMethodBeat.i(156788);
        SharedPreferences sharedPreferences = this.SzQ.getSharedPreferences("wcwebview", 4);
        if (sharedPreferences == null) {
            f.a aVar = f.a.NONE;
            AppMethodBeat.o(156788);
            return aVar;
        }
        f.a brU = b.brU(sharedPreferences.getString("force_fr_" + str.toLowerCase(), ""));
        AppMethodBeat.o(156788);
        return brU;
    }

    public final String a(String[] strArr, f.a aVar) {
        AppMethodBeat.i(156789);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(156789);
            return "";
        }
        SharedPreferences sharedPreferences = this.SzQ.getSharedPreferences("wcwebview", 4);
        if (sharedPreferences == null) {
            AppMethodBeat.o(156789);
            return "";
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (edit == null) {
            AppMethodBeat.o(156789);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            String[] strArr2 = f.SyR;
            for (String str2 : strArr2) {
                if (str2.equalsIgnoreCase(str)) {
                    edit.putString("force_fr_" + str.toLowerCase(), aVar.toString());
                    sb.append(str2).append(",");
                }
            }
        }
        if (edit.commit()) {
            String sb2 = sb.toString();
            AppMethodBeat.o(156789);
            return sb2;
        }
        AppMethodBeat.o(156789);
        return "";
    }

    public final f.c bsm(String str) {
        AppMethodBeat.i(219046);
        try {
            SharedPreferences sharedPreferences = this.SzQ.getSharedPreferences("wcwebview", 4);
            if (sharedPreferences == null) {
                f.c cVar = f.c.none;
                AppMethodBeat.o(219046);
                return cVar;
            }
            f.c brS = b.brS(sharedPreferences.getString("force_use_office_reader_" + str.toLowerCase(), ""));
            AppMethodBeat.o(219046);
            return brS;
        } catch (Exception e2) {
            Log.e("WebDebugCfg", "getForceUseOfficeReader error ", e2);
            f.c cVar2 = f.c.none;
            AppMethodBeat.o(219046);
            return cVar2;
        }
    }

    public final String a(String[] strArr, f.c cVar) {
        AppMethodBeat.i(219047);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(219047);
            return "";
        }
        SharedPreferences sharedPreferences = this.SzQ.getSharedPreferences("wcwebview", 4);
        if (sharedPreferences == null) {
            AppMethodBeat.o(219047);
            return "";
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (edit == null) {
            AppMethodBeat.o(219047);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            String[] strArr2 = f.SyR;
            for (String str2 : strArr2) {
                if (str2.equalsIgnoreCase(str)) {
                    edit.putString("force_use_office_reader_" + str.toLowerCase(), cVar.toString());
                    sb.append(str2).append(",");
                }
            }
        }
        if (edit.commit()) {
            String sb2 = sb.toString();
            AppMethodBeat.o(219047);
            return sb2;
        }
        AppMethodBeat.o(219047);
        return "";
    }

    public final boolean hsG() {
        AppMethodBeat.i(156790);
        SharedPreferences sharedPreferences = this.SzQ.getSharedPreferences("wcwebview", 4);
        if (sharedPreferences == null) {
            AppMethodBeat.o(156790);
            return false;
        }
        boolean z = sharedPreferences.getBoolean("fr_disable_cache", false);
        AppMethodBeat.o(156790);
        return z;
    }

    public final boolean hsH() {
        AppMethodBeat.i(156791);
        SharedPreferences sharedPreferences = this.SzQ.getSharedPreferences("wcwebview", 4);
        if (sharedPreferences == null) {
            AppMethodBeat.o(156791);
            return false;
        }
        boolean z = sharedPreferences.getBoolean("fr_disable_crash_detect", false);
        AppMethodBeat.o(156791);
        return z;
    }

    public final void a(JsRuntime.JsRuntimeType jsRuntimeType) {
        AppMethodBeat.i(156792);
        if (this.SzZ == jsRuntimeType) {
            AppMethodBeat.o(156792);
            return;
        }
        this.SzZ = jsRuntimeType;
        this.SzQ.getSharedPreferences("wcwebview", 0).edit().putString("V8type", jsRuntimeType.toString()).commit();
        AppMethodBeat.o(156792);
    }

    public final void Ej(boolean z) {
        AppMethodBeat.i(156793);
        if (z == this.SAa) {
            AppMethodBeat.o(156793);
            return;
        }
        this.SAa = z;
        if (this.SAa) {
            if (XWalkEnvironment.isIaDevice()) {
                XWalkEnvironment.setTestDownLoadUrl(this.SzQ, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml");
            } else {
                XWalkEnvironment.setTestDownLoadUrl(this.SzQ, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
            }
            SharedPreferences.Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
            edit.putLong("nLastFetchConfigTime", 0);
            edit.commit();
            l.g(WebView.c.WV_KIND_CW).excute("STR_CMD_CLEAR_SCHEDULER", null);
            AppMethodBeat.o(156793);
            return;
        }
        XWalkEnvironment.setTestDownLoadUrl(this.SzQ, "");
        SharedPreferences.Editor edit2 = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit2.putLong("nLastFetchConfigTime", 0);
        edit2.commit();
        l.g(WebView.c.WV_KIND_CW).excute("STR_CMD_CLEAR_SCHEDULER", null);
        AppMethodBeat.o(156793);
    }

    public final void hsI() {
        AppMethodBeat.i(156794);
        XWalkEnvironment.initTurnOnKVLog();
        this.SzQ.getSharedPreferences("wcwebview", 4).edit().putBoolean("m_bEnableLocalDebug", true).commit();
        AppMethodBeat.o(156794);
    }

    public final boolean hsJ() {
        AppMethodBeat.i(156795);
        boolean z = this.SzQ.getSharedPreferences("wcwebview", 4).getBoolean("m_bEnableLocalDebug", false);
        AppMethodBeat.o(156795);
        return z;
    }
}

package com.tencent.mm.plugin.appbrand;

import android.annotation.SuppressLint;
import android.os.Build;
import com.eclipsesource.v8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Locale;

public final class bc {
    public static void a(d dVar, i iVar) {
        AppMethodBeat.i(169480);
        s.a(iVar, b(dVar), new s.a() {
            /* class com.tencent.mm.plugin.appbrand.bc.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void onSuccess(String str) {
                AppMethodBeat.i(146925);
                Log.i("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Success: %s", "WASourceMap.js", str);
                AppMethodBeat.o(146925);
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void du(String str) {
                AppMethodBeat.i(146926);
                Log.e("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Failed: %s", "WASourceMap.js", str);
                AppMethodBeat.o(146926);
            }
        });
        iVar.evaluateJavascript(getSysInfo(), null);
        AppMethodBeat.o(169480);
    }

    public static String b(d dVar) {
        AppMethodBeat.i(169481);
        Log.i("MicroMsg.SourceMapUtil", "hy: injecting sourcemap.js");
        if (dVar == null) {
            Log.w("MicroMsg.SourceMapUtil", "hy: not valid runtime");
            AppMethodBeat.o(169481);
            return "";
        } else if (dVar.getRuntime() == null) {
            Log.w("MicroMsg.SourceMapUtil", "hy: runtime not prepared. do not try to inject sourcemap.js. maybe preloading");
            AppMethodBeat.o(169481);
            return "";
        } else if (j.a.vP(dVar.getRuntime().kAq.eix)) {
            Log.i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
            AppMethodBeat.o(169481);
            return "";
        } else {
            ICommLibReader iCommLibReader = (ICommLibReader) dVar.M(ICommLibReader.class);
            if (iCommLibReader == null) {
                Log.e("MicroMsg.SourceMapUtil", "execSourceMapScript NULL reader");
                AppMethodBeat.o(169481);
                return "";
            }
            String UM = iCommLibReader.UM("WASourceMap.js");
            AppMethodBeat.o(169481);
            return UM;
        }
    }

    public static String a(AppBrandRuntime appBrandRuntime, String str, String str2) {
        AppMethodBeat.i(146928);
        Log.i("MicroMsg.SourceMapUtil", "hy: getting sourcemap %s, %s", str, str2);
        if (appBrandRuntime == null || str == null || str.length() == 0) {
            Log.w("MicroMsg.SourceMapUtil", "runtime or jsRuntime or filePath is null.");
            AppMethodBeat.o(146928);
            return "";
        } else if (j.a.vP(appBrandRuntime.OT().leE.kNW)) {
            Log.i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
            AppMethodBeat.o(146928);
            return "";
        } else {
            String d2 = bg.d(appBrandRuntime, str + ".map");
            if (d2 == null || d2.length() == 0) {
                Log.i("MicroMsg.SourceMapUtil", "sourceMap of the script(%s) is null or nil.", str);
                AppMethodBeat.o(146928);
                return "";
            }
            String format = String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap['%s'] = %s)", str2 + str, d2);
            AppMethodBeat.o(146928);
            return format;
        }
    }

    public static ArrayList<ScriptPartObject> f(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(169482);
        Log.i("MicroMsg.SourceMapUtil", "buildSourceMapAppendList wxapkgPath: %s, filePath: %s", str, str2);
        ArrayList<ScriptPartObject> arrayList = new ArrayList<>();
        ScriptPartObject scriptPartObject = new ScriptPartObject();
        scriptPartObject.type = 1;
        scriptPartObject.content = String.format(Locale.US, "typeof __wxSourceMap !== 'undefined' && (__wxSourceMap['%s'] = ", str4);
        arrayList.add(scriptPartObject);
        ScriptPartObject scriptPartObject2 = new ScriptPartObject();
        scriptPartObject2.type = 2;
        scriptPartObject2.wxaPkgPath = str;
        scriptPartObject2.wxaFileName = str2;
        scriptPartObject2.wxaPkgKeyFilePath = str3;
        arrayList.add(scriptPartObject2);
        ScriptPartObject scriptPartObject3 = new ScriptPartObject();
        scriptPartObject3.type = 1;
        scriptPartObject3.content = ")";
        arrayList.add(scriptPartObject3);
        AppMethodBeat.o(169482);
        return arrayList;
    }

    public static boolean c(AppBrandRuntime appBrandRuntime, String str) {
        AppMethodBeat.i(169483);
        Log.i("MicroMsg.SourceMapUtil", "is sourcemap exist: %s", str);
        if (appBrandRuntime == null || str == null || str.length() == 0) {
            Log.w("MicroMsg.SourceMapUtil", "runtime or jsRuntime or filePath is null.");
            AppMethodBeat.o(169483);
            return false;
        } else if (j.a.vP(appBrandRuntime.OT().leE.kNW)) {
            Log.i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
            AppMethodBeat.o(169483);
            return false;
        } else {
            boolean g2 = bg.g(appBrandRuntime, str + ".map");
            AppMethodBeat.o(169483);
            return g2;
        }
    }

    @SuppressLint({"DefaultLocal"})
    public static String getSysInfo() {
        AppMethodBeat.i(146929);
        String format = String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap.__system = 'Android %s')", Build.VERSION.RELEASE);
        AppMethodBeat.o(146929);
        return format;
    }
}

package com.tencent.mm.plugin.appbrand.utils;

import com.eclipsesource.v8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.bc;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class t {
    private static String ohb;

    public enum a {
        LIB,
        USR;

        public static a valueOf(String str) {
            AppMethodBeat.i(147721);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(147721);
            return aVar;
        }

        static {
            AppMethodBeat.i(147722);
            AppMethodBeat.o(147722);
        }
    }

    public static void a(s sVar, i iVar, String str, String str2, String str3, int i2, String str4, a aVar, s.a aVar2) {
        AppMethodBeat.i(147723);
        if (sVar == null) {
            Log.w("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
            AppMethodBeat.o(147723);
            return;
        }
        String a2 = a(sVar, aVar);
        s.a(iVar, a2 + str, str2, str3, i2, str4, sVar.dG(str), aVar2);
        AppMethodBeat.o(147723);
    }

    private static String bZt() {
        AppMethodBeat.i(182997);
        if (Util.isNullOrNil(ohb)) {
            ohb = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/wasae.dat";
        }
        String str = ohb;
        AppMethodBeat.o(182997);
        return str;
    }

    public static void a(AppBrandRuntime appBrandRuntime, i iVar, String str, q.a aVar, s.a aVar2) {
        AppMethodBeat.i(230011);
        if (appBrandRuntime == null || appBrandRuntime.NY() == null) {
            Log.e("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: virtualAccessScriptPath[%s] runtime or service is null!", str);
            AppMethodBeat.o(230011);
            return;
        }
        String str2 = LaunchParcel.Wf(aVar.fileName).replace('/', '_') + "_" + aVar.kKF;
        String str3 = aVar.kKG;
        String a2 = a(appBrandRuntime.NY(), a.USR);
        if (a2.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            a2 = a2.substring(0, a2.length() - 1);
        }
        String str4 = a2 + n.We(str);
        if (bc.c(appBrandRuntime, str)) {
            Log.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject sourceMap appId[%s] virtualAccessScriptPath[%s]", appBrandRuntime.mAppId, str);
            s.a(iVar, bc.f(aVar.kKI, aVar.fileName + ".map", bZt(), str4), null, null, null, null);
        }
        Log.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject wxa script with appId:%s, virtualPath:%s, fileEntry.name:%s, sourceURL:%s, cacheCategory:%s, cacheKey:%s", appBrandRuntime.mAppId, str, aVar.fileName, str4, str2, str3);
        ScriptPartObject scriptPartObject = new ScriptPartObject();
        scriptPartObject.type = 2;
        scriptPartObject.wxaPkgPath = aVar.kKI;
        scriptPartObject.wxaFileName = aVar.fileName;
        scriptPartObject.wxaPkgKeyFilePath = bZt();
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(scriptPartObject);
        s.a(iVar, arrayList, str4, str2, str3, aVar2);
        AppMethodBeat.o(230011);
    }

    public static void a(AppBrandRuntime appBrandRuntime, i iVar, String str, String str2, String str3, String str4, a aVar, s.a aVar2) {
        String str5;
        AppMethodBeat.i(169540);
        if (appBrandRuntime == null || appBrandRuntime.NY() == null) {
            Log.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
            AppMethodBeat.o(169540);
            return;
        }
        String We = n.We(str2);
        if (We.startsWith("/__APP__")) {
            str5 = n.We(We.substring(8));
        } else {
            str5 = We;
        }
        String a2 = a(appBrandRuntime.NY(), aVar);
        if (bc.c(appBrandRuntime, str2)) {
            Log.i("MicroMsg.JsValidationInjectorWC", "inject sourceMap appId[%s] filePath[%s]", appBrandRuntime.mAppId, str2);
            s.a(iVar, bc.f(str, str5 + ".map", bZt(), a2 + str2), a2 + str2, str3, str4, aVar2);
        }
        ScriptPartObject scriptPartObject = new ScriptPartObject();
        scriptPartObject.type = 2;
        scriptPartObject.wxaPkgPath = str;
        scriptPartObject.wxaFileName = str5;
        scriptPartObject.wxaPkgKeyFilePath = bZt();
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(scriptPartObject);
        s.a(iVar, arrayList, a2 + str2, str3, str4, aVar2);
        AppMethodBeat.o(169540);
    }

    public static String a(com.tencent.mm.plugin.appbrand.s sVar, a aVar) {
        AppMethodBeat.i(147726);
        String str = "";
        if (aVar == a.LIB) {
            str = sVar.Ou();
        } else if (aVar == a.USR) {
            str = sVar.Ot();
        }
        AppMethodBeat.o(147726);
        return str;
    }
}

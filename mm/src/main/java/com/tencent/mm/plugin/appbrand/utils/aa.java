package com.tencent.mm.plugin.appbrand.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

public final class aa {
    public static String m(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(227741);
        if (!TextUtils.isEmpty(appBrandInitConfigWC.ldR)) {
            String str = appBrandInitConfigWC.ldR;
            AppMethodBeat.o(227741);
            return str;
        }
        String str2 = appBrandInitConfigWC.cys.ler;
        AppMethodBeat.o(227741);
        return str2;
    }

    public static boolean n(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(227742);
        if (!TextUtils.isEmpty(appBrandInitConfigWC.ldR)) {
            AppMethodBeat.o(227742);
            return true;
        }
        AppMethodBeat.o(227742);
        return false;
    }

    public static String a(q qVar, String str, String str2) {
        String str3;
        OutputStream outputStream = null;
        AppMethodBeat.i(49316);
        Uri parse = Uri.parse(str2);
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(MMApplicationContext.getContext().getContentResolver().openInputStream(parse));
            try {
                String path = parse.getPath();
                int lastIndexOf = path.lastIndexOf(46);
                if (lastIndexOf != -1) {
                    str3 = path.substring(lastIndexOf);
                } else {
                    str3 = "";
                }
                if (!TextUtils.isEmpty(str3) && !str3.startsWith(".")) {
                    str3 = ".".concat(String.valueOf(str3));
                }
                String z = com.tencent.mm.vfs.aa.z(new o(str, "opensdkfile_" + System.currentTimeMillis() + str3).her());
                try {
                    outputStream = s.ap(new o(z));
                    e.copyStream(bufferedInputStream, outputStream);
                    i<String> iVar = new i<>();
                    qVar.OK().a(new o(z), str3, true, iVar);
                    return iVar.value;
                } catch (FileNotFoundException e2) {
                    Log.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", e2, "", new Object[0]);
                    Util.qualityClose(bufferedInputStream);
                    Util.qualityClose(outputStream);
                    AppMethodBeat.o(49316);
                    return "";
                }
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", e3, "", new Object[0]);
                return "";
            } finally {
                Util.qualityClose(bufferedInputStream);
                Util.qualityClose(outputStream);
                AppMethodBeat.o(49316);
            }
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", e4, "", new Object[0]);
            AppMethodBeat.o(49316);
            return "";
        }
    }

    public static boolean afL(String str) {
        AppMethodBeat.i(49317);
        if (str == null || !str.startsWith("content://")) {
            AppMethodBeat.o(49317);
            return false;
        }
        AppMethodBeat.o(49317);
        return true;
    }
}

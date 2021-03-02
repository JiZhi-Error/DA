package com.tencent.mm.plugin.webview.e;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URI;
import java.net.URISyntaxException;

public final class b {
    private static String byB(String str) {
        AppMethodBeat.i(79104);
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getScheme()).append("://");
        sb.append(parse.getHost()).append(":").append(parse.getPort());
        if (Util.isNullOrNil(parse.getPathSegments())) {
            sb.append(FilePathGenerator.ANDROID_DIR_SEP);
        } else {
            for (String str2 : parse.getPathSegments()) {
                sb.append(FilePathGenerator.ANDROID_DIR_SEP).append(str2);
            }
        }
        if (!Util.isNullOrNil(parse.getQuery())) {
            sb.append("?").append(parse.getQuery());
        }
        if (!Util.isNullOrNil(parse.getFragment())) {
            sb.append("#").append(parse.getFragment());
        }
        if (str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            sb.append(FilePathGenerator.ANDROID_DIR_SEP);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(79104);
        return sb2;
    }

    public static String byC(String str) {
        AppMethodBeat.i(79105);
        String byA = byA(str);
        if (Util.isNullOrNil(byA)) {
            AppMethodBeat.o(79105);
            return null;
        }
        String host = Uri.parse(byA).getHost();
        AppMethodBeat.o(79105);
        return host;
    }

    public static String byD(String str) {
        AppMethodBeat.i(79106);
        String byA = byA(str);
        if (Util.isNullOrNil(byA)) {
            Log.e("MicroMsg.WebViewCacheUtils", "evaluateResURLWithScheme, original url is invalid = %s", str);
            AppMethodBeat.o(79106);
            return null;
        }
        Uri parse = Uri.parse(byA);
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getScheme()).append("://").append(parse.getHost()).append(":").append(parse.getPort());
        if (!Util.isNullOrNil(parse.getPathSegments())) {
            for (String str2 : parse.getPathSegments()) {
                sb.append(FilePathGenerator.ANDROID_DIR_SEP).append(Util.nullAsNil(str2));
            }
        }
        if (str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            sb.append(FilePathGenerator.ANDROID_DIR_SEP);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(79106);
        return sb2;
    }

    private static String byA(String str) {
        AppMethodBeat.i(79103);
        if (!com.tencent.mm.plugin.webview.luggage.c.b.afC(str)) {
            AppMethodBeat.o(79103);
            return null;
        }
        try {
            URI uri = new URI(str);
            String lowerCase = Util.nullAsNil(uri.getScheme()).toLowerCase();
            String lowerCase2 = Util.nullAsNil(uri.getHost()).toLowerCase();
            if (Util.isNullOrNil(lowerCase2)) {
                AppMethodBeat.o(79103);
                return null;
            }
            String str2 = lowerCase + "://" + lowerCase2 + ":" + (uri.getPort() == -1 ? lowerCase.equalsIgnoreCase("http") ? 80 : 443 : uri.getPort()) + FilePathGenerator.ANDROID_DIR_SEP + Util.nullAsNil(uri.getPath()) + (Util.isNullOrNil(uri.getQuery()) ? "" : "?" + uri.getQuery()) + (Util.isNullOrNil(uri.getFragment()) ? "" : "#" + uri.getFragment());
            if (str2.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str2 = str2 + FilePathGenerator.ANDROID_DIR_SEP;
            }
            String byB = byB(str2);
            AppMethodBeat.o(79103);
            return byB;
        } catch (URISyntaxException e2) {
            Log.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL URISyntaxException : %s", e2.getMessage());
            AppMethodBeat.o(79103);
            return str;
        } catch (Exception e3) {
            Log.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL normal : %s", e3.getMessage());
            AppMethodBeat.o(79103);
            return str;
        }
    }
}

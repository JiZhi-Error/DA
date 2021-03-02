package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class URLUtil extends z {
    public static String guessUrl(String str) {
        AppMethodBeat.i(54943);
        if (isX5Core()) {
            String guessUrl = getX5CoreUrlUtilImpl().guessUrl(str);
            AppMethodBeat.o(54943);
            return guessUrl;
        }
        String guessUrl2 = android.webkit.URLUtil.guessUrl(str);
        AppMethodBeat.o(54943);
        return guessUrl2;
    }

    public static String composeSearchUrl(String str, String str2, String str3) {
        AppMethodBeat.i(54944);
        if (isX5Core()) {
            String composeSearchUrl = getX5CoreUrlUtilImpl().composeSearchUrl(str, str2, str3);
            AppMethodBeat.o(54944);
            return composeSearchUrl;
        }
        String composeSearchUrl2 = android.webkit.URLUtil.composeSearchUrl(str, str2, str3);
        AppMethodBeat.o(54944);
        return composeSearchUrl2;
    }

    public static byte[] decode(byte[] bArr) {
        AppMethodBeat.i(54945);
        if (isX5Core()) {
            byte[] decode = getX5CoreUrlUtilImpl().decode(bArr);
            AppMethodBeat.o(54945);
            return decode;
        }
        byte[] decode2 = android.webkit.URLUtil.decode(bArr);
        AppMethodBeat.o(54945);
        return decode2;
    }

    public static boolean isAssetUrl(String str) {
        AppMethodBeat.i(54946);
        if (isX5Core()) {
            boolean isAssetUrl = getX5CoreUrlUtilImpl().isAssetUrl(str);
            AppMethodBeat.o(54946);
            return isAssetUrl;
        }
        boolean isAssetUrl2 = android.webkit.URLUtil.isAssetUrl(str);
        AppMethodBeat.o(54946);
        return isAssetUrl2;
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String str) {
        AppMethodBeat.i(54947);
        if (isX5Core()) {
            boolean isCookielessProxyUrl = getX5CoreUrlUtilImpl().isCookielessProxyUrl(str);
            AppMethodBeat.o(54947);
            return isCookielessProxyUrl;
        }
        boolean isCookielessProxyUrl2 = android.webkit.URLUtil.isCookielessProxyUrl(str);
        AppMethodBeat.o(54947);
        return isCookielessProxyUrl2;
    }

    public static boolean isFileUrl(String str) {
        AppMethodBeat.i(54948);
        if (isX5Core()) {
            boolean isFileUrl = getX5CoreUrlUtilImpl().isFileUrl(str);
            AppMethodBeat.o(54948);
            return isFileUrl;
        }
        boolean isFileUrl2 = android.webkit.URLUtil.isFileUrl(str);
        AppMethodBeat.o(54948);
        return isFileUrl2;
    }

    public static boolean isAboutUrl(String str) {
        AppMethodBeat.i(54949);
        if (isX5Core()) {
            boolean isAboutUrl = getX5CoreUrlUtilImpl().isAboutUrl(str);
            AppMethodBeat.o(54949);
            return isAboutUrl;
        }
        boolean isAboutUrl2 = android.webkit.URLUtil.isAboutUrl(str);
        AppMethodBeat.o(54949);
        return isAboutUrl2;
    }

    public static boolean isDataUrl(String str) {
        AppMethodBeat.i(54950);
        if (isX5Core()) {
            boolean isDataUrl = getX5CoreUrlUtilImpl().isDataUrl(str);
            AppMethodBeat.o(54950);
            return isDataUrl;
        }
        boolean isDataUrl2 = android.webkit.URLUtil.isDataUrl(str);
        AppMethodBeat.o(54950);
        return isDataUrl2;
    }

    public static boolean isJavaScriptUrl(String str) {
        AppMethodBeat.i(54951);
        if (isX5Core()) {
            boolean isJavaScriptUrl = getX5CoreUrlUtilImpl().isJavaScriptUrl(str);
            AppMethodBeat.o(54951);
            return isJavaScriptUrl;
        }
        boolean isJavaScriptUrl2 = android.webkit.URLUtil.isJavaScriptUrl(str);
        AppMethodBeat.o(54951);
        return isJavaScriptUrl2;
    }

    public static boolean isHttpUrl(String str) {
        AppMethodBeat.i(54952);
        if (isX5Core()) {
            boolean isHttpUrl = getX5CoreUrlUtilImpl().isHttpUrl(str);
            AppMethodBeat.o(54952);
            return isHttpUrl;
        }
        boolean isHttpUrl2 = android.webkit.URLUtil.isHttpUrl(str);
        AppMethodBeat.o(54952);
        return isHttpUrl2;
    }

    public static boolean isHttpsUrl(String str) {
        AppMethodBeat.i(54953);
        if (isX5Core()) {
            boolean isHttpsUrl = getX5CoreUrlUtilImpl().isHttpsUrl(str);
            AppMethodBeat.o(54953);
            return isHttpsUrl;
        }
        boolean isHttpsUrl2 = android.webkit.URLUtil.isHttpsUrl(str);
        AppMethodBeat.o(54953);
        return isHttpsUrl2;
    }

    public static boolean isNetworkUrl(String str) {
        AppMethodBeat.i(54954);
        if (isX5Core()) {
            boolean isNetworkUrl = getX5CoreUrlUtilImpl().isNetworkUrl(str);
            AppMethodBeat.o(54954);
            return isNetworkUrl;
        }
        boolean isNetworkUrl2 = android.webkit.URLUtil.isNetworkUrl(str);
        AppMethodBeat.o(54954);
        return isNetworkUrl2;
    }

    public static boolean isContentUrl(String str) {
        AppMethodBeat.i(54955);
        if (isX5Core()) {
            boolean isContentUrl = getX5CoreUrlUtilImpl().isContentUrl(str);
            AppMethodBeat.o(54955);
            return isContentUrl;
        }
        boolean isContentUrl2 = android.webkit.URLUtil.isContentUrl(str);
        AppMethodBeat.o(54955);
        return isContentUrl2;
    }

    public static boolean isValidUrl(String str) {
        AppMethodBeat.i(54956);
        if (isX5Core()) {
            boolean isValidUrl = getX5CoreUrlUtilImpl().isValidUrl(str);
            AppMethodBeat.o(54956);
            return isValidUrl;
        }
        boolean isValidUrl2 = android.webkit.URLUtil.isValidUrl(str);
        AppMethodBeat.o(54956);
        return isValidUrl2;
    }

    public static String stripAnchor(String str) {
        AppMethodBeat.i(54957);
        if (isX5Core()) {
            String stripAnchor = getX5CoreUrlUtilImpl().stripAnchor(str);
            AppMethodBeat.o(54957);
            return stripAnchor;
        }
        String stripAnchor2 = android.webkit.URLUtil.stripAnchor(str);
        AppMethodBeat.o(54957);
        return stripAnchor2;
    }

    public static final String guessFileName(String str, String str2, String str3) {
        AppMethodBeat.i(54958);
        do {
        } while (isX5Core());
        String guessFileName = android.webkit.URLUtil.guessFileName(str, str2, str3);
        AppMethodBeat.o(54958);
        return guessFileName;
    }
}

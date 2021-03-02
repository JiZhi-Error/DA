package com.tencent.smtt.export.external.interfaces;

public interface IX5CoreUrlUtil {
    String composeSearchUrl(String str, String str2, String str3);

    byte[] decode(byte[] bArr);

    String guessFileName(String str, String str2, String str3);

    String guessUrl(String str);

    boolean isAboutUrl(String str);

    boolean isAssetUrl(String str);

    boolean isContentUrl(String str);

    boolean isCookielessProxyUrl(String str);

    boolean isDataUrl(String str);

    boolean isFileUrl(String str);

    boolean isHttpUrl(String str);

    boolean isHttpsUrl(String str);

    boolean isJavaScriptUrl(String str);

    boolean isNetworkUrl(String str);

    boolean isValidUrl(String str);

    String stripAnchor(String str);
}

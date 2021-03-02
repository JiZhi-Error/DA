package com.tencent.smtt.export.external.interfaces;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.easel.interfaces.IEaselView;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import java.util.Map;

public interface IX5CoreMessy {
    boolean canOpenFile(Context context, String str);

    void checkTrim(int i2);

    void clearAdWebviewInfo();

    void clearAllPermanentPermission();

    void closeFileReader();

    void closeMiniQB();

    void createCacheWebView(Context context);

    IX5DateSorter createDateSorter(Context context);

    IX5WebChromeClient createDefaultX5WebChromeClient();

    IX5WebViewClientExtension createDefaultX5WebChromeClientExtension();

    IX5WebViewClient createDefaultX5WebViewClient();

    IEaselView createEaselView(Context context);

    boolean createMiniQBShortCut(Context context, String str, String str2, Bitmap bitmap);

    void destoryScaleManager();

    void doSearch(Context context, String str, IX5WebViewBase iX5WebViewBase, String str2);

    void doWupTask();

    void fileInfoDetect(Context context, String str, ValueCallback<String> valueCallback);

    Bundle getAdWebViewInfoFromX5Core();

    String getCrashExtraMessage();

    IX5WebViewBase getCurrentMainWebviewJustForQQandWechat();

    String getDefaultUserAgent(Context context);

    String getExtendRule(Context context, String str);

    String getGUID();

    String getMiniQBVersion();

    String getTbsVersion();

    boolean getX5RenderPerformDebug();

    boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle);

    boolean isMiniQBShortCutExist(Context context, String str);

    boolean isWritingWebCoreLogToFile();

    String mimeTypeMapGetExtensionFromMimeType(String str);

    String mimeTypeMapGetFileExtensionFromUrl(String str);

    String mimeTypeMapGetMimeTypeFromExtension(String str);

    boolean mimeTypeMapHasExtension(String str);

    boolean mimeTypeMapHasMimeType(String str);

    Uri[] parseFileChooserResult(int i2, Intent intent);

    void prefetchResource(Context context, String str, Map<String, String> map);

    void pvUploadNotifybyUI();

    void refreshJavaCoreApnState();

    void setAdWebviewInfo(int i2, String str, String str2, String str3, int i3, String str4, int i4, int i5);

    void setAdWebviewShouldShow(boolean z);

    void setGuidToTbs(byte[] bArr, byte[] bArr2, long j2);

    void setQBSmttService(Object obj);

    void setTbsInitPerformanceData(int i2, Map<String, String> map);

    void setWebContentsDebuggingEnabled(boolean z);

    void setWebCoreLogWrite2FileFlag(boolean z, String str);

    void setWebViewPoolSize(Context context, int i2);

    void setX5RenderPerformDebug(boolean z);

    int startMiniQB(Context context, String str, Map<String, String> map, ValueCallback<String> valueCallback);

    int startQBWeb(Context context, String str, String str2, Map<String, String> map);

    void switchContext(IX5WebViewBase iX5WebViewBase, Context context);

    void traceBegin(int i2, String str);

    void traceEnd(int i2, String str);

    void uploadWebCoreLog2Server();
}

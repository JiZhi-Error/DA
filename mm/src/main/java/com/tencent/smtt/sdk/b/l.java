package com.tencent.smtt.sdk.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.easel.interfaces.IEaselView;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.sdk.TbsReaderView;
import com.tencent.smtt.sdk.TbsWizard;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;

public class l implements IX5CoreMessy {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f2002a;

    l(DexLoader dexLoader, Context context) {
        this.f2002a = dexLoader;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public String getTbsVersion() {
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void traceBegin(int i2, String str) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void traceEnd(int i2, String str) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void setWebContentsDebuggingEnabled(boolean z) {
        AppMethodBeat.i(188464);
        this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webview_setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        AppMethodBeat.o(188464);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void checkTrim(int i2) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void switchContext(IX5WebViewBase iX5WebViewBase, Context context) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public IX5WebChromeClient createDefaultX5WebChromeClient() {
        AppMethodBeat.i(188465);
        if (this.f2002a == null) {
            AppMethodBeat.o(188465);
            return null;
        }
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188465);
            return null;
        }
        IX5WebChromeClient iX5WebChromeClient = (IX5WebChromeClient) invokeStaticMethod;
        AppMethodBeat.o(188465);
        return iX5WebChromeClient;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public IX5WebViewClient createDefaultX5WebViewClient() {
        AppMethodBeat.i(188466);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "createDefaultX5WebViewClient", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188466);
            return null;
        }
        IX5WebViewClient iX5WebViewClient = (IX5WebViewClient) invokeStaticMethod;
        AppMethodBeat.o(188466);
        return iX5WebViewClient;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public IX5WebViewClientExtension createDefaultX5WebChromeClientExtension() {
        AppMethodBeat.i(188467);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188467);
            return null;
        }
        IX5WebViewClientExtension iX5WebViewClientExtension = (IX5WebViewClientExtension) invokeStaticMethod;
        AppMethodBeat.o(188467);
        return iX5WebViewClientExtension;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public IEaselView createEaselView(Context context) {
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public Uri[] parseFileChooserResult(int i2, Intent intent) {
        AppMethodBeat.i(188468);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "parseFileChooserResult", new Class[]{Integer.TYPE, Intent.class}, Integer.valueOf(i2), intent);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188468);
            return null;
        }
        Uri[] uriArr = (Uri[]) invokeStaticMethod;
        AppMethodBeat.o(188468);
        return uriArr;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public IX5DateSorter createDateSorter(Context context) {
        AppMethodBeat.i(188469);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "createDateSorter", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188469);
            return null;
        }
        IX5DateSorter iX5DateSorter = (IX5DateSorter) invokeStaticMethod;
        AppMethodBeat.o(188469);
        return iX5DateSorter;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void clearAllPermanentPermission() {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void destoryScaleManager() {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void uploadWebCoreLog2Server() {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void setWebCoreLogWrite2FileFlag(boolean z, String str) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public boolean isWritingWebCoreLogToFile() {
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void setX5RenderPerformDebug(boolean z) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public boolean getX5RenderPerformDebug() {
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void doSearch(Context context, String str, IX5WebViewBase iX5WebViewBase, String str2) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public String getDefaultUserAgent(Context context) {
        AppMethodBeat.i(188470);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "getDefaultUserAgent", new Class[]{Context.class}, context);
        if (invokeStaticMethod instanceof String) {
            String str = (String) invokeStaticMethod;
            AppMethodBeat.o(188470);
            return str;
        }
        AppMethodBeat.o(188470);
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public Bundle getAdWebViewInfoFromX5Core() {
        AppMethodBeat.i(188471);
        Bundle bundle = (Bundle) this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
        AppMethodBeat.o(188471);
        return bundle;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void setAdWebviewInfo(int i2, String str, String str2, String str3, int i3, String str4, int i4, int i5) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void clearAdWebviewInfo() {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void setAdWebviewShouldShow(boolean z) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public String getCrashExtraMessage() {
        String str = null;
        AppMethodBeat.i(188472);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, Boolean.TRUE, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        if (invokeStaticMethod == null) {
            invokeStaticMethod = this.f2002a.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        }
        if (invokeStaticMethod != null) {
            str = String.valueOf(invokeStaticMethod) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
        }
        if (str == null) {
            AppMethodBeat.o(188472);
            return "X5 core get nothing...";
        }
        AppMethodBeat.o(188472);
        return str;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void doWupTask() {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public String mimeTypeMapGetFileExtensionFromUrl(String str) {
        AppMethodBeat.i(188473);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "mimeTypeMapGetFileExtensionFromUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188473);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.o(188473);
        return str2;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public boolean mimeTypeMapHasMimeType(String str) {
        AppMethodBeat.i(188474);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "mimeTypeMapHasMimeType", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188474);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188474);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public String mimeTypeMapGetMimeTypeFromExtension(String str) {
        AppMethodBeat.i(188475);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188475);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.o(188475);
        return str2;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public boolean mimeTypeMapHasExtension(String str) {
        AppMethodBeat.i(188476);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "mimeTypeMapHasExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188476);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188476);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public String mimeTypeMapGetExtensionFromMimeType(String str) {
        AppMethodBeat.i(188477);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188477);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.o(188477);
        return str2;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public int startMiniQB(Context context, String str, Map<String, String> map, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(188478);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "startMiniQB", new Class[]{Context.class, String.class, Map.class, ValueCallback.class}, context, str, map, valueCallback);
        if (invokeStaticMethod == null) {
            invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "startMiniQB", new Class[]{Context.class, String.class, Map.class}, context, str, map);
        }
        if (invokeStaticMethod == null) {
            invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "startMiniQB", new Class[]{Context.class, String.class}, context, str);
        }
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188478);
            return -3;
        }
        int intValue = ((Integer) invokeStaticMethod).intValue();
        AppMethodBeat.o(188478);
        return intValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public int startQBWeb(Context context, String str, String str2, Map<String, String> map) {
        return 0;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public boolean canOpenFile(Context context, String str) {
        AppMethodBeat.i(188479);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "canOpenFile", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
            AppMethodBeat.o(188479);
            return booleanValue;
        }
        AppMethodBeat.o(188479);
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void closeFileReader() {
        AppMethodBeat.i(188480);
        this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "closeFileReader", new Class[0], new Object[0]);
        AppMethodBeat.o(188480);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void closeMiniQB() {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public boolean createMiniQBShortCut(Context context, String str, String str2, Bitmap bitmap) {
        AppMethodBeat.i(188481);
        TbsLog.e("X5CoreMessyImpl", "qbsdk createMiniQBShortCut");
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
        TbsLog.e("X5CoreMessyImpl", "qbsdk after createMiniQBShortCut ret: ".concat(String.valueOf(invokeStaticMethod)));
        if (invokeStaticMethod != null) {
            AppMethodBeat.o(188481);
            return true;
        }
        AppMethodBeat.o(188481);
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public boolean isMiniQBShortCutExist(Context context, String str) {
        Boolean bool;
        AppMethodBeat.i(188482);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod != null) {
            Boolean bool2 = Boolean.FALSE;
            if (invokeStaticMethod instanceof Boolean) {
                bool = (Boolean) invokeStaticMethod;
            } else {
                bool = bool2;
            }
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(188482);
            return booleanValue;
        }
        AppMethodBeat.o(188482);
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(188483);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188483);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188483);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void setGuidToTbs(byte[] bArr, byte[] bArr2, long j2) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public String getExtendRule(Context context, String str) {
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void setQBSmttService(Object obj) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public String getMiniQBVersion() {
        AppMethodBeat.i(188484);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "getMiniQBVersion", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188484);
            return null;
        }
        String str = (String) invokeStaticMethod;
        AppMethodBeat.o(188484);
        return str;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public IX5WebViewBase getCurrentMainWebviewJustForQQandWechat() {
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void setTbsInitPerformanceData(int i2, Map<String, String> map) {
        AppMethodBeat.i(188485);
        this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "setTbsInitPerformanceData", new Class[]{Integer.TYPE, Map.class}, Integer.valueOf(i2), map);
        AppMethodBeat.o(188485);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public String getGUID() {
        AppMethodBeat.i(188486);
        Object invokeStaticMethod = this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "getGUID", new Class[0], new Object[0]);
        if (invokeStaticMethod == null || !(invokeStaticMethod instanceof String)) {
            AppMethodBeat.o(188486);
            return null;
        }
        String str = (String) invokeStaticMethod;
        AppMethodBeat.o(188486);
        return str;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void createCacheWebView(Context context) {
        AppMethodBeat.i(188487);
        this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "createCacheWebView", new Class[]{Context.class}, context);
        AppMethodBeat.o(188487);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void setWebViewPoolSize(Context context, int i2) {
        AppMethodBeat.i(188488);
        this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "setWebViewPoolSize", new Class[]{Context.class, Integer.TYPE}, context, Integer.valueOf(i2));
        AppMethodBeat.o(188488);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void prefetchResource(Context context, String str, Map<String, String> map) {
        AppMethodBeat.i(188489);
        this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "prefetchResource", new Class[]{Context.class, String.class, Map.class}, context, str, map);
        AppMethodBeat.o(188489);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void refreshJavaCoreApnState() {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void pvUploadNotifybyUI() {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreMessy
    public void fileInfoDetect(Context context, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(188490);
        try {
            this.f2002a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "fileInfoDetect", new Class[]{Context.class, String.class, ValueCallback.class}, context, str, valueCallback);
            AppMethodBeat.o(188490);
        } catch (Throwable th) {
            AppMethodBeat.o(188490);
        }
    }
}

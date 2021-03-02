package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteapp.a;
import com.tencent.liteapp.b.b;
import com.tencent.liteapp.c.g;
import com.tencent.liteapp.jsapi.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class LiteAppCenter {
    public static final String LITE_APP_BASE_LIB = "wxalitebaselibrary";
    private static final String TAG = "WxaLiteApp.LiteAppCenter";
    private static String lastPath = "";
    private static IWxaLiteAppCallback mCallback;
    private static Map<Long, ILiteAppUICallback> mUICallback = new ConcurrentHashMap();
    private static long pageId = -1;
    private static HashMap<Long, PageInfo> pageInfos = new HashMap<>();
    private static Map<String, Map<String, Class<? extends a>>> sAppLevelApi = new ConcurrentHashMap();
    private static Map<String, Class<? extends a>> sCommApi = new ConcurrentHashMap();
    private static HashMap<Long, SystemInfoChangeCallbackInfo> systemInfoChangeCallback = new HashMap<>();

    public static class HostInfo {
        public String appBranch = "";
        public String appBuildJob = "";
        public String appBuildTime = "";
        public String appFlavor = "";
        public String appRevision = "";
        public String appVersion = "";
        public Map<String, String> otherExtends;
        public String system = "";
        public String systemVersion = "";
    }

    public interface ILiteAppUICallback {
        boolean hasCutOut();

        void navigateBack();

        void onCheckSumFail(String str, List<String> list);

        void setFlags(int i2);

        void showPage(PageInfo pageInfo);
    }

    public interface IWxaLiteAppCallback {
        String[] getAppInfo(String str);

        HostInfo getHostInfo();

        String getLiteAppRoot();

        String getOfflineResource(String str, String str2, String str3);

        SystemInfo getSystemInfo();

        String getUin();

        String getUserAgent();

        void hideKeyboard();

        void openPage(String str, String str2, String str3, String str4);

        void reloadDebug(String str, String str2);

        void reportIdKey(long j2, long j3, long j4);

        void reportKv(int i2, String str);
    }

    private static native PageInfo _showIndexView(String str, String str2, String str3, String str4);

    private static native PageInfo _showView(String str, String str2, String str3, String str4, String str5);

    private static native void addJsApi(String str);

    private static native void addJsApi(String str, String str2);

    public static native String getAuthUrl(String str, String str2, String str3);

    public static native String getBaseLibBuildTypeByPath(String str);

    public static native String getBaseLibBuildTypeByString(String str);

    public static native String getBaseLibVersionByPath(String str);

    public static native String getBaseLibVersionByString(String str);

    public static native String getLiteAppVersion(String str, String str2, String str3);

    public static native void jsApiCallback(String str, long j2, long j3, long j4, String str2, boolean z);

    public static native void onEventTriggered(String str, String str2);

    public static native void preloadIndexView(String str, String str2, String str3);

    public static native void preloadView(String str, String str2, String str3, String str4);

    private static native void preloadViewBaseLib(int i2);

    public static native void publishGlobalEvent(long j2, long j3, String str);

    public static native void setAuthInfo(String str, String str2, Map<String, String> map, Map<String, String> map2);

    private static native void setDarkMode(boolean z);

    public static native void setDisplayParams(float f2, float f3, float f4, float f5, int i2, float f6, float f7, float f8, float f9);

    public static native void setPath(String str, HostInfo hostInfo);

    public static native void setSafeAreaInsets(float f2, float f3, float f4, float f5);

    static {
        System.loadLibrary("mmv8");
        System.loadLibrary("flutter");
        System.loadLibrary("wechatlv");
        System.loadLibrary("wxajs");
        System.loadLibrary("wcwss");
        System.loadLibrary("owl");
    }

    /* access modifiers changed from: package-private */
    public static class SystemInfoChangeCallbackInfo {
        public String appId;
        public long appPtr;
        public long callbackId;
        public long pageId;

        public SystemInfoChangeCallbackInfo(String str, long j2, long j3, long j4) {
            this.appId = str;
            this.appPtr = j2;
            this.pageId = j3;
            this.callbackId = j4;
        }
    }

    public static class PageInfo {
        public long appPtr;
        public long appUuid;
        public String basePath;
        public int flags;
        public long pageId;
        public String pageUrl;
        public long renderId;
        public boolean success;

        public PageInfo(boolean z, long j2, long j3, long j4, long j5, String str, String str2, int i2) {
            this.success = z;
            this.appUuid = j2;
            this.appPtr = j3;
            this.pageId = j4;
            this.renderId = j5;
            this.basePath = str;
            this.pageUrl = str2;
            this.flags = i2;
        }

        public String toString() {
            AppMethodBeat.i(197907);
            String str = "PageInfo{success=" + this.success + ", uuid=" + this.appUuid + ", appPtr=" + this.appPtr + ", pageId=" + this.pageId + ", renderId=" + this.renderId + ", basePath='" + this.basePath + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", flags=" + this.flags + '}';
            AppMethodBeat.o(197907);
            return str;
        }
    }

    public static class JsApi {
        public String appId;
        public long appPtr;
        public long callbackId;
        public String method;
        public long pageId;
        public String param;

        public JsApi(String str, long j2, long j3, String str2, String str3, long j4) {
            this.appId = str;
            this.appPtr = j2;
            this.pageId = j3;
            this.method = str2;
            this.param = str3;
            this.callbackId = j4;
        }

        public String toString() {
            AppMethodBeat.i(197906);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("appid:").append(this.appId).append(" appPtr:").append(this.appPtr).append(" pageId:").append(this.pageId).append(" method:").append(this.method).append(" param:").append(this.param).append(" callback:").append(this.callbackId);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(197906);
            return stringBuffer2;
        }
    }

    public static class SystemInfo {
        public String brand = "";
        public boolean darkMode = false;
        public String language = "";
        public String model = "";
        public float navigationBarHeight = 0.0f;
        public String networkType = "";
        public float pixelRatio = 0.0f;
        public String platform = "";
        public float statusBarHeight = 0.0f;
        public String system = "";
        public float titleBarHeight = 0.0f;
        public String version = "";

        public String toJasonString() {
            AppMethodBeat.i(197908);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("networkType", this.networkType);
                jSONObject.put("brand", this.brand);
                jSONObject.put("model", this.model);
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, this.language);
                jSONObject.put(TPDownloadProxyEnum.USER_PLATFORM, this.platform);
                jSONObject.put("system", this.system);
                jSONObject.put("version", this.version);
                jSONObject.put("pixelRatio", (double) this.pixelRatio);
                jSONObject.put("navigationBarHeight", (double) this.navigationBarHeight);
                jSONObject.put("statusBarHeight", (double) this.statusBarHeight);
                jSONObject.put("titleBarHeight", (double) this.titleBarHeight);
                jSONObject.put("darkMode", this.darkMode);
            } catch (JSONException e2) {
                b.e(LiteAppCenter.TAG, "toJasonString JSONException" + e2.toString(), new Object[0]);
            }
            String jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(197908);
            return jSONObject2;
        }
    }

    public static void addJsApi(String str, Class<? extends a> cls) {
        if (sCommApi.containsKey(str)) {
            throw new RuntimeException(str + " has been exists");
        }
        sCommApi.put(str, cls);
        addJsApi(str);
    }

    public static void addJsApi(Map<String, Class> map) {
        for (Map.Entry<String, Class> entry : map.entrySet()) {
            if (!a.class.isAssignableFrom(entry.getValue())) {
                throw new RuntimeException("api must be subclass of WxaLiteAppJsApi");
            }
            addJsApi(entry.getKey(), entry.getValue());
        }
    }

    public static void addJsApi(String str, String str2, Class<? extends a> cls) {
        Map<String, Class<? extends a>> map = sAppLevelApi.get(str);
        if (map == null) {
            map = new ConcurrentHashMap<>();
            sAppLevelApi.put(str, map);
        }
        if (map.containsKey(str2)) {
            throw new RuntimeException(str + ":" + str2 + " has been exists");
        }
        map.put(str2, cls);
        addJsApi(str, str2);
    }

    public static void addJsApi(String str, Map<String, Class> map) {
        for (Map.Entry<String, Class> entry : map.entrySet()) {
            if (!a.class.isAssignableFrom(entry.getValue())) {
                throw new RuntimeException(str + ":api must be subclass of WxaLiteAppJsApi");
            }
            addJsApi(str, entry.getKey(), entry.getValue());
        }
    }

    public static void updateDarkMode(boolean z) {
        setDarkMode(z);
        systemInfoChange("{\"darkMode\": " + String.valueOf(z) + "}");
    }

    private static void systemInfoChange(String str) {
        for (SystemInfoChangeCallbackInfo systemInfoChangeCallbackInfo : systemInfoChangeCallback.values()) {
            jsApiCallback(systemInfoChangeCallbackInfo.appId, systemInfoChangeCallbackInfo.appPtr, systemInfoChangeCallbackInfo.pageId, systemInfoChangeCallbackInfo.callbackId, str, true);
        }
    }

    public static PageInfo showIndexView(String str, String str2, String str3, String str4) {
        PageInfo _showIndexView = _showIndexView(str, str2, str3, str4);
        pageInfos.put(Long.valueOf(_showIndexView.pageId), _showIndexView);
        pageId = _showIndexView.pageId;
        return _showIndexView;
    }

    public static PageInfo showView(String str, String str2, String str3, String str4, String str5) {
        PageInfo _showView = _showView(str, str2, str3, str4, str5);
        pageInfos.put(Long.valueOf(_showView.pageId), _showView);
        pageId = _showView.pageId;
        return _showView;
    }

    public static void setWxaLiteAppCallback(IWxaLiteAppCallback iWxaLiteAppCallback) {
        mCallback = iWxaLiteAppCallback;
    }

    public static void setUICallback(long j2, ILiteAppUICallback iLiteAppUICallback) {
        mUICallback.put(Long.valueOf(j2), iLiteAppUICallback);
    }

    public static void unsetUICallback(long j2, ILiteAppUICallback iLiteAppUICallback) {
        if (mUICallback.containsKey(Long.valueOf(j2))) {
            mUICallback.remove(Long.valueOf(j2));
        }
    }

    private static void invokeJsApi(JsApi jsApi) {
        Class<? extends a> cls;
        b.i(TAG, "invokeJsApi:%s", jsApi.toString());
        try {
            if (jsApi.appId == null) {
                b.e(TAG, "invalid api", new Object[0]);
            } else if (jsApi.method == null || jsApi.param == null) {
                b.e(TAG, "invalid api ", new Object[0]);
                if (jsApi.callbackId > 0) {
                    jsApiCallback(jsApi.appId, jsApi.appPtr, jsApi.pageId, jsApi.callbackId, "{result: false, errMsg: \"invalid api\", data: {}}", false);
                }
            } else {
                Class<? extends a> cls2 = null;
                if (sAppLevelApi.containsKey(jsApi.appId)) {
                    cls2 = sAppLevelApi.get(jsApi.appId).get(jsApi.method);
                }
                if (cls2 == null) {
                    cls = sCommApi.get(jsApi.method);
                } else {
                    cls = cls2;
                }
                if (cls == null) {
                    b.e(TAG, "not found api ", new Object[0]);
                    if (jsApi.callbackId > 0) {
                        jsApiCallback(jsApi.appId, jsApi.appPtr, jsApi.pageId, jsApi.callbackId, "{result: false, errMsg:\"not found\" ,data: {}}", false);
                        return;
                    }
                    return;
                }
                com.tencent.liteapp.jsapi.b bVar = new com.tencent.liteapp.jsapi.b(jsApi.appId, jsApi.appPtr, jsApi.pageId, jsApi.callbackId);
                a aVar = (a) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                aVar.a(bVar);
                aVar.b(jsApi.appId, new JSONObject(jsApi.param));
            }
        } catch (Exception e2) {
            b.e(TAG, "invokeJsApi :%s", e2.toString());
            if (jsApi.callbackId > 0) {
                jsApiCallback(jsApi.appId, jsApi.appPtr, jsApi.pageId, jsApi.callbackId, "{result: false, errMsg:\"exception\" data: {}}", false);
            }
        }
    }

    public static String getLastPath() {
        return lastPath;
    }

    public static void setPath(String str) {
        lastPath = str;
        HostInfo hostInfo = new HostInfo();
        if (mCallback != null) {
            hostInfo = mCallback.getHostInfo();
        }
        setPath(str, hostInfo);
    }

    public static void setPath(String str, Map<String, String> map) {
        HostInfo hostInfo;
        lastPath = str;
        HostInfo hostInfo2 = new HostInfo();
        if (mCallback != null) {
            hostInfo = mCallback.getHostInfo();
        } else {
            hostInfo = hostInfo2;
        }
        hostInfo.otherExtends = new HashMap();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hostInfo.otherExtends.put(entry.getKey(), entry.getValue());
            }
        }
        setPath(str, hostInfo);
    }

    private static void setFlags(long j2, int i2) {
        if (mUICallback.containsKey(Long.valueOf(j2))) {
            mUICallback.get(Long.valueOf(j2)).setFlags(i2);
        }
    }

    private static void releasePage(long j2, long j3) {
        systemInfoChangeCallback.remove(Long.valueOf(j3));
        pageInfos.remove(Long.valueOf(j3));
    }

    private static void showPage(long j2, long j3) {
        PageInfo pageInfo;
        if (mUICallback.containsKey(Long.valueOf(j2)) && (pageInfo = pageInfos.get(Long.valueOf(j3))) != null) {
            mUICallback.get(Long.valueOf(j2)).showPage(pageInfo);
        }
    }

    private static void setPageInfo(long j2, long j3, PageInfo pageInfo) {
        pageInfos.put(Long.valueOf(j3), pageInfo);
    }

    private static void onSystemInfoChange(String str, long j2, long j3, long j4) {
        systemInfoChangeCallback.put(Long.valueOf(j3), new SystemInfoChangeCallbackInfo(str, j2, j3, j4));
    }

    private static void offSystemInfoChange(long j2) {
        systemInfoChangeCallback.remove(Long.valueOf(j2));
    }

    private static boolean hasCutOut(long j2) {
        if (mUICallback.containsKey(Long.valueOf(j2))) {
            return mUICallback.get(Long.valueOf(j2)).hasCutOut();
        }
        return false;
    }

    private static String getUserAgent() {
        if (mCallback != null) {
            return mCallback.getUserAgent();
        }
        return "";
    }

    public static void updateDisplayParam(Context context) {
        Point az = e.az(context);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i2 = az.x;
        int i3 = az.y;
        Float valueOf = Float.valueOf(displayMetrics.density);
        int ay = com.tencent.liteapp.d.e.ay(context);
        int aD = com.tencent.liteapp.d.e.aD(context);
        float floatValue = 48.0f * valueOf.floatValue();
        setDisplayParams(((float) i2) / valueOf.floatValue(), ((float) i3) / valueOf.floatValue(), ((float) az.x) / valueOf.floatValue(), ((float) az.y) / valueOf.floatValue(), displayMetrics.densityDpi, valueOf.floatValue(), floatValue / valueOf.floatValue(), ((float) ay) / valueOf.floatValue(), ((float) aD) / valueOf.floatValue());
        b.i(TAG, "updateLvCppDisplayParams w=%d h=%d screen=%d,%d densityDpi=%d density=%f statusBarHeight:%d navigationBarHeight:%d actionBarHeight:%f", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(az.x), Integer.valueOf(az.y), Integer.valueOf(displayMetrics.densityDpi), valueOf, Integer.valueOf(ay), Integer.valueOf(aD), Float.valueOf(floatValue));
    }

    public static boolean versionGreater(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (str2 == null || str2.isEmpty()) {
            return true;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        for (int i2 = 0; i2 < min; i2++) {
            if (!split[i2].equals(split2[i2])) {
                if (split[i2].length() > split2[i2].length()) {
                    return true;
                } else {
                    if (split[i2].length() < split2[i2].length()) {
                        return false;
                    }
                    return split[i2].compareTo(split2[i2]) > 0;
                }
            }
        }
        return true;
    }

    private static void onCheckSumFail(String str, long j2, List<String> list) {
        if (mUICallback.containsKey(Long.valueOf(j2))) {
            mUICallback.get(Long.valueOf(j2)).onCheckSumFail(str, list);
        }
    }

    private static boolean getAppInfo(String str, String[] strArr) {
        String[] appInfo;
        if (strArr == null || strArr.length != 2) {
            b.e(TAG, "info invalid", new Object[0]);
        } else if (!(mCallback == null || (appInfo = mCallback.getAppInfo(str)) == null || appInfo.length != strArr.length)) {
            strArr[0] = appInfo[0];
            strArr[1] = appInfo[1];
        }
        return false;
    }

    private static void reportKv(int i2, String str) {
        if (mCallback != null) {
            mCallback.reportKv(i2, str);
        }
    }

    private static void reportIdKey(long j2, long j3, long j4) {
        if (mCallback != null) {
            mCallback.reportIdKey(j2, j3, j4);
        }
    }

    private static String getSystemInfo() {
        return mCallback != null ? mCallback.getSystemInfo().toJasonString() : "";
    }

    private static String getAppFilePath() {
        if (mCallback != null) {
            return mCallback.getLiteAppRoot();
        }
        g.a aVar = g.crg;
        StringBuilder sb = new StringBuilder();
        a.C0147a aVar2 = com.tencent.liteapp.a.cqJ;
        return sb.append(a.C0147a.getAppContext().getFilesDir()).append("/liteapp").toString();
    }

    private static String getUin() {
        if (mCallback != null) {
            return mCallback.getUin();
        }
        return "";
    }

    private static void navigateBack(long j2) {
        if (mUICallback.containsKey(Long.valueOf(j2))) {
            mUICallback.get(Long.valueOf(j2)).navigateBack();
        }
    }

    private static void openPage(String str, String str2, String str3, String str4) {
        if (mCallback != null) {
            mCallback.openPage(str, str2, str3, str4);
        }
    }

    private static String getOfflineResource(String str, String str2, String str3) {
        if (mCallback != null) {
            return mCallback.getOfflineResource(str, str2, str3);
        }
        return "";
    }

    private static void hideKeyboard() {
        if (mCallback != null) {
            mCallback.hideKeyboard();
        }
    }

    private static void reloadDebug(String str, long j2, int i2, String str2) {
        b.i(TAG, "[liteDebug] reloadDebug, appId=" + str + ";appPtr=" + j2 + ";pageCount=" + i2 + "; qrcodeDebugQueryString=" + str2, new Object[0]);
        for (int i3 = 0; i3 < i2; i3++) {
            navigateBack(j2);
        }
        if (mCallback != null) {
            mCallback.reloadDebug(str, str2);
        }
    }
}

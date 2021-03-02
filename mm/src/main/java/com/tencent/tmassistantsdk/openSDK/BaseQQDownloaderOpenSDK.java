package com.tencent.tmassistantsdk.openSDK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class BaseQQDownloaderOpenSDK {
    protected static final String TAG = "BaseQQDownloaderOpenSDK";
    private byte _hellAccFlag_;
    protected String hostPackageName = null;
    protected int hostVersionCode = 0;
    protected Context mContext = null;
    protected ReferenceQueue<ITMQQDownloaderOpenSDKListener> mListenerQueue = new ReferenceQueue<>();
    protected ArrayList<WeakReference<ITMQQDownloaderOpenSDKListener>> mWeakListenerArrayList = new ArrayList<>();
    protected int sdkAPILevel = 1;
    protected TMAssistantSDKChannel sdkChannel = new TMAssistantSDKChannel();

    public abstract long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2);

    public abstract long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str);

    public abstract long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2);

    public abstract void destroyQQDownloaderOpenSDK();

    public abstract TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam);

    public abstract void initQQDownloaderOpenSDK(Context context);

    public abstract void startToAuthorized(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str);

    public abstract void startToWebView(Context context, String str);

    protected BaseQQDownloaderOpenSDK() {
    }

    public boolean registerListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        if (iTMQQDownloaderOpenSDKListener == null) {
            return false;
        }
        while (true) {
            Reference<? extends ITMQQDownloaderOpenSDKListener> poll = this.mListenerQueue.poll();
            if (poll == null) {
                break;
            }
            this.mWeakListenerArrayList.remove(poll);
        }
        Iterator<WeakReference<ITMQQDownloaderOpenSDKListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == iTMQQDownloaderOpenSDKListener) {
                return true;
            }
        }
        this.mWeakListenerArrayList.add(new WeakReference<>(iTMQQDownloaderOpenSDKListener, this.mListenerQueue));
        return true;
    }

    public boolean unregisterListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        if (iTMQQDownloaderOpenSDKListener == null) {
            return false;
        }
        Iterator<WeakReference<ITMQQDownloaderOpenSDKListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == iTMQQDownloaderOpenSDKListener) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public int checkQQDownloaderInstalled() {
        if (this.mContext == null) {
            throw new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
        }
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager != null) {
            try {
                if (packageManager.getPackageInfo("com.tencent.android.qqdownloader", 0) == null) {
                    return 1;
                }
                if (this.sdkAPILevel > GlobalUtil.getInstance().getQQDownloaderAPILevel()) {
                    return 2;
                }
                return 0;
            } catch (PackageManager.NameNotFoundException e2) {
                TMLog.i(TAG, "packagename not found！");
            }
        }
        return 1;
    }

    public static int getQQDownloadApiLevel(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return 0;
            }
            return applicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
        } catch (Exception e2) {
            TMLog.i(TAG, "packagename not found！");
            return 0;
        }
    }

    public void startToDownloadTaskList(Context context) {
        if (context == null) {
            throw new Exception("you must input an application or activity context!");
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("tmast://download?hostpname=" + this.hostPackageName + "&hostversion=" + this.hostVersionCode));
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/tmassistantsdk/openSDK/BaseQQDownloaderOpenSDK", "startToDownloadTaskList", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/tmassistantsdk/openSDK/BaseQQDownloaderOpenSDK", "startToDownloadTaskList", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }

    public long addDownloadTaskFromWebview(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        String formatIntentUriPath = formatIntentUriPath(5, hashMap);
        long currentTimeMillis = System.currentTimeMillis();
        TMLog.i(TAG, "addDownloadTaskFromTaskList,hostPackageName=" + this.hostPackageName + "; hostVersionCode=" + this.hostVersionCode + "; hostUserIdentity=; dataItemType=0;dataItemAction=" + formatIntentUriPath);
        return this.sdkChannel.AddDataItem(this.hostPackageName, this.hostVersionCode, "", 0, formatIntentUriPath, currentTimeMillis, currentTimeMillis + 300000, 0, null);
    }

    public long buildAddDBData(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2, String str, String str2, int i2) {
        Map<String, String> formatMapParams;
        if (TextUtils.isEmpty(str2)) {
            formatMapParams = formatMapParams(tMQQDownloaderOpenSDKParam, z, z2);
        } else {
            formatMapParams = formatMapParams(tMQQDownloaderOpenSDKParam, true, true);
            formatMapParams.put("verifytype", str2);
        }
        String formatIntentUriPath = formatIntentUriPath(i2, formatMapParams);
        long currentTimeMillis = System.currentTimeMillis();
        TMLog.i(TAG, "addDownloadTaskFromTaskList,hostPackageName=" + this.hostPackageName + "; hostVersionCode=" + this.hostVersionCode + "; hostUserIdentity=; dataItemType=0;dataItemAction=" + formatIntentUriPath);
        return this.sdkChannel.AddDataItem(this.hostPackageName, this.hostVersionCode, "", 0, formatIntentUriPath, currentTimeMillis, currentTimeMillis + 300000, 0, null);
    }

    /* access modifiers changed from: protected */
    public long buildAddDBData(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return this.sdkChannel.AddDataItem(null, 0, null, 0, null, currentTimeMillis, currentTimeMillis + 300000, 1, bArr);
    }

    /* access modifiers changed from: protected */
    public Map<String, String> formatMapParams(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        String formatOplist = formatOplist(z, z2);
        HashMap hashMap = new HashMap();
        hashMap.put("hostpname", this.hostPackageName);
        hashMap.put("hostversioncode", String.valueOf(this.hostVersionCode));
        hashMap.put("sngappid", tMQQDownloaderOpenSDKParam.SNGAppId);
        hashMap.put("appid", tMQQDownloaderOpenSDKParam.taskAppId);
        hashMap.put("apkid", tMQQDownloaderOpenSDKParam.taskApkId);
        hashMap.put("pname", tMQQDownloaderOpenSDKParam.taskPackageName);
        hashMap.put(OpenSDKTool4Assistant.EXTRA_VIA, tMQQDownloaderOpenSDKParam.via);
        hashMap.put(OpenSDKTool4Assistant.EXTRA_UIN, tMQQDownloaderOpenSDKParam.uin);
        hashMap.put("uintype", tMQQDownloaderOpenSDKParam.uinType);
        hashMap.put("versioncode", String.valueOf(tMQQDownloaderOpenSDKParam.taskVersion));
        hashMap.put("oplist", formatOplist);
        hashMap.put("channelid", tMQQDownloaderOpenSDKParam.channelId);
        hashMap.put("actionflag", tMQQDownloaderOpenSDKParam.actionFlag);
        hashMap.put("sdkid", tMQQDownloaderOpenSDKParam.sdkId);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public String formatIntentUriPath(int i2, Map<String, String> map) {
        String str;
        String str2;
        String str3;
        switch (i2) {
            case 1:
                str = "download";
                break;
            case 2:
                str = "appdetails";
                break;
            case 3:
                str = "appdetails";
                break;
            case 4:
                str = "updatedownload";
                break;
            case 5:
                str = "webview";
                break;
            default:
                str = "appdetails";
                break;
        }
        String str4 = "tpmast://" + str + "?";
        String str5 = "";
        if (map != null && map.size() > 0) {
            int i3 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
                    str2 = str5;
                } else {
                    if (i3 <= 0) {
                        str3 = "";
                    } else {
                        str3 = "&";
                    }
                    str2 = str5 + str3 + key + "=" + URLEncoder.encode(value);
                }
                i3++;
                str5 = str2;
            }
        }
        String str6 = str4 + str5;
        TMLog.i(TAG, "path:".concat(String.valueOf(str6)));
        return formatEncryptUrl(str6);
    }

    public boolean removeDownloadTask(long j2) {
        if (j2 >= 0) {
            return this.sdkChannel.delDataItem(j2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public String formatEncryptUrl(String str) {
        return "tmast://encrypt?encryptdata=".concat(String.valueOf(URLEncoder.encode(OpenSDKTool4Assistant.encryptUri(str))));
    }

    /* access modifiers changed from: protected */
    public String formatOplist(boolean z, boolean z2) {
        if (z && z2) {
            return "1;2";
        }
        if (z2) {
            return "2";
        }
        if (z) {
            return "1";
        }
        return "";
    }

    /* access modifiers changed from: protected */
    public void onStateChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, int i2, int i3, String str) {
        Iterator<WeakReference<ITMQQDownloaderOpenSDKListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener = it.next().get();
            if (iTMQQDownloaderOpenSDKListener == null) {
                TMLog.i(TAG, "onDownloadStateChanged listener = null");
            } else {
                iTMQQDownloaderOpenSDKListener.OnDownloadTaskStateChanged(tMQQDownloaderOpenSDKParam, i2, i3, str);
            }
        }
    }
}

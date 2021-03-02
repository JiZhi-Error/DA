package com.tencent.tmassistantsdk.openSDK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannelDataItem;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TMQQDownloaderOpenSDK extends BaseQQDownloaderOpenSDK implements IDownloadStateChangedListener {
    public static final String AUTHORITY = "com.tencent.android.qqdownloader.provider";
    public static final Uri CONTENT_URI = AssistantStore.DownloadInfos.CONTENT_URI;
    protected static final String TAG = "QQDownloaderOpenSDK";
    protected static TMQQDownloaderOpenSDK mInstance = null;
    private byte _hellAccFlag_;
    Map<String, TMQQDownloaderOpenSDKParam> mDownloadParams;
    protected int sdkAPILevel;

    private TMQQDownloaderOpenSDK() {
        AppMethodBeat.i(102102);
        this.sdkAPILevel = 1;
        this.mDownloadParams = null;
        this.mDownloadParams = new ConcurrentHashMap();
        AppMethodBeat.o(102102);
    }

    public static synchronized TMQQDownloaderOpenSDK getInstance() {
        TMQQDownloaderOpenSDK tMQQDownloaderOpenSDK;
        synchronized (TMQQDownloaderOpenSDK.class) {
            AppMethodBeat.i(102103);
            if (mInstance == null) {
                mInstance = new TMQQDownloaderOpenSDK();
            }
            tMQQDownloaderOpenSDK = mInstance;
            AppMethodBeat.o(102103);
        }
        return tMQQDownloaderOpenSDK;
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public void destroyQQDownloaderOpenSDK() {
        AppMethodBeat.i(102104);
        NetworkMonitorReceiver.getInstance().unregisterReceiver();
        GetSettingEngine.getInstance().cancleRequest();
        LogReportManager.getInstance().cancleReport();
        LogReportManager.getInstance().destory();
        if (this.mContext != null) {
            DownloadStateChangedReceiver.getInstance().unRegisteReceiver(this.mContext);
            DownloadStateChangedReceiver.getInstance().removeDownloadStateChangedListener(this);
        }
        GlobalUtil.getInstance().destroy();
        this.mContext = null;
        AppMethodBeat.o(102104);
    }

    public static boolean isExistActoin(long j2) {
        AppMethodBeat.i(102105);
        if (j2 < 0) {
            AppMethodBeat.o(102105);
            return false;
        }
        ArrayList<TMAssistantSDKChannelDataItem> channelDataItemList = new TMAssistantSDKChannel().getChannelDataItemList();
        if (channelDataItemList != null && channelDataItemList.size() > 0) {
            Iterator<TMAssistantSDKChannelDataItem> it = channelDataItemList.iterator();
            while (it.hasNext()) {
                TMAssistantSDKChannelDataItem next = it.next();
                if (((long) next.mDBIdentity) == j2 && next.mDataItemEndTime - next.mDataItemStartTime <= 300000) {
                    AppMethodBeat.o(102105);
                    return true;
                }
            }
        }
        AppMethodBeat.o(102105);
        return false;
    }

    public int checkQQDownloaderInstalled(int i2) {
        AppMethodBeat.i(102106);
        if (this.mContext == null) {
            Exception exc = new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
            AppMethodBeat.o(102106);
            throw exc;
        }
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager != null) {
            try {
                if (packageManager.getPackageInfo("com.tencent.android.qqdownloader", 0) != null) {
                    int qQDownloaderVersionCode = GlobalUtil.getInstance().getQQDownloaderVersionCode();
                    if (this.sdkAPILevel > GlobalUtil.getInstance().getQQDownloaderAPILevel()) {
                        AppMethodBeat.o(102106);
                        return 2;
                    } else if (i2 > qQDownloaderVersionCode) {
                        AppMethodBeat.o(102106);
                        return 2;
                    } else {
                        AppMethodBeat.o(102106);
                        return 0;
                    }
                } else {
                    AppMethodBeat.o(102106);
                    return 1;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102106);
        return 1;
    }

    public void startQQDownloader(Context context) {
        AppMethodBeat.i(102107);
        if (context != null) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.android.qqdownloader");
            if (context instanceof Application) {
                launchIntentForPackage.addFlags(268435456);
            }
            a bl = new a().bl(launchIntentForPackage);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK", "startQQDownloader", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK", "startQQDownloader", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(102107);
    }

    public void startToDownloadTaskList(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        AppMethodBeat.i(102108);
        if (context == null) {
            Exception exc = new Exception("you must input an application or activity context!");
            AppMethodBeat.o(102108);
            throw exc;
        } else if (tMQQDownloaderOpenSDKParam == null) {
            AppMethodBeat.o(102108);
        } else {
            String uuid = UUID.randomUUID().toString();
            if (this.mDownloadParams != null) {
                this.mDownloadParams.put(uuid, tMQQDownloaderOpenSDKParam);
            }
            if (z) {
                DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
                createNewChunkLogInfo.UUID = uuid;
                createNewChunkLogInfo.requestUrl = "";
                createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
                createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
                DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
            }
            Map<String, String> formatMapParams = super.formatMapParams(tMQQDownloaderOpenSDKParam, z, z2);
            formatMapParams.put("taskid", uuid);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(1, formatMapParams)));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK", "startToDownloadTaskList", "(Landroid/content/Context;Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK", "startToDownloadTaskList", "(Landroid/content/Context;Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(102108);
        }
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        AppMethodBeat.i(102109);
        if (!(this.mDownloadParams == null || tMQQDownloaderOpenSDKParam == null)) {
            this.mDownloadParams.put(UUID.randomUUID().toString(), tMQQDownloaderOpenSDKParam);
        }
        long buildAddDBData = super.buildAddDBData(tMQQDownloaderOpenSDKParam, z, z2, tMQQDownloaderOpenSDKParam.actionFlag, null, 1);
        AppMethodBeat.o(102109);
        return buildAddDBData;
    }

    public void startToAppDetail(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        AppMethodBeat.i(102110);
        if (context == null) {
            Exception exc = new Exception("you must input an application or activity context!");
            AppMethodBeat.o(102110);
            throw exc;
        }
        String uuid = UUID.randomUUID().toString();
        if (this.mDownloadParams != null) {
            this.mDownloadParams.put(uuid, tMQQDownloaderOpenSDKParam);
        }
        if (z) {
            DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
            createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
            createNewChunkLogInfo.UUID = uuid;
            createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
            createNewChunkLogInfo.resultState = 1;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
        }
        Map<String, String> formatMapParams = super.formatMapParams(tMQQDownloaderOpenSDKParam, z, z2);
        formatMapParams.put("taskid", uuid);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(2, formatMapParams)));
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK", "startToAppDetail", "(Landroid/content/Context;Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK", "startToAppDetail", "(Landroid/content/Context;Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(102110);
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        AppMethodBeat.i(102111);
        if (!(this.mDownloadParams == null || tMQQDownloaderOpenSDKParam == null)) {
            this.mDownloadParams.put(UUID.randomUUID().toString(), tMQQDownloaderOpenSDKParam);
        }
        long buildAddDBData = super.buildAddDBData(tMQQDownloaderOpenSDKParam, z, z2, tMQQDownloaderOpenSDKParam.actionFlag, null, 2);
        AppMethodBeat.o(102111);
        return buildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public void startToAuthorized(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        AppMethodBeat.i(102112);
        if (context == null) {
            Exception exc = new Exception("you must input an application or activity context!");
            AppMethodBeat.o(102112);
            throw exc;
        } else if (tMQQDownloaderOpenSDKParam == null) {
            Exception exc2 = new Exception("QQDownloaderParam param cann't be null!");
            AppMethodBeat.o(102112);
            throw exc2;
        } else {
            String uuid = UUID.randomUUID().toString();
            if (this.mDownloadParams != null) {
                this.mDownloadParams.put(uuid, tMQQDownloaderOpenSDKParam);
            }
            DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
            createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
            createNewChunkLogInfo.UUID = uuid;
            createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
            createNewChunkLogInfo.resultState = 1;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
            Map<String, String> formatMapParams = super.formatMapParams(tMQQDownloaderOpenSDKParam, true, true);
            formatMapParams.put("verifytype", str);
            formatMapParams.put("taskid", uuid);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(3, formatMapParams)));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK", "startToAuthorized", "(Landroid/content/Context;Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK", "startToAuthorized", "(Landroid/content/Context;Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(102112);
        }
    }

    public void startToAuthorized(Context context, String str) {
        AppMethodBeat.i(102113);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(formatEncryptUrl(str)));
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK", "startToAuthorized", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK", "startToAuthorized", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(102113);
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        AppMethodBeat.i(102114);
        if (!(this.mDownloadParams == null || tMQQDownloaderOpenSDKParam == null)) {
            this.mDownloadParams.put(UUID.randomUUID().toString(), tMQQDownloaderOpenSDKParam);
        }
        long buildAddDBData = super.buildAddDBData(tMQQDownloaderOpenSDKParam, true, true, tMQQDownloaderOpenSDKParam.actionFlag, str, 3);
        AppMethodBeat.o(102114);
        return buildAddDBData;
    }

    public long addDownloadTaskFromAuthorize(String str) {
        AppMethodBeat.i(102115);
        String formatEncryptUrl = super.formatEncryptUrl(str);
        long currentTimeMillis = System.currentTimeMillis();
        long AddDataItem = this.sdkChannel.AddDataItem(this.hostPackageName, this.hostVersionCode, "", 0, formatEncryptUrl, currentTimeMillis, currentTimeMillis + 300000, 0, null);
        AppMethodBeat.o(102115);
        return AddDataItem;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0214, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x021d, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x021e, code lost:
        r4 = r11;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0214 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x0060] */
    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo getDownloadTaskState(com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam r18) {
        /*
        // Method dump skipped, instructions count: 548
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK.getDownloadTaskState(com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam):com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo");
    }

    private void relateToQQDownloader(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        AppMethodBeat.i(102117);
        Map<String, String> formatMapParams = super.formatMapParams(tMQQDownloaderOpenSDKParam, false, false);
        formatMapParams.put("taskid", str);
        String formatIntentUriPath = super.formatIntentUriPath(4, formatMapParams);
        Intent intent = new Intent("com.tencent.android.qqdownloader.action.RELATED");
        intent.setPackage("com.tencent.android.qqdownloader");
        intent.putExtra("command", "cmd_updatedownload");
        intent.putExtra("relatedurl", formatIntentUriPath);
        context.sendBroadcast(intent);
        AppMethodBeat.o(102117);
    }

    private boolean isFileExist(String str) {
        AppMethodBeat.i(102118);
        if (new o(str).exists()) {
            AppMethodBeat.o(102118);
            return true;
        }
        AppMethodBeat.o(102118);
        return false;
    }

    @Override // com.tencent.tmassistantsdk.openSDK.IDownloadStateChangedListener
    public void onDownloadStateChanged(TMQQDownloaderStateChangeParam tMQQDownloaderStateChangeParam) {
        AppMethodBeat.i(102119);
        TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = tMQQDownloaderStateChangeParam.param;
        int assistantState2SDKState = GlobalUtil.assistantState2SDKState(tMQQDownloaderStateChangeParam.state);
        int assistantErrorCode2SDKErrorCode = GlobalUtil.assistantErrorCode2SDKErrorCode(tMQQDownloaderStateChangeParam.errorCode);
        String str = tMQQDownloaderStateChangeParam.errorMsg;
        String str2 = tMQQDownloaderStateChangeParam.taskId;
        TMLog.i(TAG, "onDownloadStateChanged state = ".concat(String.valueOf(assistantState2SDKState)));
        TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam2 = null;
        if (str2 != null && str2.trim().length() > 0) {
            tMQQDownloaderOpenSDKParam2 = this.mDownloadParams.get(str2);
        }
        if (tMQQDownloaderOpenSDKParam2 != null) {
            onStateChanged(tMQQDownloaderOpenSDKParam2, assistantState2SDKState, assistantErrorCode2SDKErrorCode, str);
        } else {
            TMLog.i(TAG, "onDownloadStateChanged storeParam = null");
        }
        if (6 == assistantState2SDKState) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, TMQQDownloaderOpenSDKParam> entry : this.mDownloadParams.entrySet()) {
                TMQQDownloaderOpenSDKParam value = entry.getValue();
                String key = entry.getKey();
                if (value != null && !TextUtils.isEmpty(tMQQDownloaderOpenSDKParam.taskPackageName) && value.taskPackageName.equals(tMQQDownloaderOpenSDKParam.taskPackageName) && value.taskVersion == tMQQDownloaderOpenSDKParam.taskVersion) {
                    arrayList.add(key);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.mDownloadParams.remove((String) it.next());
            }
        }
        AppMethodBeat.o(102119);
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public void initQQDownloaderOpenSDK(Context context) {
        AppMethodBeat.i(102120);
        this.mContext = context;
        this.hostPackageName = context.getPackageName();
        this.hostVersionCode = GlobalUtil.getAppVersionCode(this.mContext);
        GlobalUtil.getInstance().setContext(this.mContext);
        this.sdkAPILevel = 1;
        DownloadStateChangedReceiver.getInstance().registeReceiver(this.mContext);
        DownloadStateChangedReceiver.getInstance().addDownloadStateChangedListener(this);
        NetworkMonitorReceiver.getInstance().registerReceiver();
        GetSettingEngine.getInstance().sendRequest();
        LogReportManager.getInstance().reportLog();
        AppMethodBeat.o(102120);
    }

    public static String about() {
        return "TMQQDownloaderOpenSDK_2014_05_13_17_36_release_35169";
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public void startToWebView(Context context, String str) {
        AppMethodBeat.i(102121);
        if (context == null) {
            Exception exc = new Exception("you must input an application or activity context!");
            AppMethodBeat.o(102121);
            throw exc;
        } else if (TextUtils.isEmpty(str)) {
            Exception exc2 = new Exception("param url shouldn't be null!");
            AppMethodBeat.o(102121);
            throw exc2;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            String formatIntentUriPath = super.formatIntentUriPath(5, hashMap);
            TMLog.i(TAG, "startToWebView finalPath:".concat(String.valueOf(formatIntentUriPath)));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(formatIntentUriPath));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK", "startToWebView", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK", "startToWebView", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(102121);
        }
    }
}

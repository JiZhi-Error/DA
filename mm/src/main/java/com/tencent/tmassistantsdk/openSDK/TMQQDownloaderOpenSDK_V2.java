package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled;
import com.tencent.tmassistantsdk.openSDK.param.jce.BatchDownloadActionRequest;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class TMQQDownloaderOpenSDK_V2 extends BaseQQDownloaderOpenSDK implements ITMQQDownloaderOpenSDKListener, QQDownloaderInstalled.IQQDownloaderInstalled {
    protected static final String TAG = "QQDownloaderOpenSDK";
    protected static TMQQDownloaderOpenSDK_V2 mInstance = null;
    protected CopyOnWriteArrayList<TMQQDownloaderOpenSDKParam> mTaskList;

    protected TMQQDownloaderOpenSDK_V2() {
        AppMethodBeat.i(102142);
        this.mTaskList = null;
        this.mTaskList = new CopyOnWriteArrayList<>();
        AppMethodBeat.o(102142);
    }

    public static synchronized TMQQDownloaderOpenSDK_V2 getInstance() {
        TMQQDownloaderOpenSDK_V2 tMQQDownloaderOpenSDK_V2;
        synchronized (TMQQDownloaderOpenSDK_V2.class) {
            AppMethodBeat.i(102143);
            if (mInstance == null) {
                mInstance = new TMQQDownloaderOpenSDK_V2();
            }
            tMQQDownloaderOpenSDK_V2 = mInstance;
            AppMethodBeat.o(102143);
        }
        return tMQQDownloaderOpenSDK_V2;
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public void destroyQQDownloaderOpenSDK() {
        AppMethodBeat.i(102144);
        NetworkMonitorReceiver.getInstance().unregisterReceiver();
        GetSettingEngine.getInstance().cancleRequest();
        LogReportManager.getInstance().cancleReport();
        LogReportManager.getInstance().destory();
        if (this.mContext != null) {
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).unregisterIQQDownloaderOpenSDKListener();
            QQDownloaderInstalled.getInstance().unregisteListener();
            QQDownloaderInstalled.getInstance().unRegisteReceiver(this.mContext);
        }
        GlobalUtil.getInstance().destroy();
        this.mContext = null;
        AppMethodBeat.o(102144);
    }

    public void startToDownloadTaskList(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2, int i2) {
        int i3;
        AppMethodBeat.i(102145);
        if (context == null) {
            Exception exc = new Exception("you must input an application or activity context!");
            AppMethodBeat.o(102145);
            throw exc;
        } else if (tMQQDownloaderOpenSDKParam == null) {
            AppMethodBeat.o(102145);
        } else {
            String uuid = UUID.randomUUID().toString();
            if (z) {
                DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
                createNewChunkLogInfo.UUID = uuid;
                createNewChunkLogInfo.requestUrl = "";
                createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
                createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
                DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
            }
            if (tMQQDownloaderOpenSDKParam != null) {
                String formatOplist = super.formatOplist(z, z2);
                if (1 == i2) {
                    i3 = 2;
                } else {
                    i3 = 5;
                }
                addToTaskList(tMQQDownloaderOpenSDKParam);
                TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(tMQQDownloaderOpenSDKParam, i3, formatOplist, tMQQDownloaderOpenSDKParam.actionFlag, null);
            }
            AppMethodBeat.o(102145);
        }
    }

    public void startToAppDetail(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2, int i2) {
        int i3 = 1;
        AppMethodBeat.i(102146);
        if (context == null) {
            Exception exc = new Exception("you must input an application or activity context!");
            AppMethodBeat.o(102146);
            throw exc;
        }
        String uuid = UUID.randomUUID().toString();
        if (z) {
            DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
            createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
            createNewChunkLogInfo.UUID = uuid;
            createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
            createNewChunkLogInfo.resultState = 1;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
        }
        if (tMQQDownloaderOpenSDKParam != null) {
            String formatOplist = super.formatOplist(z, z2);
            if (1 != i2) {
                i3 = 4;
            }
            addToTaskList(tMQQDownloaderOpenSDKParam);
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(tMQQDownloaderOpenSDKParam, i3, formatOplist, tMQQDownloaderOpenSDKParam.actionFlag, null);
        }
        AppMethodBeat.o(102146);
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public void startToAuthorized(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        AppMethodBeat.i(102147);
        if (context == null) {
            Exception exc = new Exception("you must input an application or activity context!");
            AppMethodBeat.o(102147);
            throw exc;
        } else if (tMQQDownloaderOpenSDKParam == null) {
            Exception exc2 = new Exception("QQDownloaderParam param cann't be null!");
            AppMethodBeat.o(102147);
            throw exc2;
        } else {
            String uuid = UUID.randomUUID().toString();
            DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
            createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
            createNewChunkLogInfo.UUID = uuid;
            createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
            createNewChunkLogInfo.resultState = 1;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
            if (tMQQDownloaderOpenSDKParam != null) {
                addToTaskList(tMQQDownloaderOpenSDKParam);
                TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(tMQQDownloaderOpenSDKParam, 3, super.formatOplist(true, true), tMQQDownloaderOpenSDKParam.actionFlag, str);
            }
            AppMethodBeat.o(102147);
        }
    }

    public void startToAuthorized(Context context, String str) {
        AppMethodBeat.i(102148);
        String formatEncryptUrl = super.formatEncryptUrl(str);
        if (!TextUtils.isEmpty(str) && this.mContext != null) {
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleUriAction(formatEncryptUrl);
        }
        AppMethodBeat.o(102148);
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public void startToWebView(Context context, String str) {
        AppMethodBeat.i(102149);
        if (context == null) {
            Exception exc = new Exception("you must input an application or activity context!");
            AppMethodBeat.o(102149);
            throw exc;
        } else if (TextUtils.isEmpty(str)) {
            Exception exc2 = new Exception("param url shouldn't be null!");
            AppMethodBeat.o(102149);
            throw exc2;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            String formatIntentUriPath = super.formatIntentUriPath(5, hashMap);
            TMLog.i(TAG, "startToWebView finalPath:".concat(String.valueOf(formatIntentUriPath)));
            if (!TextUtils.isEmpty(str) && this.mContext != null) {
                TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleUriAction(formatIntentUriPath);
            }
            AppMethodBeat.o(102149);
        }
    }

    public int startToBatchUpdateOperation(Context context, ArrayList<TMQQDownloaderOpenSDKParam> arrayList, boolean z, int i2, String str, String str2, String str3) {
        boolean z2 = true;
        AppMethodBeat.i(102150);
        if (context == null) {
            Exception exc = new Exception("you must input an application or activity context!");
            AppMethodBeat.o(102150);
            throw exc;
        }
        int qQDownloadApiLevel = getQQDownloadApiLevel(context);
        if (qQDownloadApiLevel <= 0) {
            AppMethodBeat.o(102150);
            return 1;
        } else if (qQDownloadApiLevel < 4) {
            AppMethodBeat.o(102150);
            return 2;
        } else {
            if (!(arrayList == null || arrayList.size() == 0)) {
                z2 = false;
            }
            int batchRequestType = getBatchRequestType(z2, i2);
            if (!TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleBatchRequestAction(batchRequestType, arrayList, str, str2, str3)) {
                TMLog.w(TAG, "handleBatchRequestAction return false with batchRequestType=".concat(String.valueOf(batchRequestType)));
            }
            AppMethodBeat.o(102150);
            return 0;
        }
    }

    private int getBatchRequestType(boolean z, int i2) {
        if (z) {
            switch (i2) {
                case 0:
                default:
                    return 2;
                case 1:
                    return 1;
                case 2:
                    return 6;
                case 3:
                    return 5;
            }
        } else {
            switch (i2) {
                case 0:
                case 1:
                    return 4;
                case 2:
                    return 8;
                case 3:
                    return 7;
                default:
                    return 2;
            }
        }
    }

    public ArrayList<TMAssistantDownloadTaskInfo> getBatchTaskState(ArrayList<TMQQDownloaderOpenSDKParam> arrayList, String str, String str2, String str3) {
        AppMethodBeat.i(102151);
        if (this.mContext == null) {
            Exception exc = new Exception("mContext shouldn't be null !");
            AppMethodBeat.o(102151);
            throw exc;
        } else if (arrayList == null || arrayList.size() <= 0) {
            Exception exc2 = new Exception("ArrayList<TMQQDownloaderOpenSDKParam> appList cann't be null or empty!");
            AppMethodBeat.o(102151);
            throw exc2;
        } else {
            int qQDownloadApiLevel = getQQDownloadApiLevel(this.mContext);
            if (qQDownloadApiLevel <= 1) {
                AppMethodBeat.o(102151);
                return null;
            } else if (qQDownloadApiLevel < 4) {
                TMAssistantDownloadTaskInfo downloadTask = TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getDownloadTask(arrayList.get(0));
                if (downloadTask != null) {
                    ArrayList<TMAssistantDownloadTaskInfo> arrayList2 = new ArrayList<>();
                    arrayList2.add(downloadTask);
                    AppMethodBeat.o(102151);
                    return arrayList2;
                }
                AppMethodBeat.o(102151);
                return null;
            } else {
                ArrayList<TMAssistantDownloadTaskInfo> batchTaskInfos = TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getBatchTaskInfos(arrayList, str, str2, str3);
                AppMethodBeat.o(102151);
                return batchTaskInfos;
            }
        }
    }

    public long addBatchUpdateOperationToDB(ArrayList<TMQQDownloaderOpenSDKParam> arrayList, boolean z, int i2, String str, String str2, String str3) {
        long j2;
        byte[] buildSendData;
        AppMethodBeat.i(102152);
        boolean z2 = arrayList == null || arrayList.size() == 0;
        int batchRequestType = getBatchRequestType(z2, i2);
        if (batchRequestType != 3 && !z2) {
            Iterator<TMQQDownloaderOpenSDKParam> it = arrayList.iterator();
            while (it.hasNext()) {
                TMQQDownloaderOpenSDKParam next = it.next();
                if (next != null) {
                    addToTaskList(next);
                }
            }
        }
        BatchDownloadActionRequest buildBatchActionRequest = TMQQDownloaderOpenSDKDataProcessor.buildBatchActionRequest(batchRequestType, arrayList, str, str2, str3);
        if (buildBatchActionRequest == null || (buildSendData = TMQQDownloaderOpenSDKDataProcessor.buildSendData(buildBatchActionRequest)) == null) {
            j2 = -1;
        } else {
            j2 = buildAddDBData(buildSendData);
        }
        AppMethodBeat.o(102152);
        return j2;
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        AppMethodBeat.i(102153);
        if (this.mContext == null) {
            Exception exc = new Exception("Context shouldn't be null !");
            AppMethodBeat.o(102153);
            throw exc;
        } else if (tMQQDownloaderOpenSDKParam == null) {
            Exception exc2 = new Exception("TMQQDownloaderOpenSDKParam param cann't is null!");
            AppMethodBeat.o(102153);
            throw exc2;
        } else {
            TMAssistantDownloadTaskInfo downloadTask = TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getDownloadTask(tMQQDownloaderOpenSDKParam);
            AppMethodBeat.o(102153);
            return downloadTask;
        }
    }

    private void onProgressChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, long j2, long j3) {
        AppMethodBeat.i(102154);
        Iterator<WeakReference<ITMQQDownloaderOpenSDKListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener = it.next().get();
            if (iTMQQDownloaderOpenSDKListener == null) {
                TMLog.i(TAG, "onDownloadStateChanged listener = null");
            } else {
                iTMQQDownloaderOpenSDKListener.OnDownloadTaskProgressChanged(tMQQDownloaderOpenSDKParam, j2, j3);
            }
        }
        AppMethodBeat.o(102154);
    }

    private synchronized void addToTaskList(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        boolean z;
        AppMethodBeat.i(102155);
        if (!(tMQQDownloaderOpenSDKParam == null || this.mTaskList == null)) {
            Iterator<TMQQDownloaderOpenSDKParam> it = this.mTaskList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                TMQQDownloaderOpenSDKParam next = it.next();
                if (next.taskAppId == null) {
                    if (next.taskPackageName != null && next.taskPackageName.equals(tMQQDownloaderOpenSDKParam.taskPackageName)) {
                        z = true;
                        break;
                    }
                } else if (next.taskAppId.equals(tMQQDownloaderOpenSDKParam.taskAppId) && (next.taskPackageName == null || next.taskPackageName.equals(tMQQDownloaderOpenSDKParam.taskPackageName))) {
                    z = true;
                }
            }
            z = true;
            if (!z) {
                this.mTaskList.add(tMQQDownloaderOpenSDKParam);
            }
        }
        AppMethodBeat.o(102155);
    }

    @Override // com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener
    public void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, int i2, int i3, String str) {
        AppMethodBeat.i(102156);
        if (tMQQDownloaderOpenSDKParam != null) {
            onStateChanged(tMQQDownloaderOpenSDKParam, i2, i3, str);
        }
        AppMethodBeat.o(102156);
    }

    @Override // com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener
    public void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, long j2, long j3) {
        AppMethodBeat.i(102157);
        if (tMQQDownloaderOpenSDKParam != null) {
            onProgressChanged(tMQQDownloaderOpenSDKParam, j2, j3);
        }
        AppMethodBeat.o(102157);
    }

    @Override // com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener
    public void OnQQDownloaderInvalid() {
        AppMethodBeat.i(102158);
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener) ((WeakReference) it.next()).get();
            if (iTMQQDownloaderOpenSDKListener == null) {
                TMLog.i(TAG, "OnQQDownloaderInvalid listener = null");
            } else {
                iTMQQDownloaderOpenSDKListener.OnQQDownloaderInvalid();
            }
        }
        AppMethodBeat.o(102158);
    }

    @Override // com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled.IQQDownloaderInstalled
    public synchronized void onQQDownloaderInstalled(Context context) {
        AppMethodBeat.i(102159);
        TMLog.i(TAG, "received qqdownload install broadcase!");
        if (this.mTaskList != null) {
            Iterator<TMQQDownloaderOpenSDKParam> it = this.mTaskList.iterator();
            while (it.hasNext()) {
                TMQQDownloaderOpenSDKParam next = it.next();
                if (next != null) {
                    try {
                        getDownloadTaskState(next);
                    } catch (Exception e2) {
                        Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    }
                    this.mTaskList.remove(next);
                }
            }
        }
        AppMethodBeat.o(102159);
    }

    @Override // com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener
    public void OnServiceFree() {
        AppMethodBeat.i(102160);
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener) ((WeakReference) it.next()).get();
            if (iTMQQDownloaderOpenSDKListener == null) {
                TMLog.i(TAG, "OnQQDownloaderInvalid listener = null");
            } else {
                iTMQQDownloaderOpenSDKListener.OnServiceFree();
            }
        }
        AppMethodBeat.o(102160);
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        AppMethodBeat.i(102161);
        addToTaskList(tMQQDownloaderOpenSDKParam);
        long buildAddDBData = super.buildAddDBData(tMQQDownloaderOpenSDKParam, z, z2, tMQQDownloaderOpenSDKParam.actionFlag, null, 2);
        AppMethodBeat.o(102161);
        return buildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        AppMethodBeat.i(102162);
        addToTaskList(tMQQDownloaderOpenSDKParam);
        long buildAddDBData = super.buildAddDBData(tMQQDownloaderOpenSDKParam, true, true, tMQQDownloaderOpenSDKParam.actionFlag, str, 3);
        AppMethodBeat.o(102162);
        return buildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        AppMethodBeat.i(102163);
        addToTaskList(tMQQDownloaderOpenSDKParam);
        long buildAddDBData = super.buildAddDBData(tMQQDownloaderOpenSDKParam, z, z2, tMQQDownloaderOpenSDKParam.actionFlag, null, 1);
        AppMethodBeat.o(102163);
        return buildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK
    public void initQQDownloaderOpenSDK(Context context) {
        AppMethodBeat.i(102164);
        this.mContext = context;
        this.hostPackageName = context.getPackageName();
        this.hostVersionCode = GlobalUtil.getAppVersionCode(this.mContext);
        GlobalUtil.getInstance().setContext(this.mContext);
        this.sdkAPILevel = 2;
        if (this.mContext != null) {
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).registerIQQDownloaderOpenSDKListener(this);
            QQDownloaderInstalled.getInstance().registeReceiver(this.mContext);
            QQDownloaderInstalled.getInstance().registeListener(this);
        }
        NetworkMonitorReceiver.getInstance().registerReceiver();
        GetSettingEngine.getInstance().sendRequest();
        LogReportManager.getInstance().reportLog();
        AppMethodBeat.o(102164);
    }

    public static String about() {
        return "TMQQDownloaderOpenSDK_2014_05_13_17_36_release_35169";
    }

    public void releaseIPCConnected() {
        AppMethodBeat.i(102165);
        if (this.mContext != null) {
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).releaseIPCClient();
        }
        AppMethodBeat.o(102165);
    }
}

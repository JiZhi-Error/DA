package com.tencent.tmassistantsdk.downloadservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.IServiceDownloadTaskManagerListener;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTaskManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.storage.DBManager;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.HashMap;
import java.util.Map;

public class TMAssistantDownloadSDKService extends Service implements IServiceDownloadTaskManagerListener {
    protected static final String TAG = "TMAssistantDownloadSDKService";
    private byte _hellAccFlag_;
    protected final TMAssistantDownloadSDKServiceImpl downloadSDKServiceImpl = new TMAssistantDownloadSDKServiceImpl();
    protected final HashMap<ITMAssistantDownloadSDKServiceCallback, String> mCallbackHashMap = new HashMap<>();
    protected final RemoteCallbackList<ITMAssistantDownloadSDKServiceCallback> mCallbacks = new RemoteCallbackList<>();
    ServiceDownloadTaskManager mServiceDownloadTaskManager = null;

    public TMAssistantDownloadSDKService() {
        AppMethodBeat.i(102035);
        AppMethodBeat.o(102035);
    }

    public void onCreate() {
        AppMethodBeat.i(102036);
        super.onCreate();
        GlobalUtil.getInstance().setContext(this);
        NetworkMonitorReceiver.getInstance().registerReceiver();
        this.mServiceDownloadTaskManager = new ServiceDownloadTaskManager(DBManager.getInstance().queryWaitingAndDownloadingTaskList());
        this.mServiceDownloadTaskManager.setListener(this);
        this.mServiceDownloadTaskManager.registerApkDownloadManagerListener();
        ApkDownloadManager.getInstance().init();
        TMLog.i(TAG, "onCreate");
        AppMethodBeat.o(102036);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(102037);
        TMLog.i(TAG, "onBind ,intent:".concat(String.valueOf(intent)));
        TMAssistantDownloadSDKServiceImpl tMAssistantDownloadSDKServiceImpl = this.downloadSDKServiceImpl;
        AppMethodBeat.o(102037);
        return tMAssistantDownloadSDKServiceImpl;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(102038);
        TMLog.i(TAG, "onUnbind ,intent:".concat(String.valueOf(intent)));
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(102038);
        return onUnbind;
    }

    public void onDestroy() {
        AppMethodBeat.i(102039);
        TMLog.i(TAG, "onDestroy");
        super.onDestroy();
        ApkDownloadManager.getInstance().uninit();
        GetSettingEngine.getInstance().cancleRequest();
        LogReportManager.getInstance().cancleReport();
        LogReportManager.getInstance().destory();
        this.mServiceDownloadTaskManager.unRegisterApkDownloadManagerListener();
        this.mServiceDownloadTaskManager.setListener(null);
        this.mServiceDownloadTaskManager = null;
        NetworkMonitorReceiver.getInstance().unregisterReceiver();
        GlobalUtil.getInstance().destroy();
        SystemClock.sleep(300);
        a a2 = c.a(Process.myPid(), new a());
        Object obj = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/tmassistantsdk/downloadservice/TMAssistantDownloadSDKService", "onDestroy", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/tmassistantsdk/downloadservice/TMAssistantDownloadSDKService", "onDestroy", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(102039);
    }

    protected class TMAssistantDownloadSDKServiceImpl extends ITMAssistantDownloadSDKServiceInterface.Stub {
        protected TMAssistantDownloadSDKServiceImpl() {
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public int getServiceVersion() {
            return 1;
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void setServiceSetingIsTaskAutoResume(boolean z) {
            AppMethodBeat.i(102025);
            DownloadSetting.getInstance().setIsTaskAutoResume(z);
            AppMethodBeat.o(102025);
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void setServiceSetingIsDownloadWifiOnly(boolean z) {
            AppMethodBeat.i(102026);
            DownloadSetting.getInstance().setIsDownloadWifiOnly(z);
            AppMethodBeat.o(102026);
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void setServiceSetingMaxTaskNum(int i2) {
            AppMethodBeat.i(102027);
            DownloadSetting.getInstance().setMaxTaskNum(i2);
            AppMethodBeat.o(102027);
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public boolean isAllDownloadFinished() {
            AppMethodBeat.i(102028);
            boolean booleanValue = ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
            AppMethodBeat.o(102028);
            return booleanValue;
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2) {
            AppMethodBeat.i(102029);
            TMLog.i(TMAssistantDownloadSDKService.TAG, "getDownloadTaskInfo");
            if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
                TMAssistantDownloadTaskInfo downloadTaskInfo = TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.getDownloadTaskInfo(str, str2);
                AppMethodBeat.o(102029);
                return downloadTaskInfo;
            }
            AppMethodBeat.o(102029);
            return null;
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public int startDownloadTask(String str, String str2, String str3, long j2, int i2, String str4, String str5, Map map) {
            AppMethodBeat.i(102030);
            TMLog.i(TMAssistantDownloadSDKService.TAG, "startDownloadTask，clientkey:" + str + ",url:" + str2 + ",manager:" + TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager + ",fileName:" + str5);
            if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
                DBManager.getInstance().saveClientInfo(str, str2);
                int startDownload = TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.startDownload(str, str2, str3, j2, i2, str4, str5, map);
                AppMethodBeat.o(102030);
                return startDownload;
            }
            AppMethodBeat.o(102030);
            return 3;
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void pauseDownloadTask(String str, String str2) {
            AppMethodBeat.i(102031);
            TMLog.i(TMAssistantDownloadSDKService.TAG, JsApiPauseDownloadTask.NAME);
            try {
                if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
                    TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.pauseDownload(str, str2);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(TMAssistantDownloadSDKService.TAG, e2, "", new Object[0]);
            }
            TMLog.i(TMAssistantDownloadSDKService.TAG, "pauseDownloadTask end");
            AppMethodBeat.o(102031);
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void cancelDownloadTask(String str, String str2) {
            AppMethodBeat.i(102032);
            if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
                TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.cancelDownload(str, str2);
            }
            AppMethodBeat.o(102032);
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void registerDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
            AppMethodBeat.i(102033);
            TMLog.i(TMAssistantDownloadSDKService.TAG, "registerDownloadTaskCallback,clientKey:".concat(String.valueOf(str)));
            if (str == null || iTMAssistantDownloadSDKServiceCallback == null) {
                AppMethodBeat.o(102033);
                return;
            }
            TMAssistantDownloadSDKService.this.mCallbacks.register(iTMAssistantDownloadSDKServiceCallback);
            synchronized (this) {
                try {
                    TMAssistantDownloadSDKService.this.mCallbackHashMap.put(iTMAssistantDownloadSDKServiceCallback, str);
                } finally {
                    AppMethodBeat.o(102033);
                }
            }
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void unregisterDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
            AppMethodBeat.i(102034);
            TMLog.i(TMAssistantDownloadSDKService.TAG, "unregisterDownloadTaskCallback,clientKey:".concat(String.valueOf(str)));
            if (str == null || iTMAssistantDownloadSDKServiceCallback == null) {
                AppMethodBeat.o(102034);
                return;
            }
            TMAssistantDownloadSDKService.this.mCallbacks.unregister(iTMAssistantDownloadSDKServiceCallback);
            synchronized (this) {
                try {
                    TMAssistantDownloadSDKService.this.mCallbackHashMap.remove(iTMAssistantDownloadSDKServiceCallback);
                } finally {
                    AppMethodBeat.o(102034);
                }
            }
        }
    }

    @Override // com.tencent.tmassistantsdk.downloadservice.taskmanager.IServiceDownloadTaskManagerListener
    public void OnDownloadStateChanged(String str, String str2, int i2, int i3, String str3, boolean z, boolean z2) {
        AppMethodBeat.i(102040);
        try {
            int beginBroadcast = this.mCallbacks.beginBroadcast();
            int i4 = 0;
            while (true) {
                if (i4 >= beginBroadcast) {
                    break;
                }
                try {
                    ITMAssistantDownloadSDKServiceCallback broadcastItem = this.mCallbacks.getBroadcastItem(i4);
                    String str4 = this.mCallbackHashMap.get(broadcastItem);
                    if (str4 != null && str4.equals(str)) {
                        TMLog.i(TAG, "OnDownloadStateChanged,clientKey:" + str + ",state:" + i2 + ",url:" + str2);
                        broadcastItem.OnDownloadSDKServiceTaskStateChanged(str, str2, i2, i3, str3, z, z2);
                        break;
                    }
                } catch (RemoteException e2) {
                }
                i4++;
            }
            this.mCallbacks.finishBroadcast();
            AppMethodBeat.o(102040);
        } catch (Throwable th) {
            AppMethodBeat.o(102040);
        }
    }

    @Override // com.tencent.tmassistantsdk.downloadservice.taskmanager.IServiceDownloadTaskManagerListener
    public void OnDownloadProgressChanged(String str, String str2, long j2, long j3) {
        AppMethodBeat.i(102041);
        try {
            int beginBroadcast = this.mCallbacks.beginBroadcast();
            int i2 = 0;
            while (true) {
                if (i2 >= beginBroadcast) {
                    break;
                }
                try {
                    ITMAssistantDownloadSDKServiceCallback broadcastItem = this.mCallbacks.getBroadcastItem(i2);
                    String str3 = this.mCallbackHashMap.get(broadcastItem);
                    if (str3 != null && str3.equals(str)) {
                        TMLog.i(TAG, "OnDownloadProgressChanged,clientKey:" + str + ",receivedLen:" + j2 + ",url:" + str2);
                        broadcastItem.OnDownloadSDKServiceTaskProgressChanged(str, str2, j2, j3);
                        break;
                    }
                } catch (RemoteException e2) {
                }
                i2++;
            }
            this.mCallbacks.finishBroadcast();
            AppMethodBeat.o(102041);
        } catch (Throwable th) {
            AppMethodBeat.o(102041);
        }
    }
}

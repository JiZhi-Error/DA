package com.tencent.tmassistantsdk.downloadservice.taskmanager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.ApkDownloadManager;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.IDownloadManagerListener;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ServiceDownloadTaskManager implements IDownloadManagerListener {
    protected static final String TAG = "ServiceDownloadTaskManager";
    protected IServiceDownloadTaskManagerListener mListener = null;
    protected ArrayList<ServiceDownloadTask> mServiceTaskList = new ArrayList<>();

    public ServiceDownloadTaskManager(ArrayList<ServiceDownloadTask> arrayList) {
        AppMethodBeat.i(102042);
        if (arrayList != null && arrayList.size() > 0) {
            this.mServiceTaskList.addAll(arrayList);
        }
        AppMethodBeat.o(102042);
    }

    public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2) {
        AppMethodBeat.i(102043);
        DownloadInfo queryDownloadInfo = ApkDownloadManager.getInstance().queryDownloadInfo(str2);
        if (queryDownloadInfo != null) {
            TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(queryDownloadInfo.mURL, TMAssistantFile.getSaveFilePath(queryDownloadInfo.mFileName), queryDownloadInfo.mStatus, queryDownloadInfo.mReceivedBytes, queryDownloadInfo.getTotalSize(), queryDownloadInfo.mContentType);
            AppMethodBeat.o(102043);
            return tMAssistantDownloadTaskInfo;
        } else if (DownloadHelper.isDownloadFileExisted(str2, "application/vnd.android.package-archive")) {
            String generateFileNameFromURL = DownloadHelper.generateFileNameFromURL(str2, "application/vnd.android.package-archive");
            String saveFilePath = TMAssistantFile.getSaveFilePath(generateFileNameFromURL);
            TMAssistantFile tMAssistantFile = new TMAssistantFile(generateFileNameFromURL, generateFileNameFromURL);
            TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo2 = new TMAssistantDownloadTaskInfo(str2, saveFilePath, 4, tMAssistantFile.length(), tMAssistantFile.length(), "application/vnd.android.package-archive");
            AppMethodBeat.o(102043);
            return tMAssistantDownloadTaskInfo2;
        } else if (DownloadHelper.isDownloadFileExisted(str2, "application/tm.android.apkdiff")) {
            String generateFileNameFromURL2 = DownloadHelper.generateFileNameFromURL(str2, "application/tm.android.apkdiff");
            String saveFilePath2 = TMAssistantFile.getSaveFilePath(generateFileNameFromURL2);
            TMAssistantFile tMAssistantFile2 = new TMAssistantFile(generateFileNameFromURL2, generateFileNameFromURL2);
            TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo3 = new TMAssistantDownloadTaskInfo(str2, saveFilePath2, 4, tMAssistantFile2.length(), tMAssistantFile2.length(), "application/tm.android.apkdiff");
            AppMethodBeat.o(102043);
            return tMAssistantDownloadTaskInfo3;
        } else {
            removeDownloadTask(str2);
            AppMethodBeat.o(102043);
            return null;
        }
    }

    public int startDownload(String str, String str2, String str3, long j2, int i2, String str4, String str5, Map<String, String> map) {
        boolean z;
        AppMethodBeat.i(102044);
        if (str == null || str2 == null) {
            AppMethodBeat.o(102044);
            return 3;
        }
        TMLog.i(TAG, "startDownload,clientKey:".concat(String.valueOf(str)));
        if (findDownloadTask(str, str2) != null) {
            TMLog.i(TAG, "startDownload,clientKey:" + str + ",taskItem isn't null");
            int startDownload = ApkDownloadManager.getInstance().startDownload(str2, str3, j2, i2, str4, str5, map);
            AppMethodBeat.o(102044);
            return startDownload;
        }
        ArrayList<ServiceDownloadTask> findDownloadTask = findDownloadTask(str2);
        boolean z2 = false;
        ServiceDownloadTask serviceDownloadTask = new ServiceDownloadTask(str, str2);
        serviceDownloadTask.mState = 1;
        this.mServiceTaskList.add(serviceDownloadTask);
        TMLog.i(TAG, "startDownload,clientKey:" + str + ",add newTask");
        Iterator<ServiceDownloadTask> it = findDownloadTask.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            ServiceDownloadTask next = it.next();
            if (next.mState == 2) {
                z3 = true;
            } else {
                if (next.mState == 1) {
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
        }
        if (z3 || z2) {
            if (z3) {
                serviceDownloadTask.mState = 2;
            } else if (z2) {
                serviceDownloadTask.mState = 1;
            }
            if (this.mListener != null) {
                this.mListener.OnDownloadStateChanged(str, str2, serviceDownloadTask.mState, 0, null, false, false);
            }
            TMLog.i(TAG, "startDownload,clientKey:" + str + ",newTask is downloading, state = " + serviceDownloadTask.mState);
            AppMethodBeat.o(102044);
            return 0;
        }
        TMLog.i(TAG, "startDownload,clientKey:" + str + ",start newTask download");
        int startDownload2 = ApkDownloadManager.getInstance().startDownload(str2, str3, j2, i2, str4, str5, map);
        AppMethodBeat.o(102044);
        return startDownload2;
    }

    public void pauseDownload(String str, String str2) {
        AppMethodBeat.i(102045);
        if (str == null || str2 == null) {
            AppMethodBeat.o(102045);
            return;
        }
        TMLog.i(TAG, "pauseDownload,clientKey:".concat(String.valueOf(str)));
        ServiceDownloadTask findDownloadTask = findDownloadTask(str, str2);
        if (findDownloadTask != null) {
            findDownloadTask.mState = 3;
            this.mServiceTaskList.remove(findDownloadTask);
            TMLog.i(TAG, "pauseDownload,clientKey:" + str + ",remove taskItem");
            ArrayList<ServiceDownloadTask> findDownloadTask2 = findDownloadTask(str2);
            if (findDownloadTask2 == null || findDownloadTask2.size() == 0) {
                TMLog.i(TAG, "pauseDownload,clientKey:" + str + ",taskItem is the only on pauseAll");
                ApkDownloadManager.getInstance().pauseDownload(str2);
                TMLog.i(TAG, "pauseDownload end,clientKey:" + str + ",taskItem is the only on pauseAll");
            }
            if (this.mListener != null) {
                this.mListener.OnDownloadStateChanged(str, str2, findDownloadTask.mState, 0, null, false, false);
            }
        } else {
            TMLog.w(TAG, "pauseDownload,clientKey:" + str + ",taskItem is null");
        }
        TMLog.i(TAG, "pauseDownload end,clientKey:".concat(String.valueOf(str)));
        AppMethodBeat.o(102045);
    }

    public void cancelDownload(String str, String str2) {
        AppMethodBeat.i(102046);
        if (str == null || str2 == null) {
            AppMethodBeat.o(102046);
            return;
        }
        TMLog.i(TAG, "cancelDownload,clientKey:".concat(String.valueOf(str)));
        ServiceDownloadTask findDownloadTask = findDownloadTask(str, str2);
        if (findDownloadTask != null) {
            this.mServiceTaskList.remove(findDownloadTask);
            TMLog.i(TAG, "cancelDownload,clientKey:" + str + ",remove taskItem");
        } else {
            TMLog.w(TAG, "cancelDownload,clientKey:" + str + ",taskItem is null");
        }
        ArrayList<ServiceDownloadTask> findDownloadTask2 = findDownloadTask(str2);
        if (findDownloadTask2 == null || findDownloadTask2.size() == 0) {
            TMLog.i(TAG, "cancelDownload,clientKey:" + str + ",taskItem is the only on cancelAll");
            ApkDownloadManager.getInstance().cancelDownload(str2);
        }
        AppMethodBeat.o(102046);
    }

    public void registerApkDownloadManagerListener() {
        AppMethodBeat.i(102047);
        ApkDownloadManager.getInstance().AddDownloadListener(this);
        AppMethodBeat.o(102047);
    }

    public void unRegisterApkDownloadManagerListener() {
        AppMethodBeat.i(102048);
        ApkDownloadManager.getInstance().RemoveDownloadListener(this);
        AppMethodBeat.o(102048);
    }

    /* access modifiers changed from: protected */
    public synchronized ServiceDownloadTask findDownloadTask(String str, String str2) {
        ServiceDownloadTask serviceDownloadTask;
        AppMethodBeat.i(102049);
        if (str != null && str2 != null) {
            Iterator<ServiceDownloadTask> it = this.mServiceTaskList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    AppMethodBeat.o(102049);
                    serviceDownloadTask = null;
                    break;
                }
                serviceDownloadTask = it.next();
                if (serviceDownloadTask.mClientKey != null && serviceDownloadTask.mClientKey.equals(str) && serviceDownloadTask.mUrl.equals(str2)) {
                    AppMethodBeat.o(102049);
                    break;
                }
            }
        } else {
            AppMethodBeat.o(102049);
            serviceDownloadTask = null;
        }
        return serviceDownloadTask;
    }

    /* access modifiers changed from: protected */
    public synchronized ArrayList<ServiceDownloadTask> findDownloadTask(String str) {
        ArrayList<ServiceDownloadTask> arrayList;
        AppMethodBeat.i(102050);
        if (str == null) {
            arrayList = null;
            AppMethodBeat.o(102050);
        } else {
            ArrayList<ServiceDownloadTask> arrayList2 = new ArrayList<>();
            Iterator<ServiceDownloadTask> it = this.mServiceTaskList.iterator();
            while (it.hasNext()) {
                ServiceDownloadTask next = it.next();
                if (next.mUrl.equals(str)) {
                    arrayList2.add(next);
                }
            }
            AppMethodBeat.o(102050);
            arrayList = arrayList2;
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public synchronized void removeDownloadTask(String str) {
        AppMethodBeat.i(102051);
        if (str == null) {
            AppMethodBeat.o(102051);
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<ServiceDownloadTask> it = this.mServiceTaskList.iterator();
            while (it.hasNext()) {
                ServiceDownloadTask next = it.next();
                if (next.mUrl.equals(str)) {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 0) {
                this.mServiceTaskList.removeAll(arrayList);
            }
            AppMethodBeat.o(102051);
        }
    }

    public void setListener(IServiceDownloadTaskManagerListener iServiceDownloadTaskManagerListener) {
        this.mListener = iServiceDownloadTaskManagerListener;
    }

    @Override // com.tencent.tmassistantsdk.downloadservice.IDownloadManagerListener
    public void OnDownloadStateChanged(String str, int i2, int i3, String str2, boolean z, boolean z2) {
        AppMethodBeat.i(102052);
        if (this.mListener == null) {
            AppMethodBeat.o(102052);
            return;
        }
        ArrayList<ServiceDownloadTask> findDownloadTask = findDownloadTask(str);
        if (findDownloadTask != null && findDownloadTask.size() > 0) {
            Iterator<ServiceDownloadTask> it = findDownloadTask.iterator();
            while (it.hasNext()) {
                ServiceDownloadTask next = it.next();
                TMLog.i(TAG, "OnDownloadStateChanged,clientKey:" + next.mClientKey + ",state:" + i2 + ",errorcode:" + i3 + ",url:" + str.hashCode());
                next.mState = i2;
                this.mListener.OnDownloadStateChanged(next.mClientKey, str, i2, i3, str2, z, z2);
            }
        }
        AppMethodBeat.o(102052);
    }

    @Override // com.tencent.tmassistantsdk.downloadservice.IDownloadManagerListener
    public void OnDownloadProgressChanged(String str, long j2, long j3) {
        AppMethodBeat.i(102053);
        if (this.mListener == null) {
            AppMethodBeat.o(102053);
            return;
        }
        ArrayList<ServiceDownloadTask> findDownloadTask = findDownloadTask(str);
        if (findDownloadTask != null && findDownloadTask.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<ServiceDownloadTask> it = findDownloadTask.iterator();
            while (it.hasNext()) {
                ServiceDownloadTask next = it.next();
                if (next.checkIsNeedUpdateProgress(j2, j3, currentTimeMillis)) {
                    TMLog.i(TAG, "OnDownloadProgressChanged,clientKey:" + next.mClientKey + ",receivedLen:" + j2 + ",url:" + str.hashCode());
                    this.mListener.OnDownloadProgressChanged(next.mClientKey, str, j2, j3);
                }
            }
        }
        AppMethodBeat.o(102053);
    }
}

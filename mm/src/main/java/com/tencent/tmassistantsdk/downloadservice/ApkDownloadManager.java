package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.storage.DBManager;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApkDownloadManager implements NetworkMonitorReceiver.INetworkChangedObserver {
    protected static final long INTERVAL = 180000;
    protected static final String TAG = "ApkDownloadManager";
    protected static ApkDownloadManager mApkDownloadManager = null;
    final Map<String, DownloadInfo> mDownloads = new ConcurrentHashMap();

    public static ApkDownloadManager getInstance() {
        AppMethodBeat.i(101926);
        if (mApkDownloadManager == null) {
            mApkDownloadManager = new ApkDownloadManager();
        }
        ApkDownloadManager apkDownloadManager = mApkDownloadManager;
        AppMethodBeat.o(101926);
        return apkDownloadManager;
    }

    private ApkDownloadManager() {
        AppMethodBeat.i(101927);
        AppMethodBeat.o(101927);
    }

    public void init() {
        AppMethodBeat.i(101928);
        TMLog.i(TAG, "Start to load DownloadInfo list.");
        this.mDownloads.clear();
        ArrayList<DownloadInfo> queryDownloadInfoList = DBManager.getInstance().queryDownloadInfoList();
        if (queryDownloadInfoList != null) {
            TMLog.i(TAG, "The size of downloadinfo_list: " + queryDownloadInfoList.size());
            Iterator<DownloadInfo> it = queryDownloadInfoList.iterator();
            while (it.hasNext()) {
                DownloadInfo next = it.next();
                TMLog.i(TAG, "---------------load download info---------------");
                next.dump(TAG);
                this.mDownloads.put(next.mURL, next);
                if (!next.hasFinished()) {
                    next.updateStatus(3, false);
                }
            }
        }
        TMLog.i(TAG, "Add NetworkChangedObserver to NetworkMonitorReceiver");
        NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this);
        AppMethodBeat.o(101928);
    }

    public void uninit() {
        AppMethodBeat.i(101929);
        NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this);
        ArrayList<DownloadInfo> arrayList = new ArrayList<>();
        if (!this.mDownloads.isEmpty()) {
            for (String str : this.mDownloads.keySet()) {
                DownloadInfo downloadInfo = this.mDownloads.get(str);
                if (downloadInfo.mStatus == 2) {
                    pauseDownload(downloadInfo.mURL);
                }
                arrayList.add(downloadInfo);
            }
        }
        TMLog.i(TAG, "Start to save DownloadInfo list.");
        DBManager.getInstance().saveDownloadInfoList(arrayList);
        AppMethodBeat.o(101929);
    }

    public int startDownload(String str, String str2, long j2, int i2, String str3, String str4, Map<String, String> map) {
        DownloadInfo downloadInfo;
        boolean isDownloadFileExisted;
        boolean isDownloadFileExisted2;
        AppMethodBeat.i(101930);
        TMLog.i(TAG, "call startDownload, url: " + str + "priority: " + i2);
        if (!DownloadHelper.isNetworkConncted()) {
            TMLog.i(TAG, "call startDownload, return errCode: 1");
            AppMethodBeat.o(101930);
            return 1;
        } else if (!DownloadHelper.getNetStatus().equalsIgnoreCase("wifi") && DownloadSetting.getInstance().getIsDownloadWifiOnly()) {
            TMLog.i(TAG, "call startDownload, return errCode: 2");
            AppMethodBeat.o(101930);
            return 2;
        } else if (!DownloadHelper.isValidURL(str)) {
            TMLog.i(TAG, "call startDownload, return errCode: 3");
            AppMethodBeat.o(101930);
            return 3;
        } else if (DownloadHelper.isDownloadFileExisted(str, str3)) {
            TMLog.i(TAG, "call startDownload, return errCode: 4");
            AppMethodBeat.o(101930);
            return 4;
        } else {
            DownloadInfo downloadInfo2 = this.mDownloads.get(str);
            if (downloadInfo2 == null) {
                downloadInfo = DBManager.getInstance().queryDownloadInfoByUrl(str);
                if (downloadInfo == null) {
                    downloadInfo = new DownloadInfo(str, str2, j2, i2, str3);
                    if (downloadInfo.mContentType.equals("resource/tm.android.unknown")) {
                        downloadInfo.mFileName = str4;
                    }
                } else {
                    if (downloadInfo.mContentType.equals("application/tm.android.apkdiff")) {
                        isDownloadFileExisted2 = DownloadHelper.isDownloadFileExisted(str, downloadInfo.mContentType);
                    } else {
                        isDownloadFileExisted2 = DownloadHelper.isDownloadFileExisted(downloadInfo.mFileName);
                    }
                    if (isDownloadFileExisted2) {
                        TMLog.i(TAG, "call startDownload, return errCode: 4");
                        AppMethodBeat.o(101930);
                        return 4;
                    }
                }
                this.mDownloads.put(str, downloadInfo);
            } else {
                downloadInfo = downloadInfo2;
            }
            downloadInfo.setHeaderParams((HashMap) map);
            if (downloadInfo.mContentType.equals("application/tm.android.apkdiff")) {
                isDownloadFileExisted = DownloadHelper.isDownloadFileExisted(str, downloadInfo.mContentType);
            } else {
                isDownloadFileExisted = DownloadHelper.isDownloadFileExisted(downloadInfo.mFileName);
            }
            TMLog.i(TAG, "fileExited = ".concat(String.valueOf(isDownloadFileExisted)));
            if (isDownloadFileExisted) {
                AppMethodBeat.o(101930);
                return 4;
            }
            if (downloadInfo.hasReceivedAllDataBytes() && !isDownloadFileExisted) {
                this.mDownloads.remove(str);
                DBManager.getInstance().deleteDownloadInfo(str);
                downloadInfo = new DownloadInfo(str, str2, j2, i2, str3);
                if (downloadInfo.mContentType.equals("resource/tm.android.unknown")) {
                    downloadInfo.mFileName = str4;
                }
                downloadInfo.setHeaderParams((HashMap) map);
                this.mDownloads.put(str, downloadInfo);
            }
            int startDownloadIfReady = downloadInfo.startDownloadIfReady();
            TMLog.i(TAG, "call startDownload, return errCode: ".concat(String.valueOf(startDownloadIfReady)));
            AppMethodBeat.o(101930);
            return startDownloadIfReady;
        }
    }

    public void pauseDownload(String str) {
        AppMethodBeat.i(101931);
        TMLog.i(TAG, "call pauseDownload, url: ".concat(String.valueOf(str)));
        DownloadInfo downloadInfo = this.mDownloads.get(str);
        if (downloadInfo != null) {
            downloadInfo.pauseDownload();
        }
        AppMethodBeat.o(101931);
    }

    public void cancelDownload(String str) {
        AppMethodBeat.i(101932);
        TMLog.i(TAG, "call cancelDownload, url: ".concat(String.valueOf(str)));
        DownloadInfo remove = this.mDownloads.remove(str);
        if (remove != null) {
            remove.stopDownload();
        }
        AppMethodBeat.o(101932);
    }

    public DownloadInfo queryDownloadInfo(String str) {
        AppMethodBeat.i(101933);
        TMLog.i(TAG, "call queryDownloadInfo, url: ".concat(String.valueOf(str)));
        DownloadInfo downloadInfo = this.mDownloads.get(str);
        if (downloadInfo == null) {
            downloadInfo = DBManager.getInstance().queryDownloadInfoByUrl(str);
        }
        boolean z = false;
        if (downloadInfo != null) {
            if (downloadInfo.mContentType.equals("application/tm.android.apkdiff")) {
                z = DownloadHelper.isDownloadFileExisted(str, downloadInfo.mContentType);
            } else {
                z = DownloadHelper.isDownloadFileExisted(downloadInfo.mFileName);
            }
        }
        if (downloadInfo != null && downloadInfo.hasReceivedAllDataBytes() && !z) {
            this.mDownloads.remove(str);
            DBManager.getInstance().deleteDownloadInfo(str);
            downloadInfo = null;
        }
        AppMethodBeat.o(101933);
        return downloadInfo;
    }

    public Boolean isAllDownloadFinished() {
        AppMethodBeat.i(101934);
        for (String str : this.mDownloads.keySet()) {
            if (!this.mDownloads.get(str).hasFinished()) {
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(101934);
                return bool;
            }
        }
        Boolean bool2 = Boolean.TRUE;
        AppMethodBeat.o(101934);
        return bool2;
    }

    public void AddDownloadListener(IDownloadManagerListener iDownloadManagerListener) {
        AppMethodBeat.i(101935);
        TMLog.i(TAG, "call AddDownloadListener, dl: ".concat(String.valueOf(iDownloadManagerListener)));
        DownloadListenerManager.getInstance().Add(iDownloadManagerListener);
        AppMethodBeat.o(101935);
    }

    public void RemoveDownloadListener(IDownloadManagerListener iDownloadManagerListener) {
        AppMethodBeat.i(101936);
        TMLog.i(TAG, "call RemoveDownloadListener, dl: ".concat(String.valueOf(iDownloadManagerListener)));
        DownloadListenerManager.getInstance().Remove(iDownloadManagerListener);
        AppMethodBeat.o(101936);
    }

    @Override // com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.INetworkChangedObserver
    public void onNetworkChanged() {
        AppMethodBeat.i(101937);
        TMLog.i(TAG, "onNetworkChanged");
        if (DownloadHelper.isNetworkConncted() && DownloadSetting.getInstance().isAutoDownload()) {
            String netStatus = DownloadHelper.getNetStatus();
            TMLog.i(TAG, "currentNetType = ".concat(String.valueOf(netStatus)));
            for (String str : this.mDownloads.keySet()) {
                DownloadInfo downloadInfo = this.mDownloads.get(str);
                if (DownloadSetting.getInstance().isAutoDownload(downloadInfo.mNetType, netStatus)) {
                    TMLog.i(TAG, "onNetworkChanged, errCode = " + downloadInfo.mDownloadFailedErrCode);
                    if (downloadInfo.mDownloadFailedErrCode == 601 || downloadInfo.mDownloadFailedErrCode == 602 || downloadInfo.mDownloadFailedErrCode == 605 || downloadInfo.mDownloadFailedErrCode == 603 || downloadInfo.mDownloadFailedErrCode == 606) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TMLog.i(TAG, "onNetworkChanged, currentTime = " + currentTimeMillis + ", DownloadFailedTime = " + downloadInfo.mDownloadFailedTime);
                        if (currentTimeMillis - downloadInfo.mDownloadFailedTime < INTERVAL) {
                            downloadInfo.startDownloadIfReady(true);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(101937);
    }
}

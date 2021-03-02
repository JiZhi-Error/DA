package com.tencent.tmassistantsdk.logreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.util.TMLog;

public class LogReportManager {
    private static final Class<?>[] REPORT_MANAGERS = {DownloadReportManager.class, TipsInfoReportManager.class, UpdateInfoReportManager.class};
    private static final String TAG = "LogReportManager";
    private static LogReportManager mInstance = null;
    private final NetworkMonitorReceiver.INetworkChangedObserver mNetworkChangedObserver = new NetworkMonitorReceiver.INetworkChangedObserver() {
        /* class com.tencent.tmassistantsdk.logreport.LogReportManager.AnonymousClass1 */

        @Override // com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.INetworkChangedObserver
        public void onNetworkChanged() {
            AppMethodBeat.i(102063);
            TMLog.i(LogReportManager.TAG, "onNetworkChanged,netState:" + DownloadHelper.getNetStatus());
            Class[] clsArr = LogReportManager.REPORT_MANAGERS;
            for (Class cls : clsArr) {
                try {
                    if (cls.equals(DownloadReportManager.class)) {
                        DownloadReportManager.getInstance().resetMaxReportCount();
                    } else if (cls.equals(TipsInfoReportManager.class)) {
                        TipsInfoReportManager.getInstance().resetMaxReportCount();
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace(LogReportManager.TAG, e2, "", new Object[0]);
                }
            }
            if (DownloadHelper.isNetworkConncted()) {
                DownloadHelper.getNetStatus().equalsIgnoreCase("wifi");
            }
            AppMethodBeat.o(102063);
        }
    };

    public static synchronized LogReportManager getInstance() {
        LogReportManager logReportManager;
        synchronized (LogReportManager.class) {
            AppMethodBeat.i(102064);
            if (mInstance == null) {
                mInstance = new LogReportManager();
            }
            logReportManager = mInstance;
            AppMethodBeat.o(102064);
        }
        return logReportManager;
    }

    private LogReportManager() {
        AppMethodBeat.i(102065);
        NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this.mNetworkChangedObserver);
        AppMethodBeat.o(102065);
    }

    public void destory() {
        AppMethodBeat.i(102066);
        Class<?>[] clsArr = REPORT_MANAGERS;
        for (Class<?> cls : clsArr) {
            try {
                if (cls.equals(DownloadReportManager.class)) {
                    DownloadReportManager.getInstance().destroy();
                } else if (cls.equals(TipsInfoReportManager.class)) {
                    TipsInfoReportManager.getInstance().destroy();
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this.mNetworkChangedObserver);
        AppMethodBeat.o(102066);
    }

    public void reportLog() {
        AppMethodBeat.i(102067);
        Class<?>[] clsArr = REPORT_MANAGERS;
        for (Class<?> cls : clsArr) {
            try {
                if (cls.equals(DownloadReportManager.class)) {
                    DownloadReportManager.getInstance().reportLogData();
                } else if (cls.equals(TipsInfoReportManager.class)) {
                    TipsInfoReportManager.getInstance().reportLogData();
                } else if (cls.equals(UpdateInfoReportManager.class)) {
                    UpdateInfoReportManager.getInstance().reportLogData();
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102067);
    }

    public void cancleReport() {
        AppMethodBeat.i(102068);
        Class<?>[] clsArr = REPORT_MANAGERS;
        for (Class<?> cls : clsArr) {
            try {
                if (cls.equals(DownloadReportManager.class)) {
                    DownloadReportManager.getInstance().cancleRequest();
                } else if (cls.equals(TipsInfoReportManager.class)) {
                    TipsInfoReportManager.getInstance().cancleRequest();
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102068);
    }
}

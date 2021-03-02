package com.tencent.tmassistantsdk.logreport;

import android.net.Proxy;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable;
import com.tencent.tmassistantsdk.storage.table.DownloadLogTable;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;

public class DownloadReportManager extends BaseReportManager {
    protected static final String TAG = "DownloadReportManager";
    protected static DownloadReportManager mInstance = null;

    protected DownloadReportManager() {
    }

    public static synchronized DownloadReportManager getInstance() {
        DownloadReportManager downloadReportManager;
        synchronized (DownloadReportManager.class) {
            AppMethodBeat.i(102054);
            if (mInstance == null) {
                mInstance = new DownloadReportManager();
            }
            downloadReportManager = mInstance;
            AppMethodBeat.o(102054);
        }
        return downloadReportManager;
    }

    public DownloadChunkLogInfo createNewChunkLogInfo(byte b2) {
        AppMethodBeat.i(102055);
        TMLog.i(TAG, "createNewChunkLogInfo");
        DownloadChunkLogInfo downloadChunkLogInfo = new DownloadChunkLogInfo();
        downloadChunkLogInfo.type = b2;
        downloadChunkLogInfo.networkOperator = GlobalUtil.getInstance().getNetworkOperator();
        downloadChunkLogInfo.networkType = GlobalUtil.getInstance().getNetworkType();
        downloadChunkLogInfo.isWap = (byte) (!TextUtils.isEmpty(Proxy.getDefaultHost()) ? 1 : 0);
        downloadChunkLogInfo.startTime = System.currentTimeMillis();
        AppMethodBeat.o(102055);
        return downloadChunkLogInfo;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.logreport.BaseReportManager
    public BaseLogTable getLogTable() {
        AppMethodBeat.i(102056);
        DownloadLogTable instance = DownloadLogTable.getInstance();
        AppMethodBeat.o(102056);
        return instance;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.logreport.BaseReportManager
    public byte getReportType() {
        return 0;
    }
}

package com.tencent.tmassistantsdk.logreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKAuthorizedInfo;
import com.tencent.tmassistantsdk.protocol.jce.TipsInfoLog;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable;
import com.tencent.tmassistantsdk.storage.table.TipsInfoLogTable;
import com.tencent.tmassistantsdk.util.TMLog;

public class TipsInfoReportManager extends BaseReportManager {
    protected static final String TAG = "TipsInfoReportManager";
    protected static TipsInfoReportManager mInstance = null;

    private TipsInfoReportManager() {
    }

    public static synchronized TipsInfoReportManager getInstance() {
        TipsInfoReportManager tipsInfoReportManager;
        synchronized (TipsInfoReportManager.class) {
            AppMethodBeat.i(102069);
            if (mInstance == null) {
                mInstance = new TipsInfoReportManager();
            }
            tipsInfoReportManager = mInstance;
            AppMethodBeat.o(102069);
        }
        return tipsInfoReportManager;
    }

    public TipsInfoLog createTipsInfoLog(TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo) {
        AppMethodBeat.i(102070);
        TMLog.i(TAG, "createTipsInfoLog");
        if (tMOpenSDKAuthorizedInfo == null) {
            AppMethodBeat.o(102070);
            return null;
        }
        TipsInfoLog tipsInfoLog = new TipsInfoLog();
        tipsInfoLog.userId = tMOpenSDKAuthorizedInfo.userId;
        tipsInfoLog.userIdType = tMOpenSDKAuthorizedInfo.userIdType;
        tipsInfoLog.gamePackageName = tMOpenSDKAuthorizedInfo.gamePackageName;
        tipsInfoLog.gameVersionCode = Util.getInt(tMOpenSDKAuthorizedInfo.gameVersionCode, 0);
        tipsInfoLog.gameChannelId = tMOpenSDKAuthorizedInfo.gameChannelId;
        AppMethodBeat.o(102070);
        return tipsInfoLog;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.logreport.BaseReportManager
    public BaseLogTable getLogTable() {
        AppMethodBeat.i(102071);
        TipsInfoLogTable instance = TipsInfoLogTable.getInstance();
        AppMethodBeat.o(102071);
        return instance;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.logreport.BaseReportManager
    public byte getReportType() {
        return 1;
    }
}

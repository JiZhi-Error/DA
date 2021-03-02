package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.as;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.reflect.Field;

public final class k extends as {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(112784);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "code_id";
        mAutoDBInfo.colsMap.put("code_id", "TEXT");
        sb.append(" code_id TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "card_id";
        mAutoDBInfo.colsMap.put("card_id", "TEXT");
        sb.append(" card_id TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = TMQQDownloaderOpenSDKConst.UINTYPE_CODE;
        mAutoDBInfo.colsMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "TEXT");
        sb.append(" code TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(112784);
    }
}

package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fc;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.lang.reflect.Field;

public final class cg extends fc {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(32880);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT PRIMARY KEY ");
        sb.append(" appId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "appId";
        mAutoDBInfo.columns[1] = AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME;
        mAutoDBInfo.colsMap.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "TEXT");
        sb.append(" packageName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
        sb.append(" status INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "sceneFlag";
        mAutoDBInfo.colsMap.put("sceneFlag", "INTEGER default '0' ");
        sb.append(" sceneFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "msgTypeFlag";
        mAutoDBInfo.colsMap.put("msgTypeFlag", "INTEGER default '0' ");
        sb.append(" msgTypeFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "msgState";
        mAutoDBInfo.colsMap.put("msgState", "INTEGER default '0' ");
        sb.append(" msgState INTEGER default '0' ");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(32880);
    }
}

package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.df;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.lang.reflect.Field;

public final class d extends df {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(41672);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[19];
        mAutoDBInfo.columns = new String[20];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT PRIMARY KEY ");
        sb.append(" appId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "appId";
        mAutoDBInfo.columns[1] = "downloadUrl";
        mAutoDBInfo.colsMap.put("downloadUrl", "TEXT");
        sb.append(" downloadUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "size";
        mAutoDBInfo.colsMap.put("size", "LONG default '0' ");
        sb.append(" size LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "md5";
        mAutoDBInfo.colsMap.put("md5", "TEXT");
        sb.append(" md5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME;
        mAutoDBInfo.colsMap.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "TEXT");
        sb.append(" packageName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "expireTime";
        mAutoDBInfo.colsMap.put("expireTime", "LONG default '0' ");
        sb.append(" expireTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "randomTime";
        mAutoDBInfo.colsMap.put("randomTime", "LONG default '0' ");
        sb.append(" randomTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "isFirst";
        mAutoDBInfo.colsMap.put("isFirst", "INTEGER default 'true' ");
        sb.append(" isFirst INTEGER default 'true' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "nextCheckTime";
        mAutoDBInfo.colsMap.put("nextCheckTime", "LONG default '0' ");
        sb.append(" nextCheckTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "isRunning";
        mAutoDBInfo.colsMap.put("isRunning", "INTEGER default 'false' ");
        sb.append(" isRunning INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "noWifi";
        mAutoDBInfo.colsMap.put("noWifi", "INTEGER default 'true' ");
        sb.append(" noWifi INTEGER default 'true' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "noSdcard";
        mAutoDBInfo.colsMap.put("noSdcard", "INTEGER default 'true' ");
        sb.append(" noSdcard INTEGER default 'true' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "noEnoughSpace";
        mAutoDBInfo.colsMap.put("noEnoughSpace", "INTEGER default 'true' ");
        sb.append(" noEnoughSpace INTEGER default 'true' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "lowBattery";
        mAutoDBInfo.colsMap.put("lowBattery", "INTEGER default 'true' ");
        sb.append(" lowBattery INTEGER default 'true' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "continueDelay";
        mAutoDBInfo.colsMap.put("continueDelay", "INTEGER default 'true' ");
        sb.append(" continueDelay INTEGER default 'true' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "SecondaryUrl";
        mAutoDBInfo.colsMap.put("SecondaryUrl", "TEXT");
        sb.append(" SecondaryUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "downloadInWidget";
        mAutoDBInfo.colsMap.put("downloadInWidget", "INTEGER");
        sb.append(" downloadInWidget INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "sectionMd5Byte";
        mAutoDBInfo.colsMap.put("sectionMd5Byte", "BLOB");
        sb.append(" sectionMd5Byte BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "forceUpdateFlag";
        mAutoDBInfo.colsMap.put("forceUpdateFlag", "INTEGER default '0' ");
        sb.append(" forceUpdateFlag INTEGER default '0' ");
        mAutoDBInfo.columns[19] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(41672);
    }
}

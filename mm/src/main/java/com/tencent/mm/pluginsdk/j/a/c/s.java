package com.tencent.mm.pluginsdk.j.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ft;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class s extends ft {
    public static final IAutoDBItem.MAutoDBInfo info;

    public final String toString() {
        AppMethodBeat.i(152070);
        StringBuilder sb = new StringBuilder("ResDownloaderRecord {");
        try {
            Field[] declaredFields = getClass().getSuperclass().getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getName().startsWith(IAutoDBItem.FIELD_PREFIX)) {
                    field.setAccessible(true);
                    sb.append(field.getName().replaceFirst(IAutoDBItem.FIELD_PREFIX, "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (IllegalAccessException e2) {
            Log.printErrStackTrace("MicroMsg.ResDownloaderRecord", e2, "", new Object[0]);
        }
        try {
            Field field2 = getClass().getSuperclass().getSuperclass().getField("systemRowid");
            field2.setAccessible(true);
            sb.append("systemRowid = ").append(field2.get(this));
        } catch (IllegalAccessException e3) {
            Log.printErrStackTrace("MicroMsg.ResDownloaderRecord", e3, "", new Object[0]);
        } catch (NoSuchFieldException e4) {
            Log.printErrStackTrace("MicroMsg.ResDownloaderRecord", e4, "", new Object[0]);
        }
        String sb2 = sb.append(" }").toString();
        AppMethodBeat.o(152070);
        return sb2;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(152071);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[34];
        mAutoDBInfo.columns = new String[35];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "urlKey_hashcode";
        mAutoDBInfo.colsMap.put("urlKey_hashcode", "INTEGER PRIMARY KEY ");
        sb.append(" urlKey_hashcode INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "urlKey_hashcode";
        mAutoDBInfo.columns[1] = "urlKey";
        mAutoDBInfo.colsMap.put("urlKey", "TEXT");
        sb.append(" urlKey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "url";
        mAutoDBInfo.colsMap.put("url", "TEXT");
        sb.append(" url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "fileVersion";
        mAutoDBInfo.colsMap.put("fileVersion", "TEXT");
        sb.append(" fileVersion TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "networkType";
        mAutoDBInfo.colsMap.put("networkType", "INTEGER default '2' ");
        sb.append(" networkType INTEGER default '2' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "maxRetryTimes";
        mAutoDBInfo.colsMap.put("maxRetryTimes", "INTEGER default '3' ");
        sb.append(" maxRetryTimes INTEGER default '3' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "retryTimes";
        mAutoDBInfo.colsMap.put("retryTimes", "INTEGER default '3' ");
        sb.append(" retryTimes INTEGER default '3' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "filePath";
        mAutoDBInfo.colsMap.put("filePath", "TEXT");
        sb.append(" filePath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
        sb.append(" status INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "contentLength";
        mAutoDBInfo.colsMap.put("contentLength", "LONG default '0' ");
        sb.append(" contentLength LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = DownloadInfo.CONTENTTYPE;
        mAutoDBInfo.colsMap.put(DownloadInfo.CONTENTTYPE, "TEXT");
        sb.append(" contentType TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "expireTime";
        mAutoDBInfo.colsMap.put("expireTime", "LONG default '0' ");
        sb.append(" expireTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "md5";
        mAutoDBInfo.colsMap.put("md5", "TEXT");
        sb.append(" md5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "groupId1";
        mAutoDBInfo.colsMap.put("groupId1", "TEXT");
        sb.append(" groupId1 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "groupId2";
        mAutoDBInfo.colsMap.put("groupId2", "TEXT");
        sb.append(" groupId2 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = DownloadInfo.PRIORITY;
        mAutoDBInfo.colsMap.put(DownloadInfo.PRIORITY, "INTEGER default '0' ");
        sb.append(" priority INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "fileUpdated";
        mAutoDBInfo.colsMap.put("fileUpdated", "INTEGER");
        sb.append(" fileUpdated INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "deleted";
        mAutoDBInfo.colsMap.put("deleted", "INTEGER default 'false' ");
        sb.append(" deleted INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "resType";
        mAutoDBInfo.colsMap.put("resType", "INTEGER");
        sb.append(" resType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "subType";
        mAutoDBInfo.colsMap.put("subType", "INTEGER");
        sb.append(" subType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "reportId";
        mAutoDBInfo.colsMap.put("reportId", "LONG");
        sb.append(" reportId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "sampleId";
        mAutoDBInfo.colsMap.put("sampleId", "TEXT");
        sb.append(" sampleId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "eccSignature";
        mAutoDBInfo.colsMap.put("eccSignature", "BLOB");
        sb.append(" eccSignature BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "originalMd5";
        mAutoDBInfo.colsMap.put("originalMd5", "TEXT");
        sb.append(" originalMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "fileCompress";
        mAutoDBInfo.colsMap.put("fileCompress", "INTEGER default 'false' ");
        sb.append(" fileCompress INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "fileEncrypt";
        mAutoDBInfo.colsMap.put("fileEncrypt", "INTEGER default 'false' ");
        sb.append(" fileEncrypt INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[26] = "encryptKey";
        mAutoDBInfo.colsMap.put("encryptKey", "TEXT");
        sb.append(" encryptKey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[27] = "keyVersion";
        mAutoDBInfo.colsMap.put("keyVersion", "INTEGER default '0' ");
        sb.append(" keyVersion INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[28] = "EID";
        mAutoDBInfo.colsMap.put("EID", "INTEGER");
        sb.append(" EID INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[29] = "fileSize";
        mAutoDBInfo.colsMap.put("fileSize", "LONG");
        sb.append(" fileSize LONG");
        sb.append(", ");
        mAutoDBInfo.columns[30] = "needRetry";
        mAutoDBInfo.colsMap.put("needRetry", "INTEGER default '1' ");
        sb.append(" needRetry INTEGER default '1' ");
        sb.append(", ");
        mAutoDBInfo.columns[31] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[32] = "wvCacheType";
        mAutoDBInfo.colsMap.put("wvCacheType", "INTEGER");
        sb.append(" wvCacheType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[33] = "packageId";
        mAutoDBInfo.colsMap.put("packageId", "TEXT");
        sb.append(" packageId TEXT");
        mAutoDBInfo.columns[34] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(152071);
    }
}

package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.ge;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class j extends ge {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(126888);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_LOCALID;
        mAutoDBInfo.colsMap.put(ch.COL_LOCALID, "INTEGER PRIMARY KEY ");
        sb.append(" localId INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_LOCALID;
        mAutoDBInfo.columns[1] = DownloadInfo.FILENAME;
        mAutoDBInfo.colsMap.put(DownloadInfo.FILENAME, "TEXT");
        sb.append(" fileName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "fileNameHash";
        mAutoDBInfo.colsMap.put("fileNameHash", "INTEGER");
        sb.append(" fileNameHash INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "fileMd5";
        mAutoDBInfo.colsMap.put("fileMd5", "TEXT default '' ");
        sb.append(" fileMd5 TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "fileLength";
        mAutoDBInfo.colsMap.put("fileLength", "LONG default '0' ");
        sb.append(" fileLength LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "fileStatus";
        mAutoDBInfo.colsMap.put("fileStatus", "INTEGER default '0' ");
        sb.append(" fileStatus INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "fileDuration";
        mAutoDBInfo.colsMap.put("fileDuration", "INTEGER default '0' ");
        sb.append(" fileDuration INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
        sb.append(" createTime LONG default '0' ");
        mAutoDBInfo.columns[8] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(126888);
    }
}

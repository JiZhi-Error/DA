package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hs;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class c extends hs {
    public static final IAutoDBItem.MAutoDBInfo iBg;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    static {
        AppMethodBeat.i(110562);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[14];
        mAutoDBInfo.columns = new String[15];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "key";
        mAutoDBInfo.colsMap.put("key", "TEXT PRIMARY KEY ");
        sb.append(" key TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "key";
        mAutoDBInfo.columns[1] = "pkgId";
        mAutoDBInfo.colsMap.put("pkgId", "TEXT");
        sb.append(" pkgId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "version";
        mAutoDBInfo.colsMap.put("version", "TEXT");
        sb.append(" version TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "filePath";
        mAutoDBInfo.colsMap.put("filePath", "TEXT");
        sb.append(" filePath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "rid";
        mAutoDBInfo.colsMap.put("rid", "TEXT");
        sb.append(" rid TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "mimeType";
        mAutoDBInfo.colsMap.put("mimeType", "TEXT");
        sb.append(" mimeType TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "md5";
        mAutoDBInfo.colsMap.put("md5", "TEXT");
        sb.append(" md5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "downloadUrl";
        mAutoDBInfo.colsMap.put("downloadUrl", "TEXT");
        sb.append(" downloadUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "size";
        mAutoDBInfo.colsMap.put("size", "INTEGER");
        sb.append(" size INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "downloadNetType";
        mAutoDBInfo.colsMap.put("downloadNetType", "INTEGER");
        sb.append(" downloadNetType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "completeDownload";
        mAutoDBInfo.colsMap.put("completeDownload", "INTEGER default 'false' ");
        sb.append(" completeDownload INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "autoDownloadCount";
        mAutoDBInfo.colsMap.put("autoDownloadCount", "INTEGER default '0' ");
        sb.append(" autoDownloadCount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "fileDownloadCount";
        mAutoDBInfo.colsMap.put("fileDownloadCount", "INTEGER default '0' ");
        sb.append(" fileDownloadCount INTEGER default '0' ");
        mAutoDBInfo.columns[14] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        AppMethodBeat.o(110562);
    }
}

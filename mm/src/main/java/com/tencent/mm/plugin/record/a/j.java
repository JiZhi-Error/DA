package com.tencent.mm.plugin.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.fq;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class j extends fq implements c {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.plugin.record.a.c
    public final int getKey() {
        return this.field_localId;
    }

    public final String toString() {
        AppMethodBeat.i(140936);
        StringBuilder sb = new StringBuilder();
        sb.append("localid[").append(this.field_localId).append("]\n");
        sb.append("recordId[").append(this.field_recordLocalId).append("]\n");
        sb.append("mediaId[").append(this.field_mediaId).append("]\n");
        sb.append("dataId[").append(this.field_dataId).append("]\n");
        sb.append("path[").append(this.field_path).append("]\n");
        sb.append("cdnurl[").append(this.field_cdnUrl).append("]\n");
        sb.append("cdnkey[").append(this.field_cdnKey).append("]\n");
        sb.append("type[").append(this.field_type).append("]\n");
        sb.append("errCode[").append(this.field_errCode).append("]\n");
        sb.append("fileType[").append(this.field_fileType).append("]\n");
        sb.append("isThumb[").append(this.field_isThumb).append("]\n");
        sb.append("status[").append(this.field_status).append("]\n");
        sb.append("totalLen[").append(this.field_totalLen).append("]\n");
        sb.append("offset[").append(this.field_offset).append("]\n");
        sb.append("toUser[").append(this.field_toUser).append("]\n");
        String sb2 = sb.toString();
        AppMethodBeat.o(140936);
        return sb2;
    }

    static {
        AppMethodBeat.i(140937);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[18];
        mAutoDBInfo.columns = new String[19];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_LOCALID;
        mAutoDBInfo.colsMap.put(ch.COL_LOCALID, "INTEGER PRIMARY KEY ");
        sb.append(" localId INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_LOCALID;
        mAutoDBInfo.columns[1] = "recordLocalId";
        mAutoDBInfo.colsMap.put("recordLocalId", "INTEGER");
        sb.append(" recordLocalId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "toUser";
        mAutoDBInfo.colsMap.put("toUser", "TEXT default '' ");
        sb.append(" toUser TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "dataId";
        mAutoDBInfo.colsMap.put("dataId", "TEXT");
        sb.append(" dataId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "mediaId";
        mAutoDBInfo.colsMap.put("mediaId", "TEXT");
        sb.append(" mediaId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "path";
        mAutoDBInfo.colsMap.put("path", "TEXT");
        sb.append(" path TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "cdnUrl";
        mAutoDBInfo.colsMap.put("cdnUrl", "TEXT");
        sb.append(" cdnUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "cdnKey";
        mAutoDBInfo.colsMap.put("cdnKey", "TEXT");
        sb.append(" cdnKey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "totalLen";
        mAutoDBInfo.colsMap.put("totalLen", "INTEGER default '0' ");
        sb.append(" totalLen INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "isThumb";
        mAutoDBInfo.colsMap.put("isThumb", "INTEGER default 'false' ");
        sb.append(" isThumb INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "offset";
        mAutoDBInfo.colsMap.put("offset", "INTEGER default '0' ");
        sb.append(" offset INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
        sb.append(" type INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "fileType";
        mAutoDBInfo.colsMap.put("fileType", "INTEGER default '5' ");
        sb.append(" fileType INTEGER default '5' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
        sb.append(" status INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "errCode";
        mAutoDBInfo.colsMap.put("errCode", "INTEGER default '0' ");
        sb.append(" errCode INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "tpaeskey";
        mAutoDBInfo.colsMap.put("tpaeskey", "TEXT");
        sb.append(" tpaeskey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "tpauthkey";
        mAutoDBInfo.colsMap.put("tpauthkey", "TEXT");
        sb.append(" tpauthkey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "tpdataurl";
        mAutoDBInfo.colsMap.put("tpdataurl", "TEXT");
        sb.append(" tpdataurl TEXT");
        mAutoDBInfo.columns[18] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(140937);
    }
}

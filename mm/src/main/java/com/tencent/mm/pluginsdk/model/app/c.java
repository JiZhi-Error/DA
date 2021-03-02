package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.h;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class c extends h {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public c() {
        this.field_netTimes = 0;
    }

    public final boolean deQ() {
        if (this.field_totalLen > 0 && this.field_offset == this.field_totalLen) {
            return true;
        }
        return false;
    }

    static {
        AppMethodBeat.i(151651);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[20];
        mAutoDBInfo.columns = new String[21];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "sdkVer";
        mAutoDBInfo.colsMap.put("sdkVer", "LONG");
        sb.append(" sdkVer LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "mediaSvrId";
        mAutoDBInfo.colsMap.put("mediaSvrId", "TEXT");
        sb.append(" mediaSvrId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "mediaId";
        mAutoDBInfo.colsMap.put("mediaId", "TEXT");
        sb.append(" mediaId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "clientAppDataId";
        mAutoDBInfo.colsMap.put("clientAppDataId", "TEXT");
        sb.append(" clientAppDataId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "type";
        mAutoDBInfo.colsMap.put("type", "LONG");
        sb.append(" type LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "totalLen";
        mAutoDBInfo.colsMap.put("totalLen", "LONG");
        sb.append(" totalLen LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "offset";
        mAutoDBInfo.colsMap.put("offset", "LONG");
        sb.append(" offset LONG");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "status";
        mAutoDBInfo.colsMap.put("status", "LONG");
        sb.append(" status LONG");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "isUpload";
        mAutoDBInfo.colsMap.put("isUpload", "INTEGER");
        sb.append(" isUpload INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "lastModifyTime";
        mAutoDBInfo.colsMap.put("lastModifyTime", "LONG");
        sb.append(" lastModifyTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "fileFullPath";
        mAutoDBInfo.colsMap.put("fileFullPath", "TEXT");
        sb.append(" fileFullPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "fullXml";
        mAutoDBInfo.colsMap.put("fullXml", "TEXT");
        sb.append(" fullXml TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "msgInfoId";
        mAutoDBInfo.colsMap.put("msgInfoId", "LONG");
        sb.append(" msgInfoId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "netTimes";
        mAutoDBInfo.colsMap.put("netTimes", "LONG");
        sb.append(" netTimes LONG");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "isUseCdn";
        mAutoDBInfo.colsMap.put("isUseCdn", "INTEGER");
        sb.append(" isUseCdn INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "signature";
        mAutoDBInfo.colsMap.put("signature", "TEXT");
        sb.append(" signature TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "fakeAeskey";
        mAutoDBInfo.colsMap.put("fakeAeskey", "TEXT");
        sb.append(" fakeAeskey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "fakeSignature";
        mAutoDBInfo.colsMap.put("fakeSignature", "TEXT");
        sb.append(" fakeSignature TEXT");
        mAutoDBInfo.columns[20] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(151651);
    }
}

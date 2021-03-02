package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.Cdo;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.lang.reflect.Field;

public final class b extends Cdo {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(23779);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[14];
        mAutoDBInfo.columns = new String[15];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "deviceID";
        mAutoDBInfo.colsMap.put("deviceID", "TEXT PRIMARY KEY ");
        sb.append(" deviceID TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "deviceID";
        mAutoDBInfo.columns[1] = "brandName";
        mAutoDBInfo.colsMap.put("brandName", "TEXT");
        sb.append(" brandName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = TPDownloadProxyEnum.USER_MAC;
        mAutoDBInfo.colsMap.put(TPDownloadProxyEnum.USER_MAC, "LONG");
        sb.append(" mac LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "deviceType";
        mAutoDBInfo.colsMap.put("deviceType", "TEXT");
        sb.append(" deviceType TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "connProto";
        mAutoDBInfo.colsMap.put("connProto", "TEXT");
        sb.append(" connProto TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "connStrategy";
        mAutoDBInfo.colsMap.put("connStrategy", "INTEGER");
        sb.append(" connStrategy INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "closeStrategy";
        mAutoDBInfo.colsMap.put("closeStrategy", "INTEGER");
        sb.append(" closeStrategy INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "md5Str";
        mAutoDBInfo.colsMap.put("md5Str", "TEXT");
        sb.append(" md5Str TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "authKey";
        mAutoDBInfo.colsMap.put("authKey", "TEXT");
        sb.append(" authKey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "url";
        mAutoDBInfo.colsMap.put("url", "TEXT");
        sb.append(" url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "sessionKey";
        mAutoDBInfo.colsMap.put("sessionKey", "BLOB");
        sb.append(" sessionKey BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "sessionBuf";
        mAutoDBInfo.colsMap.put("sessionBuf", "BLOB");
        sb.append(" sessionBuf BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "authBuf";
        mAutoDBInfo.colsMap.put("authBuf", "BLOB");
        sb.append(" authBuf BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "lvbuffer";
        mAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
        sb.append(" lvbuffer BLOB");
        mAutoDBInfo.columns[14] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(23779);
    }
}

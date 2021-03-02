package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bt;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class bl extends bt {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(43197);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[17];
        mAutoDBInfo.columns = new String[18];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "talker";
        mAutoDBInfo.colsMap.put("talker", "TEXT default '0'  PRIMARY KEY ");
        sb.append(" talker TEXT default '0'  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "talker";
        mAutoDBInfo.columns[1] = "encryptTalker";
        mAutoDBInfo.colsMap.put("encryptTalker", "TEXT default '' ");
        sb.append(" encryptTalker TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "displayName";
        mAutoDBInfo.colsMap.put("displayName", "TEXT default '' ");
        sb.append(" displayName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "state";
        mAutoDBInfo.colsMap.put("state", "INTEGER default '0' ");
        sb.append(" state INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "lastModifiedTime";
        mAutoDBInfo.colsMap.put("lastModifiedTime", "LONG default '0' ");
        sb.append(" lastModifiedTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "isNew";
        mAutoDBInfo.colsMap.put("isNew", "INTEGER default '0' ");
        sb.append(" isNew INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "addScene";
        mAutoDBInfo.colsMap.put("addScene", "INTEGER default '0' ");
        sb.append(" addScene INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "fmsgSysRowId";
        mAutoDBInfo.colsMap.put("fmsgSysRowId", "LONG default '0' ");
        sb.append(" fmsgSysRowId LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "fmsgIsSend";
        mAutoDBInfo.colsMap.put("fmsgIsSend", "INTEGER default '0' ");
        sb.append(" fmsgIsSend INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "fmsgType";
        mAutoDBInfo.colsMap.put("fmsgType", "INTEGER default '0' ");
        sb.append(" fmsgType INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "fmsgContent";
        mAutoDBInfo.colsMap.put("fmsgContent", "TEXT default '' ");
        sb.append(" fmsgContent TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "recvFmsgType";
        mAutoDBInfo.colsMap.put("recvFmsgType", "INTEGER default '0' ");
        sb.append(" recvFmsgType INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "contentFromUsername";
        mAutoDBInfo.colsMap.put("contentFromUsername", "TEXT default '' ");
        sb.append(" contentFromUsername TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "contentNickname";
        mAutoDBInfo.colsMap.put("contentNickname", "TEXT default '' ");
        sb.append(" contentNickname TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "contentPhoneNumMD5";
        mAutoDBInfo.colsMap.put("contentPhoneNumMD5", "TEXT default '' ");
        sb.append(" contentPhoneNumMD5 TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "contentFullPhoneNumMD5";
        mAutoDBInfo.colsMap.put("contentFullPhoneNumMD5", "TEXT default '' ");
        sb.append(" contentFullPhoneNumMD5 TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "contentVerifyContent";
        mAutoDBInfo.colsMap.put("contentVerifyContent", "TEXT default '' ");
        sb.append(" contentVerifyContent TEXT default '' ");
        mAutoDBInfo.columns[17] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(43197);
    }
}

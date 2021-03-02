package com.tencent.mm.plugin.appbrand.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ig;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends ig {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(45095);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[9];
        mAutoDBInfo.columns = new String[10];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "RecordId";
        mAutoDBInfo.colsMap.put("RecordId", "TEXT PRIMARY KEY ");
        sb.append(" RecordId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "RecordId";
        mAutoDBInfo.columns[1] = "AppId";
        mAutoDBInfo.colsMap.put("AppId", "TEXT");
        sb.append(" AppId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "AppName";
        mAutoDBInfo.colsMap.put("AppName", "TEXT");
        sb.append(" AppName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "UserName";
        mAutoDBInfo.colsMap.put("UserName", "TEXT");
        sb.append(" UserName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "IconUrl";
        mAutoDBInfo.colsMap.put("IconUrl", "TEXT");
        sb.append(" IconUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "BriefIntro";
        mAutoDBInfo.colsMap.put("BriefIntro", "TEXT");
        sb.append(" BriefIntro TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "isSync";
        mAutoDBInfo.colsMap.put("isSync", "INTEGER default 'false' ");
        sb.append(" isSync INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "debugType";
        mAutoDBInfo.colsMap.put("debugType", "INTEGER");
        sb.append(" debugType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        mAutoDBInfo.columns[9] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(45095);
    }
}

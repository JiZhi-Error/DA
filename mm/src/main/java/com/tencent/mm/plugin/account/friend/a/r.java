package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.ey;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class r extends ey {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(184421);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[9];
        mAutoDBInfo.columns = new String[10];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "encryptUsername";
        mAutoDBInfo.colsMap.put("encryptUsername", "TEXT");
        sb.append(" encryptUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "oldUsername";
        mAutoDBInfo.colsMap.put("oldUsername", "TEXT");
        sb.append(" oldUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "ticket";
        mAutoDBInfo.colsMap.put("ticket", "TEXT");
        sb.append(" ticket TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "nickname";
        mAutoDBInfo.colsMap.put("nickname", "TEXT");
        sb.append(" nickname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "addState";
        mAutoDBInfo.colsMap.put("addState", "INTEGER");
        sb.append(" addState INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "showHead";
        mAutoDBInfo.colsMap.put("showHead", "INTEGER");
        sb.append(" showHead INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "pinyinName";
        mAutoDBInfo.colsMap.put("pinyinName", "TEXT");
        sb.append(" pinyinName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "seq";
        mAutoDBInfo.colsMap.put("seq", "INTEGER");
        sb.append(" seq INTEGER");
        mAutoDBInfo.columns[9] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(184421);
    }
}

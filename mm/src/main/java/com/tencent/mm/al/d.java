package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ak;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class d extends ak {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(123984);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[17];
        mAutoDBInfo.columns = new String[18];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "userName";
        mAutoDBInfo.colsMap.put("userName", "TEXT PRIMARY KEY ");
        sb.append(" userName TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "userName";
        mAutoDBInfo.columns[1] = "qyUin";
        mAutoDBInfo.colsMap.put("qyUin", "INTEGER");
        sb.append(" qyUin INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "userUin";
        mAutoDBInfo.colsMap.put("userUin", "INTEGER");
        sb.append(" userUin INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "userFlag";
        mAutoDBInfo.colsMap.put("userFlag", "INTEGER");
        sb.append(" userFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "wwExposeTimes";
        mAutoDBInfo.colsMap.put("wwExposeTimes", "INTEGER");
        sb.append(" wwExposeTimes INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "wwMaxExposeTimes";
        mAutoDBInfo.colsMap.put("wwMaxExposeTimes", "INTEGER");
        sb.append(" wwMaxExposeTimes INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "wwCorpId";
        mAutoDBInfo.colsMap.put("wwCorpId", "LONG");
        sb.append(" wwCorpId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "wwUserVid";
        mAutoDBInfo.colsMap.put("wwUserVid", "LONG");
        sb.append(" wwUserVid LONG");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "userType";
        mAutoDBInfo.colsMap.put("userType", "INTEGER");
        sb.append(" userType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "chatOpen";
        mAutoDBInfo.colsMap.put("chatOpen", "INTEGER");
        sb.append(" chatOpen INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "wwUnreadCnt";
        mAutoDBInfo.colsMap.put("wwUnreadCnt", "INTEGER default '0' ");
        sb.append(" wwUnreadCnt INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "show_confirm";
        mAutoDBInfo.colsMap.put("show_confirm", "INTEGER");
        sb.append(" show_confirm INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "use_preset_banner_tips";
        mAutoDBInfo.colsMap.put("use_preset_banner_tips", "INTEGER");
        sb.append(" use_preset_banner_tips INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "hide_create_chat";
        mAutoDBInfo.colsMap.put("hide_create_chat", "INTEGER");
        sb.append(" hide_create_chat INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "hide_mod_chat_member";
        mAutoDBInfo.colsMap.put("hide_mod_chat_member", "INTEGER");
        sb.append(" hide_mod_chat_member INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "hide_colleage_invite";
        mAutoDBInfo.colsMap.put("hide_colleage_invite", "INTEGER default 'true' ");
        sb.append(" hide_colleage_invite INTEGER default 'true' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "raw_attrs";
        mAutoDBInfo.colsMap.put("raw_attrs", "BLOB");
        sb.append(" raw_attrs BLOB");
        mAutoDBInfo.columns[17] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(123984);
    }
}

package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ag;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends ag {
    public static final int iPq = j.BIZ_CHAT_TYPE_GROUP.iQq;
    protected static IAutoDBItem.MAutoDBInfo info;

    static {
        AppMethodBeat.i(124174);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[18];
        mAutoDBInfo.columns = new String[19];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "bizChatId";
        mAutoDBInfo.colsMap.put("bizChatId", "LONG PRIMARY KEY ");
        sb.append(" bizChatId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "bizChatId";
        mAutoDBInfo.columns[1] = "brandUserName";
        mAutoDBInfo.colsMap.put("brandUserName", "TEXT");
        sb.append(" brandUserName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "unReadCount";
        mAutoDBInfo.colsMap.put("unReadCount", "INTEGER");
        sb.append(" unReadCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "newUnReadCount";
        mAutoDBInfo.colsMap.put("newUnReadCount", "INTEGER");
        sb.append(" newUnReadCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "lastMsgID";
        mAutoDBInfo.colsMap.put("lastMsgID", "LONG");
        sb.append(" lastMsgID LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "lastMsgTime";
        mAutoDBInfo.colsMap.put("lastMsgTime", "LONG");
        sb.append(" lastMsgTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT");
        sb.append(" content TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "digest";
        mAutoDBInfo.colsMap.put("digest", "TEXT default '' ");
        sb.append(" digest TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "digestUser";
        mAutoDBInfo.colsMap.put("digestUser", "TEXT default '' ");
        sb.append(" digestUser TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "atCount";
        mAutoDBInfo.colsMap.put("atCount", "INTEGER default '0' ");
        sb.append(" atCount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "editingMsg";
        mAutoDBInfo.colsMap.put("editingMsg", "TEXT");
        sb.append(" editingMsg TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "chatType";
        mAutoDBInfo.colsMap.put("chatType", "INTEGER");
        sb.append(" chatType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
        sb.append(" status INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "isSend";
        mAutoDBInfo.colsMap.put("isSend", "INTEGER default '0' ");
        sb.append(" isSend INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "msgType";
        mAutoDBInfo.colsMap.put("msgType", "TEXT default '' ");
        sb.append(" msgType TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "msgCount";
        mAutoDBInfo.colsMap.put("msgCount", "INTEGER default '0' ");
        sb.append(" msgCount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "flag";
        mAutoDBInfo.colsMap.put("flag", "LONG default '0' ");
        sb.append(" flag LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "atAll";
        mAutoDBInfo.colsMap.put("atAll", "INTEGER default '0' ");
        sb.append(" atAll INTEGER default '0' ");
        mAutoDBInfo.columns[18] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(124174);
    }

    /* renamed from: com.tencent.mm.al.a.a$a  reason: collision with other inner class name */
    public enum EnumC0246a {
        iPr(2),
        DEPARTMENT(32),
        EXTERNAL(128),
        NORMAL(0);
        
        private final int cSx;

        public static EnumC0246a valueOf(String str) {
            AppMethodBeat.i(212192);
            EnumC0246a aVar = (EnumC0246a) Enum.valueOf(EnumC0246a.class, str);
            AppMethodBeat.o(212192);
            return aVar;
        }

        static {
            AppMethodBeat.i(212194);
            AppMethodBeat.o(212194);
        }

        private EnumC0246a(int i2) {
            this.cSx = i2;
        }

        public static EnumC0246a sQ(int i2) {
            AppMethodBeat.i(212193);
            EnumC0246a[] values = values();
            for (EnumC0246a aVar : values) {
                if ((aVar.cSx & i2) != 0) {
                    AppMethodBeat.o(212193);
                    return aVar;
                }
            }
            EnumC0246a aVar2 = NORMAL;
            AppMethodBeat.o(212193);
            return aVar2;
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }
}

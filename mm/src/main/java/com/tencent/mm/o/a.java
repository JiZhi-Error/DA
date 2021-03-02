package com.tencent.mm.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public class a extends bb {
    public static final String gNj = null;
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public a() {
    }

    public a(String str) {
        AppMethodBeat.i(42759);
        setUsername(str);
        AppMethodBeat.o(42759);
    }

    public final void oT(int i2) {
        AppMethodBeat.i(42760);
        int i3 = this.field_attrflag | i2;
        if (this.field_attrflag >= 0 && this.field_attrflag < 536870912 && ((i3 >= 536870912 || i3 < 0) && this.field_username.contains("@"))) {
            Log.i("Conversition", "wrong add attr flag: %s, %s, %s, %s", this.field_username, Integer.valueOf(this.field_attrflag), Integer.valueOf(i2), Util.getStack());
            e.INSTANCE.a(20435, 2, Integer.valueOf(this.field_attrflag), Integer.valueOf(i2), this.field_username);
        }
        nx(this.field_attrflag | i2);
        AppMethodBeat.o(42760);
    }

    public final void oU(int i2) {
        AppMethodBeat.i(42761);
        nx(this.field_attrflag & (i2 ^ -1));
        AppMethodBeat.o(42761);
    }

    public final boolean oV(int i2) {
        return (this.field_attrflag & i2) != 0;
    }

    static {
        AppMethodBeat.i(42762);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[28];
        mAutoDBInfo.columns = new String[29];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "msgCount";
        mAutoDBInfo.colsMap.put("msgCount", "INTEGER default '0' ");
        sb.append(" msgCount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[1] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT default ''  PRIMARY KEY ");
        sb.append(" username TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_USERNAME;
        mAutoDBInfo.columns[2] = "unReadCount";
        mAutoDBInfo.colsMap.put("unReadCount", "INTEGER default '0' ");
        sb.append(" unReadCount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "chatmode";
        mAutoDBInfo.colsMap.put("chatmode", "INTEGER default '0' ");
        sb.append(" chatmode INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
        sb.append(" status INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "isSend";
        mAutoDBInfo.colsMap.put("isSend", "INTEGER default '0' ");
        sb.append(" isSend INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "conversationTime";
        mAutoDBInfo.colsMap.put("conversationTime", "LONG default '0' ");
        sb.append(" conversationTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT default '' ");
        sb.append(" content TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "msgType";
        mAutoDBInfo.colsMap.put("msgType", "TEXT default '' ");
        sb.append(" msgType TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "customNotify";
        mAutoDBInfo.colsMap.put("customNotify", "TEXT default '' ");
        sb.append(" customNotify TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "showTips";
        mAutoDBInfo.colsMap.put("showTips", "INTEGER default '0' ");
        sb.append(" showTips INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "flag";
        mAutoDBInfo.colsMap.put("flag", "LONG default '0' ");
        sb.append(" flag LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "digest";
        mAutoDBInfo.colsMap.put("digest", "TEXT default '' ");
        sb.append(" digest TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "digestUser";
        mAutoDBInfo.colsMap.put("digestUser", "TEXT default '' ");
        sb.append(" digestUser TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "hasTrunc";
        mAutoDBInfo.colsMap.put("hasTrunc", "INTEGER default '0' ");
        sb.append(" hasTrunc INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "parentRef";
        mAutoDBInfo.colsMap.put("parentRef", "TEXT");
        sb.append(" parentRef TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "attrflag";
        mAutoDBInfo.colsMap.put("attrflag", "INTEGER default '0' ");
        sb.append(" attrflag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "editingMsg";
        mAutoDBInfo.colsMap.put("editingMsg", "TEXT default '' ");
        sb.append(" editingMsg TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "atCount";
        mAutoDBInfo.colsMap.put("atCount", "INTEGER default '0' ");
        sb.append(" atCount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "sightTime";
        mAutoDBInfo.colsMap.put("sightTime", "LONG default '0' ");
        sb.append(" sightTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "unReadMuteCount";
        mAutoDBInfo.colsMap.put("unReadMuteCount", "INTEGER default '0' ");
        sb.append(" unReadMuteCount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "lastSeq";
        mAutoDBInfo.colsMap.put("lastSeq", "LONG");
        sb.append(" lastSeq LONG");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "UnDeliverCount";
        mAutoDBInfo.colsMap.put("UnDeliverCount", "INTEGER");
        sb.append(" UnDeliverCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "UnReadInvite";
        mAutoDBInfo.colsMap.put("UnReadInvite", "INTEGER");
        sb.append(" UnReadInvite INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "firstUnDeliverSeq";
        mAutoDBInfo.colsMap.put("firstUnDeliverSeq", "LONG");
        sb.append(" firstUnDeliverSeq LONG");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "editingQuoteMsgId";
        mAutoDBInfo.colsMap.put("editingQuoteMsgId", "LONG default '0' ");
        sb.append(" editingQuoteMsgId LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[26] = "hasTodo";
        mAutoDBInfo.colsMap.put("hasTodo", "INTEGER default '0' ");
        sb.append(" hasTodo INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[27] = "hbMarkRed";
        mAutoDBInfo.colsMap.put("hbMarkRed", "INTEGER default '0' ");
        sb.append(" hbMarkRed INTEGER default '0' ");
        mAutoDBInfo.columns[28] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(42762);
    }
}

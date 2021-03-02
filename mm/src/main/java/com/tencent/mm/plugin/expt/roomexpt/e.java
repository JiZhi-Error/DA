package com.tencent.mm.plugin.expt.roomexpt;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fu;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class e extends fu {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final String toString() {
        AppMethodBeat.i(122443);
        String format = String.format("name[%s %s] daySec[%s] isMute[%d] unRead[%d] send[%d] enter[%d] disRedRod[%d] stayTime[%d] score[%f] systemRowid[%d]", this.field_chatroom, this.field_nickname, this.field_daySec, Integer.valueOf(this.field_isMute), Integer.valueOf(this.field_unReadCount), Integer.valueOf(this.field_sendCount), Integer.valueOf(this.field_enterCount), Integer.valueOf(this.field_disRedDotCount), Long.valueOf(this.field_stayTime), Float.valueOf(this.field_score), Long.valueOf(this.systemRowid));
        AppMethodBeat.o(122443);
        return format;
    }

    static {
        AppMethodBeat.i(122444);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[10];
        mAutoDBInfo.columns = new String[11];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "chatroom";
        mAutoDBInfo.colsMap.put("chatroom", "TEXT");
        sb.append(" chatroom TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "daySec";
        mAutoDBInfo.colsMap.put("daySec", "TEXT");
        sb.append(" daySec TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "nickname";
        mAutoDBInfo.colsMap.put("nickname", "TEXT");
        sb.append(" nickname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "isMute";
        mAutoDBInfo.colsMap.put("isMute", "INTEGER");
        sb.append(" isMute INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "unReadCount";
        mAutoDBInfo.colsMap.put("unReadCount", "INTEGER");
        sb.append(" unReadCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "sendCount";
        mAutoDBInfo.colsMap.put("sendCount", "INTEGER");
        sb.append(" sendCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "enterCount";
        mAutoDBInfo.colsMap.put("enterCount", "INTEGER");
        sb.append(" enterCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "disRedDotCount";
        mAutoDBInfo.colsMap.put("disRedDotCount", "INTEGER");
        sb.append(" disRedDotCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "stayTime";
        mAutoDBInfo.colsMap.put("stayTime", "LONG");
        sb.append(" stayTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[9] = FirebaseAnalytics.b.SCORE;
        mAutoDBInfo.colsMap.put(FirebaseAnalytics.b.SCORE, "FLOAT");
        sb.append(" score FLOAT");
        mAutoDBInfo.columns[10] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(122444);
    }
}

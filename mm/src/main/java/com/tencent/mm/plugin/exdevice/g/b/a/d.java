package com.tencent.mm.plugin.exdevice.g.b.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.ds;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class d extends ds {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final String toString() {
        AppMethodBeat.i(23555);
        String str = (("{" + "username: " + this.field_username + " ranknum: " + this.field_ranknum + " score: " + this.field_score) + " likeCount:" + this.field_likecount + " selfLikeState:" + this.field_selfLikeState) + "}";
        AppMethodBeat.o(23555);
        return str;
    }

    static {
        AppMethodBeat.i(23556);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "rankID";
        mAutoDBInfo.colsMap.put("rankID", "TEXT");
        sb.append(" rankID TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "appusername";
        mAutoDBInfo.colsMap.put("appusername", "TEXT");
        sb.append(" appusername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "ranknum";
        mAutoDBInfo.colsMap.put("ranknum", "INTEGER");
        sb.append(" ranknum INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = FirebaseAnalytics.b.SCORE;
        mAutoDBInfo.colsMap.put(FirebaseAnalytics.b.SCORE, "INTEGER");
        sb.append(" score INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "likecount";
        mAutoDBInfo.colsMap.put("likecount", "INTEGER default '0' ");
        sb.append(" likecount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "selfLikeState";
        mAutoDBInfo.colsMap.put("selfLikeState", "INTEGER default '3' ");
        sb.append(" selfLikeState INTEGER default '3' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "sportRecord";
        mAutoDBInfo.colsMap.put("sportRecord", "BLOB");
        sb.append(" sportRecord BLOB");
        mAutoDBInfo.columns[8] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(23556);
    }
}

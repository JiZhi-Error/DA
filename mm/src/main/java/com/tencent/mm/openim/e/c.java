package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.fa;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class c extends fa {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(151329);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appid";
        mAutoDBInfo.colsMap.put("appid", "TEXT");
        sb.append(" appid TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        mAutoDBInfo.colsMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "TEXT");
        sb.append(" language TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "appRec";
        mAutoDBInfo.colsMap.put("appRec", "BLOB");
        sb.append(" appRec BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[3] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG default '0' ");
        sb.append(" updateTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "acctTypeId";
        mAutoDBInfo.colsMap.put("acctTypeId", "TEXT");
        sb.append(" acctTypeId TEXT");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(151329);
    }
}

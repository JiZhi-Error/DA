package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.ez;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends ez {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(151325);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "acctTypeId";
        mAutoDBInfo.colsMap.put("acctTypeId", "TEXT");
        sb.append(" acctTypeId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        mAutoDBInfo.colsMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "TEXT");
        sb.append(" language TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "accTypeRec";
        mAutoDBInfo.colsMap.put("accTypeRec", "BLOB");
        sb.append(" accTypeRec BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[3] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG default '0' ");
        sb.append(" updateTime LONG default '0' ");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(151325);
    }
}

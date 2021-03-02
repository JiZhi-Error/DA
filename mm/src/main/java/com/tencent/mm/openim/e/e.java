package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class e extends fb {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(151334);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appid";
        mAutoDBInfo.colsMap.put("appid", "TEXT");
        sb.append(" appid TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "wordingId";
        mAutoDBInfo.colsMap.put("wordingId", "TEXT");
        sb.append(" wordingId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        mAutoDBInfo.colsMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "TEXT");
        sb.append(" language TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "wording";
        mAutoDBInfo.colsMap.put("wording", "TEXT");
        sb.append(" wording TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "pinyin";
        mAutoDBInfo.colsMap.put("pinyin", "TEXT");
        sb.append(" pinyin TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "quanpin";
        mAutoDBInfo.colsMap.put("quanpin", "TEXT");
        sb.append(" quanpin TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG default '0' ");
        sb.append(" updateTime LONG default '0' ");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(151334);
    }
}

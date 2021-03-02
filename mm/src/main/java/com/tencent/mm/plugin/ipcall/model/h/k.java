package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dx;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class k extends dx {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(25557);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "phonenumber";
        mAutoDBInfo.colsMap.put("phonenumber", "TEXT");
        sb.append(" phonenumber TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "calltime";
        mAutoDBInfo.colsMap.put("calltime", "LONG");
        sb.append(" calltime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = FFmpegMetadataRetriever.METADATA_KEY_DURATION;
        mAutoDBInfo.colsMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, "LONG");
        sb.append(" duration LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "addressId";
        mAutoDBInfo.colsMap.put("addressId", "LONG default '-1' ");
        sb.append(" addressId LONG default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "phoneType";
        mAutoDBInfo.colsMap.put("phoneType", "INTEGER default '-1' ");
        sb.append(" phoneType INTEGER default '-1' ");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(25557);
    }
}

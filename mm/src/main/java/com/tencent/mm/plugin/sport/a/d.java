package com.tencent.mm.plugin.sport.a;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gp;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class d extends gp implements Comparable<d> {
    public static IAutoDBItem.MAutoDBInfo info;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(d dVar) {
        d dVar2 = dVar;
        if (this.field_timestamp > dVar2.field_timestamp) {
            return 1;
        }
        if (this.field_timestamp < dVar2.field_timestamp) {
            return -1;
        }
        return 0;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(116812);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "id";
        mAutoDBInfo.colsMap.put("id", "INTEGER default '0'  PRIMARY KEY ");
        sb.append(" id INTEGER default '0'  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "id";
        mAutoDBInfo.columns[1] = FFmpegMetadataRetriever.METADATA_KEY_DATE;
        mAutoDBInfo.colsMap.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, "TEXT");
        sb.append(" date TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "step";
        mAutoDBInfo.colsMap.put("step", "INTEGER");
        sb.append(" step INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = AppMeasurement.Param.TIMESTAMP;
        mAutoDBInfo.colsMap.put(AppMeasurement.Param.TIMESTAMP, "LONG");
        sb.append(" timestamp LONG");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(116812);
    }
}

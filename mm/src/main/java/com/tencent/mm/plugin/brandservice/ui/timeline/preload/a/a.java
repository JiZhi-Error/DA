package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.af;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends af {
    public static IAutoDBItem.MAutoDBInfo iBg;

    public a() {
    }

    public a(gb gbVar) {
        this.field_url = gbVar.Url;
        this.field_reportTime = gbVar.KJQ;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    public final String toString() {
        AppMethodBeat.i(6186);
        String str = "BizAppMsgReportContext{field_appMsgReportContextId=" + this.field_appMsgReportContextId + ", field_url='" + this.field_url + '\'' + ", field_reportTime=" + this.field_reportTime + ", field_aScene=" + this.field_aScene + '}';
        AppMethodBeat.o(6186);
        return str;
    }

    static {
        AppMethodBeat.i(6187);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appMsgReportContextId";
        mAutoDBInfo.colsMap.put("appMsgReportContextId", "LONG PRIMARY KEY ");
        sb.append(" appMsgReportContextId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "appMsgReportContextId";
        mAutoDBInfo.columns[1] = "url";
        mAutoDBInfo.colsMap.put("url", "TEXT");
        sb.append(" url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "reportTime";
        mAutoDBInfo.colsMap.put("reportTime", "LONG");
        sb.append(" reportTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "aScene";
        mAutoDBInfo.colsMap.put("aScene", "INTEGER");
        sb.append(" aScene INTEGER");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        AppMethodBeat.o(6187);
    }
}

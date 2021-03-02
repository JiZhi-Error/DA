package com.tencent.mm.plugin.ai.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hr;
import com.tencent.mm.plugin.ai.c.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

public final class e extends hr {
    public static IAutoDBItem.MAutoDBInfo info;
    private SimpleDateFormat kxO = null;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean TN(String str) {
        AppMethodBeat.i(238949);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(238949);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.field_appTbe = jSONObject.optLong("tbe", 0);
            this.field_appTen = jSONObject.optLong("ten", 0);
            this.field_appIn = jSONObject.optLong(LocaleUtil.INDONESIAN_NEWNAME, 0);
            this.field_appInbg = jSONObject.optLong("inbg", 0);
        } catch (Exception e2) {
        }
        if (this.field_appTbe <= 0 || this.field_appTen <= 0) {
            AppMethodBeat.o(238949);
            return false;
        }
        if (this.kxO == null) {
            this.kxO = new SimpleDateFormat("yyyyMMdd");
        }
        this.field_appDs = Util.getInt(this.kxO.format(Long.valueOf(this.field_appTbe)), -1);
        this.field_appHour = a.AU(this.field_appTbe);
        AppMethodBeat.o(238949);
        return true;
    }

    static {
        AppMethodBeat.i(238950);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appDs";
        mAutoDBInfo.colsMap.put("appDs", "INTEGER");
        sb.append(" appDs INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "appHour";
        mAutoDBInfo.colsMap.put("appHour", "INTEGER");
        sb.append(" appHour INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "appTbe";
        mAutoDBInfo.colsMap.put("appTbe", "LONG");
        sb.append(" appTbe LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "appTen";
        mAutoDBInfo.colsMap.put("appTen", "LONG");
        sb.append(" appTen LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "appIn";
        mAutoDBInfo.colsMap.put("appIn", "LONG");
        sb.append(" appIn LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "appInbg";
        mAutoDBInfo.colsMap.put("appInbg", "LONG");
        sb.append(" appInbg LONG");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(238950);
    }
}

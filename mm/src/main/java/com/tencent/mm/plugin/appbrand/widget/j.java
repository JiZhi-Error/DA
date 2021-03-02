package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ef;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class j extends ef {
    public static final IAutoDBItem.MAutoDBInfo kLR;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return kLR;
    }

    static {
        AppMethodBeat.i(76410);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appIdHash";
        mAutoDBInfo.colsMap.put("appIdHash", "INTEGER");
        sb.append(" appIdHash INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "pkgType";
        mAutoDBInfo.colsMap.put("pkgType", "INTEGER");
        sb.append(" pkgType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "widgetType";
        mAutoDBInfo.colsMap.put("widgetType", "INTEGER");
        sb.append(" widgetType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "launchAction";
        mAutoDBInfo.colsMap.put("launchAction", "BLOB");
        sb.append(" launchAction BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "jsApiInfo";
        mAutoDBInfo.colsMap.put("jsApiInfo", "BLOB");
        sb.append(" jsApiInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "versionInfo";
        mAutoDBInfo.colsMap.put("versionInfo", "BLOB");
        sb.append(" versionInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "widgetSetting";
        mAutoDBInfo.colsMap.put("widgetSetting", "BLOB");
        sb.append(" widgetSetting BLOB");
        mAutoDBInfo.columns[8] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        kLR = mAutoDBInfo;
        AppMethodBeat.o(76410);
    }
}

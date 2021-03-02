package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fm;
import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.Locale;

public final class am extends fm implements b {
    static final IAutoDBItem.MAutoDBInfo iBg;
    static final String[] kJX = {"appId", "type", "version"};

    @Override // com.tencent.mm.plugin.appbrand.ab.b
    public final String[] getKeys() {
        return kJX;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    static {
        AppMethodBeat.i(90559);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "version";
        mAutoDBInfo.colsMap.put("version", "INTEGER");
        sb.append(" version INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "pkgMd5";
        mAutoDBInfo.colsMap.put("pkgMd5", "TEXT");
        sb.append(" pkgMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "pkgPath";
        mAutoDBInfo.colsMap.put("pkgPath", "TEXT");
        sb.append(" pkgPath TEXT");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        String str = " PRIMARY KEY ( ";
        String[] strArr = kJX;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            str = str + ", " + strArr[i2];
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder sb2 = new StringBuilder();
        IAutoDBItem.MAutoDBInfo mAutoDBInfo2 = iBg;
        mAutoDBInfo2.sql = sb2.append(mAutoDBInfo2.sql).append(",").append(str2).toString();
        AppMethodBeat.o(90559);
    }

    public final String toShortString() {
        AppMethodBeat.i(90558);
        String format = String.format(Locale.US, "EncryptPkgInfo[%s %d %d]", this.field_appId, Integer.valueOf(this.field_type), Integer.valueOf(this.field_version));
        AppMethodBeat.o(90558);
        return format;
    }
}

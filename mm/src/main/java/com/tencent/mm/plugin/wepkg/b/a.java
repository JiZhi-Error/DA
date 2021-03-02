package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hm;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends hm {
    public static final IAutoDBItem.MAutoDBInfo iBg;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    static {
        AppMethodBeat.i(110557);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "pkgId";
        mAutoDBInfo.colsMap.put("pkgId", "TEXT PRIMARY KEY ");
        sb.append(" pkgId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "pkgId";
        mAutoDBInfo.columns[1] = "version";
        mAutoDBInfo.colsMap.put("version", "TEXT");
        sb.append(" version TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "oldVersion";
        mAutoDBInfo.colsMap.put("oldVersion", "TEXT");
        sb.append(" oldVersion TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "oldPath";
        mAutoDBInfo.colsMap.put("oldPath", "TEXT");
        sb.append(" oldPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "md5";
        mAutoDBInfo.colsMap.put("md5", "TEXT");
        sb.append(" md5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "downloadUrl";
        mAutoDBInfo.colsMap.put("downloadUrl", "TEXT");
        sb.append(" downloadUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "pkgSize";
        mAutoDBInfo.colsMap.put("pkgSize", "INTEGER");
        sb.append(" pkgSize INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "downloadNetType";
        mAutoDBInfo.colsMap.put("downloadNetType", "INTEGER");
        sb.append(" downloadNetType INTEGER");
        mAutoDBInfo.columns[8] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        AppMethodBeat.o(110557);
    }
}

package com.tencent.mm.plugin.scanner.history.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fw;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends fw {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(51587);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "productId";
        mAutoDBInfo.colsMap.put("productId", "TEXT PRIMARY KEY ");
        sb.append(" productId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "productId";
        mAutoDBInfo.columns[1] = "xmlContent";
        mAutoDBInfo.colsMap.put("xmlContent", "TEXT");
        sb.append(" xmlContent TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "ScanTime";
        mAutoDBInfo.colsMap.put("ScanTime", "LONG");
        sb.append(" ScanTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "funcType";
        mAutoDBInfo.colsMap.put("funcType", "INTEGER");
        sb.append(" funcType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "qrcodeUrl";
        mAutoDBInfo.colsMap.put("qrcodeUrl", "TEXT");
        sb.append(" qrcodeUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "scene";
        mAutoDBInfo.colsMap.put("scene", "INTEGER");
        sb.append(" scene INTEGER");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(51587);
    }
}

package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bh;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends bh {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return null;
    }

    static {
        AppMethodBeat.i(183925);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "designerUin";
        mAutoDBInfo.colsMap.put("designerUin", "INTEGER");
        sb.append(" designerUin INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "productId";
        mAutoDBInfo.colsMap.put("productId", "TEXT");
        sb.append(" productId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "syncTime";
        mAutoDBInfo.colsMap.put("syncTime", "INTEGER");
        sb.append(" syncTime INTEGER");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(183925);
    }
}

package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public final class s extends gm {
    protected static IAutoDBItem.MAutoDBInfo info;
    public int EmS;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final void gX(List<dqi> list) {
        AppMethodBeat.i(97621);
        this.field_memberList = "";
        Iterator<dqi> it = list.iterator();
        while (it.hasNext()) {
            this.field_memberList += it.next().MTo + ",";
        }
        AppMethodBeat.o(97621);
    }

    @Override // com.tencent.mm.g.c.gm, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(97622);
        super.convertFrom(cursor);
        this.EmS = (int) this.systemRowid;
        AppMethodBeat.o(97622);
    }

    static {
        AppMethodBeat.i(97623);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "tagId";
        mAutoDBInfo.colsMap.put("tagId", "LONG default '0' ");
        sb.append(" tagId LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "tagName";
        mAutoDBInfo.colsMap.put("tagName", "TEXT default '' ");
        sb.append(" tagName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "count";
        mAutoDBInfo.colsMap.put("count", "INTEGER default '0' ");
        sb.append(" count INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "memberList";
        mAutoDBInfo.colsMap.put("memberList", "TEXT default '' ");
        sb.append(" memberList TEXT default '' ");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(97623);
    }
}

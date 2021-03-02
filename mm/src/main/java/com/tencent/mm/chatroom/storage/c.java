package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.dl;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class c extends dl {
    protected static IAutoDBItem.MAutoDBInfo info;
    public List<Long> gts = new ArrayList();

    public c() {
        AppMethodBeat.i(182132);
        AppMethodBeat.o(182132);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.g.c.dl, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(182133);
        super.convertFrom(cursor);
        this.gts.clear();
        if (!Util.isNullOrNil(this.field_related_msgids)) {
            for (String str : this.field_related_msgids.split(",")) {
                this.gts.add(Long.valueOf(Long.parseLong(str)));
            }
        }
        AppMethodBeat.o(182133);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(182134);
        c cVar = (c) obj;
        if (!Util.isEqual(cVar.field_todoid, this.field_todoid) || !Util.isEqual(cVar.field_roomname, this.field_roomname)) {
            AppMethodBeat.o(182134);
            return false;
        }
        AppMethodBeat.o(182134);
        return true;
    }

    public final long amk() {
        AppMethodBeat.i(182135);
        if (this.gts.size() > 0) {
            long longValue = this.gts.get(0).longValue();
            AppMethodBeat.o(182135);
            return longValue;
        }
        AppMethodBeat.o(182135);
        return 0;
    }

    public final boolean aml() {
        AppMethodBeat.i(182136);
        boolean isEqual = Util.isEqual("roomannouncement@app.origin", this.field_username);
        AppMethodBeat.o(182136);
        return isEqual;
    }

    public final void yR(long j2) {
        AppMethodBeat.i(194054);
        if (!this.gts.contains(Long.valueOf(j2))) {
            this.gts.add(Long.valueOf(j2));
            StringBuilder sb = new StringBuilder();
            for (Long l : this.gts) {
                sb.append(l.longValue()).append(",");
            }
            if (sb.length() - 1 >= 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            this.field_related_msgids = sb.toString();
        }
        AppMethodBeat.o(194054);
    }

    public final boolean yS(long j2) {
        AppMethodBeat.i(182137);
        if (this.gts.contains(Long.valueOf(j2))) {
            this.gts.remove(Long.valueOf(j2));
            StringBuilder sb = new StringBuilder();
            for (Long l : this.gts) {
                sb.append(l.longValue()).append(",");
            }
            if (sb.length() - 1 >= 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            this.field_related_msgids = sb.toString();
        }
        if (this.gts.size() == 0) {
            AppMethodBeat.o(182137);
            return true;
        }
        AppMethodBeat.o(182137);
        return false;
    }

    static {
        AppMethodBeat.i(182138);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[16];
        mAutoDBInfo.columns = new String[17];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "todoid";
        mAutoDBInfo.colsMap.put("todoid", "TEXT");
        sb.append(" todoid TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "roomname";
        mAutoDBInfo.colsMap.put("roomname", "TEXT");
        sb.append(" roomname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "path";
        mAutoDBInfo.colsMap.put("path", "TEXT");
        sb.append(" path TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "createtime";
        mAutoDBInfo.colsMap.put("createtime", "LONG");
        sb.append(" createtime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "updatetime";
        mAutoDBInfo.colsMap.put("updatetime", "LONG");
        sb.append(" updatetime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "custominfo";
        mAutoDBInfo.colsMap.put("custominfo", "TEXT default '' ");
        sb.append(" custominfo TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "title";
        mAutoDBInfo.colsMap.put("title", "TEXT default '' ");
        sb.append(" title TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "creator";
        mAutoDBInfo.colsMap.put("creator", "TEXT");
        sb.append(" creator TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "related_msgids";
        mAutoDBInfo.colsMap.put("related_msgids", "TEXT");
        sb.append(" related_msgids TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "manager";
        mAutoDBInfo.colsMap.put("manager", "TEXT");
        sb.append(" manager TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "nreply";
        mAutoDBInfo.colsMap.put("nreply", "INTEGER");
        sb.append(" nreply INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "state";
        mAutoDBInfo.colsMap.put("state", "INTEGER");
        sb.append(" state INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "netSceneState";
        mAutoDBInfo.colsMap.put("netSceneState", "INTEGER");
        sb.append(" netSceneState INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "shareKey";
        mAutoDBInfo.colsMap.put("shareKey", "TEXT");
        sb.append(" shareKey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "shareName";
        mAutoDBInfo.colsMap.put("shareName", "TEXT");
        sb.append(" shareName TEXT");
        mAutoDBInfo.columns[16] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(182138);
    }
}

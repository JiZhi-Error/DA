package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l {
    public long igp = 0;
    public String query = "";
    public long timestamp = 0;
    public int type = 0;
    public int wVW = 0;
    public String wVX = "";
    public long wXc = 0;
    public long wXd = 0;
    public long wXe = 0;
    public String wXf = "";

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(131710);
        this.wXc = cursor.getLong(0);
        this.query = cursor.getString(1);
        this.wXd = cursor.getLong(2);
        this.igp = cursor.getLong(3);
        this.wVX = cursor.getString(4);
        this.wXe = cursor.getLong(5);
        this.type = cursor.getInt(6);
        this.wVW = cursor.getInt(7);
        this.timestamp = cursor.getLong(8);
        this.wXf = cursor.getString(9);
        AppMethodBeat.o(131710);
    }
}

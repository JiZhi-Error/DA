package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public int type;
    public long wVV;
    public int wVW;
    public String wVX;

    public final b f(Cursor cursor) {
        AppMethodBeat.i(131670);
        this.wVV = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.wVW = cursor.getInt(2);
        this.wVX = cursor.getString(3);
        AppMethodBeat.o(131670);
        return this;
    }
}

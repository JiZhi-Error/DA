package com.tencent.mm.aj;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Util;

public final class i {
    public int cSx = -1;
    public int fuz = 0;
    public int iKV = 0;
    public String iKW = "";
    public String iKX = "";
    private int iKY = 0;
    int iKZ = 0;
    public String username = "";

    public i() {
        AppMethodBeat.i(150283);
        AppMethodBeat.o(150283);
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(150284);
        this.username = cursor.getString(0);
        this.fuz = cursor.getInt(1);
        this.iKV = cursor.getInt(2);
        this.iKX = cursor.getString(3);
        this.iKW = cursor.getString(4);
        this.iKY = cursor.getInt(5);
        this.iKZ = cursor.getInt(6);
        AppMethodBeat.o(150284);
    }

    public final ContentValues aYq() {
        AppMethodBeat.i(150285);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 1) != 0) {
            contentValues.put(ch.COL_USERNAME, getUsername());
        }
        if ((this.cSx & 2) != 0) {
            contentValues.put("imgflag", Integer.valueOf(this.fuz));
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("lastupdatetime", Integer.valueOf(this.iKV));
        }
        if ((this.cSx & 8) != 0) {
            contentValues.put("reserved1", aYt());
        }
        if ((this.cSx & 16) != 0) {
            contentValues.put("reserved2", aYu());
        }
        if ((this.cSx & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.iKY));
        }
        if ((this.cSx & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.iKZ));
        }
        AppMethodBeat.o(150285);
        return contentValues;
    }

    public final void aYr() {
        this.cSx = -1;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final void aYs() {
        this.fuz = 3;
    }

    public final void Mv(String str) {
        this.iKX = str;
    }

    public final String aYt() {
        return this.iKX == null ? "" : this.iKX;
    }

    public final void Mw(String str) {
        this.iKW = str;
    }

    public final String aYu() {
        return this.iKW == null ? "" : this.iKW;
    }

    public final void fv(boolean z) {
        this.iKY = z ? 1 : 0;
    }

    public final void aYv() {
        AppMethodBeat.i(150286);
        this.iKZ = (int) (Util.nowSecond() / 60);
        this.cSx |= 64;
        AppMethodBeat.o(150286);
    }
}

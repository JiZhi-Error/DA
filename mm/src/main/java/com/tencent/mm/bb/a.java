package com.tencent.mm.bb;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;

public final class a {
    int cSx = -1;
    private String iKR = "";
    private String iKS = "";
    private int iKT = 0;
    private int iKU = 0;
    public int jgE = 0;
    private String path = "";
    public String username = "";

    public a() {
        AppMethodBeat.i(150784);
        AppMethodBeat.o(150784);
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(150785);
        this.username = cursor.getString(0);
        this.jgE = cursor.getInt(1);
        this.path = cursor.getString(2);
        this.iKR = cursor.getString(3);
        this.iKS = cursor.getString(4);
        this.iKT = cursor.getInt(5);
        this.iKU = cursor.getInt(6);
        AppMethodBeat.o(150785);
    }

    public final ContentValues convertTo() {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(150786);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 1) != 0) {
            contentValues.put(ch.COL_USERNAME, getUsername());
        }
        if ((this.cSx & 2) != 0) {
            contentValues.put("bgflag", Integer.valueOf(this.jgE));
        }
        if ((this.cSx & 4) != 0) {
            if (this.path == null) {
                str3 = "";
            } else {
                str3 = this.path;
            }
            contentValues.put("path", str3);
        }
        if ((this.cSx & 8) != 0) {
            if (this.iKR == null) {
                str2 = "";
            } else {
                str2 = this.iKR;
            }
            contentValues.put("reserved1", str2);
        }
        if ((this.cSx & 16) != 0) {
            if (this.iKS == null) {
                str = "";
            } else {
                str = this.iKS;
            }
            contentValues.put("reserved2", str);
        }
        if ((this.cSx & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.iKT));
        }
        if ((this.cSx & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.iKU));
        }
        AppMethodBeat.o(150786);
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}

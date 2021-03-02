package com.tencent.mm.bb;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;

public final class q {
    int cSx = -1;
    private String dJX = (this.id + "_" + this.dMe);
    public int dMe = 0;
    private String iKR = "";
    private String iKS = "";
    private int iKT = 0;
    private int iKU = 0;
    public int id = 0;
    String jhw = "";
    String name = "";
    int size = 0;
    public int status = 0;
    public int version = 0;

    public q() {
        AppMethodBeat.i(150834);
        AppMethodBeat.o(150834);
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(150835);
        this.version = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.size = cursor.getInt(4);
        this.jhw = cursor.getString(5);
        this.status = cursor.getInt(6);
        this.iKR = cursor.getString(8);
        this.iKS = cursor.getString(9);
        this.dMe = cursor.getInt(7);
        this.iKU = cursor.getInt(11);
        this.id = cursor.getInt(1);
        this.iKT = cursor.getInt(10);
        this.dJX = cursor.getString(0);
        AppMethodBeat.o(150835);
    }

    public final ContentValues convertTo() {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(150836);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 2) != 0) {
            contentValues.put("id", Integer.valueOf(this.id));
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("version", Integer.valueOf(this.version));
        }
        if ((this.cSx & 8) != 0) {
            if (this.name == null) {
                str3 = "";
            } else {
                str3 = this.name;
            }
            contentValues.put("name", str3);
        }
        if ((this.cSx & 16) != 0) {
            contentValues.put("size", Integer.valueOf(this.size));
        }
        if ((this.cSx & 32) != 0) {
            contentValues.put("packname", beq());
        }
        if ((this.cSx & 64) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.cSx & 128) != 0) {
            contentValues.put("type", Integer.valueOf(this.dMe));
        }
        if ((this.cSx & 256) != 0) {
            if (this.iKR == null) {
                str2 = "";
            } else {
                str2 = this.iKR;
            }
            contentValues.put("reserved1", str2);
        }
        if ((this.cSx & 512) != 0) {
            if (this.iKS == null) {
                str = "";
            } else {
                str = this.iKS;
            }
            contentValues.put("reserved2", str);
        }
        if ((this.cSx & 1024) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.iKT));
        }
        if ((this.cSx & 2048) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.iKU));
        }
        if ((this.cSx & 1) != 0) {
            contentValues.put(ch.COL_LOCALID, this.id + "_" + this.dMe);
        }
        AppMethodBeat.o(150836);
        return contentValues;
    }

    public final String beq() {
        return this.jhw == null ? "" : this.jhw;
    }
}

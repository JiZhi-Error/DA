package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.codeless.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;

public final class d {
    public int Bqg = 0;
    public long Bqh = 0;
    public long Bqi = 0;
    private String Bqj = "";
    private String Bqk = "";
    private String Bql = "";
    private String Bqm = "";
    public int cSx = -1;
    String extInfo = "";
    private int iFr = 0;
    private int iKT = 0;
    private int iKU = 0;
    private int iWj = 0;
    private long kfN = 0;
    public String username = "";

    public d() {
        AppMethodBeat.i(27719);
        AppMethodBeat.o(27719);
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(27720);
        this.username = cursor.getString(0);
        this.kfN = cursor.getLong(1);
        this.extInfo = cursor.getString(2);
        this.Bqg = cursor.getInt(3);
        this.Bqh = cursor.getLong(4);
        this.Bqi = cursor.getLong(5);
        this.iFr = cursor.getInt(6);
        this.iWj = cursor.getInt(7);
        this.iKT = cursor.getInt(8);
        this.iKU = cursor.getInt(9);
        this.Bqj = cursor.getString(10);
        this.Bqk = cursor.getString(11);
        this.Bql = cursor.getString(12);
        this.Bqm = cursor.getString(13);
        AppMethodBeat.o(27720);
    }

    public final ContentValues convertTo() {
        String str;
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(27721);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 1) != 0) {
            contentValues.put(ch.COL_USERNAME, getUsername());
        }
        if ((this.cSx & 2) != 0) {
            contentValues.put("qq", Long.valueOf(this.kfN));
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put(Constants.EXTINFO, bjg());
        }
        if ((this.cSx & 8) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.Bqg));
        }
        if ((this.cSx & 16) != 0) {
            contentValues.put("extupdateseq", Long.valueOf(this.Bqh));
        }
        if ((this.cSx & 32) != 0) {
            contentValues.put("imgupdateseq", Long.valueOf(this.Bqi));
        }
        if ((this.cSx & 64) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.iFr));
        }
        if ((this.cSx & 128) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.iWj));
        }
        if ((this.cSx & 256) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.iKT));
        }
        if ((this.cSx & 512) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.iKU));
        }
        if ((this.cSx & 1024) != 0) {
            if (this.Bqj == null) {
                str4 = "";
            } else {
                str4 = this.Bqj;
            }
            contentValues.put("reserved5", str4);
        }
        if ((this.cSx & 2048) != 0) {
            if (this.Bqk == null) {
                str3 = "";
            } else {
                str3 = this.Bqk;
            }
            contentValues.put("reserved6", str3);
        }
        if ((this.cSx & 4096) != 0) {
            if (this.Bql == null) {
                str2 = "";
            } else {
                str2 = this.Bql;
            }
            contentValues.put("reserved7", str2);
        }
        if ((this.cSx & 8192) != 0) {
            if (this.Bqm == null) {
                str = "";
            } else {
                str = this.Bqm;
            }
            contentValues.put("reserved8", str);
        }
        AppMethodBeat.o(27721);
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String bjg() {
        return this.extInfo == null ? "" : this.extInfo;
    }
}

package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    int cSx = -1;
    public long createTime = 0;
    public int djh = 0;
    public String filename = "";
    String iFt = "";
    String iFu = "";
    String jlz = "";
    int jsk = 0;
    long jsm = 0;
    public int msgType = 0;
    int status = 0;
    public int videoSource = 0;
    String znl = "";
    public String znm = "";
    public int znn = 0;
    public int zno = 0;
    int znp = 0;
    int znq = 0;
    public int znr = 0;

    public a() {
        AppMethodBeat.i(26343);
        AppMethodBeat.o(26343);
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(26344);
        this.jlz = cursor.getString(0);
        this.status = cursor.getInt(1);
        this.createTime = cursor.getLong(2);
        this.jsm = cursor.getLong(3);
        this.filename = cursor.getString(4);
        this.znl = cursor.getString(5);
        this.znm = cursor.getString(6);
        this.znn = cursor.getInt(7);
        this.msgType = cursor.getInt(8);
        this.zno = cursor.getInt(9);
        this.znp = cursor.getInt(10);
        this.djh = cursor.getInt(11);
        this.jsk = cursor.getInt(12);
        this.znq = cursor.getInt(13);
        this.videoSource = cursor.getInt(14);
        this.znr = cursor.getInt(15);
        this.iFt = cursor.getString(16);
        this.iFu = cursor.getString(17);
        AppMethodBeat.o(26344);
    }

    public final String ehw() {
        return this.jlz == null ? "" : this.jlz;
    }

    public final String ehx() {
        return this.filename == null ? "" : this.filename;
    }

    public final String ehy() {
        return this.znl == null ? "" : this.znl;
    }

    public final String ehz() {
        return this.znm == null ? "" : this.znm;
    }
}

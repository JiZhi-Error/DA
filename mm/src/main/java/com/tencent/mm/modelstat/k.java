package com.tencent.mm.modelstat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k {
    private static final String FORMAT = ("NetStatInfo:" + "[mobile in=%dB/%dB/%dB, out=%dB/%dB/%dB]" + "[wifi in=%dB/%dB/%dB, out=%dB/%dB/%dB]" + "[text in=%d/%dB, out=%d/%dB]" + "[image in=%d/%dB, out=%d/%dB]" + "[voice in=%d/%dB, out=%d/%dB]" + "[video in=%d/%dB, out=%d/%dB]");
    int cSx = -2;
    public int id = 0;
    public long joA = 0;
    public long joB = 0;
    public long joC = 0;
    public long joD = 0;
    public long joE = 0;
    public long joF = 0;
    public long joG = 0;
    public long joH = 0;
    public long joI = 0;
    public int jog = 0;
    public int joh = 0;
    public long joi = 0;
    public int joj = 0;
    public long jok = 0;
    public int jol = 0;
    public long jom = 0;
    public int jon = 0;
    public long joo = 0;
    public long jop = 0;
    public long joq = 0;
    public long jor = 0;
    public long jos = 0;
    public int jot = 0;
    public long jou = 0;
    public int jov = 0;
    public long jow = 0;
    public int jox = 0;
    public long joy = 0;
    public int joz = 0;

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(151084);
        this.id = cursor.getInt(0);
        this.jog = cursor.getInt(1);
        this.joh = cursor.getInt(2);
        this.joi = cursor.getLong(3);
        this.joj = cursor.getInt(4);
        this.jok = cursor.getLong(5);
        this.jol = cursor.getInt(6);
        this.jom = cursor.getLong(7);
        this.jon = cursor.getInt(8);
        this.joo = cursor.getLong(9);
        this.jop = cursor.getLong(10);
        this.joq = cursor.getLong(11);
        this.jor = cursor.getLong(12);
        this.jos = cursor.getLong(13);
        this.jot = cursor.getInt(14);
        this.jou = cursor.getLong(15);
        this.jov = cursor.getInt(16);
        this.jow = cursor.getLong(17);
        this.jox = cursor.getInt(18);
        this.joy = cursor.getLong(19);
        this.joz = cursor.getInt(20);
        this.joA = cursor.getLong(21);
        this.joB = cursor.getLong(22);
        this.joC = cursor.getLong(23);
        this.joD = cursor.getLong(24);
        this.joE = cursor.getLong(25);
        this.joF = cursor.getLong(26);
        this.joG = cursor.getLong(27);
        this.joH = cursor.getLong(28);
        this.joI = cursor.getLong(29);
        AppMethodBeat.o(151084);
    }

    static {
        AppMethodBeat.i(151086);
        AppMethodBeat.o(151086);
    }

    public final String toString() {
        AppMethodBeat.i(151085);
        String format = String.format(FORMAT, Long.valueOf(this.jop), Long.valueOf(this.joF), Long.valueOf(this.jor), Long.valueOf(this.joB), Long.valueOf(this.joH), Long.valueOf(this.joD), Long.valueOf(this.joq), Long.valueOf(this.joG), Long.valueOf(this.jos), Long.valueOf(this.joC), Long.valueOf(this.joI), Long.valueOf(this.joE), Integer.valueOf(this.joh), Long.valueOf(this.joi), Integer.valueOf(this.jot), Long.valueOf(this.jou), Integer.valueOf(this.joj), Long.valueOf(this.jok), Integer.valueOf(this.jov), Long.valueOf(this.jow), Integer.valueOf(this.jol), Long.valueOf(this.jom), Integer.valueOf(this.jox), Long.valueOf(this.joy), Integer.valueOf(this.jon), Long.valueOf(this.joo), Integer.valueOf(this.joz), Long.valueOf(this.joA));
        AppMethodBeat.o(151085);
        return format;
    }
}

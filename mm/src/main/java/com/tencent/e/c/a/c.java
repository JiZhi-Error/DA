package com.tencent.e.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends JceStruct {
    static b RLv = new b();
    public String KFF = "";
    public String RLg = "";
    public String RLh = "";
    public int RLi = 0;
    public int RLj = 0;
    public b RLk = null;
    public int RLl = 0;
    public int RLm = 0;
    public int RLn = 0;
    public int RLo = 0;
    public short RLp = 0;
    public String RLq = "";
    public int RLr = 0;
    public String RLs = "";
    public String RLt = "";
    public String RLu = "";
    public String aid = "";
    public String guid = "";
    public String imei = "";
    public String imsi = "";
    public String ip = "";
    public String khh = "";
    public double latitude = 0.0d;
    public double longitude = 0.0d;
    public String pSm = "";
    public String uuid = "";
    public String vid = "";

    @Override // com.qq.taf.jce.JceStruct
    public final JceStruct newInit() {
        AppMethodBeat.i(138324);
        c cVar = new c();
        AppMethodBeat.o(138324);
        return cVar;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138325);
        jceOutputStream.write(this.imei, 0);
        if (this.khh != null) {
            jceOutputStream.write(this.khh, 1);
        }
        if (this.pSm != null) {
            jceOutputStream.write(this.pSm, 2);
        }
        if (this.ip != null) {
            jceOutputStream.write(this.ip, 3);
        }
        if (this.RLg != null) {
            jceOutputStream.write(this.RLg, 4);
        }
        if (this.RLh != null) {
            jceOutputStream.write(this.RLh, 5);
        }
        if (this.KFF != null) {
            jceOutputStream.write(this.KFF, 6);
        }
        if (this.RLi != 0) {
            jceOutputStream.write(this.RLi, 7);
        }
        if (this.RLj != 0) {
            jceOutputStream.write(this.RLj, 8);
        }
        if (this.RLk != null) {
            jceOutputStream.write((JceStruct) this.RLk, 9);
        }
        if (this.guid != null) {
            jceOutputStream.write(this.guid, 10);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 11);
        }
        if (this.RLl != 0) {
            jceOutputStream.write(this.RLl, 12);
        }
        if (this.RLm != 0) {
            jceOutputStream.write(this.RLm, 13);
        }
        if (this.RLn != 0) {
            jceOutputStream.write(this.RLn, 14);
        }
        if (this.RLo != 0) {
            jceOutputStream.write(this.RLo, 15);
        }
        if (this.uuid != null) {
            jceOutputStream.write(this.uuid, 16);
        }
        if (this.RLp != 0) {
            jceOutputStream.write(this.RLp, 17);
        }
        if (this.longitude != 0.0d) {
            jceOutputStream.write(this.longitude, 18);
        }
        if (this.latitude != 0.0d) {
            jceOutputStream.write(this.latitude, 19);
        }
        if (this.RLq != null) {
            jceOutputStream.write(this.RLq, 20);
        }
        if (this.RLr != 0) {
            jceOutputStream.write(this.RLr, 21);
        }
        if (this.RLs != null) {
            jceOutputStream.write(this.RLs, 22);
        }
        if (this.vid != null) {
            jceOutputStream.write(this.vid, 23);
        }
        if (this.aid != null) {
            jceOutputStream.write(this.aid, 24);
        }
        if (this.RLt != null) {
            jceOutputStream.write(this.RLt, 25);
        }
        if (this.RLu != null) {
            jceOutputStream.write(this.RLu, 26);
        }
        AppMethodBeat.o(138325);
    }

    static {
        AppMethodBeat.i(138327);
        AppMethodBeat.o(138327);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138326);
        this.imei = jceInputStream.readString(0, true);
        this.khh = jceInputStream.readString(1, false);
        this.pSm = jceInputStream.readString(2, false);
        this.ip = jceInputStream.readString(3, false);
        this.RLg = jceInputStream.readString(4, false);
        this.RLh = jceInputStream.readString(5, false);
        this.KFF = jceInputStream.readString(6, false);
        this.RLi = jceInputStream.read(this.RLi, 7, false);
        this.RLj = jceInputStream.read(this.RLj, 8, false);
        this.RLk = (b) jceInputStream.read((JceStruct) RLv, 9, false);
        this.guid = jceInputStream.readString(10, false);
        this.imsi = jceInputStream.readString(11, false);
        this.RLl = jceInputStream.read(this.RLl, 12, false);
        this.RLm = jceInputStream.read(this.RLm, 13, false);
        this.RLn = jceInputStream.read(this.RLn, 14, false);
        this.RLo = jceInputStream.read(this.RLo, 15, false);
        this.uuid = jceInputStream.readString(16, false);
        this.RLp = jceInputStream.read(this.RLp, 17, false);
        this.longitude = jceInputStream.read(this.longitude, 18, false);
        this.latitude = jceInputStream.read(this.latitude, 19, false);
        this.RLq = jceInputStream.readString(20, false);
        this.RLr = jceInputStream.read(this.RLr, 21, false);
        this.RLs = jceInputStream.readString(22, false);
        this.vid = jceInputStream.readString(23, false);
        this.aid = jceInputStream.readString(24, false);
        this.RLt = jceInputStream.readString(25, false);
        this.RLu = jceInputStream.readString(26, false);
        AppMethodBeat.o(138326);
    }
}

package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class a extends JceStruct {
    static ArrayList<f> SrW = new ArrayList<>();
    static int SrX = 0;
    static int SrY = 0;
    static ArrayList<d> SrZ = new ArrayList<>();
    static b Ssa = new b();
    static byte[] Ssb;
    static Map<String, String> Ssc = new HashMap();
    public int IFo = 0;
    public String KFD = "";
    public String RLg = "";
    public String RNo = "";
    public String RNp = "";
    public String SrL = "";
    public long SrM = 0;
    public ArrayList<f> SrN = null;
    public long SrO = 0;
    public int SrP = 0;
    public ArrayList<d> SrQ = null;
    public int SrR = 0;
    public b SrS = null;
    public byte[] SrT = null;
    public String SrU = "";
    public Map<String, String> SrV = null;
    public String brand = "";
    public int channelId = 0;
    public int dataType = 0;
    public int dkT = 0;
    public String imei = "";
    public String imsi = "";
    public String model = "";
    public int platform = 0;
    public int sdkVer = 0;
    public String vid = "";

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214748);
        jceOutputStream.write(this.SrL, 0);
        jceOutputStream.write(this.channelId, 1);
        jceOutputStream.write(this.SrM, 2);
        if (this.SrN != null) {
            jceOutputStream.write((Collection) this.SrN, 3);
        }
        jceOutputStream.write(this.SrO, 4);
        jceOutputStream.write(this.dataType, 5);
        jceOutputStream.write(this.dkT, 6);
        jceOutputStream.write(this.SrP, 7);
        if (this.vid != null) {
            jceOutputStream.write(this.vid, 8);
        }
        jceOutputStream.write(this.platform, 9);
        if (this.brand != null) {
            jceOutputStream.write(this.brand, 10);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 11);
        }
        if (this.SrQ != null) {
            jceOutputStream.write((Collection) this.SrQ, 12);
        }
        jceOutputStream.write(this.IFo, 14);
        if (this.RLg != null) {
            jceOutputStream.write(this.RLg, 15);
        }
        if (this.RNo != null) {
            jceOutputStream.write(this.RNo, 16);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 17);
        }
        if (this.RNp != null) {
            jceOutputStream.write(this.RNp, 18);
        }
        jceOutputStream.write(this.sdkVer, 19);
        if (this.KFD != null) {
            jceOutputStream.write(this.KFD, 20);
        }
        jceOutputStream.write(this.SrR, 21);
        if (this.SrS != null) {
            jceOutputStream.write((JceStruct) this.SrS, 22);
        }
        if (this.imei != null) {
            jceOutputStream.write(this.imei, 23);
        }
        if (this.SrT != null) {
            jceOutputStream.write(this.SrT, 24);
        }
        if (this.SrU != null) {
            jceOutputStream.write(this.SrU, 25);
        }
        if (this.SrV != null) {
            jceOutputStream.write((Map) this.SrV, 26);
        }
        AppMethodBeat.o(214748);
    }

    static {
        AppMethodBeat.i(214750);
        SrW.add(new f());
        SrZ.add(new d());
        byte[] bArr = new byte[1];
        Ssb = bArr;
        bArr[0] = 0;
        Ssc.put("", "");
        AppMethodBeat.o(214750);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214749);
        this.SrL = jceInputStream.readString(0, true);
        this.channelId = jceInputStream.read(this.channelId, 1, true);
        this.SrM = jceInputStream.read(this.SrM, 2, false);
        this.SrN = (ArrayList) jceInputStream.read((Object) SrW, 3, false);
        this.SrO = jceInputStream.read(this.SrO, 4, false);
        this.dataType = jceInputStream.read(this.dataType, 5, false);
        this.dkT = jceInputStream.read(this.dkT, 6, false);
        this.SrP = jceInputStream.read(this.SrP, 7, false);
        this.vid = jceInputStream.readString(8, false);
        this.platform = jceInputStream.read(this.platform, 9, false);
        this.brand = jceInputStream.readString(10, false);
        this.model = jceInputStream.readString(11, false);
        this.SrQ = (ArrayList) jceInputStream.read((Object) SrZ, 12, false);
        this.IFo = jceInputStream.read(this.IFo, 14, false);
        this.RLg = jceInputStream.readString(15, false);
        this.RNo = jceInputStream.readString(16, false);
        this.imsi = jceInputStream.readString(17, false);
        this.RNp = jceInputStream.readString(18, false);
        this.sdkVer = jceInputStream.read(this.sdkVer, 19, false);
        this.KFD = jceInputStream.readString(20, false);
        this.SrR = jceInputStream.read(this.SrR, 21, false);
        this.SrS = (b) jceInputStream.read((JceStruct) Ssa, 22, false);
        this.imei = jceInputStream.readString(23, false);
        this.SrT = jceInputStream.read(Ssb, 24, false);
        this.SrU = jceInputStream.readString(25, false);
        this.SrV = (Map) jceInputStream.read((Object) Ssc, 26, false);
        AppMethodBeat.o(214749);
    }
}

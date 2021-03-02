package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class a extends JceStruct {
    static ArrayList<e> RNr;
    public int IFo = 0;
    public String RLg = "";
    public long RNm = 0;
    public ArrayList<e> RNn = null;
    public String RNo = "";
    public String RNp = "";
    public int RNq = 0;
    public String brand = "";
    public int channel = 0;
    public String dGL = "";
    public String dUb = "";
    public String imei = "";
    public String imsi = "";
    public String model = "";
    public int platform = 0;
    public int requestType = 0;
    public int sdkVer = 0;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138415);
        jceOutputStream.write(this.RNm, 0);
        jceOutputStream.write(this.dUb, 1);
        jceOutputStream.write((Collection) this.RNn, 2);
        jceOutputStream.write(this.IFo, 3);
        jceOutputStream.write(this.RLg, 4);
        jceOutputStream.write(this.channel, 5);
        jceOutputStream.write(this.requestType, 6);
        jceOutputStream.write(this.RNo, 7);
        if (this.imei != null) {
            jceOutputStream.write(this.imei, 8);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 9);
        }
        if (this.brand != null) {
            jceOutputStream.write(this.brand, 10);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 11);
        }
        if (this.RNp != null) {
            jceOutputStream.write(this.RNp, 12);
        }
        if (this.RNq != 0) {
            jceOutputStream.write(this.RNq, 13);
        }
        if (this.sdkVer != 0) {
            jceOutputStream.write(this.sdkVer, 14);
        }
        if (this.dGL != null) {
            jceOutputStream.write(this.dGL, 15);
        }
        jceOutputStream.write(this.platform, 16);
        AppMethodBeat.o(138415);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138416);
        this.RNm = jceInputStream.read(this.RNm, 0, true);
        this.dUb = jceInputStream.readString(1, true);
        if (RNr == null) {
            RNr = new ArrayList<>();
            RNr.add(new e());
        }
        this.RNn = (ArrayList) jceInputStream.read((Object) RNr, 2, true);
        this.IFo = jceInputStream.read(this.IFo, 3, true);
        this.RLg = jceInputStream.readString(4, true);
        this.channel = jceInputStream.read(this.channel, 5, true);
        this.requestType = jceInputStream.read(this.requestType, 6, true);
        this.RNo = jceInputStream.readString(7, true);
        this.imei = jceInputStream.readString(8, false);
        this.imsi = jceInputStream.readString(9, false);
        this.brand = jceInputStream.readString(10, false);
        this.model = jceInputStream.readString(11, false);
        this.RNp = jceInputStream.readString(12, false);
        this.RNq = jceInputStream.read(this.RNq, 13, false);
        this.sdkVer = jceInputStream.read(this.sdkVer, 14, false);
        this.dGL = jceInputStream.readString(15, false);
        this.platform = jceInputStream.read(this.platform, 16, false);
        AppMethodBeat.o(138416);
    }
}

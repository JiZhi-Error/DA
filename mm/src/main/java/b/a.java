package b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends JceStruct {
    static byte[] cache_sBuffer;
    public int EX = 0;
    public String Nco = "";
    public byte SKQ = 0;
    public String SKR = "";
    public byte SKS = 0;
    public String SKT = "";
    public String SKU = "";
    public String SKV = "";
    public byte SKW = 0;
    public byte SKX = 0;
    public String dPI = "";
    public String dfy = "";
    public String productId = "";
    public String qua = "";
    public String reserved = "";
    public byte[] sBuffer = null;
    public String sdkId = "";

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214830);
        jceOutputStream.write(this.SKS, 0);
        jceOutputStream.write(this.productId, 1);
        jceOutputStream.write(this.SKU, 2);
        jceOutputStream.write(this.sdkId, 3);
        jceOutputStream.write(this.dfy, 4);
        jceOutputStream.write(this.EX, 5);
        jceOutputStream.write(this.sBuffer, 6);
        if (this.SKR != null) {
            jceOutputStream.write(this.SKR, 7);
        }
        if (this.qua != null) {
            jceOutputStream.write(this.qua, 8);
        }
        jceOutputStream.write(this.SKQ, 9);
        jceOutputStream.write(this.SKX, 10);
        if (this.SKT != null) {
            jceOutputStream.write(this.SKT, 11);
        }
        if (this.reserved != null) {
            jceOutputStream.write(this.reserved, 12);
        }
        if (this.Nco != null) {
            jceOutputStream.write(this.Nco, 13);
        }
        jceOutputStream.write(this.SKW, 14);
        if (this.SKV != null) {
            jceOutputStream.write(this.SKV, 15);
        }
        if (this.dPI != null) {
            jceOutputStream.write(this.dPI, 16);
        }
        AppMethodBeat.o(214830);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214831);
        this.SKS = jceInputStream.read(this.SKS, 0, true);
        this.productId = jceInputStream.readString(1, true);
        this.SKU = jceInputStream.readString(2, true);
        this.sdkId = jceInputStream.readString(3, true);
        this.dfy = jceInputStream.readString(4, true);
        this.EX = jceInputStream.read(this.EX, 5, true);
        if (cache_sBuffer == null) {
            byte[] bArr = new byte[1];
            cache_sBuffer = bArr;
            bArr[0] = 0;
        }
        this.sBuffer = jceInputStream.read(cache_sBuffer, 6, true);
        this.SKR = jceInputStream.readString(7, false);
        this.qua = jceInputStream.readString(8, false);
        this.SKQ = jceInputStream.read(this.SKQ, 9, false);
        this.SKX = jceInputStream.read(this.SKX, 10, false);
        this.SKT = jceInputStream.readString(11, false);
        this.reserved = jceInputStream.readString(12, false);
        this.Nco = jceInputStream.readString(13, false);
        this.SKW = jceInputStream.read(this.SKW, 14, false);
        this.SKV = jceInputStream.readString(15, false);
        this.dPI = jceInputStream.readString(16, false);
        AppMethodBeat.o(214831);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
    }
}

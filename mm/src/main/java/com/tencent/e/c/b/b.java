package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class b extends JceStruct {
    static byte[] RLV;
    static byte[] RLW;
    static ArrayList<Integer> RLX = new ArrayList<>();
    static ArrayList<byte[]> RLY = new ArrayList<>();
    public int RLC = 0;
    public byte[] RLD = null;
    public String RLE = "";
    public byte[] RLF = null;
    public long RLG = 0;
    public String RLH = "";
    public int RLI = 0;
    public String RLJ = "";
    public int RLK = 0;
    public String RLL = "";
    public int RLM = 0;
    public int RLN = 0;
    public int RLO = 0;
    public ArrayList<Integer> RLP = null;
    public int RLQ = 0;
    public boolean RLR = false;
    public int RLS = 0;
    public int RLT = 0;
    public ArrayList<byte[]> RLU = null;

    @Override // com.qq.taf.jce.JceStruct
    public final JceStruct newInit() {
        AppMethodBeat.i(138332);
        b bVar = new b();
        AppMethodBeat.o(138332);
        return bVar;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138333);
        jceOutputStream.write(this.RLC, 0);
        if (this.RLD != null) {
            jceOutputStream.write(this.RLD, 1);
        }
        if (this.RLE != null) {
            jceOutputStream.write(this.RLE, 2);
        }
        if (this.RLF != null) {
            jceOutputStream.write(this.RLF, 3);
        }
        if (this.RLG != 0) {
            jceOutputStream.write(this.RLG, 4);
        }
        if (this.RLH != null) {
            jceOutputStream.write(this.RLH, 5);
        }
        if (this.RLI != 0) {
            jceOutputStream.write(this.RLI, 6);
        }
        if (this.RLJ != null) {
            jceOutputStream.write(this.RLJ, 7);
        }
        if (this.RLK != 0) {
            jceOutputStream.write(this.RLK, 8);
        }
        if (this.RLL != null) {
            jceOutputStream.write(this.RLL, 9);
        }
        jceOutputStream.write(this.RLM, 10);
        if (this.RLN != 0) {
            jceOutputStream.write(this.RLN, 11);
        }
        if (this.RLO != 0) {
            jceOutputStream.write(this.RLO, 12);
        }
        if (this.RLP != null) {
            jceOutputStream.write((Collection) this.RLP, 13);
        }
        if (this.RLQ != 0) {
            jceOutputStream.write(this.RLQ, 14);
        }
        jceOutputStream.write(this.RLR, 15);
        if (this.RLS != 0) {
            jceOutputStream.write(this.RLS, 16);
        }
        jceOutputStream.write(this.RLT, 17);
        if (this.RLU != null) {
            jceOutputStream.write((Collection) this.RLU, 18);
        }
        AppMethodBeat.o(138333);
    }

    static {
        AppMethodBeat.i(138335);
        byte[] bArr = new byte[1];
        RLV = bArr;
        bArr[0] = 0;
        byte[] bArr2 = new byte[1];
        RLW = bArr2;
        bArr2[0] = 0;
        RLX.add(0);
        byte[] bArr3 = new byte[1];
        bArr3[0] = 0;
        RLY.add(bArr3);
        AppMethodBeat.o(138335);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138334);
        this.RLC = jceInputStream.read(this.RLC, 0, true);
        this.RLD = jceInputStream.read(RLV, 1, false);
        this.RLE = jceInputStream.readString(2, false);
        this.RLF = jceInputStream.read(RLW, 3, false);
        this.RLG = jceInputStream.read(this.RLG, 4, false);
        this.RLH = jceInputStream.readString(5, false);
        this.RLI = jceInputStream.read(this.RLI, 6, false);
        this.RLJ = jceInputStream.readString(7, false);
        this.RLK = jceInputStream.read(this.RLK, 8, false);
        this.RLL = jceInputStream.readString(9, false);
        this.RLM = jceInputStream.read(this.RLM, 10, false);
        this.RLN = jceInputStream.read(this.RLN, 11, false);
        this.RLO = jceInputStream.read(this.RLO, 12, false);
        this.RLP = (ArrayList) jceInputStream.read((Object) RLX, 13, false);
        this.RLQ = jceInputStream.read(this.RLQ, 14, false);
        this.RLR = jceInputStream.read(this.RLR, 15, false);
        this.RLS = jceInputStream.read(this.RLS, 16, false);
        this.RLT = jceInputStream.read(this.RLT, 17, false);
        this.RLU = (ArrayList) jceInputStream.read((Object) RLY, 18, false);
        AppMethodBeat.o(138334);
    }
}

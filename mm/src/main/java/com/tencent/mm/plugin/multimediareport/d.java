package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class d extends a {
    public long createtime;
    public String fileid;
    public String gTB;
    public int hyI;
    public String md5;
    public String pPz;
    public String qwo;
    public int source;
    public String uuid;
    public long zGI;
    public int zGJ;
    public long zGK;
    public String zGL;
    public String zGM;
    public int zGN;
    public int zGO;
    public int zGP;
    public int zGQ;
    public String zGR;
    public String zGS;
    public int zGT;
    public b zGU;
    public LinkedList<a> zGV = new LinkedList<>();

    public d() {
        AppMethodBeat.i(194274);
        AppMethodBeat.o(194274);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194275);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.zGI);
            aVar.aM(2, this.zGJ);
            aVar.aM(3, this.source);
            aVar.bb(4, this.zGK);
            if (this.pPz != null) {
                aVar.e(5, this.pPz);
            }
            if (this.zGL != null) {
                aVar.e(6, this.zGL);
            }
            if (this.fileid != null) {
                aVar.e(7, this.fileid);
            }
            if (this.zGM != null) {
                aVar.e(8, this.zGM);
            }
            if (this.md5 != null) {
                aVar.e(9, this.md5);
            }
            aVar.bb(10, this.createtime);
            aVar.aM(11, this.zGN);
            aVar.aM(12, this.zGO);
            if (this.gTB != null) {
                aVar.e(13, this.gTB);
            }
            aVar.aM(14, this.zGP);
            aVar.aM(15, this.hyI);
            aVar.aM(16, this.zGQ);
            if (this.zGR != null) {
                aVar.e(17, this.zGR);
            }
            if (this.zGS != null) {
                aVar.e(18, this.zGS);
            }
            if (this.qwo != null) {
                aVar.e(19, this.qwo);
            }
            aVar.aM(20, this.zGT);
            if (this.uuid != null) {
                aVar.e(21, this.uuid);
            }
            if (this.zGU != null) {
                aVar.c(22, this.zGU);
            }
            aVar.e(23, 8, this.zGV);
            AppMethodBeat.o(194275);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.zGI) + 0 + g.a.a.b.b.a.bu(2, this.zGJ) + g.a.a.b.b.a.bu(3, this.source) + g.a.a.b.b.a.r(4, this.zGK);
            if (this.pPz != null) {
                r += g.a.a.b.b.a.f(5, this.pPz);
            }
            if (this.zGL != null) {
                r += g.a.a.b.b.a.f(6, this.zGL);
            }
            if (this.fileid != null) {
                r += g.a.a.b.b.a.f(7, this.fileid);
            }
            if (this.zGM != null) {
                r += g.a.a.b.b.a.f(8, this.zGM);
            }
            if (this.md5 != null) {
                r += g.a.a.b.b.a.f(9, this.md5);
            }
            int r2 = r + g.a.a.b.b.a.r(10, this.createtime) + g.a.a.b.b.a.bu(11, this.zGN) + g.a.a.b.b.a.bu(12, this.zGO);
            if (this.gTB != null) {
                r2 += g.a.a.b.b.a.f(13, this.gTB);
            }
            int bu = r2 + g.a.a.b.b.a.bu(14, this.zGP) + g.a.a.b.b.a.bu(15, this.hyI) + g.a.a.b.b.a.bu(16, this.zGQ);
            if (this.zGR != null) {
                bu += g.a.a.b.b.a.f(17, this.zGR);
            }
            if (this.zGS != null) {
                bu += g.a.a.b.b.a.f(18, this.zGS);
            }
            if (this.qwo != null) {
                bu += g.a.a.b.b.a.f(19, this.qwo);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(20, this.zGT);
            if (this.uuid != null) {
                bu2 += g.a.a.b.b.a.f(21, this.uuid);
            }
            if (this.zGU != null) {
                bu2 += g.a.a.b.b.a.b(22, this.zGU);
            }
            int c2 = bu2 + g.a.a.a.c(23, 8, this.zGV);
            AppMethodBeat.o(194275);
            return c2;
        } else if (i2 == 2) {
            this.zGV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194275);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.zGI = aVar3.UbS.zl();
                    AppMethodBeat.o(194275);
                    return 0;
                case 2:
                    dVar.zGJ = aVar3.UbS.zi();
                    AppMethodBeat.o(194275);
                    return 0;
                case 3:
                    dVar.source = aVar3.UbS.zi();
                    AppMethodBeat.o(194275);
                    return 0;
                case 4:
                    dVar.zGK = aVar3.UbS.zl();
                    AppMethodBeat.o(194275);
                    return 0;
                case 5:
                    dVar.pPz = aVar3.UbS.readString();
                    AppMethodBeat.o(194275);
                    return 0;
                case 6:
                    dVar.zGL = aVar3.UbS.readString();
                    AppMethodBeat.o(194275);
                    return 0;
                case 7:
                    dVar.fileid = aVar3.UbS.readString();
                    AppMethodBeat.o(194275);
                    return 0;
                case 8:
                    dVar.zGM = aVar3.UbS.readString();
                    AppMethodBeat.o(194275);
                    return 0;
                case 9:
                    dVar.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(194275);
                    return 0;
                case 10:
                    dVar.createtime = aVar3.UbS.zl();
                    AppMethodBeat.o(194275);
                    return 0;
                case 11:
                    dVar.zGN = aVar3.UbS.zi();
                    AppMethodBeat.o(194275);
                    return 0;
                case 12:
                    dVar.zGO = aVar3.UbS.zi();
                    AppMethodBeat.o(194275);
                    return 0;
                case 13:
                    dVar.gTB = aVar3.UbS.readString();
                    AppMethodBeat.o(194275);
                    return 0;
                case 14:
                    dVar.zGP = aVar3.UbS.zi();
                    AppMethodBeat.o(194275);
                    return 0;
                case 15:
                    dVar.hyI = aVar3.UbS.zi();
                    AppMethodBeat.o(194275);
                    return 0;
                case 16:
                    dVar.zGQ = aVar3.UbS.zi();
                    AppMethodBeat.o(194275);
                    return 0;
                case 17:
                    dVar.zGR = aVar3.UbS.readString();
                    AppMethodBeat.o(194275);
                    return 0;
                case 18:
                    dVar.zGS = aVar3.UbS.readString();
                    AppMethodBeat.o(194275);
                    return 0;
                case 19:
                    dVar.qwo = aVar3.UbS.readString();
                    AppMethodBeat.o(194275);
                    return 0;
                case 20:
                    dVar.zGT = aVar3.UbS.zi();
                    AppMethodBeat.o(194275);
                    return 0;
                case 21:
                    dVar.uuid = aVar3.UbS.readString();
                    AppMethodBeat.o(194275);
                    return 0;
                case 22:
                    dVar.zGU = aVar3.UbS.hPo();
                    AppMethodBeat.o(194275);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        a aVar4 = new a();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.populateBuilderWithField(aVar5, aVar4, a.getNextFieldNumber(aVar5))) {
                        }
                        dVar.zGV.add(aVar4);
                    }
                    AppMethodBeat.o(194275);
                    return 0;
                default:
                    AppMethodBeat.o(194275);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194275);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class nf extends a {
    public String KFu;
    public String KFv;
    public String KHk;
    public String KRP;
    public String KRQ;
    public String KRR;
    public String KRS;
    public String KRT;
    public String KRU;
    public String KRV;
    public String KRW;
    public String KRX;
    public String KRY;
    public String KRZ;
    public int KSa;
    public int KSb;
    public String KSc;
    public String KSd;
    public long KSe;
    public String Name;
    public String jfi;
    public int xIN;
    public String xuc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152508);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfi != null) {
                aVar.e(1, this.jfi);
            }
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            if (this.KHk != null) {
                aVar.e(3, this.KHk);
            }
            if (this.KRP != null) {
                aVar.e(4, this.KRP);
            }
            if (this.KRQ != null) {
                aVar.e(5, this.KRQ);
            }
            if (this.KRR != null) {
                aVar.e(6, this.KRR);
            }
            if (this.KRS != null) {
                aVar.e(7, this.KRS);
            }
            if (this.KRT != null) {
                aVar.e(8, this.KRT);
            }
            if (this.KRU != null) {
                aVar.e(9, this.KRU);
            }
            if (this.KRV != null) {
                aVar.e(10, this.KRV);
            }
            if (this.KRW != null) {
                aVar.e(11, this.KRW);
            }
            if (this.KFu != null) {
                aVar.e(12, this.KFu);
            }
            if (this.KRX != null) {
                aVar.e(13, this.KRX);
            }
            if (this.KRY != null) {
                aVar.e(14, this.KRY);
            }
            if (this.KRZ != null) {
                aVar.e(15, this.KRZ);
            }
            aVar.aM(16, this.xIN);
            aVar.aM(17, this.KSa);
            aVar.aM(18, this.KSb);
            if (this.KSc != null) {
                aVar.e(19, this.KSc);
            }
            if (this.xuc != null) {
                aVar.e(20, this.xuc);
            }
            if (this.KSd != null) {
                aVar.e(21, this.KSd);
            }
            if (this.KFv != null) {
                aVar.e(22, this.KFv);
            }
            aVar.bb(23, this.KSe);
            AppMethodBeat.o(152508);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.jfi != null ? g.a.a.b.b.a.f(1, this.jfi) + 0 : 0;
            if (this.Name != null) {
                f2 += g.a.a.b.b.a.f(2, this.Name);
            }
            if (this.KHk != null) {
                f2 += g.a.a.b.b.a.f(3, this.KHk);
            }
            if (this.KRP != null) {
                f2 += g.a.a.b.b.a.f(4, this.KRP);
            }
            if (this.KRQ != null) {
                f2 += g.a.a.b.b.a.f(5, this.KRQ);
            }
            if (this.KRR != null) {
                f2 += g.a.a.b.b.a.f(6, this.KRR);
            }
            if (this.KRS != null) {
                f2 += g.a.a.b.b.a.f(7, this.KRS);
            }
            if (this.KRT != null) {
                f2 += g.a.a.b.b.a.f(8, this.KRT);
            }
            if (this.KRU != null) {
                f2 += g.a.a.b.b.a.f(9, this.KRU);
            }
            if (this.KRV != null) {
                f2 += g.a.a.b.b.a.f(10, this.KRV);
            }
            if (this.KRW != null) {
                f2 += g.a.a.b.b.a.f(11, this.KRW);
            }
            if (this.KFu != null) {
                f2 += g.a.a.b.b.a.f(12, this.KFu);
            }
            if (this.KRX != null) {
                f2 += g.a.a.b.b.a.f(13, this.KRX);
            }
            if (this.KRY != null) {
                f2 += g.a.a.b.b.a.f(14, this.KRY);
            }
            if (this.KRZ != null) {
                f2 += g.a.a.b.b.a.f(15, this.KRZ);
            }
            int bu = f2 + g.a.a.b.b.a.bu(16, this.xIN) + g.a.a.b.b.a.bu(17, this.KSa) + g.a.a.b.b.a.bu(18, this.KSb);
            if (this.KSc != null) {
                bu += g.a.a.b.b.a.f(19, this.KSc);
            }
            if (this.xuc != null) {
                bu += g.a.a.b.b.a.f(20, this.xuc);
            }
            if (this.KSd != null) {
                bu += g.a.a.b.b.a.f(21, this.KSd);
            }
            if (this.KFv != null) {
                bu += g.a.a.b.b.a.f(22, this.KFv);
            }
            int r = bu + g.a.a.b.b.a.r(23, this.KSe);
            AppMethodBeat.o(152508);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152508);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            nf nfVar = (nf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nfVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 2:
                    nfVar.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 3:
                    nfVar.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 4:
                    nfVar.KRP = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 5:
                    nfVar.KRQ = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 6:
                    nfVar.KRR = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 7:
                    nfVar.KRS = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 8:
                    nfVar.KRT = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 9:
                    nfVar.KRU = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 10:
                    nfVar.KRV = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 11:
                    nfVar.KRW = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 12:
                    nfVar.KFu = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 13:
                    nfVar.KRX = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 14:
                    nfVar.KRY = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 15:
                    nfVar.KRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 16:
                    nfVar.xIN = aVar3.UbS.zi();
                    AppMethodBeat.o(152508);
                    return 0;
                case 17:
                    nfVar.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(152508);
                    return 0;
                case 18:
                    nfVar.KSb = aVar3.UbS.zi();
                    AppMethodBeat.o(152508);
                    return 0;
                case 19:
                    nfVar.KSc = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 20:
                    nfVar.xuc = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 21:
                    nfVar.KSd = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 22:
                    nfVar.KFv = aVar3.UbS.readString();
                    AppMethodBeat.o(152508);
                    return 0;
                case 23:
                    nfVar.KSe = aVar3.UbS.zl();
                    AppMethodBeat.o(152508);
                    return 0;
                default:
                    AppMethodBeat.o(152508);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152508);
            return -1;
        }
    }
}

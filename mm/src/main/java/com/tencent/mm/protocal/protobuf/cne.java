package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cne extends a {
    public String Desc;
    public int Mpa;
    public String MsS;
    public int MsU;
    public int MsV;
    public int Mtd;
    public String Mte;
    public cmw Mtr;
    public int Mts;
    public LinkedList<cmw> Mtt = new LinkedList<>();
    public String Mtu;
    public String Mtv;
    public String Mtw;
    public cly Mtx;
    public int Mty;
    public int Privated;
    public int beK;
    public int dJi;
    public String dNI;
    public int ibG;
    public String md5;
    public String token;
    public String videoPath;

    public cne() {
        AppMethodBeat.i(125747);
        AppMethodBeat.o(125747);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125748);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MsU);
            aVar.aM(2, this.MsV);
            aVar.aM(3, this.Privated);
            if (this.Mtr != null) {
                aVar.ni(4, this.Mtr.computeSize());
                this.Mtr.writeFields(aVar);
            }
            aVar.aM(5, this.Mts);
            aVar.e(6, 8, this.Mtt);
            aVar.aM(7, this.ibG);
            aVar.aM(8, this.Mpa);
            if (this.Desc != null) {
                aVar.e(9, this.Desc);
            }
            if (this.Mtu != null) {
                aVar.e(10, this.Mtu);
            }
            if (this.token != null) {
                aVar.e(11, this.token);
            }
            if (this.Mte != null) {
                aVar.e(12, this.Mte);
            }
            aVar.aM(13, this.Mtd);
            if (this.videoPath != null) {
                aVar.e(14, this.videoPath);
            }
            if (this.Mtv != null) {
                aVar.e(15, this.Mtv);
            }
            if (this.Mtw != null) {
                aVar.e(16, this.Mtw);
            }
            if (this.md5 != null) {
                aVar.e(17, this.md5);
            }
            if (this.dNI != null) {
                aVar.e(18, this.dNI);
            }
            aVar.aM(19, this.beK);
            aVar.aM(20, this.dJi);
            if (this.MsS != null) {
                aVar.e(21, this.MsS);
            }
            if (this.Mtx != null) {
                aVar.ni(22, this.Mtx.computeSize());
                this.Mtx.writeFields(aVar);
            }
            aVar.aM(23, this.Mty);
            AppMethodBeat.o(125748);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MsU) + 0 + g.a.a.b.b.a.bu(2, this.MsV) + g.a.a.b.b.a.bu(3, this.Privated);
            if (this.Mtr != null) {
                bu += g.a.a.a.nh(4, this.Mtr.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.Mts) + g.a.a.a.c(6, 8, this.Mtt) + g.a.a.b.b.a.bu(7, this.ibG) + g.a.a.b.b.a.bu(8, this.Mpa);
            if (this.Desc != null) {
                bu2 += g.a.a.b.b.a.f(9, this.Desc);
            }
            if (this.Mtu != null) {
                bu2 += g.a.a.b.b.a.f(10, this.Mtu);
            }
            if (this.token != null) {
                bu2 += g.a.a.b.b.a.f(11, this.token);
            }
            if (this.Mte != null) {
                bu2 += g.a.a.b.b.a.f(12, this.Mte);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.Mtd);
            if (this.videoPath != null) {
                bu3 += g.a.a.b.b.a.f(14, this.videoPath);
            }
            if (this.Mtv != null) {
                bu3 += g.a.a.b.b.a.f(15, this.Mtv);
            }
            if (this.Mtw != null) {
                bu3 += g.a.a.b.b.a.f(16, this.Mtw);
            }
            if (this.md5 != null) {
                bu3 += g.a.a.b.b.a.f(17, this.md5);
            }
            if (this.dNI != null) {
                bu3 += g.a.a.b.b.a.f(18, this.dNI);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(19, this.beK) + g.a.a.b.b.a.bu(20, this.dJi);
            if (this.MsS != null) {
                bu4 += g.a.a.b.b.a.f(21, this.MsS);
            }
            if (this.Mtx != null) {
                bu4 += g.a.a.a.nh(22, this.Mtx.computeSize());
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(23, this.Mty);
            AppMethodBeat.o(125748);
            return bu5;
        } else if (i2 == 2) {
            this.Mtt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125748);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cne cne = (cne) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cne.MsU = aVar3.UbS.zi();
                    AppMethodBeat.o(125748);
                    return 0;
                case 2:
                    cne.MsV = aVar3.UbS.zi();
                    AppMethodBeat.o(125748);
                    return 0;
                case 3:
                    cne.Privated = aVar3.UbS.zi();
                    AppMethodBeat.o(125748);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cmw cmw = new cmw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cmw.populateBuilderWithField(aVar4, cmw, a.getNextFieldNumber(aVar4))) {
                        }
                        cne.Mtr = cmw;
                    }
                    AppMethodBeat.o(125748);
                    return 0;
                case 5:
                    cne.Mts = aVar3.UbS.zi();
                    AppMethodBeat.o(125748);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cmw cmw2 = new cmw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cmw2.populateBuilderWithField(aVar5, cmw2, a.getNextFieldNumber(aVar5))) {
                        }
                        cne.Mtt.add(cmw2);
                    }
                    AppMethodBeat.o(125748);
                    return 0;
                case 7:
                    cne.ibG = aVar3.UbS.zi();
                    AppMethodBeat.o(125748);
                    return 0;
                case 8:
                    cne.Mpa = aVar3.UbS.zi();
                    AppMethodBeat.o(125748);
                    return 0;
                case 9:
                    cne.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(125748);
                    return 0;
                case 10:
                    cne.Mtu = aVar3.UbS.readString();
                    AppMethodBeat.o(125748);
                    return 0;
                case 11:
                    cne.token = aVar3.UbS.readString();
                    AppMethodBeat.o(125748);
                    return 0;
                case 12:
                    cne.Mte = aVar3.UbS.readString();
                    AppMethodBeat.o(125748);
                    return 0;
                case 13:
                    cne.Mtd = aVar3.UbS.zi();
                    AppMethodBeat.o(125748);
                    return 0;
                case 14:
                    cne.videoPath = aVar3.UbS.readString();
                    AppMethodBeat.o(125748);
                    return 0;
                case 15:
                    cne.Mtv = aVar3.UbS.readString();
                    AppMethodBeat.o(125748);
                    return 0;
                case 16:
                    cne.Mtw = aVar3.UbS.readString();
                    AppMethodBeat.o(125748);
                    return 0;
                case 17:
                    cne.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(125748);
                    return 0;
                case 18:
                    cne.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(125748);
                    return 0;
                case 19:
                    cne.beK = aVar3.UbS.zi();
                    AppMethodBeat.o(125748);
                    return 0;
                case 20:
                    cne.dJi = aVar3.UbS.zi();
                    AppMethodBeat.o(125748);
                    return 0;
                case 21:
                    cne.MsS = aVar3.UbS.readString();
                    AppMethodBeat.o(125748);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cly cly = new cly();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cly.populateBuilderWithField(aVar6, cly, a.getNextFieldNumber(aVar6))) {
                        }
                        cne.Mtx = cly;
                    }
                    AppMethodBeat.o(125748);
                    return 0;
                case 23:
                    cne.Mty = aVar3.UbS.zi();
                    AppMethodBeat.o(125748);
                    return 0;
                default:
                    AppMethodBeat.o(125748);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125748);
            return -1;
        }
    }
}

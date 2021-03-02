package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class awe extends a {
    public String EzJ;
    public int LCy;
    public long LDN;
    public long LDU;
    public int LEg;
    public avs LGR;
    public awl LGS;
    public axe LGT;
    public int LGU;
    public axj LGV;
    public long ViH;
    public int Vje;
    public int Vjf;
    public String Vjg;
    public long Vjh;
    public int dvv;
    public int iqg;
    public long liveId;
    public int liveStatus;
    public int uBn;
    public int wBG;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209525);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.liveId);
            aVar.aM(2, this.uBn);
            aVar.aM(3, this.liveStatus);
            if (this.EzJ != null) {
                aVar.e(4, this.EzJ);
            }
            aVar.aM(5, this.dvv);
            aVar.aM(6, this.wBG);
            aVar.aM(7, this.iqg);
            if (this.LGR != null) {
                aVar.ni(8, this.LGR.computeSize());
                this.LGR.writeFields(aVar);
            }
            if (this.LGS != null) {
                aVar.ni(9, this.LGS.computeSize());
                this.LGS.writeFields(aVar);
            }
            if (this.LGT != null) {
                aVar.ni(10, this.LGT.computeSize());
                this.LGT.writeFields(aVar);
            }
            aVar.aM(11, this.LCy);
            aVar.bb(12, this.LDU);
            aVar.aM(13, this.LEg);
            aVar.aM(14, this.LGU);
            aVar.bb(15, this.LDN);
            if (this.LGV != null) {
                aVar.ni(16, this.LGV.computeSize());
                this.LGV.writeFields(aVar);
            }
            aVar.aM(17, this.Vje);
            aVar.aM(18, this.Vjf);
            if (this.Vjg != null) {
                aVar.e(19, this.Vjg);
            }
            aVar.bb(20, this.Vjh);
            aVar.bb(21, this.ViH);
            AppMethodBeat.o(209525);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.liveId) + 0 + g.a.a.b.b.a.bu(2, this.uBn) + g.a.a.b.b.a.bu(3, this.liveStatus);
            if (this.EzJ != null) {
                r += g.a.a.b.b.a.f(4, this.EzJ);
            }
            int bu = r + g.a.a.b.b.a.bu(5, this.dvv) + g.a.a.b.b.a.bu(6, this.wBG) + g.a.a.b.b.a.bu(7, this.iqg);
            if (this.LGR != null) {
                bu += g.a.a.a.nh(8, this.LGR.computeSize());
            }
            if (this.LGS != null) {
                bu += g.a.a.a.nh(9, this.LGS.computeSize());
            }
            if (this.LGT != null) {
                bu += g.a.a.a.nh(10, this.LGT.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.LCy) + g.a.a.b.b.a.r(12, this.LDU) + g.a.a.b.b.a.bu(13, this.LEg) + g.a.a.b.b.a.bu(14, this.LGU) + g.a.a.b.b.a.r(15, this.LDN);
            if (this.LGV != null) {
                bu2 += g.a.a.a.nh(16, this.LGV.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(17, this.Vje) + g.a.a.b.b.a.bu(18, this.Vjf);
            if (this.Vjg != null) {
                bu3 += g.a.a.b.b.a.f(19, this.Vjg);
            }
            int r2 = bu3 + g.a.a.b.b.a.r(20, this.Vjh) + g.a.a.b.b.a.r(21, this.ViH);
            AppMethodBeat.o(209525);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209525);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awe awe = (awe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awe.liveId = aVar3.UbS.zl();
                    AppMethodBeat.o(209525);
                    return 0;
                case 2:
                    awe.uBn = aVar3.UbS.zi();
                    AppMethodBeat.o(209525);
                    return 0;
                case 3:
                    awe.liveStatus = aVar3.UbS.zi();
                    AppMethodBeat.o(209525);
                    return 0;
                case 4:
                    awe.EzJ = aVar3.UbS.readString();
                    AppMethodBeat.o(209525);
                    return 0;
                case 5:
                    awe.dvv = aVar3.UbS.zi();
                    AppMethodBeat.o(209525);
                    return 0;
                case 6:
                    awe.wBG = aVar3.UbS.zi();
                    AppMethodBeat.o(209525);
                    return 0;
                case 7:
                    awe.iqg = aVar3.UbS.zi();
                    AppMethodBeat.o(209525);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        avs avs = new avs();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = avs.populateBuilderWithField(aVar4, avs, a.getNextFieldNumber(aVar4))) {
                        }
                        awe.LGR = avs;
                    }
                    AppMethodBeat.o(209525);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        awl awl = new awl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = awl.populateBuilderWithField(aVar5, awl, a.getNextFieldNumber(aVar5))) {
                        }
                        awe.LGS = awl;
                    }
                    AppMethodBeat.o(209525);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        axe axe = new axe();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = axe.populateBuilderWithField(aVar6, axe, a.getNextFieldNumber(aVar6))) {
                        }
                        awe.LGT = axe;
                    }
                    AppMethodBeat.o(209525);
                    return 0;
                case 11:
                    awe.LCy = aVar3.UbS.zi();
                    AppMethodBeat.o(209525);
                    return 0;
                case 12:
                    awe.LDU = aVar3.UbS.zl();
                    AppMethodBeat.o(209525);
                    return 0;
                case 13:
                    awe.LEg = aVar3.UbS.zi();
                    AppMethodBeat.o(209525);
                    return 0;
                case 14:
                    awe.LGU = aVar3.UbS.zi();
                    AppMethodBeat.o(209525);
                    return 0;
                case 15:
                    awe.LDN = aVar3.UbS.zl();
                    AppMethodBeat.o(209525);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        axj axj = new axj();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = axj.populateBuilderWithField(aVar7, axj, a.getNextFieldNumber(aVar7))) {
                        }
                        awe.LGV = axj;
                    }
                    AppMethodBeat.o(209525);
                    return 0;
                case 17:
                    awe.Vje = aVar3.UbS.zi();
                    AppMethodBeat.o(209525);
                    return 0;
                case 18:
                    awe.Vjf = aVar3.UbS.zi();
                    AppMethodBeat.o(209525);
                    return 0;
                case 19:
                    awe.Vjg = aVar3.UbS.readString();
                    AppMethodBeat.o(209525);
                    return 0;
                case 20:
                    awe.Vjh = aVar3.UbS.zl();
                    AppMethodBeat.o(209525);
                    return 0;
                case 21:
                    awe.ViH = aVar3.UbS.zl();
                    AppMethodBeat.o(209525);
                    return 0;
                default:
                    AppMethodBeat.o(209525);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209525);
            return -1;
        }
    }
}

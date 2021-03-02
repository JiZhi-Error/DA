package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eso extends dop {
    public int Llx;
    public int LsZ;
    public long Lta;
    public String MKC;
    public int NpI;
    public euk NpJ;
    public euk NpK;
    public String NpL;
    public int NpM;
    public long NpN;
    public int NpO;
    public int NpP;
    public LinkedList<csu> NpQ = new LinkedList<>();

    public eso() {
        AppMethodBeat.i(115857);
        AppMethodBeat.o(115857);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115858);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.bb(3, this.Lta);
            if (this.MKC != null) {
                aVar.e(4, this.MKC);
            }
            aVar.aM(5, this.NpI);
            if (this.NpJ != null) {
                aVar.ni(6, this.NpJ.computeSize());
                this.NpJ.writeFields(aVar);
            }
            if (this.NpK != null) {
                aVar.ni(7, this.NpK.computeSize());
                this.NpK.writeFields(aVar);
            }
            aVar.aM(8, this.Llx);
            if (this.NpL != null) {
                aVar.e(9, this.NpL);
            }
            aVar.aM(10, this.NpM);
            aVar.bb(11, this.NpN);
            aVar.aM(12, this.NpO);
            aVar.aM(13, this.NpP);
            aVar.e(14, 8, this.NpQ);
            AppMethodBeat.o(115858);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta);
            if (this.MKC != null) {
                nh += g.a.a.b.b.a.f(4, this.MKC);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.NpI);
            if (this.NpJ != null) {
                bu += g.a.a.a.nh(6, this.NpJ.computeSize());
            }
            if (this.NpK != null) {
                bu += g.a.a.a.nh(7, this.NpK.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.Llx);
            if (this.NpL != null) {
                bu2 += g.a.a.b.b.a.f(9, this.NpL);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(10, this.NpM) + g.a.a.b.b.a.r(11, this.NpN) + g.a.a.b.b.a.bu(12, this.NpO) + g.a.a.b.b.a.bu(13, this.NpP) + g.a.a.a.c(14, 8, this.NpQ);
            AppMethodBeat.o(115858);
            return bu3;
        } else if (i2 == 2) {
            this.NpQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115858);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eso eso = (eso) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        eso.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(115858);
                    return 0;
                case 2:
                    eso.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115858);
                    return 0;
                case 3:
                    eso.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115858);
                    return 0;
                case 4:
                    eso.MKC = aVar3.UbS.readString();
                    AppMethodBeat.o(115858);
                    return 0;
                case 5:
                    eso.NpI = aVar3.UbS.zi();
                    AppMethodBeat.o(115858);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        euk euk = new euk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = euk.populateBuilderWithField(aVar5, euk, dop.getNextFieldNumber(aVar5))) {
                        }
                        eso.NpJ = euk;
                    }
                    AppMethodBeat.o(115858);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        euk euk2 = new euk();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = euk2.populateBuilderWithField(aVar6, euk2, dop.getNextFieldNumber(aVar6))) {
                        }
                        eso.NpK = euk2;
                    }
                    AppMethodBeat.o(115858);
                    return 0;
                case 8:
                    eso.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(115858);
                    return 0;
                case 9:
                    eso.NpL = aVar3.UbS.readString();
                    AppMethodBeat.o(115858);
                    return 0;
                case 10:
                    eso.NpM = aVar3.UbS.zi();
                    AppMethodBeat.o(115858);
                    return 0;
                case 11:
                    eso.NpN = aVar3.UbS.zl();
                    AppMethodBeat.o(115858);
                    return 0;
                case 12:
                    eso.NpO = aVar3.UbS.zi();
                    AppMethodBeat.o(115858);
                    return 0;
                case 13:
                    eso.NpP = aVar3.UbS.zi();
                    AppMethodBeat.o(115858);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        csu csu = new csu();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = csu.populateBuilderWithField(aVar7, csu, dop.getNextFieldNumber(aVar7))) {
                        }
                        eso.NpQ.add(csu);
                    }
                    AppMethodBeat.o(115858);
                    return 0;
                default:
                    AppMethodBeat.o(115858);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115858);
            return -1;
        }
    }
}

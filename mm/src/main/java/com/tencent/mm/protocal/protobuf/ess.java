package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ess extends dop {
    public int Llx;
    public int LsZ;
    public long Lta;
    public String MKC;
    public euk NpJ;
    public euk NpK;
    public long NpN;
    public int NpO;
    public int NpP;
    public LinkedList<csu> NpQ = new LinkedList<>();
    public int Nqa;
    public int Nqb;

    public ess() {
        AppMethodBeat.i(115863);
        AppMethodBeat.o(115863);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115864);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MKC != null) {
                aVar.e(2, this.MKC);
            }
            aVar.aM(3, this.LsZ);
            aVar.aM(4, this.Nqa);
            if (this.NpJ != null) {
                aVar.ni(5, this.NpJ.computeSize());
                this.NpJ.writeFields(aVar);
            }
            if (this.NpK != null) {
                aVar.ni(6, this.NpK.computeSize());
                this.NpK.writeFields(aVar);
            }
            aVar.bb(7, this.Lta);
            aVar.aM(8, this.Llx);
            aVar.bb(9, this.NpN);
            aVar.aM(10, this.Nqb);
            aVar.aM(11, this.NpO);
            aVar.aM(12, this.NpP);
            aVar.e(13, 8, this.NpQ);
            AppMethodBeat.o(115864);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MKC != null) {
                nh += g.a.a.b.b.a.f(2, this.MKC);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.LsZ) + g.a.a.b.b.a.bu(4, this.Nqa);
            if (this.NpJ != null) {
                bu += g.a.a.a.nh(5, this.NpJ.computeSize());
            }
            if (this.NpK != null) {
                bu += g.a.a.a.nh(6, this.NpK.computeSize());
            }
            int r = bu + g.a.a.b.b.a.r(7, this.Lta) + g.a.a.b.b.a.bu(8, this.Llx) + g.a.a.b.b.a.r(9, this.NpN) + g.a.a.b.b.a.bu(10, this.Nqb) + g.a.a.b.b.a.bu(11, this.NpO) + g.a.a.b.b.a.bu(12, this.NpP) + g.a.a.a.c(13, 8, this.NpQ);
            AppMethodBeat.o(115864);
            return r;
        } else if (i2 == 2) {
            this.NpQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115864);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ess ess = (ess) objArr[1];
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
                        ess.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(115864);
                    return 0;
                case 2:
                    ess.MKC = aVar3.UbS.readString();
                    AppMethodBeat.o(115864);
                    return 0;
                case 3:
                    ess.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115864);
                    return 0;
                case 4:
                    ess.Nqa = aVar3.UbS.zi();
                    AppMethodBeat.o(115864);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        euk euk = new euk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = euk.populateBuilderWithField(aVar5, euk, dop.getNextFieldNumber(aVar5))) {
                        }
                        ess.NpJ = euk;
                    }
                    AppMethodBeat.o(115864);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        euk euk2 = new euk();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = euk2.populateBuilderWithField(aVar6, euk2, dop.getNextFieldNumber(aVar6))) {
                        }
                        ess.NpK = euk2;
                    }
                    AppMethodBeat.o(115864);
                    return 0;
                case 7:
                    ess.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115864);
                    return 0;
                case 8:
                    ess.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(115864);
                    return 0;
                case 9:
                    ess.NpN = aVar3.UbS.zl();
                    AppMethodBeat.o(115864);
                    return 0;
                case 10:
                    ess.Nqb = aVar3.UbS.zi();
                    AppMethodBeat.o(115864);
                    return 0;
                case 11:
                    ess.NpO = aVar3.UbS.zi();
                    AppMethodBeat.o(115864);
                    return 0;
                case 12:
                    ess.NpP = aVar3.UbS.zi();
                    AppMethodBeat.o(115864);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        csu csu = new csu();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = csu.populateBuilderWithField(aVar7, csu, dop.getNextFieldNumber(aVar7))) {
                        }
                        ess.NpQ.add(csu);
                    }
                    AppMethodBeat.o(115864);
                    return 0;
                default:
                    AppMethodBeat.o(115864);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115864);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class etw extends dop {
    public int Llx;
    public int LsZ;
    public long Lta;
    public String MKC;
    public int MKg;
    public int NbR;
    public euk NpJ;
    public euk NpK;
    public long NpN;
    public int NpO;
    public int NpP;
    public LinkedList<csu> NpQ = new LinkedList<>();
    public int NqJ;
    public int NqV;
    public LinkedList<dqi> NqW = new LinkedList<>();
    public int NqX;

    public etw() {
        AppMethodBeat.i(115883);
        AppMethodBeat.o(115883);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115884);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.NpJ == null) {
                b bVar = new b("Not all required fields were included: PeerId");
                AppMethodBeat.o(115884);
                throw bVar;
            } else if (this.NpK == null) {
                b bVar2 = new b("Not all required fields were included: CapInfo");
                AppMethodBeat.o(115884);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.MKC != null) {
                    aVar.e(2, this.MKC);
                }
                aVar.aM(3, this.NqV);
                aVar.e(4, 8, this.NqW);
                if (this.NpJ != null) {
                    aVar.ni(6, this.NpJ.computeSize());
                    this.NpJ.writeFields(aVar);
                }
                if (this.NpK != null) {
                    aVar.ni(7, this.NpK.computeSize());
                    this.NpK.writeFields(aVar);
                }
                aVar.aM(8, this.Llx);
                aVar.aM(9, this.NbR);
                aVar.aM(10, this.LsZ);
                aVar.bb(11, this.Lta);
                aVar.aM(12, this.NqJ);
                aVar.bb(13, this.NpN);
                aVar.aM(14, this.NqX);
                aVar.aM(15, this.MKg);
                aVar.aM(16, this.NpO);
                aVar.aM(17, this.NpP);
                aVar.e(18, 8, this.NpQ);
                AppMethodBeat.o(115884);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MKC != null) {
                nh += g.a.a.b.b.a.f(2, this.MKC);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.NqV) + g.a.a.a.c(4, 8, this.NqW);
            if (this.NpJ != null) {
                bu += g.a.a.a.nh(6, this.NpJ.computeSize());
            }
            if (this.NpK != null) {
                bu += g.a.a.a.nh(7, this.NpK.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.Llx) + g.a.a.b.b.a.bu(9, this.NbR) + g.a.a.b.b.a.bu(10, this.LsZ) + g.a.a.b.b.a.r(11, this.Lta) + g.a.a.b.b.a.bu(12, this.NqJ) + g.a.a.b.b.a.r(13, this.NpN) + g.a.a.b.b.a.bu(14, this.NqX) + g.a.a.b.b.a.bu(15, this.MKg) + g.a.a.b.b.a.bu(16, this.NpO) + g.a.a.b.b.a.bu(17, this.NpP) + g.a.a.a.c(18, 8, this.NpQ);
            AppMethodBeat.o(115884);
            return bu2;
        } else if (i2 == 2) {
            this.NqW.clear();
            this.NpQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NpJ == null) {
                b bVar3 = new b("Not all required fields were included: PeerId");
                AppMethodBeat.o(115884);
                throw bVar3;
            } else if (this.NpK == null) {
                b bVar4 = new b("Not all required fields were included: CapInfo");
                AppMethodBeat.o(115884);
                throw bVar4;
            } else {
                AppMethodBeat.o(115884);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            etw etw = (etw) objArr[1];
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
                        etw.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(115884);
                    return 0;
                case 2:
                    etw.MKC = aVar3.UbS.readString();
                    AppMethodBeat.o(115884);
                    return 0;
                case 3:
                    etw.NqV = aVar3.UbS.zi();
                    AppMethodBeat.o(115884);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        etw.NqW.add(dqi);
                    }
                    AppMethodBeat.o(115884);
                    return 0;
                case 5:
                default:
                    AppMethodBeat.o(115884);
                    return -1;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        euk euk = new euk();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = euk.populateBuilderWithField(aVar6, euk, dop.getNextFieldNumber(aVar6))) {
                        }
                        etw.NpJ = euk;
                    }
                    AppMethodBeat.o(115884);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        euk euk2 = new euk();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = euk2.populateBuilderWithField(aVar7, euk2, dop.getNextFieldNumber(aVar7))) {
                        }
                        etw.NpK = euk2;
                    }
                    AppMethodBeat.o(115884);
                    return 0;
                case 8:
                    etw.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(115884);
                    return 0;
                case 9:
                    etw.NbR = aVar3.UbS.zi();
                    AppMethodBeat.o(115884);
                    return 0;
                case 10:
                    etw.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115884);
                    return 0;
                case 11:
                    etw.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115884);
                    return 0;
                case 12:
                    etw.NqJ = aVar3.UbS.zi();
                    AppMethodBeat.o(115884);
                    return 0;
                case 13:
                    etw.NpN = aVar3.UbS.zl();
                    AppMethodBeat.o(115884);
                    return 0;
                case 14:
                    etw.NqX = aVar3.UbS.zi();
                    AppMethodBeat.o(115884);
                    return 0;
                case 15:
                    etw.MKg = aVar3.UbS.zi();
                    AppMethodBeat.o(115884);
                    return 0;
                case 16:
                    etw.NpO = aVar3.UbS.zi();
                    AppMethodBeat.o(115884);
                    return 0;
                case 17:
                    etw.NpP = aVar3.UbS.zi();
                    AppMethodBeat.o(115884);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        csu csu = new csu();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = csu.populateBuilderWithField(aVar8, csu, dop.getNextFieldNumber(aVar8))) {
                        }
                        etw.NpQ.add(csu);
                    }
                    AppMethodBeat.o(115884);
                    return 0;
            }
        } else {
            AppMethodBeat.o(115884);
            return -1;
        }
    }
}

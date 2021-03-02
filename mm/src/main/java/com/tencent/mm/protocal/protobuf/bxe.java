package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bxe extends dpc {
    public LinkedList<bes> KHh = new LinkedList<>();
    public LinkedList<String> McO = new LinkedList<>();
    public String McP;
    public String McQ;
    public boolean McS;
    public LinkedList<ffl> McX = new LinkedList<>();
    public LinkedList<ffm> McY = new LinkedList<>();
    public String McZ;
    public String Mda;
    public String Mdb;
    public String Mdc;
    public boolean Mdd;
    public int Mde;
    public String Mdf;
    public String ixr;
    public boolean rCK;

    public bxe() {
        AppMethodBeat.i(32282);
        AppMethodBeat.o(32282);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32283);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32283);
                throw bVar;
            } else if (this.McZ == null) {
                b bVar2 = new b("Not all required fields were included: championcoverurl");
                AppMethodBeat.o(32283);
                throw bVar2;
            } else if (this.Mda == null) {
                b bVar3 = new b("Not all required fields were included: championmotto");
                AppMethodBeat.o(32283);
                throw bVar3;
            } else if (this.ixr == null) {
                b bVar4 = new b("Not all required fields were included: rankid");
                AppMethodBeat.o(32283);
                throw bVar4;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.e(2, 8, this.McX);
                aVar.e(3, 8, this.McY);
                aVar.e(4, 1, this.McO);
                if (this.McZ != null) {
                    aVar.e(5, this.McZ);
                }
                if (this.Mda != null) {
                    aVar.e(6, this.Mda);
                }
                if (this.ixr != null) {
                    aVar.e(7, this.ixr);
                }
                if (this.Mdb != null) {
                    aVar.e(8, this.Mdb);
                }
                if (this.McP != null) {
                    aVar.e(9, this.McP);
                }
                aVar.cc(10, this.rCK);
                if (this.McQ != null) {
                    aVar.e(11, this.McQ);
                }
                aVar.e(12, 8, this.KHh);
                aVar.cc(13, this.McS);
                if (this.Mdc != null) {
                    aVar.e(14, this.Mdc);
                }
                aVar.cc(15, this.Mdd);
                aVar.aM(16, this.Mde);
                if (this.Mdf != null) {
                    aVar.e(17, this.Mdf);
                }
                AppMethodBeat.o(32283);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.McX) + g.a.a.a.c(3, 8, this.McY) + g.a.a.a.c(4, 1, this.McO);
            if (this.McZ != null) {
                nh += g.a.a.b.b.a.f(5, this.McZ);
            }
            if (this.Mda != null) {
                nh += g.a.a.b.b.a.f(6, this.Mda);
            }
            if (this.ixr != null) {
                nh += g.a.a.b.b.a.f(7, this.ixr);
            }
            if (this.Mdb != null) {
                nh += g.a.a.b.b.a.f(8, this.Mdb);
            }
            if (this.McP != null) {
                nh += g.a.a.b.b.a.f(9, this.McP);
            }
            int fS = nh + g.a.a.b.b.a.fS(10) + 1;
            if (this.McQ != null) {
                fS += g.a.a.b.b.a.f(11, this.McQ);
            }
            int c2 = fS + g.a.a.a.c(12, 8, this.KHh) + g.a.a.b.b.a.fS(13) + 1;
            if (this.Mdc != null) {
                c2 += g.a.a.b.b.a.f(14, this.Mdc);
            }
            int fS2 = c2 + g.a.a.b.b.a.fS(15) + 1 + g.a.a.b.b.a.bu(16, this.Mde);
            if (this.Mdf != null) {
                fS2 += g.a.a.b.b.a.f(17, this.Mdf);
            }
            AppMethodBeat.o(32283);
            return fS2;
        } else if (i2 == 2) {
            this.McX.clear();
            this.McY.clear();
            this.McO.clear();
            this.KHh.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar5 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32283);
                throw bVar5;
            } else if (this.McZ == null) {
                b bVar6 = new b("Not all required fields were included: championcoverurl");
                AppMethodBeat.o(32283);
                throw bVar6;
            } else if (this.Mda == null) {
                b bVar7 = new b("Not all required fields were included: championmotto");
                AppMethodBeat.o(32283);
                throw bVar7;
            } else if (this.ixr == null) {
                b bVar8 = new b("Not all required fields were included: rankid");
                AppMethodBeat.o(32283);
                throw bVar8;
            } else {
                AppMethodBeat.o(32283);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bxe bxe = (bxe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        bxe.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32283);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ffl ffl = new ffl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ffl.populateBuilderWithField(aVar5, ffl, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bxe.McX.add(ffl);
                    }
                    AppMethodBeat.o(32283);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ffm ffm = new ffm();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ffm.populateBuilderWithField(aVar6, ffm, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bxe.McY.add(ffm);
                    }
                    AppMethodBeat.o(32283);
                    return 0;
                case 4:
                    bxe.McO.add(aVar3.UbS.readString());
                    AppMethodBeat.o(32283);
                    return 0;
                case 5:
                    bxe.McZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32283);
                    return 0;
                case 6:
                    bxe.Mda = aVar3.UbS.readString();
                    AppMethodBeat.o(32283);
                    return 0;
                case 7:
                    bxe.ixr = aVar3.UbS.readString();
                    AppMethodBeat.o(32283);
                    return 0;
                case 8:
                    bxe.Mdb = aVar3.UbS.readString();
                    AppMethodBeat.o(32283);
                    return 0;
                case 9:
                    bxe.McP = aVar3.UbS.readString();
                    AppMethodBeat.o(32283);
                    return 0;
                case 10:
                    bxe.rCK = aVar3.UbS.yZ();
                    AppMethodBeat.o(32283);
                    return 0;
                case 11:
                    bxe.McQ = aVar3.UbS.readString();
                    AppMethodBeat.o(32283);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        bes bes = new bes();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bes.populateBuilderWithField(aVar7, bes, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bxe.KHh.add(bes);
                    }
                    AppMethodBeat.o(32283);
                    return 0;
                case 13:
                    bxe.McS = aVar3.UbS.yZ();
                    AppMethodBeat.o(32283);
                    return 0;
                case 14:
                    bxe.Mdc = aVar3.UbS.readString();
                    AppMethodBeat.o(32283);
                    return 0;
                case 15:
                    bxe.Mdd = aVar3.UbS.yZ();
                    AppMethodBeat.o(32283);
                    return 0;
                case 16:
                    bxe.Mde = aVar3.UbS.zi();
                    AppMethodBeat.o(32283);
                    return 0;
                case 17:
                    bxe.Mdf = aVar3.UbS.readString();
                    AppMethodBeat.o(32283);
                    return 0;
                default:
                    AppMethodBeat.o(32283);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32283);
            return -1;
        }
    }
}

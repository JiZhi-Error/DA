package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bxc extends dpc {
    public boolean ApK;
    public LinkedList<ecx> KHS = new LinkedList<>();
    public LinkedList<bes> KHh = new LinkedList<>();
    public ffn LpZ;
    public int Lqb;
    public String McL;
    public LinkedList<ffp> McM = new LinkedList<>();
    public LinkedList<ffo> McN = new LinkedList<>();
    public LinkedList<String> McO = new LinkedList<>();
    public String McP;
    public String McQ;
    public LinkedList<sg> McR = new LinkedList<>();
    public boolean McS;
    public LinkedList<ecf> McT = new LinkedList<>();
    public ffm McU;
    public String rCo;
    public String rCp;
    public boolean rCx;
    public int rJh;
    public String source;

    public bxc() {
        AppMethodBeat.i(32279);
        AppMethodBeat.o(32279);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32280);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32280);
                throw bVar;
            } else if (this.McL == null) {
                b bVar2 = new b("Not all required fields were included: coverurl");
                AppMethodBeat.o(32280);
                throw bVar2;
            } else if (this.rCp == null) {
                b bVar3 = new b("Not all required fields were included: motto");
                AppMethodBeat.o(32280);
                throw bVar3;
            } else if (this.LpZ == null) {
                b bVar4 = new b("Not all required fields were included: rankdesc");
                AppMethodBeat.o(32280);
                throw bVar4;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.McL != null) {
                    aVar.e(2, this.McL);
                }
                if (this.rCp != null) {
                    aVar.e(3, this.rCp);
                }
                if (this.LpZ != null) {
                    aVar.ni(4, this.LpZ.computeSize());
                    this.LpZ.writeFields(aVar);
                }
                aVar.e(5, 8, this.McM);
                aVar.e(6, 8, this.McN);
                if (this.source != null) {
                    aVar.e(7, this.source);
                }
                aVar.e(8, 1, this.McO);
                if (this.McP != null) {
                    aVar.e(9, this.McP);
                }
                if (this.McQ != null) {
                    aVar.e(10, this.McQ);
                }
                aVar.e(14, 8, this.KHS);
                aVar.e(15, 8, this.KHh);
                aVar.cc(16, this.rCx);
                aVar.e(17, 8, this.McR);
                aVar.cc(18, this.McS);
                aVar.aM(19, this.rJh);
                if (this.rCo != null) {
                    aVar.e(20, this.rCo);
                }
                aVar.e(21, 8, this.McT);
                aVar.aM(22, this.Lqb);
                if (this.McU != null) {
                    aVar.ni(23, this.McU.computeSize());
                    this.McU.writeFields(aVar);
                }
                aVar.cc(24, this.ApK);
                AppMethodBeat.o(32280);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.McL != null) {
                nh += g.a.a.b.b.a.f(2, this.McL);
            }
            if (this.rCp != null) {
                nh += g.a.a.b.b.a.f(3, this.rCp);
            }
            if (this.LpZ != null) {
                nh += g.a.a.a.nh(4, this.LpZ.computeSize());
            }
            int c2 = nh + g.a.a.a.c(5, 8, this.McM) + g.a.a.a.c(6, 8, this.McN);
            if (this.source != null) {
                c2 += g.a.a.b.b.a.f(7, this.source);
            }
            int c3 = c2 + g.a.a.a.c(8, 1, this.McO);
            if (this.McP != null) {
                c3 += g.a.a.b.b.a.f(9, this.McP);
            }
            if (this.McQ != null) {
                c3 += g.a.a.b.b.a.f(10, this.McQ);
            }
            int c4 = c3 + g.a.a.a.c(14, 8, this.KHS) + g.a.a.a.c(15, 8, this.KHh) + g.a.a.b.b.a.fS(16) + 1 + g.a.a.a.c(17, 8, this.McR) + g.a.a.b.b.a.fS(18) + 1 + g.a.a.b.b.a.bu(19, this.rJh);
            if (this.rCo != null) {
                c4 += g.a.a.b.b.a.f(20, this.rCo);
            }
            int c5 = c4 + g.a.a.a.c(21, 8, this.McT) + g.a.a.b.b.a.bu(22, this.Lqb);
            if (this.McU != null) {
                c5 += g.a.a.a.nh(23, this.McU.computeSize());
            }
            int fS = c5 + g.a.a.b.b.a.fS(24) + 1;
            AppMethodBeat.o(32280);
            return fS;
        } else if (i2 == 2) {
            this.McM.clear();
            this.McN.clear();
            this.McO.clear();
            this.KHS.clear();
            this.KHh.clear();
            this.McR.clear();
            this.McT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar5 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32280);
                throw bVar5;
            } else if (this.McL == null) {
                b bVar6 = new b("Not all required fields were included: coverurl");
                AppMethodBeat.o(32280);
                throw bVar6;
            } else if (this.rCp == null) {
                b bVar7 = new b("Not all required fields were included: motto");
                AppMethodBeat.o(32280);
                throw bVar7;
            } else if (this.LpZ == null) {
                b bVar8 = new b("Not all required fields were included: rankdesc");
                AppMethodBeat.o(32280);
                throw bVar8;
            } else {
                AppMethodBeat.o(32280);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bxc bxc = (bxc) objArr[1];
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
                        bxc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32280);
                    return 0;
                case 2:
                    bxc.McL = aVar3.UbS.readString();
                    AppMethodBeat.o(32280);
                    return 0;
                case 3:
                    bxc.rCp = aVar3.UbS.readString();
                    AppMethodBeat.o(32280);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ffn ffn = new ffn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ffn.populateBuilderWithField(aVar5, ffn, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bxc.LpZ = ffn;
                    }
                    AppMethodBeat.o(32280);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ffp ffp = new ffp();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ffp.populateBuilderWithField(aVar6, ffp, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bxc.McM.add(ffp);
                    }
                    AppMethodBeat.o(32280);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ffo ffo = new ffo();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ffo.populateBuilderWithField(aVar7, ffo, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bxc.McN.add(ffo);
                    }
                    AppMethodBeat.o(32280);
                    return 0;
                case 7:
                    bxc.source = aVar3.UbS.readString();
                    AppMethodBeat.o(32280);
                    return 0;
                case 8:
                    bxc.McO.add(aVar3.UbS.readString());
                    AppMethodBeat.o(32280);
                    return 0;
                case 9:
                    bxc.McP = aVar3.UbS.readString();
                    AppMethodBeat.o(32280);
                    return 0;
                case 10:
                    bxc.McQ = aVar3.UbS.readString();
                    AppMethodBeat.o(32280);
                    return 0;
                case 11:
                case 12:
                case 13:
                default:
                    AppMethodBeat.o(32280);
                    return -1;
                case 14:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ecx ecx = new ecx();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ecx.populateBuilderWithField(aVar8, ecx, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bxc.KHS.add(ecx);
                    }
                    AppMethodBeat.o(32280);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        bes bes = new bes();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = bes.populateBuilderWithField(aVar9, bes, dpc.getNextFieldNumber(aVar9))) {
                        }
                        bxc.KHh.add(bes);
                    }
                    AppMethodBeat.o(32280);
                    return 0;
                case 16:
                    bxc.rCx = aVar3.UbS.yZ();
                    AppMethodBeat.o(32280);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        sg sgVar = new sg();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = sgVar.populateBuilderWithField(aVar10, sgVar, dpc.getNextFieldNumber(aVar10))) {
                        }
                        bxc.McR.add(sgVar);
                    }
                    AppMethodBeat.o(32280);
                    return 0;
                case 18:
                    bxc.McS = aVar3.UbS.yZ();
                    AppMethodBeat.o(32280);
                    return 0;
                case 19:
                    bxc.rJh = aVar3.UbS.zi();
                    AppMethodBeat.o(32280);
                    return 0;
                case 20:
                    bxc.rCo = aVar3.UbS.readString();
                    AppMethodBeat.o(32280);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        ecf ecf = new ecf();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = ecf.populateBuilderWithField(aVar11, ecf, dpc.getNextFieldNumber(aVar11))) {
                        }
                        bxc.McT.add(ecf);
                    }
                    AppMethodBeat.o(32280);
                    return 0;
                case 22:
                    bxc.Lqb = aVar3.UbS.zi();
                    AppMethodBeat.o(32280);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        ffm ffm = new ffm();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = ffm.populateBuilderWithField(aVar12, ffm, dpc.getNextFieldNumber(aVar12))) {
                        }
                        bxc.McU = ffm;
                    }
                    AppMethodBeat.o(32280);
                    return 0;
                case 24:
                    bxc.ApK = aVar3.UbS.yZ();
                    AppMethodBeat.o(32280);
                    return 0;
            }
        } else {
            AppMethodBeat.o(32280);
            return -1;
        }
    }
}

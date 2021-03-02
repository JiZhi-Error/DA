package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ebh extends dpc {
    public int BsF;
    public int BsG;
    public long Id;
    public int Mts;
    public LinkedList<dzl> Mtt = new LinkedList<>();
    public dzl Nba;
    public String izX;
    public int oUv;

    public ebh() {
        AppMethodBeat.i(125831);
        AppMethodBeat.o(125831);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125832);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125832);
                throw bVar;
            } else if (this.Nba == null) {
                b bVar2 = new b("Not all required fields were included: BufferUrl");
                AppMethodBeat.o(125832);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.aM(2, this.BsG);
                aVar.aM(3, this.BsF);
                if (this.izX != null) {
                    aVar.e(4, this.izX);
                }
                if (this.Nba != null) {
                    aVar.ni(5, this.Nba.computeSize());
                    this.Nba.writeFields(aVar);
                }
                aVar.aM(6, this.Mts);
                aVar.e(7, 8, this.Mtt);
                aVar.bb(8, this.Id);
                aVar.aM(9, this.oUv);
                AppMethodBeat.o(125832);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.BsG) + g.a.a.b.b.a.bu(3, this.BsF);
            if (this.izX != null) {
                nh += g.a.a.b.b.a.f(4, this.izX);
            }
            if (this.Nba != null) {
                nh += g.a.a.a.nh(5, this.Nba.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.Mts) + g.a.a.a.c(7, 8, this.Mtt) + g.a.a.b.b.a.r(8, this.Id) + g.a.a.b.b.a.bu(9, this.oUv);
            AppMethodBeat.o(125832);
            return bu;
        } else if (i2 == 2) {
            this.Mtt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125832);
                throw bVar3;
            } else if (this.Nba == null) {
                b bVar4 = new b("Not all required fields were included: BufferUrl");
                AppMethodBeat.o(125832);
                throw bVar4;
            } else {
                AppMethodBeat.o(125832);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebh ebh = (ebh) objArr[1];
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
                        ebh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(125832);
                    return 0;
                case 2:
                    ebh.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(125832);
                    return 0;
                case 3:
                    ebh.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(125832);
                    return 0;
                case 4:
                    ebh.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(125832);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dzl dzl = new dzl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dzl.populateBuilderWithField(aVar5, dzl, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ebh.Nba = dzl;
                    }
                    AppMethodBeat.o(125832);
                    return 0;
                case 6:
                    ebh.Mts = aVar3.UbS.zi();
                    AppMethodBeat.o(125832);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dzl dzl2 = new dzl();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dzl2.populateBuilderWithField(aVar6, dzl2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ebh.Mtt.add(dzl2);
                    }
                    AppMethodBeat.o(125832);
                    return 0;
                case 8:
                    ebh.Id = aVar3.UbS.zl();
                    AppMethodBeat.o(125832);
                    return 0;
                case 9:
                    ebh.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(125832);
                    return 0;
                default:
                    AppMethodBeat.o(125832);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125832);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bhh extends dpc {
    public int KOL;
    public LinkedList<b> LRg = new LinkedList<>();
    public LinkedList<Integer> LRr = new LinkedList<>();
    public LinkedList<bhg> LRs = new LinkedList<>();
    public LinkedList<bhb> LRt = new LinkedList<>();

    public bhh() {
        AppMethodBeat.i(152550);
        AppMethodBeat.o(152550);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152551);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152551);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.KOL);
            aVar.e(3, 2, this.LRr);
            aVar.e(4, 8, this.LRs);
            aVar.e(5, 8, this.LRt);
            aVar.e(7, 6, this.LRg);
            AppMethodBeat.o(152551);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KOL) + g.a.a.a.c(3, 2, this.LRr) + g.a.a.a.c(4, 8, this.LRs) + g.a.a.a.c(5, 8, this.LRt) + g.a.a.a.c(7, 6, this.LRg);
            AppMethodBeat.o(152551);
            return nh;
        } else if (i2 == 2) {
            this.LRr.clear();
            this.LRs.clear();
            this.LRt.clear();
            this.LRg.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152551);
                throw bVar2;
            }
            AppMethodBeat.o(152551);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhh bhh = (bhh) objArr[1];
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
                        bhh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152551);
                    return 0;
                case 2:
                    bhh.KOL = aVar3.UbS.zi();
                    AppMethodBeat.o(152551);
                    return 0;
                case 3:
                    bhh.LRr.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(152551);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bhg bhg = new bhg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bhg.populateBuilderWithField(aVar5, bhg, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bhh.LRs.add(bhg);
                    }
                    AppMethodBeat.o(152551);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bhb bhb = new bhb();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bhb.populateBuilderWithField(aVar6, bhb, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bhh.LRt.add(bhb);
                    }
                    AppMethodBeat.o(152551);
                    return 0;
                case 6:
                default:
                    AppMethodBeat.o(152551);
                    return -1;
                case 7:
                    bhh.LRg.add(aVar3.UbS.hPo());
                    AppMethodBeat.o(152551);
                    return 0;
            }
        } else {
            AppMethodBeat.o(152551);
            return -1;
        }
    }
}

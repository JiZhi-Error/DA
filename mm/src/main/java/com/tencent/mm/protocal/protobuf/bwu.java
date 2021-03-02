package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bwu extends dpc {
    public eoo Lqs;
    public LinkedList<eom> McA = new LinkedList<>();
    public int McB;
    public b Mcz;

    public bwu() {
        AppMethodBeat.i(74662);
        AppMethodBeat.o(74662);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(74663);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(74663);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Lqs != null) {
                aVar.ni(2, this.Lqs.computeSize());
                this.Lqs.writeFields(aVar);
            }
            aVar.e(3, 8, this.McA);
            if (this.Mcz != null) {
                aVar.c(4, this.Mcz);
            }
            aVar.aM(5, this.McB);
            AppMethodBeat.o(74663);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Lqs != null) {
                nh += g.a.a.a.nh(2, this.Lqs.computeSize());
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.McA);
            if (this.Mcz != null) {
                c2 += g.a.a.b.b.a.b(4, this.Mcz);
            }
            int bu = c2 + g.a.a.b.b.a.bu(5, this.McB);
            AppMethodBeat.o(74663);
            return bu;
        } else if (i2 == 2) {
            this.McA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(74663);
                throw bVar2;
            }
            AppMethodBeat.o(74663);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bwu bwu = (bwu) objArr[1];
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
                        bwu.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(74663);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eoo eoo = new eoo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eoo.populateBuilderWithField(aVar5, eoo, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bwu.Lqs = eoo;
                    }
                    AppMethodBeat.o(74663);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eom eom = new eom();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eom.populateBuilderWithField(aVar6, eom, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bwu.McA.add(eom);
                    }
                    AppMethodBeat.o(74663);
                    return 0;
                case 4:
                    bwu.Mcz = aVar3.UbS.hPo();
                    AppMethodBeat.o(74663);
                    return 0;
                case 5:
                    bwu.McB = aVar3.UbS.zi();
                    AppMethodBeat.o(74663);
                    return 0;
                default:
                    AppMethodBeat.o(74663);
                    return -1;
            }
        } else {
            AppMethodBeat.o(74663);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ary extends dpc {
    public long Gcy;
    public LinkedList<FinderContact> LCI = new LinkedList<>();
    public LinkedList<aqr> LDp = new LinkedList<>();
    public int continueFlag;
    public b tVM;

    public ary() {
        AppMethodBeat.i(168977);
        AppMethodBeat.o(168977);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168978);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.LCI);
            aVar.aM(3, this.continueFlag);
            aVar.bb(4, this.Gcy);
            if (this.tVM != null) {
                aVar.c(5, this.tVM);
            }
            aVar.e(6, 8, this.LDp);
            AppMethodBeat.o(168978);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LCI) + g.a.a.b.b.a.bu(3, this.continueFlag) + g.a.a.b.b.a.r(4, this.Gcy);
            if (this.tVM != null) {
                nh += g.a.a.b.b.a.b(5, this.tVM);
            }
            int c2 = nh + g.a.a.a.c(6, 8, this.LDp);
            AppMethodBeat.o(168978);
            return c2;
        } else if (i2 == 2) {
            this.LCI.clear();
            this.LDp.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168978);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ary ary = (ary) objArr[1];
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
                        ary.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(168978);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderContact.populateBuilderWithField(aVar5, finderContact, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ary.LCI.add(finderContact);
                    }
                    AppMethodBeat.o(168978);
                    return 0;
                case 3:
                    ary.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168978);
                    return 0;
                case 4:
                    ary.Gcy = aVar3.UbS.zl();
                    AppMethodBeat.o(168978);
                    return 0;
                case 5:
                    ary.tVM = aVar3.UbS.hPo();
                    AppMethodBeat.o(168978);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aqr aqr = new aqr();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aqr.populateBuilderWithField(aVar6, aqr, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ary.LDp.add(aqr);
                    }
                    AppMethodBeat.o(168978);
                    return 0;
                default:
                    AppMethodBeat.o(168978);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168978);
            return -1;
        }
    }
}

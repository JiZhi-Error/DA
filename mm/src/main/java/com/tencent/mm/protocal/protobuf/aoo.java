package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aoo extends dpc {
    public FinderContact LAJ;
    public String LAK;
    public cxs entranceInfo;
    public String nbg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209329);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LAJ != null) {
                aVar.ni(2, this.LAJ.computeSize());
                this.LAJ.writeFields(aVar);
            }
            if (this.nbg != null) {
                aVar.e(3, this.nbg);
            }
            if (this.LAK != null) {
                aVar.e(4, this.LAK);
            }
            if (this.entranceInfo != null) {
                aVar.ni(5, this.entranceInfo.computeSize());
                this.entranceInfo.writeFields(aVar);
            }
            AppMethodBeat.o(209329);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LAJ != null) {
                nh += g.a.a.a.nh(2, this.LAJ.computeSize());
            }
            if (this.nbg != null) {
                nh += g.a.a.b.b.a.f(3, this.nbg);
            }
            if (this.LAK != null) {
                nh += g.a.a.b.b.a.f(4, this.LAK);
            }
            if (this.entranceInfo != null) {
                nh += g.a.a.a.nh(5, this.entranceInfo.computeSize());
            }
            AppMethodBeat.o(209329);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209329);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aoo aoo = (aoo) objArr[1];
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
                        aoo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209329);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderContact.populateBuilderWithField(aVar5, finderContact, dpc.getNextFieldNumber(aVar5))) {
                        }
                        aoo.LAJ = finderContact;
                    }
                    AppMethodBeat.o(209329);
                    return 0;
                case 3:
                    aoo.nbg = aVar3.UbS.readString();
                    AppMethodBeat.o(209329);
                    return 0;
                case 4:
                    aoo.LAK = aVar3.UbS.readString();
                    AppMethodBeat.o(209329);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cxs cxs = new cxs();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cxs.populateBuilderWithField(aVar6, cxs, dpc.getNextFieldNumber(aVar6))) {
                        }
                        aoo.entranceInfo = cxs;
                    }
                    AppMethodBeat.o(209329);
                    return 0;
                default:
                    AppMethodBeat.o(209329);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209329);
            return -1;
        }
    }
}
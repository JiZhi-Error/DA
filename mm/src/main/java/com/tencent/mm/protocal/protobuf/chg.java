package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class chg extends dpc {
    public ys MmA;
    public fbo MmG;
    public fbq MmH;
    public ffb MmI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123627);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123627);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MmG != null) {
                aVar.ni(2, this.MmG.computeSize());
                this.MmG.writeFields(aVar);
            }
            if (this.MmA != null) {
                aVar.ni(3, this.MmA.computeSize());
                this.MmA.writeFields(aVar);
            }
            if (this.MmH != null) {
                aVar.ni(4, this.MmH.computeSize());
                this.MmH.writeFields(aVar);
            }
            if (this.MmI != null) {
                aVar.ni(5, this.MmI.computeSize());
                this.MmI.writeFields(aVar);
            }
            AppMethodBeat.o(123627);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MmG != null) {
                nh += g.a.a.a.nh(2, this.MmG.computeSize());
            }
            if (this.MmA != null) {
                nh += g.a.a.a.nh(3, this.MmA.computeSize());
            }
            if (this.MmH != null) {
                nh += g.a.a.a.nh(4, this.MmH.computeSize());
            }
            if (this.MmI != null) {
                nh += g.a.a.a.nh(5, this.MmI.computeSize());
            }
            AppMethodBeat.o(123627);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123627);
                throw bVar2;
            }
            AppMethodBeat.o(123627);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            chg chg = (chg) objArr[1];
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
                        chg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(123627);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fbo fbo = new fbo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fbo.populateBuilderWithField(aVar5, fbo, dpc.getNextFieldNumber(aVar5))) {
                        }
                        chg.MmG = fbo;
                    }
                    AppMethodBeat.o(123627);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ys ysVar = new ys();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ysVar.populateBuilderWithField(aVar6, ysVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        chg.MmA = ysVar;
                    }
                    AppMethodBeat.o(123627);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fbq fbq = new fbq();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fbq.populateBuilderWithField(aVar7, fbq, dpc.getNextFieldNumber(aVar7))) {
                        }
                        chg.MmH = fbq;
                    }
                    AppMethodBeat.o(123627);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ffb ffb = new ffb();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ffb.populateBuilderWithField(aVar8, ffb, dpc.getNextFieldNumber(aVar8))) {
                        }
                        chg.MmI = ffb;
                    }
                    AppMethodBeat.o(123627);
                    return 0;
                default:
                    AppMethodBeat.o(123627);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123627);
            return -1;
        }
    }
}

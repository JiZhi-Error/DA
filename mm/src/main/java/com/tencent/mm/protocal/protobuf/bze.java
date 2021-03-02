package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bze extends dpc {
    public fdm MeN;
    public fdn MeO;
    public fdk MeP;
    public ffc MeQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50093);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(50093);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MeN != null) {
                aVar.ni(2, this.MeN.computeSize());
                this.MeN.writeFields(aVar);
            }
            if (this.MeO != null) {
                aVar.ni(3, this.MeO.computeSize());
                this.MeO.writeFields(aVar);
            }
            if (this.MeP != null) {
                aVar.ni(4, this.MeP.computeSize());
                this.MeP.writeFields(aVar);
            }
            if (this.MeQ != null) {
                aVar.ni(5, this.MeQ.computeSize());
                this.MeQ.writeFields(aVar);
            }
            AppMethodBeat.o(50093);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MeN != null) {
                nh += g.a.a.a.nh(2, this.MeN.computeSize());
            }
            if (this.MeO != null) {
                nh += g.a.a.a.nh(3, this.MeO.computeSize());
            }
            if (this.MeP != null) {
                nh += g.a.a.a.nh(4, this.MeP.computeSize());
            }
            if (this.MeQ != null) {
                nh += g.a.a.a.nh(5, this.MeQ.computeSize());
            }
            AppMethodBeat.o(50093);
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
                AppMethodBeat.o(50093);
                throw bVar2;
            }
            AppMethodBeat.o(50093);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bze bze = (bze) objArr[1];
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
                        bze.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(50093);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fdm fdm = new fdm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fdm.populateBuilderWithField(aVar5, fdm, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bze.MeN = fdm;
                    }
                    AppMethodBeat.o(50093);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fdn fdn = new fdn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fdn.populateBuilderWithField(aVar6, fdn, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bze.MeO = fdn;
                    }
                    AppMethodBeat.o(50093);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fdk fdk = new fdk();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fdk.populateBuilderWithField(aVar7, fdk, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bze.MeP = fdk;
                    }
                    AppMethodBeat.o(50093);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ffc ffc = new ffc();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ffc.populateBuilderWithField(aVar8, ffc, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bze.MeQ = ffc;
                    }
                    AppMethodBeat.o(50093);
                    return 0;
                default:
                    AppMethodBeat.o(50093);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50093);
            return -1;
        }
    }
}

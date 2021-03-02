package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ais extends dpc {
    public String Bri;
    public dyh KLj;
    public ccb KQj;
    public qy KQk;
    public ctb KQl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155403);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(155403);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Bri != null) {
                aVar.e(2, this.Bri);
            }
            if (this.KQk != null) {
                aVar.ni(3, this.KQk.computeSize());
                this.KQk.writeFields(aVar);
            }
            if (this.KQj != null) {
                aVar.ni(4, this.KQj.computeSize());
                this.KQj.writeFields(aVar);
            }
            if (this.KLj != null) {
                aVar.ni(5, this.KLj.computeSize());
                this.KLj.writeFields(aVar);
            }
            if (this.KQl != null) {
                aVar.ni(6, this.KQl.computeSize());
                this.KQl.writeFields(aVar);
            }
            AppMethodBeat.o(155403);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Bri != null) {
                nh += g.a.a.b.b.a.f(2, this.Bri);
            }
            if (this.KQk != null) {
                nh += g.a.a.a.nh(3, this.KQk.computeSize());
            }
            if (this.KQj != null) {
                nh += g.a.a.a.nh(4, this.KQj.computeSize());
            }
            if (this.KLj != null) {
                nh += g.a.a.a.nh(5, this.KLj.computeSize());
            }
            if (this.KQl != null) {
                nh += g.a.a.a.nh(6, this.KQl.computeSize());
            }
            AppMethodBeat.o(155403);
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
                AppMethodBeat.o(155403);
                throw bVar2;
            }
            AppMethodBeat.o(155403);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ais ais = (ais) objArr[1];
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
                        ais.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(155403);
                    return 0;
                case 2:
                    ais.Bri = aVar3.UbS.readString();
                    AppMethodBeat.o(155403);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        qy qyVar = new qy();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = qyVar.populateBuilderWithField(aVar5, qyVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ais.KQk = qyVar;
                    }
                    AppMethodBeat.o(155403);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ccb ccb = new ccb();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ccb.populateBuilderWithField(aVar6, ccb, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ais.KQj = ccb;
                    }
                    AppMethodBeat.o(155403);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dyh dyh = new dyh();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dyh.populateBuilderWithField(aVar7, dyh, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ais.KLj = dyh;
                    }
                    AppMethodBeat.o(155403);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ctb ctb = new ctb();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ctb.populateBuilderWithField(aVar8, ctb, dpc.getNextFieldNumber(aVar8))) {
                        }
                        ais.KQl = ctb;
                    }
                    AppMethodBeat.o(155403);
                    return 0;
                default:
                    AppMethodBeat.o(155403);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155403);
            return -1;
        }
    }
}

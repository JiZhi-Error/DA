package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cei extends dpc {
    public epn MjT;
    public cdz Mjz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82443);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(82443);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Mjz != null) {
                aVar.ni(2, this.Mjz.computeSize());
                this.Mjz.writeFields(aVar);
            }
            if (this.MjT != null) {
                aVar.ni(3, this.MjT.computeSize());
                this.MjT.writeFields(aVar);
            }
            AppMethodBeat.o(82443);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Mjz != null) {
                nh += g.a.a.a.nh(2, this.Mjz.computeSize());
            }
            if (this.MjT != null) {
                nh += g.a.a.a.nh(3, this.MjT.computeSize());
            }
            AppMethodBeat.o(82443);
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
                AppMethodBeat.o(82443);
                throw bVar2;
            }
            AppMethodBeat.o(82443);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cei cei = (cei) objArr[1];
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
                        cei.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(82443);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cdz cdz = new cdz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cdz.populateBuilderWithField(aVar5, cdz, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cei.Mjz = cdz;
                    }
                    AppMethodBeat.o(82443);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        epn epn = new epn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = epn.populateBuilderWithField(aVar6, epn, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cei.MjT = epn;
                    }
                    AppMethodBeat.o(82443);
                    return 0;
                default:
                    AppMethodBeat.o(82443);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82443);
            return -1;
        }
    }
}
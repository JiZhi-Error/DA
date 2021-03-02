package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class btd extends dpc {
    public cqm LZN;
    public eos LZO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(134246);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(134246);
                throw bVar;
            } else if (this.LZN == null) {
                b bVar2 = new b("Not all required fields were included: UserInfo");
                AppMethodBeat.o(134246);
                throw bVar2;
            } else if (this.LZO == null) {
                b bVar3 = new b("Not all required fields were included: UserInfoExt");
                AppMethodBeat.o(134246);
                throw bVar3;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.LZN != null) {
                    aVar.ni(2, this.LZN.computeSize());
                    this.LZN.writeFields(aVar);
                }
                if (this.LZO != null) {
                    aVar.ni(3, this.LZO.computeSize());
                    this.LZO.writeFields(aVar);
                }
                AppMethodBeat.o(134246);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LZN != null) {
                nh += g.a.a.a.nh(2, this.LZN.computeSize());
            }
            if (this.LZO != null) {
                nh += g.a.a.a.nh(3, this.LZO.computeSize());
            }
            AppMethodBeat.o(134246);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar4 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(134246);
                throw bVar4;
            } else if (this.LZN == null) {
                b bVar5 = new b("Not all required fields were included: UserInfo");
                AppMethodBeat.o(134246);
                throw bVar5;
            } else if (this.LZO == null) {
                b bVar6 = new b("Not all required fields were included: UserInfoExt");
                AppMethodBeat.o(134246);
                throw bVar6;
            } else {
                AppMethodBeat.o(134246);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            btd btd = (btd) objArr[1];
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
                        btd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(134246);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cqm cqm = new cqm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cqm.populateBuilderWithField(aVar5, cqm, dpc.getNextFieldNumber(aVar5))) {
                        }
                        btd.LZN = cqm;
                    }
                    AppMethodBeat.o(134246);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eos eos = new eos();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eos.populateBuilderWithField(aVar6, eos, dpc.getNextFieldNumber(aVar6))) {
                        }
                        btd.LZO = eos;
                    }
                    AppMethodBeat.o(134246);
                    return 0;
                default:
                    AppMethodBeat.o(134246);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134246);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class fcf extends dpc {
    public eow Nyd;
    public LinkedList<hj> Nye = new LinkedList<>();

    public fcf() {
        AppMethodBeat.i(147821);
        AppMethodBeat.o(147821);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147822);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(147822);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Nyd != null) {
                aVar.ni(2, this.Nyd.computeSize());
                this.Nyd.writeFields(aVar);
            }
            aVar.e(3, 8, this.Nye);
            AppMethodBeat.o(147822);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Nyd != null) {
                nh += g.a.a.a.nh(2, this.Nyd.computeSize());
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.Nye);
            AppMethodBeat.o(147822);
            return c2;
        } else if (i2 == 2) {
            this.Nye.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(147822);
                throw bVar2;
            }
            AppMethodBeat.o(147822);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fcf fcf = (fcf) objArr[1];
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
                        fcf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(147822);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eow eow = new eow();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eow.populateBuilderWithField(aVar5, eow, dpc.getNextFieldNumber(aVar5))) {
                        }
                        fcf.Nyd = eow;
                    }
                    AppMethodBeat.o(147822);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        hj hjVar = new hj();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = hjVar.populateBuilderWithField(aVar6, hjVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        fcf.Nye.add(hjVar);
                    }
                    AppMethodBeat.o(147822);
                    return 0;
                default:
                    AppMethodBeat.o(147822);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147822);
            return -1;
        }
    }
}

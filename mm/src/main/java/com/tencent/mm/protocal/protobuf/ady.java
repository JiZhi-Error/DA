package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ady extends dpc {
    public String HQv;
    public LinkedList<tx> Lps = new LinkedList<>();
    public int Lpt;
    public int Lpu;
    public int version;

    public ady() {
        AppMethodBeat.i(32177);
        AppMethodBeat.o(32177);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32178);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32178);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.Lps);
            aVar.aM(3, this.version);
            aVar.aM(4, this.Lpt);
            aVar.aM(5, this.Lpu);
            if (this.HQv != null) {
                aVar.e(6, this.HQv);
            }
            AppMethodBeat.o(32178);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Lps) + g.a.a.b.b.a.bu(3, this.version) + g.a.a.b.b.a.bu(4, this.Lpt) + g.a.a.b.b.a.bu(5, this.Lpu);
            if (this.HQv != null) {
                nh += g.a.a.b.b.a.f(6, this.HQv);
            }
            AppMethodBeat.o(32178);
            return nh;
        } else if (i2 == 2) {
            this.Lps.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32178);
                throw bVar2;
            }
            AppMethodBeat.o(32178);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ady ady = (ady) objArr[1];
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
                        ady.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32178);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        tx txVar = new tx();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = txVar.populateBuilderWithField(aVar5, txVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ady.Lps.add(txVar);
                    }
                    AppMethodBeat.o(32178);
                    return 0;
                case 3:
                    ady.version = aVar3.UbS.zi();
                    AppMethodBeat.o(32178);
                    return 0;
                case 4:
                    ady.Lpt = aVar3.UbS.zi();
                    AppMethodBeat.o(32178);
                    return 0;
                case 5:
                    ady.Lpu = aVar3.UbS.zi();
                    AppMethodBeat.o(32178);
                    return 0;
                case 6:
                    ady.HQv = aVar3.UbS.readString();
                    AppMethodBeat.o(32178);
                    return 0;
                default:
                    AppMethodBeat.o(32178);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32178);
            return -1;
        }
    }
}

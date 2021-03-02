package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class bub extends dpc {
    public b Buffer;
    public LinkedList<dkr> MaI = new LinkedList<>();
    public dku MaJ;
    public String MaK;

    public bub() {
        AppMethodBeat.i(212278);
        AppMethodBeat.o(212278);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212279);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(212279);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.MaI);
            if (this.MaJ != null) {
                aVar.ni(3, this.MaJ.computeSize());
                this.MaJ.writeFields(aVar);
            }
            if (this.MaK != null) {
                aVar.e(4, this.MaK);
            }
            if (this.Buffer != null) {
                aVar.c(5, this.Buffer);
            }
            AppMethodBeat.o(212279);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.MaI);
            if (this.MaJ != null) {
                nh += g.a.a.a.nh(3, this.MaJ.computeSize());
            }
            if (this.MaK != null) {
                nh += g.a.a.b.b.a.f(4, this.MaK);
            }
            if (this.Buffer != null) {
                nh += g.a.a.b.b.a.b(5, this.Buffer);
            }
            AppMethodBeat.o(212279);
            return nh;
        } else if (i2 == 2) {
            this.MaI.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(212279);
                throw bVar2;
            }
            AppMethodBeat.o(212279);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bub bub = (bub) objArr[1];
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
                        bub.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(212279);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dkr dkr = new dkr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dkr.populateBuilderWithField(aVar5, dkr, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bub.MaI.add(dkr);
                    }
                    AppMethodBeat.o(212279);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dku dku = new dku();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dku.populateBuilderWithField(aVar6, dku, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bub.MaJ = dku;
                    }
                    AppMethodBeat.o(212279);
                    return 0;
                case 4:
                    bub.MaK = aVar3.UbS.readString();
                    AppMethodBeat.o(212279);
                    return 0;
                case 5:
                    bub.Buffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(212279);
                    return 0;
                default:
                    AppMethodBeat.o(212279);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212279);
            return -1;
        }
    }
}

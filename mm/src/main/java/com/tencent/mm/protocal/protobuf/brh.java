package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class brh extends dpc {
    public int KHa;
    public int LYJ;
    public LinkedList<cva> LYK = new LinkedList<>();
    public String LYL;
    public int LYM;

    public brh() {
        AppMethodBeat.i(32254);
        AppMethodBeat.o(32254);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32255);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32255);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LYJ);
            aVar.e(3, 8, this.LYK);
            if (this.LYL != null) {
                aVar.e(4, this.LYL);
            }
            aVar.aM(5, this.KHa);
            aVar.aM(6, this.LYM);
            AppMethodBeat.o(32255);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LYJ) + g.a.a.a.c(3, 8, this.LYK);
            if (this.LYL != null) {
                nh += g.a.a.b.b.a.f(4, this.LYL);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KHa) + g.a.a.b.b.a.bu(6, this.LYM);
            AppMethodBeat.o(32255);
            return bu;
        } else if (i2 == 2) {
            this.LYK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32255);
                throw bVar2;
            }
            AppMethodBeat.o(32255);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            brh brh = (brh) objArr[1];
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
                        brh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32255);
                    return 0;
                case 2:
                    brh.LYJ = aVar3.UbS.zi();
                    AppMethodBeat.o(32255);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cva cva = new cva();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cva.populateBuilderWithField(aVar5, cva, dpc.getNextFieldNumber(aVar5))) {
                        }
                        brh.LYK.add(cva);
                    }
                    AppMethodBeat.o(32255);
                    return 0;
                case 4:
                    brh.LYL = aVar3.UbS.readString();
                    AppMethodBeat.o(32255);
                    return 0;
                case 5:
                    brh.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(32255);
                    return 0;
                case 6:
                    brh.LYM = aVar3.UbS.zi();
                    AppMethodBeat.o(32255);
                    return 0;
                default:
                    AppMethodBeat.o(32255);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32255);
            return -1;
        }
    }
}

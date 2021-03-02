package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eai extends dpc {
    public int MZB;
    public LinkedList<Integer> MZD = new LinkedList<>();
    public int MZE;
    public int MZF;
    public LinkedList<ebo> MZG = new LinkedList<>();

    public eai() {
        AppMethodBeat.i(125800);
        AppMethodBeat.o(125800);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125801);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125801);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.MZB);
            aVar.f(3, 2, this.MZD);
            aVar.aM(4, this.MZE);
            aVar.aM(5, this.MZF);
            aVar.e(6, 8, this.MZG);
            AppMethodBeat.o(125801);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MZB) + g.a.a.a.d(3, 2, this.MZD) + g.a.a.b.b.a.bu(4, this.MZE) + g.a.a.b.b.a.bu(5, this.MZF) + g.a.a.a.c(6, 8, this.MZG);
            AppMethodBeat.o(125801);
            return nh;
        } else if (i2 == 2) {
            this.MZD.clear();
            this.MZG.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125801);
                throw bVar2;
            }
            AppMethodBeat.o(125801);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eai eai = (eai) objArr[1];
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
                        eai.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(125801);
                    return 0;
                case 2:
                    eai.MZB = aVar3.UbS.zi();
                    AppMethodBeat.o(125801);
                    return 0;
                case 3:
                    eai.MZD = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(125801);
                    return 0;
                case 4:
                    eai.MZE = aVar3.UbS.zi();
                    AppMethodBeat.o(125801);
                    return 0;
                case 5:
                    eai.MZF = aVar3.UbS.zi();
                    AppMethodBeat.o(125801);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ebo ebo = new ebo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ebo.populateBuilderWithField(aVar5, ebo, dpc.getNextFieldNumber(aVar5))) {
                        }
                        eai.MZG.add(ebo);
                    }
                    AppMethodBeat.o(125801);
                    return 0;
                default:
                    AppMethodBeat.o(125801);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125801);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bnb extends dpc {
    public int KHa;
    public String LVF;
    public int LVG;
    public int LVH;
    public LinkedList<Integer> LVI = new LinkedList<>();
    public LinkedList<akh> LVJ = new LinkedList<>();
    public int LVK;

    public bnb() {
        AppMethodBeat.i(220704);
        AppMethodBeat.o(220704);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220705);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(220705);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LVG);
            aVar.aM(3, this.LVH);
            aVar.aM(4, this.KHa);
            aVar.e(5, 2, this.LVI);
            aVar.e(6, 8, this.LVJ);
            aVar.aM(7, this.LVK);
            if (this.LVF != null) {
                aVar.e(8, this.LVF);
            }
            AppMethodBeat.o(220705);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LVG) + g.a.a.b.b.a.bu(3, this.LVH) + g.a.a.b.b.a.bu(4, this.KHa) + g.a.a.a.c(5, 2, this.LVI) + g.a.a.a.c(6, 8, this.LVJ) + g.a.a.b.b.a.bu(7, this.LVK);
            if (this.LVF != null) {
                nh += g.a.a.b.b.a.f(8, this.LVF);
            }
            AppMethodBeat.o(220705);
            return nh;
        } else if (i2 == 2) {
            this.LVI.clear();
            this.LVJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(220705);
                throw bVar2;
            }
            AppMethodBeat.o(220705);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bnb bnb = (bnb) objArr[1];
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
                        bnb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(220705);
                    return 0;
                case 2:
                    bnb.LVG = aVar3.UbS.zi();
                    AppMethodBeat.o(220705);
                    return 0;
                case 3:
                    bnb.LVH = aVar3.UbS.zi();
                    AppMethodBeat.o(220705);
                    return 0;
                case 4:
                    bnb.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(220705);
                    return 0;
                case 5:
                    bnb.LVI.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(220705);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        akh akh = new akh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = akh.populateBuilderWithField(aVar5, akh, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bnb.LVJ.add(akh);
                    }
                    AppMethodBeat.o(220705);
                    return 0;
                case 7:
                    bnb.LVK = aVar3.UbS.zi();
                    AppMethodBeat.o(220705);
                    return 0;
                case 8:
                    bnb.LVF = aVar3.UbS.readString();
                    AppMethodBeat.o(220705);
                    return 0;
                default:
                    AppMethodBeat.o(220705);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220705);
            return -1;
        }
    }
}

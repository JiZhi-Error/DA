package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cim extends dpc {
    public String Bri;
    public LinkedList<cik> MnA = new LinkedList<>();
    public int Mnv;
    public int Mnx;
    public LinkedList<cik> Mnz = new LinkedList<>();

    public cim() {
        AppMethodBeat.i(155436);
        AppMethodBeat.o(155436);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155437);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(155437);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Bri != null) {
                aVar.e(2, this.Bri);
            }
            aVar.aM(3, this.Mnv);
            aVar.e(4, 8, this.Mnz);
            aVar.aM(5, this.Mnx);
            aVar.e(6, 8, this.MnA);
            AppMethodBeat.o(155437);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Bri != null) {
                nh += g.a.a.b.b.a.f(2, this.Bri);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.Mnv) + g.a.a.a.c(4, 8, this.Mnz) + g.a.a.b.b.a.bu(5, this.Mnx) + g.a.a.a.c(6, 8, this.MnA);
            AppMethodBeat.o(155437);
            return bu;
        } else if (i2 == 2) {
            this.Mnz.clear();
            this.MnA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(155437);
                throw bVar2;
            }
            AppMethodBeat.o(155437);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cim cim = (cim) objArr[1];
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
                        cim.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(155437);
                    return 0;
                case 2:
                    cim.Bri = aVar3.UbS.readString();
                    AppMethodBeat.o(155437);
                    return 0;
                case 3:
                    cim.Mnv = aVar3.UbS.zi();
                    AppMethodBeat.o(155437);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cik cik = new cik();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cik.populateBuilderWithField(aVar5, cik, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cim.Mnz.add(cik);
                    }
                    AppMethodBeat.o(155437);
                    return 0;
                case 5:
                    cim.Mnx = aVar3.UbS.zi();
                    AppMethodBeat.o(155437);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cik cik2 = new cik();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cik2.populateBuilderWithField(aVar6, cik2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cim.MnA.add(cik2);
                    }
                    AppMethodBeat.o(155437);
                    return 0;
                default:
                    AppMethodBeat.o(155437);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155437);
            return -1;
        }
    }
}

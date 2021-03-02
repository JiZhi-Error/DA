package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dif extends dpc {
    public String KKG;
    public LinkedList<ekl> MMM = new LinkedList<>();
    public LinkedList<ekl> MMN = new LinkedList<>();
    public int dDN;
    public String qwn;

    public dif() {
        AppMethodBeat.i(72572);
        AppMethodBeat.o(72572);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72573);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72573);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.dDN);
            if (this.qwn != null) {
                aVar.e(3, this.qwn);
            }
            aVar.e(4, 8, this.MMM);
            aVar.e(5, 8, this.MMN);
            if (this.KKG != null) {
                aVar.e(6, this.KKG);
            }
            AppMethodBeat.o(72573);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.MMM) + g.a.a.a.c(5, 8, this.MMN);
            if (this.KKG != null) {
                c2 += g.a.a.b.b.a.f(6, this.KKG);
            }
            AppMethodBeat.o(72573);
            return c2;
        } else if (i2 == 2) {
            this.MMM.clear();
            this.MMN.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72573);
                throw bVar2;
            }
            AppMethodBeat.o(72573);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dif dif = (dif) objArr[1];
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
                        dif.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72573);
                    return 0;
                case 2:
                    dif.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(72573);
                    return 0;
                case 3:
                    dif.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(72573);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ekl ekl = new ekl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ekl.populateBuilderWithField(aVar5, ekl, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dif.MMM.add(ekl);
                    }
                    AppMethodBeat.o(72573);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ekl ekl2 = new ekl();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ekl2.populateBuilderWithField(aVar6, ekl2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dif.MMN.add(ekl2);
                    }
                    AppMethodBeat.o(72573);
                    return 0;
                case 6:
                    dif.KKG = aVar3.UbS.readString();
                    AppMethodBeat.o(72573);
                    return 0;
                default:
                    AppMethodBeat.o(72573);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72573);
            return -1;
        }
    }
}

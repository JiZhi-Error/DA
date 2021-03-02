package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bwe extends dpc {
    public boolean Mca = false;
    public int Mcb;
    public int Mcc;
    public aib Mcd;
    public aib Mce;
    public String Mcf;
    public String iwv;
    public String iww;
    public String title;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200206);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(200206);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.cc(2, this.Mca);
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.iwv != null) {
                aVar.e(4, this.iwv);
            }
            if (this.iww != null) {
                aVar.e(5, this.iww);
            }
            if (this.url != null) {
                aVar.e(6, this.url);
            }
            aVar.aM(7, this.Mcb);
            aVar.aM(8, this.Mcc);
            if (this.Mcd != null) {
                aVar.ni(9, this.Mcd.computeSize());
                this.Mcd.writeFields(aVar);
            }
            if (this.Mce != null) {
                aVar.ni(10, this.Mce.computeSize());
                this.Mce.writeFields(aVar);
            }
            if (this.Mcf != null) {
                aVar.e(11, this.Mcf);
            }
            AppMethodBeat.o(200206);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1;
            if (this.title != null) {
                nh += g.a.a.b.b.a.f(3, this.title);
            }
            if (this.iwv != null) {
                nh += g.a.a.b.b.a.f(4, this.iwv);
            }
            if (this.iww != null) {
                nh += g.a.a.b.b.a.f(5, this.iww);
            }
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(6, this.url);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.Mcb) + g.a.a.b.b.a.bu(8, this.Mcc);
            if (this.Mcd != null) {
                bu += g.a.a.a.nh(9, this.Mcd.computeSize());
            }
            if (this.Mce != null) {
                bu += g.a.a.a.nh(10, this.Mce.computeSize());
            }
            if (this.Mcf != null) {
                bu += g.a.a.b.b.a.f(11, this.Mcf);
            }
            AppMethodBeat.o(200206);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(200206);
                throw bVar2;
            }
            AppMethodBeat.o(200206);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bwe bwe = (bwe) objArr[1];
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
                        bwe.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(200206);
                    return 0;
                case 2:
                    bwe.Mca = aVar3.UbS.yZ();
                    AppMethodBeat.o(200206);
                    return 0;
                case 3:
                    bwe.title = aVar3.UbS.readString();
                    AppMethodBeat.o(200206);
                    return 0;
                case 4:
                    bwe.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(200206);
                    return 0;
                case 5:
                    bwe.iww = aVar3.UbS.readString();
                    AppMethodBeat.o(200206);
                    return 0;
                case 6:
                    bwe.url = aVar3.UbS.readString();
                    AppMethodBeat.o(200206);
                    return 0;
                case 7:
                    bwe.Mcb = aVar3.UbS.zi();
                    AppMethodBeat.o(200206);
                    return 0;
                case 8:
                    bwe.Mcc = aVar3.UbS.zi();
                    AppMethodBeat.o(200206);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aib aib = new aib();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aib.populateBuilderWithField(aVar5, aib, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bwe.Mcd = aib;
                    }
                    AppMethodBeat.o(200206);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aib aib2 = new aib();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aib2.populateBuilderWithField(aVar6, aib2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bwe.Mce = aib2;
                    }
                    AppMethodBeat.o(200206);
                    return 0;
                case 11:
                    bwe.Mcf = aVar3.UbS.readString();
                    AppMethodBeat.o(200206);
                    return 0;
                default:
                    AppMethodBeat.o(200206);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200206);
            return -1;
        }
    }
}

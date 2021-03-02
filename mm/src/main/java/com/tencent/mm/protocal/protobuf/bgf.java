package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bgf extends dpc {
    public LinkedList<String> LPV = new LinkedList<>();
    public LinkedList<String> LPW = new LinkedList<>();
    public LinkedList<String> LPX = new LinkedList<>();
    public LinkedList<bgg> LPY = new LinkedList<>();
    public String Title;
    public String xuE;

    public bgf() {
        AppMethodBeat.i(42635);
        AppMethodBeat.o(42635);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(42636);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(42636);
                throw bVar;
            } else if (this.Title == null) {
                b bVar2 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(42636);
                throw bVar2;
            } else if (this.xuE == null) {
                b bVar3 = new b("Not all required fields were included: JsonData");
                AppMethodBeat.o(42636);
                throw bVar3;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.Title != null) {
                    aVar.e(2, this.Title);
                }
                aVar.e(3, 1, this.LPV);
                if (this.xuE != null) {
                    aVar.e(4, this.xuE);
                }
                aVar.e(5, 1, this.LPW);
                aVar.e(6, 1, this.LPX);
                aVar.e(7, 8, this.LPY);
                AppMethodBeat.o(42636);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Title != null) {
                nh += g.a.a.b.b.a.f(2, this.Title);
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.LPV);
            if (this.xuE != null) {
                c2 += g.a.a.b.b.a.f(4, this.xuE);
            }
            int c3 = c2 + g.a.a.a.c(5, 1, this.LPW) + g.a.a.a.c(6, 1, this.LPX) + g.a.a.a.c(7, 8, this.LPY);
            AppMethodBeat.o(42636);
            return c3;
        } else if (i2 == 2) {
            this.LPV.clear();
            this.LPW.clear();
            this.LPX.clear();
            this.LPY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar4 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(42636);
                throw bVar4;
            } else if (this.Title == null) {
                b bVar5 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(42636);
                throw bVar5;
            } else if (this.xuE == null) {
                b bVar6 = new b("Not all required fields were included: JsonData");
                AppMethodBeat.o(42636);
                throw bVar6;
            } else {
                AppMethodBeat.o(42636);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgf bgf = (bgf) objArr[1];
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
                        bgf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(42636);
                    return 0;
                case 2:
                    bgf.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(42636);
                    return 0;
                case 3:
                    bgf.LPV.add(aVar3.UbS.readString());
                    AppMethodBeat.o(42636);
                    return 0;
                case 4:
                    bgf.xuE = aVar3.UbS.readString();
                    AppMethodBeat.o(42636);
                    return 0;
                case 5:
                    bgf.LPW.add(aVar3.UbS.readString());
                    AppMethodBeat.o(42636);
                    return 0;
                case 6:
                    bgf.LPX.add(aVar3.UbS.readString());
                    AppMethodBeat.o(42636);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bgg bgg = new bgg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bgg.populateBuilderWithField(aVar5, bgg, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bgf.LPY.add(bgg);
                    }
                    AppMethodBeat.o(42636);
                    return 0;
                default:
                    AppMethodBeat.o(42636);
                    return -1;
            }
        } else {
            AppMethodBeat.o(42636);
            return -1;
        }
    }
}

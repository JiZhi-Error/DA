package com.tencent.mm.plugin.festival.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.c.a;
import java.util.LinkedList;

public final class l extends dpc {
    public int UBa;
    public String UBb;
    public boolean UBc;
    public String UBd;
    public String UBe;
    public String UBf;
    public String UBg;
    public String UBh;
    public String UBi;
    public String UBj;
    public c UqV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(261978);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.UqV != null) {
                aVar.ni(2, this.UqV.computeSize());
                this.UqV.writeFields(aVar);
            }
            aVar.aM(3, this.UBa);
            if (this.UBb != null) {
                aVar.e(4, this.UBb);
            }
            aVar.cc(5, this.UBc);
            if (this.UBd != null) {
                aVar.e(6, this.UBd);
            }
            if (this.UBe != null) {
                aVar.e(7, this.UBe);
            }
            if (this.UBf != null) {
                aVar.e(8, this.UBf);
            }
            if (this.UBg != null) {
                aVar.e(9, this.UBg);
            }
            if (this.UBh != null) {
                aVar.e(10, this.UBh);
            }
            if (this.UBi != null) {
                aVar.e(11, this.UBi);
            }
            if (this.UBj != null) {
                aVar.e(12, this.UBj);
            }
            AppMethodBeat.o(261978);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.UqV != null) {
                nh += g.a.a.a.nh(2, this.UqV.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.UBa);
            if (this.UBb != null) {
                bu += g.a.a.b.b.a.f(4, this.UBb);
            }
            int fS = bu + g.a.a.b.b.a.fS(5) + 1;
            if (this.UBd != null) {
                fS += g.a.a.b.b.a.f(6, this.UBd);
            }
            if (this.UBe != null) {
                fS += g.a.a.b.b.a.f(7, this.UBe);
            }
            if (this.UBf != null) {
                fS += g.a.a.b.b.a.f(8, this.UBf);
            }
            if (this.UBg != null) {
                fS += g.a.a.b.b.a.f(9, this.UBg);
            }
            if (this.UBh != null) {
                fS += g.a.a.b.b.a.f(10, this.UBh);
            }
            if (this.UBi != null) {
                fS += g.a.a.b.b.a.f(11, this.UBi);
            }
            if (this.UBj != null) {
                fS += g.a.a.b.b.a.f(12, this.UBj);
            }
            AppMethodBeat.o(261978);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(261978);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
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
                        lVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(261978);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        c cVar = new c();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cVar.populateBuilderWithField(aVar5, cVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        lVar.UqV = cVar;
                    }
                    AppMethodBeat.o(261978);
                    return 0;
                case 3:
                    lVar.UBa = aVar3.UbS.zi();
                    AppMethodBeat.o(261978);
                    return 0;
                case 4:
                    lVar.UBb = aVar3.UbS.readString();
                    AppMethodBeat.o(261978);
                    return 0;
                case 5:
                    lVar.UBc = aVar3.UbS.yZ();
                    AppMethodBeat.o(261978);
                    return 0;
                case 6:
                    lVar.UBd = aVar3.UbS.readString();
                    AppMethodBeat.o(261978);
                    return 0;
                case 7:
                    lVar.UBe = aVar3.UbS.readString();
                    AppMethodBeat.o(261978);
                    return 0;
                case 8:
                    lVar.UBf = aVar3.UbS.readString();
                    AppMethodBeat.o(261978);
                    return 0;
                case 9:
                    lVar.UBg = aVar3.UbS.readString();
                    AppMethodBeat.o(261978);
                    return 0;
                case 10:
                    lVar.UBh = aVar3.UbS.readString();
                    AppMethodBeat.o(261978);
                    return 0;
                case 11:
                    lVar.UBi = aVar3.UbS.readString();
                    AppMethodBeat.o(261978);
                    return 0;
                case 12:
                    lVar.UBj = aVar3.UbS.readString();
                    AppMethodBeat.o(261978);
                    return 0;
                default:
                    AppMethodBeat.o(261978);
                    return -1;
            }
        } else {
            AppMethodBeat.o(261978);
            return -1;
        }
    }
}

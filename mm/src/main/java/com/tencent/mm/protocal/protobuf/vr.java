package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class vr extends dpc {
    public String LgG;
    public String LgH;
    public String LgI;
    public String LgJ;
    public int dDN;
    public String dTx;
    public String qwn;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200191);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(200191);
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
            if (this.title != null) {
                aVar.e(4, this.title);
            }
            if (this.dTx != null) {
                aVar.e(5, this.dTx);
            }
            if (this.LgG != null) {
                aVar.e(6, this.LgG);
            }
            if (this.LgH != null) {
                aVar.e(7, this.LgH);
            }
            if (this.LgI != null) {
                aVar.e(8, this.LgI);
            }
            if (this.LgJ != null) {
                aVar.e(9, this.LgJ);
            }
            AppMethodBeat.o(200191);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.title != null) {
                nh += g.a.a.b.b.a.f(4, this.title);
            }
            if (this.dTx != null) {
                nh += g.a.a.b.b.a.f(5, this.dTx);
            }
            if (this.LgG != null) {
                nh += g.a.a.b.b.a.f(6, this.LgG);
            }
            if (this.LgH != null) {
                nh += g.a.a.b.b.a.f(7, this.LgH);
            }
            if (this.LgI != null) {
                nh += g.a.a.b.b.a.f(8, this.LgI);
            }
            if (this.LgJ != null) {
                nh += g.a.a.b.b.a.f(9, this.LgJ);
            }
            AppMethodBeat.o(200191);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(200191);
                throw bVar2;
            }
            AppMethodBeat.o(200191);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            vr vrVar = (vr) objArr[1];
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
                        vrVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(200191);
                    return 0;
                case 2:
                    vrVar.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(200191);
                    return 0;
                case 3:
                    vrVar.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(200191);
                    return 0;
                case 4:
                    vrVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(200191);
                    return 0;
                case 5:
                    vrVar.dTx = aVar3.UbS.readString();
                    AppMethodBeat.o(200191);
                    return 0;
                case 6:
                    vrVar.LgG = aVar3.UbS.readString();
                    AppMethodBeat.o(200191);
                    return 0;
                case 7:
                    vrVar.LgH = aVar3.UbS.readString();
                    AppMethodBeat.o(200191);
                    return 0;
                case 8:
                    vrVar.LgI = aVar3.UbS.readString();
                    AppMethodBeat.o(200191);
                    return 0;
                case 9:
                    vrVar.LgJ = aVar3.UbS.readString();
                    AppMethodBeat.o(200191);
                    return 0;
                default:
                    AppMethodBeat.o(200191);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200191);
            return -1;
        }
    }
}

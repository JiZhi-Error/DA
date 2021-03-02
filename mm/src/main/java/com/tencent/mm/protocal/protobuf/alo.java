package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class alo extends dpc {
    public int Lut;
    public int dDN;
    public String qwn;
    public String rCq;
    public String yQE;
    public String yRZ;
    public String ySa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91455);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91455);
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
            if (this.yQE != null) {
                aVar.e(4, this.yQE);
            }
            if (this.rCq != null) {
                aVar.e(5, this.rCq);
            }
            aVar.aM(6, this.Lut);
            if (this.ySa != null) {
                aVar.e(7, this.ySa);
            }
            if (this.yRZ != null) {
                aVar.e(8, this.yRZ);
            }
            AppMethodBeat.o(91455);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.yQE != null) {
                nh += g.a.a.b.b.a.f(4, this.yQE);
            }
            if (this.rCq != null) {
                nh += g.a.a.b.b.a.f(5, this.rCq);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.Lut);
            if (this.ySa != null) {
                bu += g.a.a.b.b.a.f(7, this.ySa);
            }
            if (this.yRZ != null) {
                bu += g.a.a.b.b.a.f(8, this.yRZ);
            }
            AppMethodBeat.o(91455);
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
                AppMethodBeat.o(91455);
                throw bVar2;
            }
            AppMethodBeat.o(91455);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            alo alo = (alo) objArr[1];
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
                        alo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91455);
                    return 0;
                case 2:
                    alo.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(91455);
                    return 0;
                case 3:
                    alo.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(91455);
                    return 0;
                case 4:
                    alo.yQE = aVar3.UbS.readString();
                    AppMethodBeat.o(91455);
                    return 0;
                case 5:
                    alo.rCq = aVar3.UbS.readString();
                    AppMethodBeat.o(91455);
                    return 0;
                case 6:
                    alo.Lut = aVar3.UbS.zi();
                    AppMethodBeat.o(91455);
                    return 0;
                case 7:
                    alo.ySa = aVar3.UbS.readString();
                    AppMethodBeat.o(91455);
                    return 0;
                case 8:
                    alo.yRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(91455);
                    return 0;
                default:
                    AppMethodBeat.o(91455);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91455);
            return -1;
        }
    }
}

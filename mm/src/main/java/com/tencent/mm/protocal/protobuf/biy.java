package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class biy extends dpc {
    public jg KKH;
    public int dDN;
    public String qwn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72479);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72479);
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
            if (this.KKH != null) {
                aVar.ni(4, this.KKH.computeSize());
                this.KKH.writeFields(aVar);
            }
            AppMethodBeat.o(72479);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.KKH != null) {
                nh += g.a.a.a.nh(4, this.KKH.computeSize());
            }
            AppMethodBeat.o(72479);
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
                AppMethodBeat.o(72479);
                throw bVar2;
            }
            AppMethodBeat.o(72479);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            biy biy = (biy) objArr[1];
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
                        biy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72479);
                    return 0;
                case 2:
                    biy.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(72479);
                    return 0;
                case 3:
                    biy.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(72479);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        jg jgVar = new jg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = jgVar.populateBuilderWithField(aVar5, jgVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        biy.KKH = jgVar;
                    }
                    AppMethodBeat.o(72479);
                    return 0;
                default:
                    AppMethodBeat.o(72479);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72479);
            return -1;
        }
    }
}

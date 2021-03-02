package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aek extends dpc {
    public LinkedList<cvu> KHx = new LinkedList<>();
    public String LpH;
    public String LpI;
    public String jHa;

    public aek() {
        AppMethodBeat.i(152524);
        AppMethodBeat.o(152524);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152525);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.jHa != null) {
                aVar.e(2, this.jHa);
            }
            aVar.e(3, 8, this.KHx);
            if (this.LpH != null) {
                aVar.e(4, this.LpH);
            }
            if (this.LpI != null) {
                aVar.e(5, this.LpI);
            }
            AppMethodBeat.o(152525);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.jHa != null) {
                nh += g.a.a.b.b.a.f(2, this.jHa);
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.KHx);
            if (this.LpH != null) {
                c2 += g.a.a.b.b.a.f(4, this.LpH);
            }
            if (this.LpI != null) {
                c2 += g.a.a.b.b.a.f(5, this.LpI);
            }
            AppMethodBeat.o(152525);
            return c2;
        } else if (i2 == 2) {
            this.KHx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152525);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aek aek = (aek) objArr[1];
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
                        aek.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152525);
                    return 0;
                case 2:
                    aek.jHa = aVar3.UbS.readString();
                    AppMethodBeat.o(152525);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cvu cvu = new cvu();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cvu.populateBuilderWithField(aVar5, cvu, dpc.getNextFieldNumber(aVar5))) {
                        }
                        aek.KHx.add(cvu);
                    }
                    AppMethodBeat.o(152525);
                    return 0;
                case 4:
                    aek.LpH = aVar3.UbS.readString();
                    AppMethodBeat.o(152525);
                    return 0;
                case 5:
                    aek.LpI = aVar3.UbS.readString();
                    AppMethodBeat.o(152525);
                    return 0;
                default:
                    AppMethodBeat.o(152525);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152525);
            return -1;
        }
    }
}

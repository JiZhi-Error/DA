package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ati extends dpc {
    public String LEh;
    public int LEi;
    public String LEj;
    public azj LEk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209443);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LEh != null) {
                aVar.e(2, this.LEh);
            }
            aVar.aM(3, this.LEi);
            if (this.LEj != null) {
                aVar.e(4, this.LEj);
            }
            if (this.LEk != null) {
                aVar.ni(5, this.LEk.computeSize());
                this.LEk.writeFields(aVar);
            }
            AppMethodBeat.o(209443);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LEh != null) {
                nh += g.a.a.b.b.a.f(2, this.LEh);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.LEi);
            if (this.LEj != null) {
                bu += g.a.a.b.b.a.f(4, this.LEj);
            }
            if (this.LEk != null) {
                bu += g.a.a.a.nh(5, this.LEk.computeSize());
            }
            AppMethodBeat.o(209443);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209443);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ati ati = (ati) objArr[1];
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
                        ati.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209443);
                    return 0;
                case 2:
                    ati.LEh = aVar3.UbS.readString();
                    AppMethodBeat.o(209443);
                    return 0;
                case 3:
                    ati.LEi = aVar3.UbS.zi();
                    AppMethodBeat.o(209443);
                    return 0;
                case 4:
                    ati.LEj = aVar3.UbS.readString();
                    AppMethodBeat.o(209443);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        azj azj = new azj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = azj.populateBuilderWithField(aVar5, azj, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ati.LEk = azj;
                    }
                    AppMethodBeat.o(209443);
                    return 0;
                default:
                    AppMethodBeat.o(209443);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209443);
            return -1;
        }
    }
}

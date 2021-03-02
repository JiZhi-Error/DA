package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dmb extends dpc {
    public String KOu;
    public LinkedList<eox> MPF = new LinkedList<>();
    public ejg MPG;
    public int MlI;
    public int oTz;

    public dmb() {
        AppMethodBeat.i(56260);
        AppMethodBeat.o(56260);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(56261);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56261);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.oTz);
            aVar.e(3, 8, this.MPF);
            if (this.KOu != null) {
                aVar.e(4, this.KOu);
            }
            aVar.aM(5, this.MlI);
            if (this.MPG != null) {
                aVar.ni(6, this.MPG.computeSize());
                this.MPG.writeFields(aVar);
            }
            AppMethodBeat.o(56261);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTz) + g.a.a.a.c(3, 8, this.MPF);
            if (this.KOu != null) {
                nh += g.a.a.b.b.a.f(4, this.KOu);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.MlI);
            if (this.MPG != null) {
                bu += g.a.a.a.nh(6, this.MPG.computeSize());
            }
            AppMethodBeat.o(56261);
            return bu;
        } else if (i2 == 2) {
            this.MPF.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56261);
                throw bVar2;
            }
            AppMethodBeat.o(56261);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dmb dmb = (dmb) objArr[1];
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
                        dmb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56261);
                    return 0;
                case 2:
                    dmb.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(56261);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eox eox = new eox();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eox.populateBuilderWithField(aVar5, eox, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dmb.MPF.add(eox);
                    }
                    AppMethodBeat.o(56261);
                    return 0;
                case 4:
                    dmb.KOu = aVar3.UbS.readString();
                    AppMethodBeat.o(56261);
                    return 0;
                case 5:
                    dmb.MlI = aVar3.UbS.zi();
                    AppMethodBeat.o(56261);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ejg ejg = new ejg();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ejg.populateBuilderWithField(aVar6, ejg, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dmb.MPG = ejg;
                    }
                    AppMethodBeat.o(56261);
                    return 0;
                default:
                    AppMethodBeat.o(56261);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56261);
            return -1;
        }
    }
}

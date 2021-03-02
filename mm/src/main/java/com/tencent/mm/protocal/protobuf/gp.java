package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class gp extends dpc {
    public b KKm;
    public int KKr;
    public int KKs;
    public gu KKt;
    public gq KKu;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32119);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32119);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.KKr);
            aVar.aM(3, this.KKs);
            if (this.KKm != null) {
                aVar.c(4, this.KKm);
            }
            if (this.KKt != null) {
                aVar.ni(5, this.KKt.computeSize());
                this.KKt.writeFields(aVar);
            }
            if (this.KKu != null) {
                aVar.ni(6, this.KKu.computeSize());
                this.KKu.writeFields(aVar);
            }
            AppMethodBeat.o(32119);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KKr) + g.a.a.b.b.a.bu(3, this.KKs);
            if (this.KKm != null) {
                nh += g.a.a.b.b.a.b(4, this.KKm);
            }
            if (this.KKt != null) {
                nh += g.a.a.a.nh(5, this.KKt.computeSize());
            }
            if (this.KKu != null) {
                nh += g.a.a.a.nh(6, this.KKu.computeSize());
            }
            AppMethodBeat.o(32119);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32119);
                throw bVar2;
            }
            AppMethodBeat.o(32119);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            gp gpVar = (gp) objArr[1];
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
                        gpVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32119);
                    return 0;
                case 2:
                    gpVar.KKr = aVar3.UbS.zi();
                    AppMethodBeat.o(32119);
                    return 0;
                case 3:
                    gpVar.KKs = aVar3.UbS.zi();
                    AppMethodBeat.o(32119);
                    return 0;
                case 4:
                    gpVar.KKm = aVar3.UbS.hPo();
                    AppMethodBeat.o(32119);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        gu guVar = new gu();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = guVar.populateBuilderWithField(aVar5, guVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        gpVar.KKt = guVar;
                    }
                    AppMethodBeat.o(32119);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        gq gqVar = new gq();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = gqVar.populateBuilderWithField(aVar6, gqVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        gpVar.KKu = gqVar;
                    }
                    AppMethodBeat.o(32119);
                    return 0;
                default:
                    AppMethodBeat.o(32119);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32119);
            return -1;
        }
    }
}

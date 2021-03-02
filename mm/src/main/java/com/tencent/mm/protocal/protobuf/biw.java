package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class biw extends dpc {
    public LinkedList<ix> LSL = new LinkedList<>();
    public aea LSM;
    public int rBL;
    public String rBM;

    public biw() {
        AppMethodBeat.i(91480);
        AppMethodBeat.o(91480);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91481);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91481);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.rBL);
            if (this.rBM != null) {
                aVar.e(3, this.rBM);
            }
            aVar.e(4, 8, this.LSL);
            if (this.LSM != null) {
                aVar.ni(5, this.LSM.computeSize());
                this.LSM.writeFields(aVar);
            }
            AppMethodBeat.o(91481);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.rBL);
            if (this.rBM != null) {
                nh += g.a.a.b.b.a.f(3, this.rBM);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.LSL);
            if (this.LSM != null) {
                c2 += g.a.a.a.nh(5, this.LSM.computeSize());
            }
            AppMethodBeat.o(91481);
            return c2;
        } else if (i2 == 2) {
            this.LSL.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91481);
                throw bVar2;
            }
            AppMethodBeat.o(91481);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            biw biw = (biw) objArr[1];
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
                        biw.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91481);
                    return 0;
                case 2:
                    biw.rBL = aVar3.UbS.zi();
                    AppMethodBeat.o(91481);
                    return 0;
                case 3:
                    biw.rBM = aVar3.UbS.readString();
                    AppMethodBeat.o(91481);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ix ixVar = new ix();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ixVar.populateBuilderWithField(aVar5, ixVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        biw.LSL.add(ixVar);
                    }
                    AppMethodBeat.o(91481);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aea aea = new aea();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aea.populateBuilderWithField(aVar6, aea, dpc.getNextFieldNumber(aVar6))) {
                        }
                        biw.LSM = aea;
                    }
                    AppMethodBeat.o(91481);
                    return 0;
                default:
                    AppMethodBeat.o(91481);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91481);
            return -1;
        }
    }
}

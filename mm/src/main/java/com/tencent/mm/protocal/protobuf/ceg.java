package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ceg extends dpc {
    public LinkedList<epn> MjP = new LinkedList<>();
    public LinkedList<String> MjQ = new LinkedList<>();
    public String MjR;
    public LinkedList<cel> MjS = new LinkedList<>();
    public cdz Mjz;

    public ceg() {
        AppMethodBeat.i(82440);
        AppMethodBeat.o(82440);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82441);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(82441);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Mjz != null) {
                aVar.ni(2, this.Mjz.computeSize());
                this.Mjz.writeFields(aVar);
            }
            aVar.e(3, 8, this.MjP);
            aVar.e(4, 1, this.MjQ);
            if (this.MjR != null) {
                aVar.e(5, this.MjR);
            }
            aVar.e(6, 8, this.MjS);
            AppMethodBeat.o(82441);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Mjz != null) {
                nh += g.a.a.a.nh(2, this.Mjz.computeSize());
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.MjP) + g.a.a.a.c(4, 1, this.MjQ);
            if (this.MjR != null) {
                c2 += g.a.a.b.b.a.f(5, this.MjR);
            }
            int c3 = c2 + g.a.a.a.c(6, 8, this.MjS);
            AppMethodBeat.o(82441);
            return c3;
        } else if (i2 == 2) {
            this.MjP.clear();
            this.MjQ.clear();
            this.MjS.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(82441);
                throw bVar2;
            }
            AppMethodBeat.o(82441);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ceg ceg = (ceg) objArr[1];
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
                        ceg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(82441);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cdz cdz = new cdz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cdz.populateBuilderWithField(aVar5, cdz, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ceg.Mjz = cdz;
                    }
                    AppMethodBeat.o(82441);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        epn epn = new epn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = epn.populateBuilderWithField(aVar6, epn, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ceg.MjP.add(epn);
                    }
                    AppMethodBeat.o(82441);
                    return 0;
                case 4:
                    ceg.MjQ.add(aVar3.UbS.readString());
                    AppMethodBeat.o(82441);
                    return 0;
                case 5:
                    ceg.MjR = aVar3.UbS.readString();
                    AppMethodBeat.o(82441);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cel cel = new cel();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cel.populateBuilderWithField(aVar7, cel, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ceg.MjS.add(cel);
                    }
                    AppMethodBeat.o(82441);
                    return 0;
                default:
                    AppMethodBeat.o(82441);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82441);
            return -1;
        }
    }
}

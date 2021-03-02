package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bly extends dpc {
    public long LUH;
    public boolean LUI;
    public long LUJ;
    public LinkedList<ue> LUK = new LinkedList<>();
    public adu LUM;
    public adu LUN;
    public String pUa;
    public String title;

    public bly() {
        AppMethodBeat.i(201335);
        AppMethodBeat.o(201335);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201336);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(201336);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.LUH);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.cc(4, this.LUI);
            aVar.bb(5, this.LUJ);
            if (this.title != null) {
                aVar.e(6, this.title);
            }
            aVar.e(7, 8, this.LUK);
            if (this.LUM != null) {
                aVar.ni(8, this.LUM.computeSize());
                this.LUM.writeFields(aVar);
            }
            if (this.LUN != null) {
                aVar.ni(9, this.LUN.computeSize());
                this.LUN.writeFields(aVar);
            }
            AppMethodBeat.o(201336);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.LUH);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.r(5, this.LUJ);
            if (this.title != null) {
                fS += g.a.a.b.b.a.f(6, this.title);
            }
            int c2 = fS + g.a.a.a.c(7, 8, this.LUK);
            if (this.LUM != null) {
                c2 += g.a.a.a.nh(8, this.LUM.computeSize());
            }
            if (this.LUN != null) {
                c2 += g.a.a.a.nh(9, this.LUN.computeSize());
            }
            AppMethodBeat.o(201336);
            return c2;
        } else if (i2 == 2) {
            this.LUK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(201336);
                throw bVar2;
            }
            AppMethodBeat.o(201336);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bly bly = (bly) objArr[1];
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
                        bly.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(201336);
                    return 0;
                case 2:
                    bly.LUH = aVar3.UbS.zl();
                    AppMethodBeat.o(201336);
                    return 0;
                case 3:
                    bly.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(201336);
                    return 0;
                case 4:
                    bly.LUI = aVar3.UbS.yZ();
                    AppMethodBeat.o(201336);
                    return 0;
                case 5:
                    bly.LUJ = aVar3.UbS.zl();
                    AppMethodBeat.o(201336);
                    return 0;
                case 6:
                    bly.title = aVar3.UbS.readString();
                    AppMethodBeat.o(201336);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ue ueVar = new ue();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ueVar.populateBuilderWithField(aVar5, ueVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bly.LUK.add(ueVar);
                    }
                    AppMethodBeat.o(201336);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        adu adu = new adu();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = adu.populateBuilderWithField(aVar6, adu, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bly.LUM = adu;
                    }
                    AppMethodBeat.o(201336);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        adu adu2 = new adu();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = adu2.populateBuilderWithField(aVar7, adu2, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bly.LUN = adu2;
                    }
                    AppMethodBeat.o(201336);
                    return 0;
                default:
                    AppMethodBeat.o(201336);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201336);
            return -1;
        }
    }
}

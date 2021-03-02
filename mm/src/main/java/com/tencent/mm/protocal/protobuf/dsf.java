package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dsf extends dpc {
    public String KOX;
    public cpl KOY;
    public cat KPD;
    public cau KPE;
    public int MUK;
    public dv MUL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32422);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32422);
                throw bVar;
            } else if (this.KOY == null) {
                b bVar2 = new b("Not all required fields were included: Contact");
                AppMethodBeat.o(32422);
                throw bVar2;
            } else if (this.KPD == null) {
                b bVar3 = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(32422);
                throw bVar3;
            } else if (this.KPE == null) {
                b bVar4 = new b("Not all required fields were included: HardDeviceAttr");
                AppMethodBeat.o(32422);
                throw bVar4;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.KOY != null) {
                    aVar.ni(2, this.KOY.computeSize());
                    this.KOY.writeFields(aVar);
                }
                if (this.KPD != null) {
                    aVar.ni(3, this.KPD.computeSize());
                    this.KPD.writeFields(aVar);
                }
                if (this.KPE != null) {
                    aVar.ni(4, this.KPE.computeSize());
                    this.KPE.writeFields(aVar);
                }
                if (this.KOX != null) {
                    aVar.e(5, this.KOX);
                }
                aVar.aM(6, this.MUK);
                if (this.MUL != null) {
                    aVar.ni(7, this.MUL.computeSize());
                    this.MUL.writeFields(aVar);
                }
                AppMethodBeat.o(32422);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KOY != null) {
                nh += g.a.a.a.nh(2, this.KOY.computeSize());
            }
            if (this.KPD != null) {
                nh += g.a.a.a.nh(3, this.KPD.computeSize());
            }
            if (this.KPE != null) {
                nh += g.a.a.a.nh(4, this.KPE.computeSize());
            }
            if (this.KOX != null) {
                nh += g.a.a.b.b.a.f(5, this.KOX);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.MUK);
            if (this.MUL != null) {
                bu += g.a.a.a.nh(7, this.MUL.computeSize());
            }
            AppMethodBeat.o(32422);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar5 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32422);
                throw bVar5;
            } else if (this.KOY == null) {
                b bVar6 = new b("Not all required fields were included: Contact");
                AppMethodBeat.o(32422);
                throw bVar6;
            } else if (this.KPD == null) {
                b bVar7 = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(32422);
                throw bVar7;
            } else if (this.KPE == null) {
                b bVar8 = new b("Not all required fields were included: HardDeviceAttr");
                AppMethodBeat.o(32422);
                throw bVar8;
            } else {
                AppMethodBeat.o(32422);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dsf dsf = (dsf) objArr[1];
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
                        dsf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32422);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cpl cpl = new cpl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cpl.populateBuilderWithField(aVar5, cpl, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dsf.KOY = cpl;
                    }
                    AppMethodBeat.o(32422);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cat cat = new cat();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cat.populateBuilderWithField(aVar6, cat, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dsf.KPD = cat;
                    }
                    AppMethodBeat.o(32422);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cau cau = new cau();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cau.populateBuilderWithField(aVar7, cau, dpc.getNextFieldNumber(aVar7))) {
                        }
                        dsf.KPE = cau;
                    }
                    AppMethodBeat.o(32422);
                    return 0;
                case 5:
                    dsf.KOX = aVar3.UbS.readString();
                    AppMethodBeat.o(32422);
                    return 0;
                case 6:
                    dsf.MUK = aVar3.UbS.zi();
                    AppMethodBeat.o(32422);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dv dvVar = new dv();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dvVar.populateBuilderWithField(aVar8, dvVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        dsf.MUL = dvVar;
                    }
                    AppMethodBeat.o(32422);
                    return 0;
                default:
                    AppMethodBeat.o(32422);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32422);
            return -1;
        }
    }
}

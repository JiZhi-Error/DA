package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dsx extends dpc {
    public String KOX;
    public cpl KOY;
    public cat KPD;
    public cau KPE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32424);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32424);
                throw bVar;
            }
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
            AppMethodBeat.o(32424);
            return 0;
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
            AppMethodBeat.o(32424);
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
                AppMethodBeat.o(32424);
                throw bVar2;
            }
            AppMethodBeat.o(32424);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dsx dsx = (dsx) objArr[1];
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
                        dsx.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32424);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cpl cpl = new cpl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cpl.populateBuilderWithField(aVar5, cpl, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dsx.KOY = cpl;
                    }
                    AppMethodBeat.o(32424);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cat cat = new cat();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cat.populateBuilderWithField(aVar6, cat, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dsx.KPD = cat;
                    }
                    AppMethodBeat.o(32424);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cau cau = new cau();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cau.populateBuilderWithField(aVar7, cau, dpc.getNextFieldNumber(aVar7))) {
                        }
                        dsx.KPE = cau;
                    }
                    AppMethodBeat.o(32424);
                    return 0;
                case 5:
                    dsx.KOX = aVar3.UbS.readString();
                    AppMethodBeat.o(32424);
                    return 0;
                default:
                    AppMethodBeat.o(32424);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32424);
            return -1;
        }
    }
}
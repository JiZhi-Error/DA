package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aso extends dpc {
    public baw LAF;
    public int LDq;
    public LinkedList<FinderObject> LDv = new LinkedList<>();
    public String LDw;
    public int continueFlag;
    public int gAZ;
    public b lastBuffer;
    public int uKM;

    public aso() {
        AppMethodBeat.i(168986);
        AppMethodBeat.o(168986);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168987);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(168987);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.LDv);
            if (this.lastBuffer != null) {
                aVar.c(3, this.lastBuffer);
            }
            aVar.aM(4, this.continueFlag);
            aVar.aM(5, this.gAZ);
            if (this.LDw != null) {
                aVar.e(6, this.LDw);
            }
            aVar.aM(7, this.uKM);
            aVar.aM(8, this.LDq);
            if (this.LAF != null) {
                aVar.ni(9, this.LAF.computeSize());
                this.LAF.writeFields(aVar);
            }
            AppMethodBeat.o(168987);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LDv);
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(3, this.lastBuffer);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.continueFlag) + g.a.a.b.b.a.bu(5, this.gAZ);
            if (this.LDw != null) {
                bu += g.a.a.b.b.a.f(6, this.LDw);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.uKM) + g.a.a.b.b.a.bu(8, this.LDq);
            if (this.LAF != null) {
                bu2 += g.a.a.a.nh(9, this.LAF.computeSize());
            }
            AppMethodBeat.o(168987);
            return bu2;
        } else if (i2 == 2) {
            this.LDv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(168987);
                throw bVar2;
            }
            AppMethodBeat.o(168987);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aso aso = (aso) objArr[1];
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
                        aso.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(168987);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        aso.LDv.add(finderObject);
                    }
                    AppMethodBeat.o(168987);
                    return 0;
                case 3:
                    aso.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(168987);
                    return 0;
                case 4:
                    aso.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168987);
                    return 0;
                case 5:
                    aso.gAZ = aVar3.UbS.zi();
                    AppMethodBeat.o(168987);
                    return 0;
                case 6:
                    aso.LDw = aVar3.UbS.readString();
                    AppMethodBeat.o(168987);
                    return 0;
                case 7:
                    aso.uKM = aVar3.UbS.zi();
                    AppMethodBeat.o(168987);
                    return 0;
                case 8:
                    aso.LDq = aVar3.UbS.zi();
                    AppMethodBeat.o(168987);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        baw baw = new baw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = baw.populateBuilderWithField(aVar6, baw, dpc.getNextFieldNumber(aVar6))) {
                        }
                        aso.LAF = baw;
                    }
                    AppMethodBeat.o(168987);
                    return 0;
                default:
                    AppMethodBeat.o(168987);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168987);
            return -1;
        }
    }
}

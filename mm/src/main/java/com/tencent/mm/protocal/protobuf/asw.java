package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class asw extends dpc {
    public awu LDS;
    public b LDs;
    public LinkedList<FinderObject> object = new LinkedList<>();
    public int tUC;

    public asw() {
        AppMethodBeat.i(209428);
        AppMethodBeat.o(209428);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209429);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.object);
            if (this.LDs != null) {
                aVar.c(3, this.LDs);
            }
            aVar.aM(4, this.tUC);
            if (this.LDS != null) {
                aVar.ni(5, this.LDS.computeSize());
                this.LDS.writeFields(aVar);
            }
            AppMethodBeat.o(209429);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.object);
            if (this.LDs != null) {
                nh += g.a.a.b.b.a.b(3, this.LDs);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.tUC);
            if (this.LDS != null) {
                bu += g.a.a.a.nh(5, this.LDS.computeSize());
            }
            AppMethodBeat.o(209429);
            return bu;
        } else if (i2 == 2) {
            this.object.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209429);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            asw asw = (asw) objArr[1];
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
                        asw.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209429);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        asw.object.add(finderObject);
                    }
                    AppMethodBeat.o(209429);
                    return 0;
                case 3:
                    asw.LDs = aVar3.UbS.hPo();
                    AppMethodBeat.o(209429);
                    return 0;
                case 4:
                    asw.tUC = aVar3.UbS.zi();
                    AppMethodBeat.o(209429);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        awu awu = new awu();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = awu.populateBuilderWithField(aVar6, awu, dpc.getNextFieldNumber(aVar6))) {
                        }
                        asw.LDS = awu;
                    }
                    AppMethodBeat.o(209429);
                    return 0;
                default:
                    AppMethodBeat.o(209429);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209429);
            return -1;
        }
    }
}

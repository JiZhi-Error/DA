package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bid extends dop {
    public LinkedList<dqi> LSt = new LinkedList<>();
    public int LSu;
    public LinkedList<dqi> LSv = new LinkedList<>();
    public int oTz;

    public bid() {
        AppMethodBeat.i(152558);
        AppMethodBeat.o(152558);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152559);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.oTz);
            aVar.e(3, 8, this.LSt);
            aVar.aM(4, this.LSu);
            aVar.e(5, 8, this.LSv);
            AppMethodBeat.o(152559);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTz) + g.a.a.a.c(3, 8, this.LSt) + g.a.a.b.b.a.bu(4, this.LSu) + g.a.a.a.c(5, 8, this.LSv);
            AppMethodBeat.o(152559);
            return nh;
        } else if (i2 == 2) {
            this.LSt.clear();
            this.LSv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152559);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bid bid = (bid) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        bid.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152559);
                    return 0;
                case 2:
                    bid.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(152559);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        bid.LSt.add(dqi);
                    }
                    AppMethodBeat.o(152559);
                    return 0;
                case 4:
                    bid.LSu = aVar3.UbS.zi();
                    AppMethodBeat.o(152559);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dop.getNextFieldNumber(aVar6))) {
                        }
                        bid.LSv.add(dqi2);
                    }
                    AppMethodBeat.o(152559);
                    return 0;
                default:
                    AppMethodBeat.o(152559);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152559);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class azm extends a {
    public LinkedList<FinderObject> LCW = new LinkedList<>();
    public bcc tvs;

    public azm() {
        AppMethodBeat.i(209614);
        AppMethodBeat.o(209614);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209615);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.tvs != null) {
                aVar.ni(1, this.tvs.computeSize());
                this.tvs.writeFields(aVar);
            }
            aVar.e(2, 8, this.LCW);
            AppMethodBeat.o(209615);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.tvs != null ? g.a.a.a.nh(1, this.tvs.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LCW);
            AppMethodBeat.o(209615);
            return nh;
        } else if (i2 == 2) {
            this.LCW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209615);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azm azm = (azm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bcc bcc = new bcc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bcc.populateBuilderWithField(aVar4, bcc, a.getNextFieldNumber(aVar4))) {
                        }
                        azm.tvs = bcc;
                    }
                    AppMethodBeat.o(209615);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, a.getNextFieldNumber(aVar5))) {
                        }
                        azm.LCW.add(finderObject);
                    }
                    AppMethodBeat.o(209615);
                    return 0;
                default:
                    AppMethodBeat.o(209615);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209615);
            return -1;
        }
    }
}

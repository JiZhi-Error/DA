package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bjp extends dop {
    public LinkedList<qv> LTi = new LinkedList<>();

    public bjp() {
        AppMethodBeat.i(124500);
        AppMethodBeat.o(124500);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124501);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.LTi);
            AppMethodBeat.o(124501);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LTi);
            AppMethodBeat.o(124501);
            return nh;
        } else if (i2 == 2) {
            this.LTi.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124501);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bjp bjp = (bjp) objArr[1];
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
                        bjp.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124501);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        qv qvVar = new qv();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = qvVar.populateBuilderWithField(aVar5, qvVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        bjp.LTi.add(qvVar);
                    }
                    AppMethodBeat.o(124501);
                    return 0;
                default:
                    AppMethodBeat.o(124501);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124501);
            return -1;
        }
    }
}
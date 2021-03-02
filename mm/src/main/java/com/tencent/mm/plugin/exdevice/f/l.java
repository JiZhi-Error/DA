package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class l extends j {
    public b oTm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(23494);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.rCc == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(23494);
                throw bVar;
            }
            if (this.rCc != null) {
                aVar.ni(1, this.rCc.computeSize());
                this.rCc.writeFields(aVar);
            }
            if (this.oTm != null) {
                aVar.c(2, this.oTm);
            }
            AppMethodBeat.o(23494);
            return 0;
        } else if (i2 == 1) {
            int nh = this.rCc != null ? g.a.a.a.nh(1, this.rCc.computeSize()) + 0 : 0;
            if (this.oTm != null) {
                nh += g.a.a.b.b.a.b(2, this.oTm);
            }
            AppMethodBeat.o(23494);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = j.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = j.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.rCc == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(23494);
                throw bVar2;
            }
            AppMethodBeat.o(23494);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        e eVar = new e();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, j.getNextFieldNumber(aVar4))) {
                        }
                        lVar.rCc = eVar;
                    }
                    AppMethodBeat.o(23494);
                    return 0;
                case 2:
                    lVar.oTm = aVar3.UbS.hPo();
                    AppMethodBeat.o(23494);
                    return 0;
                default:
                    AppMethodBeat.o(23494);
                    return -1;
            }
        } else {
            AppMethodBeat.o(23494);
            return -1;
        }
    }
}

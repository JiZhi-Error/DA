package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class b extends j {
    public com.tencent.mm.bw.b rBJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(23486);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.rCc == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(23486);
                throw bVar;
            } else if (this.rBJ == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: AesSessionKey");
                AppMethodBeat.o(23486);
                throw bVar2;
            } else {
                if (this.rCc != null) {
                    aVar.ni(1, this.rCc.computeSize());
                    this.rCc.writeFields(aVar);
                }
                if (this.rBJ != null) {
                    aVar.c(2, this.rBJ);
                }
                AppMethodBeat.o(23486);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.rCc != null ? g.a.a.a.nh(1, this.rCc.computeSize()) + 0 : 0;
            if (this.rBJ != null) {
                nh += g.a.a.b.b.a.b(2, this.rBJ);
            }
            AppMethodBeat.o(23486);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = j.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = j.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.rCc == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(23486);
                throw bVar3;
            } else if (this.rBJ == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: AesSessionKey");
                AppMethodBeat.o(23486);
                throw bVar4;
            } else {
                AppMethodBeat.o(23486);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar5 = (b) objArr[1];
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
                        bVar5.rCc = eVar;
                    }
                    AppMethodBeat.o(23486);
                    return 0;
                case 2:
                    bVar5.rBJ = aVar3.UbS.hPo();
                    AppMethodBeat.o(23486);
                    return 0;
                default:
                    AppMethodBeat.o(23486);
                    return -1;
            }
        } else {
            AppMethodBeat.o(23486);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class eox extends a {
    public ddj NmV;
    public String Username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(56263);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NmV == null) {
                b bVar = new b("Not all required fields were included: Position");
                AppMethodBeat.o(56263);
                throw bVar;
            }
            if (this.Username != null) {
                aVar.e(1, this.Username);
            }
            if (this.NmV != null) {
                aVar.ni(2, this.NmV.computeSize());
                this.NmV.writeFields(aVar);
            }
            AppMethodBeat.o(56263);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Username != null ? g.a.a.b.b.a.f(1, this.Username) + 0 : 0;
            if (this.NmV != null) {
                f2 += g.a.a.a.nh(2, this.NmV.computeSize());
            }
            AppMethodBeat.o(56263);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NmV == null) {
                b bVar2 = new b("Not all required fields were included: Position");
                AppMethodBeat.o(56263);
                throw bVar2;
            }
            AppMethodBeat.o(56263);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eox eox = (eox) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eox.Username = aVar3.UbS.readString();
                    AppMethodBeat.o(56263);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ddj ddj = new ddj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ddj.populateBuilderWithField(aVar4, ddj, a.getNextFieldNumber(aVar4))) {
                        }
                        eox.NmV = ddj;
                    }
                    AppMethodBeat.o(56263);
                    return 0;
                default:
                    AppMethodBeat.o(56263);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56263);
            return -1;
        }
    }
}

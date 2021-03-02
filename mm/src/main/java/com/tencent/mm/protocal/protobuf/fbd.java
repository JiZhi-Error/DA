package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class fbd extends a {
    public fbg Nxt;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110854);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nxt == null) {
                b bVar = new b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.o(110854);
                throw bVar;
            }
            if (this.Nxt != null) {
                aVar.ni(4, this.Nxt.computeSize());
                this.Nxt.writeFields(aVar);
            }
            AppMethodBeat.o(110854);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Nxt != null ? g.a.a.a.nh(4, this.Nxt.computeSize()) + 0 : 0;
            AppMethodBeat.o(110854);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nxt == null) {
                b bVar2 = new b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.o(110854);
                throw bVar2;
            }
            AppMethodBeat.o(110854);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbd fbd = (fbd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fbg fbg = new fbg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fbg.populateBuilderWithField(aVar4, fbg, a.getNextFieldNumber(aVar4))) {
                        }
                        fbd.Nxt = fbg;
                    }
                    AppMethodBeat.o(110854);
                    return 0;
                default:
                    AppMethodBeat.o(110854);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110854);
            return -1;
        }
    }
}

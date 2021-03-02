package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cpp extends a {
    public ahm MvH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43108);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MvH == null) {
                b bVar = new b("Not all required fields were included: DisturbSetting");
                AppMethodBeat.o(43108);
                throw bVar;
            }
            if (this.MvH != null) {
                aVar.ni(1, this.MvH.computeSize());
                this.MvH.writeFields(aVar);
            }
            AppMethodBeat.o(43108);
            return 0;
        } else if (i2 == 1) {
            int nh = this.MvH != null ? g.a.a.a.nh(1, this.MvH.computeSize()) + 0 : 0;
            AppMethodBeat.o(43108);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MvH == null) {
                b bVar2 = new b("Not all required fields were included: DisturbSetting");
                AppMethodBeat.o(43108);
                throw bVar2;
            }
            AppMethodBeat.o(43108);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cpp cpp = (cpp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ahm ahm = new ahm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ahm.populateBuilderWithField(aVar4, ahm, a.getNextFieldNumber(aVar4))) {
                        }
                        cpp.MvH = ahm;
                    }
                    AppMethodBeat.o(43108);
                    return 0;
                default:
                    AppMethodBeat.o(43108);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43108);
            return -1;
        }
    }
}

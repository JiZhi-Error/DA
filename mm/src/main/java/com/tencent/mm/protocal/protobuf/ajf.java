package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ajf extends a {
    public String Md5;
    public LinkedList<cgx> oTA = new LinkedList<>();
    public int oTz;

    public ajf() {
        AppMethodBeat.i(104773);
        AppMethodBeat.o(104773);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104774);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Md5 != null) {
                aVar.e(1, this.Md5);
            }
            aVar.aM(2, this.oTz);
            aVar.e(3, 8, this.oTA);
            AppMethodBeat.o(104774);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Md5 != null ? g.a.a.b.b.a.f(1, this.Md5) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTz) + g.a.a.a.c(3, 8, this.oTA);
            AppMethodBeat.o(104774);
            return f2;
        } else if (i2 == 2) {
            this.oTA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104774);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ajf ajf = (ajf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ajf.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(104774);
                    return 0;
                case 2:
                    ajf.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(104774);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cgx cgx = new cgx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cgx.populateBuilderWithField(aVar4, cgx, a.getNextFieldNumber(aVar4))) {
                        }
                        ajf.oTA.add(cgx);
                    }
                    AppMethodBeat.o(104774);
                    return 0;
                default:
                    AppMethodBeat.o(104774);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104774);
            return -1;
        }
    }
}

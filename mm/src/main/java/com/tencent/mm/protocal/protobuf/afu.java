package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class afu extends a {
    public LinkedList<cvt> KHx = new LinkedList<>();
    public String jHa;

    public afu() {
        AppMethodBeat.i(152531);
        AppMethodBeat.o(152531);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152532);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jHa != null) {
                aVar.e(1, this.jHa);
            }
            aVar.e(2, 8, this.KHx);
            AppMethodBeat.o(152532);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.jHa != null ? g.a.a.b.b.a.f(1, this.jHa) + 0 : 0) + g.a.a.a.c(2, 8, this.KHx);
            AppMethodBeat.o(152532);
            return f2;
        } else if (i2 == 2) {
            this.KHx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152532);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            afu afu = (afu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    afu.jHa = aVar3.UbS.readString();
                    AppMethodBeat.o(152532);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cvt cvt = new cvt();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cvt.populateBuilderWithField(aVar4, cvt, a.getNextFieldNumber(aVar4))) {
                        }
                        afu.KHx.add(cvt);
                    }
                    AppMethodBeat.o(152532);
                    return 0;
                default:
                    AppMethodBeat.o(152532);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152532);
            return -1;
        }
    }
}
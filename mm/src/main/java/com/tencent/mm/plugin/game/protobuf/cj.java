package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cj extends a {
    public String hik;
    public cv xIU;
    public String xIy;
    public String xMp;
    public String xMq;
    public String xMr;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41796);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.hik != null) {
                aVar.e(1, this.hik);
            }
            if (this.xMp != null) {
                aVar.e(2, this.xMp);
            }
            if (this.xMq != null) {
                aVar.e(3, this.xMq);
            }
            if (this.xMr != null) {
                aVar.e(4, this.xMr);
            }
            if (this.xIU != null) {
                aVar.ni(5, this.xIU.computeSize());
                this.xIU.writeFields(aVar);
            }
            if (this.xIy != null) {
                aVar.e(6, this.xIy);
            }
            AppMethodBeat.o(41796);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.hik != null ? g.a.a.b.b.a.f(1, this.hik) + 0 : 0;
            if (this.xMp != null) {
                f2 += g.a.a.b.b.a.f(2, this.xMp);
            }
            if (this.xMq != null) {
                f2 += g.a.a.b.b.a.f(3, this.xMq);
            }
            if (this.xMr != null) {
                f2 += g.a.a.b.b.a.f(4, this.xMr);
            }
            if (this.xIU != null) {
                f2 += g.a.a.a.nh(5, this.xIU.computeSize());
            }
            if (this.xIy != null) {
                f2 += g.a.a.b.b.a.f(6, this.xIy);
            }
            AppMethodBeat.o(41796);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41796);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cj cjVar = (cj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cjVar.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(41796);
                    return 0;
                case 2:
                    cjVar.xMp = aVar3.UbS.readString();
                    AppMethodBeat.o(41796);
                    return 0;
                case 3:
                    cjVar.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(41796);
                    return 0;
                case 4:
                    cjVar.xMr = aVar3.UbS.readString();
                    AppMethodBeat.o(41796);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cv cvVar = new cv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cvVar.populateBuilderWithField(aVar4, cvVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cjVar.xIU = cvVar;
                    }
                    AppMethodBeat.o(41796);
                    return 0;
                case 6:
                    cjVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(41796);
                    return 0;
                default:
                    AppMethodBeat.o(41796);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41796);
            return -1;
        }
    }
}

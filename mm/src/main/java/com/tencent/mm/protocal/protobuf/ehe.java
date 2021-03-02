package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ehe extends a {
    public fbr Lsr;
    public long NgO;
    public long NgP;
    public long NgQ;
    public long NgR;
    public LinkedList<b> NgS = new LinkedList<>();
    public long begin_time;
    public long duration;
    public String text;

    public ehe() {
        AppMethodBeat.i(110911);
        AppMethodBeat.o(110911);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110912);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lsr != null) {
                aVar.ni(1, this.Lsr.computeSize());
                this.Lsr.writeFields(aVar);
            }
            aVar.bb(2, this.begin_time);
            aVar.bb(3, this.duration);
            if (this.text != null) {
                aVar.e(4, this.text);
            }
            aVar.bb(5, this.NgO);
            aVar.bb(6, this.NgP);
            aVar.bb(7, this.NgQ);
            aVar.bb(8, this.NgR);
            aVar.e(9, 6, this.NgS);
            AppMethodBeat.o(110912);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Lsr != null ? g.a.a.a.nh(1, this.Lsr.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.begin_time) + g.a.a.b.b.a.r(3, this.duration);
            if (this.text != null) {
                nh += g.a.a.b.b.a.f(4, this.text);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.NgO) + g.a.a.b.b.a.r(6, this.NgP) + g.a.a.b.b.a.r(7, this.NgQ) + g.a.a.b.b.a.r(8, this.NgR) + g.a.a.a.c(9, 6, this.NgS);
            AppMethodBeat.o(110912);
            return r;
        } else if (i2 == 2) {
            this.NgS.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110912);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ehe ehe = (ehe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fbr fbr = new fbr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fbr.populateBuilderWithField(aVar4, fbr, a.getNextFieldNumber(aVar4))) {
                        }
                        ehe.Lsr = fbr;
                    }
                    AppMethodBeat.o(110912);
                    return 0;
                case 2:
                    ehe.begin_time = aVar3.UbS.zl();
                    AppMethodBeat.o(110912);
                    return 0;
                case 3:
                    ehe.duration = aVar3.UbS.zl();
                    AppMethodBeat.o(110912);
                    return 0;
                case 4:
                    ehe.text = aVar3.UbS.readString();
                    AppMethodBeat.o(110912);
                    return 0;
                case 5:
                    ehe.NgO = aVar3.UbS.zl();
                    AppMethodBeat.o(110912);
                    return 0;
                case 6:
                    ehe.NgP = aVar3.UbS.zl();
                    AppMethodBeat.o(110912);
                    return 0;
                case 7:
                    ehe.NgQ = aVar3.UbS.zl();
                    AppMethodBeat.o(110912);
                    return 0;
                case 8:
                    ehe.NgR = aVar3.UbS.zl();
                    AppMethodBeat.o(110912);
                    return 0;
                case 9:
                    ehe.NgS.add(aVar3.UbS.hPo());
                    AppMethodBeat.o(110912);
                    return 0;
                default:
                    AppMethodBeat.o(110912);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110912);
            return -1;
        }
    }
}

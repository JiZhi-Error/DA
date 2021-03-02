package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bpl extends dop {
    public boolean AqQ;
    public String KDQ;
    public b LFp;
    public long hyH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(207473);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LFp != null) {
                aVar.c(2, this.LFp);
            }
            aVar.bb(3, this.hyH);
            if (this.KDQ != null) {
                aVar.e(4, this.KDQ);
            }
            aVar.cc(5, this.AqQ);
            AppMethodBeat.o(207473);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LFp != null) {
                nh += g.a.a.b.b.a.b(2, this.LFp);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.hyH);
            if (this.KDQ != null) {
                r += g.a.a.b.b.a.f(4, this.KDQ);
            }
            int fS = r + g.a.a.b.b.a.fS(5) + 1;
            AppMethodBeat.o(207473);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(207473);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bpl bpl = (bpl) objArr[1];
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
                        bpl.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(207473);
                    return 0;
                case 2:
                    bpl.LFp = aVar3.UbS.hPo();
                    AppMethodBeat.o(207473);
                    return 0;
                case 3:
                    bpl.hyH = aVar3.UbS.zl();
                    AppMethodBeat.o(207473);
                    return 0;
                case 4:
                    bpl.KDQ = aVar3.UbS.readString();
                    AppMethodBeat.o(207473);
                    return 0;
                case 5:
                    bpl.AqQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(207473);
                    return 0;
                default:
                    AppMethodBeat.o(207473);
                    return -1;
            }
        } else {
            AppMethodBeat.o(207473);
            return -1;
        }
    }
}

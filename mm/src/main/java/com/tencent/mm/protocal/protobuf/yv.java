package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class yv extends dop {
    public jl LjV;
    public String LjW;
    public long timestamp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91414);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LjV != null) {
                aVar.ni(2, this.LjV.computeSize());
                this.LjV.writeFields(aVar);
            }
            if (this.LjW != null) {
                aVar.e(3, this.LjW);
            }
            aVar.bb(4, this.timestamp);
            AppMethodBeat.o(91414);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LjV != null) {
                nh += g.a.a.a.nh(2, this.LjV.computeSize());
            }
            if (this.LjW != null) {
                nh += g.a.a.b.b.a.f(3, this.LjW);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.timestamp);
            AppMethodBeat.o(91414);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91414);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            yv yvVar = (yv) objArr[1];
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
                        yvVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91414);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        jl jlVar = new jl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = jlVar.populateBuilderWithField(aVar5, jlVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        yvVar.LjV = jlVar;
                    }
                    AppMethodBeat.o(91414);
                    return 0;
                case 3:
                    yvVar.LjW = aVar3.UbS.readString();
                    AppMethodBeat.o(91414);
                    return 0;
                case 4:
                    yvVar.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(91414);
                    return 0;
                default:
                    AppMethodBeat.o(91414);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91414);
            return -1;
        }
    }
}

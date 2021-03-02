package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.LinkedList;

public final class a extends dop {
    public String jfi;
    public int xub;
    public String xuc;
    public long xud;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(40860);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.xub);
            if (this.xuc != null) {
                aVar.e(3, this.xuc);
            }
            if (this.jfi != null) {
                aVar.e(4, this.jfi);
            }
            aVar.bb(5, this.xud);
            AppMethodBeat.o(40860);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.xub);
            if (this.xuc != null) {
                nh += g.a.a.b.b.a.f(3, this.xuc);
            }
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(4, this.jfi);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.xud);
            AppMethodBeat.o(40860);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(40860);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar5, jrVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(40860);
                    return 0;
                case 2:
                    aVar4.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(40860);
                    return 0;
                case 3:
                    aVar4.xuc = aVar3.UbS.readString();
                    AppMethodBeat.o(40860);
                    return 0;
                case 4:
                    aVar4.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(40860);
                    return 0;
                case 5:
                    aVar4.xud = aVar3.UbS.zl();
                    AppMethodBeat.o(40860);
                    return 0;
                default:
                    AppMethodBeat.o(40860);
                    return -1;
            }
        } else {
            AppMethodBeat.o(40860);
            return -1;
        }
    }
}

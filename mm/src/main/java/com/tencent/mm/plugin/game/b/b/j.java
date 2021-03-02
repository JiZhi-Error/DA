package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.c.a;
import java.util.LinkedList;

public final class j extends dop {
    public LinkedList<i> xuZ = new LinkedList<>();
    public int xub;
    public String xva;
    public String xvb;

    public j() {
        AppMethodBeat.i(40876);
        AppMethodBeat.o(40876);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(40877);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.xub);
            aVar.e(3, 8, this.xuZ);
            if (this.xva != null) {
                aVar.e(4, this.xva);
            }
            if (this.xvb != null) {
                aVar.e(5, this.xvb);
            }
            AppMethodBeat.o(40877);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.xub) + g.a.a.a.c(3, 8, this.xuZ);
            if (this.xva != null) {
                nh += g.a.a.b.b.a.f(4, this.xva);
            }
            if (this.xvb != null) {
                nh += g.a.a.b.b.a.f(5, this.xvb);
            }
            AppMethodBeat.o(40877);
            return nh;
        } else if (i2 == 2) {
            this.xuZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(40877);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
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
                        jVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(40877);
                    return 0;
                case 2:
                    jVar.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(40877);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        i iVar = new i();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = iVar.populateBuilderWithField(aVar5, iVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        jVar.xuZ.add(iVar);
                    }
                    AppMethodBeat.o(40877);
                    return 0;
                case 4:
                    jVar.xva = aVar3.UbS.readString();
                    AppMethodBeat.o(40877);
                    return 0;
                case 5:
                    jVar.xvb = aVar3.UbS.readString();
                    AppMethodBeat.o(40877);
                    return 0;
                default:
                    AppMethodBeat.o(40877);
                    return -1;
            }
        } else {
            AppMethodBeat.o(40877);
            return -1;
        }
    }
}

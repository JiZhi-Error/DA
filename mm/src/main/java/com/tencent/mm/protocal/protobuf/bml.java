package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bml extends a {
    public int KXD;
    public doo LVf;
    public cju LVg;
    public int LVh;
    public boolean LVi;
    public boolean LVj;
    public int LVk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(175244);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LVf != null) {
                aVar.ni(1, this.LVf.computeSize());
                this.LVf.writeFields(aVar);
            }
            if (this.LVg != null) {
                aVar.ni(2, this.LVg.computeSize());
                this.LVg.writeFields(aVar);
            }
            aVar.aM(3, this.LVh);
            aVar.aM(4, this.KXD);
            aVar.cc(5, this.LVi);
            aVar.cc(6, this.LVj);
            aVar.aM(7, this.LVk);
            AppMethodBeat.o(175244);
            return 0;
        } else if (i2 == 1) {
            int nh = this.LVf != null ? g.a.a.a.nh(1, this.LVf.computeSize()) + 0 : 0;
            if (this.LVg != null) {
                nh += g.a.a.a.nh(2, this.LVg.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.LVh) + g.a.a.b.b.a.bu(4, this.KXD) + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.fS(6) + 1 + g.a.a.b.b.a.bu(7, this.LVk);
            AppMethodBeat.o(175244);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(175244);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bml bml = (bml) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        doo doo = new doo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = doo.populateBuilderWithField(aVar4, doo, a.getNextFieldNumber(aVar4))) {
                        }
                        bml.LVf = doo;
                    }
                    AppMethodBeat.o(175244);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cju cju = new cju();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cju.populateBuilderWithField(aVar5, cju, a.getNextFieldNumber(aVar5))) {
                        }
                        bml.LVg = cju;
                    }
                    AppMethodBeat.o(175244);
                    return 0;
                case 3:
                    bml.LVh = aVar3.UbS.zi();
                    AppMethodBeat.o(175244);
                    return 0;
                case 4:
                    bml.KXD = aVar3.UbS.zi();
                    AppMethodBeat.o(175244);
                    return 0;
                case 5:
                    bml.LVi = aVar3.UbS.yZ();
                    AppMethodBeat.o(175244);
                    return 0;
                case 6:
                    bml.LVj = aVar3.UbS.yZ();
                    AppMethodBeat.o(175244);
                    return 0;
                case 7:
                    bml.LVk = aVar3.UbS.zi();
                    AppMethodBeat.o(175244);
                    return 0;
                default:
                    AppMethodBeat.o(175244);
                    return -1;
            }
        } else {
            AppMethodBeat.o(175244);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ctm extends dop {
    public b LXC;
    public int Myo;
    public int Myp;
    public b Myq;
    public int Myr;
    public String Mys;
    public String Myt;
    public String Myu;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(120957);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.Myo);
            aVar.aM(3, this.Myp);
            if (this.Myq != null) {
                aVar.c(4, this.Myq);
            }
            aVar.aM(5, this.Myr);
            if (this.LXC != null) {
                aVar.c(6, this.LXC);
            }
            if (this.Mys != null) {
                aVar.e(7, this.Mys);
            }
            if (this.Myt != null) {
                aVar.e(8, this.Myt);
            }
            if (this.Myu != null) {
                aVar.e(9, this.Myu);
            }
            aVar.aM(10, this.Scene);
            AppMethodBeat.o(120957);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Myo) + g.a.a.b.b.a.bu(3, this.Myp);
            if (this.Myq != null) {
                nh += g.a.a.b.b.a.b(4, this.Myq);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.Myr);
            if (this.LXC != null) {
                bu += g.a.a.b.b.a.b(6, this.LXC);
            }
            if (this.Mys != null) {
                bu += g.a.a.b.b.a.f(7, this.Mys);
            }
            if (this.Myt != null) {
                bu += g.a.a.b.b.a.f(8, this.Myt);
            }
            if (this.Myu != null) {
                bu += g.a.a.b.b.a.f(9, this.Myu);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.Scene);
            AppMethodBeat.o(120957);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(120957);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctm ctm = (ctm) objArr[1];
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
                        ctm.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(120957);
                    return 0;
                case 2:
                    ctm.Myo = aVar3.UbS.zi();
                    AppMethodBeat.o(120957);
                    return 0;
                case 3:
                    ctm.Myp = aVar3.UbS.zi();
                    AppMethodBeat.o(120957);
                    return 0;
                case 4:
                    ctm.Myq = aVar3.UbS.hPo();
                    AppMethodBeat.o(120957);
                    return 0;
                case 5:
                    ctm.Myr = aVar3.UbS.zi();
                    AppMethodBeat.o(120957);
                    return 0;
                case 6:
                    ctm.LXC = aVar3.UbS.hPo();
                    AppMethodBeat.o(120957);
                    return 0;
                case 7:
                    ctm.Mys = aVar3.UbS.readString();
                    AppMethodBeat.o(120957);
                    return 0;
                case 8:
                    ctm.Myt = aVar3.UbS.readString();
                    AppMethodBeat.o(120957);
                    return 0;
                case 9:
                    ctm.Myu = aVar3.UbS.readString();
                    AppMethodBeat.o(120957);
                    return 0;
                case 10:
                    ctm.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(120957);
                    return 0;
                default:
                    AppMethodBeat.o(120957);
                    return -1;
            }
        } else {
            AppMethodBeat.o(120957);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class doe extends dop {
    public long MKf;
    public long MRu;
    public String MRv;
    public int MRw;
    public int MRx;
    public int MRy;
    public long MRz;
    public int Mnc;
    public int Scene;
    public String jfi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117902);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.MRu);
            if (this.MRv != null) {
                aVar.e(3, this.MRv);
            }
            aVar.aM(4, this.Scene);
            aVar.aM(5, this.MRw);
            aVar.aM(6, this.Mnc);
            aVar.aM(7, this.MRx);
            aVar.bb(8, this.MKf);
            aVar.aM(9, this.MRy);
            if (this.jfi != null) {
                aVar.e(10, this.jfi);
            }
            aVar.bb(11, this.MRz);
            AppMethodBeat.o(117902);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.MRu);
            if (this.MRv != null) {
                nh += g.a.a.b.b.a.f(3, this.MRv);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Scene) + g.a.a.b.b.a.bu(5, this.MRw) + g.a.a.b.b.a.bu(6, this.Mnc) + g.a.a.b.b.a.bu(7, this.MRx) + g.a.a.b.b.a.r(8, this.MKf) + g.a.a.b.b.a.bu(9, this.MRy);
            if (this.jfi != null) {
                bu += g.a.a.b.b.a.f(10, this.jfi);
            }
            int r = bu + g.a.a.b.b.a.r(11, this.MRz);
            AppMethodBeat.o(117902);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117902);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            doe doe = (doe) objArr[1];
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
                        doe.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(117902);
                    return 0;
                case 2:
                    doe.MRu = aVar3.UbS.zl();
                    AppMethodBeat.o(117902);
                    return 0;
                case 3:
                    doe.MRv = aVar3.UbS.readString();
                    AppMethodBeat.o(117902);
                    return 0;
                case 4:
                    doe.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117902);
                    return 0;
                case 5:
                    doe.MRw = aVar3.UbS.zi();
                    AppMethodBeat.o(117902);
                    return 0;
                case 6:
                    doe.Mnc = aVar3.UbS.zi();
                    AppMethodBeat.o(117902);
                    return 0;
                case 7:
                    doe.MRx = aVar3.UbS.zi();
                    AppMethodBeat.o(117902);
                    return 0;
                case 8:
                    doe.MKf = aVar3.UbS.zl();
                    AppMethodBeat.o(117902);
                    return 0;
                case 9:
                    doe.MRy = aVar3.UbS.zi();
                    AppMethodBeat.o(117902);
                    return 0;
                case 10:
                    doe.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(117902);
                    return 0;
                case 11:
                    doe.MRz = aVar3.UbS.zl();
                    AppMethodBeat.o(117902);
                    return 0;
                default:
                    AppMethodBeat.o(117902);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117902);
            return -1;
        }
    }
}

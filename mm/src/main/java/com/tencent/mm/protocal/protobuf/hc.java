package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class hc extends a {
    public cvt KKL;
    public LinkedList<cvt> KKM = new LinkedList<>();
    public String dHx;
    public String dOe;

    public hc() {
        AppMethodBeat.i(152496);
        AppMethodBeat.o(152496);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152497);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dOe != null) {
                aVar.e(1, this.dOe);
            }
            if (this.KKL != null) {
                aVar.ni(2, this.KKL.computeSize());
                this.KKL.writeFields(aVar);
            }
            aVar.e(3, 8, this.KKM);
            if (this.dHx != null) {
                aVar.e(4, this.dHx);
            }
            AppMethodBeat.o(152497);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dOe != null ? g.a.a.b.b.a.f(1, this.dOe) + 0 : 0;
            if (this.KKL != null) {
                f2 += g.a.a.a.nh(2, this.KKL.computeSize());
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.KKM);
            if (this.dHx != null) {
                c2 += g.a.a.b.b.a.f(4, this.dHx);
            }
            AppMethodBeat.o(152497);
            return c2;
        } else if (i2 == 2) {
            this.KKM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152497);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            hc hcVar = (hc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hcVar.dOe = aVar3.UbS.readString();
                    AppMethodBeat.o(152497);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cvt cvt = new cvt();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cvt.populateBuilderWithField(aVar4, cvt, a.getNextFieldNumber(aVar4))) {
                        }
                        hcVar.KKL = cvt;
                    }
                    AppMethodBeat.o(152497);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cvt cvt2 = new cvt();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cvt2.populateBuilderWithField(aVar5, cvt2, a.getNextFieldNumber(aVar5))) {
                        }
                        hcVar.KKM.add(cvt2);
                    }
                    AppMethodBeat.o(152497);
                    return 0;
                case 4:
                    hcVar.dHx = aVar3.UbS.readString();
                    AppMethodBeat.o(152497);
                    return 0;
                default:
                    AppMethodBeat.o(152497);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152497);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class abz extends a {
    public String Leo;
    public String Lep;
    public long LfD;
    public String LfE;
    public String LfF;
    public bzq LmB;
    public String pRY;
    public String pRZ;
    public String qGB;
    public String title;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113985);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.pRY != null) {
                aVar.e(2, this.pRY);
            }
            if (this.pRZ != null) {
                aVar.e(3, this.pRZ);
            }
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            aVar.bb(5, this.LfD);
            if (this.LfE != null) {
                aVar.e(6, this.LfE);
            }
            if (this.LfF != null) {
                aVar.e(7, this.LfF);
            }
            if (this.qGB != null) {
                aVar.e(8, this.qGB);
            }
            if (this.LmB != null) {
                aVar.ni(9, this.LmB.computeSize());
                this.LmB.writeFields(aVar);
            }
            if (this.Leo != null) {
                aVar.e(10, this.Leo);
            }
            if (this.Lep != null) {
                aVar.e(11, this.Lep);
            }
            AppMethodBeat.o(113985);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.pRY != null) {
                f2 += g.a.a.b.b.a.f(2, this.pRY);
            }
            if (this.pRZ != null) {
                f2 += g.a.a.b.b.a.f(3, this.pRZ);
            }
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(4, this.url);
            }
            int r = f2 + g.a.a.b.b.a.r(5, this.LfD);
            if (this.LfE != null) {
                r += g.a.a.b.b.a.f(6, this.LfE);
            }
            if (this.LfF != null) {
                r += g.a.a.b.b.a.f(7, this.LfF);
            }
            if (this.qGB != null) {
                r += g.a.a.b.b.a.f(8, this.qGB);
            }
            if (this.LmB != null) {
                r += g.a.a.a.nh(9, this.LmB.computeSize());
            }
            if (this.Leo != null) {
                r += g.a.a.b.b.a.f(10, this.Leo);
            }
            if (this.Lep != null) {
                r += g.a.a.b.b.a.f(11, this.Lep);
            }
            AppMethodBeat.o(113985);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113985);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            abz abz = (abz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    abz.title = aVar3.UbS.readString();
                    AppMethodBeat.o(113985);
                    return 0;
                case 2:
                    abz.pRY = aVar3.UbS.readString();
                    AppMethodBeat.o(113985);
                    return 0;
                case 3:
                    abz.pRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(113985);
                    return 0;
                case 4:
                    abz.url = aVar3.UbS.readString();
                    AppMethodBeat.o(113985);
                    return 0;
                case 5:
                    abz.LfD = aVar3.UbS.zl();
                    AppMethodBeat.o(113985);
                    return 0;
                case 6:
                    abz.LfE = aVar3.UbS.readString();
                    AppMethodBeat.o(113985);
                    return 0;
                case 7:
                    abz.LfF = aVar3.UbS.readString();
                    AppMethodBeat.o(113985);
                    return 0;
                case 8:
                    abz.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(113985);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bzq bzq = new bzq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bzq.populateBuilderWithField(aVar4, bzq, a.getNextFieldNumber(aVar4))) {
                        }
                        abz.LmB = bzq;
                    }
                    AppMethodBeat.o(113985);
                    return 0;
                case 10:
                    abz.Leo = aVar3.UbS.readString();
                    AppMethodBeat.o(113985);
                    return 0;
                case 11:
                    abz.Lep = aVar3.UbS.readString();
                    AppMethodBeat.o(113985);
                    return 0;
                default:
                    AppMethodBeat.o(113985);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113985);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ffc extends a {
    public String NAt;
    public String NAu;
    public LinkedList<cxp> NAv = new LinkedList<>();
    public String NAw;
    public int NAx;
    public String Title;

    public ffc() {
        AppMethodBeat.i(50125);
        AppMethodBeat.o(50125);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50126);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NAt != null) {
                aVar.e(1, this.NAt);
            }
            if (this.NAu != null) {
                aVar.e(2, this.NAu);
            }
            aVar.e(3, 8, this.NAv);
            if (this.NAw != null) {
                aVar.e(4, this.NAw);
            }
            aVar.aM(5, this.NAx);
            if (this.Title != null) {
                aVar.e(6, this.Title);
            }
            AppMethodBeat.o(50126);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.NAt != null ? g.a.a.b.b.a.f(1, this.NAt) + 0 : 0;
            if (this.NAu != null) {
                f2 += g.a.a.b.b.a.f(2, this.NAu);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.NAv);
            if (this.NAw != null) {
                c2 += g.a.a.b.b.a.f(4, this.NAw);
            }
            int bu = c2 + g.a.a.b.b.a.bu(5, this.NAx);
            if (this.Title != null) {
                bu += g.a.a.b.b.a.f(6, this.Title);
            }
            AppMethodBeat.o(50126);
            return bu;
        } else if (i2 == 2) {
            this.NAv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50126);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ffc ffc = (ffc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ffc.NAt = aVar3.UbS.readString();
                    AppMethodBeat.o(50126);
                    return 0;
                case 2:
                    ffc.NAu = aVar3.UbS.readString();
                    AppMethodBeat.o(50126);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cxp cxp = new cxp();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cxp.populateBuilderWithField(aVar4, cxp, a.getNextFieldNumber(aVar4))) {
                        }
                        ffc.NAv.add(cxp);
                    }
                    AppMethodBeat.o(50126);
                    return 0;
                case 4:
                    ffc.NAw = aVar3.UbS.readString();
                    AppMethodBeat.o(50126);
                    return 0;
                case 5:
                    ffc.NAx = aVar3.UbS.zi();
                    AppMethodBeat.o(50126);
                    return 0;
                case 6:
                    ffc.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(50126);
                    return 0;
                default:
                    AppMethodBeat.o(50126);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50126);
            return -1;
        }
    }
}

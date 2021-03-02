package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amv;
import java.util.LinkedList;

public final class c extends a {
    public String BGs;
    public amv KBr;
    public String desc;
    public LinkedList<aml> iAd = new LinkedList<>();
    public long rnM;
    public String title;

    public c() {
        AppMethodBeat.i(94808);
        AppMethodBeat.o(94808);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(94809);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.e(3, 8, this.iAd);
            if (this.BGs != null) {
                aVar.e(4, this.BGs);
            }
            if (this.KBr != null) {
                aVar.ni(5, this.KBr.computeSize());
                this.KBr.writeFields(aVar);
            }
            aVar.bb(6, this.rnM);
            AppMethodBeat.o(94809);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.iAd);
            if (this.BGs != null) {
                c2 += g.a.a.b.b.a.f(4, this.BGs);
            }
            if (this.KBr != null) {
                c2 += g.a.a.a.nh(5, this.KBr.computeSize());
            }
            int r = c2 + g.a.a.b.b.a.r(6, this.rnM);
            AppMethodBeat.o(94809);
            return r;
        } else if (i2 == 2) {
            this.iAd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(94809);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(94809);
                    return 0;
                case 2:
                    cVar.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(94809);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aml aml = new aml();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aml.populateBuilderWithField(aVar4, aml, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.iAd.add(aml);
                    }
                    AppMethodBeat.o(94809);
                    return 0;
                case 4:
                    cVar.BGs = aVar3.UbS.readString();
                    AppMethodBeat.o(94809);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        amv amv = new amv();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = amv.populateBuilderWithField(aVar5, amv, a.getNextFieldNumber(aVar5))) {
                        }
                        cVar.KBr = amv;
                    }
                    AppMethodBeat.o(94809);
                    return 0;
                case 6:
                    cVar.rnM = aVar3.UbS.zl();
                    AppMethodBeat.o(94809);
                    return 0;
                default:
                    AppMethodBeat.o(94809);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94809);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class dzj extends a {
    public long Id;
    public long MZa;
    public dzi MZb;
    public dzi MZc;
    public String izX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125772);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MZb == null) {
                b bVar = new b("Not all required fields were included: CurrentAction");
                AppMethodBeat.o(125772);
                throw bVar;
            }
            aVar.bb(1, this.Id);
            aVar.bb(2, this.MZa);
            if (this.MZb != null) {
                aVar.ni(3, this.MZb.computeSize());
                this.MZb.writeFields(aVar);
            }
            if (this.MZc != null) {
                aVar.ni(4, this.MZc.computeSize());
                this.MZc.writeFields(aVar);
            }
            if (this.izX != null) {
                aVar.e(5, this.izX);
            }
            AppMethodBeat.o(125772);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Id) + 0 + g.a.a.b.b.a.r(2, this.MZa);
            if (this.MZb != null) {
                r += g.a.a.a.nh(3, this.MZb.computeSize());
            }
            if (this.MZc != null) {
                r += g.a.a.a.nh(4, this.MZc.computeSize());
            }
            if (this.izX != null) {
                r += g.a.a.b.b.a.f(5, this.izX);
            }
            AppMethodBeat.o(125772);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MZb == null) {
                b bVar2 = new b("Not all required fields were included: CurrentAction");
                AppMethodBeat.o(125772);
                throw bVar2;
            }
            AppMethodBeat.o(125772);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dzj dzj = (dzj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dzj.Id = aVar3.UbS.zl();
                    AppMethodBeat.o(125772);
                    return 0;
                case 2:
                    dzj.MZa = aVar3.UbS.zl();
                    AppMethodBeat.o(125772);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dzi dzi = new dzi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dzi.populateBuilderWithField(aVar4, dzi, a.getNextFieldNumber(aVar4))) {
                        }
                        dzj.MZb = dzi;
                    }
                    AppMethodBeat.o(125772);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dzi dzi2 = new dzi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dzi2.populateBuilderWithField(aVar5, dzi2, a.getNextFieldNumber(aVar5))) {
                        }
                        dzj.MZc = dzi2;
                    }
                    AppMethodBeat.o(125772);
                    return 0;
                case 5:
                    dzj.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(125772);
                    return 0;
                default:
                    AppMethodBeat.o(125772);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125772);
            return -1;
        }
    }
}

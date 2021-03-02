package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class elj extends a {
    public cig Nkp;
    public cig Nkq;
    public String content;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72616);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.content != null) {
                aVar.e(2, this.content);
            }
            if (this.Nkp != null) {
                aVar.ni(3, this.Nkp.computeSize());
                this.Nkp.writeFields(aVar);
            }
            if (this.Nkq != null) {
                aVar.ni(4, this.Nkq.computeSize());
                this.Nkq.writeFields(aVar);
            }
            AppMethodBeat.o(72616);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.content != null) {
                f2 += g.a.a.b.b.a.f(2, this.content);
            }
            if (this.Nkp != null) {
                f2 += g.a.a.a.nh(3, this.Nkp.computeSize());
            }
            if (this.Nkq != null) {
                f2 += g.a.a.a.nh(4, this.Nkq.computeSize());
            }
            AppMethodBeat.o(72616);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72616);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            elj elj = (elj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    elj.title = aVar3.UbS.readString();
                    AppMethodBeat.o(72616);
                    return 0;
                case 2:
                    elj.content = aVar3.UbS.readString();
                    AppMethodBeat.o(72616);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cig cig = new cig();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cig.populateBuilderWithField(aVar4, cig, a.getNextFieldNumber(aVar4))) {
                        }
                        elj.Nkp = cig;
                    }
                    AppMethodBeat.o(72616);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cig cig2 = new cig();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cig2.populateBuilderWithField(aVar5, cig2, a.getNextFieldNumber(aVar5))) {
                        }
                        elj.Nkq = cig2;
                    }
                    AppMethodBeat.o(72616);
                    return 0;
                default:
                    AppMethodBeat.o(72616);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72616);
            return -1;
        }
    }
}

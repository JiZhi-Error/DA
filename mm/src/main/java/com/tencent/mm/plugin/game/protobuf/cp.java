package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cp extends a {
    public String Title;
    public LinkedList<cq> xMy = new LinkedList<>();
    public cr xMz;

    public cp() {
        AppMethodBeat.i(41802);
        AppMethodBeat.o(41802);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41803);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title == null) {
                b bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41803);
                throw bVar;
            }
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            aVar.e(2, 8, this.xMy);
            if (this.xMz != null) {
                aVar.ni(3, this.xMz.computeSize());
                this.xMz.writeFields(aVar);
            }
            AppMethodBeat.o(41803);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0) + g.a.a.a.c(2, 8, this.xMy);
            if (this.xMz != null) {
                f2 += g.a.a.a.nh(3, this.xMz.computeSize());
            }
            AppMethodBeat.o(41803);
            return f2;
        } else if (i2 == 2) {
            this.xMy.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Title == null) {
                b bVar2 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41803);
                throw bVar2;
            }
            AppMethodBeat.o(41803);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cp cpVar = (cp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cpVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41803);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cq cqVar = new cq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cqVar.populateBuilderWithField(aVar4, cqVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cpVar.xMy.add(cqVar);
                    }
                    AppMethodBeat.o(41803);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cr crVar = new cr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = crVar.populateBuilderWithField(aVar5, crVar, a.getNextFieldNumber(aVar5))) {
                        }
                        cpVar.xMz = crVar;
                    }
                    AppMethodBeat.o(41803);
                    return 0;
                default:
                    AppMethodBeat.o(41803);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41803);
            return -1;
        }
    }
}

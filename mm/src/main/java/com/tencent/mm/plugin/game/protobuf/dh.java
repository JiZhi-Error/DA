package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dh extends a {
    public String Desc;
    public String Title;
    public String jfi;
    public String xIx;
    public g xIz;
    public String xKf;
    public String xLk;
    public LinkedList<ag> xMV = new LinkedList<>();

    public dh() {
        AppMethodBeat.i(41823);
        AppMethodBeat.o(41823);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41824);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            if (this.xIx != null) {
                aVar.e(3, this.xIx);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            if (this.xLk != null) {
                aVar.e(5, this.xLk);
            }
            if (this.xIz != null) {
                aVar.ni(6, this.xIz.computeSize());
                this.xIz.writeFields(aVar);
            }
            aVar.e(7, 8, this.xMV);
            if (this.xKf != null) {
                aVar.e(8, this.xKf);
            }
            AppMethodBeat.o(41824);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.jfi != null) {
                f2 += g.a.a.b.b.a.f(2, this.jfi);
            }
            if (this.xIx != null) {
                f2 += g.a.a.b.b.a.f(3, this.xIx);
            }
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.xLk != null) {
                f2 += g.a.a.b.b.a.f(5, this.xLk);
            }
            if (this.xIz != null) {
                f2 += g.a.a.a.nh(6, this.xIz.computeSize());
            }
            int c2 = f2 + g.a.a.a.c(7, 8, this.xMV);
            if (this.xKf != null) {
                c2 += g.a.a.b.b.a.f(8, this.xKf);
            }
            AppMethodBeat.o(41824);
            return c2;
        } else if (i2 == 2) {
            this.xMV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41824);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dh dhVar = (dh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dhVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41824);
                    return 0;
                case 2:
                    dhVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(41824);
                    return 0;
                case 3:
                    dhVar.xIx = aVar3.UbS.readString();
                    AppMethodBeat.o(41824);
                    return 0;
                case 4:
                    dhVar.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(41824);
                    return 0;
                case 5:
                    dhVar.xLk = aVar3.UbS.readString();
                    AppMethodBeat.o(41824);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        g gVar = new g();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dhVar.xIz = gVar;
                    }
                    AppMethodBeat.o(41824);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ag agVar = new ag();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = agVar.populateBuilderWithField(aVar5, agVar, a.getNextFieldNumber(aVar5))) {
                        }
                        dhVar.xMV.add(agVar);
                    }
                    AppMethodBeat.o(41824);
                    return 0;
                case 8:
                    dhVar.xKf = aVar3.UbS.readString();
                    AppMethodBeat.o(41824);
                    return 0;
                default:
                    AppMethodBeat.o(41824);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41824);
            return -1;
        }
    }
}

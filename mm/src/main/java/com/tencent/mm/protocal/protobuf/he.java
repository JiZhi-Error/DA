package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class he extends a {
    public String KHk;
    public String KKN;
    public hf KKO;
    public String Name;
    public String Title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125712);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KKO == null) {
                b bVar = new b("Not all required fields were included: ArtisIcon");
                AppMethodBeat.o(125712);
                throw bVar;
            }
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.KKN != null) {
                aVar.e(3, this.KKN);
            }
            if (this.KHk != null) {
                aVar.e(4, this.KHk);
            }
            if (this.KKO != null) {
                aVar.ni(5, this.KKO.computeSize());
                this.KKO.writeFields(aVar);
            }
            AppMethodBeat.o(125712);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Name != null ? g.a.a.b.b.a.f(1, this.Name) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.KKN != null) {
                f2 += g.a.a.b.b.a.f(3, this.KKN);
            }
            if (this.KHk != null) {
                f2 += g.a.a.b.b.a.f(4, this.KHk);
            }
            if (this.KKO != null) {
                f2 += g.a.a.a.nh(5, this.KKO.computeSize());
            }
            AppMethodBeat.o(125712);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KKO == null) {
                b bVar2 = new b("Not all required fields were included: ArtisIcon");
                AppMethodBeat.o(125712);
                throw bVar2;
            }
            AppMethodBeat.o(125712);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            he heVar = (he) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    heVar.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(125712);
                    return 0;
                case 2:
                    heVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(125712);
                    return 0;
                case 3:
                    heVar.KKN = aVar3.UbS.readString();
                    AppMethodBeat.o(125712);
                    return 0;
                case 4:
                    heVar.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(125712);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        hf hfVar = new hf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = hfVar.populateBuilderWithField(aVar4, hfVar, a.getNextFieldNumber(aVar4))) {
                        }
                        heVar.KKO = hfVar;
                    }
                    AppMethodBeat.o(125712);
                    return 0;
                default:
                    AppMethodBeat.o(125712);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125712);
            return -1;
        }
    }
}

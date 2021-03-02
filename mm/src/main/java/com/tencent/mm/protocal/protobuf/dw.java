package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class dw extends a {
    public LinkedList<bzz> GroupList = new LinkedList<>();
    public he KHT;
    public String xLl;

    public dw() {
        AppMethodBeat.i(125706);
        AppMethodBeat.o(125706);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125707);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KHT == null) {
                b bVar = new b("Not all required fields were included: ArtisAuthor");
                AppMethodBeat.o(125707);
                throw bVar;
            }
            if (this.KHT != null) {
                aVar.ni(1, this.KHT.computeSize());
                this.KHT.writeFields(aVar);
            }
            aVar.e(2, 8, this.GroupList);
            if (this.xLl != null) {
                aVar.e(3, this.xLl);
            }
            AppMethodBeat.o(125707);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.KHT != null ? g.a.a.a.nh(1, this.KHT.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.GroupList);
            if (this.xLl != null) {
                nh += g.a.a.b.b.a.f(3, this.xLl);
            }
            AppMethodBeat.o(125707);
            return nh;
        } else if (i2 == 2) {
            this.GroupList.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KHT == null) {
                b bVar2 = new b("Not all required fields were included: ArtisAuthor");
                AppMethodBeat.o(125707);
                throw bVar2;
            }
            AppMethodBeat.o(125707);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dw dwVar = (dw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        he heVar = new he();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = heVar.populateBuilderWithField(aVar4, heVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dwVar.KHT = heVar;
                    }
                    AppMethodBeat.o(125707);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bzz bzz = new bzz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bzz.populateBuilderWithField(aVar5, bzz, a.getNextFieldNumber(aVar5))) {
                        }
                        dwVar.GroupList.add(bzz);
                    }
                    AppMethodBeat.o(125707);
                    return 0;
                case 3:
                    dwVar.xLl = aVar3.UbS.readString();
                    AppMethodBeat.o(125707);
                    return 0;
                default:
                    AppMethodBeat.o(125707);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125707);
            return -1;
        }
    }
}

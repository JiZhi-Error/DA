package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class fbh extends a {
    public String LzG;
    public String LzI;
    public fbg Nxt;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110858);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LzG == null) {
                b bVar = new b("Not all required fields were included: Rid");
                AppMethodBeat.o(110858);
                throw bVar;
            } else if (this.LzI == null) {
                b bVar2 = new b("Not all required fields were included: MimeType");
                AppMethodBeat.o(110858);
                throw bVar2;
            } else if (this.Nxt == null) {
                b bVar3 = new b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.o(110858);
                throw bVar3;
            } else {
                if (this.LzG != null) {
                    aVar.e(1, this.LzG);
                }
                if (this.LzI != null) {
                    aVar.e(2, this.LzI);
                }
                if (this.Nxt != null) {
                    aVar.ni(3, this.Nxt.computeSize());
                    this.Nxt.writeFields(aVar);
                }
                AppMethodBeat.o(110858);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.LzG != null ? g.a.a.b.b.a.f(1, this.LzG) + 0 : 0;
            if (this.LzI != null) {
                f2 += g.a.a.b.b.a.f(2, this.LzI);
            }
            if (this.Nxt != null) {
                f2 += g.a.a.a.nh(3, this.Nxt.computeSize());
            }
            AppMethodBeat.o(110858);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LzG == null) {
                b bVar4 = new b("Not all required fields were included: Rid");
                AppMethodBeat.o(110858);
                throw bVar4;
            } else if (this.LzI == null) {
                b bVar5 = new b("Not all required fields were included: MimeType");
                AppMethodBeat.o(110858);
                throw bVar5;
            } else if (this.Nxt == null) {
                b bVar6 = new b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.o(110858);
                throw bVar6;
            } else {
                AppMethodBeat.o(110858);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbh fbh = (fbh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fbh.LzG = aVar3.UbS.readString();
                    AppMethodBeat.o(110858);
                    return 0;
                case 2:
                    fbh.LzI = aVar3.UbS.readString();
                    AppMethodBeat.o(110858);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fbg fbg = new fbg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fbg.populateBuilderWithField(aVar4, fbg, a.getNextFieldNumber(aVar4))) {
                        }
                        fbh.Nxt = fbg;
                    }
                    AppMethodBeat.o(110858);
                    return 0;
                default:
                    AppMethodBeat.o(110858);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110858);
            return -1;
        }
    }
}

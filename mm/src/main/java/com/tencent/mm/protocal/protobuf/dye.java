package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dye extends a {
    public epg MXR;
    public String MXS;
    public String MXT;
    public String name;
    public String value;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200224);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            if (this.value != null) {
                aVar.e(2, this.value);
            }
            if (this.MXR != null) {
                aVar.ni(3, this.MXR.computeSize());
                this.MXR.writeFields(aVar);
            }
            if (this.MXS != null) {
                aVar.e(4, this.MXS);
            }
            if (this.MXT != null) {
                aVar.e(5, this.MXT);
            }
            AppMethodBeat.o(200224);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.name != null ? g.a.a.b.b.a.f(1, this.name) + 0 : 0;
            if (this.value != null) {
                f2 += g.a.a.b.b.a.f(2, this.value);
            }
            if (this.MXR != null) {
                f2 += g.a.a.a.nh(3, this.MXR.computeSize());
            }
            if (this.MXS != null) {
                f2 += g.a.a.b.b.a.f(4, this.MXS);
            }
            if (this.MXT != null) {
                f2 += g.a.a.b.b.a.f(5, this.MXT);
            }
            AppMethodBeat.o(200224);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200224);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dye dye = (dye) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dye.name = aVar3.UbS.readString();
                    AppMethodBeat.o(200224);
                    return 0;
                case 2:
                    dye.value = aVar3.UbS.readString();
                    AppMethodBeat.o(200224);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        epg epg = new epg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = epg.populateBuilderWithField(aVar4, epg, a.getNextFieldNumber(aVar4))) {
                        }
                        dye.MXR = epg;
                    }
                    AppMethodBeat.o(200224);
                    return 0;
                case 4:
                    dye.MXS = aVar3.UbS.readString();
                    AppMethodBeat.o(200224);
                    return 0;
                case 5:
                    dye.MXT = aVar3.UbS.readString();
                    AppMethodBeat.o(200224);
                    return 0;
                default:
                    AppMethodBeat.o(200224);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200224);
            return -1;
        }
    }
}

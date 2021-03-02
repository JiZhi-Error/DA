package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dug extends dop {
    public String Bri;
    public int Mnv;
    public LinkedList<dqi> Mnw = new LinkedList<>();

    public dug() {
        AppMethodBeat.i(155461);
        AppMethodBeat.o(155461);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155462);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Bri != null) {
                aVar.e(2, this.Bri);
            }
            aVar.aM(3, this.Mnv);
            aVar.e(4, 8, this.Mnw);
            AppMethodBeat.o(155462);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Bri != null) {
                nh += g.a.a.b.b.a.f(2, this.Bri);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.Mnv) + g.a.a.a.c(4, 8, this.Mnw);
            AppMethodBeat.o(155462);
            return bu;
        } else if (i2 == 2) {
            this.Mnw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155462);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dug dug = (dug) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        dug.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(155462);
                    return 0;
                case 2:
                    dug.Bri = aVar3.UbS.readString();
                    AppMethodBeat.o(155462);
                    return 0;
                case 3:
                    dug.Mnv = aVar3.UbS.zi();
                    AppMethodBeat.o(155462);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        dug.Mnw.add(dqi);
                    }
                    AppMethodBeat.o(155462);
                    return 0;
                default:
                    AppMethodBeat.o(155462);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155462);
            return -1;
        }
    }
}

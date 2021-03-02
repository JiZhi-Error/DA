package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ddy extends dop {
    public int LVh;
    public boolean MIZ;
    public int Meg;
    public String dNI;
    public String path;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123636);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            if (this.dNI != null) {
                aVar.e(3, this.dNI);
            }
            aVar.aM(4, this.Meg);
            if (this.path != null) {
                aVar.e(5, this.path);
            }
            aVar.aM(6, this.LVh);
            aVar.cc(7, this.MIZ);
            AppMethodBeat.o(123636);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(2, this.username);
            }
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(3, this.dNI);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Meg);
            if (this.path != null) {
                bu += g.a.a.b.b.a.f(5, this.path);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.LVh) + g.a.a.b.b.a.fS(7) + 1;
            AppMethodBeat.o(123636);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123636);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddy ddy = (ddy) objArr[1];
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
                        ddy.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123636);
                    return 0;
                case 2:
                    ddy.username = aVar3.UbS.readString();
                    AppMethodBeat.o(123636);
                    return 0;
                case 3:
                    ddy.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(123636);
                    return 0;
                case 4:
                    ddy.Meg = aVar3.UbS.zi();
                    AppMethodBeat.o(123636);
                    return 0;
                case 5:
                    ddy.path = aVar3.UbS.readString();
                    AppMethodBeat.o(123636);
                    return 0;
                case 6:
                    ddy.LVh = aVar3.UbS.zi();
                    AppMethodBeat.o(123636);
                    return 0;
                case 7:
                    ddy.MIZ = aVar3.UbS.yZ();
                    AppMethodBeat.o(123636);
                    return 0;
                default:
                    AppMethodBeat.o(123636);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123636);
            return -1;
        }
    }
}

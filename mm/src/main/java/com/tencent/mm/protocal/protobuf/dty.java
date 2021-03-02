package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dty extends dop {
    public String KIz;
    public String MKC;
    public String MVH;
    public String MVI;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(207015);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MKC != null) {
                aVar.e(2, this.MKC);
            }
            if (this.MVH != null) {
                aVar.e(3, this.MVH);
            }
            if (this.MVI != null) {
                aVar.e(4, this.MVI);
            }
            if (this.KIz != null) {
                aVar.e(5, this.KIz);
            }
            aVar.aM(6, this.Scene);
            AppMethodBeat.o(207015);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MKC != null) {
                nh += g.a.a.b.b.a.f(2, this.MKC);
            }
            if (this.MVH != null) {
                nh += g.a.a.b.b.a.f(3, this.MVH);
            }
            if (this.MVI != null) {
                nh += g.a.a.b.b.a.f(4, this.MVI);
            }
            if (this.KIz != null) {
                nh += g.a.a.b.b.a.f(5, this.KIz);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.Scene);
            AppMethodBeat.o(207015);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(207015);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dty dty = (dty) objArr[1];
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
                        dty.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(207015);
                    return 0;
                case 2:
                    dty.MKC = aVar3.UbS.readString();
                    AppMethodBeat.o(207015);
                    return 0;
                case 3:
                    dty.MVH = aVar3.UbS.readString();
                    AppMethodBeat.o(207015);
                    return 0;
                case 4:
                    dty.MVI = aVar3.UbS.readString();
                    AppMethodBeat.o(207015);
                    return 0;
                case 5:
                    dty.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(207015);
                    return 0;
                case 6:
                    dty.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(207015);
                    return 0;
                default:
                    AppMethodBeat.o(207015);
                    return -1;
            }
        } else {
            AppMethodBeat.o(207015);
            return -1;
        }
    }
}

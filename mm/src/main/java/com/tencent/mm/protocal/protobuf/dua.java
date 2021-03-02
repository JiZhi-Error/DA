package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dua extends dop {
    public String AAN;
    public String KHk;
    public String MVL;
    public String MVM;
    public String Name;
    public String xJz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155459);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.xJz != null) {
                aVar.e(2, this.xJz);
            }
            if (this.MVL != null) {
                aVar.e(3, this.MVL);
            }
            if (this.AAN != null) {
                aVar.e(5, this.AAN);
            }
            if (this.Name != null) {
                aVar.e(4, this.Name);
            }
            if (this.KHk != null) {
                aVar.e(6, this.KHk);
            }
            if (this.MVM != null) {
                aVar.e(7, this.MVM);
            }
            AppMethodBeat.o(155459);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.xJz != null) {
                nh += g.a.a.b.b.a.f(2, this.xJz);
            }
            if (this.MVL != null) {
                nh += g.a.a.b.b.a.f(3, this.MVL);
            }
            if (this.AAN != null) {
                nh += g.a.a.b.b.a.f(5, this.AAN);
            }
            if (this.Name != null) {
                nh += g.a.a.b.b.a.f(4, this.Name);
            }
            if (this.KHk != null) {
                nh += g.a.a.b.b.a.f(6, this.KHk);
            }
            if (this.MVM != null) {
                nh += g.a.a.b.b.a.f(7, this.MVM);
            }
            AppMethodBeat.o(155459);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155459);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dua dua = (dua) objArr[1];
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
                        dua.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(155459);
                    return 0;
                case 2:
                    dua.xJz = aVar3.UbS.readString();
                    AppMethodBeat.o(155459);
                    return 0;
                case 3:
                    dua.MVL = aVar3.UbS.readString();
                    AppMethodBeat.o(155459);
                    return 0;
                case 4:
                    dua.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(155459);
                    return 0;
                case 5:
                    dua.AAN = aVar3.UbS.readString();
                    AppMethodBeat.o(155459);
                    return 0;
                case 6:
                    dua.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(155459);
                    return 0;
                case 7:
                    dua.MVM = aVar3.UbS.readString();
                    AppMethodBeat.o(155459);
                    return 0;
                default:
                    AppMethodBeat.o(155459);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155459);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class zb extends dop {
    public String Lki;
    public String Lkj;
    public String Lkk;
    public String Lkl;
    public String Lkm;
    public String Lkn;
    public int Scene;
    public String Title;
    public String jeV;
    public String jfi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(63271);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jeV != null) {
                aVar.e(2, this.jeV);
            }
            if (this.Title != null) {
                aVar.e(3, this.Title);
            }
            if (this.Lki != null) {
                aVar.e(4, this.Lki);
            }
            if (this.Lkj != null) {
                aVar.e(5, this.Lkj);
            }
            if (this.Lkk != null) {
                aVar.e(6, this.Lkk);
            }
            if (this.Lkl != null) {
                aVar.e(7, this.Lkl);
            }
            if (this.Lkm != null) {
                aVar.e(8, this.Lkm);
            }
            if (this.jfi != null) {
                aVar.e(9, this.jfi);
            }
            aVar.aM(10, this.Scene);
            if (this.Lkn != null) {
                aVar.e(11, this.Lkn);
            }
            AppMethodBeat.o(63271);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jeV != null) {
                nh += g.a.a.b.b.a.f(2, this.jeV);
            }
            if (this.Title != null) {
                nh += g.a.a.b.b.a.f(3, this.Title);
            }
            if (this.Lki != null) {
                nh += g.a.a.b.b.a.f(4, this.Lki);
            }
            if (this.Lkj != null) {
                nh += g.a.a.b.b.a.f(5, this.Lkj);
            }
            if (this.Lkk != null) {
                nh += g.a.a.b.b.a.f(6, this.Lkk);
            }
            if (this.Lkl != null) {
                nh += g.a.a.b.b.a.f(7, this.Lkl);
            }
            if (this.Lkm != null) {
                nh += g.a.a.b.b.a.f(8, this.Lkm);
            }
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(9, this.jfi);
            }
            int bu = nh + g.a.a.b.b.a.bu(10, this.Scene);
            if (this.Lkn != null) {
                bu += g.a.a.b.b.a.f(11, this.Lkn);
            }
            AppMethodBeat.o(63271);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(63271);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            zb zbVar = (zb) objArr[1];
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
                        zbVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(63271);
                    return 0;
                case 2:
                    zbVar.jeV = aVar3.UbS.readString();
                    AppMethodBeat.o(63271);
                    return 0;
                case 3:
                    zbVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(63271);
                    return 0;
                case 4:
                    zbVar.Lki = aVar3.UbS.readString();
                    AppMethodBeat.o(63271);
                    return 0;
                case 5:
                    zbVar.Lkj = aVar3.UbS.readString();
                    AppMethodBeat.o(63271);
                    return 0;
                case 6:
                    zbVar.Lkk = aVar3.UbS.readString();
                    AppMethodBeat.o(63271);
                    return 0;
                case 7:
                    zbVar.Lkl = aVar3.UbS.readString();
                    AppMethodBeat.o(63271);
                    return 0;
                case 8:
                    zbVar.Lkm = aVar3.UbS.readString();
                    AppMethodBeat.o(63271);
                    return 0;
                case 9:
                    zbVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(63271);
                    return 0;
                case 10:
                    zbVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(63271);
                    return 0;
                case 11:
                    zbVar.Lkn = aVar3.UbS.readString();
                    AppMethodBeat.o(63271);
                    return 0;
                default:
                    AppMethodBeat.o(63271);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63271);
            return -1;
        }
    }
}

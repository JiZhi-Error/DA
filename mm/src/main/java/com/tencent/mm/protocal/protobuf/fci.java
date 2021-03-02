package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fci extends dop {
    public int LEg;
    public String Nhv;
    public LinkedList<String> Nyh = new LinkedList<>();
    public boolean Nyi;
    public String Nyj;
    public boolean Nyk;
    public boolean Nyl;
    public String dNI;

    public fci() {
        AppMethodBeat.i(153313);
        AppMethodBeat.o(153313);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153314);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            aVar.e(3, 1, this.Nyh);
            aVar.cc(4, this.Nyi);
            if (this.Nyj != null) {
                aVar.e(5, this.Nyj);
            }
            aVar.cc(6, this.Nyk);
            if (this.Nhv != null) {
                aVar.e(7, this.Nhv);
            }
            aVar.cc(8, this.Nyl);
            aVar.aM(9, this.LEg);
            AppMethodBeat.o(153314);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.Nyh) + g.a.a.b.b.a.fS(4) + 1;
            if (this.Nyj != null) {
                c2 += g.a.a.b.b.a.f(5, this.Nyj);
            }
            int fS = c2 + g.a.a.b.b.a.fS(6) + 1;
            if (this.Nhv != null) {
                fS += g.a.a.b.b.a.f(7, this.Nhv);
            }
            int fS2 = fS + g.a.a.b.b.a.fS(8) + 1 + g.a.a.b.b.a.bu(9, this.LEg);
            AppMethodBeat.o(153314);
            return fS2;
        } else if (i2 == 2) {
            this.Nyh.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153314);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fci fci = (fci) objArr[1];
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
                        fci.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(153314);
                    return 0;
                case 2:
                    fci.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(153314);
                    return 0;
                case 3:
                    fci.Nyh.add(aVar3.UbS.readString());
                    AppMethodBeat.o(153314);
                    return 0;
                case 4:
                    fci.Nyi = aVar3.UbS.yZ();
                    AppMethodBeat.o(153314);
                    return 0;
                case 5:
                    fci.Nyj = aVar3.UbS.readString();
                    AppMethodBeat.o(153314);
                    return 0;
                case 6:
                    fci.Nyk = aVar3.UbS.yZ();
                    AppMethodBeat.o(153314);
                    return 0;
                case 7:
                    fci.Nhv = aVar3.UbS.readString();
                    AppMethodBeat.o(153314);
                    return 0;
                case 8:
                    fci.Nyl = aVar3.UbS.yZ();
                    AppMethodBeat.o(153314);
                    return 0;
                case 9:
                    fci.LEg = aVar3.UbS.zi();
                    AppMethodBeat.o(153314);
                    return 0;
                default:
                    AppMethodBeat.o(153314);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153314);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ene extends a {
    public int BsF;
    public int BsG;
    public String Lsm;
    public String Lsn;
    public String Lso;
    public String MD5;
    public b Nlc;
    public boolean Nld;
    public LinkedList<String> Nle = new LinkedList<>();
    public String Nlf;

    public ene() {
        AppMethodBeat.i(104839);
        AppMethodBeat.o(104839);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104840);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nlc == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: EmojiBuffer");
                AppMethodBeat.o(104840);
                throw bVar;
            }
            if (this.MD5 != null) {
                aVar.e(1, this.MD5);
            }
            aVar.aM(2, this.BsG);
            aVar.aM(3, this.BsF);
            if (this.Nlc != null) {
                aVar.c(4, this.Nlc);
            }
            aVar.cc(5, this.Nld);
            aVar.e(6, 1, this.Nle);
            if (this.Lsm != null) {
                aVar.e(7, this.Lsm);
            }
            if (this.Nlf != null) {
                aVar.e(8, this.Nlf);
            }
            if (this.Lso != null) {
                aVar.e(9, this.Lso);
            }
            if (this.Lsn != null) {
                aVar.e(10, this.Lsn);
            }
            AppMethodBeat.o(104840);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MD5 != null ? g.a.a.b.b.a.f(1, this.MD5) + 0 : 0) + g.a.a.b.b.a.bu(2, this.BsG) + g.a.a.b.b.a.bu(3, this.BsF);
            if (this.Nlc != null) {
                f2 += g.a.a.b.b.a.b(4, this.Nlc);
            }
            int fS = f2 + g.a.a.b.b.a.fS(5) + 1 + g.a.a.a.c(6, 1, this.Nle);
            if (this.Lsm != null) {
                fS += g.a.a.b.b.a.f(7, this.Lsm);
            }
            if (this.Nlf != null) {
                fS += g.a.a.b.b.a.f(8, this.Nlf);
            }
            if (this.Lso != null) {
                fS += g.a.a.b.b.a.f(9, this.Lso);
            }
            if (this.Lsn != null) {
                fS += g.a.a.b.b.a.f(10, this.Lsn);
            }
            AppMethodBeat.o(104840);
            return fS;
        } else if (i2 == 2) {
            this.Nle.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nlc == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: EmojiBuffer");
                AppMethodBeat.o(104840);
                throw bVar2;
            }
            AppMethodBeat.o(104840);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ene ene = (ene) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ene.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(104840);
                    return 0;
                case 2:
                    ene.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(104840);
                    return 0;
                case 3:
                    ene.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(104840);
                    return 0;
                case 4:
                    ene.Nlc = aVar3.UbS.hPo();
                    AppMethodBeat.o(104840);
                    return 0;
                case 5:
                    ene.Nld = aVar3.UbS.yZ();
                    AppMethodBeat.o(104840);
                    return 0;
                case 6:
                    ene.Nle.add(aVar3.UbS.readString());
                    AppMethodBeat.o(104840);
                    return 0;
                case 7:
                    ene.Lsm = aVar3.UbS.readString();
                    AppMethodBeat.o(104840);
                    return 0;
                case 8:
                    ene.Nlf = aVar3.UbS.readString();
                    AppMethodBeat.o(104840);
                    return 0;
                case 9:
                    ene.Lso = aVar3.UbS.readString();
                    AppMethodBeat.o(104840);
                    return 0;
                case 10:
                    ene.Lsn = aVar3.UbS.readString();
                    AppMethodBeat.o(104840);
                    return 0;
                default:
                    AppMethodBeat.o(104840);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104840);
            return -1;
        }
    }
}

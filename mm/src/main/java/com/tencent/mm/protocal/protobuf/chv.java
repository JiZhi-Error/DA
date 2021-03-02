package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class chv extends a {
    public String Mnh;
    public String Mni;
    public eok Mnj;
    public String Mnk;
    public String Mnl;
    public String Mnm;
    public String Mnn;
    public String desc;
    public String name;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200211);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.Mnh != null) {
                aVar.e(3, this.Mnh);
            }
            if (this.Mni != null) {
                aVar.e(4, this.Mni);
            }
            if (this.Mnj != null) {
                aVar.ni(5, this.Mnj.computeSize());
                this.Mnj.writeFields(aVar);
            }
            if (this.Mnk != null) {
                aVar.e(6, this.Mnk);
            }
            if (this.Mnl != null) {
                aVar.e(7, this.Mnl);
            }
            if (this.Mnm != null) {
                aVar.e(8, this.Mnm);
            }
            if (this.Mnn != null) {
                aVar.e(9, this.Mnn);
            }
            AppMethodBeat.o(200211);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.name != null ? g.a.a.b.b.a.f(1, this.name) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            if (this.Mnh != null) {
                f2 += g.a.a.b.b.a.f(3, this.Mnh);
            }
            if (this.Mni != null) {
                f2 += g.a.a.b.b.a.f(4, this.Mni);
            }
            if (this.Mnj != null) {
                f2 += g.a.a.a.nh(5, this.Mnj.computeSize());
            }
            if (this.Mnk != null) {
                f2 += g.a.a.b.b.a.f(6, this.Mnk);
            }
            if (this.Mnl != null) {
                f2 += g.a.a.b.b.a.f(7, this.Mnl);
            }
            if (this.Mnm != null) {
                f2 += g.a.a.b.b.a.f(8, this.Mnm);
            }
            if (this.Mnn != null) {
                f2 += g.a.a.b.b.a.f(9, this.Mnn);
            }
            AppMethodBeat.o(200211);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200211);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            chv chv = (chv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    chv.name = aVar3.UbS.readString();
                    AppMethodBeat.o(200211);
                    return 0;
                case 2:
                    chv.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(200211);
                    return 0;
                case 3:
                    chv.Mnh = aVar3.UbS.readString();
                    AppMethodBeat.o(200211);
                    return 0;
                case 4:
                    chv.Mni = aVar3.UbS.readString();
                    AppMethodBeat.o(200211);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eok eok = new eok();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eok.populateBuilderWithField(aVar4, eok, a.getNextFieldNumber(aVar4))) {
                        }
                        chv.Mnj = eok;
                    }
                    AppMethodBeat.o(200211);
                    return 0;
                case 6:
                    chv.Mnk = aVar3.UbS.readString();
                    AppMethodBeat.o(200211);
                    return 0;
                case 7:
                    chv.Mnl = aVar3.UbS.readString();
                    AppMethodBeat.o(200211);
                    return 0;
                case 8:
                    chv.Mnm = aVar3.UbS.readString();
                    AppMethodBeat.o(200211);
                    return 0;
                case 9:
                    chv.Mnn = aVar3.UbS.readString();
                    AppMethodBeat.o(200211);
                    return 0;
                default:
                    AppMethodBeat.o(200211);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200211);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class aiu extends a {
    public ain Cgj;
    public erc Lsp;
    public erc Lsq;
    public String md5;
    public String name;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(140926);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.md5 == null) {
                b bVar = new b("Not all required fields were included: md5");
                AppMethodBeat.o(140926);
                throw bVar;
            } else if (this.Lsp == null) {
                b bVar2 = new b("Not all required fields were included: editorMatrix");
                AppMethodBeat.o(140926);
                throw bVar2;
            } else if (this.Lsq == null) {
                b bVar3 = new b("Not all required fields were included: showMatrix");
                AppMethodBeat.o(140926);
                throw bVar3;
            } else {
                if (this.md5 != null) {
                    aVar.e(1, this.md5);
                }
                if (this.name != null) {
                    aVar.e(2, this.name);
                }
                if (this.Lsp != null) {
                    aVar.ni(3, this.Lsp.computeSize());
                    this.Lsp.writeFields(aVar);
                }
                if (this.Lsq != null) {
                    aVar.ni(4, this.Lsq.computeSize());
                    this.Lsq.writeFields(aVar);
                }
                if (this.Cgj != null) {
                    aVar.ni(5, this.Cgj.computeSize());
                    this.Cgj.writeFields(aVar);
                }
                AppMethodBeat.o(140926);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.md5 != null ? g.a.a.b.b.a.f(1, this.md5) + 0 : 0;
            if (this.name != null) {
                f2 += g.a.a.b.b.a.f(2, this.name);
            }
            if (this.Lsp != null) {
                f2 += g.a.a.a.nh(3, this.Lsp.computeSize());
            }
            if (this.Lsq != null) {
                f2 += g.a.a.a.nh(4, this.Lsq.computeSize());
            }
            if (this.Cgj != null) {
                f2 += g.a.a.a.nh(5, this.Cgj.computeSize());
            }
            AppMethodBeat.o(140926);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.md5 == null) {
                b bVar4 = new b("Not all required fields were included: md5");
                AppMethodBeat.o(140926);
                throw bVar4;
            } else if (this.Lsp == null) {
                b bVar5 = new b("Not all required fields were included: editorMatrix");
                AppMethodBeat.o(140926);
                throw bVar5;
            } else if (this.Lsq == null) {
                b bVar6 = new b("Not all required fields were included: showMatrix");
                AppMethodBeat.o(140926);
                throw bVar6;
            } else {
                AppMethodBeat.o(140926);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aiu aiu = (aiu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aiu.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(140926);
                    return 0;
                case 2:
                    aiu.name = aVar3.UbS.readString();
                    AppMethodBeat.o(140926);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        erc erc = new erc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = erc.populateBuilderWithField(aVar4, erc, a.getNextFieldNumber(aVar4))) {
                        }
                        aiu.Lsp = erc;
                    }
                    AppMethodBeat.o(140926);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        erc erc2 = new erc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = erc2.populateBuilderWithField(aVar5, erc2, a.getNextFieldNumber(aVar5))) {
                        }
                        aiu.Lsq = erc2;
                    }
                    AppMethodBeat.o(140926);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ain ain = new ain();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ain.populateBuilderWithField(aVar6, ain, a.getNextFieldNumber(aVar6))) {
                        }
                        aiu.Cgj = ain;
                    }
                    AppMethodBeat.o(140926);
                    return 0;
                default:
                    AppMethodBeat.o(140926);
                    return -1;
            }
        } else {
            AppMethodBeat.o(140926);
            return -1;
        }
    }
}

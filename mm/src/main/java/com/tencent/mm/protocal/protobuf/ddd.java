package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ddd extends a {
    public int MIi;
    public acl MIj;
    public sf MIk;
    public sf MIl;
    public String desc;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200218);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.aM(3, this.MIi);
            if (this.MIj != null) {
                aVar.ni(4, this.MIj.computeSize());
                this.MIj.writeFields(aVar);
            }
            if (this.MIk != null) {
                aVar.ni(5, this.MIk.computeSize());
                this.MIk.writeFields(aVar);
            }
            if (this.MIl != null) {
                aVar.ni(6, this.MIl.computeSize());
                this.MIl.writeFields(aVar);
            }
            AppMethodBeat.o(200218);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.MIi);
            if (this.MIj != null) {
                bu += g.a.a.a.nh(4, this.MIj.computeSize());
            }
            if (this.MIk != null) {
                bu += g.a.a.a.nh(5, this.MIk.computeSize());
            }
            if (this.MIl != null) {
                bu += g.a.a.a.nh(6, this.MIl.computeSize());
            }
            AppMethodBeat.o(200218);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200218);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddd ddd = (ddd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ddd.title = aVar3.UbS.readString();
                    AppMethodBeat.o(200218);
                    return 0;
                case 2:
                    ddd.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(200218);
                    return 0;
                case 3:
                    ddd.MIi = aVar3.UbS.zi();
                    AppMethodBeat.o(200218);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        acl acl = new acl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = acl.populateBuilderWithField(aVar4, acl, a.getNextFieldNumber(aVar4))) {
                        }
                        ddd.MIj = acl;
                    }
                    AppMethodBeat.o(200218);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        sf sfVar = new sf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sfVar.populateBuilderWithField(aVar5, sfVar, a.getNextFieldNumber(aVar5))) {
                        }
                        ddd.MIk = sfVar;
                    }
                    AppMethodBeat.o(200218);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        sf sfVar2 = new sf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sfVar2.populateBuilderWithField(aVar6, sfVar2, a.getNextFieldNumber(aVar6))) {
                        }
                        ddd.MIl = sfVar2;
                    }
                    AppMethodBeat.o(200218);
                    return 0;
                default:
                    AppMethodBeat.o(200218);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200218);
            return -1;
        }
    }
}

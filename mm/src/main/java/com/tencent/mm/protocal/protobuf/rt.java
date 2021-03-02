package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class rt extends a {
    public rv KZb;
    public dso KZe;
    public sc KZf;
    public String oUJ;
    public String xIy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117841);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.oUJ == null) {
                b bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(117841);
                throw bVar;
            } else if (this.KZe == null) {
                b bVar2 = new b("Not all required fields were included: ContactItem");
                AppMethodBeat.o(117841);
                throw bVar2;
            } else {
                if (this.oUJ != null) {
                    aVar.e(1, this.oUJ);
                }
                if (this.KZb != null) {
                    aVar.ni(2, this.KZb.computeSize());
                    this.KZb.writeFields(aVar);
                }
                if (this.KZe != null) {
                    aVar.ni(3, this.KZe.computeSize());
                    this.KZe.writeFields(aVar);
                }
                if (this.KZf != null) {
                    aVar.ni(4, this.KZf.computeSize());
                    this.KZf.writeFields(aVar);
                }
                if (this.xIy != null) {
                    aVar.e(5, this.xIy);
                }
                AppMethodBeat.o(117841);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.oUJ != null ? g.a.a.b.b.a.f(1, this.oUJ) + 0 : 0;
            if (this.KZb != null) {
                f2 += g.a.a.a.nh(2, this.KZb.computeSize());
            }
            if (this.KZe != null) {
                f2 += g.a.a.a.nh(3, this.KZe.computeSize());
            }
            if (this.KZf != null) {
                f2 += g.a.a.a.nh(4, this.KZf.computeSize());
            }
            if (this.xIy != null) {
                f2 += g.a.a.b.b.a.f(5, this.xIy);
            }
            AppMethodBeat.o(117841);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.oUJ == null) {
                b bVar3 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(117841);
                throw bVar3;
            } else if (this.KZe == null) {
                b bVar4 = new b("Not all required fields were included: ContactItem");
                AppMethodBeat.o(117841);
                throw bVar4;
            } else {
                AppMethodBeat.o(117841);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            rt rtVar = (rt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    rtVar.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(117841);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        rv rvVar = new rv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = rvVar.populateBuilderWithField(aVar4, rvVar, a.getNextFieldNumber(aVar4))) {
                        }
                        rtVar.KZb = rvVar;
                    }
                    AppMethodBeat.o(117841);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dso dso = new dso();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dso.populateBuilderWithField(aVar5, dso, a.getNextFieldNumber(aVar5))) {
                        }
                        rtVar.KZe = dso;
                    }
                    AppMethodBeat.o(117841);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        sc scVar = new sc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = scVar.populateBuilderWithField(aVar6, scVar, a.getNextFieldNumber(aVar6))) {
                        }
                        rtVar.KZf = scVar;
                    }
                    AppMethodBeat.o(117841);
                    return 0;
                case 5:
                    rtVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(117841);
                    return 0;
                default:
                    AppMethodBeat.o(117841);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117841);
            return -1;
        }
    }
}

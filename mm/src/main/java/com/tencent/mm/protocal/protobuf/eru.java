package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eru extends dop {
    public long Lnw;
    public String NoW;
    public String NoX;
    public LinkedList<esc> Npl = new LinkedList<>();
    public esc Npm;
    public LinkedList<erw> Npn = new LinkedList<>();

    public eru() {
        AppMethodBeat.i(239529);
        AppMethodBeat.o(239529);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(239530);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.NoW != null) {
                aVar.e(2, this.NoW);
            }
            if (this.Npm != null) {
                aVar.ni(3, this.Npm.computeSize());
                this.Npm.writeFields(aVar);
            }
            aVar.bb(4, this.Lnw);
            if (this.NoX != null) {
                aVar.e(5, this.NoX);
            }
            aVar.e(6, 8, this.Npn);
            aVar.e(7, 8, this.Npl);
            AppMethodBeat.o(239530);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.NoW != null) {
                nh += g.a.a.b.b.a.f(2, this.NoW);
            }
            if (this.Npm != null) {
                nh += g.a.a.a.nh(3, this.Npm.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(4, this.Lnw);
            if (this.NoX != null) {
                r += g.a.a.b.b.a.f(5, this.NoX);
            }
            int c2 = r + g.a.a.a.c(6, 8, this.Npn) + g.a.a.a.c(7, 8, this.Npl);
            AppMethodBeat.o(239530);
            return c2;
        } else if (i2 == 2) {
            this.Npn.clear();
            this.Npl.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(239530);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eru eru = (eru) objArr[1];
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
                        eru.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(239530);
                    return 0;
                case 2:
                    eru.NoW = aVar3.UbS.readString();
                    AppMethodBeat.o(239530);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        esc esc = new esc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = esc.populateBuilderWithField(aVar5, esc, dop.getNextFieldNumber(aVar5))) {
                        }
                        eru.Npm = esc;
                    }
                    AppMethodBeat.o(239530);
                    return 0;
                case 4:
                    eru.Lnw = aVar3.UbS.zl();
                    AppMethodBeat.o(239530);
                    return 0;
                case 5:
                    eru.NoX = aVar3.UbS.readString();
                    AppMethodBeat.o(239530);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        erw erw = new erw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = erw.populateBuilderWithField(aVar6, erw, dop.getNextFieldNumber(aVar6))) {
                        }
                        eru.Npn.add(erw);
                    }
                    AppMethodBeat.o(239530);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        esc esc2 = new esc();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = esc2.populateBuilderWithField(aVar7, esc2, dop.getNextFieldNumber(aVar7))) {
                        }
                        eru.Npl.add(esc2);
                    }
                    AppMethodBeat.o(239530);
                    return 0;
                default:
                    AppMethodBeat.o(239530);
                    return -1;
            }
        } else {
            AppMethodBeat.o(239530);
            return -1;
        }
    }
}

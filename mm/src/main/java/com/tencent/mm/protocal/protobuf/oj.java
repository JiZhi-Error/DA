package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class oj extends dop {
    public LinkedList<os> KUf = new LinkedList<>();
    public int KUg;
    public int KUh;
    public String KUi;
    public long KUj;
    public String KUk;
    public uc KUl;
    public oi KUm;
    public fq KUn;
    public String KUo;
    public String KUp;
    public LinkedList<dli> gCs = new LinkedList<>();

    public oj() {
        AppMethodBeat.i(212238);
        AppMethodBeat.o(212238);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212239);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.KUf);
            aVar.aM(3, this.KUg);
            aVar.aM(4, this.KUh);
            if (this.KUi != null) {
                aVar.e(5, this.KUi);
            }
            aVar.bb(6, this.KUj);
            if (this.KUk != null) {
                aVar.e(7, this.KUk);
            }
            if (this.KUl != null) {
                aVar.ni(8, this.KUl.computeSize());
                this.KUl.writeFields(aVar);
            }
            if (this.KUm != null) {
                aVar.ni(9, this.KUm.computeSize());
                this.KUm.writeFields(aVar);
            }
            if (this.KUn != null) {
                aVar.ni(10, this.KUn.computeSize());
                this.KUn.writeFields(aVar);
            }
            if (this.KUo != null) {
                aVar.e(11, this.KUo);
            }
            if (this.KUp != null) {
                aVar.e(12, this.KUp);
            }
            aVar.e(13, 8, this.gCs);
            AppMethodBeat.o(212239);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.KUf) + g.a.a.b.b.a.bu(3, this.KUg) + g.a.a.b.b.a.bu(4, this.KUh);
            if (this.KUi != null) {
                nh += g.a.a.b.b.a.f(5, this.KUi);
            }
            int r = nh + g.a.a.b.b.a.r(6, this.KUj);
            if (this.KUk != null) {
                r += g.a.a.b.b.a.f(7, this.KUk);
            }
            if (this.KUl != null) {
                r += g.a.a.a.nh(8, this.KUl.computeSize());
            }
            if (this.KUm != null) {
                r += g.a.a.a.nh(9, this.KUm.computeSize());
            }
            if (this.KUn != null) {
                r += g.a.a.a.nh(10, this.KUn.computeSize());
            }
            if (this.KUo != null) {
                r += g.a.a.b.b.a.f(11, this.KUo);
            }
            if (this.KUp != null) {
                r += g.a.a.b.b.a.f(12, this.KUp);
            }
            int c2 = r + g.a.a.a.c(13, 8, this.gCs);
            AppMethodBeat.o(212239);
            return c2;
        } else if (i2 == 2) {
            this.KUf.clear();
            this.gCs.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212239);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            oj ojVar = (oj) objArr[1];
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
                        ojVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(212239);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        os osVar = new os();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = osVar.populateBuilderWithField(aVar5, osVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        ojVar.KUf.add(osVar);
                    }
                    AppMethodBeat.o(212239);
                    return 0;
                case 3:
                    ojVar.KUg = aVar3.UbS.zi();
                    AppMethodBeat.o(212239);
                    return 0;
                case 4:
                    ojVar.KUh = aVar3.UbS.zi();
                    AppMethodBeat.o(212239);
                    return 0;
                case 5:
                    ojVar.KUi = aVar3.UbS.readString();
                    AppMethodBeat.o(212239);
                    return 0;
                case 6:
                    ojVar.KUj = aVar3.UbS.zl();
                    AppMethodBeat.o(212239);
                    return 0;
                case 7:
                    ojVar.KUk = aVar3.UbS.readString();
                    AppMethodBeat.o(212239);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        uc ucVar = new uc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ucVar.populateBuilderWithField(aVar6, ucVar, dop.getNextFieldNumber(aVar6))) {
                        }
                        ojVar.KUl = ucVar;
                    }
                    AppMethodBeat.o(212239);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        oi oiVar = new oi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = oiVar.populateBuilderWithField(aVar7, oiVar, dop.getNextFieldNumber(aVar7))) {
                        }
                        ojVar.KUm = oiVar;
                    }
                    AppMethodBeat.o(212239);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        fq fqVar = new fq();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = fqVar.populateBuilderWithField(aVar8, fqVar, dop.getNextFieldNumber(aVar8))) {
                        }
                        ojVar.KUn = fqVar;
                    }
                    AppMethodBeat.o(212239);
                    return 0;
                case 11:
                    ojVar.KUo = aVar3.UbS.readString();
                    AppMethodBeat.o(212239);
                    return 0;
                case 12:
                    ojVar.KUp = aVar3.UbS.readString();
                    AppMethodBeat.o(212239);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dli dli = new dli();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dli.populateBuilderWithField(aVar9, dli, dop.getNextFieldNumber(aVar9))) {
                        }
                        ojVar.gCs.add(dli);
                    }
                    AppMethodBeat.o(212239);
                    return 0;
                default:
                    AppMethodBeat.o(212239);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212239);
            return -1;
        }
    }
}

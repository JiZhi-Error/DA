package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bpd extends dop {
    public int KMz;
    public String LPT;
    public SKBuiltinBuffer_t LXm;
    public int LXn;
    public int LXo;
    public LinkedList<dbm> LXp = new LinkedList<>();
    public int LXq;
    public chk LpL;
    public int Scene;

    public bpd() {
        AppMethodBeat.i(32249);
        AppMethodBeat.o(32249);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32250);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.LpL == null) {
                b bVar = new b("Not all required fields were included: Loc");
                AppMethodBeat.o(32250);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.KMz);
            aVar.aM(3, this.Scene);
            if (this.LXm != null) {
                aVar.ni(4, this.LXm.computeSize());
                this.LXm.writeFields(aVar);
            }
            if (this.LpL != null) {
                aVar.ni(5, this.LpL.computeSize());
                this.LpL.writeFields(aVar);
            }
            if (this.LPT != null) {
                aVar.e(6, this.LPT);
            }
            aVar.aM(7, this.LXn);
            aVar.aM(8, this.LXo);
            aVar.e(11, 8, this.LXp);
            aVar.aM(12, this.LXq);
            AppMethodBeat.o(32250);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KMz) + g.a.a.b.b.a.bu(3, this.Scene);
            if (this.LXm != null) {
                nh += g.a.a.a.nh(4, this.LXm.computeSize());
            }
            if (this.LpL != null) {
                nh += g.a.a.a.nh(5, this.LpL.computeSize());
            }
            if (this.LPT != null) {
                nh += g.a.a.b.b.a.f(6, this.LPT);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.LXn) + g.a.a.b.b.a.bu(8, this.LXo) + g.a.a.a.c(11, 8, this.LXp) + g.a.a.b.b.a.bu(12, this.LXq);
            AppMethodBeat.o(32250);
            return bu;
        } else if (i2 == 2) {
            this.LXp.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LpL == null) {
                b bVar2 = new b("Not all required fields were included: Loc");
                AppMethodBeat.o(32250);
                throw bVar2;
            }
            AppMethodBeat.o(32250);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bpd bpd = (bpd) objArr[1];
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
                        bpd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32250);
                    return 0;
                case 2:
                    bpd.KMz = aVar3.UbS.zi();
                    AppMethodBeat.o(32250);
                    return 0;
                case 3:
                    bpd.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32250);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        bpd.LXm = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32250);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        chk chk = new chk();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = chk.populateBuilderWithField(aVar6, chk, dop.getNextFieldNumber(aVar6))) {
                        }
                        bpd.LpL = chk;
                    }
                    AppMethodBeat.o(32250);
                    return 0;
                case 6:
                    bpd.LPT = aVar3.UbS.readString();
                    AppMethodBeat.o(32250);
                    return 0;
                case 7:
                    bpd.LXn = aVar3.UbS.zi();
                    AppMethodBeat.o(32250);
                    return 0;
                case 8:
                    bpd.LXo = aVar3.UbS.zi();
                    AppMethodBeat.o(32250);
                    return 0;
                case 9:
                case 10:
                default:
                    AppMethodBeat.o(32250);
                    return -1;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dbm dbm = new dbm();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dbm.populateBuilderWithField(aVar7, dbm, dop.getNextFieldNumber(aVar7))) {
                        }
                        bpd.LXp.add(dbm);
                    }
                    AppMethodBeat.o(32250);
                    return 0;
                case 12:
                    bpd.LXq = aVar3.UbS.zi();
                    AppMethodBeat.o(32250);
                    return 0;
            }
        } else {
            AppMethodBeat.o(32250);
            return -1;
        }
    }
}

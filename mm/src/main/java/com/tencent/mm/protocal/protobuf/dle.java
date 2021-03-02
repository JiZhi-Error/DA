package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dle extends a {
    public String Bah;
    public String MPb;
    public double MPc;
    public LinkedList<ve> MPd = new LinkedList<>();
    public String MPe;
    public LinkedList<dpo> MPf = new LinkedList<>();
    public long clK;
    public String dNI;
    public String nickname;
    public String username;

    public dle() {
        AppMethodBeat.i(50103);
        AppMethodBeat.o(50103);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50104);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            if (this.nickname != null) {
                aVar.e(3, this.nickname);
            }
            if (this.Bah != null) {
                aVar.e(4, this.Bah);
            }
            aVar.bb(5, this.clK);
            if (this.MPb != null) {
                aVar.e(6, this.MPb);
            }
            aVar.e(7, this.MPc);
            aVar.e(16, 8, this.MPd);
            if (this.MPe != null) {
                aVar.e(17, this.MPe);
            }
            aVar.e(19, 8, this.MPf);
            AppMethodBeat.o(50104);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.username != null) {
                f2 += g.a.a.b.b.a.f(2, this.username);
            }
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(3, this.nickname);
            }
            if (this.Bah != null) {
                f2 += g.a.a.b.b.a.f(4, this.Bah);
            }
            int r = f2 + g.a.a.b.b.a.r(5, this.clK);
            if (this.MPb != null) {
                r += g.a.a.b.b.a.f(6, this.MPb);
            }
            int fS = r + g.a.a.b.b.a.fS(7) + 8 + g.a.a.a.c(16, 8, this.MPd);
            if (this.MPe != null) {
                fS += g.a.a.b.b.a.f(17, this.MPe);
            }
            int c2 = fS + g.a.a.a.c(19, 8, this.MPf);
            AppMethodBeat.o(50104);
            return c2;
        } else if (i2 == 2) {
            this.MPd.clear();
            this.MPf.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50104);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dle dle = (dle) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dle.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(50104);
                    return 0;
                case 2:
                    dle.username = aVar3.UbS.readString();
                    AppMethodBeat.o(50104);
                    return 0;
                case 3:
                    dle.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(50104);
                    return 0;
                case 4:
                    dle.Bah = aVar3.UbS.readString();
                    AppMethodBeat.o(50104);
                    return 0;
                case 5:
                    dle.clK = aVar3.UbS.zl();
                    AppMethodBeat.o(50104);
                    return 0;
                case 6:
                    dle.MPb = aVar3.UbS.readString();
                    AppMethodBeat.o(50104);
                    return 0;
                case 7:
                    dle.MPc = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(50104);
                    return 0;
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 18:
                default:
                    AppMethodBeat.o(50104);
                    return -1;
                case 16:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ve veVar = new ve();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = veVar.populateBuilderWithField(aVar4, veVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dle.MPd.add(veVar);
                    }
                    AppMethodBeat.o(50104);
                    return 0;
                case 17:
                    dle.MPe = aVar3.UbS.readString();
                    AppMethodBeat.o(50104);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dpo dpo = new dpo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dpo.populateBuilderWithField(aVar5, dpo, a.getNextFieldNumber(aVar5))) {
                        }
                        dle.MPf.add(dpo);
                    }
                    AppMethodBeat.o(50104);
                    return 0;
            }
        } else {
            AppMethodBeat.o(50104);
            return -1;
        }
    }
}

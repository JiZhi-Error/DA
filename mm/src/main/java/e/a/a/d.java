package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class d extends a {
    public String LjW;
    public int Ubo;
    public String Ubp;
    public String Ubq;
    public String Ubr;
    public long Ubs;
    public int Ubt;
    public h Ubu;
    public String Ubv;
    public String Ubw;
    public String Ubx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91742);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Ubo);
            if (this.Ubp != null) {
                aVar.e(2, this.Ubp);
            }
            if (this.Ubq != null) {
                aVar.e(3, this.Ubq);
            }
            if (this.Ubr != null) {
                aVar.e(5, this.Ubr);
            }
            aVar.bb(6, this.Ubs);
            if (this.LjW != null) {
                aVar.e(7, this.LjW);
            }
            aVar.aM(8, this.Ubt);
            if (this.Ubu != null) {
                aVar.ni(9, this.Ubu.computeSize());
                this.Ubu.writeFields(aVar);
            }
            if (this.Ubv != null) {
                aVar.e(10, this.Ubv);
            }
            if (this.Ubw != null) {
                aVar.e(11, this.Ubw);
            }
            if (this.Ubx != null) {
                aVar.e(12, this.Ubx);
            }
            AppMethodBeat.o(91742);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ubo) + 0;
            if (this.Ubp != null) {
                bu += g.a.a.b.b.a.f(2, this.Ubp);
            }
            if (this.Ubq != null) {
                bu += g.a.a.b.b.a.f(3, this.Ubq);
            }
            if (this.Ubr != null) {
                bu += g.a.a.b.b.a.f(5, this.Ubr);
            }
            int r = bu + g.a.a.b.b.a.r(6, this.Ubs);
            if (this.LjW != null) {
                r += g.a.a.b.b.a.f(7, this.LjW);
            }
            int bu2 = r + g.a.a.b.b.a.bu(8, this.Ubt);
            if (this.Ubu != null) {
                bu2 += g.a.a.a.nh(9, this.Ubu.computeSize());
            }
            if (this.Ubv != null) {
                bu2 += g.a.a.b.b.a.f(10, this.Ubv);
            }
            if (this.Ubw != null) {
                bu2 += g.a.a.b.b.a.f(11, this.Ubw);
            }
            if (this.Ubx != null) {
                bu2 += g.a.a.b.b.a.f(12, this.Ubx);
            }
            AppMethodBeat.o(91742);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91742);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.Ubo = aVar3.UbS.zi();
                    AppMethodBeat.o(91742);
                    return 0;
                case 2:
                    dVar.Ubp = aVar3.UbS.readString();
                    AppMethodBeat.o(91742);
                    return 0;
                case 3:
                    dVar.Ubq = aVar3.UbS.readString();
                    AppMethodBeat.o(91742);
                    return 0;
                case 4:
                default:
                    AppMethodBeat.o(91742);
                    return -1;
                case 5:
                    dVar.Ubr = aVar3.UbS.readString();
                    AppMethodBeat.o(91742);
                    return 0;
                case 6:
                    dVar.Ubs = aVar3.UbS.zl();
                    AppMethodBeat.o(91742);
                    return 0;
                case 7:
                    dVar.LjW = aVar3.UbS.readString();
                    AppMethodBeat.o(91742);
                    return 0;
                case 8:
                    dVar.Ubt = aVar3.UbS.zi();
                    AppMethodBeat.o(91742);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        h hVar = new h();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = hVar.populateBuilderWithField(aVar4, hVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.Ubu = hVar;
                    }
                    AppMethodBeat.o(91742);
                    return 0;
                case 10:
                    dVar.Ubv = aVar3.UbS.readString();
                    AppMethodBeat.o(91742);
                    return 0;
                case 11:
                    dVar.Ubw = aVar3.UbS.readString();
                    AppMethodBeat.o(91742);
                    return 0;
                case 12:
                    dVar.Ubx = aVar3.UbS.readString();
                    AppMethodBeat.o(91742);
                    return 0;
            }
        } else {
            AppMethodBeat.o(91742);
            return -1;
        }
    }
}

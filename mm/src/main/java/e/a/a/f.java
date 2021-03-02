package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class f extends a {
    public b LaX;
    public String UbA;
    public String UbB;
    public String UbC;
    public int UbD;
    public e UbE;
    public b UbF;
    public String Uby;
    public String Ubz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91744);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Uby != null) {
                aVar.e(1, this.Uby);
            }
            if (this.Ubz != null) {
                aVar.e(2, this.Ubz);
            }
            if (this.UbA != null) {
                aVar.e(3, this.UbA);
            }
            if (this.UbB != null) {
                aVar.e(4, this.UbB);
            }
            if (this.UbC != null) {
                aVar.e(5, this.UbC);
            }
            aVar.aM(6, this.UbD);
            if (this.UbE != null) {
                aVar.ni(7, this.UbE.computeSize());
                this.UbE.writeFields(aVar);
            }
            if (this.UbF != null) {
                aVar.c(8, this.UbF);
            }
            if (this.LaX != null) {
                aVar.c(9, this.LaX);
            }
            AppMethodBeat.o(91744);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Uby != null ? g.a.a.b.b.a.f(1, this.Uby) + 0 : 0;
            if (this.Ubz != null) {
                f2 += g.a.a.b.b.a.f(2, this.Ubz);
            }
            if (this.UbA != null) {
                f2 += g.a.a.b.b.a.f(3, this.UbA);
            }
            if (this.UbB != null) {
                f2 += g.a.a.b.b.a.f(4, this.UbB);
            }
            if (this.UbC != null) {
                f2 += g.a.a.b.b.a.f(5, this.UbC);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.UbD);
            if (this.UbE != null) {
                bu += g.a.a.a.nh(7, this.UbE.computeSize());
            }
            if (this.UbF != null) {
                bu += g.a.a.b.b.a.b(8, this.UbF);
            }
            if (this.LaX != null) {
                bu += g.a.a.b.b.a.b(9, this.LaX);
            }
            AppMethodBeat.o(91744);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91744);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fVar.Uby = aVar3.UbS.readString();
                    AppMethodBeat.o(91744);
                    return 0;
                case 2:
                    fVar.Ubz = aVar3.UbS.readString();
                    AppMethodBeat.o(91744);
                    return 0;
                case 3:
                    fVar.UbA = aVar3.UbS.readString();
                    AppMethodBeat.o(91744);
                    return 0;
                case 4:
                    fVar.UbB = aVar3.UbS.readString();
                    AppMethodBeat.o(91744);
                    return 0;
                case 5:
                    fVar.UbC = aVar3.UbS.readString();
                    AppMethodBeat.o(91744);
                    return 0;
                case 6:
                    fVar.UbD = aVar3.UbS.zi();
                    AppMethodBeat.o(91744);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        e eVar = new e();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fVar.UbE = eVar;
                    }
                    AppMethodBeat.o(91744);
                    return 0;
                case 8:
                    fVar.UbF = aVar3.UbS.hPo();
                    AppMethodBeat.o(91744);
                    return 0;
                case 9:
                    fVar.LaX = aVar3.UbS.hPo();
                    AppMethodBeat.o(91744);
                    return 0;
                default:
                    AppMethodBeat.o(91744);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91744);
            return -1;
        }
    }
}

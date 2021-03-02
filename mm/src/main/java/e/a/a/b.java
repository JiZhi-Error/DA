package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class b extends a {
    public int NkQ;
    public g Ubc;
    public String Ubd;
    public String Ube;
    public String Ubf;
    public String Ubg;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91739);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ubc != null) {
                aVar.ni(1, this.Ubc.computeSize());
                this.Ubc.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.Ubd != null) {
                aVar.e(3, this.Ubd);
            }
            if (this.Ube != null) {
                aVar.e(4, this.Ube);
            }
            aVar.aM(5, this.NkQ);
            if (this.Ubf != null) {
                aVar.e(6, this.Ubf);
            }
            if (this.Ubg != null) {
                aVar.e(7, this.Ubg);
            }
            AppMethodBeat.o(91739);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Ubc != null ? g.a.a.a.nh(1, this.Ubc.computeSize()) + 0 : 0;
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.Ubd != null) {
                nh += g.a.a.b.b.a.f(3, this.Ubd);
            }
            if (this.Ube != null) {
                nh += g.a.a.b.b.a.f(4, this.Ube);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.NkQ);
            if (this.Ubf != null) {
                bu += g.a.a.b.b.a.f(6, this.Ubf);
            }
            if (this.Ubg != null) {
                bu += g.a.a.b.b.a.f(7, this.Ubg);
            }
            AppMethodBeat.o(91739);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91739);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        g gVar = new g();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar.Ubc = gVar;
                    }
                    AppMethodBeat.o(91739);
                    return 0;
                case 2:
                    bVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91739);
                    return 0;
                case 3:
                    bVar.Ubd = aVar3.UbS.readString();
                    AppMethodBeat.o(91739);
                    return 0;
                case 4:
                    bVar.Ube = aVar3.UbS.readString();
                    AppMethodBeat.o(91739);
                    return 0;
                case 5:
                    bVar.NkQ = aVar3.UbS.zi();
                    AppMethodBeat.o(91739);
                    return 0;
                case 6:
                    bVar.Ubf = aVar3.UbS.readString();
                    AppMethodBeat.o(91739);
                    return 0;
                case 7:
                    bVar.Ubg = aVar3.UbS.readString();
                    AppMethodBeat.o(91739);
                    return 0;
                default:
                    AppMethodBeat.o(91739);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91739);
            return -1;
        }
    }
}

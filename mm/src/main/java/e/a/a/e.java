package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class e extends a {
    public String LXU;
    public String UaZ;
    public String Uba;
    public int Ubb;
    public g Ubc;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91743);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UaZ != null) {
                aVar.e(1, this.UaZ);
            }
            if (this.Uba != null) {
                aVar.e(2, this.Uba);
            }
            aVar.aM(3, this.Ubb);
            if (this.LXU != null) {
                aVar.e(4, this.LXU);
            }
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            if (this.Ubc != null) {
                aVar.ni(6, this.Ubc.computeSize());
                this.Ubc.writeFields(aVar);
            }
            AppMethodBeat.o(91743);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UaZ != null ? g.a.a.b.b.a.f(1, this.UaZ) + 0 : 0;
            if (this.Uba != null) {
                f2 += g.a.a.b.b.a.f(2, this.Uba);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.Ubb);
            if (this.LXU != null) {
                bu += g.a.a.b.b.a.f(4, this.LXU);
            }
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(5, this.url);
            }
            if (this.Ubc != null) {
                bu += g.a.a.a.nh(6, this.Ubc.computeSize());
            }
            AppMethodBeat.o(91743);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91743);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.UaZ = aVar3.UbS.readString();
                    AppMethodBeat.o(91743);
                    return 0;
                case 2:
                    eVar.Uba = aVar3.UbS.readString();
                    AppMethodBeat.o(91743);
                    return 0;
                case 3:
                    eVar.Ubb = aVar3.UbS.zi();
                    AppMethodBeat.o(91743);
                    return 0;
                case 4:
                    eVar.LXU = aVar3.UbS.readString();
                    AppMethodBeat.o(91743);
                    return 0;
                case 5:
                    eVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91743);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        g gVar = new g();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.Ubc = gVar;
                    }
                    AppMethodBeat.o(91743);
                    return 0;
                default:
                    AppMethodBeat.o(91743);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91743);
            return -1;
        }
    }
}

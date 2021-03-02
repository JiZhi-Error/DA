package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class anj extends a implements dyp {
    public int KZh;
    public SKBuiltinBuffer_t Lev;
    public abo Ley;
    public int Ret;

    @Override // com.tencent.mm.protocal.protobuf.dyp
    public final int getRet() {
        return this.Ret;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127483);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ley == null) {
                b bVar = new b("Not all required fields were included: CmdList");
                AppMethodBeat.o(127483);
                throw bVar;
            } else if (this.Lev == null) {
                b bVar2 = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(127483);
                throw bVar2;
            } else {
                aVar.aM(1, this.Ret);
                if (this.Ley != null) {
                    aVar.ni(2, this.Ley.computeSize());
                    this.Ley.writeFields(aVar);
                }
                if (this.Lev != null) {
                    aVar.ni(3, this.Lev.computeSize());
                    this.Lev.writeFields(aVar);
                }
                aVar.aM(4, this.KZh);
                AppMethodBeat.o(127483);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0;
            if (this.Ley != null) {
                bu += g.a.a.a.nh(2, this.Ley.computeSize());
            }
            if (this.Lev != null) {
                bu += g.a.a.a.nh(3, this.Lev.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.KZh);
            AppMethodBeat.o(127483);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Ley == null) {
                b bVar3 = new b("Not all required fields were included: CmdList");
                AppMethodBeat.o(127483);
                throw bVar3;
            } else if (this.Lev == null) {
                b bVar4 = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(127483);
                throw bVar4;
            } else {
                AppMethodBeat.o(127483);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anj anj = (anj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    anj.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(127483);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        abo abo = new abo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = abo.populateBuilderWithField(aVar4, abo, a.getNextFieldNumber(aVar4))) {
                        }
                        anj.Ley = abo;
                    }
                    AppMethodBeat.o(127483);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar5))) {
                        }
                        anj.Lev = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(127483);
                    return 0;
                case 4:
                    anj.KZh = aVar3.UbS.zi();
                    AppMethodBeat.o(127483);
                    return 0;
                default:
                    AppMethodBeat.o(127483);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127483);
            return -1;
        }
    }
}

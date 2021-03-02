package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eqi extends dop {
    public SKBuiltinBuffer_t KPW;
    public int MPQ;
    public int MPS;
    public String Mdm;
    public esi NnN;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32496);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.NnN == null) {
                b bVar = new b("Not all required fields were included: Piece");
                AppMethodBeat.o(32496);
                throw bVar;
            } else if (this.KPW == null) {
                b bVar2 = new b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.o(32496);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.NnN != null) {
                    aVar.ni(2, this.NnN.computeSize());
                    this.NnN.writeFields(aVar);
                }
                aVar.aM(3, this.MPQ);
                aVar.aM(4, this.MPS);
                if (this.Mdm != null) {
                    aVar.e(5, this.Mdm);
                }
                if (this.KPW != null) {
                    aVar.ni(6, this.KPW.computeSize());
                    this.KPW.writeFields(aVar);
                }
                AppMethodBeat.o(32496);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.NnN != null) {
                nh += g.a.a.a.nh(2, this.NnN.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MPQ) + g.a.a.b.b.a.bu(4, this.MPS);
            if (this.Mdm != null) {
                bu += g.a.a.b.b.a.f(5, this.Mdm);
            }
            if (this.KPW != null) {
                bu += g.a.a.a.nh(6, this.KPW.computeSize());
            }
            AppMethodBeat.o(32496);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NnN == null) {
                b bVar3 = new b("Not all required fields were included: Piece");
                AppMethodBeat.o(32496);
                throw bVar3;
            } else if (this.KPW == null) {
                b bVar4 = new b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.o(32496);
                throw bVar4;
            } else {
                AppMethodBeat.o(32496);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqi eqi = (eqi) objArr[1];
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
                        eqi.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32496);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        esi esi = new esi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = esi.populateBuilderWithField(aVar5, esi, dop.getNextFieldNumber(aVar5))) {
                        }
                        eqi.NnN = esi;
                    }
                    AppMethodBeat.o(32496);
                    return 0;
                case 3:
                    eqi.MPQ = aVar3.UbS.zi();
                    AppMethodBeat.o(32496);
                    return 0;
                case 4:
                    eqi.MPS = aVar3.UbS.zi();
                    AppMethodBeat.o(32496);
                    return 0;
                case 5:
                    eqi.Mdm = aVar3.UbS.readString();
                    AppMethodBeat.o(32496);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar6))) {
                        }
                        eqi.KPW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32496);
                    return 0;
                default:
                    AppMethodBeat.o(32496);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32496);
            return -1;
        }
    }
}

package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aed extends dop {
    public LinkedList<con> KGQ = new LinkedList<>();
    public dqi Lpx;
    public SKBuiltinBuffer_t Lpy;
    public String Lpz;
    public int Scene;
    public int gsq;
    public String jfi;

    public aed() {
        AppMethodBeat.i(101797);
        AppMethodBeat.o(101797);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101798);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Lpx == null) {
                b bVar = new b("Not all required fields were included: Topic");
                AppMethodBeat.o(101798);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Lpx != null) {
                aVar.ni(2, this.Lpx.computeSize());
                this.Lpx.writeFields(aVar);
            }
            aVar.aM(3, this.gsq);
            aVar.e(4, 8, this.KGQ);
            aVar.aM(5, this.Scene);
            if (this.Lpy != null) {
                aVar.ni(6, this.Lpy.computeSize());
                this.Lpy.writeFields(aVar);
            }
            if (this.Lpz != null) {
                aVar.e(7, this.Lpz);
            }
            if (this.jfi != null) {
                aVar.e(8, this.jfi);
            }
            AppMethodBeat.o(101798);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Lpx != null) {
                nh += g.a.a.a.nh(2, this.Lpx.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.gsq) + g.a.a.a.c(4, 8, this.KGQ) + g.a.a.b.b.a.bu(5, this.Scene);
            if (this.Lpy != null) {
                bu += g.a.a.a.nh(6, this.Lpy.computeSize());
            }
            if (this.Lpz != null) {
                bu += g.a.a.b.b.a.f(7, this.Lpz);
            }
            if (this.jfi != null) {
                bu += g.a.a.b.b.a.f(8, this.jfi);
            }
            AppMethodBeat.o(101798);
            return bu;
        } else if (i2 == 2) {
            this.KGQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lpx == null) {
                b bVar2 = new b("Not all required fields were included: Topic");
                AppMethodBeat.o(101798);
                throw bVar2;
            }
            AppMethodBeat.o(101798);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aed aed = (aed) objArr[1];
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
                        aed.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(101798);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        aed.Lpx = dqi;
                    }
                    AppMethodBeat.o(101798);
                    return 0;
                case 3:
                    aed.gsq = aVar3.UbS.zi();
                    AppMethodBeat.o(101798);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        con con = new con();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = con.populateBuilderWithField(aVar6, con, dop.getNextFieldNumber(aVar6))) {
                        }
                        aed.KGQ.add(con);
                    }
                    AppMethodBeat.o(101798);
                    return 0;
                case 5:
                    aed.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(101798);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t.populateBuilderWithField(aVar7, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar7))) {
                        }
                        aed.Lpy = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(101798);
                    return 0;
                case 7:
                    aed.Lpz = aVar3.UbS.readString();
                    AppMethodBeat.o(101798);
                    return 0;
                case 8:
                    aed.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(101798);
                    return 0;
                default:
                    AppMethodBeat.o(101798);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101798);
            return -1;
        }
    }
}

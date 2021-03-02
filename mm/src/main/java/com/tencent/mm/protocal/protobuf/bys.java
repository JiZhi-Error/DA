package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bys extends dop {
    public SKBuiltinBuffer_t KLh;
    public SKBuiltinBuffer_t LRA;
    public String Mec;
    public int Scene;
    public String UserName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32315);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KLh == null) {
                b bVar = new b("Not all required fields were included: A2Key");
                AppMethodBeat.o(32315);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KLh != null) {
                aVar.ni(2, this.KLh.computeSize());
                this.KLh.writeFields(aVar);
            }
            if (this.UserName != null) {
                aVar.e(3, this.UserName);
            }
            aVar.aM(4, this.Scene);
            if (this.Mec != null) {
                aVar.e(5, this.Mec);
            }
            if (this.LRA != null) {
                aVar.ni(6, this.LRA.computeSize());
                this.LRA.writeFields(aVar);
            }
            AppMethodBeat.o(32315);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KLh != null) {
                nh += g.a.a.a.nh(2, this.KLh.computeSize());
            }
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(3, this.UserName);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Scene);
            if (this.Mec != null) {
                bu += g.a.a.b.b.a.f(5, this.Mec);
            }
            if (this.LRA != null) {
                bu += g.a.a.a.nh(6, this.LRA.computeSize());
            }
            AppMethodBeat.o(32315);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KLh == null) {
                b bVar2 = new b("Not all required fields were included: A2Key");
                AppMethodBeat.o(32315);
                throw bVar2;
            }
            AppMethodBeat.o(32315);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bys bys = (bys) objArr[1];
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
                        bys.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32315);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        bys.KLh = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32315);
                    return 0;
                case 3:
                    bys.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(32315);
                    return 0;
                case 4:
                    bys.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32315);
                    return 0;
                case 5:
                    bys.Mec = aVar3.UbS.readString();
                    AppMethodBeat.o(32315);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar6))) {
                        }
                        bys.LRA = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(32315);
                    return 0;
                default:
                    AppMethodBeat.o(32315);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32315);
            return -1;
        }
    }
}

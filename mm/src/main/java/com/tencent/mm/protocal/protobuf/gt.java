package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class gt extends a {
    public gu KKt;
    public gv KKy;
    public b KKz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32124);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KKy == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: VoiceAttr");
                AppMethodBeat.o(32124);
                throw bVar;
            } else if (this.KKt == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: UploadCtx");
                AppMethodBeat.o(32124);
                throw bVar2;
            } else if (this.KKz == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: VoiceData");
                AppMethodBeat.o(32124);
                throw bVar3;
            } else {
                if (this.KKy != null) {
                    aVar.ni(1, this.KKy.computeSize());
                    this.KKy.writeFields(aVar);
                }
                if (this.KKt != null) {
                    aVar.ni(2, this.KKt.computeSize());
                    this.KKt.writeFields(aVar);
                }
                if (this.KKz != null) {
                    aVar.c(3, this.KKz);
                }
                AppMethodBeat.o(32124);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.KKy != null ? g.a.a.a.nh(1, this.KKy.computeSize()) + 0 : 0;
            if (this.KKt != null) {
                nh += g.a.a.a.nh(2, this.KKt.computeSize());
            }
            if (this.KKz != null) {
                nh += g.a.a.b.b.a.b(3, this.KKz);
            }
            AppMethodBeat.o(32124);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KKy == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: VoiceAttr");
                AppMethodBeat.o(32124);
                throw bVar4;
            } else if (this.KKt == null) {
                g.a.a.b bVar5 = new g.a.a.b("Not all required fields were included: UploadCtx");
                AppMethodBeat.o(32124);
                throw bVar5;
            } else if (this.KKz == null) {
                g.a.a.b bVar6 = new g.a.a.b("Not all required fields were included: VoiceData");
                AppMethodBeat.o(32124);
                throw bVar6;
            } else {
                AppMethodBeat.o(32124);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            gt gtVar = (gt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        gv gvVar = new gv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gvVar.populateBuilderWithField(aVar4, gvVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gtVar.KKy = gvVar;
                    }
                    AppMethodBeat.o(32124);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        gu guVar = new gu();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = guVar.populateBuilderWithField(aVar5, guVar, a.getNextFieldNumber(aVar5))) {
                        }
                        gtVar.KKt = guVar;
                    }
                    AppMethodBeat.o(32124);
                    return 0;
                case 3:
                    gtVar.KKz = aVar3.UbS.hPo();
                    AppMethodBeat.o(32124);
                    return 0;
                default:
                    AppMethodBeat.o(32124);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32124);
            return -1;
        }
    }
}

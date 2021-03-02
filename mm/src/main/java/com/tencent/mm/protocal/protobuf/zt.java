package com.tencent.mm.protocal.protobuf;

import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class zt extends dpc {
    public String KUA;
    public int Lla;
    public LinkedList<eib> Llb = new LinkedList<>();
    public int Llc;
    public String Md5;
    public int Version;

    public zt() {
        AppMethodBeat.i(6405);
        AppMethodBeat.o(6405);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(NativeBitmapStruct.GLFormat.GL_ALPHA);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.Version);
            if (this.KUA != null) {
                aVar.e(3, this.KUA);
            }
            if (this.Md5 != null) {
                aVar.e(4, this.Md5);
            }
            aVar.aM(5, this.Lla);
            aVar.e(6, 8, this.Llb);
            aVar.aM(7, this.Llc);
            AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Version);
            if (this.KUA != null) {
                nh += g.a.a.b.b.a.f(3, this.KUA);
            }
            if (this.Md5 != null) {
                nh += g.a.a.b.b.a.f(4, this.Md5);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.Lla) + g.a.a.a.c(6, 8, this.Llb) + g.a.a.b.b.a.bu(7, this.Llc);
            AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
            return bu;
        } else if (i2 == 2) {
            this.Llb.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
                throw bVar2;
            }
            AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            zt ztVar = (zt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        ztVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
                    return 0;
                case 2:
                    ztVar.Version = aVar3.UbS.zi();
                    AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
                    return 0;
                case 3:
                    ztVar.KUA = aVar3.UbS.readString();
                    AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
                    return 0;
                case 4:
                    ztVar.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
                    return 0;
                case 5:
                    ztVar.Lla = aVar3.UbS.zi();
                    AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eib eib = new eib();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eib.populateBuilderWithField(aVar5, eib, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ztVar.Llb.add(eib);
                    }
                    AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
                    return 0;
                case 7:
                    ztVar.Llc = aVar3.UbS.zi();
                    AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
                    return 0;
                default:
                    AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
                    return -1;
            }
        } else {
            AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_ALPHA);
            return -1;
        }
    }
}

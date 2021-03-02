package com.tencent.mm.plugin.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.api.a;
import com.tencent.mm.plugin.mmsight.model.b.b;
import com.tencent.mm.plugin.mmsight.model.b.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class a implements a.b {
    @Override // com.tencent.mm.plugin.mmsight.api.a.b
    public final com.tencent.mm.plugin.mmsight.api.a a(String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(89182);
        int i8 = ae.gKA.gIY;
        Log.i("MicroMsg.MMSightPresendRemuxerImpl", "get, configRemuxerType: %s", Integer.valueOf(i8));
        if (i8 != -1) {
            if (i8 == 1) {
                b bVar = new b(str, str2, i2, i3, i4, i5);
                AppMethodBeat.o(89182);
                return bVar;
            } else if (i8 == 2) {
                c cVar = new c(str, str2, i2, i3, i4, i5, i6, i7);
                AppMethodBeat.o(89182);
                return cVar;
            }
        }
        if (d.oD(19)) {
            b bVar2 = new b(str, str2, i2, i3, i4, i5);
            AppMethodBeat.o(89182);
            return bVar2;
        }
        c cVar2 = new c(str, str2, i2, i3, i4, i5, i6, i7);
        AppMethodBeat.o(89182);
        return cVar2;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.a.b
    public final com.tencent.mm.plugin.mmsight.api.a a(String str, String str2, int i2, int i3, int i4, int i5, long j2, long j3, int i6, int i7) {
        AppMethodBeat.i(89183);
        int i8 = ae.gKA.gIY;
        Log.i("MicroMsg.MMSightPresendRemuxerImpl", "get, configRemuxerType: %s", Integer.valueOf(i8));
        if (i8 != -1) {
            if (i8 == 1) {
                b bVar = new b(str, str2, i2, i3, i4, i5, j2, j3);
                AppMethodBeat.o(89183);
                return bVar;
            } else if (i8 == 2) {
                c cVar = new c(str, str2, i2, i3, i4, i5, j2, j3, i6, i7);
                AppMethodBeat.o(89183);
                return cVar;
            }
        }
        if (d.oD(19)) {
            b bVar2 = new b(str, str2, i2, i3, i4, i5, j2, j3);
            AppMethodBeat.o(89183);
            return bVar2;
        }
        c cVar2 = new c(str, str2, i2, i3, i4, i5, j2, j3, i6, i7);
        AppMethodBeat.o(89183);
        return cVar2;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.a.b
    public final com.tencent.mm.plugin.mmsight.api.a a(int i2, String str, String str2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.i(89184);
        if (i2 == 1) {
            b bVar = new b(str, str2, i3, i4, i5, i6);
            AppMethodBeat.o(89184);
            return bVar;
        } else if (i2 == 2) {
            c cVar = new c(str, str2, i3, i4, i5, i6, i7, i8);
            AppMethodBeat.o(89184);
            return cVar;
        } else {
            AppMethodBeat.o(89184);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.api.a.b
    public final com.tencent.mm.plugin.mmsight.api.a a(int i2, String str, String str2, int i3, int i4, int i5, int i6, long j2, long j3, int i7, int i8) {
        AppMethodBeat.i(89185);
        if (i2 == 1) {
            b bVar = new b(str, str2, i3, i4, i5, i6, j2, j3);
            AppMethodBeat.o(89185);
            return bVar;
        } else if (i2 == 2) {
            c cVar = new c(str, str2, i3, i4, i5, i6, j2, j3, i7, i8);
            AppMethodBeat.o(89185);
            return cVar;
        } else {
            AppMethodBeat.o(89185);
            return null;
        }
    }
}

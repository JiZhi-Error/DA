package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.b;
import com.tencent.qbar.QbarNative;

public final class d extends c implements b.a {
    private a lQM = new a(this, "barcode|qrcode");

    public d() {
        AppMethodBeat.i(46236);
        AppMethodBeat.o(46236);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.a.c
    public final b bGb() {
        return this.lQM;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.a
    public final void a(int i2, String str, int i3, byte[] bArr, QbarNative.QBarPoint qBarPoint) {
        AppMethodBeat.i(226733);
        this.lQL.a(i2, i3, str, bArr, qBarPoint);
        AppMethodBeat.o(226733);
    }
}

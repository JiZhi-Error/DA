package com.tencent.mm.plugin.appbrand.widget.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.jsapi.u.c;

@SuppressLint({"AppCompatCustomView"})
public final class e extends f implements a {
    private c cEN = null;
    private ad.b nal;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.f, com.tencent.mm.plugin.appbrand.widget.b.f
    public final /* bridge */ /* synthetic */ boolean bEY() {
        AppMethodBeat.i(137940);
        boolean bEY = super.bEY();
        AppMethodBeat.o(137940);
        return bEY;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.b.f
    public final /* bridge */ /* synthetic */ void setInterceptEvent(boolean z) {
        AppMethodBeat.i(137941);
        super.setInterceptEvent(z);
        AppMethodBeat.o(137941);
    }

    public e(Context context) {
        super(context);
    }

    public final void setImageFilePath(String str) {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.b.c
    public final void setImageByteArray(byte[] bArr) {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.b.a
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.u.b
    public final c getReferrerPolicy() {
        return this.cEN;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.u.b
    public final void setReferrerPolicy(c cVar) {
        this.cEN = cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.b.a
    public final void setKeyValueSet(ad.b bVar) {
        this.nal = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.b.a
    public final ad.b getKeyValueSet() {
        return this.nal;
    }
}

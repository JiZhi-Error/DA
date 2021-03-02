package com.tencent.luggage.game.b.a;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b;
import com.tencent.luggage.game.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.nio.ByteBuffer;

public final class a extends c<c.b> {
    private final String appId;
    private final q cuH;

    public a(c.b bVar) {
        super(bVar);
        AppMethodBeat.i(222867);
        this.appId = bVar.LR();
        this.cuH = bVar.getFileSystem();
        AppMethodBeat.o(222867);
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final boolean accept(Object obj) {
        return true;
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final b.a a(Object obj, ImageDecodeConfig imageDecodeConfig) {
        AppMethodBeat.i(222868);
        b.a aVar = new b.a();
        String str = (String) obj;
        if (this.cuH == null) {
            Log.e("MicroMsg.AppBrandFileSystemImageStreamFetcher", "fetch %s, appId[%s] fs NULL", str, this.appId);
            aVar.errorMsg = MMApplicationContext.getContext().getString(R.string.a12);
            AppMethodBeat.o(222868);
            return aVar;
        }
        i<ByteBuffer> iVar = new i<>();
        m b2 = this.cuH.b(str, iVar);
        if (b2 != m.OK || iVar.value == null) {
            Log.e("MicroMsg.AppBrandFileSystemImageStreamFetcher", "fetch %s, ret %s, appId[%s]", str, b2.name(), this.appId);
            aVar.errorMsg = String.format(MMApplicationContext.getContext().getString(R.string.a11), b2.name());
        } else {
            aVar.inputStream = new com.tencent.luggage.h.a(iVar.value);
        }
        AppMethodBeat.o(222868);
        return aVar;
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final String sS() {
        return "appbrand_file";
    }
}

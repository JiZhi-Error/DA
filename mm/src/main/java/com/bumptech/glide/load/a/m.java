package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class m extends b<InputStream> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.b
    public final /* synthetic */ void R(InputStream inputStream) {
        AppMethodBeat.i(76898);
        inputStream.close();
        AppMethodBeat.o(76898);
    }

    public m(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.bumptech.glide.load.a.d
    public final Class<InputStream> os() {
        return InputStream.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.b
    public final /* synthetic */ InputStream a(AssetManager assetManager, String str) {
        AppMethodBeat.i(76899);
        InputStream open = assetManager.open(str);
        AppMethodBeat.o(76899);
        return open;
    }
}

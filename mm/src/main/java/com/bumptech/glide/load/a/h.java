package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h extends b<ParcelFileDescriptor> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.b
    public final /* synthetic */ void R(ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(76885);
        parcelFileDescriptor.close();
        AppMethodBeat.o(76885);
    }

    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.bumptech.glide.load.a.d
    public final Class<ParcelFileDescriptor> os() {
        return ParcelFileDescriptor.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.b
    public final /* synthetic */ ParcelFileDescriptor a(AssetManager assetManager, String str) {
        AppMethodBeat.i(76886);
        ParcelFileDescriptor parcelFileDescriptor = assetManager.openFd(str).getParcelFileDescriptor();
        AppMethodBeat.o(76886);
        return parcelFileDescriptor;
    }
}

package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;

public final class a extends l<AssetFileDescriptor> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.l
    public final /* synthetic */ void R(AssetFileDescriptor assetFileDescriptor) {
        AppMethodBeat.i(76863);
        assetFileDescriptor.close();
        AppMethodBeat.o(76863);
    }

    public a(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.a.d
    public final Class<AssetFileDescriptor> os() {
        return AssetFileDescriptor.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.l
    public final /* synthetic */ AssetFileDescriptor a(Uri uri, ContentResolver contentResolver) {
        AppMethodBeat.i(76864);
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("FileDescriptor is null for: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(76864);
            throw fileNotFoundException;
        }
        AppMethodBeat.o(76864);
        return openAssetFileDescriptor;
    }
}

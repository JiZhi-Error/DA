package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;

public final class i extends l<ParcelFileDescriptor> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.l
    public final /* synthetic */ void R(ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(76887);
        parcelFileDescriptor.close();
        AppMethodBeat.o(76887);
    }

    public i(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.a.d
    public final Class<ParcelFileDescriptor> os() {
        return ParcelFileDescriptor.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.l
    public final /* synthetic */ ParcelFileDescriptor a(Uri uri, ContentResolver contentResolver) {
        AppMethodBeat.i(76888);
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("FileDescriptor is null for: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(76888);
            throw fileNotFoundException;
        }
        ParcelFileDescriptor parcelFileDescriptor = openAssetFileDescriptor.getParcelFileDescriptor();
        AppMethodBeat.o(76888);
        return parcelFileDescriptor;
    }
}

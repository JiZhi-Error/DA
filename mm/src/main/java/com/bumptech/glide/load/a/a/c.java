package com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.g;
import com.bumptech.glide.load.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class c implements d<InputStream> {
    private final Uri aFr;
    private final e aFs;
    private InputStream inputStream;

    public static c a(Context context, Uri uri, d dVar) {
        AppMethodBeat.i(76907);
        c cVar = new c(uri, new e(com.bumptech.glide.c.af(context).aCn.nO(), dVar, com.bumptech.glide.c.af(context).aCo, context.getContentResolver()));
        AppMethodBeat.o(76907);
        return cVar;
    }

    private c(Uri uri, e eVar) {
        this.aFr = uri;
        this.aFs = eVar;
    }

    @Override // com.bumptech.glide.load.a.d
    public final void cleanup() {
        AppMethodBeat.i(76909);
        if (this.inputStream != null) {
            try {
                this.inputStream.close();
                AppMethodBeat.o(76909);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(76909);
    }

    @Override // com.bumptech.glide.load.a.d
    public final void cancel() {
    }

    @Override // com.bumptech.glide.load.a.d
    public final Class<InputStream> os() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.a.d
    public final com.bumptech.glide.load.a ot() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    public static class b implements d {
        private static final String[] aFt = {"_data"};
        private final ContentResolver aFp;

        public b(ContentResolver contentResolver) {
            this.aFp = contentResolver;
        }

        @Override // com.bumptech.glide.load.a.a.d
        public final Cursor h(Uri uri) {
            AppMethodBeat.i(76906);
            String lastPathSegment = uri.getLastPathSegment();
            Cursor query = this.aFp.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, aFt, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, null);
            AppMethodBeat.o(76906);
            return query;
        }
    }

    public static class a implements d {
        private static final String[] aFt = {"_data"};
        private final ContentResolver aFp;

        public a(ContentResolver contentResolver) {
            this.aFp = contentResolver;
        }

        @Override // com.bumptech.glide.load.a.a.d
        public final Cursor h(Uri uri) {
            AppMethodBeat.i(76905);
            String lastPathSegment = uri.getLastPathSegment();
            Cursor query = this.aFp.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, aFt, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            AppMethodBeat.o(76905);
            return query;
        }
    }

    @Override // com.bumptech.glide.load.a.d
    public final void a(g gVar, d.a<? super InputStream> aVar) {
        int i2;
        InputStream inputStream2;
        AppMethodBeat.i(76908);
        try {
            InputStream j2 = this.aFs.j(this.aFr);
            if (j2 != null) {
                i2 = this.aFs.i(this.aFr);
            } else {
                i2 = -1;
            }
            if (i2 != -1) {
                inputStream2 = new com.bumptech.glide.load.a.g(j2, i2);
            } else {
                inputStream2 = j2;
            }
            this.inputStream = inputStream2;
            aVar.S(this.inputStream);
            AppMethodBeat.o(76908);
        } catch (FileNotFoundException e2) {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            aVar.e(e2);
            AppMethodBeat.o(76908);
        }
    }
}

package com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/* access modifiers changed from: package-private */
public final class e {
    private static final a aFu = new a();
    private final b aFo;
    private final ContentResolver aFp;
    private final a aFv;
    private final d aFw;
    private final List<ImageHeaderParser> aFx;

    static {
        AppMethodBeat.i(76913);
        AppMethodBeat.o(76913);
    }

    e(List<ImageHeaderParser> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, aFu, dVar, bVar, contentResolver);
    }

    private e(List<ImageHeaderParser> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        this.aFv = aVar;
        this.aFw = dVar;
        this.aFo = bVar;
        this.aFp = contentResolver;
        this.aFx = list;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a A[Catch:{ all -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037 A[SYNTHETIC, Splitter:B:17:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[SYNTHETIC, Splitter:B:23:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int i(android.net.Uri r6) {
        /*
            r5 = this;
            r4 = 76910(0x12c6e, float:1.07774E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            r0 = 0
            android.content.ContentResolver r1 = r5.aFp     // Catch:{ IOException -> 0x001e, NullPointerException -> 0x0055, all -> 0x003f }
            java.io.InputStream r1 = r1.openInputStream(r6)     // Catch:{ IOException -> 0x001e, NullPointerException -> 0x0055, all -> 0x003f }
            java.util.List<com.bumptech.glide.load.ImageHeaderParser> r0 = r5.aFx     // Catch:{ IOException -> 0x005a, NullPointerException -> 0x0058 }
            com.bumptech.glide.load.b.a.b r2 = r5.aFo     // Catch:{ IOException -> 0x005a, NullPointerException -> 0x0058 }
            int r0 = com.bumptech.glide.load.f.b(r0, r1, r2)     // Catch:{ IOException -> 0x005a, NullPointerException -> 0x0058 }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ IOException -> 0x004b }
        L_0x001a:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x001d:
            return r0
        L_0x001e:
            r1 = move-exception
        L_0x001f:
            r1 = r0
        L_0x0020:
            java.lang.String r0 = "ThumbStreamOpener"
            r2 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0035
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "Failed to open uri: "
            r0.<init>(r2)     // Catch:{ all -> 0x0051 }
            r0.append(r6)     // Catch:{ all -> 0x0051 }
        L_0x0035:
            if (r1 == 0) goto L_0x003a
            r1.close()     // Catch:{ IOException -> 0x004d }
        L_0x003a:
            r0 = -1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x001d
        L_0x003f:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L_0x0042:
            if (r3 == 0) goto L_0x0047
            r3.close()     // Catch:{ IOException -> 0x004f }
        L_0x0047:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r2
        L_0x004b:
            r1 = move-exception
            goto L_0x001a
        L_0x004d:
            r0 = move-exception
            goto L_0x003a
        L_0x004f:
            r0 = move-exception
            goto L_0x0047
        L_0x0051:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L_0x0042
        L_0x0055:
            r1 = move-exception
            r1 = r0
            goto L_0x0020
        L_0x0058:
            r0 = move-exception
            goto L_0x0020
        L_0x005a:
            r0 = move-exception
            r0 = r1
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.a.a.e.i(android.net.Uri):int");
    }

    public final InputStream j(Uri uri) {
        boolean z;
        InputStream inputStream = null;
        AppMethodBeat.i(76911);
        String k = k(uri);
        if (TextUtils.isEmpty(k)) {
            AppMethodBeat.o(76911);
        } else {
            File file = new File(k);
            if (!file.exists() || 0 >= file.length()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                AppMethodBeat.o(76911);
            } else {
                Uri fromFile = Uri.fromFile(file);
                try {
                    inputStream = this.aFp.openInputStream(fromFile);
                    AppMethodBeat.o(76911);
                } catch (NullPointerException e2) {
                    FileNotFoundException fileNotFoundException = (FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e2);
                    AppMethodBeat.o(76911);
                    throw fileNotFoundException;
                }
            }
        }
        return inputStream;
    }

    private String k(Uri uri) {
        AppMethodBeat.i(76912);
        Cursor h2 = this.aFw.h(uri);
        if (h2 != null) {
            try {
                if (h2.moveToFirst()) {
                    return h2.getString(0);
                }
            } finally {
                if (h2 != null) {
                    h2.close();
                }
                AppMethodBeat.o(76912);
            }
        }
        if (h2 != null) {
            h2.close();
        }
        AppMethodBeat.o(76912);
        return null;
    }
}

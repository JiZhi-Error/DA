package com.bumptech.glide.load.b.b;

import android.content.Context;
import com.bumptech.glide.load.b.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class f extends d {
    public f(Context context) {
        this(context, "image_manager_disk_cache");
    }

    private f(final Context context, final String str) {
        super(new d.a() {
            /* class com.bumptech.glide.load.b.b.f.AnonymousClass1 */

            @Override // com.bumptech.glide.load.b.b.d.a
            public final File ph() {
                AppMethodBeat.i(77154);
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    AppMethodBeat.o(77154);
                    return null;
                } else if (str != null) {
                    File file = new File(cacheDir, str);
                    AppMethodBeat.o(77154);
                    return file;
                } else {
                    AppMethodBeat.o(77154);
                    return cacheDir;
                }
            }
        });
        AppMethodBeat.i(77155);
        AppMethodBeat.o(77155);
    }
}

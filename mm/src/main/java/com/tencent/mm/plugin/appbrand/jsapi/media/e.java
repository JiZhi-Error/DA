package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public interface e extends b {
    public static final e mca = new e() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.media.e.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.e
        public final Bitmap decodeFile(String str, BitmapFactory.Options options) {
            AppMethodBeat.i(139865);
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            AppMethodBeat.o(139865);
            return decodeFile;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.e
        public final Bitmap b(InputStream inputStream, BitmapFactory.Options options) {
            AppMethodBeat.i(139866);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            AppMethodBeat.o(139866);
            return decodeStream;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.e
        public final Bitmap decodeStream(InputStream inputStream) {
            AppMethodBeat.i(221237);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            AppMethodBeat.o(221237);
            return decodeStream;
        }
    };

    Bitmap b(InputStream inputStream, BitmapFactory.Options options);

    Bitmap decodeFile(String str, BitmapFactory.Options options);

    Bitmap decodeStream(InputStream inputStream);

    public static class a {
        public static e a(e eVar) {
            return eVar == null ? e.mca : eVar;
        }
    }
}

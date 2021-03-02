package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.io.InputStream;

public final class p implements e {
    public static final p meq = new p();

    static {
        AppMethodBeat.i(46601);
        AppMethodBeat.o(46601);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.media.e
    public final Bitmap decodeFile(String str, BitmapFactory.Options options) {
        AppMethodBeat.i(46599);
        Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
        AppMethodBeat.o(46599);
        return decodeFile;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.media.e
    public final Bitmap b(InputStream inputStream, BitmapFactory.Options options) {
        AppMethodBeat.i(46600);
        Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options);
        AppMethodBeat.o(46600);
        return decodeStream;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.media.e
    public final Bitmap decodeStream(InputStream inputStream) {
        AppMethodBeat.i(204362);
        Bitmap decodeStream = BitmapUtil.decodeStream(inputStream);
        AppMethodBeat.o(204362);
        return decodeStream;
    }
}

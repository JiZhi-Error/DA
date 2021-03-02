package com.bumptech.glide.load.d.a;

import android.media.ExifInterface;
import android.support.e.a;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class k implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType c(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final int a(InputStream inputStream, b bVar) {
        AppMethodBeat.i(204480);
        int attributeInt = new ExifInterface(inputStream).getAttributeInt(a.TAG_ORIENTATION, 1);
        if (attributeInt == 0) {
            AppMethodBeat.o(204480);
            return -1;
        }
        AppMethodBeat.o(204480);
        return attributeInt;
    }
}

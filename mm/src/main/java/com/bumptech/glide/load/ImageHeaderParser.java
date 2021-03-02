package com.bumptech.glide.load;

import com.bumptech.glide.load.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface ImageHeaderParser {
    int a(InputStream inputStream, b bVar);

    ImageType a(ByteBuffer byteBuffer);

    ImageType c(InputStream inputStream);

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean aEU;

        public static ImageType valueOf(String str) {
            AppMethodBeat.i(76844);
            ImageType imageType = (ImageType) Enum.valueOf(ImageType.class, str);
            AppMethodBeat.o(76844);
            return imageType;
        }

        static {
            AppMethodBeat.i(76845);
            AppMethodBeat.o(76845);
        }

        private ImageType(boolean z) {
            this.aEU = z;
        }

        public final boolean hasAlpha() {
            return this.aEU;
        }
    }
}

package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.d.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.List;

public final class f {
    public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, InputStream inputStream, b bVar) {
        AppMethodBeat.i(76846);
        if (inputStream == null) {
            ImageHeaderParser.ImageType imageType = ImageHeaderParser.ImageType.UNKNOWN;
            AppMethodBeat.o(76846);
            return imageType;
        }
        if (!inputStream.markSupported()) {
            inputStream = new n(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ImageHeaderParser.ImageType c2 = list.get(i2).c(inputStream);
                if (c2 != ImageHeaderParser.ImageType.UNKNOWN) {
                    return c2;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
                AppMethodBeat.o(76846);
            }
        }
        ImageHeaderParser.ImageType imageType2 = ImageHeaderParser.ImageType.UNKNOWN;
        AppMethodBeat.o(76846);
        return imageType2;
    }

    public static int b(List<ImageHeaderParser> list, InputStream inputStream, b bVar) {
        AppMethodBeat.i(76847);
        if (inputStream == null) {
            AppMethodBeat.o(76847);
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new n(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                int a2 = list.get(i2).a(inputStream, bVar);
                if (a2 != -1) {
                    return a2;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
                AppMethodBeat.o(76847);
            }
        }
        AppMethodBeat.o(76847);
        return -1;
    }
}

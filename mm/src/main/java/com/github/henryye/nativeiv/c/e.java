package com.github.henryye.nativeiv.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public final class e {
    public static InputStream l(InputStream inputStream) {
        AppMethodBeat.i(127399);
        if (!inputStream.markSupported()) {
            if (inputStream instanceof FileInputStream) {
                inputStream = new c((FileInputStream) inputStream);
            } else {
                inputStream = new BufferedInputStream(inputStream);
            }
        }
        AppMethodBeat.o(127399);
        return inputStream;
    }
}

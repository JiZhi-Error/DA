package com.github.henryye.nativeiv.b;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import java.io.InputStream;

public interface b {
    a a(Object obj, ImageDecodeConfig imageDecodeConfig);

    boolean accept(Object obj);

    String sS();

    public static class a {
        public String errorMsg;
        public InputStream inputStream;

        public a() {
        }

        public a(InputStream inputStream2) {
            this.inputStream = inputStream2;
        }
    }
}

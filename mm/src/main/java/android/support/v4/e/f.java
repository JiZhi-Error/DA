package android.support.v4.e;

import java.io.Writer;

public final class f extends Writer {
    private StringBuilder mBuilder = new StringBuilder(128);
    private final String mTag;

    public f(String str) {
        this.mTag = str;
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public final void close() {
        fw();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        fw();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                fw();
            } else {
                this.mBuilder.append(c2);
            }
        }
    }

    private void fw() {
        if (this.mBuilder.length() > 0) {
            this.mBuilder.delete(0, this.mBuilder.length());
        }
    }
}

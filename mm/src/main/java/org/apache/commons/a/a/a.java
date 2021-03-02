package org.apache.commons.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class a extends OutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final List<byte[]> UeF;
    private int UeG;
    private int UeH;
    private byte[] UeI;
    private boolean UeJ;
    private int count;

    public a() {
        this((byte) 0);
    }

    private a(byte b2) {
        AppMethodBeat.i(10290);
        this.UeF = new ArrayList();
        this.UeJ = true;
        synchronized (this) {
            try {
                awk(1024);
            } finally {
                AppMethodBeat.o(10290);
            }
        }
    }

    private void awk(int i2) {
        AppMethodBeat.i(10291);
        if (this.UeG < this.UeF.size() - 1) {
            this.UeH += this.UeI.length;
            this.UeG++;
            this.UeI = this.UeF.get(this.UeG);
            AppMethodBeat.o(10291);
            return;
        }
        if (this.UeI == null) {
            this.UeH = 0;
        } else {
            i2 = Math.max(this.UeI.length << 1, i2 - this.UeH);
            this.UeH += this.UeI.length;
        }
        this.UeG++;
        this.UeI = new byte[i2];
        this.UeF.add(this.UeI);
        AppMethodBeat.o(10291);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(10292);
        if (i2 < 0 || i2 > bArr.length || i3 < 0 || i2 + i3 > bArr.length || i2 + i3 < 0) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(10292);
            throw indexOutOfBoundsException;
        } else if (i3 == 0) {
            AppMethodBeat.o(10292);
        } else {
            synchronized (this) {
                try {
                    int i4 = this.count + i3;
                    int i5 = this.count - this.UeH;
                    int i6 = i3;
                    while (i6 > 0) {
                        int min = Math.min(i6, this.UeI.length - i5);
                        System.arraycopy(bArr, (i2 + i3) - i6, this.UeI, i5, min);
                        i6 -= min;
                        if (i6 > 0) {
                            awk(i4);
                            i5 = 0;
                        }
                    }
                    this.count = i4;
                } finally {
                    AppMethodBeat.o(10292);
                }
            }
        }
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i2) {
        AppMethodBeat.i(10293);
        int i3 = this.count - this.UeH;
        if (i3 == this.UeI.length) {
            awk(this.count + 1);
            i3 = 0;
        }
        this.UeI[i3] = (byte) i2;
        this.count++;
        AppMethodBeat.o(10293);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final synchronized byte[] toByteArray() {
        byte[] bArr;
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(10294);
            int i3 = this.count;
            if (i3 == 0) {
                bArr = EMPTY_BYTE_ARRAY;
                AppMethodBeat.o(10294);
            } else {
                byte[] bArr2 = new byte[i3];
                for (byte[] bArr3 : this.UeF) {
                    int min = Math.min(bArr3.length, i3);
                    System.arraycopy(bArr3, 0, bArr2, i2, min);
                    i2 += min;
                    i3 -= min;
                    if (i3 == 0) {
                        break;
                    }
                }
                AppMethodBeat.o(10294);
                bArr = bArr2;
            }
        }
        return bArr;
    }

    @Deprecated
    public final String toString() {
        AppMethodBeat.i(10295);
        String str = new String(toByteArray(), Charset.defaultCharset());
        AppMethodBeat.o(10295);
        return str;
    }
}

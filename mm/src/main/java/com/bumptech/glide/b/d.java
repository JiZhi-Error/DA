package com.bumptech.glide.b;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.cr;
import com.tencent.smtt.sdk.WebView;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public final class d {
    public final byte[] aEo = new byte[256];
    public ByteBuffer aEp;
    public c aEq;
    public int blockSize = 0;

    public d() {
        AppMethodBeat.i(3468);
        AppMethodBeat.o(3468);
    }

    public final void ok() {
        AppMethodBeat.i(3469);
        boolean z = false;
        while (!z && !op() && this.aEq.frameCount <= Integer.MAX_VALUE) {
            switch (read()) {
                case 33:
                    switch (read()) {
                        case 1:
                            on();
                            continue;
                        case cr.CTRL_INDEX /*{ENCODED_INT: 249}*/:
                            this.aEq.aEi = new b();
                            read();
                            int read = read();
                            this.aEq.aEi.aEd = (read & 28) >> 2;
                            if (this.aEq.aEi.aEd == 0) {
                                this.aEq.aEi.aEd = 1;
                            }
                            this.aEq.aEi.aEc = (read & 1) != 0;
                            short s = this.aEp.getShort();
                            if (s < 2) {
                                s = 10;
                            }
                            this.aEq.aEi.delay = s * 10;
                            this.aEq.aEi.aEe = read();
                            read();
                            continue;
                        case 254:
                            on();
                            continue;
                        case 255:
                            oo();
                            StringBuilder sb = new StringBuilder();
                            for (int i2 = 0; i2 < 11; i2++) {
                                sb.append((char) this.aEo[i2]);
                            }
                            if (!sb.toString().equals("NETSCAPE2.0")) {
                                on();
                                break;
                            } else {
                                ol();
                                continue;
                            }
                        default:
                            on();
                            continue;
                    }
                case 44:
                    if (this.aEq.aEi == null) {
                        this.aEq.aEi = new b();
                    }
                    this.aEq.aEi.aDX = this.aEp.getShort();
                    this.aEq.aEi.aDY = this.aEp.getShort();
                    this.aEq.aEi.aDZ = this.aEp.getShort();
                    this.aEq.aEi.aEa = this.aEp.getShort();
                    int read2 = read();
                    boolean z2 = (read2 & 128) != 0;
                    int pow = (int) Math.pow(2.0d, (double) ((read2 & 7) + 1));
                    b bVar = this.aEq.aEi;
                    bVar.aEb = (read2 & 64) != 0;
                    if (z2) {
                        this.aEq.aEi.aEg = dg(pow);
                    } else {
                        this.aEq.aEi.aEg = null;
                    }
                    this.aEq.aEi.aEf = this.aEp.position();
                    read();
                    on();
                    if (!op()) {
                        this.aEq.frameCount++;
                        this.aEq.aEj.add(this.aEq.aEi);
                        break;
                    } else {
                        break;
                    }
                case bv.CTRL_INDEX /*{ENCODED_INT: 59}*/:
                    z = true;
                    break;
                default:
                    this.aEq.status = 1;
                    break;
            }
        }
        AppMethodBeat.o(3469);
    }

    private void ol() {
        AppMethodBeat.i(3470);
        do {
            oo();
            if (this.aEo[0] == 1) {
                this.aEq.loopCount = (this.aEo[1] & 255) | ((this.aEo[2] & 255) << 8);
            }
            if (this.blockSize <= 0) {
                break;
            }
        } while (!op());
        AppMethodBeat.o(3470);
    }

    public final void om() {
        boolean z = true;
        AppMethodBeat.i(3471);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) read());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.aEq.status = 1;
            AppMethodBeat.o(3471);
            return;
        }
        this.aEq.width = this.aEp.getShort();
        this.aEq.height = this.aEp.getShort();
        int read = read();
        c cVar = this.aEq;
        if ((read & 128) == 0) {
            z = false;
        }
        cVar.aEk = z;
        this.aEq.aEl = (int) Math.pow(2.0d, (double) ((read & 7) + 1));
        this.aEq.aEm = read();
        this.aEq.aEn = read();
        if (this.aEq.aEk && !op()) {
            this.aEq.aEh = dg(this.aEq.aEl);
            this.aEq.bgColor = this.aEq.aEh[this.aEq.aEm];
        }
        AppMethodBeat.o(3471);
    }

    private int[] dg(int i2) {
        AppMethodBeat.i(3472);
        int[] iArr = null;
        byte[] bArr = new byte[(i2 * 3)];
        try {
            this.aEp.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i4 < i2) {
                int i5 = i3 + 1;
                int i6 = bArr[i3] & 255;
                int i7 = i5 + 1;
                int i8 = bArr[i5] & 255;
                i3 = i7 + 1;
                int i9 = i4 + 1;
                iArr[i4] = (i6 << 16) | WebView.NIGHT_MODE_COLOR | (i8 << 8) | (bArr[i7] & 255);
                i4 = i9;
            }
        } catch (BufferUnderflowException e2) {
            Log.isLoggable("GifHeaderParser", 3);
            this.aEq.status = 1;
        }
        AppMethodBeat.o(3472);
        return iArr;
    }

    private void on() {
        int read;
        AppMethodBeat.i(3473);
        do {
            read = read();
            this.aEp.position(Math.min(this.aEp.position() + read, this.aEp.limit()));
        } while (read > 0);
        AppMethodBeat.o(3473);
    }

    private void oo() {
        int i2 = 0;
        AppMethodBeat.i(3474);
        this.blockSize = read();
        if (this.blockSize > 0) {
            int i3 = 0;
            while (i2 < this.blockSize) {
                try {
                    i3 = this.blockSize - i2;
                    this.aEp.get(this.aEo, i2, i3);
                    i2 += i3;
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        new StringBuilder("Error Reading Block n: ").append(i2).append(" count: ").append(i3).append(" blockSize: ").append(this.blockSize);
                    }
                    this.aEq.status = 1;
                }
            }
            AppMethodBeat.o(3474);
            return;
        }
        AppMethodBeat.o(3474);
    }

    private int read() {
        AppMethodBeat.i(3475);
        int i2 = 0;
        try {
            i2 = this.aEp.get() & 255;
        } catch (Exception e2) {
            this.aEq.status = 1;
        }
        AppMethodBeat.o(3475);
        return i2;
    }

    public final boolean op() {
        return this.aEq.status != 0;
    }
}

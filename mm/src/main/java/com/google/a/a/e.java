package com.google.a.a;

import java.io.IOException;

public abstract class e {
    protected volatile int cbo = -1;

    public abstract e a(a aVar);

    public final int If() {
        if (this.cbo < 0) {
            yC();
        }
        return this.cbo;
    }

    public final int yC() {
        int Ig = Ig();
        this.cbo = Ig;
        return Ig;
    }

    /* access modifiers changed from: protected */
    public int Ig() {
        return 0;
    }

    public void a(b bVar) {
    }

    public static final byte[] b(e eVar) {
        byte[] bArr = new byte[eVar.yC()];
        try {
            b bVar = new b(bArr, bArr.length);
            eVar.a(bVar);
            if (bVar.limit - bVar.position == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        return f.c(this);
    }

    public static <T extends e> T a(T t, byte[] bArr, int i2) {
        try {
            a aVar = new a(bArr, i2);
            t.a(aVar);
            aVar.fF(0);
            return t;
        } catch (d e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }
}

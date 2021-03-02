package com.tencent.mm.bw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;

public final class b {
    public byte[] zy;

    private b() {
    }

    public b(byte[] bArr) {
        this(bArr, 0, bArr.length);
        AppMethodBeat.i(2357);
        AppMethodBeat.o(2357);
    }

    public b(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(2358);
        this.zy = new byte[i3];
        System.arraycopy(bArr, i2, this.zy, 0, i3);
        AppMethodBeat.o(2358);
    }

    public static b Q(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(2359);
        b bVar = new b(bArr, i2, i3);
        AppMethodBeat.o(2359);
        return bVar;
    }

    public static b cD(byte[] bArr) {
        AppMethodBeat.i(2360);
        if (bArr == null) {
            bArr = new byte[0];
        }
        b bVar = new b(bArr);
        AppMethodBeat.o(2360);
        return bVar;
    }

    public static b bfZ(String str) {
        AppMethodBeat.i(2361);
        try {
            b bVar = new b();
            bVar.zy = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(2361);
            return bVar;
        } catch (UnsupportedEncodingException e2) {
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported?", e2);
            AppMethodBeat.o(2361);
            throw runtimeException;
        }
    }

    public final b aiU(int i2) {
        AppMethodBeat.i(2362);
        byte[] bArr = new byte[i2];
        if (this.zy.length >= i2) {
            System.arraycopy(this.zy, 0, bArr, 0, i2 - 1);
            this.zy = bArr;
        } else {
            System.arraycopy(this.zy, 0, bArr, 0, this.zy.length);
            this.zy = bArr;
        }
        AppMethodBeat.o(2362);
        return this;
    }

    public final void cE(byte[] bArr) {
        AppMethodBeat.i(2363);
        System.arraycopy(this.zy, 0, bArr, 4, this.zy.length);
        AppMethodBeat.o(2363);
    }

    public final void j(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(2364);
        System.arraycopy(this.zy, i2, bArr, i3, i4);
        AppMethodBeat.o(2364);
    }

    public final byte[] toByteArray() {
        AppMethodBeat.i(2365);
        int length = this.zy.length;
        byte[] bArr = new byte[length];
        System.arraycopy(this.zy, 0, bArr, 0, length);
        AppMethodBeat.o(2365);
        return bArr;
    }

    public final String toString(String str) {
        AppMethodBeat.i(196829);
        String str2 = new String(this.zy, str);
        AppMethodBeat.o(196829);
        return str2;
    }

    public final String yO() {
        int i2 = 0;
        AppMethodBeat.i(2366);
        while (i2 < this.zy.length && this.zy[i2] != 0) {
            try {
                i2++;
            } catch (UnsupportedEncodingException e2) {
                RuntimeException runtimeException = new RuntimeException("UTF-8 not supported?");
                AppMethodBeat.o(2366);
                throw runtimeException;
            }
        }
        String str = new String(this.zy, 0, i2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        AppMethodBeat.o(2366);
        return str;
    }
}

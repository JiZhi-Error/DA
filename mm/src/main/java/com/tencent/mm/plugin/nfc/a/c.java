package com.tencent.mm.plugin.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.c.a;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public final class c implements Serializable {
    public byte[] ADT;

    public c(byte[] bArr) {
        AppMethodBeat.i(26648);
        if (bArr == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("apdu is null");
            AppMethodBeat.o(26648);
            throw illegalArgumentException;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        bV(bArr2);
        this.ADT = bArr2;
        AppMethodBeat.o(26648);
    }

    private static void bV(byte[] bArr) {
        AppMethodBeat.i(26649);
        if (bArr.length < 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("apdu must be at least 2 bytes long");
            AppMethodBeat.o(26649);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(26649);
    }

    public final short ext() {
        return (short) (this.ADT[this.ADT.length - 2] & 255);
    }

    public final short exu() {
        return (short) (this.ADT[this.ADT.length - 1] & 255);
    }

    public final String toString() {
        AppMethodBeat.i(26651);
        String byteArrayToHexString = a.byteArrayToHexString(this.ADT);
        AppMethodBeat.o(26651);
        return byteArrayToHexString;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(26652);
        int length = this.ADT.length;
        this.ADT = Arrays.copyOf(this.ADT, (this.ADT.length + cVar.ADT.length) - 2);
        int i2 = length - 2;
        byte[] bArr = (byte[]) cVar.ADT.clone();
        int length2 = bArr.length;
        int i3 = 0;
        while (i3 < length2) {
            this.ADT[i2] = bArr[i3];
            i3++;
            i2++;
        }
        AppMethodBeat.o(26652);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(26653);
        if (this == obj) {
            AppMethodBeat.o(26653);
            return true;
        } else if (!(obj instanceof c)) {
            AppMethodBeat.o(26653);
            return false;
        } else {
            boolean equals = Arrays.equals(this.ADT, ((c) obj).ADT);
            AppMethodBeat.o(26653);
            return equals;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(26654);
        int hashCode = Arrays.hashCode(this.ADT);
        AppMethodBeat.o(26654);
        return hashCode;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        AppMethodBeat.i(26655);
        this.ADT = (byte[]) objectInputStream.readUnshared();
        bV(this.ADT);
        AppMethodBeat.o(26655);
    }

    public final boolean exv() {
        AppMethodBeat.i(26650);
        if (((short) ((ext() << 8) | exu())) == -28672) {
            AppMethodBeat.o(26650);
            return true;
        }
        AppMethodBeat.o(26650);
        return false;
    }
}

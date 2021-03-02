package com.tencent.mm.plugin.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public final class a implements Serializable {
    private byte[] ADT;
    private transient int ADU;
    private transient int ADV;
    private transient int ADW;

    public a(byte[] bArr) {
        AppMethodBeat.i(26640);
        this.ADT = (byte[]) bArr.clone();
        parse();
        AppMethodBeat.o(26640);
    }

    public a(String str) {
        AppMethodBeat.i(26641);
        this.ADT = com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(str);
        parse();
        AppMethodBeat.o(26641);
    }

    private void parse() {
        int i2 = 256;
        AppMethodBeat.i(26642);
        if (this.ADT.length < 4) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("apdu must be at least 4 bytes long");
            AppMethodBeat.o(26642);
            throw illegalArgumentException;
        } else if (this.ADT.length == 4) {
            AppMethodBeat.o(26642);
        } else {
            int i3 = this.ADT[4] & 255;
            if (this.ADT.length == 5) {
                if (i3 != 0) {
                    i2 = i3;
                }
                this.ADV = i2;
                AppMethodBeat.o(26642);
            } else if (i3 != 0) {
                if (this.ADT.length == i3 + 5) {
                    this.ADU = i3;
                    this.ADW = 5;
                    AppMethodBeat.o(26642);
                } else if (this.ADT.length == i3 + 6) {
                    this.ADU = i3;
                    this.ADW = 5;
                    int i4 = this.ADT[this.ADT.length - 1] & 255;
                    if (i4 != 0) {
                        i2 = i4;
                    }
                    this.ADV = i2;
                    AppMethodBeat.o(26642);
                } else {
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid APDU: length=" + this.ADT.length + ", b1=" + i3);
                    AppMethodBeat.o(26642);
                    throw illegalArgumentException2;
                }
            } else if (this.ADT.length < 7) {
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid APDU: length=" + this.ADT.length + ", b1=" + i3);
                AppMethodBeat.o(26642);
                throw illegalArgumentException3;
            } else {
                int i5 = ((this.ADT[5] & 255) << 8) | (this.ADT[6] & 255);
                if (this.ADT.length == 7) {
                    if (i5 == 0) {
                        i5 = 65536;
                    }
                    this.ADV = i5;
                    AppMethodBeat.o(26642);
                } else if (i5 == 0) {
                    IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Invalid APDU: length=" + this.ADT.length + ", b1=" + i3 + ", b2||b3=" + i5);
                    AppMethodBeat.o(26642);
                    throw illegalArgumentException4;
                } else if (this.ADT.length == i5 + 7) {
                    this.ADU = i5;
                    this.ADW = 7;
                    AppMethodBeat.o(26642);
                } else if (this.ADT.length == i5 + 9) {
                    this.ADU = i5;
                    this.ADW = 7;
                    int length = this.ADT.length - 2;
                    int i6 = (this.ADT[length + 1] & 255) | ((this.ADT[length] & 255) << 8);
                    if (i6 == 0) {
                        i6 = 65536;
                    }
                    this.ADV = i6;
                    AppMethodBeat.o(26642);
                } else {
                    IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("Invalid APDU: length=" + this.ADT.length + ", b1=" + i3 + ", b2||b3=" + i5);
                    AppMethodBeat.o(26642);
                    throw illegalArgumentException5;
                }
            }
        }
    }

    public final void TH(int i2) {
        this.ADV = i2;
        this.ADT[this.ADT.length - 1] = (byte) i2;
    }

    public final byte[] getBytes() {
        AppMethodBeat.i(26643);
        byte[] bArr = (byte[]) this.ADT.clone();
        AppMethodBeat.o(26643);
        return bArr;
    }

    public final String toString() {
        AppMethodBeat.i(26644);
        String byteArrayToHexString = com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(this.ADT);
        AppMethodBeat.o(26644);
        return byteArrayToHexString;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(26645);
        if (this == obj) {
            AppMethodBeat.o(26645);
            return true;
        } else if (!(obj instanceof a)) {
            AppMethodBeat.o(26645);
            return false;
        } else {
            boolean equals = Arrays.equals(this.ADT, ((a) obj).ADT);
            AppMethodBeat.o(26645);
            return equals;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(26646);
        int hashCode = Arrays.hashCode(this.ADT);
        AppMethodBeat.o(26646);
        return hashCode;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        AppMethodBeat.i(26647);
        this.ADT = (byte[]) objectInputStream.readUnshared();
        parse();
        AppMethodBeat.o(26647);
    }
}

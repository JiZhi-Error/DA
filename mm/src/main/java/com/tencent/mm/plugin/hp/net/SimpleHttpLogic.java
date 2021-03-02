package com.tencent.mm.plugin.hp.net;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;

@Keep
public class SimpleHttpLogic {

    @Keep
    public static class Request {
        public byte[] body;
        public String cgi;
        public String host;
    }

    @Keep
    public interface TaskCallback {
        void onCompleted(int i2, int i3, byte[] bArr);
    }

    public static native boolean pack(byte[] bArr, PByteArray pByteArray, byte[] bArr2, int i2, byte[] bArr3, String str, int i3, int i4, int i5, byte[] bArr4, byte[] bArr5, int i6, int i7, int i8);

    public static native void startRequest(Request request, TaskCallback taskCallback, String str);

    public static native boolean unpack(PByteArray pByteArray, byte[] bArr, byte[] bArr2, PByteArray pByteArray2, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4);

    public static boolean packRequest(byte[] bArr, PByteArray pByteArray) {
        AppMethodBeat.i(196783);
        boolean pack = pack(bArr, pByteArray, new byte[10], 0, new byte[10], "defaultid", 0, 3777, 1234567, new byte[10], new byte[10], 0, 6, 0);
        AppMethodBeat.o(196783);
        return pack;
    }

    public static boolean unpackResponse(byte[] bArr, PByteArray pByteArray) {
        AppMethodBeat.i(196784);
        PInt pInt = new PInt(-100);
        boolean unpack = unpack(pByteArray, bArr, new byte[10], new PByteArray(), pInt, new PInt(0), new PInt(0), new PInt(255));
        b.i("simple", "unpack ret is " + pInt.value + " unpack result " + unpack, new Object[0]);
        AppMethodBeat.o(196784);
        return unpack;
    }
}

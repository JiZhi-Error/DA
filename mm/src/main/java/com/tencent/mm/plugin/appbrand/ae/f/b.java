package com.tencent.mm.plugin.appbrand.ae.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public final class b {
    public static CodingErrorAction ojD = CodingErrorAction.REPORT;

    public static byte[] afS(String str) {
        AppMethodBeat.i(156672);
        try {
            byte[] bytes = str.getBytes("UTF8");
            AppMethodBeat.o(156672);
            return bytes;
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e2.toString());
            byte[] bArr = new byte[0];
            AppMethodBeat.o(156672);
            return bArr;
        }
    }

    public static byte[] afT(String str) {
        AppMethodBeat.i(156673);
        try {
            byte[] bytes = str.getBytes("ASCII");
            AppMethodBeat.o(156673);
            return bytes;
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e2.toString());
            byte[] bArr = new byte[0];
            AppMethodBeat.o(156673);
            return bArr;
        }
    }

    public static String K(byte[] bArr, int i2) {
        AppMethodBeat.i(156674);
        try {
            String str = new String(bArr, 0, i2, "ASCII");
            AppMethodBeat.o(156674);
            return str;
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e2.toString());
            AppMethodBeat.o(156674);
            return "";
        }
    }

    public static String B(ByteBuffer byteBuffer) {
        AppMethodBeat.i(156675);
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(ojD);
        newDecoder.onUnmappableCharacter(ojD);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            AppMethodBeat.o(156675);
            return charBuffer;
        } catch (CharacterCodingException e2) {
            com.tencent.mm.plugin.appbrand.ae.c.b bVar = new com.tencent.mm.plugin.appbrand.ae.c.b(1007, e2);
            AppMethodBeat.o(156675);
            throw bVar;
        }
    }
}

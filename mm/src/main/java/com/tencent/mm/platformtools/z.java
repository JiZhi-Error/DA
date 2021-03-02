package com.tencent.mm.platformtools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;

public final class z {
    public static SKBuiltinBuffer_t aC(byte[] bArr) {
        AppMethodBeat.i(132976);
        if (bArr == null) {
            AppMethodBeat.o(132976);
            return null;
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(bArr);
        AppMethodBeat.o(132976);
        return sKBuiltinBuffer_t;
    }

    public static byte[] a(SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.i(132977);
        if (sKBuiltinBuffer_t == null || sKBuiltinBuffer_t.getBuffer() == null) {
            AppMethodBeat.o(132977);
            return null;
        }
        byte[] byteArray = sKBuiltinBuffer_t.getBuffer().toByteArray();
        AppMethodBeat.o(132977);
        return byteArray;
    }

    public static byte[] a(SKBuiltinBuffer_t sKBuiltinBuffer_t, byte[] bArr) {
        AppMethodBeat.i(132978);
        if (sKBuiltinBuffer_t == null || sKBuiltinBuffer_t.getBuffer() == null) {
            AppMethodBeat.o(132978);
            return bArr;
        }
        byte[] byteArray = sKBuiltinBuffer_t.getBuffer().toByteArray();
        AppMethodBeat.o(132978);
        return byteArray;
    }

    public static String a(dqi dqi) {
        if (dqi == null) {
            return null;
        }
        return dqi.MTo;
    }

    public static String a(dqi dqi, String str) {
        if (dqi == null) {
            return str;
        }
        return dqi.MTo;
    }

    public static dqi Su(String str) {
        AppMethodBeat.i(132979);
        if (str == null) {
            AppMethodBeat.o(132979);
            return null;
        }
        dqi dqi = new dqi();
        dqi.bhy(str);
        AppMethodBeat.o(132979);
        return dqi;
    }

    public static String a(b bVar) {
        AppMethodBeat.i(132980);
        if (bVar == null) {
            AppMethodBeat.o(132980);
            return null;
        }
        String yO = bVar.yO();
        AppMethodBeat.o(132980);
        return yO;
    }

    public static String b(SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.i(132981);
        if (sKBuiltinBuffer_t == null || sKBuiltinBuffer_t.getBuffer() == null) {
            AppMethodBeat.o(132981);
            return null;
        }
        String yO = sKBuiltinBuffer_t.getBuffer().yO();
        AppMethodBeat.o(132981);
        return yO;
    }

    public static SKBuiltinBuffer_t Sv(String str) {
        AppMethodBeat.i(132982);
        if (str == null) {
            AppMethodBeat.o(132982);
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        if (decode == null) {
            AppMethodBeat.o(132982);
            return null;
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(decode);
        AppMethodBeat.o(132982);
        return sKBuiltinBuffer_t;
    }
}

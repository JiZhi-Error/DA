package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.c;
import java.util.UnknownFormatConversionException;

public class e {

    /* renamed from: a  reason: collision with root package name */
    static int f2040a = 5;

    /* renamed from: b  reason: collision with root package name */
    static int f2041b = 16;

    /* renamed from: c  reason: collision with root package name */
    static char[] f2042c = new char[16];

    /* renamed from: d  reason: collision with root package name */
    static String f2043d = "dex2oat-cmdline";

    /* renamed from: e  reason: collision with root package name */
    static long f2044e = 4096;

    public static String a(Context context, String str) {
        boolean z = true;
        AppMethodBeat.i(188415);
        c cVar = new c(str);
        cVar.a(f2042c);
        if (f2042c[f2040a] != 1) {
            z = false;
        }
        cVar.a(z);
        cVar.a(f2044e);
        String a2 = a(new String(a(cVar)));
        AppMethodBeat.o(188415);
        return a2;
    }

    private static String a(String str) {
        AppMethodBeat.i(188416);
        String[] split = str.split(new String("\u0000"));
        int i2 = 0;
        while (i2 < split.length) {
            int i3 = i2 + 1;
            String str2 = split[i2];
            i2 = i3 + 1;
            String str3 = split[i3];
            if (str2.equals(f2043d)) {
                AppMethodBeat.o(188416);
                return str3;
            }
        }
        AppMethodBeat.o(188416);
        return "";
    }

    public static char[] a(c cVar) {
        AppMethodBeat.i(188417);
        char[] cArr = new char[4];
        char[] cArr2 = new char[4];
        cVar.a(cArr);
        if (cArr[0] == 'o' && cArr[1] == 'a' && cArr[2] == 't') {
            cVar.a(cArr2);
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            if (cArr2[1] <= '4') {
                cVar.b();
                cVar.b();
                cVar.b();
            }
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            char[] cArr3 = new char[cVar.b()];
            cVar.a(cArr3);
            AppMethodBeat.o(188417);
            return cArr3;
        }
        UnknownFormatConversionException unknownFormatConversionException = new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", Character.valueOf(cArr[0]), Character.valueOf(cArr[1]), Character.valueOf(cArr[2])));
        AppMethodBeat.o(188417);
        throw unknownFormatConversionException;
    }
}

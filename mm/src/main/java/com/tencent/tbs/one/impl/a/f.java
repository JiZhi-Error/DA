package com.tencent.tbs.one.impl.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static b f2357a = new a((byte) 0);

    static class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.tbs.one.impl.a.f.b
        public final void a(int i2, String str) {
            AppMethodBeat.i(173920);
            Log.println(i2, "TBSOne", str);
            AppMethodBeat.o(173920);
        }
    }

    public interface b {
        void a(int i2, String str);
    }

    static {
        AppMethodBeat.i(173900);
        AppMethodBeat.o(173900);
    }

    private static String a(String str, Throwable th, Object... objArr) {
        AppMethodBeat.i(173896);
        String format = (objArr == null || ((th != null || objArr.length <= 0) && objArr.length <= 1)) ? str : String.format(Locale.US, str, objArr);
        if (th != null) {
            format = format + '\n' + Log.getStackTraceString(th);
        }
        AppMethodBeat.o(173896);
        return format;
    }

    private static Throwable a(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (!(obj instanceof Throwable)) {
            return null;
        }
        return (Throwable) obj;
    }

    public static void a(b bVar) {
        f2357a = bVar;
    }

    public static void a(String str, Object... objArr) {
        AppMethodBeat.i(173897);
        f2357a.a(4, a(str, a(objArr), objArr));
        AppMethodBeat.o(173897);
    }

    public static void b(String str, Object... objArr) {
        AppMethodBeat.i(173898);
        f2357a.a(5, a(str, a(objArr), objArr));
        AppMethodBeat.o(173898);
    }

    public static void c(String str, Object... objArr) {
        AppMethodBeat.i(173899);
        f2357a.a(6, a(str, a(objArr), objArr));
        AppMethodBeat.o(173899);
    }
}

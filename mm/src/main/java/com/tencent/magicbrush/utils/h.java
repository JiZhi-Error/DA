package com.tencent.magicbrush.utils;

import android.os.SystemClock;
import com.facebook.internal.NativeProtocol;
import com.github.henryye.nativeiv.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007J-\u0010\t\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0007J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J*\u0010\u001c\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001d0\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00110 J2\u0010\u001c\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001d0\u001e2\u0006\u0010!\u001a\u00020\u00012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00110 R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/magicbrush/utils/Util;", "", "()V", "TAG", "", "currentTicks", "", "findLibPath", "libName", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "isNullOrNil", "", "str", "loadLibrary", "", "loader", "Ljava/lang/ClassLoader;", "nullAsNil", "qualityClose", "c", "Ljava/io/Closeable;", "quietlyClose", "closeable", "ticksToNow", "tick", "forEachCopyOnWrite", "T", "", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "lock", "lib-magicbrush-nano_release"})
public final class h {
    public static final h cPz = new h();

    static {
        AppMethodBeat.i(140303);
        AppMethodBeat.o(140303);
    }

    private h() {
    }

    public static final boolean isNullOrNil(String str) {
        AppMethodBeat.i(140299);
        if (str == null || p.j("", str)) {
            AppMethodBeat.o(140299);
            return true;
        }
        AppMethodBeat.o(140299);
        return false;
    }

    public static final long currentTicks() {
        AppMethodBeat.i(140300);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.o(140300);
        return elapsedRealtime;
    }

    public static final long ticksToNow(long j2) {
        AppMethodBeat.i(140301);
        long elapsedRealtime = SystemClock.elapsedRealtime() - j2;
        AppMethodBeat.o(140301);
        return elapsedRealtime;
    }

    public static final void ef(String str) {
        AppMethodBeat.i(140302);
        p.h(str, "libName");
        b.d("MagicBrush.Util", "System.loadLibrary " + str + ' ' + ((Object) null), new Object[0]);
        System.loadLibrary(str);
        AppMethodBeat.o(140302);
    }

    public static final String findLibPath(String str) {
        AppMethodBeat.i(206889);
        p.h(str, "libName");
        b.d("MagicBrush.Util", "hy: try find lib path " + str + " with dummy imp", new Object[0]);
        AppMethodBeat.o(206889);
        return "";
    }
}

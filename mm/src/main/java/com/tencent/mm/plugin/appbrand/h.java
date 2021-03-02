package com.tencent.mm.plugin.appbrand;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class h {
    private static final Iterator<c> kzD = new Iterator<c>() {
        /* class com.tencent.mm.plugin.appbrand.h.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ c next() {
            return null;
        }

        public final boolean hasNext() {
            return false;
        }
    };
    private static final Map<String, b> kzE = new HashMap();
    private static final Map<String, d> kzF = new HashMap();
    private static final com.tencent.mm.plugin.appbrand.ac.h<String, c> kzG = new com.tencent.mm.plugin.appbrand.ac.h<>();
    private static final com.tencent.mm.plugin.appbrand.ac.h<String, a> kzH = new com.tencent.mm.plugin.appbrand.ac.h<>();

    public interface a {
        boolean onNewIntent(Intent intent);
    }

    public enum d {
        CLOSE,
        BACK,
        HIDE,
        HANG,
        HOME_PRESSED,
        RECENT_APPS_PRESSED,
        LAUNCH_NATIVE_PAGE,
        LAUNCH_MINI_PROGRAM;

        public static d valueOf(String str) {
            AppMethodBeat.i(140565);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(140565);
            return dVar;
        }

        static {
            AppMethodBeat.i(140566);
            AppMethodBeat.o(140566);
        }
    }

    public enum b {
        INIT,
        ON_CREATE,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY;

        public static b valueOf(String str) {
            AppMethodBeat.i(140562);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(140562);
            return bVar;
        }

        static {
            AppMethodBeat.i(140563);
            AppMethodBeat.o(140563);
        }
    }

    public static abstract class c {
        public void onCreate() {
        }

        public void onDestroy() {
        }

        public void a(d dVar) {
        }

        public void onResume() {
        }

        public void bra() {
        }
    }

    static {
        AppMethodBeat.i(140582);
        AppMethodBeat.o(140582);
    }

    public static void a(String str, c cVar) {
        AppMethodBeat.i(140567);
        if (TextUtils.isEmpty(str) || cVar == null) {
            AppMethodBeat.o(140567);
            return;
        }
        kzG.r(str, cVar);
        AppMethodBeat.o(140567);
    }

    private static Iterator<c> TT(String str) {
        AppMethodBeat.i(140568);
        Set<c> cM = kzG.cM(str);
        if (cM != null) {
            Iterator<c> it = cM.iterator();
            AppMethodBeat.o(140568);
            return it;
        }
        Iterator<c> it2 = kzD;
        AppMethodBeat.o(140568);
        return it2;
    }

    public static void TU(String str) {
        AppMethodBeat.i(140569);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(140569);
            return;
        }
        Iterator<c> TT = TT(str);
        while (TT.hasNext()) {
            TT.next().onCreate();
        }
        AppMethodBeat.o(140569);
    }

    public static void TV(String str) {
        AppMethodBeat.i(140570);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(140570);
            return;
        }
        Iterator<c> TT = TT(str);
        while (TT.hasNext()) {
            TT.next().onDestroy();
        }
        AppMethodBeat.o(140570);
    }

    public static void TW(String str) {
        AppMethodBeat.i(221212);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(221212);
            return;
        }
        Iterator<c> TT = TT(str);
        while (TT.hasNext()) {
            TT.next().bra();
        }
        AppMethodBeat.o(221212);
    }

    public static void TX(String str) {
        AppMethodBeat.i(140571);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(140571);
            return;
        }
        Iterator<c> TT = TT(str);
        while (TT.hasNext()) {
            TT.next().a(Uc(str));
        }
        AppMethodBeat.o(140571);
    }

    public static void TY(String str) {
        AppMethodBeat.i(140572);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(140572);
            return;
        }
        Iterator<c> TT = TT(str);
        while (TT.hasNext()) {
            TT.next().onResume();
        }
        AppMethodBeat.o(140572);
    }

    public static void TZ(String str) {
        AppMethodBeat.i(140573);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(140573);
            return;
        }
        Iterator<c> TT = TT(str);
        while (TT.hasNext()) {
            TT.next();
        }
        AppMethodBeat.o(140573);
    }

    public static void b(String str, c cVar) {
        AppMethodBeat.i(140574);
        if (cVar == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(140574);
            return;
        }
        kzG.J(str, cVar);
        AppMethodBeat.o(140574);
    }

    public static void a(String str, a aVar) {
        AppMethodBeat.i(182832);
        kzH.r(str, aVar);
        AppMethodBeat.o(182832);
    }

    public static void b(String str, a aVar) {
        AppMethodBeat.i(182833);
        kzH.J(str, aVar);
        AppMethodBeat.o(182833);
    }

    public static boolean b(String str, Intent intent) {
        AppMethodBeat.i(182834);
        Set<a> cM = kzH.cM(str);
        if (cM != null) {
            for (a aVar : cM) {
                if (aVar.onNewIntent(intent)) {
                    AppMethodBeat.o(182834);
                    return true;
                }
            }
        }
        AppMethodBeat.o(182834);
        return false;
    }

    public static void Ua(String str) {
        AppMethodBeat.i(140576);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(140576);
            return;
        }
        kzG.cN(str);
        kzH.cN(str);
        AppMethodBeat.o(140576);
    }

    public static void Ub(String str) {
        AppMethodBeat.i(140577);
        a(str, d.HIDE);
        AppMethodBeat.o(140577);
    }

    public static d Uc(String str) {
        AppMethodBeat.i(140578);
        d dVar = kzF.get(str);
        if (dVar == null) {
            d dVar2 = d.HIDE;
            AppMethodBeat.o(140578);
            return dVar2;
        }
        AppMethodBeat.o(140578);
        return dVar;
    }

    public static void a(String str, d dVar) {
        AppMethodBeat.i(140579);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(140579);
            return;
        }
        kzF.put(str, dVar);
        AppMethodBeat.o(140579);
    }

    public static void a(String str, b bVar) {
        AppMethodBeat.i(140580);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(140580);
            return;
        }
        kzE.put(str, bVar);
        AppMethodBeat.o(140580);
    }

    public static b Ud(String str) {
        AppMethodBeat.i(140581);
        b bVar = kzE.get(str);
        if (bVar == null) {
            bVar = b.INIT;
        }
        AppMethodBeat.o(140581);
        return bVar;
    }
}

package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nJ\u001e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ3\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042#\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\rJ\u001e\u0010 \u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u001e\u0010!\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u001e\u0010\"\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u001e\u0010#\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0006\u0010$\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R6\u0010\u0007\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bj\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`\u000bX\u0004¢\u0006\u0002\n\u0000R`\u0010\f\u001aT\u0012\u0004\u0012\u00020\u0004\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\r0\bj)\u0012\u0004\u0012\u00020\u0004\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\r`\u000bX\u0004¢\u0006\u0002\n\u0000R6\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bj\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`\u000bX\u0004¢\u0006\u0002\n\u0000R6\u0010\u0013\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bj\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`\u000bX\u0004¢\u0006\u0002\n\u0000R6\u0010\u0014\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bj\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`\u000bX\u0004¢\u0006\u0002\n\u0000R6\u0010\u0015\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bj\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveSysMsgCallback;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "aceptLinkMicCallbacks", "Ljava/util/HashMap;", "Lkotlin/Function0;", "", "Lkotlin/collections/HashMap;", "anchorConnectionChangeCallbacks", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "available", "applyLinkMicCallbacks", "closeLinkMicCallbacks", "closeLiveCallbacks", "kickedCallbacks", "notifyAccepLinkMic", "notifyAnchorConnectionChange", "notifyApplyLinkMic", "notifyClodeLive", "notifyCloseLinkMic", "notifyKicked", "registerAcceptLinkMicCallback", "key", "callback", "registerAnchorConnectionChangeCallback", "registerApplyLinkMicCallback", "registerCloseLinkMicCallback", "registerCloseLiveCallback", "registerKickedCallback", "releaseCallback", "plugin-finder_release"})
public final class q {
    private static final String TAG = TAG;
    private static final HashMap<String, a<x>> ujX = new HashMap<>();
    private static final HashMap<String, a<x>> ujY = new HashMap<>();
    private static final HashMap<String, a<x>> ujZ = new HashMap<>();
    private static final HashMap<String, a<x>> uka = new HashMap<>();
    private static final HashMap<String, a<x>> ukb = new HashMap<>();
    private static final HashMap<String, b<Boolean, x>> ukc = new HashMap<>();
    public static final q ukd = new q();

    static {
        AppMethodBeat.i(246271);
        AppMethodBeat.o(246271);
    }

    private q() {
    }

    public static void j(String str, a<x> aVar) {
        AppMethodBeat.i(246261);
        p.h(str, "key");
        Log.i(TAG, "register close live callback");
        if (uka.get(str) == null) {
            uka.put(str, aVar);
        }
        AppMethodBeat.o(246261);
    }

    public static void k(String str, a<x> aVar) {
        AppMethodBeat.i(246262);
        p.h(str, "key");
        Log.i(TAG, "register kicked callback");
        if (ukb.get(str) == null) {
            ukb.put(str, aVar);
        }
        AppMethodBeat.o(246262);
    }

    public static void k(String str, b<? super Boolean, x> bVar) {
        AppMethodBeat.i(246263);
        p.h(str, "key");
        Log.i(TAG, "register anchor connection change callback");
        if (ukc.get(str) == null) {
            ukc.put(str, bVar);
        }
        AppMethodBeat.o(246263);
    }

    public static void dgx() {
        AppMethodBeat.i(246264);
        Log.i(TAG, "notify apply link mic");
        for (Map.Entry<String, a<x>> entry : ujX.entrySet()) {
            entry.getValue().invoke();
        }
        AppMethodBeat.o(246264);
    }

    public static void dgy() {
        AppMethodBeat.i(246265);
        Log.i(TAG, "notify accept link mic");
        for (Map.Entry<String, a<x>> entry : ujY.entrySet()) {
            entry.getValue().invoke();
        }
        AppMethodBeat.o(246265);
    }

    public static void dgz() {
        AppMethodBeat.i(246266);
        Log.i(TAG, "notify close link mic");
        for (Map.Entry<String, a<x>> entry : ujZ.entrySet()) {
            entry.getValue().invoke();
        }
        AppMethodBeat.o(246266);
    }

    public static void dgA() {
        AppMethodBeat.i(246267);
        Log.i(TAG, "notify close live");
        for (Map.Entry<String, a<x>> entry : uka.entrySet()) {
            entry.getValue().invoke();
        }
        AppMethodBeat.o(246267);
    }

    public static void dgB() {
        AppMethodBeat.i(246268);
        Log.i(TAG, "notify kicked");
        for (Map.Entry<String, a<x>> entry : ukb.entrySet()) {
            entry.getValue().invoke();
        }
        AppMethodBeat.o(246268);
    }

    public static void no(boolean z) {
        AppMethodBeat.i(246269);
        Log.i(TAG, "notify anchor connection change");
        for (Map.Entry<String, b<Boolean, x>> entry : ukc.entrySet()) {
            entry.getValue().invoke(Boolean.valueOf(z));
        }
        AppMethodBeat.o(246269);
    }

    public static void dgC() {
        AppMethodBeat.i(246270);
        Log.i(TAG, "release callback");
        ujX.clear();
        ujY.clear();
        ujZ.clear();
        uka.clear();
        ukb.clear();
        ukc.clear();
        AppMethodBeat.o(246270);
    }
}

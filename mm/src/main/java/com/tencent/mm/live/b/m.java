package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\nJ\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\nJ1\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00052!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006J\u001c\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\rJF\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000526\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0011J\u001c\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\rJ\u001c\u0010 \u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\rJ\u0006\u0010!\u001a\u00020\nR`\u0010\u0003\u001aT\u0012\u0004\u0012\u00020\u0005\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00060\u0004j)\u0012\u0004\u0012\u00020\u0005\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006`\u000bX\u0004¢\u0006\u0002\n\u0000R6\u0010\f\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r`\u000bX\u0004¢\u0006\u0002\n\u0000R6\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r`\u000bX\u0004¢\u0006\u0002\n\u0000R6\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r`\u000bX\u0004¢\u0006\u0002\n\u0000R\u0001\u0010\u0010\u001a~\u0012\u0004\u0012\u00020\u0005\u00124\u00122\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u00110\u0004j>\u0012\u0004\u0012\u00020\u0005\u00124\u00122\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0011`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/live/model/LiveCallbacks;", "", "()V", "liveBanCommentCallbacks", "Ljava/util/HashMap;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sysTip", "", "Lkotlin/collections/HashMap;", "liveKickedCallbacks", "Lkotlin/Function0;", "liveMessageCallbacks", "liveOnlineCntChangeCallbacks", "livelinkMicCallbacks", "Lkotlin/Function2;", "", "linked", "callingUser", "callbackBanComment", "callbackKicked", "callbackLinkMic", "callbackLiveMessage", "callbackOnlineCntChanged", "registerLiveBanCommentCallback", "key", "callback", "registerLiveKickedCallback", "registerLiveLinkMicCallback", "registerLiveMessageCallback", "registerOnlineCntChangedCallback", "releaseCallbacks", "plugin-logic_release"})
public final class m {
    private static final HashMap<String, a<x>> hGb = new HashMap<>();
    private static final HashMap<String, a<x>> hGc = new HashMap<>();
    private static final HashMap<String, b<String, x>> hGd = new HashMap<>();
    private static final HashMap<String, kotlin.g.a.m<Boolean, String, x>> hGe = new HashMap<>();
    private static final HashMap<String, a<x>> hGf = new HashMap<>();
    public static final m hGg = new m();

    static {
        AppMethodBeat.i(207591);
        AppMethodBeat.o(207591);
    }

    private m() {
    }

    public static void aFe() {
        AppMethodBeat.i(207580);
        for (Map.Entry<String, a<x>> entry : hGc.entrySet()) {
            entry.getValue().invoke();
        }
        AppMethodBeat.o(207580);
    }

    public static void GL(String str) {
        AppMethodBeat.i(207581);
        p.h(str, "sysTip");
        for (Map.Entry<String, b<String, x>> entry : hGd.entrySet()) {
            entry.getValue().invoke(str);
        }
        AppMethodBeat.o(207581);
    }

    public static void h(boolean z, String str) {
        AppMethodBeat.i(207582);
        p.h(str, "callingUser");
        for (Map.Entry<String, kotlin.g.a.m<Boolean, String, x>> entry : hGe.entrySet()) {
            entry.getValue().invoke(Boolean.valueOf(z), str);
        }
        AppMethodBeat.o(207582);
    }

    public static void aFf() {
        AppMethodBeat.i(207583);
        for (Map.Entry<String, a<x>> entry : hGb.entrySet()) {
            entry.getValue().invoke();
        }
        AppMethodBeat.o(207583);
    }

    public static void aFg() {
        AppMethodBeat.i(207584);
        for (Map.Entry<String, a<x>> entry : hGf.entrySet()) {
            entry.getValue().invoke();
        }
        AppMethodBeat.o(207584);
    }

    public static void d(String str, a<x> aVar) {
        AppMethodBeat.i(207585);
        p.h(str, "key");
        p.h(aVar, "callback");
        hGc.put(str, aVar);
        AppMethodBeat.o(207585);
    }

    public static void a(String str, b<? super String, x> bVar) {
        AppMethodBeat.i(207586);
        p.h(str, "key");
        p.h(bVar, "callback");
        hGd.put(str, bVar);
        AppMethodBeat.o(207586);
    }

    public static void a(String str, kotlin.g.a.m<? super Boolean, ? super String, x> mVar) {
        AppMethodBeat.i(207587);
        p.h(str, "key");
        p.h(mVar, "callback");
        hGe.put(str, mVar);
        AppMethodBeat.o(207587);
    }

    public static void e(String str, a<x> aVar) {
        AppMethodBeat.i(207588);
        p.h(str, "key");
        p.h(aVar, "callback");
        hGb.put(str, aVar);
        AppMethodBeat.o(207588);
    }

    public static void f(String str, a<x> aVar) {
        AppMethodBeat.i(207589);
        p.h(str, "key");
        p.h(aVar, "callback");
        hGf.put(str, aVar);
        AppMethodBeat.o(207589);
    }

    public static void aFh() {
        AppMethodBeat.i(207590);
        hGc.clear();
        hGd.clear();
        hGe.clear();
        hGb.clear();
        hGf.clear();
        AppMethodBeat.o(207590);
    }
}

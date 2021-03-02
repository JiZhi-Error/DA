package com.tencent.tbs.one.impl.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneEventEmitter;
import com.tencent.tbs.one.TBSOneEventReceiver;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.c.a;
import com.tencent.tbs.one.impl.common.g;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public final class b implements TBSOneEventEmitter {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<h> f2678a;

    public b(h hVar) {
        AppMethodBeat.i(174141);
        this.f2678a = new WeakReference<>(hVar);
        AppMethodBeat.o(174141);
    }

    static /* synthetic */ void a(TBSOneComponent tBSOneComponent, String str, String str2, Map map) {
        AppMethodBeat.i(174145);
        b(tBSOneComponent, str, str2, map);
        AppMethodBeat.o(174145);
    }

    private static void a(String str, String str2) {
        AppMethodBeat.i(174139);
        f.b("Failed to emit event %s, reason: %s", str, str2);
        AppMethodBeat.o(174139);
    }

    private static void a(String str, String str2, String str3, String str4, Throwable th) {
        AppMethodBeat.i(174140);
        f.b("Failed to emit event %s to %s#%s, reason: %s", str3, str, str2, str4, th);
        AppMethodBeat.o(174140);
    }

    private static void b(TBSOneComponent tBSOneComponent, String str, String str2, Map<String, Object> map) {
        AppMethodBeat.i(174144);
        if (tBSOneComponent.getEntryClassLoader() == null) {
            a(tBSOneComponent.getName(), str, str2, "no entry class loader found", null);
        }
        try {
            Class<?> loadClass = tBSOneComponent.getEntryClassLoader().loadClass(str);
            if (TBSOneEventReceiver.class.isAssignableFrom(loadClass)) {
                ((TBSOneEventReceiver) loadClass.getConstructor(new Class[0]).newInstance(new Object[0])).onReceive(str2, map);
                AppMethodBeat.o(174144);
                return;
            }
            a(tBSOneComponent.getName(), str, str2, "can't assign receiver class to com.tencent.tbs.one.TBSOneEventReceiver", null);
            AppMethodBeat.o(174144);
        } catch (ClassNotFoundException e2) {
            a(tBSOneComponent.getName(), str, str2, "can't load event receiver class", e2);
            AppMethodBeat.o(174144);
        } catch (NoSuchMethodException e3) {
            a(tBSOneComponent.getName(), str, str2, "can't find constructor method for event receiver class", e3);
            AppMethodBeat.o(174144);
        } catch (Exception e4) {
            a(tBSOneComponent.getName(), str, str2, "can't construct event receiver object", e4);
            AppMethodBeat.o(174144);
        }
    }

    @Override // com.tencent.tbs.one.TBSOneEventEmitter
    public final void emit(TBSOneEventEmitter.UnloadedBehavior unloadedBehavior, final String str, final String str2, final String str3, final Map<String, Object> map) {
        AppMethodBeat.i(174142);
        final h hVar = this.f2678a.get();
        if (hVar == null) {
            a(str, str2, str3, "TBSOneManager is not alive", null);
            AppMethodBeat.o(174142);
            return;
        }
        a e2 = hVar.e(str);
        if (e2 != null) {
            b(e2, str2, str3, map);
            AppMethodBeat.o(174142);
        } else if (unloadedBehavior == TBSOneEventEmitter.UnloadedBehavior.IGNORE) {
            a(str, str2, str3, "component is not loaded yet", null);
            AppMethodBeat.o(174142);
        } else if (unloadedBehavior != TBSOneEventEmitter.UnloadedBehavior.LOAD || !hVar.b(str)) {
            m.a(new Runnable() {
                /* class com.tencent.tbs.one.impl.e.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(173959);
                    hVar.a(str, (Bundle) null, new TBSOneCallback<TBSOneComponent>() {
                        /* class com.tencent.tbs.one.impl.e.b.AnonymousClass1.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.tbs.one.TBSOneCallback
                        public final /* synthetic */ void onCompleted(TBSOneComponent tBSOneComponent) {
                            AppMethodBeat.i(174103);
                            a e2 = hVar.e(str);
                            if (e2 != null) {
                                b.a(e2, str2, str3, map);
                            }
                            AppMethodBeat.o(174103);
                        }
                    });
                    AppMethodBeat.o(173959);
                }
            });
            AppMethodBeat.o(174142);
        } else {
            a(str, str2, str3, "component is not installed yet", null);
            AppMethodBeat.o(174142);
        }
    }

    @Override // com.tencent.tbs.one.TBSOneEventEmitter
    public final void emit(String str, Map<String, Object> map) {
        AppMethodBeat.i(174143);
        h hVar = this.f2678a.get();
        if (hVar == null) {
            a(str, "TBSOneManager is not alive");
            AppMethodBeat.o(174143);
            return;
        }
        List<g> list = hVar.k.get(str);
        if (list == null) {
            a(str, "no event receiver found");
            AppMethodBeat.o(174143);
            return;
        }
        ListIterator<g> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            g next = listIterator.next();
            b(hVar.e(next.f2576a), next.f2577b, str, map);
        }
        AppMethodBeat.o(174143);
    }
}

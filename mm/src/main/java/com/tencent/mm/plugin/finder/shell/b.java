package com.tencent.mm.plugin.finder.shell;

import android.content.Intent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.HashMap;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nJ\u0006\u0010\u0013\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R5\u0010\b\u001a)\u0012\u0004\u0012\u00020\u0004\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/shell/FinderShellInit;", "", "()V", "TAG", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "com/tencent/mm/plugin/finder/shell/FinderShellInit$listener$1", "Lcom/tencent/mm/plugin/finder/shell/FinderShellInit$listener$1;", "shells", "Ljava/util/HashMap;", "Lkotlin/Function1;", "Landroid/content/Intent;", "Lkotlin/ParameterName;", "name", "intent", "", "createShell", "cmd", "shell", "setup", "plugin-finder_release"})
public final class b {
    private static final HashMap<String, kotlin.g.a.b<Intent, x>> vwh = new HashMap<>();
    private static final a vwi = new a();
    public static final b vwj = new b();

    static {
        AppMethodBeat.i(251496);
        AppMethodBeat.o(251496);
    }

    private b() {
    }

    public static void m(String str, kotlin.g.a.b<? super Intent, x> bVar) {
        AppMethodBeat.i(251494);
        p.h(str, "cmd");
        p.h(bVar, "shell");
        Locale locale = Locale.getDefault();
        p.g(locale, "Locale.getDefault()");
        String lowerCase = str.toLowerCase(locale);
        p.g(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        vwh.put(lowerCase, bVar);
        AppMethodBeat.o(251494);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0017¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/shell/FinderShellInit$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ShellExecEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class a extends IListener<uq> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(uq uqVar) {
            AppMethodBeat.i(251493);
            uq uqVar2 = uqVar;
            p.h(uqVar2, "event");
            if (WeChatEnvironment.hasDebugger() && p.j(uqVar2.eaT.action, "wechat.shell.FINDER_SHELL")) {
                String stringExtra = uqVar2.eaT.intent.getStringExtra("cmd");
                Log.i("Finder.Shell", "get cmd ".concat(String.valueOf(stringExtra)));
                b bVar = b.vwj;
                HashMap hashMap = b.vwh;
                p.g(stringExtra, "cmd");
                Locale locale = Locale.getDefault();
                p.g(locale, "Locale.getDefault()");
                if (stringExtra == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(251493);
                    throw tVar;
                }
                String lowerCase = stringExtra.toLowerCase(locale);
                p.g(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                kotlin.g.a.b bVar2 = (kotlin.g.a.b) hashMap.get(lowerCase);
                if (bVar2 != null) {
                    Intent intent = uqVar2.eaT.intent;
                    p.g(intent, "event.data.intent");
                    bVar2.invoke(intent);
                }
            }
            AppMethodBeat.o(251493);
            return true;
        }
    }

    public static void setup() {
        AppMethodBeat.i(251495);
        if (WeChatEnvironment.hasDebugger()) {
            vwi.alive();
            new a();
        }
        AppMethodBeat.o(251495);
    }
}

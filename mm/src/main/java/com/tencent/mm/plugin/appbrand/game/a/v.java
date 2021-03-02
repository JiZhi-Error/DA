package com.tencent.mm.plugin.appbrand.game.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.j;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.aa;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b&\u0018\u0000 )*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0014J\r\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J\r\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0012J\r\u0010\u0014\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0012J\u000f\u0010\u0015\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0016\u001a\u0004\u0018\u00018\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH$¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u000bJ\b\u0010&\u001a\u00020\u0007H\u0004J\u0015\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010(R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "", "()V", "mConfigMemory", "Ljava/lang/Object;", "askRestart", "", "context", "Landroid/content/Context;", "message", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "", "enableKv", "getConfig", "()Ljava/lang/Object;", "getConfigDefaultValue", "getConfigImpl", "getConfigLocalStorage", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Object;", "onProcessConfigBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "onProcessConfigFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "onProcessConfigInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "onProcessConfigLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "processCommand", "value", "removeConfigLocalStorage", "setConfigLocalStorage", "(Ljava/lang/Object;)V", "Companion", "plugin-appbrand-integration_release"})
public abstract class v<T> {
    private static final f lrX = g.ah(b.lrZ);
    public static final a lrY = new a((byte) 0);
    private T lrW;

    public static final void a(Context context, String[] strArr) {
        a.a(context, strArr);
    }

    /* access modifiers changed from: protected */
    public abstract T YH(String str);

    public abstract T bDb();

    /* access modifiers changed from: protected */
    public b.a bCZ() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String bCY() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean bDa() {
        return true;
    }

    public T aLT() {
        String a2;
        T t = this.lrW;
        if (t == null) {
            if (bCY() != null) {
                String decodeString = MultiProcessMMKV.getMMKV("WAGameDynamicConfig").decodeString("WAGameDynamicConfig" + bCY(), null);
                if (decodeString == null) {
                    t = null;
                } else {
                    t = YH(decodeString);
                }
                if (t != null) {
                    Log.i("WAGameDynamicConfig", "hit localstorage");
                    this.lrW = t;
                }
            }
            if (bCZ() == null || (a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(bCZ(), "")) == null || (t = YH(a2)) == null) {
                t = bDb();
            } else {
                Log.i("WAGameDynamicConfig", "hit ABTest");
            }
            this.lrW = t;
        }
        return t;
    }

    public final void ab(Context context, String str) {
        boolean z = true;
        p.h(context, "context");
        boolean z2 = bCY() != null;
        if (!aa.SXc || z2) {
            T YH = YH(str);
            if (YH == null) {
                boolean z3 = bCY() != null;
                if (!aa.SXc || z3) {
                    MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("WAGameDynamicConfig");
                    mmkv.remove("WAGameDynamicConfig" + bCY());
                    mmkv.commit();
                    if (mmkv.containsKey("WAGameDynamicConfig" + bCY())) {
                        z = false;
                    }
                    if (!aa.SXc || z) {
                        Log.i("WAGameDynamicConfig", "dl: remove localstorage config");
                        if (bDa()) {
                            ac(context, "config[" + bCY() + "] removed");
                            return;
                        }
                        return;
                    }
                    throw new AssertionError("Assertion failed");
                }
                throw new AssertionError("Assertion failed");
            }
            if (bCY() == null) {
                z = false;
            }
            if (!aa.SXc || z) {
                MultiProcessMMKV mmkv2 = MultiProcessMMKV.getMMKV("WAGameDynamicConfig");
                mmkv2.encode("WAGameDynamicConfig" + bCY(), String.valueOf(YH));
                mmkv2.commit();
                Log.i("WAGameDynamicConfig", "dl: set localstorage config ".concat(String.valueOf(str)));
                if (bDa()) {
                    ac(context, "config[" + bCY() + "] set to " + ((Object) YH));
                    return;
                }
                return;
            }
            throw new AssertionError("Assertion failed");
        }
        throw new AssertionError("Assertion failed");
    }

    private static void ac(Context context, String str) {
        new AlertDialog.Builder(context).setTitle("").setMessage(str).setNegativeButton("cancel", (DialogInterface.OnClickListener) null).setPositiveButton("restart", c.lsa).show();
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "T", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class c implements DialogInterface.OnClickListener {
        public static final c lsa = new c();

        static {
            AppMethodBeat.i(50394);
            AppMethodBeat.o(50394);
        }

        c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(50393);
            com.tencent.mm.plugin.appbrand.game.h.a aVar = com.tencent.mm.plugin.appbrand.game.h.a.lvA;
            com.tencent.mm.plugin.appbrand.game.h.a.bDC();
            com.tencent.mm.plugin.appbrand.game.h.a.suicide();
            AppMethodBeat.o(50393);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0002J%\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0013H\u0007¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R%\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig$Companion;", "", "()V", "TAG", "", "mCommandProcessor", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "getMCommandProcessor", "()Ljava/util/List;", "mCommandProcessor$delegate", "Lkotlin/Lazy;", "checkNotDuplicate", "", "registry", "processCommand", "context", "Landroid/content/Context;", "args", "", "(Landroid/content/Context;[Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, String[] strArr) {
            T t;
            AppMethodBeat.i(50391);
            p.h(context, "context");
            p.h(strArr, "args");
            boolean z = strArr.length >= 3;
            if (!aa.SXc || z) {
                boolean z2 = (strArr[1] == null || strArr[0] == null) ? false : true;
                if (!aa.SXc || z2) {
                    boolean I = n.I("//wagame", strArr[0], true);
                    if (!aa.SXc || I) {
                        f fVar = v.lrX;
                        a aVar = v.lrY;
                        Iterator<T> it = ((List) fVar.getValue()).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t = null;
                                break;
                            }
                            T next = it.next();
                            if (n.I(strArr[1], next.bCY(), false)) {
                                t = next;
                                break;
                            }
                        }
                        T t2 = t;
                        if (t2 == null) {
                            Toast.makeText(MMApplicationContext.getContext(), "Unknown config name " + strArr[1], 0).show();
                            AppMethodBeat.o(50391);
                            return;
                        }
                        t2.ab(context, strArr[2]);
                        AppMethodBeat.o(50391);
                        return;
                    }
                    AssertionError assertionError = new AssertionError("Assertion failed");
                    AppMethodBeat.o(50391);
                    throw assertionError;
                }
                AssertionError assertionError2 = new AssertionError("Assertion failed");
                AppMethodBeat.o(50391);
                throw assertionError2;
            }
            AssertionError assertionError3 = new AssertionError("Assertion failed");
            AppMethodBeat.o(50391);
            throw assertionError3;
        }

        public static final /* synthetic */ void bt(List list) {
            AppMethodBeat.i(50392);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String bCY = it.next().bCY();
                if (bCY != null) {
                    boolean z = !linkedHashSet.contains(bCY);
                    if (!aa.SXc || z) {
                        linkedHashSet.add(bCY);
                    } else {
                        AssertionError assertionError = new AssertionError("Assertion failed");
                        AppMethodBeat.o(50392);
                        throw assertionError;
                    }
                }
            }
            AppMethodBeat.o(50392);
        }
    }

    protected static Boolean YJ(String str) {
        if (str == null) {
            return null;
        }
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.contentEquals(str)) {
            return Boolean.TRUE;
        }
        if ("false".contentEquals(str)) {
            return Boolean.FALSE;
        }
        Integer buA = n.buA(str);
        if (buA == null) {
            return null;
        }
        if (buA.intValue() > 0) {
            return Boolean.TRUE;
        }
        if (buA.intValue() == 0 || buA.intValue() == -1) {
            return Boolean.FALSE;
        }
        throw new IllegalStateException("Ambiguity name");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "invoke"})
    static final class b extends q implements kotlin.g.a.a<List<v<?>>> {
        public static final b lrZ = new b();

        static {
            AppMethodBeat.i(50389);
            AppMethodBeat.o(50389);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<v<?>> invoke() {
            AppMethodBeat.i(50388);
            List mutableListOf = j.mutableListOf(g.lrD, e.lry, b.lrq, c.lrr, r.lrS, s.lrT, m.lrN, i.lrF, o.lrP, t.lrU, k.lrL, l.lrM, d.lrs, n.lrO);
            mutableListOf.add(h.lrE);
            j.a aVar = j.lrK;
            Collection values = j.bDd().values();
            p.g(values, "registry.values");
            mutableListOf.addAll(values);
            a aVar2 = v.lrY;
            a.bt(mutableListOf);
            AppMethodBeat.o(50388);
            return mutableListOf;
        }
    }
}

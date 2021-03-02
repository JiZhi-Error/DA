package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.util.Pair;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0006\u0010 \u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0018J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback;", "", "()V", "CLASS_NAME", "", "METHOD_DESC_doAttach", "METHOD_DESC_doPause", "METHOD_DESC_doResume", "METHOD_DESC_onEnterBegin", "METHOD_DESC_onExitBegin", "METHOD_DESC_onExitEnd", "METHOD_NAME_doAttach", "METHOD_NAME_doPause", "METHOD_NAME_doResume", "METHOD_NAME_onEnterBegin", "METHOD_NAME_onExitBegin", "METHOD_NAME_onExitEnd", "mChatFragmentListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1;", "mDoAttach", "", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/IChatFragmentListener;", "mOnEnter", "mOnExit", "callbackOnEnter", "", "callbackOnExit", "callbackOnPause", "callbackOnResume", "monitor", "registerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterListener", "plugin-expt_release"})
public final class a {
    private static List<i> mListeners = new ArrayList();
    private static boolean szR;
    private static boolean szS;
    private static boolean szT;
    private static final C1026a szU = new C1026a();
    public static final a szV = new a();

    static {
        AppMethodBeat.i(220745);
        AppMethodBeat.o(220745);
    }

    private a() {
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(220746);
        aVar.cOa();
        AppMethodBeat.o(220746);
    }

    public static final /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(220747);
        aVar.cOc();
        AppMethodBeat.o(220747);
    }

    public static final /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(220748);
        aVar.cOb();
        AppMethodBeat.o(220748);
    }

    public static final /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(220749);
        aVar.cOd();
        AppMethodBeat.o(220749);
    }

    public static void cMH() {
        AppMethodBeat.i(220739);
        szR = false;
        szS = false;
        szT = false;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("doAttach", "(Landroid/content/Context;)V"));
        arrayList.add(new Pair("onEnterBegin", "()V"));
        arrayList.add(new Pair("onExitBegin", "()V"));
        arrayList.add(new Pair("doResume", "()V"));
        arrayList.add(new Pair("doPause", "()V"));
        arrayList.add(new Pair("onExitEnd", "()V"));
        linkedHashMap.put("com/tencent/mm/ui/chatting/ChattingUIFragment", arrayList);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(linkedHashMap, szU);
        AppMethodBeat.o(220739);
    }

    public final synchronized void a(i iVar) {
        AppMethodBeat.i(220740);
        p.h(iVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!mListeners.contains(iVar)) {
            mListeners.add(iVar);
        }
        AppMethodBeat.o(220740);
    }

    private final synchronized void cOa() {
        AppMethodBeat.i(220741);
        Iterator<T> it = mListeners.iterator();
        while (it.hasNext()) {
            it.next().onEnter();
        }
        AppMethodBeat.o(220741);
    }

    private final synchronized void cOb() {
        AppMethodBeat.i(220742);
        Iterator<T> it = mListeners.iterator();
        while (it.hasNext()) {
            it.next().onExit();
        }
        AppMethodBeat.o(220742);
    }

    private final synchronized void cOc() {
        AppMethodBeat.i(220743);
        Iterator<T> it = mListeners.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
        AppMethodBeat.o(220743);
    }

    private final synchronized void cOd() {
        AppMethodBeat.i(220744);
        Iterator<T> it = mListeners.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
        AppMethodBeat.o(220744);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatFragmentCallback$mChatFragmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.core.b.b.a$a  reason: collision with other inner class name */
    public static final class C1026a implements c {
        C1026a() {
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            AppMethodBeat.i(220738);
            if (!p.j(str, "com/tencent/mm/ui/chatting/ChattingUIFragment")) {
                AppMethodBeat.o(220738);
            } else if (str2 == null) {
                AppMethodBeat.o(220738);
            } else {
                switch (str2.hashCode()) {
                    case -1799985168:
                        if (str2.equals("onEnterBegin") && p.j(str3, "()V")) {
                            a aVar = a.szV;
                            if (!a.szR) {
                                a.a(a.szV);
                                a aVar2 = a.szV;
                                a.szS = true;
                                AppMethodBeat.o(220738);
                                return;
                            }
                        }
                        break;
                    case -1427566836:
                        if (str2.equals("onExitBegin") && p.j(str3, "()V")) {
                            a aVar3 = a.szV;
                            if (!a.szR) {
                                a.c(a.szV);
                                a aVar4 = a.szV;
                                a.szT = true;
                                AppMethodBeat.o(220738);
                                return;
                            }
                        }
                        break;
                    case -112389456:
                        if (str2.equals("doAttach") && p.j(str3, "(Landroid/content/Context;)V")) {
                            a aVar5 = a.szV;
                            a.szR = true;
                            AppMethodBeat.o(220738);
                            return;
                        }
                    case 20863998:
                        if (str2.equals("onExitEnd") && p.j(str3, "()V")) {
                            a aVar6 = a.szV;
                            a.szR = false;
                            break;
                        }
                    case 360443032:
                        if (str2.equals("doResume") && p.j(str3, "()V")) {
                            a aVar7 = a.szV;
                            if (!a.szR) {
                                a aVar8 = a.szV;
                                if (!a.szS) {
                                    a.b(a.szV);
                                    AppMethodBeat.o(220738);
                                    return;
                                }
                                a aVar9 = a.szV;
                                a.szS = false;
                                AppMethodBeat.o(220738);
                                return;
                            }
                        }
                        break;
                    case 1810778155:
                        if (str2.equals("doPause") && p.j(str3, "()V")) {
                            a aVar10 = a.szV;
                            if (!a.szR) {
                                a aVar11 = a.szV;
                                if (!a.szT) {
                                    a.d(a.szV);
                                    AppMethodBeat.o(220738);
                                    return;
                                }
                                a aVar12 = a.szV;
                                a.szT = false;
                                AppMethodBeat.o(220738);
                                return;
                            }
                        }
                        break;
                }
                AppMethodBeat.o(220738);
            }
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }
}

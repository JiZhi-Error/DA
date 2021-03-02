package com.tencent.mm.plugin.expt.c;

import android.util.Pair;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR8\u0010\u000b\u001a,\u0012\u0004\u0012\u00020\u0004\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f0\u000e0\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/expt/biz/ChatListMonitor;", "", "()V", "CLASS_HEADER", "", "INTERFACE_NAME", "METHOD_DESC", "METHOD_NAME", "mChatListListener", "com/tencent/mm/plugin/expt/biz/ChatListMonitor$mChatListListener$1", "Lcom/tencent/mm/plugin/expt/biz/ChatListMonitor$mChatListListener$1;", "mChatMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "monitor", "", "plugin-expt_release"})
public final class a {
    private static final HashMap<String, Map<String, List<Pair<String, String>>>> sxj = new HashMap<>();
    private static final C1009a sxk = new C1009a();
    public static final a sxl = new a();

    static {
        AppMethodBeat.i(220733);
        AppMethodBeat.o(220733);
    }

    private a() {
    }

    public static void cMH() {
        AppMethodBeat.i(220732);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z"));
        HashMap hashMap = new HashMap();
        hashMap.put("android/view/View$OnTouchListener", arrayList);
        sxj.put("com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", hashMap);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.e(sxj, sxk);
        AppMethodBeat.o(220732);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/expt/biz/ChatListMonitor$mChatListListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.c.a$a  reason: collision with other inner class name */
    public static final class C1009a implements c {
        C1009a() {
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            AppMethodBeat.i(220731);
            if (str != null) {
                if (!n.J(str, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", false)) {
                    AppMethodBeat.o(220731);
                    return;
                } else if (p.j(str2, "onTouch") && p.j(str3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z") && objArr != null && objArr.length >= 2 && (objArr[1] instanceof MotionEvent)) {
                    Object obj2 = objArr[1];
                    if (obj2 == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.MotionEvent");
                        AppMethodBeat.o(220731);
                        throw tVar;
                    } else if ((((MotionEvent) obj2).getAction() & 255) == 0) {
                        com.tencent.mm.plugin.expt.hellhound.a.lW(false);
                        com.tencent.mm.plugin.expt.hellhound.a.aox("temp_6");
                    }
                }
            }
            AppMethodBeat.o(220731);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }
}

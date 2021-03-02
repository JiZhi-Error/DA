package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.protocal.protobuf.erd;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0002\u0004\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\nR\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "", "()V", "mGestureExecListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1;", "mGestureListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1;", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "onTouchEvent", "", "onTouchEventViewName", "", "callback", "", "methodName", "type", "resId", "idHex", "gestureMonitor", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "plugin-expt_release"})
public final class a {
    private static boolean sAw;
    public static final C1027a sAx = new C1027a((byte) 0);
    public c sAr;
    private int sAs = -1;
    private String sAt;
    public final b sAu = new b(this);
    public final c sAv = new c(this);

    static {
        AppMethodBeat.i(220754);
        AppMethodBeat.o(220754);
    }

    public a() {
        AppMethodBeat.i(220753);
        AppMethodBeat.o(220753);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$Companion;", "", "()V", "gGestureFirst", "", "getGGestureFirst", "()Z", "setGGestureFirst", "(Z)V", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.core.b.c.a$a  reason: collision with other inner class name */
    public static final class C1027a {
        private C1027a() {
        }

        public /* synthetic */ C1027a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J[\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJN\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0011"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    public static final class b implements com.tencent.mm.hellhoundlib.a.b {
        final /* synthetic */ a sAy;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.sAy = aVar;
        }

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void c(String str, String str2, String str3, String str4, Object obj, Object[] objArr) {
            boolean z;
            AppMethodBeat.i(220750);
            a aVar = this.sAy;
            MotionEvent motionEvent = objArr != null ? objArr[0] : null;
            if (motionEvent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.MotionEvent");
                AppMethodBeat.o(220750);
                throw tVar;
            }
            aVar.sAs = motionEvent.getAction();
            if (this.sAy.sAs == 0) {
                this.sAy.sAt = str;
                Boolean valueOf = str != null ? Boolean.valueOf(n.a((CharSequence) str, (CharSequence) "$OnTouchListener", false)) : null;
                C1027a aVar2 = a.sAx;
                if (valueOf == null || !valueOf.booleanValue() || !p.j(str2, "onTouch") || !p.j(str3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z")) {
                    z = false;
                } else {
                    z = true;
                }
                a.sAw = z;
            }
            AppMethodBeat.o(220750);
        }

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void a(String str, String str2, String str3, Object obj) {
            AppMethodBeat.i(220751);
            if (this.sAy.sAs == 0) {
                Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                if (bool != null) {
                    bool.booleanValue();
                    C1027a aVar = a.sAx;
                    a.sAw = bool.booleanValue();
                } else {
                    AppMethodBeat.o(220751);
                    return;
                }
            }
            AppMethodBeat.o(220751);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    public static final class c implements com.tencent.mm.hellhoundlib.a.c {
        final /* synthetic */ a sAy;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(a aVar) {
            this.sAy = aVar;
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            String hexString;
            AppMethodBeat.i(220752);
            if (objArr != null) {
                if (!(objArr.length == 0) && (obj instanceof View)) {
                    g.a aVar = g.sBf;
                    String dL = g.a.dL((View) obj);
                    if (dL == null) {
                        C1027a aVar2 = a.sAx;
                        a.sAw = false;
                        AppMethodBeat.o(220752);
                        return;
                    }
                    if (((View) obj).getId() == -1) {
                        g.a aVar3 = g.sBf;
                        dL = g.a.dM((View) obj);
                    }
                    if (((View) obj).getId() == -1) {
                        hexString = dL;
                    } else {
                        hexString = com.tencent.mm.plugin.expt.hellhound.core.b.toHexString(((View) obj).getId());
                        p.g(hexString, "HellhoundUtil.toHexString(caller.id)");
                    }
                    a aVar4 = this.sAy;
                    String name = ((View) obj).getClass().getName();
                    p.g(name, "caller.javaClass.name");
                    a.a(aVar4, str2, name, dL, hexString);
                    AppMethodBeat.o(220752);
                    return;
                }
            }
            C1027a aVar5 = a.sAx;
            a.sAw = false;
            AppMethodBeat.o(220752);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(a aVar, String str, String str2, String str3, String str4) {
        c cVar;
        AppMethodBeat.i(220755);
        erd erd = new erd();
        erd.NoL = str3;
        erd.id = str4;
        erd.timestamp = System.currentTimeMillis();
        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str2);
        erd.typeName = aoE;
        erd.NoM = aoE;
        if (str != null) {
            switch (str.hashCode()) {
                case -1263341865:
                    if (str.equals("onSingleTapUp")) {
                        erd.eventId = d.SINGLE_CLICK.value;
                        break;
                    }
                    break;
                case -1236836200:
                    if (str.equals("onContextClick")) {
                        erd.eventId = d.SINGLE_CLICK.value;
                        break;
                    }
                    break;
                case -836949261:
                    if (str.equals("onDoubleTap")) {
                        erd.eventId = d.DOUBLE_CLICK.value;
                        break;
                    }
                    break;
                case 83417096:
                    if (str.equals(e.a.NAME)) {
                        erd.eventId = d.LONG_CLICK.value;
                        break;
                    }
                    break;
            }
            if (erd.eventId != d.INVALIDATE.value || (cVar = aVar.sAr) == null) {
                AppMethodBeat.o(220755);
            }
            cVar.a(null, erd);
            AppMethodBeat.o(220755);
            return;
        }
        erd.eventId = d.INVALIDATE.value;
        if (erd.eventId != d.INVALIDATE.value) {
        }
        AppMethodBeat.o(220755);
    }
}

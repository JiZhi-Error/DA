package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.protocal.protobuf.erd;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0004\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0014R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R,\u0010\n\u001a \u0012\u0004\u0012\u00020\f\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e0\r0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "", "()V", "mHorizontalListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$mHorizontalListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$mHorizontalListener$1;", "mLastPosition", "", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "mMethodMap", "", "", "", "Landroid/util/Pair;", "monitor", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "monitor$plugin_expt_release", "unmonitor", "unmonitor$plugin_expt_release", "Companion", "plugin-expt_release"})
public final class b {
    public static final a sAB = new a((byte) 0);
    int afB = -1;
    final C1028b sAA = new C1028b(this);
    c sAr;
    final Map<String, List<Pair<String, String>>> sAz = new LinkedHashMap();

    static {
        AppMethodBeat.i(220758);
        AppMethodBeat.o(220758);
    }

    public b() {
        AppMethodBeat.i(220757);
        AppMethodBeat.o(220757);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$Companion;", "", "()V", "CLASS_NAME", "", "METHOD_DESC", "METHOD_NAME", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$mHorizontalListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.core.b.c.b$b  reason: collision with other inner class name */
    public static final class C1028b implements c {
        final /* synthetic */ b sAC;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1028b(b bVar) {
            this.sAC = bVar;
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            Class<?> cls;
            AppMethodBeat.i(220756);
            if (obj != null && (obj instanceof View) && objArr != null && objArr.length >= 2) {
                Object obj2 = objArr[0];
                if (obj2 == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(220756);
                    throw tVar;
                }
                int intValue = ((Integer) obj2).intValue();
                Object obj3 = objArr[1];
                if (obj3 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type kotlin.Boolean");
                    AppMethodBeat.o(220756);
                    throw tVar2;
                }
                ((Boolean) obj3).booleanValue();
                if (intValue > 0 || this.sAC.afB != -1) {
                    this.sAC.afB = intValue;
                    erd erd = new erd();
                    erd.id = "Horizontal-Scroll-".concat(String.valueOf(intValue));
                    erd.NoL = erd.id;
                    erd.typeName = erd.id;
                    com.tencent.mm.plugin.expt.hellhound.core.a cNx = com.tencent.mm.plugin.expt.hellhound.core.a.cNx();
                    p.g(cNx, "HellhoundMonitor.getInstance()");
                    Object cNw = cNx.cNw();
                    String name = (cNw == null || (cls = cNw.getClass()) == null) ? null : cls.getName();
                    if (name != null) {
                        str = name;
                    }
                    erd.dMl = str;
                    erd.NoM = ((View) obj).getClass().getName();
                    erd.eventId = d.GLIDE.value;
                    erd.aHK = obj.hashCode();
                    erd.NoN = obj.hashCode();
                    erd.timestamp = System.currentTimeMillis();
                    erd.type = 1;
                    erd.LCp = intValue;
                    c cVar = this.sAC.sAr;
                    if (cVar != null) {
                        cVar.a((View) obj, erd);
                        AppMethodBeat.o(220756);
                        return;
                    }
                } else {
                    AppMethodBeat.o(220756);
                    return;
                }
            }
            AppMethodBeat.o(220756);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }
}

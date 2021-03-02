package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.protocal.protobuf.erd;
import java.lang.ref.WeakReference;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\t\u0011\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u0017\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b\u001eR\u001a\u0010\u0003\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "", "()V", "mArgsOnTouchRef", "Ljava/lang/ref/WeakReference;", "", "mClickDown", "", "mImageViewClickListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1;", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "mTouchPair", "Landroid/util/Pair;", "", "mViewOpListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1;", "callback", "", "view", "Landroid/view/View;", "className", "caller", "eventId", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewEventId;", "imageViewMonitor", "viewOpMonitor", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "viewOpMonitor$plugin_expt_release", "Companion", "plugin-expt_release"})
public final class f {
    public static final a sBd = new a((byte) 0);
    private WeakReference<Object[]> sAY;
    private Pair<String, String> sAZ;
    public c sAr;
    public final c sBa = new c(this);
    private boolean sBb;
    public final b sBc = new b(this);

    static {
        AppMethodBeat.i(220781);
        AppMethodBeat.o(220781);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public f() {
        AppMethodBeat.i(220780);
        AppMethodBeat.o(220780);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    public static final class c implements com.tencent.mm.hellhoundlib.a.c {
        final /* synthetic */ f sBe;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(f fVar) {
            this.sBe = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ca, code lost:
            if (kotlin.g.b.p.j(r1, r2) != false) goto L_0x00cc;
         */
        @Override // com.tencent.mm.hellhoundlib.a.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.Object r10, java.lang.Object[] r11) {
            /*
            // Method dump skipped, instructions count: 434
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.core.b.c.f.c.a(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, java.lang.Object[]):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Object[]] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.tencent.mm.hellhoundlib.a.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.Object r11, java.lang.Object r12) {
            /*
            // Method dump skipped, instructions count: 216
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.core.b.c.f.c.a(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, java.lang.Object):void");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    public static final class b implements com.tencent.mm.hellhoundlib.a.c {
        final /* synthetic */ f sBe;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(f fVar) {
            this.sBe = fVar;
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            boolean z;
            AppMethodBeat.i(220776);
            if (objArr != null) {
                if (!(objArr.length == 0)) {
                    if (!(objArr[0] instanceof MotionEvent)) {
                        AppMethodBeat.o(220776);
                        return;
                    }
                    Object obj2 = objArr[0];
                    if (obj2 == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.MotionEvent");
                        AppMethodBeat.o(220776);
                        throw tVar;
                    }
                    f fVar = this.sBe;
                    if (((MotionEvent) obj2).getAction() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    fVar.sBb = z;
                    AppMethodBeat.o(220776);
                    return;
                }
            }
            AppMethodBeat.o(220776);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
            AppMethodBeat.i(220777);
            if (!this.sBe.sBb) {
                AppMethodBeat.o(220777);
            } else if (obj == null || !(obj instanceof View)) {
                AppMethodBeat.o(220777);
            } else if (obj2 == null || !(obj2 instanceof Boolean) || !((Boolean) obj2).booleanValue()) {
                AppMethodBeat.o(220777);
            } else {
                this.sBe.sBb = false;
                f.a(this.sBe, (View) obj, str, obj, d.TOUCH);
                AppMethodBeat.o(220777);
            }
        }
    }

    public static final /* synthetic */ void a(f fVar, View view, String str, Object obj, d dVar) {
        String dL;
        String hexString;
        int i2;
        Class<?> cls;
        String name;
        AppMethodBeat.i(220782);
        if (view.getId() == -1) {
            g.a aVar = g.sBf;
            dL = g.a.dM(view);
        } else {
            g.a aVar2 = g.sBf;
            dL = g.a.dL(view);
        }
        if (view.getId() == -1) {
            hexString = dL;
        } else {
            hexString = com.tencent.mm.plugin.expt.hellhound.core.b.toHexString(view.getId());
        }
        erd erd = new erd();
        erd.NoL = dL;
        erd.id = hexString;
        erd.timestamp = System.currentTimeMillis();
        erd.aHK = view.hashCode();
        erd.typeName = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(view.getClass().getName());
        if (!(obj == null || (cls = obj.getClass()) == null || (name = cls.getName()) == null)) {
            str = name;
        }
        erd.NoM = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
        erd.eventId = dVar.value;
        if (view instanceof ViewGroup) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        erd.type = i2;
        c cVar = fVar.sAr;
        if (cVar != null) {
            cVar.a(view, erd);
            AppMethodBeat.o(220782);
            return;
        }
        AppMethodBeat.o(220782);
    }
}

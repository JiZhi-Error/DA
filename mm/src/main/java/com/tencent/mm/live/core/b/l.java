package com.tencent.mm.live.core.b;

import android.view.SurfaceHolder;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u000eHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R$\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bRN\u0010\f\u001a6\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0004¨\u0006#"}, hxF = {"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "", "surfaceHolder", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;)V", "onViewCreated", "Lkotlin/Function0;", "", "getOnViewCreated", "()Lkotlin/jvm/functions/Function0;", "setOnViewCreated", "(Lkotlin/jvm/functions/Function0;)V", "onViewSizeChanged", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "w", "h", "getOnViewSizeChanged", "()Lkotlin/jvm/functions/Function2;", "setOnViewSizeChanged", "(Lkotlin/jvm/functions/Function2;)V", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "Companion", "plugin-core_release"})
public final class l {
    public static final a hEE = new a((byte) 0);
    public SurfaceHolder beb;
    public kotlin.g.a.a<x> hEC;
    public m<? super Integer, ? super Integer, x> hED;

    static {
        AppMethodBeat.i(196695);
        AppMethodBeat.o(196695);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(196698);
        if (this == obj || ((obj instanceof l) && p.j(this.beb, ((l) obj).beb))) {
            AppMethodBeat.o(196698);
            return true;
        }
        AppMethodBeat.o(196698);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(196697);
        SurfaceHolder surfaceHolder = this.beb;
        if (surfaceHolder != null) {
            int hashCode = surfaceHolder.hashCode();
            AppMethodBeat.o(196697);
            return hashCode;
        }
        AppMethodBeat.o(196697);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(196696);
        String str = "RenderSurfaceHolder(surfaceHolder=" + this.beb + ")";
        AppMethodBeat.o(196696);
        return str;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private /* synthetic */ l() {
        this(null);
    }

    public l(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(196694);
        this.beb = surfaceHolder;
        SurfaceHolder surfaceHolder2 = this.beb;
        if (surfaceHolder2 != null) {
            surfaceHolder2.addCallback(new SurfaceHolder.Callback(this) {
                /* class com.tencent.mm.live.core.b.l.AnonymousClass1 */
                final /* synthetic */ l hEF;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.hEF = r1;
                }

                public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    AppMethodBeat.i(196691);
                    Log.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceDestroyed");
                    AppMethodBeat.o(196691);
                }

                public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                    AppMethodBeat.i(196692);
                    Log.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceCreated");
                    kotlin.g.a.a<x> aVar = this.hEF.hEC;
                    if (aVar != null) {
                        aVar.invoke();
                        AppMethodBeat.o(196692);
                        return;
                    }
                    AppMethodBeat.o(196692);
                }

                public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                    AppMethodBeat.i(196693);
                    Log.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceChanged width is " + i3 + " and height is " + i4);
                    m<? super Integer, ? super Integer, x> mVar = this.hEF.hED;
                    if (mVar != null) {
                        mVar.invoke(Integer.valueOf(i3), Integer.valueOf(i4));
                        AppMethodBeat.o(196693);
                        return;
                    }
                    AppMethodBeat.o(196693);
                }
            });
            AppMethodBeat.o(196694);
            return;
        }
        AppMethodBeat.o(196694);
    }
}

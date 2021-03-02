package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.d.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.at;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.k;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010 \u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\"H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"})
public final class a extends b implements at {
    private final a TVq;
    private final boolean TVr;
    private volatile a _immediate;
    private final Handler handler;
    private final String name;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"})
    public static final class b implements Runnable {
        final /* synthetic */ a TVs;
        final /* synthetic */ k TVu;

        public b(a aVar, k kVar) {
            this.TVs = aVar;
            this.TVu = kVar;
        }

        public final void run() {
            AppMethodBeat.i(107778);
            this.TVu.a(this.TVs, x.SXb);
            AppMethodBeat.o(107778);
        }
    }

    private a(Handler handler2, String str, boolean z) {
        super((byte) 0);
        AppMethodBeat.i(107776);
        this.handler = handler2;
        this.name = str;
        this.TVr = z;
        this._immediate = this.TVr ? this : null;
        a aVar = this._immediate;
        if (aVar == null) {
            aVar = new a(this.handler, this.name, true);
            this._immediate = aVar;
        }
        this.TVq = aVar;
        AppMethodBeat.o(107776);
    }

    public a(Handler handler2, String str) {
        this(handler2, str, false);
        AppMethodBeat.i(107777);
        AppMethodBeat.o(107777);
    }

    @Override // kotlinx.coroutines.ad
    public final boolean hMH() {
        AppMethodBeat.i(187957);
        if (!this.TVr || (!p.j(Looper.myLooper(), this.handler.getLooper()))) {
            AppMethodBeat.o(187957);
            return true;
        }
        AppMethodBeat.o(187957);
        return false;
    }

    @Override // kotlinx.coroutines.ad
    public final void a(f fVar, Runnable runnable) {
        AppMethodBeat.i(107772);
        this.handler.post(runnable);
        AppMethodBeat.o(107772);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"kotlinx/coroutines/android/HandlerContext$invokeOnTimeout$1", "Lkotlinx/coroutines/DisposableHandle;", "dispose", "", "kotlinx-coroutines-android"})
    /* renamed from: kotlinx.coroutines.android.a$a  reason: collision with other inner class name */
    public static final class C2378a implements bc {
        final /* synthetic */ a TVs;
        final /* synthetic */ Runnable TVt;

        C2378a(a aVar, Runnable runnable) {
            this.TVs = aVar;
            this.TVt = runnable;
        }

        @Override // kotlinx.coroutines.bc
        public final void dispose() {
            AppMethodBeat.i(187959);
            this.TVs.handler.removeCallbacks(this.TVt);
            AppMethodBeat.o(187959);
        }
    }

    @Override // kotlinx.coroutines.android.b, kotlinx.coroutines.at
    public final bc d(long j2, Runnable runnable) {
        AppMethodBeat.i(187958);
        this.handler.postDelayed(runnable, j.aN(j2, 4611686018427387903L));
        C2378a aVar = new C2378a(this, runnable);
        AppMethodBeat.o(187958);
        return aVar;
    }

    @Override // kotlinx.coroutines.ad
    public final String toString() {
        AppMethodBeat.i(107774);
        if (this.name == null) {
            String handler2 = this.handler.toString();
            AppMethodBeat.o(107774);
            return handler2;
        } else if (this.TVr) {
            String str = this.name + " [immediate]";
            AppMethodBeat.o(107774);
            return str;
        } else {
            String str2 = this.name;
            AppMethodBeat.o(107774);
            return str2;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).handler == this.handler;
    }

    public final int hashCode() {
        AppMethodBeat.i(107775);
        int identityHashCode = System.identityHashCode(this.handler);
        AppMethodBeat.o(107775);
        return identityHashCode;
    }

    @Override // kotlinx.coroutines.at
    public final void a(long j2, k<? super x> kVar) {
        AppMethodBeat.i(107773);
        b bVar = new b(this, kVar);
        this.handler.postDelayed(bVar, j.aN(j2, 4611686018427387903L));
        kVar.W(new c(this, bVar));
        AppMethodBeat.o(107773);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<Throwable, x> {
        final /* synthetic */ a TVs;
        final /* synthetic */ Runnable TVt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, Runnable runnable) {
            super(1);
            this.TVs = aVar;
            this.TVt = runnable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Throwable th) {
            AppMethodBeat.i(107781);
            this.TVs.handler.removeCallbacks(this.TVt);
            x xVar = x.SXb;
            AppMethodBeat.o(107781);
            return xVar;
        }
    }
}

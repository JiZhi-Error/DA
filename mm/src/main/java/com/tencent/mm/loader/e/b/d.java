package com.tencent.mm.loader.e.b;

import android.os.Looper;
import com.facebook.share.internal.ShareConstants;
import com.tencent.mm.loader.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0019B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H$¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H&J$\u0010\u0015\u001a\u00020\n2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00042\u000e\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0017H&J$\u0010\u0018\u001a\u00020\n2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00042\u000e\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0017H&R\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "R", "", "weakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getWeakHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setWeakHolder", "onResourceReady", "", "resource", "waitUI", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/IWaitUI;)V", "onResourceReadyUI", "", "viewWeakHolder", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)Z", "uniqueCode", "", "updateBackgroundUI", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/loader/Reaper;", "updateDefaultDrawable", "Companion", "libimageloader_release"})
public abstract class d<R> {
    private static final String TAG = TAG;
    public static final a iat = new a((byte) 0);
    public g<?> ias;

    public abstract void a(g<?> gVar, f<?, ?> fVar);

    /* access modifiers changed from: protected */
    public abstract boolean a(R r, g<?> gVar);

    public abstract int aJV();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/loader/impr/target/ResourceShowTarget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public d(g<?> gVar) {
        p.h(gVar, "weakHolder");
        this.ias = gVar;
    }

    public final void a(R r, b bVar) {
        p.h(bVar, "waitUI");
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            Log.i(TAG, "onResourceReady " + ((Object) r) + " and this " + this);
        }
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        if (currentThread == mainLooper.getThread()) {
            bVar.eR(a(r, this.ias));
        } else {
            MMHandlerThread.postToMainThread(new b(this, bVar, r));
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "R", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ d iau;
        final /* synthetic */ b iav;
        final /* synthetic */ Object iaw;

        b(d dVar, b bVar, Object obj) {
            this.iau = dVar;
            this.iav = bVar;
            this.iaw = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.tencent.mm.loader.e.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        public final void run() {
            this.iav.eR(this.iau.a(this.iaw, this.iau.ias));
        }
    }
}

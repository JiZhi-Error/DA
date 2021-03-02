package com.tencent.mm.plugin.finder.feed.model.internal;

import android.os.SystemClock;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012J$\u0010\u0018\u001a\u00020\u00192\u001a\u0010\u001a\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00190\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u000bJ\u0016\u0010\u001d\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001eH\u0016J\u0016\u0010\u001f\u001a\u00020\u00192\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/Preload;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IPreload;", "hardWaitDurationMs", "", "(J)V", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "isLoading", "", "()Z", "setLoading", "(Z)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "getResponse", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "setResponse", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", "clearCache", "getCache", "", "call", "Lkotlin/Function1;", "isHasCached", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lkotlin/Function0;", "setCache", "plugin-finder_release"})
public final class m<T extends i> implements j<T> {
    private final ReentrantLock dgE;
    private final Condition dgF;
    public volatile boolean isLoading;
    public volatile IResponse<T> tYO;
    private final long tYP;

    private m() {
        AppMethodBeat.i(245040);
        this.tYP = 0;
        this.dgE = new ReentrantLock();
        this.dgF = this.dgE.newCondition();
        AppMethodBeat.o(245040);
    }

    public /* synthetic */ m(byte b2) {
        this();
    }

    public final boolean ddC() {
        return this.tYO != null;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.j
    public final void a(IResponse<T> iResponse) {
        AppMethodBeat.i(245036);
        p.h(iResponse, "response");
        this.dgE.lock();
        try {
            this.tYO = iResponse;
            this.dgF.signalAll();
        } finally {
            this.isLoading = false;
            this.dgE.unlock();
            AppMethodBeat.o(245036);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.j
    public final void G(a<x> aVar) {
        AppMethodBeat.i(245037);
        p.h(aVar, "call");
        this.dgE.lock();
        try {
            this.isLoading = true;
            this.dgE.unlock();
            aVar.invoke();
            AppMethodBeat.o(245037);
        } catch (Throwable th) {
            this.dgE.unlock();
            AppMethodBeat.o(245037);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.j
    public final void D(b<? super IResponse<T>, x> bVar) {
        AppMethodBeat.i(245038);
        p.h(bVar, "call");
        this.dgE.lock();
        try {
            if (this.isLoading) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.dgF.await(1, TimeUnit.MINUTES);
                long uptimeMillis2 = this.tYP - (SystemClock.uptimeMillis() - uptimeMillis);
                if (uptimeMillis2 > 0) {
                    this.dgF.await(uptimeMillis2, TimeUnit.MILLISECONDS);
                }
            } else if (this.tYO != null && this.tYP > 0) {
                this.dgF.await(this.tYP, TimeUnit.MILLISECONDS);
            }
            this.dgE.unlock();
            IResponse<T> iResponse = this.tYO;
            this.tYO = null;
            bVar.invoke(iResponse);
            AppMethodBeat.o(245038);
        } catch (Throwable th) {
            this.dgE.unlock();
            AppMethodBeat.o(245038);
            throw th;
        }
    }

    public final boolean clearCache() {
        AppMethodBeat.i(245039);
        try {
            this.dgE.lock();
            boolean z = this.tYO != null;
            this.tYO = null;
            return z;
        } finally {
            this.dgE.unlock();
            AppMethodBeat.o(245039);
        }
    }
}

package com.tencent.luggage.sdk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u0000 !*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eJ\b\u0010\u001d\u001a\u00020\u0019H&J\u0006\u0010\u001e\u001a\u00020\u0016J\r\u0010\u001f\u001a\u00028\u0000H&¢\u0006\u0002\u0010 R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\n¨\u0006\""}, hxF = {"Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "T", "", "()V", "cost", "", "endTimeStampMs", "getEndTimeStampMs", "()J", "setEndTimeStampMs", "(J)V", "futureTask", "Ljava/util/concurrent/FutureTask;", "isUsed", "", "()Z", "setUsed", "(Z)V", "startTimeStampMs", "getStartTimeStampMs", "setStartTimeStampMs", "cancel", "", "getPreFetchResult", "timeoutMs", "", "(I)Ljava/lang/Object;", "initialed", "isDone", "key", "post", "preFetch", "()Ljava/lang/Object;", "Companion", "luggage-wechat-full-sdk_release"})
public abstract class a<T> {
    public static final C0185a cCw = new C0185a((byte) 0);
    protected FutureTask<T> cCr;
    protected long cCs;
    protected long cCt;
    public boolean cCu;
    private long cCv;

    public abstract T OX();

    public abstract int OY();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask$Companion;", "", "()V", "DEFAULT_TIME_OUT", "", "TAG", "", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.luggage.sdk.e.a$a  reason: collision with other inner class name */
    public static final class C0185a {
        private C0185a() {
        }

        public /* synthetic */ C0185a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "T", "call", "()Ljava/lang/Object;"})
    static final class b<V> implements Callable<T> {
        final /* synthetic */ a cCx;

        b(a aVar) {
            this.cCx = aVar;
        }

        @Override // java.util.concurrent.Callable
        public final T call() {
            AppMethodBeat.i(230041);
            long currentTimeMillis = System.currentTimeMillis();
            T t = (T) this.cCx.OX();
            this.cCx.cCv = System.currentTimeMillis() - currentTimeMillis;
            AppMethodBeat.o(230041);
            return t;
        }
    }

    public final void cancel() {
        if (this.cCr == null) {
            throw new IllegalStateException();
        }
        FutureTask<T> futureTask = this.cCr;
        if (futureTask == null) {
            p.btv("futureTask");
        }
        futureTask.cancel(false);
    }

    public final boolean OZ() {
        return this.cCr != null;
    }

    public T hS(int i2) {
        boolean z;
        if (this.cCr == null) {
            throw new IllegalStateException();
        }
        FutureTask<T> futureTask = this.cCr;
        if (futureTask == null) {
            p.btv("futureTask");
        }
        boolean isDone = futureTask.isDone();
        T t = null;
        long j2 = 0;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            FutureTask<T> futureTask2 = this.cCr;
            if (futureTask2 == null) {
                p.btv("futureTask");
            }
            t = futureTask2.get((long) i2, TimeUnit.MILLISECONDS);
            j2 = System.currentTimeMillis() - currentTimeMillis;
        } catch (Exception e2) {
            Log.e("Luggage.AppBrandBasePreFetchTask", "getPreFetchResult: " + e2.getMessage());
        }
        if (t == null) {
            cancel();
        }
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(OY());
        if (t != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(isDone);
        objArr[3] = Long.valueOf(this.cCv);
        objArr[4] = Long.valueOf(j2);
        Log.i("Luggage.AppBrandBasePreFetchTask", "getPreFetchResult: #%d task hit preFetch, isPreFetchSuccess = [%b], is done before invoke = [%b], cost = [%dms], wait = [%dms]", objArr);
        this.cCu = true;
        return t;
    }
}

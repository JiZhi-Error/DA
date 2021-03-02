package com.b.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;

/* access modifiers changed from: package-private */
public abstract class d {
    boolean chu;
    private Collection<WeakReference<m>> chv;
    private a chw;
    boolean isRunning;
    private Context mAppContext;
    private Handler mHandler;

    /* access modifiers changed from: package-private */
    public abstract void IV();

    /* access modifiers changed from: package-private */
    public abstract void a(Context context, Handler handler, a aVar);

    /* access modifiers changed from: package-private */
    public abstract void au(Context context);

    /* access modifiers changed from: package-private */
    public abstract void av(Context context);

    d() {
    }

    /* access modifiers changed from: package-private */
    public final void c(p pVar) {
        if (this.isRunning && this.chv != null) {
            for (WeakReference<m> weakReference : this.chv) {
                m mVar = weakReference.get();
                if (mVar != null) {
                    mVar.a(pVar);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(Context context, m... mVarArr) {
        if (context == null) {
            throw new Exception("Module: context cannot be null");
        }
        IY();
        b(context.getApplicationContext(), mVarArr);
        this.chu = true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void IY() {
        if (this.chu) {
            stop();
            IV();
            this.chu = false;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(Handler handler, a aVar) {
        stop();
        this.mHandler = handler;
        this.chw = aVar;
        a(this.mAppContext, this.mHandler, this.chw);
        this.isRunning = true;
    }

    /* access modifiers changed from: package-private */
    public synchronized void stop() {
        if (this.isRunning) {
            av(this.mAppContext);
            this.mHandler = null;
            this.chw = null;
            this.isRunning = false;
        }
    }

    private void b(Context context, m... mVarArr) {
        this.mAppContext = context;
        if (mVarArr == null) {
            this.chv = null;
        } else {
            this.chv = new LinkedList();
            for (m mVar : mVarArr) {
                this.chv.add(new WeakReference<>(mVar));
            }
        }
        au(context);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        final long chx;

        a(long j2) {
            AppMethodBeat.i(87918);
            this.chx = Math.max(j2, 0L);
            AppMethodBeat.o(87918);
        }
    }
}

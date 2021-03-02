package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bs;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public abstract class q {
    private static final long DEFAULT_RETURN_TIMEOUT = 600000;
    private static final int LIMIT_NOT_INITIALIZED = -99;
    private static final String TAG = "MicroMsg.NetSceneBase";
    private g dispatcher;
    private boolean hasCallbackToQueue;
    private s irr;
    private boolean isCanceled = false;
    private boolean isKinda = false;
    protected long lastdispatch = Util.currentTicks();
    private int limit = -99;
    private int netId = -1;
    private int priority = 0;
    private i queueCallback;
    private w remoteCB;

    public abstract int doScene(g gVar, i iVar);

    public abstract int getType();

    public void setIsKinda(boolean z) {
        this.isKinda = z;
    }

    public boolean getIsKinda() {
        return this.isKinda;
    }

    public enum b {
        EUnchecked,
        EOk,
        EFailed;

        public static b valueOf(String str) {
            AppMethodBeat.i(132314);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(132314);
            return bVar;
        }

        static {
            AppMethodBeat.i(132315);
            AppMethodBeat.o(132315);
        }
    }

    public enum a {
        EStatusCheckFailed,
        EReachMaxLimit;

        public static a valueOf(String str) {
            AppMethodBeat.i(132311);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(132311);
            return aVar;
        }

        static {
            AppMethodBeat.i(132312);
            AppMethodBeat.o(132312);
        }
    }

    public void reset() {
        this.lastdispatch = Util.currentTicks();
        this.netId = -1;
        this.limit = -99;
    }

    /* access modifiers changed from: protected */
    public long getReturnTimeout() {
        return DEFAULT_RETURN_TIMEOUT;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i2) {
        this.priority = i2;
    }

    /* access modifiers changed from: protected */
    public void setSecurityCheckError(a aVar) {
    }

    /* access modifiers changed from: protected */
    public b securityVerificationChecked(s sVar) {
        return b.EUnchecked;
    }

    public boolean uniqueInNetsceneQueue() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int securityLimitCount() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public boolean securityLimitCountReach() {
        return this.limit <= 0;
    }

    /* access modifiers changed from: protected */
    public boolean isSupportConcurrent() {
        return false;
    }

    public g dispatcher() {
        return this.dispatcher;
    }

    /* access modifiers changed from: protected */
    public void prepareDispatcher(g gVar) {
        this.lastdispatch = Util.currentTicks();
        this.dispatcher = gVar;
    }

    public boolean needCheckCallback() {
        return securityLimitCount() == 1;
    }

    public boolean hasCallBackToQueue() {
        return this.hasCallbackToQueue;
    }

    public void setHasCallbackToQueue(boolean z) {
        this.hasCallbackToQueue = z;
    }

    /* access modifiers changed from: protected */
    public int dispatch(g gVar, final s sVar, m mVar) {
        prepareDispatcher(gVar);
        this.irr = sVar;
        final m a2 = bs.a(mVar);
        int aVX = bs.aVX();
        if (aVX != 0) {
            return aVX;
        }
        if (this.limit == -99) {
            this.limit = securityLimitCount();
            Log.i(TAG, "initilized security limit count to " + this.limit);
        }
        if (securityLimitCount() > 1) {
            switch (securityVerificationChecked(sVar)) {
                case EUnchecked:
                    Assert.assertTrue("scene security verification not passed, type=" + sVar.getType() + ", uri=" + sVar.getUri() + ", CHECK NOW", false);
                    break;
                case EFailed:
                    Log.e(TAG, "scene security verification not passed, type=" + sVar.getType() + ", uri=" + sVar.getUri());
                    this.limit--;
                    setSecurityCheckError(a.EStatusCheckFailed);
                    this.netId = -1;
                    return this.netId;
                case EOk:
                    break;
                default:
                    Assert.assertTrue("invalid security verification status", false);
                    break;
            }
        }
        if (securityLimitCountReach()) {
            Log.e(TAG, "dispatch failed, scene limited for security, current limit=" + securityLimitCount());
            setSecurityCheckError(a.EReachMaxLimit);
            this.netId = -1;
            return this.netId;
        }
        this.limit--;
        y yVar = new y(sVar);
        if (this.remoteCB != null && !isSupportConcurrent()) {
            this.remoteCB.cancel();
        }
        this.remoteCB = new w(sVar, a2, this, this.queueCallback, gVar);
        this.netId = gVar.a(yVar, this.remoteCB);
        Log.i(TAG, "dispatcher send, %s", Integer.valueOf(this.netId));
        if (this.netId < 0) {
            Log.i(TAG, "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.netId), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(sVar.getType()));
            new MMHandler().post(new Runnable() {
                /* class com.tencent.mm.ak.q.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(132308);
                    Log.i(q.TAG, "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(q.this.netId), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(sVar.getType()));
                    a2.onGYNetEnd(-1, 3, -1, "send to network failed", sVar, null);
                    Log.i(q.TAG, "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(q.this.netId), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(sVar.getType()));
                    AppMethodBeat.o(132308);
                }
            });
            return 99999999;
        }
        w wVar = this.remoteCB;
        wVar.handler.postDelayed(wVar.iMR, 330000);
        return this.netId;
    }

    public void setOnSceneEnd(i iVar) {
        this.queueCallback = iVar;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void updateDispatchId(int i2) {
    }

    /* access modifiers changed from: protected */
    public void updateDispatchIdNew(int i2) {
        this.netId = i2;
    }

    public s getReqResp() {
        return this.irr;
    }

    public int getMMReqRespHash() {
        if (this.irr == null) {
            return 0;
        }
        return this.irr.hashCode();
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        Log.i(TAG, "cancel: %d, hash:%d, type:%d", Integer.valueOf(this.netId), Integer.valueOf(hashCode()), Integer.valueOf(getType()));
        this.isCanceled = true;
        if (this.remoteCB != null) {
            this.remoteCB.cancel();
        }
        if (this.netId != -1 && this.dispatcher != null) {
            int i2 = this.netId;
            this.netId = -1;
            this.dispatcher.cancel(i2);
        }
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    /* access modifiers changed from: protected */
    public boolean accept(q qVar) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean acceptConcurrent(q qVar) {
        return false;
    }

    public String getInfo() {
        return "";
    }
}

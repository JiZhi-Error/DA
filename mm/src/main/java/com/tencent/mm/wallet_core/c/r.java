package com.tencent.mm.wallet_core.c;

import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class r extends q implements m {
    private static final String RtY = MMApplicationContext.getResources().getString(R.string.itf);
    protected int RtZ = 0;
    protected String Rua;
    private WeakReference<MMActivity> aWF;
    protected i callback;
    protected int errCode = 0;
    protected String errMsg;
    protected int errType = 0;
    protected boolean qxx = true;
    protected boolean qxy = false;
    protected d rr;

    public interface a<T extends q> {
        void d(int i2, int i3, String str, T t);
    }

    /* access modifiers changed from: protected */
    public abstract void b(int i2, int i3, String str, s sVar);

    /* access modifiers changed from: protected */
    public abstract void e(s sVar);

    public final void t(MMActivity mMActivity) {
        this.aWF = new WeakReference<>(mMActivity);
    }

    public boolean eMZ() {
        return true;
    }

    public boolean czQ() {
        return false;
    }

    public boolean eMY() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        r0 = r8.aWF.get();
     */
    @Override // com.tencent.mm.network.m
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGYNetEnd(int r9, int r10, int r11, java.lang.String r12, com.tencent.mm.network.s r13, byte[] r14) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.wallet_core.c.r.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void");
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        this.callback = iVar;
        Assert.assertNotNull("rr can't be null!", this.rr);
        return dispatch(gVar, this.rr, this);
    }

    public final r a(a aVar) {
        if (!this.qxx && !this.qxy) {
            aVar.d(this.errCode, this.errType, this.errMsg, this);
        }
        return this;
    }

    public final r b(a aVar) {
        if (this.qxy) {
            aVar.d(this.errCode, this.errType, this.errMsg, this);
        }
        return this;
    }

    public final r c(a aVar) {
        if (this.qxx) {
            aVar.d(this.errCode, this.errType, this.errMsg, this);
        }
        return this;
    }
}

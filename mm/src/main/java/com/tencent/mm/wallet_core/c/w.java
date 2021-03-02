package com.tencent.mm.wallet_core.c;

import android.os.Bundle;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.t.a.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public abstract class w extends q implements m {
    private Bundle mBundle;
    private int mCmdId = 0;
    private String mProcessName = "";
    private long mRequestTime;
    private int mScene = 0;
    public long sessionId = 0;

    public abstract void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2);

    public int getCgicmdForKV() {
        return -1;
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        onGYNetEnd(i2, i3, i4, str, sVar, bArr, reportCostTime(i3, i4));
    }

    private long reportCostTime(int i2, int i3) {
        long currentTimeMillis = System.currentTimeMillis() - this.mRequestTime;
        String str = "";
        String str2 = "";
        this.mCmdId = getCgicmdForKV();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.mBundle != null) {
            str = this.mBundle.getString("key_TransId");
            str2 = this.mBundle.getString("key_reqKey");
            if (this.sessionId == 0) {
                this.sessionId = this.mBundle.getLong("key_SessionId", 0);
            }
            if (this.mScene == 0) {
                this.mScene = this.mBundle.getInt("key_scene");
            }
        }
        h.INSTANCE.a(11170, Integer.valueOf(getType()), Integer.valueOf(this.mCmdId), Long.valueOf(currentTimeMillis), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(NetStatusUtil.getNetType(MMApplicationContext.getContext())), this.mProcessName, str, str2, Long.valueOf(this.sessionId), Long.valueOf(currentTimeMillis2));
        ab.a(getType(), getCgicmdForKV(), i2, i3, currentTimeMillis, this.mScene, this.mProcessName);
        return currentTimeMillis;
    }

    @Override // com.tencent.mm.ak.q
    public int dispatch(g gVar, s sVar, m mVar) {
        this.mRequestTime = System.currentTimeMillis();
        c.eBv().sC(false);
        return super.dispatch(gVar, sVar, mVar);
    }

    public void setCmdId(int i2) {
        this.mCmdId = i2;
    }

    public void setProcessName(String str) {
        this.mProcessName = str;
    }

    public void setProcessBundle(Bundle bundle) {
        this.mBundle = bundle;
    }

    public void setProcessSessionId(long j2) {
        this.sessionId = j2;
    }

    public void setScene(int i2) {
        this.mScene = i2;
    }
}

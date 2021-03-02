package com.tencent.mm.ak;

import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class o implements s {
    private static final String TAG = "MicroMsg.MMReqRespBase";
    private boolean isSingleSession = true;
    private boolean isUserCmd = false;
    private l.d req;

    /* access modifiers changed from: protected */
    public abstract l.d getReqObjImp();

    @Override // com.tencent.mm.network.s
    public final l.d getReqObj() {
        if (this.req == null) {
            this.req = getReqObjImp();
            fillBaseReq(this.req, this);
        }
        return this.req;
    }

    public static void fillBaseReq(l.d dVar, o oVar) {
        dVar.setDeviceID(q.aoG());
        dVar.setDeviceType(d.ics);
        dVar.setClientVersion(d.KyO);
        dVar.setUin(j.e.a.Kzx.aVJ());
        if (g.aAc()) {
            int type = oVar.getType();
            boolean z = ((a) g.af(a.class)).aqJ().getInt("UseAesGcmSessionKeySwitch", 1) == 0;
            Log.i(TAG, "summerauths check cgi[%s] accHasReady openSwitch[%s] ", Integer.valueOf(type), Boolean.valueOf(z));
            if (z) {
                String value = ((a) g.af(a.class)).aqJ().getValue("UseAesGcmSessionKeyCgiList");
                if (!Util.isNullOrNil(value)) {
                    Log.i(TAG, "summerauths check cgi list[%s]", value);
                    String[] split = value.trim().split(",");
                    if (split.length > 0) {
                        for (String str : split) {
                            if (type == Util.getInt(str, 0)) {
                                oVar.setSingleSession(false);
                                Log.i(TAG, "summerauths check cgi list found cgi[%s] singleSession[%s]", str, Boolean.valueOf(oVar.isSingleSession()));
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        Log.i(TAG, "summerauths check cgi[%s] USE_ECDH[%s] accHasReady[%s] ", Integer.valueOf(dVar.getCmdId()), Boolean.valueOf(f.KyZ), Boolean.valueOf(g.aAc()));
    }

    public boolean getPush() {
        return false;
    }

    @Override // com.tencent.mm.network.s
    public int getOptions() {
        return 0;
    }

    @Override // com.tencent.mm.network.s
    public boolean getIsUserCmd() {
        return this.isUserCmd;
    }

    public void setIsUserCmd(boolean z) {
        this.isUserCmd = z;
    }

    @Override // com.tencent.mm.network.s
    public void setConnectionInfo(String str) {
    }

    @Override // com.tencent.mm.network.s
    public int getTimeOut() {
        return 0;
    }

    @Override // com.tencent.mm.network.s
    public boolean isSingleSession() {
        return this.isSingleSession;
    }

    /* access modifiers changed from: package-private */
    public void setSingleSession(boolean z) {
        this.isSingleSession = z;
    }

    @Override // com.tencent.mm.network.s
    public boolean getIsLongPolling() {
        return false;
    }

    @Override // com.tencent.mm.network.s
    public int getLongPollingTimeout() {
        return 0;
    }

    @Override // com.tencent.mm.network.s
    public int getNewExtFlags() {
        return 0;
    }

    @Override // com.tencent.mm.network.s
    public byte[] getTransHeader() {
        return null;
    }

    @Override // com.tencent.mm.network.s
    public boolean keepAlive() {
        return false;
    }
}

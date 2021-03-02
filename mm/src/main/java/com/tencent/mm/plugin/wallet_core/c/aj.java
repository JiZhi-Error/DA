package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class aj extends m {
    public int HQA;
    public String HQv;
    public String HQw;
    public String HQx;
    public String HQy;
    public int HQz;
    private long jmW;
    public String lJj;

    public aj() {
        AppMethodBeat.i(69963);
        setRequestData(null);
        AppMethodBeat.o(69963);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1992;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/gettransferwording";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69964);
        Log.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
        Log.d("MicroMsg.NetSceneTransferWording", "json: %s", jSONObject);
        this.lJj = jSONObject.optString("delay_confirm_wording");
        this.HQv = jSONObject.optString("delay_confirm_switch_wording");
        this.HQw = jSONObject.optString("delay_confirm_switch_remind_wording");
        this.HQx = jSONObject.optString("delay_confirm_desc_url");
        this.HQz = jSONObject.optInt("delay_confirm_desc_url_flag", 0);
        this.jmW = jSONObject.optLong("expire_time", 0) * 1000;
        this.HQA = jSONObject.optInt("delay_confirm_switch_flag", 0);
        g.aAi();
        ao azQ = g.aAh().azQ();
        if (!Util.isNullOrNil(this.lJj)) {
            azQ.set(ar.a.USERINFO_DELAY_TRANSFER_CONFIRM_WORDING_STRING, this.lJj);
        }
        if (!Util.isNullOrNil(this.HQv)) {
            azQ.set(ar.a.USERINFO_DELAY_TRANSFER_SWITCH_WORDING_STRING, this.HQv);
        }
        if (!Util.isNullOrNil(this.HQw)) {
            azQ.set(ar.a.USERINFO_DELAY_TRANSFER_REMIND_WORDING_STRING, this.HQw);
        }
        if (!Util.isNullOrNil(this.HQx)) {
            try {
                this.HQy = URLDecoder.decode(this.HQx, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                if (!Util.isNullOrNil(this.HQy)) {
                    azQ.set(ar.a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, this.HQy);
                }
            } catch (UnsupportedEncodingException e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneTransferWording", e2, "", new Object[0]);
            }
        }
        azQ.set(ar.a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, Integer.valueOf(this.HQz));
        azQ.set(ar.a.USERINFO_DELAY_TRANSFER_EXPIRE_TIME_LONG, Long.valueOf(this.jmW));
        azQ.set(ar.a.USERINFO_DELAY_TRANSFER_SHOW_SWITCH_FLAG_INT, Integer.valueOf(this.HQA));
        if (this.HQA == 0) {
            Log.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
            cqd cqd = new cqd();
            cqd.Cyb = 0;
            ((l) g.af(l.class)).aSM().d(new k.a(205, cqd));
            azQ.set(147457, Long.valueOf(((Long) azQ.get(147457, (Object) 0L)).longValue() & -17 & -33));
        }
        AppMethodBeat.o(69964);
    }

    public static boolean a(boolean z, i iVar) {
        AppMethodBeat.i(69965);
        g.aAi();
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_DELAY_TRANSFER_EXPIRE_TIME_LONG, (Object) 0L)).longValue();
        if (z || longValue < System.currentTimeMillis()) {
            Log.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", Long.valueOf(longValue), Boolean.valueOf(z));
            if (iVar != null) {
                iVar.a(new aj(), false, 1);
            } else {
                g.aAi();
                g.aAg().hqi.a(new aj(), 0);
            }
            AppMethodBeat.o(69965);
            return true;
        }
        Log.d("MicroMsg.NetSceneTransferWording", "not time");
        AppMethodBeat.o(69965);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final boolean isBlock() {
        return false;
    }
}

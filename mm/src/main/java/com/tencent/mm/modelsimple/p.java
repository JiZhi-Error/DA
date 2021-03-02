package com.tencent.mm.modelsimple;

import android.os.Build;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.g.a.yu;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.cr;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class p extends q implements m {
    private String account;
    private i callback;
    private d rr;

    public p(String str) {
        AppMethodBeat.i(134157);
        this.account = str;
        d.a aVar = new d.a();
        aVar.iLN = new btc();
        aVar.iLO = new btd();
        aVar.uri = "/cgi-bin/micromsg-bin/getprofile";
        aVar.funcId = 302;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((btc) this.rr.iLK.iLR).UserName = str;
        AppMethodBeat.o(134157);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 302;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(134158);
        if (Util.isNullOrNil(this.account)) {
            Log.e("MicroMsg.NetSceneGetProfile", "null or empty username");
            AppMethodBeat.o(134158);
            return -1;
        }
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(134158);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z = true;
        AppMethodBeat.i(134159);
        Log.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + i3 + " errCode=" + i4 + " errMsg=" + str);
        if (i3 == 0 && i4 == 0) {
            btd btd = (btd) this.rr.iLL.iLR;
            ym ymVar = new ym();
            ymVar.eeL.eeM = btd.LZO.NmE;
            EventCenter.instance.publish(ymVar);
            if (z.aTY().equals(btd.LZN.Lqk.toString()) && !Util.isNullOrNil(btd.LZO.Lis)) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_SELFINFO_SMALLIMGURL_STRING, btd.LZO.Lis);
            }
            Log.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", Integer.valueOf(btd.LZN.Mwm), Integer.valueOf(btd.LZO.Nmy));
            com.tencent.mm.kernel.g.aAh().azQ().set(64, Integer.valueOf(btd.LZO.KEf));
            com.tencent.mm.kernel.g.aAh().azQ().set(144385, Integer.valueOf(btd.LZO.Nmy));
            com.tencent.mm.kernel.g.aAh().azQ().set(40, Integer.valueOf(btd.LZN.Mwm));
            Log.i("MicroMsg.NetSceneGetProfile", "getprofile PluginSwitch: %d", Integer.valueOf(btd.LZN.Mwm));
            PluginAuth.setUserInfoPluginSwitch(btd.LZN.Mwm);
            com.tencent.mm.kernel.g.aAh().azQ().set(339975, Integer.valueOf(btd.LZO.NmG));
            Log.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", Integer.valueOf(btd.LZO.NmG));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(btd.LZO.LRD));
            cr.so(btd.LZO.LRD);
            Log.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", Integer.valueOf(btd.LZO.NmG), Integer.valueOf(btd.LZO.LRD));
            com.tencent.mm.kernel.g.aAh().azQ().set(208903, btd.LZO.KPA);
            com.tencent.mm.kernel.g.aAh().azQ().set(274433, btd.LZO.Mvp);
            com.tencent.mm.kernel.g.aAh().azQ().set(274434, btd.LZO.Mvo);
            com.tencent.mm.kernel.g.aAh().azQ().set(274436, btd.LZO.Nmz);
            MultiProcessMMKV.getMMKV("mmkv_crossprocess_infos").encode("mmkv_key_user_reg_ic", btd.LZO.Nmz);
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_PROFILE_WEIDIANINFO_STRING, Util.nullAs(btd.LZO.fuW, ""));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_F2F_RING_TONE_STRING, btd.LZO.NmI);
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EXT_USER_STATUS_INT_SYNC, Integer.valueOf(btd.LZO.MKH));
            Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.UserStatus:%s", Integer.valueOf(btd.LZO.MKH));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EXT_BIND_XMAIL_STRING_SYNC, btd.LZO.NmM);
            Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.BindXMail:%s", btd.LZO.NmM);
            Log.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", btd.LZO.fuW);
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC, btd.LZO.MvT);
            Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.PatSuffix:%s", btd.LZO.MvT);
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_PAT_SUFFIX_VERSION_INT_SYNC, Integer.valueOf(btd.LZO.MVK));
            Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.PatSuffixVersion:%d", Integer.valueOf(btd.LZO.MVK));
            if ((btd.LZO.NmH & 1099511627776L) == 0) {
                z = false;
            }
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_STATE_BOOLEAN_SYNC, Boolean.valueOf(z));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_FINDER_RANGE_INT_SYNC, Integer.valueOf(btd.LZO.NmN));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_BIZ_ACCT_RANGE_INT_SYNC, Integer.valueOf(btd.LZO.NmO));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_MINI_PROGRAM_RANGE_INT_SYNC, Integer.valueOf(btd.LZO.NmP));
            EventCenter.instance.publish(new yu());
            bf.iDu.aO("last_login_use_voice", new StringBuilder().append(btd.LZN.Mwm).toString());
            if (Build.VERSION.SDK_INT < 23) {
                Settings.System.putString(MMApplicationContext.getContext().getContentResolver(), "89884a87498ef44f", btd.LZO.NmF);
            }
            Log.i("MicroMsg.NetSceneGetProfile", "handling xagreement configs");
            if (!(btd.LZO == null || btd.LZO.NmQ == null)) {
                cr.z(btd.LZO.NmQ.NAz, btd.LZO.NmQ.NAA);
            }
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_ACCOUNT_SALT_STRING_SYNC, btd.LZO.NmR);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(134159);
    }
}

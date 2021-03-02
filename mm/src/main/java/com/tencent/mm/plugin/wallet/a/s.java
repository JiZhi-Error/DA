package com.tencent.mm.plugin.wallet.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.zm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.y.c;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.HashMap;
import java.util.Map;

public class s implements bd {
    private int HEY = 0;
    private r HEZ = new r();
    private ab HFa = new ab();
    private k HFb = new k();
    private MStorageEx.IOnStorageChange HFc = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.plugin.wallet.a.s.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(69189);
            if (Util.nullAsInt(obj, 0) == 339975) {
                g.aAi();
                int intValue = ((Integer) g.aAh().azQ().get(339975, (Object) 0)).intValue();
                if (intValue != s.this.HEY) {
                    ap.gni().reset();
                    s.this.HEY = intValue;
                }
                AppMethodBeat.o(69189);
                return;
            }
            if (ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC.equals(obj)) {
                g.aAi();
                int intValue2 = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
                if (intValue2 != s.this.efI) {
                    ap.gni().reset();
                    s.this.efI = intValue2;
                }
            }
            AppMethodBeat.o(69189);
        }
    };
    private d.a HFd = new d.a() {
        /* class com.tencent.mm.plugin.wallet.a.s.AnonymousClass2 */

        @Override // com.tencent.mm.wallet_core.d.a
        public final Intent q(int i2, Bundle bundle) {
            AppMethodBeat.i(69190);
            Log.i("MicroMsg.SubCoreMMWallet", "balance fetch process end");
            le leVar = new le();
            leVar.dQr.requestCode = 17;
            leVar.dQr.resultCode = -1;
            AppMethodBeat.o(69190);
            return null;
        }
    };
    private IListener HFe = new IListener<zm>() {
        /* class com.tencent.mm.plugin.wallet.a.s.AnonymousClass3 */

        {
            AppMethodBeat.i(160864);
            this.__eventId = zm.class.getName().hashCode();
            AppMethodBeat.o(160864);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zm zmVar) {
            AppMethodBeat.i(69191);
            Bundle bundle = new Bundle();
            bundle.putInt("key_balance_fetch_scene", 1);
            a.a((Activity) zmVar.efD.context, b.class, bundle, s.this.HFd);
            AppMethodBeat.o(69191);
            return false;
        }
    };
    private q HFf = new q() {
        /* class com.tencent.mm.plugin.wallet.a.s.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(69192);
            if ("paymsg".equals(str) && PayuSecureEncrypt.ENCRYPT_VERSION_HASH.equals(map.get(".sysmsg.paymsg.PayMsgType"))) {
                int i2 = Util.getInt(map.get(".sysmsg.paymsg.WalletRedDot"), 0);
                int i3 = Util.getInt(map.get(".sysmsg.paymsg.BankCardRedDot"), 0);
                String str2 = map.get(".sysmsg.paymsg.NewTagBankSerial");
                String str3 = map.get(".sysmsg.paymsg.WalletRedDotWording");
                Log.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", Integer.valueOf(i2), Integer.valueOf(i3), str2);
                if (i2 == 1) {
                    c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, true);
                } else {
                    c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, false);
                }
                if (i3 == 1) {
                    c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_WALLET_BANKCARD_STRING_SYNC, true);
                } else {
                    c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_WALLET_BANKCARD_STRING_SYNC, false);
                }
                if (!Util.isNullOrNil(str3)) {
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_MORE_TAB_REDDOT_WORDING_STRING_SYNC, str3);
                }
                if (!Util.isNullOrNil(str2)) {
                    g.aAi();
                    String str4 = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, "");
                    if (!Util.isNullOrNil(str4)) {
                        str2 = str4 + "," + str2;
                    }
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, str2);
                }
            }
            AppMethodBeat.o(69192);
        }
    };
    private l HFg = new l();
    private int efI = 0;

    static {
        AppMethodBeat.i(69200);
        a.j("ForgotPwdProcess", com.tencent.mm.plugin.wallet.pwd.a.class);
        a.j("BindCardProcess", com.tencent.mm.plugin.wallet_core.b.b.class);
        AppMethodBeat.o(69200);
    }

    public s() {
        AppMethodBeat.i(69193);
        o oVar = new o(com.tencent.mm.plugin.wallet_core.d.b.fSn());
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(69193);
    }

    public static s fOg() {
        AppMethodBeat.i(69194);
        s sVar = (s) y.at(s.class);
        AppMethodBeat.o(69194);
        return sVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(69195);
        g.aAi();
        this.HEY = ((Integer) g.aAh().azQ().get(339975, (Object) 0)).intValue();
        g.aAi();
        this.efI = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("paymsg", this.HFf);
        EventCenter.instance.addListener(this.HEZ);
        EventCenter.instance.addListener(this.HFa);
        EventCenter.instance.addListener(this.HFb);
        this.HFe.alive();
        this.HFg.alive();
        g.aAi();
        g.aAh().azQ().add(this.HFc);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE);
        AppMethodBeat.o(69195);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(69196);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("paymsg", this.HFf);
        EventCenter.instance.removeListener(this.HEZ);
        EventCenter.instance.removeListener(this.HFa);
        EventCenter.instance.removeListener(this.HFb);
        this.HFe.dead();
        this.HFg.dead();
        g.aAi();
        g.aAh().azQ().remove(this.HFc);
        AppMethodBeat.o(69196);
    }

    public static an fOh() {
        AppMethodBeat.i(69197);
        an fQI = t.fQI();
        AppMethodBeat.o(69197);
        return fQI;
    }

    public static String bbI() {
        AppMethodBeat.i(69198);
        g.aAi();
        String str = (String) g.aAh().azQ().get(6, (Object) null);
        String extractCountryCode = PhoneFormater.extractCountryCode(str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(69198);
            return "";
        }
        String substring = str.substring(extractCountryCode.length() + 1);
        AppMethodBeat.o(69198);
        return substring;
    }

    public static String fOi() {
        String extractCountryCode;
        AppMethodBeat.i(69199);
        g.aAi();
        String str = (String) g.aAh().azQ().get(6, (Object) null);
        if (Util.isNullOrNil(str)) {
            extractCountryCode = "";
        } else {
            extractCountryCode = PhoneFormater.extractCountryCode(str.replace("+", ""));
        }
        if (Util.isNullOrNil(extractCountryCode)) {
            if (z.aUo()) {
                extractCountryCode = "27";
            } else {
                extractCountryCode = "86";
            }
        }
        AppMethodBeat.o(69199);
        return extractCountryCode;
    }
}

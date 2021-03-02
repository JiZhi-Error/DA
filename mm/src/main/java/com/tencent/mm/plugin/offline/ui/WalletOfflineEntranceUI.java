package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.b.a.ks;
import com.tencent.mm.plugin.appbrand.jsapi.ca;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.tavkit.component.TAVExporter;

@a(7)
public class WalletOfflineEntranceUI extends WalletBaseUI {
    boolean AMV = true;
    private boolean AMW = false;
    private IListener<ip> AMX = new IListener<ip>() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160828);
            this.__eventId = ip.class.getName().hashCode();
            AppMethodBeat.o(160828);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ip ipVar) {
            AppMethodBeat.i(66539);
            ip ipVar2 = ipVar;
            Log.i("MicroMsg.WalletOfflineEntranceUI", "rcv fuck event: %s", ipVar2.dNj.dNk);
            Intent intent = new Intent();
            intent.putExtra("key_callback", ipVar2.dNj.dNk);
            WalletOfflineEntranceUI.this.setResult(-1, intent);
            WalletOfflineEntranceUI.this.finish();
            AppMethodBeat.o(66539);
            return false;
        }
    };
    private int mEntryScene = -1;
    private int mScene;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletOfflineEntranceUI() {
        AppMethodBeat.i(66540);
        AppMethodBeat.o(66540);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(66541);
        super.onCreate(bundle);
        if (26 != Build.VERSION.SDK_INT) {
            setRequestedOrientation(1);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } else if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        b.hhj().init(getApplicationContext());
        this.AMX.alive();
        eAg();
        SecDataUIC.a aVar = SecDataUIC.CWq;
        chc chc = (chc) SecDataUIC.a.b(this, 3, chc.class);
        if (chc != null && "launch_type_offline_wallet".equals(chc.Mmm)) {
            ks ksVar = new ks();
            ksVar.elF = 1;
            ksVar.eXj = 1;
            ksVar.bfK();
            com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
            com.tencent.mm.util.b.a(ksVar);
        }
        AppMethodBeat.o(66541);
    }

    private void eAg() {
        d dVar;
        AppMethodBeat.i(66542);
        Log.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
        k.aeJ(1);
        f.aqm(30);
        eAi();
        this.mScene = getIntent().getIntExtra("key_from_scene", 0);
        if (getIntent().getBooleanExtra("is_offline_create", false) || !(this.mScene == 6 || this.mScene == 7)) {
            init();
            this.AMV = false;
            AppMethodBeat.o(66542);
            return;
        }
        Log.i("MicroMsg.WalletOfflineEntranceUI", "from h5 or wxapp check sign: %s", Integer.valueOf(this.mScene));
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("appId");
        String stringExtra2 = intent.getStringExtra("timeStamp");
        String stringExtra3 = intent.getStringExtra("nonceStr");
        String stringExtra4 = intent.getStringExtra("packageExt");
        String stringExtra5 = intent.getStringExtra("signtype");
        String stringExtra6 = intent.getStringExtra("paySignature");
        int intExtra = intent.getIntExtra("pay_channel", 0);
        if (this.mScene == 6) {
            dVar = new d(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, intent.getStringExtra("url"), 16, ca.NAME, intExtra);
        } else {
            dVar = new d(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, 16, intent.getStringExtra("wxapp_username"), intent.getStringExtra("wxapp_path"), ca.NAME, intExtra);
        }
        addSceneEndListener(580);
        doSceneProgress(dVar, true);
        this.AMV = false;
        AppMethodBeat.o(66542);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(66543);
        super.onDestroy();
        this.AMX.dead();
        AppMethodBeat.o(66543);
    }

    private int eAh() {
        int i2 = 3;
        AppMethodBeat.i(66544);
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("key_from_scene")) {
            AppMethodBeat.o(66544);
            return 0;
        }
        int intExtra = intent.getIntExtra("key_from_scene", 0);
        if (intExtra == 1) {
            this.mEntryScene = 1;
            i2 = 2;
        } else if (intExtra == 2) {
            this.mEntryScene = 2;
            i2 = 1;
        } else if (intExtra == 3) {
            this.mEntryScene = 3;
        } else if (intExtra == 4) {
            this.mEntryScene = 4;
            i2 = 6;
        } else if (intExtra == 5) {
            this.mEntryScene = 8;
            i2 = 4;
        } else if (intExtra == 6) {
            this.mEntryScene = 10;
            i2 = 7;
        } else if (intExtra == 7) {
            this.mEntryScene = 11;
            i2 = 8;
        } else if (intExtra == 8) {
            this.mEntryScene = 12;
            i2 = 9;
        } else {
            this.mEntryScene = 0;
            Log.i("MicroMsg.WalletOfflineEntranceUI", "unknown scene: %d", Integer.valueOf(intExtra));
            i2 = 1;
        }
        h.INSTANCE.a(14021, 1, Integer.valueOf(i2));
        AppMethodBeat.o(66544);
        return i2;
    }

    private void init() {
        AppMethodBeat.i(66545);
        eAh();
        if (t.fQI().fRp() || t.fQI().Hwc == null) {
            Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
            doSceneProgress(new ad(null, 8), true);
            this.AMV = false;
            AppMethodBeat.o(66545);
            return;
        }
        if (this.mKindaEnable) {
            com.tencent.mm.wallet_core.b.hgC();
        }
        Intent intent = new Intent();
        intent.putExtra("key_entry_scene", this.mEntryScene);
        intent.putExtra("key_from_scene", this.mScene);
        String stringExtra = getIntent().getStringExtra("key_business_attach");
        if (!Util.isNullOrNil(stringExtra)) {
            intent.putExtra("key_business_attach", stringExtra);
        }
        intent.putExtra("is_offline_create", getIntent().getBooleanExtra("is_offline_create", false));
        intent.putExtra("key_appid", getIntent().getStringExtra("key_appid"));
        c.b(getContext(), "offline", ".ui.WalletOfflineCoinPurseUI", intent, 1);
        AppMethodBeat.o(66545);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(66546);
        super.onResume();
        Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
        if (this.AMV) {
            Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
            if (com.tencent.mm.plugin.offline.c.a.eAj()) {
                Log.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() true");
                Intent intent = new Intent();
                intent.putExtra("key_entry_scene", this.mEntryScene);
                intent.putExtra("key_from_scene", 0);
                AppMethodBeat.o(66546);
                return;
            }
            Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() false");
            AppMethodBeat.o(66546);
            return;
        }
        Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is false , not finish activity");
        this.AMV = true;
        AppMethodBeat.o(66546);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(66547);
        if (i2 == 1 && i3 == -1) {
            Log.i("MicroMsg.WalletOfflineEntranceUI", "do not finish");
        } else {
            finish();
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(66547);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(66548);
        if (qVar instanceof d) {
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
                e.bfP(((d) qVar).fPP());
                init();
                if (this.mScene == 6 || this.mScene == 7) {
                    Intent intent = new Intent();
                    if (this.AMW) {
                        intent.putExtra("key_callback", "return");
                    } else {
                        intent.putExtra("key_callback", "ok");
                    }
                    setResult(-1, intent);
                }
                AppMethodBeat.o(66548);
                return true;
            }
            Log.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (this.mScene == 6 || this.mScene == 7) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_callback", "fail");
                setResult(0, intent2);
            }
            finish();
            AppMethodBeat.o(66548);
            return true;
        } else if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
            init();
            AppMethodBeat.o(66548);
            return true;
        } else {
            Log.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", Integer.valueOf(i2), Integer.valueOf(i3));
            init();
            Log.e("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd FAIL");
            finish();
            AppMethodBeat.o(66548);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(66549);
        if (i2 == 4) {
            finish();
        }
        AppMethodBeat.o(66549);
        return true;
    }

    private void eAi() {
        AppMethodBeat.i(66550);
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("key_from_scene", 0);
            Log.i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is ".concat(String.valueOf(intExtra)));
            if (intExtra == 3) {
                com.tencent.mm.plugin.offline.c.a.ANf = intExtra;
                int intExtra2 = getIntent().getIntExtra("key_expire_time", 0);
                long longExtra = getIntent().getLongExtra("key_begin_time", 0);
                boolean booleanExtra = getIntent().getBooleanExtra("key_is_mark", false);
                Log.i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + intExtra2 + " beginTime:" + longExtra + " isMark:" + booleanExtra);
                com.tencent.mm.plugin.offline.c.a.ANg = intExtra2;
                com.tencent.mm.plugin.offline.c.a.ANh = longExtra;
                com.tencent.mm.plugin.offline.c.a.ANi = booleanExtra;
                com.tencent.mm.plugin.offline.c.a.pQH = getIntent().getStringExtra("key_card_id");
                com.tencent.mm.plugin.offline.c.a.ANj = getIntent().getStringExtra("key_user_card_id");
                com.tencent.mm.plugin.offline.c.a.ANk = getIntent().getStringExtra("key_card_code");
                AppMethodBeat.o(66550);
                return;
            } else if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
                com.tencent.mm.plugin.offline.c.a.ANf = intExtra;
                com.tencent.mm.plugin.offline.c.a.ANg = 0;
                com.tencent.mm.plugin.offline.c.a.ANh = 0;
                com.tencent.mm.plugin.offline.c.a.ANi = false;
                com.tencent.mm.plugin.offline.c.a.pQH = "";
                com.tencent.mm.plugin.offline.c.a.ANj = "";
                com.tencent.mm.plugin.offline.c.a.ANk = "";
            }
        }
        AppMethodBeat.o(66550);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(66551);
        Log.i("MicroMsg.WalletOfflineEntranceUI", "onNewIntent");
        if (intent == null || !intent.hasExtra("is_offline_create")) {
            this.AMV = false;
            this.AMW = true;
            setIntent(intent);
            eAg();
            AppMethodBeat.o(66551);
            return;
        }
        this.AMV = true;
        this.AMW = true;
        setIntent(intent);
        eAg();
        AppMethodBeat.o(66551);
    }
}

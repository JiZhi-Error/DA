package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_index.c.i;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class WalletSendC2CMsgUI extends WalletBaseUI {
    private Map<String, String> Iso = null;
    private int mScene;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71948);
        super.onCreate(bundle);
        setContentViewVisibility(8);
        this.mScene = getIntent().getIntExtra("key_scene", 0);
        Log.i("MicroMsg.WalletSendC2CMsgUI", "scene:" + this.mScene);
        if (this.mScene == 0) {
            addSceneEndListener(580);
            if (getIntent() == null) {
                Log.e("MicroMsg.WalletSendC2CMsgUI", "func[doCheckPayNetscene] intent null");
                setResult(-1000);
                finish();
                AppMethodBeat.o(71948);
                return;
            }
            doSceneForceProgress(new d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 6, "getSendC2CMessageRequest", getIntent().getIntExtra("pay_channel", 0)));
            AppMethodBeat.o(71948);
        } else if (!aWc(null)) {
            Log.d("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
            setResult(-1000);
            finish();
            AppMethodBeat.o(71948);
        } else {
            AppMethodBeat.o(71948);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(71949);
        super.onDestroy();
        removeSceneEndListener(580);
        AppMethodBeat.o(71949);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        boolean z = false;
        AppMethodBeat.i(71950);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof d) {
                Log.i("MicroMsg.WalletSendC2CMsgUI", "Check jsapi suc & Go Select Contact");
                e.bfP(((d) qVar).fPP());
                Log.i("MicroMsg.WalletSendC2CMsgUI", "doCallSelectConversationUI");
                Map<String, String> fUy = fUy();
                if (fUy != null && fUy.containsKey("togroup") && AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(fUy.get("togroup"))) {
                    z = true;
                }
                Intent intent = new Intent();
                if (z) {
                    i4 = 7;
                } else {
                    i4 = 3;
                }
                intent.putExtra("select_is_ret", true);
                intent.putExtra("Select_Conv_Type", i4);
                c.c(this, ".ui.transmit.SelectConversationUI", intent, 1);
                AppMethodBeat.o(71950);
                return true;
            } else if (qVar instanceof i) {
                Log.i("MicroMsg.WalletSendC2CMsgUI", "Send c2c msg suc");
                if (this.mScene == 1) {
                    h.cD(this, getString(R.string.isi));
                } else {
                    h.cD(this, getString(R.string.dzo));
                    setResult(-1);
                }
                finish();
                AppMethodBeat.o(71950);
                return true;
            }
        } else if (qVar instanceof d) {
            Log.e("MicroMsg.WalletSendC2CMsgUI", "Check jsapi fail");
            setResult(-1000);
            finish();
            AppMethodBeat.o(71950);
            return true;
        } else if (qVar instanceof i) {
            if (this.mScene == 1) {
                h.cD(this, str);
            } else {
                setResult(-1000);
            }
            finish();
            AppMethodBeat.o(71950);
            return true;
        } else {
            setResult(-1000);
            finish();
        }
        AppMethodBeat.o(71950);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(71951);
        super.onActivityResult(i2, i3, intent);
        if (intent != null) {
            Log.d("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i2 + ", resultCode = " + i3 + ", data = " + intent.toString());
        } else {
            Log.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i2 + ", resultCode = " + i3 + ", data = null");
        }
        if (i2 != 1) {
            Log.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i2)));
            AppMethodBeat.o(71951);
        } else if (i3 != -1 || intent == null) {
            Log.e("MicroMsg.WalletSendC2CMsgUI", "cancel select contact fail");
            setResult(0);
            finish();
            AppMethodBeat.o(71951);
        } else {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            Log.d("MicroMsg.WalletSendC2CMsgUI", "Select user , " + Util.nullAsNil(stringExtra));
            if (!aWc(stringExtra)) {
                Log.e("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
                setResult(-1000);
                finish();
                AppMethodBeat.o(71951);
                return;
            }
            AppMethodBeat.o(71951);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    private boolean aWc(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        AppMethodBeat.i(71952);
        if (this.mScene == 1) {
            String stringExtra = getIntent().getStringExtra("key_receiver");
            str6 = getIntent().getStringExtra("key_sender_des");
            str5 = getIntent().getStringExtra("key_receiver_des");
            str4 = URLEncoder.encode(getIntent().getStringExtra("key_url"));
            String stringExtra2 = getIntent().getStringExtra("key_templateid");
            str2 = getIntent().getStringExtra("key_sceneid");
            str8 = getIntent().getStringExtra("key_receivertitle");
            str7 = getIntent().getStringExtra("key_sendertitle");
            str3 = stringExtra2;
            str9 = stringExtra;
        } else {
            Map<String, String> fUy = fUy();
            if (fUy == null || Util.isNullOrNil(str)) {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
                str8 = null;
                str9 = str;
            } else {
                str8 = URLDecoder.decode(Util.nullAsNil(fUy.get("receivertitle")));
                str7 = URLDecoder.decode(Util.nullAsNil(fUy.get("sendertitle")));
                str6 = URLDecoder.decode(Util.nullAsNil(fUy.get("senderdes")));
                str5 = URLDecoder.decode(Util.nullAsNil(fUy.get("receiverdes")));
                str4 = Util.nullAsNil(fUy.get("url"));
                str3 = URLDecoder.decode(Util.nullAsNil(fUy.get("templateid")));
                str2 = URLDecoder.decode(Util.nullAsNil(fUy.get("senceid")));
                str9 = str;
            }
        }
        if (Util.isNullOrNil(str4) || Util.isNullOrNil(str3)) {
            Log.w("MicroMsg.WalletSendC2CMsgUI", "url = " + Util.isNullOrNil(str4) + "templateId=" + Util.isNullOrNil(str3));
            AppMethodBeat.o(71952);
            return false;
        }
        Log.d("MicroMsg.WalletSendC2CMsgUI", "send c2c msg to".concat(String.valueOf(str9)));
        doSceneProgress(new i(str9, str8, str7, str3, str6, str5, str4, str2));
        AppMethodBeat.o(71952);
        return true;
    }

    private Map<String, String> fUy() {
        AppMethodBeat.i(71953);
        if (this.Iso == null) {
            String stringExtra = getIntent().getStringExtra("packageExt");
            Log.d("MicroMsg.WalletSendC2CMsgUI", "func[getPackageData] packageExt: ".concat(String.valueOf(stringExtra)));
            if (!Util.isNullOrNil(stringExtra)) {
                String[] split = stringExtra.split("&");
                this.Iso = new HashMap();
                if (split != null && split.length > 0) {
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (!Util.isNullOrNil(split[i2])) {
                            String[] split2 = split[i2].split("=");
                            if (split2.length == 2 && !Util.isNullOrNil(split2[0])) {
                                this.Iso.put(split2[0], split2[1]);
                            }
                        }
                    }
                }
            }
        }
        Map<String, String> map = this.Iso;
        AppMethodBeat.o(71953);
        return map;
    }
}

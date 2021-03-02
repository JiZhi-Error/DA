package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.plugin.card.d.h;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
public class CardAddEntranceUI extends MMActivity {
    private String appId;
    private int eaQ = 8;
    LinkedList<um> pYH = new LinkedList<>();
    private String pYS = "";
    private String pYT;
    private int pYU = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardAddEntranceUI() {
        AppMethodBeat.i(113180);
        AppMethodBeat.o(113180);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.m5;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113181);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            Log.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onCreate() intent == null");
            setResult(0);
            finish();
            AppMethodBeat.o(113181);
            return;
        }
        Log.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI doRediect() handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.eaQ = intent.getIntExtra("key_from_scene", 8);
        this.pYU = intent.getIntExtra("key_stastic_scene", 0);
        Log.i("MicroMsg.CardAddEntranceUI", "doRediect() from_scene:" + this.eaQ + "  from_origin_scene:" + this.pYU);
        this.pYS = intent.getStringExtra("key_package_name");
        String stringExtra2 = intent.getStringExtra("key_sign");
        String stringExtra3 = getIntent().getStringExtra("src_username");
        Log.i("MicroMsg.CardAddEntranceUI", "doRediect() src_username:".concat(String.valueOf(stringExtra3)));
        String stringExtra4 = getIntent().getStringExtra("js_url");
        this.appId = getIntent().getStringExtra("key_app_id");
        this.pYT = getIntent().getStringExtra("key_transaction");
        String stringExtra5 = getIntent().getStringExtra("key_consumed_card_id");
        Log.i("MicroMsg.CardAddEntranceUI", "doRediect() consumedCardId:".concat(String.valueOf(stringExtra5)));
        String stringExtra6 = getIntent().getStringExtra("key_template_id");
        ArrayList<um> cR = h.cR(stringExtra, this.eaQ);
        if (cR == null || cR.size() == 0) {
            Log.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI initView () tempList == null || tempList.size() == 0");
            setResult(0);
            finish();
            AppMethodBeat.o(113181);
            return;
        }
        this.pYH.clear();
        this.pYH.addAll(cR);
        Intent intent2 = new Intent();
        intent2.putExtra("key_from_scene", this.eaQ);
        intent2.putExtra("key_stastic_scene", this.pYU);
        if (cR.size() == 1) {
            um umVar = cR.get(0);
            intent2.putExtra("key_card_id", umVar.pRX);
            intent2.putExtra("key_card_ext", umVar.eaP);
            intent2.putExtra("src_username", stringExtra3);
            intent2.putExtra("js_url", stringExtra4);
            intent2.putExtra("key_consumed_card_id", stringExtra5);
            intent2.putExtra("key_template_id", stringExtra6);
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardDetailUI.class);
            startActivityForResult(intent2, 1);
            AppMethodBeat.o(113181);
            return;
        }
        intent2.putExtra("key_in_card_list", stringExtra);
        intent2.putExtra("key_package_name", this.pYS);
        intent2.putExtra("key_sign", stringExtra2);
        intent2.putExtra("src_username", stringExtra3);
        intent2.putExtra("js_url", stringExtra4);
        intent2.putExtra("key_consumed_card_id", stringExtra5);
        intent2.putExtra("key_template_id", stringExtra6);
        intent2.setClass(this, CardAcceptCardListUI.class);
        startActivityForResult(intent2, 2);
        AppMethodBeat.o(113181);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113182);
        super.onDestroy();
        AppMethodBeat.o(113182);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(113183);
        Log.v("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onActivityResult");
        if (i3 == -1) {
            Log.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_OK");
        } else {
            Log.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_CANCELED");
        }
        LinkedList linkedList = new LinkedList();
        Iterator<um> it = this.pYH.iterator();
        while (it.hasNext()) {
            um next = it.next();
            e eVar = new e();
            eVar.pRX = next.pRX;
            eVar.eaP = next.eaP;
            linkedList.add(eVar);
        }
        if (i2 != 1) {
            if (i2 == 2) {
                Log.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_ACCEPT_CARD_LIST");
                String str = "";
                if (intent != null) {
                    str = intent.getStringExtra("card_list");
                }
                if (this.eaQ != 7 && this.eaQ != 16) {
                    if (this.eaQ != 26) {
                        switch (i3) {
                            case -1:
                                if (TextUtils.isEmpty(str)) {
                                    aN(-1, h.a(linkedList, true, this.eaQ));
                                    break;
                                } else {
                                    aN(-1, str);
                                    break;
                                }
                            case 0:
                                if (TextUtils.isEmpty(str)) {
                                    aN(0, h.a(linkedList, false, this.eaQ));
                                    break;
                                } else {
                                    aN(0, str);
                                    break;
                                }
                        }
                    } else {
                        Intent intent2 = new Intent();
                        switch (i3) {
                            case -1:
                                if (intent != null && !TextUtils.isEmpty(str)) {
                                    intent.putExtra("card_list", h.cS(str, this.eaQ));
                                    setResult(-1, intent);
                                    break;
                                } else {
                                    intent2.putExtra("card_list", h.a(linkedList, true, this.eaQ));
                                    setResult(-1, intent2);
                                    break;
                                }
                            case 0:
                                if (intent != null && !TextUtils.isEmpty(str)) {
                                    intent.putExtra("card_list", h.cS(str, this.eaQ));
                                    setResult(0, intent);
                                    break;
                                } else {
                                    intent2.putExtra("card_list", h.a(linkedList, false, this.eaQ));
                                    intent2.putExtra("result_code", 1);
                                    setResult(0, intent2);
                                    break;
                                }
                                break;
                        }
                    }
                } else {
                    Intent intent3 = new Intent();
                    switch (i3) {
                        case -1:
                            if (intent != null && !TextUtils.isEmpty(str)) {
                                intent.putExtra("card_list", h.cS(str, this.eaQ));
                                setResult(-1, intent);
                                break;
                            } else {
                                intent3.putExtra("card_list", h.a(linkedList, true, this.eaQ));
                                setResult(-1, intent3);
                                break;
                            }
                            break;
                        case 0:
                            if (intent != null && !TextUtils.isEmpty(str)) {
                                intent.putExtra("card_list", h.cS(str, this.eaQ));
                                setResult(0, intent);
                                break;
                            } else {
                                intent3.putExtra("card_list", h.a(linkedList, false, this.eaQ));
                                intent3.putExtra("result_code", 1);
                                setResult(0, intent3);
                                break;
                            }
                    }
                }
            }
        } else {
            Log.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_DETAIL");
            if (this.eaQ != 7 && this.eaQ != 16) {
                if (this.eaQ != 26) {
                    switch (i3) {
                        case -1:
                            if (intent != null && linkedList.size() > 0) {
                                ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                            }
                            aN(-1, h.a(linkedList, true, this.eaQ));
                            break;
                        case 0:
                            aN(0, h.a(linkedList, false, this.eaQ));
                            break;
                    }
                } else {
                    Intent intent4 = new Intent();
                    switch (i3) {
                        case -1:
                            if (intent != null && linkedList.size() > 0) {
                                ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                            }
                            intent4.putExtra("card_list", h.a(linkedList, true, this.eaQ));
                            setResult(-1, intent4);
                            break;
                        case 0:
                            intent4.putExtra("card_list", h.a(linkedList, false, this.eaQ));
                            setResult(0, intent4);
                            break;
                    }
                }
            } else {
                Intent intent5 = new Intent();
                switch (i3) {
                    case -1:
                        if (intent != null && linkedList.size() > 0) {
                            ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                        }
                        intent5.putExtra("card_list", h.a(linkedList, true, this.eaQ));
                        setResult(-1, intent5);
                        break;
                    case 0:
                        intent5.putExtra("card_list", h.a(linkedList, false, this.eaQ));
                        setResult(0, intent5);
                        break;
                }
            }
        }
        finish();
        AppMethodBeat.o(113183);
    }

    private void aN(int i2, String str) {
        AppMethodBeat.i(113184);
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_add_card_to_wx_card_list", str);
        g o = com.tencent.mm.pluginsdk.model.app.h.o(this.appId, true, false);
        AddCardToWXCardPackage.Resp resp = new AddCardToWXCardPackage.Resp(bundle);
        if (o != null) {
            resp.openId = o.field_openId;
        }
        resp.transaction = this.pYT;
        Object[] objArr = new Object[4];
        objArr[0] = this.appId;
        objArr[1] = o == null ? "null appinfo" : o.field_appName;
        objArr[2] = o == null ? "null appinfo" : o.field_openId;
        objArr[3] = this.pYT;
        Log.i("MicroMsg.CardAddEntranceUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", objArr);
        resp.toBundle(bundle);
        Log.i("MicroMsg.CardAddEntranceUI", "setResultToSDK result:".concat(String.valueOf(i2)));
        if (i2 == -1) {
            resp.errCode = 0;
        } else {
            resp.errCode = -2;
        }
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.targetPkgName = this.pYS;
        args.bundle = bundle;
        q.bo(bundle);
        q.bp(bundle);
        MMessageActV2.send(MMApplicationContext.getContext(), args);
        AppMethodBeat.o(113184);
    }
}

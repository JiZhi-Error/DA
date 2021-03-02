package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.zm;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ai;
import com.tencent.mm.plugin.wallet.balance.model.lqt.o;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@a(7)
public class WalletOpenViewProxyUI extends WalletBaseUI {
    private com.tencent.mm.plugin.wallet.balance.ui.lqt.a Iqy;
    private Map<String, String> Ism = new HashMap();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletOpenViewProxyUI() {
        AppMethodBeat.i(71942);
        AppMethodBeat.o(71942);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        String[] split;
        AppMethodBeat.i(71943);
        super.onCreate(bundle);
        setContentViewVisibility(8);
        this.Iqy = new com.tencent.mm.plugin.wallet.balance.ui.lqt.a(this);
        String stringExtra = getIntent().getStringExtra("packageExt");
        this.Ism = new HashMap();
        if (!Util.isNullOrNil(stringExtra) && (split = stringExtra.split("&")) != null && split.length > 0) {
            for (int i2 = 0; i2 < split.length; i2++) {
                if (!Util.isNullOrNil(split[i2])) {
                    String[] split2 = split[i2].split("=");
                    if (split2.length == 2 && !Util.isNullOrNil(split2[0])) {
                        this.Ism.put(split2[0], split2[1]);
                    }
                }
            }
        }
        String str = this.Ism.get("trace_info");
        if (!Util.isNullOrNil(str)) {
            ag.aUH(str);
        }
        addSceneEndListener(2996);
        addSceneEndListener(580);
        addSceneEndListener(385);
        if (getIntent() == null) {
            Log.d("MicroMsg.WalletOpenViewProxyUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            AppMethodBeat.o(71943);
            return;
        }
        String str2 = this.Ism.get("openview");
        String stringExtra2 = getIntent().getStringExtra("appId");
        String stringExtra3 = getIntent().getStringExtra("timeStamp");
        String stringExtra4 = getIntent().getStringExtra("nonceStr");
        String stringExtra5 = getIntent().getStringExtra("packageExt");
        String stringExtra6 = getIntent().getStringExtra("paySignature");
        if ("open_wcpay_f2f_receive_detail".equals(str2)) {
            doSceneForceProgress(new z(stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6));
            AppMethodBeat.o(71943);
        } else if ("open_wcpay_grouppay_detail".equals(str2) || "open_wcpay_hk_f2f".equals(str2)) {
            aWb(stringExtra5);
            AppMethodBeat.o(71943);
        } else if ("open_wcpay_lqt_detail".equals(str2)) {
            Log.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui");
            if (this.Ism != null) {
                new Intent().putExtra("key_account_type", 1);
                String str3 = this.Ism.get("ecardtype");
                String str4 = this.Ism.get("extradata");
                String str5 = this.Ism.get("need_open_lqb");
                Log.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui, ecardtype: %s, extradata: %s, need_open_lqb: %s", str3, str4, str5);
                if (Util.getInt(str5, 0) == 1) {
                    if (Util.isNullOrNil(str3)) {
                        str3 = "WEB_DEBIT";
                    }
                    doSceneForceProgress(new ai(str3, str4));
                } else {
                    int i3 = Util.getInt(this.Ism.get("auto_jump_charge_setting"), 0);
                    int i4 = Util.getInt(this.Ism.get("show_open_toast"), 0);
                    Intent intent = new Intent();
                    if (i3 == 1) {
                        intent.putExtra("show_open_toast", i4);
                        c.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtBalanceAutoTransferUI", intent);
                    } else {
                        c.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent);
                    }
                    setResult(-1);
                    finish();
                }
            } else {
                c.V(getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                setResult(-1);
                finish();
            }
            h.INSTANCE.idkeyStat(663, 18, 1, false);
            AppMethodBeat.o(71943);
        } else if ("redenvelopes_getshowresouces_and_move_to_root".equals(str2)) {
            Log.i("MicroMsg.WalletOpenViewProxyUI", "receive envelope");
            ((com.tencent.mm.plugin.luckymoney.a.a) g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).W(true, true);
            setResult(-1);
            finish();
            AppMethodBeat.o(71943);
        } else {
            doSceneForceProgress(new d(stringExtra2, stringExtra3, stringExtra4, stringExtra5, getIntent().getStringExtra("signtype"), stringExtra6, getIntent().getStringExtra("url"), 4, "openWCPaySpecificView", getIntent().getIntExtra("pay_channel", 0)));
            AppMethodBeat.o(71943);
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71944);
        Log.i("MicroMsg.WalletOpenViewProxyUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
        if (i2 != 0 || i3 != 0) {
            setResult(0);
            finish();
            AppMethodBeat.o(71944);
            return true;
        } else if (qVar instanceof d) {
            e.bfP(((d) qVar).fPP());
            aWb(getIntent().getStringExtra("packageExt"));
            AppMethodBeat.o(71944);
            return true;
        } else if (qVar instanceof z) {
            aWb(getIntent().getStringExtra("packageExt"));
            AppMethodBeat.o(71944);
            return true;
        } else if (qVar instanceof ai) {
            cww cww = ((ai) qVar).HuV;
            Log.i("MicroMsg.WalletOpenViewProxyUI", "on open lqb account scene end, retcode: %s, regmsg: %s", Integer.valueOf(cww.pTZ), cww.pUa);
            if (cww.efB != null) {
                this.Iqy.a(cww.efB, null);
            }
            if (cww.pTZ == 0) {
                Intent intent = new Intent();
                intent.putExtra("key_account_type", 2);
                c.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent);
                setResult(-1);
            } else if (cww.efB == null) {
                Toast.makeText(this, cww.pUa, 1).show();
                setResult(0);
            }
            finish();
            AppMethodBeat.o(71944);
            return true;
        } else {
            AppMethodBeat.o(71944);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(71945);
        super.onDestroy();
        removeSceneEndListener(580);
        removeSceneEndListener(385);
        removeSceneEndListener(2996);
        AppMethodBeat.o(71945);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    private void aWb(String str) {
        boolean z;
        AppMethodBeat.i(71946);
        if (!Util.isNullOrNil(str)) {
            String str2 = this.Ism.get("openview");
            if ("open_wcpay_biz_view".equals(str2)) {
                Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_index_ui");
                f.iF(getContext());
                z = true;
            } else if ("open_wcpay_balance_view".equals(str2)) {
                Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open wallet_balance_manager_ui");
                f.aF(getContext(), 0);
                z = true;
            } else if ("open_wcpay_order_detail_view".equals(str2)) {
                Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_order_transaction_info_ui");
                Intent intent = new Intent();
                intent.putExtra("trans_id", this.Ism.get("trans_id"));
                intent.putExtra("scene", 1);
                if (this.Ism.containsKey("bill_id")) {
                    intent.putExtra("bill_id", this.Ism.get("bill_id"));
                }
                c.b(getContext(), "order", ".ui.MallOrderTransactionInfoUI", intent);
                z = true;
            } else if ("open_wcpay_f2f_receive_detail".equals(str2)) {
                Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_f2f_receive_detail");
                Intent intent2 = new Intent();
                intent2.putExtra("key_timestamp", Util.getLong(this.Ism.get("fromtimestamp"), 0));
                intent2.putExtra("key_from_scene", 1);
                c.b(getContext(), "collect", ".ui.CollectBillUI", intent2);
                h.INSTANCE.a(13944, 2);
                z = true;
            } else if ("open_wcpay_grouppay_detail".equals(str2)) {
                Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_grouppay_detail");
                Intent intent3 = new Intent();
                intent3.putExtra("bill_no", this.Ism.get("billno"));
                intent3.putExtra("chatroom", this.Ism.get("groupid"));
                intent3.putExtra("key_sign", this.Ism.get("sign"));
                intent3.putExtra("key_ver", this.Ism.get("ver"));
                intent3.putExtra("enter_scene", 5);
                c.b(getContext(), "aa", ".ui.PaylistAAUI", intent3);
                z = true;
            } else if ("open_wcpay_t2bc_detail".equals(str2)) {
                Log.d("MicroMsg.WalletOpenViewProxyUI", "do open_wcpay_t2bc_detail");
                Intent intent4 = new Intent();
                intent4.putExtra("key_transfer_bill_id", this.Ism.get("transfer_bill_id"));
                intent4.putExtra("key_enter_scene", 1);
                c.b(getContext(), "remittance", ".bankcard.ui.BankRemitDetailUI", intent4);
                z = true;
            } else if ("open_honey_pay_home".equals(str2)) {
                Log.d("MicroMsg.WalletOpenViewProxyUI", "do open honey pay view");
                c.b(getContext(), "honey_pay", ".ui.HoneyPayMainUI", new Intent());
                z = true;
            } else if ("open_wcpay_t2bc_view".equals(str2)) {
                Log.d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_T2BC_UI");
                c.b(getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI", new Intent());
                z = true;
            } else if ("open_wcpay_fetch_balance_view".equals(str2)) {
                Log.d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_FETCH_BALANCE_UI");
                zm zmVar = new zm();
                zmVar.efD.context = getContext();
                EventCenter.instance.publish(zmVar);
                z = true;
            } else if ("open_wcpay_wallet_lock_view".equals(str2)) {
                Intent intent5 = new Intent();
                intent5.putExtra("wallet_lock_jsapi_scene", this.Ism.get("entry_scene"));
                ((b) g.af(b.class)).j(this, intent5);
                z = true;
            } else if ("open_wcpay_security_setting_view".equals(str2)) {
                Intent intent6 = new Intent();
                intent6.putExtra("wallet_lock_jsapi_scene", this.Ism.get("entry_scene"));
                c.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent6);
                z = true;
            } else {
                if ("open_wcpay_c2c_message_view".equals(str2)) {
                    if (this.Ism != null) {
                        int i2 = Util.getInt(this.Ism.get("bizType"), -1);
                        if (i2 == 1) {
                            String str3 = this.Ism.get("bizId");
                            String str4 = this.Ism.get(ch.COL_USERNAME);
                            long j2 = Util.getLong(this.Ism.get("createTime"), -1);
                            Log.i("MicroMsg.WalletOpenViewProxyUI", "view open c2c message view, bizType: %s, bizId: %s, username: %s, createTime: %s", Integer.valueOf(i2), str3, str4, Long.valueOf(j2));
                            ld ldVar = new ld();
                            ldVar.dQo.dQp = str3;
                            ldVar.dQo.username = str4;
                            ldVar.dQo.dQq = Long.valueOf(j2);
                            EventCenter.instance.publish(ldVar);
                        }
                        z = true;
                    }
                } else if ("open_lqt_auto_planindex_view".equals(str2)) {
                    c.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtPlanBeforeHomeUI", new Intent());
                    z = true;
                } else if ("open_wcpay_hk_f2f".equals(str2)) {
                    Intent intent7 = new Intent();
                    intent7.putExtra("key_from_scene", 1);
                    c.b(getContext(), "collect", ".ui.CollectHKMainUI", intent7);
                    z = true;
                } else if ("open_lqt_auto_planadd_view".equals(str2)) {
                    Intent intent8 = new Intent(this, WalletLqtPlanAddUI.class);
                    intent8.putExtra("key_mode", 1);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/wallet_index/ui/WalletOpenViewProxyUI", "handleOpenView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_index/ui/WalletOpenViewProxyUI", "handleOpenView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    z = true;
                } else if ("open_wcpay_lqt_save".equals(str2)) {
                    ag.aUH(this.Ism.get("trace_info"));
                    final String str5 = this.Ism.get("operate_id");
                    final Dialog c2 = com.tencent.mm.wallet_core.ui.h.c(getContext(), false, null);
                    new o().aYI().b(new com.tencent.mm.vending.c.a<Void, c.a<dhn>>() {
                        /* class com.tencent.mm.plugin.wallet_index.ui.WalletOpenViewProxyUI.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(c.a<dhn> aVar) {
                            boolean z;
                            boolean z2 = true;
                            AppMethodBeat.i(71941);
                            c.a<dhn> aVar2 = aVar;
                            Log.i("MicroMsg.WalletOpenViewProxyUI", "on qryusrfunddetail finish, errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                            if (WalletOpenViewProxyUI.this.isFinishing() || WalletOpenViewProxyUI.this.isDestroyed()) {
                                Void r0 = QZL;
                                AppMethodBeat.o(71941);
                                return r0;
                            }
                            c2.dismiss();
                            if (aVar2.errType == 0 && aVar2.errCode == 0) {
                                dhn dhn = (dhn) aVar2.iLC;
                                Log.i("MicroMsg.WalletOpenViewProxyUI", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", Integer.valueOf(dhn.pTZ), dhn.pUa);
                                if (dhn.pTZ == 0) {
                                    ag.aUH(dhn.HuS);
                                    ArrayList<String> arrayList = new ArrayList<>();
                                    if (dhn.MLV != null && dhn.MLV.size() > 0) {
                                        Iterator<ahq> it = dhn.MLV.iterator();
                                        while (it.hasNext()) {
                                            ahq next = it.next();
                                            if (!Util.isNullOrNil(next.title) && !Util.isNullOrNil(next.yUB)) {
                                                arrayList.add(String.format("%s||%s", next.title, next.yUB));
                                            }
                                        }
                                    }
                                    ((w) new com.tencent.mm.vending.app.c().a(WalletOpenViewProxyUI.this.getContext(), w.class)).HtX.jP(dhn.yba, Util.safeParseInt((String) WalletOpenViewProxyUI.this.Ism.get("entry_scene")));
                                    Intent intent = new Intent(WalletOpenViewProxyUI.this.getContext(), WalletLqtSaveFetchUI.class);
                                    intent.putExtra("lqt_save_fund_code", dhn != null ? dhn.Mnl : null);
                                    intent.putExtra("lqt_save_fetch_mode", 1);
                                    if (dhn.egj == 1) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    intent.putExtra("lqt_is_show_protocol", z);
                                    if (dhn.MLU != 1) {
                                        z2 = false;
                                    }
                                    intent.putExtra("lqt_is_agree_protocol", z2);
                                    intent.putStringArrayListExtra("lqt_protocol_list", arrayList);
                                    intent.putExtra("lqt_profile_wording", dhn.MLJ);
                                    intent.putExtra("lqt_account_type", dhn.yba);
                                    intent.putExtra("lqt_fund_spid", dhn.Mnk);
                                    intent.putExtra("operate_id", str5);
                                    WalletOpenViewProxyUI walletOpenViewProxyUI = WalletOpenViewProxyUI.this;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(walletOpenViewProxyUI, bl.axQ(), "com/tencent/mm/plugin/wallet_index/ui/WalletOpenViewProxyUI$1", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    walletOpenViewProxyUI.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(walletOpenViewProxyUI, "com/tencent/mm/plugin/wallet_index/ui/WalletOpenViewProxyUI$1", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                }
                            }
                            WalletOpenViewProxyUI.this.finish();
                            Void r02 = QZL;
                            AppMethodBeat.o(71941);
                            return r02;
                        }
                    });
                    z = false;
                } else if ("open_wcpay_grouppay_introview".equals(str2)) {
                    String str6 = this.Ism.get("amount");
                    String str7 = this.Ism.get("title");
                    Intent intent9 = new Intent();
                    intent9.putExtra("amount", str6);
                    if (!Util.isNullOrNil(str7)) {
                        str7 = URLDecoder.decode(str7);
                        intent9.putExtra("title", str7);
                    }
                    intent9.putExtra("enter_scene", 5);
                    Log.i("MicroMsg.WalletOpenViewProxyUI", "view open grouppay, amount: %s, title: %s", str6, str7);
                    com.tencent.mm.br.c.b(this, "aa", ".ui.AAEntranceUI", intent9);
                    z = true;
                } else {
                    Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] invalid target view : ".concat(String.valueOf(str2)));
                }
                z = true;
            }
        } else {
            Log.w("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] packageExt null or nil");
            z = true;
        }
        Intent intent10 = new Intent();
        intent10.putExtra("closeWebView", this.Ism.get("closeWebView"));
        setResult(-1, intent10);
        if (z) {
            finish();
        }
        AppMethodBeat.o(71946);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(71947);
        if (i2 == 563) {
            if (i3 == -1) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                Log.i("MicroMsg.WalletOpenViewProxyUI", "select chatroom：%s", stringExtra);
                String str = this.Ism.get("amount");
                String str2 = this.Ism.get("title");
                Intent intent2 = new Intent();
                intent2.putExtra("amount", str);
                if (!Util.isNullOrNil(str2)) {
                    str2 = URLDecoder.decode(str2);
                    intent2.putExtra("title", str2);
                }
                if (!Util.isNullOrNil(stringExtra)) {
                    intent2.putExtra("chatroom_name", stringExtra);
                }
                intent2.putExtra("enter_scene", 5);
                com.tencent.mm.br.c.b(getContext(), "aa", ".ui.LaunchAAUI", intent2);
                Log.i("MicroMsg.WalletOpenViewProxyUI", "view open grouppay, amount: %s, title: %s", str, str2);
            }
            finish();
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(71947);
    }
}

package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aah;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.id_verify.model.j;
import com.tencent.mm.plugin.wallet_core.id_verify.model.k;
import com.tencent.mm.plugin.wallet_core.id_verify.model.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;

public class a extends com.tencent.mm.plugin.wallet_core.b.b {
    private IListener<lj> AJa = new IListener<lj>() {
        /* class com.tencent.mm.plugin.wallet_core.id_verify.a.AnonymousClass6 */

        {
            AppMethodBeat.i(160872);
            this.__eventId = lj.class.getName().hashCode();
            AppMethodBeat.o(160872);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lj ljVar) {
            AppMethodBeat.i(69998);
            lj ljVar2 = ljVar;
            Log.i("MicroMsg.RealNameVerifyProcess", "KindaBindCardEvent callback");
            if (ljVar2 == null || !(ljVar2 instanceof lj)) {
                AppMethodBeat.o(69998);
                return false;
            }
            z.hhs();
            if (ljVar2.dQz != null) {
                if (ljVar2.dQz.dQA) {
                    Log.i("MicroMsg.RealNameVerifyProcess", "KindaBindCardEvent bindCard Succ");
                    Activity crossActivity = ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).getCrossActivity();
                    if (crossActivity != null) {
                        Bundle bundle = a.this.dQL;
                        bundle.putInt("realname_verify_process_ret", -1);
                        bundle.putString("realname_verify_process_finish_title", ljVar2.dQz.dQE);
                        bundle.putString("realname_verify_process_finish_desc", ljVar2.dQz.dQF);
                        bundle.putString("realname_verify_process_finish_page", ljVar2.dQz.dQG);
                        bundle.putInt("realname_verify_process_finish_err_jump", Util.safeParseInt(ljVar2.dQz.dQH));
                        a.this.b(crossActivity, WcPayRealnameVerifySuccessUI.class, a.this.dQL);
                    }
                } else {
                    Log.i("MicroMsg.RealNameVerifyProcess", "KindaBindCardEvent bindCard Cancel");
                }
            }
            EventCenter.instance.removeListener(a.this.AJa);
            AppMethodBeat.o(69998);
            return true;
        }
    };
    private boolean HQM = false;
    private int HQN = -1;
    public AbstractC1914a HQO;
    private boolean idt = false;
    private String mActivityName = null;
    private int mMode;
    private String mPluginName = null;
    private int resultCode = 0;

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.a$a  reason: collision with other inner class name */
    public interface AbstractC1914a {
        void run(Activity activity);
    }

    public a() {
        AppMethodBeat.i(69999);
        AppMethodBeat.o(69999);
    }

    static /* synthetic */ int F(a aVar) {
        AppMethodBeat.i(214164);
        int fPO = aVar.fPO();
        AppMethodBeat.o(214164);
        return fPO;
    }

    static /* synthetic */ boolean P(a aVar) {
        AppMethodBeat.i(214166);
        boolean fPV = aVar.fPV();
        AppMethodBeat.o(214166);
        return fPV;
    }

    static /* synthetic */ void a(a aVar, Activity activity, Class cls, int i2, Intent intent, boolean z) {
        AppMethodBeat.i(214163);
        aVar.a(activity, cls, i2, intent, z);
        AppMethodBeat.o(214163);
    }

    static /* synthetic */ void a(a aVar, Activity activity, String str, String str2, int i2, Intent intent, boolean z) {
        AppMethodBeat.i(70007);
        aVar.a(activity, str, str2, i2, intent, z);
        AppMethodBeat.o(70007);
    }

    static /* synthetic */ void a(a aVar, i iVar) {
        AppMethodBeat.i(174441);
        aVar.a(iVar);
        AppMethodBeat.o(174441);
    }

    static /* synthetic */ void b(a aVar, Activity activity, String str, String str2, int i2, Intent intent, boolean z) {
        AppMethodBeat.i(70009);
        aVar.a(activity, str, str2, i2, intent, z);
        AppMethodBeat.o(70009);
    }

    static /* synthetic */ void b(a aVar, i iVar) {
        AppMethodBeat.i(174442);
        aVar.a(iVar);
        AppMethodBeat.o(174442);
    }

    static /* synthetic */ void c(a aVar, i iVar) {
        AppMethodBeat.i(214165);
        aVar.a(iVar);
        AppMethodBeat.o(214165);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(70000);
        K("start", activity, bundle);
        if (this.dQL == null) {
            this.dQL = new Bundle();
        }
        b(activity, WcPayRealnameProxyUI.class, bundle);
        AppMethodBeat.o(70000);
        return this;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(70001);
        K("back", activity, Integer.valueOf(i2));
        z.hhs();
        if ((activity instanceof SwitchRealnameVerifyModeUI) || (activity instanceof WcPayRealnameVerifyMainUI)) {
            if (i2 == 0) {
                b(activity, this.dQL);
                AppMethodBeat.o(70001);
                return;
            }
        } else if ((activity instanceof WalletRealNameVerifyUI) || (activity instanceof WalletBankcardIdUI)) {
            if (this.HQN != 0) {
                b(activity, this.dQL);
                AppMethodBeat.o(70001);
                return;
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, this.dQL);
            AppMethodBeat.o(70001);
            return;
        } else if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i2);
            AppMethodBeat.o(70001);
            return;
        } else if (activity instanceof WcPayRealnameVerifySuccessUI) {
            a(activity, WcPayRealnameVerifyIdInputUI.class, i2);
            AppMethodBeat.o(70001);
            return;
        } else if (activity instanceof WcPayRealnameVerifyCodeUI) {
            a(activity, WcPayRealnameVerifyBindcardEntranceUI.class, i2);
        }
        AppMethodBeat.o(70001);
    }

    private boolean fPV() {
        AppMethodBeat.i(70002);
        boolean equals = "rename".equals(this.dQL.getString("key_realname_scene"));
        AppMethodBeat.o(70002);
        return equals;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        boolean z;
        AppMethodBeat.i(70003);
        K("forward", activity, "actionCode:".concat(String.valueOf(i2)), bundle);
        int i3 = this.dQL.getInt("real_name_verify_mode", this.mMode);
        if (this.mMode != i3) {
            this.mMode = i3;
        }
        if (activity instanceof WcPayRealnameProxyUI) {
            if (bundle == null) {
                bundle = this.dQL;
            }
            if (bundle != null) {
                this.mMode = bundle.getInt("real_name_verify_mode", 0);
            } else {
                this.mMode = 0;
            }
            this.HQN = this.mMode;
            bundle.putBoolean("key_is_realname_verify_process", true);
            this.mPluginName = bundle.getString("realname_verify_process_jump_plugin", "");
            this.mActivityName = bundle.getString("realname_verify_process_jump_activity", "");
            if (bundle.getInt("realname_verify_process_allow_idverify", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.HQM = z;
            Log.i("MicroMsg.RealNameVerifyProcess", "mAllowIdVerify is  mAllowIdVerify: %s,mPluginName %s, mActivityName %s ", Boolean.valueOf(this.HQM), this.mPluginName, this.mActivityName);
            switch (this.mMode) {
                case 0:
                    z.aqh(10);
                    b(activity, SwitchRealnameVerifyModeUI.class, bundle);
                    AppMethodBeat.o(70003);
                    return;
                case 1:
                    bundle.putBoolean("key_need_bind_response", true);
                    if (!h(activity, bundle)) {
                        z.aqh(10);
                        super.a(activity, bundle);
                        AppMethodBeat.o(70003);
                        return;
                    }
                    break;
                case 2:
                    b(activity, WalletRealNameVerifyUI.class, bundle);
                    AppMethodBeat.o(70003);
                    return;
                case 4:
                    String string = this.dQL.getString("key_realname_scene");
                    Log.i("MicroMsg.RealNameVerifyProcess", "realname scene: %s", string);
                    if (!"rename".equals(string)) {
                        b(activity, WcPayRealnameVerifyMainUI.class, bundle);
                        break;
                    } else {
                        b(activity, WcPayRealnameVerifyIdInputUI.class, bundle);
                        AppMethodBeat.o(70003);
                        return;
                    }
            }
            AppMethodBeat.o(70003);
            return;
        }
        if (this.mMode == 2) {
            if (activity instanceof WalletRealNameVerifyUI) {
                b(activity, WalletSetPasswordUI.class, bundle);
                AppMethodBeat.o(70003);
                return;
            } else if (activity instanceof WalletSetPasswordUI) {
                b(activity, WalletPwdConfirmUI.class, bundle);
                AppMethodBeat.o(70003);
                return;
            } else if (!(activity instanceof WalletPwdConfirmUI) && (activity instanceof SwitchRealnameVerifyModeUI)) {
                b(activity, WalletRealNameVerifyUI.class, bundle);
                this.mMode = 2;
                AppMethodBeat.o(70003);
                return;
            }
        } else if (this.mMode == 1) {
            if (activity instanceof SwitchRealnameVerifyModeUI) {
                if (t.fQI().fRk()) {
                    b(activity, WalletCheckPwdUI.class, bundle);
                    AppMethodBeat.o(70003);
                    return;
                }
                b(activity, WalletBankcardIdUI.class, bundle);
                AppMethodBeat.o(70003);
                return;
            } else if (activity instanceof WalletCheckPwdUI) {
                b(activity, WalletBankcardIdUI.class, bundle);
                AppMethodBeat.o(70003);
                return;
            } else {
                super.a(activity, i2, bundle);
                AppMethodBeat.o(70003);
                return;
            }
        } else if (this.mMode == 4) {
            if (activity instanceof WcPayRealnameVerifyMainUI) {
                b(activity, WcPayRealnameVerifyIdInputUI.class, bundle);
                AppMethodBeat.o(70003);
                return;
            } else if (activity instanceof WcPayRealnameVerifyIdInputUI) {
                if (!bundle.getBoolean("realname_verify_process_need_bind_card", false)) {
                    boolean z2 = this.dQL.getBoolean("realname_verify_process_show_bindcard_page", false);
                    Log.i("MicroMsg.RealNameVerifyProcess", "show bind page: %s", Boolean.valueOf(z2));
                    if (z2) {
                        b(activity, WcPayRealnameVerifyBindcardEntranceUI.class, bundle);
                        AppMethodBeat.o(70003);
                        return;
                    }
                    b(activity, WalletSetPasswordUI.class, bundle);
                    AppMethodBeat.o(70003);
                    return;
                } else if (h(activity, bundle)) {
                    AppMethodBeat.o(70003);
                    return;
                } else if (!t.fQI().fRk() || fPV()) {
                    b(activity, WalletBankcardIdUI.class, bundle);
                    AppMethodBeat.o(70003);
                    return;
                } else {
                    b(activity, WalletCheckPwdUI.class, bundle);
                    AppMethodBeat.o(70003);
                    return;
                }
            } else if (activity instanceof WcPayRealnameVerifyBindcardEntranceUI) {
                if (bundle.getBoolean("realname_verify_process_do_bind", false)) {
                    if (h(activity, bundle)) {
                        AppMethodBeat.o(70003);
                        return;
                    } else if (!t.fQI().fRk() || fPV()) {
                        b(activity, WalletBankcardIdUI.class, bundle);
                        AppMethodBeat.o(70003);
                        return;
                    } else {
                        b(activity, WalletCheckPwdUI.class, bundle);
                        AppMethodBeat.o(70003);
                        return;
                    }
                } else if (this.dQL.getBoolean("realname_verify_process_verify_sms_without_bindcard", false)) {
                    b(activity, WcPayRealnameVerifyCodeUI.class, bundle);
                    AppMethodBeat.o(70003);
                    return;
                } else {
                    b(activity, WalletSetPasswordUI.class, bundle);
                    AppMethodBeat.o(70003);
                    return;
                }
            } else if (activity instanceof WcPayRealnameVerifyCodeUI) {
                b(activity, WalletSetPasswordUI.class, bundle);
                AppMethodBeat.o(70003);
                return;
            } else if (activity instanceof WalletSetPasswordUI) {
                b(activity, WalletPwdConfirmUI.class, bundle);
                AppMethodBeat.o(70003);
                return;
            } else if (activity instanceof WalletPwdConfirmUI) {
                b(activity, WcPayRealnameVerifySuccessUI.class, bundle);
                AppMethodBeat.o(70003);
                return;
            } else if (activity instanceof WalletVerifyCodeUI) {
                String string2 = this.dQL.getString("key_resetpwd");
                Log.i("MicroMsg.RealNameVerifyProcess", "resetpwd: %s", string2);
                if ("resetpwd".equals(string2)) {
                    b(activity, WalletSetPasswordUI.class, bundle);
                    AppMethodBeat.o(70003);
                    return;
                }
                super.a(activity, i2, bundle);
                AppMethodBeat.o(70003);
                return;
            } else {
                super.a(activity, i2, bundle);
                AppMethodBeat.o(70003);
                return;
            }
        } else if (activity instanceof WalletRealNameVerifyUI) {
            b(activity, WalletBankcardIdUI.class, bundle);
            this.mMode = 1;
            AppMethodBeat.o(70003);
            return;
        } else {
            super.a(activity, i2, bundle);
        }
        AppMethodBeat.o(70003);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final void b(final Activity activity, Bundle bundle) {
        final Bundle bundle2;
        AppMethodBeat.i(70004);
        K("end", activity, bundle);
        z.hhs();
        if (bundle == null) {
            bundle2 = this.dQL;
        } else {
            bundle2 = bundle;
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        if (this.mMode == 1) {
            hgM();
            if (bundle2.getBoolean("intent_bind_end", false)) {
                this.resultCode = -1;
            } else {
                this.resultCode = 0;
            }
        } else if (bundle2.containsKey("realname_verify_process_ret")) {
            this.resultCode = bundle2.getInt("realname_verify_process_ret", -1);
        } else {
            this.resultCode = 0;
        }
        if (bundle2.containsKey("intent_bind_end")) {
            bundle2.remove("intent_bind_end");
        }
        if (bundle2.containsKey("key_is_bind_reg_process")) {
            bundle2.remove("key_is_bind_reg_process");
        }
        bundle2.putInt("realname_verify_process_ret", this.resultCode);
        final Intent intent = new Intent();
        intent.putExtras(bundle2);
        if (this.resultCode == -1) {
            Toast.makeText(activity, activity.getString(R.string.fup), 0).show();
        }
        final zv zvVar = new zv();
        if (this.resultCode == -1) {
            zvVar.efR.scene = 17;
        } else if (this.resultCode == 0) {
            zvVar.efR.scene = 18;
        } else {
            zvVar.efR.scene = 0;
        }
        zvVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.a.AnonymousClass1 */

            public final void run() {
                Class<?> cls = null;
                AppMethodBeat.i(69982);
                zvVar.callback = null;
                a.this.idt = true;
                if (Util.isNullOrNil(a.this.mPluginName) || Util.isNullOrNil(a.this.mActivityName)) {
                    a.this.b(activity, a.this.resultCode, bundle2);
                    if (a.this.resultCode == -1) {
                        aah aah = new aah();
                        aah.ehe.result = a.this.resultCode;
                        EventCenter.instance.publish(aah);
                    }
                    AppMethodBeat.o(69982);
                    return;
                }
                Log.i("MicroMsg.RealNameVerifyProcess", "real name verify process end,jump to " + a.this.mPluginName + a.this.mActivityName);
                boolean z = a.this.dQL.getBoolean("process_finish_stay_orgpage", true);
                intent.putExtra("key_process_is_end", true);
                intent.putExtra("key_process_is_stay", z);
                boolean z2 = intent.getExtras().getBoolean("is_from_new_cashier");
                try {
                    cls = Class.forName(intent.getExtras().getString("start_activity_class", ""));
                } catch (Exception e2) {
                }
                if (z2) {
                    if (cls == null) {
                        a.a(a.this, activity, a.this.mPluginName, a.this.mActivityName, a.this.resultCode, intent, z);
                    } else {
                        a.a(a.this, activity, cls, a.this.resultCode, intent, z);
                    }
                    if (a.this.HQO != null) {
                        a.this.HQO.run(activity);
                    }
                    AppMethodBeat.o(69982);
                    return;
                }
                a.b(a.this, activity, a.this.mPluginName, a.this.mActivityName, a.this.resultCode, intent, z);
                if (a.this.resultCode == -1) {
                    aah aah2 = new aah();
                    aah2.ehe.result = a.this.resultCode;
                    EventCenter.instance.publish(aah2);
                }
                AppMethodBeat.o(69982);
            }
        };
        zvVar.callback.run();
        AppMethodBeat.o(70004);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(70005);
        if (mMActivity instanceof WalletPwdConfirmUI) {
            if (this.mMode == 2 || this.mMode == 4) {
                AnonymousClass2 r0 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.a.AnonymousClass2 */

                    @Override // com.tencent.mm.wallet_core.d.g
                    public final boolean r(Object... objArr) {
                        AppMethodBeat.i(69985);
                        v vVar = (v) objArr[0];
                        String string = a.this.dQL.getString("key_real_name_token");
                        String string2 = a.this.dQL.getString("realname_verify_process_face_token");
                        String string3 = a.this.dQL.getString("key_realname_sessionid");
                        RealNameBundle realNameBundle = (RealNameBundle) a.this.dQL.getParcelable("realname_verify_process_bundle");
                        if (vVar == null || Util.isNullOrNil(vVar.kdF)) {
                            Log.e("MicroMsg.RealNameVerifyProcess", "get pwd error");
                        } else if (a.this.dQL.containsKey("kreq_token")) {
                            Log.i("MicroMsg.RealNameVerifyProcess", "bindcard verify");
                            this.Ruz.b(new com.tencent.mm.plugin.wallet_core.b.a.b(vVar, a.this.dQL.getInt("entry_scene", -1), string3, realNameBundle), true);
                        } else {
                            this.Ruz.b(new f(vVar.kdF, string, string2, a.this.dQL.getInt("entry_scene", -1), string3, realNameBundle), true);
                        }
                        AppMethodBeat.o(69985);
                        return true;
                    }

                    @Override // com.tencent.mm.wallet_core.d.g
                    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                        AppMethodBeat.i(69986);
                        if (qVar instanceof f) {
                            if (i2 == 0 && i3 == 0) {
                                if (((f) qVar).HPB == 0) {
                                    a.this.dQL.putInt("realname_verify_process_ret", -1);
                                }
                                a.this.dQL.putString("realname_verify_process_finish_title", ((f) qVar).title);
                                a.this.dQL.putString("realname_verify_process_finish_desc", ((f) qVar).desc);
                                a.this.dQL.putString("realname_verify_process_finish_page", ((f) qVar).jmT);
                                a.this.dQL.putInt("realname_verify_process_finish_err_jump", ((f) qVar).HPB);
                                Log.i("MicroMsg.RealNameVerifyProcess", "real name reg succ ,update user info");
                                t.fQI().and();
                                zv zvVar = new zv();
                                zvVar.efR.scene = 16;
                                zvVar.callback = new Runnable() {
                                    /* class com.tencent.mm.plugin.wallet_core.id_verify.a.AnonymousClass2.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(69983);
                                        Log.i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
                                        AppMethodBeat.o(69983);
                                    }
                                };
                                EventCenter.instance.publish(zvVar);
                                a.a(a.this, this.Ruz);
                                if (a.this.mMode == 2) {
                                    a.this.b(this.activity, a.this.dQL);
                                } else {
                                    a.this.a(this.activity, 0, a.this.dQL);
                                }
                                AppMethodBeat.o(69986);
                                return true;
                            }
                        } else if (qVar instanceof com.tencent.mm.plugin.wallet_core.b.a.b) {
                            if (i2 == 0 && i3 == 0) {
                                if (((com.tencent.mm.plugin.wallet_core.b.a.b) qVar).HPB == 0) {
                                    a.this.dQL.putInt("realname_verify_process_ret", -1);
                                }
                                a.this.dQL.putString("realname_verify_process_finish_title", ((com.tencent.mm.plugin.wallet_core.b.a.b) qVar).title);
                                a.this.dQL.putString("realname_verify_process_finish_desc", ((com.tencent.mm.plugin.wallet_core.b.a.b) qVar).desc);
                                a.this.dQL.putString("realname_verify_process_finish_page", ((com.tencent.mm.plugin.wallet_core.b.a.b) qVar).jmT);
                                a.this.dQL.putInt("realname_verify_process_finish_err_jump", ((com.tencent.mm.plugin.wallet_core.b.a.b) qVar).HPB);
                                Log.i("MicroMsg.RealNameVerifyProcess", "bind card verify succ ,update user info");
                                if (((com.tencent.mm.plugin.wallet_core.b.a.b) qVar).HPA != null) {
                                    a.this.dQL.putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.b.a.b) qVar).HPA);
                                }
                                t.fQI().and();
                                zv zvVar2 = new zv();
                                zvVar2.efR.scene = 16;
                                zvVar2.callback = new Runnable() {
                                    /* class com.tencent.mm.plugin.wallet_core.id_verify.a.AnonymousClass2.AnonymousClass2 */

                                    public final void run() {
                                        AppMethodBeat.i(69984);
                                        Log.i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
                                        AppMethodBeat.o(69984);
                                    }
                                };
                                EventCenter.instance.publish(zvVar2);
                                a.b(a.this, this.Ruz);
                                if (a.this.mMode == 2) {
                                    a.this.b(this.activity, a.this.dQL);
                                } else {
                                    a.this.a(this.activity, 0, a.this.dQL);
                                }
                                AppMethodBeat.o(69986);
                                return true;
                            }
                        } else if (qVar instanceof m) {
                            AppMethodBeat.o(69986);
                            return true;
                        }
                        AppMethodBeat.o(69986);
                        return false;
                    }
                };
                AppMethodBeat.o(70005);
                return r0;
            }
            com.tencent.mm.wallet_core.d.g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(70005);
            return a2;
        } else if (mMActivity instanceof WalletRealNameVerifyUI) {
            AnonymousClass3 r02 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.a.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(69987);
                    CharSequence charSequence = null;
                    if (i2 == 0) {
                        String string = this.activity.getString(R.string.ipi);
                        String string2 = this.activity.getString(R.string.ipe);
                        String string3 = this.activity.getString(R.string.ipo, new Object[]{string, string2});
                        l lVar = new l(this.activity);
                        SpannableString spannableString = new SpannableString(string3);
                        spannableString.setSpan(lVar, string3.length() - string2.length(), string3.length(), 33);
                        charSequence = spannableString.subSequence(0, spannableString.length());
                    }
                    AppMethodBeat.o(69987);
                    return charSequence;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    return false;
                }
            };
            AppMethodBeat.o(70005);
            return r02;
        } else if ((mMActivity instanceof WalletCardElementUI) || (mMActivity instanceof WalletCardImportUI)) {
            AnonymousClass4 r03 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.a.AnonymousClass4 */
                Authen HFI;

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69990);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof com.tencent.mm.plugin.wallet_core.b.a.a) {
                            com.tencent.mm.plugin.wallet_core.b.a.a aVar = (com.tencent.mm.plugin.wallet_core.b.a.a) qVar;
                            if (aVar.HPz == null) {
                                a.this.dQL.putString("kreq_token", aVar.getToken());
                                if (a.this.c(this.activity, a.this.dQL)) {
                                    Log.i("MicroMsg.RealNameVerifyProcess", "need update bankcardlist");
                                    this.Ruz.b(new ad(null, 12), true);
                                } else {
                                    Log.i("MicroMsg.RealNameVerifyProcess", "not need update bankcardlist");
                                    a.this.a(this.activity, 0, a.this.dQL);
                                }
                            } else {
                                Log.i("MicroMsg.RealNameVerifyProcess", "NetSceneTenpayBindBankcard show juveniles dialog");
                                h.c(this.activity, aVar.HPz.dQx, "", aVar.HPz.IaV, aVar.HPz.IaU, new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.wallet_core.id_verify.a.AnonymousClass4.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(69988);
                                        Log.i("MicroMsg.RealNameVerifyProcess", "NetSceneTenpayBindBankcard dialog lOk");
                                        AnonymousClass4.this.Ruz.a(new com.tencent.mm.plugin.wallet_core.b.a.a(AnonymousClass4.this.HFI, "1", a.this.dQL.getString("key_realname_sessionid")), true, 1);
                                        u.xV(1);
                                        AppMethodBeat.o(69988);
                                    }
                                }, new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.wallet_core.id_verify.a.AnonymousClass4.AnonymousClass2 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(69989);
                                        Log.i("MicroMsg.RealNameVerifyProcess", "NetSceneTenpayBindBankcard dialog lCancel");
                                        u.xV(0);
                                        AppMethodBeat.o(69989);
                                    }
                                });
                            }
                            AppMethodBeat.o(69990);
                            return true;
                        } else if (qVar instanceof ad) {
                            Log.i("MicroMsg.RealNameVerifyProcess", "update bankcardlist success!");
                            a.this.a(this.activity, 0, a.this.dQL);
                            AppMethodBeat.o(69990);
                            return true;
                        }
                    }
                    AppMethodBeat.o(69990);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69992);
                    a.this.K("onNext", objArr);
                    this.HFI = (Authen) objArr[0];
                    this.HFI.cSx = a.F(a.this);
                    this.Ruz.a(new com.tencent.mm.plugin.wallet_core.b.a.a(this.HFI, "", a.this.dQL.getString("key_realname_sessionid")), true, 1);
                    AppMethodBeat.o(69992);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final void onActivityResult(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(69993);
                    Log.i("MicroMsg.RealNameVerifyProcess", "onActivityResult: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 != 1) {
                        super.onActivityResult(i2, i3, intent);
                    } else if (!(i3 != -1 || intent == null || intent.getExtras() == null)) {
                        a.this.dQL.putString("realname_verify_process_face_token", intent.getExtras().getString("token"));
                        a.this.a(this.activity, 0, a.this.dQL);
                        AppMethodBeat.o(69993);
                        return;
                    }
                    AppMethodBeat.o(69993);
                }
            };
            AppMethodBeat.o(70005);
            return r03;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            AnonymousClass5 r04 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.a.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69994);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof com.tencent.mm.plugin.wallet_core.b.a.a) {
                            Log.i("MicroMsg.RealNameVerifyProcess", "verify code success!");
                            a.this.dQL.putString("kreq_token", ((com.tencent.mm.plugin.wallet_core.b.a.a) qVar).getToken());
                            AppMethodBeat.o(69994);
                            return true;
                        } else if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.v) {
                            a.c(a.this, this.Ruz);
                            if (((com.tencent.mm.plugin.wallet_core.c.v) qVar).HPA != null) {
                                a.this.dQL.putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.c.v) qVar).HPA);
                            }
                            a.this.dQL.putString("key_resetpwd", ((com.tencent.mm.plugin.wallet_core.c.v) qVar).action);
                            boolean z = a.this.dQL.getBoolean("realname_verify_process_need_face", false);
                            Log.i("MicroMsg.RealNameVerifyProcess", "forward: %s", Boolean.valueOf(z));
                            if (z) {
                                se seVar = new se();
                                seVar.dYI.dKq = this.activity;
                                seVar.dYI.scene = (int) a.this.dQL.getLong("realname_verify_process_face_scene");
                                seVar.dYI.packageName = a.this.dQL.getString("realname_verify_process_face_package");
                                seVar.dYI.dYK = a.this.dQL.getString("realname_verify_process_face_package_sign");
                                seVar.dYI.requestCode = 1;
                                EventCenter.instance.publish(seVar);
                            } else {
                                a.this.a(this.activity, 0, a.this.dQL);
                            }
                            AppMethodBeat.o(69994);
                            return true;
                        } else if (qVar instanceof m) {
                            AppMethodBeat.o(69994);
                            return true;
                        }
                    }
                    AppMethodBeat.o(69994);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final void onActivityResult(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(69995);
                    Log.i("MicroMsg.RealNameVerifyProcess", "onActivityResult: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 != 1) {
                        super.onActivityResult(i2, i3, intent);
                    } else if (!(i3 != -1 || intent == null || intent.getExtras() == null)) {
                        a.this.dQL.putString("realname_verify_process_face_token", intent.getExtras().getString("token"));
                        a.this.a(this.activity, 0, a.this.dQL);
                        AppMethodBeat.o(69995);
                        return;
                    }
                    AppMethodBeat.o(69995);
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69996);
                    a.this.K("WalletVerifyCodeUI onNext", objArr);
                    Log.i("MicroMsg.RealNameVerifyProcess", "onNext, do bind verify!");
                    v vVar = (v) objArr[1];
                    if (!t.fQI().fRk() || a.P(a.this)) {
                        vVar.flag = "1";
                    } else {
                        vVar.flag = "2";
                    }
                    this.Ruz.a(new com.tencent.mm.plugin.wallet_core.c.v(vVar, a.this.dQL.getInt("entry_scene", -1), a.this.dQL.getString("key_realname_sessionid")), true, 1);
                    AppMethodBeat.o(69996);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(69997);
                    String string = this.activity.getString(R.string.ith);
                    AppMethodBeat.o(69997);
                    return string;
                }
            };
            AppMethodBeat.o(70005);
            return r04;
        } else if (mMActivity instanceof WcPayRealnameVerifyCodeUI) {
            b bVar = new b(mMActivity, iVar);
            AppMethodBeat.o(70005);
            return bVar;
        } else {
            com.tencent.mm.wallet_core.d.g a3 = super.a(mMActivity, iVar);
            AppMethodBeat.o(70005);
            return a3;
        }
    }

    class b extends com.tencent.mm.wallet_core.d.g {
        int HQT = 0;

        public b(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean r(Object... objArr) {
            return false;
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(174440);
            if (qVar instanceof j) {
                if (i2 == 0 && i3 == 0) {
                    AppMethodBeat.o(174440);
                    return true;
                }
            } else if ((qVar instanceof k) && i2 == 0 && i3 == 0) {
                a.this.a(this.activity, 0, new Bundle());
                AppMethodBeat.o(174440);
                return true;
            }
            AppMethodBeat.o(174440);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "realname_verify_process";
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final int a(MMActivity mMActivity, int i2) {
        return R.string.ien;
    }

    private boolean h(Context context, Bundle bundle) {
        AppMethodBeat.i(70006);
        com.tencent.mm.wallet_core.b.hgC();
        if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_bind_card, true)) {
            EventCenter.instance.add(this.AJa);
            Log.d("MicroMsg.RealNameVerifyProcess", "startKindaBindCard:true");
            if (bundle != null) {
                ab.mg(6, bundle.getInt("key_bind_scene"));
                z.aqh(bundle.getInt("key_bind_scene"));
            } else {
                ab.mg(6, 0);
                z.aqh(0);
            }
            bundle.putInt("key_bind_scene", 10);
            if (fPV()) {
                bundle.putInt("reg_flag", 0);
            }
            ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(context, bundle);
            AppMethodBeat.o(70006);
            return true;
        }
        Log.d("MicroMsg.RealNameVerifyProcess", "startKindaBindCard:false");
        AppMethodBeat.o(70006);
        return false;
    }
}

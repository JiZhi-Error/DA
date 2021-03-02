package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;
import org.apache.commons.a.a;
import org.json.JSONException;
import org.json.JSONObject;

public class WcPayRealnameVerifyMainUI extends WalletBaseUI {
    private boolean HPI;
    private TextView HTt;
    private ViewGroup HTu;
    private u HTv = new u();
    private TextView jVn;
    private Button wEz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WcPayRealnameVerifyMainUI() {
        AppMethodBeat.i(70125);
        AppMethodBeat.o(70125);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70126);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.f3048f));
        hideActionbarLine();
        setMMTitle("");
        this.HTv.IkQ = new u.b() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.b
            public final int eho() {
                return 1;
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.b
            public final Context getContext() {
                AppMethodBeat.i(70118);
                AppCompatActivity context = WcPayRealnameVerifyMainUI.this.getContext();
                AppMethodBeat.o(70118);
                return context;
            }
        };
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(70119);
                d process = WcPayRealnameVerifyMainUI.this.getProcess();
                if (process != null) {
                    process.g(WcPayRealnameVerifyMainUI.this.getContext(), 0);
                    AppMethodBeat.o(70119);
                    return true;
                }
                WcPayRealnameVerifyMainUI.this.finish();
                AppMethodBeat.o(70119);
                return false;
            }
        });
        String string = getInput().getString("realname_verify_process_get_wording_cache");
        try {
            if (!Util.isNullOrNil(string)) {
                btr btr = (btr) new btr().parseFrom(string.getBytes(a.ISO_8859_1));
                this.HPI = btr.HPI;
                if (btr.Maw != null) {
                    m.a(btr.Maw).a(this, new g() {
                        /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI.AnonymousClass5 */

                        @Override // com.tencent.mm.wallet_core.c.g
                        public final void eeY() {
                        }
                    });
                }
            }
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.WcPayRealnameVerifyMainUI", e2, "", new Object[0]);
        }
        initView();
        AppMethodBeat.o(70126);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70127);
        this.wEz = (Button) findViewById(R.id.jr0);
        this.jVn = (TextView) findViewById(R.id.jqx);
        this.HTt = (TextView) findViewById(R.id.jqz);
        this.HTu = (ViewGroup) findViewById(R.id.jqy);
        this.wEz.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(70123);
                Log.d("MicroMsg.WcPayRealnameVerifyMainUI", "click verify btn");
                WcPayRealnameVerifyMainUI.this.HTv.a(new u.a() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
                    public final void ehm() {
                        AppMethodBeat.i(70120);
                        WcPayRealnameVerifyMainUI.a(WcPayRealnameVerifyMainUI.this);
                        AppMethodBeat.o(70120);
                    }

                    @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
                    public final void cancel() {
                        AppMethodBeat.i(70121);
                        WcPayRealnameVerifyMainUI.this.HTv.dEF = false;
                        AppMethodBeat.o(70121);
                    }

                    @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
                    public final void ehn() {
                        AppMethodBeat.i(70122);
                        WcPayRealnameVerifyMainUI.a(WcPayRealnameVerifyMainUI.this);
                        AppMethodBeat.o(70122);
                    }
                }, WcPayRealnameVerifyMainUI.this.HPI);
                AppMethodBeat.o(70123);
            }
        });
        JSONObject fPW = fPW();
        if (fPW != null) {
            this.jVn.setText(Util.nullAs(fPW.optString("cache_header_titles", getString(R.string.hju)), getString(R.string.hju)));
            if (fPW.optBoolean("isShowCapitalSecurity", false)) {
                this.HTt.setText(R.string.ijd);
                this.HTt.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(70124);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyMainUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        intent.putExtra("wallet_lock_jsapi_scene", 2);
                        c.b(WcPayRealnameVerifyMainUI.this.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", intent);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyMainUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(70124);
                    }
                });
                this.HTu.setVisibility(0);
                AppMethodBeat.o(70127);
                return;
            }
            this.HTu.setVisibility(8);
        }
        AppMethodBeat.o(70127);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(70128);
        super.onResume();
        this.HTv.onResume();
        AppMethodBeat.o(70128);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(70129);
        super.onPause();
        this.HTv.onPause();
        AppMethodBeat.o(70129);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(70130);
        if (i2 == 1) {
            if (i3 == -1) {
                this.HTv.ehm();
            } else {
                this.HTv.cancel();
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(70130);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cb4;
    }

    private static JSONObject fPW() {
        AppMethodBeat.i(70131);
        com.tencent.mm.kernel.g.aAi();
        Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_REALNAME_SWITCH_WORDING_STRING_SYNC, "");
        if (obj != null) {
            String str = (String) obj;
            if (!Util.isNullOrNil(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j2 = jSONObject.getLong(AppMeasurement.Param.TIMESTAMP);
                    long j3 = jSONObject.getLong("cache_time");
                    Log.i("MicroMsg.WcPayRealnameVerifyMainUI", " dddd time=" + currentTimeMillis + ";timestamp=" + j2 + ";cachetime=" + j3);
                    if (currentTimeMillis - j2 > j3) {
                        Log.e("MicroMsg.WcPayRealnameVerifyMainUI", "wording data from cache is out of date");
                        AppMethodBeat.o(70131);
                        return null;
                    }
                    AppMethodBeat.o(70131);
                    return jSONObject;
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.WcPayRealnameVerifyMainUI", e2, "", new Object[0]);
                    Log.e("MicroMsg.WcPayRealnameVerifyMainUI", "parse wording data form cache error");
                    AppMethodBeat.o(70131);
                    return null;
                }
            }
        }
        Log.i("MicroMsg.WcPayRealnameVerifyMainUI", "cache is null");
        AppMethodBeat.o(70131);
        return null;
    }

    static /* synthetic */ void a(WcPayRealnameVerifyMainUI wcPayRealnameVerifyMainUI) {
        AppMethodBeat.i(70132);
        Log.i("MicroMsg.WcPayRealnameVerifyMainUI", "go to id input ui");
        com.tencent.mm.wallet_core.a.l(wcPayRealnameVerifyMainUI, wcPayRealnameVerifyMainUI.getInput());
        AppMethodBeat.o(70132);
    }
}

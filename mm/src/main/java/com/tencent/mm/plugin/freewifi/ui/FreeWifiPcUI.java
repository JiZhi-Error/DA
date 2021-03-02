package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.d.l;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;

public class FreeWifiPcUI extends MMActivity {
    private String appId;
    private String dHx;
    private Button hPX;
    private String wPA;
    private String wRE;
    private Button wRz;
    private TextView wSw;
    private int wSx;
    private q wSy = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FreeWifiPcUI freeWifiPcUI) {
        AppMethodBeat.i(25128);
        freeWifiPcUI.goBack();
        AppMethodBeat.o(25128);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25125);
        super.onCreate(bundle);
        setMMTitle(R.string.dip);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25120);
                FreeWifiPcUI.a(FreeWifiPcUI.this);
                AppMethodBeat.o(25120);
                return true;
            }
        });
        this.appId = getIntent().getStringExtra("free_wifi_appid");
        this.wSx = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
        this.dHx = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
        this.wPA = getIntent().getStringExtra("free_wifi_app_nickname");
        this.wRE = getIntent().getStringExtra("free_wifi_privacy_url");
        this.wSw = (TextView) findViewById(R.id.d_p);
        this.hPX = (Button) findViewById(R.id.d_q);
        this.wSw.setText("由" + this.wPA + "提供");
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(25123);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FreeWifiPcUI.this.hPX.setClickable(false);
                final MTimerHandler mTimerHandler = new MTimerHandler(new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(25121);
                        FreeWifiPcUI.this.wSy = h.a((Context) FreeWifiPcUI.this.getContext(), FreeWifiPcUI.this.getString(R.string.b9i), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        AppMethodBeat.o(25121);
                        return true;
                    }
                }, false);
                mTimerHandler.startTimer(2000);
                k.a dMF = k.dMF();
                dMF.wNa = String.valueOf(FreeWifiPcUI.this.wSx);
                dMF.wNb = FreeWifiPcUI.this.appId;
                dMF.quX = FreeWifiPcUI.this.dHx;
                dMF.wNd = k.b.SetPcLoginUserInfo.wNO;
                dMF.wNe = k.b.SetPcLoginUserInfo.name;
                dMF.dMH().dMG();
                Log.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", m.aw(FreeWifiPcUI.this.getIntent()), Integer.valueOf(m.ax(FreeWifiPcUI.this.getIntent())), Integer.valueOf(FreeWifiPcUI.this.wSx), FreeWifiPcUI.this.appId, FreeWifiPcUI.this.dHx);
                new l(FreeWifiPcUI.this.appId, FreeWifiPcUI.this.wSx, FreeWifiPcUI.this.dHx).c(new i() {
                    /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.AnonymousClass2.AnonymousClass2 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(25122);
                        mTimerHandler.stopTimer();
                        if (i2 == 0 && i3 == 0) {
                            FreeWifiPcUI.this.finish();
                        } else if (!m.gC(i2, i3) || m.eP(str)) {
                            FreeWifiPcUI.a(FreeWifiPcUI.this, FreeWifiPcUI.this.getString(R.string.dhu), FreeWifiPcUI.this.getString(R.string.dhv));
                        } else {
                            FreeWifiPcUI.a(FreeWifiPcUI.this, str + "(" + m.a(m.ay(FreeWifiPcUI.this.getIntent()), k.b.SetPcLoginUserInfoReturn, i3) + ")", "");
                        }
                        k.a dMF = k.dMF();
                        dMF.wNa = String.valueOf(FreeWifiPcUI.this.wSx);
                        dMF.wNb = FreeWifiPcUI.this.appId;
                        dMF.quX = FreeWifiPcUI.this.dHx;
                        dMF.wNd = k.b.SetPcLoginUserInfoReturn.wNO;
                        dMF.wNe = k.b.SetPcLoginUserInfoReturn.name;
                        dMF.result = i3;
                        dMF.dMH().dMG();
                        Log.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", m.aw(FreeWifiPcUI.this.getIntent()), Integer.valueOf(m.ax(FreeWifiPcUI.this.getIntent())), Integer.valueOf(FreeWifiPcUI.this.wSx), FreeWifiPcUI.this.appId, FreeWifiPcUI.this.dHx);
                        AppMethodBeat.o(25122);
                    }
                });
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25123);
            }
        });
        this.wRz = (Button) findViewById(R.id.d_r);
        this.wRz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(25124);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("rawUrl", FreeWifiPcUI.this.wRE);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                c.b(FreeWifiPcUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25124);
            }
        });
        AppMethodBeat.o(25125);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(25126);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(25126);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(25126);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(25127);
        g.jRt.h(new Intent(), this);
        finish();
        AppMethodBeat.o(25127);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.amn;
    }

    static /* synthetic */ void a(FreeWifiPcUI freeWifiPcUI, String str, String str2) {
        AppMethodBeat.i(25129);
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiPcUI, FreeWifiErrorUI.class);
        freeWifiPcUI.finish();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(freeWifiPcUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI", "toErrorUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        freeWifiPcUI.startActivity((Intent) bl.pG(0));
        a.a(freeWifiPcUI, "com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI", "toErrorUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(25129);
    }
}

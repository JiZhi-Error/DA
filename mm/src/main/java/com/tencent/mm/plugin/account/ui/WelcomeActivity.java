package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.h.a.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.tavkit.component.TAVExporter;
import java.util.ArrayList;
import org.json.JSONObject;

@a(3)
public class WelcomeActivity extends MMFragmentActivity {
    private static final String[] kkg = {"public_profile"};
    private d kkF;
    private c kkV;
    private ka kkY = new ka();
    private x kmF = new x();
    private WelcomeSelectView ksB;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WelcomeActivity() {
        AppMethodBeat.i(128811);
        AppMethodBeat.o(128811);
    }

    static /* synthetic */ void f(WelcomeActivity welcomeActivity) {
        AppMethodBeat.i(128820);
        welcomeActivity.bpX();
        AppMethodBeat.o(128820);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128812);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        this.ksB = new WelcomeSelectView(this);
        setContentView(this.ksB);
        this.ksB.bpY();
        this.ksB.ksF.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.WelcomeActivity.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(128794);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/WelcomeActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("not_auth_setting", true);
                intent.putExtra("from_login_history", true);
                com.tencent.mm.plugin.account.a.a.jRt.n(intent, WelcomeActivity.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128794);
            }
        });
        this.ksB.ksD.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.WelcomeActivity.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(128802);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!ao.gJH() || ao.gJL()) {
                    Intent intent = new Intent(WelcomeActivity.this, MobileInputUI.class);
                    intent.putExtra("mobile_input_purpose", 1);
                    WelcomeActivity welcomeActivity = WelcomeActivity.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(welcomeActivity, bl.axQ(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    welcomeActivity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(welcomeActivity, "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else {
                    d.a aVar = com.tencent.mm.plugin.account.model.d.kiq;
                    Intent intent2 = new Intent(WelcomeActivity.this, LoginSelectUI.class);
                    intent2.putExtra("mobile_input_purpose", 1);
                    WelcomeActivity welcomeActivity2 = WelcomeActivity.this;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(welcomeActivity2, bl2.axQ(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    welcomeActivity2.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(welcomeActivity2, "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128802);
            }
        });
        final ArrayList arrayList = new ArrayList();
        n nVar = new n(this, 1001, 0);
        nVar.setTitle(R.string.fyj);
        arrayList.add(nVar);
        final n nVar2 = new n(this, 1002, 0);
        if (com.tencent.mm.aw.b.bdD()) {
            nVar2.setTitle(R.string.fyh);
            arrayList.add(nVar2);
        }
        if (arrayList.size() > 1) {
            final e eVar = new e((Context) this, 1, false);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.plugin.account.ui.WelcomeActivity.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(128803);
                    if (mVar.gKQ()) {
                        for (n nVar : arrayList) {
                            mVar.g(nVar);
                        }
                    }
                    AppMethodBeat.o(128803);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.plugin.account.ui.WelcomeActivity.AnonymousClass6 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(128804);
                    switch (menuItem.getItemId()) {
                        case 1001:
                            Intent intent = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
                            WelcomeActivity welcomeActivity = WelcomeActivity.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(welcomeActivity, bl.axQ(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            welcomeActivity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(welcomeActivity, "com/tencent/mm/plugin/account/ui/WelcomeActivity$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(128804);
                            return;
                        case 1002:
                            WelcomeActivity.this.kkY.eTd = 1;
                            WelcomeActivity.this.kkY.ejA = 2;
                            WelcomeActivity.this.kkY.bfK();
                            WelcomeActivity.b(WelcomeActivity.this);
                            break;
                    }
                    AppMethodBeat.o(128804);
                }
            };
            eVar.PGl = new e.b() {
                /* class com.tencent.mm.plugin.account.ui.WelcomeActivity.AnonymousClass7 */

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                }
            };
            this.ksB.ksE.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.WelcomeActivity.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128805);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (com.tencent.mm.protocal.d.KyR) {
                        WelcomeActivity.c(WelcomeActivity.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(128805);
                        return;
                    }
                    eVar.dGm();
                    if (arrayList.contains(nVar2)) {
                        WelcomeActivity.this.kkY.eTd = 1;
                        WelcomeActivity.this.kkY.ejA = 1;
                        WelcomeActivity.this.kkY.bfK();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128805);
                }
            });
            AppMethodBeat.o(128812);
            return;
        }
        this.ksB.ksE.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.WelcomeActivity.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(128806);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (com.tencent.mm.protocal.d.KyR) {
                    WelcomeActivity.c(WelcomeActivity.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128806);
                    return;
                }
                Intent intent = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
                WelcomeActivity welcomeActivity = WelcomeActivity.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(welcomeActivity, bl.axQ(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                welcomeActivity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(welcomeActivity, "com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128806);
            }
        });
        AppMethodBeat.o(128812);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128813);
        super.onResume();
        this.ksB.init();
        AppMethodBeat.o(128813);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(161711);
        this.kmF.a(this, i2, strArr, iArr);
        AppMethodBeat.o(161711);
    }

    private void bpX() {
        AppMethodBeat.i(128814);
        if (r.s(this, "com.facebook.katana")) {
            this.kkF.a("name,picture.type(large)", new d.a() {
                /* class com.tencent.mm.plugin.account.ui.WelcomeActivity.AnonymousClass10 */

                @Override // com.tencent.mm.ui.h.a.d.a
                public final void A(JSONObject jSONObject) {
                    AppMethodBeat.i(128807);
                    Log.i("MicroMsg.WelcomeActivity", "facebook-android get name and picture completed!");
                    if (jSONObject != null) {
                        try {
                            Intent intent = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
                            String str = null;
                            if (!(WelcomeActivity.this.kkF.QjM == null || WelcomeActivity.this.kkF.QjM.getToken() == null)) {
                                str = WelcomeActivity.this.kkF.QjM.getToken().toString();
                            }
                            intent.putExtra("third_app_token", str);
                            intent.putExtra("reg_3d_app_type", 1);
                            intent.putExtra("register_title", WelcomeActivity.this.getString(R.string.biw));
                            if (jSONObject.has("name")) {
                                intent.putExtra("register_nick_name", jSONObject.getString("name"));
                                Log.i("MicroMsg.WelcomeActivity", "name %s", jSONObject.getString("name"));
                            }
                            if (jSONObject.has("picture")) {
                                Log.i("MicroMsg.WelcomeActivity", "picture %s", jSONObject.get("picture"));
                                intent.putExtra("register_avatar", ((JSONObject) jSONObject.get("picture")).getJSONObject("data").getString("url"));
                            }
                            WelcomeActivity welcomeActivity = WelcomeActivity.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(welcomeActivity, bl.axQ(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$8", "onCompleted", "(Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            welcomeActivity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(welcomeActivity, "com/tencent/mm/plugin/account/ui/WelcomeActivity$8", "onCompleted", "(Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            WelcomeActivity.this.kkY.eTd = 1;
                            WelcomeActivity.this.kkY.ejA = 3;
                            WelcomeActivity.this.kkY.bfK();
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.WelcomeActivity", e2, "parse json error!", new Object[0]);
                            h.c(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
                            AppMethodBeat.o(128807);
                            return;
                        }
                    }
                    AppMethodBeat.o(128807);
                }

                @Override // com.tencent.mm.ui.h.a.d.a
                public final void onError(String str) {
                    AppMethodBeat.i(128808);
                    Log.i("MicroMsg.WelcomeActivity", "facebook-android get name and picture error! %s", str);
                    h.c(WelcomeActivity.this, WelcomeActivity.this.getString(R.string.c77), "", true);
                    AppMethodBeat.o(128808);
                }
            });
            AppMethodBeat.o(128814);
            return;
        }
        g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
            /* class com.tencent.mm.plugin.account.ui.WelcomeActivity.AnonymousClass11 */
            JSONObject klc = null;

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean doInBackground() {
                AppMethodBeat.i(128809);
                Bundle bundle = new Bundle();
                bundle.putString(GraphRequest.FIELDS_PARAM, "name,picture.type(large)");
                try {
                    String r = WelcomeActivity.this.kkV.r("me", bundle);
                    Log.i("MicroMsg.WelcomeActivity", "result json %s", r);
                    this.klc = new JSONObject(r);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.WelcomeActivity", e2, "get name and picture error!", new Object[0]);
                    h.c(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
                }
                AppMethodBeat.o(128809);
                return true;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean onPostExecute() {
                AppMethodBeat.i(128810);
                if (this.klc != null) {
                    try {
                        Intent intent = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
                        intent.putExtra("third_app_token", WelcomeActivity.this.kkV.jZX.toString());
                        intent.putExtra("reg_3d_app_type", 1);
                        intent.putExtra("register_title", WelcomeActivity.this.getString(R.string.biw));
                        intent.putExtra("register_nick_name", this.klc.getString("name"));
                        intent.putExtra("register_avatar", ((JSONObject) this.klc.get("picture")).getJSONObject("data").getString("url"));
                        WelcomeActivity welcomeActivity = WelcomeActivity.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(welcomeActivity, bl.axQ(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$9", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        welcomeActivity.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(welcomeActivity, "com/tencent/mm/plugin/account/ui/WelcomeActivity$9", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        WelcomeActivity.this.kkY.eTd = 1;
                        WelcomeActivity.this.kkY.ejA = 3;
                        WelcomeActivity.this.kkY.bfK();
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.WelcomeActivity", e2, "parse json error!", new Object[0]);
                        h.c(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
                    }
                }
                AppMethodBeat.o(128810);
                return true;
            }
        });
        AppMethodBeat.o(128814);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128815);
        super.onDestroy();
        this.kkY.bfK();
        if (this.kkF != null) {
            this.kkF.logout();
        }
        AppMethodBeat.o(128815);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z = true;
        AppMethodBeat.i(128817);
        super.onActivityResult(i2, i3, intent);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.WelcomeActivity", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", objArr);
        if (this.kkF != null) {
            this.kkF.j(i2, i3, intent);
        }
        AppMethodBeat.o(128817);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(128816);
        Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
        bZ.addFlags(67108864);
        bZ.putExtra("can_finish", true);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/WelcomeActivity", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.ui.base.b.kd(this);
        AppMethodBeat.o(128816);
    }

    static /* synthetic */ void b(WelcomeActivity welcomeActivity) {
        AppMethodBeat.i(128818);
        if (r.s(welcomeActivity, "com.facebook.katana")) {
            if (welcomeActivity.kkF == null) {
                welcomeActivity.kkF = new com.tencent.mm.ui.h.a.d(welcomeActivity.getString(R.string.c71));
                welcomeActivity.kkF.gWp();
            }
            if (!welcomeActivity.kkF.gWo()) {
                welcomeActivity.kkF.logout();
                welcomeActivity.kkF.a(welcomeActivity, new d.b() {
                    /* class com.tencent.mm.plugin.account.ui.WelcomeActivity.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.h.a.d.b
                    public final void onSuccess() {
                        AppMethodBeat.i(128795);
                        Log.i("MicroMsg.WelcomeActivity", "facebook-android login success!");
                        WelcomeActivity.f(WelcomeActivity.this);
                        AppMethodBeat.o(128795);
                    }

                    @Override // com.tencent.mm.ui.h.a.d.b
                    public final void onCancel() {
                        AppMethodBeat.i(128796);
                        Log.i("MicroMsg.WelcomeActivity", "facebook-android login cancel!");
                        AppMethodBeat.o(128796);
                    }

                    @Override // com.tencent.mm.ui.h.a.d.b
                    public final void onError(String str) {
                        AppMethodBeat.i(128797);
                        Log.i("MicroMsg.WelcomeActivity", "facebook-android login error! %s", str);
                        h.c(WelcomeActivity.this, WelcomeActivity.this.getString(R.string.c77), "", true);
                        AppMethodBeat.o(128797);
                    }
                }, kkg);
                AppMethodBeat.o(128818);
                return;
            }
            welcomeActivity.bpX();
            AppMethodBeat.o(128818);
            return;
        }
        welcomeActivity.kkV = new c(welcomeActivity.getString(R.string.c71));
        welcomeActivity.kkV.a(welcomeActivity, kkg, new c.a() {
            /* class com.tencent.mm.plugin.account.ui.WelcomeActivity.AnonymousClass3 */

            @Override // com.tencent.mm.ui.h.a.c.a
            public final void E(Bundle bundle) {
                AppMethodBeat.i(128798);
                Log.i("MicroMsg.WelcomeActivity", "facebook login success");
                WelcomeActivity.f(WelcomeActivity.this);
                AppMethodBeat.o(128798);
            }

            @Override // com.tencent.mm.ui.h.a.c.a
            public final void a(com.tencent.mm.ui.h.a.e eVar) {
                AppMethodBeat.i(128799);
                Log.i("MicroMsg.WelcomeActivity", "facebook-android login error! %s", eVar.getMessage());
                h.c(WelcomeActivity.this, WelcomeActivity.this.getString(R.string.c77), "", true);
                AppMethodBeat.o(128799);
            }

            @Override // com.tencent.mm.ui.h.a.c.a
            public final void a(com.tencent.mm.ui.h.a.b bVar) {
                AppMethodBeat.i(128800);
                Log.i("MicroMsg.WelcomeActivity", "facebook-android login error! %s", bVar.getMessage());
                h.c(WelcomeActivity.this, WelcomeActivity.this.getString(R.string.c77), "", true);
                AppMethodBeat.o(128800);
            }

            @Override // com.tencent.mm.ui.h.a.c.a
            public final void onCancel() {
                AppMethodBeat.i(128801);
                Log.i("MicroMsg.WelcomeActivity", "facebook login cancel");
                AppMethodBeat.o(128801);
            }
        });
        AppMethodBeat.o(128818);
    }

    static /* synthetic */ void c(WelcomeActivity welcomeActivity) {
        AppMethodBeat.i(128819);
        String string = welcomeActivity.getString(R.string.bjm, new Object[]{"0x" + Integer.toHexString(com.tencent.mm.protocal.d.KyO), LocaleUtil.getApplicationLanguage()});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        com.tencent.mm.plugin.account.a.a.jRt.i(intent, welcomeActivity);
        AppMethodBeat.o(128819);
    }
}

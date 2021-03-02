package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.facebook.GraphRequest;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.h.a.b;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.h.a.d;
import com.tencent.mm.ui.h.a.e;
import com.tencent.tav.decoder.EncoderWriter;
import org.json.JSONObject;

public class FacebookLoginUI extends MMPreference implements i {
    private static final String[] kkg = {"public_profile", Scopes.EMAIL, "user_location"};
    private String edo = "";
    private String kbV;
    private d kkF;
    private String kkI = "";
    private IListener kkK = new IListener<lz>() {
        /* class com.tencent.mm.plugin.account.ui.FacebookLoginUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161700);
            this.__eventId = lz.class.getName().hashCode();
            AppMethodBeat.o(161700);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lz lzVar) {
            AppMethodBeat.i(127980);
            lz lzVar2 = lzVar;
            if (lzVar2 == null || lzVar2.dRz == null) {
                AppMethodBeat.o(127980);
                return false;
            }
            Log.i("MicroMsg.FacebookLoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", lzVar2.dRz.content, lzVar2.dRz.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", lzVar2.dRz.content);
            intent.putExtra("key_disaster_url", lzVar2.dRz.url);
            intent.setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/FacebookLoginUI$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/account/ui/FacebookLoginUI$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(127980);
            return true;
        }
    };
    private c kkV;
    private q kkW;
    private t kkX;
    private ka kkY = new ka();
    private c kkZ;
    private DialogInterface.OnCancelListener kke;
    boolean kla = true;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FacebookLoginUI() {
        AppMethodBeat.i(127999);
        AppMethodBeat.o(127999);
    }

    static /* synthetic */ void b(FacebookLoginUI facebookLoginUI) {
        AppMethodBeat.i(128013);
        facebookLoginUI.bpa();
        AppMethodBeat.o(128013);
    }

    static /* synthetic */ void e(FacebookLoginUI facebookLoginUI) {
        AppMethodBeat.i(128014);
        facebookLoginUI.bpc();
        AppMethodBeat.o(128014);
    }

    static /* synthetic */ void i(FacebookLoginUI facebookLoginUI) {
        AppMethodBeat.i(128016);
        facebookLoginUI.goBack();
        AppMethodBeat.o(128016);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(EncoderWriter.OUTPUT_AUDIO_BIT_RATE);
        super.onCreate(bundle);
        setMMTitle(R.string.elp);
        com.tencent.mm.plugin.account.a.a.jRu.Xc();
        this.kbV = com.tencent.mm.plugin.b.a.caK();
        initView();
        g.azz().a(701, this);
        g.azz().a(252, this);
        AppMethodBeat.o(EncoderWriter.OUTPUT_AUDIO_BIT_RATE);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128001);
        super.onDestroy();
        g.azz().b(701, this);
        g.azz().b(252, this);
        AppMethodBeat.o(128001);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(128002);
        EventCenter.instance.addListener(this.kkK);
        super.onResume();
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L100_200_FB,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("L100_200_FB")).append(",1").toString());
        com.tencent.mm.plugin.b.a.bxk("L100_200_FB");
        AppMethodBeat.o(128002);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128003);
        super.onPause();
        EventCenter.instance.removeListener(this.kkK);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L100_200_FB,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("L100_200_FB")).append(",2").toString());
        AppMethodBeat.o(128003);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128004);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(128004);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128004);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(128005);
        com.tencent.mm.plugin.b.a.bxl(this.kbV);
        finish();
        AppMethodBeat.o(128005);
    }

    private void bpa() {
        AppMethodBeat.i(128006);
        if (isFinishing()) {
            AppMethodBeat.o(128006);
            return;
        }
        getString(R.string.zb);
        this.kkW = h.a((Context) this, getString(R.string.emm), true, (DialogInterface.OnCancelListener) null);
        this.kkW.setOnCancelListener(this.kke);
        Log.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", "facebook@wechat_auth", Integer.valueOf(this.kkI.length()), this.kkI.substring(0, 4));
        this.kkX = new t("facebook@wechat_auth", this.kkI, 0, "", "", "", 0, "", true, false);
        g.azz().a(this.kkX, 0);
        AppMethodBeat.o(128006);
    }

    private void bpb() {
        AppMethodBeat.i(128007);
        if (r.s(this, "com.facebook.katana")) {
            if (this.kkF == null) {
                this.kkF = new d(getString(R.string.c71));
                this.kkF.gWp();
            }
            if (!this.kkF.gWo()) {
                this.kkF.logout();
                this.kkF.a(this, new d.b() {
                    /* class com.tencent.mm.plugin.account.ui.FacebookLoginUI.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.h.a.d.b
                    public final void onSuccess() {
                        AppMethodBeat.i(127983);
                        Log.i("MicroMsg.FacebookLoginUI", "facebook-android login success!");
                        FacebookLoginUI.this.kkI = FacebookLoginUI.this.kkF.QjM.getToken();
                        FacebookLoginUI.b(FacebookLoginUI.this);
                        AppMethodBeat.o(127983);
                    }

                    @Override // com.tencent.mm.ui.h.a.d.b
                    public final void onCancel() {
                        AppMethodBeat.i(127984);
                        Log.i("MicroMsg.FacebookLoginUI", "facebook-android login cancel!");
                        AppMethodBeat.o(127984);
                    }

                    @Override // com.tencent.mm.ui.h.a.d.b
                    public final void onError(String str) {
                        AppMethodBeat.i(127985);
                        Log.i("MicroMsg.FacebookLoginUI", "facebook-android login error! %s", str);
                        h.c(FacebookLoginUI.this, FacebookLoginUI.this.getString(R.string.c77), "", true);
                        AppMethodBeat.o(127985);
                    }
                }, kkg);
            } else {
                bpa();
            }
        } else {
            try {
                if (this.kkV != null) {
                    this.kkV.kx(this);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FacebookLoginUI", e2, "", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L14,");
            g.aAf();
            com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("L14")).append(",1").toString());
            this.kkV = new c(getString(R.string.c71));
            this.kkV.a(this, kkg, new a(this, (byte) 0));
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(582, 5, 1, false);
        AppMethodBeat.o(128007);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01f4  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int r10, int r11, java.lang.String r12, com.tencent.mm.ak.q r13) {
        /*
        // Method dump skipped, instructions count: 612
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.FacebookLoginUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    private void bpc() {
        AppMethodBeat.i(128009);
        String string = getString(R.string.bjm, new Object[]{"0x" + Integer.toHexString(com.tencent.mm.protocal.d.KyO), LocaleUtil.getApplicationLanguage()});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        com.tencent.mm.plugin.account.a.a.jRt.i(intent, this);
        AppMethodBeat.o(128009);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128010);
        this.kkV = new c(getString(R.string.c71));
        this.kke = new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.FacebookLoginUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(127981);
                if (FacebookLoginUI.this.kkX != null) {
                    g.azz().a(FacebookLoginUI.this.kkX);
                }
                AppMethodBeat.o(127981);
            }
        };
        bpb();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.FacebookLoginUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127982);
                FacebookLoginUI.i(FacebookLoginUI.this);
                AppMethodBeat.o(127982);
                return true;
            }
        });
        AppMethodBeat.o(128010);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4 = 0;
        AppMethodBeat.i(128011);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(intent == null);
        Log.i("MicroMsg.FacebookLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", objArr);
        if (i3 == -1 && i2 == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(Util.isNullOrNil(stringExtra));
            if (!Util.isNullOrNil(stringExtra)) {
                i4 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i4);
            objArr2[2] = Integer.valueOf(intExtra);
            Log.i("MicroMsg.FacebookLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", objArr2);
            if (intExtra == -217) {
                bpb();
                AppMethodBeat.o(128011);
                return;
            }
        }
        if (this.kkV != null) {
            this.kkV.j(i2, i3, intent);
        }
        if (this.kkF != null) {
            this.kkF.j(i2, i3, intent);
        }
        AppMethodBeat.o(128011);
    }

    /* access modifiers changed from: package-private */
    public final class a implements c.a {
        private a() {
        }

        /* synthetic */ a(FacebookLoginUI facebookLoginUI, byte b2) {
            this();
        }

        @Override // com.tencent.mm.ui.h.a.c.a
        public final void E(Bundle bundle) {
            AppMethodBeat.i(127995);
            FacebookLoginUI.this.kkI = FacebookLoginUI.this.kkV.jZX;
            FacebookLoginUI.b(FacebookLoginUI.this);
            AppMethodBeat.o(127995);
        }

        @Override // com.tencent.mm.ui.h.a.c.a
        public final void a(e eVar) {
            AppMethodBeat.i(127996);
            Log.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + eVar.getMessage());
            h.c(FacebookLoginUI.this, eVar.getMessage(), FacebookLoginUI.this.getString(R.string.c77), true);
            FacebookLoginUI.bpd();
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
            g.aAf();
            com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("L14")).append(",2").toString());
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(582, 7, 1, false);
            AppMethodBeat.o(127996);
        }

        @Override // com.tencent.mm.ui.h.a.c.a
        public final void a(b bVar) {
            AppMethodBeat.i(127997);
            Log.d("MicroMsg.FacebookLoginUI", "onError:" + bVar.getMessage());
            h.c(FacebookLoginUI.this, bVar.getMessage(), FacebookLoginUI.this.getString(R.string.c77), true);
            FacebookLoginUI.bpd();
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
            g.aAf();
            com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("L14")).append(",2").toString());
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(582, 8, 1, false);
            AppMethodBeat.o(127997);
        }

        @Override // com.tencent.mm.ui.h.a.c.a
        public final void onCancel() {
            AppMethodBeat.i(127998);
            Log.d("MicroMsg.FacebookLoginUI", "onCancel");
            FacebookLoginUI.bpd();
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
            g.aAf();
            com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("L14")).append(",2").toString());
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(582, 9, 1, false);
            AppMethodBeat.o(127998);
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.ax;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(128012);
        String str = preference.mKey;
        if (str == null) {
            Log.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
            AppMethodBeat.o(128012);
            return true;
        } else if (str.equals("facebook_auth_bind_btn")) {
            bpb();
            AppMethodBeat.o(128012);
            return true;
        } else {
            AppMethodBeat.o(128012);
            return false;
        }
    }

    static /* synthetic */ void f(FacebookLoginUI facebookLoginUI) {
        AppMethodBeat.i(128015);
        if (r.s(facebookLoginUI, "com.facebook.katana")) {
            facebookLoginUI.kkF.a("name,picture.type(large)", new d.a() {
                /* class com.tencent.mm.plugin.account.ui.FacebookLoginUI.AnonymousClass5 */

                @Override // com.tencent.mm.ui.h.a.d.a
                public final void A(JSONObject jSONObject) {
                    AppMethodBeat.i(127986);
                    Log.i("MicroMsg.FacebookLoginUI", "facebook-android get name and picture completed!");
                    if (jSONObject != null) {
                        try {
                            Intent intent = new Intent(FacebookLoginUI.this, RegByMobileRegAIOUI.class);
                            String str = null;
                            if (!(FacebookLoginUI.this.kkF.QjM == null || FacebookLoginUI.this.kkF.QjM.getToken() == null)) {
                                str = FacebookLoginUI.this.kkF.QjM.getToken().toString();
                            }
                            intent.putExtra("third_app_token", str);
                            intent.putExtra("register_title", FacebookLoginUI.this.getString(R.string.biw));
                            if (jSONObject.has("name")) {
                                intent.putExtra("register_nick_name", jSONObject.getString("name"));
                                Log.i("MicroMsg.FacebookLoginUI", "name %s", jSONObject.getString("name"));
                            }
                            if (jSONObject.has("picture")) {
                                Log.i("MicroMsg.FacebookLoginUI", "picture %s", jSONObject.get("picture"));
                                intent.putExtra("register_avatar", ((JSONObject) jSONObject.get("picture")).getJSONObject("data").getString("url"));
                            }
                            FacebookLoginUI facebookLoginUI = FacebookLoginUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(facebookLoginUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/FacebookLoginUI$3", "onCompleted", "(Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            facebookLoginUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(facebookLoginUI, "com/tencent/mm/plugin/account/ui/FacebookLoginUI$3", "onCompleted", "(Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            FacebookLoginUI.this.finish();
                            FacebookLoginUI.this.kkY.eTd = 1;
                            FacebookLoginUI.this.kkY.ejA = 4;
                            FacebookLoginUI.this.kkY.bfK();
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.FacebookLoginUI", e2, "parse json error!", new Object[0]);
                            h.c(FacebookLoginUI.this, "Retrieve Failed, Error Format!", "", true);
                            AppMethodBeat.o(127986);
                            return;
                        }
                    }
                    AppMethodBeat.o(127986);
                }

                @Override // com.tencent.mm.ui.h.a.d.a
                public final void onError(String str) {
                    AppMethodBeat.i(127987);
                    Log.i("MicroMsg.FacebookLoginUI", "facebook-android get name and picture error! %s", str);
                    h.c(FacebookLoginUI.this, FacebookLoginUI.this.getString(R.string.c77), "", true);
                    AppMethodBeat.o(127987);
                }
            });
            AppMethodBeat.o(128015);
            return;
        }
        g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
            /* class com.tencent.mm.plugin.account.ui.FacebookLoginUI.AnonymousClass6 */
            JSONObject klc = null;

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean doInBackground() {
                AppMethodBeat.i(127988);
                Bundle bundle = new Bundle();
                bundle.putString(GraphRequest.FIELDS_PARAM, "name,picture.type(large)");
                try {
                    String r = FacebookLoginUI.this.kkV.r("me", bundle);
                    Log.i("MicroMsg.FacebookLoginUI", "result json %s", r);
                    this.klc = new JSONObject(r);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FacebookLoginUI", e2, "get name and picture error!", new Object[0]);
                    h.c(FacebookLoginUI.this, "Retrieve Failed, Error Format!", "", true);
                }
                AppMethodBeat.o(127988);
                return true;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean onPostExecute() {
                AppMethodBeat.i(127989);
                if (this.klc != null) {
                    try {
                        Intent intent = new Intent(FacebookLoginUI.this, RegByMobileRegAIOUI.class);
                        intent.putExtra("third_app_token", FacebookLoginUI.this.kkV.jZX.toString());
                        intent.putExtra("register_title", FacebookLoginUI.this.getString(R.string.biw));
                        intent.putExtra("register_nick_name", this.klc.getString("name"));
                        intent.putExtra("register_avatar", ((JSONObject) this.klc.get("picture")).getJSONObject("data").getString("url"));
                        FacebookLoginUI facebookLoginUI = FacebookLoginUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(facebookLoginUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/FacebookLoginUI$4", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        facebookLoginUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(facebookLoginUI, "com/tencent/mm/plugin/account/ui/FacebookLoginUI$4", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        FacebookLoginUI.this.kkY.eTd = 1;
                        FacebookLoginUI.this.kkY.ejA = 4;
                        FacebookLoginUI.this.kkY.bfK();
                        FacebookLoginUI.this.finish();
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.FacebookLoginUI", e2, "parse json error!", new Object[0]);
                        h.c(FacebookLoginUI.this, "Retrieve Failed, Error Format!", "", true);
                    }
                }
                AppMethodBeat.o(127989);
                return true;
            }
        });
        AppMethodBeat.o(128015);
    }

    static /* synthetic */ void bpd() {
        AppMethodBeat.i(128017);
        g.aAh().hqB.set(20, Integer.valueOf(Util.nullAs((Integer) g.aAh().hqB.get(20), 0) + 1));
        AppMethodBeat.o(128017);
    }
}

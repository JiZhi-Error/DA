package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.pay.tool.APPluginConstants;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bu;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.b;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.ui.h;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;

@a(19)
public class LoginHistoryUI extends MMActivity implements i {
    private String edo = "";
    protected ProgressDialog gtM = null;
    private SecurityImage kdp = null;
    protected String kjv;
    private IListener kkK = new IListener<lz>() {
        /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161701);
            this.__eventId = lz.class.getName().hashCode();
            AppMethodBeat.o(161701);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lz lzVar) {
            AppMethodBeat.i(128088);
            lz lzVar2 = lzVar;
            if (lzVar2 == null || lzVar2.dRz == null) {
                AppMethodBeat.o(128088);
                return false;
            }
            Log.i("MicroMsg.LoginHistoryUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", lzVar2.dRz.content, lzVar2.dRz.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", lzVar2.dRz.content);
            intent.putExtra("key_disaster_url", lzVar2.dRz.url);
            intent.setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128088);
            return true;
        }
    };
    protected TextView klL;
    protected EditText klM;
    protected Button klN;
    protected Button klO;
    protected View klP;
    protected View klQ;
    protected View klR;
    protected Button klS;
    protected Button klT;
    private View klU;
    protected Button klV;
    protected String klW;
    protected String klX;
    private String klY;
    private ImageView klZ;
    protected g klt = new g();
    protected boolean klu;
    private String klx;
    protected String kly = "";
    private MMKeyboardUperView kma;
    private ResizeLayout kmb;
    protected String kmc;
    protected String kmd;
    private String kme;
    private b kmf;
    protected LinearLayout kmg;
    protected LinearLayout kmh;
    protected LinearLayout kmi;
    protected MMFormInputView kmj;
    protected MMFormVerifyCodeInputView kmk;
    private Button kml;
    protected boolean kmm = false;
    private int kmn;
    private int kmo;
    private boolean kmp = false;
    private String kmq;
    protected int[] kmr = new int[5];
    private int kms = 0;
    protected int loginType;
    private SharedPreferences sp;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LoginHistoryUI() {
        AppMethodBeat.i(128117);
        AppMethodBeat.o(128117);
    }

    static /* synthetic */ void a(LoginHistoryUI loginHistoryUI, String str) {
        AppMethodBeat.i(128143);
        loginHistoryUI.Tu(str);
        AppMethodBeat.o(128143);
    }

    static /* synthetic */ void b(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.i(128138);
        loginHistoryUI.goBack();
        AppMethodBeat.o(128138);
    }

    static /* synthetic */ int i(LoginHistoryUI loginHistoryUI) {
        int i2 = loginHistoryUI.kms;
        loginHistoryUI.kms = i2 + 1;
        return i2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128118);
        super.onCreate(bundle);
        Log.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", com.tencent.mm.plugin.account.a.a.jRu);
        com.tencent.mm.plugin.account.a.a.jRu.Xc();
        this.sp = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        Intent intent = getIntent();
        if (intent != null) {
            this.kmp = intent.getBooleanExtra("login_success_need_bind_fingerprint", false);
            this.kmp = this.kmp;
            if (this.kmp) {
                this.kmq = intent.getStringExtra("bind_login_fingerprint_info");
            }
        }
        initView();
        this.kmf = new b();
        AppMethodBeat.o(128118);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128119);
        Log.i("MicroMsg.LoginHistoryUI", "onDestroy");
        g.azz().b(701, this);
        g.azz().b(252, this);
        if (this.kmf != null) {
            this.kmf.close();
        }
        h.INSTANCE.a(14262, Integer.valueOf(this.kmr[0]), Integer.valueOf(this.kmr[1]), Integer.valueOf(this.kmr[2]), Integer.valueOf(this.kmr[3]), Integer.valueOf(this.kmr[4]));
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        super.onDestroy();
        AppMethodBeat.o(128119);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128120);
        super.onResume();
        final ArrayList arrayList = new ArrayList();
        if (!(!bpi() || this.loginType == 1 || (this.kmn & 131072) == 0)) {
            n nVar = new n(this, TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL, 0);
            nVar.setTitle(R.string.emk);
            arrayList.add(nVar);
        }
        if (!(this.loginType == 5 || (this.kmn & TPMediaCodecProfileLevel.HEVCMainTierLevel52) == 0)) {
            n nVar2 = new n(this, 7005, 0);
            nVar2.setTitle(R.string.emh);
            arrayList.add(nVar2);
        }
        if (!Util.isNullOrNil(this.kmc)) {
            if (this.loginType != 2) {
                n nVar3 = new n(this, 7007, 0);
                nVar3.setTitle(getString(R.string.emi));
                arrayList.add(nVar3);
            }
            if (!Util.isNullOrNil(this.klX) && this.loginType != 3) {
                n nVar4 = new n(this, 7008, 0);
                nVar4.setTitle(getString(R.string.emj));
                arrayList.add(nVar4);
            }
            if (this.kmc.equalsIgnoreCase(this.klW)) {
                this.klM.setHint(getString(R.string.g0h));
            }
        }
        if (arrayList.size() > 1) {
            final e eVar = new e((Context) this, 1, false);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass23 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(128105);
                    if (mVar.size() == 0) {
                        for (n nVar : arrayList) {
                            mVar.g(nVar);
                        }
                    }
                    AppMethodBeat.o(128105);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass24 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(128106);
                    LoginHistoryUI.a(LoginHistoryUI.this, menuItem.getItemId());
                    AppMethodBeat.o(128106);
                }
            };
            eVar.PGl = new e.b() {
                /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass25 */

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                }
            };
            this.klO.setVisibility(0);
            this.klO.setText(R.string.ely);
            this.klO.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass26 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128107);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    LoginHistoryUI.this.hideVKB();
                    eVar.dGm();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128107);
                }
            });
        } else if (arrayList.size() > 0) {
            this.klO.setVisibility(0);
            this.klO.setText(((n) arrayList.get(0)).getTitle());
            this.klO.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass27 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128108);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    LoginHistoryUI.a(LoginHistoryUI.this, ((n) arrayList.get(0)).getItemId());
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128108);
                }
            });
        } else {
            this.klO.setVisibility(8);
        }
        EventCenter.instance.addListener(this.kkK);
        g.aAf();
        com.tencent.mm.kernel.a.azu();
        if (!g.aAc() || !g.aAf().hpY || this.kmc.equals("")) {
            if (com.tencent.mm.p.a.ats() == 2) {
                d.a aVar = new d.a(this);
                aVar.aoO(R.string.b3h);
                aVar.boo(getString(R.string.b3g));
                aVar.Dk(false);
                aVar.aoV(R.string.b3e).c(new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass22 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(128104);
                        Log.i("MicroMsg.LoginHistoryUI", "db dangerous and auto logout");
                        LoginHistoryUI.a(LoginHistoryUI.this);
                        AppMethodBeat.o(128104);
                    }
                });
                aVar.hbn().show();
                com.tencent.mm.p.a.b(this, System.currentTimeMillis());
            }
            AppMethodBeat.o(128120);
        } else if (this.gtM == null || !this.gtM.isShowing()) {
            b((t) null);
            AppMethodBeat.o(128120);
        } else {
            AppMethodBeat.o(128120);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128121);
        super.onPause();
        EventCenter.instance.removeListener(this.kkK);
        AppMethodBeat.o(128121);
    }

    private void goBack() {
        AppMethodBeat.i(128122);
        Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
        bZ.addFlags(67108864);
        if (Util.isNullOrNil(this.klY)) {
            bZ.putExtra("can_finish", true);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.ui.base.b.kd(this);
        AppMethodBeat.o(128122);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128123);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128123);
        return onKeyDown;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x02d6  */
    @Override // com.tencent.mm.ui.MMActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 950
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.LoginHistoryUI.initView():void");
    }

    /* access modifiers changed from: protected */
    public final String Ts(String str) {
        AppMethodBeat.i(128125);
        PhoneFormater phoneFormater = new PhoneFormater();
        String str2 = "86";
        if (this.kmc.startsWith("+") && (str2 = PhoneFormater.extractCountryCode((str = str.replace("+", "")))) != null) {
            str = str.substring(str2.length());
        }
        String formatNumber = phoneFormater.formatNumber(str2, str);
        AppMethodBeat.o(128125);
        return formatNumber;
    }

    /* access modifiers changed from: protected */
    public final void bpg() {
        AppMethodBeat.i(128126);
        g.azz().a(701, this);
        g.azz().a(252, this);
        AppMethodBeat.o(128126);
    }

    /* access modifiers changed from: protected */
    public final void bph() {
        AppMethodBeat.i(128127);
        g.azz().b(701, this);
        g.azz().b(252, this);
        AppMethodBeat.o(128127);
    }

    /* access modifiers changed from: protected */
    public void bpf() {
        AppMethodBeat.i(128128);
        this.klt.account = this.kmc.trim();
        AppMethodBeat.o(128128);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.MMFragmentActivity
    public void hideVKB() {
        AppMethodBeat.i(128129);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(128129);
            return;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.o(128129);
            return;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(128129);
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        AppMethodBeat.o(128129);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle bundleExtra;
        int i4 = 0;
        AppMethodBeat.i(128130);
        super.onActivityResult(i2, i3, intent);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(intent == null);
        Log.d("MicroMsg.LoginHistoryUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", objArr);
        if (i2 != 1024 || intent == null) {
            if (i2 != 1025 || intent == null) {
                if (i2 == 31685 && intent != null && i3 == -1 && (bundleExtra = intent.getBundleExtra("result_data")) != null && bundleExtra.getString("go_next", "").equals("auth_again")) {
                    bpf();
                }
            } else if (i3 == 2) {
                String stringExtra = intent.getStringExtra("KFaceLoginAuthPwd");
                Object[] objArr2 = new Object[2];
                objArr2[0] = Boolean.valueOf(Util.isNullOrNil(stringExtra));
                if (!Util.isNullOrNil(stringExtra)) {
                    i4 = stringExtra.length();
                }
                objArr2[1] = Integer.valueOf(i4);
                Log.i("MicroMsg.LoginHistoryUI", "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", objArr2);
                Tt(stringExtra);
                AppMethodBeat.o(128130);
                return;
            }
        } else if (i3 == -1) {
            String stringExtra2 = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            Object[] objArr3 = new Object[3];
            objArr3[0] = Boolean.valueOf(Util.isNullOrNil(stringExtra2));
            if (!Util.isNullOrNil(stringExtra2)) {
                i4 = stringExtra2.length();
            }
            objArr3[1] = Integer.valueOf(i4);
            objArr3[2] = Integer.valueOf(intExtra);
            Log.d("MicroMsg.LoginHistoryUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", objArr3);
            Tt(stringExtra2);
            AppMethodBeat.o(128130);
            return;
        }
        AppMethodBeat.o(128130);
    }

    private void Tt(String str) {
        AppMethodBeat.i(128131);
        this.kly = str;
        bpf();
        AppMethodBeat.o(128131);
    }

    private void Tu(String str) {
        AppMethodBeat.i(128132);
        Log.i("MicroMsg.LoginHistoryUI", "requestSms %s", str);
        if (!Util.isNullOrNil(str)) {
            final com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(str, 16, "", 0, "");
            g.azz().a(aVar, 0);
            getString(R.string.zb);
            this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass8 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(128094);
                    g.azz().a(aVar);
                    AppMethodBeat.o(128094);
                }
            });
        }
        AppMethodBeat.o(128132);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(128133);
        Log.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        Log.i("MicroMsg.LoginHistoryUI", "Scene Type " + qVar.getType());
        if (qVar.getType() == 145) {
            if (this.gtM != null && this.gtM.isShowing()) {
                this.gtM.dismiss();
                this.gtM = null;
            }
            int Vj = ((com.tencent.mm.modelfriend.a) qVar).Vj();
            if (Vj == 13) {
                if (i3 == -36) {
                    com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                    if (((com.tencent.mm.modelfriend.a) qVar).bbJ() == 1) {
                        Log.i("MicroMsg.LoginHistoryUI", "login check state, sms up");
                        if (Dk != null) {
                            Dk.a(this, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass9 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(128095);
                                    LoginHistoryUI.g(LoginHistoryUI.this);
                                    AppMethodBeat.o(128095);
                                }
                            }, null);
                            AppMethodBeat.o(128133);
                            return;
                        }
                        com.tencent.mm.ui.base.h.a(this, getString(R.string.em3), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass10 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128096);
                                LoginHistoryUI.g(LoginHistoryUI.this);
                                AppMethodBeat.o(128096);
                            }
                        }, (DialogInterface.OnClickListener) null);
                    } else if (Dk != null) {
                        Dk.a(this, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass11 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128097);
                                LoginHistoryUI.this.kmk.bTu();
                                LoginHistoryUI.a(LoginHistoryUI.this, LoginHistoryUI.this.klX);
                                AppMethodBeat.o(128097);
                            }
                        }, null);
                        AppMethodBeat.o(128133);
                        return;
                    } else {
                        this.kmk.bTu();
                        Tu(this.klX);
                    }
                }
            } else if (Vj == 16) {
                if (i3 == -41) {
                    com.tencent.mm.ui.base.h.n(this, R.string.fz6, R.string.fz7);
                    this.kmk.reset();
                    AppMethodBeat.o(128133);
                    return;
                } else if (i3 == -75) {
                    com.tencent.mm.ui.base.h.c(this, getString(R.string.gz), "", true);
                    this.kmk.reset();
                    AppMethodBeat.o(128133);
                    return;
                } else if (i3 == -106) {
                    y.g(this, str, 32045);
                    this.kmk.reset();
                    AppMethodBeat.o(128133);
                    return;
                }
            } else if (Vj == 17) {
                if (i2 == 0 && i3 == 0) {
                    new h(new h.a() {
                        /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass12 */

                        @Override // com.tencent.mm.plugin.account.ui.h.a
                        public final void a(ProgressDialog progressDialog) {
                            LoginHistoryUI.this.gtM = progressDialog;
                        }
                    }, ((com.tencent.mm.modelfriend.a) qVar).getUsername(), ((com.tencent.mm.modelfriend.a) qVar).bbF(), this.klX).b(this);
                    AppMethodBeat.o(128133);
                    return;
                } else if (n(i2, i3, str)) {
                    AppMethodBeat.o(128133);
                    return;
                } else {
                    com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
                    if (Dk2 != null) {
                        Dk2.a(this, null, null);
                    }
                }
            }
        } else if (qVar.getType() == 252 || qVar.getType() == 701) {
            this.edo = ((t) qVar).bfk();
            Log.e("MicroMsg.LoginHistoryUI", "url " + this.edo);
            g.azz().b(701, this);
            g.azz().b(252, this);
            this.klt.kmJ = ((t) qVar).getSecCodeType();
            this.klt.kds = ((t) qVar).bfl();
            this.klt.kdr = ((t) qVar).bfm();
            this.klt.kdt = ((t) qVar).bfn();
            if (i3 == -205) {
                this.kjv = ((t) qVar).bbH();
                this.klX = ((t) qVar).bfp();
                this.klx = ((t) qVar).bfs();
            }
            if (i2 == 4 && (i3 == -16 || i3 == -17)) {
                g.azz().a(new bu(new bu.a() {
                    /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass13 */

                    @Override // com.tencent.mm.model.bu.a
                    public final void a(com.tencent.mm.network.g gVar) {
                        AppMethodBeat.i(128098);
                        if (gVar == null) {
                            AppMethodBeat.o(128098);
                            return;
                        }
                        g.aAf();
                        gVar.aZh().a(new byte[0], new byte[0], new byte[0], com.tencent.mm.kernel.a.getUin());
                        AppMethodBeat.o(128098);
                    }
                }), 0);
                z = true;
            } else {
                z = false;
            }
            if (z || (i2 == 0 && i3 == 0)) {
                com.tencent.mm.kernel.a.unhold();
                l.boe();
                com.tencent.mm.platformtools.t.dr(this);
                y.St(this.klt.account);
                if (this.gtM != null && this.gtM.isShowing()) {
                    this.gtM.setMessage(getString(R.string.wc));
                }
                b((t) qVar);
                if (this.loginType == 3) {
                    this.klu = ((t) qVar).bfu();
                    if (((t) qVar).bfo()) {
                        boolean z2 = this.klu;
                        Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
                        intent.putExtra("kintent_hint", getString(R.string.gr1));
                        intent.putExtra("kintent_cancelable", z2);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                }
                AppMethodBeat.o(128133);
                return;
            }
            if (this.gtM != null && this.gtM.isShowing()) {
                this.gtM.dismiss();
                this.gtM = null;
            }
            if (i3 == -106) {
                y.g(this, str, 31685);
                AppMethodBeat.o(128133);
                return;
            } else if (i3 == -217) {
                y.a(this, com.tencent.mm.platformtools.e.a((t) qVar), i3);
                AppMethodBeat.o(128133);
                return;
            } else if (n(i2, i3, str)) {
                AppMethodBeat.o(128133);
                return;
            } else {
                com.tencent.mm.h.a Dk3 = com.tencent.mm.h.a.Dk(str);
                if (Dk3 == null || !Dk3.a(this, null, null)) {
                    Toast.makeText(this, getString(R.string.de5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                } else {
                    AppMethodBeat.o(128133);
                    return;
                }
            }
        }
        if (n(i2, i3, str)) {
            AppMethodBeat.o(128133);
        } else {
            AppMethodBeat.o(128133);
        }
    }

    private void b(t tVar) {
        AppMethodBeat.i(128134);
        Log.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", Integer.valueOf(hashCode()), Util.getStack());
        Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
        bZ.addFlags(67108864);
        if (tVar != null) {
            bZ.putExtra("kstyle_show_bind_mobile_afterauth", tVar.bfq());
            bZ.putExtra("kstyle_bind_recommend_show", tVar.bft());
            bZ.putExtra("kstyle_bind_wording", tVar.bfr());
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(128134);
    }

    private boolean n(final int i2, int i3, String str) {
        String ayX;
        AppMethodBeat.i(128135);
        if (i2 == 4) {
            switch (i3) {
                case -2023:
                case -100:
                    com.tencent.mm.kernel.a.hold();
                    g.aAf();
                    if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {
                        ayX = com.tencent.mm.cb.a.aI(this, R.string.ev5);
                    } else {
                        g.aAf();
                        ayX = com.tencent.mm.kernel.a.ayX();
                    }
                    com.tencent.mm.ui.base.h.a(this, ayX, getString(R.string.zb), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass20 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }, new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass21 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    AppMethodBeat.o(128135);
                    return true;
                case -311:
                case -310:
                case -6:
                    g.azz().a(701, this);
                    g.azz().a(252, this);
                    if (this.kdp == null) {
                        this.kdp = SecurityImage.a.a(this, this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass18 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                int i3 = -1;
                                AppMethodBeat.i(128102);
                                Log.d("MicroMsg.LoginHistoryUI", "imgSid:" + LoginHistoryUI.this.klt.kds + " img len" + LoginHistoryUI.this.klt.kdr.length + " " + f.apq());
                                Object[] objArr = new Object[5];
                                objArr[0] = Integer.valueOf(i2);
                                objArr[1] = Integer.valueOf(LoginHistoryUI.this.kly == null ? -1 : LoginHistoryUI.this.kly.length());
                                objArr[2] = Util.secPrint(LoginHistoryUI.this.kly);
                                if (LoginHistoryUI.this.klt.kdq != null) {
                                    i3 = LoginHistoryUI.this.klt.kdq.length();
                                }
                                objArr[3] = Integer.valueOf(i3);
                                objArr[4] = Util.secPrint(LoginHistoryUI.this.klt.kdq);
                                Log.d("MicroMsg.LoginHistoryUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", objArr);
                                final t tVar = new t(LoginHistoryUI.this.klt.account, LoginHistoryUI.this.klt.kdq, LoginHistoryUI.this.klt.kmJ, LoginHistoryUI.this.kdp.getSecImgCode(), LoginHistoryUI.this.kdp.getSecImgSid(), LoginHistoryUI.this.kdp.getSecImgEncryptKey(), 0, "", false, false);
                                if (Util.isNullOrNil(LoginHistoryUI.this.klt.kdq) && !Util.isNullOrNil(LoginHistoryUI.this.kly)) {
                                    Log.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", Util.secPrint(LoginHistoryUI.this.kly));
                                    tVar.PA(LoginHistoryUI.this.kly);
                                }
                                g.azz().a(tVar, 0);
                                LoginHistoryUI loginHistoryUI = LoginHistoryUI.this;
                                LoginHistoryUI loginHistoryUI2 = LoginHistoryUI.this;
                                LoginHistoryUI.this.getString(R.string.zb);
                                loginHistoryUI.gtM = com.tencent.mm.ui.base.h.a((Context) loginHistoryUI2, LoginHistoryUI.this.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass18.AnonymousClass1 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(128101);
                                        g.azz().a(tVar);
                                        g.azz().b(701, LoginHistoryUI.this);
                                        g.azz().b(252, LoginHistoryUI.this);
                                        AppMethodBeat.o(128101);
                                    }
                                });
                                AppMethodBeat.o(128102);
                            }
                        }, null, new DialogInterface.OnDismissListener() {
                            /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass19 */

                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(128103);
                                LoginHistoryUI.this.kdp = null;
                                AppMethodBeat.o(128103);
                            }
                        }, this.klt);
                    } else {
                        Log.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.klt.kds + " img len" + this.klt.kdr.length + " " + f.apq());
                        this.kdp.b(this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt);
                    }
                    AppMethodBeat.o(128135);
                    return true;
                case -205:
                    Log.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", Util.secPrint(this.kjv), this.klx);
                    g.a(this.klt);
                    Intent intent = new Intent();
                    intent.putExtra("auth_ticket", this.kjv);
                    intent.putExtra("binded_mobile", this.klX);
                    intent.putExtra("close_safe_device_style", this.klx);
                    intent.putExtra("from_source", 2);
                    com.tencent.mm.plugin.account.a.a.jRt.g(this, intent);
                    AppMethodBeat.o(128135);
                    return true;
                case -140:
                    if (!Util.isNullOrNil(this.edo)) {
                        y.m(this, str, this.edo);
                    }
                    AppMethodBeat.o(128135);
                    return true;
                case -75:
                    y.dz(this);
                    AppMethodBeat.o(128135);
                    return true;
                case -72:
                    com.tencent.mm.ui.base.h.n(this, R.string.g0b, R.string.zb);
                    AppMethodBeat.o(128135);
                    return true;
                case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidClassException:
                    com.tencent.mm.ui.base.h.a(this, (int) R.string.af3, (int) R.string.af9, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass17 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(128135);
                    return true;
                case APPluginConstants.ERROR_IO_NoHttpResponseException:
                    com.tencent.mm.ui.base.h.d(this, getString(R.string.af5), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass16 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(128135);
                    return true;
                case -9:
                    com.tencent.mm.ui.base.h.n(this, R.string.em7, R.string.em8);
                    AppMethodBeat.o(128135);
                    return true;
                case -3:
                    if (this.kms <= 0) {
                        com.tencent.mm.ui.base.h.n(this, R.string.by2, R.string.em8);
                        this.kms++;
                    } else {
                        com.tencent.mm.ui.base.h.c(this, getString(R.string.by3), getString(R.string.em8), getString(R.string.by4), getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass14 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128099);
                                LoginHistoryUI.h(LoginHistoryUI.this);
                                AppMethodBeat.o(128099);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass15 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128100);
                                LoginHistoryUI.i(LoginHistoryUI.this);
                                AppMethodBeat.o(128100);
                            }
                        });
                    }
                    AppMethodBeat.o(128135);
                    return true;
                case -1:
                    if (g.azz().aYS() == 5) {
                        com.tencent.mm.ui.base.h.n(this, R.string.fbf, R.string.fbe);
                        AppMethodBeat.o(128135);
                        return true;
                    }
                    com.tencent.mm.ui.base.h.n(this, R.string.em7, R.string.em8);
                    AppMethodBeat.o(128135);
                    return true;
            }
        }
        if (com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str)) {
            if (this.kdp != null) {
                this.kdp.dismiss();
            }
            AppMethodBeat.o(128135);
            return true;
        }
        boolean a2 = this.kmf.a(this, new ae(i2, i3, str));
        AppMethodBeat.o(128135);
        return a2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b2k;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public void setRequestedOrientation(int i2) {
    }

    public static void Y(Context context, String str) {
        AppMethodBeat.i(128136);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(128136);
    }

    public boolean bpi() {
        AppMethodBeat.i(196864);
        if (!WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned()) {
            AppMethodBeat.o(196864);
            return true;
        }
        AppMethodBeat.o(196864);
        return false;
    }

    static /* synthetic */ void a(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.i(128137);
        MMEntryLock.unlock("welcome_page_show");
        com.tencent.mm.kernel.l.s(loginHistoryUI, true);
        ad adVar = new ad();
        adVar.dDb.dDc = false;
        EventCenter.instance.publish(adVar);
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().Xc();
        loginHistoryUI.finish();
        AppCompatActivity context = loginHistoryUI.getContext();
        Log.appenderFlush();
        MMNativeJpeg.Destroy();
        Intent intent = null;
        try {
            intent = new Intent().setClass(context, Class.forName(MMApplicationContext.getLaunchName()));
        } catch (ClassNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.LoginHistoryUI", e2, "", new Object[0]);
        }
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "exitApplication", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "exitApplication", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128137);
    }

    static /* synthetic */ void d(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.i(128139);
        loginHistoryUI.kmr[4] = 1;
        Intent intent = new Intent(loginHistoryUI, MobileInputUI.class);
        intent.putExtra("mobile_input_purpose", 1);
        int[] iArr = new int[5];
        iArr[4] = 1;
        intent.putExtra("kv_report_login_method_data", iArr);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(loginHistoryUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "switchUser", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        loginHistoryUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(loginHistoryUI, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "switchUser", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128139);
    }

    static /* synthetic */ void e(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.i(128140);
        if (com.tencent.mm.protocal.d.KyR) {
            String string = loginHistoryUI.getString(R.string.bjm, new Object[]{"0x" + Integer.toHexString(com.tencent.mm.protocal.d.KyO), LocaleUtil.getApplicationLanguage()});
            Log.e("MicroMsg.LoginHistoryUI", "url ".concat(String.valueOf(string)));
            Y(loginHistoryUI.getContext(), string);
            AppMethodBeat.o(128140);
            return;
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(loginHistoryUI, RegByMobileRegAIOUI.class));
        com.tencent.mm.hellhoundlib.a.a.a(loginHistoryUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "register", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        loginHistoryUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(loginHistoryUI, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "register", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128140);
    }

    static /* synthetic */ void f(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.i(128141);
        Y(loginHistoryUI.getContext(), loginHistoryUI.getString(R.string.j1x) + LocaleUtil.getApplicationLanguage());
        AppMethodBeat.o(128141);
    }

    static /* synthetic */ void g(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.i(128142);
        Intent intent = new Intent(loginHistoryUI, LoginByMobileSendSmsUI.class);
        intent.putExtra("from_mobile", loginHistoryUI.klX);
        intent.putExtra("switch_login_wx_id", loginHistoryUI.klY);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(loginHistoryUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "jumpToLoginSmsUp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        loginHistoryUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(loginHistoryUI, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "jumpToLoginSmsUp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128142);
    }

    static /* synthetic */ void h(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.i(128144);
        int i2 = 0;
        if (loginHistoryUI.kmo != 0) {
            if (!((loginHistoryUI.kmo & 2) == 0 && (loginHistoryUI.kmo & 4) == 0)) {
                i2 = 2;
            }
            if ((loginHistoryUI.kmo & 4) != 0) {
                i2 |= 4;
            }
            if ((loginHistoryUI.kmo & 1) != 0) {
                i2 |= 1;
            }
        } else if (!com.tencent.mm.aw.b.isOverseasUser()) {
            i2 = 7;
        } else {
            i2 = 6;
        }
        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(loginHistoryUI);
        lVar.HLX = new o.f(i2 | 8, loginHistoryUI) {
            /* class com.tencent.mm.plugin.account.ui.f.AnonymousClass1 */
            final /* synthetic */ int kld;
            final /* synthetic */ Context val$context;

            {
                this.kld = r1;
                this.val$context = r2;
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(128018);
                if ((this.kld & 1) != 0) {
                    mVar.d(1, this.val$context.getString(R.string.fxm));
                }
                if ((this.kld & 2) != 0) {
                    mVar.d(2, this.val$context.getString(R.string.fxn));
                }
                if ((this.kld & 4) != 0) {
                    mVar.d(4, this.val$context.getString(R.string.fxl));
                }
                if ((this.kld & 8) > 0) {
                    mVar.d(8, this.val$context.getString(R.string.j1w));
                }
                AppMethodBeat.o(128018);
            }
        };
        lVar.HLY = new o.g(loginHistoryUI) {
            /* class com.tencent.mm.plugin.account.ui.f.AnonymousClass2 */
            final /* synthetic */ String kle = null;
            final /* synthetic */ String klf = null;
            final /* synthetic */ String klg = null;
            final /* synthetic */ Context val$context;

            {
                this.val$context = r2;
            }

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                String str;
                AppMethodBeat.i(128019);
                switch (menuItem.getItemId()) {
                    case 1:
                        com.tencent.mm.plugin.b.a.bxl("F100_100_QQ");
                        StringBuilder sb = new StringBuilder();
                        g.aAf();
                        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(this.val$context.getClass().getName()).append(",F100_100_QQ,");
                        g.aAf();
                        com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("F100_100_QQ")).append(",1").toString());
                        f.X(this.val$context, this.val$context.getString(R.string.htr));
                        AppMethodBeat.o(128019);
                        return;
                    case 2:
                        com.tencent.mm.plugin.b.a.bxl("F100_100_Email");
                        StringBuilder sb2 = new StringBuilder();
                        g.aAf();
                        StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(this.val$context.getClass().getName()).append(",F100_100_Email,");
                        g.aAf();
                        com.tencent.mm.plugin.b.a.j(true, append2.append(com.tencent.mm.kernel.a.FN("F100_100_Email")).append(",1").toString());
                        f.X(this.val$context, this.val$context.getString(R.string.ema) + LocaleUtil.getApplicationLanguage());
                        AppMethodBeat.o(128019);
                        return;
                    case 4:
                        Context context = this.val$context;
                        String str2 = this.kle;
                        String str3 = this.klf;
                        String str4 = this.klg;
                        com.tencent.mm.plugin.b.a.bxl("F100_100_phone");
                        StringBuilder sb3 = new StringBuilder();
                        g.aAf();
                        StringBuilder append3 = sb3.append(com.tencent.mm.kernel.a.azt()).append(",").append(context.getClass().getName()).append(",F100_100_phone,");
                        g.aAf();
                        com.tencent.mm.plugin.b.a.j(true, append3.append(com.tencent.mm.kernel.a.FN("F100_100_phone")).append(",1").toString());
                        if (com.tencent.mm.protocal.d.KyR) {
                            Toast.makeText(context, context.getString(R.string.gz), 0).show();
                            AppMethodBeat.o(128019);
                            return;
                        }
                        Intent intent = new Intent(context, MobileInputUI.class);
                        if (str3 != null) {
                            int indexOf = str3.indexOf("+");
                            if (indexOf != -1 && str3.length() > 0) {
                                str3 = str3.substring(indexOf + 1);
                            }
                            intent.putExtra("couttry_code", str3);
                        }
                        if (str2 != null) {
                            intent.putExtra("country_name", str2);
                        }
                        if (str4 != null) {
                            intent.putExtra("bindmcontact_shortmobile", str4);
                        }
                        intent.putExtra("mobile_input_purpose", 1);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/ForgotPwdMenu", "loginBySMS", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/account/ui/ForgotPwdMenu", "loginBySMS", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(128019);
                        return;
                    case 8:
                        String string = this.val$context.getString(R.string.j1x);
                        if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA)) {
                            str = string + LocaleUtil.CHINA;
                        } else {
                            str = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1i) + "/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=";
                        }
                        f.X(this.val$context, str);
                        break;
                }
                AppMethodBeat.o(128019);
            }
        };
        lVar.gXI();
        AppMethodBeat.o(128144);
    }

    static /* synthetic */ void a(LoginHistoryUI loginHistoryUI, int i2) {
        AppMethodBeat.i(128145);
        Intent intent = null;
        loginHistoryUI.kmr[3] = 1;
        switch (i2) {
            case TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL:
                intent = new Intent(loginHistoryUI, LoginVoiceUI.class);
                break;
            case 7006:
                intent = new Intent(loginHistoryUI, LoginFaceUI.class);
                break;
            case 7007:
                intent = new Intent(loginHistoryUI, LoginPasswordUI.class);
                break;
            case 7008:
                intent = new Intent(loginHistoryUI, LoginSmsUI.class);
                break;
        }
        if (intent != null) {
            intent.putExtra("switch_login_wx_id", loginHistoryUI.klY);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(loginHistoryUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "jumpToOtherLogin", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            loginHistoryUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(loginHistoryUI, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "jumpToOtherLogin", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.LoginHistoryUI.AnonymousClass28 */

                public final void run() {
                    AppMethodBeat.i(128109);
                    LoginHistoryUI.this.finish();
                    LoginHistoryUI.this.overridePendingTransition(-1, -1);
                    AppMethodBeat.o(128109);
                }
            }, 300);
            com.tencent.mm.ui.base.b.ke(loginHistoryUI);
        }
        AppMethodBeat.o(128145);
    }
}

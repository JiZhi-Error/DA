package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.n;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.network.d;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.b;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.ui.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.wx.util.WXUtil;

public class MobileLoginOrForceReg extends MMActivity implements i {
    private String dHx;
    private String dSf;
    private String edo;
    protected ProgressDialog gtM = null;
    private ImageView gvv;
    private TextView gvw;
    private MMHandler handler = new MMHandler() {
        /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(128377);
            if (message.obj != null) {
                MobileLoginOrForceReg.this.gvv.setImageBitmap((Bitmap) message.obj);
            }
            AppMethodBeat.o(128377);
        }
    };
    private int jkp;
    private TextView kbe;
    private SecurityImage kdp = null;
    private IListener kkK = new IListener<lz>() {
        /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass12 */

        {
            AppMethodBeat.i(161705);
            this.__eventId = lz.class.getName().hashCode();
            AppMethodBeat.o(161705);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lz lzVar) {
            AppMethodBeat.i(128385);
            lz lzVar2 = lzVar;
            if (lzVar2 == null || lzVar2.dRz == null) {
                AppMethodBeat.o(128385);
                return false;
            }
            Log.i("MicorMsg.MobileLoginOrForceReg", "summerdiz loginDisasterListener callback content[%s], url[%s]", lzVar2.dRz.content, lzVar2.dRz.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", lzVar2.dRz.content);
            intent.putExtra("key_disaster_url", lzVar2.dRz.url);
            intent.setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
            Context context = MMApplicationContext.getContext();
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$2", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$2", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128385);
            return true;
        }
    };
    private ka kkY = new ka();
    private g klt = null;
    private h klz = null;
    private b kmf;
    private String knu;
    private Button koa;
    private Button kob;
    private LinearLayout koc;
    private LinearLayout kod;
    private int koe;
    private String kof;
    private String kog;
    private int koh;
    private String koi;
    private boolean koj = true;
    private boolean kok;
    private String kol;
    private String kom;
    private int kon;
    private String koo;
    private int kop;
    private String nickname;
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MobileLoginOrForceReg() {
        AppMethodBeat.i(128395);
        AppMethodBeat.o(128395);
    }

    static /* synthetic */ void p(MobileLoginOrForceReg mobileLoginOrForceReg) {
        AppMethodBeat.i(128405);
        mobileLoginOrForceReg.goBack();
        AppMethodBeat.o(128405);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128396);
        super.onCreate(bundle);
        this.koi = com.tencent.mm.plugin.b.a.caK();
        g.azz().a(701, this);
        g.azz().a(252, this);
        g.azz().a(126, this);
        g.azz().a(255, this);
        this.kon = getIntent().getIntExtra("key_reg_style", 1);
        this.dHx = getIntent().getStringExtra("ticket");
        this.dSf = getIntent().getStringExtra("moble");
        this.koe = getIntent().getIntExtra("next_controll", 0);
        this.username = getIntent().getStringExtra(ch.COL_USERNAME);
        this.kof = getIntent().getStringExtra("password");
        this.nickname = getIntent().getStringExtra("nickname");
        this.kog = getIntent().getStringExtra("avatar_url");
        this.knu = getIntent().getStringExtra("regsession_id");
        this.koo = getIntent().getStringExtra("reg_3d_app_ticket");
        this.kop = getIntent().getIntExtra("reg_3d_app_type", 0);
        this.koh = getIntent().getIntExtra("mobile_check_type", 0);
        this.kok = getIntent().getBooleanExtra("kintent_hasavatar", false);
        this.kol = getIntent().getStringExtra("kintent_nickname");
        this.kom = getIntent().getStringExtra("kintent_password");
        if (this.kom == null || this.kom.length() < 8) {
            this.jkp = 4;
        } else {
            this.jkp = 1;
        }
        initView();
        this.kmf = new b();
        AppMethodBeat.o(128396);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String str;
        AppMethodBeat.i(128397);
        this.koa = (Button) findViewById(R.id.bfl);
        this.kob = (Button) findViewById(R.id.d95);
        this.koc = (LinearLayout) findViewById(R.id.dn6);
        this.kod = (LinearLayout) findViewById(R.id.fzi);
        this.gvv = (ImageView) findViewById(R.id.x1);
        this.gvw = (TextView) findViewById(R.id.fzg);
        this.kbe = (TextView) findViewById(R.id.a4c);
        PhoneFormater phoneFormater = new PhoneFormater();
        if (this.dSf.startsWith("+")) {
            String extractCountryCode = PhoneFormater.extractCountryCode(this.dSf);
            if (!Util.isNullOrNil(extractCountryCode)) {
                str = "+" + extractCountryCode + " " + phoneFormater.formatNumber(extractCountryCode, this.dSf.substring(extractCountryCode.length() + 1));
            } else {
                str = this.dSf;
            }
        } else {
            str = "+86 " + phoneFormater.formatNumber("86", this.dSf);
        }
        this.kbe.setText(str);
        if (!Util.isNullOrNil(this.nickname) || !Util.isNullOrNil(this.kog)) {
            this.kod.setVisibility(8);
            this.koc.setVisibility(0);
            if (Util.isNullOrNil(this.nickname)) {
                this.gvw.setVisibility(8);
            } else {
                this.gvw.setText(this.nickname);
            }
            Bitmap Wg = a.b.gov().Wg();
            if (Wg != null) {
                this.gvv.setImageBitmap(Wg);
            }
            if (!Util.isNullOrNil(this.kog)) {
                final String str2 = this.kog;
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass13 */

                    public final void run() {
                        AppMethodBeat.i(128386);
                        Bitmap bitmap = null;
                        try {
                            bitmap = BackwardSupportUtil.BitmapFactory.decodeStream(d.w(str2, 10000, com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT));
                        } catch (Exception e2) {
                            Log.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
                            Log.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", e2, "", new Object[0]);
                        }
                        MobileLoginOrForceReg.this.handler.sendMessage(MobileLoginOrForceReg.this.handler.obtainMessage(0, bitmap));
                        AppMethodBeat.o(128386);
                    }

                    public final String toString() {
                        AppMethodBeat.i(128387);
                        String str = super.toString() + "|loadBitmap";
                        AppMethodBeat.o(128387);
                        return str;
                    }
                });
            }
        } else {
            this.kod.setVisibility(0);
            this.koc.setVisibility(8);
        }
        this.koa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(128388);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MobileLoginOrForceReg.this.klz = new h(new h.a() {
                    /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass14.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.account.ui.h.a
                    public final void a(ProgressDialog progressDialog) {
                        MobileLoginOrForceReg.this.gtM = progressDialog;
                    }
                }, MobileLoginOrForceReg.this.username, MobileLoginOrForceReg.this.kof, MobileLoginOrForceReg.this.dSf);
                MobileLoginOrForceReg.this.klz.b(MobileLoginOrForceReg.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128388);
            }
        });
        this.kob.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(128389);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (Util.isNullOrNil(MobileLoginOrForceReg.this.kol)) {
                    Intent intent = new Intent();
                    com.tencent.mm.plugin.b.a.bxl("R200_900_phone");
                    intent.putExtra("regsetinfo_ticket", MobileLoginOrForceReg.this.dHx);
                    intent.putExtra("regsetinfo_user", MobileLoginOrForceReg.this.dSf);
                    intent.putExtra("regsetinfo_pwd", MobileLoginOrForceReg.this.kof);
                    intent.putExtra("regsetinfo_ismobile", 4);
                    intent.putExtra("regsetinfo_isForce", true);
                    intent.putExtra("regsession_id", MobileLoginOrForceReg.this.knu);
                    intent.putExtra("reg_3d_app_ticket", MobileLoginOrForceReg.this.koo);
                    intent.putExtra("reg_3d_app_type", MobileLoginOrForceReg.this.kop);
                    intent.putExtra("regsetinfo_NextControl", MobileLoginOrForceReg.this.koe);
                    intent.putExtra("mobile_check_type", MobileLoginOrForceReg.this.koh);
                    intent.putExtra("key_reg_style", MobileLoginOrForceReg.this.kon);
                    intent.setClass(MobileLoginOrForceReg.this, RegSetInfoUI.class);
                    MobileLoginOrForceReg mobileLoginOrForceReg = MobileLoginOrForceReg.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(mobileLoginOrForceReg, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    mobileLoginOrForceReg.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(mobileLoginOrForceReg, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else {
                    MobileLoginOrForceReg.o(MobileLoginOrForceReg.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128389);
            }
        });
        setMMTitle(R.string.f1e);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass16 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128390);
                MobileLoginOrForceReg.p(MobileLoginOrForceReg.this);
                AppMethodBeat.o(128390);
                return false;
            }
        });
        AppMethodBeat.o(128397);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128398);
        EventCenter.instance.addListener(this.kkK);
        super.onResume();
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
        g.aAf();
        com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R200_600")).append(",1").toString());
        com.tencent.mm.plugin.b.a.bxk("R200_600");
        AppMethodBeat.o(128398);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128399);
        super.onPause();
        EventCenter.instance.removeListener(this.kkK);
        AppMethodBeat.o(128399);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128400);
        g.azz().b(701, this);
        g.azz().b(252, this);
        g.azz().b(126, this);
        g.azz().b(255, this);
        if (this.kmf != null) {
            this.kmf.close();
        }
        super.onDestroy();
        AppMethodBeat.o(128400);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bay;
    }

    private void goBack() {
        Intent intent;
        AppMethodBeat.i(128401);
        com.tencent.mm.plugin.b.a.bxl("R200_100");
        if (this.kon == 1) {
            intent = new Intent(this, RegByMobileRegAIOUI.class);
        } else {
            intent = new Intent(this, MobileInputUI.class);
        }
        intent.putExtra("mobile_input_purpose", 2);
        intent.addFlags(67108864);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.b.a.bxk(this.koi);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R200_600")).append(",2").toString());
        finish();
        AppMethodBeat.o(128401);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128402);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(128402);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128402);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, final q qVar) {
        boolean z;
        String ayX;
        com.tencent.mm.h.a Dk;
        AppMethodBeat.i(128403);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (this.klt == null) {
            this.klt = new g();
        }
        if (qVar.getType() == 255) {
            if (i3 == -3 && i2 == 4) {
                boolean z2 = this.koj;
                Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", getString(R.string.gr1));
                intent.putExtra("kintent_cancelable", z2);
                startActivityForResult(intent, 0);
            }
            AppMethodBeat.o(128403);
        } else if ((qVar.getType() != 252 && qVar.getType() != 701) || this.klz == null) {
            if (qVar.getType() == 126) {
                if (i3 == -6 || i3 == -311 || i3 == -310) {
                    final Boolean valueOf = Boolean.valueOf(this.kok);
                    final String str2 = this.kom;
                    final String str3 = this.kol;
                    if (this.kdp == null) {
                        this.kdp = SecurityImage.a.a(this, 0, ((v) qVar).bfm(), ((v) qVar).bfl(), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128379);
                                final v vVar = new v("", str2, str3, 0, "", MobileLoginOrForceReg.this.dSf, "", "", MobileLoginOrForceReg.this.dHx, MobileLoginOrForceReg.this.jkp, "", ((v) qVar).bfl(), MobileLoginOrForceReg.this.kdp.getSecImgCode(), true, valueOf.booleanValue());
                                vVar.PB(MobileLoginOrForceReg.this.knu);
                                vVar.PC(MobileLoginOrForceReg.this.koo);
                                vVar.tL(MobileLoginOrForceReg.this.koh);
                                g.azz().a(vVar, 0);
                                MobileLoginOrForceReg mobileLoginOrForceReg = MobileLoginOrForceReg.this;
                                AppCompatActivity context = MobileLoginOrForceReg.this.getContext();
                                MobileLoginOrForceReg.this.getString(R.string.zb);
                                mobileLoginOrForceReg.gtM = com.tencent.mm.ui.base.h.a((Context) context, MobileLoginOrForceReg.this.getString(R.string.g0m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass2.AnonymousClass1 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(128378);
                                        g.azz().a(vVar);
                                        AppMethodBeat.o(128378);
                                    }
                                });
                                AppMethodBeat.o(128379);
                            }
                        }, null, new DialogInterface.OnDismissListener() {
                            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass3 */

                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(128380);
                                MobileLoginOrForceReg.this.kdp = null;
                                AppMethodBeat.o(128380);
                            }
                        }, new SecurityImage.b() {
                            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass4 */

                            @Override // com.tencent.mm.ui.applet.SecurityImage.b
                            public final void bnH() {
                                AppMethodBeat.i(128381);
                                MobileLoginOrForceReg.this.hideVKB();
                                v vVar = new v("", str2, str3, 0, "", MobileLoginOrForceReg.this.dSf, "", "", MobileLoginOrForceReg.this.dHx, MobileLoginOrForceReg.this.jkp, "", ((v) qVar).bfl(), "", true, valueOf.booleanValue());
                                vVar.PB(MobileLoginOrForceReg.this.knu);
                                vVar.PC(MobileLoginOrForceReg.this.koo);
                                vVar.tL(MobileLoginOrForceReg.this.koh);
                                g.azz().a(vVar, 0);
                                AppMethodBeat.o(128381);
                            }
                        });
                        AppMethodBeat.o(128403);
                        return;
                    }
                    this.kdp.b(0, ((v) qVar).bfm(), ((v) qVar).bfl(), "");
                    AppMethodBeat.o(128403);
                    return;
                }
                if (i2 == 0 && i3 == 0) {
                    final String str4 = this.dSf;
                    Boolean valueOf2 = Boolean.valueOf(this.kok);
                    this.kkY.eTd = (long) this.kop;
                    this.kkY.ejA = 6;
                    this.kkY.bfK();
                    g.aAf();
                    com.tencent.mm.kernel.a.unhold();
                    com.tencent.mm.kernel.a.es(true);
                    if (valueOf2.booleanValue()) {
                        String str5 = com.tencent.mm.loader.j.b.aKR() + "temp.avatar";
                        String str6 = com.tencent.mm.loader.j.b.aKR() + "temp.avatar.hd";
                        s.nx(str5, str6);
                        s.deleteFile(str5);
                        BitmapUtil.createThumbNail(str6, 156, 156, Bitmap.CompressFormat.JPEG, 90, str5, true);
                        new n(this, com.tencent.mm.loader.j.b.aKR() + "temp.avatar").a(new Runnable() {
                            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass5 */

                            public final void run() {
                                AppMethodBeat.i(128382);
                                MobileLoginOrForceReg.this.dHx = ((v) qVar).bfv();
                                bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, str4);
                                s.deleteFile(com.tencent.mm.loader.j.b.aKR() + "temp.avatar");
                                Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(MobileLoginOrForceReg.this);
                                bZ.addFlags(67108864);
                                MobileLoginOrForceReg mobileLoginOrForceReg = MobileLoginOrForceReg.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                                com.tencent.mm.hellhoundlib.a.a.a(mobileLoginOrForceReg, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                mobileLoginOrForceReg.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(mobileLoginOrForceReg, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                StringBuilder sb = new StringBuilder();
                                g.aAf();
                                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
                                g.aAf();
                                com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R200_600")).append(",4").toString());
                                MobileLoginOrForceReg.this.finish();
                                AppMethodBeat.o(128382);
                            }
                        }, new Runnable() {
                            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass6 */

                            public final void run() {
                                AppMethodBeat.i(128383);
                                MobileLoginOrForceReg.this.dHx = ((v) qVar).bfv();
                                bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, str4);
                                Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(MobileLoginOrForceReg.this);
                                bZ.addFlags(67108864);
                                MobileLoginOrForceReg mobileLoginOrForceReg = MobileLoginOrForceReg.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                                com.tencent.mm.hellhoundlib.a.a.a(mobileLoginOrForceReg, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                mobileLoginOrForceReg.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(mobileLoginOrForceReg, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                StringBuilder sb = new StringBuilder();
                                g.aAf();
                                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
                                g.aAf();
                                com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R200_600")).append(",4").toString());
                                MobileLoginOrForceReg.this.finish();
                                AppMethodBeat.o(128383);
                            }
                        });
                    } else {
                        this.dHx = ((v) qVar).bfv();
                        bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, str4);
                        Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
                        bZ.addFlags(67108864);
                        bZ.putExtra("LauncherUI.enter_from_reg", true);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        finish();
                        com.tencent.mm.plugin.b.a.bxl("RE900_100");
                        StringBuilder sb = new StringBuilder();
                        g.aAf();
                        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
                        g.aAf();
                        com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R200_600")).append(",4").toString());
                    }
                }
                com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
                if (Dk2 != null) {
                    Dk2.a(this, null, null);
                    AppMethodBeat.o(128403);
                    return;
                }
            }
            if (!this.kmf.a(this, new ae(i2, i3, str))) {
                z = false;
                switch (i3) {
                    case -2023:
                    case -100:
                        g.aAf();
                        com.tencent.mm.kernel.a.hold();
                        AppCompatActivity context = getContext();
                        g.aAf();
                        if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {
                            ayX = com.tencent.mm.cb.a.aI(getContext(), R.string.ev5);
                        } else {
                            g.aAf();
                            ayX = com.tencent.mm.kernel.a.ayX();
                        }
                        com.tencent.mm.ui.base.h.a(context, ayX, getContext().getString(R.string.zb), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass9 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }, new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass10 */

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        z = true;
                        break;
                    case -140:
                        if (!Util.isNullOrNil(this.edo)) {
                            y.m(getContext(), str, this.edo);
                        }
                        z = true;
                        break;
                    case -75:
                        com.tencent.mm.ui.base.h.n(this, R.string.h0, R.string.fxq);
                        z = true;
                        break;
                    case APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException:
                        Toast.makeText(this, (int) R.string.adr, 0).show();
                        z = true;
                        break;
                    case APPluginConstants.ERROR_IO_SSLException_SSLHandshakeException:
                        Toast.makeText(this, (int) R.string.adt, 0).show();
                        z = true;
                        break;
                    case APPluginConstants.ERROR_IO_ObjectStreamException_NotSerializableException:
                        Toast.makeText(this, (int) R.string.adw, 0).show();
                        z = true;
                        break;
                    case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                        Toast.makeText(this, (int) R.string.adu, 0).show();
                        z = true;
                        break;
                    case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidClassException:
                        com.tencent.mm.ui.base.h.a(this, (int) R.string.af3, (int) R.string.af9, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass8 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        z = true;
                        break;
                    case APPluginConstants.ERROR_IO_NoHttpResponseException:
                        com.tencent.mm.ui.base.h.d(this, getString(R.string.af5), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass7 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        z = true;
                        break;
                }
            } else {
                z = true;
            }
            if (z) {
                AppMethodBeat.o(128403);
            } else if ((qVar.getType() == 252 || qVar.getType() == 701) && (Dk = com.tencent.mm.h.a.Dk(str)) != null && Dk.a(getContext(), null, null)) {
                AppMethodBeat.o(128403);
            } else {
                if (!(i2 == 0 && i3 == 0)) {
                    Toast.makeText(getContext(), getString(R.string.af2, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                }
                AppMethodBeat.o(128403);
            }
        } else if (i3 == -6 || i3 == -311 || i3 == -310) {
            this.klt.account = this.username;
            this.klt.kmI = this.kom;
            this.klt.kds = ((t) qVar).bfl();
            this.klt.kdr = ((t) qVar).bfm();
            this.klt.kdt = ((t) qVar).bfn();
            this.klt.kmJ = ((t) qVar).getSecCodeType();
            if (this.kdp == null) {
                this.kdp = SecurityImage.a.a(this, this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass17 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(128392);
                        Log.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.this.klt.kds + " img len" + MobileLoginOrForceReg.this.klt.kdr.length + " " + f.apq());
                        final t tVar = new t(MobileLoginOrForceReg.this.klt.account, MobileLoginOrForceReg.this.klt.kmI, MobileLoginOrForceReg.this.klt.kmJ, MobileLoginOrForceReg.this.kdp.getSecImgCode(), MobileLoginOrForceReg.this.kdp.getSecImgSid(), MobileLoginOrForceReg.this.kdp.getSecImgEncryptKey(), 1, "", false, true);
                        g.azz().a(tVar, 0);
                        MobileLoginOrForceReg mobileLoginOrForceReg = MobileLoginOrForceReg.this;
                        MobileLoginOrForceReg.this.getString(R.string.zb);
                        com.tencent.mm.ui.base.h.a((Context) mobileLoginOrForceReg, MobileLoginOrForceReg.this.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass17.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(128391);
                                g.azz().a(tVar);
                                AppMethodBeat.o(128391);
                            }
                        });
                        AppMethodBeat.o(128392);
                    }
                }, null, new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass18 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(128393);
                        MobileLoginOrForceReg.this.kdp = null;
                        AppMethodBeat.o(128393);
                    }
                }, this.klt);
                AppMethodBeat.o(128403);
                return;
            }
            this.kdp.b(this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt);
            AppMethodBeat.o(128403);
        } else {
            this.edo = ((t) qVar).bfk();
            this.klz.a(this, i2, i3, str, qVar);
            if (qVar instanceof t) {
                this.koj = ((t) qVar).bfu();
            }
            if (i2 == 0 && i3 == 0) {
                final u uVar = new u(1);
                g.azz().a(uVar, 0);
                getString(R.string.zb);
                this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass19 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(128394);
                        g.azz().a(uVar);
                        AppMethodBeat.o(128394);
                    }
                });
                if (!Util.isNullOrNil(this.koo)) {
                    g.aAh().azQ().set(ar.a.USERINFO_LOGIN_SHOW_BIND_THIRD_ADD_TYPE_INT, Integer.valueOf(this.kop));
                }
            }
            AppMethodBeat.o(128403);
        }
    }

    static /* synthetic */ void o(MobileLoginOrForceReg mobileLoginOrForceReg) {
        AppMethodBeat.i(128404);
        final v vVar = new v("", mobileLoginOrForceReg.kom, mobileLoginOrForceReg.kol, 0, "", mobileLoginOrForceReg.dSf, "", "", mobileLoginOrForceReg.dHx, mobileLoginOrForceReg.jkp, "", "", "", true, mobileLoginOrForceReg.kok);
        vVar.PB(mobileLoginOrForceReg.knu);
        vVar.PC(mobileLoginOrForceReg.koo);
        vVar.tL(mobileLoginOrForceReg.koh);
        g.azz().a(vVar, 0);
        AppCompatActivity context = mobileLoginOrForceReg.getContext();
        mobileLoginOrForceReg.getString(R.string.zb);
        mobileLoginOrForceReg.gtM = com.tencent.mm.ui.base.h.a((Context) context, mobileLoginOrForceReg.getString(R.string.g0m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.AnonymousClass11 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(128384);
                g.azz().a(vVar);
                AppMethodBeat.o(128384);
            }
        });
        AppMethodBeat.o(128404);
    }
}

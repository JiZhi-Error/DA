package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.n;
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.ui.h;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.wx.util.WXUtil;

public class RegByMobileSendSmsUI extends MMActivity implements i {
    private int countDown = 15;
    private String dHx;
    private String dQC;
    private ka kkY = new ka();
    private String kkz = "";
    private ProgressDialog klA;
    private int klB;
    private Button klC;
    private MTimerHandler klF;
    private String klr = "";
    private String kls = "";
    private h klz;
    private String knu = "";
    private int kon;
    private int kop;
    private boolean kpI;
    private SecurityImage kpL;
    private String kph;
    private Button kqx;
    private String nickName;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RegByMobileSendSmsUI() {
        AppMethodBeat.i(128577);
        AppMethodBeat.o(128577);
    }

    static /* synthetic */ void d(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        AppMethodBeat.i(128588);
        regByMobileSendSmsUI.goBack();
        AppMethodBeat.o(128588);
    }

    static /* synthetic */ int r(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        int i2 = regByMobileSendSmsUI.countDown;
        regByMobileSendSmsUI.countDown = i2 - 1;
        return i2;
    }

    static /* synthetic */ void t(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        AppMethodBeat.i(128591);
        regByMobileSendSmsUI.stopTimer();
        AppMethodBeat.o(128591);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128578);
        super.onCreate(bundle);
        this.kon = getIntent().getIntExtra("key_reg_style", 1);
        this.klr = Util.nullAsNil(getIntent().getStringExtra("from_mobile"));
        this.kls = Util.nullAsNil(getIntent().getStringExtra("to_mobile"));
        this.kkz = Util.nullAsNil(getIntent().getStringExtra("verify_code"));
        this.knu = Util.nullAsNil(getIntent().getStringExtra("regsession_id"));
        this.kph = Util.nullAsNil(getIntent().getStringExtra("reg_3d_app_ticket"));
        this.nickName = Util.nullAsNil(getIntent().getStringExtra("kintent_nickname"));
        this.dQC = Util.nullAsNil(getIntent().getStringExtra("kintent_password"));
        this.kpI = getIntent().getBooleanExtra("kintent_hasavatar", false);
        this.kop = getIntent().getIntExtra("reg_3d_app_type", 0);
        initView();
        AppMethodBeat.o(128578);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128579);
        super.initView();
        ((TextView) findViewById(R.id.hkm)).setText(getString(R.string.fzd, new Object[]{this.klr}));
        ((TextView) findViewById(R.id.hkj)).setText(Tr(getString(R.string.fzc, new Object[]{this.kkz})));
        ((TextView) findViewById(R.id.hkn)).setText(Tr(getString(R.string.fzf, new Object[]{this.kls})));
        this.klC = (Button) findViewById(R.id.hki);
        this.kqx = (Button) findViewById(R.id.fz0);
        if (Util.isNullOrNil(this.klr, this.kls, this.kkz)) {
            this.klC.setEnabled(false);
            this.kqx.setEnabled(false);
        } else {
            this.kqx.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128562);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this);
                    a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128562);
                }
            });
        }
        if (Util.isNullOrNil(q.getSimCountryIso())) {
            this.klC.setVisibility(8);
        } else {
            this.klC.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass9 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128570);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("smsto:" + RegByMobileSendSmsUI.this.kls));
                    intent.putExtra("sms_body", RegByMobileSendSmsUI.this.kkz);
                    try {
                        RegByMobileSendSmsUI regByMobileSendSmsUI = RegByMobileSendSmsUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        a.a(regByMobileSendSmsUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        regByMobileSendSmsUI.startActivity((Intent) bl.pG(0));
                        a.a(regByMobileSendSmsUI, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        RegByMobileSendSmsUI.this.overridePendingTransition(R.anim.eq, R.anim.en);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.RegByMobileSendSmsUI", e2.getMessage());
                    }
                    a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128570);
                }
            });
        }
        setMMTitle(R.string.fze);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128571);
                RegByMobileSendSmsUI.d(RegByMobileSendSmsUI.this);
                AppMethodBeat.o(128571);
                return true;
            }
        });
        AppMethodBeat.o(128579);
    }

    private m Tr(String str) {
        AppMethodBeat.i(128580);
        m mVar = new m(str);
        Log.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", str);
        int indexOf = str.indexOf(32) + 1;
        mVar.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(R.dimen.hf)), indexOf, str.length(), 33);
        mVar.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.ts)), indexOf, str.length(), 33);
        AppMethodBeat.o(128580);
        return mVar;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bba;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128581);
        super.onResume();
        g.azz().a(145, this);
        g.azz().a(701, this);
        g.azz().a(252, this);
        AppMethodBeat.o(128581);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(128582);
        super.onStop();
        stopTimer();
        g.azz().b(145, this);
        g.azz().b(701, this);
        g.azz().b(252, this);
        AppMethodBeat.o(128582);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        com.tencent.mm.h.a Dk;
        AppMethodBeat.i(128583);
        Log.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.klA != null) {
            this.klA.dismiss();
        }
        if (qVar.getType() == 145 && ((com.tencent.mm.modelfriend.a) qVar).Vj() == 15) {
            final com.tencent.mm.modelfriend.a aVar = (com.tencent.mm.modelfriend.a) qVar;
            this.dHx = aVar.bbG();
            if (i3 == 0) {
                stopTimer();
                if (this.kon == 1) {
                    g.azz().a(126, this);
                    final v vVar = new v("", this.dQC, this.nickName, 0, "", this.klr, "", "", this.dHx, 1, "", "", "", true, this.kpI);
                    vVar.PB(this.knu);
                    vVar.PC(this.kph);
                    vVar.tL(1);
                    g.azz().a(vVar, 0);
                    getString(R.string.zb);
                    this.klA = h.a((Context) this, getString(R.string.g0m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass11 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(128572);
                            g.azz().a(vVar);
                            g.azz().b(126, RegByMobileSendSmsUI.this);
                            AppMethodBeat.o(128572);
                        }
                    });
                    AppMethodBeat.o(128583);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("regsetinfo_ticket", this.dHx);
                intent.putExtra("regsetinfo_user", this.klr);
                intent.putExtra("regsession_id", this.knu);
                intent.putExtra("reg_3d_app_ticket", this.kph);
                intent.putExtra("reg_3d_app_type", this.kop);
                intent.putExtra("mobile_check_type", 1);
                intent.putExtra("regsetinfo_ismobile", 4);
                intent.putExtra("regsetinfo_NextControl", aVar.bbN());
                intent.putExtra("key_reg_style", this.kon);
                intent.setClass(this, RegSetInfoUI.class);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(128583);
            } else if (i3 == -35) {
                stopTimer();
                com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
                this.kkY.eTd = (long) this.kop;
                this.kkY.ejA = 7;
                this.kkY.bfK();
                if (Dk2 != null) {
                    Dk2.a(this, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass12 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(128573);
                            g.azz().a(701, RegByMobileSendSmsUI.this);
                            g.azz().a(252, RegByMobileSendSmsUI.this);
                            RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, aVar.getUsername(), aVar.bbF());
                            RegByMobileSendSmsUI.this.kkY.eTd = (long) RegByMobileSendSmsUI.this.kop;
                            RegByMobileSendSmsUI.this.kkY.ejA = 8;
                            RegByMobileSendSmsUI.this.kkY.bfK();
                            AppMethodBeat.o(128573);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass13 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(128583);
                    return;
                }
                h.a(this, getString(R.string.adc), (String) null, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass14 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(128574);
                        RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, aVar.getUsername(), aVar.bbF());
                        RegByMobileSendSmsUI.this.kkY.eTd = (long) RegByMobileSendSmsUI.this.kop;
                        RegByMobileSendSmsUI.this.kkY.ejA = 8;
                        RegByMobileSendSmsUI.this.kkY.bfK();
                        AppMethodBeat.o(128574);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass15 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(128583);
            } else if (i3 == -212) {
                stopTimer();
                Intent intent2 = new Intent(this, MobileLoginOrForceReg.class);
                intent2.putExtra("ticket", this.dHx);
                intent2.putExtra("moble", this.klr);
                intent2.putExtra("regsession_id", this.knu);
                intent2.putExtra("reg_3d_app_ticket", this.kph);
                intent2.putExtra("reg_3d_app_type", this.kop);
                intent2.putExtra("next_controll", aVar.bbN());
                intent2.putExtra(ch.COL_USERNAME, aVar.getUsername());
                intent2.putExtra("password", aVar.bbF());
                intent2.putExtra("nickname", aVar.bbT());
                intent2.putExtra("avatar_url", aVar.bbS());
                intent2.putExtra("mobile_check_type", 1);
                intent2.putExtra("kintent_hasavatar", this.kpI);
                intent2.putExtra("kintent_nickname", this.nickName);
                intent2.putExtra("kintent_password", this.dQC);
                intent2.putExtra("key_reg_style", this.kon);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                a.a(this, bl2.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl2.pG(0));
                a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(128583);
            } else if (Util.isNullOrNil(str) || this.klB < 4 || (Dk = com.tencent.mm.h.a.Dk(str)) == null || !Dk.a(this, null, null)) {
                AppMethodBeat.o(128583);
            } else {
                AppMethodBeat.o(128583);
            }
        } else {
            if (qVar.getType() == 126) {
                final v vVar2 = (v) qVar;
                if (i3 == -6 || i3 == -311 || i3 == -310) {
                    if (this.kpL == null) {
                        this.kpL = SecurityImage.a.a(this, 0, vVar2.bfm(), vVar2.bfl(), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass16 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128576);
                                final v vVar = new v("", RegByMobileSendSmsUI.this.dQC, RegByMobileSendSmsUI.this.nickName, 0, "", RegByMobileSendSmsUI.this.klr, "", "", RegByMobileSendSmsUI.this.dHx, 1, "", vVar2.bfl(), RegByMobileSendSmsUI.this.kpL.getSecImgCode(), true, RegByMobileSendSmsUI.this.kpI);
                                vVar.PB(RegByMobileSendSmsUI.this.knu);
                                vVar.PC(RegByMobileSendSmsUI.this.kph);
                                vVar.tL(1);
                                g.azz().a(vVar, 0);
                                RegByMobileSendSmsUI regByMobileSendSmsUI = RegByMobileSendSmsUI.this;
                                AppCompatActivity context = RegByMobileSendSmsUI.this.getContext();
                                RegByMobileSendSmsUI.this.getString(R.string.zb);
                                regByMobileSendSmsUI.klA = h.a((Context) context, RegByMobileSendSmsUI.this.getString(R.string.g0m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass16.AnonymousClass1 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(128575);
                                        g.azz().a(vVar);
                                        AppMethodBeat.o(128575);
                                    }
                                });
                                AppMethodBeat.o(128576);
                            }
                        }, null, new DialogInterface.OnDismissListener() {
                            /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass2 */

                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(128563);
                                RegByMobileSendSmsUI.this.kpL = null;
                                AppMethodBeat.o(128563);
                            }
                        }, new SecurityImage.b() {
                            /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass3 */

                            @Override // com.tencent.mm.ui.applet.SecurityImage.b
                            public final void bnH() {
                                AppMethodBeat.i(128564);
                                RegByMobileSendSmsUI.this.hideVKB();
                                v vVar = new v("", RegByMobileSendSmsUI.this.dQC, RegByMobileSendSmsUI.this.nickName, 0, "", RegByMobileSendSmsUI.this.klr, "", "", RegByMobileSendSmsUI.this.dHx, 1, "", vVar2.bfl(), RegByMobileSendSmsUI.this.kpL.getSecImgCode(), true, RegByMobileSendSmsUI.this.kpI);
                                vVar.PB(RegByMobileSendSmsUI.this.knu);
                                vVar.PC(RegByMobileSendSmsUI.this.kph);
                                vVar.tL(1);
                                g.azz().a(vVar, 0);
                                AppMethodBeat.o(128564);
                            }
                        });
                        AppMethodBeat.o(128583);
                        return;
                    }
                    this.kpL.b(0, ((v) qVar).bfm(), ((v) qVar).bfl(), "");
                    AppMethodBeat.o(128583);
                    return;
                } else if (i2 == 0 && i3 == 0) {
                    final String str2 = this.klr;
                    this.kkY.eTd = (long) this.kop;
                    this.kkY.ejA = 6;
                    this.kkY.bfK();
                    com.tencent.mm.kernel.a.unhold();
                    com.tencent.mm.kernel.a.es(true);
                    if (this.kpI) {
                        String str3 = com.tencent.mm.loader.j.b.aKR() + "temp.avatar";
                        String str4 = com.tencent.mm.loader.j.b.aKR() + "temp.avatar.hd";
                        s.nx(str3, str4);
                        s.deleteFile(str3);
                        BitmapUtil.createThumbNail(str4, 156, 156, Bitmap.CompressFormat.JPEG, 90, str3, true);
                        new n(this, com.tencent.mm.loader.j.b.aKR() + "temp.avatar").a(new Runnable() {
                            /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(128565);
                                RegByMobileSendSmsUI.this.dHx = vVar2.bfv();
                                bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, str2);
                                s.deleteFile(com.tencent.mm.loader.j.b.aKR() + "temp.avatar");
                                Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegByMobileSendSmsUI.this);
                                bZ.addFlags(67108864);
                                RegByMobileSendSmsUI regByMobileSendSmsUI = RegByMobileSendSmsUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                                a.a(regByMobileSendSmsUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                regByMobileSendSmsUI.startActivity((Intent) bl.pG(0));
                                a.a(regByMobileSendSmsUI, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                StringBuilder sb = new StringBuilder();
                                g.aAf();
                                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
                                g.aAf();
                                com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R200_600")).append(",4").toString());
                                RegByMobileSendSmsUI.this.finish();
                                AppMethodBeat.o(128565);
                            }
                        }, new Runnable() {
                            /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass5 */

                            public final void run() {
                                AppMethodBeat.i(128566);
                                RegByMobileSendSmsUI.this.dHx = vVar2.bfv();
                                bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, str2);
                                Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegByMobileSendSmsUI.this);
                                bZ.addFlags(67108864);
                                RegByMobileSendSmsUI regByMobileSendSmsUI = RegByMobileSendSmsUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                                a.a(regByMobileSendSmsUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                regByMobileSendSmsUI.startActivity((Intent) bl.pG(0));
                                a.a(regByMobileSendSmsUI, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                StringBuilder sb = new StringBuilder();
                                g.aAf();
                                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
                                g.aAf();
                                com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R200_600")).append(",4").toString());
                                RegByMobileSendSmsUI.this.finish();
                                AppMethodBeat.o(128566);
                            }
                        });
                        AppMethodBeat.o(128583);
                        return;
                    }
                    this.dHx = vVar2.bfv();
                    bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, str2);
                    Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
                    bZ.addFlags(67108864);
                    bZ.putExtra("LauncherUI.enter_from_reg", true);
                    com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                    a.a(this, bl3.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl3.pG(0));
                    a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    finish();
                    com.tencent.mm.plugin.b.a.bxl("RE900_100");
                    StringBuilder sb = new StringBuilder();
                    g.aAf();
                    StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
                    g.aAf();
                    com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R200_600")).append(",4").toString());
                    AppMethodBeat.o(128583);
                    return;
                } else {
                    com.tencent.mm.h.a Dk3 = com.tencent.mm.h.a.Dk(str);
                    if (Dk3 != null) {
                        Dk3.a(this, null, null);
                        AppMethodBeat.o(128583);
                        return;
                    }
                }
            }
            AppMethodBeat.o(128583);
        }
    }

    private void stopTimer() {
        AppMethodBeat.i(128584);
        if (this.klF != null) {
            this.klF.stopTimer();
        }
        this.kqx.setText(R.string.fz8);
        this.kqx.setEnabled(true);
        AppMethodBeat.o(128584);
    }

    private void goBack() {
        AppMethodBeat.i(128585);
        h.a(this, getString(R.string.fz_), "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(128569);
                RegByMobileSendSmsUI.t(RegByMobileSendSmsUI.this);
                RegByMobileSendSmsUI.this.finish();
                AppMethodBeat.o(128569);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(128585);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128586);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(128586);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128586);
        return onKeyDown;
    }

    static /* synthetic */ void a(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        AppMethodBeat.i(128587);
        regByMobileSendSmsUI.kqx.setEnabled(false);
        if (regByMobileSendSmsUI.klF != null) {
            regByMobileSendSmsUI.klF.stopTimer();
            regByMobileSendSmsUI.countDown = 15;
            regByMobileSendSmsUI.klB = 0;
            regByMobileSendSmsUI.klF.startTimer(0, 1000);
            AppMethodBeat.o(128587);
            return;
        }
        regByMobileSendSmsUI.klF = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass7 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(128568);
                if (RegByMobileSendSmsUI.this.countDown > 0) {
                    RegByMobileSendSmsUI.this.kqx.setText(RegByMobileSendSmsUI.this.getString(R.string.fzh, new Object[]{Integer.valueOf(RegByMobileSendSmsUI.this.countDown)}));
                    RegByMobileSendSmsUI.r(RegByMobileSendSmsUI.this);
                    if (RegByMobileSendSmsUI.this.countDown % 4 == 0) {
                        RegByMobileSendSmsUI.s(RegByMobileSendSmsUI.this);
                    }
                    AppMethodBeat.o(128568);
                    return true;
                }
                RegByMobileSendSmsUI.this.kqx.setText(R.string.fz8);
                RegByMobileSendSmsUI.this.kqx.setEnabled(true);
                AppMethodBeat.o(128568);
                return false;
            }
        }, true);
        regByMobileSendSmsUI.klF.startTimer(0, 1000);
        AppMethodBeat.o(128587);
    }

    static /* synthetic */ void a(RegByMobileSendSmsUI regByMobileSendSmsUI, String str, String str2) {
        AppMethodBeat.i(128589);
        g.azz().a(701, regByMobileSendSmsUI);
        g.azz().a(252, regByMobileSendSmsUI);
        regByMobileSendSmsUI.klz = new h(new h.a() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.account.ui.h.a
            public final void a(ProgressDialog progressDialog) {
                AppMethodBeat.i(128567);
                RegByMobileSendSmsUI.this.klA = progressDialog;
                AppMethodBeat.o(128567);
            }
        }, str, str2, regByMobileSendSmsUI.klr);
        regByMobileSendSmsUI.klz.b(regByMobileSendSmsUI);
        AppMethodBeat.o(128589);
    }

    static /* synthetic */ void s(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        AppMethodBeat.i(128590);
        regByMobileSendSmsUI.klB++;
        if (regByMobileSendSmsUI.klB <= 4) {
            com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(regByMobileSendSmsUI.klr, 15, "", 0, "");
            aVar.tb(1);
            aVar.Ok(regByMobileSendSmsUI.knu);
            aVar.F(regByMobileSendSmsUI.klB, regByMobileSendSmsUI.klB == 4);
            g.azz().a(aVar, 0);
        }
        AppMethodBeat.o(128590);
    }
}

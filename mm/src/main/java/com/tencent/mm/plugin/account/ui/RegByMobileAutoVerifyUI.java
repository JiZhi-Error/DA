package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.n;
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.b.a.nw;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.ui.h;
import com.tencent.mm.plugin.mobile.verify.a.a;
import com.tencent.mm.protocal.n;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.CheckBoxLicenseView;
import com.tencent.recovery.wx.util.WXUtil;

public class RegByMobileAutoVerifyUI extends MMActivity implements i, a.AbstractC1483a {
    private String countryCode;
    private String dHx;
    private String dSf;
    private String hJl;
    private String knu;
    private int kon;
    private String kpE;
    private String kpF;
    private String kpG;
    private String kpH;
    private boolean kpI;
    private int kpJ = 2;
    private ProgressDialog kpK;
    private SecurityImage kpL;
    private nw kpM = new nw();
    private String seq;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RegByMobileAutoVerifyUI() {
        AppMethodBeat.i(196908);
        AppMethodBeat.o(196908);
    }

    static /* synthetic */ void c(RegByMobileAutoVerifyUI regByMobileAutoVerifyUI) {
        AppMethodBeat.i(196917);
        regByMobileAutoVerifyUI.bpB();
        AppMethodBeat.o(196917);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(196909);
        super.onCreate(bundle);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        this.dSf = getIntent().getStringExtra("Key_Mobile");
        this.countryCode = getIntent().getStringExtra("Key_CountryCode");
        this.kpE = this.countryCode + this.dSf;
        this.seq = getIntent().getStringExtra("Key_Seq");
        this.hJl = getIntent().getStringExtra("Key_Url");
        this.knu = getIntent().getStringExtra("Key_reg_sessionId");
        this.kpF = System.currentTimeMillis() + "_" + this.seq;
        this.kpG = getIntent().getStringExtra("kintent_nickname");
        this.kpH = getIntent().getStringExtra("kintent_password");
        this.kon = getIntent().getIntExtra("key_reg_style", 1);
        this.kpI = getIntent().getBooleanExtra("kintent_hasavatar", false);
        Log.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile (%s,%s), seq %s, verifyUrl %s, regNickname %s, hasSetAvatar %s", this.countryCode, this.dSf, this.seq, this.hJl, this.kpG, Boolean.valueOf(this.kpI));
        initView();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(196890);
                RegByMobileAutoVerifyUI.this.onBackPressed();
                AppMethodBeat.o(196890);
                return true;
            }
        });
        this.kpM.exh = System.currentTimeMillis();
        nw nwVar = this.kpM;
        nwVar.fiG = nwVar.x("DeviceID", q.aoJ(), true);
        nw nwVar2 = this.kpM;
        nwVar2.fiF = nwVar2.x("RegisterMobile", this.kpE, true);
        g.azz().a(126, this);
        g.azz().a(145, this);
        AppMethodBeat.o(196909);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(196910);
        final Button button = (Button) findViewById(R.id.fz0);
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(196899);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (RegByMobileAutoVerifyUI.this.kpJ != 2) {
                    RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this);
                } else {
                    RegByMobileAutoVerifyUI.c(RegByMobileAutoVerifyUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(196899);
            }
        });
        CheckBoxLicenseView checkBoxLicenseView = (CheckBoxLicenseView) findViewById(R.id.gyv);
        checkBoxLicenseView.setTermTip(getString(R.string.fz3));
        checkBoxLicenseView.setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass10 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(196900);
                if (z) {
                    RegByMobileAutoVerifyUI.this.kpM.eki = 1;
                    RegByMobileAutoVerifyUI.this.kpM.bfK();
                }
                button.setEnabled(z);
                AppMethodBeat.o(196900);
            }
        });
        ((TextView) findViewById(R.id.gyw)).setText(getString(R.string.fz0, new Object[]{this.kpE}));
        ((TextView) findViewById(R.id.gz3)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(196901);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                RegByMobileAutoVerifyUI.this.kpM.eki = 2;
                RegByMobileAutoVerifyUI.this.kpM.bfK();
                RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(196901);
            }
        });
        AppMethodBeat.o(196910);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(196911);
        this.kpM.eki = 4;
        this.kpM.bfK();
        super.onBackPressed();
        AppMethodBeat.o(196911);
    }

    private void bpB() {
        AppMethodBeat.i(196912);
        ((a) g.ah(a.class)).getMobileToken(this.kpF, this.hJl, this);
        this.kpK = h.a((Context) this, getString(R.string.aey), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass12 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(196902);
                ((a) g.ah(a.class)).removeCallback(RegByMobileAutoVerifyUI.this.kpF);
                RegByMobileAutoVerifyUI.this.kpK.dismiss();
                AppMethodBeat.o(196902);
            }
        });
        AppMethodBeat.o(196912);
    }

    @Override // com.tencent.mm.plugin.mobile.verify.a.a.AbstractC1483a
    public final void F(final Bundle bundle) {
        AppMethodBeat.i(196913);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(196904);
                String string = bundle.getString("session", "");
                if (!Util.isNullOrNil(string) && string.equals(RegByMobileAutoVerifyUI.this.kpF)) {
                    String string2 = bundle.getString("token", "");
                    Log.i("MicroMsg.RegByMobileAutoVerifyUI", "reg, get mobile token %s", string2);
                    if (!Util.isNullOrNil(string2)) {
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, string2);
                        AppMethodBeat.o(196904);
                        return;
                    }
                    RegByMobileAutoVerifyUI.this.kpM.eki = 3;
                    RegByMobileAutoVerifyUI.this.kpM.eRI = 2;
                    RegByMobileAutoVerifyUI.this.kpM.bfK();
                    if (RegByMobileAutoVerifyUI.this.kpK != null) {
                        RegByMobileAutoVerifyUI.this.kpK.dismiss();
                    }
                    h.a((Context) RegByMobileAutoVerifyUI.this, RegByMobileAutoVerifyUI.this.getString(R.string.fyy), "", RegByMobileAutoVerifyUI.this.getString(R.string.w0), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass13.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(196903);
                            RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
                            AppMethodBeat.o(196903);
                        }
                    });
                }
                AppMethodBeat.o(196904);
            }
        });
        AppMethodBeat.o(196913);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bm9;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(196914);
        super.onDestroy();
        ((a) g.ah(a.class)).removeCallback(this.kpF);
        g.azz().b(126, this);
        g.azz().b(145, this);
        g.azz().b(701, this);
        g.azz().b(252, this);
        AppMethodBeat.o(196914);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(196915);
        Log.i("MicroMsg.RegByMobileAutoVerifyUI", "scene %s, onSceneEnd: errType %d, errCode %d, errMsg %s", qVar, Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.kpK != null) {
            this.kpK.dismiss();
            this.kpK = null;
        }
        if (qVar.getType() == 145) {
            int Vj = ((com.tencent.mm.modelfriend.a) qVar).Vj();
            Log.i("MicroMsg.RegByMobileAutoVerifyUI", "BindMobileForReg OpCode %d", Integer.valueOf(Vj));
            if (Vj == 14) {
                if (i3 == 0) {
                    this.kpJ = ((com.tencent.mm.modelfriend.a) qVar).bbJ();
                    Log.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile check type %d", Integer.valueOf(this.kpJ));
                    if (this.kpJ == 2) {
                        cta bbM = ((com.tencent.mm.modelfriend.a) qVar).bbM();
                        this.seq = bbM.seq;
                        this.hJl = bbM.url;
                        this.kpF = System.currentTimeMillis() + "_" + this.seq;
                        bpB();
                    } else if (this.kpJ == 1) {
                        this.kpM.eki = 3;
                        this.kpM.eRI = 2;
                        this.kpM.bfK();
                        String bbL = ((com.tencent.mm.modelfriend.a) qVar).bbL();
                        String bbK = ((com.tencent.mm.modelfriend.a) qVar).bbK();
                        Intent intent = new Intent(this, RegByMobileSendSmsUI.class);
                        intent.putExtra("regsession_id", this.knu);
                        intent.putExtra("key_reg_style", 1);
                        intent.putExtra("from_mobile", this.kpE);
                        intent.putExtra("to_mobile", bbL);
                        intent.putExtra("verify_code", bbK);
                        intent.putExtra("kintent_nickname", this.kpG);
                        intent.putExtra("kintent_password", this.kpH);
                        intent.putExtra("kintent_hasavatar", this.kpI);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else {
                        this.kpM.eki = 3;
                        this.kpM.eRI = 2;
                        this.kpM.bfK();
                        int bbO = ((com.tencent.mm.modelfriend.a) qVar).bbO();
                        int bbP = ((com.tencent.mm.modelfriend.a) qVar).bbP();
                        Intent intent2 = new Intent();
                        intent2.putExtra("bindmcontact_mobile", this.kpE);
                        intent2.putExtra("bindmcontact_shortmobile", this.dSf);
                        intent2.putExtra("couttry_code", this.countryCode);
                        intent2.putExtra("mobileverify_countdownsec", bbO);
                        intent2.putExtra("mobileverify_countdownstyle", bbP);
                        intent2.putExtra("kintent_hasavatar", this.kpI);
                        intent2.putExtra("kintent_nickname", this.kpG);
                        intent2.putExtra("kintent_password", this.kpH);
                        intent2.putExtra("key_reg_style", this.kon);
                        intent2.putExtra("regsession_id", this.knu);
                        intent2.putExtra("mobile_verify_purpose", 2);
                        startActivity(MobileVerifyUI.class, intent2);
                        finish();
                    }
                } else if (i3 == -41) {
                    h.n(this, R.string.fz6, R.string.fz7);
                    AppMethodBeat.o(196915);
                    return;
                } else if (i3 == -34) {
                    h.c(this, getString(R.string.adu), "", true);
                    AppMethodBeat.o(196915);
                    return;
                }
            } else if (Vj == 15) {
                final com.tencent.mm.modelfriend.a aVar = (com.tencent.mm.modelfriend.a) qVar;
                this.dHx = aVar.bbG();
                if (i3 == 0) {
                    this.kpM.eki = 3;
                    this.kpM.eRI = 1;
                    this.kpM.bfK();
                    if (this.kon == 1) {
                        g.azz().a(126, this);
                        final v vVar = new v("", this.kpH, this.kpG, 0, "", this.kpE, "", "", this.dHx, 1, "", "", "", true, this.kpI);
                        vVar.PB(this.knu);
                        vVar.tL(this.kpJ);
                        g.azz().a(vVar, 0);
                        getString(R.string.zb);
                        this.kpK = h.a((Context) this, getString(R.string.g0m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass15 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(196906);
                                g.azz().a(vVar);
                                g.azz().b(126, RegByMobileAutoVerifyUI.this);
                                AppMethodBeat.o(196906);
                            }
                        });
                    } else {
                        Intent intent3 = new Intent();
                        intent3.putExtra("regsetinfo_ticket", this.dHx);
                        intent3.putExtra("regsetinfo_user", this.kpE);
                        intent3.putExtra("regsession_id", this.knu);
                        intent3.putExtra("mobile_check_type", 1);
                        intent3.putExtra("regsetinfo_ismobile", 4);
                        intent3.putExtra("regsetinfo_NextControl", aVar.bbN());
                        intent3.putExtra("key_reg_style", this.kon);
                        intent3.setClass(this, RegSetInfoUI.class);
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                } else if (i3 == -35) {
                    this.kpM.eki = 3;
                    this.kpM.eRI = 2;
                    this.kpM.bfK();
                    com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                    if (Dk != null) {
                        Dk.a(this, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass16 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(196907);
                                g.azz().a(701, RegByMobileAutoVerifyUI.this);
                                g.azz().a(252, RegByMobileAutoVerifyUI.this);
                                RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, aVar.getUsername(), aVar.bbF());
                                AppMethodBeat.o(196907);
                            }
                        }, null);
                    } else {
                        h.a(this, getString(R.string.adc), (String) null, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(196891);
                                g.azz().a(701, RegByMobileAutoVerifyUI.this);
                                g.azz().a(252, RegByMobileAutoVerifyUI.this);
                                RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, aVar.getUsername(), aVar.bbF());
                                AppMethodBeat.o(196891);
                            }
                        }, (DialogInterface.OnClickListener) null);
                    }
                } else if (i3 == -212) {
                    this.kpM.eki = 3;
                    this.kpM.eRI = 2;
                    this.kpM.bfK();
                    Intent intent4 = new Intent(this, MobileLoginOrForceReg.class);
                    intent4.putExtra("ticket", this.dHx);
                    intent4.putExtra("moble", this.kpE);
                    intent4.putExtra("regsession_id", this.knu);
                    intent4.putExtra("next_controll", aVar.bbN());
                    intent4.putExtra(ch.COL_USERNAME, aVar.getUsername());
                    intent4.putExtra("password", aVar.bbF());
                    intent4.putExtra("nickname", aVar.bbT());
                    intent4.putExtra("avatar_url", aVar.bbS());
                    intent4.putExtra("mobile_check_type", this.kpJ);
                    intent4.putExtra("kintent_hasavatar", this.kpI);
                    intent4.putExtra("kintent_nickname", this.kpG);
                    intent4.putExtra("kintent_password", this.kpH);
                    intent4.putExtra("key_reg_style", this.kon);
                    com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent4);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl3.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else if (i3 == -449 || i3 == -450 || i3 == -451) {
                    this.kpM.eki = 3;
                    this.kpM.eRI = 2;
                    this.kpM.bfK();
                    h.a((Context) this, getString(R.string.fyy), "", getString(R.string.w0), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(196892);
                            RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
                            AppMethodBeat.o(196892);
                        }
                    });
                    AppMethodBeat.o(196915);
                    return;
                } else {
                    this.kpM.eki = 3;
                    this.kpM.eRI = 2;
                    this.kpM.bfK();
                    Toast.makeText(this, getString(R.string.af2, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                }
            }
        } else if (qVar.getType() == 126) {
            final v vVar2 = (v) qVar;
            if (i3 == -6 || i3 == -311 || i3 == -310) {
                if (this.kpL == null) {
                    this.kpL = SecurityImage.a.a(this, 0, vVar2.bfm(), vVar2.bfl(), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(196894);
                            final v vVar = new v("", RegByMobileAutoVerifyUI.this.kpH, RegByMobileAutoVerifyUI.this.kpG, 0, "", RegByMobileAutoVerifyUI.this.kpE, "", "", RegByMobileAutoVerifyUI.this.dHx, 1, "", vVar2.bfl(), RegByMobileAutoVerifyUI.this.kpL.getSecImgCode(), true, RegByMobileAutoVerifyUI.this.kpI);
                            vVar.PB(RegByMobileAutoVerifyUI.this.knu);
                            vVar.tL(RegByMobileAutoVerifyUI.this.kpJ);
                            g.azz().a(vVar, 0);
                            RegByMobileAutoVerifyUI regByMobileAutoVerifyUI = RegByMobileAutoVerifyUI.this;
                            AppCompatActivity context = RegByMobileAutoVerifyUI.this.getContext();
                            RegByMobileAutoVerifyUI.this.getString(R.string.zb);
                            regByMobileAutoVerifyUI.kpK = h.a((Context) context, RegByMobileAutoVerifyUI.this.getString(R.string.g0m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass4.AnonymousClass1 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(196893);
                                    g.azz().a(vVar);
                                    AppMethodBeat.o(196893);
                                }
                            });
                            AppMethodBeat.o(196894);
                        }
                    }, null, new DialogInterface.OnDismissListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass5 */

                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.i(196895);
                            RegByMobileAutoVerifyUI.this.kpL = null;
                            AppMethodBeat.o(196895);
                        }
                    }, new SecurityImage.b() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass6 */

                        @Override // com.tencent.mm.ui.applet.SecurityImage.b
                        public final void bnH() {
                            AppMethodBeat.i(196896);
                            RegByMobileAutoVerifyUI.this.hideVKB();
                            v vVar = new v("", RegByMobileAutoVerifyUI.this.kpH, RegByMobileAutoVerifyUI.this.kpG, 0, "", RegByMobileAutoVerifyUI.this.kpE, "", "", RegByMobileAutoVerifyUI.this.dHx, 1, "", vVar2.bfl(), RegByMobileAutoVerifyUI.this.kpL.getSecImgCode(), true, RegByMobileAutoVerifyUI.this.kpI);
                            vVar.PB(RegByMobileAutoVerifyUI.this.knu);
                            vVar.tL(RegByMobileAutoVerifyUI.this.kpJ);
                            g.azz().a(vVar, 0);
                            AppMethodBeat.o(196896);
                        }
                    });
                    AppMethodBeat.o(196915);
                    return;
                }
                this.kpL.b(0, ((v) qVar).bfm(), ((v) qVar).bfl(), "");
                AppMethodBeat.o(196915);
                return;
            } else if (i2 == 0 && i3 == 0) {
                final String str2 = this.kpE;
                com.tencent.mm.kernel.a.unhold();
                com.tencent.mm.kernel.a.es(true);
                if (this.kpI) {
                    String str3 = com.tencent.mm.loader.j.b.aKR() + "temp.avatar";
                    String str4 = com.tencent.mm.loader.j.b.aKR() + "temp.avatar.hd";
                    s.nx(str3, str4);
                    s.deleteFile(str3);
                    BitmapUtil.createThumbNail(str4, 156, 156, Bitmap.CompressFormat.JPEG, 90, str3, true);
                    new n(this, com.tencent.mm.loader.j.b.aKR() + "temp.avatar").a(new Runnable() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass7 */

                        public final void run() {
                            AppMethodBeat.i(196897);
                            RegByMobileAutoVerifyUI.this.dHx = vVar2.bfv();
                            bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, str2);
                            s.deleteFile(com.tencent.mm.loader.j.b.aKR() + "temp.avatar");
                            Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegByMobileAutoVerifyUI.this);
                            bZ.addFlags(67108864);
                            RegByMobileAutoVerifyUI regByMobileAutoVerifyUI = RegByMobileAutoVerifyUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                            com.tencent.mm.hellhoundlib.a.a.a(regByMobileAutoVerifyUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            regByMobileAutoVerifyUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(regByMobileAutoVerifyUI, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            StringBuilder sb = new StringBuilder();
                            g.aAf();
                            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
                            g.aAf();
                            com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R200_600")).append(",4").toString());
                            RegByMobileAutoVerifyUI.this.finish();
                            AppMethodBeat.o(196897);
                        }
                    }, new Runnable() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass8 */

                        public final void run() {
                            AppMethodBeat.i(196898);
                            RegByMobileAutoVerifyUI.this.dHx = vVar2.bfv();
                            bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, str2);
                            Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegByMobileAutoVerifyUI.this);
                            bZ.addFlags(67108864);
                            RegByMobileAutoVerifyUI regByMobileAutoVerifyUI = RegByMobileAutoVerifyUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                            com.tencent.mm.hellhoundlib.a.a.a(regByMobileAutoVerifyUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            regByMobileAutoVerifyUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(regByMobileAutoVerifyUI, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            StringBuilder sb = new StringBuilder();
                            g.aAf();
                            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
                            g.aAf();
                            com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R200_600")).append(",4").toString());
                            RegByMobileAutoVerifyUI.this.finish();
                            AppMethodBeat.o(196898);
                        }
                    });
                    AppMethodBeat.o(196915);
                    return;
                }
                this.dHx = vVar2.bfv();
                bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, str2);
                Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
                bZ.addFlags(67108864);
                bZ.putExtra("LauncherUI.enter_from_reg", true);
                com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl4.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl4.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                finish();
                com.tencent.mm.plugin.b.a.bxl("RE900_100");
                StringBuilder sb = new StringBuilder();
                g.aAf();
                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
                g.aAf();
                com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R200_600")).append(",4").toString());
                AppMethodBeat.o(196915);
                return;
            }
        }
        com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
        if (Dk2 == null || !Dk2.a(this, null, null)) {
            com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str);
            AppMethodBeat.o(196915);
            return;
        }
        AppMethodBeat.o(196915);
    }

    static /* synthetic */ void b(RegByMobileAutoVerifyUI regByMobileAutoVerifyUI) {
        AppMethodBeat.i(196916);
        regByMobileAutoVerifyUI.getString(R.string.zb);
        regByMobileAutoVerifyUI.kpK = h.a((Context) regByMobileAutoVerifyUI, regByMobileAutoVerifyUI.getString(R.string.a06), false, (DialogInterface.OnCancelListener) null);
        com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(regByMobileAutoVerifyUI.kpE, 14, "", 0, "", 2);
        aVar.Ok(regByMobileAutoVerifyUI.knu);
        g.azz().a(aVar, 0);
        AppMethodBeat.o(196916);
    }

    static /* synthetic */ void e(RegByMobileAutoVerifyUI regByMobileAutoVerifyUI) {
        AppMethodBeat.i(196918);
        regByMobileAutoVerifyUI.getString(R.string.zb);
        regByMobileAutoVerifyUI.kpK = h.a((Context) regByMobileAutoVerifyUI, regByMobileAutoVerifyUI.getString(R.string.a06), false, (DialogInterface.OnCancelListener) null);
        com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(regByMobileAutoVerifyUI.kpE, 14, "", 0, "", 1);
        aVar.Ok(regByMobileAutoVerifyUI.knu);
        g.azz().a(aVar, 0);
        AppMethodBeat.o(196918);
    }

    static /* synthetic */ void a(RegByMobileAutoVerifyUI regByMobileAutoVerifyUI, String str) {
        AppMethodBeat.i(196919);
        if (regByMobileAutoVerifyUI.kpJ == 2) {
            com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(regByMobileAutoVerifyUI.kpE, 15, "", 0, "");
            aVar.Ok(regByMobileAutoVerifyUI.knu);
            aVar.tb(2);
            cta cta = new cta();
            cta.seq = regByMobileAutoVerifyUI.seq;
            cta.token = str;
            ((n.a) aVar.iMO.getReqObj()).KzI.KQe = cta;
            g.azz().a(aVar, 0);
        }
        AppMethodBeat.o(196919);
    }

    static /* synthetic */ void a(RegByMobileAutoVerifyUI regByMobileAutoVerifyUI, String str, String str2) {
        AppMethodBeat.i(196920);
        g.azz().a(701, regByMobileAutoVerifyUI);
        g.azz().a(252, regByMobileAutoVerifyUI);
        new h(new h.a() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI.AnonymousClass14 */

            @Override // com.tencent.mm.plugin.account.ui.h.a
            public final void a(ProgressDialog progressDialog) {
                AppMethodBeat.i(196905);
                RegByMobileAutoVerifyUI.this.kpK = progressDialog;
                AppMethodBeat.o(196905);
            }
        }, str, str2, regByMobileAutoVerifyUI.kpE).b(regByMobileAutoVerifyUI);
        AppMethodBeat.o(196920);
    }
}

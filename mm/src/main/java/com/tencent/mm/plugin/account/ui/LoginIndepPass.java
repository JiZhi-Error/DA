package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.cc.h;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bu;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.q;

public class LoginIndepPass extends MMActivity implements i {
    private String account;
    private String edo;
    private ProgressDialog gtM = null;
    private String kbV;
    private q kdn;
    private SecurityImage kdp = null;
    private String kjv;
    private IListener kkK = new IListener<lz>() {
        /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass1 */

        {
            AppMethodBeat.i(161702);
            this.__eventId = lz.class.getName().hashCode();
            AppMethodBeat.o(161702);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lz lzVar) {
            AppMethodBeat.i(128146);
            lz lzVar2 = lzVar;
            if (lzVar2 == null || lzVar2.dRz == null) {
                AppMethodBeat.o(128146);
                return false;
            }
            Log.i("MicroMsg.LoginIndepPass", "summerdiz loginDisasterListener callback content[%s], url[%s]", lzVar2.dRz.content, lzVar2.dRz.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", lzVar2.dRz.content);
            intent.putExtra("key_disaster_url", lzVar2.dRz.url);
            intent.setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
            Context context = MMApplicationContext.getContext();
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginIndepPass$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/account/ui/LoginIndepPass$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128146);
            return true;
        }
    };
    private String klX;
    private g klt = new g();
    private String klx;
    private Button kmA;
    private EditText kmy;
    private String kmz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LoginIndepPass() {
        AppMethodBeat.i(128163);
        AppMethodBeat.o(128163);
    }

    static /* synthetic */ void a(LoginIndepPass loginIndepPass) {
        AppMethodBeat.i(128173);
        loginIndepPass.bpf();
        AppMethodBeat.o(128173);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b2l;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128164);
        super.onCreate(bundle);
        String string = getString(R.string.emd);
        if (d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            string = getString(R.string.wx) + h.jr(this);
        }
        setMMTitle(string);
        this.kmz = getIntent().getStringExtra("bindmcontact_mobile");
        if (this.kmz != null) {
            this.account = PhoneFormater.pureNumber(this.kmz);
        }
        com.tencent.mm.plugin.account.a.a.jRu.Xc();
        this.kbV = com.tencent.mm.plugin.b.a.caK();
        initView();
        AppMethodBeat.o(128164);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128165);
        EventCenter.instance.addListener(this.kkK);
        super.onResume();
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L200_200,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("L200_200")).append(",1").toString());
        com.tencent.mm.plugin.b.a.bxk("L200_200");
        AppMethodBeat.o(128165);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128166);
        super.onPause();
        EventCenter.instance.removeListener(this.kkK);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L200_200,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("L200_200")).append(",2").toString());
        AppMethodBeat.o(128166);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128167);
        g.azz().b(701, this);
        g.azz().b(252, this);
        super.onDestroy();
        AppMethodBeat.o(128167);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128168);
        this.kmy = (EditText) findViewById(R.id.dxr);
        this.kmA = (Button) findViewById(R.id.esf);
        enableOptionMenu(false);
        addTextOptionMenu(0, getString(R.string.emf), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass9 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128153);
                LoginIndepPass.a(LoginIndepPass.this);
                AppMethodBeat.o(128153);
                return true;
            }
        });
        this.kmy.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass10 */

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(128154);
                LoginIndepPass.b(LoginIndepPass.this);
                AppMethodBeat.o(128154);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.kmy.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass11 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128155);
                if (i2 == 6 || i2 == 5) {
                    LoginIndepPass.a(LoginIndepPass.this);
                    AppMethodBeat.o(128155);
                    return true;
                }
                AppMethodBeat.o(128155);
                return false;
            }
        });
        this.kmy.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass12 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128156);
                b bVar = new b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginIndepPass$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (66 == i2 && keyEvent.getAction() == 0) {
                    LoginIndepPass.a(LoginIndepPass.this);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/account/ui/LoginIndepPass$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(128156);
                    return true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/account/ui/LoginIndepPass$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(128156);
                return false;
            }
        });
        this.kmA.setText(getString(R.string.emj));
        this.kmA.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(128159);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginIndepPass$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.ui.base.h.a(LoginIndepPass.this, LoginIndepPass.this.getString(R.string.g04) + LoginIndepPass.this.kmz, LoginIndepPass.this.getString(R.string.g05), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass13.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(128158);
                        g.azz().a(145, LoginIndepPass.this);
                        final com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(LoginIndepPass.this.account, 16, "", 0, "");
                        g.azz().a(aVar, 0);
                        LoginIndepPass loginIndepPass = LoginIndepPass.this;
                        LoginIndepPass loginIndepPass2 = LoginIndepPass.this;
                        LoginIndepPass.this.getString(R.string.zb);
                        loginIndepPass.kdn = com.tencent.mm.ui.base.h.a((Context) loginIndepPass2, LoginIndepPass.this.getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass13.AnonymousClass1.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(128157);
                                g.azz().a(aVar);
                                g.azz().b(701, LoginIndepPass.this);
                                g.azz().b(252, LoginIndepPass.this);
                                AppMethodBeat.o(128157);
                            }
                        });
                        AppMethodBeat.o(128158);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass13.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginIndepPass$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128159);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass14 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128160);
                com.tencent.mm.plugin.b.a.bxl("L200_100");
                Intent intent = new Intent(LoginIndepPass.this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.addFlags(67108864);
                LoginIndepPass loginIndepPass = LoginIndepPass.this;
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(loginIndepPass, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginIndepPass$7", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                loginIndepPass.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(loginIndepPass, "com/tencent/mm/plugin/account/ui/LoginIndepPass$7", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LoginIndepPass.this.finish();
                AppMethodBeat.o(128160);
                return true;
            }
        });
        this.kjv = getIntent().getStringExtra("auth_ticket");
        if (!Util.isNullOrNil(this.kjv)) {
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(128161);
                    LoginIndepPass.a(LoginIndepPass.this, g.bpk(), g.bpl());
                    AppMethodBeat.o(128161);
                }
            }, 500);
        }
        AppMethodBeat.o(128168);
    }

    private void bpf() {
        AppMethodBeat.i(128169);
        String obj = this.kmy.getText().toString();
        if (Util.isNullOrNil(this.account)) {
            com.tencent.mm.ui.base.h.n(this, R.string.hvs, R.string.em8);
            AppMethodBeat.o(128169);
        } else if (obj.equals("")) {
            com.tencent.mm.ui.base.h.n(this, R.string.hvk, R.string.em8);
            AppMethodBeat.o(128169);
        } else {
            hideVKB();
            g.azz().a(701, this);
            g.azz().a(252, this);
            final t tVar = new t(this.account, obj, (String) null, 1);
            g.azz().a(tVar, 0);
            getString(R.string.zb);
            this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass16 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(128162);
                    g.azz().a(tVar);
                    AppMethodBeat.o(128162);
                }
            });
            AppMethodBeat.o(128169);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        com.tencent.mm.h.a Dk;
        AppMethodBeat.i(128170);
        Log.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (this.kdn != null) {
            this.kdn.dismiss();
            this.kdn = null;
        }
        if (qVar.getType() == 252 || qVar.getType() == 701) {
            this.edo = ((t) qVar).bfk();
            g.azz().b(701, this);
            g.azz().b(252, this);
            this.klt.kds = ((t) qVar).bfl();
            this.klt.kdr = ((t) qVar).bfm();
            this.klt.kdt = ((t) qVar).bfn();
            this.klt.kmJ = ((t) qVar).getSecCodeType();
            this.klt.account = this.account;
            this.klt.kdq = this.kmy.getText().toString();
            if (i3 == -75) {
                y.dz(getContext());
                AppMethodBeat.o(128170);
            } else if (i3 == -106) {
                y.g(this, str, 0);
                AppMethodBeat.o(128170);
            } else if (i3 == -217) {
                y.a(this, e.a((t) qVar), i3);
                AppMethodBeat.o(128170);
            } else if (i3 == -205) {
                this.kjv = ((t) qVar).bbH();
                this.klX = ((t) qVar).bfp();
                this.klx = ((t) qVar).bfs();
                Log.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", Util.secPrint(this.kjv), this.klx);
                g.a(this.klt);
                Intent intent = new Intent();
                intent.putExtra("auth_ticket", this.kjv);
                intent.putExtra("binded_mobile", this.klX);
                intent.putExtra("close_safe_device_style", this.klx);
                intent.putExtra("from_source", 5);
                com.tencent.mm.plugin.account.a.a.jRt.g(this, intent);
                AppMethodBeat.o(128170);
            } else if (i3 == -140) {
                if (!Util.isNullOrNil(this.edo)) {
                    y.m(this, str, this.edo);
                }
                AppMethodBeat.o(128170);
            } else {
                if (i2 == 4 && (i3 == -16 || i3 == -17)) {
                    g.azz().a(new bu(new bu.a() {
                        /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass3 */

                        @Override // com.tencent.mm.model.bu.a
                        public final void a(com.tencent.mm.network.g gVar) {
                            AppMethodBeat.i(128148);
                            if (gVar == null) {
                                AppMethodBeat.o(128148);
                                return;
                            }
                            g.aAf();
                            gVar.aZh().a(new byte[0], new byte[0], new byte[0], com.tencent.mm.kernel.a.getUin());
                            AppMethodBeat.o(128148);
                        }
                    }), 0);
                    z = true;
                } else {
                    z = false;
                }
                if (i3 == -6 || i3 == -311 || i3 == -310) {
                    g.azz().a(701, this);
                    g.azz().a(252, this);
                    if (this.kdp == null) {
                        this.kdp = SecurityImage.a.a(getContext(), this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128150);
                                Log.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.this.klt.kds + " img len" + LoginIndepPass.this.klt.kdr.length + " " + f.apq());
                                final t tVar = new t(LoginIndepPass.this.klt.account, LoginIndepPass.this.klt.kdq, LoginIndepPass.this.klt.kmJ, LoginIndepPass.this.kdp.getSecImgCode(), LoginIndepPass.this.kdp.getSecImgSid(), LoginIndepPass.this.kdp.getSecImgEncryptKey(), 1, "", false, false);
                                g.azz().a(tVar, 0);
                                LoginIndepPass loginIndepPass = LoginIndepPass.this;
                                LoginIndepPass loginIndepPass2 = LoginIndepPass.this;
                                LoginIndepPass.this.getString(R.string.zb);
                                loginIndepPass.gtM = com.tencent.mm.ui.base.h.a((Context) loginIndepPass2, LoginIndepPass.this.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass4.AnonymousClass1 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(128149);
                                        g.azz().a(tVar);
                                        g.azz().b(701, LoginIndepPass.this);
                                        g.azz().b(252, LoginIndepPass.this);
                                        AppMethodBeat.o(128149);
                                    }
                                });
                                AppMethodBeat.o(128150);
                            }
                        }, null, new DialogInterface.OnDismissListener() {
                            /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass5 */

                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(128151);
                                LoginIndepPass.this.kdp = null;
                                AppMethodBeat.o(128151);
                            }
                        }, this.klt);
                        AppMethodBeat.o(128170);
                        return;
                    }
                    Log.d("MicroMsg.LoginIndepPass", "imgSid:" + this.klt.kds + " img len" + this.klt.kdr.length + " " + f.apq());
                    this.kdp.b(this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt);
                    AppMethodBeat.o(128170);
                } else if (z || (i2 == 0 && i3 == 0)) {
                    com.tencent.mm.kernel.a.unhold();
                    l.boe();
                    y.St(this.klt.account);
                    com.tencent.mm.platformtools.t.dr(this);
                    y.showAddrBookUploadConfirm(this, new Runnable() {
                        /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass6 */

                        public final void run() {
                            AppMethodBeat.i(128152);
                            Log.d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
                            Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(LoginIndepPass.this);
                            bZ.addFlags(67108864);
                            LoginIndepPass loginIndepPass = LoginIndepPass.this;
                            a bl = new a().bl(bZ);
                            com.tencent.mm.hellhoundlib.a.a.a(loginIndepPass, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginIndepPass$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            loginIndepPass.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(loginIndepPass, "com/tencent/mm/plugin/account/ui/LoginIndepPass$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            LoginIndepPass.this.finish();
                            AppMethodBeat.o(128152);
                        }
                    }, false, 2);
                    AppMethodBeat.o(128170);
                } else if (n(i2, i3, str)) {
                    AppMethodBeat.o(128170);
                } else if ((qVar.getType() == 252 || qVar.getType() == 701) && (Dk = com.tencent.mm.h.a.Dk(str)) != null && Dk.a(this, null, null)) {
                    AppMethodBeat.o(128170);
                } else {
                    Toast.makeText(this, getString(R.string.de5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                    AppMethodBeat.o(128170);
                }
            }
        } else if (qVar.getType() == 145) {
            g.azz().b(145, this);
            String bbI = ((com.tencent.mm.modelfriend.a) qVar).bbI();
            if (i3 == -41) {
                com.tencent.mm.ui.base.h.n(this, R.string.fz6, R.string.fz7);
                AppMethodBeat.o(128170);
            } else if (i3 == -75) {
                com.tencent.mm.ui.base.h.c(this, getString(R.string.gz), "", true);
                AppMethodBeat.o(128170);
            } else {
                com.tencent.mm.plugin.b.a.bxl("L3");
                StringBuilder sb = new StringBuilder();
                g.aAf();
                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L3,");
                g.aAf();
                com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("L3")).append(",1").toString());
                Intent intent2 = new Intent();
                intent2.putExtra("bindmcontact_mobile", this.kmz);
                intent2.putExtra("bindmcontact_shortmobile", bbI);
                intent2.putExtra("mobile_verify_purpose", 1);
                intent2.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a) qVar).bbO());
                intent2.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a) qVar).bbP());
                intent2.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a) qVar).bbQ());
                startActivity(MobileVerifyUI.class, intent2);
                AppMethodBeat.o(128170);
            }
        } else if (n(i2, i3, str)) {
            AppMethodBeat.o(128170);
        } else {
            if (!(i2 == 0 && i3 == 0)) {
                Toast.makeText(this, getString(R.string.de5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            }
            AppMethodBeat.o(128170);
        }
    }

    private boolean n(int i2, int i3, String str) {
        String ayX;
        AppMethodBeat.i(128171);
        if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), i2, i3, str)) {
            AppMethodBeat.o(128171);
            return true;
        }
        if (i2 == 4) {
            switch (i3) {
                case -2023:
                case -100:
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
                        /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }, new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass8 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    AppMethodBeat.o(128171);
                    return true;
                case -140:
                    if (!Util.isNullOrNil(this.edo)) {
                        y.m(getContext(), str, this.edo);
                    }
                    AppMethodBeat.o(128171);
                    return true;
                case -9:
                    com.tencent.mm.ui.base.h.n(this, R.string.em7, R.string.em8);
                    AppMethodBeat.o(128171);
                    return true;
                case -4:
                case -3:
                    com.tencent.mm.ui.base.h.n(this, R.string.by2, R.string.em8);
                    AppMethodBeat.o(128171);
                    return true;
                case -1:
                    if (g.azz().aYS() == 5) {
                        com.tencent.mm.ui.base.h.n(this, R.string.fbf, R.string.fbe);
                        AppMethodBeat.o(128171);
                        return true;
                    }
                    AppMethodBeat.o(128171);
                    return false;
            }
        }
        AppMethodBeat.o(128171);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4 = 0;
        AppMethodBeat.i(128172);
        super.onActivityResult(i2, i3, intent);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(intent == null);
        Log.d("MicroMsg.LoginIndepPass", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", objArr);
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
            Log.d("MicroMsg.LoginIndepPass", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", objArr2);
            if (intExtra == -217) {
                bpf();
                AppMethodBeat.o(128172);
                return;
            }
        }
        AppMethodBeat.o(128172);
    }

    static /* synthetic */ void b(LoginIndepPass loginIndepPass) {
        AppMethodBeat.i(128174);
        if (!Util.isNullOrNil(loginIndepPass.kmy.getText().toString().trim())) {
            loginIndepPass.enableOptionMenu(true);
            AppMethodBeat.o(128174);
            return;
        }
        loginIndepPass.enableOptionMenu(false);
        AppMethodBeat.o(128174);
    }

    static /* synthetic */ void a(LoginIndepPass loginIndepPass, String str, String str2) {
        AppMethodBeat.i(128175);
        if (Util.isNullOrNil(str)) {
            com.tencent.mm.ui.base.h.n(loginIndepPass, R.string.hvs, R.string.em8);
            AppMethodBeat.o(128175);
        } else if (Util.isNullOrNil(str2)) {
            com.tencent.mm.ui.base.h.n(loginIndepPass, R.string.hvk, R.string.em8);
            AppMethodBeat.o(128175);
        } else {
            loginIndepPass.kmy.setText(str2);
            loginIndepPass.hideVKB();
            g.azz().a(701, loginIndepPass);
            g.azz().a(252, loginIndepPass);
            final t tVar = new t(str, str2, (String) null, 1);
            g.azz().a(tVar, 0);
            loginIndepPass.getString(R.string.zb);
            loginIndepPass.gtM = com.tencent.mm.ui.base.h.a((Context) loginIndepPass, loginIndepPass.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.ui.LoginIndepPass.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(128147);
                    g.azz().a(tVar);
                    AppMethodBeat.o(128147);
                }
            });
            AppMethodBeat.o(128175);
        }
    }
}

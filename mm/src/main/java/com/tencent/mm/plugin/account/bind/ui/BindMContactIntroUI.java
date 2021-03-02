package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.aw.b;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;

public class BindMContactIntroUI extends MMWizardActivity implements i {
    private String dSf;
    private boolean jZU = false;
    private ImageView kaB;
    private TextView kaC;
    private TextView kaD;
    private Button kaE;
    private Button kaF;
    private l.a kaG;
    private com.tencent.mm.plugin.account.friend.ui.i kaH;
    private String kaI = null;
    private String kaJ = null;
    private int kaK;
    private int kaL = 0;
    private q tipDialog = null;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(BindMContactIntroUI bindMContactIntroUI) {
        AppMethodBeat.i(109877);
        bindMContactIntroUI.bnm();
        AppMethodBeat.o(109877);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.j3;
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109866);
        super.onCreate(bundle);
        g.azz().a(132, this);
        g.azz().a(255, this);
        g.azz().a(254, this);
        setMMTitle(R.string.aek);
        AppMethodBeat.o(109866);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109867);
        g.azz().b(132, this);
        g.azz().b(255, this);
        g.azz().b(254, this);
        if (this.kaH != null) {
            this.kaH.recycle();
        }
        super.onDestroy();
        AppMethodBeat.o(109867);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(109868);
        super.onResume();
        initView();
        AppMethodBeat.o(109868);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109869);
        this.kaK = getIntent().getIntExtra("bind_scene", 0);
        this.jZU = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.kaL = getIntent().getIntExtra("key_upload_scene", 0);
        this.kaG = l.bnZ();
        Log.d("MicroMsg.BindMContactIntroUI", "state " + this.kaG);
        this.dSf = (String) g.aAh().azQ().get(6, (Object) null);
        if (this.dSf == null || this.dSf.equals("")) {
            this.dSf = (String) g.aAh().azQ().get(4097, (Object) null);
        }
        this.kaB = (ImageView) findViewById(R.id.hm0);
        this.kaC = (TextView) findViewById(R.id.hly);
        this.kaD = (TextView) findViewById(R.id.hlx);
        this.kaE = (Button) findViewById(R.id.hlw);
        this.kaF = (Button) findViewById(R.id.hlz);
        this.kaE.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(109850);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BindMContactIntroUI.a(BindMContactIntroUI.this);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109850);
            }
        });
        this.kaF.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(109854);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BindMContactIntroUI.b(BindMContactIntroUI.this);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109854);
            }
        });
        if (getIntent().getBooleanExtra("skip", false)) {
            addTextOptionMenu(0, getString(R.string.w4), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass21 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(109857);
                    BindMContactIntroUI.c(BindMContactIntroUI.this);
                    AppMethodBeat.o(109857);
                    return true;
                }
            });
        } else {
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass22 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(109858);
                    BindMContactIntroUI.c(BindMContactIntroUI.this);
                    AppMethodBeat.o(109858);
                    return true;
                }
            });
        }
        if (this.kaG == l.a.SUCC_UNLOAD || this.kaG == l.a.SUCC) {
            String value = h.aqJ().getValue("ShowUnbindPhone");
            final int i2 = 2;
            if (!Util.isNullOrNil(value)) {
                i2 = Util.safeParseInt(value);
            }
            if (i2 != 0) {
                addIconOptionMenu(1, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass23 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(109861);
                        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(BindMContactIntroUI.this.getContext());
                        lVar.HLX = new o.f() {
                            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass23.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(m mVar) {
                                AppMethodBeat.i(109859);
                                mVar.setHeaderTitle(R.string.ae9);
                                if ((i2 & 2) != 0) {
                                    mVar.kV(0, R.string.aer);
                                }
                                if ((i2 & 1) != 0) {
                                    mVar.kV(1, R.string.ado);
                                }
                                AppMethodBeat.o(109859);
                            }
                        };
                        lVar.HLY = new o.g() {
                            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass23.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                AppMethodBeat.i(109860);
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        BindMContactIntroUI.d(BindMContactIntroUI.this);
                                        AppMethodBeat.o(109860);
                                        return;
                                    case 1:
                                        Intent intent = new Intent();
                                        intent.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
                                        c.b(BindMContactIntroUI.this, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                                        break;
                                }
                                AppMethodBeat.o(109860);
                            }
                        };
                        lVar.gXI();
                        AppMethodBeat.o(109861);
                        return false;
                    }
                });
            }
        }
        switch (this.kaG) {
            case NO_INIT:
                showOptionMenu(1, false);
                this.kaB.setImageResource(R.raw.mobile_unbind_icon);
                this.kaD.setVisibility(0);
                this.kaF.setVisibility(8);
                this.kaC.setText(R.string.ae4);
                this.kaD.setText(R.string.ae3);
                this.kaE.setText(R.string.ade);
                AppMethodBeat.o(109869);
                return;
            case SET_MOBILE:
                showOptionMenu(1, false);
                this.kaB.setImageResource(R.raw.mobile_unbind_icon);
                this.kaD.setVisibility(0);
                this.kaF.setVisibility(0);
                this.kaC.setText(String.format(getString(R.string.af6), this.dSf));
                this.kaD.setText(R.string.aev);
                this.kaE.setText(R.string.af0);
                this.kaF.setText(R.string.adp);
                AppMethodBeat.o(109869);
                return;
            case SUCC_UNLOAD:
                showOptionMenu(1, true);
                this.kaB.setImageResource(R.raw.mobile_binded_icon);
                this.kaD.setVisibility(0);
                this.kaF.setVisibility(0);
                this.kaC.setText(String.format(getString(R.string.af6), this.dSf));
                this.kaD.setText(R.string.aew);
                this.kaE.setText(R.string.aex);
                this.kaF.setText(R.string.adn);
                AppMethodBeat.o(109869);
                return;
            case SUCC:
                showOptionMenu(1, true);
                this.kaB.setImageResource(R.raw.mobile_binded_icon);
                this.kaD.setVisibility(0);
                this.kaF.setVisibility(0);
                this.kaC.setText(String.format(getString(R.string.af6), this.dSf));
                this.kaD.setText(R.string.adl);
                this.kaE.setText(R.string.ae2);
                this.kaF.setText(R.string.adn);
                break;
        }
        AppMethodBeat.o(109869);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(109870);
        if (i2 == 4) {
            bnm();
            AppMethodBeat.o(109870);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(109870);
        return onKeyDown;
    }

    private void bnm() {
        AppMethodBeat.i(109871);
        hideVKB();
        if (this.kaK == 2) {
            cancel();
            finish();
            AppMethodBeat.o(109871);
            return;
        }
        ala(1);
        AppMethodBeat.o(109871);
    }

    private void gi(boolean z) {
        b.a bs;
        AppMethodBeat.i(109872);
        Intent intent = new Intent(this, BindMContactUI.class);
        if (z) {
            intent.putExtra("bind_scene", 3);
        } else {
            intent.putExtra("bind_scene", 0);
        }
        String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
        if (!Util.isNullOrNil(simCountryIso) && (bs = com.tencent.mm.aw.b.bs(simCountryIso, getString(R.string.bj8))) != null) {
            intent.putExtra("country_name", bs.jbZ);
            intent.putExtra("couttry_code", bs.jbY);
        }
        ay(this, intent);
        AppMethodBeat.o(109872);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        AppMethodBeat.i(109873);
        Log.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + qVar.getType() + " errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar.getType() == 132 && i2 == 0 && i3 == 0) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (((z) qVar).Vj() == 3) {
                ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).removeSelfAccount(this);
                if (!Util.isNullOrNil(this.kaJ)) {
                    com.tencent.mm.ui.base.h.a(this, this.kaJ, "", getString(R.string.w1), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass26 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(109864);
                            MMWizardActivity.ay(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class));
                            AppMethodBeat.o(109864);
                        }
                    });
                    AppMethodBeat.o(109873);
                    return;
                }
                ay(this, new Intent(this, BindMContactStatusUI.class));
            }
            AppMethodBeat.o(109873);
            return;
        }
        if (!com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str)) {
            z = false;
            switch (i3) {
                case -214:
                    com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                    if (Dk != null) {
                        Dk.a(this, null, null);
                    }
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
                case APPluginConstants.ERROR_IO_ObjectStreamException_NotActiveException:
                    Toast.makeText(this, (int) R.string.ads, 0).show();
                    z = true;
                    break;
                case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                    Toast.makeText(this, (int) R.string.adu, 0).show();
                    z = true;
                    break;
            }
        } else {
            z = true;
        }
        if (z) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            AppMethodBeat.o(109873);
            return;
        }
        if (qVar.getType() == 254) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i2 == 0 && i3 == 0) {
                this.kaJ = ((aa) qVar).bol().Lle;
                this.kaI = ((aa) qVar).bok();
                if (!Util.isNullOrNil(this.kaJ)) {
                    final z zVar = new z(this.dSf, 3, "", 0, "");
                    g.azz().a(zVar, 0);
                    AppCompatActivity context = getContext();
                    getString(R.string.zb);
                    this.tipDialog = com.tencent.mm.ui.base.h.a((Context) context, getString(R.string.aeu), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass27 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(109865);
                            g.azz().a(zVar);
                            AppMethodBeat.o(109865);
                        }
                    });
                    AppMethodBeat.o(109873);
                    return;
                }
                g.azz().a(new u(2), 0);
                AppMethodBeat.o(109873);
                return;
            } else if (i3 == -3) {
                Log.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.gvz), (String) null, getString(R.string.gw0), getString(R.string.gvy), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(109851);
                        Intent intent = new Intent();
                        if (WeChatBrands.AppInfo.current().isMainland()) {
                            intent.putExtra("kintent_hint", BindMContactIntroUI.this.getString(R.string.gvw));
                        } else {
                            intent.putExtra("kintent_hint", BindMContactIntroUI.this.getString(R.string.gvx));
                        }
                        intent.putExtra("from_unbind", true);
                        c.b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
                        AppMethodBeat.o(109851);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            } else if (i3 == -81) {
                com.tencent.mm.ui.base.h.a(this, (int) R.string.gmc, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            } else if (i3 == -82) {
                com.tencent.mm.ui.base.h.a(this, (int) R.string.gmd, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            } else if (i3 == -83) {
                com.tencent.mm.ui.base.h.a(this, (int) R.string.gma, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            } else if (i3 == -84) {
                com.tencent.mm.ui.base.h.a(this, (int) R.string.gmb, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            } else if (i3 == -85) {
                com.tencent.mm.ui.base.h.a(this, (int) R.string.gm8, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass8 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            } else if (i3 == -86) {
                com.tencent.mm.ui.base.h.a(this, (int) R.string.gmf, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass9 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
        }
        if (qVar.getType() == 255) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i3 == 0) {
                final z zVar2 = new z(this.dSf, 3, "", 0, "");
                g.azz().a(zVar2, 0);
                AppCompatActivity context2 = getContext();
                getString(R.string.zb);
                this.tipDialog = com.tencent.mm.ui.base.h.a((Context) context2, getString(R.string.aeu), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass10 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(109852);
                        g.azz().a(zVar2);
                        AppMethodBeat.o(109852);
                    }
                });
            } else {
                Log.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
                com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.gvz), (String) null, getString(R.string.gw0), getString(R.string.gvy), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass11 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(109853);
                        Intent intent = new Intent();
                        if (WeChatBrands.AppInfo.current().isMainland()) {
                            intent.putExtra("kintent_hint", BindMContactIntroUI.this.getString(R.string.gvw));
                        } else {
                            intent.putExtra("kintent_hint", BindMContactIntroUI.this.getString(R.string.gvx));
                        }
                        intent.putExtra("from_unbind", true);
                        c.b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
                        AppMethodBeat.o(109853);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass13 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
        }
        if (qVar.getType() == 132) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (((z) qVar).Vj() == 3) {
                if (i3 == -82) {
                    com.tencent.mm.ui.base.h.a(this, (int) R.string.gmd, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass14 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(109873);
                    return;
                } else if (i3 == -83) {
                    com.tencent.mm.ui.base.h.a(this, (int) R.string.gma, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass15 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(109873);
                    return;
                } else if (i3 == -84) {
                    com.tencent.mm.ui.base.h.a(this, (int) R.string.gmb, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass16 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(109873);
                    return;
                } else if (i3 == -85) {
                    com.tencent.mm.ui.base.h.a(this, (int) R.string.gm8, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass17 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(109873);
                    return;
                } else {
                    Toast.makeText(this, getString(R.string.aeq, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                }
            }
        }
        AppMethodBeat.o(109873);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109874);
        super.onActivityResult(i2, i3, intent);
        Log.d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    Log.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.dSf);
                    g.azz().a(new aa(aa.kfi), 0);
                    getString(R.string.zb);
                    this.tipDialog = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass19 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    break;
                }
                break;
        }
        AppMethodBeat.o(109874);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(BindMContactIntroUI bindMContactIntroUI) {
        boolean z;
        AppMethodBeat.i(109875);
        switch (bindMContactIntroUI.kaG) {
            case NO_INIT:
                bindMContactIntroUI.gi(false);
                AppMethodBeat.o(109875);
                return;
            case SET_MOBILE:
                final String str = bindMContactIntroUI.dSf;
                if (bindMContactIntroUI.kaH == null) {
                    bindMContactIntroUI.kaH = new com.tencent.mm.plugin.account.friend.ui.i(i.b.BINDMOBILE, bindMContactIntroUI, new i.a() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass25 */

                        @Override // com.tencent.mm.plugin.account.friend.ui.i.a
                        public final void h(int i2, Bundle bundle) {
                            AppMethodBeat.i(109863);
                            if (i2 == 2) {
                                if (BindMContactIntroUI.this.kaK == 1) {
                                    if (!com.tencent.mm.model.z.aUi()) {
                                        yo yoVar = new yo();
                                        yoVar.eeN.eeO = true;
                                        yoVar.eeN.eeP = true;
                                        EventCenter.instance.publish(yoVar);
                                    }
                                    BindMContactIntroUI.g(BindMContactIntroUI.this);
                                    Intent intent = new Intent();
                                    intent.addFlags(67108864);
                                    com.tencent.mm.plugin.account.a.a.jRt.e(BindMContactIntroUI.this, intent);
                                    AppMethodBeat.o(109863);
                                    return;
                                }
                                MMWizardActivity.ay(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class).putExtra("bind_scene", BindMContactIntroUI.this.kaK));
                                if (BindMContactIntroUI.this.jZU) {
                                    if (BindMContactIntroUI.this.kaK == 2) {
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 3, 3);
                                        AppMethodBeat.o(109863);
                                        return;
                                    }
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 1, 2);
                                    AppMethodBeat.o(109863);
                                    return;
                                }
                            } else if (i2 == 1) {
                                Intent intent2 = new Intent(BindMContactIntroUI.this, BindMContactVerifyUI.class);
                                intent2.putExtra("bindmcontact_mobile", str);
                                intent2.putExtra("bind_scene", BindMContactIntroUI.this.kaK);
                                intent2.putExtra("KEnterFromBanner", BindMContactIntroUI.this.jZU);
                                MMWizardActivity.ay(BindMContactIntroUI.this, intent2);
                            }
                            AppMethodBeat.o(109863);
                        }
                    });
                }
                com.tencent.mm.plugin.account.friend.ui.i iVar = bindMContactIntroUI.kaH;
                if (bindMContactIntroUI.kaK == 0 || bindMContactIntroUI.kaK == 3) {
                    z = true;
                } else {
                    z = false;
                }
                iVar.khR = z;
                bindMContactIntroUI.kaH.Tm(str);
                AppMethodBeat.o(109875);
                return;
            case SUCC_UNLOAD:
                l.gl(false);
                ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).showAddrBookUploadConfirm(bindMContactIntroUI, new Runnable() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass18 */

                    public final void run() {
                        AppMethodBeat.i(109855);
                        if (l.bnX()) {
                            BindMContactIntroUI.bnn();
                            BindMContactIntroUI.this.kaE.setText(BindMContactIntroUI.this.getString(R.string.ae2));
                            BindMContactIntroUI.this.kaG = l.a.SUCC;
                            boolean nullAs = Util.nullAs((Boolean) g.aAh().azQ().get(12322, Boolean.FALSE), false);
                            if (BindMContactIntroUI.this.jZU && nullAs) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 3, 3);
                            }
                        }
                        AppMethodBeat.o(109855);
                    }
                }, true, bindMContactIntroUI.kaL);
                break;
            case SUCC:
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(bindMContactIntroUI, MobileFriendUI.class));
                a.a(bindMContactIntroUI, bl.axQ(), "com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI", "onClickMainButton", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                bindMContactIntroUI.startActivity((Intent) bl.pG(0));
                a.a(bindMContactIntroUI, "com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI", "onClickMainButton", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(109875);
                return;
        }
        AppMethodBeat.o(109875);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void b(BindMContactIntroUI bindMContactIntroUI) {
        AppMethodBeat.i(109876);
        switch (bindMContactIntroUI.kaG) {
            case NO_INIT:
                AppMethodBeat.o(109876);
                return;
            case SET_MOBILE:
                l.boa();
                bindMContactIntroUI.initView();
                AppMethodBeat.o(109876);
                return;
            case SUCC_UNLOAD:
                bindMContactIntroUI.gi(true);
                break;
            case SUCC:
                bindMContactIntroUI.gi(true);
                AppMethodBeat.o(109876);
                return;
        }
        AppMethodBeat.o(109876);
    }

    static /* synthetic */ void d(BindMContactIntroUI bindMContactIntroUI) {
        AppMethodBeat.i(109878);
        com.tencent.mm.ui.base.h.c(bindMContactIntroUI.getContext(), bindMContactIntroUI.getString(R.string.aeo), bindMContactIntroUI.getString(R.string.aep), bindMContactIntroUI.getString(R.string.sz), bindMContactIntroUI.getString(R.string.aen), null, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass24 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(109862);
                if (BindMContactIntroUI.this.dSf == null || BindMContactIntroUI.this.dSf.equals("")) {
                    AppMethodBeat.o(109862);
                    return;
                }
                g.azz().a(new aa(aa.kfi), 0);
                BindMContactIntroUI bindMContactIntroUI = BindMContactIntroUI.this;
                BindMContactIntroUI bindMContactIntroUI2 = BindMContactIntroUI.this;
                BindMContactIntroUI.this.getString(R.string.zb);
                bindMContactIntroUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) bindMContactIntroUI2, BindMContactIntroUI.this.getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.AnonymousClass24.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                AppMethodBeat.o(109862);
            }
        });
        AppMethodBeat.o(109878);
    }

    static /* synthetic */ void g(BindMContactIntroUI bindMContactIntroUI) {
        AppMethodBeat.i(109879);
        bindMContactIntroUI.ala(1);
        AppMethodBeat.o(109879);
    }

    static /* synthetic */ void bnn() {
        AppMethodBeat.i(109880);
        int aUc = com.tencent.mm.model.z.aUc();
        l.gl(true);
        g.aAh().azQ().set(7, Integer.valueOf(aUc & -131073));
        com.tencent.mm.plugin.account.a.a.jRu.WZ();
        AppMethodBeat.o(109880);
    }
}

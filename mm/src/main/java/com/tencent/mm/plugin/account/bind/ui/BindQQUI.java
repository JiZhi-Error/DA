package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.b.p;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.l;

public class BindQQUI extends MMWizardActivity implements i {
    private String kaI = null;
    private String kaJ = null;
    q tipDialog;
    private int type = 0;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109980);
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
        g.azz().a(254, this);
        g.azz().a(255, this);
        AppMethodBeat.o(109980);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109981);
        g.azz().b(254, this);
        g.azz().b(255, this);
        super.onDestroy();
        AppMethodBeat.o(109981);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(109982);
        super.onResume();
        initView();
        AppMethodBeat.o(109982);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.j8;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109983);
        long longValue = new p(Util.nullAsNil((Integer) g.aAh().azQ().get(9, (Object) null))).longValue();
        if (longValue == 0) {
            setMMTitle(R.string.afs);
            TextView textView = (TextView) findViewById(R.id.hm1);
            textView.setVisibility(8);
            textView.setText(R.string.afq);
            ((TextView) findViewById(R.id.hm2)).setVisibility(8);
            Button button = (Button) findViewById(R.id.a4n);
            button.setVisibility(0);
            button.setText(R.string.afp);
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(109973);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/account/bind/ui/BindQQUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    MMWizardActivity.ay(BindQQUI.this, new Intent(BindQQUI.this, VerifyQQUI.class));
                    a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindQQUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(109973);
                }
            });
            removeOptionMenu(1);
        } else {
            setMMTitle(R.string.afo);
            TextView textView2 = (TextView) findViewById(R.id.hm1);
            textView2.setVisibility(8);
            textView2.setText(R.string.afm);
            TextView textView3 = (TextView) findViewById(R.id.hm2);
            textView3.setVisibility(0);
            textView3.setText(getString(R.string.afn) + longValue);
            Button button2 = (Button) findViewById(R.id.a4n);
            button2.setVisibility(8);
            button2.setText(R.string.dyp);
            button2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(109974);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/account/bind/ui/BindQQUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindQQUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(109974);
                }
            });
            addIconOptionMenu(1, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass7 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(109977);
                    l lVar = new l(BindQQUI.this.getContext());
                    lVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass7.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(109975);
                            mVar.setHeaderTitle(R.string.ae9);
                            mVar.kV(0, R.string.hrz);
                            AppMethodBeat.o(109975);
                        }
                    };
                    lVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass7.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(109976);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    BindQQUI bindQQUI = BindQQUI.this;
                                    g.azz().a(new aa(aa.kfh), 0);
                                    bindQQUI.getString(R.string.zb);
                                    bindQQUI.tipDialog = h.a((Context) bindQQUI, bindQQUI.getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                        /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass2 */

                                        public final void onCancel(DialogInterface dialogInterface) {
                                        }
                                    });
                                    break;
                            }
                            AppMethodBeat.o(109976);
                        }
                    };
                    lVar.gXI();
                    AppMethodBeat.o(109977);
                    return false;
                }
            });
        }
        if (this.type == 1) {
            addTextOptionMenu(0, getString(R.string.w4), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(109971);
                    BindQQUI.a(BindQQUI.this);
                    AppMethodBeat.o(109971);
                    return true;
                }
            });
            AppMethodBeat.o(109983);
            return;
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109972);
                BindQQUI.this.hideVKB();
                BindQQUI.this.finish();
                AppMethodBeat.o(109972);
                return true;
            }
        });
        AppMethodBeat.o(109983);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(109984);
        Log.d("MicroMsg.BindQQUI", "onSceneEnd " + i2 + " errCode " + i3 + " errMsg " + str + "  " + qVar.getType());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (qVar.getType() == 254) {
            if (i2 == 0 && i3 == 0) {
                this.kaI = ((aa) qVar).bok();
                if (this.kaI != null && this.kaI.length() > 0) {
                    g.aAh().azQ().set(102407, this.kaI);
                }
                if (!Util.isNullOrNil(this.kaJ)) {
                    Intent intent = new Intent(this, StartUnbindQQ.class);
                    intent.putExtra("notice", this.kaJ);
                    ay(this, intent);
                    AppMethodBeat.o(109984);
                    return;
                }
                g.azz().a(new u(2), 0);
                AppMethodBeat.o(109984);
                return;
            }
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i3 == -3) {
                Log.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                h.a((Context) getContext(), getString(R.string.gvz), (String) null, getString(R.string.gw0), getString(R.string.gvy), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass8 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(109978);
                        Intent intent = new Intent();
                        intent.putExtra("kintent_hint", BindQQUI.this.getString(R.string.gvw));
                        intent.putExtra("from_unbind", true);
                        c.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
                        AppMethodBeat.o(109978);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass9 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(109984);
                return;
            } else if (i3 == -81) {
                h.a(this, (int) R.string.gmc, (int) R.string.zb, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(109984);
                return;
            } else if (i3 == -82) {
                h.a(this, (int) R.string.gmd, (int) R.string.zb, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(109984);
                return;
            } else if (i3 == -83) {
                h.a(this, (int) R.string.gma, (int) R.string.zb, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(109984);
                return;
            } else if (i3 == -84) {
                h.a(this, (int) R.string.gmb, (int) R.string.zb, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(109984);
                return;
            } else if (i3 == -85) {
                h.a(this, (int) R.string.gm_, (int) R.string.zb, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(109984);
                return;
            } else if (i3 == -86) {
                h.a(this, (int) R.string.gmf, (int) R.string.zb, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(109984);
                return;
            }
        } else if (qVar.getType() == 255) {
            if (i3 == 0) {
                ay(this, new Intent(this, StartUnbindQQ.class));
                AppMethodBeat.o(109984);
                return;
            }
            h.a((Context) getContext(), getString(R.string.gvz), (String) null, getString(R.string.gw0), getString(R.string.gvy), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(109979);
                    Intent intent = new Intent();
                    intent.putExtra("kintent_hint", BindQQUI.this.getString(R.string.gvw));
                    intent.putExtra("from_unbind", true);
                    c.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
                    AppMethodBeat.o(109979);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
        }
        AppMethodBeat.o(109984);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109985);
        super.onActivityResult(i2, i3, intent);
        Log.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    Log.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
                    g.azz().a(new aa(aa.kfh), 0);
                    getString(R.string.zb);
                    this.tipDialog = h.a((Context) this, getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindQQUI.AnonymousClass3 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    break;
                }
                break;
        }
        AppMethodBeat.o(109985);
    }

    static /* synthetic */ void a(BindQQUI bindQQUI) {
        AppMethodBeat.i(109986);
        bindQQUI.ala(1);
        AppMethodBeat.o(109986);
    }
}

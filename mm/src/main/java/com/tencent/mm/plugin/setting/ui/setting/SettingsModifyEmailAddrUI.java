package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.am;
import com.tencent.mm.plugin.account.model.e;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SettingsModifyEmailAddrUI extends MMActivity implements i, MStorageEx.IOnStorageChange {
    private EditText DcJ;
    private String DcK;
    private String DcL;
    private TextView DcM;
    private TextView DcN;
    private boolean DcO;
    private boolean DcP;
    private boolean DcQ;
    private ProgressDialog gtM;
    private String kaI = null;
    private String kaJ = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        AppMethodBeat.i(74240);
        settingsModifyEmailAddrUI.goBack();
        AppMethodBeat.o(74240);
    }

    static /* synthetic */ void b(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        AppMethodBeat.i(74241);
        settingsModifyEmailAddrUI.eTi();
        AppMethodBeat.o(74241);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74230);
        super.onCreate(bundle);
        initView();
        g.azz().a(138, this);
        g.azz().a(254, this);
        g.azz().a(256, this);
        g.azz().a(108, this);
        g.azz().a(255, this);
        g.aAh().azQ().add(this);
        AppMethodBeat.o(74230);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.br1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74231);
        g.azz().b(138, this);
        g.azz().b(254, this);
        g.azz().b(256, this);
        g.azz().b(108, this);
        g.azz().b(255, this);
        g.aAh().azQ().remove(this);
        super.onDestroy();
        AppMethodBeat.o(74231);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(74232);
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        if (mStorageEx != g.aAh().azQ() || nullAsInt <= 0) {
            Log.e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
            AppMethodBeat.o(74232);
            return;
        }
        Integer num = (Integer) g.aAh().azQ().get(7, (Object) null);
        this.DcK = (String) g.aAh().azQ().get(5, (Object) null);
        this.DcO = (num == null || (num.intValue() & 2) == 0) ? false : true;
        this.DcQ = this.DcO;
        if (this.DcP) {
            eTh();
        }
        AppMethodBeat.o(74232);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74233);
        setMMTitle(R.string.gqr);
        this.DcJ = (EditText) findViewById(R.id.hmw);
        this.DcM = (TextView) findViewById(R.id.izp);
        this.DcN = (TextView) findViewById(R.id.fj6);
        this.DcK = (String) g.aAh().azQ().get(5, (Object) null);
        this.DcJ.setText(this.DcK);
        Integer num = (Integer) g.aAh().azQ().get(7, (Object) null);
        this.DcO = (num == null || (num.intValue() & 2) == 0) ? false : true;
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74219);
                SettingsModifyEmailAddrUI.a(SettingsModifyEmailAddrUI.this);
                AppMethodBeat.o(74219);
                return true;
            }
        });
        this.DcP = true;
        eTh();
        AppMethodBeat.o(74233);
    }

    private void eTh() {
        AppMethodBeat.i(74234);
        if (this.DcO) {
            this.DcM.setVisibility(0);
            this.DcM.setText(getString(R.string.gvv));
            this.DcN.setText(getString(R.string.gqs));
            this.DcN.setTextColor(getResources().getColor(R.color.bi));
            this.DcJ.setEnabled(false);
            this.DcJ.setFilters(new InputFilter[]{new InputFilter() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass12 */

                public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                    AppMethodBeat.i(74220);
                    if (charSequence.length() <= 0) {
                        CharSequence subSequence = spanned.subSequence(i4, i5);
                        AppMethodBeat.o(74220);
                        return subSequence;
                    }
                    AppMethodBeat.o(74220);
                    return "";
                }
            }});
            this.DcM.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass22 */

                public final void onClick(View view) {
                    AppMethodBeat.i(74222);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    g.azz().a(new aa(aa.kfk), 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI2 = SettingsModifyEmailAddrUI.this;
                    SettingsModifyEmailAddrUI.this.getString(R.string.zb);
                    settingsModifyEmailAddrUI.gtM = h.a((Context) settingsModifyEmailAddrUI2, SettingsModifyEmailAddrUI.this.getString(R.string.gw1), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass22.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    SettingsModifyEmailAddrUI.this.hideVKB();
                    a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74222);
                }
            });
            hideVKB(this.DcJ);
            AppMethodBeat.o(74234);
        } else if (!Util.isNullOrNil(this.DcK)) {
            this.DcM.setVisibility(0);
            this.DcM.setText(getString(R.string.glu));
            this.DcN.setText(getString(R.string.gli));
            this.DcN.setTextColor(getResources().getColor(R.color.a5c));
            this.DcJ.setEnabled(false);
            this.DcJ.setFilters(new InputFilter[]{new InputFilter() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass23 */

                public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                    AppMethodBeat.i(74223);
                    if (charSequence.length() <= 0) {
                        CharSequence subSequence = spanned.subSequence(i4, i5);
                        AppMethodBeat.o(74223);
                        return subSequence;
                    }
                    AppMethodBeat.o(74223);
                    return "";
                }
            }});
            this.DcM.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass24 */

                public final void onClick(View view) {
                    AppMethodBeat.i(74225);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    final am amVar = new am((String) g.aAh().azQ().get(2, (Object) null));
                    g.azz().a(amVar, 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
                    AppCompatActivity context = SettingsModifyEmailAddrUI.this.getContext();
                    SettingsModifyEmailAddrUI.this.getString(R.string.zb);
                    settingsModifyEmailAddrUI.gtM = h.a((Context) context, SettingsModifyEmailAddrUI.this.getString(R.string.go7), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass24.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(74224);
                            g.azz().a(amVar);
                            AppMethodBeat.o(74224);
                        }
                    });
                    SettingsModifyEmailAddrUI.this.hideVKB();
                    a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyEmailAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74225);
                }
            });
            addTextOptionMenu(0, getString(R.string.tt), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass25 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(74226);
                    SettingsModifyEmailAddrUI.b(SettingsModifyEmailAddrUI.this);
                    AppMethodBeat.o(74226);
                    return true;
                }
            });
            hideVKB(this.DcJ);
            AppMethodBeat.o(74234);
        } else {
            eTi();
            AppMethodBeat.o(74234);
        }
    }

    private void eTi() {
        AppMethodBeat.i(74235);
        this.DcM.setVisibility(8);
        this.DcM.setText(getString(R.string.gvv));
        this.DcN.setText(getString(R.string.gqs));
        this.DcN.setTextColor(getResources().getColor(R.color.bi));
        this.DcJ.setEnabled(true);
        this.DcJ.setFilters(new InputFilter[]{new InputFilter() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass26 */

            public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                return null;
            }
        }});
        addTextOptionMenu(0, getString(R.string.yl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass27 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74228);
                SettingsModifyEmailAddrUI.this.DcL = SettingsModifyEmailAddrUI.this.DcJ.getText().toString().trim();
                if (!Util.isValidEmail(SettingsModifyEmailAddrUI.this.DcL)) {
                    h.n(SettingsModifyEmailAddrUI.this.getContext(), R.string.hvg, R.string.zb);
                    AppMethodBeat.o(74228);
                } else {
                    Integer num = (Integer) g.aAh().azQ().get(7, (Object) null);
                    Boolean valueOf = Boolean.valueOf((num == null || (num.intValue() & 2) == 0) ? false : true);
                    if (!SettingsModifyEmailAddrUI.this.DcL.equals(SettingsModifyEmailAddrUI.this.DcK) || !valueOf.booleanValue()) {
                        final e eVar = new e(e.kir, SettingsModifyEmailAddrUI.this.DcL);
                        g.azz().a(eVar, 0);
                        SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
                        SettingsModifyEmailAddrUI settingsModifyEmailAddrUI2 = SettingsModifyEmailAddrUI.this;
                        SettingsModifyEmailAddrUI.this.getString(R.string.zb);
                        settingsModifyEmailAddrUI.gtM = h.a((Context) settingsModifyEmailAddrUI2, SettingsModifyEmailAddrUI.this.getString(R.string.gns), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass27.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(74227);
                                g.azz().a(eVar);
                                AppMethodBeat.o(74227);
                            }
                        });
                        SettingsModifyEmailAddrUI.this.hideVKB();
                    } else {
                        SettingsModifyEmailAddrUI.this.finish();
                    }
                    AppMethodBeat.o(74228);
                }
                return true;
            }
        });
        AppMethodBeat.o(74235);
    }

    private void goBack() {
        AppMethodBeat.i(74236);
        hideVKB();
        finish();
        if (this.DcQ) {
            setResult(-1);
            AppMethodBeat.o(74236);
            return;
        }
        setResult(0);
        AppMethodBeat.o(74236);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(74237);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(74237);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(74237);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(74238);
        Log.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + qVar.getType() + " errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (c.jRu.a(getContext(), i2, i3, str)) {
            AppMethodBeat.o(74238);
            return;
        }
        if (qVar.getType() == 254) {
            if (i2 == 0 && i3 == 0) {
                this.kaJ = ((aa) qVar).bol().Lle;
                this.kaI = ((aa) qVar).bok();
                if (!Util.isNullOrNil(this.kaJ)) {
                    g.azz().a(new e(e.kis, this.DcJ.getText().toString().trim()), 0);
                    AppMethodBeat.o(74238);
                    return;
                }
                g.azz().a(new u(2), 0);
                AppMethodBeat.o(74238);
                return;
            }
            if (this.gtM != null) {
                this.gtM.dismiss();
                this.gtM = null;
            }
            if (i3 == -3) {
                Log.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                h.a((Context) getContext(), getString(R.string.gvz), (String) null, getString(R.string.gw0), getString(R.string.gvy), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass28 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(74229);
                        Intent intent = new Intent(SettingsModifyEmailAddrUI.this, RegByMobileSetPwdUI.class);
                        if (WeChatBrands.AppInfo.current().isMainland()) {
                            intent.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(R.string.gvw));
                        } else {
                            intent.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(R.string.gvx));
                        }
                        intent.putExtra("from_unbind", true);
                        SettingsModifyEmailAddrUI.this.startActivityForResult(intent, 1);
                        AppMethodBeat.o(74229);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(74238);
                return;
            } else if (i3 == -82) {
                h.a(this, (int) R.string.gmd, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(74238);
                return;
            } else if (i3 == -83) {
                h.a(this, (int) R.string.gma, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(74238);
                return;
            } else if (i3 == -84) {
                h.a(this, (int) R.string.gmb, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(74238);
                return;
            } else if (i3 == -85) {
                h.a(this, (int) R.string.gm5, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(74238);
                return;
            }
        } else if (qVar.getType() == 256) {
            c.jRu.WZ();
            if (((e) qVar).Vj() == e.kir) {
                if (i2 == 0 && i3 == 0) {
                    h.a(getContext(), (int) R.string.go6, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(74238);
                    return;
                }
                if (this.gtM != null) {
                    this.gtM.dismiss();
                    this.gtM = null;
                }
                if (i3 == -82) {
                    h.a(this, (int) R.string.gmd, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass8 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(74238);
                    return;
                } else if (i3 == -83) {
                    h.a(this, (int) R.string.gma, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass9 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(74238);
                    return;
                } else if (i3 == -84) {
                    h.a(this, (int) R.string.gmb, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass10 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(74238);
                    return;
                } else if (i3 == -85) {
                    h.a(this, (int) R.string.gm5, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass11 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(74238);
                    return;
                } else if (i3 == -86) {
                    h.a(this, (int) R.string.gmf, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass13 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(74238);
                    return;
                } else {
                    h.d(getContext(), getString(R.string.go5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), getString(R.string.zb), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass14 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(74238);
                    return;
                }
            } else if (((e) qVar).Vj() == e.kis) {
                if (this.gtM != null) {
                    this.gtM.dismiss();
                    this.gtM = null;
                }
                if (i2 == 0 && i3 == 0) {
                    g.aAh().azQ().set(7, Integer.valueOf(((Integer) g.aAh().azQ().get(7, (Object) null)).intValue() | 2));
                    if (!Util.isNullOrNil(this.kaJ)) {
                        h.a(getContext(), this.kaJ, "", getString(R.string.w1), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass15 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        AppMethodBeat.o(74238);
                        return;
                    }
                    h.a(getContext(), (int) R.string.gm7, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass16 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(74238);
                    return;
                }
            }
        } else if (qVar.getType() != 138) {
            if (qVar.getType() == 108) {
                if (this.gtM != null) {
                    this.gtM.dismiss();
                    this.gtM = null;
                }
                if (i2 == 0 && i3 == 0) {
                    h.a(getContext(), (int) R.string.go6, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass17 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(74238);
                    return;
                }
                h.d(getContext(), getString(R.string.go5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), getString(R.string.zb), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass18 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(74238);
                return;
            } else if (qVar.getType() == 255) {
                if (i3 == 0) {
                    g.azz().a(new e(e.kis, this.DcJ.getText().toString().trim()), 0);
                    AppMethodBeat.o(74238);
                    return;
                }
                if (this.gtM != null) {
                    this.gtM.dismiss();
                    this.gtM = null;
                }
                h.a((Context) getContext(), getString(R.string.gvz), (String) null, getString(R.string.gw0), getString(R.string.gvy), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass19 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(74221);
                        Intent intent = new Intent(SettingsModifyEmailAddrUI.this, RegByMobileSetPwdUI.class);
                        if (WeChatBrands.AppInfo.current().isMainland()) {
                            intent.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(R.string.gvw));
                        } else {
                            intent.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(R.string.gvx));
                        }
                        intent.putExtra("from_unbind", true);
                        SettingsModifyEmailAddrUI.this.startActivityForResult(intent, 1);
                        AppMethodBeat.o(74221);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass20 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
        }
        AppMethodBeat.o(74238);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(74239);
        super.onActivityResult(i2, i3, intent);
        Log.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    Log.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.DcK + " newEmail: " + this.DcL);
                    g.azz().a(new aa(aa.kfk), 0);
                    getString(R.string.zb);
                    this.gtM = h.a((Context) this, getString(R.string.gps), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.AnonymousClass21 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    break;
                }
                break;
        }
        AppMethodBeat.o(74239);
    }
}

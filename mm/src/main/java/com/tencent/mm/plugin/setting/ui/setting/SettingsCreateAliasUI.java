package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.plugin.setting.model.e;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import com.tencent.smtt.sdk.TbsListener;

public class SettingsCreateAliasUI extends MMActivity implements i {
    private i Dax = null;
    private EditText DbH;
    private e DbI;
    private boolean DbJ = false;
    private TextView DbK;
    private String fMb;
    private ProgressDialog gtM = null;
    private ImageView gvv;
    private TextView gvw;
    private TextView kqG;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(256532);
        super.onCreate(bundle);
        this.DbJ = getIntent().getBooleanExtra("KFromSetAliasTips", false);
        initView();
        g.azz().a(TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, this);
        AppMethodBeat.o(256532);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bqu;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(256533);
        super.onPause();
        AppMethodBeat.o(256533);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(256534);
        if (this.DbI != null) {
            g.azz().a(this.DbI);
        }
        g.azz().b(TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, this);
        super.onDestroy();
        AppMethodBeat.o(256534);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(256535);
        setMMTitle(R.string.bjc);
        this.gvv = (ImageView) findViewById(R.id.x1);
        this.gvw = (TextView) findViewById(R.id.fzg);
        this.kqG = (TextView) findViewById(R.id.j1u);
        this.DbK = (TextView) findViewById(R.id.fj8);
        this.DbH = (EditText) findViewById(R.id.gzj);
        String aTY = z.aTY();
        if (!as.bjx(aTY)) {
            this.DbH.setText(z.aTY());
            this.kqG.setText(getString(R.string.h5, new Object[]{aTY}));
        }
        this.DbH.setSelection(this.DbH.getText().length());
        this.DbH.setFocusable(true);
        this.DbH.setFocusableInTouchMode(true);
        this.DbH.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(256525);
                SettingsCreateAliasUI settingsCreateAliasUI = SettingsCreateAliasUI.this;
                a aVar = new a();
                if (charSequence.length() >= 6 && charSequence.length() <= 20) {
                    if (Util.isAlpha(charSequence.charAt(0))) {
                        int length = charSequence.length() - 1;
                        while (true) {
                            if (length <= 0) {
                                aVar.errMsg = settingsCreateAliasUI.getString(R.string.f38);
                                aVar.dHF = true;
                                break;
                            }
                            char charAt = charSequence.charAt(length);
                            if (Util.isAlpha(charAt) || charAt == '-' || charAt == '_' || Util.isNum(charAt)) {
                                length--;
                            } else if (Character.isSpace(charAt)) {
                                aVar.errMsg = settingsCreateAliasUI.getString(R.string.hv_);
                                aVar.dHF = false;
                            } else if (Util.isChinese(charAt)) {
                                aVar.errMsg = settingsCreateAliasUI.getString(R.string.hv8);
                                aVar.dHF = false;
                            } else {
                                aVar.errMsg = settingsCreateAliasUI.getString(R.string.hvc);
                                aVar.dHF = false;
                            }
                        }
                    } else {
                        aVar.errMsg = settingsCreateAliasUI.getString(R.string.hva);
                        aVar.dHF = false;
                    }
                } else {
                    aVar.errMsg = settingsCreateAliasUI.getString(R.string.hvc);
                    aVar.dHF = false;
                }
                if (aVar.dHF) {
                    SettingsCreateAliasUI.this.enableOptionMenu(true);
                    SettingsCreateAliasUI.this.DbK.setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(R.color.uj));
                } else {
                    SettingsCreateAliasUI.this.enableOptionMenu(false);
                    SettingsCreateAliasUI.this.DbK.setTextColor(SettingsCreateAliasUI.this.getResources().getColorStateList(R.color.a73));
                }
                SettingsCreateAliasUI.this.DbK.setText(aVar.errMsg);
                SettingsCreateAliasUI.this.kqG.setText(SettingsCreateAliasUI.this.getString(R.string.h5, new Object[]{charSequence}));
                AppMethodBeat.o(256525);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.gvw.setText(l.b(this, Util.nullAsNil(z.aUa()), this.gvw.getTextSize()));
        a.b.c(this.gvv, aTY);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(256526);
                SettingsCreateAliasUI.this.hideVKB();
                SettingsCreateAliasUI.this.finish();
                AppMethodBeat.o(256526);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.yl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(256528);
                SettingsCreateAliasUI.this.fMb = SettingsCreateAliasUI.this.DbH.getText().toString().trim();
                if (z.aTY().equalsIgnoreCase(SettingsCreateAliasUI.this.fMb)) {
                    SettingsCreateAliasUI.this.hideVKB();
                    SettingsCreateAliasUI.this.finish();
                    AppMethodBeat.o(256528);
                } else {
                    h.a(SettingsCreateAliasUI.this.getContext(), SettingsCreateAliasUI.this.getString(R.string.f36, new Object[]{SettingsCreateAliasUI.this.fMb}), SettingsCreateAliasUI.this.getString(R.string.b9d), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI.AnonymousClass3.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(256527);
                            SettingsCreateAliasUI.e(SettingsCreateAliasUI.this);
                            AppMethodBeat.o(256527);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(256528);
                }
                return true;
            }
        }, null, t.b.GREEN);
        enableOptionMenu(false);
        AppMethodBeat.o(256535);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = true;
        AppMethodBeat.i(256536);
        if (i2 == 0 && i3 == 0) {
            if (this.DbJ) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10358, "1");
            }
            hideVKB();
            g.aAh().azQ().set(42, this.fMb);
            com.tencent.mm.ak.t azz = g.azz();
            AnonymousClass5 r4 = new i() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI.AnonymousClass5 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(final int i2, final int i3, String str, final q qVar) {
                    AppMethodBeat.i(256531);
                    Log.d("MicroMsg.SettingsCreateAliasUI", "onSceneEnd " + i2 + " errCode " + i3 + " errMsg " + str + "  " + qVar.getType());
                    g.azz().b(255, SettingsCreateAliasUI.this.Dax);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(256530);
                            if (SettingsCreateAliasUI.this.gtM != null) {
                                SettingsCreateAliasUI.this.gtM.dismiss();
                                SettingsCreateAliasUI.this.gtM = null;
                            }
                            SettingsCreateAliasUI.this.Dax = null;
                            if (qVar.getType() == 255) {
                                boolean z = (i3 == -3 && i2 == 4) ? false : true;
                                Intent intent = new Intent(SettingsCreateAliasUI.this, SettingsAliasResultUI.class);
                                intent.putExtra("has_pwd", z);
                                SettingsCreateAliasUI settingsCreateAliasUI = SettingsCreateAliasUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(settingsCreateAliasUI, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                settingsCreateAliasUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(settingsCreateAliasUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsCreateAliasUI$5$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                SettingsCreateAliasUI.this.finish();
                            }
                            AppMethodBeat.o(256530);
                        }
                    });
                    AppMethodBeat.o(256531);
                }
            };
            this.Dax = r4;
            azz.a(255, r4);
            g.azz().a(new u(1), 0);
            AppMethodBeat.o(256536);
            return;
        }
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (!c.jRu.a(getContext(), i2, i3, str)) {
            switch (i2) {
                case 4:
                    if (i3 == -7 || i3 == -10) {
                        h.n(getContext(), R.string.fxp, R.string.f39);
                        break;
                    }
                default:
                    z = false;
                    break;
            }
        }
        if (z) {
            AppMethodBeat.o(256536);
        } else {
            AppMethodBeat.o(256536);
        }
    }

    static /* synthetic */ void e(SettingsCreateAliasUI settingsCreateAliasUI) {
        AppMethodBeat.i(256537);
        if (settingsCreateAliasUI.fMb.equals(z.aTY())) {
            h.n(settingsCreateAliasUI.getContext(), R.string.f37, R.string.f35);
            AppMethodBeat.o(256537);
        } else if (!Util.isValidAccount(settingsCreateAliasUI.fMb)) {
            h.n(settingsCreateAliasUI.getContext(), R.string.hvc, R.string.fxr);
            AppMethodBeat.o(256537);
        } else {
            AppCompatActivity context = settingsCreateAliasUI.getContext();
            settingsCreateAliasUI.getString(R.string.f35);
            settingsCreateAliasUI.gtM = h.a((Context) context, settingsCreateAliasUI.getString(R.string.f30), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsCreateAliasUI.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(256529);
                    if (SettingsCreateAliasUI.this.DbI != null) {
                        g.azz().a(SettingsCreateAliasUI.this.DbI);
                    }
                    AppMethodBeat.o(256529);
                }
            });
            if (settingsCreateAliasUI.DbI != null) {
                g.azz().a(settingsCreateAliasUI.DbI);
            }
            settingsCreateAliasUI.DbI = new e(settingsCreateAliasUI.fMb);
            g.azz().a(settingsCreateAliasUI.DbI, 0);
            AppMethodBeat.o(256537);
        }
    }
}

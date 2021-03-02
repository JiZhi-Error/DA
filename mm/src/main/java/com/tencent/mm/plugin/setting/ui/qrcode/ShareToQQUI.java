package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.plugin.account.model.l;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.widget.MMEditText;

public class ShareToQQUI extends MMActivity implements i {
    private TextView CYJ;
    private int CYK;
    private boolean CYL = false;
    private ProgressDialog gtM = null;
    private EditText nBD;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a0l;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73855);
        super.onCreate(bundle);
        g.azz().a(26, this);
        initView();
        if (z.aUF()) {
            c cVar = new c(getString(R.string.c71));
            cVar.bnE(Util.nullAsNil((String) g.aAh().azQ().get(65830, (Object) null)));
            new k(cVar, new l() {
                /* class com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.account.model.l, com.tencent.mm.plugin.account.model.k.a
                public final void E(Bundle bundle) {
                    AppMethodBeat.i(73852);
                    super.E(bundle);
                    AppMethodBeat.o(73852);
                }

                @Override // com.tencent.mm.plugin.account.model.l, com.tencent.mm.plugin.account.model.k.a
                public final void onError(int i2, String str) {
                    AppMethodBeat.i(73853);
                    super.onError(i2, str);
                    if (i2 == 3) {
                        ShareToQQUI.d(ShareToQQUI.this);
                    }
                    AppMethodBeat.o(73853);
                }
            }).bnw();
        }
        AppMethodBeat.o(73855);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(73856);
        g.azz().b(26, this);
        super.onDestroy();
        AppMethodBeat.o(73856);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(73857);
        setMMTitle(R.string.gke);
        this.nBD = (EditText) findViewById(R.id.be9);
        this.CYJ = (TextView) findViewById(R.id.joi);
        this.nBD.addTextChangedListener(new MMEditText.c(this.nBD, this.CYJ, 280));
        this.CYK = getIntent().getIntExtra("show_to", 2);
        if (this.CYK == 4) {
            this.nBD.setText(R.string.gjg);
        } else {
            this.nBD.setText(R.string.gji);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73845);
                ShareToQQUI.this.hideVKB();
                ShareToQQUI.this.finish();
                AppMethodBeat.o(73845);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.yx), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                final y yVar;
                boolean z;
                boolean z2;
                AppMethodBeat.i(73849);
                ShareToQQUI.this.CYL = true;
                if (ShareToQQUI.this.CYK == 2 || ShareToQQUI.this.CYK == 1) {
                    String obj = ShareToQQUI.this.nBD.getText().toString();
                    if (ShareToQQUI.this.CYK == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (ShareToQQUI.this.CYK == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    yVar = new y(obj, z, z2);
                } else if (ShareToQQUI.this.CYK == 4) {
                    long nullAsNil = Util.nullAsNil((Long) g.aAh().azQ().get(65831, (Object) null));
                    String nullAsNil2 = Util.nullAsNil((String) g.aAh().azQ().get(65830, (Object) null));
                    if (Util.milliSecondsToNow(nullAsNil) > Util.MILLSECONDS_OF_DAY && nullAsNil2.length() > 0) {
                        c cVar = new c(ShareToQQUI.this.getString(R.string.c71));
                        cVar.bnE(nullAsNil2);
                        new k(cVar, new l() {
                            /* class com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.account.model.l, com.tencent.mm.plugin.account.model.k.a
                            public final void E(Bundle bundle) {
                                AppMethodBeat.i(73846);
                                super.E(bundle);
                                AppMethodBeat.o(73846);
                            }

                            @Override // com.tencent.mm.plugin.account.model.l, com.tencent.mm.plugin.account.model.k.a
                            public final void onError(int i2, String str) {
                                AppMethodBeat.i(73847);
                                super.onError(i2, str);
                                AppMethodBeat.o(73847);
                            }
                        }).bnw();
                    }
                    yVar = new y(ShareToQQUI.this.nBD.getText().toString());
                } else {
                    h.n(ShareToQQUI.this.getContext(), R.string.h0h, R.string.zb);
                    AppMethodBeat.o(73849);
                    return true;
                }
                g.azz().a(yVar, 0);
                ShareToQQUI shareToQQUI = ShareToQQUI.this;
                AppCompatActivity context = ShareToQQUI.this.getContext();
                ShareToQQUI.this.getString(R.string.zb);
                shareToQQUI.gtM = h.a((Context) context, ShareToQQUI.this.getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.AnonymousClass2.AnonymousClass2 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(73848);
                        g.azz().a(yVar);
                        AppMethodBeat.o(73848);
                    }
                });
                AppMethodBeat.o(73849);
                return true;
            }
        });
        AppMethodBeat.o(73857);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(73858);
        Log.i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar.getType() != 26) {
            AppMethodBeat.o(73858);
            return;
        }
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (i2 == 4 && i3 == -68) {
            if (Util.isNullOrNil(str)) {
                str = "error";
            }
            h.a(this, str, getString(R.string.zb), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(73850);
                    Intent intent = new Intent(ShareToQQUI.this.getContext(), FacebookAuthUI.class);
                    intent.putExtra("is_force_unbind", true);
                    AppCompatActivity context = ShareToQQUI.this.getContext();
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareToQQUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/setting/ui/qrcode/ShareToQQUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ShareToQQUI.this.hideVKB();
                    ShareToQQUI.this.finish();
                    AppMethodBeat.o(73850);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(73858);
        } else if (i2 == 0 && i3 == 0) {
            hideVKB();
            String string = getString(R.string.h0k);
            new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.AnonymousClass4 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(73851);
                    ShareToQQUI.this.finish();
                    AppMethodBeat.o(73851);
                }
            };
            h.cD(this, string);
            AppMethodBeat.o(73858);
        } else {
            this.CYL = false;
            if (com.tencent.mm.plugin.setting.c.jRu.a(getContext(), i2, i3, str)) {
                AppMethodBeat.o(73858);
                return;
            }
            Toast.makeText(this, getString(R.string.h0j, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            AppMethodBeat.o(73858);
        }
    }

    static /* synthetic */ void d(ShareToQQUI shareToQQUI) {
        AppMethodBeat.i(73859);
        Log.e("MicroMsg.ShareToQQUI", "dealWithRefreshTokenFail");
        if (!shareToQQUI.CYL) {
            String string = shareToQQUI.getContext().getString(R.string.zb);
            h.a(shareToQQUI.getContext(), shareToQQUI.getContext().getString(R.string.c7h), string, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(73854);
                    Intent intent = new Intent(ShareToQQUI.this.getContext(), FacebookAuthUI.class);
                    intent.putExtra("is_force_unbind", true);
                    ShareToQQUI.this.getContext().startActivityForResult(intent, 8);
                    AppMethodBeat.o(73854);
                }
            }, (DialogInterface.OnClickListener) null);
        }
        AppMethodBeat.o(73859);
    }
}

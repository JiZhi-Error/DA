package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class BindGoogleContactIntroUI extends MMActivity implements i {
    private ImageView jZA;
    private TextView jZB;
    private Button jZC;
    private Button jZD;
    private boolean jZE = false;
    private boolean jZF = false;
    private String jZG;
    private ProgressDialog jZH;
    private x jZI;
    private int jZJ;
    private View.OnClickListener jZK = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(109758);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(BindGoogleContactIntroUI.this, BindGoogleContactUI.class);
            intent.putExtra("enter_scene", BindGoogleContactIntroUI.this.jZJ);
            BindGoogleContactIntroUI bindGoogleContactIntroUI = BindGoogleContactIntroUI.this;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            a.a(bindGoogleContactIntroUI, bl.axQ(), "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            bindGoogleContactIntroUI.startActivity((Intent) bl.pG(0));
            a.a(bindGoogleContactIntroUI, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109758);
        }
    };
    private View.OnClickListener jZL = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(109760);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            h.a((Context) BindGoogleContactIntroUI.this.getContext(), true, BindGoogleContactIntroUI.this.getString(R.string.hrx), "", BindGoogleContactIntroUI.this.getString(R.string.hrw), BindGoogleContactIntroUI.this.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI.AnonymousClass2.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(109759);
                    BindGoogleContactIntroUI.b(BindGoogleContactIntroUI.this);
                    AppMethodBeat.o(109759);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI.AnonymousClass2.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109760);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BindGoogleContactIntroUI() {
        AppMethodBeat.i(109763);
        AppMethodBeat.o(109763);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.j0;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109764);
        super.onCreate(bundle);
        setMMTitle(R.string.ada);
        this.jZJ = getIntent().getIntExtra("enter_scene", 0);
        this.jZE = m.dB(this);
        if (this.jZE) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
        }
        AppMethodBeat.o(109764);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(109765);
        super.onResume();
        this.jZG = (String) g.aAh().azQ().get(208903, (Object) null);
        if (TextUtils.isEmpty(this.jZG)) {
            this.jZF = false;
        } else {
            this.jZF = true;
        }
        initView();
        if (this.jZF) {
            this.jZD.setVisibility(0);
            this.jZC.setVisibility(8);
            this.jZB.setVisibility(0);
            this.jZB.setText(getString(R.string.ad9, new Object[]{this.jZG}));
            this.jZD.setOnClickListener(this.jZL);
        } else {
            bnc();
        }
        g.azz().a(487, this);
        AppMethodBeat.o(109765);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(109766);
        super.onStop();
        g.azz().b(487, this);
        AppMethodBeat.o(109766);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109767);
        super.onDestroy();
        AppMethodBeat.o(109767);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109768);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109761);
                BindGoogleContactIntroUI.this.finish();
                AppMethodBeat.o(109761);
                return true;
            }
        });
        this.jZA = (ImageView) findViewById(R.id.hlp);
        this.jZB = (TextView) findViewById(R.id.hlq);
        this.jZC = (Button) findViewById(R.id.hlo);
        this.jZD = (Button) findViewById(R.id.hm5);
        AppMethodBeat.o(109768);
    }

    private void bnc() {
        AppMethodBeat.i(109769);
        this.jZD.setVisibility(8);
        this.jZC.setVisibility(0);
        this.jZA.setVisibility(0);
        this.jZB.setVisibility(0);
        this.jZB.setText(R.string.ad_);
        this.jZC.setText(R.string.ad8);
        this.jZC.setOnClickListener(this.jZK);
        AppMethodBeat.o(109769);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109770);
        Log.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 == -1) {
            if (i2 == 2005) {
                this.jZE = intent.getBooleanExtra("gpservices", false);
                AppMethodBeat.o(109770);
                return;
            }
        } else if (i2 == 2005) {
            this.jZE = intent.getBooleanExtra("gpservices", false);
        }
        AppMethodBeat.o(109770);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(109771);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        Log.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", objArr);
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            g.aAh().azQ().set(208903, "");
            g.aAh().azQ().set(208901, "");
            g.aAh().azQ().set(208902, "");
            g.aAh().azQ().set(208905, Boolean.TRUE);
            g.aAh().azQ().gBI();
            bnc();
            h.cD(this, getString(R.string.hry));
            AppMethodBeat.o(109771);
            return;
        }
        Log.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
        Toast.makeText(this, (int) R.string.du8, 0).show();
        AppMethodBeat.o(109771);
    }

    static /* synthetic */ void b(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        AppMethodBeat.i(109772);
        bindGoogleContactIntroUI.jZI = new x(x.a.MM_BIND_GCONTACT_OPCODE_UNBIND, bindGoogleContactIntroUI.jZG, x.keY);
        g.azz().a(bindGoogleContactIntroUI.jZI, 0);
        bindGoogleContactIntroUI.getString(R.string.zb);
        bindGoogleContactIntroUI.jZH = h.a((Context) bindGoogleContactIntroUI, bindGoogleContactIntroUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(109762);
                g.azz().a(BindGoogleContactIntroUI.this.jZI);
                AppMethodBeat.o(109762);
            }
        });
        AppMethodBeat.o(109772);
    }
}

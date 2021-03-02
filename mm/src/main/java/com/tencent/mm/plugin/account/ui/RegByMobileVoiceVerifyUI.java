package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.aw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RegByMobileVoiceVerifyUI extends MMActivity implements i {
    private String dSf;
    private String kbV;
    private String klo;
    private a kqU;
    private z kqV;
    private int kqW = 0;
    private String languageCode;
    private TextView vr;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ int d(RegByMobileVoiceVerifyUI regByMobileVoiceVerifyUI) {
        switch (regByMobileVoiceVerifyUI.kqW) {
            case 0:
                return 14;
            case 1:
            case 3:
            default:
                return 16;
            case 2:
                return 8;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128629);
        super.onCreate(bundle);
        this.dSf = getIntent().getExtras().getString("bindmcontact_mobile");
        this.kqW = getIntent().getExtras().getInt("voice_verify_type");
        if (this.kqW == 0 || this.kqW == 2 || this.kqW == 3) {
            g.azz().a(145, this);
        } else if (this.kqW == 4 || this.kqW == 1) {
            g.azz().a(132, this);
        }
        this.kbV = com.tencent.mm.plugin.b.a.caK();
        initView();
        AppMethodBeat.o(128629);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128630);
        super.onResume();
        if (this.kqW == 0 || this.kqW == 2 || this.kqW == 3) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_500,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("R200_500")).append(",1").toString());
            com.tencent.mm.plugin.b.a.bxk("R200_500");
        }
        AppMethodBeat.o(128630);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128631);
        super.onDestroy();
        g.azz().b(132, this);
        g.azz().b(145, this);
        if (this.kqW == 0 || this.kqW == 2 || this.kqW == 3) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_500,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R200_500")).append(",2").toString());
        }
        AppMethodBeat.o(128631);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128632);
        if (i2 == 4) {
            com.tencent.mm.plugin.b.a.bxl(this.kbV);
            hideVKB();
            finish();
            AppMethodBeat.o(128632);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128632);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128633);
        setMMTitle(R.string.afi);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128624);
                RegByMobileVoiceVerifyUI.this.hideVKB();
                RegByMobileVoiceVerifyUI.this.finish();
                AppMethodBeat.o(128624);
                return true;
            }
        });
        this.vr = (TextView) findViewById(R.id.e7n);
        this.klo = RegByMobileVoiceVerifySelectUI.Ty(this.dSf);
        this.vr.setText(this.klo);
        this.languageCode = b.Ph(this.dSf);
        findViewById(R.id.enw).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(128625);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileVoiceVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                RegByMobileVoiceVerifyUI.this.startActivityForResult(new Intent(RegByMobileVoiceVerifyUI.this, RegByMobileVoiceVerifySelectUI.class).putExtra("voice_verify_code", RegByMobileVoiceVerifyUI.this.languageCode), 10000);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileVoiceVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128625);
            }
        });
        ((Button) findViewById(R.id.a4h)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(128628);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileVoiceVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (RegByMobileVoiceVerifyUI.this.kqW == 0 || RegByMobileVoiceVerifyUI.this.kqW == 2 || RegByMobileVoiceVerifyUI.this.kqW == 3) {
                    RegByMobileVoiceVerifyUI.this.kqU = new a(RegByMobileVoiceVerifyUI.this.dSf, RegByMobileVoiceVerifyUI.d(RegByMobileVoiceVerifyUI.this), "", 1, RegByMobileVoiceVerifyUI.this.languageCode);
                    g.azz().a(RegByMobileVoiceVerifyUI.this.kqU, 0);
                    h.a(RegByMobileVoiceVerifyUI.this, (int) R.string.aff, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI.AnonymousClass3.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(128626);
                            RegByMobileVoiceVerifyUI.this.finish();
                            AppMethodBeat.o(128626);
                        }
                    });
                } else if (RegByMobileVoiceVerifyUI.this.kqW == 4 || RegByMobileVoiceVerifyUI.this.kqW == 1) {
                    RegByMobileVoiceVerifyUI.this.kqV = new z(RegByMobileVoiceVerifyUI.this.dSf, 1, "", 1, RegByMobileVoiceVerifyUI.this.languageCode);
                    g.azz().a(RegByMobileVoiceVerifyUI.this.kqV, 0);
                    h.a(RegByMobileVoiceVerifyUI.this, (int) R.string.aff, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI.AnonymousClass3.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(128627);
                            RegByMobileVoiceVerifyUI.this.finish();
                            AppMethodBeat.o(128627);
                        }
                    });
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileVoiceVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128628);
            }
        });
        AppMethodBeat.o(128633);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(128634);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10000) {
            if (intent == null) {
                AppMethodBeat.o(128634);
                return;
            }
            this.klo = intent.getStringExtra("voice_verify_language");
            this.languageCode = intent.getStringExtra("voice_verify_code");
            this.vr.setText(this.klo);
        }
        AppMethodBeat.o(128634);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.j7;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(128635);
        Log.i("MicroMsg.RegByMobileVoiceVerifyUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        AppMethodBeat.o(128635);
    }
}

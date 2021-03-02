package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b;

public class VerifyPwdUI extends MMActivity implements i, b.a {
    private Button gxv;
    private ScrollView gxx;
    private InputPanelLinearLayout gxy;
    private View ksx;
    private TextView ksy;
    private EditText ksz;
    private int scene;
    private q tipDialog;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(VerifyPwdUI verifyPwdUI, String str) {
        AppMethodBeat.i(196950);
        verifyPwdUI.DI(str);
        AppMethodBeat.o(196950);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(196943);
        super.onCreate(bundle);
        g.azz().a(384, this);
        this.scene = getIntent().getIntExtra("key_scenen", 0);
        initView();
        AppMethodBeat.o(196943);
    }

    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(196944);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.gxx = (ScrollView) findViewById(R.id.hcs);
        this.gxy = (InputPanelLinearLayout) findViewById(R.id.dym);
        this.gxy.setExternalListener(this);
        this.ksy = (TextView) findViewById(R.id.c4r);
        this.ksx = findViewById(R.id.d98);
        this.ksz = (EditText) findViewById(R.id.gmb);
        this.ksz.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.VerifyPwdUI.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(196937);
                if (!Util.isNullOrNil(editable.toString())) {
                    VerifyPwdUI.this.gxv.setEnabled(true);
                    AppMethodBeat.o(196937);
                    return;
                }
                VerifyPwdUI.this.gxv.setEnabled(false);
                VerifyPwdUI.a(VerifyPwdUI.this, "");
                AppMethodBeat.o(196937);
            }
        });
        this.gxv = (Button) findViewById(R.id.fz0);
        this.gxv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.VerifyPwdUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(196938);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/ui/VerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                VerifyPwdUI.a(VerifyPwdUI.this, "");
                VerifyPwdUI.b(VerifyPwdUI.this);
                a.a(this, "com/tencent/mm/plugin/account/ui/VerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(196938);
            }
        });
        this.ksx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.VerifyPwdUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(196939);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/ui/VerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                VerifyPwdUI.this.hideVKB();
                c.V(VerifyPwdUI.this, "setting", ".ui.setting.SettingsForgetPwdUI");
                a.a(this, "com/tencent/mm/plugin/account/ui/VerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(196939);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.VerifyPwdUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(196940);
                VerifyPwdUI.this.onBackPressed();
                AppMethodBeat.o(196940);
                return true;
            }
        });
        AppMethodBeat.o(196944);
    }

    private void DI(String str) {
        AppMethodBeat.i(196945);
        if (Util.isNullOrNil(str)) {
            this.ksy.setVisibility(8);
            AppMethodBeat.o(196945);
            return;
        }
        this.ksy.setVisibility(0);
        this.ksy.setText(str);
        AppMethodBeat.o(196945);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(196946);
        super.onDestroy();
        g.azz().b(384, this);
        hideVKB();
        AppMethodBeat.o(196946);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(196947);
        super.onBackPressed();
        setResult(0);
        AppMethodBeat.o(196947);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c55;
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(196948);
        Log.i("MicroMsg.VerifyPwdUI", "keyboard show %s, keyboardHeight %d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gxv.getLayoutParams();
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.cb);
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.cb);
            this.gxv.setLayoutParams(layoutParams);
            this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), i2);
            final int height = this.gxx.getHeight();
            this.gxy.requestLayout();
            this.gxy.post(new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.VerifyPwdUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(196941);
                    Log.i("MicroMsg.VerifyPwdUI", "inputContainer.height: %d, screenHeight: %d", Integer.valueOf(VerifyPwdUI.this.gxy.getHeight()), Integer.valueOf(height));
                    if (VerifyPwdUI.this.gxy.getHeight() > height) {
                        VerifyPwdUI.this.gxx.scrollBy(0, VerifyPwdUI.this.gxy.getHeight() - height);
                    }
                    AppMethodBeat.o(196941);
                }
            });
            AppMethodBeat.o(196948);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gxv.getLayoutParams();
        layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.bx);
        layoutParams2.topMargin = 0;
        this.gxv.setLayoutParams(layoutParams2);
        this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), 0);
        this.gxx.scrollBy(0, 0);
        AppMethodBeat.o(196948);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(196949);
        Log.i("MicroMsg.VerifyPwdUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            Intent intent = new Intent();
            intent.putExtra("key_ticket", ((ad) qVar).bbG());
            setResult(-1, intent);
            u.cG(this, getString(R.string.hvl));
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.VerifyPwdUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(196942);
                    VerifyPwdUI.this.hideVKB();
                    VerifyPwdUI.this.finish();
                    AppMethodBeat.o(196942);
                }
            }, 500);
            AppMethodBeat.o(196949);
        } else if (i2 != 4) {
            DI(getString(R.string.u5));
            AppMethodBeat.o(196949);
        } else if (!Util.isNullOrNil(str)) {
            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
            if (Dk != null) {
                DI(Dk.desc);
                AppMethodBeat.o(196949);
                return;
            }
            DI(str);
            AppMethodBeat.o(196949);
        } else {
            DI(getString(R.string.u5));
            AppMethodBeat.o(196949);
        }
    }

    static /* synthetic */ void b(VerifyPwdUI verifyPwdUI) {
        AppMethodBeat.i(196951);
        g.azz().a(new ad(1, verifyPwdUI.ksz.getText().toString(), "", "", "", false, verifyPwdUI.scene), 0);
        verifyPwdUI.getString(R.string.zb);
        verifyPwdUI.tipDialog = h.a((Context) verifyPwdUI, verifyPwdUI.getString(R.string.ys), false, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(196951);
    }
}

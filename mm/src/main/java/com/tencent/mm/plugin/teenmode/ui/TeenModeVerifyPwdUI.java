package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.content.DialogInterface;
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

public class TeenModeVerifyPwdUI extends MMActivity implements i, b.a {
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

    static /* synthetic */ void a(TeenModeVerifyPwdUI teenModeVerifyPwdUI, String str) {
        AppMethodBeat.i(187466);
        teenModeVerifyPwdUI.DI(str);
        AppMethodBeat.o(187466);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(187459);
        super.onCreate(bundle);
        g.azz().a(384, this);
        this.scene = getIntent().getIntExtra("key_scenen", 3);
        initView();
        AppMethodBeat.o(187459);
    }

    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(187460);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.gxx = (ScrollView) findViewById(R.id.hcs);
        this.gxy = (InputPanelLinearLayout) findViewById(R.id.dym);
        this.gxy.setExternalListener(this);
        this.ksy = (TextView) findViewById(R.id.c4r);
        this.ksx = findViewById(R.id.d98);
        this.ksz = (EditText) findViewById(R.id.gmb);
        this.ksz.requestFocus();
        this.ksz.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.teenmode.ui.TeenModeVerifyPwdUI.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(187453);
                if (!Util.isNullOrNil(editable.toString())) {
                    TeenModeVerifyPwdUI.this.gxv.setEnabled(true);
                    AppMethodBeat.o(187453);
                    return;
                }
                TeenModeVerifyPwdUI.this.gxv.setEnabled(false);
                TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this, "");
                AppMethodBeat.o(187453);
            }
        });
        this.gxv = (Button) findViewById(R.id.fz0);
        this.gxv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.TeenModeVerifyPwdUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(187454);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this, "");
                TeenModeVerifyPwdUI.this.hideVKB();
                TeenModeVerifyPwdUI.b(TeenModeVerifyPwdUI.this);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187454);
            }
        });
        this.ksx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.TeenModeVerifyPwdUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(187455);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TeenModeVerifyPwdUI.this.hideVKB();
                c.V(TeenModeVerifyPwdUI.this, "setting", ".ui.setting.SettingsForgetPwdUI");
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187455);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.TeenModeVerifyPwdUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(187456);
                TeenModeVerifyPwdUI.this.onBackPressed();
                AppMethodBeat.o(187456);
                return true;
            }
        });
        AppMethodBeat.o(187460);
    }

    private void DI(String str) {
        AppMethodBeat.i(187461);
        if (Util.isNullOrNil(str)) {
            this.ksy.setVisibility(8);
            AppMethodBeat.o(187461);
            return;
        }
        this.ksy.setVisibility(0);
        this.ksy.setText(str);
        AppMethodBeat.o(187461);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(187462);
        super.onDestroy();
        g.azz().b(384, this);
        hideVKB();
        AppMethodBeat.o(187462);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(187463);
        super.onBackPressed();
        setResult(0);
        AppMethodBeat.o(187463);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c56;
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(187464);
        Log.i("MicroMsg.VerifyPwdUI", "keyboard show %s, keyboardHeight %d", Boolean.valueOf(z), Integer.valueOf(i2));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gxv.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.cr);
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.cl);
            this.gxv.setLayoutParams(layoutParams);
            this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), i2);
            final int height = this.gxx.getHeight();
            this.gxy.requestLayout();
            this.gxy.post(new Runnable() {
                /* class com.tencent.mm.plugin.teenmode.ui.TeenModeVerifyPwdUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(187457);
                    Log.i("MicroMsg.VerifyPwdUI", "inputContainer.height: %d, screenHeight: %d", Integer.valueOf(TeenModeVerifyPwdUI.this.gxy.getHeight()), Integer.valueOf(height));
                    if (TeenModeVerifyPwdUI.this.gxy.getHeight() > height) {
                        TeenModeVerifyPwdUI.this.gxx.scrollBy(0, TeenModeVerifyPwdUI.this.gxy.getHeight() - height);
                    }
                    AppMethodBeat.o(187457);
                }
            });
            AppMethodBeat.o(187464);
            return;
        }
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.bx);
        layoutParams.topMargin = 0;
        this.gxv.setLayoutParams(layoutParams);
        this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), 0);
        this.gxx.scrollBy(0, 0);
        AppMethodBeat.o(187464);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(187465);
        Log.i("MicroMsg.VerifyPwdUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.teenmode.b.b.fvs().pl(2);
            u.cG(this, getString(R.string.hvl));
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.teenmode.ui.TeenModeVerifyPwdUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(187458);
                    TeenModeVerifyPwdUI.this.hideVKB();
                    TeenModeVerifyPwdUI.this.finish();
                    c.V(TeenModeVerifyPwdUI.this, "teenmode", ".ui.SettingsTeenModeMain");
                    AppMethodBeat.o(187458);
                }
            }, 2000);
            AppMethodBeat.o(187465);
            return;
        }
        com.tencent.mm.plugin.teenmode.b.b.fvs().pl(6);
        if (i2 != 4) {
            DI(getString(R.string.u5));
            AppMethodBeat.o(187465);
        } else if (!Util.isNullOrNil(str)) {
            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
            if (Dk != null) {
                DI(Dk.desc);
                AppMethodBeat.o(187465);
                return;
            }
            DI(str);
            AppMethodBeat.o(187465);
        } else {
            DI(getString(R.string.u5));
            AppMethodBeat.o(187465);
        }
    }

    static /* synthetic */ void b(TeenModeVerifyPwdUI teenModeVerifyPwdUI) {
        AppMethodBeat.i(187467);
        g.azz().a(new ad(1, teenModeVerifyPwdUI.ksz.getText().toString(), "", "", "", false, teenModeVerifyPwdUI.scene), 0);
        teenModeVerifyPwdUI.getString(R.string.zb);
        teenModeVerifyPwdUI.tipDialog = h.a((Context) teenModeVerifyPwdUI, teenModeVerifyPwdUI.getString(R.string.ys), false, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(187467);
    }
}

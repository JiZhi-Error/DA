package com.tencent.mm.plugin.teenmode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class SettingsTeenModeIntro extends MMActivity {
    private CheckBox FWn;
    private TextView FWo;
    private Button sUc;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.brb;
    }

    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(187389);
        super.onCreate(bundle);
        setMMTitle("");
        initView();
        AppMethodBeat.o(187389);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(187390);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.sUc = (Button) findViewById(R.id.iij);
        this.sUc.setEnabled(false);
        this.sUc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeIntro.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(187385);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeIntro$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsTeenModeIntro.this.finish();
                Intent intent = new Intent();
                intent.putExtra("key_scenen", 3);
                c.b(SettingsTeenModeIntro.this, "teenmode", ".ui.TeenModeVerifyPwdUI", intent);
                a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeIntro$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187385);
            }
        });
        this.FWn = (CheckBox) findViewById(R.id.e92);
        Util.expandViewTouchArea(this.FWn, 250, 250, 250, 250);
        this.FWn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeIntro.AnonymousClass2 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(187386);
                if (z) {
                    SettingsTeenModeIntro.this.sUc.setEnabled(true);
                    AppMethodBeat.o(187386);
                    return;
                }
                SettingsTeenModeIntro.this.sUc.setEnabled(false);
                AppMethodBeat.o(187386);
            }
        });
        String string = getString(R.string.hlm);
        String string2 = getString(R.string.hln);
        int lastIndexOf = string.lastIndexOf(string2);
        if (lastIndexOf < 0) {
            AppMethodBeat.o(187390);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new com.tencent.mm.plugin.teenmode.b.a() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeIntro.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.teenmode.b.a
            public final void ebS() {
                AppMethodBeat.i(187387);
                SettingsTeenModeIntro.b(SettingsTeenModeIntro.this);
                AppMethodBeat.o(187387);
            }
        }, lastIndexOf, string2.length() + lastIndexOf, 18);
        this.FWo = (TextView) findViewById(R.id.e93);
        this.FWo.setOnTouchListener(new o(this));
        this.FWo.setClickable(true);
        this.FWo.setText(spannableStringBuilder);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeIntro.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(187388);
                SettingsTeenModeIntro.this.onBackPressed();
                AppMethodBeat.o(187388);
                return true;
            }
        });
        AppMethodBeat.o(187390);
    }

    static /* synthetic */ void b(SettingsTeenModeIntro settingsTeenModeIntro) {
        AppMethodBeat.i(187391);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=weixin_agreement&s=teens_mode_agreement&lang=zh_CN");
        c.b(settingsTeenModeIntro, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(187391);
    }
}

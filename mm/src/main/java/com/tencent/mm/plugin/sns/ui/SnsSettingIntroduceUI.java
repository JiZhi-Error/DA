package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e;

public class SnsSettingIntroduceUI extends MMActivity {
    private Button EIX;
    private Button EIY;
    private Intent EIZ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(99075);
        super.onDestroy();
        AppMethodBeat.o(99075);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(99076);
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        hideTitleView();
        this.EIZ = getIntent();
        this.EIX = (Button) findViewById(R.id.xt);
        this.EIX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(99073);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/SnsSettingIntroduceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(14090, 3);
                c.b(SnsSettingIntroduceUI.this, "sns", ".ui.SnsTimeLineUI", SnsSettingIntroduceUI.this.EIZ);
                SnsSettingIntroduceUI.this.finish();
                SnsSettingIntroduceUI.this.overridePendingTransition(0, 0);
                a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingIntroduceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99073);
            }
        });
        h.INSTANCE.a(14090, 1);
        this.EIY = (Button) findViewById(R.id.dke);
        this.EIY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(99074);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/SnsSettingIntroduceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bb bbVar = new bb();
                bbVar.dEk.index = 3;
                EventCenter.instance.publish(bbVar);
                c.b(SnsSettingIntroduceUI.this.getContext(), "setting", ".ui.setting.SettingsUI", new Intent());
                Intent intent = new Intent();
                intent.putExtra("enter_scene", e.k.Ozk);
                c.b(SnsSettingIntroduceUI.this.getContext(), "setting", ".ui.setting.SettingsPrivacyUI", intent);
                h.INSTANCE.a(14090, 2);
                SnsSettingIntroduceUI.this.finish();
                a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingIntroduceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99074);
            }
        });
        AppMethodBeat.o(99076);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(99077);
        if (i2 == 4 && keyEvent.getAction() == 0) {
            finish();
            h.INSTANCE.a(14090, 3);
            AppMethodBeat.o(99077);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(99077);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bx3;
    }
}

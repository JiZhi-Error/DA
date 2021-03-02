package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class SnsLongMsgUI extends MMActivity {
    private Button Edp;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(98850);
        super.onDestroy();
        AppMethodBeat.o(98850);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98851);
        super.onCreate(bundle);
        setTitleVisibility(8);
        this.Edp = (Button) findViewById(R.id.e6o);
        this.Edp.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsLongMsgUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(98849);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/SnsLongMsgUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.setClass(SnsLongMsgUI.this, SnsUploadUI.class);
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", Util.nowSecond());
                intent.putExtra("sns_comment_type", 1);
                intent.putExtra("Ksnsupload_type", 9);
                SnsLongMsgUI snsLongMsgUI = SnsLongMsgUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(snsLongMsgUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsLongMsgUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                snsLongMsgUI.startActivity((Intent) bl.pG(0));
                a.a(snsLongMsgUI, "com/tencent/mm/plugin/sns/ui/SnsLongMsgUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                SnsLongMsgUI.this.finish();
                a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLongMsgUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98849);
            }
        });
        AppMethodBeat.o(98851);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(98852);
        if (i2 == 4 && keyEvent.getAction() == 0) {
            Intent intent = new Intent();
            intent.setClass(this, SnsUploadUI.class);
            intent.putExtra("KSnsPostManu", true);
            intent.putExtra("KTouchCameraTime", Util.nowSecond());
            intent.putExtra("sns_comment_type", 1);
            intent.putExtra("Ksnsupload_type", 9);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            a.a(this, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsLongMsgUI", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            a.a(this, "com/tencent/mm/plugin/sns/ui/SnsLongMsgUI", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
            AppMethodBeat.o(98852);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(98852);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b2q;
    }
}

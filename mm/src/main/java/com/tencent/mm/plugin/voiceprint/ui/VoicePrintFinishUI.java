package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class VoicePrintFinishUI extends MMActivity {
    private TextView BgP;
    private int Fex;
    private Button GSc;
    private ImageView GSd;
    private TextView mPa;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29889);
        Log.i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
        super.onCreate(bundle);
        hideTitleView();
        this.Fex = getIntent().getIntExtra("kscene_type", 73);
        Log.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", Integer.valueOf(this.Fex));
        this.mPa = (TextView) findViewById(R.id.j_j);
        this.BgP = (TextView) findViewById(R.id.j_l);
        this.GSc = (Button) findViewById(R.id.h6z);
        this.GSd = (ImageView) findViewById(R.id.j_i);
        switch (this.Fex) {
            case 72:
                this.mPa.setText(R.string.hzw);
                this.BgP.setText(R.string.hzx);
                this.GSd.setVisibility(0);
                this.GSc.setText(R.string.gwk);
                break;
            case d.CTRL_INDEX:
                this.mPa.setVisibility(8);
                this.BgP.setText(R.string.i0l);
                this.GSd.setVisibility(0);
                this.GSc.setText(R.string.gwl);
                break;
        }
        this.GSc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.VoicePrintFinishUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(29887);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (VoicePrintFinishUI.this.Fex == 72) {
                    Intent intent = new Intent();
                    intent.setClass(VoicePrintFinishUI.this, VoiceUnLockUI.class);
                    intent.putExtra("kscene_type", 73);
                    VoicePrintFinishUI voicePrintFinishUI = VoicePrintFinishUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(voicePrintFinishUI, bl.axQ(), "com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    voicePrintFinishUI.startActivity((Intent) bl.pG(0));
                    a.a(voicePrintFinishUI, "com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                VoicePrintFinishUI.this.finish();
                a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoicePrintFinishUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29887);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.VoicePrintFinishUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29888);
                VoicePrintFinishUI.this.finish();
                AppMethodBeat.o(29888);
                return true;
            }
        });
        AppMethodBeat.o(29889);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(29890);
        super.onDestroy();
        AppMethodBeat.o(29890);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c6m;
    }
}

package com.tencent.mm.plugin.account.bind.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactStatusUI extends MMWizardActivity {
    private Button hPX;
    private ImageView kaB;
    private TextView kaT;
    private TextView kaU;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109882);
        super.onCreate(bundle);
        setMMTitle(R.string.aek);
        initView();
        AppMethodBeat.o(109882);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.j4;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109883);
        this.kaB = (ImageView) findViewById(R.id.a43);
        this.kaT = (TextView) findViewById(R.id.a41);
        this.kaU = (TextView) findViewById(R.id.a3z);
        this.hPX = (Button) findViewById(R.id.a42);
        if (l.bnZ() == l.a.SUCC) {
            this.kaB.setImageResource(R.raw.mobile_binded_icon);
            String str = (String) g.aAh().azQ().get(6, (Object) null);
            if (str == null || str.equals("")) {
                str = (String) g.aAh().azQ().get(4097, (Object) null);
            }
            this.kaU.setText(getString(R.string.aeg));
            this.kaT.setText(getString(R.string.af6, new Object[]{str}));
        } else {
            this.kaB.setImageResource(R.raw.mobile_unbind_icon);
            this.kaU.setText(R.string.aes);
            this.kaT.setText(R.string.aes);
            this.kaU.setVisibility(8);
        }
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactStatusUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(109881);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactStatusUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BindMContactStatusUI.a(BindMContactStatusUI.this);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactStatusUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109881);
            }
        });
        AppMethodBeat.o(109883);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(109884);
        if (i2 == 4) {
            ala(1);
            AppMethodBeat.o(109884);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(109884);
        return onKeyDown;
    }

    static /* synthetic */ void a(BindMContactStatusUI bindMContactStatusUI) {
        AppMethodBeat.i(109885);
        bindMContactStatusUI.ala(1);
        AppMethodBeat.o(109885);
    }
}

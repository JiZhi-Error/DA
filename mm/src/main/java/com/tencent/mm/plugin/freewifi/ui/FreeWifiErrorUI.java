package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiErrorUI extends MMActivity {
    private ImageView wRq;
    private TextView wRr;
    private TextView wRs;
    private TextView wRt;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25017);
        super.onCreate(bundle);
        setMMTitle(R.string.dip);
        this.wRq = (ImageView) findViewById(R.id.d_h);
        if (getIntent().getIntExtra("free_wifi_show_detail_error", 0) == 1) {
            this.wRq.setImageResource(R.drawable.bdm);
        }
        this.wRr = (TextView) findViewById(R.id.d_g);
        this.wRs = (TextView) findViewById(R.id.d_e);
        this.wRt = (TextView) findViewById(R.id.d_f);
        String stringExtra = getIntent().getStringExtra("free_wifi_error_ui_error_msg");
        String stringExtra2 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail1");
        String stringExtra3 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail12");
        if (!m.eP(stringExtra)) {
            this.wRr.setText(stringExtra);
        }
        if (!m.eP(stringExtra2)) {
            this.wRs.setText(stringExtra2);
        }
        if (!m.eP(stringExtra3)) {
            this.wRt.setText(stringExtra3);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25016);
                FreeWifiErrorUI.this.finish();
                AppMethodBeat.o(25016);
                return true;
            }
        });
        AppMethodBeat.o(25017);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.amh;
    }
}

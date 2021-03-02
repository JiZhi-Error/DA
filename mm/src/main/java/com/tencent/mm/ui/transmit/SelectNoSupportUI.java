package com.tencent.mm.ui.transmit;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class SelectNoSupportUI extends MMActivity {
    private String QzS = "friend";
    private TextView QzT;
    private TextView QzU;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ba_;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39411);
        super.onCreate(bundle);
        Log.i("MicroMsg.SelectNoSupportUI", "onCreate!");
        this.QzS = getIntent().getStringExtra("sharePictureTo");
        Log.i("MicroMsg.SelectNoSupportUI", "initData done!");
        initView();
        Log.i("MicroMsg.SelectNoSupportUI", "initView done!");
        AppMethodBeat.o(39411);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(39412);
        setMMTitle(getString(R.string.gi6));
        this.QzT = (TextView) findViewById(R.id.g04);
        this.QzU = (TextView) findViewById(R.id.g03);
        this.QzT.setText(getString(R.string.gie));
        if (!Util.isNullOrNil(this.QzS)) {
            String str = this.QzS;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1266283874:
                    if (str.equals("friend")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 114040:
                    if (str.equals("sns")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    this.QzU.setText(getString(R.string.gif));
                    break;
                case 1:
                    this.QzU.setText(getString(R.string.gig));
                    break;
            }
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.transmit.SelectNoSupportUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39410);
                SelectNoSupportUI selectNoSupportUI = SelectNoSupportUI.this;
                selectNoSupportUI.hideVKB();
                selectNoSupportUI.finish();
                AppMethodBeat.o(39410);
                return true;
            }
        });
        AppMethodBeat.o(39412);
    }
}

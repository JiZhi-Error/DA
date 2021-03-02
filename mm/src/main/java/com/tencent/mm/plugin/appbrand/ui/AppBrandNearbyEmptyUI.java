package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.report.model.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;

public final class AppBrandNearbyEmptyUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ed;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        View findViewById;
        AppMethodBeat.i(48664);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(48664);
            return;
        }
        if (ao.gJN()) {
            overridePendingTransition(0, 0);
        }
        getContentView().setBackgroundColor(getContext().getResources().getColor(R.color.a2r));
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        setMMTitle(R.string.nx);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48663);
                AppBrandNearbyEmptyUI.this.onBackPressed();
                AppMethodBeat.o(48663);
                return true;
            }
        });
        if (!(getSupportActionBar() == null || (findViewById = getSupportActionBar().getCustomView().findViewById(R.id.eh)) == null || findViewById.getLayoutParams() == null || !(findViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
            ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).rightMargin = 0;
            findViewById.requestLayout();
        }
        TextView textView = (TextView) findViewById(R.id.bfc);
        TextView textView2 = (TextView) findViewById(R.id.bf2);
        switch (getIntent().getIntExtra("extra_enter_reason", 0)) {
            case 0:
                l lVar = new l();
                lVar.nJe = l.b.TOP_ENTRANCE_IN_DESKTOP;
                lVar.nJi = l.a.EMPTY_PAGE;
                lVar.report();
                break;
            case 1:
                textView.setText(R.string.nw);
                textView2.setText(R.string.nv);
                l lVar2 = new l();
                lVar2.nJe = l.b.TOP_ENTRANCE_IN_DESKTOP;
                lVar2.nJi = l.a.LBS_NOT_ALLOW;
                lVar2.report();
                break;
            default:
                finish();
                AppMethodBeat.o(48664);
                return;
        }
        setResult(-1);
        AppMethodBeat.o(48664);
    }
}

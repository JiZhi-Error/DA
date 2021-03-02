package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mm.ui.ai;

public abstract class SearchBarUI extends BaseActivity implements ai.a {
    ai OKE;

    @Override // com.tencent.mm.ui.BaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.BaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a("", new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.SearchBarUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(159098);
                SearchBarUI searchBarUI = SearchBarUI.this;
                searchBarUI.removeAllOptionMenu();
                searchBarUI.OKE = new ai(searchBarUI);
                searchBarUI.OKE.setSearchViewListener(searchBarUI);
                searchBarUI.OKE.setHint(searchBarUI.getResources().getString(R.string.hru));
                searchBarUI.getSupportActionBar().setCustomView(searchBarUI.OKE);
                SearchBarUI.showVKB(searchBarUI);
                AppMethodBeat.o(159098);
                return false;
            }
        }, BaseActivity.c.SEARCH);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.SearchBarUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(159099);
                SearchBarUI.this.finish();
                AppMethodBeat.o(159099);
                return true;
            }
        });
    }

    @Override // com.tencent.mm.ui.ai.a
    public void onClickBackBtn(View view) {
        finish();
    }
}

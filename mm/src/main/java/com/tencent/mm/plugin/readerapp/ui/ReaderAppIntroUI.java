package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.ui.MMActivity;

public class ReaderAppIntroUI extends MMActivity {
    private int dXa = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bkz;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(102704);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(102704);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(102705);
        ImageView imageView = (ImageView) findViewById(R.id.gsx);
        TextView textView = (TextView) findViewById(R.id.gsy);
        this.dXa = getIntent().getIntExtra("type", 0);
        if (this.dXa == 20) {
            setMMTitle(R.string.dz0);
            imageView.setImageResource(R.drawable.bmi);
            textView.setText(R.string.beh);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppIntroUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(102702);
                ReaderAppIntroUI.this.finish();
                AppMethodBeat.o(102702);
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppIntroUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(102703);
                a.jRt.c(new Intent().putExtra("Contact_User", bv.sd(ReaderAppIntroUI.this.dXa)), ReaderAppIntroUI.this);
                ReaderAppIntroUI.this.finish();
                AppMethodBeat.o(102703);
                return true;
            }
        });
        AppMethodBeat.o(102705);
    }
}

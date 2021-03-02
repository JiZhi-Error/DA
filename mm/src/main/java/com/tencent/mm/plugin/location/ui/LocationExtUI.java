package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t;
import java.util.ArrayList;

public class LocationExtUI extends MMActivity {
    private ArrayList<String> rms = new ArrayList<>();
    private TextView yHx;
    private TextView yHy;
    private String yHz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LocationExtUI() {
        AppMethodBeat.i(55812);
        AppMethodBeat.o(55812);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55813);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (Util.isNullOrNil(stringExtra)) {
            findViewById(R.id.eqc).setVisibility(8);
        } else {
            ((TextView) findViewById(R.id.eqw)).setText(stringExtra);
        }
        this.yHx = (TextView) findViewById(R.id.ihe);
        this.yHy = (TextView) findViewById(R.id.h02);
        this.yHx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.LocationExtUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(55808);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/location/ui/LocationExtUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("key_fav_result_list", LocationExtUI.this.rms);
                com.tencent.mm.plugin.fav.a.b.a(LocationExtUI.this.getContext(), ".ui.FavTagEditUI", intent, 4098);
                a.a(this, "com/tencent/mm/plugin/location/ui/LocationExtUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(55808);
            }
        });
        this.yHy.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.LocationExtUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(55809);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/location/ui/LocationExtUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(LocationExtUI.this.getContext(), RemarkUI.class);
                intent.putExtra("key_nullable", true);
                intent.putExtra("key_value", LocationExtUI.this.getIntent().getStringExtra("key_value"));
                intent.putExtra("key_hint", LocationExtUI.this.getString(R.string.ekx));
                intent.putExtra("Kwebmap_locaion", LocationExtUI.this.getIntent().getStringExtra("Kwebmap_locaion"));
                intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
                intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
                intent.putExtra("kFavInfoLocalId", LocationExtUI.this.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("kRemark", LocationExtUI.this.getIntent().getStringExtra("kRemark"));
                LocationExtUI.this.startActivityForResult(intent, 4097);
                a.a(this, "com/tencent/mm/plugin/location/ui/LocationExtUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(55809);
            }
        });
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.location.ui.LocationExtUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55810);
                Intent intent = new Intent();
                intent.putExtra("key_remark_result", LocationExtUI.this.yHz);
                intent.putExtra("key_tags_result", LocationExtUI.this.rms);
                LocationExtUI.this.setResult(-1, intent);
                LocationExtUI.this.finish();
                AppMethodBeat.o(55810);
                return true;
            }
        }, null, t.b.GREEN);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.location.ui.LocationExtUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55811);
                LocationExtUI.this.finish();
                AppMethodBeat.o(55811);
                return true;
            }
        });
        AppMethodBeat.o(55813);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b2_;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(55814);
        if (4097 == i2) {
            if (-1 != i3 || intent == null) {
                AppMethodBeat.o(55814);
                return;
            }
            CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
            this.yHz = charSequenceExtra == null ? "" : charSequenceExtra.toString();
            this.yHy.setText(this.yHz);
            AppMethodBeat.o(55814);
        } else if (4098 != i2) {
            super.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(55814);
        } else if (-1 != i3 || intent == null) {
            AppMethodBeat.o(55814);
        } else {
            this.rms.clear();
            String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
            if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
                AppMethodBeat.o(55814);
                return;
            }
            String str = stringArrayExtra[0];
            this.rms.add(stringArrayExtra[0]);
            String string = getResources().getString(R.string.ccr);
            for (int i4 = 1; i4 < stringArrayExtra.length; i4++) {
                this.rms.add(stringArrayExtra[i4]);
                str = str + string + stringArrayExtra[i4];
            }
            this.yHx.setText(str);
            AppMethodBeat.o(55814);
        }
    }
}

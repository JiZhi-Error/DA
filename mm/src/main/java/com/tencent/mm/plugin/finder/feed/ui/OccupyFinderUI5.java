package com.tencent.mm.plugin.finder.feed.ui;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.abk;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.sdk.event.EventCenter;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "plugin-finder_release"})
public final class OccupyFinderUI5 extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245741);
        super.onCreate(bundle);
        setContentView(R.layout.akx);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        if (getIntent().getBooleanExtra("enterRealnameVerifyUI", false)) {
            a aVar = a.vUU;
            a.g(this, "");
        } else {
            EventCenter.instance.publish(new abk());
            finish();
        }
        overridePendingTransition(0, 0);
        AppMethodBeat.o(245741);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(245742);
        super.onNewIntent(intent);
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(245742);
    }
}

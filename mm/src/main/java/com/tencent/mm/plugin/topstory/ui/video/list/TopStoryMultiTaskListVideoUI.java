package com.tencent.mm.plugin.topstory.ui.video.list;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.a;

@a(6)
public class TopStoryMultiTaskListVideoUI extends TopStoryListVideoUI {
    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(236403);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        AppMethodBeat.o(236403);
    }
}

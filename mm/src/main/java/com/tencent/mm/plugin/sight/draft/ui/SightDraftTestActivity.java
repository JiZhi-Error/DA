package com.tencent.mm.plugin.sight.draft.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class SightDraftTestActivity extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28692);
        super.onCreate(bundle);
        SightDraftContainerView sightDraftContainerView = new SightDraftContainerView(this);
        setContentView(sightDraftContainerView);
        sightDraftContainerView.eVW();
        AppMethodBeat.o(28692);
    }
}

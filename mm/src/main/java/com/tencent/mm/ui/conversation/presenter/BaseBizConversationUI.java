package com.tencent.mm.ui.conversation.presenter;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.conversation.BaseConversationUI;

public abstract class BaseBizConversationUI extends BaseConversationUI {
    MMActivity.a onActResult = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.conversation.BaseConversationUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.conversation.BaseConversationUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (this.onActResult != null) {
            this.onActResult.d(i2, i3, intent);
            this.onActResult = null;
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }
}

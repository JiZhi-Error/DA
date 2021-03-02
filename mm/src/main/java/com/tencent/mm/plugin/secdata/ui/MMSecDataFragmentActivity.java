package com.tencent.mm.plugin.secdata.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/secdata/ui/MMSecDataFragmentActivity;", "Lcom/tencent/mm/ui/MMFragmentActivity;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "ui-sec-data_release"})
public abstract class MMSecDataFragmentActivity extends MMFragmentActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public Set<Class<? extends UIComponent>> importUIComponents() {
        return ak.setOf(SecDataUIC.class);
    }
}

package com.tencent.mm.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.a;

@a(3)
public class AccountExpiredUI extends MMActivity {
    private int errCode;
    private String errMsg;
    private int errType;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(32897);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(32897);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0293  */
    @Override // com.tencent.mm.ui.MMActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 752
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.AccountExpiredUI.initView():void");
    }

    public void onPointerCaptureChanged(boolean z) {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}

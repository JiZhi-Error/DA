package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class MiniQbCallBackBaseUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f1  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r14) {
        /*
        // Method dump skipped, instructions count: 435
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.MiniQbCallBackBaseUI.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public String getTag() {
        return "MicroMsg.FilesFloatBall.MiniQbCallBackBaseUI";
    }

    /* access modifiers changed from: protected */
    public void b(String str, String str2, int i2, String str3, int i3) {
        AppMethodBeat.i(234463);
        Log.i(getTag(), "dealEvent() processName:%s appId:%s readProgress:%d", str, str2, Integer.valueOf(i3));
        AppMethodBeat.o(234463);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}

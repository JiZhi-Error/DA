package com.tencent.mm.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.sdk.platformtools.Log;

public class CheckSmsCanAddCardUI extends MMActivity implements i {
    private String OyL;
    private d rr;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ce  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
        // Method dump skipped, instructions count: 214
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.CheckSmsCanAddCardUI.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.axe;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(32987);
        super.onDestroy();
        bg.azz().b(1038, this);
        AppMethodBeat.o(32987);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(32988);
        Log.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            zo zoVar = (zo) this.rr.iLL.iLR;
            String str2 = zoVar.eaO;
            String str3 = zoVar.eaP;
            Log.i("MicroMsg.CheckSmsCanAddCardUI", "onSceneEnd cardid:%s extMsg:%s", str2, str3);
            Intent intent = new Intent();
            intent.putExtra("key_card_id", str2);
            intent.putExtra("key_card_ext", str3);
            intent.putExtra("key_from_scene", 8);
            intent.putExtra("key_is_sms_add_card", true);
            c.c(this, "card", ".ui.CardDetailUI", intent);
            finish();
            AppMethodBeat.o(32988);
            return;
        }
        gGU();
        AppMethodBeat.o(32988);
    }

    private void gGU() {
        AppMethodBeat.i(32989);
        Toast.makeText(this, getString(R.string.hve), 1).show();
        LauncherUI.jI(this);
        finish();
        AppMethodBeat.o(32989);
    }
}

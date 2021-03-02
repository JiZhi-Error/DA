package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.d;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class EmojiPaidUI extends BaseEmojiStoreUI {
    private h[] rgA;

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(108952);
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12740, 4, "", "", "", 10, 10);
        AppMethodBeat.o(108952);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int bp(byte[] bArr) {
        AppMethodBeat.i(108953);
        int bp = super.bp(bArr);
        AppMethodBeat.o(108953);
        return bp;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGQ() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(108954);
        setMMTitle(R.string.bst);
        if (z.aUn()) {
            addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.emoji.ui.EmojiPaidUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(108950);
                    EmojiPaidUI.a(EmojiPaidUI.this);
                    AppMethodBeat.o(108950);
                    return true;
                }
            });
        }
        super.initView();
        this.GQ.setVisibility(8);
        this.mListView.setVisibility(8);
        AppMethodBeat.o(108954);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void cGL() {
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(108955);
        super.onDestroy();
        if (this.rgA != null && this.rgA.length > 0) {
            for (int i2 = 0; i2 < this.rgA.length; i2++) {
                g.aAg().hqi.a(this.rgA[i2]);
            }
        }
        AppMethodBeat.o(108955);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void a(h hVar) {
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4;
        AppMethodBeat.i(108956);
        Log.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + i2 + "  resultCode:" + i3);
        cGW();
        String str = "";
        if (intent != null) {
            i4 = intent.getIntExtra("key_err_code", 0);
            Log.w("MicroMsg.emoji.EmojiPaidUI", "errCode:".concat(String.valueOf(i4)));
            str = intent.getStringExtra("key_err_msg");
            Log.w("MicroMsg.emoji.EmojiPaidUI", "errMsg:".concat(String.valueOf(str)));
        } else {
            i4 = 0;
        }
        if (i3 != -1) {
            Toast.makeText(this, (int) R.string.btc, 0).show();
            AppMethodBeat.o(108956);
        } else if (intent == null || i4 != 0) {
            Toast.makeText(this, str, 0).show();
            AppMethodBeat.o(108956);
        } else {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                Toast.makeText(this, str, 0).show();
                AppMethodBeat.o(108956);
                return;
            }
            this.reh = null;
            this.ree = -1;
            J(false, false);
            g.aAh().azQ().set(208900, Boolean.TRUE);
            Toast.makeText(this, (int) R.string.btd, 0).show();
            AppMethodBeat.o(108956);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void a(boolean z, com.tencent.mm.plugin.emoji.model.g gVar, boolean z2, boolean z3) {
        AppMethodBeat.i(108957);
        if (!(gVar == null || !z || this.rbD == null)) {
            this.rbD.b(gVar);
        }
        if (this.rbD == null || gVar == null || gVar.rbs <= 0) {
            this.GQ.setVisibility(0);
            this.rec.setText(R.string.bsq);
            this.mListView.setVisibility(8);
            AppMethodBeat.o(108957);
            return;
        }
        this.GQ.setVisibility(8);
        this.mListView.setVisibility(0);
        AppMethodBeat.o(108957);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final boolean cGN() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final a cGJ() {
        AppMethodBeat.i(108958);
        d dVar = new d(getContext());
        AppMethodBeat.o(108958);
        return dVar;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange, com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(108959);
        if (str != null && str.equals("event_update_group")) {
            cHg();
            fC(131074, 50);
        }
        AppMethodBeat.o(108959);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGH() {
        return 10;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGI() {
        return 6;
    }

    static /* synthetic */ void a(EmojiPaidUI emojiPaidUI) {
        AppMethodBeat.i(108960);
        com.tencent.mm.ui.base.h.b(emojiPaidUI.getContext(), null, null, emojiPaidUI.getResources().getString(R.string.btb), new h.d() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiPaidUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(108951);
                switch (i2) {
                    case 0:
                        Intent intent = new Intent();
                        intent.putExtra("key_action_type", 200002);
                        c.b(EmojiPaidUI.this, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                        Log.i("MicroMsg.emoji.EmojiPaidUI", "[showMenuDialog] startActivityForResult ui.WalletIapUI");
                        EmojiPaidUI.this.bnj();
                        break;
                }
                AppMethodBeat.o(108951);
            }
        });
        AppMethodBeat.o(108960);
    }
}

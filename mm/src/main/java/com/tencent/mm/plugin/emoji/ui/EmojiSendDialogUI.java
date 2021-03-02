package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.wxmm.v2helper;

public class EmojiSendDialogUI extends MMBaseActivity implements i {
    private String emojiPath;
    private EmojiInfo gWm;
    private boolean rhd = false;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(108962);
        overridePendingTransition(-1, -1);
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
        }
        g.aAg().hqi.a(v2helper.EMethodSetNgStrength, this);
        this.gWm = (EmojiInfo) getIntent().getParcelableExtra("emoji_info");
        EmojiInfo amm = ((d) g.ah(d.class)).getProvider().amm(this.gWm.field_md5);
        if (amm != null) {
            this.gWm = amm;
            this.rhd = true;
        }
        a aVar = a.hdT;
        this.emojiPath = EmojiLogic.W(a.awt(), this.gWm.field_groupId, this.gWm.getMd5());
        EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk(this.gWm.field_md5);
        if ((blk == null || blk.field_catalog != EmojiInfo.VkW) && !Util.isNullOrNil(this.gWm.field_groupId) && !((d) g.ah(d.class)).getEmojiMgr().amq(this.gWm.field_groupId)) {
            g.aAg().hqi.a(new h(this.gWm.field_groupId, (byte) 0), 0);
            Log.i("MicroMsg.EmojiSendDialogUI", "do exchange %s %s", this.gWm.field_md5, this.gWm.field_groupId);
            z = false;
        } else {
            Log.i("MicroMsg.EmojiSendDialogUI", "no need exchange %s %s", this.gWm.field_md5, this.gWm.field_groupId);
            z = true;
        }
        if (z) {
            cHu();
        }
        AppMethodBeat.o(108962);
    }

    private void cHu() {
        AppMethodBeat.i(108963);
        Log.i("MicroMsg.EmojiSendDialogUI", "select contact");
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        if (this.rhd) {
            intent.putExtra("Retr_Msg_thumb_path", this.gWm.field_md5);
        } else {
            intent.putExtra("image_path", this.emojiPath);
        }
        intent.putExtra("emoji_activity_id", this.gWm.field_activityid);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
        c.c(this, ".ui.transmit.SelectConversationUI", intent, 1001);
        overridePendingTransition(R.anim.dq, R.anim.di);
        AppMethodBeat.o(108963);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(108964);
        if (qVar.getType() == 423) {
            h hVar = (h) qVar;
            Log.i("MicroMsg.EmojiSendDialogUI", "exchange end %s", hVar.rcD);
            if (Util.isNullOrNil(this.gWm.field_groupId)) {
                cHu();
                AppMethodBeat.o(108964);
                return;
            } else if (!this.gWm.field_groupId.equalsIgnoreCase(hVar.rcD)) {
                Log.i("MicroMsg.EmojiSendDialogUI", "no the same product ID");
            } else if (i2 == 0 && i3 == 0) {
                cHu();
                AppMethodBeat.o(108964);
                return;
            } else if (i3 == 4) {
                amW(getString(R.string.btl));
                AppMethodBeat.o(108964);
                return;
            } else {
                amW(getString(R.string.btj));
                AppMethodBeat.o(108964);
                return;
            }
        }
        AppMethodBeat.o(108964);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(108965);
        super.onDestroy();
        g.aAg().hqi.b(v2helper.EMethodSetNgStrength, this);
        AppMethodBeat.o(108965);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r9, int r10, android.content.Intent r11) {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        AppMethodBeat.i(108967);
        overridePendingTransition(-1, -1);
        super.finish();
        AppMethodBeat.o(108967);
    }

    private void amW(String str) {
        AppMethodBeat.i(108968);
        if (!isFinishing()) {
            com.tencent.mm.ui.base.h.c(this, str, "", true).setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI.AnonymousClass1 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(108961);
                    EmojiSendDialogUI.this.setResult(0);
                    EmojiSendDialogUI.this.finish();
                    AppMethodBeat.o(108961);
                }
            });
        }
        AppMethodBeat.o(108968);
    }
}

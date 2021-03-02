package com.tencent.mm.plugin.luckymoney.hk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.luckymoney.a.b;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.plugin.luckymoney.model.ac;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class LuckyMoneyHKBeforeDetailUI extends LuckyMoneyBaseUI {
    private static final String yUb = MMApplicationContext.getContext().getResources().getString(R.string.itf);
    private Dialog tipDialog;
    private String yUc;
    private com.tencent.mm.plugin.luckymoney.hk.a.a yUd;

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ View c(LuckyMoneyHKBeforeDetailUI luckyMoneyHKBeforeDetailUI) {
        AppMethodBeat.i(213277);
        View contentView = luckyMoneyHKBeforeDetailUI.getContentView();
        AppMethodBeat.o(213277);
        return contentView;
    }

    static /* synthetic */ View d(LuckyMoneyHKBeforeDetailUI luckyMoneyHKBeforeDetailUI) {
        AppMethodBeat.i(213278);
        View contentView = luckyMoneyHKBeforeDetailUI.getContentView();
        AppMethodBeat.o(213278);
        return contentView;
    }

    static /* synthetic */ void e(LuckyMoneyHKBeforeDetailUI luckyMoneyHKBeforeDetailUI) {
        AppMethodBeat.i(213279);
        luckyMoneyHKBeforeDetailUI.eeX();
        AppMethodBeat.o(213279);
    }

    static {
        AppMethodBeat.i(213280);
        AppMethodBeat.o(213280);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        q qVar;
        AppMethodBeat.i(213274);
        super.onCreate(bundle);
        overridePendingTransition(0, R.anim.e1);
        ao.q(this, getResources().getColor(R.color.ac_));
        setContentViewVisibility(8);
        this.yUc = getIntent().getStringExtra("key_sendid");
        String stringExtra = getIntent().getStringExtra("key_native_url");
        int intExtra = getIntent().getIntExtra("key_jump_from", 2);
        Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "sendid=" + Util.nullAsNil(this.yUc) + ", nativeurl=" + Util.nullAsNil(stringExtra) + ", jumpFrom=" + intExtra);
        if (intExtra == 2) {
            if (b.aDn(this.yUc) != null) {
                eeX();
                AppMethodBeat.o(213274);
                return;
            }
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (!(byteArrayExtra == null || (qVar = (q) new q().parseFrom(byteArrayExtra)) == null)) {
                    b.a(this.yUc, qVar);
                    eeX();
                    AppMethodBeat.o(213274);
                    return;
                }
            } catch (Exception e2) {
                Log.w("MicroMsg.LuckyMoneyHKBeforeDetailUI", "Parse LuckyMoneyDetail fail!" + e2.getLocalizedMessage());
            }
        }
        if (Util.isNullOrNil(this.yUc) && !Util.isNullOrNil(stringExtra)) {
            try {
                this.yUc = Uri.parse(stringExtra).getQueryParameter("sendid");
            } catch (Exception e3) {
            }
        }
        if (!Util.isNullOrNil(this.yUc)) {
            final String str = this.yUc;
            this.tipDialog = h.a((Context) getContext(), 3, (int) R.style.lj, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKBeforeDetailUI.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(213272);
                    if (LuckyMoneyHKBeforeDetailUI.this.tipDialog != null && LuckyMoneyHKBeforeDetailUI.this.tipDialog.isShowing()) {
                        LuckyMoneyHKBeforeDetailUI.this.tipDialog.dismiss();
                    }
                    if (LuckyMoneyHKBeforeDetailUI.this.yUd != null) {
                        LuckyMoneyHKBeforeDetailUI.this.yUd.cancel();
                    }
                    if (LuckyMoneyHKBeforeDetailUI.c(LuckyMoneyHKBeforeDetailUI.this).getVisibility() == 8 || LuckyMoneyHKBeforeDetailUI.d(LuckyMoneyHKBeforeDetailUI.this).getVisibility() == 4) {
                        Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "user cancel & finish");
                        LuckyMoneyHKBeforeDetailUI.this.finish();
                    }
                    AppMethodBeat.o(213272);
                }
            });
            Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "do query detail");
            this.yUd = new com.tencent.mm.plugin.luckymoney.hk.a.a(stringExtra, str, 0, getIntent().getIntExtra("key_hk_scene", 0));
            this.yUd.aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<bfb>>() {
                /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKBeforeDetailUI.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(c.a<bfb> aVar) {
                    String str;
                    AppMethodBeat.i(213273);
                    c.a<bfb> aVar2 = aVar;
                    if (aVar2 != null) {
                        Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "do query detail: errtype: %s, errcode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                        if (aVar2.errType == 0 && aVar2.errCode == 0) {
                            bfb bfb = (bfb) aVar2.iLC;
                            Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "do query detail: retcode: %s, retmsg: %s", Integer.valueOf(bfb.dDN), bfb.qwn);
                            if (bfb.dDN == 0) {
                                q a2 = ac.a(bfb);
                                LuckyMoneyEmojiSwitch luckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch();
                                luckyMoneyEmojiSwitch.yVJ = bfb.yVJ;
                                luckyMoneyEmojiSwitch.yVI = bfb.LOK;
                                LuckyMoneyHKBeforeDetailUI.this.getIntent().putExtra("key_emoji_switch", luckyMoneyEmojiSwitch);
                                b.a(str, a2);
                                LuckyMoneyHKBeforeDetailUI.e(LuckyMoneyHKBeforeDetailUI.this);
                            } else {
                                String str2 = LuckyMoneyHKBeforeDetailUI.yUb;
                                if (!Util.isNullOrNil(bfb.qwn)) {
                                    str = bfb.qwn;
                                } else {
                                    str = str2;
                                }
                                h.cD(LuckyMoneyHKBeforeDetailUI.this.getContext(), str);
                                LuckyMoneyHKBeforeDetailUI.this.finish();
                            }
                        } else {
                            String str3 = LuckyMoneyHKBeforeDetailUI.yUb;
                            if (!Util.isNullOrNil(aVar2.errMsg)) {
                                str3 = aVar2.errMsg;
                            }
                            h.cD(LuckyMoneyHKBeforeDetailUI.this.getContext(), str3);
                            LuckyMoneyHKBeforeDetailUI.this.finish();
                        }
                    }
                    AppMethodBeat.o(213273);
                    return null;
                }
            }).a(this);
            AppMethodBeat.o(213274);
            return;
        }
        Log.w("MicroMsg.LuckyMoneyHKBeforeDetailUI", "sendid null or nil, finish");
        finish();
        AppMethodBeat.o(213274);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(213275);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(213275);
    }

    private void eeX() {
        AppMethodBeat.i(213276);
        Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "go to detail ui");
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKBeforeDetailUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(213271);
                Intent intent = new Intent(LuckyMoneyHKBeforeDetailUI.this.getContext(), LuckyMoneyDetailUI.class);
                intent.putExtras(LuckyMoneyHKBeforeDetailUI.this.getIntent());
                intent.putExtra("key_hk_flag", 1);
                LuckyMoneyHKBeforeDetailUI luckyMoneyHKBeforeDetailUI = LuckyMoneyHKBeforeDetailUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyHKBeforeDetailUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKBeforeDetailUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                luckyMoneyHKBeforeDetailUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyHKBeforeDetailUI, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKBeforeDetailUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKBeforeDetailUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(213270);
                        LuckyMoneyHKBeforeDetailUI.this.finish();
                        AppMethodBeat.o(213270);
                    }
                }, 500);
                AppMethodBeat.o(213271);
            }
        }.run();
        AppMethodBeat.o(213276);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        return false;
    }
}

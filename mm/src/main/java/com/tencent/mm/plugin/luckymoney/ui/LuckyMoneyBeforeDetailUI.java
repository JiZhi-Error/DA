package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.luckymoney.model.a.d;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.bh;
import com.tencent.mm.plugin.luckymoney.story.a.b;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.a;

@a(7)
public class LuckyMoneyBeforeDetailUI extends LuckyMoneyBaseUI {
    private String UXO;
    private String UXP;
    private int UXQ;
    private int gwE;
    private String mRa;
    private Dialog tipDialog;
    private int yQh;
    private String yUc;
    private int zbZ;
    private b zca;

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ View c(LuckyMoneyBeforeDetailUI luckyMoneyBeforeDetailUI) {
        AppMethodBeat.i(65448);
        View contentView = luckyMoneyBeforeDetailUI.getContentView();
        AppMethodBeat.o(65448);
        return contentView;
    }

    static /* synthetic */ View d(LuckyMoneyBeforeDetailUI luckyMoneyBeforeDetailUI) {
        AppMethodBeat.i(163706);
        View contentView = luckyMoneyBeforeDetailUI.getContentView();
        AppMethodBeat.o(163706);
        return contentView;
    }

    static /* synthetic */ void e(LuckyMoneyBeforeDetailUI luckyMoneyBeforeDetailUI) {
        AppMethodBeat.i(163707);
        luckyMoneyBeforeDetailUI.eeX();
        AppMethodBeat.o(163707);
    }

    static /* synthetic */ View f(LuckyMoneyBeforeDetailUI luckyMoneyBeforeDetailUI) {
        AppMethodBeat.i(163708);
        View contentView = luckyMoneyBeforeDetailUI.getContentView();
        AppMethodBeat.o(163708);
        return contentView;
    }

    static /* synthetic */ View g(LuckyMoneyBeforeDetailUI luckyMoneyBeforeDetailUI) {
        AppMethodBeat.i(163709);
        View contentView = luckyMoneyBeforeDetailUI.getContentView();
        AppMethodBeat.o(163709);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        q dVar;
        com.tencent.mm.plugin.luckymoney.model.q qVar;
        AppMethodBeat.i(65443);
        super.onCreate(bundle);
        overridePendingTransition(0, R.anim.e1);
        ao.q(this, getResources().getColor(R.color.ac_));
        setContentViewVisibility(8);
        this.yUc = getIntent().getStringExtra("key_sendid");
        this.zbZ = getIntent().getIntExtra("scene_id", 0);
        this.mRa = getIntent().getStringExtra("key_username");
        this.yQh = getIntent().getIntExtra("key_hb_kind", 1);
        this.gwE = getIntent().getIntExtra("key_from", 0);
        this.UXO = getIntent().getStringExtra("key_live_id");
        this.UXP = getIntent().getStringExtra("key_live_attach");
        this.UXQ = getIntent().getIntExtra("key_live_anchor_type", 0);
        Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "from scene: %s", Integer.valueOf(this.gwE));
        String stringExtra = getIntent().getStringExtra("key_native_url");
        int intExtra = getIntent().getIntExtra("key_jump_from", 2);
        Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid=" + Util.nullAsNil(this.yUc) + ", nativeurl=" + Util.nullAsNil(stringExtra) + ", jumpFrom=" + intExtra);
        if (intExtra == 2) {
            if (com.tencent.mm.plugin.luckymoney.a.b.aDn(this.yUc) != null) {
                egb();
                AppMethodBeat.o(65443);
                return;
            }
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (!(byteArrayExtra == null || (qVar = (com.tencent.mm.plugin.luckymoney.model.q) new com.tencent.mm.plugin.luckymoney.model.q().parseFrom(byteArrayExtra)) == null)) {
                    com.tencent.mm.plugin.luckymoney.a.b.a(this.yUc, qVar);
                    egb();
                    AppMethodBeat.o(65443);
                    return;
                }
            } catch (Exception e2) {
                Log.w("MicroMsg.LuckyMoneyBeforeDetailUI", "Parse LuckyMoneyDetail fail!" + e2.getLocalizedMessage());
            }
        }
        if (Util.isNullOrNil(this.yUc) && !Util.isNullOrNil(stringExtra)) {
            try {
                this.yUc = Uri.parse(stringExtra).getQueryParameter("sendid");
            } catch (Exception e3) {
            }
        }
        if (!Util.isNullOrNil(this.yUc)) {
            String str = this.yUc;
            Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "get recordList");
            this.tipDialog = h.a((Context) getContext(), 3, (int) R.style.lj, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(163703);
                    if (LuckyMoneyBeforeDetailUI.this.tipDialog != null && LuckyMoneyBeforeDetailUI.this.tipDialog.isShowing()) {
                        LuckyMoneyBeforeDetailUI.this.tipDialog.dismiss();
                    }
                    LuckyMoneyBeforeDetailUI.this.zbX.forceCancel();
                    if (LuckyMoneyBeforeDetailUI.this.zca != null) {
                        LuckyMoneyBeforeDetailUI.this.zca.cancel();
                    }
                    if (LuckyMoneyBeforeDetailUI.f(LuckyMoneyBeforeDetailUI.this).getVisibility() == 8 || LuckyMoneyBeforeDetailUI.g(LuckyMoneyBeforeDetailUI.this).getVisibility() == 4) {
                        Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "user cancel & finish");
                        LuckyMoneyBeforeDetailUI.this.finish();
                    }
                    AppMethodBeat.o(163703);
                }
            });
            if (this.zbZ != 0) {
                if (af.rQ(this.zbZ)) {
                    dVar = new ap(str, 0, stringExtra, "v1.0", "");
                } else if (this.gwE == 3) {
                    dVar = new d(str, 0, stringExtra, "v1.0", "", this.UXO, this.UXP, this.UXQ);
                } else {
                    dVar = new com.tencent.mm.plugin.luckymoney.model.ao(str, 11, 0, stringExtra, "v1.0", "");
                }
            } else if (this.yQh == 5) {
                dVar = new ap(str, 0, stringExtra, "v1.0", "");
            } else if (this.gwE == 3 || this.yQh == 7) {
                dVar = new d(str, 0, stringExtra, "v1.0", "", this.UXO, this.UXP, this.UXQ);
            } else {
                dVar = new com.tencent.mm.plugin.luckymoney.model.ao(str, 11, 0, stringExtra, "v1.0", "");
            }
            doSceneProgress(dVar, false);
            AppMethodBeat.o(65443);
            return;
        }
        Log.w("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid null or nil, finish");
        finish();
        AppMethodBeat.o(65443);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(65444);
        Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "onSceneEnd() errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " netsceneType:" + qVar.getType());
        if (!(qVar instanceof com.tencent.mm.plugin.luckymoney.model.ao)) {
            AppMethodBeat.o(65444);
            return false;
        } else if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.luckymoney.model.ao aoVar = (com.tencent.mm.plugin.luckymoney.model.ao) qVar;
            com.tencent.mm.plugin.luckymoney.a.b.a(this.yUc, aoVar.yWT);
            getIntent().putExtra("key_process_content", aoVar.yXg);
            getIntent().putExtra("key_detail_emoji_md5", aoVar.yXh);
            getIntent().putExtra("key_detail_emoji_type", aoVar.yXi);
            getIntent().putExtra("key_emoji_switch", aoVar.yXj);
            egb();
            AppMethodBeat.o(65444);
            return true;
        } else {
            h.cD(this, str);
            finish();
            AppMethodBeat.o(65444);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(65445);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(65445);
    }

    private void egb() {
        final String str;
        com.tencent.mm.plugin.luckymoney.model.q aDn;
        bh aDy;
        AppMethodBeat.i(163704);
        Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "try fetch story info");
        if (!getIntent().getBooleanExtra("key_has_story", true)) {
            Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "no story, don't fetch data");
            eeX();
            AppMethodBeat.o(163704);
            return;
        }
        String stringExtra = getIntent().getStringExtra("key_packet_id");
        if (!Util.isNullOrNil(stringExtra) || (aDn = com.tencent.mm.plugin.luckymoney.a.b.aDn(this.yUc)) == null || (aDy = bh.aDy(aDn.yVB)) == null || aDy.yUC == null) {
            str = stringExtra;
        } else {
            str = aDy.yUC.Lot;
        }
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "no packet id");
            eeX();
            AppMethodBeat.o(163704);
            return;
        }
        com.tencent.mm.plugin.luckymoney.story.b.a aVar = new com.tencent.mm.plugin.luckymoney.story.b.a();
        aVar.field_packet_id = str;
        boolean z = com.tencent.mm.plugin.luckymoney.b.a.eex().eeu().get(aVar, new String[0]);
        long j2 = aVar.field_update_time;
        Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "has story info: %s, %s", Boolean.valueOf(z), Long.valueOf(j2));
        if (System.currentTimeMillis() - j2 > Util.MILLSECONDS_OF_DAY) {
            Log.w("MicroMsg.LuckyMoneyBeforeDetailUI", "need refetch story");
            z = false;
        }
        if (z) {
            dlt a2 = com.tencent.mm.plugin.luckymoney.story.b.a.a(aVar);
            a2.MPo.addAll(com.tencent.mm.plugin.luckymoney.b.a.eex().eev().aDB(str));
            com.tencent.mm.plugin.luckymoney.a.b.a(str, a2);
            eeX();
            AppMethodBeat.o(163704);
            return;
        }
        if (this.tipDialog == null) {
            this.tipDialog = h.a((Context) getContext(), 3, (int) R.style.lj, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(163699);
                    if (LuckyMoneyBeforeDetailUI.this.tipDialog != null && LuckyMoneyBeforeDetailUI.this.tipDialog.isShowing()) {
                        LuckyMoneyBeforeDetailUI.this.tipDialog.dismiss();
                    }
                    LuckyMoneyBeforeDetailUI.this.zbX.forceCancel();
                    if (LuckyMoneyBeforeDetailUI.this.zca != null) {
                        LuckyMoneyBeforeDetailUI.this.zca.cancel();
                    }
                    if (LuckyMoneyBeforeDetailUI.c(LuckyMoneyBeforeDetailUI.this).getVisibility() == 8 || LuckyMoneyBeforeDetailUI.d(LuckyMoneyBeforeDetailUI.this).getVisibility() == 4) {
                        Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "user cancel & finish");
                        LuckyMoneyBeforeDetailUI.this.finish();
                    }
                    AppMethodBeat.o(163699);
                }
            });
        }
        this.zca = new b();
        this.zca.b(new com.tencent.mm.plugin.luckymoney.story.a.a(str, true));
        this.zca.a(new a.AbstractC2168a<buh>() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
            @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
            public final /* synthetic */ void d(buh buh, int i2, int i3) {
                AppMethodBeat.i(258614);
                buh buh2 = buh;
                if (!(buh2 == null || buh2.MaT == null)) {
                    Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "response.subtype_id：%s", Integer.valueOf(buh2.VjK));
                    buh2.MaT.VjK = buh2.VjK;
                    com.tencent.mm.plugin.luckymoney.a.b.a(str, buh2.MaT);
                }
                LuckyMoneyBeforeDetailUI.e(LuckyMoneyBeforeDetailUI.this);
                AppMethodBeat.o(258614);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
            public final /* bridge */ /* synthetic */ void dx(buh buh) {
            }
        }, 0);
        AppMethodBeat.o(163704);
    }

    private void eeX() {
        AppMethodBeat.i(163705);
        Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "go to detail ui");
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(163702);
                Intent intent = new Intent(LuckyMoneyBeforeDetailUI.this.getContext(), LuckyMoneyDetailUI.class);
                intent.putExtras(LuckyMoneyBeforeDetailUI.this.getIntent());
                LuckyMoneyBeforeDetailUI luckyMoneyBeforeDetailUI = LuckyMoneyBeforeDetailUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyBeforeDetailUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBeforeDetailUI$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                luckyMoneyBeforeDetailUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyBeforeDetailUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBeforeDetailUI$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(163701);
                        LuckyMoneyBeforeDetailUI.this.finish();
                        AppMethodBeat.o(163701);
                    }
                }, 500);
                AppMethodBeat.o(163702);
            }
        }.run();
        AppMethodBeat.o(163705);
    }
}

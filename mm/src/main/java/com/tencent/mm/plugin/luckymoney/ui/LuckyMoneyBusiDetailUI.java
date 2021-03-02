package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.ax;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.luckymoney.ui.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a(3)
public class LuckyMoneyBusiDetailUI extends LuckyMoneyBaseUI {
    private View agA;
    private int fs = 0;
    private TextView jVn;
    private boolean mwr = false;
    private TextView nAB;
    private View rfF;
    private List<ad> yQe = new LinkedList();
    private TextView yQk;
    private ListView yQs;
    private ImageView yQt;
    private TextView yQu;
    private View yQw;
    private View yQx;
    AbsListView.OnScrollListener yQz = new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.AnonymousClass1 */
        private boolean yQA = false;
        private boolean yQB;

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(65449);
            if (absListView.getCount() == 0) {
                AppMethodBeat.o(65449);
                return;
            }
            switch (i2) {
                case 0:
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        if (!LuckyMoneyBusiDetailUI.this.zbX.isProcessing()) {
                            LuckyMoneyBusiDetailUI.this.mwr = false;
                        }
                        if (LuckyMoneyBusiDetailUI.this.zci && !LuckyMoneyBusiDetailUI.this.mwr) {
                            LuckyMoneyBusiDetailUI.d(LuckyMoneyBusiDetailUI.this);
                        }
                    }
                    this.yQA = false;
                    AppMethodBeat.o(65449);
                    return;
                case 1:
                    this.yQA = true;
                    break;
            }
            AppMethodBeat.o(65449);
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            int i5;
            boolean z = true;
            AppMethodBeat.i(65450);
            if (i4 == 0 || !this.yQA) {
                AppMethodBeat.o(65450);
                return;
            }
            if (i2 <= 0) {
                View childAt = absListView.getChildAt(i2);
                if (childAt != null) {
                    i5 = 0 - childAt.getTop();
                } else {
                    i5 = 0;
                }
                if (i5 <= 100) {
                    z = false;
                }
            }
            if (this.yQB != z) {
                if (z) {
                    LuckyMoneyBusiDetailUI.this.getResources().getDrawable(R.drawable.cbq);
                }
                this.yQB = z;
            }
            AppMethodBeat.o(65450);
        }
    };
    private String yUc;
    private String yUq;
    private TextView yln;
    private LuckyMoneyWishFooter zce;
    private ImageView zcf;
    private View zcg;
    private ImageView zch;
    private boolean zci = true;
    private int zcj;
    private String zck;
    private String zcl;
    private int zcm = 0;
    private Map<String, Integer> zcn = new HashMap();
    private j zco;
    private String zcp = "";
    private boolean zcq = false;

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyBusiDetailUI() {
        AppMethodBeat.i(65464);
        AppMethodBeat.o(65464);
    }

    static /* synthetic */ int PQ(int i2) {
        AppMethodBeat.i(65482);
        int PP = PP(i2);
        AppMethodBeat.o(65482);
        return PP;
    }

    static /* synthetic */ void d(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI) {
        AppMethodBeat.i(65480);
        luckyMoneyBusiDetailUI.egc();
        AppMethodBeat.o(65480);
    }

    static /* synthetic */ void e(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI) {
        AppMethodBeat.i(65481);
        luckyMoneyBusiDetailUI.ege();
        AppMethodBeat.o(65481);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x01da  */
    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
        // Method dump skipped, instructions count: 592
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.onCreate(android.os.Bundle):void");
    }

    public static void fixBackgroundRepeat(View view) {
        AppMethodBeat.i(65466);
        if (view == null) {
            AppMethodBeat.o(65466);
            return;
        }
        Drawable background = view.getBackground();
        if (background == null) {
            AppMethodBeat.o(65466);
        } else if (!(background instanceof BitmapDrawable)) {
            AppMethodBeat.o(65466);
        } else {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
            bitmapDrawable.mutate();
            bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            AppMethodBeat.o(65466);
        }
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(65467);
        if (keyEvent.getKeyCode() == 4 && this.zce.getVisibility() == 0) {
            this.zce.setVisibility(8);
            AppMethodBeat.o(65467);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(65467);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4 = 0;
        AppMethodBeat.i(65468);
        if (qVar instanceof ao) {
            if (i2 == 0 && i3 == 0) {
                ao aoVar = (ao) qVar;
                com.tencent.mm.plugin.luckymoney.model.q qVar2 = aoVar.yWT;
                this.zcp = aoVar.yXg;
                a(qVar2);
                AppMethodBeat.o(65468);
                return true;
            }
            h.cD(this, str);
            AppMethodBeat.o(65468);
            return true;
        } else if (qVar instanceof ax) {
            if (i2 == 0 && i3 == 0) {
                h.cD(this, getString(R.string.dzo));
                this.zco.yQg = false;
                ege();
                ax axVar = (ax) qVar;
                if (this.yQe != null) {
                    while (true) {
                        if (i4 >= this.yQe.size()) {
                            break;
                        }
                        ad adVar = this.yQe.get(i4);
                        if (adVar.yVk.equalsIgnoreCase(axVar.yVk)) {
                            adVar.yWF = axVar.yPK;
                            this.zco.notifyDataSetChanged();
                            break;
                        }
                        i4++;
                    }
                }
                AppMethodBeat.o(65468);
                return true;
            }
            h.cD(this, str);
            AppMethodBeat.o(65468);
            return true;
        } else if (!(qVar instanceof bf)) {
            AppMethodBeat.o(65468);
            return false;
        } else if (i2 == 0 && i3 == 0) {
            h.cD(this, getString(R.string.dzo));
            AppMethodBeat.o(65468);
            return true;
        } else {
            h.cD(this, str);
            AppMethodBeat.o(65468);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(65469);
        switch (i2) {
            case 1:
                if (i3 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!Util.isNullOrNil(stringExtra)) {
                        if (this.zcl != null && this.zcl.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")) {
                            Log.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
                            break;
                        } else {
                            doSceneProgress(new bf(stringExtra.replaceAll(",", "|"), this.yUc, "v1.0"));
                            break;
                        }
                    }
                }
                break;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(65469);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(65470);
        if (getIntent().hasExtra("key_realname_guide_helper")) {
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiDetailUI");
            boolean b2 = ((RealnameGuideHelper) getIntent().getParcelableExtra("key_realname_guide_helper")).b(this, bundle, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(65451);
                    Log.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
                    AppMethodBeat.o(65451);
                }
            });
            getIntent().removeExtra("key_realname_guide_helper");
            if (!b2) {
                super.finish();
            }
            AppMethodBeat.o(65470);
            return;
        }
        super.finish();
        AppMethodBeat.o(65470);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b3i;
    }

    private void egc() {
        AppMethodBeat.i(65471);
        this.mwr = true;
        if (this.fs <= 0 || this.yQe.size() <= 0 || this.yQe.get(this.yQe.size() - 1) == null) {
            this.zcp = "";
            doSceneProgress(new ao(this.yUc, 11, this.fs, this.yUq, "v1.0", this.zcp));
            AppMethodBeat.o(65471);
            return;
        }
        doSceneProgress(new ao(this.yUc, this.fs, this.yUq, Util.getLong(this.yQe.get(this.yQe.size() - 1).yWp, 0), "v1.0", this.zcp));
        AppMethodBeat.o(65471);
    }

    private void a(com.tencent.mm.plugin.luckymoney.model.q qVar) {
        AppMethodBeat.i(65472);
        if (qVar == null) {
            AppMethodBeat.o(65472);
            return;
        }
        this.zci = qVar.yVn == 1;
        if (this.fs == 0) {
            this.zck = qVar.yVk;
            this.zco.yQf = this.zck;
            this.zco.yQh = qVar.yVv;
            b(qVar);
            d(qVar);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, Integer.valueOf(PP(qVar.yVv)), 0, 0, 0, 1);
        }
        c(qVar);
        LinkedList<ad> linkedList = qVar.yVw;
        if (linkedList != null) {
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                ad adVar = linkedList.get(i2);
                if (!this.zcn.containsKey(adVar.yVk)) {
                    this.yQe.add(linkedList.get(i2));
                    this.zcn.put(adVar.yVk, 1);
                }
            }
            this.fs += linkedList.size();
            this.mwr = false;
            this.zco.fq(this.yQe);
        }
        iD(qVar.yVu, qVar.yVx);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13051, Integer.valueOf(this.zcm), 1, qVar.yVu, af.fr(qVar.yVr), "", "", "", "", qVar.yVd, Integer.valueOf(qVar.resourceId));
        AppMethodBeat.o(65472);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00da, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r11.yVe) == false) goto L_0x00dc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(final com.tencent.mm.plugin.luckymoney.model.q r11) {
        /*
        // Method dump skipped, instructions count: 299
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.b(com.tencent.mm.plugin.luckymoney.model.q):void");
    }

    private void iD(String str, String str2) {
        AppMethodBeat.i(65474);
        this.zch.setImageResource(R.drawable.cc1);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
            this.zch.setVisibility(8);
            AppMethodBeat.o(65474);
            return;
        }
        egd();
        af.b(this.zch, str, str2, false);
        this.zch.setVisibility(0);
        AppMethodBeat.o(65474);
    }

    private void egd() {
        AppMethodBeat.i(65475);
        new DisplayMetrics();
        DisplayMetrics displayMetrics = MMApplicationContext.getContext().getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            AppMethodBeat.o(65475);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.zch.getLayoutParams();
        layoutParams.height = (int) (((float) ((displayMetrics.widthPixels - (getResources().getDimensionPixelSize(R.dimen.aaq) * 2)) - (getResources().getDimensionPixelSize(R.dimen.aap) * 2))) * 0.75f);
        this.zch.setLayoutParams(layoutParams);
        AppMethodBeat.o(65475);
    }

    private void c(final com.tencent.mm.plugin.luckymoney.model.q qVar) {
        boolean z;
        AppMethodBeat.i(65476);
        if (qVar == null) {
            AppMethodBeat.o(65476);
            return;
        }
        boolean z2 = (qVar.egZ == 3 || qVar.egZ == 2) && qVar.yVm == 1 && !this.zci && qVar.yVp == 1;
        if (qVar.yVq == null || qVar.yVq.gGn != 1 || Util.isNullOrNil(qVar.yVq.yUG)) {
            z = false;
        } else {
            z = true;
        }
        TextView textView = (TextView) this.rfF.findViewById(R.id.ag8);
        if (z2 || z) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(65454);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, Integer.valueOf(LuckyMoneyBusiDetailUI.PQ(qVar.yVv)), 0, 0, 0, 3);
                    af.a((MMActivity) LuckyMoneyBusiDetailUI.this, 1, false);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(65454);
                }
            });
            if (z) {
                this.zcl = qVar.yVq.yUG;
                textView.setText(qVar.yVq.yUH);
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, Integer.valueOf(PP(qVar.yVv)), 0, 0, 0, 2);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) this.rfF.findViewById(R.id.ag5);
        if (this.zcj == 1 || this.zcj == 3 || textView.getVisibility() == 0) {
            textView2.setVisibility(8);
        } else {
            textView2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(65455);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, Integer.valueOf(LuckyMoneyBusiDetailUI.PQ(qVar.yVv)), 0, 0, 0, 4);
                    Intent intent = new Intent();
                    intent.setClass(LuckyMoneyBusiDetailUI.this.getContext(), LuckyMoneyMyRecordUI.class);
                    intent.putExtra("key_type", 2);
                    LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI = LuckyMoneyBusiDetailUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyBusiDetailUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    luckyMoneyBusiDetailUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyBusiDetailUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(65455);
                }
            });
            textView2.setVisibility(0);
        }
        if (!this.zcq) {
            this.yQs.addFooterView(this.rfF);
            this.zcq = true;
        }
        AppMethodBeat.o(65476);
    }

    private void d(com.tencent.mm.plugin.luckymoney.model.q qVar) {
        AppMethodBeat.i(65477);
        if (qVar != null) {
            LinkedList<bg> linkedList = qVar.yVr;
            if (linkedList != null && linkedList.size() > 0) {
                View findViewById = this.agA.findViewById(R.id.ag1);
                View findViewById2 = this.agA.findViewById(R.id.ag2);
                View findViewById3 = this.agA.findViewById(R.id.ag3);
                ViewGroup viewGroup = (ViewGroup) this.agA.findViewById(R.id.afy);
                ViewGroup viewGroup2 = (ViewGroup) this.agA.findViewById(R.id.afz);
                ViewGroup viewGroup3 = (ViewGroup) this.agA.findViewById(R.id.ag0);
                View findViewById4 = this.agA.findViewById(R.id.aft);
                View findViewById5 = this.agA.findViewById(R.id.afu);
                i.c cVar = new i.c();
                cVar.textColor = getResources().getColor(R.color.yj);
                cVar.zgx = true;
                cVar.resourceId = qVar.resourceId;
                cVar.zgy = this.zcm;
                if (linkedList.size() > 0) {
                    i.a(this, viewGroup, linkedList.get(0), cVar);
                    findViewById.setVisibility(0);
                }
                if (linkedList.size() > 1) {
                    i.a(this, viewGroup2, linkedList.get(1), cVar);
                    findViewById2.setVisibility(0);
                }
                if (linkedList.size() > 2) {
                    i.a(this, viewGroup3, linkedList.get(2), cVar);
                    findViewById3.setVisibility(0);
                }
                if (findViewById.getVisibility() == 0 && (findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0)) {
                    findViewById4.setVisibility(0);
                }
                if (findViewById2.getVisibility() == 0 && findViewById3.getVisibility() == 0) {
                    findViewById5.setVisibility(0);
                }
                if (findViewById.getVisibility() == 0 || findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0) {
                    this.zcg.requestLayout();
                    this.zcg.setVisibility(0);
                }
            }
            i.c cVar2 = new i.c();
            cVar2.textColor = getResources().getColor(R.color.yj);
            cVar2.textSize = getResources().getDimensionPixelSize(R.dimen.ka);
            i.a(this, (ViewGroup) this.rfF.findViewById(R.id.afv), qVar.yVs, cVar2);
        }
        AppMethodBeat.o(65477);
    }

    private void ege() {
        AppMethodBeat.i(65478);
        if (!(this.zce == null || this.zce.getVisibility() == 8)) {
            this.zce.setVisibility(8);
        }
        AppMethodBeat.o(65478);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(65479);
        super.onDestroy();
        if (this.zce != null) {
            LuckyMoneyWishFooter luckyMoneyWishFooter = this.zce;
            if (luckyMoneyWishFooter.rum != null) {
                Log.i("MicroMsg.SnsCommentFooter", "commentfooter release");
                luckyMoneyWishFooter.rum.goC();
                luckyMoneyWishFooter.rum.destroy();
            }
        }
        AppMethodBeat.o(65479);
    }

    private static int PP(int i2) {
        if (i2 == 2) {
            return 13;
        }
        return 7;
    }
}

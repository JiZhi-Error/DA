package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.n;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import java.io.IOException;
import java.util.List;

@a(3)
public class FTSAddFriendUI extends FTSBaseUI {
    private final i callback = new i() {
        /* class com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.AnonymousClass5 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            String str2;
            AppMethodBeat.i(111822);
            g.azz().b(106, this);
            FTSAddFriendUI.d(FTSAddFriendUI.this);
            if (i2 == 0 && i3 == 0) {
                FTSAddFriendUI.this.sMC = ((f) qVar).eiq();
                FTSAddFriendUI fTSAddFriendUI = FTSAddFriendUI.this;
                drs drs = (drs) ((f) qVar).rr.iLK.iLR;
                if (drs != null) {
                    str2 = z.a(drs.Lqk);
                } else {
                    str2 = "";
                }
                fTSAddFriendUI.xay = str2;
                if (FTSAddFriendUI.this.sMC.LUB > 0) {
                    if (FTSAddFriendUI.this.sMC.LUC.isEmpty()) {
                        h.a((Context) FTSAddFriendUI.this, (int) R.string.gfw, 0, true, (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(111822);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("add_more_friend_search_scene", 3);
                    if (FTSAddFriendUI.this.sMC.LUC.size() > 1) {
                        try {
                            intent.putExtra("result", FTSAddFriendUI.this.sMC.toByteArray());
                            c.b(FTSAddFriendUI.this.getContext(), "subapp", ".ui.pluginapp.ContactSearchResultUI", intent);
                            AppMethodBeat.o(111822);
                            return;
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.FTS.FTSAddFriendUI", e2, "", new Object[0]);
                            AppMethodBeat.o(111822);
                            return;
                        }
                    } else {
                        ((n) g.af(n.class)).a(intent, FTSAddFriendUI.this.sMC.LUC.getFirst(), FTSAddFriendUI.this.xaz);
                    }
                }
                FTSAddFriendUI.this.xaw = 1;
                FTSAddFriendUI.g(FTSAddFriendUI.this);
            } else {
                switch (i3) {
                    case -24:
                        com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                        if (Dk == null) {
                            FTSAddFriendUI.this.xap.setText(R.string.fdp);
                            break;
                        } else {
                            FTSAddFriendUI.this.xap.setText(Dk.desc);
                            break;
                        }
                    case -4:
                        if (i2 != 4) {
                            FTSAddFriendUI.this.xap.setText(FTSAddFriendUI.this.getString(R.string.gfr));
                            break;
                        }
                    default:
                        FTSAddFriendUI.this.xap.setText(R.string.fdp);
                        break;
                }
                FTSAddFriendUI.this.xaw = -1;
                FTSAddFriendUI.this.xax = 1;
            }
            FTSAddFriendUI.h(FTSAddFriendUI.this);
            AppMethodBeat.o(111822);
        }
    };
    private long lastClickTime;
    private long mZq;
    private Dialog rAV;
    private drt sMC;
    private View xae;
    private View xaf;
    private View xag;
    private View xah;
    private View xai;
    private View xaj;
    private View xak;
    private ImageView xal;
    private TextView xam;
    private TextView xan;
    private TextView xao;
    private TextView xap;
    private TextView xaq;
    private boolean xar;
    protected boolean xas;
    private int xat = 1;
    private FTSLocalPageRelevantView xau;
    private c xav;
    private int xaw;
    private int xax;
    private String xay;
    int xaz = -1;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FTSAddFriendUI() {
        AppMethodBeat.i(111826);
        AppMethodBeat.o(111826);
    }

    static /* synthetic */ void c(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.i(111842);
        fTSAddFriendUI.dPd();
        AppMethodBeat.o(111842);
    }

    static /* synthetic */ void d(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.i(111843);
        fTSAddFriendUI.dPe();
        AppMethodBeat.o(111843);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111827);
        super.onCreate(bundle);
        e.wVm = d.Ni(16);
        if (Build.VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.c_), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        setHint(getContext().getResources().getString(R.string.bi5));
        this.xae = findViewById(R.id.a32);
        this.xaf = findViewById(R.id.ba2);
        this.xag = findViewById(R.id.dn8);
        this.xak = findViewById(R.id.ba3);
        this.xah = findViewById(R.id.fzp);
        this.xai = findViewById(R.id.fds);
        this.xaj = findViewById(R.id.hdq);
        this.xau = (FTSLocalPageRelevantView) findViewById(R.id.gzx);
        this.xal = (ImageView) findViewById(R.id.b_z);
        this.xam = (TextView) findViewById(R.id.bdj);
        this.xan = (TextView) findViewById(R.id.ba7);
        this.xao = (TextView) findViewById(R.id.hf6);
        this.xap = (TextView) findViewById(R.id.ba8);
        this.xaq = (TextView) findViewById(R.id.hds);
        try {
            String optString = ak.aXe("webSearchBar").optString("wording");
            Log.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", optString);
            this.xaq.setText(optString);
        } catch (Exception e2) {
        }
        getContentView().postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(111818);
                FTSAddFriendUI.this.xaN.getFtsEditText().awD();
                FTSAddFriendUI.this.xaN.getFtsEditText().awC();
                AppMethodBeat.o(111818);
            }
        }, 128);
        this.xae.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(111819);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSAddFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FTSAddFriendUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSAddFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111819);
            }
        });
        AppMethodBeat.o(111827);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(111828);
        super.onResume();
        ai.fXY();
        AppMethodBeat.o(111828);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(111829);
        finish();
        AppMethodBeat.o(111829);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final d a(e eVar) {
        AppMethodBeat.i(111830);
        if (this.xav == null) {
            this.xav = new c(eVar);
        }
        c cVar = this.xav;
        AppMethodBeat.o(111830);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.e, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void a(com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        AppMethodBeat.i(111831);
        if (aVar instanceof com.tencent.mm.plugin.fts.ui.a.a) {
            if (System.currentTimeMillis() - this.lastClickTime <= 1000) {
                AppMethodBeat.o(111831);
                return;
            } else {
                this.lastClickTime = System.currentTimeMillis();
                ayL(aVar.wWd.wWB);
            }
        }
        AppMethodBeat.o(111831);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void a(String str, String str2, List<a.c> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(168765);
        super.a(str, str2, list, bVar);
        this.xar = false;
        AppMethodBeat.o(168765);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.amx;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPc() {
        AppMethodBeat.i(111834);
        super.dPc();
        this.xaf.setVisibility(8);
        AppMethodBeat.o(111834);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void stopSearch() {
        AppMethodBeat.i(111835);
        super.stopSearch();
        this.xaf.setVisibility(8);
        AppMethodBeat.o(111835);
    }

    private void dPd() {
        AppMethodBeat.i(111836);
        if (Util.nullAsNil(z.a(this.sMC.Lqk)).length() > 0) {
            if (2 == this.sMC.MUk) {
                this.xaz = 15;
            } else if (1 == this.sMC.MUk) {
                this.xaz = 1;
            }
            Intent intent = new Intent();
            ((n) g.af(n.class)).a(intent, this.sMC, this.xaz);
            if (this.xaz == 15 && 2 == this.sMC.MUk) {
                intent.putExtra("Contact_Search_Mobile", this.xay);
            }
            intent.putExtra("add_more_friend_search_scene", 2);
            c.b(this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(111836);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onDestroy() {
        AppMethodBeat.i(111837);
        super.onDestroy();
        g.azz().b(106, this.callback);
        if (this.xar && !this.xas) {
            ar.q(this.query, this.xat, 3, 16);
        }
        AppMethodBeat.o(111837);
    }

    private void ayL(String str) {
        AppMethodBeat.i(111838);
        this.xar = true;
        this.xas = false;
        this.xat = 1;
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            AppMethodBeat.o(111838);
            return;
        }
        this.xaz = Character.isDigit(str.charAt(0)) ? 15 : 3;
        this.xaw = 0;
        this.xax = 0;
        g.azz().a(106, this.callback);
        final f fVar = new f(str, 3);
        g.azz().a(fVar, 0);
        getString(R.string.zb);
        this.rAV = h.a((Context) this, getString(R.string.gfq), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.AnonymousClass6 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(111823);
                g.azz().a(fVar);
                g.azz().b(106, FTSAddFriendUI.this.callback);
                FTSAddFriendUI.this.rAV = null;
                AppMethodBeat.o(111823);
            }
        });
        AppMethodBeat.o(111838);
    }

    private void dPe() {
        AppMethodBeat.i(111839);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(111825);
                if (FTSAddFriendUI.this.rAV != null) {
                    FTSAddFriendUI.this.rAV.dismiss();
                    FTSAddFriendUI.this.rAV = null;
                }
                AppMethodBeat.o(111825);
            }
        });
        AppMethodBeat.o(111839);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onClickClearTextBtn(View view) {
        AppMethodBeat.i(111840);
        super.onClickClearTextBtn(view);
        if (!this.xaN.getFtsEditText().vy.hasFocus()) {
            this.xaN.getFtsEditText().awD();
            showVKB();
        }
        AppMethodBeat.o(111840);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final boolean awE() {
        AppMethodBeat.i(111833);
        ayL(this.query);
        hideVKB();
        AppMethodBeat.o(111833);
        return true;
    }

    static /* synthetic */ void a(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.i(111841);
        String str = fTSAddFriendUI.query;
        if (str == null || Util.isNullOrNil(str.trim())) {
            AppMethodBeat.o(111841);
            return;
        }
        if (System.currentTimeMillis() - fTSAddFriendUI.mZq > 1000) {
            fTSAddFriendUI.mZq = System.currentTimeMillis();
            if (!ai.afs(0)) {
                Log.e("MicroMsg.FTS.FTSAddFriendUI", "fts h5 template not avail");
                AppMethodBeat.o(111841);
                return;
            }
            if (!Util.isNullOrNil(fTSAddFriendUI.query)) {
                fTSAddFriendUI.xas = true;
                ar.q(fTSAddFriendUI.query, 2, 2, 16);
            }
            ((com.tencent.mm.plugin.websearch.api.h) g.af(com.tencent.mm.plugin.websearch.api.h.class)).M(fTSAddFriendUI.getContext(), str, ai.afq(16));
            ar.afA(16);
        }
        AppMethodBeat.o(111841);
    }

    static /* synthetic */ void g(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.i(111844);
        final ap apVar = new ap();
        apVar.dDt.context = fTSAddFriendUI;
        apVar.dDt.fromScene = 16;
        apVar.dDt.dDv = fTSAddFriendUI.query;
        apVar.dDt.dDx = false;
        apVar.dDt.title = fTSAddFriendUI.getString(R.string.gfx);
        apVar.dDt.dDw = 1;
        AnonymousClass7 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(111824);
                FTSAddFriendUI.d(FTSAddFriendUI.this);
                if (!apVar.dDu.dDz) {
                    FTSAddFriendUI.this.xax = -1;
                } else {
                    FTSAddFriendUI.this.xax = 1;
                }
                FTSAddFriendUI.h(FTSAddFriendUI.this);
                AppMethodBeat.o(111824);
            }
        };
        apVar.dDt.dDy = r1;
        apVar.dDt.action = 1;
        if (!EventCenter.instance.publish(apVar)) {
            apVar.dDu.dDz = false;
            r1.run();
        }
        AppMethodBeat.o(111844);
    }

    static /* synthetic */ void h(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.i(111845);
        if (fTSAddFriendUI.xaw == 0 || fTSAddFriendUI.xax == 0) {
            AppMethodBeat.o(111845);
            return;
        }
        fTSAddFriendUI.dPe();
        if (fTSAddFriendUI.xaw <= 0 || fTSAddFriendUI.xax >= 0) {
            if (fTSAddFriendUI.xaw > 0) {
                drt drt = fTSAddFriendUI.sMC;
                String a2 = z.a(drt.Lqk);
                String a3 = z.a(drt.Mjj);
                String str = drt.keb;
                fTSAddFriendUI.xaK.setVisibility(8);
                fTSAddFriendUI.xaf.setVisibility(0);
                fTSAddFriendUI.xag.setVisibility(0);
                fTSAddFriendUI.xak.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(111821);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSAddFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (!Util.isNullOrNil(FTSAddFriendUI.this.query)) {
                            FTSAddFriendUI.this.xas = true;
                            ar.q(FTSAddFriendUI.this.query, FTSAddFriendUI.this.xat, 1, 16);
                        }
                        FTSAddFriendUI.c(FTSAddFriendUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSAddFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(111821);
                    }
                });
                fTSAddFriendUI.xam.setText(a3);
                fTSAddFriendUI.xan.setText(str);
                a.b.c(fTSAddFriendUI.xal, a2);
                fTSAddFriendUI.xah.setVisibility(8);
                fTSAddFriendUI.xai.setVisibility(8);
                fTSAddFriendUI.xaj.setVisibility(8);
                fTSAddFriendUI.xau.setVisibility(8);
            } else {
                fTSAddFriendUI.xaK.setVisibility(8);
                fTSAddFriendUI.xaf.setVisibility(0);
                fTSAddFriendUI.xag.setVisibility(8);
                fTSAddFriendUI.xah.setVisibility(0);
                fTSAddFriendUI.xai.setVisibility(8);
                fTSAddFriendUI.xaj.setVisibility(8);
                fTSAddFriendUI.xau.setVisibility(8);
            }
            if (fTSAddFriendUI.xax > 0) {
                fTSAddFriendUI.xai.setVisibility(0);
                fTSAddFriendUI.xaj.setVisibility(0);
                fTSAddFriendUI.xao.setText(com.tencent.mm.plugin.fts.a.f.a(fTSAddFriendUI.getString(R.string.dkc), "", com.tencent.mm.plugin.fts.a.a.e.c(fTSAddFriendUI.query, fTSAddFriendUI.query)).wWu);
                fTSAddFriendUI.xat = 2;
                fTSAddFriendUI.xaj.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(111820);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSAddFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        FTSAddFriendUI.a(FTSAddFriendUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSAddFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(111820);
                    }
                });
                AppMethodBeat.o(111845);
                return;
            }
            fTSAddFriendUI.xai.setVisibility(8);
            fTSAddFriendUI.xaj.setVisibility(8);
            fTSAddFriendUI.xau.setVisibility(8);
            AppMethodBeat.o(111845);
            return;
        }
        fTSAddFriendUI.xas = true;
        fTSAddFriendUI.dPd();
        AppMethodBeat.o(111845);
    }
}

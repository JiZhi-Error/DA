package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.gr;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.n;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import com.tencent.xweb.util.d;
import java.util.List;

@a(3)
public class FTSAddWw extends FTSBaseUI {
    private i callback;
    private long lastClickTime;
    private String mSessionId = "";
    private String qLO = "";
    private Dialog rAV;
    private dsk xaD;
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
    int xaz = -1;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(FTSAddWw fTSAddWw) {
        AppMethodBeat.i(111869);
        fTSAddWw.dPd();
        AppMethodBeat.o(111869);
    }

    static /* synthetic */ void d(FTSAddWw fTSAddWw) {
        AppMethodBeat.i(111870);
        fTSAddWw.dPe();
        AppMethodBeat.o(111870);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111853);
        super.onCreate(bundle);
        this.mSessionId = d.getMessageDigest(new StringBuilder().append(System.currentTimeMillis()).toString().getBytes());
        e.wVm = com.tencent.mm.plugin.fts.a.d.Ni(16);
        if (Build.VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.c_), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        hideActionbarLine();
        setHint(getContext().getResources().getString(R.string.bib));
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
            /* class com.tencent.mm.plugin.fts.ui.FTSAddWw.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(111846);
                FTSAddWw.this.xaN.getFtsEditText().awD();
                FTSAddWw.this.xaN.getFtsEditText().awC();
                AppMethodBeat.o(111846);
            }
        }, 128);
        this.xae.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fts.ui.FTSAddWw.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(111847);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSAddWw$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FTSAddWw.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSAddWw$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111847);
            }
        });
        AppMethodBeat.o(111853);
    }

    @Override // com.tencent.mm.ui.search.a.b, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onClickBackBtn(View view) {
        AppMethodBeat.i(111854);
        super.onClickBackBtn(view);
        gr grVar = new gr();
        grVar.ut(this.mSessionId);
        grVar.eCt = 2;
        grVar.bfK();
        AppMethodBeat.o(111854);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPf() {
        AppMethodBeat.i(111855);
        super.dPf();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fts.ui.FTSAddWw.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(111848);
                gr grVar = new gr();
                grVar.ut(FTSAddWw.this.mSessionId);
                grVar.eCt = 2;
                grVar.bfK();
                FTSAddWw.this.finish();
                AppMethodBeat.o(111848);
                return true;
            }
        });
        AppMethodBeat.o(111855);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(111856);
        super.onResume();
        ai.fXY();
        AppMethodBeat.o(111856);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(111857);
        gr grVar = new gr();
        grVar.ut(this.mSessionId);
        grVar.eCt = 2;
        grVar.bfK();
        finish();
        AppMethodBeat.o(111857);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final d a(e eVar) {
        AppMethodBeat.i(111858);
        if (this.xav == null) {
            this.xav = new c(eVar);
        }
        c cVar = this.xav;
        AppMethodBeat.o(111858);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.e, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void a(com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        AppMethodBeat.i(111859);
        if (aVar instanceof com.tencent.mm.plugin.fts.ui.a.a) {
            if (System.currentTimeMillis() - this.lastClickTime <= 1000) {
                AppMethodBeat.o(111859);
                return;
            }
            this.lastClickTime = System.currentTimeMillis();
            this.qLO = aVar.wWd.wWB;
            ayL(aVar.wWd.wWB);
            gr grVar = new gr();
            grVar.ut(this.mSessionId);
            grVar.eCt = 1;
            grVar.bfK();
        }
        AppMethodBeat.o(111859);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void a(String str, String str2, List<a.c> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(168766);
        super.a(str, str2, list, bVar);
        this.xar = false;
        AppMethodBeat.o(168766);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.amx;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPc() {
        AppMethodBeat.i(111862);
        super.dPc();
        this.xaf.setVisibility(8);
        AppMethodBeat.o(111862);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void stopSearch() {
        AppMethodBeat.i(111863);
        super.stopSearch();
        gr grVar = new gr();
        grVar.ut(this.mSessionId);
        grVar.eCt = 3;
        grVar.bfK();
        this.xaf.setVisibility(8);
        AppMethodBeat.o(111863);
    }

    private void dPd() {
        AppMethodBeat.i(111864);
        String str = this.xaD.UserName;
        if (Util.nullAsNil(str).length() > 0) {
            if (2 == this.xaD.MUk) {
                this.xaz = 15;
            } else if (1 == this.xaD.MUk) {
                this.xaz = 1;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra(e.d.OyT, this.xaD.LRO);
            if (this.xaz == 15 && 2 == this.xaD.MUk) {
                intent.putExtra("Contact_Search_Mobile", this.qLO.trim());
            }
            intent.putExtra("key_add_contact_openim_appid", this.xaD.jfi);
            intent.putExtra("Contact_Nick", this.xaD.oUJ);
            intent.putExtra("Contact_PyInitial", this.xaD.LoE);
            intent.putExtra("Contact_QuanPin", this.xaD.LoF);
            intent.putExtra("Contact_Sex", this.xaD.kdY);
            intent.putExtra("key_add_contact_custom_detail_visible", this.xaD.MUN.MBw);
            intent.putExtra("key_add_contact_custom_detail", this.xaD.MUN.xKd);
            intent.putExtra("Contact_Scene", this.xaz);
            intent.putExtra("key_ww_add_session_id", this.mSessionId);
            intent.putExtra("add_more_friend_search_scene", 2);
            c.b(this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(111864);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onDestroy() {
        AppMethodBeat.i(111865);
        super.onDestroy();
        if (this.xar && !this.xas) {
            ar.q(this.query, this.xat, 3, 16);
        }
        if (this.callback != null) {
            g.azz().b(com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX, this.callback);
        }
        AppMethodBeat.o(111865);
    }

    private void ayL(String str) {
        AppMethodBeat.i(111866);
        this.xar = true;
        this.xas = false;
        this.xat = 1;
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            AppMethodBeat.o(111866);
            return;
        }
        this.xaz = Character.isDigit(str.charAt(0)) ? 15 : 3;
        this.callback = new i() {
            /* class com.tencent.mm.plugin.fts.ui.FTSAddWw.AnonymousClass5 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(111850);
                g.azz().b(com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX, this);
                FTSAddWw.d(FTSAddWw.this);
                if (i2 == 0 && i3 == 0) {
                    FTSAddWw.this.xaD = ((n) qVar).jHg;
                    FTSAddWw.this.xaw = 1;
                    gr grVar = new gr();
                    grVar.ut(FTSAddWw.this.mSessionId);
                    grVar.eCt = 0;
                    grVar.eKL = 1;
                    grVar.bfK();
                } else {
                    switch (i3) {
                        case -24:
                            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                            if (Dk == null) {
                                FTSAddWw.this.xap.setText(R.string.fdp);
                                break;
                            } else {
                                FTSAddWw.this.xap.setText(Dk.desc);
                                break;
                            }
                        case -4:
                            if (i2 != 4) {
                                FTSAddWw.this.xap.setText(FTSAddWw.this.getString(R.string.gfr));
                                break;
                            }
                        default:
                            FTSAddWw.this.xap.setText(R.string.fdp);
                            break;
                    }
                    FTSAddWw.this.xaw = -1;
                    FTSAddWw.this.xax = 1;
                    gr grVar2 = new gr();
                    grVar2.ut(FTSAddWw.this.mSessionId);
                    grVar2.eCt = 0;
                    grVar2.eKL = 2;
                    grVar2.bfK();
                }
                FTSAddWw.g(FTSAddWw.this);
                AppMethodBeat.o(111850);
            }
        };
        this.xaw = 0;
        this.xax = 0;
        g.azz().a(com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX, this.callback);
        final n nVar = new n(str);
        g.azz().a(nVar, 0);
        getString(R.string.zb);
        this.rAV = h.a((Context) this, getString(R.string.gfq), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.fts.ui.FTSAddWw.AnonymousClass6 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(111851);
                g.azz().a(nVar);
                g.azz().b(com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX, FTSAddWw.this.callback);
                FTSAddWw.this.rAV = null;
                AppMethodBeat.o(111851);
            }
        });
        AppMethodBeat.o(111866);
    }

    private void dPe() {
        AppMethodBeat.i(111867);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.FTSAddWw.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(111852);
                if (FTSAddWw.this.rAV != null) {
                    FTSAddWw.this.rAV.dismiss();
                    FTSAddWw.this.rAV = null;
                }
                AppMethodBeat.o(111852);
            }
        });
        AppMethodBeat.o(111867);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onClickClearTextBtn(View view) {
        AppMethodBeat.i(111868);
        super.onClickClearTextBtn(view);
        if (!this.xaN.getFtsEditText().vy.hasFocus()) {
            this.xaN.getFtsEditText().awD();
            showVKB();
        }
        AppMethodBeat.o(111868);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final boolean awE() {
        AppMethodBeat.i(111861);
        ayL(this.query);
        hideVKB();
        AppMethodBeat.o(111861);
        return true;
    }

    static /* synthetic */ void g(FTSAddWw fTSAddWw) {
        AppMethodBeat.i(111871);
        if (fTSAddWw.xaw != 0) {
            fTSAddWw.dPe();
            if (fTSAddWw.xaw > 0) {
                fTSAddWw.xas = true;
                fTSAddWw.dPd();
                AppMethodBeat.o(111871);
                return;
            } else if (fTSAddWw.xaw > 0) {
                dsk dsk = fTSAddWw.xaD;
                String str = dsk.UserName;
                String str2 = dsk.oUJ;
                fTSAddWw.xaK.setVisibility(8);
                fTSAddWw.xaf.setVisibility(0);
                fTSAddWw.xag.setVisibility(0);
                fTSAddWw.xak.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.fts.ui.FTSAddWw.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(111849);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSAddWw$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (!Util.isNullOrNil(FTSAddWw.this.query)) {
                            FTSAddWw.this.xas = true;
                            ar.q(FTSAddWw.this.query, FTSAddWw.this.xat, 1, 16);
                        }
                        FTSAddWw.c(FTSAddWw.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSAddWw$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(111849);
                    }
                });
                fTSAddWw.xam.setText(str2);
                fTSAddWw.xan.setText("");
                a.b.c(fTSAddWw.xal, str);
                fTSAddWw.xah.setVisibility(8);
                fTSAddWw.xai.setVisibility(8);
                fTSAddWw.xaj.setVisibility(8);
                fTSAddWw.xau.setVisibility(8);
                AppMethodBeat.o(111871);
                return;
            } else {
                fTSAddWw.xaK.setVisibility(8);
                fTSAddWw.xaf.setVisibility(0);
                fTSAddWw.xag.setVisibility(8);
                fTSAddWw.xah.setVisibility(0);
                fTSAddWw.xai.setVisibility(8);
                fTSAddWw.xaj.setVisibility(8);
                fTSAddWw.xau.setVisibility(8);
            }
        }
        AppMethodBeat.o(111871);
    }
}

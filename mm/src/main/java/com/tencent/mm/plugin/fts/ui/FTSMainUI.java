package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aas;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.g.b.a.kh;
import com.tencent.mm.g.b.a.nt;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.b.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.fts.ui.widget.b;
import com.tencent.mm.plugin.fts.ui.widget.h;
import com.tencent.mm.plugin.fts.ui.widget.i;
import com.tencent.mm.plugin.fts.ui.widget.j;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.k;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cge;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.efl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import org.json.JSONObject;

@a(3)
public class FTSMainUI extends FTSBaseVoiceSearchUI implements b.a {
    public int mve;
    Dialog rAV;
    int xaz = -1;
    private FTSMainUIEducationLayout xbP;
    private com.tencent.mm.plugin.fts.ui.widget.b xbQ;
    private boolean xbR = false;
    private String xbS;
    private volatile boolean xbT;
    private h xbU;
    i xbV;
    private KeyboardLinearLayout xbW;
    public k xbX;
    private View xbY;
    View xbZ;
    private View xca;
    private TextView xcb;
    private View xcc;
    private View xcd;
    private k xce = new k() {
        /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass3 */
    };
    private View.OnClickListener xcf = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass4 */

        public final void onClick(View view) {
            int i2;
            String str;
            int i3;
            AppMethodBeat.i(111964);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            try {
                if (view.getTag() != null) {
                    i3 = ((JSONObject) view.getTag()).optInt("businessType");
                } else {
                    i3 = 0;
                }
                i2 = i3;
            } catch (Exception e2) {
                i2 = 0;
            }
            Object tag = view.getTag(R.id.gy4);
            String str2 = "";
            if (tag instanceof View) {
                if (((View) tag).getVisibility() == 0) {
                    n nVar = n.UWX;
                    str = n.hVM();
                } else {
                    str = str2;
                }
                ((View) tag).setVisibility(8);
                str2 = str;
            }
            if (i2 == 0) {
                String charSequence = ((TextView) view.getTag(R.id.iwy)).getText().toString();
                if (charSequence.equals(FTSMainUI.this.getString(R.string.ggb))) {
                    i2 = 2;
                } else if (charSequence.equals(FTSMainUI.this.getString(R.string.ggf))) {
                    i2 = 8;
                } else if (charSequence.equals(FTSMainUI.this.getString(R.string.ggc))) {
                    i2 = 1;
                }
            }
            if (i2 != 0) {
                if (i2 == 2 && !WeChatBrands.Business.Entries.HomeServiceMp.checkAvailable(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(111964);
                    return;
                } else if (i2 == 1 && !WeChatBrands.Business.Entries.HomeServiceMp.checkAvailable(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(111964);
                    return;
                } else if (i2 == 512 && !WeChatBrands.Business.Entries.SessionMusic.checkAvailable(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(111964);
                    return;
                } else if ((i2 == 64 || i2 == 262208) && !WeChatBrands.Business.Entries.GlobalAppbrand.checkAvailable(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(111964);
                    return;
                } else {
                    n nVar2 = n.UWX;
                    long j2 = (long) i2;
                    Log.i(n.TAG, "click reddot ".concat(String.valueOf(j2)));
                    if (n.RO(j2)) {
                        e aAh = g.aAh();
                        p.g(aAh, "MMKernel.storage()");
                        aAh.azQ().set(ar.a.USERINFO_FTS_MAIN_EDUCATION_RED_DOT_STRING, "");
                        n.UWV = null;
                    }
                    i iVar = FTSMainUI.this.xbV;
                    ((com.tencent.mm.plugin.websearch.api.i) g.af(com.tencent.mm.plugin.websearch.api.i.class)).a(iVar.xfV, new Runnable(i2, str2) {
                        /* class com.tencent.mm.plugin.fts.ui.widget.i.AnonymousClass3 */
                        final /* synthetic */ String UXa;
                        final /* synthetic */ int val$type;

                        {
                            this.val$type = r2;
                            this.UXa = r3;
                        }

                        public final void run() {
                            AppMethodBeat.i(112334);
                            if (System.currentTimeMillis() - i.this.mZq <= 1000) {
                                AppMethodBeat.o(112334);
                                return;
                            }
                            i.this.mZq = System.currentTimeMillis();
                            if (!ai.afs(0)) {
                                Log.e("MicroMsg.FTS.PardusSearchLogic", "fts h5 template not avail");
                                AppMethodBeat.o(112334);
                                return;
                            }
                            String aXf = ak.aXf("searchID");
                            com.tencent.mm.plugin.websearch.api.ar.b(this.val$type, 14, aXf, com.tencent.mm.plugin.fts.a.e.dOy(), this.UXa);
                            Log.i("MicroMsg.FTS.PardusSearchLogic", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", Integer.valueOf(this.val$type), aXf);
                            i.this.xfV.hideVKB();
                            Intent fXX = ai.fXX();
                            fXX.putExtra("ftsneedkeyboard", true);
                            fXX.putExtra("ftsbizscene", 14);
                            fXX.putExtra("ftsType", this.val$type);
                            fXX.putExtra("key_change_search_icon", true);
                            Map<String, String> h2 = ai.h(14, false, this.val$type);
                            h2.put("sessionId", String.valueOf(com.tencent.mm.plugin.fts.a.e.wVm));
                            h2.put("subSessionId", String.valueOf(com.tencent.mm.plugin.fts.a.e.wVm));
                            fXX.putExtra("sessionId", String.valueOf(com.tencent.mm.plugin.fts.a.e.wVm));
                            fXX.putExtra("subSessionId", String.valueOf(com.tencent.mm.plugin.fts.a.e.wVm));
                            fXX.putExtra("rawUrl", ai.bd(h2));
                            fXX.putExtra("key_load_js_without_delay", true);
                            if (this.val$type != 64) {
                                c.b(i.this.xfV, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", fXX);
                                AppMethodBeat.o(112334);
                                return;
                            }
                            ((com.tencent.mm.plugin.websearch.api.h) g.af(com.tencent.mm.plugin.websearch.api.h.class)).b(i.this.xfV, 14, "", "");
                            AppMethodBeat.o(112334);
                        }
                    });
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111964);
        }
    };
    private IListener<aas> xcg = new IListener<aas>() {
        /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass5 */

        {
            AppMethodBeat.i(161156);
            this.__eventId = aas.class.getName().hashCode();
            AppMethodBeat.o(161156);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aas aas) {
            AppMethodBeat.i(111965);
            FTSMainUI.this.xbP.updateView();
            AppMethodBeat.o(111965);
            return false;
        }
    };
    int xch = 1;

    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FTSMainUI() {
        AppMethodBeat.i(111977);
        AppMethodBeat.o(111977);
    }

    static /* synthetic */ void e(FTSMainUI fTSMainUI) {
        AppMethodBeat.i(235392);
        fTSMainUI.dPx();
        AppMethodBeat.o(235392);
    }

    static /* synthetic */ void f(FTSMainUI fTSMainUI) {
        AppMethodBeat.i(235395);
        super.finish();
        AppMethodBeat.o(235395);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111978);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.c_), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        this.xbW = (KeyboardLinearLayout) findViewById(R.id.h8v);
        this.xbW.setOnkbdStateListener(new KeyboardLinearLayout.a() {
            /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.KeyboardLinearLayout.a
            public final void Ns(int i2) {
                AppMethodBeat.i(111962);
                if (i2 == -3) {
                    Log.i("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_SHOW");
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            efl efl;
                            AppMethodBeat.i(111960);
                            FTSMainUI.this.xbR = true;
                            if (Util.isNullOrNil(FTSMainUI.this.xaQ.getSearchContent()) && FTSMainUI.this.xbQ != null) {
                                FTSMainUI.this.xbQ.show();
                            }
                            h hVar = FTSMainUI.this.xbU;
                            hVar.xfU = true;
                            cgf cgf = hVar.xfR;
                            if (cgf == null || (efl = cgf.MlS) == null || efl.KKx == null) {
                                AppMethodBeat.o(111960);
                                return;
                            }
                            hVar.ufR.setVisibility(0);
                            AppMethodBeat.o(111960);
                        }
                    }, 0);
                    AppMethodBeat.o(111962);
                    return;
                }
                if (i2 == -2) {
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(111961);
                            FTSMainUI.this.xbR = false;
                            if (FTSMainUI.this.xbQ != null) {
                                FTSMainUI.this.xbQ.dPM();
                            }
                            h hVar = FTSMainUI.this.xbU;
                            hVar.xfU = false;
                            hVar.ufR.setVisibility(8);
                            AppMethodBeat.o(111961);
                        }
                    }, 0);
                    Log.i("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_HIDE");
                }
                AppMethodBeat.o(111962);
            }
        });
        this.xaQ.setHint(getString(R.string.yn));
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        hideActionbarLine();
        com.tencent.mm.plugin.fts.a.e.wVm = d.Ni(3);
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", Integer.valueOf(this.mve), 1, 0, 0, 0, "", 0, 0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Long.valueOf(com.tencent.mm.plugin.fts.a.e.wVm), "", 0, 0, 0, "", "", "", 1, 0, "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.wVm), 0, "", "");
        Log.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", 10991, format);
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10991, format);
        this.xbP = (FTSMainUIEducationLayout) findViewById(R.id.hdy);
        this.xbP.setOnCellClickListener(this.xcf);
        this.xbP.setOnHotwordClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(111966);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                i iVar = FTSMainUI.this.xbV;
                String str = (String) view.getTag();
                if (System.currentTimeMillis() - iVar.mZq > 1000) {
                    iVar.mZq = System.currentTimeMillis();
                    if (!ai.afs(0)) {
                        Log.e("MicroMsg.FTS.PardusSearchLogic", "fts h5 template not avail");
                    } else {
                        Intent fXX = ai.fXX();
                        fXX.putExtra("ftsbizscene", 15);
                        fXX.putExtra("ftsQuery", str);
                        fXX.putExtra("title", str);
                        fXX.putExtra("isWebwx", str);
                        fXX.putExtra("ftscaneditable", false);
                        Map<String, String> h2 = ai.h(15, false, 2);
                        h2.put(SearchIntents.EXTRA_QUERY, str);
                        h2.put("sceneActionType", "2");
                        fXX.putExtra("rawUrl", ai.bd(h2));
                        om omVar = new om();
                        omVar.dUz.scene = 0;
                        EventCenter.instance.publish(omVar);
                        fXX.putExtra("ftsInitToSearch", true);
                        c.b(iVar.xfV.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", fXX);
                        com.tencent.mm.plugin.websearch.api.ar.cO(15, str);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111966);
            }
        });
        this.xbP.setNeedHotWord(false);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(111971);
                com.tencent.mm.modelgeo.d.bca().a((b.a) FTSMainUI.this, true);
                AppMethodBeat.o(111971);
            }
        }, "FTSMainUI.GetLocation");
        if (((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() == null) {
            finish();
            AppMethodBeat.o(111978);
            return;
        }
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().dOn();
        ak.bq(3, false);
        EventCenter.instance.add(this.xcg);
        AppMethodBeat.o(111978);
    }

    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI, com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        AppMethodBeat.i(111979);
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        com.tencent.mm.plugin.fts.ui.widget.c cVar = this.xaQ;
        i iVar = this.xbV;
        if (cVar.Qwh != null) {
            cVar.Qwh.setFocusChangeListener(iVar);
        }
        if (LocaleUtil.isChineseAppLang() || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.ENGLISH)) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(111979);
            return onCreateOptionsMenu;
        }
        FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl = (FTSVoiceInputLayoutImpl) findViewById(R.id.dbd);
        TextView textView = (TextView) findViewById(R.id.jaj);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.jah);
        if (fTSVoiceInputLayoutImpl == null || textView == null || progressBar == null) {
            Object[] objArr = new Object[3];
            if (fTSVoiceInputLayoutImpl == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (textView == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[1] = Boolean.valueOf(z3);
            if (progressBar != null) {
                z4 = false;
            }
            objArr[2] = Boolean.valueOf(z4);
            Log.w("MicroMsg.FTS.FTSMainUI", "voicePanel == null || sayTv == null || loadingIv == null, %s, %s, %s", objArr);
            AppMethodBeat.o(111979);
            return onCreateOptionsMenu;
        }
        this.xbQ = new com.tencent.mm.plugin.fts.ui.widget.b(this, fTSVoiceInputLayoutImpl, textView, progressBar);
        this.xbQ.xfn = new b.a() {
            /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.fts.ui.widget.b.a
            public final void dPy() {
                AppMethodBeat.i(111967);
                FTSMainUI.this.xaQ.setCursorVisible(false);
                FTSMainUI.this.xbX.Nr(1);
                FTSMainUI.e(FTSMainUI.this);
                FTSMainUI.this.xaQ.setHint(FTSMainUI.this.getContext().getString(R.string.dki));
                AppMethodBeat.o(111967);
            }

            @Override // com.tencent.mm.plugin.fts.ui.widget.b.a
            public final void ayO(String str) {
                AppMethodBeat.i(111968);
                FTSMainUI.this.xaQ.setSearchContent(str);
                AppMethodBeat.o(111968);
            }

            @Override // com.tencent.mm.plugin.fts.ui.widget.b.a
            public final void c(boolean z, boolean z2, String str) {
                AppMethodBeat.i(111969);
                FTSMainUI.this.xaQ.setSearchContent(str);
                FTSMainUI.a(FTSMainUI.this, str);
                if (!z) {
                    if (z2) {
                        FTSMainUI.ayN(FTSMainUI.this.getString(R.string.dkk));
                        AppMethodBeat.o(111969);
                        return;
                    }
                    FTSMainUI.ayN(FTSMainUI.this.getString(R.string.dkl));
                }
                AppMethodBeat.o(111969);
            }

            @Override // com.tencent.mm.plugin.fts.ui.widget.b.a
            public final void ayP(String str) {
                AppMethodBeat.i(111970);
                FTSMainUI.this.xbX.xbD.xeC = str;
                FTSMainUI.this.xaQ.setSearchContent(str);
                FTSMainUI.a(FTSMainUI.this, str);
                AppMethodBeat.o(111970);
            }
        };
        AppMethodBeat.o(111979);
        return onCreateOptionsMenu;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(111980);
        finish();
        AppMethodBeat.o(111980);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(111981);
        hideVKB();
        super.onStop();
        AppMethodBeat.o(111981);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final void dPh() {
        AppMethodBeat.i(111982);
        switch (getIntent().getIntExtra("from_tab_index", -1)) {
            case 0:
                this.mve = 1;
                break;
            case 1:
                this.mve = 2;
                break;
            case 2:
                this.mve = 3;
                break;
            case 3:
                this.mve = 4;
                break;
            default:
                this.mve = 0;
                break;
        }
        this.xbV = new i(this);
        this.xbU = new h(this);
        AppMethodBeat.o(111982);
    }

    public final k dPv() {
        return this.xbX;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final d a(e eVar) {
        AppMethodBeat.i(111983);
        this.xbX = new k(eVar, this.mve, this.xbV);
        this.xbX.Nr(2);
        k kVar = this.xbX;
        AppMethodBeat.o(111983);
        return kVar;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.anl;
    }

    @Override // com.tencent.mm.plugin.fts.ui.e
    public final void a(com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        AppMethodBeat.i(111984);
        if (z) {
            this.xbV.Nz(1);
        }
        AppMethodBeat.o(111984);
    }

    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(111985);
        com.tencent.f.h.RTc.bqo("FTSMainUI.GetLocation");
        com.tencent.mm.modelgeo.d.bca().c(this);
        if (((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() != null) {
            ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().dOo();
        }
        EventCenter.instance.removeListener(this.xcg);
        if (this.xbQ != null) {
            com.tencent.mm.plugin.fts.ui.widget.b bVar = this.xbQ;
            if (bVar.xfp != null) {
                bVar.xfp.biE();
                FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl = bVar.xfp;
                if (fTSVoiceInputLayoutImpl.ndA != null) {
                    fTSVoiceInputLayoutImpl.ndA.removeCallbacksAndMessages(null);
                }
                if (fTSVoiceInputLayoutImpl.xhn != null) {
                    fTSVoiceInputLayoutImpl.xhn.removeCallbacksAndMessages(null);
                }
                if (fTSVoiceInputLayoutImpl.jxC != null) {
                    fTSVoiceInputLayoutImpl.jxC.stopTimer();
                }
            }
        }
        if (this.xbV != null) {
            i iVar = this.xbV;
            if (iVar.xgB != null) {
                j jVar = iVar.xgB;
                jVar.xha.destroy();
                g.azz().b(2975, jVar);
                jVar.xgX.removeJavascriptInterface("pardusJSApi");
                jVar.xgX.destroy();
            }
            iVar.Nz(3);
            iVar.clearData();
            iVar.dQc();
            iVar.dOG();
        }
        if (this.xbU != null) {
            g.azz().b(4591, this.xbU);
        }
        super.onDestroy();
        AppMethodBeat.o(111985);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(111986);
        super.onResume();
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(111972);
                com.tencent.mm.compatible.util.i.v(FTSMainUI.this);
                AppMethodBeat.o(111972);
            }
        });
        yr yrVar = new yr();
        yrVar.eeW.gY = 0;
        EventCenter.instance.publish(yrVar);
        if (!Util.isNullOrNil(this.xbS)) {
            this.query = this.xbS;
            this.xbS = null;
        }
        ai.fXY();
        AppMethodBeat.o(111986);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(111987);
        int i2 = 100;
        if (!getController().hideVKB()) {
            i2 = 0;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(111973);
                Log.i("MicroMsg.FTS.FTSMainUI", " finish");
                FTSMainUI.f(FTSMainUI.this);
                AppMethodBeat.o(111973);
            }
        }, (long) i2);
        AppMethodBeat.o(111987);
    }

    @Override // com.tencent.mm.modelgeo.b.a
    public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
        AppMethodBeat.i(111988);
        Log.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3));
        com.tencent.mm.modelgeo.d.bca().c(this);
        AppMethodBeat.o(111988);
        return false;
    }

    private void dPw() {
        AppMethodBeat.i(111989);
        this.xbP.setVisibility(0);
        this.xbP.updateView();
        AppMethodBeat.o(111989);
    }

    private void dPx() {
        AppMethodBeat.i(111990);
        this.xbP.setVisibility(8);
        AppMethodBeat.o(111990);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final void dPm() {
        AppMethodBeat.i(111991);
        super.dPm();
        dPw();
        this.xcd.setVisibility(8);
        if (this.xbR && this.xbQ != null) {
            this.xbQ.show();
        }
        AppMethodBeat.o(111991);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final void dPl() {
        AppMethodBeat.i(111992);
        super.dPl();
        dPx();
        this.xcd.setVisibility(8);
        if (this.xbQ != null && !this.xbQ.xfo) {
            this.xbQ.dPM();
        }
        AppMethodBeat.o(111992);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final void dPk() {
        AppMethodBeat.i(111993);
        super.dPk();
        dPx();
        this.xcd.setVisibility(8);
        this.xaK.setVisibility(0);
        if (this.xbQ != null && !this.xbQ.xfo) {
            this.xbQ.dPM();
        }
        AppMethodBeat.o(111993);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final void dPj() {
        AppMethodBeat.i(111994);
        super.dPj();
        dPx();
        this.xcd.setVisibility(8);
        if (this.xbQ != null && !this.xbQ.xfo) {
            this.xbQ.dPM();
        }
        AppMethodBeat.o(111994);
    }

    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final View getHeaderView() {
        AppMethodBeat.i(111995);
        i iVar = this.xbV;
        if (iVar.xfY == null) {
            iVar.xfY = LayoutInflater.from(iVar.xfV).inflate(R.layout.ao2, (ViewGroup) null, false);
            iVar.contentView = iVar.xfY.findViewById(R.id.do8);
            iVar.xgc = iVar.xfY.findViewById(R.id.hf3);
            iVar.xgd = (TextView) iVar.xfY.findViewById(R.id.ie2);
            iVar.xge = (TextView) iVar.xfY.findViewById(R.id.ie3);
            iVar.xgf = (TextView) iVar.xfY.findViewById(R.id.ie4);
            iVar.xgg = iVar.xfY.findViewById(R.id.hez);
            iVar.xgh = iVar.xfY.findViewById(R.id.h5n);
            iVar.xeb = iVar.xfY.findViewById(R.id.bcc);
            iVar.gvv = (ImageView) iVar.xfY.findViewById(R.id.x1);
            iVar.xgi = (TextView) iVar.xfY.findViewById(R.id.bdj);
            iVar.xec = (TextView) iVar.xfY.findViewById(R.id.ba7);
            iVar.xgj = (TextView) iVar.xfY.findViewById(R.id.bdk);
            iVar.xgk = iVar.xfY.findViewById(R.id.bsx);
            iVar.xgl = (ImageView) iVar.xfY.findViewById(R.id.bsw);
            iVar.xgm = (TextView) iVar.xfY.findViewById(R.id.bsz);
            iVar.xgn = (TextView) iVar.xfY.findViewById(R.id.bsv);
            iVar.xgo = (TextView) iVar.xfY.findViewById(R.id.bsu);
            iVar.xgp = (TextView) iVar.xfY.findViewById(R.id.bsy);
            iVar.xgq = iVar.xfY.findViewById(R.id.j58);
            iVar.xgr = (ImageView) iVar.xfY.findViewById(R.id.j6n);
            iVar.xgs = (TextView) iVar.xfY.findViewById(R.id.j4n);
            iVar.xgt = (TextView) iVar.xfY.findViewById(R.id.j6u);
            iVar.xgu = (TextView) iVar.xfY.findViewById(R.id.j3w);
            iVar.xgv = iVar.xfY.findViewById(R.id.fq6);
            iVar.xgw = (ImageView) iVar.xfY.findViewById(R.id.fq3);
            iVar.xgx = (ImageView) iVar.xfY.findViewById(R.id.fqn);
            iVar.xgy = (TextView) iVar.xfY.findViewById(R.id.fqp);
            iVar.xgz = (TextView) iVar.xfY.findViewById(R.id.fq0);
            iVar.xgA = (TextView) iVar.xfY.findViewById(R.id.fpv);
            iVar.xgB = new j(iVar, (FrameLayout) iVar.xfY.findViewById(R.id.jl1));
        }
        View view = iVar.xfY;
        AppMethodBeat.o(111995);
        return view;
    }

    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final List<View> dPq() {
        AppMethodBeat.i(111996);
        ArrayList arrayList = new ArrayList();
        if (this.xbY == null) {
            this.xbY = getLayoutInflater().inflate(R.layout.anu, (ViewGroup) null, false);
            this.xbZ = this.xbY.findViewById(R.id.hdl);
            this.xbZ.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass11 */

                public final void onClick(View view) {
                    int i2;
                    AppMethodBeat.i(111974);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    FTSMainUI fTSMainUI = FTSMainUI.this;
                    String str = FTSMainUI.this.query;
                    com.tencent.mm.plugin.fts.ui.c.b bVar2 = fTSMainUI.xbX.xbD;
                    int count = fTSMainUI.xbX.getCount();
                    int i3 = fTSMainUI.mve;
                    kh khVar = new kh();
                    khVar.eUg = (long) i3;
                    if (d.ays(str)) {
                        khVar.eUh = 8;
                    } else {
                        khVar.eUh = 9;
                    }
                    khVar.eUi = (long) (count + 1);
                    if (bVar2.xaI > 0 && bVar2.xaI < System.currentTimeMillis()) {
                        khVar.ePF = System.currentTimeMillis() - bVar2.xeh;
                    }
                    if (!bVar2.xeC.equals(str)) {
                        khVar.eUG = 1;
                    }
                    kh xp = khVar.xo("").xp("");
                    xp.eUr = (long) bVar2.xel;
                    xp.eUs = (long) bVar2.xem;
                    xp.eUt = (long) bVar2.xen;
                    xp.eUu = (long) bVar2.xeo;
                    xp.eUv = (long) bVar2.xep;
                    xp.eUw = (long) bVar2.favCount;
                    xp.eUy = (long) bVar2.xeq;
                    xp.eUz = (long) bVar2.xer;
                    kh xr = xp.xq(String.valueOf(com.tencent.mm.plugin.fts.a.e.wVm)).xr(str);
                    xr.eUD = (long) bVar2.dPA();
                    kh xu = xr.xs("").xt("").xu("");
                    xu.eUF = 1;
                    xu.xv("").xw("").xx("").xy("").xz("").xA("").xB("").xC("").xD("");
                    khVar.bfK();
                    Log.i("MicroMsg.FTS.FTSReportLogic", "%s", khVar.abW().replace(APLogFileUtil.SEPARATOR_LINE, " "));
                    boolean ays = d.ays(fTSMainUI.query);
                    boolean ayt = d.ayt(fTSMainUI.query);
                    if (ays) {
                        i2 = 8;
                    } else {
                        if (ayt) {
                            i2 = 9;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(111974);
                    }
                    bVar2.Nv(i2);
                    k kVar = fTSMainUI.xbX;
                    kVar.xby = true;
                    kVar.xbE.Nz(1);
                    fTSMainUI.xbX.xby = true;
                    if (!fTSMainUI.xbX.xbo) {
                        fTSMainUI.xbX.xbo = true;
                        l.a(str, true, fTSMainUI.xbX.getCount(), 0, bVar2);
                    }
                    if (!(str == null || str.length() == 0 || str.trim().length() == 0)) {
                        fTSMainUI.xaz = Character.isDigit(str.charAt(0)) ? 15 : 3;
                        AnonymousClass12 r0 = new com.tencent.mm.ak.i(str) {
                            /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass12 */
                            final /* synthetic */ String LZ;

                            {
                                this.LZ = r2;
                            }

                            @Override // com.tencent.mm.ak.i
                            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                                AppMethodBeat.i(111975);
                                g.azz().b(106, this);
                                if (i2 == 4 && i3 == -4) {
                                    FTSMainUI.g(FTSMainUI.this);
                                    com.tencent.mm.ui.base.h.a((Context) FTSMainUI.this, (int) R.string.gfw, 0, true, (DialogInterface.OnClickListener) null);
                                    AppMethodBeat.o(111975);
                                    return;
                                }
                                FTSMainUI.g(FTSMainUI.this);
                                if (i2 == 0 && i3 == 0) {
                                    drt eiq = ((f) qVar).eiq();
                                    if (eiq.LUB <= 0) {
                                        if (Util.nullAsNil(z.a(eiq.Lqk)).length() > 0) {
                                            if (2 == eiq.MUk) {
                                                FTSMainUI.this.xaz = 15;
                                            } else if (1 == eiq.MUk) {
                                                FTSMainUI.this.xaz = 1;
                                            }
                                            Intent intent = new Intent();
                                            ((com.tencent.mm.api.n) g.af(com.tencent.mm.api.n.class)).a(intent, eiq, FTSMainUI.this.xaz);
                                            if (FTSMainUI.this.xaz == 15) {
                                                intent.putExtra("Contact_Search_Mobile", this.LZ.trim());
                                            }
                                            intent.putExtra("Contact_Scene", FTSMainUI.this.xaz);
                                            intent.putExtra("add_more_friend_search_scene", 2);
                                            c.b(FTSMainUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                                        }
                                        AppMethodBeat.o(111975);
                                    } else if (eiq.LUC.isEmpty()) {
                                        com.tencent.mm.ui.base.h.a((Context) FTSMainUI.this, (int) R.string.gfw, 0, true, (DialogInterface.OnClickListener) null);
                                        AppMethodBeat.o(111975);
                                    } else {
                                        Intent intent2 = new Intent();
                                        ((com.tencent.mm.api.n) g.af(com.tencent.mm.api.n.class)).a(intent2, eiq.LUC.getFirst(), FTSMainUI.this.xaz);
                                        c.b(FTSMainUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                                        AppMethodBeat.o(111975);
                                    }
                                } else {
                                    switch (i3) {
                                        case -24:
                                            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                                            if (Dk != null) {
                                                com.tencent.mm.ui.base.h.a((Context) FTSMainUI.this, Dk.desc, Dk.Title, true, (DialogInterface.OnClickListener) null);
                                                break;
                                            }
                                            break;
                                        case -4:
                                            Toast.makeText(FTSMainUI.this, FTSMainUI.this.getString(R.string.gfr), 0).show();
                                            break;
                                    }
                                    Log.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", Integer.valueOf(i2), Integer.valueOf(i3)));
                                    AppMethodBeat.o(111975);
                                }
                            }
                        };
                        g.azz().a(106, r0);
                        f fVar = new f(str, 3);
                        g.azz().a(fVar, 0);
                        fTSMainUI.getString(R.string.zb);
                        fTSMainUI.rAV = com.tencent.mm.ui.base.h.a((Context) fTSMainUI, fTSMainUI.getString(R.string.gfq), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener(fVar, r0) {
                            /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass13 */
                            final /* synthetic */ f xaB;
                            final /* synthetic */ com.tencent.mm.ak.i xck;

                            {
                                this.xaB = r2;
                                this.xck = r3;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(111976);
                                g.azz().a(this.xaB);
                                g.azz().b(106, this.xck);
                                FTSMainUI.this.rAV = null;
                                AppMethodBeat.o(111976);
                            }
                        });
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(111974);
                }
            });
            this.xca = this.xbY.findViewById(R.id.hdk);
            this.xcb = (TextView) this.xbY.findViewById(R.id.hdm);
        }
        arrayList.add(this.xbY);
        if (this.xbV.dzK() != null) {
            arrayList.add(this.xbV.dzK());
        }
        if (this.xcc == null) {
            this.xcc = getLayoutInflater().inflate(R.layout.ani, (ViewGroup) null, false);
            this.xcd = this.xcc.findViewById(R.id.epl);
        }
        arrayList.add(this.xcc);
        AppMethodBeat.o(111996);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI, com.tencent.mm.ui.tools.s.b
    public final boolean SN(String str) {
        AppMethodBeat.i(111997);
        super.SN(str);
        if (this.xbT && !TextUtils.isEmpty(this.query)) {
            k kVar = this.xbX;
            ArrayList arrayList = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.d.e eVar : kVar.xbB) {
                arrayList.addAll(eVar.dOH());
            }
            if (arrayList.size() != 0 || !TextUtils.isEmpty(this.xcb.getText()) || this.xbV.dDz) {
                nt ntVar = new nt();
                ntVar.fiw = 1;
                ntVar.ejW = 2;
                ntVar.AT(this.query).bfK();
            } else {
                this.xbV.dY(this.query, 17);
                nt ntVar2 = new nt();
                ntVar2.fiw = 1;
                ntVar2.ejW = 1;
                ntVar2.AT(this.query).bfK();
                int i2 = this.mve;
                com.tencent.mm.plugin.fts.ui.c.b bVar = this.xbX.xbD;
                kh khVar = new kh();
                khVar.eUg = (long) i2;
                khVar.eUh = 29;
                khVar.eUj = 1;
                khVar.eUD = (long) bVar.dPA();
                kh xC = khVar.xo("").xp("").xr(bVar.query).xq("").xs("").xt("").xu("").xv("").xw("").xx("").xy("").xz("").xA("").xB("").xC("");
                xC.eUV = com.tencent.mm.plugin.fts.a.e.wVm;
                xC.eUW = bVar.xej;
                xC.xD("");
                khVar.bfK();
                Log.i("MicroMsg.FTS.FTSReportLogic", "%s", khVar.abW().replace(APLogFileUtil.SEPARATOR_LINE, " "));
                this.xbV.Nz(8);
            }
        }
        AppMethodBeat.o(111997);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final void dPr() {
        AppMethodBeat.i(111998);
        this.xcd.setVisibility(0);
        AppMethodBeat.o(111998);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final void dPs() {
        AppMethodBeat.i(111999);
        this.xcd.setVisibility(8);
        AppMethodBeat.o(111999);
    }

    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI, com.tencent.mm.plugin.fts.ui.d.a
    public final void ay(int i2, boolean z) {
        int i3;
        int i4 = 1;
        int i5 = 0;
        AppMethodBeat.i(112000);
        super.ay(i2, z);
        if (z || i2 != 0 || !this.xbX.xbM) {
            this.xcd.setVisibility(8);
        } else {
            this.xcd.setVisibility(0);
        }
        if (!z) {
            this.xbZ.setVisibility(8);
            this.xbV.f(i2, z, false);
            AppMethodBeat.o(112000);
            return;
        }
        this.xbT = true;
        boolean ays = d.ays(this.query);
        boolean ayt = d.ayt(this.query);
        this.xbV.f(i2, z, ays || ayt);
        if (i2 <= 0) {
            this.xca.setVisibility(8);
        } else if (ays || ayt) {
            this.xca.setVisibility(0);
        }
        if (ays || ayt) {
            this.xbZ.setVisibility(0);
            com.tencent.mm.plugin.fts.ui.c.b bVar = this.xbX.xbD;
            if (ays) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (!ayt) {
                i4 = 0;
            }
            bVar.xew = i3;
            bVar.xex = i4;
            if (ays) {
                i5 = 8;
            } else if (ayt) {
                i5 = 9;
            }
            com.tencent.mm.plugin.fts.ui.c.b bVar2 = this.xbX.xbD;
            com.tencent.mm.plugin.fts.a.a.c cVar = new com.tencent.mm.plugin.fts.a.a.c();
            cVar.position = bVar2.xeA + 1;
            cVar.dUb = "SearchContactBar";
            cVar.wVZ = System.currentTimeMillis() - bVar2.xaI;
            cVar.dUm = i5;
            if (!bVar2.xeG.contains(cVar)) {
                bVar2.xeG.add(cVar);
            }
        }
        AppMethodBeat.o(112000);
    }

    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI, com.tencent.mm.ui.tools.s.b
    public final void SO(String str) {
        AppMethodBeat.i(112001);
        if (this.xbQ == null || !this.xbQ.xfo) {
            super.SO(str);
        }
        this.xbT = false;
        AppMethodBeat.o(112001);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final void dPc() {
        AppMethodBeat.i(112002);
        super.dPc();
        this.xca.setVisibility(8);
        this.xbZ.setVisibility(8);
        this.xch = 1;
        i iVar = this.xbV;
        String str = this.query;
        long j2 = com.tencent.mm.plugin.fts.a.e.wVn;
        if (iVar.xgD == i.b.StartSearch) {
            l.N(iVar.xbf, 11);
        } else if (iVar.xgD == i.b.StartAnimation) {
            l.N(iVar.xbf, 8);
        }
        iVar.clearData();
        iVar.dOG();
        iVar.dQd();
        int aft = ai.aft(5);
        Log.i("MicroMsg.FTS.PardusSearchLogic", "start search %s %d %d", str, Long.valueOf(j2), Integer.valueOf(aft));
        iVar.a(i.b.StartSearch);
        iVar.query = str;
        cze cze = new cze();
        cze.KXA = str;
        cze.Mba = String.valueOf(j2);
        cze.SessionId = String.valueOf(com.tencent.mm.plugin.fts.a.e.wVm);
        b.a aVar = b.a.clicfg_fts_pardus_open_flag;
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        cze.MEs = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, com.tencent.mm.util.c.hdd());
        cze.MaY = aft;
        iVar.xbf = j2;
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_fts_pardus_time, 500);
        iVar.xgC = new u(cze);
        g.azz().a(1076, iVar);
        g.azz().a(iVar.xgC, 0);
        iVar.xaI = System.currentTimeMillis();
        iVar.xeO.sendMessageDelayed(iVar.xeO.obtainMessage(1, Long.valueOf(j2)), (long) a2);
        iVar.xbb.setText(l.e((Context) iVar.xfV.getContext(), com.tencent.mm.plugin.fts.a.f.a(iVar.xfV.getString(R.string.dkc), "", com.tencent.mm.plugin.fts.a.a.e.c(str, str)).wWu, com.tencent.mm.cb.a.aG(iVar.xfV.getContext(), R.dimen.is)));
        l.N(iVar.xbf, 1);
        h hVar = this.xbU;
        String str2 = this.query;
        String valueOf = String.valueOf(com.tencent.mm.plugin.fts.a.e.wVn);
        p.h(str2, SearchIntents.EXTRA_QUERY);
        p.h(valueOf, "searchId");
        hVar.reset();
        hVar.xfQ = str2;
        hVar.xfT = valueOf;
        cge cge = new cge();
        cge.Mba = hVar.xfT;
        cge.KXA = str2;
        cge.MaY = ai.aft(0);
        cge.Scene = 74;
        cge.SessionId = String.valueOf(com.tencent.mm.plugin.fts.a.e.wVm);
        hVar.xfS = new com.tencent.mm.plugin.fts.ui.c.c(cge);
        g.azz().a(hVar.xfS, 0);
        CharSequence charSequence = null;
        if (d.ays(this.query)) {
            charSequence = com.tencent.mm.plugin.fts.a.f.a(getString(R.string.djc), "", com.tencent.mm.plugin.fts.a.a.e.c(this.query, this.query)).wWu;
        } else if (d.ayt(this.query)) {
            charSequence = com.tencent.mm.plugin.fts.a.f.a(getString(R.string.djd), "", com.tencent.mm.plugin.fts.a.a.e.c(this.query, this.query)).wWu;
        }
        this.xcb.setText(l.e((Context) getContext(), charSequence, com.tencent.mm.cb.a.aG(getContext(), R.dimen.is)));
        AppMethodBeat.o(112002);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final void stopSearch() {
        AppMethodBeat.i(112003);
        super.stopSearch();
        this.xch = 1;
        i iVar = this.xbV;
        iVar.dQc();
        iVar.dOG();
        iVar.clearData();
        iVar.dQd();
        this.xbU.reset();
        AppMethodBeat.o(112003);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
    public final void dPp() {
        AppMethodBeat.i(112004);
        super.dPp();
        i iVar = this.xbV;
        if (!iVar.xgE) {
            iVar.xgE = true;
            if (iVar.xgD == i.b.StartSearch) {
                Log.i("MicroMsg.FTS.PardusSearchLogic", "onTouchLV and cancel search");
                l.N(iVar.xbf, 10);
                iVar.cHi();
            }
        }
        AppMethodBeat.o(112004);
    }

    static /* synthetic */ void a(FTSMainUI fTSMainUI, String str) {
        AppMethodBeat.i(235393);
        fTSMainUI.xaQ.setCursorVisible(true);
        fTSMainUI.xaQ.setHint(fTSMainUI.getContext().getString(R.string.yn));
        if (!Util.isNullOrNil(str)) {
            com.tencent.mm.plugin.fts.ui.widget.b bVar = fTSMainUI.xbQ;
            bVar.xfp.setVisibility(8);
            bVar.hbv.setVisibility(8);
            bVar.xfq.setText("");
            AppMethodBeat.o(235393);
            return;
        }
        fTSMainUI.dPw();
        AppMethodBeat.o(235393);
    }

    static /* synthetic */ void ayN(String str) {
        AppMethodBeat.i(235394);
        f.a Dq = new f.a(MMApplicationContext.getContext()).bow(str).Dq(true);
        Dq.JnN = true;
        Dq.a(null, null).show();
        AppMethodBeat.o(235394);
    }

    static /* synthetic */ void g(FTSMainUI fTSMainUI) {
        AppMethodBeat.i(235396);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.FTSMainUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(111963);
                if (FTSMainUI.this.rAV != null) {
                    FTSMainUI.this.rAV.dismiss();
                    FTSMainUI.this.rAV = null;
                }
                AppMethodBeat.o(111963);
            }
        });
        AppMethodBeat.o(235396);
    }
}

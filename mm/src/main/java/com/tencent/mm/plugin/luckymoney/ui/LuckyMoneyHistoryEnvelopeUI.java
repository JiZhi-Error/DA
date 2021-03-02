package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LuckyMoneyHistoryEnvelopeUI extends MMActivity {
    private int UYb;
    private int UYc;
    private int UYd;
    private int UYe;
    private FrameLayout UYf;
    private RecyclerView UYg;
    private ArrayList<com.tencent.mm.view.recyclerview.a> UYh = new ArrayList<>();
    private List<String> UYi = new ArrayList();
    private int opk;
    private final float yZR = 1.656f;
    private WxRecyclerAdapter zdR;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyHistoryEnvelopeUI() {
        AppMethodBeat.i(258681);
        AppMethodBeat.o(258681);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(258682);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.BW_97));
        hideActionbarLine();
        setMMTitle(getString(R.string.jdp));
        this.opk = (com.tencent.mm.cb.a.jn(getContext()) - (com.tencent.mm.wallet_core.ui.noscale.a.axx(8) * 3)) / 2;
        this.UYb = this.opk - (com.tencent.mm.wallet_core.ui.noscale.a.axx(8) * 2);
        this.UYc = (int) (((float) this.UYb) * 1.656f);
        this.UYd = (int) (((float) this.UYb) * 1.38f);
        this.UYe = (int) (((float) this.UYb) / 2.9f);
        initView();
        Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "do get show source");
        final k eeZ = k.eeZ();
        final q a2 = h.a((Context) getContext(), 3, (int) R.style.lj, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(258661);
                eeZ.cancel();
                AppMethodBeat.o(258661);
            }
        });
        eeZ.b(new com.tencent.mm.plugin.luckymoney.model.d("", 2));
        eeZ.a(new a.AbstractC2168a<bvi>() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
            @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
            public final /* synthetic */ void d(bvi bvi, int i2, int i3) {
                AppMethodBeat.i(258662);
                bvi bvi2 = bvi;
                if (a2 != null && a2.isShowing()) {
                    a2.dismiss();
                }
                Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "do get show source net callback");
                if (i2 == 0 && i3 == 0 && bvi2 != null) {
                    Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "retcode: %s", Integer.valueOf(bvi2.dDN));
                    if (bvi2.dDN == 0) {
                        LuckyMoneyHistoryEnvelopeUI.this.UYi.addAll(bvi2.Mbv);
                        Iterator<cbe> it = bvi2.Mbs.iterator();
                        while (it.hasNext()) {
                            cbe next = it.next();
                            if (next.MgE == 1 || next.KTQ == 1 || bvi2.Mbv.contains(next.Lot)) {
                                a aVar = new a();
                                aVar.yXW = next;
                                LuckyMoneyHistoryEnvelopeUI.this.UYh.add(aVar);
                                LuckyMoneyHistoryEnvelopeUI.this.zdR.atj.notifyChanged();
                            }
                        }
                        if (!Util.isNullOrNil(bvi2.VjN)) {
                            c cVar = new c();
                            cVar.UYo = bvi2.VjN;
                            LuckyMoneyHistoryEnvelopeUI.this.UYh.add(cVar);
                            AppMethodBeat.o(258662);
                            return;
                        }
                    } else {
                        f.bpB(bvi2.qwn);
                    }
                    AppMethodBeat.o(258662);
                    return;
                }
                f.ar(LuckyMoneyHistoryEnvelopeUI.this.getContext(), "");
                AppMethodBeat.o(258662);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
            public final /* bridge */ /* synthetic */ void dx(bvi bvi) {
            }
        }, 0);
        AppMethodBeat.o(258682);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(258683);
        this.UYf = (FrameLayout) findViewById(R.id.k0t);
        this.UYg = (RecyclerView) findViewById(R.id.k0d);
        getContext();
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(2);
        gridLayoutManager.apR = new GridLayoutManager.b() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass1 */

            @Override // android.support.v7.widget.GridLayoutManager.b
            public final int bX(int i2) {
                AppMethodBeat.i(258660);
                if (LuckyMoneyHistoryEnvelopeUI.this.zdR.getItemViewType(i2) == 2) {
                    int i3 = gridLayoutManager.apM;
                    AppMethodBeat.o(258660);
                    return i3;
                }
                AppMethodBeat.o(258660);
                return 1;
            }
        };
        this.UYg.setLayoutManager(gridLayoutManager);
        this.zdR = new WxRecyclerAdapter(new com.tencent.mm.view.recyclerview.f() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass6 */

            @Override // com.tencent.mm.view.recyclerview.f
            public final e<?> EC(int i2) {
                AppMethodBeat.i(258665);
                if (i2 == 1) {
                    b bVar = new b();
                    AppMethodBeat.o(258665);
                    return bVar;
                }
                d dVar = new d();
                AppMethodBeat.o(258665);
                return dVar;
            }
        }, this.UYh, false);
        this.zdR.RqP = new g.c() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass7 */

            @Override // com.tencent.mm.view.recyclerview.g.c
            public final void a(RecyclerView.a aVar, View view, int i2, RecyclerView.v vVar) {
                AppMethodBeat.i(258666);
                Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "click envelope: %s", Integer.valueOf(i2));
                com.tencent.mm.view.recyclerview.a aVar2 = (com.tencent.mm.view.recyclerview.a) ((com.tencent.mm.view.recyclerview.h) vVar).Rra;
                if (aVar2 instanceof a) {
                    LuckyMoneyHistoryEnvelopeUI.a(LuckyMoneyHistoryEnvelopeUI.this, ((a) aVar2).yXW);
                }
                AppMethodBeat.o(258666);
            }
        };
        this.zdR.RqO = new g.d() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass8 */

            @Override // com.tencent.mm.view.recyclerview.g.d
            public final boolean b(RecyclerView.a aVar, View view, int i2, RecyclerView.v vVar) {
                AppMethodBeat.i(258667);
                Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "long click envelope: %s", Integer.valueOf(i2));
                com.tencent.mm.view.recyclerview.a aVar2 = (com.tencent.mm.view.recyclerview.a) ((com.tencent.mm.view.recyclerview.h) vVar).Rra;
                if (aVar2 instanceof a) {
                    LuckyMoneyHistoryEnvelopeUI.b(LuckyMoneyHistoryEnvelopeUI.this, ((a) aVar2).yXW);
                }
                AppMethodBeat.o(258667);
                return false;
            }
        };
        this.UYg.setAdapter(this.zdR);
        this.UYg.a(new RecyclerView.h() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass9 */
            private final int spacing = com.tencent.mm.wallet_core.ui.noscale.a.axx(4);

            {
                AppMethodBeat.i(258668);
                AppMethodBeat.o(258668);
            }

            @Override // android.support.v7.widget.RecyclerView.h
            public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                AppMethodBeat.i(258669);
                int ceil = (int) Math.ceil((double) (((float) LuckyMoneyHistoryEnvelopeUI.this.UYh.size()) / 2.0f));
                int bw = RecyclerView.bw(view);
                int ceil2 = (int) Math.ceil((double) (((float) (bw + 1)) / 2.0f));
                if (ceil2 == 0) {
                    rect.top = this.spacing * 2;
                    rect.bottom = this.spacing * 2;
                } else if (ceil2 == ceil) {
                    rect.top = this.spacing;
                    rect.bottom = this.spacing * 2;
                } else {
                    rect.top = this.spacing;
                    rect.bottom = this.spacing;
                }
                if (bw % 2 == 0) {
                    rect.left = this.spacing * 2;
                    rect.right = this.spacing;
                    AppMethodBeat.o(258669);
                    return;
                }
                rect.left = this.spacing;
                rect.right = this.spacing * 2;
                AppMethodBeat.o(258669);
            }
        });
        AppMethodBeat.o(258683);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(258684);
        super.onDestroy();
        AppMethodBeat.o(258684);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cg0;
    }

    class b extends e<a> {
        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(final com.tencent.mm.view.recyclerview.h hVar, a aVar, int i2, int i3, boolean z, List list) {
            AppMethodBeat.i(258679);
            a.b.a((ImageView) hVar.Mn(R.id.eo8), z.aTY(), 0.06f, false);
            hVar.e(R.id.eon, LuckyMoneyHistoryEnvelopeUI.this.getString(R.string.eso, new Object[]{l.e((Context) LuckyMoneyHistoryEnvelopeUI.this.getContext(), (CharSequence) z.aUa(), com.tencent.mm.cb.a.aG(LuckyMoneyHistoryEnvelopeUI.this.getContext(), R.dimen.ac))}));
            final cbe cbe = aVar.yXW;
            if (cbe.MgC != null) {
                a(hVar, cbe, false);
            }
            hVar.Mn(R.id.eoq).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(258674);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$EnvelopeConvertItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    b.this.a(hVar, cbe, true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$EnvelopeConvertItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(258674);
                }
            });
            if (cbe.iwy == 2) {
                hVar.Mn(R.id.eop).setVisibility(0);
                ((TextView) hVar.Mn(R.id.eop)).setTextSize(1, 11.0f);
            } else {
                hVar.Mn(R.id.eop).setVisibility(8);
            }
            hVar.e(R.id.eog, cbe.MgB);
            TextView textView = (TextView) hVar.Mn(R.id.k0l);
            if (cbe.KTQ == 1) {
                textView.setText(cbe.MgH);
            } else if (cbe.MgE == 1) {
                textView.setText(cbe.MgD);
            } else if (LuckyMoneyHistoryEnvelopeUI.this.UYi.contains(cbe.Lot)) {
                textView.setText(R.string.eos);
            }
            String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
            if (loadApplicationLanguage == null || loadApplicationLanguage.length() <= 0 || (!loadApplicationLanguage.equals(LocaleUtil.CHINA) && !loadApplicationLanguage.equals(LocaleUtil.TAIWAN) && !loadApplicationLanguage.equals(LocaleUtil.HONGKONG))) {
                hVar.Mn(R.id.eoh).setBackgroundResource(R.drawable.ckc);
                hVar.nm(R.id.eoh, R.string.er0);
            }
            AppMethodBeat.o(258679);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.cfz;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
            AppMethodBeat.i(258677);
            ViewGroup.LayoutParams layoutParams = hVar.aus.getLayoutParams();
            layoutParams.width = LuckyMoneyHistoryEnvelopeUI.this.opk;
            hVar.aus.setLayoutParams(layoutParams);
            int axx = com.tencent.mm.wallet_core.ui.noscale.a.axx(8);
            hVar.aus.setPadding(axx, axx, axx, axx);
            ViewGroup.LayoutParams layoutParams2 = hVar.Mn(R.id.eoi).getLayoutParams();
            layoutParams2.width = LuckyMoneyHistoryEnvelopeUI.this.UYb;
            layoutParams2.height = LuckyMoneyHistoryEnvelopeUI.this.UYc;
            hVar.Mn(R.id.eoi).setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = hVar.Mn(R.id.eod).getLayoutParams();
            layoutParams3.width = LuckyMoneyHistoryEnvelopeUI.this.UYb;
            layoutParams3.height = LuckyMoneyHistoryEnvelopeUI.this.UYc;
            hVar.Mn(R.id.eod).setLayoutParams(layoutParams3);
            ViewGroup.LayoutParams layoutParams4 = hVar.Mn(R.id.eoj).getLayoutParams();
            layoutParams4.width = LuckyMoneyHistoryEnvelopeUI.this.UYb;
            layoutParams4.height = LuckyMoneyHistoryEnvelopeUI.this.UYd;
            hVar.Mn(R.id.eoj).setLayoutParams(layoutParams4);
            ViewGroup.LayoutParams layoutParams5 = hVar.Mn(R.id.eoh).getLayoutParams();
            layoutParams5.width = LuckyMoneyHistoryEnvelopeUI.this.UYe;
            layoutParams5.height = LuckyMoneyHistoryEnvelopeUI.this.UYe;
            hVar.Mn(R.id.eoh).setLayoutParams(layoutParams5);
            AppMethodBeat.o(258677);
        }

        /* access modifiers changed from: package-private */
        public final void a(final com.tencent.mm.view.recyclerview.h hVar, final cbe cbe, boolean z) {
            AppMethodBeat.i(258678);
            if (z) {
                hVar.Mn(R.id.eom).setVisibility(8);
                hVar.Mn(R.id.eo7).setVisibility(0);
                hVar.Mn(R.id.eoo).setVisibility(8);
            } else {
                hVar.Mn(R.id.eol).setVisibility(0);
            }
            ((com.tencent.mm.plugin.luckymoney.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a((ImageView) hVar.Mn(R.id.eod), cbe, new a.AbstractC1465a() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.b.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.luckymoney.a.a.AbstractC1465a
                public final void ei(final boolean z) {
                    AppMethodBeat.i(258676);
                    Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "load ok: %s", Boolean.valueOf(z));
                    AnonymousClass1 r0 = new Runnable() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.b.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(258675);
                            hVar.Mn(R.id.eol).setVisibility(8);
                            if (cbe.MgE == 1 || cbe.KTQ == 1) {
                                Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "envelope has expired do nothing");
                                AppMethodBeat.o(258675);
                            } else if (!z) {
                                hVar.Mn(R.id.eoq).setVisibility(0);
                                hVar.Mn(R.id.eom).setVisibility(0);
                                hVar.Mn(R.id.eo7).setVisibility(8);
                                hVar.Mn(R.id.eoo).setVisibility(0);
                                AppMethodBeat.o(258675);
                            } else {
                                hVar.Mn(R.id.eoq).setVisibility(8);
                                AppMethodBeat.o(258675);
                            }
                        }
                    };
                    if (MMHandlerThread.isMainThread()) {
                        r0.run();
                        AppMethodBeat.o(258676);
                        return;
                    }
                    hVar.Mn(R.id.eoq).post(r0);
                    AppMethodBeat.o(258676);
                }
            });
            AppMethodBeat.o(258678);
        }
    }

    class d extends e<c> {
        d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, c cVar, int i2, int i3, boolean z, List list) {
            AppMethodBeat.i(258680);
            hVar.e(R.id.jzu, cVar.UYo);
            AppMethodBeat.o(258680);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.cg1;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements com.tencent.mm.view.recyclerview.a {
        public cbe yXW;

        a() {
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            AppMethodBeat.i(258673);
            long hashCode = (long) this.yXW.Lot.hashCode();
            AppMethodBeat.o(258673);
            return hashCode;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 1;
        }
    }

    class c implements com.tencent.mm.view.recyclerview.a {
        public String UYo;

        c() {
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            return 0;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 2;
        }
    }

    static /* synthetic */ void a(LuckyMoneyHistoryEnvelopeUI luckyMoneyHistoryEnvelopeUI, cbe cbe) {
        int color;
        AppMethodBeat.i(258685);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(luckyMoneyHistoryEnvelopeUI.getContext()).inflate(R.layout.b4b, (ViewGroup) luckyMoneyHistoryEnvelopeUI.UYf, false);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.f47);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.f3z);
        ImageView imageView2 = (ImageView) viewGroup.findViewById(R.id.f4e);
        Button button = (Button) viewGroup.findViewById(R.id.f4f);
        viewGroup.setClickable(true);
        ((TextView) viewGroup.findViewById(R.id.f4b)).setText(R.string.eof);
        ((TextView) viewGroup.findViewById(R.id.f46)).setText(luckyMoneyHistoryEnvelopeUI.getString(R.string.eso, new Object[]{l.e((Context) luckyMoneyHistoryEnvelopeUI.getContext(), (CharSequence) z.aUa(), com.tencent.mm.cb.a.aG(luckyMoneyHistoryEnvelopeUI.getContext(), R.dimen.ab1))}));
        a.b.a((ImageView) viewGroup.findViewById(R.id.f45), z.aTY(), 0.06f, false);
        ((ViewGroup) viewGroup.findViewById(R.id.f4d)).setVisibility(8);
        imageView.setVisibility(0);
        ((com.tencent.mm.plugin.luckymoney.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(imageView, cbe, null);
        button.setClickable(false);
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
        if (loadApplicationLanguage == null || loadApplicationLanguage.length() <= 0 || (!loadApplicationLanguage.equals(LocaleUtil.CHINA) && !loadApplicationLanguage.equals(LocaleUtil.TAIWAN) && !loadApplicationLanguage.equals(LocaleUtil.HONGKONG))) {
            button.setBackgroundResource(R.drawable.ckc);
            button.setText(R.string.er0);
        } else {
            button.setBackgroundResource(R.drawable.c97);
        }
        if (ao.isDarkMode()) {
            color = luckyMoneyHistoryEnvelopeUI.getResources().getColor(R.color.BW_0_Alpha_0_8);
            viewGroup.setBackgroundResource(R.color.BW_0_Alpha_0_8);
        } else {
            color = luckyMoneyHistoryEnvelopeUI.getResources().getColor(R.color.yr);
            viewGroup.setBackgroundResource(R.color.yr);
        }
        final i iVar = new i(luckyMoneyHistoryEnvelopeUI.getContext(), R.style.a87);
        iVar.setContentView(viewGroup);
        iVar.getWindow().setLayout(-1, -1);
        iVar.getWindow().getDecorView().setSystemUiVisibility(iVar.getWindow().getDecorView().getWindowSystemUiVisibility() | 1024);
        iVar.getWindow().setStatusBarColor(color);
        iVar.setOnShowListener(new DialogInterface.OnShowListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass4 */

            public final void onShow(DialogInterface dialogInterface) {
                int i2;
                AppMethodBeat.i(258663);
                if (Build.VERSION.SDK_INT >= 23) {
                    View decorView = iVar.getWindow().getDecorView();
                    int systemUiVisibility = decorView.getSystemUiVisibility();
                    if (ao.isDarkMode()) {
                        i2 = systemUiVisibility & -8193;
                    } else {
                        i2 = systemUiVisibility | 8192;
                    }
                    decorView.setSystemUiVisibility(i2);
                }
                AppMethodBeat.o(258663);
            }
        });
        iVar.show();
        af.eo(viewGroup2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(258664);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                iVar.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(258664);
            }
        });
        AppMethodBeat.o(258685);
    }

    static /* synthetic */ void b(LuckyMoneyHistoryEnvelopeUI luckyMoneyHistoryEnvelopeUI, final cbe cbe) {
        AppMethodBeat.i(258686);
        if (cbe != null) {
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(cbe.Lot)) {
                Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "can not delete default envelope");
                AppMethodBeat.o(258686);
                return;
            }
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) luckyMoneyHistoryEnvelopeUI.getContext(), 1, true);
            TextView textView = new TextView(luckyMoneyHistoryEnvelopeUI.getContext());
            textView.setPadding(0, 0, 0, com.tencent.mm.cb.a.fromDPToPix((Context) luckyMoneyHistoryEnvelopeUI.getContext(), 9));
            textView.setMinHeight(com.tencent.mm.cb.a.aG(luckyMoneyHistoryEnvelopeUI.getContext(), R.dimen.x));
            textView.setTextSize(14.0f);
            textView.setTextColor(luckyMoneyHistoryEnvelopeUI.getResources().getColor(R.color.u_));
            textView.setText(R.string.er6);
            textView.setGravity(81);
            eVar.V(textView, true);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass10 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(258670);
                    mVar.a(0, LuckyMoneyHistoryEnvelopeUI.this.getResources().getColor(R.color.Red), LuckyMoneyHistoryEnvelopeUI.this.getString(R.string.er5));
                    AppMethodBeat.o(258670);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass11 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(258671);
                    if (menuItem.getItemId() == 0) {
                        LuckyMoneyHistoryEnvelopeUI.a(LuckyMoneyHistoryEnvelopeUI.this, cbe.Lot);
                    }
                    AppMethodBeat.o(258671);
                }
            };
            eVar.dGm();
        }
        AppMethodBeat.o(258686);
    }

    static /* synthetic */ void a(LuckyMoneyHistoryEnvelopeUI luckyMoneyHistoryEnvelopeUI, final String str) {
        AppMethodBeat.i(258687);
        Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "do delete show source: %s", str);
        final q a2 = h.a((Context) luckyMoneyHistoryEnvelopeUI.getContext(), 3, (int) R.style.lj, luckyMoneyHistoryEnvelopeUI.getString(R.string.ekc), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass12 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        new com.tencent.mm.plugin.luckymoney.model.c(str).aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<adg>>() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.AnonymousClass13 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<adg> aVar) {
                AppMethodBeat.i(258672);
                c.a<adg> aVar2 = aVar;
                Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "do confirm errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                if (a2 != null) {
                    a2.dismiss();
                }
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    Log.i("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "retcode: %s", Integer.valueOf(((adg) aVar2.iLC).dDN));
                    if (((adg) aVar2.iLC).dDN == 0) {
                        int b2 = LuckyMoneyHistoryEnvelopeUI.b(LuckyMoneyHistoryEnvelopeUI.this, str);
                        if (b2 >= 0) {
                            LuckyMoneyHistoryEnvelopeUI.this.zdR.ck(b2);
                        }
                    } else if (!Util.isNullOrNil(((adg) aVar2.iLC).qwn)) {
                        f.cP(LuckyMoneyHistoryEnvelopeUI.this.getContext(), ((adg) aVar2.iLC).qwn);
                    }
                } else {
                    f.ar(LuckyMoneyHistoryEnvelopeUI.this.getContext(), aVar2.errMsg);
                }
                AppMethodBeat.o(258672);
                return null;
            }
        });
        AppMethodBeat.o(258687);
    }

    static /* synthetic */ int b(LuckyMoneyHistoryEnvelopeUI luckyMoneyHistoryEnvelopeUI, String str) {
        int i2;
        AppMethodBeat.i(258688);
        int i3 = 0;
        Iterator<com.tencent.mm.view.recyclerview.a> it = luckyMoneyHistoryEnvelopeUI.UYh.iterator();
        while (true) {
            i2 = i3;
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            com.tencent.mm.view.recyclerview.a next = it.next();
            if ((next instanceof a) && ((a) next).yXW.Lot.equals(str)) {
                luckyMoneyHistoryEnvelopeUI.UYh.remove(next);
                break;
            }
            i3 = i2 + 1;
        }
        AppMethodBeat.o(258688);
        return i2;
    }
}

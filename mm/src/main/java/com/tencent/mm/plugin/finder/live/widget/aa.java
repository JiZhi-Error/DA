package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "avatar", "Landroid/widget/ImageView;", "group", "Landroid/widget/RelativeLayout;", "hangupBtn", "Landroid/view/View;", "lastContentRect", "Landroid/graphics/Rect;", "linkLeftGroup", "linkingTip", "Landroid/widget/TextView;", "miniAnchorOptGroup", "Landroid/widget/LinearLayout;", "miniAnchorOptLuckyMoney", "miniAnchorOptSwitch", "nickname", "widgetRoot", "fillContent", "", "goToFinderProfileImpl", "hideLinkMicBottomBar", "showLinkMicBottomBar", "contentRect", "updateLinkMicBottomBar", "Companion", "plugin-finder_release"})
public final class aa extends z {
    private static final String TAG = TAG;
    public static final a USh = new a((byte) 0);
    private final RelativeLayout URO;
    private final View URS;
    private final View USd;
    private final LinearLayout USe;
    private final View USf;
    private final View USg;
    private final ImageView keC;
    private final Rect lastContentRect = new Rect();
    private final View unm;
    private final TextView uuB;
    private final TextView uuC;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aa(final ViewGroup viewGroup, final d dVar) {
        super(viewGroup, dVar);
        p.h(viewGroup, "root");
        p.h(dVar, "basePlugin");
        AppMethodBeat.i(261217);
        View inflate = View.inflate(viewGroup.getContext(), R.layout.cf6, null);
        p.g(inflate, "View.inflate(root.contex…c_bottom_widget_ui, null)");
        this.URS = inflate;
        this.URO = new RelativeLayout(viewGroup.getContext());
        View findViewById = this.URS.findViewById(R.id.jyx);
        p.g(findViewById, "widgetRoot.findViewById(…o_link_bottom_bar_avatar)");
        this.keC = (ImageView) findViewById;
        View findViewById2 = this.URS.findViewById(R.id.cym);
        p.g(findViewById2, "widgetRoot.findViewById(…deo_link_bottom_bar_name)");
        this.uuB = (TextView) findViewById2;
        View findViewById3 = this.URS.findViewById(R.id.cyk);
        p.g(findViewById3, "widgetRoot.findViewById(…_bottom_bar_hangup_group)");
        this.unm = findViewById3;
        View findViewById4 = this.URS.findViewById(R.id.cyl);
        p.g(findViewById4, "widgetRoot.findViewById(…k_bottom_bar_linking_tip)");
        this.uuC = (TextView) findViewById4;
        View findViewById5 = this.URS.findViewById(R.id.jyz);
        p.g(findViewById5, "widgetRoot.findViewById(…nk_bottom_bar_left_group)");
        this.USd = findViewById5;
        View findViewById6 = this.URS.findViewById(R.id.k31);
        p.g(findViewById6, "widgetRoot.findViewById(…ar_mini_anchor_opt_group)");
        this.USe = (LinearLayout) findViewById6;
        View findViewById7 = this.URS.findViewById(R.id.k32);
        p.g(findViewById7, "widgetRoot.findViewById(…i_anchor_opt_lucky_money)");
        this.USf = findViewById7;
        View findViewById8 = this.URS.findViewById(R.id.k34);
        p.g(findViewById8, "widgetRoot.findViewById(…anchor_opt_switch_camera)");
        this.USg = findViewById8;
        View view = this.unm;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.finder.live.widget.aa.AnonymousClass1 */
                final /* synthetic */ aa USi;

                {
                    this.USi = r1;
                }

                public final void onClick(View view) {
                    String str;
                    AppMethodBeat.i(261207);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (dVar.umc.getLiveRole() == 0) {
                        m mVar = m.vli;
                        m.ou(true);
                    }
                    Bundle bundle = new Bundle();
                    e eVar = this.USi.USa;
                    if (eVar != null) {
                        str = eVar.sessionId;
                    } else {
                        str = null;
                    }
                    bundle.putString("PARAM_FINDER_LIVE_MIC_ID", str);
                    dVar.umc.statusChange(b.c.hNP, bundle);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(261207);
                }
            });
        }
        this.keC.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.aa.AnonymousClass2 */
            final /* synthetic */ aa USi;

            {
                this.USi = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(261208);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e eVar = this.USi.USa;
                if (eVar != null && eVar.UPN) {
                    aa.e(this.USi);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(261208);
            }
        });
        View view2 = this.USf;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.finder.live.widget.aa.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(261209);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.kernel.e aAh = g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    Object obj = aAh.azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0);
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(261209);
                        throw tVar;
                    }
                    int intValue = ((Integer) obj).intValue();
                    if (intValue != 0 && intValue != 1) {
                        Context context = viewGroup.getContext();
                        Context context2 = viewGroup.getContext();
                        p.g(context2, "root.context");
                        u.makeText(context, context2.getResources().getString(R.string.jao), 0).show();
                    } else if (viewGroup.getContext() instanceof Activity) {
                        o oVar = o.ujN;
                        s finderLiveAssistant = o.getFinderLiveAssistant();
                        if (finderLiveAssistant != null) {
                            Context context3 = viewGroup.getContext();
                            if (context3 == null) {
                                t tVar2 = new t("null cannot be cast to non-null type android.app.Activity");
                                AppMethodBeat.o(261209);
                                throw tVar2;
                            }
                            finderLiveAssistant.bC((Activity) context3);
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(261209);
                }
            });
        }
        View view3 = this.USg;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.finder.live.widget.aa.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(261210);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    b.C0376b.a(dVar.umc, b.c.hLE);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(261210);
                }
            });
            AppMethodBeat.o(261217);
            return;
        }
        AppMethodBeat.o(261217);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(261218);
        AppMethodBeat.o(261218);
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void x(Rect rect) {
        AppMethodBeat.i(261214);
        p.h(rect, "contentRect");
        com.tencent.mm.ac.d.h(new c(this, rect));
        AppMethodBeat.o(261214);
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void hTE() {
        AppMethodBeat.i(261215);
        com.tencent.mm.ac.d.h(new b(this));
        AppMethodBeat.o(261215);
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void y(Rect rect) {
        AppMethodBeat.i(261216);
        p.h(rect, "contentRect");
        if (p.j(this.lastContentRect, rect)) {
            Log.i(TAG, "skip updateLinkMicBottomBar, lastContentRect == contentRect. lastContentRect:" + this.lastContentRect + " contentRect:" + rect);
            AppMethodBeat.o(261216);
            return;
        }
        Log.i(TAG, "updateLinkMicBottomBar contentRect:".concat(String.valueOf(rect)));
        this.lastContentRect.set(rect);
        this.URO.setTranslationX((float) rect.left);
        this.URO.setTranslationY((float) rect.top);
        ViewGroup.LayoutParams layoutParams = this.URO.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = rect.width();
            layoutParams.height = rect.height();
            this.URO.requestLayout();
            AppMethodBeat.o(261216);
            return;
        }
        AppMethodBeat.o(261216);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ aa USi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(aa aaVar) {
            super(0);
            this.USi = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(261211);
            this.USi.hwr.removeView(this.USi.URO);
            x xVar = x.SXb;
            AppMethodBeat.o(261211);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Rect URQ;
        final /* synthetic */ aa USi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(aa aaVar, Rect rect) {
            super(0);
            this.USi = aaVar;
            this.URQ = rect;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            AppMethodBeat.i(261213);
            a aVar = aa.USh;
            Log.i(aa.TAG, "showLinkMicBottomBar contentRect:" + this.URQ + " bindMicUser:" + this.USi.USa);
            this.USi.lastContentRect.set(this.URQ);
            aa.b(this.USi);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.URQ.width(), this.URQ.height());
            ViewParent parent = this.USi.URO.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(this.USi.URO);
            }
            this.USi.URO.setTranslationX((float) this.URQ.left);
            this.USi.URO.setTranslationY((float) this.URQ.top);
            this.USi.hwr.addView(this.USi.URO, layoutParams);
            ViewParent parent2 = this.USi.URS.getParent();
            if (!(parent2 instanceof ViewGroup)) {
                parent2 = null;
            }
            ViewGroup viewGroup2 = (ViewGroup) parent2;
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.USi.URS);
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.URQ.width(), -2);
            layoutParams2.addRule(12);
            this.USi.URO.addView(this.USi.URS, layoutParams2);
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
                String djq = this.USi.uFw.getLiveData().djq();
                e eVar = this.USi.USa;
                if (eVar != null) {
                    str = eVar.uCo;
                } else {
                    str = null;
                }
                if (Util.isEqual(djq, str)) {
                    this.USi.URO.setClickable(false);
                    this.USi.URO.setOnClickListener(null);
                    x xVar = x.SXb;
                    AppMethodBeat.o(261213);
                    return xVar;
                }
            }
            this.USi.URO.setClickable(false);
            this.USi.URO.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.finder.live.widget.aa.c.AnonymousClass1 */
                final /* synthetic */ c USj;

                {
                    this.USj = r1;
                }

                public final void onClick(View view) {
                    String str;
                    AppMethodBeat.i(261212);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$showLinkMicBottomBar$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                    if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                        a aVar = aa.USh;
                        Log.i(aa.TAG, "click rect area but i am anchor, skipped");
                    } else {
                        String djq = this.USj.USi.uFw.getLiveData().djq();
                        e eVar = this.USj.USi.USa;
                        if (eVar != null) {
                            str = eVar.uCo;
                        } else {
                            str = null;
                        }
                        if (Util.isEqual(djq, str)) {
                            a aVar2 = aa.USh;
                            Log.i(aa.TAG, "click rect area but is myself, skipped");
                        } else {
                            this.USj.USi.hUr();
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$showLinkMicBottomBar$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(261212);
                }
            });
            x xVar2 = x.SXb;
            AppMethodBeat.o(261213);
            return xVar2;
        }
    }

    public static final /* synthetic */ void b(aa aaVar) {
        AppMethodBeat.i(261219);
        e eVar = aaVar.USa;
        if (eVar != null) {
            if (Util.isEqual(aaVar.uFw.getLiveData().djq(), eVar.uCo)) {
                aaVar.uuC.setVisibility(8);
                aaVar.unm.setVisibility(0);
            } else {
                aaVar.uuC.setVisibility(0);
                aaVar.unm.setVisibility(8);
            }
            if (Util.isEqual(aaVar.uFw.getLiveData().djq(), eVar.uCo)) {
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
                    aaVar.USe.setVisibility(0);
                    aaVar.USd.setVisibility(8);
                    if (!aaVar.uFw.getLiveData().hTX() || aaVar.uFw.getLiveData().UQh.LFy != 1) {
                        aaVar.USf.setVisibility(8);
                        AppMethodBeat.o(261219);
                        return;
                    }
                    aaVar.USf.setVisibility(0);
                    AppMethodBeat.o(261219);
                    return;
                }
            }
            aaVar.USe.setVisibility(8);
            aaVar.USd.setVisibility(0);
            if (eVar.UPN) {
                aaVar.keC.setVisibility(0);
                com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
                com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(eVar.headUrl);
                ImageView imageView = aaVar.keC;
                com.tencent.mm.plugin.finder.loader.m mVar3 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dka.a(aVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
            } else if (as.bjt(eVar.username)) {
                aaVar.keC.setVisibility(0);
                com.tencent.mm.plugin.finder.loader.m mVar4 = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka2 = com.tencent.mm.plugin.finder.loader.m.dka();
                com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(eVar.headUrl);
                ImageView imageView2 = aaVar.keC;
                com.tencent.mm.plugin.finder.loader.m mVar5 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dka2.a(aVar2, imageView2, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
            } else {
                aaVar.keC.setVisibility(0);
                com.tencent.mm.plugin.finder.loader.m mVar6 = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dkb = com.tencent.mm.plugin.finder.loader.m.dkb();
                com.tencent.mm.plugin.finder.loader.a aVar3 = new com.tencent.mm.plugin.finder.loader.a(eVar.headUrl);
                ImageView imageView3 = aaVar.keC;
                com.tencent.mm.plugin.finder.loader.m mVar7 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dkb.a(aVar3, imageView3, com.tencent.mm.plugin.finder.loader.m.a(m.a.WX_AVATAR));
            }
            TextView textView = aaVar.uuB;
            com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
            TextView textView2 = aaVar.uuB;
            y yVar = y.vXH;
            textView.setText(com.tencent.mm.plugin.finder.convert.d.e(textView2, y.hf(eVar.username, eVar.nickname)));
            AppMethodBeat.o(261219);
            return;
        }
        AppMethodBeat.o(261219);
    }

    public static final /* synthetic */ void e(aa aaVar) {
        boolean z;
        AppMethodBeat.i(261220);
        Log.i(TAG, "goToFinderProfileImpl bindLinkMicUser:" + aaVar.USa);
        e eVar = aaVar.USa;
        if (eVar != null) {
            String str = eVar.username;
            if (str == null || str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Intent intent = new Intent();
                intent.putExtra("key_from_profile_share_scene", 0);
                intent.putExtra("finder_username", eVar.username);
                intent.putExtra("key_enter_profile_type", 11);
                bbn bbn = aaVar.uFw.reportObj;
                if (bbn != null) {
                    String str2 = bbn.sGQ;
                    String str3 = bbn.sGE;
                    if (!TextUtils.isEmpty(str2)) {
                        intent.putExtra("key_context_id", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        intent.putExtra("key_click_tab_context_id", str3);
                    }
                }
                ((aj) g.ah(aj.class)).enterFinderProfileUI(aaVar.hwr.getContext(), intent);
            }
            AppMethodBeat.o(261220);
            return;
        }
        AppMethodBeat.o(261220);
    }
}

package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "bottomGroup", "Landroid/view/View;", "group", "Landroid/widget/RelativeLayout;", "hungupBtn", "lastContentRect", "Landroid/graphics/Rect;", "luckyMoney", "widgetRoot", "fillContent", "", "hideLinkMicBottomBar", "releaseContent", "showLinkMicBottomBar", "contentRect", "updateLinkMicBottomBar", "plugin-finder_release"})
public final class y extends z {
    private final String TAG = "Finder.FinderLiveMicAudioStateWidget";
    private final RelativeLayout URO;
    private final View URS;
    private final View URU;
    private final View URV;
    private final View URW;
    private final Rect lastContentRect;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(final ViewGroup viewGroup, final d dVar) {
        super(viewGroup, dVar);
        p.h(viewGroup, "root");
        p.h(dVar, "basePlugin");
        AppMethodBeat.i(261201);
        this.URO = new RelativeLayout(viewGroup.getContext());
        this.lastContentRect = new Rect();
        View inflate = View.inflate(viewGroup.getContext(), R.layout.cf4, null);
        p.g(inflate, "View.inflate(root.contex…ic_audio_bottom_ui, null)");
        this.URS = inflate;
        View findViewById = this.URS.findViewById(R.id.jy_);
        p.g(findViewById, "widgetRoot.findViewById(…state_audio_hungup_group)");
        this.URU = findViewById;
        View findViewById2 = this.URS.findViewById(R.id.jya);
        p.g(findViewById2, "widgetRoot.findViewById(…_audio_lucky_money_group)");
        this.URV = findViewById2;
        View findViewById3 = this.URS.findViewById(R.id.jy8);
        p.g(findViewById3, "widgetRoot.findViewById(…state_audio_bottom_group)");
        this.URW = findViewById3;
        this.URU.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.y.AnonymousClass1 */
            final /* synthetic */ y URX;

            {
                this.URX = r1;
            }

            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(261193);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Bundle bundle = new Bundle();
                e eVar = this.URX.USa;
                if (eVar != null) {
                    str = eVar.sessionId;
                } else {
                    str = null;
                }
                bundle.putString("PARAM_FINDER_LIVE_MIC_ID", str);
                dVar.umc.statusChange(b.c.hNP, bundle);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(261193);
            }
        });
        this.URV.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.finder.live.widget.y.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(261194);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.kernel.e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                Object obj = aAh.azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0);
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(261194);
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
                            AppMethodBeat.o(261194);
                            throw tVar2;
                        }
                        finderLiveAssistant.bC((Activity) context3);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(261194);
            }
        });
        AppMethodBeat.o(261201);
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void x(Rect rect) {
        AppMethodBeat.i(261198);
        p.h(rect, "contentRect");
        com.tencent.mm.ac.d.h(new b(this, rect));
        AppMethodBeat.o(261198);
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void hTE() {
        AppMethodBeat.i(261199);
        com.tencent.mm.ac.d.h(new a(this));
        AppMethodBeat.o(261199);
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void y(Rect rect) {
        AppMethodBeat.i(261200);
        p.h(rect, "contentRect");
        if (p.j(this.lastContentRect, rect)) {
            Log.i(this.TAG, "skip updateLinkMicBottomBar, lastContentRect == contentRect. lastContentRect:" + this.lastContentRect + " contentRect:" + rect);
            AppMethodBeat.o(261200);
            return;
        }
        Log.i(this.TAG, "updateLinkMicBottomBar contentRect:".concat(String.valueOf(rect)));
        this.lastContentRect.set(rect);
        this.URO.setTranslationX((float) rect.left);
        this.URO.setTranslationY((float) rect.top);
        ViewGroup.LayoutParams layoutParams = this.URO.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = rect.width();
            layoutParams.height = rect.height();
            this.URO.requestLayout();
            AppMethodBeat.o(261200);
            return;
        }
        AppMethodBeat.o(261200);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ y URX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(y yVar) {
            super(0);
            this.URX = yVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(261195);
            y.f(this.URX);
            x xVar = x.SXb;
            AppMethodBeat.o(261195);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Rect URQ;
        final /* synthetic */ y URX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(y yVar, Rect rect) {
            super(0);
            this.URX = yVar;
            this.URQ = rect;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            AppMethodBeat.i(261197);
            Log.i(this.URX.TAG, "showLinkMicBottomBar contentRect:" + this.URQ + " bindMicUser:" + this.URX.USa);
            this.URX.lastContentRect.set(this.URQ);
            y.c(this.URX);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.URQ.width(), this.URQ.height());
            ViewParent parent = this.URX.URO.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(this.URX.URO);
            }
            this.URX.URO.setTranslationX((float) this.URQ.left);
            this.URX.URO.setTranslationY((float) this.URQ.top);
            this.URX.hwr.addView(this.URX.URO, layoutParams);
            ViewParent parent2 = this.URX.URS.getParent();
            if (!(parent2 instanceof ViewGroup)) {
                parent2 = null;
            }
            ViewGroup viewGroup2 = (ViewGroup) parent2;
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.URX.URS);
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.URQ.width(), -2);
            layoutParams2.bottomMargin = at.fromDPToPix(this.URX.hwr.getContext(), 8);
            layoutParams2.addRule(12);
            this.URX.URS.setLayoutParams(layoutParams2);
            this.URX.URO.addView(this.URX.URS);
            m mVar = m.vVH;
            if (!m.dBP()) {
                String djq = this.URX.uFw.getLiveData().djq();
                e eVar = this.URX.USa;
                if (eVar != null) {
                    str = eVar.uCo;
                } else {
                    str = null;
                }
                if (Util.isEqual(djq, str)) {
                    this.URX.URO.setClickable(false);
                    this.URX.URO.setOnClickListener(null);
                    x xVar = x.SXb;
                    AppMethodBeat.o(261197);
                    return xVar;
                }
            }
            this.URX.URO.setClickable(true);
            this.URX.URO.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.finder.live.widget.y.b.AnonymousClass1 */
                final /* synthetic */ b URZ;

                {
                    this.URZ = r1;
                }

                public final void onClick(View view) {
                    String str;
                    AppMethodBeat.i(261196);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget$showLinkMicBottomBar$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    m mVar = m.vVH;
                    if (m.dBP()) {
                        Log.i(this.URZ.URX.TAG, "click rect area but i am anchor, skipped");
                    } else {
                        String djq = this.URZ.URX.uFw.getLiveData().djq();
                        e eVar = this.URZ.URX.USa;
                        if (eVar != null) {
                            str = eVar.uCo;
                        } else {
                            str = null;
                        }
                        if (Util.isEqual(djq, str)) {
                            Log.i(this.URZ.URX.TAG, "click rect area but is myself, skipped");
                        } else {
                            this.URZ.URX.hUr();
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget$showLinkMicBottomBar$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(261196);
                }
            });
            x xVar2 = x.SXb;
            AppMethodBeat.o(261197);
            return xVar2;
        }
    }

    public static final /* synthetic */ void c(y yVar) {
        AppMethodBeat.i(261202);
        e eVar = yVar.USa;
        if (eVar != null) {
            if (!yVar.uFw.getLiveData().hTX() || yVar.uFw.getLiveData().UQh.LFy != 1) {
                yVar.URV.setVisibility(8);
            } else {
                yVar.URV.setVisibility(0);
            }
            if (Util.isEqual(eVar.uCo, yVar.uFw.getLiveData().djq())) {
                yVar.URW.setVisibility(0);
                AppMethodBeat.o(261202);
                return;
            }
            yVar.URW.setVisibility(8);
            AppMethodBeat.o(261202);
            return;
        }
        AppMethodBeat.o(261202);
    }

    public static final /* synthetic */ void f(y yVar) {
        AppMethodBeat.i(261203);
        yVar.hwr.removeView(yVar.URO);
        AppMethodBeat.o(261203);
    }
}

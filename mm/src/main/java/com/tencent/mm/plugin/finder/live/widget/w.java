package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicAnchorHolderWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "group", "Landroid/widget/RelativeLayout;", "lastContentRect", "Landroid/graphics/Rect;", "fillContent", "", "hideLinkMicBottomBar", "prepareMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "releaseContent", "showLinkMicBottomBar", "contentRect", "updateLinkMicBottomBar", "plugin-finder_release"})
public final class w extends z {
    private final String TAG = "Finder.FinderLiveMicAnchorHolderWidget";
    private final RelativeLayout URO;
    private final Rect lastContentRect;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(ViewGroup viewGroup, d dVar) {
        super(viewGroup, dVar);
        p.h(viewGroup, "root");
        p.h(dVar, "basePlugin");
        AppMethodBeat.i(261183);
        this.URO = new RelativeLayout(viewGroup.getContext());
        this.lastContentRect = new Rect();
        AppMethodBeat.o(261183);
    }

    public static final /* synthetic */ void hUq() {
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void b(m mVar) {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(261179);
        p.h(mVar, "menu");
        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (!com.tencent.mm.plugin.finder.utils.m.dBP() && this.uFw.getLiveData().dja()) {
            Context context = this.hwr.getContext();
            p.g(context, "root.context");
            SpannableStringBuilder append = new SpannableStringBuilder(context.getResources().getString(R.string.j_s)).append('\"');
            Context context2 = this.hwr.getContext();
            e eVar = this.USa;
            SpannableStringBuilder append2 = append.append((CharSequence) com.tencent.mm.pluginsdk.ui.span.l.c(context2, (eVar == null || (str3 = eVar.nickname) == null) ? "" : str3)).append('\"');
            p.g(append2, "SpannableStringBuilder(r…kname ?: \"\")).append('\"')");
            mVar.d(0, append2);
        }
        Context context3 = this.hwr.getContext();
        p.g(context3, "root.context");
        SpannableStringBuilder append3 = new SpannableStringBuilder(context3.getResources().getString(R.string.jb4)).append('\"');
        Context context4 = this.hwr.getContext();
        e eVar2 = this.USa;
        if (eVar2 != null && (str2 = eVar2.nickname) != null) {
            str = str2;
        }
        SpannableStringBuilder append4 = append3.append((CharSequence) com.tencent.mm.pluginsdk.ui.span.l.c(context4, str)).append('\"');
        Context context5 = this.hwr.getContext();
        p.g(context5, "root.context");
        SpannableStringBuilder append5 = append4.append((CharSequence) context5.getResources().getString(R.string.jb3));
        p.g(append5, "SpannableStringBuilder(r…_mic_goto_profile_after))");
        mVar.d(1, append5);
        Context context6 = this.hwr.getContext();
        p.g(context6, "root.context");
        mVar.d(2, context6.getResources().getString(R.string.cx_));
        AppMethodBeat.o(261179);
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void x(Rect rect) {
        AppMethodBeat.i(261180);
        p.h(rect, "contentRect");
        com.tencent.mm.ac.d.h(new b(this, rect));
        AppMethodBeat.o(261180);
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void hTE() {
        AppMethodBeat.i(261181);
        com.tencent.mm.ac.d.h(new a(this));
        AppMethodBeat.o(261181);
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void y(Rect rect) {
        AppMethodBeat.i(261182);
        p.h(rect, "contentRect");
        if (p.j(this.lastContentRect, rect)) {
            Log.i(this.TAG, "skip updateLinkMicBottomBar, lastContentRect == contentRect. lastContentRect:" + this.lastContentRect + " contentRect:" + rect);
            AppMethodBeat.o(261182);
            return;
        }
        this.lastContentRect.set(rect);
        this.URO.setTranslationX((float) rect.left);
        this.URO.setTranslationY((float) rect.top);
        ViewGroup.LayoutParams layoutParams = this.URO.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = rect.width();
            layoutParams.height = rect.height();
            this.URO.requestLayout();
            AppMethodBeat.o(261182);
            return;
        }
        AppMethodBeat.o(261182);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ w URP;
        final /* synthetic */ Rect URQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(w wVar, Rect rect) {
            super(0);
            this.URP = wVar;
            this.URQ = rect;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(261178);
            this.URP.lastContentRect.set(this.URQ);
            w.hUq();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.URQ.width(), this.URQ.height());
            ViewParent parent = this.URP.URO.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(this.URP.URO);
            }
            this.URP.URO.setTranslationX((float) this.URQ.left);
            this.URP.URO.setTranslationY((float) this.URQ.top);
            this.URP.hwr.addView(this.URP.URO, layoutParams);
            this.URP.URO.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.finder.live.widget.w.b.AnonymousClass1 */
                final /* synthetic */ b URR;

                {
                    this.URR = r1;
                }

                public final void onClick(View view) {
                    String str;
                    AppMethodBeat.i(261177);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAnchorHolderWidget$showLinkMicBottomBar$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                    if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                        Log.i(this.URR.URP.TAG, "click rect area but i am anchor, skipped");
                    } else {
                        String djq = this.URR.URP.uFw.getLiveData().djq();
                        e eVar = this.URR.URP.USa;
                        if (eVar != null) {
                            str = eVar.uCo;
                        } else {
                            str = null;
                        }
                        if (Util.isEqual(djq, str)) {
                            Log.i(this.URR.URP.TAG, "click rect area but is myself, skipped");
                        } else {
                            this.URR.URP.hUr();
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAnchorHolderWidget$showLinkMicBottomBar$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(261177);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(261178);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ w URP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(w wVar) {
            super(0);
            this.URP = wVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(261176);
            w.d(this.URP);
            x xVar = x.SXb;
            AppMethodBeat.o(261176);
            return xVar;
        }
    }

    public static final /* synthetic */ void d(w wVar) {
        AppMethodBeat.i(261184);
        wVar.hwr.removeView(wVar.URO);
        AppMethodBeat.o(261184);
    }
}

package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioPreviewWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "avatar", "Landroid/widget/ImageView;", "bgView", "group", "Landroid/widget/RelativeLayout;", "lastContentRect", "Landroid/graphics/Rect;", "nickname", "Landroid/widget/TextView;", "stateTv", "waveIcon", "Lorg/libpag/PAGView;", "widgetRoot", "Landroid/view/View;", "fillContent", "", "hideLinkMicBottomBar", "releaseContent", "showLinkMicBottomBar", "contentRect", "updateLinkMicBottomBar", "plugin-finder_release"})
public final class x extends z {
    private final ImageView BQU;
    private final String TAG = "Finder.FinderLiveMicAudioPreviewWidget";
    private final RelativeLayout URO;
    private final View URS;
    private final ImageView keC;
    private final Rect lastContentRect;
    private final PAGView unn;
    private final TextView uuB;
    private final TextView uzB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(ViewGroup viewGroup, d dVar) {
        super(viewGroup, dVar);
        p.h(viewGroup, "root");
        p.h(dVar, "basePlugin");
        AppMethodBeat.i(261190);
        this.URO = new RelativeLayout(viewGroup.getContext());
        this.lastContentRect = new Rect();
        View inflate = View.inflate(viewGroup.getContext(), R.layout.cf8, null);
        p.g(inflate, "View.inflate(root.contex…mic_state_audio_ui, null)");
        this.URS = inflate;
        View findViewById = this.URS.findViewById(R.id.jy6);
        p.g(findViewById, "widgetRoot.findViewById(…e_mic_state_audio_avatar)");
        this.keC = (ImageView) findViewById;
        View findViewById2 = this.URS.findViewById(R.id.jyc);
        p.g(findViewById2, "widgetRoot.findViewById(…ive_mic_state_audio_name)");
        this.uuB = (TextView) findViewById2;
        View findViewById3 = this.URS.findViewById(R.id.jyg);
        p.g(findViewById3, "widgetRoot.findViewById(…ic_state_audio_wave_icon)");
        this.unn = (PAGView) findViewById3;
        View findViewById4 = this.URS.findViewById(R.id.jyd);
        p.g(findViewById4, "widgetRoot.findViewById(…_live_mic_state_audio_tv)");
        this.uzB = (TextView) findViewById4;
        View findViewById5 = this.URS.findViewById(R.id.jy7);
        p.g(findViewById5, "widgetRoot.findViewById(…_live_mic_state_audio_bg)");
        this.BQU = (ImageView) findViewById5;
        PAGView pAGView = this.unn;
        Context context = viewGroup.getContext();
        p.g(context, "root.context");
        pAGView.setFile(PAGFile.Load(context.getAssets(), "finder_live_link_mic_wave.pag"));
        this.unn.setAlpha(0.5f);
        this.unn.setRepeatCount(-1);
        AppMethodBeat.o(261190);
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void x(Rect rect) {
        AppMethodBeat.i(261187);
        p.h(rect, "contentRect");
        com.tencent.mm.ac.d.h(new b(this, rect));
        AppMethodBeat.o(261187);
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void hTE() {
        AppMethodBeat.i(261188);
        com.tencent.mm.ac.d.h(new a(this));
        AppMethodBeat.o(261188);
    }

    @Override // com.tencent.mm.plugin.finder.live.widget.z
    public final void y(Rect rect) {
        AppMethodBeat.i(261189);
        p.h(rect, "contentRect");
        if (p.j(this.lastContentRect, rect)) {
            Log.i(this.TAG, "skip updateLinkMicBottomBar, lastContentRect == contentRect. lastContentRect:" + this.lastContentRect + " contentRect:" + rect);
            AppMethodBeat.o(261189);
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
            AppMethodBeat.o(261189);
            return;
        }
        AppMethodBeat.o(261189);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ Rect URQ;
        final /* synthetic */ x URT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(x xVar, Rect rect) {
            super(0);
            this.URT = xVar;
            this.URQ = rect;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(261186);
            this.URT.lastContentRect.set(this.URQ);
            x.b(this.URT);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.URQ.width(), this.URQ.height());
            ViewParent parent = this.URT.URO.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(this.URT.URO);
            }
            this.URT.URO.setTranslationX((float) this.URQ.left);
            this.URT.URO.setTranslationY((float) this.URQ.top);
            this.URT.hwr.addView(this.URT.URO, layoutParams);
            ViewParent parent2 = this.URT.URS.getParent();
            if (!(parent2 instanceof ViewGroup)) {
                parent2 = null;
            }
            ViewGroup viewGroup2 = (ViewGroup) parent2;
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.URT.URS);
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(13);
            this.URT.URS.setLayoutParams(layoutParams2);
            this.URT.URO.addView(this.URT.URS);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(261186);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ x URT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(x xVar) {
            super(0);
            this.URT = xVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(261185);
            x.e(this.URT);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(261185);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(x xVar) {
        AppMethodBeat.i(261191);
        e eVar = xVar.USa;
        if (eVar != null) {
            xVar.keC.setVisibility(0);
            if (as.bjt(eVar.username)) {
                m mVar = m.uJa;
                com.tencent.mm.loader.d<o> dka = m.dka();
                com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(eVar.headUrl);
                ImageView imageView = xVar.keC;
                m mVar2 = m.uJa;
                dka.a(aVar, imageView, m.a(m.a.AVATAR));
            } else {
                m mVar3 = m.uJa;
                com.tencent.mm.loader.d<o> dkb = m.dkb();
                com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(eVar.headUrl);
                ImageView imageView2 = xVar.keC;
                m mVar4 = m.uJa;
                dkb.a(aVar2, imageView2, m.a(m.a.WX_AVATAR));
            }
            m mVar5 = m.uJa;
            com.tencent.mm.loader.d<o> dke = m.dke();
            com.tencent.mm.plugin.finder.loader.e eVar2 = new com.tencent.mm.plugin.finder.loader.e(eVar.headUrl, com.tencent.mm.plugin.finder.storage.x.THUMB_IMAGE);
            ImageView imageView3 = xVar.BQU;
            m mVar6 = m.uJa;
            dke.a(eVar2, imageView3, m.a(m.a.AVATAR));
            TextView textView = xVar.uuB;
            com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
            TextView textView2 = xVar.uuB;
            y yVar = y.vXH;
            textView.setText(com.tencent.mm.plugin.finder.convert.d.e(textView2, y.hf(eVar.username, eVar.nickname)));
            TextView textView3 = xVar.uzB;
            Context context = xVar.URS.getContext();
            p.g(context, "widgetRoot.context");
            textView3.setText(context.getResources().getString(R.string.cue));
            xVar.unn.play();
            AppMethodBeat.o(261191);
            return;
        }
        AppMethodBeat.o(261191);
    }

    public static final /* synthetic */ void e(x xVar) {
        AppMethodBeat.i(261192);
        xVar.hwr.removeView(xVar.URO);
        xVar.unn.stop();
        AppMethodBeat.o(261192);
    }
}

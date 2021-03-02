package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.r;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J@\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016J \u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFollowConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adjustNickNameTvSize", "", "nicknameTv", "Landroid/widget/TextView;", "authIconIV", "Landroid/view/View;", "userOnLive", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ao extends e<af> {
    final String TAG = "FinderFollowConvert";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, af afVar, int i2, int i3, boolean z, List list) {
        String str;
        AppMethodBeat.i(243136);
        af afVar2 = afVar;
        p.h(hVar, "holder");
        p.h(afVar2, "item");
        ImageView imageView = (ImageView) hVar.Mn(R.id.x1);
        TextView textView = (TextView) hVar.Mn(R.id.fzg);
        ImageView imageView2 = (ImageView) hVar.Mn(R.id.w0);
        View Mn = hVar.Mn(R.id.cw_);
        TextView textView2 = (TextView) hVar.Mn(R.id.w2);
        g gVar = afVar2.contact;
        Context context = hVar.getContext();
        m mVar = m.uJa;
        d<o> dka = m.dka();
        com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(gVar.cXH());
        p.g(imageView, "avatarIv");
        m mVar2 = m.uJa;
        dka.a(aVar, imageView, m.a(m.a.AVATAR));
        p.g(textView, "nicknameTv");
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, gVar.getNickname()));
        FinderAuthInfo finderAuthInfo = gVar.field_authInfo;
        int i4 = finderAuthInfo != null ? finderAuthInfo.authIconType : 0;
        p.g(textView2, "authJob");
        textView2.setVisibility(8);
        y yVar = y.vXH;
        p.g(imageView2, "authIcon");
        y.a(imageView2, gVar.field_authInfo);
        if (i4 > 0) {
            switch (i4) {
                case 1:
                    textView2.setVisibility(0);
                    FinderAuthInfo finderAuthInfo2 = gVar.field_authInfo;
                    textView2.setText((finderAuthInfo2 == null || (str = finderAuthInfo2.authProfession) == null) ? "" : str);
                    break;
                case 100:
                    textView2.setVisibility(8);
                    break;
            }
        } else {
            textView2.setVisibility(8);
        }
        if (gVar.field_liveStatus == 1) {
            p.g(Mn, "onliveWidget");
            Mn.setVisibility(0);
            Mn.setOnClickListener(new b(Mn, gVar, hVar));
        } else {
            p.g(Mn, "onliveWidget");
            Mn.setVisibility(8);
        }
        textView.getViewTreeObserver().addOnPreDrawListener(new a(this, textView, Mn, imageView2));
        AppMethodBeat.o(243136);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.a9y;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243135);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        View Mn = hVar.Mn(R.id.cw_);
        Mn.post(new c(Mn));
        AppMethodBeat.o(243135);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ View tEq;

        c(View view) {
            this.tEq = view;
        }

        public final void run() {
            AppMethodBeat.i(243134);
            Rect rect = new Rect();
            this.tEq.getHitRect(rect);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.bt);
            rect.inset(-dimensionPixelOffset, -dimensionPixelOffset);
            View view = this.tEq;
            p.g(view, "onliveWidget");
            ViewParent parent = view.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(243134);
                throw tVar;
            }
            ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.tEq));
            AppMethodBeat.o(243134);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ View tEq;
        final /* synthetic */ g tEr;

        b(View view, g gVar, h hVar) {
            this.tEq = view;
            this.tEr = gVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243133);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFollowConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.tEq.getContext();
            p.g(context, "onliveWidget.context");
            new r(context, this.tEr.getUsername(), this.qhp.lR(), false).dzC();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFollowConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243133);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFollowConvert$adjustNickNameTvSize$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-finder_release"})
    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ ao tEm;
        final /* synthetic */ TextView tEn;
        final /* synthetic */ View tEo;
        final /* synthetic */ View tEp;

        a(ao aoVar, TextView textView, View view, View view2) {
            this.tEm = aoVar;
            this.tEn = textView;
            this.tEo = view;
            this.tEp = view2;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(243132);
            this.tEn.getViewTreeObserver().removeOnPreDrawListener(this);
            ViewParent parent = this.tEn.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(243132);
                throw tVar;
            }
            int width = ((View) parent).getWidth();
            int i2 = 0;
            if (this.tEo.getVisibility() == 0) {
                i2 = this.tEo.getWidth() + ((int) this.tEo.getResources().getDimension(R.dimen.cc)) + 0;
            }
            if (this.tEp.getVisibility() == 0) {
                i2 += this.tEp.getWidth() + ((int) this.tEp.getResources().getDimension(R.dimen.ct));
            }
            if (this.tEn.getWidth() + i2 > width) {
                this.tEn.setMaxWidth(width - i2);
                Log.i(this.tEm.TAG, "adjustNickNameTvSize titleW:" + this.tEn.getWidth() + ", containerW:" + width + ",iconW:" + i2);
            }
            AppMethodBeat.o(243132);
            return true;
        }
    }
}

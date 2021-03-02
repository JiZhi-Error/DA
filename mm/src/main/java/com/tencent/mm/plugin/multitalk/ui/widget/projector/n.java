package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.d.f;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0014J\u0006\u0010*\u001a\u00020!J\u000e\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0004R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI;", "", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "mCurrentIndex", "", "getMCurrentIndex", "()I", "setMCurrentIndex", "(I)V", "mCurrentStr", "", "getMCurrentStr", "()Ljava/lang/String;", "setMCurrentStr", "(Ljava/lang/String;)V", "mLeftArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mLeftRoot", "Landroid/widget/FrameLayout;", "mMaxCount", "getMMaxCount", "setMMaxCount", "mRightArrow", "mRightRoot", "mScreenThumbIndexTv", "Landroid/widget/TextView;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "thumbnailIndexRoot", "applyTouchEvent", "", "getIconSelectColor", "isLeftArrow", "", "getLayout", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewGroup", "refreshLayout", "showIndexText", "str", "plugin-multitalk_release"})
public final class n {
    int mMaxCount = -1;
    int rmJ = -1;
    a zQD;
    private WeImageView zXA;
    private String zXB;
    private TextView zXv;
    private FrameLayout zXw;
    private FrameLayout zXx;
    private FrameLayout zXy;
    private WeImageView zXz;

    public n(a aVar) {
        p.h(aVar, "statusManager");
        AppMethodBeat.i(240036);
        this.zQD = aVar;
        AppMethodBeat.o(240036);
    }

    public final void aGE(String str) {
        AppMethodBeat.i(240032);
        p.h(str, "str");
        TextView textView = this.zXv;
        if (textView != null) {
            textView.setVisibility(0);
        }
        FrameLayout frameLayout = this.zXw;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        this.zXB = str;
        TextView textView2 = this.zXv;
        if (textView2 != null) {
            textView2.setText(str);
        }
        TextView textView3 = this.zXv;
        if (textView3 != null) {
            WeImageView weImageView = this.zXz;
            if (weImageView != null) {
                Context context = textView3.getContext();
                p.g(context, "it.context");
                weImageView.setIconColor(context.getResources().getColor(si(true)));
            }
            WeImageView weImageView2 = this.zXA;
            if (weImageView2 != null) {
                Context context2 = textView3.getContext();
                p.g(context2, "it.context");
                weImageView2.setIconColor(context2.getResources().getColor(si(false)));
                AppMethodBeat.o(240032);
                return;
            }
            AppMethodBeat.o(240032);
            return;
        }
        AppMethodBeat.o(240032);
    }

    public final View c(Context context, FrameLayout frameLayout) {
        AppMethodBeat.i(240033);
        p.h(context, "context");
        p.h(frameLayout, "viewGroup");
        if (this.zQD.epg()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.bd6, frameLayout);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
                AppMethodBeat.o(240033);
                throw tVar;
            }
            this.zXw = (FrameLayout) inflate;
            epD();
        } else {
            View inflate2 = LayoutInflater.from(context).inflate(R.layout.bd5, frameLayout);
            if (inflate2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
                AppMethodBeat.o(240033);
                throw tVar2;
            }
            this.zXw = (FrameLayout) inflate2;
            epD();
        }
        FrameLayout frameLayout2 = this.zXw;
        AppMethodBeat.o(240033);
        return frameLayout2;
    }

    private void epD() {
        AppMethodBeat.i(240034);
        FrameLayout frameLayout = this.zXw;
        if (frameLayout != null) {
            this.zXv = (TextView) frameLayout.findViewById(R.id.hca);
            TextView textView = this.zXv;
            if (textView != null) {
                textView.setVisibility(4);
            }
            FrameLayout frameLayout2 = this.zXw;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(4);
            }
            this.zXz = (WeImageView) frameLayout.findViewById(R.id.hcd);
            this.zXA = (WeImageView) frameLayout.findViewById(R.id.hcf);
            this.zXx = (FrameLayout) frameLayout.findViewById(R.id.hce);
            this.zXy = (FrameLayout) frameLayout.findViewById(R.id.hcg);
            WeImageView weImageView = this.zXz;
            if (weImageView != null) {
                weImageView.setRotation(180.0f);
            }
            WeImageView weImageView2 = this.zXz;
            if (weImageView2 != null) {
                weImageView2.setImageDrawable(ar.m(frameLayout.getContext(), R.raw.icons_filled_arrow, si(true)));
            }
            WeImageView weImageView3 = this.zXz;
            if (weImageView3 != null) {
                Context context = frameLayout.getContext();
                p.g(context, "it.context");
                weImageView3.setIconColor(context.getResources().getColor(si(true)));
            }
            WeImageView weImageView4 = this.zXA;
            if (weImageView4 != null) {
                weImageView4.setImageDrawable(ar.m(frameLayout.getContext(), R.raw.icons_filled_arrow, si(false)));
            }
            WeImageView weImageView5 = this.zXA;
            if (weImageView5 != null) {
                Context context2 = frameLayout.getContext();
                p.g(context2, "it.context");
                weImageView5.setIconColor(context2.getResources().getColor(si(false)));
            }
            FrameLayout frameLayout3 = this.zXx;
            if (frameLayout3 != null) {
                frameLayout3.setOnClickListener(new a(this));
            }
            FrameLayout frameLayout4 = this.zXy;
            if (frameLayout4 != null) {
                frameLayout4.setOnClickListener(new b(this));
            }
            String str = this.zXB;
            if (str != null) {
                aGE(str);
                AppMethodBeat.o(240034);
                return;
            }
            AppMethodBeat.o(240034);
            return;
        }
        AppMethodBeat.o(240034);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$1$1"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ n zXC;

        a(n nVar) {
            this.zXC = nVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(240030);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.zXC.rmJ == 0) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(240030);
                return;
            }
            f fVar = f.zZd;
            f.eqv();
            n nVar = this.zXC;
            nVar.rmJ--;
            this.zXC.aGE(new StringBuilder().append(this.zXC.rmJ + 1).append('/').append(this.zXC.mMaxCount).toString());
            Bundle bundle = new Bundle();
            bundle.putInt("thumb_flip_target_position", this.zXC.rmJ);
            this.zXC.zQD.a(a.c.THUMB_VIEW_PAGE_FLIP, bundle);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240030);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$1$2"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ n zXC;

        b(n nVar) {
            this.zXC = nVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(240031);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.zXC.rmJ == this.zXC.mMaxCount - 1) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(240031);
                return;
            }
            f fVar = f.zZd;
            f.eqv();
            this.zXC.rmJ++;
            this.zXC.aGE(new StringBuilder().append(this.zXC.rmJ + 1).append('/').append(this.zXC.mMaxCount).toString());
            Bundle bundle = new Bundle();
            bundle.putInt("thumb_flip_target_position", this.zXC.rmJ);
            this.zXC.zQD.a(a.c.THUMB_VIEW_PAGE_FLIP, bundle);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240031);
        }
    }

    private final int si(boolean z) {
        return z ? this.rmJ == 0 ? R.color.tw : R.color.am : this.rmJ != this.mMaxCount + -1 ? R.color.am : R.color.tw;
    }

    public final void eoD() {
        AppMethodBeat.i(240035);
        TextView textView = this.zXv;
        if (textView != null) {
            WeImageView weImageView = this.zXz;
            if (weImageView != null) {
                Context context = textView.getContext();
                p.g(context, "it.context");
                weImageView.setIconColor(context.getResources().getColor(si(true)));
            }
            WeImageView weImageView2 = this.zXA;
            if (weImageView2 != null) {
                Context context2 = textView.getContext();
                p.g(context2, "it.context");
                weImageView2.setIconColor(context2.getResources().getColor(si(false)));
                AppMethodBeat.o(240035);
                return;
            }
            AppMethodBeat.o(240035);
            return;
        }
        AppMethodBeat.o(240035);
    }
}

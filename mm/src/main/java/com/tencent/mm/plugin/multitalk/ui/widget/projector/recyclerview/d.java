package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbnailLayoutHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "radius", "", "thumbCover", "Landroid/widget/ImageView;", "getThumbCover", "()Landroid/widget/ImageView;", "setThumbCover", "(Landroid/widget/ImageView;)V", "thumbLayout", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-multitalk_release"})
public final class d extends RecyclerView.v {
    private final float radius = ((float) a.fromDPToPix(MMApplicationContext.getContext(), 2));
    public WeImageView zYM;
    ImageView zYN;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(240080);
        View findViewById = view.findViewById(R.id.foz);
        if (findViewById == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(240080);
            throw tVar;
        }
        this.zYN = (ImageView) findViewById;
        ImageView imageView = this.zYN;
        if (imageView != null) {
            imageView.setClipToOutline(true);
        }
        ImageView imageView2 = this.zYN;
        if (imageView2 != null) {
            imageView2.setOutlineProvider(new e(this.radius));
        }
        View findViewById2 = view.findViewById(R.id.fp0);
        if (findViewById2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
            AppMethodBeat.o(240080);
            throw tVar2;
        }
        this.zYM = (WeImageView) findViewById2;
        WeImageView weImageView = this.zYM;
        if (weImageView != null) {
            weImageView.setClipToOutline(true);
        }
        WeImageView weImageView2 = this.zYM;
        if (weImageView2 != null) {
            weImageView2.setOutlineProvider(new e(this.radius));
            AppMethodBeat.o(240080);
            return;
        }
        AppMethodBeat.o(240080);
    }
}

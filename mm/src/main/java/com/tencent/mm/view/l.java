package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.view.b.b;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0002\u0010\f¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/view/MultiTalkDrawingView;", "Lcom/tencent/mm/view/BaseDrawingView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createBoardView", "Lcom/tencent/mm/view/board/BaseBoardView;", "createFooterView", "Lcom/tencent/mm/view/footer/BaseFooterView;", "getFeatures", "", "Lcom/tencent/mm/api/FeaturesType;", "()[Lcom/tencent/mm/api/FeaturesType;", "Companion", "plugin-photoedit-sdk_release"})
public final class l extends a {
    public static final a Rka = new a((byte) 0);

    static {
        AppMethodBeat.i(204704);
        AppMethodBeat.o(204704);
    }

    public l(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.a
    public final com.tencent.mm.view.b.a hfv() {
        AppMethodBeat.i(204701);
        b bVar = new b(getContext(), getPresenter());
        AppMethodBeat.o(204701);
        return bVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.a
    public final com.tencent.mm.view.footer.a hfw() {
        AppMethodBeat.i(204702);
        Context context = getContext();
        p.g(context, "context");
        com.tencent.mm.bt.b presenter = getPresenter();
        p.g(presenter, "presenter");
        com.tencent.mm.view.footer.b bVar = new com.tencent.mm.view.footer.b(context, presenter);
        AppMethodBeat.o(204702);
        return bVar;
    }

    @Override // com.tencent.mm.view.a
    public final h[] getFeatures() {
        AppMethodBeat.i(204703);
        if (this.Riw == null) {
            this.Riw = new h[]{h.DOODLE, h.EMOJI, h.TEXT, h.MOSAIC, h.CROP_PHOTO};
        }
        h[] hVarArr = this.Riw;
        p.g(hVarArr, "mFeaturesTypes");
        AppMethodBeat.o(204703);
        return hVarArr;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/view/MultiTalkDrawingView$Companion;", "", "()V", "TAG", "", "plugin-photoedit-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

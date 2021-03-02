package com.tencent.mm.view.footer;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/view/footer/MultitalkScreenFooterView;", "Lcom/tencent/mm/view/footer/PhotoFooterView;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "(Landroid/content/Context;Lcom/tencent/mm/presenter/IPresenter;)V", "getColor", "", FirebaseAnalytics.b.INDEX, "Companion", "plugin-photoedit-sdk_release"})
public final class b extends c {
    private static final int BSV = BSV;
    private static final int BSW = -16777216;
    private static final int BSX = BSX;
    private static final int BSY = BSY;
    private static final int BSZ = BSZ;
    private static final int BTa = BTa;
    private static final int BTb = BTb;
    private static final int BTc = BTc;
    private static final int[] RoQ = {BSV, BSW, BSX, BSY, BSZ, BTa, BTb, BTc};
    public static final a RoW = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/view/footer/MultitalkScreenFooterView$Companion;", "", "()V", "COLOR_0", "", "COLOR_1", "COLOR_2", "COLOR_3", "COLOR_4", "COLOR_5", "COLOR_6", "COLOR_7", "mColorsDoodle", "", "getMColorsDoodle", "()[I", "plugin-photoedit-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, com.tencent.mm.bt.b bVar) {
        super(context, bVar);
        p.h(context, "context");
        p.h(bVar, "presenter");
        AppMethodBeat.i(204713);
        AppMethodBeat.o(204713);
    }

    static {
        AppMethodBeat.i(204714);
        AppMethodBeat.o(204714);
    }

    @Override // com.tencent.mm.view.footer.a
    public final int getColor(int i2) {
        if (i2 < 0 || i2 >= RoQ.length) {
            return -65536;
        }
        return RoQ[i2];
    }
}

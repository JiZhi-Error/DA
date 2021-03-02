package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/view/BaseEmojiView;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "getCallback", "()Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "setCallback", "(Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "netLoad", "", "start", "", "cancel", "", "onLoad", "success", "async", "plugin-emojisdk_release"})
public class f extends j<BaseEmojiView> {
    i.a gWA;
    private boolean gWB;
    private long start = System.currentTimeMillis();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "width", "", "height", "invoke"})
    public static final class b extends q implements m<Integer, Integer, x> {
        final /* synthetic */ f gWC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(f fVar) {
            super(2);
            this.gWC = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, Integer num2) {
            AppMethodBeat.i(199905);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            if (this.gWC.gWm.field_width == 0 || this.gWC.gWm.field_height == 0) {
                this.gWC.gWm.field_width = intValue;
                this.gWC.gWm.field_height = intValue2;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(199905);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(EmojiInfo emojiInfo, BaseEmojiView baseEmojiView, i.a aVar) {
        super(emojiInfo, baseEmojiView);
        p.h(emojiInfo, "emojiInfo");
        p.h(baseEmojiView, "view");
        AppMethodBeat.i(105470);
        this.gWA = aVar;
        AppMethodBeat.o(105470);
    }

    @Override // com.tencent.mm.emoji.loader.d.i, com.tencent.mm.emoji.loader.d.j
    public void dR(boolean z) {
        BaseEmojiView baseEmojiView;
        Drawable drawable = null;
        AppMethodBeat.i(105468);
        String auD = g.auD();
        StringBuilder append = new StringBuilder("onLoad ").append(this).append(' ');
        WeakReference<V> weakReference = this.gWH;
        Log.d(auD, append.append(weakReference != null ? (BaseEmojiView) weakReference.get() : null).append(' ').append(z).toString());
        if (this.gWB) {
            com.tencent.mm.search.c.a aVar = com.tencent.mm.search.c.a.NJv;
            if (com.tencent.mm.search.c.a.MH(this.start)) {
                com.tencent.mm.search.c.a aVar2 = com.tencent.mm.search.c.a.NJv;
                com.tencent.mm.search.c.a.gxx();
                com.tencent.mm.search.c.a aVar3 = com.tencent.mm.search.c.a.NJv;
                com.tencent.mm.search.c.a.MG(System.currentTimeMillis() - this.start);
            }
        }
        WeakReference<V> weakReference2 = this.gWH;
        if (weakReference2 != null) {
            baseEmojiView = (BaseEmojiView) weakReference2.get();
        } else {
            baseEmojiView = null;
        }
        if (z) {
            drawable = new com.tencent.mm.emoji.loader.b.a().a(this.gWm, new b(this));
        }
        d.h(new a(this, z, drawable, baseEmojiView));
        AppMethodBeat.o(105468);
    }

    @Override // com.tencent.mm.emoji.loader.d.i, com.tencent.mm.emoji.loader.d.j
    public final void cancel() {
        AppMethodBeat.i(105469);
        super.cancel();
        this.gWA = null;
        AppMethodBeat.o(105469);
    }

    @Override // com.tencent.mm.emoji.loader.d.i
    public void start(boolean z) {
        AppMethodBeat.i(105467);
        if (this.gWm.hYi()) {
            dR(true);
            AppMethodBeat.o(105467);
            return;
        }
        this.gWB = true;
        d.h(new c(this));
        AppMethodBeat.o(105467);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f gWC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar) {
            super(0);
            this.gWC = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            WeakReference<V> weakReference;
            BaseEmojiView baseEmojiView;
            AppMethodBeat.i(105466);
            WeakReference<V> weakReference2 = this.gWC.gWH;
            if (!(((weakReference2 != null ? (BaseEmojiView) weakReference2.get() : null) instanceof CoverEmojiStatusView) || (weakReference = this.gWC.gWH) == null || (baseEmojiView = (BaseEmojiView) weakReference.get()) == null)) {
                baseEmojiView.init();
            }
            this.gWC.dS(true);
            x xVar = x.SXb;
            AppMethodBeat.o(105466);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean $success;
        final /* synthetic */ f gWC;
        final /* synthetic */ Drawable gWv;
        final /* synthetic */ BaseEmojiView gWw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(f fVar, boolean z, Drawable drawable, BaseEmojiView baseEmojiView) {
            super(0);
            this.gWC = fVar;
            this.$success = z;
            this.gWv = drawable;
            this.gWw = baseEmojiView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105465);
            if (!this.$success || this.gWv == null) {
                BaseEmojiView baseEmojiView = this.gWw;
                if (baseEmojiView != null) {
                    baseEmojiView.init();
                }
                i.a aVar = this.gWC.gWA;
                if (aVar != null) {
                    aVar.dQ(false);
                }
            } else {
                BaseEmojiView baseEmojiView2 = this.gWw;
                if (baseEmojiView2 != null) {
                    baseEmojiView2.setImageDrawable(this.gWv);
                }
                BaseEmojiView baseEmojiView3 = this.gWw;
                if (baseEmojiView3 != null) {
                    baseEmojiView3.resume();
                }
                i.a aVar2 = this.gWC.gWA;
                if (aVar2 != null) {
                    aVar2.dQ(true);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105465);
            return xVar;
        }
    }
}

package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;Ljava/lang/String;)V", "firstLoad", "", "onLoad", "", "success", "onSize", "width", "", "height", "start", "async", "plugin-emojisdk_release"})
public final class a extends f {
    private final String cacheKey;
    private boolean gWt = true;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "width", "", "height", "invoke"})
    public static final class b extends q implements m<Integer, Integer, x> {
        final /* synthetic */ a gWu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(2);
            this.gWu = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, Integer num2) {
            AppMethodBeat.i(105448);
            a.a(this.gWu, num.intValue(), num2.intValue());
            x xVar = x.SXb;
            AppMethodBeat.o(105448);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(EmojiInfo emojiInfo, ChattingEmojiView chattingEmojiView, String str) {
        super(emojiInfo, chattingEmojiView, chattingEmojiView);
        p.h(emojiInfo, "emojiInfo");
        p.h(chattingEmojiView, "view");
        p.h(str, "cacheKey");
        AppMethodBeat.i(105451);
        this.cacheKey = str;
        AppMethodBeat.o(105451);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005d, code lost:
        if (kotlin.g.b.p.j(r3, r0) != false) goto L_0x005f;
     */
    @Override // com.tencent.mm.emoji.loader.d.i, com.tencent.mm.emoji.loader.d.f
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void start(boolean r8) {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.loader.d.a.start(boolean):void");
    }

    @Override // com.tencent.mm.emoji.loader.d.i, com.tencent.mm.emoji.loader.d.j, com.tencent.mm.emoji.loader.d.f
    public final void dR(boolean z) {
        BaseEmojiView baseEmojiView;
        BaseEmojiView baseEmojiView2;
        Drawable drawable = null;
        AppMethodBeat.i(105450);
        StringBuilder append = new StringBuilder("onLoad ").append(this).append(' ');
        WeakReference<V> weakReference = this.gWH;
        if (weakReference != null) {
            baseEmojiView = (BaseEmojiView) weakReference.get();
        } else {
            baseEmojiView = null;
        }
        Log.d("MicroMsg.ChatEmojiViewRequest", append.append(baseEmojiView).append(' ').append(z).toString());
        WeakReference<V> weakReference2 = this.gWH;
        if (weakReference2 != null) {
            baseEmojiView2 = (BaseEmojiView) weakReference2.get();
        } else {
            baseEmojiView2 = null;
        }
        if (z) {
            drawable = new com.tencent.mm.emoji.loader.b.a().a(this.gWm, new b(this));
        }
        if (drawable != null || !this.gWt) {
            d.h(new C0327a(this, drawable, baseEmojiView2, z));
            AppMethodBeat.o(105450);
            return;
        }
        this.gWt = false;
        dS(true);
        AppMethodBeat.o(105450);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a gWu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(0);
            this.gWu = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(177051);
            this.gWu.dR(true);
            x xVar = x.SXb;
            AppMethodBeat.o(177051);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.loader.d.a$a  reason: collision with other inner class name */
    public static final class C0327a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean $success;
        final /* synthetic */ a gWu;
        final /* synthetic */ Drawable gWv;
        final /* synthetic */ BaseEmojiView gWw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0327a(a aVar, Drawable drawable, BaseEmojiView baseEmojiView, boolean z) {
            super(0);
            this.gWu = aVar;
            this.gWv = drawable;
            this.gWw = baseEmojiView;
            this.$success = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            AppMethodBeat.i(105447);
            com.tencent.mm.emoji.loader.a.a aVar = com.tencent.mm.emoji.loader.a.a.gVS;
            com.tencent.mm.emoji.loader.a.a.put(this.gWu.cacheKey, this.gWv);
            BaseEmojiView baseEmojiView = this.gWw;
            if (baseEmojiView != null) {
                baseEmojiView.setImageDrawable(this.gWv);
            }
            BaseEmojiView baseEmojiView2 = this.gWw;
            if (baseEmojiView2 != null) {
                baseEmojiView2.resume();
            }
            i.a aVar2 = this.gWu.gWA;
            if (aVar2 != null) {
                if (!this.$success || this.gWv == null) {
                    z = false;
                } else {
                    z = true;
                }
                aVar2.dQ(z);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105447);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(a aVar, int i2, int i3) {
        AppMethodBeat.i(105452);
        if (aVar.gWm.field_width == 0 || aVar.gWm.field_height == 0) {
            aVar.gWm.field_width = i2;
            aVar.gWm.field_height = i3;
            com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
            p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d) ah).getProvider().updateEmojiInfo(aVar.gWm);
        }
        AppMethodBeat.o(105452);
    }
}

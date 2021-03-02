package com.tencent.mm.emoji.loader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.c;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/emoji/loader/task/EmojiCoverTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "dependRequest", "Lcom/tencent/mm/emoji/loader/request/Request;", "taskKey", "", "getTaskKey", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
public final class a extends c implements Runnable {
    private final String gWK;
    private i<?> gWL;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.loader.e.a$a  reason: collision with other inner class name */
    static final class C0328a extends q implements b<Boolean, x> {
        final /* synthetic */ a gWM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0328a(a aVar) {
            super(1);
            this.gWM = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(105473);
            boolean booleanValue = bool.booleanValue();
            Log.d("MicroMsg.EmojiCoverTask", "run: " + this.gWM.gWK + ", " + booleanValue);
            this.gWM.dQ(booleanValue);
            x xVar = x.SXb;
            AppMethodBeat.o(105473);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(EmojiInfo emojiInfo) {
        super(emojiInfo);
        p.h(emojiInfo, "emojiInfo");
        AppMethodBeat.i(105476);
        this.gWK = emojiInfo.getMd5() + "_cover";
        AppMethodBeat.o(105476);
    }

    @Override // com.tencent.mm.emoji.loader.e.c
    public final String auJ() {
        return this.gWK;
    }

    @Override // com.tencent.mm.emoji.loader.e.c
    public final void run() {
        AppMethodBeat.i(105474);
        super.run();
        this.gWL = new c().a(this.gWm, new C0328a(this));
        AppMethodBeat.o(105474);
    }

    @Override // com.tencent.mm.emoji.loader.e.c
    public final void dQ(boolean z) {
        AppMethodBeat.i(105475);
        i<?> iVar = this.gWL;
        if (iVar != null) {
            iVar.cancel();
        }
        super.dQ(z);
        AppMethodBeat.o(105475);
    }
}

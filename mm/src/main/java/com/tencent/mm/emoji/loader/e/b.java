package com.tencent.mm.emoji.loader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.h;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.loader.f.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/emoji/loader/task/EmojiLoadTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkCache", "", "getTaskKey", "run", "", "plugin-emojisdk_release"})
public final class b extends c {
    final String TAG = "MicroMsg.EmojiLoadTask";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class a extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ b gWN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar) {
            super(1);
            this.gWN = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(105477);
            boolean booleanValue = bool.booleanValue();
            Log.i(this.gWN.TAG, this.gWN.gWm.getMd5() + " fetch " + booleanValue);
            if (booleanValue) {
                c cVar = c.gWT;
                boolean k = c.k(this.gWN.gWm);
                Log.i(this.gWN.TAG, this.gWN.gWm.getMd5() + " verify " + k);
                this.gWN.dQ(k);
            } else {
                this.gWN.dQ(false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105477);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(EmojiInfo emojiInfo) {
        super(emojiInfo);
        p.h(emojiInfo, "emojiInfo");
        AppMethodBeat.i(105480);
        AppMethodBeat.o(105480);
    }

    @Override // com.tencent.mm.emoji.loader.e.c
    public final void run() {
        AppMethodBeat.i(105479);
        super.run();
        if (this.gWm.hYi()) {
            dQ(true);
            AppMethodBeat.o(105479);
            return;
        }
        e eVar = e.gVM;
        if (e.auB()) {
            Log.w(this.TAG, this.gWm.getMd5() + ": mock download fail");
            dQ(false);
            AppMethodBeat.o(105479);
            return;
        }
        h hVar = h.gWs;
        h.d(this.gWm, new a(this));
        AppMethodBeat.o(105479);
    }

    @Override // com.tencent.mm.emoji.loader.e.c
    public final String auJ() {
        AppMethodBeat.i(105478);
        String md5 = this.gWm.getMd5();
        p.g(md5, "emojiInfo.md5");
        AppMethodBeat.o(105478);
        return md5;
    }
}

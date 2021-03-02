package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.d;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "call", "", "checkUpdate", "uniqueId", "", "Companion", "plugin-emojisdk_release"})
public final class c extends com.tencent.mm.loader.g.c {
    private static final String TAG = TAG;
    public static final a hcB = new a((byte) 0);
    final EmojiInfo gWm;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ c hcC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar) {
            super(1);
            this.hcC = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(105730);
            boolean booleanValue = bool.booleanValue();
            Log.i(c.TAG, this.hcC + ' ' + this.hcC.gWm.getMd5() + " fetcher " + booleanValue);
            if (booleanValue) {
                c.a(this.hcC);
                this.hcC.a(j.OK);
            } else {
                this.hcC.a(j.Fail);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105730);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public c(EmojiInfo emojiInfo) {
        p.h(emojiInfo, "emojiInfo");
        AppMethodBeat.i(105733);
        this.gWm = emojiInfo;
        AppMethodBeat.o(105733);
    }

    static {
        AppMethodBeat.i(105734);
        AppMethodBeat.o(105734);
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        AppMethodBeat.i(105731);
        new com.tencent.mm.emoji.loader.c.c().a(this.gWm, new b(this));
        AppMethodBeat.o(105731);
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(105732);
        String md5 = this.gWm.getMd5();
        p.g(md5, "emojiInfo.md5");
        AppMethodBeat.o(105732);
        return md5;
    }

    public static final /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(105735);
        boolean z = false;
        bj gCJ = bj.gCJ();
        p.g(gCJ, "EmojiStorageMgr.getInstance()");
        EmojiInfo blk = gCJ.cgN().blk(cVar.gWm.getMd5());
        if (blk == null) {
            AppMethodBeat.o(105735);
            return;
        }
        if (blk.getState() != EmojiInfo.Vle) {
            blk.setState(EmojiInfo.Vle);
            z = true;
        }
        if (blk.field_width <= 0 || blk.field_width <= 0) {
            d decoder = MMGIFJNIFactory.Companion.getDecoder(blk);
            if (MMGIFJNIFactory.Companion.isValid(decoder)) {
                blk.field_width = decoder.aur();
                blk.field_height = decoder.aus();
                z = true;
            }
            decoder.destroy();
        }
        if (z) {
            bj gCJ2 = bj.gCJ();
            p.g(gCJ2, "EmojiStorageMgr.getInstance()");
            gCJ2.cgN().L(blk);
            if (p.j(cVar.gWm.avy(), "capture")) {
                com.tencent.mm.emoji.b.j.auL().dY(true);
            }
        }
        AppMethodBeat.o(105735);
    }
}

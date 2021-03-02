package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.f;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/emoji/upload/EmojiUploadManager;", "", "()V", "emojiCaptureUploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "uploadCallback", "com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1;", "addUploadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timeEnter", "", "plugin-emojisdk_release"})
public final class i {
    private static final d<c> hdM = new d<>(new f(new com.tencent.mm.loader.g.a.a(20), new g(1, (byte) 0), 1, "EmojiUpload"));
    private static final a hdN = new a();
    public static final i hdO = new i();

    static {
        AppMethodBeat.i(105782);
        hdM.a(hdN);
        AppMethodBeat.o(105782);
    }

    private i() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
    public static final class a implements com.tencent.mm.loader.g.f<c> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(c cVar, j jVar) {
            AppMethodBeat.i(105779);
            c cVar2 = cVar;
            p.h(cVar2, "task");
            p.h(jVar, "status");
            Log.i(j.TAG, "onLoaderFin: " + String.valueOf(cVar2.hdz) + ", " + jVar);
            AppMethodBeat.o(105779);
        }
    }

    public static void o(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105780);
        p.h(emojiInfo, "emojiInfo");
        Log.i(j.TAG, "addUploadTask: " + emojiInfo.getMd5());
        hdM.c(new c(emojiInfo));
        AppMethodBeat.o(105780);
    }

    public static void zm(long j2) {
        AppMethodBeat.i(105781);
        Log.i(j.TAG, "addUploadTask: ".concat(String.valueOf(j2)));
        bj gCJ = bj.gCJ();
        p.g(gCJ, "EmojiStorageMgr.getInstance()");
        EmojiInfo Nl = gCJ.cgN().Nl(j2);
        Log.i(j.TAG, "addUploadTask: " + (Nl != null ? Nl.getMd5() : null));
        if (Nl != null) {
            o(Nl);
            AppMethodBeat.o(105781);
            return;
        }
        AppMethodBeat.o(105781);
    }
}

package com.tencent.mm.emoji.loader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.EmojiLoaderProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/emoji/loader/task/ProcessTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getTaskKey", "", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
public final class e extends c {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(EmojiInfo emojiInfo) {
        super(emojiInfo);
        p.h(emojiInfo, "emojiInfo");
        AppMethodBeat.i(105484);
        AppMethodBeat.o(105484);
    }

    @Override // com.tencent.mm.emoji.loader.e.c
    public final void run() {
        AppMethodBeat.i(105482);
        super.run();
        EmojiLoaderProxy.a aVar = EmojiLoaderProxy.gVR;
        EmojiLoaderProxy.gVP = EmojiLoaderProxy.gVP + 1;
        if (EmojiLoaderProxy.gVQ) {
            EmojiLoaderProxy.gVQ = false;
            EmojiLoaderProxy emojiLoaderProxy = new EmojiLoaderProxy(new d(MMApplicationContext.getContext()));
            p.h(emojiLoaderProxy, "<set-?>");
            EmojiLoaderProxy.gVO = emojiLoaderProxy;
        }
        EmojiLoaderProxy.a aVar2 = EmojiLoaderProxy.gVR;
        EmojiLoaderProxy.gVO.load(this.gWm);
        AppMethodBeat.o(105482);
    }

    @Override // com.tencent.mm.emoji.loader.e.c
    public final void dQ(boolean z) {
        AppMethodBeat.i(105483);
        super.dQ(z);
        EmojiLoaderProxy.a aVar = EmojiLoaderProxy.gVR;
        EmojiLoaderProxy.gVP = EmojiLoaderProxy.gVP - 1;
        if (EmojiLoaderProxy.gVP <= 0) {
            EmojiLoaderProxy.gVQ = true;
            d serverProxy = EmojiLoaderProxy.gVO.getServerProxy();
            if (serverProxy != null) {
                serverProxy.release();
                AppMethodBeat.o(105483);
                return;
            }
        }
        AppMethodBeat.o(105483);
    }

    @Override // com.tencent.mm.emoji.loader.e.c
    public final String auJ() {
        AppMethodBeat.i(105481);
        String md5 = this.gWm.getMd5();
        p.g(md5, "emojiInfo.md5");
        AppMethodBeat.o(105481);
        return md5;
    }
}

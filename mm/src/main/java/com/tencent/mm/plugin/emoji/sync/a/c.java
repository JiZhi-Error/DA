package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class c extends com.tencent.mm.plugin.emoji.sync.c {
    private String mKey;
    private d rdU;
    private q rdW;
    private EmojiInfo rdX;

    public c(String str) {
        AppMethodBeat.i(108781);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
        }
        this.mKey = str;
        this.rdX = k.getEmojiStorageMgr().OpN.blk(this.mKey);
        AppMethodBeat.o(108781);
    }

    public final void run() {
        AppMethodBeat.i(108782);
        if (this.rdU != null) {
            this.rdU.amU(this.mKey);
        } else {
            Log.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
        }
        if (this.rdX == null) {
            this.rdU.m(this.mKey, 1, false);
            AppMethodBeat.o(108782);
            return;
        }
        this.rdW = new g(this.rdX);
        com.tencent.mm.kernel.g.aAg().hqi.a(this.rdW, 0);
        AppMethodBeat.o(108782);
    }

    @Override // com.tencent.mm.plugin.emoji.sync.c
    public final String getKey() {
        return this.mKey;
    }

    @Override // com.tencent.mm.plugin.emoji.sync.c
    public final void a(d dVar) {
        this.rdU = dVar;
    }

    @Override // com.tencent.mm.plugin.emoji.sync.c
    public final boolean equals(Object obj) {
        AppMethodBeat.i(108783);
        if (obj != null && (obj instanceof c)) {
            c cVar = (c) obj;
            if (!Util.isNullOrNil(this.mKey) && !Util.isNullOrNil(cVar.mKey) && this.mKey.equals(cVar.mKey)) {
                AppMethodBeat.o(108783);
                return true;
            }
        }
        AppMethodBeat.o(108783);
        return false;
    }

    @Override // com.tencent.mm.plugin.emoji.sync.c
    public final void cancel() {
    }
}

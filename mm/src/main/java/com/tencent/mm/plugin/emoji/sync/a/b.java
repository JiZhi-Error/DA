package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class b extends c {
    private String rcD;
    private d rdU;

    public b(String str) {
        AppMethodBeat.i(108778);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
        }
        this.rcD = str;
        AppMethodBeat.o(108778);
    }

    public final void run() {
        AppMethodBeat.i(108779);
        if (this.rdU != null) {
            this.rdU.amU(getKey());
        } else {
            Log.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
        }
        EmojiGroupInfo di = k.getEmojiStorageMgr().OpO.di(new StringBuilder().append(EmojiGroupInfo.VkN).toString(), false);
        di.field_flag = 0;
        k.getEmojiStorageMgr().OpO.replace(di);
        if (this.rdU != null) {
            this.rdU.m(getKey(), 2, true);
        }
        AppMethodBeat.o(108779);
    }

    @Override // com.tencent.mm.plugin.emoji.sync.c
    public final String getKey() {
        return this.rcD == null ? "" : this.rcD;
    }

    @Override // com.tencent.mm.plugin.emoji.sync.c
    public final void a(d dVar) {
        this.rdU = dVar;
    }

    @Override // com.tencent.mm.plugin.emoji.sync.c
    public final boolean equals(Object obj) {
        AppMethodBeat.i(108780);
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (!Util.isNullOrNil(this.rcD) && !Util.isNullOrNil(bVar.getKey()) && this.rcD.equals(bVar.getKey())) {
                AppMethodBeat.o(108780);
                return true;
            }
        }
        AppMethodBeat.o(108780);
        return false;
    }

    @Override // com.tencent.mm.plugin.emoji.sync.c
    public final void cancel() {
    }
}

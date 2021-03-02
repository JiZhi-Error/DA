package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.m;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.l;
import java.io.IOException;

public final class a extends c {
    public String rcD;
    private d rdU;
    private h rdV;
    private boolean rdb = false;

    public a(String str) {
        AppMethodBeat.i(108773);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.rcD = str;
        AppMethodBeat.o(108773);
    }

    public a(String str, byte b2) {
        AppMethodBeat.i(108774);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.rcD = str;
        this.rdb = true;
        AppMethodBeat.o(108774);
    }

    public final void run() {
        AppMethodBeat.i(108775);
        if (this.rdU != null) {
            this.rdU.amU(getKey());
        } else {
            Log.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
        }
        EmojiGroupInfo di = k.getEmojiStorageMgr().OpO.di(getKey(), true);
        if (this.rdb || di == null || di.field_sync != 2 || di.field_status != 7) {
            this.rdV = new h(this.rcD);
            g.aAg().hqi.a(this.rdV, 0);
            GetEmotionDetailResponse getEmotionDetailResponse = new GetEmotionDetailResponse();
            l blt = k.getEmojiStorageMgr().OpR.blt(this.rcD);
            if (!(blt == null || blt.field_content == null)) {
                try {
                    getEmotionDetailResponse.parseFrom(blt.field_content);
                } catch (IOException e2) {
                    Log.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", Util.stackTraceToString(e2));
                }
            }
            if (getEmotionDetailResponse.EmotionDetail == null) {
                g.aAg().hqi.a(new m(this.rcD, 15), 0);
            }
            AppMethodBeat.o(108775);
            return;
        }
        dm dmVar = new dm();
        dmVar.dGw.md5 = getKey();
        dmVar.dGw.dDe = 2;
        dmVar.dGw.success = true;
        EventCenter.instance.publish(dmVar);
        AppMethodBeat.o(108775);
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
        AppMethodBeat.i(108776);
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (!Util.isNullOrNil(this.rcD) && !Util.isNullOrNil(aVar.getKey()) && this.rcD.equals(aVar.getKey())) {
                AppMethodBeat.o(108776);
                return true;
            }
        }
        AppMethodBeat.o(108776);
        return false;
    }

    @Override // com.tencent.mm.plugin.emoji.sync.c
    public final void cancel() {
        AppMethodBeat.i(108777);
        if (this.rdV == null || Util.isNullOrNil(this.rdV.iYT)) {
            Log.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
            AppMethodBeat.o(108777);
            return;
        }
        f.baQ().Oc(this.rdV.iYT);
        Log.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", this.rdV.iYT);
        AppMethodBeat.o(108777);
    }
}

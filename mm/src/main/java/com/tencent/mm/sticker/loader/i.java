package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/sticker/loader/StickerUrlTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "md5", "outputPath", "zipFile", "call", "", "onResult", "success", "", "uniqueId", "Companion", "plugin-sticker_release"})
public final class i extends g {
    public static final a NNX = new a((byte) 0);
    private final String NNW;
    private final String TAG = "MicroMsg.StickerUrlTask";
    private final String md5;
    private final String rpE;

    static {
        AppMethodBeat.i(105954);
        AppMethodBeat.o(105954);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(StickerLoadInfo stickerLoadInfo) {
        super(stickerLoadInfo);
        p.h(stickerLoadInfo, "info");
        AppMethodBeat.i(105953);
        this.md5 = stickerLoadInfo.Lb();
        StringBuilder sb = new StringBuilder();
        e eVar = e.NNN;
        this.rpE = sb.append(e.gyY()).append("preview/").toString();
        StringBuilder sb2 = new StringBuilder();
        e eVar2 = e.NNN;
        this.NNW = sb2.append(e.gyY()).append("preview.zip").toString();
        AppMethodBeat.o(105953);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0171  */
    @Override // com.tencent.mm.loader.g.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void call() {
        /*
        // Method dump skipped, instructions count: 398
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sticker.loader.i.call():void");
    }

    @Override // com.tencent.mm.sticker.loader.g
    public final void dQ(boolean z) {
        AppMethodBeat.i(105952);
        Log.i(this.TAG, "onResult: " + z + ", " + this.NNU.errType);
        super.dQ(z);
        AppMethodBeat.o(105952);
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        return this.md5;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/sticker/loader/StickerUrlTask$Companion;", "", "()V", "RET_EXPIRED", "", "RET_UNI_MISMATCH", "plugin-sticker_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

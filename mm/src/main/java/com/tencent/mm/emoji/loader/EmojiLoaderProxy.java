package com.tencent.mm.emoji.loader;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sticker.loader.StickerLoadInfo;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getArgs", "", "", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "(Landroid/os/Bundle;)[Ljava/lang/Object;", "load", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "loadRemote", "md5", "", "loadSticker", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadStickerRemote", "Companion", "plugin-emojisdk_release"})
public final class EmojiLoaderProxy extends com.tencent.mm.remoteservice.a {
    private static EmojiLoaderProxy gVO = new EmojiLoaderProxy(new d(MMApplicationContext.getContext()));
    private static int gVP;
    private static boolean gVQ = true;
    public static final a gVR = new a((byte) 0);
    private final d gVN;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "getInstance", "()Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "setInstance", "(Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;)V", "needCreate", "", "requestCount", "", "requestConnect", "", "tryRelease", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public EmojiLoaderProxy(d dVar) {
        super(dVar);
        this.gVN = dVar;
    }

    public final d getServerProxy() {
        return this.gVN;
    }

    static {
        AppMethodBeat.i(105409);
        AppMethodBeat.o(105409);
    }

    public final void load(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105404);
        p.h(emojiInfo, "emojiInfo");
        Log.i("MicroMsg.EmojiLoaderProxy", "load: " + emojiInfo.getMd5());
        REMOTE_CALL("loadRemote", emojiInfo.getMd5());
        AppMethodBeat.o(105404);
    }

    @f
    public final void loadRemote(String str) {
        AppMethodBeat.i(105405);
        p.h(str, "md5");
        Log.i("MicroMsg.EmojiLoaderProxy", "loadRemote: ".concat(String.valueOf(str)));
        bj gCJ = bj.gCJ();
        p.g(gCJ, "EmojiStorageMgr.getInstance()");
        EmojiInfo blk = gCJ.cgN().blk(str);
        if (blk == null) {
            AppMethodBeat.o(105405);
            return;
        }
        e eVar = e.gVM;
        e.e(blk);
        AppMethodBeat.o(105405);
    }

    public final void loadSticker(StickerLoadInfo stickerLoadInfo) {
        AppMethodBeat.i(105406);
        p.h(stickerLoadInfo, "info");
        Log.i("MicroMsg.EmojiLoaderProxy", "loadSticker: " + stickerLoadInfo.Lb());
        REMOTE_CALL("loadStickerRemote", stickerLoadInfo);
        AppMethodBeat.o(105406);
    }

    @f
    public final void loadStickerRemote(StickerLoadInfo stickerLoadInfo) {
        AppMethodBeat.i(105407);
        p.h(stickerLoadInfo, "info");
        Log.i("MicroMsg.EmojiLoaderProxy", "loadStickerRemote: " + stickerLoadInfo.Lb());
        e eVar = e.NNN;
        e.b(stickerLoadInfo);
        AppMethodBeat.o(105407);
    }

    @Override // com.tencent.mm.remoteservice.a
    public final Object[] getArgs(Bundle bundle) {
        AppMethodBeat.i(105408);
        if (bundle != null) {
            bundle.setClassLoader(StickerLoadInfo.class.getClassLoader());
        }
        Object[] args = super.getArgs(bundle);
        p.g(args, "super.getArgs(params)");
        AppMethodBeat.o(105408);
        return args;
    }
}

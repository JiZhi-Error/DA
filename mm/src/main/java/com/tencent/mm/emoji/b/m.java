package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.d.d;
import com.tencent.mm.emoji.d.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/emoji/model/EmojiUploadLogic;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getCallback", "()Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "setCallback", "(Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "emojiMgr", "Lcom/tencent/mm/pluginsdk/defimpl/IEmojiMgr;", "kotlin.jvm.PlatformType", "dealSaveSuccess", "", "gifMd5", "", "doUpload", "preCheck", "", "Companion", "EmojiUploadCallback", "plugin-emojisdk_release"})
public final class m {
    public static final a gXL = new a((byte) 0);
    EmojiInfo gWm;
    private final d gXJ;
    b gXK;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "", "uploadCallback", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
    public interface b {
        void z(int i2, String str);
    }

    static {
        AppMethodBeat.i(105522);
        AppMethodBeat.o(105522);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/emoji/model/EmojiUploadLogic$Companion;", "", "()V", "CAPTURE_EMOJI_UPLOAD_MAX_COUNT", "", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public m(EmojiInfo emojiInfo, b bVar) {
        boolean z;
        p.h(emojiInfo, "emojiInfo");
        AppMethodBeat.i(105521);
        this.gWm = emojiInfo;
        this.gXK = bVar;
        com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(ah, "plugin(IPluginEmoji::class.java)");
        this.gXJ = ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiMgr();
        if (!s.YS(this.gWm.hYx())) {
            b bVar2 = this.gXK;
            if (bVar2 != null) {
                bVar2.z(10, null);
            }
            z = false;
        } else if (s.boW(this.gWm.hYx()) > ((long) this.gXJ.d(this.gWm, true))) {
            b bVar3 = this.gXK;
            if (bVar3 != null) {
                bVar3.z(2, null);
            }
            z = false;
        } else {
            k kVar = k.gXr;
            if (k.auQ()) {
                if (this.gWm.hYt() < 5) {
                    this.gWm.hYu();
                    com.tencent.mm.kernel.b.a ah2 = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                    p.g(ah2, "MMKernel.plugin(IPluginEmoji::class.java)");
                    ((com.tencent.mm.plugin.emoji.b.d) ah2).getEmojiMgr().updateEmojiInfo(this.gWm);
                    b bVar4 = this.gXK;
                    if (bVar4 != null) {
                        bVar4.z(3, null);
                    }
                } else {
                    b bVar5 = this.gXK;
                    if (bVar5 != null) {
                        bVar5.z(9, null);
                    }
                }
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            Log.i("MicroMsg.EmojiUploadLogic", "start upload emoji");
            h hVar = h.hdL;
            h.a(this.gWm, true, new c(this));
        }
        AppMethodBeat.o(105521);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "errType", "", "gifMd5", "", "kotlin.jvm.PlatformType", "onResult"})
    static final class c implements d.a {
        final /* synthetic */ m gXM;

        c(m mVar) {
            this.gXM = mVar;
        }

        @Override // com.tencent.mm.emoji.d.d.a
        public final void A(int i2, String str) {
            AppMethodBeat.i(105520);
            if (i2 == 0) {
                m.a(this.gXM, str);
                AppMethodBeat.o(105520);
                return;
            }
            switch (i2) {
                case 2:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 11:
                    break;
                case 3:
                case 9:
                case 10:
                default:
                    if (this.gXM.gWm.hYt() >= 5) {
                        i2 = 9;
                        break;
                    } else {
                        this.gXM.gWm.hYu();
                        com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                        ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiMgr().updateEmojiInfo(this.gXM.gWm);
                        if (i2 != 3) {
                            i2 = 1;
                            break;
                        } else {
                            i2 = 3;
                            break;
                        }
                    }
            }
            b bVar = this.gXM.gXK;
            if (bVar != null) {
                bVar.z(i2, null);
                AppMethodBeat.o(105520);
                return;
            }
            AppMethodBeat.o(105520);
        }
    }

    public static final /* synthetic */ void a(m mVar, String str) {
        AppMethodBeat.i(105523);
        Log.i("MicroMsg.EmojiUploadLogic", "deal success ".concat(String.valueOf(str)));
        if (str != null && (!p.j(str, mVar.gWm.getMd5()))) {
            EmojiInfo amm = mVar.gXJ.amm(str);
            p.g(amm, "emojiMgr.getEmojiByMd5(gifMd5)");
            mVar.gWm = amm;
        }
        mVar.gXJ.a(mVar.gWm, false);
        com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d) ah).getProvider().t(mVar.gWm);
        b bVar = mVar.gXK;
        if (bVar != null) {
            bVar.z(0, str);
            AppMethodBeat.o(105523);
            return;
        }
        AppMethodBeat.o(105523);
    }
}

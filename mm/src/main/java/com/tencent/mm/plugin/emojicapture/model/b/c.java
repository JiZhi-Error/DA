package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.gif.g;
import com.tencent.mm.plugin.gif.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0017\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0019R\u000e\u0010\f\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "", "outputPath", "", "width", "", "height", "frameDurationMs", "", "outputGif", "", "(Ljava/lang/String;IIJZ)V", "TAG", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lcom/tencent/mm/plugin/gif/IAnimFileEncoder;", "gifEncoderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "saveRgbFrameCount", "startEncodeTick", "encodeFrame", "", "data", "", "finishEncode", "callback", "Lkotlin/Function0;", "Companion", "plugin-emojicapture_release"})
public final class c {
    public static final a rpF = new a((byte) 0);
    private final String TAG = "MicroMsg.EmojiMixGifEncoder";
    private final int height;
    private long ifQ;
    MMHandler rpB = new MMHandler("EmojiMixer_gifEncode");
    private com.tencent.mm.plugin.gif.a rpC;
    private int rpD = 30;
    private final String rpE;
    private final int width;

    static {
        AppMethodBeat.i(269);
        AppMethodBeat.o(269);
    }

    public c(String str, int i2, int i3, long j2, final boolean z) {
        p.h(str, "outputPath");
        AppMethodBeat.i(268);
        this.rpE = str;
        this.width = i2;
        this.height = i3;
        this.rpC = z ? new g(this.rpE, this.width, this.height, j2) : new j(this.rpE, this.width, this.height, j2);
        this.rpB.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.emojicapture.model.b.c.AnonymousClass1 */
            final /* synthetic */ c rpG;

            {
                this.rpG = r1;
            }

            public final void run() {
                AppMethodBeat.i(264);
                boolean init = this.rpG.rpC.init();
                Log.i(this.rpG.TAG, "init encoder, outputGif: " + z + " ret: " + init);
                if (!init) {
                    if (z) {
                        e eVar = e.roB;
                        e.cJe();
                    } else {
                        e eVar2 = e.roB;
                        e.cJd();
                    }
                }
                this.rpG.ifQ = Util.currentTicks();
                AppMethodBeat.o(264);
            }
        });
        AppMethodBeat.o(268);
    }

    public static /* synthetic */ void a(c cVar, byte[] bArr) {
        AppMethodBeat.i(267);
        p.h(bArr, "data");
        cVar.rpB.post(new b(cVar, bArr));
        AppMethodBeat.o(267);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ byte[] ihA;
        final /* synthetic */ c rpG;
        final /* synthetic */ long rpI = -1;

        b(c cVar, byte[] bArr) {
            this.rpG = cVar;
            this.ihA = bArr;
        }

        public final void run() {
            AppMethodBeat.i(265);
            long currentTicks = Util.currentTicks();
            Log.i(this.rpG.TAG, "encodeRgbaFrame used " + Util.ticksToNow(currentTicks) + ", ret:" + this.rpG.rpC.d(this.ihA, this.rpI));
            AppMethodBeat.o(265);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.c$c  reason: collision with other inner class name */
    public static final class RunnableC0979c implements Runnable {
        final /* synthetic */ kotlin.g.a.a ihE;
        final /* synthetic */ c rpG;

        RunnableC0979c(c cVar, kotlin.g.a.a aVar) {
            this.rpG = cVar;
            this.ihE = aVar;
        }

        public final void run() {
            AppMethodBeat.i(266);
            long currentTicks = Util.currentTicks();
            Log.i(this.rpG.TAG, "finishEncode used " + Util.ticksToNow(currentTicks) + ", ret:" + this.rpG.rpC.dXw() + ", totally used " + Util.ticksToNow(this.rpG.ifQ) + LocaleUtil.MALAY);
            this.rpG.rpB.quit();
            kotlin.g.a.a aVar = this.ihE;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(266);
                return;
            }
            AppMethodBeat.o(266);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder$Companion;", "", "()V", "EMOJI_MIX_WXAM_QP", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory;", "", "()V", "Companion", "plugin-emojisdk_release"})
public final class MMGIFJNIFactory {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory$Companion;", "", "()V", "TAG", "", "decodeThumb", "Landroid/graphics/Bitmap;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "byteArray", "", "getDecoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "md5", "isValid", "", "decoder", "plugin-emojisdk_release"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }

        public final d getDecoder(String str) {
            AppMethodBeat.i(199864);
            p.h(str, "md5");
            bj gCJ = bj.gCJ();
            p.g(gCJ, "EmojiStorageMgr.getInstance()");
            EmojiInfo blk = gCJ.cgN().blk(str);
            if (blk == null) {
                b bVar = new b();
                AppMethodBeat.o(199864);
                return bVar;
            }
            d decoder = getDecoder(blk);
            AppMethodBeat.o(199864);
            return decoder;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00d6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.emoji.decode.d getDecoder(com.tencent.mm.storage.emotion.EmojiInfo r7) {
            /*
            // Method dump skipped, instructions count: 222
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion.getDecoder(com.tencent.mm.storage.emotion.EmojiInfo):com.tencent.mm.emoji.decode.d");
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.emoji.decode.d getDecoder(byte[] r8) {
            /*
                r7 = this;
                r6 = 199865(0x30cb9, float:2.8007E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                r2 = 0
                if (r8 == 0) goto L_0x0060
                boolean r0 = com.tencent.mm.sdk.platformtools.ImgUtil.isWXGF(r8)     // Catch:{ MMGIFException -> 0x0039 }
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.emoji.decode.g r0 = new com.tencent.mm.emoji.decode.g     // Catch:{ MMGIFException -> 0x0039 }
                r0.<init>(r8)     // Catch:{ MMGIFException -> 0x0039 }
                com.tencent.mm.emoji.decode.d r0 = (com.tencent.mm.emoji.decode.d) r0     // Catch:{ MMGIFException -> 0x0039 }
            L_0x0016:
                if (r0 != 0) goto L_0x005c
                com.tencent.mm.emoji.decode.b r0 = new com.tencent.mm.emoji.decode.b
                r0.<init>()
                com.tencent.mm.emoji.decode.d r0 = (com.tencent.mm.emoji.decode.d) r0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            L_0x0022:
                return r0
            L_0x0023:
                boolean r0 = com.tencent.mm.sdk.platformtools.ImgUtil.isGif(r8)
                if (r0 == 0) goto L_0x0031
                com.tencent.mm.emoji.decode.f r0 = new com.tencent.mm.emoji.decode.f
                r0.<init>(r8)
                com.tencent.mm.emoji.decode.d r0 = (com.tencent.mm.emoji.decode.d) r0
                goto L_0x0016
            L_0x0031:
                com.tencent.mm.emoji.decode.e r0 = new com.tencent.mm.emoji.decode.e
                r0.<init>(r8)
                com.tencent.mm.emoji.decode.d r0 = (com.tencent.mm.emoji.decode.d) r0
                goto L_0x0016
            L_0x0039:
                r1 = move-exception
                java.lang.String r3 = com.tencent.mm.emoji.decode.MMGIFJNIFactory.access$getTAG$cp()
                r0 = r1
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                java.lang.String r4 = "decode bytes error"
                r5 = 0
                java.lang.Object[] r5 = new java.lang.Object[r5]
                com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r3, r0, r4, r5)
                int r0 = r1.getErrorCode()
                r1 = 103(0x67, float:1.44E-43)
                if (r0 != r1) goto L_0x0060
                if (r8 == 0) goto L_0x0060
                com.tencent.mm.emoji.decode.e r0 = new com.tencent.mm.emoji.decode.e
                r0.<init>(r8)
                com.tencent.mm.emoji.decode.d r0 = (com.tencent.mm.emoji.decode.d) r0
                goto L_0x0016
            L_0x005c:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                goto L_0x0022
            L_0x0060:
                r0 = r2
                goto L_0x0016
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion.getDecoder(byte[]):com.tencent.mm.emoji.decode.d");
        }

        public final boolean isValid(d dVar) {
            return dVar != null && !(dVar instanceof b);
        }

        public final Bitmap decodeThumb(EmojiInfo emojiInfo) {
            AppMethodBeat.i(177050);
            p.h(emojiInfo, "emojiInfo");
            d decoder = getDecoder(emojiInfo);
            if (isValid(decoder)) {
                decoder.auo();
                Bitmap frame = decoder.getFrame();
                decoder.destroy();
                AppMethodBeat.o(177050);
                return frame;
            }
            AppMethodBeat.o(177050);
            return null;
        }

        public final Bitmap decodeThumb(byte[] bArr) {
            AppMethodBeat.i(199866);
            d decoder = getDecoder(bArr);
            if (isValid(decoder)) {
                decoder.auo();
                Bitmap frame = decoder.getFrame();
                decoder.destroy();
                AppMethodBeat.o(199866);
                return frame;
            }
            AppMethodBeat.o(199866);
            return null;
        }
    }

    static {
        AppMethodBeat.i(105375);
        AppMethodBeat.o(105375);
    }
}

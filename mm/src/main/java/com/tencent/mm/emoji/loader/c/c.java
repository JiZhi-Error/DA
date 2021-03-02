package com.tencent.mm.emoji.loader.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.d;
import com.tencent.mm.emoji.decode.g;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bJ5\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher;", "", "()V", "fetch", "Lcom/tencent/mm/emoji/loader/request/Request;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetchInternal", "readFromCache", "Companion", "plugin-emojisdk_release"})
public final class c {
    public static final a gWc = new a((byte) 0);

    static {
        AppMethodBeat.i(105427);
        AppMethodBeat.o(105427);
    }

    public static final boolean f(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105429);
        boolean f2 = a.f(emojiInfo);
        AppMethodBeat.o(105429);
        return f2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "success", "", "config", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "invoke"})
    static final class b extends q implements m<Boolean, e, x> {
        final /* synthetic */ c gWd;
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ EmojiInfo gWf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, kotlin.g.a.b bVar, EmojiInfo emojiInfo) {
            super(2);
            this.gWd = cVar;
            this.gWe = bVar;
            this.gWf = emojiInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, e eVar) {
            AppMethodBeat.i(105423);
            e eVar2 = eVar;
            if (!bool.booleanValue() || eVar2 == null) {
                kotlin.g.a.b bVar = this.gWe;
                if (bVar != null) {
                    bVar.invoke(Boolean.FALSE);
                }
            } else {
                c.c(this.gWf, this.gWe);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105423);
            return xVar;
        }
    }

    public static final /* synthetic */ void c(EmojiInfo emojiInfo, kotlin.g.a.b bVar) {
        AppMethodBeat.i(105428);
        b(emojiInfo, bVar);
        AppMethodBeat.o(105428);
    }

    private static void b(EmojiInfo emojiInfo, kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(105426);
        if (!Util.isNullOrNil(emojiInfo.field_thumbUrl)) {
            Log.i("MicroMsg.EmojiCoverFetcher", "loadDataImp: load by url " + emojiInfo.getMd5());
            com.tencent.mm.av.a.d.b OV = new com.tencent.mm.plugin.emoji.d.a().OV(emojiInfo.field_thumbUrl);
            if ((OV != null ? OV.data : null) != null) {
                Bitmap decodeByteArray = BitmapUtil.decodeByteArray(OV.data);
                com.tencent.mm.emoji.loader.a.b bVar2 = com.tencent.mm.emoji.loader.a.b.gVU;
                com.tencent.mm.emoji.loader.a.b.put(emojiInfo.getMd5(), decodeByteArray);
                s.C(emojiInfo.hYy(), OV.data);
                if (bVar != null) {
                    bVar.invoke(Boolean.TRUE);
                    AppMethodBeat.o(105426);
                    return;
                }
                AppMethodBeat.o(105426);
            } else if (bVar != null) {
                bVar.invoke(Boolean.FALSE);
                AppMethodBeat.o(105426);
            } else {
                AppMethodBeat.o(105426);
            }
        } else {
            Log.i("MicroMsg.EmojiCoverFetcher", "loadDataImp: load by gif " + emojiInfo.getMd5());
            e eVar = e.gVM;
            e.a(emojiInfo, false, (i.a) new C0326c(emojiInfo, bVar));
            AppMethodBeat.o(105426);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$fetchInternal$1", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "onResult", "", "success", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.loader.c.c$c  reason: collision with other inner class name */
    public static final class C0326c implements i.a {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ EmojiInfo gWf;

        C0326c(EmojiInfo emojiInfo, kotlin.g.a.b bVar) {
            this.gWf = emojiInfo;
            this.gWe = bVar;
        }

        @Override // com.tencent.mm.emoji.loader.d.i.a
        public final void dQ(boolean z) {
            AppMethodBeat.i(105424);
            Log.i("MicroMsg.EmojiCoverFetcher", "onResult: " + this.gWf.getMd5() + ", " + z);
            if (z) {
                a aVar = c.gWc;
                if (a.f(this.gWf)) {
                    kotlin.g.a.b bVar = this.gWe;
                    if (bVar != null) {
                        bVar.invoke(Boolean.TRUE);
                        AppMethodBeat.o(105424);
                        return;
                    }
                    AppMethodBeat.o(105424);
                    return;
                }
                kotlin.g.a.b bVar2 = this.gWe;
                if (bVar2 != null) {
                    bVar2.invoke(Boolean.FALSE);
                    AppMethodBeat.o(105424);
                    return;
                }
                AppMethodBeat.o(105424);
                return;
            }
            kotlin.g.a.b bVar3 = this.gWe;
            if (bVar3 != null) {
                bVar3.invoke(Boolean.FALSE);
                AppMethodBeat.o(105424);
                return;
            }
            AppMethodBeat.o(105424);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$Companion;", "", "()V", "ThumbSize", "", "createThumb", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean f(EmojiInfo emojiInfo) {
            Bitmap frame;
            byte[] bn;
            AppMethodBeat.i(105422);
            p.h(emojiInfo, "emojiInfo");
            Log.i("MicroMsg.EmojiCoverFetcher", "createThumb: " + emojiInfo.getMd5());
            d decoder = MMGIFJNIFactory.Companion.getDecoder(emojiInfo);
            if (!MMGIFJNIFactory.Companion.isValid(decoder)) {
                Log.w("MicroMsg.EmojiCoverFetcher", "createThumb: invalid decoder");
                decoder.destroy();
                AppMethodBeat.o(105422);
                return false;
            }
            if (!(decoder instanceof g) || decoder.aup() != 1) {
                decoder.auo();
                frame = decoder.getFrame();
                decoder.destroy();
            } else {
                decoder.destroy();
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginEmoji.class);
                p.g(ah, "MMKernel.plugin(PluginEmoji::class.java)");
                byte[] a2 = ((PluginEmoji) ah).getProvider().a(emojiInfo);
                if (a2 == null || (bn = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).bn(a2)) == null) {
                    frame = null;
                } else {
                    frame = BitmapUtil.decodeByteArray(bn);
                }
            }
            if (frame == null) {
                Log.e("MicroMsg.EmojiCoverFetcher", "bitmap is null");
                AppMethodBeat.o(105422);
                return false;
            }
            try {
                BitmapUtil.saveBitmapToImage(frame, 100, Bitmap.CompressFormat.PNG, emojiInfo.hYy(), false);
                if ((frame.getWidth() > 120 || frame.getHeight() > 120) && (frame = BitmapUtil.extractThumbNail(frame, 120, 120, false, true)) == null) {
                    AppMethodBeat.o(105422);
                    return false;
                }
                com.tencent.mm.emoji.loader.a.b bVar = com.tencent.mm.emoji.loader.a.b.gVU;
                com.tencent.mm.emoji.loader.a.b.put(emojiInfo.getMd5(), frame);
                AppMethodBeat.o(105422);
                return true;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.EmojiCoverFetcher", e2, "saveBitmapToImage failed", new Object[0]);
                AppMethodBeat.o(105422);
                return false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00da, code lost:
        if (r0.getHeight() > 120) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e0, code lost:
        if (r0 == null) goto L_0x00cd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.emoji.loader.d.i<?> a(com.tencent.mm.storage.emotion.EmojiInfo r8, kotlin.g.a.b<? super java.lang.Boolean, kotlin.x> r9) {
        /*
        // Method dump skipped, instructions count: 260
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.loader.c.c.a(com.tencent.mm.storage.emotion.EmojiInfo, kotlin.g.a.b):com.tencent.mm.emoji.loader.d.i");
    }
}

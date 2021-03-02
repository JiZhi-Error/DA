package com.tencent.mm.plugin.emojicapture.model.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.b.c;
import com.tencent.mm.plugin.emojicapture.ui.b.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001,BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010(\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\b\u0010)\u001a\u00020 H\u0002J-\u0010*\u001a\u00020 2%\b\u0002\u0010+\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixer;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "gifPath", "videoPlayRate", "", "removeBackground", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "outputGif", "timeEnter", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;Ljava/lang/String;IZLcom/tencent/mm/sticker/StickerPack;ZJ)V", "getEmojiFrameRetriever", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "frameCount", "gifEncoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "getGifPath", "()Ljava/lang/String;", "mixPixelBuffer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "mixTime", "onMixFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "startTick", "syncMgr", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "getTimeEnter", "()J", "videoDecoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "finishMix", "mixVideoFrame", "start", "mixFinish", "Companion", "plugin-emojicapture_release"})
public final class k {
    public static final a rqq = new a((byte) 0);
    int frameCount;
    long gXF;
    private final long hdz;
    final String lCj;
    final int rpK;
    final f rpM;
    final boolean rpN;
    private l rqi;
    com.tencent.mm.plugin.emojicapture.ui.b.c rqj;
    g rqk;
    c rql;
    kotlin.g.a.b<? super Boolean, x> rqm;
    private long rqn;
    final a rqo;
    final boolean rqp;
    final String videoPath;

    static {
        AppMethodBeat.i(TPNativePlayerInitConfig.INT_PIXEL_FORMAT);
        AppMethodBeat.o(TPNativePlayerInitConfig.INT_PIXEL_FORMAT);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "skipFrame", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ k rqr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(k kVar) {
            super(1);
            this.rqr = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(302);
            if (!bool.booleanValue()) {
                com.tencent.mm.plugin.emojicapture.ui.b.c e2 = k.e(this.rqr);
                AnonymousClass1 r0 = new kotlin.g.a.b<byte[], x>(this) {
                    /* class com.tencent.mm.plugin.emojicapture.model.b.k.c.AnonymousClass1 */
                    final /* synthetic */ c rqs;

                    {
                        this.rqs = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(byte[] bArr) {
                        AppMethodBeat.i(301);
                        byte[] bArr2 = bArr;
                        p.h(bArr2, LocaleUtil.ITALIAN);
                        k.c(this.rqs.rqr).cJx();
                        c cVar = this.rqs.rqr.rql;
                        if (cVar != null) {
                            c.a(cVar, bArr2);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(301);
                        return xVar;
                    }
                };
                com.tencent.mm.plugin.emojicapture.ui.b.d dVar = e2.rvZ;
                if (dVar == null) {
                    p.btv("renderer");
                }
                byte[] bArr = new byte[(dVar.ijY * dVar.ijZ * 4)];
                dVar.rwx.position(0);
                dVar.rwx.get(bArr);
                r0.invoke(bArr);
            } else {
                k.c(this.rqr).cJx();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(302);
            return xVar;
        }
    }

    public k(String str, a aVar, String str2, int i2, boolean z, f fVar, boolean z2, long j2) {
        p.h(str, "videoPath");
        p.h(aVar, "emojiFrameRetriever");
        p.h(str2, "gifPath");
        AppMethodBeat.i(309);
        this.videoPath = str;
        this.rqo = aVar;
        this.lCj = str2;
        this.rpK = i2;
        this.rqp = z;
        this.rpM = fVar;
        this.rpN = z2;
        this.hdz = j2;
        AppMethodBeat.o(309);
    }

    public static final /* synthetic */ l c(k kVar) {
        AppMethodBeat.i(312);
        l lVar = kVar.rqi;
        if (lVar == null) {
            p.btv("videoDecoder");
        }
        AppMethodBeat.o(312);
        return lVar;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.emojicapture.ui.b.c e(k kVar) {
        AppMethodBeat.i(313);
        com.tencent.mm.plugin.emojicapture.ui.b.c cVar = kVar.rqj;
        if (cVar == null) {
            p.btv("mixPixelBuffer");
        }
        AppMethodBeat.o(313);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixer$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ k rqr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(k kVar) {
            super(0);
            this.rqr = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(303);
            this.rqr.frameCount++;
            k.b(this.rqr);
            x xVar = x.SXb;
            AppMethodBeat.o(303);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ k rqr;
        final /* synthetic */ com.tencent.mm.plugin.sight.base.a rqt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(k kVar, com.tencent.mm.plugin.sight.base.a aVar) {
            super(0);
            this.rqr = kVar;
            this.rqt = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            i iVar;
            AppMethodBeat.i(TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_NULL);
            k kVar = this.rqr;
            if (com.tencent.mm.compatible.util.d.oD(23)) {
                Log.i("MicroMsg.EmojiMixer", "api level 23 user async decoder");
                String str = this.rqr.videoPath;
                com.tencent.mm.plugin.sight.base.a aVar = this.rqt;
                iVar = new j(str, aVar != null ? aVar.videoDuration : 0, k.e(this.rqr).cJV());
            } else {
                Log.i("MicroMsg.EmojiMixer", "api level below 23 user sync decoder");
                iVar = new i(this.rqr.videoPath, k.e(this.rqr).cJV());
            }
            kVar.rqi = iVar;
            k.c(this.rqr).rqx = AnonymousClass1.rqu;
            k.c(this.rqr).rqy = new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.emojicapture.model.b.k.e.AnonymousClass2 */
                final /* synthetic */ e rqv;

                {
                    this.rqv = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE);
                    k.e(this.rqv.rqr).k(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.emojicapture.model.b.k.e.AnonymousClass2.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass2 rqw;

                        {
                            this.rqw = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(TbsListener.ErrorCode.THROWABLE_QBSDK_INIT);
                            k.a(this.rqw.rqv.rqr, this.rqw.rqv.rqr.frameCount > 0);
                            com.tencent.mm.plugin.emojicapture.ui.b.c e2 = k.e(this.rqw.rqv.rqr);
                            e2.k(new c.a(e2));
                            x xVar = x.SXb;
                            AppMethodBeat.o(TbsListener.ErrorCode.THROWABLE_QBSDK_INIT);
                            return xVar;
                        }
                    });
                    x xVar = x.SXb;
                    AppMethodBeat.o(TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE);
                    return xVar;
                }
            };
            if (k.c(this.rqr).init() < 0) {
                com.tencent.mm.plugin.emojicapture.model.e eVar = com.tencent.mm.plugin.emojicapture.model.e.roB;
                com.tencent.mm.plugin.emojicapture.model.e.cIZ();
            }
            k.c(this.rqr).startDecode();
            x xVar = x.SXb;
            AppMethodBeat.o(TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_NULL);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(k kVar) {
        boolean z;
        com.tencent.mm.plugin.recordvideo.ui.editor.b.a cJu;
        AppMethodBeat.i(TPNativePlayerInitConfig.INT_WIDTH);
        com.tencent.mm.plugin.emojicapture.ui.b.c cVar = kVar.rqj;
        if (cVar == null) {
            p.btv("mixPixelBuffer");
        }
        g gVar = kVar.rqk;
        if (gVar == null) {
            p.btv("syncMgr");
        }
        int i2 = kVar.frameCount;
        Log.i(gVar.TAG, "after syncMixNextFrame, framePass " + i2 + ", videoPassFrame:" + gVar.CdP + ", targetPassFrame:" + gVar.CdU + ", emojiPassDuration: " + gVar.CdS);
        int i3 = i2 - 1;
        if (i3 > 0 && gVar.CdP < i3) {
            gVar.CdP = i3;
        }
        gVar.CdZ = gVar.CdY * ((float) gVar.CdU);
        gVar.CdX = gVar.CdW * ((float) gVar.CdP);
        while (gVar.CdZ >= gVar.CdS && (cJu = gVar.Cea.cJu()) != null && cJu.CgA > 0) {
            gVar.CdS += (float) cJu.CgA;
            gVar.CdR = cJu.bitmap;
        }
        Bitmap bitmap = gVar.CdR;
        if (gVar.CdW * ((float) gVar.CdP) < gVar.CdY * ((float) gVar.CdU)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.i(gVar.TAG, "syncMixNextFrame, skip frame");
        } else {
            gVar.CdU++;
            Log.i(gVar.TAG, "syncMixNextFrame pass frame: " + gVar.CdU);
        }
        gVar.CdP++;
        g.a aVar = new g.a(bitmap, z);
        c cVar2 = new c(kVar);
        Log.i(cVar.TAG, "mixVideoAndEmojiFrame, skip: " + Boolean.valueOf(aVar.dKD));
        if (p.j(Boolean.valueOf(aVar.dKD), Boolean.FALSE)) {
            com.tencent.mm.plugin.emojicapture.ui.b.d dVar = cVar.rvZ;
            if (dVar == null) {
                p.btv("renderer");
            }
            dVar.ika = aVar.Ceb;
            com.tencent.mm.plugin.emojicapture.ui.b.d dVar2 = cVar.rvZ;
            if (dVar2 == null) {
                p.btv("renderer");
            }
            GL10 gl10 = cVar.rvY;
            if (gl10 == null) {
                p.btv("gl");
            }
            dVar2.onDrawFrame(gl10);
            cVar2.invoke(Boolean.FALSE);
            AppMethodBeat.o(TPNativePlayerInitConfig.INT_WIDTH);
            return;
        }
        com.tencent.mm.plugin.emojicapture.ui.b.d dVar3 = cVar.rvZ;
        if (dVar3 == null) {
            p.btv("renderer");
        }
        dVar3.cJW().updateTexImage();
        cVar2.invoke(Boolean.TRUE);
        AppMethodBeat.o(TPNativePlayerInitConfig.INT_WIDTH);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean $success;
        final /* synthetic */ k rqr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(k kVar, boolean z) {
            super(0);
            this.rqr = kVar;
            this.$success = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(300);
            this.rqr.rqn = Util.milliSecondsToNow(this.rqr.gXF);
            Log.i("MicroMsg.EmojiMixer", "mix used " + this.rqr.rqn + "ms, frame:" + this.rqr.frameCount);
            if (this.$success) {
                com.tencent.mm.plugin.emojicapture.model.e eVar = com.tencent.mm.plugin.emojicapture.model.e.roB;
                com.tencent.mm.plugin.emojicapture.model.e.q(this.rqr.rqn, this.rqr.rqp);
            }
            kotlin.g.a.b bVar = this.rqr.rqm;
            if (bVar != null) {
                bVar.invoke(Boolean.valueOf(this.$success));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(300);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(k kVar, boolean z) {
        AppMethodBeat.i(314);
        c cVar = kVar.rql;
        if (cVar != null) {
            cVar.rpB.post(new c.RunnableC0979c(cVar, new b(kVar, z)));
            AppMethodBeat.o(314);
            return;
        }
        AppMethodBeat.o(314);
    }
}

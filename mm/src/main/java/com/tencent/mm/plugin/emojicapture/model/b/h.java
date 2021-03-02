package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.model.b.k;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.ui.b.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.g;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "mixInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "(Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;)V", "TAG", "", "mixCost", "", "getMixCost", "()J", "setMixCost", "(J)V", "getMixInfo", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "timeEnter", "getTimeEnter", "call", "", "handleResult", "success", "", "uniqueId", "plugin-emojicapture_release"})
public final class h extends c {
    final String TAG = "MicroMsg.EmojiMixTask";
    final long hdz = this.rpW.hdz;
    long rpV;
    final d rpW;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class a extends q implements b<Boolean, x> {
        final /* synthetic */ h rpX;
        final /* synthetic */ long rpY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(h hVar, long j2) {
            super(1);
            this.rpX = hVar;
            this.rpY = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(277);
            boolean booleanValue = bool.booleanValue();
            Log.i(this.rpX.TAG, String.valueOf(this.rpX.hdz) + " mix end: " + this.rpX.rpW.rpE + ' ' + booleanValue);
            this.rpX.rpW.rpJ.stop();
            this.rpX.rpV = Util.milliSecondsToNow(this.rpY);
            if (booleanValue) {
                h.a(this.rpX, true);
                this.rpX.a(j.OK);
            } else {
                h.a(this.rpX, false);
                this.rpX.a(j.Fail);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(277);
            return xVar;
        }
    }

    public h(d dVar) {
        p.h(dVar, "mixInfo");
        AppMethodBeat.i(280);
        this.rpW = dVar;
        AppMethodBeat.o(280);
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        double d2;
        Integer num = null;
        boolean z = true;
        AppMethodBeat.i(278);
        k kVar = new k(this.rpW.videoPath, this.rpW.rpJ, this.rpW.rpE, this.rpW.rpK, this.rpW.rpL, this.rpW.rpM, this.rpW.rpN, this.rpW.hdz);
        long nowMilliSecond = Util.nowMilliSecond();
        for (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a aVar : this.rpW.rpJ.rpx) {
            aVar.init();
        }
        EmojiCaptureReporter.Gi(37);
        a aVar2 = new a(this, nowMilliSecond);
        kVar.gXF = System.currentTimeMillis();
        com.tencent.mm.plugin.sight.base.a aNx = e.aNx(kVar.videoPath);
        if ((aNx != null ? Integer.valueOf(aNx.frameRate) : null) instanceof Integer) {
            d2 = 1000.0d / ((double) aNx.frameRate);
        } else {
            d2 = 0.0d;
        }
        kVar.rqm = aVar2;
        StringBuilder sb = new StringBuilder("start decode ");
        Thread currentThread = Thread.currentThread();
        p.g(currentThread, "Thread.currentThread()");
        StringBuilder append = sb.append(currentThread.getId()).append(", fps: ").append(aNx != null ? Integer.valueOf(aNx.frameRate) : null).append(", duration: ");
        if (aNx != null) {
            num = Integer.valueOf(aNx.videoDuration);
        }
        Log.i("MicroMsg.EmojiMixer", append.append(num).append(", videoFrameDuration: ").append(d2).append(", removeBackground:").append(kVar.rqp).append(", path: ").append(kVar.videoPath).toString());
        kVar.frameCount = 0;
        com.tencent.mm.plugin.emojicapture.model.e eVar = com.tencent.mm.plugin.emojicapture.model.e.roB;
        com.tencent.mm.plugin.emojicapture.model.e.b(kVar.rqp, kVar.rpM != null, kVar.rpK > 1, aNx != null ? aNx.videoDuration : 0);
        if (kVar.rpN) {
            com.tencent.mm.plugin.emojicapture.model.e eVar2 = com.tencent.mm.plugin.emojicapture.model.e.roB;
            com.tencent.mm.plugin.emojicapture.model.e.cJc();
        } else {
            com.tencent.mm.plugin.emojicapture.model.e eVar3 = com.tencent.mm.plugin.emojicapture.model.e.roB;
            com.tencent.mm.plugin.emojicapture.model.e.cJb();
        }
        kVar.rqk = new b(kVar.videoPath, kVar.rqo, kVar.rpK);
        if (!Util.isNullOrNil(kVar.lCj)) {
            String str = kVar.lCj;
            d.a aVar3 = d.roA;
            int i2 = d.roz;
            d.a aVar4 = d.roA;
            int i3 = d.roz;
            g gVar = kVar.rqk;
            if (gVar == null) {
                p.btv("syncMgr");
            }
            kVar.rql = new c(str, i2, i3, (long) gVar.CdY, kVar.rpN);
        }
        d.a aVar5 = d.roA;
        int i4 = d.roz;
        d.a aVar6 = d.roA;
        int i5 = d.roz;
        if (kVar.rpN) {
            z = false;
        }
        kVar.rqj = new com.tencent.mm.plugin.emojicapture.ui.b.c(i4, i5, z, kVar.rpM);
        com.tencent.mm.plugin.emojicapture.ui.b.c cVar = kVar.rqj;
        if (cVar == null) {
            p.btv("mixPixelBuffer");
        }
        cVar.rwd = new k.d(kVar);
        com.tencent.mm.plugin.emojicapture.ui.b.c cVar2 = kVar.rqj;
        if (cVar2 == null) {
            p.btv("mixPixelBuffer");
        }
        cVar2.rwb.post(new c.b(cVar2, kVar.rqp, new k.e(kVar, aNx)));
        AppMethodBeat.o(278);
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(279);
        String valueOf = String.valueOf(this.hdz);
        AppMethodBeat.o(279);
        return valueOf;
    }

    public static final /* synthetic */ void a(h hVar, boolean z) {
        AppMethodBeat.i(281);
        if (z) {
            if (!com.tencent.mm.plugin.emojicapture.ui.c.Gr(hVar.rpW.scene)) {
                com.tencent.mm.emoji.d.b bVar = com.tencent.mm.emoji.d.b.hdv;
                com.tencent.mm.emoji.d.b.b(hVar.rpW.hdz, true, null);
            }
            EmojiCaptureProxy.a aVar = EmojiCaptureProxy.rrF;
            EmojiCaptureProxy emojiCaptureProxy = EmojiCaptureProxy.rrE;
            String str = hVar.rpW.rpE;
            String md5 = hVar.rpW.gWm.getMd5();
            p.g(md5, "mixInfo.emojiInfo.md5");
            emojiCaptureProxy.postUploadTask(str, md5);
            EmojiCaptureReporter.g(hVar.hdz, hVar.rpV, hVar.rpW.scene);
            EmojiCaptureReporter.fE(38, (int) hVar.rpV);
            AppMethodBeat.o(281);
            return;
        }
        com.tencent.mm.emoji.d.b bVar2 = com.tencent.mm.emoji.d.b.hdv;
        com.tencent.mm.emoji.d.b.b(hVar.rpW.hdz, false, null);
        hVar.rpW.gWm.a(EmojiInfo.b.ERR_MIX_VIDEO_ZERO_FRAME);
        hVar.rpW.gWm.a(EmojiInfo.a.STATUS_MIX_FAIL);
        EmojiCaptureProxy.a aVar2 = EmojiCaptureProxy.rrF;
        EmojiCaptureProxy.rrE.updateEmojiInfo(hVar.rpW.gWm);
        EmojiCaptureReporter.g(hVar.hdz, 3, hVar.rpW.scene);
        AppMethodBeat.o(281);
    }
}

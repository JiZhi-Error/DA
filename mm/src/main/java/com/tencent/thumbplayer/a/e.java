package com.tencent.thumbplayer.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.utils.g;

public final class e implements c.a, c.b, c.AbstractC2201c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.k, c.l, c.m {
    private c.f RVZ;
    private c.AbstractC2201c RWa;
    private c.e RWb;
    private c.d RWc;
    private c.g RWd;
    private c.m RWe;
    private c.i RWf;
    private c.k RWg;
    private c.a RWh;
    private c.j RWi;
    private c.l RWj;
    private c.b RWk;
    c.h RWl;
    a RWm;
    private String mTag = "TPPlayerListenerS";

    public e(String str) {
        AppMethodBeat.i(188707);
        bqx(str);
        this.RWm = new a(this.mTag);
        this.RVZ = this.RWm;
        this.RWa = this.RWm;
        this.RWb = this.RWm;
        this.RWc = this.RWm;
        this.RWd = this.RWm;
        this.RWe = this.RWm;
        this.RWf = this.RWm;
        this.RWg = this.RWm;
        this.RWh = this.RWm;
        this.RWi = this.RWm;
        this.RWj = this.RWm;
        this.RWk = this.RWm;
        AppMethodBeat.o(188707);
    }

    public final void bqx(String str) {
        AppMethodBeat.i(188708);
        if (TextUtils.isEmpty(str)) {
            this.mTag = "TPPlayerListenerS";
        } else {
            this.mTag = str;
        }
        if (this.RWm != null) {
            this.RWm.mTag = this.mTag;
        }
        AppMethodBeat.o(188708);
    }

    @Override // com.tencent.thumbplayer.a.a.c.f
    public final void tf() {
        AppMethodBeat.i(188709);
        this.RVZ.tf();
        AppMethodBeat.o(188709);
    }

    @Override // com.tencent.thumbplayer.a.a.c.AbstractC2201c
    public final void onCompletion() {
        AppMethodBeat.i(188710);
        this.RWa.onCompletion();
        AppMethodBeat.o(188710);
    }

    @Override // com.tencent.thumbplayer.a.a.c.e
    public final void a(int i2, long j2, long j3, Object obj) {
        AppMethodBeat.i(188711);
        this.RWb.a(i2, j2, j3, obj);
        AppMethodBeat.o(188711);
    }

    @Override // com.tencent.thumbplayer.a.a.c.d
    public final void a(@TPCommonEnum.TPErrorType int i2, int i3, long j2, long j3) {
        AppMethodBeat.i(188712);
        this.RWc.a(i2, i3, j2, j3);
        AppMethodBeat.o(188712);
    }

    @Override // com.tencent.thumbplayer.a.a.c.g
    public final void cJH() {
        AppMethodBeat.i(188713);
        this.RWd.cJH();
        AppMethodBeat.o(188713);
    }

    @Override // com.tencent.thumbplayer.a.a.c.m
    public final void aI(long j2, long j3) {
        AppMethodBeat.i(188714);
        this.RWe.aI(j2, j3);
        AppMethodBeat.o(188714);
    }

    @Override // com.tencent.thumbplayer.a.a.c.i
    public final void a(TPSubtitleData tPSubtitleData) {
        AppMethodBeat.i(188715);
        this.RWf.a(tPSubtitleData);
        AppMethodBeat.o(188715);
    }

    @Override // com.tencent.thumbplayer.a.a.c.j
    public final void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
        AppMethodBeat.i(188716);
        this.RWi.a(tPSubtitleFrameBuffer);
        AppMethodBeat.o(188716);
    }

    @Override // com.tencent.thumbplayer.a.a.c.k
    public final void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
        AppMethodBeat.i(188717);
        this.RWg.a(tPVideoFrameBuffer);
        AppMethodBeat.o(188717);
    }

    @Override // com.tencent.thumbplayer.a.a.c.a
    public final void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
        AppMethodBeat.i(188718);
        this.RWh.a(tPAudioFrameBuffer);
        AppMethodBeat.o(188718);
    }

    @Override // com.tencent.thumbplayer.a.a.c.l
    public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        AppMethodBeat.i(188719);
        TPPostProcessFrameBuffer a2 = this.RWj.a(tPPostProcessFrameBuffer);
        AppMethodBeat.o(188719);
        return a2;
    }

    @Override // com.tencent.thumbplayer.a.a.c.b
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        AppMethodBeat.i(188720);
        TPPostProcessFrameBuffer b2 = this.RWk.b(tPPostProcessFrameBuffer);
        AppMethodBeat.o(188720);
        return b2;
    }

    @Override // com.tencent.thumbplayer.a.a.c.h
    public final void onStateChange(int i2, int i3) {
        AppMethodBeat.i(188721);
        this.RWl.onStateChange(i2, i3);
        AppMethodBeat.o(188721);
    }

    public final void a(c.f fVar) {
        if (fVar == null) {
            fVar = this.RWm;
        }
        this.RVZ = fVar;
    }

    public final void a(c.AbstractC2201c cVar) {
        if (cVar == null) {
            cVar = this.RWm;
        }
        this.RWa = cVar;
    }

    public final void a(c.e eVar) {
        if (eVar == null) {
            eVar = this.RWm;
        }
        this.RWb = eVar;
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            dVar = this.RWm;
        }
        this.RWc = dVar;
    }

    public final void a(c.g gVar) {
        if (gVar == null) {
            gVar = this.RWm;
        }
        this.RWd = gVar;
    }

    public final void a(c.m mVar) {
        if (mVar == null) {
            mVar = this.RWm;
        }
        this.RWe = mVar;
    }

    public final void a(c.i iVar) {
        if (iVar == null) {
            iVar = this.RWm;
        }
        this.RWf = iVar;
    }

    public final void a(c.j jVar) {
        if (jVar == null) {
            jVar = this.RWm;
        }
        this.RWi = jVar;
    }

    public final void a(c.k kVar) {
        if (kVar == null) {
            kVar = this.RWm;
        }
        this.RWg = kVar;
    }

    public final void b(c.a aVar) {
        if (aVar == null) {
            aVar = this.RWm;
        }
        this.RWh = aVar;
    }

    public final void b(c.l lVar) {
        if (lVar == null) {
            lVar = this.RWm;
        }
        this.RWj = lVar;
    }

    public final void b(c.b bVar) {
        if (bVar == null) {
            bVar = this.RWm;
        }
        this.RWk = bVar;
    }

    public final void clear() {
        this.RVZ = this.RWm;
        this.RWa = this.RWm;
        this.RWb = this.RWm;
        this.RWc = this.RWm;
        this.RWd = this.RWm;
        this.RWe = this.RWm;
        this.RWf = this.RWm;
        this.RWg = this.RWm;
        this.RWh = this.RWm;
        this.RWi = this.RWm;
        this.RWl = this.RWm;
        this.RWj = this.RWm;
        this.RWk = this.RWm;
    }

    /* access modifiers changed from: package-private */
    public static class a implements c.a, c.b, c.AbstractC2201c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.k, c.l, c.m {
        String mTag;

        public a(String str) {
            this.mTag = str;
        }

        @Override // com.tencent.thumbplayer.a.a.c.f
        public final void tf() {
            AppMethodBeat.i(188694);
            g.i(this.mTag, " empty base listener , notify , onPrepared");
            AppMethodBeat.o(188694);
        }

        @Override // com.tencent.thumbplayer.a.a.c.AbstractC2201c
        public final void onCompletion() {
            AppMethodBeat.i(188695);
            g.i(this.mTag, " empty base listener , notify , onCompletion");
            AppMethodBeat.o(188695);
        }

        @Override // com.tencent.thumbplayer.a.a.c.e
        public final void a(int i2, long j2, long j3, Object obj) {
            AppMethodBeat.i(188696);
            g.i(this.mTag, " empty base listener , notify , onInfo");
            AppMethodBeat.o(188696);
        }

        @Override // com.tencent.thumbplayer.a.a.c.d
        public final void a(int i2, int i3, long j2, long j3) {
            AppMethodBeat.i(188697);
            g.i(this.mTag, " empty base listener , notify , onError");
            AppMethodBeat.o(188697);
        }

        @Override // com.tencent.thumbplayer.a.a.c.g
        public final void cJH() {
            AppMethodBeat.i(188698);
            g.i(this.mTag, " empty base listener , notify , onSeekComplete");
            AppMethodBeat.o(188698);
        }

        @Override // com.tencent.thumbplayer.a.a.c.m
        public final void aI(long j2, long j3) {
            AppMethodBeat.i(188699);
            g.i(this.mTag, " empty base listener , notify , onVideoSizeChanged");
            AppMethodBeat.o(188699);
        }

        @Override // com.tencent.thumbplayer.a.a.c.i
        public final void a(TPSubtitleData tPSubtitleData) {
            AppMethodBeat.i(188700);
            g.i(this.mTag, " empty base listener , notify , onSubtitleData");
            AppMethodBeat.o(188700);
        }

        @Override // com.tencent.thumbplayer.a.a.c.j
        public final void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            AppMethodBeat.i(188701);
            g.i(this.mTag, " empty base listener , notify , TPSubtitleFrameBuffer");
            AppMethodBeat.o(188701);
        }

        @Override // com.tencent.thumbplayer.a.a.c.k
        public final void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
            AppMethodBeat.i(188702);
            g.i(this.mTag, " empty base listener , notify , onVideoFrameOut");
            AppMethodBeat.o(188702);
        }

        @Override // com.tencent.thumbplayer.a.a.c.a
        public final void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
            AppMethodBeat.i(188703);
            g.i(this.mTag, " empty base listener , notify , onAudioFrameOut");
            AppMethodBeat.o(188703);
        }

        @Override // com.tencent.thumbplayer.a.a.c.l
        public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            AppMethodBeat.i(188704);
            g.i(this.mTag, " empty base listener , notify , onVideoProcessFrameOut");
            AppMethodBeat.o(188704);
            return null;
        }

        @Override // com.tencent.thumbplayer.a.a.c.b
        public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            AppMethodBeat.i(188705);
            g.i(this.mTag, " empty base listener , notify , onAudioProcessFrameOut");
            AppMethodBeat.o(188705);
            return null;
        }

        @Override // com.tencent.thumbplayer.a.a.c.h
        public final void onStateChange(int i2, int i3) {
            AppMethodBeat.i(188706);
            g.i(this.mTag, " empty base listener , notify , onStateChange");
            AppMethodBeat.o(188706);
        }
    }
}

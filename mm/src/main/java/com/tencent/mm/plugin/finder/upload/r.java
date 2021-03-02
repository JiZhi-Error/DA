package com.tencent.mm.plugin.finder.upload;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.upload.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0002J6\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u001e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "mainFinderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getMainFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setMainFinderObj", "failTask", "", "getAudioQualityLevel", "", "input", "", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, "samplerate", WeChatBrands.Business.GROUP_CHANNELS, "", "enableAuQA", "", "useOriAu", "saveToDb", "start", "uniqueId", "updateProgress", "avgProgress", FirebaseAnalytics.b.INDEX, "size", "Companion", "plugin-finder_release"})
public final class r extends j {
    public static final a vTH = new a((byte) 0);
    FinderItem vTG;

    static {
        AppMethodBeat.i(253147);
        AppMethodBeat.o(253147);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke", "com/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask$start$3$1"})
    static final class b extends q implements kotlin.g.a.b<Float, x> {
        final /* synthetic */ int puW;
        final /* synthetic */ int tBf;
        final /* synthetic */ z.c vRU;
        final /* synthetic */ r vTI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(z.c cVar, int i2, r rVar, int i3) {
            super(1);
            this.vRU = cVar;
            this.puW = i2;
            this.vTI = rVar;
            this.tBf = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Float f2) {
            AppMethodBeat.i(253139);
            float floatValue = f2.floatValue();
            if (floatValue - this.vRU.SYD > 0.1f) {
                this.vTI.d(floatValue, this.puW, this.tBf);
                this.vRU.SYD = floatValue;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253139);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "result", "", "invoke", "com/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask$start$3$videoQuality$1"})
    static final class c extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ int tBf;
        final /* synthetic */ Object tpZ;
        final /* synthetic */ z.a tqa;
        final /* synthetic */ z.d vRW;
        final /* synthetic */ FinderMediaReportObject vRX;
        final /* synthetic */ String vRZ;
        final /* synthetic */ aco vSa;
        final /* synthetic */ VideoTransPara vSb;
        final /* synthetic */ r vTI;
        final /* synthetic */ long vTJ;
        final /* synthetic */ acn vTK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(z.d dVar, long j2, FinderMediaReportObject finderMediaReportObject, String str, aco aco, VideoTransPara videoTransPara, acn acn, Object obj, z.a aVar, r rVar, int i2) {
            super(1);
            this.vRW = dVar;
            this.vTJ = j2;
            this.vRX = finderMediaReportObject;
            this.vRZ = str;
            this.vSa = aco;
            this.vSb = videoTransPara;
            this.vTK = acn;
            this.tpZ = obj;
            this.tqa = aVar;
            this.vTI = rVar;
            this.tBf = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            int i2 = -1;
            AppMethodBeat.i(253140);
            boolean booleanValue = bool.booleanValue();
            z.d dVar = this.vRW;
            if (!booleanValue) {
                Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "remuxer failed localId:" + this.vTI.vTG.getLocalId() + ", cost:" + Util.ticksToNow(this.vTJ));
                r.c cVar = r.c.vhb;
                r.c.nU(false);
                this.vRX.remuxTime = (int) Util.ticksToNow(this.vTJ);
                this.vRX.remuxRetCode = -1;
            } else {
                this.vRX.remuxTime = (int) Util.ticksToNow(this.vTJ);
                this.vRX.remuxRetCode = 0;
                r.c cVar2 = r.c.vhb;
                r.c.u(Util.ticksToNow(this.vTJ), false);
                Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "remuxer succ, cost: " + Util.ticksToNow(this.vTJ) + ", path:" + this.vRZ + " localId:" + this.vTI.vTG.getLocalId());
                long boW = s.boW(this.vRZ);
                long currentTicks = Util.currentTicks();
                c.a aVar = c.vRQ;
                int a2 = c.a.a(this.vRZ, this.vSa.targetWidth, this.vSa.targetHeight, this.vSb, this.vTI.vTG.getLocalId(), false);
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (boW > com.tencent.mm.plugin.finder.storage.c.dqI()) {
                    com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.dtH() != 1) {
                        this.vRX.zipTime = (int) Util.ticksToNow(currentTicks);
                        if (a2 == 0) {
                            this.vRX.zipRetCode = 1;
                        } else {
                            this.vRX.zipRetCode = 2;
                        }
                    }
                }
                if (!TextUtils.isEmpty(this.vTK.iiv) || this.vTK.Lnd.size() > 1 || this.vTK.Gxx.Lna.size() > 0 || this.vTK.Gxx.Lnb) {
                    com.tencent.mm.plugin.recordvideo.e.c cVar5 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                    com.tencent.mm.plugin.recordvideo.e.c.aLJ(this.vRZ);
                }
                i2 = a2;
            }
            dVar.SYE = i2;
            synchronized (this.tpZ) {
                try {
                    this.tqa.SYB = true;
                    this.tpZ.notify();
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(253140);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(253140);
            return xVar2;
        }
    }

    public r(FinderItem finderItem) {
        p.h(finderItem, "mainFinderObj");
        AppMethodBeat.i(253146);
        this.vTG = finderItem;
        AppMethodBeat.o(253146);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d7  */
    @Override // com.tencent.mm.plugin.finder.upload.j
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void start() {
        /*
        // Method dump skipped, instructions count: 1738
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.r.start():void");
    }

    public final void d(float f2, int i2, int i3) {
        AppMethodBeat.i(253142);
        float f3 = (f2 > 1.0f ? 1.0f : f2) * ((1.0f + ((float) i2)) / ((float) i3));
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int drd = (int) (((float) com.tencent.mm.plugin.finder.storage.c.drd()) * f3);
        Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "feed " + this.vTG.getLocalId() + " updateProgress " + f2 + ", " + f3 + ", " + drd + ", index:" + i2 + ", size:" + i3);
        if (this.vTG.getPostInfo().Mpc < drd) {
            this.vTG.getPostInfo().Mpc = drd;
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.r(this.vTG);
        }
        EventCenter eventCenter = EventCenter.instance;
        hk hkVar = new hk();
        hkVar.dLT.localId = this.vTG.getLocalId();
        hkVar.dLT.progress = this.vTG.getPostInfo().Mpc;
        eventCenter.publish(hkVar);
        AppMethodBeat.o(253142);
    }

    private final void dBc() {
        AppMethodBeat.i(253143);
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        c.a.q(this.vTG);
        AppMethodBeat.o(253143);
    }

    private final void dBl() {
        AppMethodBeat.i(253144);
        Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "failTask");
        a(j.Fail);
        AppMethodBeat.o(253144);
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(253145);
        String valueOf = String.valueOf(this.vTG.getLocalId());
        AppMethodBeat.o(253145);
        return valueOf;
    }
}

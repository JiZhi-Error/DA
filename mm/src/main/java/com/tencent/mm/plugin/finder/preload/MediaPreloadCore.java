package com.tencent.mm.plugin.finder.preload;

import android.support.v7.app.AppCompatActivity;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.worker.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;

public final class MediaPreloadCore extends UIComponent {
    private static boolean uTU = ((Boolean) com.tencent.mm.plugin.finder.storage.c.dsv().value()).booleanValue();
    public static final a uTV = new a((byte) 0);
    private int dLS;
    private final f uTP = g.ah(d.uUb);
    public final com.tencent.mm.plugin.finder.preload.worker.b uTQ;
    private final com.tencent.mm.plugin.finder.preload.worker.a uTR;
    public boolean uTS;
    private FeedData uTT;

    public final com.tencent.mm.plugin.finder.preload.model.a getPreloadModel() {
        AppMethodBeat.i(249513);
        com.tencent.mm.plugin.finder.preload.model.a aVar = (com.tencent.mm.plugin.finder.preload.model.a) this.uTP.getValue();
        AppMethodBeat.o(249513);
        return aVar;
    }

    public static final class e extends q implements kotlin.g.a.b<b, Boolean> {
        final /* synthetic */ b uUc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b bVar) {
            super(1);
            this.uUc = bVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(b bVar) {
            AppMethodBeat.i(249512);
            Boolean valueOf = Boolean.valueOf(p.j(bVar, this.uUc));
            AppMethodBeat.o(249512);
            return valueOf;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(at atVar) {
            AppMethodBeat.i(249503);
            p.h(atVar, "cache");
            String filePath = atVar.getFilePath();
            CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
            long[] jArr = new long[2];
            c2CDownloadRequest.fileKey = atVar.field_mediaId;
            c2CDownloadRequest.fileType = 8;
            StringBuilder sb = new StringBuilder();
            String str = atVar.field_url;
            if (str == null) {
                str = "";
            }
            c2CDownloadRequest.url = sb.append(str).append(atVar.field_urlToken).toString();
            c2CDownloadRequest.snsCipherKey = atVar.field_decodeKey;
            c2CDownloadRequest.setSavePath(filePath);
            c2CDownloadRequest.videoflagPolicy = 0;
            c2CDownloadRequest.requestVideoFlag = atVar.field_fileFormat;
            c2CDownloadRequest.requestVideoFormat = atVar.field_reqFormat;
            b bVar = new b(CdnLogic.queryVideoMoovInfo(c2CDownloadRequest, jArr), jArr[0], jArr[1]);
            AppMethodBeat.o(249503);
            return bVar;
        }
    }

    static {
        AppMethodBeat.i(249525);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        AppMethodBeat.o(249525);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaPreloadCore(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        com.tencent.mm.plugin.finder.preload.worker.a aVar = null;
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(249524);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.uTQ = com.tencent.mm.plugin.finder.storage.c.drD() ? new com.tencent.mm.plugin.finder.preload.worker.b(getPreloadModel()) : null;
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.uTR = com.tencent.mm.plugin.finder.storage.c.drE() ? new com.tencent.mm.plugin.finder.preload.worker.a() : aVar;
        this.dLS = Integer.MIN_VALUE;
        AppMethodBeat.o(249524);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0067, code lost:
        if (com.tencent.mm.plugin.finder.storage.c.drE() != false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer<com.tencent.mm.plugin.finder.model.bo> r5, int r6, com.tencent.mm.plugin.finder.event.base.c r7) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a(com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer, int, com.tencent.mm.plugin.finder.event.base.c):void");
    }

    public final void aun(String str) {
        AppMethodBeat.i(249515);
        Log.i("Finder.MediaPreloadCore", "[onPreloadStart] source=".concat(String.valueOf(str)));
        com.tencent.mm.plugin.finder.preload.worker.b bVar = this.uTQ;
        if (bVar != null) {
            if (bVar.dxj.compareAndSet(true, false)) {
                bVar.dlM();
            }
            AppMethodBeat.o(249515);
            return;
        }
        AppMethodBeat.o(249515);
    }

    private final void auo(String str) {
        AppMethodBeat.i(249516);
        Log.i("Finder.MediaPreloadCore", "[onPreloadStop] source=".concat(String.valueOf(str)));
        com.tencent.mm.plugin.finder.preload.worker.b bVar = this.uTQ;
        if (bVar != null) {
            if (bVar.dxj.compareAndSet(false, true)) {
                bVar.l("resetRunningTask", new b.l(bVar));
            }
            AppMethodBeat.o(249516);
            return;
        }
        AppMethodBeat.o(249516);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStart() {
        AppMethodBeat.i(249517);
        super.onStart();
        if (!this.uTS) {
            aun("Activity#onStart");
        }
        AppMethodBeat.o(249517);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStop() {
        AppMethodBeat.i(249518);
        super.onStop();
        if (!this.uTS) {
            auo("Activity#onStrop");
        }
        AppMethodBeat.o(249518);
    }

    public final void bl(String str, boolean z) {
        boolean z2;
        AppMethodBeat.i(249519);
        p.h(str, "mediaId");
        Log.i("Finder.MediaPreloadCore", "[onMediaFocusDownload] mediaId=" + str + " isFocused=" + z);
        if (dlE()) {
            if (z) {
                auo("onMediaFocusDownload#".concat(String.valueOf(str)));
                z2 = true;
            } else {
                aun("onMediaFocusDownload#".concat(String.valueOf(str)));
                z2 = false;
            }
            this.uTS = z2;
        }
        if (this.uTR != null) {
            com.tencent.mm.plugin.finder.preload.worker.a.auu(str);
        }
        com.tencent.mm.plugin.finder.preload.worker.b bVar = this.uTQ;
        if (bVar != null) {
            bVar.bn(str, z);
            AppMethodBeat.o(249519);
            return;
        }
        AppMethodBeat.o(249519);
    }

    public final void bm(String str, boolean z) {
        AppMethodBeat.i(249520);
        p.h(str, "mediaId");
        Log.i("Finder.MediaPreloadCore", "[onMediaFocusForTP] mediaId=" + str + " isFocused=" + z);
        if (this.uTR != null) {
            com.tencent.mm.plugin.finder.preload.worker.a.auu(str);
        }
        com.tencent.mm.plugin.finder.preload.worker.b bVar = this.uTQ;
        if (bVar != null) {
            bVar.bn(str, z);
            AppMethodBeat.o(249520);
            return;
        }
        AppMethodBeat.o(249520);
    }

    public final void aup(String str) {
        AppMethodBeat.i(249521);
        p.h(str, "mediaId");
        Log.i("Finder.MediaPreloadCore", "[stopPreloadForTP] mediaId=".concat(String.valueOf(str)));
        if (!this.uTS) {
            auo("onMediaFocusForTP#".concat(String.valueOf(str)));
            this.uTS = true;
        }
        AppMethodBeat.o(249521);
    }

    public final boolean dlE() {
        AppMethodBeat.i(249522);
        if (getPreloadModel().uUu < 0 || getPreloadModel().uUt < 0) {
            AppMethodBeat.o(249522);
            return false;
        }
        AppMethodBeat.o(249522);
        return true;
    }

    public final void a(b bVar) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue;
        AppMethodBeat.i(249523);
        p.h(bVar, "callback");
        com.tencent.mm.plugin.finder.preload.worker.b bVar2 = this.uTQ;
        if (bVar2 == null || (concurrentLinkedQueue = bVar2.uVL) == null) {
            AppMethodBeat.o(249523);
            return;
        }
        concurrentLinkedQueue.add(bVar);
        AppMethodBeat.o(249523);
    }

    public static final class b {
        private final long length;
        private final long offset;
        public final boolean uTW;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (!(this.uTW == bVar.uTW && this.offset == bVar.offset && this.length == bVar.length)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            boolean z = this.uTW;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            long j2 = this.offset;
            long j3 = this.length;
            return (((i2 * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }

        public final String toString() {
            AppMethodBeat.i(249504);
            String str = "MoovReadyInfo(isMoovReady=" + this.uTW + ", offset=" + this.offset + ", length=" + this.length + ")";
            AppMethodBeat.o(249504);
            return str;
        }

        public b(boolean z, long j2, long j3) {
            this.uTW = z;
            this.offset = j2;
            this.length = j3;
        }
    }

    public final class c extends com.tencent.mm.plugin.finder.event.base.d {
        private final DataBuffer<bo> dataList;
        private final MMHandler iVP = new MMHandler("FinderMediaPreloadCore");
        final /* synthetic */ MediaPreloadCore uTX;

        public c(MediaPreloadCore mediaPreloadCore, DataBuffer<bo> dataBuffer) {
            p.h(dataBuffer, "dataList");
            this.uTX = mediaPreloadCore;
            AppMethodBeat.i(249509);
            this.dataList = dataBuffer;
            AppMethodBeat.o(249509);
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
            AppMethodBeat.i(249506);
            p.h(cVar, "dispatcher");
            p.h(bVar, "event");
            if (!(bVar instanceof h) || !(((h) bVar).type == 6 || ((h) bVar).type == 7 || ((h) bVar).type == 0)) {
                AppMethodBeat.o(249506);
                return false;
            }
            AppMethodBeat.o(249506);
            return true;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean cZD() {
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
            LinkedList linkedList;
            FinderItem finderItem;
            LinkedList<cjl> mediaList;
            cjl cjl;
            AppMethodBeat.i(249507);
            p.h(bVar, "ev");
            if (bVar instanceof h) {
                FeedData feedData = ((h) bVar).tIF;
                int i2 = ((h) bVar).type;
                if (feedData != null) {
                    long id = feedData.getId();
                    FeedData feedData2 = this.uTX.uTT;
                    FeedData feedData3 = feedData2 == null || id != feedData2.getId() ? feedData : null;
                    if (feedData3 != null) {
                        int totalSize = this.dataList.getTotalSize();
                        ArrayList arrayList = new ArrayList(totalSize);
                        for (int i3 = 0; i3 < totalSize; i3++) {
                            bo boVar = this.dataList.get(i3);
                            if (boVar instanceof bm) {
                                linkedList = ((bm) boVar).dkV();
                            } else if (boVar instanceof BaseFinderFeed) {
                                LinkedList linkedList2 = new LinkedList();
                                boolean a2 = y.a(y.vXH, this.uTX.dLS, 0, 2);
                                ((BaseFinderFeed) boVar).feedObject.setReplaceLongVideoToNormal(a2);
                                FeedData.a aVar = FeedData.Companion;
                                cjl cjl2 = (cjl) j.kt(FeedData.a.s((BaseFinderFeed) boVar).getMediaList());
                                if (cjl2 != null) {
                                    linkedList2.add(cjl2);
                                }
                                if (!a2 && (cjl = (cjl) j.kt(((BaseFinderFeed) boVar).feedObject.getLongVideoMediaList())) != null) {
                                    linkedList2.add(cjl);
                                }
                                linkedList = linkedList2;
                            } else if (boVar instanceof ag) {
                                BaseFinderFeed baseFinderFeed = (BaseFinderFeed) j.kt(((ag) boVar).rvFeedList);
                                linkedList = (baseFinderFeed == null || (finderItem = baseFinderFeed.feedObject) == null || (mediaList = finderItem.getMediaList()) == null) ? new LinkedList() : j.v((Collection) mediaList);
                            } else {
                                linkedList = new LinkedList();
                            }
                            arrayList.add(new o(boVar, j.v(linkedList)));
                        }
                        this.iVP.post(new a(arrayList, this, feedData, i2));
                        this.uTX.uTT = feedData3;
                        AppMethodBeat.o(249507);
                        return;
                    }
                }
            }
            AppMethodBeat.o(249507);
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final void onRelease() {
            AppMethodBeat.i(249508);
            super.onRelease();
            com.tencent.mm.plugin.finder.preload.worker.a unused = this.uTX.uTR;
            com.tencent.mm.plugin.finder.preload.worker.b bVar = this.uTX.uTQ;
            if (bVar != null) {
                bVar.ife = true;
                LinkedList linkedList = new LinkedList();
                bVar.l("onClearAll", new b.i(bVar, linkedList));
                Log.i(bVar.TAG, "[onClearAll] ".concat(String.valueOf(linkedList)));
                AppMethodBeat.o(249508);
                return;
            }
            AppMethodBeat.o(249508);
        }

        static final class a implements Runnable {
            final /* synthetic */ List hvj;
            final /* synthetic */ c uTY;
            final /* synthetic */ FeedData uTZ;
            final /* synthetic */ int uUa;

            a(List list, c cVar, FeedData feedData, int i2) {
                this.hvj = list;
                this.uTY = cVar;
                this.uTZ = feedData;
                this.uUa = i2;
            }

            public final void run() {
                AppMethodBeat.i(249505);
                com.tencent.mm.plugin.finder.preload.worker.b bVar = this.uTY.uTX.uTQ;
                if (bVar != null) {
                    bVar.a(this.uTZ, this.hvj, this.uUa);
                }
                if (this.uTY.uTX.uTR != null) {
                    com.tencent.mm.plugin.finder.preload.worker.a.a(this.uTZ, this.hvj);
                }
                AppMethodBeat.o(249505);
            }
        }
    }

    static final class d extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.a> {
        public static final d uUb = new d();

        static {
            AppMethodBeat.i(249511);
            AppMethodBeat.o(249511);
        }

        d() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.preload.model.a invoke() {
            AppMethodBeat.i(249510);
            com.tencent.mm.plugin.finder.preload.model.a mediaPreloadModel = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel();
            AppMethodBeat.o(249510);
            return mediaPreloadModel;
        }
    }
}

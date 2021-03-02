package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.jsapi.cr;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.c.d;
import com.tencent.mm.sticker.c.h;
import com.tencent.mm.sticker.c.i;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001fJ\u0006\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020\u001fJ\u0016\u0010&\u001a\u00020\u001f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0(H\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\b\u0010*\u001a\u00020\u001fH\u0002J\u0018\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\"J\u0006\u0010/\u001a\u00020\u001fR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;)V", "appendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "codeMore", "", "ctxBuff", "", "dataHasMore", "", "firstLoaded", "firstPage", "historyList", "isLoading", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "moreList", "pageBuff", "recommendHasMore", "recommendList", "requestType", "appendRecommend", "", "info", "lensId", "", "destroy", "loadData", "loadMore", "processData", "lensList", "", "processMore", "processRecommend", "setup", "timeEnter", "", ch.COL_USERNAME, "updateHistory", "Companion", "plugin-emojicapture_release"})
public final class f {
    private static final chz rpl = new chz();
    private static final chz rpm = new chz();
    private static final chz rpn = new chz();
    private static final chz rpo = new chz();
    private static final chz rpp = new chz();
    private static final chz rpq = new chz();
    public static final a rpr = new a((byte) 0);
    private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> gZm;
    private boolean isLoading;
    public int requestType = 1;
    public final LinkedList<chz> roR = new LinkedList<>();
    private final int rpa = 2;
    private byte[] rpb;
    private boolean rpc = true;
    private boolean rpd = true;
    private boolean rpe;
    public boolean rpf;
    public byte[] rpg;
    private final LinkedList<chz> rph = new LinkedList<>();
    private final LinkedList<chz> rpi = new LinkedList<>();
    private final LinkedList<chz> rpj = new LinkedList<>();
    final d rpk;

    public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> bVar, d dVar) {
        p.h(bVar, "lifeCycleKeeper");
        p.h(dVar, "callback");
        AppMethodBeat.i(248);
        this.gZm = bVar;
        this.rpk = dVar;
        AppMethodBeat.o(248);
    }

    public static final /* synthetic */ void g(f fVar) {
        AppMethodBeat.i(251);
        fVar.cJm();
        AppMethodBeat.o(251);
    }

    public static final /* synthetic */ void m(f fVar) {
        AppMethodBeat.i(252);
        fVar.cJn();
        AppMethodBeat.o(252);
    }

    public final void cJk() {
        AppMethodBeat.i(TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID);
        Log.i(g.TAG, "loadMore: " + this.isLoading + ", " + this.rpc);
        if (!this.rpc || this.isLoading) {
            AppMethodBeat.o(TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID);
            return;
        }
        this.isLoading = true;
        i.a aVar = i.NOv;
        i.a.a(this.requestType, this.rpb, this.rpg, this.gZm, new d(this));
        AppMethodBeat.o(TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$loadMore$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-emojicapture_release"})
    public static final class d implements h {
        final /* synthetic */ f rps;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(f fVar) {
            this.rps = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
            if ((!(r3.length == 0)) == true) goto L_0x0038;
         */
        @Override // com.tencent.mm.sticker.c.h
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r7, int r8, com.tencent.mm.protocal.protobuf.bpi r9) {
            /*
            // Method dump skipped, instructions count: 178
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emojicapture.model.a.f.d.a(int, int, com.tencent.mm.protocal.protobuf.bpi):void");
        }
    }

    public final void cJl() {
        AppMethodBeat.i(242);
        this.rpi.clear();
        LinkedList<chz> linkedList = this.rpi;
        com.tencent.mm.sticker.a.b bVar = com.tencent.mm.sticker.a.b.NOi;
        linkedList.addAll(com.tencent.mm.sticker.a.b.gzf());
        Log.i(g.TAG, "updateHistory: " + this.rpi.size());
        cJn();
        AppMethodBeat.o(242);
    }

    public final void ann(String str) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.o.b.d.CTRL_INDEX);
        p.h(str, "lensId");
        chz chz = new chz();
        chz.Lso = str;
        a(chz);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.o.b.d.CTRL_INDEX);
    }

    public final void a(chz chz) {
        T t;
        T t2;
        AppMethodBeat.i(244);
        p.h(chz, "info");
        Iterator<T> it = this.roR.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (p.j(next.Lso, chz.Lso)) {
                t = next;
                break;
            }
        }
        T t3 = t;
        Iterator<T> it2 = this.rph.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t2 = null;
                break;
            }
            T next2 = it2.next();
            if (p.j(next2.Lso, chz.Lso)) {
                t2 = next2;
                break;
            }
        }
        T t4 = t2;
        if (t3 != null) {
            if (t4 == null) {
                this.rph.add(t3);
            }
        } else if (t4 == null) {
            String str = chz.Lso;
            if (str == null || a.b(chz)) {
                this.rph.add(chz);
            } else {
                d.a aVar = com.tencent.mm.sticker.c.d.NOm;
                d.a.a(this.gZm, str, new b(this));
            }
        }
        cJm();
        AppMethodBeat.o(244);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$appendRecommend$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
    public static final class b implements com.tencent.mm.sticker.c.c {
        final /* synthetic */ f rps;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(f fVar) {
            this.rps = fVar;
        }

        @Override // com.tencent.mm.sticker.c.c
        public final void a(int i2, chz chz) {
            AppMethodBeat.i(236);
            Log.i(g.TAG, "getLensInfo onResult: ".concat(String.valueOf(chz)));
            if (chz != null) {
                this.rps.rph.add(chz);
                f.g(this.rps);
            }
            AppMethodBeat.o(236);
        }
    }

    public static void destroy() {
        AppMethodBeat.i(245);
        com.tencent.mm.sticker.a.b bVar = com.tencent.mm.sticker.a.b.NOi;
        com.tencent.mm.sticker.a.b.ae(null);
        AppMethodBeat.o(245);
    }

    public final void cJm() {
        AppMethodBeat.i(246);
        com.tencent.mm.ac.d.h(new C0975f(this));
        AppMethodBeat.o(246);
    }

    public final void cJn() {
        int i2 = 0;
        AppMethodBeat.i(247);
        Log.i(g.TAG, "processMore: " + this.rpi.size() + ", " + this.rpj.size());
        LinkedList linkedList = new LinkedList();
        if (this.rpi.size() > 0) {
            linkedList.add(new com.tencent.mm.sticker.c(rpo, 0, 6, (byte) 0));
            LinkedList<chz> linkedList2 = this.rpi;
            ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
            int i3 = 0;
            for (T t : linkedList2) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    j.hxH();
                }
                arrayList.add(new com.tencent.mm.sticker.c(t, i3 + 1, 2));
                i3 = i4;
            }
            linkedList.addAll(arrayList);
            linkedList.add(new com.tencent.mm.sticker.c(rpp, 0, 6, (byte) 0));
        }
        if (this.rpj.size() > 0) {
            linkedList.add(new com.tencent.mm.sticker.c(rpq, 0, 6, (byte) 0));
            LinkedList<chz> linkedList3 = this.rpj;
            ArrayList arrayList2 = new ArrayList(j.a(linkedList3, 10));
            for (T t2 : linkedList3) {
                int i5 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                arrayList2.add(new com.tencent.mm.sticker.c(t2, i2 + 1, 3));
                i2 = i5;
            }
            linkedList.addAll(arrayList2);
        }
        this.rpk.dl(linkedList);
        AppMethodBeat.o(247);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$Companion;", "", "()V", "EMPTY_STICKER", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getEMPTY_STICKER", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "HISTORY_END", "getHISTORY_END", "HISTORY_HEADER", "getHISTORY_HEADER", "MORE_STICKER", "getMORE_STICKER", "MORE_STICKER_DISABLE", "getMORE_STICKER_DISABLE", "RECOMMEND_HEADER", "getRECOMMEND_HEADER", "isValidLensInfo", "", "lensInfo", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean b(chz chz) {
            String str;
            String str2 = null;
            AppMethodBeat.i(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL);
            p.h(chz, "lensInfo");
            if (!Util.isNullOrNil(chz.Lso)) {
                chy chy = chz.Mnr;
                if (chy != null) {
                    str = chy.Url;
                } else {
                    str = null;
                }
                if (!Util.isNullOrNil(str)) {
                    cib cib = chz.Mns;
                    if (cib != null) {
                        str2 = cib.KMl;
                    }
                    if (!Util.isNullOrNil(str2)) {
                        AppMethodBeat.o(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL);
            return false;
        }
    }

    static {
        AppMethodBeat.i(cr.CTRL_INDEX);
        AppMethodBeat.o(cr.CTRL_INDEX);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f rps;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(f fVar) {
            super(0);
            this.rps = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS);
            this.rps.cJl();
            x xVar = x.SXb;
            AppMethodBeat.o(TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ List roU;
        final /* synthetic */ f rps;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(f fVar, List list) {
            super(0);
            this.rps = fVar;
            this.roU = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            AppMethodBeat.i(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL);
            if (this.rps.rpd) {
                this.rps.rpd = false;
                this.rps.rpj.clear();
                this.rps.roR.clear();
                if (this.roU.isEmpty()) {
                    com.tencent.mm.sticker.a.b bVar = com.tencent.mm.sticker.a.b.NOi;
                    com.tencent.mm.sticker.a.b.iA(this.rps.roR);
                    f.g(this.rps);
                    x xVar = x.SXb;
                    AppMethodBeat.o(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL);
                    return xVar;
                }
            }
            d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
            int min = Math.min(com.tencent.mm.plugin.emojicapture.model.d.rox - this.rps.roR.size(), this.roU.size());
            if (min > 0) {
                this.rps.roR.addAll(this.roU.subList(0, min));
                com.tencent.mm.sticker.a.b bVar2 = com.tencent.mm.sticker.a.b.NOi;
                com.tencent.mm.sticker.a.b.iA(this.rps.roR);
                f fVar = this.rps;
                if (min < this.roU.size()) {
                    z = true;
                } else {
                    z = false;
                }
                fVar.rpe = z;
                f.g(this.rps);
                if (min < this.roU.size()) {
                    LinkedList linkedList = this.rps.rpj;
                    List list = this.roU;
                    linkedList.addAll(list.subList(min, list.size()));
                    f.m(this.rps);
                }
            } else {
                if (!this.rps.rpe) {
                    this.rps.rpe = true;
                    f.g(this.rps);
                }
                this.rps.rpj.addAll(this.roU);
                f.m(this.rps);
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL);
            return xVar2;
        }
    }

    public static final /* synthetic */ void a(f fVar, List list) {
        AppMethodBeat.i(250);
        com.tencent.mm.ac.d.h(new e(fVar, list));
        AppMethodBeat.o(250);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.a.f$f  reason: collision with other inner class name */
    public static final class C0975f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f rps;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0975f(f fVar) {
            super(0);
            this.rps = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2 = 0;
            AppMethodBeat.i(240);
            Log.i(g.TAG, "processRecommend: " + this.rps.roR.size() + ", " + this.rps.rpe);
            LinkedList linkedList = new LinkedList();
            if (this.rps.roR.size() > 0) {
                a aVar = f.rpr;
                linkedList.add(f.rpl);
                linkedList.addAll(this.rps.roR);
                for (chz chz : this.rps.rph) {
                    Iterator it = this.rps.roR.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i3 = -1;
                            break;
                        } else if (p.j(((chz) it.next()).Lso, chz.Lso)) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i3 < 0) {
                        Log.i(g.TAG, "processRecommend: append");
                        linkedList.add(chz);
                    }
                }
                if (this.rps.rpe || this.rps.rpc) {
                    a aVar2 = f.rpr;
                    linkedList.add(f.rpm);
                } else {
                    a aVar3 = f.rpr;
                    linkedList.add(f.rpn);
                }
            }
            d dVar = this.rps.rpk;
            LinkedList linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
            for (Object obj : linkedList2) {
                int i4 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                arrayList.add(new com.tencent.mm.sticker.c((chz) obj, i2, 1));
                i2 = i4;
            }
            dVar.dk(arrayList);
            x xVar = x.SXb;
            AppMethodBeat.o(240);
            return xVar;
        }
    }
}

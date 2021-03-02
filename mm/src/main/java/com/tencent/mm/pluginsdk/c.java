package com.tencent.mm.pluginsdk;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010/\u001a\u00020\u0017J\u0006\u00100\u001a\u00020\u0017J\u0006\u00101\u001a\u000202J\b\u00103\u001a\u000202H\u0002J\u0006\u00104\u001a\u00020\u0017J\b\u00105\u001a\u00020\u0004H\u0002J\u0006\u00106\u001a\u00020\u0017J\u0006\u00107\u001a\u00020\u0017J\u0006\u00108\u001a\u00020\u0017J\b\u00109\u001a\u00020\u0013H\u0002J\u0006\u0010:\u001a\u00020\u0013J\b\u0010;\u001a\u00020\u0013H\u0002J\u0006\u0010<\u001a\u000202J\b\u0010=\u001a\u00020\u0004H\u0002J\u0006\u0010>\u001a\u000202J\u0010\u0010?\u001a\u0002022\b\u0010@\u001a\u0004\u0018\u00010AR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R#\u0010\u001f\u001a\n !*\u0004\u0018\u00010 0 8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b\"\u0010#R'\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b.\u0010\u001d\u001a\u0004\b,\u0010-¨\u0006B"}, hxF = {"Lcom/tencent/mm/pluginsdk/BizImagePreloadStrategy;", "", "()V", "DEFAULT_PRELOAD_STRATEGY_FETCH_INTERVAL", "", "KEY_EXPOSE_PRELOAD_INTERVAL", "", "KEY_NEED_EXPOSE_PRELOAD", "KEY_NEED_PRELOAD_AT_BOX_EXPOSE", "KEY_NEED_PRELOAD_AT_CHAT_LIST", "KEY_NEED_PRELOAD_AT_FOREGROUND", "KEY_NEED_PRELOAD_FOLD", "KEY_PRELOAD_DOWNLOAD_GAP", "KEY_PRELOAD_HAS_FETCHED", "KEY_PRELOAD_LAST_LOAD_TIME", "KEY_PRELOAD_PIC_LIMIT_MINUTE", "KEY_PRELOAD_SYNC_GAP", "KEY_PRELOAD_TOP_NUM", "SCENE_BIZ_TIME_LINE_PRELOAD", "", "TAG", "TIME_LINE_SLOT_COLLAPSE_TO_COUNT", "hasNewMessageReceived", "", "imageUrls", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getImageUrls", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "imageUrls$delegate", "Lkotlin/Lazy;", "isPreloadFold", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "timeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getTimeMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "timeMap$delegate", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timer$delegate", "appMsgExposePreloadEnable", "chatListPreloadEnable", "clearQueue", "", "doDownLoadImage", "foregroundPreloadEnable", "imageDownloadGap", "isClientSwitchOn", "needFoldCoverPreload", "needPreload", "preloadInterval", "preloadPicLimitInMinute", "preloadTopNum", "selectImageDownLoad", "syncGap", "tryDownloadTopNImage", "updateBizImgPreloadStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "plugin-biz_release"})
public final class c {
    private static boolean JSm = true;
    public static boolean JSn;
    private static final kotlin.f JSo = g.ah(b.JSx);
    private static final kotlin.f JSp = g.ah(e.JSA);
    private static final kotlin.f JSq = g.ah(f.JSB);
    public static final c JSr = new c();
    private static final kotlin.f iBW = g.ah(C2015c.JSy);

    public static MultiProcessMMKV aTI() {
        AppMethodBeat.i(124779);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) iBW.getValue();
        AppMethodBeat.o(124779);
        return multiProcessMMKV;
    }

    private static ConcurrentLinkedDeque<String> glG() {
        AppMethodBeat.i(177626);
        ConcurrentLinkedDeque<String> concurrentLinkedDeque = (ConcurrentLinkedDeque) JSo.getValue();
        AppMethodBeat.o(177626);
        return concurrentLinkedDeque;
    }

    private static ConcurrentHashMap<Long, Integer> glH() {
        AppMethodBeat.i(176160);
        ConcurrentHashMap<Long, Integer> concurrentHashMap = (ConcurrentHashMap) JSp.getValue();
        AppMethodBeat.o(176160);
        return concurrentHashMap;
    }

    private static MTimerHandler glI() {
        AppMethodBeat.i(124778);
        MTimerHandler mTimerHandler = (MTimerHandler) JSq.getValue();
        AppMethodBeat.o(124778);
        return mTimerHandler;
    }

    static {
        AppMethodBeat.i(124775);
        AppMethodBeat.o(124775);
    }

    private c() {
    }

    public static final /* synthetic */ ConcurrentLinkedDeque glR() {
        AppMethodBeat.i(177627);
        ConcurrentLinkedDeque<String> glG = glG();
        AppMethodBeat.o(177627);
        return glG;
    }

    public static final /* synthetic */ MultiProcessMMKV glS() {
        AppMethodBeat.i(124789);
        MultiProcessMMKV aTI = aTI();
        AppMethodBeat.o(124789);
        return aTI;
    }

    public static void c(qd qdVar) {
        fo foVar;
        AppMethodBeat.i(124780);
        if (qdVar == null || (foVar = qdVar.KWX) == null) {
            AppMethodBeat.o(124780);
            return;
        }
        aTI().putBoolean("biz_time_line_has_fetch_strategy", true);
        aTI().putBoolean("biz_time_line_need_preload", foVar.KJb);
        aTI().putBoolean("biz_time_line_need_preload_fold", foVar.KJa);
        aTI().putBoolean("biz_time_preload_at_foreground", foVar.KJh);
        aTI().putBoolean("biz_time_preload_at_chat_list", foVar.KJi);
        aTI().putBoolean("biz_time_preload_at_biz_box_expose", foVar.KJj);
        JSm = foVar.KJa;
        if (foVar.KJd > 0) {
            aTI().putInt("biz_time_line_need_preload_interval", foVar.KJd);
        }
        if (foVar.KJc > 0) {
            aTI().putInt("biz_time_line_need_preload_top_num", foVar.KJc);
        }
        if (foVar.KJe > 0) {
            aTI().putInt("biz_time_line_msg_sync_gap", foVar.KJe);
        }
        if (foVar.KJf > 0) {
            aTI().putInt("biz_time_line_pic_download_gap", foVar.KJf);
        }
        if (foVar.KJg > 0) {
            aTI().putInt("biz_time_line_pic_limit_minute", foVar.KJg);
        }
        Log.i("MicroMsg.BizImagePreloadStrategy", "CoverPreloadInfo: NeedPreload = " + foVar.KJb + ", NeedPreloadFold = " + foVar.KJa + ", PreloadInterval = " + foVar.KJd + ", PreloadTopNum = " + foVar.KJd + ", PreloadSyncGap = " + foVar.KJe + ", PreloadPicGap = " + foVar.KJf + ", NeedPreloadAtForeground = " + foVar.KJh + ", NeedPreloadAtChatList = " + foVar.KJi + ", NeedPreloadAtAppMsgExpose = " + foVar.KJj);
        AppMethodBeat.o(124780);
    }

    public static boolean glJ() {
        boolean z;
        AppMethodBeat.i(124781);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_biz_time_line_img_preload, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy isClientSwitchOn: %b", Boolean.valueOf(z));
        AppMethodBeat.o(124781);
        return z;
    }

    public static boolean glK() {
        AppMethodBeat.i(124782);
        if (ab.NQR) {
            AppMethodBeat.o(124782);
            return false;
        }
        boolean z = aTI().getBoolean("biz_time_line_need_preload", false);
        Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy needPreload %b", Boolean.valueOf(z));
        AppMethodBeat.o(124782);
        return z;
    }

    private static int glL() {
        AppMethodBeat.i(212472);
        int i2 = aTI().getInt("biz_time_line_need_preload_interval", 60000);
        Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy preloadInterval %d", Integer.valueOf(i2));
        AppMethodBeat.o(212472);
        return i2;
    }

    private static long glM() {
        AppMethodBeat.i(124783);
        long j2 = aTI().getLong("biz_time_line_msg_sync_gap", 500);
        Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy syncGap %d", Long.valueOf(j2));
        AppMethodBeat.o(124783);
        return j2;
    }

    public final void glN() {
        AppMethodBeat.i(124784);
        if (!glJ() || !glK()) {
            AppMethodBeat.o(124784);
            return;
        }
        if (System.currentTimeMillis() - aTI().getLong("biz_time_line_need_last_load_time", 0) <= ((long) glL())) {
            Log.i("MicroMsg.BizImagePreloadStrategy", "tryDownloadTopNImage delta <= interval");
            AppMethodBeat.o(124784);
            return;
        }
        try {
            if (!glI().stopped()) {
                glI().stopTimer();
            }
            JSn = false;
            glI().startTimer(glM());
            AppMethodBeat.o(124784);
        } catch (Exception e2) {
            Log.e("MicroMsg.BizImagePreloadStrategy", e2.getMessage());
            AppMethodBeat.o(124784);
        }
    }

    public final void glO() {
        AppMethodBeat.i(124785);
        if (ab.NQR) {
            AppMethodBeat.o(124785);
            return;
        }
        if (JSn) {
            try {
                JSn = false;
                glI().startTimer(glM());
                AppMethodBeat.o(124785);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.BizImagePreloadStrategy", e2.getMessage());
            }
        }
        JSn = false;
        h.RTc.aX(d.JSz);
        AppMethodBeat.o(124785);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        public static final d JSz = new d();

        static {
            AppMethodBeat.i(124768);
            AppMethodBeat.o(124768);
        }

        d() {
        }

        public final void run() {
            AppMethodBeat.i(124767);
            c cVar = c.JSr;
            List<z> ajT = ag.ban().ajT(c.glQ());
            c cVar2 = c.JSr;
            c.glP();
            p.g(ajT, "timelineInfoArray");
            ArrayList arrayList = new ArrayList();
            for (T t : ajT) {
                u a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(((z) t).field_msgId, ((z) t).field_content);
                ArrayList arrayList2 = new ArrayList();
                LinkedList linkedList = a2.iAd;
                p.g(linkedList, "reader.items");
                Iterable<v> iterable = linkedList;
                if (!((z) t).field_isExpand) {
                    iterable = j.b(iterable, 2);
                }
                int i2 = 0;
                for (v vVar : iterable) {
                    if (i2 == 0) {
                        LinkedList linkedList2 = a2.iAd;
                        p.g(linkedList2, "reader.items");
                        if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).L(t, linkedList2.getFirst())) {
                            arrayList2.add(vVar.iAo);
                        } else {
                            arrayList2.add(vVar.iAD);
                        }
                    } else {
                        arrayList2.add(!com.tencent.matrix.trace.g.b.eP(vVar.iAo) ? vVar.iAo : vVar.iAD);
                    }
                    i2++;
                }
                j.a((Collection) arrayList, (Iterable) arrayList2);
            }
            ArrayList<String> arrayList3 = new ArrayList();
            for (Object obj : arrayList) {
                if (!Util.isNullOrNil((String) obj)) {
                    arrayList3.add(obj);
                }
            }
            for (String str : arrayList3) {
                c cVar3 = c.JSr;
                c.glR().addLast(str);
            }
            c cVar4 = c.JSr;
            c.glS().putLong("biz_time_line_need_last_load_time", System.currentTimeMillis());
            c cVar5 = c.JSr;
            c.glT();
            AppMethodBeat.o(124767);
        }
    }

    public static void glP() {
        AppMethodBeat.i(124786);
        glG().clear();
        Log.i("MicroMsg.BizImagePreloadStrategy", "do clearQueue");
        AppMethodBeat.o(124786);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ String JSs;
        final /* synthetic */ com.tencent.mm.av.a.a.c JSt;
        final /* synthetic */ long JSu;

        a(String str, com.tencent.mm.av.a.a.c cVar, long j2) {
            this.JSs = str;
            this.JSt = cVar;
            this.JSu = j2;
        }

        public final void run() {
            AppMethodBeat.i(124762);
            q.bcV().a(this.JSs, (ImageView) null, this.JSt, new k(this) {
                /* class com.tencent.mm.pluginsdk.c.a.AnonymousClass1 */
                final /* synthetic */ a JSv;

                {
                    this.JSv = r1;
                }

                @Override // com.tencent.mm.av.a.c.k
                public final void a(String str, View view, Bitmap bitmap, Object[] objArr) {
                    AppMethodBeat.i(124761);
                    Log.i("MicroMsg.BizImagePreloadStrategy", "DownLoadImage finish: url = %s", str);
                    MMHandlerThread.postToMainThreadDelayed(AnonymousClass1.JSw, this.JSv.JSu);
                    AppMethodBeat.o(124761);
                }
            });
            AppMethodBeat.o(124762);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<ConcurrentLinkedDeque<String>> {
        public static final b JSx = new b();

        static {
            AppMethodBeat.i(124764);
            AppMethodBeat.o(124764);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ConcurrentLinkedDeque<String> invoke() {
            AppMethodBeat.i(124763);
            ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
            AppMethodBeat.o(124763);
            return concurrentLinkedDeque;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<ConcurrentHashMap<Long, Integer>> {
        public static final e JSA = new e();

        static {
            AppMethodBeat.i(124770);
            AppMethodBeat.o(124770);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ConcurrentHashMap<Long, Integer> invoke() {
            AppMethodBeat.i(124769);
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            AppMethodBeat.o(124769);
            return concurrentHashMap;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<MTimerHandler> {
        public static final f JSB = new f();

        static {
            AppMethodBeat.i(124774);
            AppMethodBeat.o(124774);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MTimerHandler invoke() {
            AppMethodBeat.i(124773);
            MTimerHandler mTimerHandler = new MTimerHandler(AnonymousClass1.JSC, false);
            AppMethodBeat.o(124773);
            return mTimerHandler;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.pluginsdk.c$c  reason: collision with other inner class name */
    static final class C2015c extends kotlin.g.b.q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final C2015c JSy = new C2015c();

        static {
            AppMethodBeat.i(124766);
            AppMethodBeat.o(124766);
        }

        C2015c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(124765);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            AppMethodBeat.o(124765);
            return singleMMKV;
        }
    }

    public static final /* synthetic */ int glQ() {
        AppMethodBeat.i(124787);
        int i2 = aTI().getInt("biz_time_line_need_preload_top_num", 4);
        Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy preloadTopNum %d", Integer.valueOf(i2));
        AppMethodBeat.o(124787);
        return i2;
    }

    public static final /* synthetic */ void glT() {
        AppMethodBeat.i(124790);
        if (ab.NQR) {
            glG().clear();
            Log.i("MicroMsg.BizImagePreloadStrategy", "isInTimeLine clear");
            AppMethodBeat.o(124790);
            return;
        }
        String pollFirst = glG().pollFirst();
        if (!Util.isNullOrNil(pollFirst)) {
            long currentTimeMillis = System.currentTimeMillis() / Util.MILLSECONDS_OF_MINUTE;
            Integer num = glH().get(Long.valueOf(currentTimeMillis));
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue();
            int i2 = aTI().getInt("biz_time_line_pic_limit_minute", 60);
            Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy preloadPicLimitInMinute %d", Integer.valueOf(i2));
            if (intValue > i2) {
                Log.i("MicroMsg.BizImagePreloadStrategy", "download too much in one minute, count:%d", num);
                AppMethodBeat.o(124790);
                return;
            }
            long j2 = aTI().getLong("biz_time_line_pic_download_gap", 200);
            Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy imageDownloadGap %d", Long.valueOf(j2));
            String u = com.tencent.mm.api.b.u(pollFirst, 1);
            com.tencent.mm.av.a.a.c bdv = new c.a().bdp().a(new n()).OS(s.bdu(u)).bdv();
            glH().put(Long.valueOf(currentTimeMillis), Integer.valueOf(num.intValue() + 1));
            MMHandlerThread.postToMainThread(new a(u, bdv, j2));
        }
        AppMethodBeat.o(124790);
    }
}

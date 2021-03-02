package com.tencent.mm.plugin.festival.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.y;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.festival.b.i;
import com.tencent.mm.plugin.festival.model.z;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\u0006\u0010\u001e\u001a\u00020\u0015J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u0015H\u0002J\u001a\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u000eH\u0002J\u0006\u0010'\u001a\u00020\u0015J\u0006\u0010(\u001a\u00020\u0015J\u0006\u0010)\u001a\u00020\u0015J\b\u0010*\u001a\u00020\u0015H\u0002J\b\u0010+\u001a\u00020\u0015H\u0002J\u0006\u0010,\u001a\u00020\u0015J\b\u0010-\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalMusicManager;", "Lcom/tencent/mm/plugin/festival/model/FestivalWishConfigProvider$OnConfigUpdatedListener;", "()V", "AudioAppId", "", "DefaultMusicPath", "TAG", "audioEventListener", "com/tencent/mm/plugin/festival/model/FestivalMusicManager$audioEventListener$1", "Lcom/tencent/mm/plugin/festival/model/FestivalMusicManager$audioEventListener$1;", "audioId", "ignorePause", "", FirebaseAnalytics.b.INDEX, "", "musicList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishMusic;", "Lkotlin/collections/ArrayList;", "onPlayComplete", "Lkotlin/Function0;", "", "onPlayError", "playFlag", "pollMusicListThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "checkFestivalDefaultMusicLocalPathFromAsset", "context", "Landroid/content/Context;", "livePlay", "markIgnorePause", "onConfigUpdated", "config", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishConfig;", "playDefault", "playNext", "playUrl", "url", "seek", "release", "start", "startPlayMusic", "startPlayMusicInternal", "startPollInfoTimer", "stop", "stopPollInfoTimer", "plugin-festival_release"})
public final class r implements z.a {
    private static final ArrayList<i> UyA = new ArrayList<>();
    public static boolean UyC = false;
    private static int UyD = 2;
    private static final kotlin.g.a.a<x> UyE = d.UyM;
    private static final kotlin.g.a.a<x> UyF = c.UyL;
    public static final a UyG = new a();
    private static MTimerHandler UyH = null;
    private static final String UyI = (com.tencent.mm.loader.j.b.aKC() + "festival2021/festival_default_bg_music.mp3");
    public static final r UyJ = new r();
    public static final String dtX = dtX;
    private static int index;

    static {
        AppMethodBeat.i(263041);
        AppMethodBeat.o(263041);
    }

    private r() {
    }

    public static final /* synthetic */ void hfr() {
        AppMethodBeat.i(263042);
        hea();
        AppMethodBeat.o(263042);
    }

    public static final /* synthetic */ void ih(String str, int i2) {
        AppMethodBeat.i(263043);
        ig(str, i2);
        AppMethodBeat.o(263043);
    }

    public static final /* synthetic */ String mi(Context context) {
        AppMethodBeat.i(263044);
        String mh = mh(context);
        AppMethodBeat.o(263044);
        return mh;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/festival/model/FestivalMusicManager$audioEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AudioPlayerEvent;", "callback", "", "event", "plugin-festival_release"})
    public static final class a extends IListener<y> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(y yVar) {
            String str;
            y.a aVar;
            y.a aVar2;
            Integer num = null;
            AppMethodBeat.i(263023);
            y yVar2 = yVar;
            if (yVar2 == null || (aVar2 = yVar2.dCW) == null) {
                str = null;
            } else {
                str = aVar2.appId;
            }
            if (!p.j("festival2021", str)) {
                AppMethodBeat.o(263023);
                return false;
            }
            if (!(yVar2 == null || (aVar = yVar2.dCW) == null)) {
                num = Integer.valueOf(aVar.action);
            }
            Log.i("FestivalMusicManager", "FestivalAudioPlayerEvent callback action:".concat(String.valueOf(num)));
            if (num != null && num.intValue() == 5) {
                r rVar = r.UyJ;
                r.UyF.invoke();
            } else if (num != null && num.intValue() == 4) {
                r rVar2 = r.UyJ;
                r.UyE.invoke();
            } else if (num != null) {
                num.intValue();
            }
            AppMethodBeat.o(263023);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    public static final class f implements MTimerHandler.CallBack {
        public static final f UyO = new f();

        static {
            AppMethodBeat.i(263032);
            AppMethodBeat.o(263032);
        }

        f() {
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(263031);
            r rVar = r.UyJ;
            r.hfr();
            AppMethodBeat.o(263031);
            return true;
        }
    }

    public static void hdZ() {
        AppMethodBeat.i(263033);
        Log.i("FestivalMusicManager", "stopPollInfoTimer");
        MTimerHandler mTimerHandler = UyH;
        if (mTimerHandler != null) {
            mTimerHandler.stopTimer();
            AppMethodBeat.o(263033);
            return;
        }
        AppMethodBeat.o(263033);
    }

    public static void hea() {
        AppMethodBeat.i(263034);
        Log.i("FestivalMusicManager", "startPlayMusicInternal");
        q qVar = q.UyB;
        ArrayList<i> hdY = q.hdY();
        if (hdY == null || hdY.isEmpty()) {
            Log.i("FestivalMusicManager", "startPlayMusicInternal list empty poll");
            Log.i("FestivalMusicManager", "startPollInfoTimer");
            if (UyH == null) {
                UyH = new MTimerHandler("FestivalFinderShareInfoPlugin::Timer", (MTimerHandler.CallBack) f.UyO, false);
            }
            MTimerHandler mTimerHandler = UyH;
            if (mTimerHandler != null) {
                mTimerHandler.stopTimer();
            }
            MTimerHandler mTimerHandler2 = UyH;
            if (mTimerHandler2 != null) {
                q qVar2 = q.UyB;
                mTimerHandler2.startTimer(q.getInterval());
                AppMethodBeat.o(263034);
                return;
            }
            AppMethodBeat.o(263034);
            return;
        }
        UyA.clear();
        ArrayList<i> arrayList = UyA;
        q qVar3 = q.UyB;
        ArrayList<i> hdY2 = q.hdY();
        if (hdY2 == null) {
            p.hyc();
        }
        arrayList.addAll(hdY2);
        if (com.tencent.mm.ai.c.LT(dtX)) {
            Log.i("FestivalMusicManager", "startPlayMusicInternal already play");
            AppMethodBeat.o(263034);
            return;
        }
        switch (UyD) {
            case 0:
                hef();
                AppMethodBeat.o(263034);
                return;
            default:
                heb();
                AppMethodBeat.o(263034);
                return;
        }
    }

    public static void stop() {
        AppMethodBeat.i(263035);
        Log.i("FestivalMusicManager", "stop");
        if (!UyC) {
            com.tencent.mm.ai.c.aGU(dtX);
        }
        AppMethodBeat.o(263035);
    }

    public static void heb() {
        AppMethodBeat.i(263036);
        if (UyA.isEmpty()) {
            Log.i("FestivalMusicManager", "livePlay musicList empty");
            AppMethodBeat.o(263036);
            return;
        }
        Iterator<T> it = UyA.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = it.next().iAs + i2;
        }
        Log.i("FestivalMusicManager", "totalLength:%d", Integer.valueOf(i2));
        int aWB = cl.aWB() % i2;
        z.d dVar = new z.d();
        dVar.SYE = 0;
        int size = UyA.size();
        if (size >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i iVar = UyA.get(i3);
                p.g(iVar, "musicList[i]");
                i iVar2 = iVar;
                i4 += iVar2.iAs;
                if (aWB > i4) {
                    if (i3 == size) {
                        break;
                    }
                    i3++;
                } else {
                    index = i3;
                    dVar.SYE = iVar2.iAs - (i4 - aWB);
                    break;
                }
            }
        }
        com.tencent.mm.ac.d.h(new b(dVar));
        AppMethodBeat.o(263036);
    }

    private static void hef() {
        AppMethodBeat.i(263037);
        com.tencent.mm.ac.d.h(e.UyN);
        AppMethodBeat.o(263037);
    }

    private static void ig(String str, int i2) {
        AppMethodBeat.i(263038);
        Log.i("FestivalMusicManager", "index:%d playUrl:%s seek:%d", Integer.valueOf(index), str, Integer.valueOf(i2));
        com.tencent.mm.ai.b bVar = new com.tencent.mm.ai.b();
        bVar.appId = "festival2021";
        bVar.dtX = dtX;
        if (n.J(str, "http", false)) {
            bVar.dvn = str;
        } else {
            bVar.filePath = str;
        }
        bVar.iJE = true;
        bVar.dvv = i2 * 1000;
        com.tencent.mm.ai.c.m(bVar);
        AppMethodBeat.o(263038);
    }

    private static String mh(Context context) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        Throwable th4 = null;
        AppMethodBeat.i(263039);
        File file = new File(UyI);
        file.delete();
        if (file.exists()) {
            Log.i("FestivalMusicManager", "already exist");
            String str = UyI;
            AppMethodBeat.o(263039);
            return str;
        }
        AssetManager assets = context.getAssets();
        try {
            s.boN(s.boZ(UyI));
            InputStream open = assets.open("festival2021/festival_default_bg_music.mp3");
            try {
                InputStream inputStream = open;
                OutputStream LM = s.LM(UyI);
                try {
                    OutputStream outputStream = LM;
                    p.g(inputStream, "input");
                    p.g(outputStream, "output");
                    kotlin.f.a.f(inputStream, outputStream);
                    kotlin.f.b.a(LM, null);
                    kotlin.f.b.a(open, null);
                    String str2 = UyI;
                    AppMethodBeat.o(263039);
                    return str2;
                } catch (Throwable th5) {
                    th2 = th5;
                    th3 = th;
                    kotlin.f.b.a(LM, th3);
                    AppMethodBeat.o(263039);
                    throw th2;
                }
            } catch (Throwable th6) {
                th = th6;
                th4 = th;
                kotlin.f.b.a(open, th4);
                AppMethodBeat.o(263039);
                throw th;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("FestivalMusicManager", e2, "copyAssets", new Object[0]);
        }
    }

    @Override // com.tencent.mm.plugin.festival.model.z.a
    public final void a(com.tencent.mm.plugin.festival.b.e eVar) {
        AppMethodBeat.i(263040);
        p.h(eVar, "config");
        if (UyD != eVar.UAK) {
            Log.i("FestivalMusicManager", "onConfigUpdated playFlag:" + eVar.UAK);
        }
        UyD = eVar.UAK;
        AppMethodBeat.o(263040);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        public static final d UyM = new d();

        static {
            AppMethodBeat.i(263028);
            AppMethodBeat.o(263028);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(263027);
            Log.i("FestivalMusicManager", "onPlayError");
            r rVar = r.UyJ;
            r.hRv();
            x xVar = x.SXb;
            AppMethodBeat.o(263027);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        public static final c UyL = new c();

        static {
            AppMethodBeat.i(263026);
            AppMethodBeat.o(263026);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(263025);
            Log.i("FestivalMusicManager", "onPlayComplete");
            r rVar = r.UyJ;
            r.hRv();
            x xVar = x.SXb;
            AppMethodBeat.o(263025);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ z.d UyK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(z.d dVar) {
            super(0);
            this.UyK = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(263024);
            r rVar = r.UyJ;
            ArrayList arrayList = r.UyA;
            r rVar2 = r.UyJ;
            String str = ((i) arrayList.get(r.index)).url;
            p.g(str, "musicList[index].url");
            r.ih(str, this.UyK.SYE);
            x xVar = x.SXb;
            AppMethodBeat.o(263024);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        public static final e UyN = new e();

        static {
            AppMethodBeat.i(263030);
            AppMethodBeat.o(263030);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(263029);
            com.tencent.mm.ai.b bVar = new com.tencent.mm.ai.b();
            bVar.appId = "festival2021";
            r rVar = r.UyJ;
            bVar.dtX = r.dtX;
            r rVar2 = r.UyJ;
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            bVar.filePath = r.mi(context);
            bVar.iJE = true;
            bVar.loop = true;
            com.tencent.mm.ai.c.m(bVar);
            x xVar = x.SXb;
            AppMethodBeat.o(263029);
            return xVar;
        }
    }

    public static final /* synthetic */ void hRv() {
        AppMethodBeat.i(263045);
        switch (UyD) {
            case 0:
                Log.i("FestivalMusicManager", "play next default");
                hef();
                AppMethodBeat.o(263045);
                return;
            default:
                int i2 = index + 1;
                index = i2;
                int size = i2 % UyA.size();
                Log.i("FestivalMusicManager", "play next i:%d", Integer.valueOf(size));
                String str = UyA.get(size).url;
                p.g(str, "musicList[i].url");
                ig(str, 0);
                AppMethodBeat.o(263045);
                return;
        }
    }
}

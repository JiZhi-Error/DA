package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001BB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0006J\u000e\u00105\u001a\u0002032\u0006\u00106\u001a\u00020\u0004J\u000e\u00107\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u0006J\u0006\u00108\u001a\u000203J\u0016\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0004J\u001e\u0010;\u001a\u000203*\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010>\u001a\u00020\u0006J\u001a\u0010?\u001a\u000203*\u00020<2\u0006\u00104\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0006J\n\u0010A\u001a\u000203*\u00020<R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R-\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001f` ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R.\u0010#\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010$0\u001ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010$` X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler;", "", "()V", "END", "", "EVENT_CGI_SUCCESS", "", "EVENT_CLOSE_PAGE", "EVENT_ENTER_PAGE", "EVENT_FULLSCREEN", "EVENT_GETA8KEY", "EVENT_INSERT_VIDEO", "EVENT_MORE_VIDEO", "EVENT_ONREADY", "EVENT_PLAYER_ERROR", "EVENT_PLAYER_FIRST_DOWNLOAD", "EVENT_PLAYER_FIRST_PREPARE", "EVENT_PLAYER_LAG", "EVENT_PLAYER_PAUSE", "EVENT_PLAYER_PLAY", "EVENT_PLAYER_READY_PLAY", "EVENT_PLAYER_SEEK", "EVENT_PLAYER_SPEED", "EVENT_START_PLAYER", "EVENT_SWITCH_RESOLUTION", "START", "TAG", "initViewSelf", "insertVideoNativeView", "instanceMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "Lkotlin/collections/HashMap;", "getInstanceMap", "()Ljava/util/HashMap;", "nameToTime", "", "onAppMsgGet", "onAppMsgGetProcess", "onMediaPlayerPrepared", "onPageFinished", "onResetAfterCreateSelf", "onResetAfterCreateSuper", "onResetBeforeCreate", "onResumeSelf", "onStartSelf", "onSurfaceTextureAvailable", "postBindedSelf", "setDataSource", "startTime", "clearInstance", "", "key", "enterTime", "end", "getInstance", "resetTrace", "traceTime", "name", "addEvent", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "ins", "endTime", "addItem", "value", "toInfoString", "Instance", "plugin-brandservice_release"})
public final class j {
    private static final HashMap<String, Long> pLi = new HashMap<>();
    private static final HashMap<String, a> pLj = new HashMap<>();
    public static final j pLk = new j();

    static {
        AppMethodBeat.i(195987);
        AppMethodBeat.o(195987);
    }

    private j() {
    }

    public static /* synthetic */ void a(ff ffVar, a aVar) {
        AppMethodBeat.i(195983);
        a(ffVar, aVar, "");
        AppMethodBeat.o(195983);
    }

    public static void a(ff ffVar, a aVar, String str) {
        HashMap<String, ff> hashMap;
        LinkedList<ff> linkedList;
        AppMethodBeat.i(195982);
        p.h(ffVar, "$this$addEvent");
        p.h(str, "endTime");
        String str2 = "";
        LinkedList<fi> linkedList2 = ffVar.KEQ;
        p.g(linkedList2, "item");
        for (T t : linkedList2) {
            if (p.j(t.key, "EventType")) {
                String str3 = t.iFF;
                p.g(str3, "it.`val`");
                str2 = str3;
            }
        }
        if (!p.j(str2, "")) {
            LinkedList<fi> linkedList3 = ffVar.KEQ;
            fi fiVar = new fi();
            fiVar.key = "EndTime";
            if (p.j(str, "")) {
                str = String.valueOf(System.currentTimeMillis());
            }
            fiVar.iFF = str;
            linkedList3.add(fiVar);
            if (!(aVar == null || (linkedList = aVar.pLt) == null)) {
                linkedList.add(ffVar);
            }
            if (!(aVar == null || (hashMap = aVar.lCV) == null)) {
                hashMap.remove(str2);
                AppMethodBeat.o(195982);
                return;
            }
        }
        AppMethodBeat.o(195982);
    }

    public static void a(ff ffVar, String str, String str2) {
        AppMethodBeat.i(195984);
        p.h(ffVar, "$this$addItem");
        p.h(str, "key");
        p.h(str2, "value");
        LinkedList<fi> linkedList = ffVar.KEQ;
        fi fiVar = new fi();
        fiVar.key = str;
        fiVar.iFF = str2;
        linkedList.add(fiVar);
        AppMethodBeat.o(195984);
    }

    public static a aiP(String str) {
        AppMethodBeat.i(195985);
        p.h(str, "key");
        if (pLj.get(str) == null) {
            pLj.put(str, new a());
            Log.i("MicroMsg.BizVideoProfiler", " getInstance null, create " + pLj.get(str));
        }
        a aVar = pLj.get(str);
        if (aVar == null) {
            p.hyc();
        }
        a aVar2 = aVar;
        AppMethodBeat.o(195985);
        return aVar2;
    }

    public static void aiQ(String str) {
        AppMethodBeat.i(195986);
        p.h(str, "key");
        if (!pLj.containsKey(str)) {
            AppMethodBeat.o(195986);
            return;
        }
        pLj.remove(str);
        AppMethodBeat.o(195986);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107J\u0006\u00108\u001a\u000205J\u000e\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\u0004J\u0006\u0010;\u001a\u000205J\u000e\u0010<\u001a\u0002052\u0006\u0010:\u001a\u00020\u0004J\u0012\u0010=\u001a\u000205*\b\u0012\u0004\u0012\u00020,0+H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R1\u0010/\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010,00j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010,`1¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "", "()V", "AppMsgUrl", "", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "(Ljava/lang/String;)V", "DeviceBrand", "getDeviceBrand", "setDeviceBrand", "DeviceModel", "getDeviceModel", "setDeviceModel", "EnterId", "getEnterId", "setEnterId", "EnterPageId", "getEnterPageId", "setEnterPageId", "LanguageVersion", "getLanguageVersion", "setLanguageVersion", "NetType", "getNetType", "setNetType", "OsName", "getOsName", "setOsName", "OsVersion", "getOsVersion", "setOsVersion", "Scene", "getScene", "setScene", "SubScene", "getSubScene", "setSubScene", "Vid", "getVid", "setVid", "eventItem", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReport;", "getEventItem", "()Ljava/util/LinkedList;", "eventMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getEventMap", "()Ljava/util/HashMap;", "addPerformanceData", "", "performance", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "clearEvent", "getEvent", "event", "report", "tryToAddEvent", "toInfoString", "plugin-brandservice_release"})
    public static final class a {
        String hid = "";
        String hie = "";
        String hif = "";
        String hig = "";
        final HashMap<String, ff> lCV = new HashMap<>();
        String pLl = "";
        String pLm = "-1";
        public String pLn = "";
        public String pLo = "";
        public String pLp = "";
        public String pLq = "";
        public String pLr = "";
        public String pLs = "";
        public final LinkedList<ff> pLt = new LinkedList<>();

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "", "t", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j$a$a  reason: collision with other inner class name */
        public static final class C0896a extends q implements kotlin.g.a.b<Long, String> {
            public static final C0896a pLu = new C0896a();

            static {
                AppMethodBeat.i(195974);
                AppMethodBeat.o(195974);
            }

            C0896a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ String invoke(Long l) {
                AppMethodBeat.i(195973);
                long longValue = l.longValue();
                if (longValue == 0) {
                    AppMethodBeat.o(195973);
                    return "";
                }
                String valueOf = String.valueOf(longValue);
                AppMethodBeat.o(195973);
                return valueOf;
            }
        }

        public a() {
            AppMethodBeat.i(195981);
            AppMethodBeat.o(195981);
        }

        public final void cra() {
            AppMethodBeat.i(195977);
            this.pLt.clear();
            this.lCV.clear();
            AppMethodBeat.o(195977);
        }

        public final ff aiR(String str) {
            AppMethodBeat.i(195978);
            p.h(str, "event");
            ff ffVar = this.lCV.get(str);
            if (ffVar == null) {
                ff ffVar2 = new ff();
                ffVar2.type = 5;
                LinkedList<fi> linkedList = ffVar2.KEQ;
                fi fiVar = new fi();
                fiVar.key = "EventType";
                fiVar.iFF = str;
                linkedList.add(fiVar);
                LinkedList<fi> linkedList2 = ffVar2.KEQ;
                fi fiVar2 = new fi();
                fiVar2.key = "StartTime";
                fiVar2.iFF = String.valueOf(System.currentTimeMillis());
                linkedList2.add(fiVar2);
                this.lCV.put(str, ffVar2);
                ffVar = ffVar2;
            }
            AppMethodBeat.o(195978);
            return ffVar;
        }

        public final void aiS(String str) {
            AppMethodBeat.i(195979);
            p.h(str, "event");
            ff ffVar = this.lCV.get(str);
            if (ffVar != null) {
                j jVar = j.pLk;
                j.a(ffVar, this);
                AppMethodBeat.o(195979);
                return;
            }
            AppMethodBeat.o(195979);
        }

        public final void report() {
            AppMethodBeat.i(195980);
            new c(this).invoke();
            fg fgVar = new fg();
            ff ffVar = new ff();
            ffVar.type = 5;
            LinkedList<fi> linkedList = ffVar.KEQ;
            fi fiVar = new fi();
            fiVar.key = "DeviceModel";
            String str = this.hid;
            if (str == null) {
                str = "";
            }
            fiVar.iFF = str;
            linkedList.add(fiVar);
            fi fiVar2 = new fi();
            fiVar2.key = "DeviceBrand";
            String str2 = this.hie;
            if (str2 == null) {
                str2 = "";
            }
            fiVar2.iFF = str2;
            linkedList.add(fiVar2);
            fi fiVar3 = new fi();
            fiVar3.key = "OsName";
            String str3 = this.hif;
            if (str3 == null) {
                str3 = "";
            }
            fiVar3.iFF = str3;
            linkedList.add(fiVar3);
            fi fiVar4 = new fi();
            fiVar4.key = "OsVersion";
            String str4 = this.hig;
            if (str4 == null) {
                str4 = "";
            }
            fiVar4.iFF = str4;
            linkedList.add(fiVar4);
            fi fiVar5 = new fi();
            fiVar5.key = "LanguageVersion";
            String str5 = this.pLl;
            if (str5 == null) {
                str5 = "";
            }
            fiVar5.iFF = str5;
            linkedList.add(fiVar5);
            fi fiVar6 = new fi();
            fiVar6.key = "NetType";
            String str6 = this.pLm;
            if (str6 == null) {
                str6 = "";
            }
            fiVar6.iFF = str6;
            linkedList.add(fiVar6);
            fi fiVar7 = new fi();
            fiVar7.key = "EnterId";
            String str7 = this.pLn;
            if (str7 == null) {
                str7 = "";
            }
            fiVar7.iFF = str7;
            linkedList.add(fiVar7);
            fi fiVar8 = new fi();
            fiVar8.key = "EnterPageId";
            String str8 = this.pLo;
            if (str8 == null) {
                str8 = "";
            }
            fiVar8.iFF = str8;
            linkedList.add(fiVar8);
            fi fiVar9 = new fi();
            fiVar9.key = "AppMsgUrl";
            String str9 = this.pLp;
            if (str9 == null) {
                str9 = "";
            }
            fiVar9.iFF = str9;
            linkedList.add(fiVar9);
            fi fiVar10 = new fi();
            fiVar10.key = "Vid";
            String str10 = this.pLq;
            if (str10 == null) {
                str10 = "";
            }
            fiVar10.iFF = str10;
            linkedList.add(fiVar10);
            fi fiVar11 = new fi();
            fiVar11.key = "Scene";
            String str11 = this.pLr;
            if (str11 == null) {
                str11 = "";
            }
            fiVar11.iFF = str11;
            linkedList.add(fiVar11);
            fi fiVar12 = new fi();
            fiVar12.key = "SubScene";
            String str12 = this.pLs;
            if (str12 == null) {
                str12 = "";
            }
            fiVar12.iFF = str12;
            linkedList.add(fiVar12);
            fgVar.KIH = ffVar;
            Iterator<T> it = this.pLt.iterator();
            while (it.hasNext()) {
                fgVar.KIG.add(it.next());
            }
            d.a aVar = new d.a();
            aVar.c(fgVar);
            aVar.d(new fh());
            aVar.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
            aVar.sG(1870);
            aVar.sI(0);
            aVar.sJ(0);
            IPCRunCgi.a(aVar.aXF(), b.pLv);
            Log.i("MicroMsg.BizVideoProfiler", " report instance = ".concat(String.valueOf(this)));
            cra();
            AppMethodBeat.o(195980);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
        static final class b implements IPCRunCgi.a {
            public static final b pLv = new b();

            static {
                AppMethodBeat.i(195975);
                AppMethodBeat.o(195975);
            }

            b() {
            }

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<no name provided>", "", "invoke"})
        static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ a pLw;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar) {
                super(0);
                this.pLw = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(195976);
                this.pLw.hid = com.tencent.mm.protocal.d.KyJ;
                this.pLw.hie = com.tencent.mm.protocal.d.KyI;
                this.pLw.hif = com.tencent.mm.protocal.d.KyL;
                this.pLw.hig = com.tencent.mm.protocal.d.KyM;
                this.pLw.pLl = MMApplicationContext.getResources().getConfiguration().locale.getLanguage();
                this.pLw.pLm = "-1";
                if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                    this.pLw.pLm = "1";
                } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                    this.pLw.pLm = "2";
                } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                    this.pLw.pLm = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                    this.pLw.pLm = "4";
                } else if (NetStatusUtil.is5G(MMApplicationContext.getContext())) {
                    this.pLw.pLm = "5";
                }
                x xVar = x.SXb;
                AppMethodBeat.o(195976);
                return xVar;
            }
        }
    }
}

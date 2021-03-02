package com.tencent.mm.pluginsdk.model;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.s;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u000589:;<B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\u001a\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J$\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007J\u001a\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007J\u0012\u0010#\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u001a\u0010$\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0006\u0010%\u001a\u00020\u0013J\b\u0010&\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\u0013H\u0007J\u0010\u0010(\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+J \u0010,\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0007H\u0007J\u0014\u0010.\u001a\u00020\u00132\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000700J\u0010\u00101\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002J$\u00102\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007J:\u00103\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001a2\u0006\u00104\u001a\u0002052\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u00107\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R:\u0010\u0005\u001a.\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u0016\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\u0004\u0012\u00020\u0007`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R.\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006="}, hxF = {"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter;", "", "()V", "ENABLE_CHECK_ON_SCREEN", "", "HOST_NAME_MAP", "Ljava/util/HashMap;", "", "kotlin.jvm.PlatformType", "Lkotlin/collections/HashMap;", "REPORT_THREAD_LOOP_TAG", "TAG", "appMsgUrlMap", "isFlinging", "mLoadCountInfo", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "reportInfoMap", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "clearAppMsgUrl", "", "fillReportInfo", "reportInfo", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "finishAction", NativeProtocol.WEB_DIALOG_ACTION, "", "url", AppMeasurement.Param.TIMESTAMP, "", "finishAndReport", "getAppMsgKey", "msgId", "msgIndex", "getIdByUrl", "plusImageLoadCount", "reportBlank", "reportImageLoadCountInfo", "resetImageLoadCountInfo", "resumeAll", "retryDownload", "runTask", "runnable", "Ljava/lang/Runnable;", "setAppMsgUrl", "appMsgUrl", "showList", "urlSet", "", "simplifyUrl", "startAction", "startLoad", "item", "Lcom/tencent/mm/message/BizReaderItem;", "cellPosition", "stopAllByFling", "Action", "ActionTimeInfo", "BizImageBlankReportInfo", "ImageLoadCountInfo", "Status", "plugin-biz_release"})
public final class a {
    static final HashMap<String, b> AbY = new HashMap<>();
    static final HashMap<String, String> JUh = new HashMap<>();
    private static c JUi = new c();
    public static boolean JUj;
    private static final HashMap<String, String> JUk = ae.g(s.U(WeChatHosts.domainString(R.string.e20), "1"), s.U("mmbiz.qpic.cn", "2"), s.U("vpic.video.qq.com", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL), s.U("mmbiz.qlogo.cn", "4"));
    public static final a JUl = new a();

    static {
        AppMethodBeat.i(124821);
        AppMethodBeat.o(124821);
    }

    private a() {
    }

    public static void n(long j2, int i2, String str) {
        AppMethodBeat.i(124812);
        p.h(str, "appMsgUrl");
        JUh.put(al(j2, i2), str);
        AppMethodBeat.o(124812);
    }

    public static void gmj() {
        AppMethodBeat.i(124813);
        JUh.clear();
        AppMethodBeat.o(124813);
    }

    static String al(long j2, int i2) {
        AppMethodBeat.i(124814);
        String str = String.valueOf(j2) + "," + String.valueOf(i2);
        AppMethodBeat.o(124814);
        return str;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ com.tencent.mm.av.a.d.b JUF;
        final /* synthetic */ long kPc;
        final /* synthetic */ String mkH;

        e(String str, long j2, com.tencent.mm.av.a.d.b bVar) {
            this.mkH = str;
            this.kPc = j2;
            this.JUF = bVar;
        }

        public final void run() {
            AppMethodBeat.i(124803);
            if (this.mkH.length() == 0) {
                AppMethodBeat.o(124803);
                return;
            }
            a aVar = a.JUl;
            b bVar = (b) a.AbY.get(this.mkH);
            if (bVar == null) {
                AppMethodBeat.o(124803);
            } else if (bVar.gmp()) {
                a aVar2 = a.JUl;
                Log.w("MicroMsg.BizImageBlankReporter", "alvinluo finishAndReport id: %s TOTAL is finished", a.bdl(this.mkH));
                a aVar3 = a.JUl;
                a.AbY.remove(this.mkH);
                AppMethodBeat.o(124803);
            } else {
                bVar.aR(1, this.kPc);
                Set<Integer> keySet = bVar.JUz.keySet();
                p.g(keySet, "actionTimePointMap.keys");
                Iterator<T> it = keySet.iterator();
                boolean z = true;
                while (true) {
                    if (it.hasNext()) {
                        T next = it.next();
                        C2022a aVar4 = bVar.JUz.get(next);
                        if (aVar4 == null) {
                            break;
                        } else if (aVar4.isFinished()) {
                            p.g(next, NativeProtocol.WEB_DIALOG_ACTION);
                            bVar.aS(next.intValue(), aVar4.total);
                        } else if (next != null && next.intValue() == 8 && !bVar.JUw) {
                            p.g(next, NativeProtocol.WEB_DIALOG_ACTION);
                            bVar.aS(next.intValue(), 0);
                            z = true;
                        } else if (next != null && next.intValue() == 9 && !bVar.JUw) {
                            p.g(next, NativeProtocol.WEB_DIALOG_ACTION);
                            bVar.aS(next.intValue(), 0);
                            z = true;
                        } else {
                            Log.e("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult invalid action: %d, id: %s", next, bVar.id);
                            z = false;
                        }
                    } else {
                        bVar.JUA = z;
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(bVar.JUA);
                        C2022a aVar5 = bVar.JUz.get(1);
                        objArr[1] = aVar5 != null ? Long.valueOf(aVar5.total) : null;
                        objArr[2] = bVar.id;
                        Log.d("MicroMsg.BizImageBlankReporter", "alvinluo blankReportInfo fillResult resultValid: %b, timeTotal: %s, id: %s", objArr);
                    }
                }
                a aVar6 = a.JUl;
                a.AbY.remove(this.mkH);
                a aVar7 = a.JUl;
                a.a(bVar, this.JUF);
                AppMethodBeat.o(124803);
            }
        }
    }

    public static /* synthetic */ void dd(int i2, String str) {
        AppMethodBeat.i(124816);
        d(i2, str, 0);
        AppMethodBeat.o(124816);
    }

    public static void d(int i2, String str, long j2) {
        AppMethodBeat.i(124815);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(124815);
            return;
        }
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
        }
        v(new k(str, i2, j2));
        AppMethodBeat.o(124815);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class k implements Runnable {
        final /* synthetic */ long JUE;
        final /* synthetic */ int jAd;
        final /* synthetic */ String mkH;

        k(String str, int i2, long j2) {
            this.mkH = str;
            this.jAd = i2;
            this.JUE = j2;
        }

        public final void run() {
            AppMethodBeat.i(124810);
            a aVar = a.JUl;
            b bVar = (b) a.AbY.get(this.mkH);
            if (bVar == null) {
                b bVar2 = new b(this.mkH);
                a aVar2 = a.JUl;
                a.AbY.put(this.mkH, bVar2);
                bVar = bVar2;
            }
            bVar.aQ(this.jAd, this.JUE);
            AppMethodBeat.o(124810);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ long kPc;

        public h(long j2) {
            this.kPc = j2;
        }

        public final void run() {
            AppMethodBeat.i(124807);
            Log.d("MicroMsg.BizImageBlankReporter", "alvinluo resumeAll");
            a aVar = a.JUl;
            a.JUj = false;
            a aVar2 = a.JUl;
            Set<String> keySet = a.AbY.keySet();
            p.g(keySet, "reportInfoMap.keys");
            for (String str : keySet) {
                a aVar3 = a.JUl;
                b bVar = (b) a.AbY.get(str);
                if (bVar != null && bVar.JUx) {
                    a aVar4 = a.JUl;
                    p.g(str, "url");
                    Log.d("MicroMsg.BizImageBlankReporter", "alvinluo resume Scroll_Fling id: %s", a.bdl(str));
                    bVar.aR(9, this.kPc);
                }
            }
            AppMethodBeat.o(124807);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class l implements Runnable {
        final /* synthetic */ long kPc;

        public l(long j2) {
            this.kPc = j2;
        }

        public final void run() {
            AppMethodBeat.i(124811);
            Log.d("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling");
            a aVar = a.JUl;
            a.JUj = true;
            a aVar2 = a.JUl;
            Set<String> keySet = a.AbY.keySet();
            p.g(keySet, "reportInfoMap.keys");
            for (String str : keySet) {
                a aVar3 = a.JUl;
                b bVar = (b) a.AbY.get(str);
                if (bVar != null && !bVar.xqn && !bVar.gmp()) {
                    a aVar4 = a.JUl;
                    Log.v("MicroMsg.BizImageBlankReporter", "alvinluo stopAllByFling task not running and start SCROLL_FLING id: %s, %s", a.bdl(bVar.url), bVar.url);
                    bVar.aQ(9, this.kPc);
                }
            }
            AppMethodBeat.o(124811);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ long JUE;
        final /* synthetic */ int jAd;
        final /* synthetic */ String mkH;

        d(String str, int i2, long j2) {
            this.mkH = str;
            this.jAd = i2;
            this.JUE = j2;
        }

        public final void run() {
            AppMethodBeat.i(124802);
            a aVar = a.JUl;
            b bVar = (b) a.AbY.get(this.mkH);
            if (bVar != null) {
                bVar.aR(this.jAd, this.JUE);
                AppMethodBeat.o(124802);
                return;
            }
            AppMethodBeat.o(124802);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class j implements Runnable {
        final /* synthetic */ Set JUI;
        final /* synthetic */ long kPc;

        public j(Set set, long j2) {
            this.JUI = set;
            this.kPc = j2;
        }

        public final void run() {
            C2022a aVar;
            C2022a aVar2;
            AppMethodBeat.i(124809);
            for (String str : this.JUI) {
                if (!(str.length() == 0)) {
                    a aVar3 = a.JUl;
                    b bVar = (b) a.AbY.get(str);
                    if (bVar != null) {
                        long j2 = this.kPc;
                        C2022a aVar4 = bVar.JUz.get(Integer.valueOf(bVar.jCM));
                        if (aVar4 != null) {
                            aVar4.Mm(j2);
                        }
                        bVar.JUy = true;
                        if (bVar.JUx && (aVar2 = bVar.JUz.get(9)) != null) {
                            aVar2.Mm(j2);
                        }
                    }
                }
            }
            a aVar5 = a.JUl;
            Set<String> keySet = a.AbY.keySet();
            p.g(keySet, "reportInfoMap.keys");
            for (String str2 : keySet) {
                a aVar6 = a.JUl;
                b bVar2 = (b) a.AbY.get(str2);
                if (bVar2 != null && !this.JUI.contains(bVar2.url)) {
                    long j3 = this.kPc;
                    C2022a aVar7 = bVar2.JUz.get(Integer.valueOf(bVar2.jCM));
                    if (aVar7 != null) {
                        aVar7.Mn(j3);
                    }
                    bVar2.JUy = false;
                    if (bVar2.JUx && (aVar = bVar2.JUz.get(9)) != null) {
                        aVar.Mn(j3);
                    }
                }
            }
            AppMethodBeat.o(124809);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ long kPc;
        final /* synthetic */ String mkH;

        public i(String str, long j2) {
            this.mkH = str;
            this.kPc = j2;
        }

        public final void run() {
            AppMethodBeat.i(124808);
            a aVar = a.JUl;
            b bVar = (b) a.AbY.get(this.mkH);
            if (bVar != null) {
                long j2 = this.kPc;
                bVar.retryCount++;
                C2022a aVar2 = bVar.JUz.get(3);
                if (aVar2 != null) {
                    if (aVar2.status == 4) {
                        Log.i("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload force restart id: %s", bVar.id);
                        aVar2.status = 1;
                        aVar2.Mm(j2);
                    }
                    AppMethodBeat.o(124808);
                    return;
                }
                AppMethodBeat.o(124808);
                return;
            }
            AppMethodBeat.o(124808);
        }
    }

    public static void v(Runnable runnable) {
        AppMethodBeat.i(124818);
        p.h(runnable, "runnable");
        MMHandlerThread.postToMainThread(runnable);
        AppMethodBeat.o(124818);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ com.tencent.mm.av.a.d.b JUF;
        final /* synthetic */ b JUG;

        f(b bVar, com.tencent.mm.av.a.d.b bVar2) {
            this.JUG = bVar;
            this.JUF = bVar2;
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(124804);
            a aVar = a.JUl;
            a.b(this.JUG, this.JUF);
            a aVar2 = a.JUl;
            a.a(this.JUF);
            if (this.JUG.JUA) {
                b bVar = this.JUG;
                if (bVar.JUq + bVar.JUn + bVar.JUo + bVar.JUp >= 50) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    a aVar3 = a.JUl;
                    a.a(this.JUG);
                }
            }
            AppMethodBeat.o(124804);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        public static final g JUH = new g();

        static {
            AppMethodBeat.i(124806);
            AppMethodBeat.o(124806);
        }

        g() {
        }

        public final void run() {
            AppMethodBeat.i(124805);
            a aVar = a.JUl;
            Log.i("MicroMsg.BizImageBlankReporter", "alvinluo reportImageLoadCountInfo %s", a.JUi);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            a aVar2 = a.JUl;
            a aVar3 = a.JUl;
            a aVar4 = a.JUl;
            a aVar5 = a.JUl;
            hVar.a(17890, Integer.valueOf(a.JUi.gAZ), Integer.valueOf(a.JUi.JUD), Integer.valueOf(a.JUi.JUC), Integer.valueOf(a.JUi.JUB));
            a aVar6 = a.JUl;
            a.gmn();
            AppMethodBeat.o(124805);
        }
    }

    public static void gmk() {
        AppMethodBeat.i(124819);
        com.tencent.f.h.RTc.b(g.JUH, "biz_image_blank_report");
        AppMethodBeat.o(124819);
    }

    public static String bdl(String str) {
        AppMethodBeat.i(124820);
        p.h(str, "url");
        byte[] bytes = str.getBytes(kotlin.n.d.UTF_8);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(bytes);
        p.g(messageDigest, "MD5.getMessageDigest(url.toByteArray())");
        AppMethodBeat.o(124820);
        return messageDigest;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\fJ\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\fJ\u0010\u0010%\u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\u001fJ\u0010\u0010'\u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\fJ\u0010\u0010(\u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u001a\u0010\u001b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010¨\u0006)"}, hxF = {"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "", "id", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;I)V", "getAction", "()I", "setAction", "(I)V", "begin", "", "getBegin", "()J", "setBegin", "(J)V", "end", "getEnd", "setEnd", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "total", "getTotal", "setTotal", "addTime", "", "finish", AppMeasurement.Param.TIMESTAMP, "isFinished", "", "onResume", "pause", "reset", "resume", "start", "plugin-biz_release"})
    /* renamed from: com.tencent.mm.pluginsdk.model.a$a  reason: collision with other inner class name */
    public static final class C2022a {
        int action = -1;
        private long begin = 0;
        long boX = 0;
        String id = "";
        int status = 0;
        long total = 0;

        public C2022a(String str, int i2) {
            p.h(str, "id");
            AppMethodBeat.i(124794);
            this.id = str;
            this.action = i2;
            AppMethodBeat.o(124794);
        }

        public final void Mm(long j2) {
            AppMethodBeat.i(124792);
            if (this.status == 3 || this.status == 1) {
                Log.v("MicroMsg.BizImageBlankReporter", "alvinluo resume action: %d, id: %s, timestamp: %d", Integer.valueOf(this.action), this.id, Long.valueOf(j2));
                this.status = 2;
                if (j2 < 0) {
                    j2 = System.currentTimeMillis();
                }
                this.begin = j2;
                this.boX = 0;
            }
            AppMethodBeat.o(124792);
        }

        public final void Mn(long j2) {
            AppMethodBeat.i(124793);
            if (this.status == 2) {
                Log.v("MicroMsg.BizImageBlankReporter", "alvinluo pause action: %d, id: %s, status: %d, timestamp: %d", Integer.valueOf(this.action), this.id, Integer.valueOf(this.status), Long.valueOf(j2));
                if (j2 < 0) {
                    j2 = System.currentTimeMillis();
                }
                this.boX = j2;
                gmo();
                this.status = 3;
            }
            AppMethodBeat.o(124793);
        }

        /* access modifiers changed from: package-private */
        public final void gmo() {
            if (this.boX >= this.begin) {
                this.total += this.boX - this.begin;
            }
        }

        public final boolean isFinished() {
            return this.status == 4;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b0\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010N\u001a\u00020OJ\u0018\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u001eH\u0002J\u0018\u0010S\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u00072\b\b\u0002\u0010T\u001a\u00020\u001eJ\u0010\u0010U\u001a\u00020O2\b\b\u0002\u0010T\u001a\u00020\u001eJ\u0006\u0010V\u001a\u00020\u0014J\u000e\u0010W\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u0007J\u0006\u0010X\u001a\u00020\u0014J\u0010\u0010Y\u001a\u00020O2\u0006\u0010T\u001a\u00020\u001eH\u0002J\u0010\u0010-\u001a\u00020O2\u0006\u0010T\u001a\u00020\u001eH\u0002J\u0018\u0010Z\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u00072\b\b\u0002\u0010T\u001a\u00020\u001eJ\u0006\u0010[\u001a\u00020OJ\u0018\u0010\\\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u00072\b\b\u0002\u0010T\u001a\u00020\u001eJ\u0010\u0010]\u001a\u00020O2\b\b\u0002\u0010T\u001a\u00020\u001eJ\u0010\u0010^\u001a\u00020O2\b\b\u0002\u0010T\u001a\u00020\u001eJ\u0018\u0010_\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u00072\b\b\u0002\u0010T\u001a\u00020\u001eJ\b\u0010`\u001a\u00020\u0003H\u0016R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010'\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u001a\u0010*\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u0004R\u001a\u0010-\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u0018R\u001a\u00100\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0010\"\u0004\b2\u0010\u0012R\u000e\u00103\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\u001a\u00107\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010 \"\u0004\b9\u0010\"R\u001a\u0010:\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R\u001a\u0010=\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010 \"\u0004\b?\u0010\"R\u001a\u0010@\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R\u001a\u0010C\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010 \"\u0004\bE\u0010\"R\u001a\u0010F\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010 \"\u0004\bH\u0010\"R\u001a\u0010I\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010 \"\u0004\bK\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\f\"\u0004\bM\u0010\u0004¨\u0006a"}, hxF = {"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$BizImageBlankReportInfo;", "", "url", "", "(Ljava/lang/String;)V", "actionTimePointMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ActionTimeInfo;", "Lkotlin/collections/HashMap;", "appMsgUrl", "getAppMsgUrl", "()Ljava/lang/String;", "setAppMsgUrl", "currentAction", "getCurrentAction", "()I", "setCurrentAction", "(I)V", "downloadSuccess", "", "getDownloadSuccess", "()Z", "setDownloadSuccess", "(Z)V", "hasTask", "getHasTask", "setHasTask", "id", "imageSize", "", "getImageSize", "()J", "setImageSize", "(J)V", "isPausedByScrollFling", "setPausedByScrollFling", "isTaskRunning", "setTaskRunning", ImagesContract.LOCAL, "getLocal", "setLocal", DownloadInfo.NETTYPE, "getNetType", "setNetType", "onScreen", "getOnScreen", "setOnScreen", "position", "getPosition", "setPosition", "resultValid", "retryCount", "getRetryCount", "setRetryCount", "timeFile", "getTimeFile", "setTimeFile", "timeHevc", "getTimeHevc", "setTimeHevc", "timeNet", "getTimeNet", "setTimeNet", "timeScroll", "getTimeScroll", "setTimeScroll", "timeTaskRun", "getTimeTaskRun", "setTimeTaskRun", "timeThread", "getTimeThread", "setTimeThread", "timeTotal", "getTimeTotal", "setTimeTotal", "getUrl", "setUrl", "fillResult", "", "fillTime", NativeProtocol.WEB_DIALOG_ACTION, "time", "finish", AppMeasurement.Param.TIMESTAMP, MessengerShareContentUtility.SHARE_BUTTON_HIDE, "isBlank", "isFinished", "isResultValid", "offScreen", "pause", "reset", "resume", "retryDownload", "show", "start", "toString", "plugin-biz_release"})
    public static final class b {
        boolean BPb;
        boolean JUA;
        long JUm;
        long JUn;
        long JUo;
        long JUp;
        long JUq;
        long JUr;
        private long JUs;
        String JUt = "";
        long JUu;
        boolean JUv;
        boolean JUw;
        boolean JUx;
        boolean JUy;
        HashMap<Integer, C2022a> JUz = new HashMap<>();
        String id = "";
        int jCM = -1;
        int position = -1;
        int retryCount;
        String url = "";
        String wib = "";
        boolean xqn;

        public final void bdm(String str) {
            AppMethodBeat.i(124795);
            p.h(str, "<set-?>");
            this.JUt = str;
            AppMethodBeat.o(124795);
        }

        public b(String str) {
            p.h(str, "url");
            AppMethodBeat.i(124800);
            this.url = str;
            a aVar = a.JUl;
            this.id = a.bdl(str);
            AppMethodBeat.o(124800);
        }

        public final String toString() {
            AppMethodBeat.i(124796);
            kotlin.g.b.ae aeVar = kotlin.g.b.ae.SYK;
            a aVar = a.JUl;
            String format = String.format("BizImageBlankReportInfo %s {id: %s, timeTotal: %d, timeTaskRun: %d, timeFile: %d, timeNet: %d, timeScroll: %d, timeHevc: %d, timeThread: %d, \nnetType: %s, position: %d, imageSize: %d, retryCount: %d, downloadSuccess: %b, local: %b, \nurl: %s}", Arrays.copyOf(new Object[]{Integer.valueOf(hashCode()), a.bdl(this.url), Long.valueOf(this.JUm), Long.valueOf(this.JUs), Long.valueOf(this.JUn), Long.valueOf(this.JUo), Long.valueOf(this.JUp), Long.valueOf(this.JUq), Long.valueOf(this.JUr), this.wib, Integer.valueOf(this.position), Long.valueOf(this.JUu), Integer.valueOf(this.retryCount), Boolean.valueOf(this.JUv), Boolean.valueOf(this.BPb), this.url}, 16));
            p.g(format, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(124796);
            return format;
        }

        public final void aQ(int i2, long j2) {
            AppMethodBeat.i(124797);
            if (i2 == 2) {
                this.xqn = true;
                this.JUw = true;
            } else if (i2 == 9) {
                this.JUx = true;
            }
            C2022a aVar = this.JUz.get(Integer.valueOf(i2));
            if (aVar == null) {
                C2022a aVar2 = new C2022a(this.id, i2);
                this.JUz.put(Integer.valueOf(i2), aVar2);
                aVar = aVar2;
            }
            if (aVar.status == 0) {
                Log.v("MicroMsg.BizImageBlankReporter", "alvinluo start action: %d, id: %s, status: %d, timestamp: %d", Integer.valueOf(aVar.action), aVar.id, Integer.valueOf(aVar.status), Long.valueOf(j2));
                aVar.status = 1;
            }
            if (i2 == 1 || i2 == 2) {
                aVar.Mm(j2);
            } else {
                aVar.Mm(j2);
            }
            if (i2 != 9) {
                this.jCM = i2;
            }
            AppMethodBeat.o(124797);
        }

        public final void aR(int i2, long j2) {
            AppMethodBeat.i(124798);
            C2022a aVar = this.JUz.get(Integer.valueOf(i2));
            if (aVar != null && (aVar.status == 2 || aVar.status == 3)) {
                Log.v("MicroMsg.BizImageBlankReporter", "alvinluo finish action: %d, id: %s, status: %d, timestamp: %d", Integer.valueOf(aVar.action), aVar.id, Integer.valueOf(aVar.status), Long.valueOf(j2));
                if (aVar.status == 2) {
                    if (j2 < 0) {
                        j2 = System.currentTimeMillis();
                    }
                    aVar.boX = j2;
                    aVar.gmo();
                }
                aVar.status = 4;
            }
            this.jCM = -1;
            if (i2 == 9) {
                this.JUx = false;
            }
            AppMethodBeat.o(124798);
        }

        public final boolean gmp() {
            AppMethodBeat.i(124799);
            C2022a aVar = this.JUz.get(1);
            if (aVar != null) {
                boolean isFinished = aVar.isFinished();
                AppMethodBeat.o(124799);
                return isFinished;
            }
            AppMethodBeat.o(124799);
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void aS(int i2, long j2) {
            switch (i2) {
                case 1:
                    this.JUm = j2;
                    return;
                case 2:
                    this.JUs = j2;
                    return;
                case 3:
                    this.JUo = j2;
                    return;
                case 4:
                    this.JUm = j2;
                    return;
                case 5:
                case 6:
                case 7:
                    this.JUn += j2;
                    return;
                case 8:
                    this.JUr = j2;
                    return;
                case 9:
                    this.JUp = j2;
                    return;
                default:
                    return;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "", "()V", "fromFileCount", "", "getFromFileCount", "()I", "setFromFileCount", "(I)V", "fromMemoryCount", "getFromMemoryCount", "setFromMemoryCount", "fromNetCount", "getFromNetCount", "setFromNetCount", "totalCount", "getTotalCount", "setTotalCount", "reset", "", "toString", "", "plugin-biz_release"})
    public static final class c {
        int JUB;
        int JUC;
        int JUD;
        int gAZ;

        public final String toString() {
            AppMethodBeat.i(124801);
            kotlin.g.b.ae aeVar = kotlin.g.b.ae.SYK;
            String format = String.format("totalCount: %d, fromNetCount: %d, fromFileCount: %d, fromMemoryCount: %d", Arrays.copyOf(new Object[]{Integer.valueOf(this.gAZ), Integer.valueOf(this.JUB), Integer.valueOf(this.JUC), Integer.valueOf(this.JUD)}, 4));
            p.g(format, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(124801);
            return format;
        }
    }

    public static /* synthetic */ void de(int i2, String str) {
        long j2 = 0;
        AppMethodBeat.i(124817);
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            if (0 == 0) {
                j2 = System.currentTimeMillis();
            }
            v(new d(str, i2, j2));
        }
        AppMethodBeat.o(124817);
    }

    public static final /* synthetic */ void a(b bVar, com.tencent.mm.av.a.d.b bVar2) {
        AppMethodBeat.i(124822);
        com.tencent.f.h.RTc.b(new f(bVar, bVar2), "biz_image_blank_report");
        AppMethodBeat.o(124822);
    }

    public static final /* synthetic */ void b(b bVar, com.tencent.mm.av.a.d.b bVar2) {
        Bitmap bitmap;
        boolean z;
        long j2;
        String str;
        String str2;
        kotlin.k.f fVar;
        String str3;
        boolean z2;
        AppMethodBeat.i(124823);
        if (bVar2 == null || bVar2.from != 2) {
            if (bVar2 != null) {
                bitmap = bVar2.bitmap;
            } else {
                bitmap = null;
            }
            if (bitmap != null) {
                z = true;
            } else {
                z = false;
            }
            bVar.JUv = z;
            bVar.BPb = true;
        } else {
            if (bVar2.data != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.JUv = z2;
        }
        if (bVar2 != null) {
            j2 = (long) bVar2.jbH;
        } else {
            j2 = -1;
        }
        bVar.JUu = j2;
        com.tencent.mm.pluginsdk.ui.applet.g gVar = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
        String iz = com.tencent.mm.pluginsdk.ui.applet.g.iz(MMApplicationContext.getContext());
        p.h(iz, "<set-?>");
        bVar.wib = iz;
        String str4 = bVar.JUt;
        kotlin.n.i p = new kotlin.n.k("https?://([0-9a-zA-Z.]+)/").p(str4, 0);
        if (p == null || p.hMh() == null) {
            str = str4;
        } else {
            if (p.hMh().size() > 1) {
                kotlin.n.f avS = p.hMh().avS(1);
                if (avS != null) {
                    str2 = avS.value;
                } else {
                    str2 = null;
                }
                kotlin.n.f avS2 = p.hMh().avS(1);
                if (avS2 != null) {
                    fVar = avS2.TSZ;
                } else {
                    fVar = null;
                }
                String str5 = JUk.get(str2);
                if (str5 == null) {
                    str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } else {
                    str3 = str5;
                }
                p.g(str3, "HOST_NAME_MAP[toReplace] ?: \"0\"");
                if (fVar != null) {
                    if (str4 == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                        AppMethodBeat.o(124823);
                        throw tVar;
                    }
                    String str6 = str4;
                    String str7 = str3;
                    p.h(str6, "$this$replaceRange");
                    p.h(fVar, "range");
                    p.h(str7, "replacement");
                    str = n.a(str6, fVar.SYU, fVar.SYV + 1, str7).toString();
                    Log.v("MicroMsg.BizImageBlankReporter", "alvinluo simplifyAppMsg old: %s, new: %s", str4, str);
                }
            }
            str = str4;
            Log.v("MicroMsg.BizImageBlankReporter", "alvinluo simplifyAppMsg old: %s, new: %s", str4, str);
        }
        bVar.bdm(str);
        if (bVar.JUu <= 0) {
            bVar.JUu = com.tencent.mm.vfs.s.boW(s.bdu(bVar.url));
        }
        AppMethodBeat.o(124823);
    }

    public static final /* synthetic */ void a(com.tencent.mm.av.a.d.b bVar) {
        JUi.gAZ++;
        if (bVar != null && bVar.from == 0) {
            JUi.JUD++;
        } else if (bVar != null && bVar.from == 1) {
            JUi.JUC++;
        } else if (bVar != null && bVar.from == 2) {
            JUi.JUB++;
        }
    }

    public static final /* synthetic */ void a(b bVar) {
        int i2 = 1;
        AppMethodBeat.i(124824);
        Log.i("MicroMsg.BizImageBlankReporter", "alvinluo reportBlank doReport reportInfo %s", bVar);
        com.tencent.mm.pluginsdk.ui.applet.g gVar = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
        Uri parse = Uri.parse(bVar.url);
        p.g(parse, "Uri.parse(reportInfo.url)");
        String b2 = com.tencent.mm.pluginsdk.ui.applet.g.b(parse, "tp");
        p.h(b2, "<set-?>");
        bVar.url = b2;
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[13];
        objArr[0] = Long.valueOf(bVar.JUm);
        objArr[1] = Long.valueOf(bVar.JUn);
        objArr[2] = Long.valueOf(bVar.JUo);
        objArr[3] = Long.valueOf(bVar.JUp);
        objArr[4] = Integer.valueOf(bVar.position);
        objArr[5] = bVar.wib;
        objArr[6] = bVar.url;
        objArr[7] = Long.valueOf(bVar.JUu);
        objArr[8] = Integer.valueOf(bVar.retryCount);
        if (!bVar.JUv) {
            i2 = 0;
        }
        objArr[9] = Integer.valueOf(i2);
        objArr[10] = Long.valueOf(bVar.JUq);
        objArr[11] = Long.valueOf(bVar.JUr);
        objArr[12] = bVar.JUt;
        hVar.a(17611, objArr);
        AppMethodBeat.o(124824);
    }

    public static final /* synthetic */ void gmn() {
        AppMethodBeat.i(124825);
        Log.i("MicroMsg.BizImageBlankReporter", "alvinluo resetImageLoadCountInfo %s", JUi);
        c cVar = JUi;
        cVar.gAZ = 0;
        cVar.JUB = 0;
        cVar.JUC = 0;
        cVar.JUD = 0;
        AppMethodBeat.o(124825);
    }
}

package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import android.net.Uri;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.network.ai;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.ad.c;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.brandservice.c;
import com.tencent.mm.plugin.webview.core.g;
import com.tencent.mm.plugin.webview.k.e;
import com.tencent.mm.protocal.protobuf.bhb;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.protocal.protobuf.bhe;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.fai;
import com.tencent.mm.protocal.protobuf.faj;
import com.tencent.mm.protocal.protobuf.fak;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.__BATCH_RUN_OBJ;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tavkit.component.TAVPlayer;
import com.tencent.xweb.WebResourceResponse;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a.ae;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.bu;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\t\u0001\u0001\u0001\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fJ!\u0010.\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0/\u0018\u00010/2\u0006\u0010-\u001a\u00020\u001f¢\u0006\u0002\u00100JB\u00101\u001a\u0002022\u0006\u0010-\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00042\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u000108H\u0002J\u0019\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020;H@ø\u0001\u0000¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020,2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?2\u0006\u00103\u001a\u00020\u001fH\u0002J\u000e\u0010A\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001fJ\u0010\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010-\u001a\u00020\u001fJ\"\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010E\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f2\b\u0010F\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010G\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010H\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001fJ\u0016\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010?2\u0006\u0010-\u001a\u00020\u001fJ\u0010\u0010J\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u001fH\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010-\u001a\u00020\u001fH\u0002J\u0010\u0010M\u001a\u00020\u00162\b\u0010-\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010N\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u001fH\u0002J\u000e\u0010O\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u001fJ\u000e\u0010P\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u001fJ\u0016\u0010Q\u001a\u00020\u00162\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u001fJ\u0018\u0010T\u001a\u00020\u00162\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u001fH\u0002J \u0010U\u001a\u0004\u0018\u00010;2\u0006\u0010-\u001a\u00020\u001f2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020W0?H\u0002J\u0010\u0010X\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u001fH\u0002JB\u0010Y\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001f2\b\b\u0002\u0010F\u001a\u00020\u001f2\b\b\u0002\u0010Z\u001a\u00020\u001f2\b\b\u0002\u0010[\u001a\u00020\u001f2\b\b\u0002\u0010\\\u001a\u00020\u001f2\b\b\u0002\u0010]\u001a\u00020\u0004H\u0007J\u0016\u0010^\u001a\u00020,2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020`0?H\u0007J\u0016\u0010a\u001a\u00020,2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001f0?H\u0002JN\u0010c\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010d\u001a\u00020\u001f2\b\b\u0002\u0010e\u001a\u00020\u00162\u0016\b\u0002\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u0001082\b\b\u0002\u0010g\u001a\u00020\u00042\b\b\u0002\u0010h\u001a\u00020\u0004H\u0002J\u0016\u0010i\u001a\u00020,2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020k0?H\u0002J\u0016\u0010l\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010]\u001a\u00020\u0004J(\u0010m\u001a\u000202*\u0002022\u0006\u00104\u001a\u0002052\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160oH\u0002JB\u0010m\u001a\u000202*\u0002022\u0006\u0010p\u001a\u00020q2\u0014\b\u0002\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160o2\u0016\b\u0002\u0010r\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020,\u0018\u00010oH\u0002J\f\u0010s\u001a\u00020,*\u00020tH\u0002J\u001a\u0010u\u001a\u00020v*\u00020v2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020k0?H\u0002J\f\u0010w\u001a\u00020,*\u00020LH\u0002J\f\u0010x\u001a\u00020,*\u00020tH\u0002J \u0010y\u001a\b\u0012\u0004\u0012\u00020W0?*\u00020t2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020|0{H\u0002J\"\u0010}\u001a\u00020,*\u00020t2\u0006\u0010~\u001a\u00020v2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020W0?H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u001a\u001a\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0014R\u0014\u0010)\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher;", "", "()V", "MIN_EXPIRE_SECONDS", "", "PRE_AUTH_EXPIRE_SECONDS", "REFRESH_BEFORE_EXPIRE_SECONDS", "value", "currentScene", "getCurrentScene", "()I", "setCurrentScene", "(I)V", "preauthRequestLimiter", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "getPreauthRequestLimiter$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "prefetchInfoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getPrefetchInfoManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "prefetchTestMode", "", "getPrefetchTestMode", "()Z", "prefetchTestMode$delegate", "Lkotlin/Lazy;", "resHeadersManager", "getResHeadersManager$plugin_brandservice_release", "sendingGetA8keyLiteQueue", "Ljava/util/concurrent/ConcurrentSkipListSet;", "", "settingManager", "getSettingManager$plugin_brandservice_release", "userAgentInfo", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "getUserAgentInfo", "()Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "userAgentInfo$delegate", "webHeadersManager", "getWebHeadersManager$plugin_brandservice_release", "webIdToSceneManager", "getWebIdToSceneManager$plugin_brandservice_release", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "fetchContent", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "host", "target", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "deep", "prefetchHeaders", "", "fetchManifest", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRes", "batchRes", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "appId", "getReportScene", "getRespUrl", "getUrlCookie", "getUrlScene", "getValidPreloadWebInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "isDnsCached", "isInPreAuthWhiteList", "isUrlCache", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "isWebUrlStorageEqual", "matchManifest", "domains", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "needReauth", "preAuth", "title", "desc", "from", "scene", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "preDns", "urls", "prefetch", "prefetchUrl", "checkCacheOnly", "headers", "bizScene", "subBizScene", "sendGetA8KeyLiteRequest", "preauths", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "setUrlToScene", "connect", "receiveHeader", "Lkotlin/Function1;", "targetFile", "Lcom/tencent/mm/vfs/VFSFile;", "onCompleted", "mockManifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteResponse;", "prepare", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteRequest;", "save", "saveDomainInfos", "saveManifest", "localPrefetchDomainInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "savePrefetch", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "BatchPreauth", "PrefetchAction", "PrefetchRes", "PrefetchTarget", "PrefetchType", "plugin-brandservice_release"})
public final class v {
    private static final MMKVSlotManager pDA = new MMKVSlotManager(x.coM(), 604800);
    private static final ConcurrentSkipListSet<String> pDB = new ConcurrentSkipListSet<>();
    private static final kotlin.f pDC = kotlin.g.ah(s.pFa);
    private static final MMCacheSlotManager pDD = new MMCacheSlotManager();
    private static final kotlin.f pDE = kotlin.g.ah(n.pEB);
    private static final MMKVSlotManager pDF = new MMKVSlotManager(u.coo(), 86400);
    public static final v pDG = new v();
    private static final MMKVSlotManager pDx = new MMKVSlotManager(x.coM(), 3600);
    private static final MMKVSlotManager pDy = new MMKVSlotManager(x.coM(), 604800);
    private static final MMKVSlotManager pDz = new MMKVSlotManager(x.coM(), 86400);

    public static boolean cou() {
        AppMethodBeat.i(195731);
        boolean booleanValue = ((Boolean) pDE.getValue()).booleanValue();
        AppMethodBeat.o(195731);
        return booleanValue;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class g extends kotlin.g.b.q implements kotlin.g.a.b<Integer, Boolean> {
        public static final g pEi = new g();

        static {
            AppMethodBeat.i(195697);
            AppMethodBeat.o(195697);
        }

        g() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Integer num) {
            boolean z;
            AppMethodBeat.i(195696);
            if (num.intValue() == 200) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(195696);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke"})
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.b<z, z> {
        final /* synthetic */ String mkH;
        final /* synthetic */ Map pEj;
        final /* synthetic */ d pEk;
        final /* synthetic */ String pEl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(Map map, d dVar, String str, String str2) {
            super(1);
            this.pEj = map;
            this.pEk = dVar;
            this.pEl = str;
            this.mkH = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ z invoke(z zVar) {
            AppMethodBeat.i(195701);
            final z zVar2 = zVar;
            kotlin.g.b.p.h(zVar2, "conn");
            Map map = this.pEj;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    zVar2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            Log.i("MicroMsg.WebPrefetcher", "fetch content @" + this.pEk.cox());
            v vVar = v.pDG;
            z a2 = v.a(zVar2, this.pEk, new kotlin.g.a.b<Integer, Boolean>(this) {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.h.AnonymousClass1 */
                final /* synthetic */ h pEm;

                {
                    this.pEm = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ Boolean invoke(Integer num) {
                    boolean z;
                    boolean z2 = false;
                    AppMethodBeat.i(195700);
                    final int intValue = num.intValue();
                    AnonymousClass1 r2 = new kotlin.g.a.a<Boolean>(this) {
                        /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.h.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 pEo;

                        {
                            this.pEo = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ Boolean invoke() {
                            AppMethodBeat.i(195698);
                            Boolean valueOf = Boolean.valueOf(ij());
                            AppMethodBeat.o(195698);
                            return valueOf;
                        }

                        public final boolean ij() {
                            AppMethodBeat.i(195699);
                            d dVar = this.pEo.pEm.pEk;
                            synchronized (zVar2) {
                                try {
                                    Map<String, List<String>> headerFields = zVar2.getHeaderFields();
                                    kotlin.g.b.p.g(headerFields, "conn.headerFields");
                                    for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                                        String key = entry.getKey();
                                        List<String> value = entry.getValue();
                                        if (!kotlin.g.b.p.j(key, "status")) {
                                            HashMap<String, List<String>> coB = dVar.coB();
                                            kotlin.g.b.p.g(key, "key");
                                            if (key == null) {
                                                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                                                AppMethodBeat.o(195699);
                                                throw tVar;
                                            }
                                            String lowerCase = key.toLowerCase();
                                            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
                                            kotlin.g.b.p.g(value, "value");
                                            coB.put(lowerCase, value);
                                        }
                                    }
                                    if (intValue == 304) {
                                        dVar.coB().put("status", kotlin.a.j.listOf("200"));
                                    } else {
                                        dVar.coB().put("status", kotlin.a.j.listOf(String.valueOf(intValue)));
                                    }
                                    x xVar = x.SXb;
                                } finally {
                                    AppMethodBeat.o(195699);
                                }
                            }
                            switch (intValue) {
                                case 200:
                                case 304:
                                    AppMethodBeat.o(195699);
                                    return true;
                                case 301:
                                case 302:
                                    Set<String> keySet = this.pEo.pEm.pEk.coB().keySet();
                                    kotlin.g.b.p.g(keySet, "target.headers.keys");
                                    Set<String> set = keySet;
                                    if (!(set instanceof Collection) || !set.isEmpty()) {
                                        for (T t : set) {
                                            kotlin.g.b.p.g(t, LocaleUtil.ITALIAN);
                                            if (t == null) {
                                                t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                                                AppMethodBeat.o(195699);
                                                throw tVar2;
                                            }
                                            String lowerCase2 = t.toLowerCase();
                                            kotlin.g.b.p.g(lowerCase2, "(this as java.lang.String).toLowerCase()");
                                            if (kotlin.g.b.p.j(lowerCase2, FirebaseAnalytics.b.LOCATION)) {
                                                return true;
                                            }
                                        }
                                        AppMethodBeat.o(195699);
                                        return false;
                                    }
                                    AppMethodBeat.o(195699);
                                    return false;
                                default:
                                    Log.e("MicroMsg.WebPrefetcher", "checkHeaders invalid:response:" + intValue);
                                    AppMethodBeat.o(195699);
                                    return false;
                            }
                        }
                    };
                    switch (intValue) {
                        case 200:
                            z = r2.ij();
                            if (z) {
                                this.pEm.pEk.a(e.HTML, this.pEm.pEl);
                            } else {
                                Log.e("MicroMsg.WebPrefetcher", "fetch error: invalid headers " + zVar2.getURL());
                            }
                            v vVar = v.pDG;
                            com.tencent.mm.plugin.webview.i.b.ags(v.ahE(this.pEm.mkH));
                            break;
                        case 301:
                        case 302:
                            boolean ij = r2.ij();
                            if (ij) {
                                this.pEm.pEk.a(e.HTML, this.pEm.pEl);
                                if (!kotlin.n.n.aL(this.pEm.pEk.getLocation())) {
                                    z2 = true;
                                }
                                if (z2) {
                                    v vVar2 = v.pDG;
                                    v.cH(kotlin.a.j.listOf(new a(this.pEm.pEk.getLocation(), "", "", "", this.pEm.pEk.coz(), this.pEm.pEk.coA(), this.pEm.mkH, null, 128)));
                                }
                            } else {
                                Log.e("MicroMsg.WebPrefetcher", "fetch error: invalid headers " + zVar2.getURL());
                            }
                            z = ij;
                            break;
                        case 304:
                            z = r2.ij();
                            if (z) {
                                this.pEm.pEk.a(e.HTML, this.pEm.pEl);
                                Log.i("MicroMsg.WebPrefetcher", "update " + zVar2.getURL() + ": " + this.pEm.pEk.coF());
                            } else {
                                Log.e("MicroMsg.WebPrefetcher", "update fail " + zVar2.getURL() + ": " + this.pEm.pEk.coF());
                            }
                            v vVar3 = v.pDG;
                            com.tencent.mm.plugin.webview.i.b.agt(v.ahE(this.pEm.mkH));
                            break;
                        default:
                            v vVar4 = v.pDG;
                            com.tencent.mm.plugin.webview.i.b.agu(v.ahE(this.pEm.mkH));
                            Log.e("MicroMsg.WebPrefetcher", "fetch error: respCode:" + zVar2.getResponseCode() + " respMsg:" + zVar2.getResponseMessage() + ", url:" + zVar2.getURL());
                            z = false;
                            break;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(195700);
                    return valueOf;
                }
            });
            AppMethodBeat.o(195701);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchManifest$2$1"})
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.b<z, z> {
        final /* synthetic */ String pAl;
        final /* synthetic */ kotlin.d.d pEq;
        final /* synthetic */ com.tencent.mm.plugin.ad.a pEr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(String str, kotlin.d.d dVar, com.tencent.mm.plugin.ad.a aVar) {
            super(1);
            this.pAl = str;
            this.pEq = dVar;
            this.pEr = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ z invoke(z zVar) {
            AppMethodBeat.i(195703);
            z zVar2 = zVar;
            kotlin.g.b.p.h(zVar2, "conn");
            v vVar = v.pDG;
            c.a aVar = com.tencent.mm.plugin.ad.c.ICA;
            z a2 = v.a(zVar2, com.tencent.mm.plugin.ad.c.ICy.aWR(this.pAl), (kotlin.g.a.b) null, new kotlin.g.a.b<Boolean, x>(this) {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.i.AnonymousClass1 */
                final /* synthetic */ i pEs;

                {
                    this.pEs = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Boolean bool) {
                    AppMethodBeat.i(195702);
                    boolean booleanValue = bool.booleanValue();
                    Log.i("MicroMsg.WebPrefetcher", "fetch manifest:" + this.pEs.pEr.ICs.LQP + '#' + this.pEs.pAl + ", succ:" + booleanValue + ", path:" + this.pEs.pEr.ICt.xut + ", url:" + this.pEs.pEr.ICt.LQV);
                    if (booleanValue) {
                        String str = this.pEs.pEr.ICs.LQP;
                        kotlin.g.b.p.g(str, "manifest.domain.Domain");
                        c.ahT(str);
                        kotlin.d.d dVar = this.pEs.pEq;
                        Boolean bool2 = Boolean.TRUE;
                        Result.Companion companion = Result.Companion;
                        dVar.resumeWith(Result.m46constructorimpl(bool2));
                    } else {
                        kotlin.d.d dVar2 = this.pEs.pEq;
                        Boolean bool3 = Boolean.FALSE;
                        Result.Companion companion2 = Result.Companion;
                        dVar2.resumeWith(Result.m46constructorimpl(bool3));
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(195702);
                    return xVar;
                }
            }, 2);
            AppMethodBeat.o(195703);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$fetchRes$1$1"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.b<z, z> {
        final /* synthetic */ String pAl;
        final /* synthetic */ c pEt;
        final /* synthetic */ String pEu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(String str, c cVar, String str2) {
            super(1);
            this.pAl = str;
            this.pEt = cVar;
            this.pEu = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ z invoke(z zVar) {
            AppMethodBeat.i(195706);
            final z zVar2 = zVar;
            kotlin.g.b.p.h(zVar2, "conn");
            String url = zVar2.getURL();
            kotlin.g.b.p.g(url, "conn.url");
            String str = this.pAl;
            c.a aVar = com.tencent.mm.plugin.ad.c.ICA;
            com.tencent.mm.plugin.ad.b bVar = com.tencent.mm.plugin.ad.c.ICx;
            v vVar = v.pDG;
            final d dVar = new d(url, str, bVar, v.cos());
            v vVar2 = v.pDG;
            z a2 = v.a(zVar2, dVar, new kotlin.g.a.b<Integer, Boolean>(this) {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.j.AnonymousClass1 */
                final /* synthetic */ j pEv;

                {
                    this.pEv = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ Boolean invoke(Integer num) {
                    AppMethodBeat.i(195704);
                    Boolean valueOf = Boolean.valueOf(Dz(num.intValue()));
                    AppMethodBeat.o(195704);
                    return valueOf;
                }

                private boolean Dz(int i2) {
                    AppMethodBeat.i(195705);
                    switch (i2) {
                        case 200:
                            synchronized (zVar2) {
                                try {
                                    dVar.coB().putAll(zVar2.getHeaderFields());
                                    x xVar = x.SXb;
                                } catch (Throwable th) {
                                    AppMethodBeat.o(195705);
                                    throw th;
                                }
                            }
                            dVar.coB().put("status", kotlin.a.j.listOf(String.valueOf(i2)));
                            dVar.a(this.pEv.pEt.pDL, this.pEv.pEu);
                            AppMethodBeat.o(195705);
                            return true;
                        default:
                            AppMethodBeat.o(195705);
                            return false;
                    }
                }
            });
            AppMethodBeat.o(195706);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class o extends kotlin.g.b.q implements kotlin.g.a.b<bhd, String> {
        public static final o pEC = new o();

        static {
            AppMethodBeat.i(195711);
            AppMethodBeat.o(195711);
        }

        o() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(bhd bhd) {
            AppMethodBeat.i(195710);
            bhd bhd2 = bhd;
            String str = bhd2.xut + ',' + bhd2.LQW + ',' + bhd2.LQV;
            AppMethodBeat.o(195710);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLiteReqInfo;", "invoke"})
    public static final class q extends kotlin.g.b.q implements kotlin.g.a.b<bhe, String> {
        public static final q pEX = new q();

        static {
            AppMethodBeat.i(195716);
            AppMethodBeat.o(195716);
        }

        q() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(bhe bhe) {
            AppMethodBeat.i(195715);
            String str = bhe.LQZ;
            kotlin.g.b.p.g(str, "it.ReqUrl");
            AppMethodBeat.o(195715);
            return str;
        }
    }

    static {
        AppMethodBeat.i(6809);
        AppMethodBeat.o(6809);
    }

    private v() {
    }

    public static final /* synthetic */ void b(String str, String str2, Map map, int i2, int i3) {
        AppMethodBeat.i(195743);
        a(str, str2, map, i2, i3);
        AppMethodBeat.o(195743);
    }

    public static final /* synthetic */ void cH(List list) {
        AppMethodBeat.i(195737);
        cG(list);
        AppMethodBeat.o(195737);
    }

    public static MMKVSlotManager cop() {
        return pDx;
    }

    public static MMKVSlotManager coq() {
        return pDy;
    }

    public static MMKVSlotManager cor() {
        return pDz;
    }

    public static MMKVSlotManager cos() {
        return pDA;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "toString", "JS", "CSS", "HTML", "plugin-brandservice_release"})
    public enum e {
        JS("JS"),
        CSS("CSS"),
        HTML("HTML");
        
        private final String type;

        public static e valueOf(String str) {
            AppMethodBeat.i(195693);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(195693);
            return eVar;
        }

        private e(String str) {
            this.type = str;
        }

        static {
            AppMethodBeat.i(195691);
            AppMethodBeat.o(195691);
        }

        public final String toString() {
            return this.type;
        }
    }

    static /* synthetic */ z a(z zVar, com.tencent.mm.vfs.o oVar, kotlin.g.a.b bVar, kotlin.g.a.b bVar2, int i2) {
        g gVar;
        AppMethodBeat.i(195721);
        if ((i2 & 2) != 0) {
            gVar = g.pEi;
        } else {
            gVar = bVar;
        }
        kotlin.g.a.b bVar3 = (i2 & 4) != 0 ? null : bVar2;
        Context context = MMApplicationContext.getContext();
        e.a aVar = com.tencent.mm.plugin.webview.k.e.JBw;
        String a2 = com.tencent.mm.plugin.appbrand.ac.p.a(context, e.a.giH(), (com.tencent.mm.plugin.webview.k.e) pDC.getValue());
        Log.v("MicroMsg.WebPrefetcher", "prefetch UA:".concat(String.valueOf(a2)));
        zVar.setRequestProperty("User-Agent", a2);
        zVar.bjR();
        zVar.setUseCaches(false);
        zVar.setRequestMethod("GET");
        zVar.bjT();
        String k2 = com.tencent.mm.vfs.s.k(oVar.getPath(), true);
        zVar.setSavePath(k2 + ".fd");
        zVar.bjS();
        zVar.a(new f(zVar, k2, oVar, gVar, bVar3));
        zVar.setReadTimeout(10000);
        zVar.setConnectTimeout(3000);
        zVar.connect();
        AppMethodBeat.o(195721);
        return zVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$connect$2$1", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskCallback;", "onCronetReceiveHeader", "", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "Lcom/tencent/mars/cdn/CronetLogic$ResponseHeader;", "status_code", "onCronetTaskCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "onDownloadProgressChanged", "progress", "Lcom/tencent/mars/cdn/CronetLogic$CronetDownloadProgress;", "plugin-brandservice_release"})
    public static final class f implements CronetLogic.CronetTaskCallback {
        final /* synthetic */ kotlin.g.a.b pAj;
        final /* synthetic */ z pEe;
        final /* synthetic */ String pEf;
        final /* synthetic */ com.tencent.mm.vfs.o pEg;
        final /* synthetic */ kotlin.g.a.b pEh;

        f(z zVar, String str, com.tencent.mm.vfs.o oVar, kotlin.g.a.b bVar, kotlin.g.a.b bVar2) {
            this.pEe = zVar;
            this.pEf = str;
            this.pEg = oVar;
            this.pEh = bVar;
            this.pAj = bVar2;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public final void onCronetTaskCompleted(String str, CronetLogic.CronetTaskResult cronetTaskResult) {
            AppMethodBeat.i(195694);
            if (cronetTaskResult != null) {
                switch (cronetTaskResult.statusCode) {
                    case 200:
                        if (!com.tencent.mm.vfs.s.nx(this.pEe.getSavePath(), this.pEf)) {
                            Log.e("MicroMsg.WebPrefetcher", "save conn failed:" + this.pEe.getURL() + " to " + this.pEe.getSavePath());
                            break;
                        } else {
                            Log.i("MicroMsg.WebPrefetcher", "save file:" + this.pEe.getURL() + " to " + this.pEf);
                            break;
                        }
                    case 301:
                    case 302:
                        this.pEh.invoke(Integer.valueOf(cronetTaskResult.statusCode));
                        break;
                }
            }
            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(this.pEe.getSavePath());
            if (oVar.exists()) {
                oVar.delete();
            }
            kotlin.g.a.b bVar = this.pAj;
            if (bVar != null) {
                bVar.invoke(Boolean.valueOf(com.tencent.mm.vfs.s.YS(this.pEf)));
                AppMethodBeat.o(195694);
                return;
            }
            AppMethodBeat.o(195694);
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public final void onDownloadProgressChanged(String str, CronetLogic.CronetDownloadProgress cronetDownloadProgress) {
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public final int onCronetReceiveHeader(CronetLogic.ResponseHeader responseHeader, int i2) {
            AppMethodBeat.i(195695);
            if (((Boolean) this.pEh.invoke(Integer.valueOf(i2))).booleanValue()) {
                AppMethodBeat.o(195695);
                return 0;
            }
            kotlin.g.a.b bVar = this.pAj;
            if (bVar != null) {
                bVar.invoke(Boolean.FALSE);
            }
            AppMethodBeat.o(195695);
            return -99;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JS\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchAction;", "", "host", "", "rawUrl", "prefetchUrl", "checkCacheOnly", "", "prefetchHeader", "", "bizScene", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;I)V", "getBizScene", "()I", "getCheckCacheOnly", "()Z", "getHost", "()Ljava/lang/String;", "getPrefetchHeader", "()Ljava/util/Map;", "getPrefetchUrl", "getRawUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-brandservice_release"})
    public static final class b {
        final String edo;
        private final int hDa;
        final String host;
        final String pDI;
        final boolean pDJ;
        final Map<String, String> pDK;

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
            if (r3.hDa == r4.hDa) goto L_0x0042;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 195651(0x2fc43, float:2.74165E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0042
                boolean r0 = r4 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.b
                if (r0 == 0) goto L_0x0047
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.v$b r4 = (com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.b) r4
                java.lang.String r0 = r3.host
                java.lang.String r1 = r4.host
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                java.lang.String r0 = r3.edo
                java.lang.String r1 = r4.edo
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                java.lang.String r0 = r3.pDI
                java.lang.String r1 = r4.pDI
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                boolean r0 = r3.pDJ
                boolean r1 = r4.pDJ
                if (r0 != r1) goto L_0x0047
                java.util.Map<java.lang.String, java.lang.String> r0 = r3.pDK
                java.util.Map<java.lang.String, java.lang.String> r1 = r4.pDK
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                int r0 = r3.hDa
                int r1 = r4.hDa
                if (r0 != r1) goto L_0x0047
            L_0x0042:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0046:
                return r0
            L_0x0047:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0046
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(195650);
            String str = this.host;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.edo;
            int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
            String str3 = this.pDI;
            int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
            boolean z = this.pDJ;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = (i3 + hashCode3) * 31;
            Map<String, String> map = this.pDK;
            if (map != null) {
                i2 = map.hashCode();
            }
            int i7 = ((i6 + i2) * 31) + this.hDa;
            AppMethodBeat.o(195650);
            return i7;
        }

        public final String toString() {
            AppMethodBeat.i(195649);
            String str = "PrefetchAction(host=" + this.host + ", rawUrl=" + this.edo + ", prefetchUrl=" + this.pDI + ", checkCacheOnly=" + this.pDJ + ", prefetchHeader=" + this.pDK + ", bizScene=" + this.hDa + ")";
            AppMethodBeat.o(195649);
            return str;
        }

        private b(String str, String str2, String str3, boolean z, Map<String, String> map) {
            kotlin.g.b.p.h(str, "host");
            kotlin.g.b.p.h(str2, "rawUrl");
            kotlin.g.b.p.h(str3, "prefetchUrl");
            AppMethodBeat.i(195648);
            this.host = str;
            this.edo = str2;
            this.pDI = str3;
            this.pDJ = z;
            this.pDK = map;
            this.hDa = 0;
            AppMethodBeat.o(195648);
        }

        public /* synthetic */ b(String str, String str2, String str3, boolean z, Map map, byte b2) {
            this(str, str2, str3, false, map);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchRes;", "", "url", "", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "bizScene", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;I)V", "getBizScene", "()I", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-brandservice_release"})
    public static final class c {
        private final int hDa;
        final e pDL;
        final String url;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (r3.hDa == r4.hDa) goto L_0x0028;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 195655(0x2fc47, float:2.74171E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0028
                boolean r0 = r4 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.c
                if (r0 == 0) goto L_0x002d
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.v$c r4 = (com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.c) r4
                java.lang.String r0 = r3.url
                java.lang.String r1 = r4.url
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.v$e r0 = r3.pDL
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.v$e r1 = r4.pDL
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                int r0 = r3.hDa
                int r1 = r4.hDa
                if (r0 != r1) goto L_0x002d
            L_0x0028:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x002c:
                return r0
            L_0x002d:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.c.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(195654);
            String str = this.url;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            e eVar = this.pDL;
            if (eVar != null) {
                i2 = eVar.hashCode();
            }
            int i3 = ((hashCode + i2) * 31) + this.hDa;
            AppMethodBeat.o(195654);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(195653);
            String str = "PrefetchRes(url=" + this.url + ", type=" + this.pDL + ", bizScene=" + this.hDa + ")";
            AppMethodBeat.o(195653);
            return str;
        }

        public c(String str, e eVar, int i2) {
            kotlin.g.b.p.h(str, "url");
            kotlin.g.b.p.h(eVar, "type");
            AppMethodBeat.i(195652);
            this.url = str;
            this.pDL = eVar;
            this.hDa = i2;
            AppMethodBeat.o(195652);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\n\u0010S\u001a\u0004\u0018\u00010CH\u0002J\u0006\u0010T\u001a\u00020UJ\u0016\u0010V\u001a\u00020U2\u0006\u0010I\u001a\u00020J2\u0006\u0010W\u001a\u00020\u0003R\u001d\u0010\f\u001a\u0004\u0018\u00010\u00038FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00038FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00158FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u000eR\u001b\u0010!\u001a\u00020\u00038FX\u0002¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b\"\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%RC\u0010&\u001a*\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(0'j\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(`)8FX\u0002¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b*\u0010+R\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b-\u0010/R\u0011\u00100\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b0\u0010/R\u001d\u00101\u001a\u0004\u0018\u0001028BX\u0002¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b3\u00104R\u0011\u00106\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b7\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u000eR\u0011\u00109\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b:\u0010\u0017R\u0014\u0010;\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u000eR\u0011\u0010=\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b>\u0010\u000eR\u0011\u0010?\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b@\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u000eR\u0013\u0010B\u001a\u0004\u0018\u00010C8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001b\u0010F\u001a\u00020\u00158FX\u0002¢\u0006\f\n\u0004\bH\u0010\u0010\u001a\u0004\bG\u0010\u0017R\u0011\u0010I\u001a\u00020J8F¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u000eR\u0011\u0010N\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\bO\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u000eR\u0011\u0010Q\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bR\u0010\u000e¨\u0006X"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "", "url", "", "webId", "content", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "headerSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "referHost", "mainAppId", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;Ljava/lang/String;Ljava/lang/String;)V", "appId", "getAppId", "()Ljava/lang/String;", "appId$delegate", "Lkotlin/Lazy;", "bizId", "getBizId", "bizId$delegate", "bizScene", "", "getBizScene", "()I", "bizScene$delegate", "cacheTime", "", "getCacheTime", "()J", "getContent", "()Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "eTag", "getETag", "fullUrl", "getFullUrl", "fullUrl$delegate", "getHeaderSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHeaders", "()Ljava/util/HashMap;", "headers$delegate", "isCached", "", "()Z", "isRedirect", "lazyWebPrefetchInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "getLazyWebPrefetchInfo", "()Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "lazyWebPrefetchInfo$delegate", FirebaseAnalytics.b.LOCATION, com.tencent.mm.plugin.appbrand.jsapi.i.m.NAME, "getMainAppId", "maxCache", "getMaxCache", "mimeType", "getMimeType", "prefetchHost", "getPrefetchHost", "prefetchUrl", "getPrefetchUrl", "getReferHost", "response", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getResponse", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "subBizScene", "getSubBizScene", "subBizScene$delegate", "type", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getType", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchType;", "getUrl", "version", "getVersion", "getWebId", "wxETag", "getWxETag", "createResponse", "refresh", "", "saveHeaders", "host", "plugin-brandservice_release"})
    public static final class d {
        private final kotlin.f pDM;
        private final kotlin.f pDN;
        private final kotlin.f pDO;
        private final kotlin.f pDP;
        private final kotlin.f pDQ;
        private final kotlin.f pDR;
        private final kotlin.f pDS;
        final String pDT;
        final com.tencent.mm.plugin.ad.b pDU;
        final MMKVSlotManager pDV;
        private final String pDW;
        final String pDX;
        final String url;

        private String coy() {
            AppMethodBeat.i(195671);
            String str = (String) this.pDP.getValue();
            AppMethodBeat.o(195671);
            return str;
        }

        private String getAppId() {
            AppMethodBeat.i(195670);
            String str = (String) this.pDO.getValue();
            AppMethodBeat.o(195670);
            return str;
        }

        public final int coA() {
            AppMethodBeat.i(195673);
            int intValue = ((Number) this.pDR.getValue()).intValue();
            AppMethodBeat.o(195673);
            return intValue;
        }

        public final HashMap<String, List<String>> coB() {
            AppMethodBeat.i(195674);
            HashMap<String, List<String>> hashMap = (HashMap) this.pDS.getValue();
            AppMethodBeat.o(195674);
            return hashMap;
        }

        public final String cox() {
            AppMethodBeat.i(195669);
            String str = (String) this.pDN.getValue();
            AppMethodBeat.o(195669);
            return str;
        }

        public final int coz() {
            AppMethodBeat.i(195672);
            int intValue = ((Number) this.pDQ.getValue()).intValue();
            AppMethodBeat.o(195672);
            return intValue;
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005`\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"removeInvalidHeaders", "", "headers", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.v$d$d  reason: collision with other inner class name */
        public static final class C0892d extends kotlin.g.b.q implements kotlin.g.a.b<HashMap<String, List<? extends String>>, x> {
            public static final C0892d pDZ = new C0892d();

            static {
                AppMethodBeat.i(195662);
                AppMethodBeat.o(195662);
            }

            C0892d() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(HashMap<String, List<? extends String>> hashMap) {
                AppMethodBeat.i(195660);
                i(hashMap);
                x xVar = x.SXb;
                AppMethodBeat.o(195660);
                return xVar;
            }

            public static void i(HashMap<String, List<String>> hashMap) {
                AppMethodBeat.i(195661);
                kotlin.g.b.p.h(hashMap, "headers");
                Set<String> keySet = hashMap.keySet();
                kotlin.g.b.p.g(keySet, "headers.keys");
                ArrayList arrayList = new ArrayList();
                for (T t : keySet) {
                    T t2 = t;
                    Set coN = x.coN();
                    kotlin.g.b.p.g(t2, LocaleUtil.ITALIAN);
                    if (t2 == null) {
                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(195661);
                        throw tVar;
                    }
                    String lowerCase = t2.toLowerCase();
                    kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (coN.contains(lowerCase)) {
                        arrayList.add(t);
                    }
                }
                ArrayList<String> arrayList2 = arrayList;
                Log.i("MicroMsg.WebPrefetcher", "removeInvalidHeaders size: " + arrayList2.size());
                for (String str : arrayList2) {
                    hashMap.remove(str);
                }
                AppMethodBeat.o(195661);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0003`\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"})
        static final class f extends kotlin.g.b.q implements kotlin.g.a.a<HashMap<String, List<? extends String>>> {
            final /* synthetic */ d pDY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(d dVar) {
                super(0);
                this.pDY = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ HashMap<String, List<? extends String>> invoke() {
                AppMethodBeat.i(195664);
                HashMap<String, List<String>> coK = coK();
                AppMethodBeat.o(195664);
                return coK;
            }

            private HashMap<String, List<String>> coK() {
                Object obj;
                byte[] decodeBytes;
                AppMethodBeat.i(195665);
                MMKVSlotManager mMKVSlotManager = this.pDY.pDV;
                String cox = this.pDY.cox();
                MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) mMKVSlotManager.findSlot(cox);
                if (multiProcessMMKV != null) {
                    if (multiProcessMMKV.containsKey(cox) && (decodeBytes = multiProcessMMKV.decodeBytes(cox)) != null) {
                        if (!(decodeBytes.length == 0)) {
                            try {
                                Object newInstance = faj.class.newInstance();
                                ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                                obj = (com.tencent.mm.bw.a) newInstance;
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                            }
                        }
                    }
                    obj = null;
                } else {
                    obj = null;
                }
                faj faj = (faj) obj;
                HashMap<String, List<String>> hashMap = new HashMap<>();
                if (faj != null) {
                    LinkedList<fai> linkedList = faj.NwC;
                    kotlin.g.b.p.g(linkedList, "it.header");
                    for (T t : linkedList) {
                        hashMap.put(t.key, t.LOe);
                    }
                }
                AppMethodBeat.o(195665);
                return hashMap;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/WebPrefetchInfo;", "invoke"})
        static final class g extends kotlin.g.b.q implements kotlin.g.a.a<fak> {
            final /* synthetic */ d pDY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(d dVar) {
                super(0);
                this.pDY = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ fak invoke() {
                AppMethodBeat.i(195666);
                fak coL = coL();
                AppMethodBeat.o(195666);
                return coL;
            }

            private fak coL() {
                Object obj;
                byte[] decodeBytes;
                AppMethodBeat.i(195667);
                v vVar = v.pDG;
                MMKVSlotManager cop = v.cop();
                String str = this.pDY.pDT;
                MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) cop.findSlot(str);
                if (multiProcessMMKV != null) {
                    if (multiProcessMMKV.containsKey(str) && (decodeBytes = multiProcessMMKV.decodeBytes(str)) != null) {
                        if (!(decodeBytes.length == 0)) {
                            try {
                                Object newInstance = fak.class.newInstance();
                                ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                                obj = (com.tencent.mm.bw.a) newInstance;
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                            }
                        }
                    }
                    obj = null;
                } else {
                    obj = null;
                }
                fak fak = (fak) obj;
                AppMethodBeat.o(195667);
                return fak;
            }
        }

        public /* synthetic */ d(String str, String str2, com.tencent.mm.plugin.ad.b bVar, MMKVSlotManager mMKVSlotManager) {
            this(str, str2, bVar, mMKVSlotManager, null, null);
        }

        public d(String str, String str2, com.tencent.mm.plugin.ad.b bVar, MMKVSlotManager mMKVSlotManager, String str3, String str4) {
            kotlin.g.b.p.h(str, "url");
            kotlin.g.b.p.h(str2, "webId");
            kotlin.g.b.p.h(bVar, "content");
            kotlin.g.b.p.h(mMKVSlotManager, "headerSlot");
            AppMethodBeat.i(195689);
            this.url = str;
            this.pDT = str2;
            this.pDU = bVar;
            this.pDV = mMKVSlotManager;
            this.pDW = str3;
            this.pDX = str4;
            this.pDM = kotlin.g.ah(new g(this));
            this.pDN = kotlin.g.ah(new b(this));
            this.pDO = kotlin.g.ah(new a(this));
            this.pDP = kotlin.g.ah(new e(this));
            this.pDQ = kotlin.g.ah(new c(this));
            this.pDR = kotlin.g.ah(new h(this));
            this.pDS = kotlin.g.ah(new f(this));
            AppMethodBeat.o(195689);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
            if (r0 == null) goto L_0x003b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.e coC() {
            /*
                r3 = this;
                r2 = 195675(0x2fc5b, float:2.74199E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                java.util.HashMap r0 = r3.coB()
                java.lang.String r1 = "x-wx-client-prefetch-type"
                java.lang.Object r0 = r0.get(r1)
                java.util.List r0 = (java.util.List) r0
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = kotlin.a.j.ks(r0)
                java.lang.String r0 = (java.lang.String) r0
                if (r0 == 0) goto L_0x003b
                if (r0 != 0) goto L_0x002b
                kotlin.t r0 = new kotlin.t
                java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
                r0.<init>(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                throw r0
            L_0x002b:
                java.lang.String r0 = r0.toUpperCase()
                java.lang.String r1 = "(this as java.lang.String).toUpperCase()"
                kotlin.g.b.p.g(r0, r1)
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.v$e r0 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.e.valueOf(r0)
                if (r0 != 0) goto L_0x003d
            L_0x003b:
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.v$e r0 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.e.HTML
            L_0x003d:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.d.coC():com.tencent.mm.plugin.brandservice.ui.timeline.preload.v$e");
        }

        public final String getLocation() {
            String str;
            AppMethodBeat.i(195676);
            List<String> list = coB().get(FirebaseAnalytics.b.LOCATION);
            if (list == null || (str = (String) kotlin.a.j.ks(list)) == null) {
                str = "";
            }
            AppMethodBeat.o(195676);
            return str;
        }

        private long getVersion() {
            String str;
            AppMethodBeat.i(195677);
            List<String> list = coB().get("x-wx-version");
            if (list == null || (str = (String) kotlin.a.j.ks(list)) == null) {
                AppMethodBeat.o(195677);
                return -1;
            }
            long parseLong = Long.parseLong(str);
            AppMethodBeat.o(195677);
            return parseLong;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
            if (r0 == null) goto L_0x0040;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.lang.String getMimeType() {
            /*
                r3 = this;
                r2 = 195678(0x2fc5e, float:2.74203E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                java.util.HashMap r0 = r3.coB()
                java.lang.String r1 = "content-type"
                java.lang.Object r0 = r0.get(r1)
                java.util.List r0 = (java.util.List) r0
                if (r0 == 0) goto L_0x0040
                java.lang.Object r0 = kotlin.a.j.ks(r0)
                java.lang.String r0 = (java.lang.String) r0
                if (r0 == 0) goto L_0x0040
                java.lang.String r1 = ";"
                java.lang.String r0 = kotlin.n.n.oz(r0, r1)
                if (r0 == 0) goto L_0x0040
                if (r0 != 0) goto L_0x0034
                kotlin.t r0 = new kotlin.t
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
                r0.<init>(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                throw r0
            L_0x0034:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.CharSequence r0 = kotlin.n.n.trim(r0)
                java.lang.String r0 = r0.toString()
                if (r0 != 0) goto L_0x0043
            L_0x0040:
                java.lang.String r0 = "text/html"
            L_0x0043:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.d.getMimeType():java.lang.String");
        }

        public final int coD() {
            Integer valueOf;
            String str;
            String str2;
            AppMethodBeat.i(195679);
            List<String> list = coB().get("x-wx-max-cache");
            if (list == null || (str2 = (String) kotlin.a.j.ks(list)) == null) {
                List<String> list2 = coB().get("max-age");
                valueOf = (list2 == null || (str = (String) kotlin.a.j.ks(list2)) == null) ? null : Integer.valueOf(Integer.parseInt(str));
            } else {
                valueOf = Integer.valueOf(Integer.parseInt(str2));
            }
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                AppMethodBeat.o(195679);
                return intValue;
            }
            AppMethodBeat.o(195679);
            return 600;
        }

        public final long coE() {
            String str;
            AppMethodBeat.i(195680);
            List<String> list = coB().get("x-wx-client-cache-time");
            if (list == null || (str = (String) kotlin.a.j.ks(list)) == null) {
                AppMethodBeat.o(195680);
                return -1;
            }
            long parseLong = Long.parseLong(str);
            AppMethodBeat.o(195680);
            return parseLong;
        }

        public final String coF() {
            String str;
            AppMethodBeat.i(195681);
            List<String> list = coB().get("x-wx-etag");
            if (list == null || (str = (String) kotlin.a.j.ks(list)) == null) {
                str = "";
            }
            AppMethodBeat.o(195681);
            return str;
        }

        public final String coG() {
            String str;
            AppMethodBeat.i(195682);
            List<String> list = coB().get("etag");
            if (list == null || (str = (String) kotlin.a.j.ks(list)) == null) {
                str = "";
            }
            AppMethodBeat.o(195682);
            return str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(195683);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
            if (r0.equals("302") != false) goto L_0x0035;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
            if (r0.equals("301") != false) goto L_0x0035;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean isRedirect() {
            /*
                r3 = this;
                r2 = 195683(0x2fc63, float:2.7421E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                java.util.HashMap r0 = r3.coB()
                java.lang.String r1 = "status"
                java.lang.Object r0 = r0.get(r1)
                java.util.List r0 = (java.util.List) r0
                if (r0 == 0) goto L_0x0022
                java.lang.Object r0 = kotlin.a.j.ks(r0)
                java.lang.String r0 = (java.lang.String) r0
            L_0x001b:
                if (r0 != 0) goto L_0x0024
            L_0x001d:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0021:
                return r0
            L_0x0022:
                r0 = 0
                goto L_0x001b
            L_0x0024:
                int r1 = r0.hashCode()
                switch(r1) {
                    case 50548: goto L_0x002c;
                    case 50549: goto L_0x003a;
                    default: goto L_0x002b;
                }
            L_0x002b:
                goto L_0x001d
            L_0x002c:
                java.lang.String r1 = "301"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x001d
            L_0x0035:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0021
            L_0x003a:
                java.lang.String r1 = "302"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x001d
                goto L_0x0035
                switch-data {50548->0x002c, 50549->0x003a, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.d.isRedirect():boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004b, code lost:
            if (r0.equals("301") != false) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0057, code lost:
            if (kotlin.n.n.aL(getLocation()) != false) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(195684);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0065, code lost:
            if (r0.equals("302") != false) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(195684);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean coH() {
            /*
            // Method dump skipped, instructions count: 124
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.d.coH():boolean");
        }

        private void refresh() {
            String str;
            AppMethodBeat.i(195685);
            if (coC() == e.HTML && coE() > 0 && coD() > 0 && MMSlotKt.isExpire(coE(), Math.max(coD() - 60, 60))) {
                v vVar = v.pDG;
                com.tencent.mm.plugin.webview.i.b.agr(v.ahE(this.url));
                v vVar2 = v.pDG;
                String str2 = this.url;
                List<String> list = coB().get("x-wx-client-prefetch-url");
                if (list == null || (str = (String) kotlin.a.j.ks(list)) == null) {
                    str = "";
                }
                v.fi(str2, str);
            }
            AppMethodBeat.o(195685);
        }

        public final e.b coI() {
            AppMethodBeat.i(195686);
            while (true) {
                Log.i("MicroMsg.WebPrefetcher", "get response #" + this.pDT + ", " + this.getAppId() + ", " + this.pDW + ", " + this.url);
                c.a aVar = com.tencent.mm.plugin.ad.c.ICA;
                WebResourceResponse lD = c.a.lD(this.getAppId(), this.url);
                if (lD != null) {
                    e.b bVar = new e.b();
                    bVar.url = this.coy();
                    bVar.pmP = this.coC().toString();
                    bVar.pmO = this.getVersion();
                    bVar.hDa = this.coz();
                    bVar.pmN = this.coA();
                    bVar.pmQ = lD;
                    bVar.appId = this.getAppId();
                    AppMethodBeat.o(195686);
                    return bVar;
                } else if (this.coH()) {
                    Log.i("MicroMsg.WebPrefetcher", "fetch cached: #" + this.pDT + ", " + this.url);
                    switch (w.$EnumSwitchMapping$0[this.coC().ordinal()]) {
                        case 1:
                            if (this.isRedirect()) {
                                Log.i("MicroMsg.WebPrefetcher", "HTML redirect, location:" + this.getLocation());
                                String location = this.getLocation();
                                String ahY = c.ahY(this.getLocation());
                                c.a aVar2 = com.tencent.mm.plugin.ad.c.ICA;
                                com.tencent.mm.plugin.ad.b bVar2 = com.tencent.mm.plugin.ad.c.ICw;
                                v vVar = v.pDG;
                                this = new d(location, ahY, bVar2, v.cor());
                            } else {
                                v vVar2 = v.pDG;
                                if (!v.ahB(this.url)) {
                                    Log.w("MicroMsg.WebPrefetcher", "preauth expired preauth: #" + this.pDT + ", " + this.url);
                                    v.aip(this.url);
                                    AppMethodBeat.o(195686);
                                    return null;
                                } else if (!MMSlotKt.isExpire(this.coE(), this.coD())) {
                                    List<String> list = this.coB().get("set-cookie");
                                    if (list != null) {
                                        Iterator<T> it = list.iterator();
                                        while (it.hasNext()) {
                                            com.tencent.xweb.c.hsp().setCookie(this.url, it.next());
                                        }
                                    }
                                    e.b coJ = this.coJ();
                                    AppMethodBeat.o(195686);
                                    return coJ;
                                } else {
                                    Log.w("MicroMsg.WebPrefetcher", "doc expired refresh cached: #" + this.pDT + ", " + this.url);
                                    this.refresh();
                                    AppMethodBeat.o(195686);
                                    return null;
                                }
                            }
                        default:
                            e.b coJ2 = this.coJ();
                            AppMethodBeat.o(195686);
                            return coJ2;
                    }
                } else {
                    AppMethodBeat.o(195686);
                    return null;
                }
            }
        }

        private final e.b coJ() {
            AppMethodBeat.i(195687);
            int size = coB().size();
            boolean contains = this.pDU.contains(cox());
            if (size == 0 || !contains) {
                Log.e("MicroMsg.WebPrefetcher", "createResponse fail headerSize:" + size + ", containsFile:" + contains);
                AppMethodBeat.o(195687);
                return null;
            }
            e.b bVar = new e.b();
            bVar.url = coy();
            bVar.pmP = coC().toString();
            bVar.pmO = getVersion();
            bVar.hDa = coz();
            bVar.pmN = coA();
            C0892d dVar = C0892d.pDZ;
            C0892d.i(coB());
            String mimeType = getMimeType();
            HashMap<String, List<String>> coB = coB();
            LinkedHashMap linkedHashMap = new LinkedHashMap(ae.atJ(coB.size()));
            for (T t : coB.entrySet()) {
                Object key = t.getKey();
                T t2 = t;
                t2.getKey();
                linkedHashMap.put(key, (String) kotlin.a.j.ks((List) t2.getValue()));
            }
            bVar.pmQ = new WebResourceResponse(mimeType, MimeTypeUtil.ContentType.DEFAULT_CHARSET, 200, "OK", linkedHashMap, com.tencent.mm.vfs.s.ao(this.pDU.aWR(cox())));
            AppMethodBeat.o(195687);
            return bVar;
        }

        public final void a(e eVar, String str) {
            AppMethodBeat.i(195688);
            kotlin.g.b.p.h(eVar, "type");
            kotlin.g.b.p.h(str, "host");
            coB().put("x-wx-client-cache-time", kotlin.a.j.listOf(String.valueOf(MMSlotKt.now())));
            coB().put("x-wx-client-prefetch-url", kotlin.a.j.listOf(this.url));
            if (!kotlin.n.n.aL(str)) {
                coB().put("x-wx-client-prefetch-host", kotlin.a.j.listOf(str));
            }
            coB().put("x-wx-client-prefetch-type", kotlin.a.j.listOf(eVar.toString()));
            faj faj = new faj();
            LinkedList<fai> linkedList = faj.NwC;
            HashMap<String, List<String>> coB = coB();
            ArrayList arrayList = new ArrayList(coB.size());
            for (Map.Entry<String, List<String>> entry : coB.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                fai fai = new fai();
                if (key == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(195688);
                    throw tVar;
                }
                String lowerCase = key.toLowerCase();
                kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
                switch (lowerCase.hashCode()) {
                    case 785670158:
                        if (lowerCase.equals("content-type")) {
                            key = "content-type";
                            break;
                        } else {
                            break;
                        }
                    case 1237214767:
                        if (lowerCase.equals("set-cookie")) {
                            key = "set-cookie";
                            break;
                        } else {
                            break;
                        }
                    case 1901043637:
                        if (lowerCase.equals(FirebaseAnalytics.b.LOCATION)) {
                            key = FirebaseAnalytics.b.LOCATION;
                            break;
                        } else {
                            break;
                        }
                }
                fai.key = key;
                fai.LOe.addAll(value);
                arrayList.add(fai);
            }
            linkedList.addAll(arrayList);
            ((MultiProcessMMKV) this.pDV.getSlot()).encode(cox(), faj.toByteArray());
            Log.v("MicroMsg.WebPrefetcher", "saveHeaders " + eVar + " : webId:" + this.pDT + ", bizId:" + cox() + ", header size:" + coB().size());
            AppMethodBeat.o(195688);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<String> {
            final /* synthetic */ d pDY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(d dVar) {
                super(0);
                this.pDY = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ String invoke() {
                String str;
                AppMethodBeat.i(195658);
                fak a2 = d.a(this.pDY);
                if (a2 == null || (str = a2.dPJ) == null) {
                    str = this.pDY.pDT;
                }
                AppMethodBeat.o(195658);
                return str;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<String> {
            final /* synthetic */ d pDY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(0);
                this.pDY = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ String invoke() {
                String str;
                AppMethodBeat.i(195657);
                fak a2 = d.a(this.pDY);
                if (a2 == null || (str = a2.appId) == null) {
                    str = this.pDY.pDX;
                }
                AppMethodBeat.o(195657);
                return str;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class e extends kotlin.g.b.q implements kotlin.g.a.a<String> {
            final /* synthetic */ d pDY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(d dVar) {
                super(0);
                this.pDY = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ String invoke() {
                String str;
                AppMethodBeat.i(195663);
                fak a2 = d.a(this.pDY);
                if (a2 == null || (str = a2.pFJ) == null) {
                    str = this.pDY.url;
                }
                AppMethodBeat.o(195663);
                return str;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class c extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
            final /* synthetic */ d pDY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(d dVar) {
                super(0);
                this.pDY = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Integer invoke() {
                int i2;
                AppMethodBeat.i(195659);
                fak a2 = d.a(this.pDY);
                if (a2 != null) {
                    i2 = a2.hDa;
                } else {
                    i2 = 0;
                }
                Integer valueOf = Integer.valueOf(i2);
                AppMethodBeat.o(195659);
                return valueOf;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class h extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
            final /* synthetic */ d pDY;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(d dVar) {
                super(0);
                this.pDY = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Integer invoke() {
                int i2;
                AppMethodBeat.i(195668);
                fak a2 = d.a(this.pDY);
                if (a2 != null) {
                    i2 = a2.pmN;
                } else {
                    i2 = 0;
                }
                Integer valueOf = Integer.valueOf(i2);
                AppMethodBeat.o(195668);
                return valueOf;
            }
        }

        public static final /* synthetic */ fak a(d dVar) {
            AppMethodBeat.i(195690);
            fak fak = (fak) dVar.pDM.getValue();
            AppMethodBeat.o(195690);
            return fak;
        }
    }

    static /* synthetic */ Object a(com.tencent.mm.plugin.ad.a aVar, kotlin.d.d<? super Boolean> dVar) {
        AppMethodBeat.i(195722);
        kotlin.d.h hVar = new kotlin.d.h(kotlin.d.a.b.e(dVar));
        kotlin.d.h hVar2 = hVar;
        String str = aVar.ICt.LQV;
        kotlin.g.b.p.g(str, "manifest.manifest.ManifestUrl");
        String aWU = com.tencent.mm.plugin.ad.e.aWU(str);
        c.a aVar2 = com.tencent.mm.plugin.ad.c.ICA;
        if (!com.tencent.mm.plugin.ad.c.ICy.contains(aWU)) {
            com.tencent.mm.plugin.report.service.h hVar3 = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[7];
            objArr[0] = aVar.ICs;
            objArr[1] = Integer.valueOf(aVar.hDa);
            objArr[2] = 1;
            objArr[3] = "";
            String str2 = aVar.ICt.LQV;
            if (str2 == null) {
                str2 = "";
            }
            objArr[4] = str2;
            objArr[5] = 3;
            objArr[6] = Integer.valueOf(aVar.hDa);
            hVar3.a(21074, objArr);
            ai.a(new z(aVar.ICt.LQV, 0), new i(aWU, hVar2, aVar));
        } else {
            com.tencent.mm.plugin.report.service.h hVar4 = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr2 = new Object[7];
            objArr2[0] = aVar.ICs;
            objArr2[1] = Integer.valueOf(aVar.hDa);
            objArr2[2] = 1;
            objArr2[3] = "";
            String str3 = aVar.ICt.LQV;
            if (str3 == null) {
                str3 = "";
            }
            objArr2[4] = str3;
            objArr2[5] = 1;
            objArr2[6] = Integer.valueOf(aVar.hDa);
            hVar4.a(21074, objArr2);
            Boolean bool = Boolean.TRUE;
            Result.Companion companion = Result.Companion;
            hVar2.resumeWith(Result.m46constructorimpl(bool));
        }
        Object hxK = hVar.hxK();
        if (hxK == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            kotlin.g.b.p.h(dVar, "frame");
        }
        AppMethodBeat.o(195722);
        return hxK;
    }

    static /* synthetic */ void fi(String str, String str2) {
        AppMethodBeat.i(195724);
        a(str, str2, (Map<String, String>) null, 0, 0);
        AppMethodBeat.o(195724);
    }

    private static void a(String str, String str2, Map<String, String> map, int i2, int i3) {
        AppMethodBeat.i(195723);
        b bVar = new b(c.getHost(str), str, str2, false, map, (byte) 0);
        String str3 = b.class.getCanonicalName() + '_' + MStorageEventData.EventType.BATCH;
        synchronized (__BATCH_RUN_OBJ.INSTANCE) {
            try {
                bu buVar = __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(str3);
                if (buVar != null) {
                    buVar.a((CancellationException) null);
                }
                HashMap<String, Queue<?>> batchData = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
                if (!batchData.containsKey(str3)) {
                    batchData.put(str3, new LinkedList());
                }
                Queue<?> queue = batchData.get(str3);
                if (queue == null) {
                    t tVar = new t("null cannot be cast to non-null type java.util.LinkedList<T>");
                    AppMethodBeat.o(195723);
                    throw tVar;
                }
                ((LinkedList) queue).add(bVar);
            } catch (Throwable th) {
                AppMethodBeat.o(195723);
                throw th;
            }
        }
        __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().put(str3, kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new m(50, str3, null, i2, str2, i3), 2));
        AppMethodBeat.o(195723);
    }

    private static boolean aio(String str) {
        boolean z;
        AppMethodBeat.i(195725);
        while (true) {
            kotlin.g.b.p.h(str, "url");
            String ahY = c.ahY(str);
            c.a aVar = com.tencent.mm.plugin.ad.c.ICA;
            d dVar = new d(str, ahY, com.tencent.mm.plugin.ad.c.ICw, pDz);
            boolean coH = dVar.coH();
            boolean isRedirect = dVar.isRedirect();
            if (!coH || isRedirect) {
                if (isRedirect) {
                    if (dVar.getLocation().length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        break;
                    }
                    str = dVar.getLocation();
                } else {
                    break;
                }
            } else {
                AppMethodBeat.o(195725);
                return true;
            }
        }
        AppMethodBeat.o(195725);
        return false;
    }

    public static e.b ahF(String str) {
        AppMethodBeat.i(195726);
        kotlin.g.b.p.h(str, "url");
        String ahY = c.ahY(str);
        c.a aVar = com.tencent.mm.plugin.ad.c.ICA;
        e.b coI = new d(str, ahY, com.tencent.mm.plugin.ad.c.ICw, pDz).coI();
        AppMethodBeat.o(195726);
        return coI;
    }

    public static e.b R(String str, String str2, String str3) {
        AppMethodBeat.i(195727);
        kotlin.g.b.p.h(str, "referer");
        kotlin.g.b.p.h(str2, "url");
        String ff = c.ff(c.getHost(str), str2);
        c.a aVar = com.tencent.mm.plugin.ad.c.ICA;
        e.b coI = new d(str2, ff, com.tencent.mm.plugin.ad.c.ICx, pDA, c.getHost(str), str3).coI();
        AppMethodBeat.o(195727);
        return coI;
    }

    public static void ahG(String str) {
        AppMethodBeat.i(6803);
        kotlin.g.b.p.h(str, "url");
        String ahY = c.ahY(str);
        c.a aVar = com.tencent.mm.plugin.ad.c.ICA;
        com.tencent.mm.vfs.o aWR = com.tencent.mm.plugin.ad.c.ICw.aWR(ahY);
        if (aWR.exists()) {
            aWR.delete();
        }
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) pDz.findSlot(ahY);
        if (multiProcessMMKV != null) {
            multiProcessMMKV.remove(ahY);
        }
        MultiProcessMMKV multiProcessMMKV2 = (MultiProcessMMKV) pDx.findSlot(c.ahY(str));
        if (multiProcessMMKV2 != null) {
            multiProcessMMKV2.removeValueForKey(c.ahY(str));
            AppMethodBeat.o(6803);
            return;
        }
        AppMethodBeat.o(6803);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$BatchPreauth;", "", "url", "", "appId", "title", "desc", "scene", "", "subBizScene", "refer", IssueStorage.COLUMN_EXT_INFO, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDesc", "getExtInfo", "getRefer", "getScene", "()I", "getSubBizScene", "getTitle", "getUrl", "plugin-brandservice_release"})
    public static final class a {
        final String appId;
        final String desc;
        final String extInfo;
        final String pDH;
        final int pmN;
        final int scene;
        final String title;
        final String url;

        private a(String str, String str2, String str3, String str4, int i2, int i3, String str5, String str6) {
            kotlin.g.b.p.h(str, "url");
            kotlin.g.b.p.h(str2, "appId");
            kotlin.g.b.p.h(str3, "title");
            kotlin.g.b.p.h(str4, "desc");
            AppMethodBeat.i(195646);
            this.url = str;
            this.appId = str2;
            this.title = str3;
            this.desc = str4;
            this.scene = i2;
            this.pmN = i3;
            this.pDH = str5;
            this.extInfo = str6;
            AppMethodBeat.o(195646);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(String str, String str2, String str3, String str4, int i2, int i3, String str5, String str6, int i4) {
            this(str, str2, str3, str4, (i4 & 16) != 0 ? -1 : i2, (i4 & 32) != 0 ? -1 : i3, (i4 & 64) != 0 ? null : str5, (i4 & 128) != 0 ? null : str6);
            AppMethodBeat.i(195647);
            AppMethodBeat.o(195647);
        }
    }

    public static /* synthetic */ void aip(String str) {
        AppMethodBeat.i(195729);
        a(str, "", "", "", "", -1);
        AppMethodBeat.o(195729);
    }

    public static final void a(String str, String str2, String str3, String str4, String str5, int i2) {
        AppMethodBeat.i(195728);
        kotlin.g.b.p.h(str, "url");
        kotlin.g.b.p.h(str2, "appId");
        kotlin.g.b.p.h(str3, "title");
        kotlin.g.b.p.h(str4, "desc");
        kotlin.g.b.p.h(str5, "from");
        Log.v("MicroMsg.WebPrefetcher", "preAuth: " + str3 + ' ' + str);
        a aVar = new a(str, str2, str3, str4, i2, 0, null, null, TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
        v vVar = pDG;
        String str6 = a.class.getCanonicalName() + '_' + "addToPreload";
        synchronized (__BATCH_RUN_OBJ.INSTANCE) {
            try {
                bu buVar = __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(str6);
                if (buVar != null) {
                    buVar.a((CancellationException) null);
                }
                HashMap<String, Queue<?>> batchData = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
                if (!batchData.containsKey(str6)) {
                    batchData.put(str6, new LinkedList());
                }
                Queue<?> queue = batchData.get(str6);
                if (queue == null) {
                    t tVar = new t("null cannot be cast to non-null type java.util.LinkedList<T>");
                    AppMethodBeat.o(195728);
                    throw tVar;
                }
                ((LinkedList) queue).add(aVar);
            } catch (Throwable th) {
                AppMethodBeat.o(195728);
                throw th;
            }
        }
        __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().put(str6, kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new k(1000, str6, null, vVar), 2));
        AppMethodBeat.o(195728);
    }

    public static final void cF(List<? extends e.a> list) {
        AppMethodBeat.i(160497);
        kotlin.g.b.p.h(list, "auths");
        if (list.isEmpty()) {
            AppMethodBeat.o(160497);
            return;
        }
        List<? extends e.a> list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(list2, 10));
        for (T t : list2) {
            String str = t.url;
            kotlin.g.b.p.g(str, "info.url");
            String str2 = t.appId;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = t.title;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = t.desc;
            if (str4 == null) {
                str4 = "";
            }
            arrayList.add(new a(str, str2, str3, str4, t.pmM, t.pmN, null, t.extInfo, 64));
        }
        cG(arrayList);
        AppMethodBeat.o(160497);
    }

    private static void cG(List<a> list) {
        AppMethodBeat.i(195730);
        Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths size = %s", Integer.valueOf(list.size()));
        bhf bhf = new bhf();
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            T t2 = t;
            if (cou() || (!pDD.contains(c.ahW(t2.url)) && !UrlExKt.isMpUrl(t2.url) && !ais(t2.url) && air(t2.url) && !pDB.contains(t2.url))) {
                arrayList.add(t);
            }
        }
        ArrayList<a> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(arrayList2, 10));
        int i2 = 0;
        for (a aVar : arrayList2) {
            h hVar = new h();
            hVar.LQZ = aVar.url;
            hVar.jfi = aVar.appId;
            hVar.LRa = aVar.title;
            hVar.LRb = aVar.desc;
            hVar.LQY = i2;
            hVar.LRc = aVar.pDH;
            hVar.Scene = aVar.scene;
            hVar.pmN = aVar.pmN;
            pDD.add(c.ahW(aVar.url));
            hVar.extInfo = aVar.extInfo;
            hVar.hDa = aVar.scene;
            arrayList3.add(hVar);
            i2++;
        }
        bhf.LRf.addAll(arrayList3);
        bhf.KOL = bhf.LRf.size();
        bhf.Scene = 0;
        bhf.KMd = 0;
        if (bhf.LRf.isEmpty()) {
            Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preAuths: nothing to preauth");
            AppMethodBeat.o(195730);
            return;
        }
        try {
            ConcurrentSkipListSet<String> concurrentSkipListSet = pDB;
            LinkedList<bhe> linkedList = bhf.LRf;
            kotlin.g.b.p.g(linkedList, "req.ReqInfo");
            LinkedList<bhe> linkedList2 = linkedList;
            ArrayList arrayList4 = new ArrayList(kotlin.a.j.a(linkedList2, 10));
            Iterator<T> it = linkedList2.iterator();
            while (it.hasNext()) {
                arrayList4.add(it.next().LQZ);
            }
            concurrentSkipListSet.addAll(arrayList4);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebPrefetcher", "Concurrent Add Exception: " + e2.getMessage());
        }
        g.a aVar2 = com.tencent.mm.plugin.webview.core.g.ILB;
        if (g.a.fZP()) {
            CronetLogic.setUserCertVerify(true);
        }
        StringBuilder sb = new StringBuilder("[TRACE_PREFETCH] sendGetA8KeyLiteRequest batch req: ");
        LinkedList<bhe> linkedList3 = bhf.LRf;
        kotlin.g.b.p.g(linkedList3, "req.ReqInfo");
        Log.v("MicroMsg.WebPrefetcher", sb.append(kotlin.a.j.a(linkedList3, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, q.pEX, 30)).toString());
        com.tencent.mm.ac.d.b("MicroMsg.WebPrefetcher", new r(bhf));
        AppMethodBeat.o(195730);
    }

    public static MMCacheSlotManager cot() {
        return pDD;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
    public static final class k extends kotlin.d.b.a.j implements kotlin.g.a.m<kotlinx.coroutines.ai, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ long $delay;
        final /* synthetic */ String $key;
        Object L$0;
        int label;
        private kotlinx.coroutines.ai p$;
        final /* synthetic */ v pEw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(long j2, String str, kotlin.d.d dVar, v vVar) {
            super(2, dVar);
            this.$delay = j2;
            this.$key = str;
            this.pEw = vVar;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(6785);
            kotlin.g.b.p.h(dVar, "completion");
            k kVar = new k(this.$delay, this.$key, dVar, this.pEw);
            kVar.p$ = (kotlinx.coroutines.ai) obj;
            AppMethodBeat.o(6785);
            return kVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(kotlinx.coroutines.ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(6786);
            Object invokeSuspend = ((k) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(6786);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.ai aiVar;
            ArrayList arrayList;
            AppMethodBeat.i(6784);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    aiVar = this.p$;
                    long j2 = this.$delay;
                    this.L$0 = aiVar;
                    this.label = 1;
                    if (au.a(j2, this) == aVar) {
                        AppMethodBeat.o(6784);
                        return aVar;
                    }
                    break;
                case 1:
                    aiVar = (kotlinx.coroutines.ai) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(6784);
                    throw illegalStateException;
            }
            if (!aj.a(aiVar)) {
                x xVar = x.SXb;
                AppMethodBeat.o(6784);
                return xVar;
            }
            synchronized (__BATCH_RUN_OBJ.INSTANCE) {
                try {
                    Queue<?> queue = __BATCH_RUN_OBJ.INSTANCE.getBatchData().get(this.$key);
                    if (!(queue instanceof Queue)) {
                        queue = null;
                    }
                    Queue<?> queue2 = queue;
                    if (queue2 != null) {
                        __BATCH_RUN_OBJ.INSTANCE.getBatchData().remove(this.$key);
                        arrayList = new ArrayList(queue2);
                    } else {
                        arrayList = null;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(6784);
                    throw th;
                }
            }
            if (arrayList != null) {
                v.cH(arrayList);
            }
            __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
            x xVar2 = x.SXb;
            AppMethodBeat.o(6784);
            return xVar2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
    public static final class m extends kotlin.d.b.a.j implements kotlin.g.a.m<kotlinx.coroutines.ai, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ long $delay;
        final /* synthetic */ String $key;
        Object L$0;
        int label;
        private kotlinx.coroutines.ai p$;
        final /* synthetic */ int pEA;
        final /* synthetic */ int pEy;
        final /* synthetic */ String pEz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(long j2, String str, kotlin.d.d dVar, int i2, String str2, int i3) {
            super(2, dVar);
            this.$delay = j2;
            this.$key = str;
            this.pEy = i2;
            this.pEz = str2;
            this.pEA = i3;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(6796);
            kotlin.g.b.p.h(dVar, "completion");
            m mVar = new m(this.$delay, this.$key, dVar, this.pEy, this.pEz, this.pEA);
            mVar.p$ = (kotlinx.coroutines.ai) obj;
            AppMethodBeat.o(6796);
            return mVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(kotlinx.coroutines.ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(6797);
            Object invokeSuspend = ((m) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(6797);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.ai aiVar;
            ArrayList<b> arrayList;
            AppMethodBeat.i(6795);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    aiVar = this.p$;
                    long j2 = this.$delay;
                    this.L$0 = aiVar;
                    this.label = 1;
                    if (au.a(j2, this) == aVar) {
                        AppMethodBeat.o(6795);
                        return aVar;
                    }
                    break;
                case 1:
                    aiVar = (kotlinx.coroutines.ai) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(6795);
                    throw illegalStateException;
            }
            if (!aj.a(aiVar)) {
                x xVar = x.SXb;
                AppMethodBeat.o(6795);
                return xVar;
            }
            synchronized (__BATCH_RUN_OBJ.INSTANCE) {
                try {
                    Queue<?> queue = __BATCH_RUN_OBJ.INSTANCE.getBatchData().get(this.$key);
                    if (!(queue instanceof Queue)) {
                        queue = null;
                    }
                    Queue<?> queue2 = queue;
                    if (queue2 != null) {
                        __BATCH_RUN_OBJ.INSTANCE.getBatchData().remove(this.$key);
                        arrayList = new ArrayList(queue2);
                    } else {
                        arrayList = null;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(6795);
                    throw th;
                }
            }
            if (arrayList != null) {
                for (b bVar : arrayList) {
                    String str = bVar.edo;
                    String ahY = c.ahY(bVar.edo);
                    c.a aVar2 = com.tencent.mm.plugin.ad.c.ICA;
                    com.tencent.mm.plugin.ad.b bVar2 = com.tencent.mm.plugin.ad.c.ICw;
                    v vVar = v.pDG;
                    d dVar = new d(str, ahY, bVar2, v.cor());
                    if (!dVar.coH()) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(21074, bVar.host, Integer.valueOf(this.pEy), 2, this.pEz, this.pEz, 3, Integer.valueOf(this.pEA));
                        v vVar2 = v.pDG;
                        v.a(bVar.pDI, bVar.host, dVar, bVar.pDK);
                    } else if (!bVar.pDJ) {
                        int max = Math.max(dVar.coD() - 60, 60);
                        if (dVar.coE() <= 0 || !MMSlotKt.isExpire(dVar.coE(), max)) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(21074, bVar.host, Integer.valueOf(this.pEy), 2, this.pEz, this.pEz, 1, Integer.valueOf(this.pEA));
                        } else {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(21074, bVar.host, Integer.valueOf(this.pEy), 2, this.pEz, this.pEz, 2, Integer.valueOf(this.pEA));
                            v vVar3 = v.pDG;
                            v.a(bVar.pDI, bVar.host, dVar, bVar.pDK);
                        }
                    }
                }
            }
            __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
            x xVar2 = x.SXb;
            AppMethodBeat.o(6795);
            return xVar2;
        }
    }

    public static fak aiq(String str) {
        Object obj;
        byte[] decodeBytes;
        AppMethodBeat.i(195732);
        String ahY = c.ahY(str);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) pDx.findSlot(ahY);
        if (multiProcessMMKV != null) {
            if (multiProcessMMKV.containsKey(ahY) && (decodeBytes = multiProcessMMKV.decodeBytes(ahY)) != null) {
                if (!(decodeBytes.length == 0)) {
                    try {
                        Object newInstance = fak.class.newInstance();
                        ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                        obj = (com.tencent.mm.bw.a) newInstance;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                    }
                }
            }
            obj = null;
        } else {
            obj = null;
        }
        fak fak = (fak) obj;
        if (fak != null) {
            boolean isExpire = MMSlotKt.isExpire(fak.jsm, 600);
            Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getValidPreloadWebInfo: webId#" + ahY + ", bizId: " + fak.dPJ + "  prefetch:" + fak.NwF + ", authorized:" + fak.NwE + ", antispam:" + fak.NwD + ", lastModify:" + fak.jsm + ", expire:" + isExpire + ", url:" + str);
            if (fak.NwD || isExpire) {
                AppMethodBeat.o(195732);
                return null;
            } else if (!fak.NwE) {
                AppMethodBeat.o(195732);
                return fak;
            } else if (fak.NwF && fak.NwE && aio(str)) {
                AppMethodBeat.o(195732);
                return fak;
            }
        }
        Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] getVaildPreloadWebInfo: webId#" + ahY + ", not cached, url:" + str + ' ');
        AppMethodBeat.o(195732);
        return null;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.webview.k.e> {
        public static final s pFa = new s();

        static {
            AppMethodBeat.i(195720);
            AppMethodBeat.o(195720);
        }

        s() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.webview.k.e invoke() {
            AppMethodBeat.i(195719);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            com.tencent.mm.plugin.webview.k.e eVar = new com.tencent.mm.plugin.webview.k.e(context);
            AppMethodBeat.o(195719);
            return eVar;
        }
    }

    public static boolean ahB(String str) {
        AppMethodBeat.i(195733);
        kotlin.g.b.p.h(str, "url");
        if (aiq(str) != null) {
            AppMethodBeat.o(195733);
            return true;
        }
        AppMethodBeat.o(195733);
        return false;
    }

    private static boolean air(String str) {
        Object obj;
        boolean z;
        boolean z2;
        boolean z3;
        byte[] decodeBytes;
        AppMethodBeat.i(6806);
        String ahY = c.ahY(str);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) pDx.findSlot(ahY);
        if (multiProcessMMKV != null) {
            if (multiProcessMMKV.containsKey(ahY) && (decodeBytes = multiProcessMMKV.decodeBytes(ahY)) != null) {
                if (!(decodeBytes.length == 0)) {
                    try {
                        Object newInstance = fak.class.newInstance();
                        ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                        obj = (com.tencent.mm.bw.a) newInstance;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                    }
                }
            }
            obj = null;
        } else {
            obj = null;
        }
        fak fak = (fak) obj;
        if (fak != null) {
            boolean isExpire = MMSlotKt.isExpire(fak.jsm, (int) TAVPlayer.VIDEO_PLAYER_WIDTH);
            z = isExpire;
            z2 = isExpire;
            z3 = true;
        } else {
            z = true;
            z2 = false;
            z3 = false;
        }
        Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] needReauth:" + z + ", webId:" + ahY + ", cached:" + z3 + ", expired:" + z2 + ", url:" + str);
        AppMethodBeat.o(6806);
        return z;
    }

    private static boolean ais(String str) {
        String host;
        Object obj;
        byte[] decodeBytes;
        AppMethodBeat.i(195734);
        Uri parse = Uri.parse(UrlExKt.getWithProtocol(str));
        if (parse == null || (host = parse.getHost()) == null) {
            AppMethodBeat.o(195734);
            return false;
        }
        kotlin.g.b.p.g(host, LocaleUtil.ITALIAN);
        String aia = c.aia(host);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) pDy.findSlot(aia);
        if (multiProcessMMKV != null) {
            if (multiProcessMMKV.containsKey(aia) && (decodeBytes = multiProcessMMKV.decodeBytes(aia)) != null) {
                if (!(decodeBytes.length == 0)) {
                    try {
                        Object newInstance = bhb.class.newInstance();
                        ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                        obj = (com.tencent.mm.bw.a) newInstance;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                    }
                }
            }
            obj = null;
        } else {
            obj = null;
        }
        bhb bhb = (bhb) obj;
        boolean z = bhb != null ? bhb.LQQ == 1 && !MMSlotKt.isExpire(bhb.LQS, bhb.LQR) : false;
        if (z) {
            Log.v("MicroMsg.WebPrefetcher", "[TRACE_PREFETCH] preauth cancelled, in whiteList:".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(195734);
        return z;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class l implements Runnable {
        final /* synthetic */ List pEx;

        l(List list) {
            this.pEx = list;
        }

        public final void run() {
            AppMethodBeat.i(195707);
            LinkedList linkedList = new LinkedList();
            for (String str : this.pEx) {
                try {
                    Log.i("MicroMsg.WebPrefetcher", "pre dns:".concat(String.valueOf(InetAddress.getByName(str))));
                    c.a aVar = com.tencent.mm.plugin.brandservice.c.pmm;
                    MMCacheSlotManager mMCacheSlotManager = com.tencent.mm.plugin.brandservice.c.pml;
                    kotlin.g.b.p.g(str, "host");
                    mMCacheSlotManager.add(str);
                    linkedList.add(str);
                } catch (Exception e2) {
                    Log.e("MicroMsg.WebPrefetcher", "InetAddress Error, " + e2.getMessage());
                }
            }
            com.tencent.mm.plugin.webview.i.b.agp(linkedList.size());
            AppMethodBeat.o(195707);
        }
    }

    private static int ait(String str) {
        AppMethodBeat.i(175488);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) pDF.findSlot(c.ahY(str));
        if (multiProcessMMKV != null) {
            int i2 = multiProcessMMKV.getInt(c.ahY(str), 0);
            AppMethodBeat.o(175488);
            return i2;
        }
        AppMethodBeat.o(175488);
        return 0;
    }

    public static boolean cK(String str, int i2) {
        AppMethodBeat.i(175489);
        kotlin.g.b.p.h(str, "url");
        boolean encode = ((MultiProcessMMKV) pDF.getSlot()).encode(c.ahY(str), i2);
        AppMethodBeat.o(175489);
        return encode;
    }

    public static void Dy(int i2) {
        AppMethodBeat.i(175491);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("WebPrefetcher.currentScene");
        if (mmkv != null) {
            mmkv.encode("currentScene", i2);
            AppMethodBeat.o(175491);
            return;
        }
        AppMethodBeat.o(175491);
    }

    private static int cov() {
        AppMethodBeat.i(175490);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("WebPrefetcher.currentScene");
        if (mmkv != null) {
            int decodeInt = mmkv.decodeInt("currentScene");
            AppMethodBeat.o(175490);
            return decodeInt;
        }
        AppMethodBeat.o(175490);
        return 0;
    }

    public static int ahE(String str) {
        AppMethodBeat.i(175492);
        switch (cov()) {
            case 8:
            case 16:
                if (str != null) {
                    ait(str);
                    int ait = ait(str);
                    AppMethodBeat.o(175492);
                    return ait;
                }
                AppMethodBeat.o(175492);
                return 0;
            default:
                int cov = cov();
                AppMethodBeat.o(175492);
                return cov;
        }
    }

    public static boolean fj(String str, String str2) {
        AppMethodBeat.i(195735);
        String ahY = c.ahY(str);
        c.a aVar = com.tencent.mm.plugin.ad.c.ICA;
        String location = new d(str, ahY, com.tencent.mm.plugin.ad.c.ICw, pDz).getLocation();
        if (!kotlin.n.n.aL(location)) {
            String aJ = c.aJ(location, true);
            Log.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: location:#" + aJ + ", " + location);
            String aJ2 = c.aJ(str2, true);
            Log.v("MicroMsg.WebPrefetcher", "isWebUrlStorageEqual: target:#".concat(String.valueOf(aJ2)));
            boolean j2 = kotlin.g.b.p.j(aJ, aJ2);
            AppMethodBeat.o(195735);
            return j2;
        }
        AppMethodBeat.o(195735);
        return false;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class r extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ bhf pEY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(bhf bhf) {
            super(0);
            this.pEY = bhf;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195718);
            Log.i("MicroMsg.WebPrefetcher", "sendGetA8KeyLiteRequest:" + this.pEY.LRf.size());
            this.pEY.LRg = new LinkedList<>();
            LinkedList<bhe> linkedList = this.pEY.LRf;
            kotlin.g.b.p.g(linkedList, "req.ReqInfo");
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                y yVar = y.pFf;
                String str = it.next().LQZ;
                kotlin.g.b.p.g(str, "it.ReqUrl");
                bhc aiv = y.aiv(str);
                if (aiv != null) {
                    this.pEY.LRg.add(new com.tencent.mm.bw.b(aiv.toByteArray()));
                }
            }
            d.a aVar = new d.a();
            aVar.c(this.pEY);
            aVar.d(new bhh());
            aVar.MB("/cgi-bin/micromsg-bin/geta8keylite");
            aVar.sG(3564);
            aVar.sI(0);
            aVar.sJ(0);
            IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a(this) {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.r.AnonymousClass1 */
                final /* synthetic */ r pEZ;

                {
                    this.pEZ = r1;
                }

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                    AppMethodBeat.i(195717);
                    if (i2 == 0 || i3 == 0) {
                        kotlin.g.b.p.g(dVar, "rr");
                        com.tencent.mm.bw.a aYK = dVar.aYK();
                        if (!(aYK instanceof bhh)) {
                            aYK = null;
                        }
                        bhh bhh = (bhh) aYK;
                        if (bhh != null) {
                            Log.i("MicroMsg.WebPrefetcher", "GetA8KeyLiteResponse: " + bhh.LRg.size());
                            v vVar = v.pDG;
                            v.a(bhh);
                            v vVar2 = v.pDG;
                            bhf bhf = this.pEZ.pEY;
                            v vVar3 = v.pDG;
                            LinkedList<com.tencent.mm.bw.b> linkedList = this.pEZ.pEY.LRg;
                            kotlin.g.b.p.g(linkedList, "req.PrefetchDomainInfos");
                            v.a(bhh, bhf, v.a(bhh, linkedList));
                        }
                    } else {
                        Log.e("MicroMsg.WebPrefetcher", "sendGetA8KeyLiteRequest:" + i2 + ", " + i3 + ", " + str);
                    }
                    try {
                        v vVar4 = v.pDG;
                        ConcurrentSkipListSet concurrentSkipListSet = v.pDB;
                        LinkedList<bhe> linkedList2 = this.pEZ.pEY.LRf;
                        kotlin.g.b.p.g(linkedList2, "req.ReqInfo");
                        LinkedList<bhe> linkedList3 = linkedList2;
                        ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList3, 10));
                        Iterator<T> it = linkedList3.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().LQZ);
                        }
                        concurrentSkipListSet.removeAll(arrayList);
                        AppMethodBeat.o(195717);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.WebPrefetcher", "Concurrent Remove Exception: " + e2.getMessage());
                        AppMethodBeat.o(195717);
                    }
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(195718);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final n pEB = new n();

        static {
            AppMethodBeat.i(195709);
            AppMethodBeat.o(195709);
        }

        n() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z = true;
            AppMethodBeat.i(195708);
            if (MultiProcessMMKV.getMMKV("__webview_command").decodeInt("prefetchTestMode", 0) != 1) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(195708);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcher$savePrefetch$1", f = "WebPrefetcher.kt", hxM = {974, 976, 979, 1002}, m = "invokeSuspend")
    public static final class p extends kotlin.d.b.a.j implements kotlin.g.a.m<kotlinx.coroutines.ai, kotlin.d.d<? super x>, Object> {
        Object L$0;
        int label;
        private kotlinx.coroutines.ai p$;
        Object pED;
        Object pEE;
        Object pEF;
        Object pEG;
        Object pEH;
        Object pEI;
        Object pEJ;
        Object pEK;
        Object pEL;
        Object pEM;
        Object pEN;
        Object pEO;
        Object pEP;
        int pEQ;
        int pER;
        int pES;
        boolean pET;
        final /* synthetic */ bhh pEU;
        final /* synthetic */ bhf pEV;
        final /* synthetic */ List pEW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(bhh bhh, bhf bhf, List list, kotlin.d.d dVar) {
            super(2, dVar);
            this.pEU = bhh;
            this.pEV = bhf;
            this.pEW = list;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(195713);
            kotlin.g.b.p.h(dVar, "completion");
            p pVar = new p(this.pEU, this.pEV, this.pEW, dVar);
            pVar.p$ = (kotlinx.coroutines.ai) obj;
            AppMethodBeat.o(195713);
            return pVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(kotlinx.coroutines.ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(195714);
            Object invokeSuspend = ((p) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(195714);
            return invokeSuspend;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(24:14|(1:16)(1:35)|17|(1:19)(1:36)|20|(6:25|(5:28|(1:32)(1:37)|(2:34|197)(1:196)|194|26)|195|38|(2:41|39)|198)|42|(2:85|(1:87))(1:44)|45|(1:47)|48|(1:52)(1:88)|(1:54)|55|(1:89)(1:59)|(20:61|(1:63)|64|(1:66)(1:90)|67|(1:69)(1:91)|70|(1:74)(1:92)|(2:76|(15:78|(4:80|(1:82)(10:190|94|(12:102|97|(4:99|(1:101)(11:193|120|(16:122|(1:124)(1:136)|125|(1:127)|128|(1:130)|131|(6:133|(2:135|208)|138|(2:141|139)|199|142)|143|144|145|(1:147)(1:156)|148|(2:150|151)(1:159)|152|(1:160)(0))|154|144|145|(0)(0)|148|(0)(0)|152|(0))|101|206)|153|154|144|145|(0)(0)|148|(0)(0)|152|(0)(0))|96|97|(9:153|154|144|145|(0)(0)|148|(0)(0)|152|(0))|99|(0)|101|206)|82|205)|191|96|97|(0)|153|154|144|145|(0)(0)|148|(0)(0)|152|(0)(0)))|103|(1:107)(1:112)|(4:109|(1:111)(15:189|114|(7:116|97|(0)|99|(0)(0)|101|206)|118|97|(0)|153|154|144|145|(0)(0)|148|(0)(0)|152|(0))|111|207)|117|118|97|(0)|99|(0)|101|206)|155|144|145|(0)(0)|148|(0)(0)|152|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x0a9f, code lost:
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WebPrefetcher", "Report Error");
            r4 = r14;
            r5 = r15;
            r6 = r16;
            r7 = r17;
            r8 = r18;
         */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x053b  */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x0545  */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x0689  */
        /* JADX WARNING: Removed duplicated region for block: B:122:0x0784  */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x095f A[LOOP:2: B:139:0x0959->B:141:0x095f, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:147:0x09d5 A[Catch:{ Exception -> 0x0a9e }] */
        /* JADX WARNING: Removed duplicated region for block: B:150:0x0a0b A[Catch:{ Exception -> 0x0a9e }] */
        /* JADX WARNING: Removed duplicated region for block: B:153:0x0a30  */
        /* JADX WARNING: Removed duplicated region for block: B:156:0x0a87  */
        /* JADX WARNING: Removed duplicated region for block: B:159:0x0ab2  */
        /* JADX WARNING: Removed duplicated region for block: B:160:0x0ad1  */
        /* JADX WARNING: Removed duplicated region for block: B:162:0x0ada  */
        /* JADX WARNING: Removed duplicated region for block: B:164:0x0add A[SYNTHETIC, Splitter:B:164:0x0add] */
        /* JADX WARNING: Removed duplicated region for block: B:169:0x0b09 A[LOOP:3: B:167:0x0b03->B:169:0x0b09, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:170:0x0b2c  */
        /* JADX WARNING: Removed duplicated region for block: B:176:0x0b66  */
        /* JADX WARNING: Removed duplicated region for block: B:193:0x0c41  */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x04c3  */
        @Override // kotlin.d.b.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r41) {
            /*
            // Method dump skipped, instructions count: 3182
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.p.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final /* synthetic */ z a(z zVar, d dVar, kotlin.g.a.b bVar) {
        boolean z;
        AppMethodBeat.i(195736);
        com.tencent.mm.vfs.o aWR = dVar.pDU.aWR(dVar.cox());
        if (aWR.exists()) {
            if (!kotlin.n.n.aL(dVar.coF())) {
                zVar.setRequestProperty("x-wx-if-none-match", dVar.coF());
            }
            if (!kotlin.n.n.aL(dVar.coG())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                zVar.setRequestProperty("if-none-match", dVar.coG());
            }
        }
        a(zVar, aWR, bVar, (kotlin.g.a.b) null, 4);
        AppMethodBeat.o(195736);
        return zVar;
    }

    public static final /* synthetic */ z a(String str, String str2, d dVar, Map map) {
        AppMethodBeat.i(195738);
        z zVar = (z) ai.a(new z(str, 0), new h(map, dVar, str2, str));
        AppMethodBeat.o(195738);
        return zVar;
    }

    public static final /* synthetic */ void a(bhh bhh) {
        AppMethodBeat.i(6814);
        LinkedList<bhb> linkedList = bhh.LRt;
        kotlin.g.b.p.g(linkedList, "DomainInfos");
        for (T t : linkedList) {
            String str = t.LQP;
            if (str != null) {
                t.LQS = MMSlotKt.now();
                ((MultiProcessMMKV) pDy.getSlot()).encode(c.aia(str), t.toByteArray());
                Log.i("MicroMsg.WebPrefetcher", "save preauth domain:" + str + ' ' + t.LQQ + ' ' + t.LQR);
            }
        }
        AppMethodBeat.o(6814);
    }

    public static final /* synthetic */ void a(bhh bhh, bhf bhf, List list) {
        AppMethodBeat.i(195739);
        kotlinx.coroutines.f.b(bn.TUK, (kotlin.d.f) null, new p(bhh, bhf, list, null), 3);
        AppMethodBeat.o(195739);
    }

    public static final /* synthetic */ List a(bhh bhh, LinkedList linkedList) {
        ArrayList arrayList;
        bhc bhc;
        LinkedList<bhd> linkedList2;
        AppMethodBeat.i(195740);
        if (linkedList != null) {
            LinkedList<com.tencent.mm.bw.b> linkedList3 = linkedList;
            ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(linkedList3, 10));
            for (com.tencent.mm.bw.b bVar : linkedList3) {
                bhc bhc2 = new bhc();
                bhc2.parseFrom(bVar.toByteArray());
                x xVar = x.SXb;
                arrayList2.add(bhc2);
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        List v = kotlin.a.j.v((Collection) arrayList);
        LinkedList<com.tencent.mm.bw.b> linkedList4 = bhh.LRg;
        kotlin.g.b.p.g(linkedList4, "PrefetchDomainInfos");
        LinkedList<com.tencent.mm.bw.b> linkedList5 = linkedList4;
        ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(linkedList5, 10));
        Iterator<T> it = linkedList5.iterator();
        while (it.hasNext()) {
            bhc bhc3 = new bhc();
            bhc3.parseFrom(it.next().toByteArray());
            x xVar2 = x.SXb;
            arrayList3.add(bhc3);
        }
        ArrayList<bhc> arrayList4 = arrayList3;
        Log.i("MicroMsg.WebPrefetcher", "saveManifest before: localSize: " + v.size() + ", respSize:" + arrayList4.size());
        for (bhc bhc4 : arrayList4) {
            String str = bhc4.LQP;
            kotlin.g.b.p.g(str, "Domain");
            String aWU = com.tencent.mm.plugin.ad.e.aWU(str);
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            LinkedList<bhd> linkedList6 = bhc4.LQU;
            kotlin.g.b.p.g(linkedList6, "ResInfos");
            HashMap hashMap = new HashMap();
            for (T t : linkedList6) {
                String str2 = t.xut;
                kotlin.g.b.p.g(str2, "resInfo.Path");
                kotlin.g.b.p.g(t, "resInfo");
                hashMap.put(str2, t);
                x xVar3 = x.SXb;
            }
            Iterator it2 = v.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    bhc = null;
                    break;
                }
                bhc = (bhc) it2.next();
                if (kotlin.g.b.p.j(bhc.LQP, bhc4.LQP)) {
                    break;
                }
            }
            x xVar4 = x.SXb;
            if (bhc != null) {
                LinkedList<bhd> linkedList7 = bhc.LQU;
                v.remove(bhc);
                x xVar5 = x.SXb;
                linkedList2 = linkedList7;
            } else {
                linkedList2 = null;
            }
            if (linkedList2 != null) {
                for (bhd bhd : linkedList2) {
                    if (hashMap.containsKey(bhd.xut)) {
                        Object obj = hashMap.get(bhd.xut);
                        if (obj == null) {
                            kotlin.g.b.p.hyc();
                        }
                        kotlin.g.b.p.g(obj, "respPathMap[storedResInfo.Path]!!");
                        bhd bhd2 = (bhd) obj;
                        if ((!kotlin.g.b.p.j(bhd.LQV, bhd2.LQV)) || bhd2.him == 1) {
                            Log.i("MicroMsg.WebPrefetcher", "update manifest:" + bhc4.LQP + '#' + aWU + ", path:" + bhd.xut + ", optType:" + bhd.him);
                            z2 = true;
                        } else {
                            z = true;
                        }
                    } else {
                        bhc4.LQU.add(bhd);
                        z3 = true;
                    }
                }
                x xVar6 = x.SXb;
            }
            LinkedList<bhd> linkedList8 = bhc4.LQU;
            kotlin.g.b.p.g(linkedList8, "ResInfos");
            ArrayList arrayList5 = new ArrayList();
            for (T t2 : linkedList8) {
                if (!(t2.him == 1)) {
                    arrayList5.add(t2);
                }
            }
            ArrayList arrayList6 = arrayList5;
            Log.i("MicroMsg.WebPrefetcher", "saveManifest resultResInfos size:" + arrayList6.size() + ", ResInfos size:" + bhc4.LQU.size());
            LinkedList<bhd> linkedList9 = new LinkedList<>();
            linkedList9.addAll(arrayList6);
            x xVar7 = x.SXb;
            bhc4.LQU = linkedList9;
            if (!z || z2 || z3) {
                ((MultiProcessMMKV) pDy.getSlot()).encode(aWU, bhc4.toByteArray());
                StringBuilder append = new StringBuilder("save manifest:").append(bhc4.LQP).append('#').append(aWU).append(", [");
                LinkedList<bhd> linkedList10 = bhc4.LQU;
                kotlin.g.b.p.g(linkedList10, "ResInfos");
                Log.i("MicroMsg.WebPrefetcher", append.append(kotlin.a.j.a(linkedList10, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, o.pEC, 30)).append(']').toString());
            } else {
                Log.i("MicroMsg.WebPrefetcher", "resp manifest:" + bhc4.LQP + '#' + aWU + ", nothing changed");
            }
            x xVar8 = x.SXb;
        }
        Log.i("MicroMsg.WebPrefetcher", "saveManifest after: localSize: " + v.size() + ", respSize:" + arrayList4.size());
        ArrayList arrayList7 = new ArrayList();
        arrayList7.addAll(arrayList4);
        arrayList7.addAll(v);
        Log.i("MicroMsg.WebPrefetcher", "saveManifest result: size: " + arrayList7.size());
        AppMethodBeat.o(195740);
        return arrayList7;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.ad.a n(String str, List list) {
        String path;
        AppMethodBeat.i(195741);
        Uri parse = Uri.parse(str);
        c.a aVar = com.tencent.mm.plugin.ad.c.ICA;
        kotlin.g.b.p.g(parse, "respUri");
        com.tencent.mm.plugin.ad.a aWT = c.a.aWT(parse.getHost());
        if (aWT != null) {
            Log.i("MicroMsg.WebPrefetcher", "matchManifest debug");
            AppMethodBeat.o(195741);
            return aWT;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bhc bhc = (bhc) it.next();
            kotlin.g.b.p.g(parse, "respUri");
            if (kotlin.g.b.p.j(parse.getHost(), bhc.LQP)) {
                LinkedList<bhd> linkedList = bhc.LQU;
                kotlin.g.b.p.g(linkedList, "domain.ResInfos");
                for (T t : linkedList) {
                    if (!(parse == null || (path = parse.getPath()) == null)) {
                        String str2 = t.xut;
                        kotlin.g.b.p.g(str2, "resInfo.Path");
                        if (com.tencent.luggage.h.c.B(path, str2)) {
                            kotlin.g.b.p.g(t, "resInfo");
                            com.tencent.mm.plugin.ad.a aVar2 = new com.tencent.mm.plugin.ad.a(bhc, t, false, 60);
                            AppMethodBeat.o(195741);
                            return aVar2;
                        }
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(195741);
        return null;
    }

    public static final /* synthetic */ void a(fak fak) {
        AppMethodBeat.i(195742);
        String str = fak.url;
        kotlin.g.b.p.g(str, "url");
        String ahY = c.ahY(str);
        String str2 = fak.pFJ;
        kotlin.g.b.p.g(str2, "fullUrl");
        fak.dPJ = c.aJ(str2, true);
        ((MultiProcessMMKV) pDx.getSlot()).encode(ahY, fak.toByteArray());
        Log.i("MicroMsg.WebPrefetcher", "save preauth webid:" + ahY + " bizId: " + fak.dPJ + " prefetch:" + fak.NwF + ", authorized:" + fak.NwE + ", antispam:" + fak.NwD + ", lastModify:" + fak.jsm + ", " + fak.url + ", " + fak.appId);
        AppMethodBeat.o(195742);
    }

    public static final /* synthetic */ void g(List list, String str) {
        AppMethodBeat.i(195744);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            String ff = c.ff(str, cVar.url);
            c.a aVar = com.tencent.mm.plugin.ad.c.ICA;
            if (!com.tencent.mm.plugin.ad.c.ICx.contains(ff)) {
                ai.a(new z(cVar.url, 0), new j(ff, cVar, str));
            }
        }
        AppMethodBeat.o(195744);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x004c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void cI(java.util.List r8) {
        /*
        // Method dump skipped, instructions count: 170
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.cI(java.util.List):void");
    }
}

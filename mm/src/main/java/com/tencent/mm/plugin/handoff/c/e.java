package com.tencent.mm.plugin.handoff.c;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.ae;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002z{B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dH\u0016J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0017J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0017J\b\u00104\u001a\u00020+H\u0016J\u0012\u00105\u001a\u0004\u0018\u00010\u001d2\u0006\u0010.\u001a\u00020/H\u0003J\n\u00106\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u00106\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020\rH\u0016J\u0010\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020\rH\u0016J\b\u0010;\u001a\u00020+H\u0016J\b\u0010<\u001a\u00020+H\u0002J\b\u0010=\u001a\u00020+H\u0016J\u0012\u0010>\u001a\u0004\u0018\u00010\u001d2\u0006\u00108\u001a\u00020\rH\u0016J\u0012\u0010?\u001a\u0004\u0018\u00010\u001d2\u0006\u0010:\u001a\u00020\rH\u0016J\b\u0010@\u001a\u00020\u0019H\u0002J\b\u0010A\u001a\u00020\u0019H\u0002J\b\u0010B\u001a\u00020\u0019H\u0002J\b\u0010C\u001a\u00020\u0019H\u0016J\u0010\u0010D\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dH\u0016J\u0010\u0010E\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0017J\u0010\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020\bH\u0002J\u0010\u0010H\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010I\u001a\u00020+H\u0016J\b\u0010J\u001a\u00020+H\u0016J\u0010\u0010K\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dH\u0016J\u0010\u0010L\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dH\u0016J\u0018\u0010M\u001a\u00020+2\u0006\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dH\u0016J\u0010\u0010R\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dH\u0016J\u0010\u0010S\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dH\u0016J\b\u0010T\u001a\u00020+H\u0016J\b\u0010U\u001a\u00020+H\u0016J\u0010\u0010V\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dH\u0016J\u0010\u0010W\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dH\u0016J\u0010\u0010X\u001a\u00020+2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010Y\u001a\u00020+2\u0006\u0010Z\u001a\u00020\rH\u0016J\u0010\u0010[\u001a\u00020+2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020+2\u0006\u0010:\u001a\u00020\rH\u0016J\u0016\u0010_\u001a\u00020+2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020/0aH\u0016J\u0016\u0010b\u001a\u00020+2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002020aH\u0016J\u0016\u0010d\u001a\u00020+2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020+0fH\u0002J\u0010\u0010g\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dH\u0016J\u0010\u0010h\u001a\u00020+2\u0006\u0010G\u001a\u00020\bH\u0002J\u0018\u0010i\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/2\u0006\u0010j\u001a\u00020\u0019H\u0016J\u0010\u0010k\u001a\u00020+2\u0006\u00101\u001a\u000202H\u0016J\b\u0010l\u001a\u00020+H\u0002J\u0018\u0010m\u001a\u00020+2\u0006\u00108\u001a\u00020\r2\u0006\u0010n\u001a\u00020\rH\u0016J\u0018\u0010o\u001a\u00020\u00192\u0006\u00108\u001a\u00020\r2\u0006\u0010p\u001a\u00020\u0015H\u0016J(\u0010q\u001a\u00020+2\u0006\u00108\u001a\u00020\r2\u0006\u0010r\u001a\u00020\r2\u0006\u0010s\u001a\u00020\b2\u0006\u0010t\u001a\u00020\rH\u0016J \u0010q\u001a\u00020+2\u0006\u00108\u001a\u00020\r2\u0006\u0010u\u001a\u00020\r2\u0006\u0010v\u001a\u00020\rH\u0016J\u0018\u0010w\u001a\u00020\u00192\u0006\u00108\u001a\u00020\r2\u0006\u0010x\u001a\u00020\u0006H\u0016J\u0010\u0010y\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d0\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006|"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffService;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "FIX_DELAY", "", "MAC_MULTI_TASK_VERSION", "", "MSG_FIX", "PC_MULTI_TASK_VERSION", "PC_SUPPORT_VERSION", "TAG", "", "currentWebViewUI", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "fileCache", "Landroid/support/v4/util/ArrayMap;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "handler", "Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "isForeground", "", "isInQB", "items", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "getOnlineInfo", "()Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "setOnlineInfo", "(Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;)V", "qbFile", "requestProcessor", "Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor;", "statusManager", "Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "wc", "add", "", "handOff", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "addWindowFromBall", "allList", "ballInfo2HandOff", "cache", "cancelUpload", "id", "del", "key", "delAllFloatingWindow", "doFix", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "isMac", "isMultiTaskVersion", "isPC", "isSupportOpenInComputer", "mod", "modFromBallInfo", "notifyQbOpenResult", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "notifyUserStatusChange", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onRegister", "onUnregister", "onWebViewCreate", "onWebViewDestroy", "openMultiTask", "processRequest", "message", "registerWebViewUI", "webViewUI", "Lcom/tencent/mm/ui/MMActivity;", "removeMultiTask", "restoreFromBallInfoList", "ballInfoList", "", "restoreFromMultiTaskList", "multiTaskInfoList", "runInHandOffThread", "block", "Lkotlin/Function0;", "sendOpenRequest", "toastOpenResult", "tryEnterFloatBallInternal", "enterFloatBall", "updateMultiTask", "updateQbMenuIfNeed", "uploadFail", "arg", "uploadStart", "info", "uploadSuccess", "appId", "sdkVersion", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "upsert", "FixHandler", "NotifyUserStatusChangeTask", "plugin-handoff_release"})
public final class e implements com.tencent.mm.kernel.c.b, com.tencent.mm.plugin.handoff.a.a, MStorage.IOnStorageChange {
    private static boolean cQp = true;
    static HandOff yid;
    private static HandOff yie;
    private static ConcurrentHashMap<String, HandOff> yif = new ConcurrentHashMap<>();
    private static final android.support.v4.e.a<String, kotlin.o<HandOffFile, com.tencent.mm.pluginsdk.model.app.c>> yig = new android.support.v4.e.a<>();
    private static final a yih;
    private static GetOnLineInfoInfoResult yii = new GetOnLineInfoInfoResult();
    private static boolean yij;
    private static final h yik;
    private static final d yil;
    public static final e yim = new e();

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class h<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final h yip = new h();

        static {
            AppMethodBeat.i(199175);
            AppMethodBeat.o(199175);
        }

        h() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class i<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final i yiq = new i();

        static {
            AppMethodBeat.i(199176);
            AppMethodBeat.o(199176);
        }

        i() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    static {
        AppMethodBeat.i(10371);
        MMHandlerThread aAk = com.tencent.mm.kernel.g.aAk();
        kotlin.g.b.p.g(aAk, "MMKernel.getPizzaWorkerThread()");
        Looper looper = aAk.getLooper();
        kotlin.g.b.p.g(looper, "MMKernel.getPizzaWorkerThread().looper");
        yih = new a(looper);
        MMHandlerThread aAk2 = com.tencent.mm.kernel.g.aAk();
        kotlin.g.b.p.g(aAk2, "MMKernel.getPizzaWorkerThread()");
        Looper looper2 = aAk2.getLooper();
        kotlin.g.b.p.g(looper2, "MMKernel.getPizzaWorkerThread().looper");
        yik = new h(looper2);
        MMHandlerThread aAk3 = com.tencent.mm.kernel.g.aAk();
        kotlin.g.b.p.g(aAk3, "MMKernel.getPizzaWorkerThread()");
        Looper looper3 = aAk3.getLooper();
        kotlin.g.b.p.g(looper3, "MMKernel.getPizzaWorkerThread().looper");
        yil = new d(looper3);
        AppMethodBeat.o(10371);
    }

    private e() {
    }

    public static GetOnLineInfoInfoResult dYq() {
        return yii;
    }

    @SuppressLint({"SwitchIntDef"})
    private static final HandOff P(BallInfo ballInfo) {
        AppMethodBeat.i(10341);
        HandOffFile handOffFile = null;
        switch (ballInfo.type) {
            case 1:
                String nullAsNil = Util.nullAsNil(ballInfo.icon);
                String nullAsNil2 = Util.nullAsNil(ballInfo.name);
                String nullAsNil3 = Util.nullAsNil(ballInfo.jkf.getString("appId"));
                String nullAsNil4 = Util.nullAsNil(ballInfo.jkf.getString(ch.COL_USERNAME));
                kotlin.g.b.p.g(nullAsNil, "icon");
                kotlin.g.b.p.g(nullAsNil2, "title");
                kotlin.g.b.p.g(nullAsNil3, "appId");
                kotlin.g.b.p.g(nullAsNil4, ch.COL_USERNAME);
                handOffFile = new HandOffMP(nullAsNil, nullAsNil2, nullAsNil3, "", nullAsNil4, 2, null, null, null, FileUtils.S_IRWXU, null);
                break;
            case 2:
            case 5:
                String nullAsNil5 = Util.nullAsNil(ballInfo.name);
                String nullAsNil6 = Util.nullAsNil(ballInfo.jkf.getString(HandOffURL.KShareUrl));
                String nullAsNil7 = Util.nullAsNil(ballInfo.jkf.getString("rawUrl"));
                String nullAsNil8 = Util.nullAsNil(ballInfo.icon);
                kotlin.g.b.p.g(nullAsNil5, "title");
                kotlin.g.b.p.g(nullAsNil6, "shareUrl");
                if (!(nullAsNil6.length() > 0)) {
                    nullAsNil6 = nullAsNil7;
                }
                kotlin.g.b.p.g(nullAsNil6, "if (shareUrl.isNotEmpty()) shareUrl else url");
                kotlin.g.b.p.g(nullAsNil8, "icon");
                handOffFile = new HandOffURL(nullAsNil5, nullAsNil6, nullAsNil8, 2, null, null, null, 112, null);
                break;
            case 4:
                HandOffFile.a aVar = HandOffFile.Companion;
                handOffFile = HandOffFile.a.fromBallInfo(ballInfo);
                break;
        }
        if (handOffFile != null) {
            String str = ballInfo.key;
            kotlin.g.b.p.g(str, "ballInfo.key");
            handOffFile.setKey(str);
            handOffFile.setCreateTime(ballInfo.createTime);
            String string = ballInfo.jkf.getString(HandOff.KId);
            if (string != null) {
                kotlin.g.b.p.g(string, LocaleUtil.ITALIAN);
                handOffFile.setId(string);
            }
            AppMethodBeat.o(10341);
            return handOffFile;
        }
        AppMethodBeat.o(10341);
        return null;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.handoff.c.e$e  reason: collision with other inner class name */
    public static final class C1433e extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final C1433e yio = new C1433e();

        static {
            AppMethodBeat.i(199172);
            AppMethodBeat.o(199172);
        }

        C1433e() {
            super(0);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
        /* renamed from: com.tencent.mm.plugin.handoff.c.e$e$a */
        public static final class a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                AppMethodBeat.i(199169);
                int a2 = kotlin.b.a.a(Long.valueOf(-t.getCreateTime()), Long.valueOf(-t2.getCreateTime()));
                AppMethodBeat.o(199169);
                return a2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
        /* renamed from: com.tencent.mm.plugin.handoff.c.e$e$b */
        public static final class b<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                AppMethodBeat.i(199170);
                int a2 = kotlin.b.a.a(Long.valueOf(-t.getCreateTime()), Long.valueOf(-t2.getCreateTime()));
                AppMethodBeat.o(199170);
                return a2;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0099  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0074 A[SYNTHETIC] */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 202
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.handoff.c.e.C1433e.invoke():java.lang.Object");
        }
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBc() {
        AppMethodBeat.i(10342);
        Log.i("HandOffService", "onRegister");
        AppMethodBeat.o(10342);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBd() {
        AppMethodBeat.i(10343);
        Log.i("HandOffService", "onUnregister");
        AppMethodBeat.o(10343);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void dYj() {
        AppMethodBeat.i(10344);
        yih.removeMessages(1);
        yih.sendEmptyMessageDelayed(1, 10000);
        AppMethodBeat.o(10344);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void ff(List<? extends BallInfo> list) {
        AppMethodBeat.i(10345);
        kotlin.g.b.p.h(list, "ballInfoList");
        Log.i("HandOffService", "restore from ballInfoList");
        yif.clear();
        yig.clear();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            HandOff P = P(it.next());
            if (P != null) {
                arrayList.add(P);
            }
        }
        ArrayList<HandOff> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(arrayList2, 10));
        for (HandOff handOff : arrayList2) {
            arrayList3.add(kotlin.s.U(handOff.getKey(), handOff));
        }
        ae.a(arrayList3, yif);
        try {
            com.tencent.mm.kernel.g.aAf();
            if (com.tencent.mm.kernel.a.azo()) {
                h hVar = yik;
                Collection<HandOff> values = yif.values();
                kotlin.g.b.p.g(values, "items.values");
                hVar.l(values);
                AppMethodBeat.o(10345);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("HandOffService", e2, "restoreFromBallInfoList fail, exp:%s", e2);
        }
        AppMethodBeat.o(10345);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void fg(List<? extends MultiTaskInfo> list) {
        AppMethodBeat.i(199196);
        kotlin.g.b.p.h(list, "multiTaskInfoList");
        T(new u(list));
        AppMethodBeat.o(199196);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void a(HandOff handOff) {
        AppMethodBeat.i(10346);
        kotlin.g.b.p.h(handOff, "handOff");
        T(new q(handOff));
        AppMethodBeat.o(10346);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void b(HandOff handOff) {
        AppMethodBeat.i(10347);
        kotlin.g.b.p.h(handOff, "handOff");
        T(new r(handOff));
        AppMethodBeat.o(10347);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void c(HandOff handOff) {
        AppMethodBeat.i(10348);
        kotlin.g.b.p.h(handOff, "handOff");
        T(new l(handOff));
        AppMethodBeat.o(10348);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void d(HandOff handOff) {
        AppMethodBeat.i(10349);
        kotlin.g.b.p.h(handOff, "handOff");
        T(new m(handOff));
        AppMethodBeat.o(10349);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final HandOff aBx(String str) {
        AppMethodBeat.i(199197);
        kotlin.g.b.p.h(str, "key");
        HandOff handOff = yif.get(str);
        if (handOff != null) {
            HandOff copy = handOff.copy();
            AppMethodBeat.o(199197);
            return copy;
        }
        AppMethodBeat.o(199197);
        return null;
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final HandOff aBy(String str) {
        T t2;
        AppMethodBeat.i(10350);
        kotlin.g.b.p.h(str, "id");
        Collection<HandOff> values = yif.values();
        kotlin.g.b.p.g(values, "items.values");
        Iterator<T> it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            T next = it.next();
            if (kotlin.g.b.p.j(next.getId(), str)) {
                t2 = next;
                break;
            }
        }
        T t3 = t2;
        AppMethodBeat.o(10350);
        return t3;
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void O(BallInfo ballInfo) {
        AppMethodBeat.i(10351);
        kotlin.g.b.p.h(ballInfo, "ballInfo");
        HandOff P = P(ballInfo);
        if (P != null) {
            k(P);
            AppMethodBeat.o(10351);
            return;
        }
        AppMethodBeat.o(10351);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void d(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(199198);
        kotlin.g.b.p.h(multiTaskInfo, "multiTaskInfo");
        T(new d(multiTaskInfo));
        AppMethodBeat.o(199198);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void e(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(199199);
        kotlin.g.b.p.h(multiTaskInfo, "multiTaskInfo");
        T(new w(multiTaskInfo));
        AppMethodBeat.o(199199);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void aBz(String str) {
        AppMethodBeat.i(199200);
        kotlin.g.b.p.h(str, "key");
        T(new t(str));
        AppMethodBeat.o(199200);
    }

    public static void k(HandOff handOff) {
        AppMethodBeat.i(10353);
        kotlin.g.b.p.h(handOff, "handOff");
        T(new c(handOff));
        AppMethodBeat.o(10353);
    }

    public static void l(HandOff handOff) {
        AppMethodBeat.i(10354);
        kotlin.g.b.p.h(handOff, "handOff");
        T(new g(handOff));
        AppMethodBeat.o(10354);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void e(HandOff handOff) {
        AppMethodBeat.i(10355);
        kotlin.g.b.p.h(handOff, "handOff");
        T(new x(handOff));
        AppMethodBeat.o(10355);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void f(HandOff handOff) {
        AppMethodBeat.i(199201);
        kotlin.g.b.p.h(handOff, "handOff");
        T(new v(handOff));
        AppMethodBeat.o(199201);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffService$NotifyUserStatusChangeTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class b implements com.tencent.mm.ipcinvoker.b<GetOnLineInfoInfoResult, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(GetOnLineInfoInfoResult getOnLineInfoInfoResult, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(199166);
            GetOnLineInfoInfoResult getOnLineInfoInfoResult2 = getOnLineInfoInfoResult;
            kotlin.g.b.p.h(getOnLineInfoInfoResult2, "data");
            kotlin.g.b.p.h(dVar, "callback");
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).a(getOnLineInfoInfoResult2);
            AppMethodBeat.o(199166);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void a(GetOnLineInfoInfoResult getOnLineInfoInfoResult) {
        boolean z;
        AppMethodBeat.i(199202);
        kotlin.g.b.p.h(getOnLineInfoInfoResult, "onlineInfo");
        Log.i("HandOffService", "notifyUserStatusChange: ".concat(String.valueOf(getOnLineInfoInfoResult)));
        yii = getOnLineInfoInfoResult;
        com.tencent.mm.ipcinvoker.h.a(ToolsProcessIPCService.dkO, getOnLineInfoInfoResult, b.class, h.yip);
        com.tencent.mm.ipcinvoker.h.a(ToolsMpProcessIPCService.dkO, getOnLineInfoInfoResult, b.class, i.yiq);
        if (yij) {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
            intent.setPackage(TbsConfig.APP_QB);
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", 3);
                HandOff handOff = yie;
                if (!(handOff instanceof HandOffFile)) {
                    handOff = null;
                }
                HandOffFile handOffFile = (HandOffFile) handOff;
                String akC = com.tencent.mm.vfs.s.akC(handOffFile != null ? handOffFile.getFullPath() : null);
                if (dYl()) {
                    HandOffFile.a aVar = HandOffFile.Companion;
                    if (HandOffFile.a.isSupportOpenFile(akC)) {
                        z = true;
                        jSONObject.put("isShow", z);
                        jSONArray.put(jSONObject);
                        intent.putExtra("menuItems", jSONArray.toString());
                        MMApplicationContext.getContext().sendBroadcast(intent);
                        AppMethodBeat.o(199202);
                        return;
                    }
                }
                z = false;
                jSONObject.put("isShow", z);
                jSONArray.put(jSONObject);
                intent.putExtra("menuItems", jSONArray.toString());
                MMApplicationContext.getContext().sendBroadcast(intent);
                AppMethodBeat.o(199202);
                return;
            } catch (Exception e2) {
                Log.e("HandOffService", "UpdateQbMenuIfNeed() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            }
        }
        AppMethodBeat.o(199202);
    }

    private static boolean dYr() {
        return yii.jjN == 1;
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final boolean dYl() {
        AppMethodBeat.i(199203);
        if (!dYr() || !yii.kDf || yii.jjS < 1661009920) {
            AppMethodBeat.o(199203);
            return false;
        }
        AppMethodBeat.o(199203);
        return true;
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void del(String str) {
        AppMethodBeat.i(10356);
        kotlin.g.b.p.h(str, "key");
        T(new f(str));
        AppMethodBeat.o(10356);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void dYk() {
        AppMethodBeat.i(10357);
        T(C1433e.yio);
        AppMethodBeat.o(10357);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final boolean a(String str, com.tencent.mm.pluginsdk.model.app.c cVar) {
        AppMethodBeat.i(10358);
        kotlin.g.b.p.h(str, "id");
        kotlin.g.b.p.h(cVar, "info");
        for (Map.Entry<String, HandOff> entry : yif.entrySet()) {
            HandOff value = entry.getValue();
            if ((value instanceof HandOffFile) && kotlin.g.b.p.j(value.getId(), str)) {
                yig.put(str, new kotlin.o<>(value, cVar));
                AppMethodBeat.o(10358);
                return true;
            }
        }
        AppMethodBeat.o(10358);
        return false;
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final boolean az(String str, long j2) {
        AppMethodBeat.i(10359);
        kotlin.g.b.p.h(str, "id");
        kotlin.o<HandOffFile, com.tencent.mm.pluginsdk.model.app.c> oVar = yig.get(str);
        if (oVar != null) {
            h hVar = yik;
            A a2 = oVar.first;
            kotlin.g.b.p.h(a2, "handOff");
            hVar.a(7, kotlin.a.j.listOf(a2));
            AppMethodBeat.o(10359);
            return true;
        }
        Log.w("HandOffService", "error in file uploading, handoff with id [" + str + "] lost!");
        AppMethodBeat.o(10359);
        return false;
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    /* renamed from: if  reason: not valid java name */
    public final void m24if(String str, String str2) {
        AppMethodBeat.i(10360);
        kotlin.g.b.p.h(str, "id");
        kotlin.g.b.p.h(str2, "arg");
        kotlin.o<HandOffFile, com.tencent.mm.pluginsdk.model.app.c> oVar = yig.get(str);
        if (oVar != null) {
            h hVar = yik;
            A a2 = oVar.first;
            kotlin.g.b.p.h(a2, "handOff");
            hVar.a(8, kotlin.a.j.listOf(a2));
            yig.remove(str);
            AppMethodBeat.o(10360);
            return;
        }
        String e2 = new kotlin.n.k("seq=\"\\d+\"").e(new kotlin.n.k("opcode=\"\\d+\"").e(str2, "opcode=\"8\""), "seq=\"<![CSEQ]>\"");
        h hVar2 = yik;
        kotlin.g.b.p.h(e2, "msg");
        hVar2.yiO.add(e2);
        hVar2.dYG();
        Log.w("HandOffService", "error in file upload fail, handoff with id [" + str + "] lost!");
        AppMethodBeat.o(10360);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void av(String str, String str2, String str3) {
        AppMethodBeat.i(10361);
        kotlin.g.b.p.h(str, "id");
        kotlin.g.b.p.h(str2, "cdnURL");
        kotlin.g.b.p.h(str3, "aesKey");
        kotlin.o<HandOffFile, com.tencent.mm.pluginsdk.model.app.c> oVar = yig.get(str);
        if (oVar != null) {
            oVar.first.setCdnURL(str2);
            oVar.first.setAesKey(str3);
            yik.o(oVar.first);
            yig.remove(str);
            AppMethodBeat.o(10361);
            return;
        }
        Log.e("HandOffService", "error in file upload success, handoff with id [" + str + "] lost!");
        AppMethodBeat.o(10361);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void e(String str, String str2, int i2, String str3) {
        AppMethodBeat.i(10362);
        kotlin.g.b.p.h(str, "id");
        kotlin.g.b.p.h(str2, "appId");
        kotlin.g.b.p.h(str3, "mediaId");
        kotlin.o<HandOffFile, com.tencent.mm.pluginsdk.model.app.c> oVar = yig.get(str);
        if (oVar != null) {
            oVar.first.setAppId(str2);
            oVar.first.setSdkVersion(i2);
            oVar.first.setMediaId(str3);
            yik.o(oVar.first);
            yig.remove(str);
            AppMethodBeat.o(10362);
            return;
        }
        Log.e("HandOffService", "error in file upload success, handoff with md5 [" + str + "] lost!");
        AppMethodBeat.o(10362);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void aBA(String str) {
        AppMethodBeat.i(10363);
        kotlin.g.b.p.h(str, "id");
        kotlin.o<HandOffFile, com.tencent.mm.pluginsdk.model.app.c> oVar = yig.get(str);
        if (oVar != null) {
            ((com.tencent.mm.pluginsdk.model.app.c) oVar.second).field_status = 105;
            yig.remove(str);
            AppMethodBeat.o(10363);
            return;
        }
        Log.e("HandOffService", "error in cancel file upload, handoff with md5 [" + str + "] lost!");
        AppMethodBeat.o(10363);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void g(HandOff handOff) {
        AppMethodBeat.i(10364);
        yid = handOff != null ? handOff.copy() : null;
        AppMethodBeat.o(10364);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final HandOff dYm() {
        return yid;
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void h(HandOff handOff) {
        AppMethodBeat.i(10365);
        kotlin.g.b.p.h(handOff, "handOff");
        T(new n(handOff));
        AppMethodBeat.o(10365);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void i(HandOff handOff) {
        AppMethodBeat.i(10366);
        kotlin.g.b.p.h(handOff, "handOff");
        T(o.yit);
        AppMethodBeat.o(10366);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void j(HandOff handOff) {
        AppMethodBeat.i(10367);
        kotlin.g.b.p.h(handOff, "handOff");
        T(new p(handOff));
        AppMethodBeat.o(10367);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void processRequest(String str) {
        AppMethodBeat.i(199204);
        kotlin.g.b.p.h(str, "message");
        T(new s(str));
        AppMethodBeat.o(199204);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
    public static final class a extends MMHandler {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            kotlin.g.b.p.h(looper, "looper");
            AppMethodBeat.i(10340);
            AppMethodBeat.o(10340);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(10339);
            e eVar = e.yim;
            e.dYs();
            AppMethodBeat.o(10339);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        T t2;
        boolean z;
        AppMethodBeat.i(10370);
        kotlin.g.b.p.h(str, "event");
        kotlin.g.b.p.h(mStorageEventData, "eventData");
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(af.class);
        kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginFav::class.java)");
        com.tencent.mm.plugin.fav.a.g DY = ((af) ah).getFavItemInfoStorage().DY(Long.parseLong(str));
        if (DY != null && DY.field_type == 8 && mStorageEventData.eventId == 3) {
            LinkedList<aml> linkedList = DY.field_favProto.ppH;
            kotlin.g.b.p.g(linkedList, "favItemInfo.field_favProto.dataList");
            aml aml = (aml) kotlin.a.j.kt(linkedList);
            if (aml != null) {
                String gtW = aml.gtW();
                if (!(gtW == null || gtW.length() == 0)) {
                    String gua = aml.gua();
                    Collection<HandOff> values = yif.values();
                    kotlin.g.b.p.g(values, "items.values");
                    Iterator<T> it = values.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t2 = null;
                            break;
                        }
                        T next = it.next();
                        T t3 = next;
                        if (!(t3 instanceof HandOffFile) || !kotlin.g.b.p.j(t3.getMd5(), gua) || !kotlin.g.b.p.j(t3.getSvrId(), "-1")) {
                            z = false;
                            continue;
                        } else {
                            z = true;
                            continue;
                        }
                        if (z) {
                            t2 = next;
                            break;
                        }
                    }
                    T t4 = t2;
                    if (t4 != null) {
                        if (t4 == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.handoff.model.HandOffFile");
                            AppMethodBeat.o(10370);
                            throw tVar;
                        }
                        T t5 = t4;
                        String gtW2 = aml.gtW();
                        kotlin.g.b.p.g(gtW2, "favDataItem.cdnDataUrl");
                        t5.setCdnURL(gtW2);
                        String gtX = aml.gtX();
                        kotlin.g.b.p.g(gtX, "favDataItem.cdnDataKey");
                        t5.setAesKey(gtX);
                        t5.setSvrId(String.valueOf(DY.field_id));
                        l(t5);
                        AppMethodBeat.o(10370);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(10370);
    }

    public static void T(kotlin.g.a.a<kotlin.x> aVar) {
        Object obj;
        AppMethodBeat.i(199205);
        Thread currentThread = Thread.currentThread();
        Looper looper = yih.getLooper();
        kotlin.g.b.p.g(looper, "handler.looper");
        if (kotlin.g.b.p.j(currentThread, looper.getThread())) {
            aVar.invoke();
            AppMethodBeat.o(199205);
            return;
        }
        a aVar2 = yih;
        if (aVar != null) {
            obj = new f(aVar);
        } else {
            obj = aVar;
        }
        aVar2.post((Runnable) obj);
        AppMethodBeat.o(199205);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class u extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ List yiv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(List list) {
            super(0);
            this.yiv = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199191);
            Log.i("HandOffService", "restore from multiTaskInfoList");
            e eVar = e.yim;
            e.yif.clear();
            e eVar2 = e.yim;
            e.yig.clear();
            ArrayList arrayList = new ArrayList();
            for (MultiTaskInfo multiTaskInfo : this.yiv) {
                a aVar = a.yhP;
                HandOff f2 = a.f(multiTaskInfo);
                if (f2 != null) {
                    arrayList.add(f2);
                }
            }
            ArrayList<HandOff> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(arrayList2, 10));
            for (HandOff handOff : arrayList2) {
                arrayList3.add(kotlin.s.U(handOff.getKey(), handOff));
            }
            e eVar3 = e.yim;
            ae.a(arrayList3, e.yif);
            try {
                e eVar4 = e.yim;
                h hVar = e.yik;
                e eVar5 = e.yim;
                Collection<? extends HandOff> values = e.yif.values();
                kotlin.g.b.p.g(values, "items.values");
                hVar.l(values);
            } catch (Exception e2) {
                Log.printErrStackTrace("HandOffService", e2, "restoreFromMultiTaskInfoList fail, exp:%s", e2);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199191);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ HandOff yin;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(HandOff handOff) {
            super(0);
            this.yin = handOff;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199187);
            e.yim.e(this.yin);
            Log.i("HandOffService", "onWebViewCreate: handOff id = " + this.yin.getId() + ", key = " + this.yin.getKey());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199187);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ HandOff yin;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(HandOff handOff) {
            super(0);
            this.yin = handOff;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199188);
            e.yim.del(this.yin.getKey());
            Log.i("HandOffService", "onWebViewDestroy: handOff id = " + this.yin.getId() + ", key = " + this.yin.getKey());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199188);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class l extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ HandOff yin;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(HandOff handOff) {
            super(0);
            this.yin = handOff;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199181);
            e.yim.e(this.yin);
            Log.i("HandOffService", "onFileCreate: handOff id = " + this.yin.getId() + ", key = " + this.yin.getKey());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199181);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ HandOff yin;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(HandOff handOff) {
            super(0);
            this.yin = handOff;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199182);
            e.yim.del(this.yin.getKey());
            Log.i("HandOffService", "onFileDestroy: handOff id = " + this.yin.getId() + ", key = " + this.yin.getKey());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199182);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiTaskInfo uLz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MultiTaskInfo multiTaskInfo) {
            super(0);
            this.uLz = multiTaskInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199168);
            a aVar = a.yhP;
            HandOff f2 = a.f(this.uLz);
            if (f2 != null) {
                e eVar = e.yim;
                e.k(f2);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199168);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MultiTaskInfo uLz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(MultiTaskInfo multiTaskInfo) {
            super(0);
            this.uLz = multiTaskInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199194);
            a aVar = a.yhP;
            HandOff f2 = a.f(this.uLz);
            if (f2 != null) {
                e eVar = e.yim;
                e.l(f2);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199194);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class t extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ String $key;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(String str) {
            super(0);
            this.$key = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199190);
            e.yim.del(this.$key);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199190);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ HandOff yin;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(HandOff handOff) {
            super(0);
            this.yin = handOff;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199167);
            e eVar = e.yim;
            e.yih.removeMessages(1);
            e eVar2 = e.yim;
            e.yif.put(this.yin.getKey(), this.yin);
            if ((this.yin instanceof HandOffFile) && ((HandOffFile) this.yin).getSource() == 2 && kotlin.g.b.p.j(this.yin.getId(), "-1")) {
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(af.class);
                kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginFav::class.java)");
                ((af) ah).getFavItemInfoStorage().add(e.yim);
            }
            e eVar3 = e.yim;
            h hVar = e.yik;
            kotlin.g.b.p.h(this.yin, "handOff");
            hVar.apply();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199167);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ HandOff yin;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(HandOff handOff) {
            super(0);
            this.yin = handOff;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199174);
            e eVar = e.yim;
            e.yih.removeMessages(1);
            e eVar2 = e.yim;
            HandOff handOff = (HandOff) e.yif.get(this.yin.getKey());
            if (handOff != null) {
                handOff.update(this.yin);
                e eVar3 = e.yim;
                h hVar = e.yik;
                kotlin.g.b.p.g(handOff, LocaleUtil.ITALIAN);
                kotlin.g.b.p.h(handOff, "handOff");
                hVar.apply();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199174);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class x extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ HandOff yin;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(HandOff handOff) {
            super(0);
            this.yin = handOff;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199195);
            e eVar = e.yim;
            e.yih.removeMessages(1);
            e eVar2 = e.yim;
            if (e.yif.containsKey(this.yin.getKey())) {
                e eVar3 = e.yim;
                e.l(this.yin.copy());
            } else {
                e eVar4 = e.yim;
                e.k(this.yin.copy());
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199195);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class v extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ HandOff yin;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(HandOff handOff) {
            super(0);
            this.yin = handOff;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            int i2;
            AppMethodBeat.i(199193);
            e eVar = e.yim;
            h hVar = e.yik;
            List listOf = kotlin.a.j.listOf(this.yin);
            kotlin.g.b.p.h(listOf, "handOffList");
            hVar.a(10, listOf);
            if (this.yin instanceof HandOffFile) {
                if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                    i2 = -1;
                } else {
                    e eVar2 = e.yim;
                    if (!e.dYq().kDf) {
                        i2 = -2;
                    } else {
                        i2 = 0;
                    }
                }
                e eVar3 = e.yim;
                if (e.yij) {
                    e eVar4 = e.yim;
                    e.OK(i2);
                } else {
                    e eVar5 = e.yim;
                    e.OL(i2);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199193);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ String $key;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(0);
            this.$key = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199173);
            e eVar = e.yim;
            e.yih.removeMessages(1);
            e eVar2 = e.yim;
            HandOff handOff = (HandOff) e.yif.remove(this.$key);
            if (handOff != null) {
                e eVar3 = e.yim;
                h hVar = e.yik;
                kotlin.g.b.p.g(handOff, LocaleUtil.ITALIAN);
                hVar.n(handOff);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199173);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ HandOff yin;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(HandOff handOff) {
            super(0);
            this.yin = handOff;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199183);
            Log.i("HandOffService", "onQBFileCreate");
            e eVar = e.yim;
            e.yij = true;
            e eVar2 = e.yim;
            e.yie = this.yin;
            e.yim.c(this.yin);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199183);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final o yit = new o();

        static {
            AppMethodBeat.i(199185);
            AppMethodBeat.o(199185);
        }

        o() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199184);
            Log.i("HandOffService", "onQBFileDestroy");
            e eVar = e.yim;
            e.yij = false;
            e eVar2 = e.yim;
            HandOff handOff = e.yie;
            if (handOff != null) {
                e.yim.d(handOff);
                e eVar3 = e.yim;
                e.yie = null;
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199184);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ HandOff yin;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(HandOff handOff) {
            super(0);
            this.yin = handOff;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199186);
            Log.i("HandOffService", "onQBFileDestroy");
            e eVar = e.yim;
            HandOff handOff = e.yie;
            if (handOff != null) {
                handOff.update(this.yin);
                e.yim.e(handOff);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199186);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final k yis = new k();

        static {
            AppMethodBeat.i(199180);
            AppMethodBeat.o(199180);
        }

        k() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199179);
            Log.i("HandOffService", "onAppForeground");
            e eVar = e.yim;
            e.cQp = true;
            try {
                if (a.dYp() == -1) {
                    StringBuilder sb = new StringBuilder("onAppForeground, has no float window permission, try remove all float windows: ");
                    e eVar2 = e.yim;
                    Log.i("HandOffService", sb.append(e.yif.size()).toString());
                    e eVar3 = e.yim;
                    Iterator it = e.yif.entrySet().iterator();
                    while (it.hasNext()) {
                        if (((HandOff) ((Map.Entry) it.next()).getValue()).getHandOffType() == 2) {
                            it.remove();
                        }
                    }
                    StringBuilder sb2 = new StringBuilder("onAppForeground, try remove all float windows done: ");
                    e eVar4 = e.yim;
                    Log.i("HandOffService", sb2.append(e.yif.size()).toString());
                }
            } catch (Exception e2) {
                Log.e("HandOffService", "onAppForeground, remove float window fail: " + e2.getLocalizedMessage());
            }
            Log.i("HandOffService", "onAppForeground, send alllist");
            e.yim.dYk();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199179);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final j yir = new j();

        static {
            AppMethodBeat.i(199178);
            AppMethodBeat.o(199178);
        }

        j() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199177);
            Log.i("HandOffService", "onAppBackground");
            e eVar = e.yim;
            e.cQp = false;
            e eVar2 = e.yim;
            if (!e.yij) {
                e eVar3 = e.yim;
                h hVar = e.yik;
                e eVar4 = e.yim;
                Collection values = e.yif.values();
                kotlin.g.b.p.g(values, "items.values");
                ArrayList arrayList = new ArrayList();
                for (Object obj : values) {
                    if (((HandOff) obj).getHandOffType() == 1) {
                        arrayList.add(obj);
                    }
                }
                hVar.m(arrayList);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199177);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ String yiu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(String str) {
            super(0);
            this.yiu = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00c7  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0109  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x007e  */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 300
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.handoff.c.e.s.invoke():java.lang.Object");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void dYs() {
        /*
        // Method dump skipped, instructions count: 230
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.handoff.c.e.dYs():void");
    }

    public static final /* synthetic */ void OK(int i2) {
        AppMethodBeat.i(199206);
        Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
        intent.setPackage(TbsConfig.APP_QB);
        switch (i2) {
            case -2:
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, i2);
                jSONObject.put("des", MMApplicationContext.getContext().getString(R.string.fis));
                intent.putExtra("key_reader_sdk_toast", jSONObject.toString());
                break;
            case -1:
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, i2);
                jSONObject2.put("des", MMApplicationContext.getContext().getString(R.string.fir));
                intent.putExtra("key_reader_sdk_toast", jSONObject2.toString());
                break;
            case 0:
                Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getResources(), R.drawable.icon_toast_ok);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, 0);
                jSONObject3.put("des", MMApplicationContext.getContext().getString(R.string.cek));
                intent.putExtra("key_reader_sdk_toast", jSONObject3.toString());
                intent.putExtra("key_reader_sdk_toast_icon", decodeResource);
                break;
        }
        try {
            MMApplicationContext.getContext().sendBroadcast(intent);
            AppMethodBeat.o(199206);
        } catch (Exception e2) {
            Log.e("HandOffService", "notifyQbOpenResult() Exception%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(199206);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void OL(int i2) {
        AppMethodBeat.i(199207);
        switch (i2) {
            case -2:
                com.tencent.mm.ui.base.u.u(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.fis), 0);
                break;
            case -1:
                com.tencent.mm.ui.base.u.u(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.fir), 0);
                AppMethodBeat.o(199207);
                return;
            case 0:
                com.tencent.mm.ui.base.u.cG(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.fit));
                AppMethodBeat.o(199207);
                return;
        }
        AppMethodBeat.o(199207);
    }

    public static final /* synthetic */ boolean dYz() {
        boolean z;
        AppMethodBeat.i(199208);
        if (!dYr() || yii.jjS < 1661075456) {
            if (yii.jjN == 2) {
                z = true;
            } else {
                z = false;
            }
            if (!z || yii.jjS < 302383616) {
                AppMethodBeat.o(199208);
                return false;
            }
        }
        AppMethodBeat.o(199208);
        return true;
    }
}

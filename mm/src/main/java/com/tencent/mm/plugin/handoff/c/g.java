package com.tencent.mm.plugin.handoff.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.c.b;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001c\u0018\u0000 R2\u00020\u0001:\u001aMNOPQRSTUVWXYZ[\\]^_`abcdefB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0017H\u0016J\u0010\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0016\u00103\u001a\u00020\t2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e05H\u0016J\u0016\u00106\u001a\u00020\t2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001105H\u0016J\u0010\u00108\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u00109\u001a\u00020\tH\u0002J\u0018\u0010:\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u001fH\u0016J\u0010\u0010<\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010=\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u0017H\u0016J\u0018\u0010?\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010@\u001a\u00020AH\u0016J(\u0010B\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u00172\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0017H\u0016J \u0010B\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u0017H\u0016J\u0018\u0010I\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "()V", "currentWebViewUI", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "add", "", "handOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "addWindowFromBall", "allList", "cache", "cancelUpload", "id", "", "del", "key", "delAllFloatingWindow", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "isSupportOpenInComputer", "", "mod", "modFromBallInfo", "notifyUserStatusChange", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onWebViewCreate", "onWebViewDestroy", "openMultiTask", "processRequest", "message", "registerWebViewUI", "webViewUI", "Lcom/tencent/mm/ui/MMActivity;", "removeMultiTask", "restoreFromBallInfoList", "ballInfoList", "", "restoreFromMultiTaskList", "multiTaskInfoList", "sendOpenRequest", "syncUserStatus", "tryEnterFloatBallInternal", "enterFloatBall", "updateMultiTask", "uploadFail", "arg", "uploadStart", "info", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "uploadSuccess", "appId", "sdkVersion", "", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "", "upsert", "AddHandOffFromBallTask", "AddTask", "AddWindowFromBallTask", "AllListTask", "CancelUploadTask", "Companion", "DelAllFloatingWindowTask", "DelTask", "FixHandOffTask", "GetCacheTask", "GetHandOffByIdTask", "GetHandOffByKeyTask", "ModFromBallInfoTask", "ModTask", "OnFileCreateTask", "OnFileDestroyTask", "OnWebViewCreateTask", "OnWebViewDestroyTask", "SendOpenRequestTask", "SetCacheTask", "SyncUserStatusTask", "UploadFail", "UploadSuccessCDNTask", "UploadSuccessCGITask", "UploadingTask", "UpsertTask", "plugin-handoff_release"})
public final class g implements com.tencent.mm.plugin.handoff.a.a {
    public static final d yiw = new d((byte) 0);
    private GetOnLineInfoInfoResult yii = new GetOnLineInfoInfoResult();

    static {
        AppMethodBeat.i(10428);
        AppMethodBeat.o(10428);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class aa<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final aa yiC = new aa();

        static {
            AppMethodBeat.i(10395);
            AppMethodBeat.o(10395);
        }

        aa() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class ab<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final ab yiD = new ab();

        static {
            AppMethodBeat.i(10397);
            AppMethodBeat.o(10397);
        }

        ab() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class ac<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final ac yiE = new ac();

        static {
            AppMethodBeat.i(10398);
            AppMethodBeat.o(10398);
        }

        ac() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class ad<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final ad yiF = new ad();

        static {
            AppMethodBeat.i(10399);
            AppMethodBeat.o(10399);
        }

        ad() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class ae<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final ae yiG = new ae();

        static {
            AppMethodBeat.i(10400);
            AppMethodBeat.o(10400);
        }

        ae() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class af<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final af yiH = new af();

        static {
            AppMethodBeat.i(199212);
            AppMethodBeat.o(199212);
        }

        af() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "kotlin.jvm.PlatformType", "onCallback"})
    public static final class ag<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ g yiI;

        ag(g gVar) {
            this.yiI = gVar;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(199213);
            GetOnLineInfoInfoResult getOnLineInfoInfoResult = (GetOnLineInfoInfoResult) obj;
            Log.i("HandOffServiceProxy", "syncUserStatus: ".concat(String.valueOf(getOnLineInfoInfoResult)));
            g gVar = this.yiI;
            kotlin.g.b.p.g(getOnLineInfoInfoResult, "onlineInfo");
            gVar.yii = getOnLineInfoInfoResult;
            AppMethodBeat.o(199213);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class ah<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final ah yiJ = new ah();

        static {
            AppMethodBeat.i(10401);
            AppMethodBeat.o(10401);
        }

        ah() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class ai<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final ai yiK = new ai();

        static {
            AppMethodBeat.i(10402);
            AppMethodBeat.o(10402);
        }

        ai() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class aj<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final aj yiL = new aj();

        static {
            AppMethodBeat.i(10403);
            AppMethodBeat.o(10403);
        }

        aj() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class ak<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final ak yiM = new ak();

        static {
            AppMethodBeat.i(10404);
            AppMethodBeat.o(10404);
        }

        ak() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class v<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final v yix = new v();

        static {
            AppMethodBeat.i(10390);
            AppMethodBeat.o(10390);
        }

        v() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class w<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final w yiy = new w();

        static {
            AppMethodBeat.i(10391);
            AppMethodBeat.o(10391);
        }

        w() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class x<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final x yiz = new x();

        static {
            AppMethodBeat.i(10392);
            AppMethodBeat.o(10392);
        }

        x() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class y<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final y yiA = new y();

        static {
            AppMethodBeat.i(10393);
            AppMethodBeat.o(10393);
        }

        y() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class z<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final z yiB = new z();

        static {
            AppMethodBeat.i(10394);
            AppMethodBeat.o(10394);
        }

        z() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    public g() {
        AppMethodBeat.i(199224);
        dYC();
        AppMethodBeat.o(199224);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$Companion;", "", "()V", "TAG", "", "plugin-handoff_release"})
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SyncUserStatusTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class p implements com.tencent.mm.ipcinvoker.b<IPCVoid, GetOnLineInfoInfoResult> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<GetOnLineInfoInfoResult> dVar) {
            AppMethodBeat.i(199211);
            kotlin.g.b.p.h(iPCVoid, "data");
            kotlin.g.b.p.h(dVar, "callback");
            e eVar = e.yim;
            dVar.bn(e.dYq());
            AppMethodBeat.o(199211);
        }
    }

    private final void dYC() {
        AppMethodBeat.i(199214);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCVoid(), p.class, new ag(this));
        AppMethodBeat.o(199214);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void dYj() {
        AppMethodBeat.i(10405);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCVoid(), f.class, aa.yiC);
        AppMethodBeat.o(10405);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void ff(List<? extends BallInfo> list) {
        AppMethodBeat.i(10406);
        kotlin.g.b.p.h(list, "ballInfoList");
        AppMethodBeat.o(10406);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void fg(List<? extends MultiTaskInfo> list) {
        AppMethodBeat.i(199215);
        kotlin.g.b.p.h(list, "multiTaskInfoList");
        AppMethodBeat.o(199215);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void a(HandOff handOff) {
        AppMethodBeat.i(10407);
        kotlin.g.b.p.h(handOff, "handOff");
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, handOff, l.class, ad.yiF);
        AppMethodBeat.o(10407);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnWebViewCreateTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class l implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(HandOff handOff, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10382);
            HandOff handOff2 = handOff;
            kotlin.g.b.p.h(handOff2, "handOff");
            e.yim.a(handOff2);
            AppMethodBeat.o(10382);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void b(HandOff handOff) {
        AppMethodBeat.i(10408);
        kotlin.g.b.p.h(handOff, "handOff");
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, handOff, m.class, ae.yiG);
        AppMethodBeat.o(10408);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnWebViewDestroyTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class m implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(HandOff handOff, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10383);
            HandOff handOff2 = handOff;
            kotlin.g.b.p.h(handOff2, "handOff");
            e.yim.b(handOff2);
            AppMethodBeat.o(10383);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void c(HandOff handOff) {
        AppMethodBeat.i(10409);
        kotlin.g.b.p.h(handOff, "handOff");
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, handOff, j.class, ab.yiD);
        AppMethodBeat.o(10409);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnFileCreateTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class j implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(HandOff handOff, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10380);
            HandOff handOff2 = handOff;
            kotlin.g.b.p.h(handOff2, "handOff");
            e.yim.c(handOff2);
            AppMethodBeat.o(10380);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void d(HandOff handOff) {
        AppMethodBeat.i(10410);
        kotlin.g.b.p.h(handOff, "handOff");
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, handOff, k.class, ac.yiE);
        AppMethodBeat.o(10410);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnFileDestroyTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class k implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(HandOff handOff, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10381);
            HandOff handOff2 = handOff;
            kotlin.g.b.p.h(handOff2, "handOff");
            e.yim.d(handOff2);
            AppMethodBeat.o(10381);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final HandOff aBx(String str) {
        AppMethodBeat.i(199216);
        kotlin.g.b.p.h(str, "key");
        HandOff handOff = (HandOff) com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCString(str), i.class);
        AppMethodBeat.o(199216);
        return handOff;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetHandOffByKeyTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "key", "plugin-handoff_release"})
    public static final class i implements com.tencent.mm.ipcinvoker.k<IPCString, HandOff> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ HandOff invoke(IPCString iPCString) {
            AppMethodBeat.i(199209);
            IPCString iPCString2 = iPCString;
            kotlin.g.b.p.h(iPCString2, "key");
            e eVar = e.yim;
            String str = iPCString2.value;
            kotlin.g.b.p.g(str, "key.value");
            HandOff aBx = eVar.aBx(str);
            AppMethodBeat.o(199209);
            return aBx;
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final HandOff aBy(String str) {
        AppMethodBeat.i(10411);
        kotlin.g.b.p.h(str, "id");
        HandOff handOff = (HandOff) com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCString(str), h.class);
        AppMethodBeat.o(10411);
        return handOff;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetHandOffByIdTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "id", "plugin-handoff_release"})
    public static final class h implements com.tencent.mm.ipcinvoker.k<IPCString, HandOff> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ HandOff invoke(IPCString iPCString) {
            AppMethodBeat.i(10378);
            IPCString iPCString2 = iPCString;
            kotlin.g.b.p.h(iPCString2, "id");
            e eVar = e.yim;
            String str = iPCString2.value;
            kotlin.g.b.p.g(str, "id.value");
            HandOff aBy = eVar.aBy(str);
            AppMethodBeat.o(10378);
            return aBy;
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void O(BallInfo ballInfo) {
        AppMethodBeat.i(10412);
        kotlin.g.b.p.h(ballInfo, "ballInfo");
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, ballInfo, a.class, v.yix);
        AppMethodBeat.o(10412);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$AddWindowFromBallTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "ballInfo", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class a implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BallInfo ballInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10373);
            BallInfo ballInfo2 = ballInfo;
            kotlin.g.b.p.h(ballInfo2, "ballInfo");
            e.yim.O(ballInfo2);
            AppMethodBeat.o(10373);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void d(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(199217);
        kotlin.g.b.p.h(multiTaskInfo, "multiTaskInfo");
        AppMethodBeat.o(199217);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void e(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(199218);
        kotlin.g.b.p.h(multiTaskInfo, "multiTaskInfo");
        AppMethodBeat.o(199218);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void aBz(String str) {
        AppMethodBeat.i(199219);
        kotlin.g.b.p.h(str, "key");
        AppMethodBeat.o(199219);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void f(HandOff handOff) {
        AppMethodBeat.i(199220);
        kotlin.g.b.p.h(handOff, "handOff");
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, handOff, n.class, af.yiH);
        AppMethodBeat.o(199220);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void a(GetOnLineInfoInfoResult getOnLineInfoInfoResult) {
        AppMethodBeat.i(199221);
        kotlin.g.b.p.h(getOnLineInfoInfoResult, "onlineInfo");
        Log.i("HandOffServiceProxy", "notifyUserStatusChange: ".concat(String.valueOf(getOnLineInfoInfoResult)));
        this.yii = getOnLineInfoInfoResult;
        AppMethodBeat.o(199221);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final boolean dYl() {
        AppMethodBeat.i(199222);
        if (this.yii.jjS == 0) {
            dYC();
        }
        if (!this.yii.kDf || this.yii.jjS < 1661009920) {
            AppMethodBeat.o(199222);
            return false;
        }
        AppMethodBeat.o(199222);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SendOpenRequestTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class n implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(HandOff handOff, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(199210);
            HandOff handOff2 = handOff;
            kotlin.g.b.p.h(handOff2, "handOff");
            e.yim.f(handOff2);
            AppMethodBeat.o(199210);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void e(HandOff handOff) {
        AppMethodBeat.i(10414);
        kotlin.g.b.p.h(handOff, "handOff");
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, handOff, u.class, ak.yiM);
        AppMethodBeat.o(10414);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UpsertTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class u implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(HandOff handOff, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10389);
            HandOff handOff2 = handOff;
            kotlin.g.b.p.h(handOff2, "handOff");
            e.yim.e(handOff2);
            AppMethodBeat.o(10389);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void del(String str) {
        AppMethodBeat.i(10415);
        kotlin.g.b.p.h(str, "key");
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCString(str), e.class, z.yiB);
        AppMethodBeat.o(10415);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$DelTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "key", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class e implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10376);
            IPCString iPCString2 = iPCString;
            kotlin.g.b.p.h(iPCString2, "key");
            e eVar = e.yim;
            String str = iPCString2.value;
            kotlin.g.b.p.g(str, "key.value");
            eVar.del(str);
            AppMethodBeat.o(10376);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void dYk() {
        AppMethodBeat.i(10416);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCVoid(), b.class, w.yiy);
        AppMethodBeat.o(10416);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final boolean a(String str, com.tencent.mm.pluginsdk.model.app.c cVar) {
        AppMethodBeat.i(10417);
        kotlin.g.b.p.h(str, "id");
        kotlin.g.b.p.h(cVar, "info");
        Log.w("HandOffServiceProxy", "uploadStart should only be called in MM process!");
        AppMethodBeat.o(10417);
        return false;
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final boolean az(String str, long j2) {
        AppMethodBeat.i(10418);
        kotlin.g.b.p.h(str, "id");
        kotlin.g.b.p.h("uploadedSize", "$this$bundleTo");
        boolean z2 = ((IPCBoolean) com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, b.a(b.ig("id", str), new c(new b.C1432b("uploadedSize", j2))), t.class)).value;
        AppMethodBeat.o(10418);
        return z2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadingTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "data", "plugin-handoff_release"})
    public static final class t implements com.tencent.mm.ipcinvoker.k<Bundle, IPCBoolean> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(Bundle bundle) {
            AppMethodBeat.i(10388);
            Bundle bundle2 = bundle;
            kotlin.g.b.p.h(bundle2, "data");
            String string = bundle2.getString("id");
            if (string == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(string, "data.getString(\"id\")!!");
            IPCBoolean iPCBoolean = new IPCBoolean(e.yim.az(string, bundle2.getLong("uploadedSize")));
            AppMethodBeat.o(10388);
            return iPCBoolean;
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    /* renamed from: if  reason: not valid java name */
    public final void m25if(String str, String str2) {
        AppMethodBeat.i(10419);
        kotlin.g.b.p.h(str, "id");
        kotlin.g.b.p.h(str2, "arg");
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, b.a(b.ig("id", str), b.ig("arg", str2)), q.class, ah.yiJ);
        AppMethodBeat.o(10419);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadFail;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class q implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10385);
            Bundle bundle2 = bundle;
            kotlin.g.b.p.h(bundle2, "data");
            String string = bundle2.getString("id");
            if (string == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(string, "data.getString(\"id\")!!");
            String string2 = bundle2.getString("arg");
            if (string2 == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(string2, "data.getString(\"arg\")!!");
            e.yim.m24if(string, string2);
            AppMethodBeat.o(10385);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void av(String str, String str2, String str3) {
        AppMethodBeat.i(10420);
        kotlin.g.b.p.h(str, "id");
        kotlin.g.b.p.h(str2, "cdnURL");
        kotlin.g.b.p.h(str3, "aesKey");
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, b.a(b.ig("id", str), b.ig("cdnURL", str2), b.ig("aesKey", str3)), r.class, ai.yiK);
        AppMethodBeat.o(10420);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadSuccessCDNTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class r implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10386);
            Bundle bundle2 = bundle;
            kotlin.g.b.p.h(bundle2, "data");
            String string = bundle2.getString("id");
            if (string == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(string, "data.getString(\"id\")!!");
            String string2 = bundle2.getString("cdnURL");
            if (string2 == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(string2, "data.getString(\"cdnURL\")!!");
            String string3 = bundle2.getString("aesKey");
            if (string3 == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(string3, "data.getString(\"aesKey\")!!");
            e.yim.av(string, string2, string3);
            AppMethodBeat.o(10386);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void e(String str, String str2, int i2, String str3) {
        AppMethodBeat.i(10421);
        kotlin.g.b.p.h(str, "id");
        kotlin.g.b.p.h(str2, "appId");
        kotlin.g.b.p.h(str3, "mediaId");
        kotlin.g.b.p.h("sdkVersion", "$this$bundleTo");
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, b.a(b.ig("id", str), b.ig("appId", str2), new c(new b.a("sdkVersion", i2)), b.ig("mediaId", str3)), s.class, aj.yiL);
        AppMethodBeat.o(10421);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadSuccessCGITask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class s implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10387);
            Bundle bundle2 = bundle;
            kotlin.g.b.p.h(bundle2, "data");
            String string = bundle2.getString("id");
            if (string == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(string, "data.getString(\"id\")!!");
            String string2 = bundle2.getString("appId");
            if (string2 == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(string2, "data.getString(\"appId\")!!");
            int i2 = bundle2.getInt("sdkVersion");
            String string3 = bundle2.getString("mediaId");
            if (string3 == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(string3, "data.getString(\"mediaId\")!!");
            e.yim.e(string, string2, i2, string3);
            AppMethodBeat.o(10387);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void aBA(String str) {
        AppMethodBeat.i(10422);
        kotlin.g.b.p.h(str, "id");
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCString(str), c.class, y.yiA);
        AppMethodBeat.o(10422);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$CancelUploadTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "id", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class c implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10375);
            IPCString iPCString2 = iPCString;
            kotlin.g.b.p.h(iPCString2, "id");
            kotlin.g.b.p.h(dVar, "callback");
            e eVar = e.yim;
            String str = iPCString2.value;
            kotlin.g.b.p.g(str, "id.value");
            eVar.aBA(str);
            AppMethodBeat.o(10375);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void g(HandOff handOff) {
        AppMethodBeat.i(10423);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, handOff, o.class, x.yiz);
        AppMethodBeat.o(10423);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SetCacheTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class o implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(HandOff handOff, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10384);
            e.yim.g(handOff);
            AppMethodBeat.o(10384);
        }
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final HandOff dYm() {
        AppMethodBeat.i(10424);
        HandOff handOff = (HandOff) com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCVoid(), C1434g.class);
        AppMethodBeat.o(10424);
        return handOff;
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void h(HandOff handOff) {
        AppMethodBeat.i(10425);
        kotlin.g.b.p.h(handOff, "handOff");
        AppMethodBeat.o(10425);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void i(HandOff handOff) {
        AppMethodBeat.i(10426);
        kotlin.g.b.p.h(handOff, "handOff");
        AppMethodBeat.o(10426);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void j(HandOff handOff) {
        AppMethodBeat.i(10427);
        kotlin.g.b.p.h(handOff, "handOff");
        AppMethodBeat.o(10427);
    }

    @Override // com.tencent.mm.plugin.handoff.a.a
    public final void processRequest(String str) {
        AppMethodBeat.i(199223);
        kotlin.g.b.p.h(str, "message");
        AppMethodBeat.o(199223);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$FixHandOffTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class f implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10377);
            e.yim.dYj();
            AppMethodBeat.o(10377);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$AllListTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
    public static final class b implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(10374);
            e.yim.dYk();
            AppMethodBeat.o(10374);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetCacheTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "data", "plugin-handoff_release"})
    /* renamed from: com.tencent.mm.plugin.handoff.c.g$g  reason: collision with other inner class name */
    public static final class C1434g implements com.tencent.mm.ipcinvoker.k<IPCVoid, HandOff> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* bridge */ /* synthetic */ HandOff invoke(IPCVoid iPCVoid) {
            e eVar = e.yim;
            return e.yid;
        }
    }
}

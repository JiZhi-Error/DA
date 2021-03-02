package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.k;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.u;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.protocal.protobuf.zt;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00042\n\u0010!\u001a\u00020\"\"\u00020\u0007H\u0007J&\u0010#\u001a\u00020\u001e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0004H\u0003J\b\u0010'\u001a\u00020\u001eH\u0007J\b\u0010(\u001a\u00020\u001eH\u0003J\b\u0010)\u001a\u00020\u001eH\u0007J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0007H\u0007JR\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u0002002\"\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000402j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`32\u0006\u0010\u001f\u001a\u00020\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001e05H\u0002J4\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00042\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040;2\u0006\u0010<\u001a\u00020\u0004H\u0002J&\u0010=\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002002\u0006\u0010\u001f\u001a\u00020\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001e05H\u0002J\b\u0010>\u001a\u00020\u0004H\u0007J\u0010\u0010?\u001a\u0002002\u0006\u0010,\u001a\u00020\u0007H\u0007J\b\u0010@\u001a\u00020\u0004H\u0007J\b\u0010A\u001a\u00020\u0004H\u0007J\u0012\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u0004H\u0007J\u001a\u0010E\u001a\u0002002\u0006\u0010,\u001a\u00020\u00072\b\b\u0002\u0010F\u001a\u00020\u0004H\u0002J=\u0010G\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\"\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000402j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`3H@ø\u0001\u0000¢\u0006\u0002\u0010HJ\u0016\u0010I\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u00020LJ\u0010\u0010M\u001a\u00020L2\u0006\u0010/\u001a\u000200H\u0003J\u0010\u0010N\u001a\u00020L2\u0006\u0010,\u001a\u00020\u0007H\u0003J0\u0010O\u001a\u00020L2\u0006\u0010P\u001a\u0002072\u0006\u00108\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010-\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0004H\u0002J\u0018\u0010T\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002002\u0006\u0010\u001f\u001a\u00020\u0007H\u0003J\u0010\u0010U\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u0007H\u0007J\u0018\u0010W\u001a\u00020L2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u0004H\u0002J\u0010\u0010Y\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0007J\u0018\u0010Z\u001a\u00020L2\u0006\u0010/\u001a\u0002002\u0006\u0010[\u001a\u000200H\u0002J\u001a\u0010\\\u001a\u00020L2\b\u0010Q\u001a\u0004\u0018\u00010\u00042\u0006\u0010D\u001a\u00020RH\u0002J\u0018\u0010]\u001a\u00020L2\u0006\u0010/\u001a\u0002002\u0006\u0010[\u001a\u000200H\u0002J\u0014\u0010^\u001a\u00020\u001e*\u0002002\u0006\u0010_\u001a\u00020\u0004H\u0002J\f\u0010`\u001a\u00020\u0004*\u000200H\u0002J\u001c\u0010a\u001a\u000200*\u0002002\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0004H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u00148FX\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140\u0019X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001a\u001a\u00020\u0004*\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006e"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager;", "", "()V", "HARDCODE_URL", "", "kotlin.jvm.PlatformType", "MIN_CHECK_TIME", "", "PPREFIX_MP", "PREFIX", "SUPPORT_TMPL_TYPES", "", "getSUPPORT_TMPL_TYPES", "()[Ljava/lang/Integer;", "SUPPORT_TMPL_TYPES$delegate", "Lkotlin/Lazy;", "TAG", "checkTmplList", "Ljava/util/ArrayList;", "expireTime", "", "expireTime$annotations", "getExpireTime", "()J", "lastCheckTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "keyDownloadTime", "getKeyDownloadTime", "(I)Ljava/lang/String;", "checkTmpl", "", "openScene", DownloadInfo.NETTYPE, "tmplTypes", "", "checkTmplInner", "typeInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplClientTypeInfo;", "cleanInvalidTmpl", "cleanInvalidTmplInner", "clear", "createTmplParam", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "tmplType", "download", "url", "tmplInfo", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "httpHeaderMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onSuccess", "Lkotlin/Function0;", "downloadFile", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "reportId", "downloadUrl", "headers", "", "filePath", "downloadTmpl", "getHARDCODE_URL", "getLatestTmplInfo", "getPrefix", "getSaveDir", "getTmplByte", "Ljava/io/InputStream;", "file", "getTmplInfo", "skipUid", "getUrlWithA8key", "(Ljava/lang/String;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectRecord", "tmplParams", "success", "", "isTmplInfoExist", "needCheck", "processPatch", "result", "md5", "Lcom/tencent/mm/vfs/VFSFile;", "patchBase", "processTmplInfo", "saveCheckTimeColdDown", "coldDown", "unzip", SharePatchInfo.OAT_DIR, "updateTmplInfo", "verify", "standard", "verifyMD5", "verifyVersion", "appendToList", "key", "debugInfo", "parseFrom", "type", "uid", "DownloadResult", "plugin-brandservice_release"})
public final class b {
    private static final String PREFIX;
    private static final String pFm;
    private static final kotlin.f pFn = kotlin.g.ah(C0885b.pFu);
    private static final int pFo = pFo;
    private static final ConcurrentHashMap<Integer, Long> pFp = new ConcurrentHashMap<>();
    private static final ArrayList<Integer> pFq = new ArrayList<>();
    public static final b pFr = new b();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\r¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "", "()V", "exception", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "isZip", "", "()Z", "setZip", "(Z)V", "patchBase", "", "getPatchBase", "()Ljava/lang/String;", "setPatchBase", "(Ljava/lang/String;)V", "patchMD5", "getPatchMD5", "setPatchMD5", "success", "getSuccess", "setSuccess", "plugin-brandservice_release"})
    public static final class a {
        Exception exception;
        boolean kwO;
        String pFs;
        String pFt;
        boolean success;
    }

    public static Integer[] coQ() {
        AppMethodBeat.i(6841);
        Integer[] numArr = (Integer[]) pFn.getValue();
        AppMethodBeat.o(6841);
        return numArr;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "checkTmplVerRespCgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplVerResp;", "kotlin.jvm.PlatformType", "call"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<Void, c.a<zt>> {
        final /* synthetic */ LinkedList pFv;
        final /* synthetic */ int pmo;

        c(int i2, LinkedList linkedList) {
            this.pmo = i2;
            this.pFv = linkedList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0099 A[LOOP:1: B:24:0x0093->B:26:0x0099, LOOP_END] */
        @Override // com.tencent.mm.vending.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Void call(com.tencent.mm.ak.c.a<com.tencent.mm.protocal.protobuf.zt> r9) {
            /*
            // Method dump skipped, instructions count: 179
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.c.call(java.lang.Object):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"isIncludeFile", "", "Ljava/util/ArrayList;", "", "file", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
    public static final class e extends q implements m<ArrayList<String>, o, Boolean> {
        public static final e pFx = new e();

        static {
            AppMethodBeat.i(6834);
            AppMethodBeat.o(6834);
        }

        e() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ Boolean invoke(ArrayList<String> arrayList, o oVar) {
            AppMethodBeat.i(6832);
            Boolean valueOf = Boolean.valueOf(a(arrayList, oVar));
            AppMethodBeat.o(6832);
            return valueOf;
        }

        public static boolean a(ArrayList<String> arrayList, o oVar) {
            AppMethodBeat.i(6833);
            p.h(arrayList, "$this$isIncludeFile");
            p.h(oVar, "file");
            boolean contains = arrayList.contains(oVar.getAbsolutePath() + (oVar.isDirectory() ? FilePathGenerator.ANDROID_DIR_SEP : ""));
            AppMethodBeat.o(6833);
            return contains;
        }
    }

    static {
        AppMethodBeat.i(6840);
        String str = com.tencent.mm.plugin.webview.h.a.pFm;
        pFm = str;
        PREFIX = str;
        AppMethodBeat.o(6840);
    }

    private b() {
    }

    public static final /* synthetic */ String DF(int i2) {
        AppMethodBeat.i(6864);
        String DA = DA(i2);
        AppMethodBeat.o(6864);
        return DA;
    }

    public static final /* synthetic */ String m(eib eib) {
        AppMethodBeat.i(6867);
        String l = l(eib);
        AppMethodBeat.o(6867);
        return l;
    }

    private static String DA(int i2) {
        AppMethodBeat.i(6842);
        String concat = "_tmpl_download_time_".concat(String.valueOf(i2));
        AppMethodBeat.o(6842);
        return concat;
    }

    public static void a(eic eic, boolean z) {
        AppMethodBeat.i(195762);
        p.h(eic, "tmplParams");
        String str = "_tmpl_info_inject_fail_-" + eic.pCV + '-' + eic.hFF;
        if (z) {
            u.coo().removeValueForKey(str);
            AppMethodBeat.o(195762);
            return;
        }
        int i2 = u.coo().getInt(str, 0) + 1;
        u.coo().putInt(str, i2);
        Log.e("MicroMsg.Preload.TmplInfoManager", "store tmpl inject fail:" + eic.pCV + ',' + eic.hFF + ',' + i2);
        if (i2 > 2) {
            com.tencent.mm.plugin.webview.h.a.pl(TbsListener.ErrorCode.RENAME_EXCEPTION);
            Log.e("MicroMsg.Preload.TmplInfoManager", "clear tmpl for too many inject fail:" + eic.pCV + ',' + eic.hFF + ',' + i2);
        }
        AppMethodBeat.o(195762);
    }

    public static final synchronized void a(int i2, String str, int... iArr) {
        boolean z;
        boolean z2;
        ArrayList arrayList;
        boolean isExpire;
        synchronized (b.class) {
            AppMethodBeat.i(6844);
            p.h(str, DownloadInfo.NETTYPE);
            p.h(iArr, "tmplTypes");
            if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                Log.w("MicroMsg.Preload.TmplInfoManager", "[checkTmpl] not check, because network is 2g");
                AppMethodBeat.o(6844);
            } else {
                j.a aVar = j.pCC;
                if (BuildInfo.IS_FLAVOR_RED || k.cdi().getInt("preload_type", 1) != 3) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    com.tencent.mm.plugin.brandservice.ui.timeline.preload.o.fh("MicroMsg.Preload.TmplInfoManager", "use local file, ignore");
                    AppMethodBeat.o(6844);
                } else {
                    if (i2 == -1) {
                        pFp.clear();
                    }
                    LinkedList linkedList = new LinkedList();
                    Integer[] coQ = coQ();
                    ArrayList<Number> arrayList2 = new ArrayList();
                    for (Integer num : coQ) {
                        int intValue = num.intValue();
                        j.a aVar2 = j.pCC;
                        if (k.cdi().getBoolean("preload_tmpl_always_check_tmpl_ver", false)) {
                            isExpire = true;
                        } else {
                            long j2 = 0;
                            if (pFp.containsKey(Integer.valueOf(intValue))) {
                                Long l = pFp.get(Integer.valueOf(intValue));
                                if (l == null) {
                                    p.hyc();
                                }
                                j2 = l.longValue();
                            }
                            if (pFq.contains(Integer.valueOf(intValue))) {
                                Log.v("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] %d already check", Integer.valueOf(intValue));
                                isExpire = false;
                            } else {
                                isExpire = MMSlotKt.isExpire(j2, u.coo().getLong("_check_time_colddown", (long) pFo));
                            }
                        }
                        if (isExpire) {
                            arrayList2.add(num);
                        }
                    }
                    for (Number number : arrayList2) {
                        int intValue2 = number.intValue();
                        pFq.add(Integer.valueOf(intValue2));
                        pFp.put(Integer.valueOf(intValue2), Long.valueOf(System.currentTimeMillis()));
                        zr zrVar = new zr();
                        zrVar.oUv = intValue2;
                        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.CR(101)) {
                            zrVar.LkX = u.con();
                        }
                        linkedList.add(zrVar);
                        eib DD = DD(intValue2);
                        if (u.a(DD)) {
                            if (u.ain(u.b(DD))) {
                                zrVar.LkW = DD.LQx;
                            }
                            Set<String> stringSet = u.coo().getStringSet(u.h(DD), null);
                            if (stringSet != null) {
                                ArrayList arrayList3 = new ArrayList();
                                for (T t : stringSet) {
                                    T t2 = t;
                                    eib eib = new eib();
                                    p.g(t2, LocaleUtil.ITALIAN);
                                    if (a(a(eib, intValue2, t2), DD)) {
                                        arrayList3.add(t);
                                    }
                                }
                                arrayList = arrayList3;
                            } else {
                                arrayList = null;
                            }
                            ArrayList arrayList4 = arrayList;
                            if (!(arrayList4 == null || arrayList4.isEmpty())) {
                                zrVar.LkV.addAll(arrayList);
                            }
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        com.tencent.mm.plugin.webview.h.a.pl(0);
                        new a(linkedList, i2, str).aYI().g(new c(i2, linkedList));
                    }
                    AppMethodBeat.o(6844);
                }
            }
        }
    }

    public static final void clear() {
        AppMethodBeat.i(6845);
        u.coo().clear();
        s.dy(coS(), true);
        s.deleteDir(com.tencent.mm.loader.j.b.aKB() + "/jscache/");
        AppMethodBeat.o(6845);
    }

    public static final void DB(int i2) {
        AppMethodBeat.i(6846);
        u.coo().putLong("_check_time_colddown", (long) (i2 * 1000));
        AppMethodBeat.o(6846);
    }

    public static final void j(eib eib) {
        AppMethodBeat.i(6847);
        p.h(eib, "tmplInfo");
        String e2 = u.e(eib);
        u.coo().putString(u.Dx(eib.oUv), eib.LQx);
        u.coo().removeValueForKey(u.f(eib));
        u.coo().removeValueForKey(u.g(eib));
        u.coo().encode(e2, eib.toByteArray());
        String h2 = u.h(eib);
        MultiProcessMMKV coo = u.coo();
        HashSet stringSet = u.coo().getStringSet(h2, null);
        if (stringSet == null) {
            stringSet = new HashSet();
        }
        stringSet.add(eib.LQx);
        coo.putStringSet(h2, stringSet);
        AppMethodBeat.o(6847);
    }

    private static eib a(eib eib, int i2, String str) {
        boolean z;
        AppMethodBeat.i(6848);
        eib.oUv = i2;
        eib.LQx = str;
        byte[] decodeBytes = u.coo().decodeBytes(u.e(eib));
        if (decodeBytes == null || decodeBytes.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            try {
                eib.parseFrom(decodeBytes);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Preload.TmplInfoManager", e2, "decode TmplInfo:" + i2 + ", " + str, new Object[0]);
            }
        }
        AppMethodBeat.o(6848);
        return eib;
    }

    private static boolean a(eib eib, eib eib2) {
        AppMethodBeat.i(6849);
        if (!u.aim(u.b(eib)).exists()) {
            Log.i("MicroMsg.Preload.TmplInfoManager", "no tmpl file:" + eib.LQx);
        } else if (b(eib, eib2)) {
            u.coo().putString(u.f(eib), eib.LQx);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.b(u.coo(), u.g(eib));
            AppMethodBeat.o(6849);
            return true;
        } else {
            if (p.j(u.e(eib), u.coo().getString(u.f(eib), null))) {
                u.coo().removeValueForKey(u.f(eib));
                u.coo().removeValueForKey(u.g(eib));
            }
            u.coo().remove(u.e(eib));
            String h2 = u.h(eib2);
            Set<String> stringSet = u.coo().getStringSet(h2, null);
            if (stringSet != null) {
                stringSet.remove(eib.LQx);
                u.coo().putStringSet(h2, stringSet);
            }
            Log.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + eib.LQx + " is invalid");
        }
        AppMethodBeat.o(6849);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r0 > 0) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(com.tencent.mm.protocal.protobuf.eib r7, com.tencent.mm.protocal.protobuf.eib r8) {
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.b(com.tencent.mm.protocal.protobuf.eib, com.tencent.mm.protocal.protobuf.eib):boolean");
    }

    public static final eib DC(int i2) {
        AppMethodBeat.i(6851);
        eib eib = new eib();
        String string = u.coo().getString(u.Dx(i2), null);
        if (string != null) {
            p.g(string, "uid");
            a(eib, i2, string);
        }
        AppMethodBeat.o(6851);
        return eib;
    }

    private static /* synthetic */ eib DD(int i2) {
        AppMethodBeat.i(6853);
        eib aI = aI(i2, "");
        AppMethodBeat.o(6853);
        return aI;
    }

    private static eib aI(int i2, String str) {
        AppMethodBeat.i(6852);
        eib DC = DC(i2);
        if (u.a(DC)) {
            if (!u.ain(u.b(DC)) || !(!p.j(DC.LQx, str))) {
                String string = u.coo().getString(u.f(DC), null);
                if (string != null) {
                    eib eib = new eib();
                    p.g(string, LocaleUtil.ITALIAN);
                    eib a2 = a(eib, i2, string);
                    if (a2 != null && u.a(a2) && !u.i(a2) && u.ain(u.b(a2)) && (!p.j(a2.LQx, str))) {
                        AppMethodBeat.o(6852);
                        return a2;
                    }
                }
                Set<String> stringSet = u.coo().getStringSet(u.h(DC), null);
                if (stringSet != null) {
                    Set<String> set = stringSet;
                    p.h(set, "$this$sortedDescending");
                    kotlin.b.f fVar = kotlin.b.f.SXy;
                    if (fVar == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
                        AppMethodBeat.o(6852);
                        throw tVar;
                    }
                    List<String> a3 = kotlin.a.j.a((Iterable) set, (Comparator) fVar);
                    if (a3 != null) {
                        for (String str2 : a3) {
                            if (!p.j(str2, str)) {
                                eib eib2 = new eib();
                                p.g(str2, "uid");
                                eib a4 = a(eib2, i2, str2);
                                if (a(a4, DC)) {
                                    AppMethodBeat.o(6852);
                                    return a4;
                                }
                            }
                        }
                    }
                }
            } else {
                AppMethodBeat.o(6852);
                return DC;
            }
        }
        eib eib3 = new eib();
        AppMethodBeat.o(6852);
        return eib3;
    }

    private static final synchronized boolean k(eib eib) {
        boolean z = false;
        synchronized (b.class) {
            AppMethodBeat.i(6854);
            if (eib == null) {
                Log.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is null, return false");
                AppMethodBeat.o(6854);
            } else if (!u.a(eib)) {
                Log.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is invalid, return false");
                AppMethodBeat.o(6854);
            } else if (DC(eib.oUv).Version != eib.Version) {
                AppMethodBeat.o(6854);
            } else if (!u.ain(u.b(eib))) {
                Log.w("MicroMsg.Preload.TmplInfoManager", "[isTmplInfoExist]file isn't exist, may be delete");
                AppMethodBeat.o(6854);
            } else {
                z = true;
                AppMethodBeat.o(6854);
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        public static final d pFw = new d();

        static {
            AppMethodBeat.i(6831);
            AppMethodBeat.o(6831);
        }

        d() {
        }

        public final void run() {
            AppMethodBeat.i(6830);
            b.coV();
            AppMethodBeat.o(6830);
        }
    }

    public static final void coR() {
        AppMethodBeat.i(6855);
        com.tencent.f.h.RTc.b(d.pFw, "tmplPreload");
        AppMethodBeat.o(6855);
    }

    public static final eic DE(int i2) {
        AppMethodBeat.i(195763);
        eib DD = DD(i2);
        if (!u.a(DD)) {
            Log.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]type:" + i2 + " localTmplInfo is null");
            com.tencent.mm.plugin.webview.h.a.pl(100);
            AppMethodBeat.o(195763);
            return null;
        }
        String c2 = u.c(DD);
        if (!u.ain(c2)) {
            Log.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]filePath:" + c2 + " is null");
            if (DD.MSm > 0) {
                com.tencent.mm.plugin.webview.h.a.gH(DD.MSm, 100);
            }
            AppMethodBeat.o(195763);
            return null;
        }
        eic eic = new eic();
        eic.pCV = i2;
        eic.version = DD.Version;
        eic.md5 = DD.Md5;
        eic.Nhr = c2;
        eic.ISo = pFm + i2 + '_' + DD.LQx + ".html" + (p.j(PREFIX, pFm) ^ true ? "?prefix=" + URLEncoder.encode(PREFIX) : "");
        eic.pkK = DD.KUA;
        eic.reportId = DD.MSm;
        eic.DPz = u.coo().getLong(DA(DD.oUv), 0);
        eic.hFF = DD.LQx;
        LinkedList<eia> linkedList = DD.Nhn;
        p.g(linkedList, "tmplInfo.HttpHeaderList");
        StringBuilder sb = new StringBuilder();
        for (T t : linkedList) {
            StringBuilder append = sb.append("\n" + t.xMX + ':' + t.Cyk);
            p.g(append, "sb.append(\"\\n${header.Key}:${header.Value}\")");
            sb = append;
        }
        eic.Nhs = sb.toString();
        AppMethodBeat.o(195763);
        return eic;
    }

    public static final String coS() {
        AppMethodBeat.i(6857);
        String str = com.tencent.mm.loader.j.b.aKB() + "webview_tmpl/";
        j.a aVar = j.pCC;
        if (j.a.cnY()) {
            str = com.tencent.mm.loader.j.b.aKJ();
            p.g(str, "CConstants.DATAROOT_SDCARD_PATH()");
        }
        if (!n.nm(str, FilePathGenerator.ANDROID_DIR_SEP)) {
            str = str + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str2 = str + "tmpls/";
        FilePathGenerator.checkMkdir(str2);
        AppMethodBeat.o(6857);
        return str2;
    }

    public static final String coT() {
        AppMethodBeat.i(195764);
        String str = pFm;
        p.g(str, "HARDCODE_URL");
        AppMethodBeat.o(195764);
        return str;
    }

    public static final String getPrefix() {
        AppMethodBeat.i(195765);
        String str = PREFIX;
        p.g(str, "PREFIX");
        AppMethodBeat.o(195765);
        return str;
    }

    private static String l(eib eib) {
        AppMethodBeat.i(6858);
        String str = "Type:" + eib.oUv + " Version:" + eib.Version + " CdnUrl:" + eib.KUA + " Md5:" + eib.Md5;
        AppMethodBeat.o(6858);
        return str;
    }

    static /* synthetic */ Object a(String str, HashMap<String, String> hashMap, kotlin.d.d<? super String> dVar) {
        AppMethodBeat.i(6859);
        kotlin.d.h hVar = new kotlin.d.h(kotlin.d.a.b.e(dVar));
        kotlin.d.h hVar2 = hVar;
        try {
            com.tencent.mm.modelsimple.l lVar = new com.tencent.mm.modelsimple.l(str, "", 0, 8, com.tencent.mm.modelsimple.l.beZ(), new byte[0]);
            com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
            p.g(aAg, "MMKernel.network()");
            com.tencent.mm.ak.t azz = aAg.azz();
            p.g(azz, "MMKernel.network().netSceneQueue");
            int intValue = Integer.valueOf(lVar.doScene(azz.azD(), new g(hVar2, str, hashMap))).intValue();
            if (intValue < 0) {
                Log.e("MicroMsg.Preload.TmplInfoManager", "NetSceneGetA8Key dispatch fail ".concat(String.valueOf(intValue)));
                Result.Companion companion = Result.Companion;
                hVar2.resumeWith(Result.m46constructorimpl(""));
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.Preload.TmplInfoManager", "getUrlWithA8key ex:" + e2.getMessage());
        }
        Object hxK = hVar.hxK();
        if (hxK == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            p.h(dVar, "frame");
        }
        AppMethodBeat.o(6859);
        return hxK;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n¨\u0006\u000b"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$getUrlWithA8key$2$1"})
    public static final class g implements i {
        final /* synthetic */ kotlin.d.d pEq;
        final /* synthetic */ String pFh;
        final /* synthetic */ HashMap pFz;

        g(kotlin.d.d dVar, String str, HashMap hashMap) {
            this.pEq = dVar;
            this.pFh = str;
            this.pFz = hashMap;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(6838);
            Log.i("MicroMsg.Preload.TmplInfoManager", "[processTmplInfo]errType:%d, errCode:%dm errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            qVar.setHasCallbackToQueue(true);
            if (i2 != 0 || i3 != 0) {
                kotlin.d.d dVar = this.pEq;
                Result.Companion companion = Result.Companion;
                dVar.resumeWith(Result.m46constructorimpl(""));
                AppMethodBeat.o(6838);
            } else if (qVar == null) {
                try {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.modelsimple.NetSceneGetA8Key");
                    AppMethodBeat.o(6838);
                    throw tVar;
                } catch (Exception e2) {
                    Log.e("MicroMsg.Preload.TmplInfoManager", "NetSceneGetA8Key ex " + e2.getMessage());
                    AppMethodBeat.o(6838);
                }
            } else {
                com.tencent.mm.modelsimple.l lVar = (com.tencent.mm.modelsimple.l) qVar;
                List<ccc> beX = lVar.beX();
                p.g(beX, "netSceneGetA8Key.httpHeader");
                for (T t : beX) {
                    String str2 = t.xMX;
                    if (!(str2 == null || str2.length() == 0)) {
                        String str3 = t.Cyk;
                        if (!(str3 == null || str3.length() == 0)) {
                            String str4 = t.xMX;
                            p.g(str4, "it.Key");
                            String str5 = t.Cyk;
                            p.g(str5, "it.Value");
                            this.pFz.put(str4, str5);
                        }
                    }
                }
                kotlin.d.d dVar2 = this.pEq;
                String beQ = lVar.beQ();
                Result.Companion companion2 = Result.Companion;
                dVar2.resumeWith(Result.m46constructorimpl(beQ));
                AppMethodBeat.o(6838);
            }
        }
    }

    private static boolean d(String str, o oVar) {
        AppMethodBeat.i(175496);
        if (Util.isNullOrNil(str) || !p.j(str, s.bhK(oVar.getPath()))) {
            Log.e("MicroMsg.Preload.TmplInfoManager", "checkTmpl %s, MD5 not match", oVar.getAbsolutePath());
            AppMethodBeat.o(175496);
            return false;
        }
        AppMethodBeat.o(175496);
        return true;
    }

    private static boolean fk(String str, String str2) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        Throwable th5;
        Throwable th6;
        AppMethodBeat.i(6861);
        ZipFile zipFile = new ZipFile(str);
        try {
            ZipFile zipFile2 = zipFile;
            Enumeration<? extends ZipEntry> entries = zipFile2.entries();
            byte[] bArr = new byte[1024];
            z.d dVar = new z.d();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                p.g(zipEntry, "zipEntry");
                String name = zipEntry.getName();
                p.g(name, "name");
                if (n.a((CharSequence) name, "../", 0, false, 6) != -1) {
                    Log.e("MicroMsg.Preload.TmplInfoManager", "skip unzip break through file:%s", name);
                } else {
                    o oVar = new o(str2 + name);
                    String parent = oVar.getParent();
                    if (parent == null) {
                        p.hyc();
                    }
                    o oVar2 = new o(parent);
                    if (!oVar2.exists()) {
                        oVar2.mkdirs();
                    }
                    if (!zipEntry.isDirectory()) {
                        if (!oVar.exists()) {
                            oVar.createNewFile();
                        }
                        InputStream inputStream = zipFile2.getInputStream(zipEntry);
                        try {
                            InputStream inputStream2 = inputStream;
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(s.ap(oVar));
                            try {
                                BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
                                while (true) {
                                    int read = inputStream2.read(bArr);
                                    dVar.SYE = read;
                                    if (read <= 0) {
                                        break;
                                    }
                                    bufferedOutputStream2.write(bArr, 0, dVar.SYE);
                                }
                                bufferedOutputStream2.flush();
                                x xVar = x.SXb;
                                kotlin.f.b.a(bufferedOutputStream, null);
                                x xVar2 = x.SXb;
                                kotlin.f.b.a(inputStream, null);
                            } catch (Throwable th7) {
                                th5 = th7;
                                th6 = th;
                                kotlin.f.b.a(bufferedOutputStream, th6);
                                AppMethodBeat.o(6861);
                                throw th5;
                            }
                        } catch (Throwable th8) {
                            th3 = th8;
                            th4 = th;
                            kotlin.f.b.a(inputStream, th4);
                            AppMethodBeat.o(6861);
                            throw th3;
                        }
                    } else if (!oVar.exists()) {
                        oVar.mkdir();
                    }
                }
            }
            kotlin.f.b.a(zipFile, null);
            AppMethodBeat.o(6861);
            return true;
        } catch (Throwable th9) {
            th = th9;
            th2 = th;
            kotlin.f.b.a(zipFile, th2);
            AppMethodBeat.o(6861);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    private static a a(int i2, String str, Map<String, String> map, String str2) {
        Throwable th;
        boolean z;
        AppMethodBeat.i(6862);
        a aVar = new a();
        o oVar = new o(str2);
        if (oVar.exists()) {
            oVar.delete();
        }
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection == null) {
                t tVar = new t("null cannot be cast to non-null type java.net.HttpURLConnection");
                AppMethodBeat.o(6862);
                throw tVar;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            try {
                httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
                httpURLConnection.setRequestProperty("Cache-Control", "no-store");
                httpURLConnection.setDefaultUseCaches(false);
                if (map != null) {
                    if (!map.isEmpty()) {
                        Log.i("MicroMsg.Preload.TmplInfoManager", "headers.size:%d", Integer.valueOf(map.size()));
                        for (String str3 : map.keySet()) {
                            httpURLConnection.setRequestProperty(str3, map.get(str3));
                        }
                    }
                }
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    oVar.createNewFile();
                    byte[] bArr = new byte[8192];
                    z.d dVar = new z.d();
                    OutputStream ap = s.ap(oVar);
                    Throwable th2 = null;
                    try {
                        OutputStream outputStream = ap;
                        while (true) {
                            int read = httpURLConnection.getInputStream().read(bArr);
                            dVar.SYE = read;
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, dVar.SYE);
                        }
                        x xVar = x.SXb;
                        kotlin.f.b.a(ap, null);
                        aVar.success = true;
                        aVar.pFs = httpURLConnection.getHeaderField("X-WECHAT-MPBASEFULLVERSION");
                        aVar.pFt = httpURLConnection.getHeaderField("X-WECHAT-MPPATCHMD5");
                        String headerField = httpURLConnection.getHeaderField("X-WECHAT-MPCONTROLFLAG");
                        if (headerField == null || !(!p.j(AppEventsConstants.EVENT_PARAM_VALUE_NO, headerField))) {
                            z = false;
                        } else {
                            z = true;
                        }
                        aVar.kwO = z;
                    } catch (Throwable th3) {
                        th = th3;
                        th2 = th;
                        kotlin.f.b.a(ap, th2);
                        AppMethodBeat.o(6862);
                        throw th;
                    }
                } else {
                    Log.e("MicroMsg.Preload.TmplInfoManager", "Server return code:".concat(String.valueOf(responseCode)));
                    if (responseCode > 500) {
                        com.tencent.mm.plugin.webview.h.a.gH(i2, 11);
                    } else if (responseCode > 400) {
                        com.tencent.mm.plugin.webview.h.a.gH(i2, 10);
                    }
                }
                x xVar2 = x.SXb;
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th4) {
                }
                httpURLConnection.disconnect();
                AppMethodBeat.o(6862);
                return aVar;
            } catch (Throwable th5) {
                try {
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                } catch (Throwable th6) {
                }
                httpURLConnection.disconnect();
                AppMethodBeat.o(6862);
                throw th5;
            }
        } catch (FileNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.Preload.TmplInfoManager", e2, "not found file:" + str2 + " \nurl:" + str, new Object[0]);
            aVar.exception = e2;
            com.tencent.mm.plugin.webview.h.a.gH(i2, 7);
            if (oVar.exists()) {
                oVar.delete();
            }
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.Preload.TmplInfoManager", e3, "download file:" + str2 + " \nurl:" + str, new Object[0]);
            aVar.exception = e3;
            com.tencent.mm.plugin.webview.h.a.gH(i2, 7);
            if (oVar.exists()) {
                oVar.delete();
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "", "invoke", "()[Ljava/lang/Integer;"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b$b  reason: collision with other inner class name */
    static final class C0885b extends q implements kotlin.g.a.a<Integer[]> {
        public static final C0885b pFu = new C0885b();

        static {
            AppMethodBeat.i(6828);
            AppMethodBeat.o(6828);
        }

        C0885b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer[] invoke() {
            AppMethodBeat.i(6827);
            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.CR(102)) {
                Integer[] numArr = {5, 6};
                AppMethodBeat.o(6827);
                return numArr;
            }
            Integer[] numArr2 = {0, 4, 6};
            AppMethodBeat.o(6827);
            return numArr2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.brandservice.ui.timeline.preload.resdownload.LocalTmplInfoManager$downloadTmpl$1", f = "LocalTmplInfoManager.kt", hxM = {588}, m = "invokeSuspend")
    public static final class f extends kotlin.d.b.a.j implements m<ai, kotlin.d.d<? super x>, Object> {
        Object L$0;
        final /* synthetic */ kotlin.g.a.a kPs;
        int label;
        private ai p$;
        Object pED;
        Object pEE;
        final /* synthetic */ eib pFy;
        final /* synthetic */ int pmo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(eib eib, int i2, kotlin.g.a.a aVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.pFy = eib;
            this.pmo = i2;
            this.kPs = aVar;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(6836);
            p.h(dVar, "completion");
            f fVar = new f(this.pFy, this.pmo, this.kPs, dVar);
            fVar.p$ = (ai) obj;
            AppMethodBeat.o(6836);
            return fVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(6837);
            Object invokeSuspend = ((f) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(6837);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            HashMap hashMap;
            String str;
            Object obj2;
            AppMethodBeat.i(6835);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ai aiVar = this.p$;
                    hashMap = new HashMap();
                    String str2 = this.pFy.KUA;
                    LinkedList<eia> linkedList = this.pFy.Nhn;
                    p.g(linkedList, "tmplInfo.HttpHeaderList");
                    for (T t : linkedList) {
                        String str3 = t.xMX;
                        if (!(str3 == null || str3.length() == 0)) {
                            String str4 = t.Cyk;
                            if (!(str4 == null || str4.length() == 0)) {
                                String str5 = t.xMX;
                                p.g(str5, "it.Key");
                                String str6 = t.Cyk;
                                p.g(str6, "it.Value");
                                hashMap.put(str5, str6);
                            }
                        }
                    }
                    if (this.pFy.Nho) {
                        b bVar = b.pFr;
                        p.g(str2, "downloadUrl");
                        this.L$0 = aiVar;
                        this.pED = hashMap;
                        this.pEE = str2;
                        this.label = 1;
                        obj2 = b.a(str2, hashMap, this);
                        if (obj2 == aVar) {
                            AppMethodBeat.o(6835);
                            return aVar;
                        }
                        str = (String) obj2;
                        break;
                    } else {
                        str = str2;
                        break;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    hashMap = (HashMap) this.pED;
                    str = (String) obj2;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(6835);
                    throw illegalStateException;
            }
            String str7 = str;
            if (!(str7 == null || str7.length() == 0)) {
                b bVar2 = b.pFr;
                b.a(str, this.pFy, hashMap, this.pmo, this.kPs);
            } else {
                StringBuilder sb = new StringBuilder("url is null or empty:");
                b bVar3 = b.pFr;
                Log.e("MicroMsg.Preload.TmplInfoManager", sb.append(b.m(this.pFy)).toString());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(6835);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int $type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(int i2) {
            super(0);
            this.$type = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(6839);
            MultiProcessMMKV coo = u.coo();
            b bVar = b.pFr;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.b(coo, b.DF(this.$type));
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.Dp(this.$type);
            x xVar = x.SXb;
            AppMethodBeat.o(6839);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(eib eib, int i2) {
        AppMethodBeat.i(6863);
        if (k(eib)) {
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.o.fh("MicroMsg.Preload.TmplInfoManager", eib.LQx + " exist, only see for debug");
            AppMethodBeat.o(6863);
            return;
        }
        h hVar = new h(eib.oUv);
        String str = eib.KUA;
        if (str == null || n.aL(str)) {
            Log.i("MicroMsg.Preload.TmplInfoManager", "[addDownloadTask] TmplInfo is null, return");
            AppMethodBeat.o(6863);
            return;
        }
        Log.i("MicroMsg.Preload.TmplInfoManager", "start download:" + l(eib));
        kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new f(eib, i2, hVar, null), 2);
        AppMethodBeat.o(6863);
    }

    public static final /* synthetic */ void coV() {
        AppMethodBeat.i(6865);
        String coS = coS();
        Log.i("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl saveDir:%s", coS);
        o aim = u.aim(coS);
        if (!aim.exists()) {
            Log.w("MicroMsg.Preload.TmplInfoManager", "fileDir:%s is not exist, err", coS);
            AppMethodBeat.o(6865);
        } else if (!aim.isDirectory()) {
            Log.w("MicroMsg.Preload.TmplInfoManager", "fileDir:%s is not dir, err", coS);
            AppMethodBeat.o(6865);
        } else {
            o[] het = aim.het();
            if (het != null) {
                if (!(het.length == 0)) {
                    if (BuildInfo.DEBUG) {
                        Log.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl oldCount %d", Integer.valueOf(het.length));
                        for (o oVar : het) {
                            p.g(oVar, "file");
                            Log.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl file:%s", oVar.getName());
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    Integer[] coQ = coQ();
                    ArrayList<List> arrayList2 = new ArrayList();
                    for (Integer num : coQ) {
                        int intValue = num.intValue();
                        Set<String> stringSet = u.coo().getStringSet(u.h(DC(intValue)), new HashSet());
                        if (stringSet == null) {
                            p.hyc();
                        }
                        p.g(stringSet, "kvTmpl.getStringSet(\n   …keyVersions, HashSet())!!");
                        List p = kotlin.a.j.p(stringSet);
                        ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(p, 10));
                        Iterator it = p.iterator();
                        while (it.hasNext()) {
                            arrayList3.add(kotlin.a.j.listOf(Integer.valueOf(intValue), (String) it.next()));
                        }
                        kotlin.a.j.a((Collection) arrayList2, (Iterable) arrayList3);
                    }
                    for (List list : arrayList2) {
                        Object obj = list.get(0);
                        if (obj == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(6865);
                            throw tVar;
                        }
                        int intValue2 = ((Integer) obj).intValue();
                        Object obj2 = list.get(1);
                        if (obj2 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
                            AppMethodBeat.o(6865);
                            throw tVar2;
                        }
                        eib a2 = a(new eib(), intValue2, (String) obj2);
                        if (u.a(a2)) {
                            arrayList.add(u.b(a2));
                        }
                    }
                    if (BuildInfo.DEBUG) {
                        Log.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl curFilePaths %s", arrayList);
                    }
                    e eVar = e.pFx;
                    ArrayList arrayList4 = new ArrayList();
                    for (o oVar2 : het) {
                        long lastModified = oVar2.lastModified();
                        if (MMSlotKt.isExpire(lastModified, 604800000L)) {
                            p.g(oVar2, "file");
                            if (!e.a(arrayList, oVar2)) {
                                arrayList4.add(oVar2.getAbsolutePath());
                            }
                        }
                        if (BuildInfo.DEBUG && MMSlotKt.isExpire(lastModified, (long) Util.MILLSECONDS_OF_MINUTE)) {
                            p.g(oVar2, "file");
                            if (!e.a(arrayList, oVar2)) {
                                arrayList4.add(oVar2.getAbsolutePath());
                            }
                        }
                    }
                    if (1 >= Log.getLogLevel()) {
                        Log.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl deleteFilePaths %s", arrayList4);
                    }
                    Iterator it2 = arrayList4.iterator();
                    while (it2.hasNext()) {
                        String str = (String) it2.next();
                        p.g(str, "filePath");
                        if (u.aim(str).isDirectory()) {
                            s.dy(str, true);
                        } else {
                            s.deleteFile(str);
                        }
                    }
                    AppMethodBeat.o(6865);
                }
            }
            Log.w("MicroMsg.Preload.TmplInfoManager", "files is null");
            AppMethodBeat.o(6865);
        }
    }

    public static final /* synthetic */ void a(String str, eib eib, HashMap hashMap, int i2, kotlin.g.a.a aVar) {
        a aVar2;
        int i3;
        boolean z;
        int i4;
        String aF;
        boolean z2;
        int i5;
        AppMethodBeat.i(6866);
        if (!n.aL(str)) {
            String str2 = eib.LQx;
            int i6 = eib.MSm;
            int i7 = eib.oUv;
            int i8 = eib.Version;
            com.tencent.mm.plugin.webview.h.c cVar = new com.tencent.mm.plugin.webview.h.c();
            cVar.startTime = System.currentTimeMillis();
            com.tencent.mm.plugin.webview.h.a.gH(i6, 3);
            p.g(str2, "uid");
            String aH = com.tencent.mm.plugin.brandservice.ui.timeline.preload.t.aH(i7, str2);
            try {
                aVar2 = a(i6, str, hashMap, aH);
            } catch (Exception e2) {
                aVar2 = new a();
                Log.printErrStackTrace("MicroMsg.Preload.TmplInfoManager", e2, "downloadTmpl", new Object[0]);
            }
            cVar.pmM = i2;
            cVar.JcD = aVar2.pFs != null;
            cVar.JcC = i8;
            cVar.pCV = i7;
            cVar.JcE = str2;
            boolean z3 = false;
            if (aVar2.kwO) {
                if (aVar2.success) {
                    i5 = TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS;
                } else {
                    i5 = TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;
                }
                com.tencent.mm.plugin.webview.h.a.gH(i6, i5);
            }
            if (aVar2.success) {
                o oVar = new o(aH);
                cVar.size = oVar.length();
                if (aVar2.pFs != null) {
                    if (aVar2.pFt != null) {
                        if (aVar2.kwO) {
                            com.tencent.mm.plugin.webview.h.a.gH(i6, TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS);
                        }
                        if (d(aVar2.pFt, oVar)) {
                            if (aVar2.kwO) {
                                String str3 = aVar2.pFs;
                                if (str3 == null) {
                                    p.hyc();
                                }
                                aF = com.tencent.mm.plugin.brandservice.ui.timeline.preload.t.u(i7, str3, "origin.zip");
                            } else {
                                String str4 = aVar2.pFs;
                                if (str4 == null) {
                                    p.hyc();
                                }
                                aF = com.tencent.mm.plugin.brandservice.ui.timeline.preload.t.aF(i7, str4);
                            }
                            if (new o(aF).exists()) {
                                String str5 = eib.Md5;
                                p.g(str5, "tmplInfo.Md5");
                                String str6 = aF + ".patch";
                                if (((IBSPatchJNIService) com.tencent.mm.kernel.g.af(IBSPatchJNIService.class)).bspatch(aF, str6, oVar.getAbsolutePath()) == 0) {
                                    Log.i("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] patch download success");
                                    o oVar2 = new o(str6);
                                    String bhK = s.bhK(oVar2.getPath());
                                    if (Util.isNullOrNil(bhK) || !p.j(bhK, str5)) {
                                        oVar2.delete();
                                        com.tencent.mm.plugin.webview.h.a.gH(i6, 228);
                                        if (aVar2.kwO) {
                                            com.tencent.mm.plugin.webview.h.a.gH(i6, 240);
                                        }
                                        Log.e("MicroMsg.Preload.TmplInfoManager", "checkTmpl %s MD5 not match after patch", aF);
                                        z2 = false;
                                    } else {
                                        Log.i("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] patch MD5 verify success");
                                        s.nx(oVar2.getPath(), oVar.getPath());
                                        z2 = true;
                                    }
                                } else {
                                    com.tencent.mm.plugin.webview.h.a.gH(i6, TbsListener.ErrorCode.UNLZMA_FAIURE);
                                    Log.e("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] patch fail");
                                    z2 = false;
                                }
                                if (!aVar2.kwO || z2) {
                                    z3 = z2;
                                } else {
                                    com.tencent.mm.plugin.webview.h.a.gH(i6, TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL);
                                    z3 = z2;
                                }
                            } else {
                                Log.e("MicroMsg.Preload.TmplInfoManager", "patch origin file not found:%s", aF);
                                if (aVar2.kwO) {
                                    com.tencent.mm.plugin.webview.h.a.gH(i6, TbsListener.ErrorCode.TPATCH_FAIL);
                                }
                            }
                        } else {
                            com.tencent.mm.plugin.webview.h.a.gH(i6, TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
                            if (aVar2.kwO) {
                                com.tencent.mm.plugin.webview.h.a.gH(i6, 236);
                            }
                        }
                    } else {
                        Log.e("MicroMsg.Preload.TmplInfoManager", "checkTmpl %d,%s, no patch MD5", Integer.valueOf(eib.oUv), eib.LQx);
                        com.tencent.mm.plugin.webview.h.a.gH(i6, 229);
                    }
                } else if (d(eib.Md5, oVar)) {
                    z3 = true;
                    Log.i("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] download & MD5 verify success");
                } else {
                    com.tencent.mm.plugin.webview.h.a.gH(i6, 6);
                    Log.e("MicroMsg.Preload.TmplInfoManager", "checkTmpl %d,%s MD5 not match", Integer.valueOf(eib.oUv), eib.LQx);
                }
                if (z3) {
                    boolean z4 = true;
                    if (aVar2.kwO) {
                        try {
                            String u = com.tencent.mm.plugin.brandservice.ui.timeline.preload.t.u(i7, str2, "");
                            fk(aH, u);
                            new o(aH).am(new o(u + "/origin.zip"));
                        } catch (Exception e3) {
                            com.tencent.mm.plugin.webview.h.a.gH(i6, TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID);
                            if (aVar2.pFs != null) {
                                com.tencent.mm.plugin.webview.h.a.gH(i6, 242);
                            }
                            Log.printErrStackTrace("MicroMsg.Preload.TmplInfoManager", e3, "zip", new Object[0]);
                            z4 = false;
                        }
                    } else {
                        new o(aH).am(new o(com.tencent.mm.plugin.brandservice.ui.timeline.preload.t.aF(i7, str2)));
                    }
                    cVar.endTime = System.currentTimeMillis();
                    cVar.report();
                    if (z4) {
                        eib DC = DC(i7);
                        if (DC.Version != 0) {
                            if (DC.Version < eib.Version) {
                                com.tencent.mm.plugin.webview.h.a.gH(i6, 12);
                            } else if (DC.Version > eib.Version) {
                                com.tencent.mm.plugin.webview.h.a.gH(i6, 13);
                            }
                        }
                        aVar.invoke();
                    }
                }
                if (aVar2.pFs != null) {
                    i4 = TbsListener.ErrorCode.EXCEED_INCR_UPDATE;
                } else {
                    i4 = 226;
                }
                com.tencent.mm.plugin.webview.h.a.gH(i6, i4);
                com.tencent.mm.plugin.webview.h.a.gH(i6, 4);
                z = z3;
            } else {
                if (aVar2.pFs != null) {
                    i3 = TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR;
                } else {
                    i3 = TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL;
                }
                com.tencent.mm.plugin.webview.h.a.gH(i6, i3);
                com.tencent.mm.plugin.webview.h.a.gH(i6, 5);
                Log.e("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] download fail");
                z = false;
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.o.fh("MicroMsg.Preload.TmplInfoManager", "isDownloadSuccess:" + z + ' ' + i7 + ',' + str2 + " \n" + aVar2.exception);
        }
        AppMethodBeat.o(6866);
    }
}

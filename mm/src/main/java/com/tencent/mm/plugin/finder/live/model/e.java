package com.tencent.mm.plugin.finder.live.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020$H\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&J(\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0006\u0010-\u001a\u00020$J\u0012\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u0004J\u0010\u0010/\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010\u0004J\u0018\u00101\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020\u0006J\u001a\u00102\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00103\u001a\u00020\u0006J\u0006\u00104\u001a\u00020$J\u0006\u00105\u001a\u00020$J\b\u00106\u001a\u00020$H\u0002J\u0006\u00107\u001a\u00020$J\u0018\u00108\u001a\u00020$2\u0006\u00100\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nRQ\u0010\u000b\u001aB\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000e0\u000e \r* \u0012\f\u0012\n \r*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R1\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00140\u0013j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0014`\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R9\u0010\u0018\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004 \r*\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R9\u0010\u001a\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004 \r*\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveGiftLoader;", "", "()V", "TAG", "", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "giftCache", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftInfo;", "", "getGiftCache", "()Ljava/util/Map;", "giftFullPagDurationMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getGiftFullPagDurationMap", "()Ljava/util/HashMap;", "giftFullPagMd5Map", "getGiftFullPagMd5Map", "giftPreviewPagMd5Map", "getGiftPreviewPagMd5Map", "released", "attachGiftPagTaskInfo", "imageUrl", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "checkGiftMd5", "", "debugThumbRes", "", "pos", "fetchPag", "url", "id", "name", "isPreview", "fillDebugData", "getGiftInfo", "isPreciousGift", "giftId", "isValidGift", "pagPath", "isPreviewPag", "prepareLocalGift", "release", "tryFetchGiftRes", "trySyncGift", "updatePagMd5Cache", "plugin-finder_release"})
public final class e {
    private static final String TAG = TAG;
    private static boolean aXs;
    private static volatile boolean released;
    private static final Map<String, String> uiA = Collections.synchronizedMap(new HashMap());
    private static final Map<String, String> uiB = Collections.synchronizedMap(new HashMap());
    private static final HashMap<String, Long> uiC = new HashMap<>();
    public static final e uiD = new e();
    private static final Map<String, s> uiz = Collections.synchronizedMap(new LinkedHashMap());

    static {
        AppMethodBeat.i(246101);
        AppMethodBeat.o(246101);
    }

    private e() {
    }

    public static Map<String, s> dfw() {
        return uiz;
    }

    public static HashMap<String, Long> dfx() {
        return uiC;
    }

    public static boolean getDebug() {
        return aXs;
    }

    public static void dfy() {
        AppMethodBeat.i(246088);
        released = false;
        uiz.clear();
        List<s> dxR = ((PluginFinder) g.ah(PluginFinder.class)).getLiveGiftStorage().dxR();
        if (dxR.isEmpty()) {
            Log.w(TAG, "prepareLocalGift giftList from db is nullOrNil");
        }
        for (T t : dxR) {
            Map<String, s> map = uiz;
            p.g(map, "giftCache");
            map.put(((s) t).field_rewardProductId, t);
        }
        Log.i(TAG, "prepareLocalGift cur gift cache:" + uiz);
        AppMethodBeat.o(246088);
    }

    public static void dfz() {
        AppMethodBeat.i(246089);
        uiz.clear();
        List<s> dxR = ((PluginFinder) g.ah(PluginFinder.class)).getLiveGiftStorage().dxR();
        if (dxR.isEmpty()) {
            Log.w(TAG, "skip fetch gift, giftList from db is nullOrNil");
        }
        for (T t : dxR) {
            Map<String, s> map = uiz;
            p.g(map, "giftCache");
            map.put(((s) t).field_rewardProductId, t);
        }
        Log.i(TAG, "cur gift cache:" + uiz);
        dfC();
        dfA();
        AppMethodBeat.o(246089);
    }

    private static void dfA() {
        AppMethodBeat.i(246090);
        Map<String, s> map = uiz;
        p.g(map, "giftCache");
        synchronized (map) {
            try {
                for (Map.Entry<String, s> entry : map.entrySet()) {
                    String key = entry.getKey();
                    s value = entry.getValue();
                    m mVar = m.uJa;
                    b<o, Bitmap> bQ = m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p(value.field_thumbnailFileUrl, x.THUMB_IMAGE));
                    bQ.hYt = new com.tencent.mm.loader.e.b.a();
                    f fVar = new f(bQ, bQ.hYE);
                    fVar.hYv = true;
                    fVar.hYs = fVar.hYw.hYD;
                    fVar.aJu();
                    if (!value.dxO() || !Util.isEqual(value.field_previewPagMd5, uiB.get(key))) {
                        Log.i(TAG, "do fetch preview gift. fetched:" + (!value.dxO()) + " md5Check:" + (!Util.isEqual(value.field_previewPagMd5, uiB.get(key))) + " : [id:" + value.field_rewardProductId + ", name:" + value.field_name + ", isFullPag:" + value.dxN() + ']');
                        String str = value.field_previewPagUrl;
                        p.g(str, "giftInfo.field_previewPagUrl");
                        String str2 = value.field_rewardProductId;
                        p.g(str2, "giftInfo.field_rewardProductId");
                        String str3 = value.field_name;
                        p.g(str3, "giftInfo.field_name");
                        d(str, str2, str3, true);
                    }
                    if (value.dxN() && (!value.dxP() || !Util.isEqual(value.field_animationPagMd5, uiA.get(key)))) {
                        Log.i(TAG, new StringBuilder("do fetch full gift. fetched:").append(!value.dxP()).append(" md5Check:").append(!Util.isEqual(value.field_animationPagMd5, uiA.get(key))).append(" : [id:").append(value.field_rewardProductId).append(", name:").append(value.field_name).append(", isFullPag:").append(value.dxN()).append(']').toString());
                        String str4 = value.field_animationPagUrl;
                        p.g(str4, "giftInfo.field_animationPagUrl");
                        String str5 = value.field_rewardProductId;
                        p.g(str5, "giftInfo.field_rewardProductId");
                        String str6 = value.field_name;
                        p.g(str6, "giftInfo.field_name");
                        d(str4, str5, str6, false);
                    }
                    Log.i(TAG, "id:" + value.field_rewardProductId + " name:" + value.field_name + " isFullPag:" + value.dxN() + " prePagFetched:" + value.dxO() + " fullPagFetched:" + value.dxP());
                }
                kotlin.x xVar = kotlin.x.SXb;
            } finally {
                AppMethodBeat.o(246090);
            }
        }
    }

    private static void d(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(246091);
        if (released) {
            Log.i(TAG, "skip fetch pag, live is released");
            AppMethodBeat.o(246091);
            return;
        }
        com.tencent.mm.i.e eVar = new com.tencent.mm.i.e();
        eVar.taskName = "task_FinderCdnDownloader";
        al alVar = al.waC;
        String a2 = al.a(new com.tencent.mm.plugin.finder.loader.l(str, str2, str3, z));
        com.tencent.mm.vfs.s.deleteFile(a2);
        com.tencent.mm.vfs.s.boN(new com.tencent.mm.vfs.o(a2).getParent());
        if (a(str, a2, eVar)) {
            eVar.gqy = new a(z, str2);
            if (com.tencent.mm.an.f.baQ().e(eVar)) {
                Log.i(TAG, "SubCoreCdnTransport addRecvTask suc");
                AppMethodBeat.o(246091);
                return;
            }
            Log.w(TAG, "SubCoreCdnTransport addRecvTask failed");
            AppMethodBeat.o(246091);
            return;
        }
        Log.w(TAG, "attachSnsImgTaskInfo failed");
        AppMethodBeat.o(246091);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveGiftLoader$fetchPag$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
    public static final class a implements g.a {
        final /* synthetic */ String pAl;
        final /* synthetic */ boolean uiE;

        a(boolean z, String str) {
            this.uiE = z;
            this.pAl = str;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(246085);
            p.h(str, "mediaId");
            e eVar = e.uiD;
            Log.i(e.TAG, "mediaId " + str + " startRet " + i2 + " sceneResult " + dVar + " onlyCheckExist " + z + " isPreview:" + this.uiE);
            e eVar2 = e.uiD;
            if (e.released) {
                e eVar3 = e.uiD;
                Log.i(e.TAG, "skip fetch pag callback, live is released");
                AppMethodBeat.o(246085);
            } else if (dVar == null) {
                e eVar4 = e.uiD;
                Log.i(e.TAG, "skip fetch pag callback, sceneResult == null");
                AppMethodBeat.o(246085);
            } else if (dVar.field_retCode != 0) {
                e eVar5 = e.uiD;
                Log.w(e.TAG, "skip fetch pag callback, fetch pag fail:" + dVar.field_retCode);
                AppMethodBeat.o(246085);
            } else {
                e eVar6 = e.uiD;
                s sVar = e.dfw().get(this.pAl);
                if (sVar != null) {
                    if (this.uiE) {
                        sVar.field_state |= 1;
                    } else {
                        sVar.field_state |= 2;
                    }
                    ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveGiftStorage().replace(sVar);
                    e eVar7 = e.uiD;
                    e.bh(this.pAl, this.uiE);
                }
                AppMethodBeat.o(246085);
            }
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(246086);
            p.h(str, "mediaId");
            p.h(byteArrayOutputStream, "buff");
            AppMethodBeat.o(246086);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            AppMethodBeat.i(246087);
            p.h(str, "mediaId");
            p.h(bArr, "inbuf");
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(246087);
            return bArr2;
        }
    }

    public static /* synthetic */ String atz(String str) {
        AppMethodBeat.i(246093);
        String bf = bf(str, false);
        AppMethodBeat.o(246093);
        return bf;
    }

    public static String bf(String str, boolean z) {
        AppMethodBeat.i(246092);
        if (!aXs) {
            s sVar = uiz.get(str);
            if (sVar == null || str == null) {
                AppMethodBeat.o(246092);
                return "";
            } else if (z) {
                al alVar = al.waC;
                String str2 = sVar.field_previewPagUrl;
                p.g(str2, "giftInfo.field_previewPagUrl");
                String str3 = sVar.field_name;
                p.g(str3, "giftInfo.field_name");
                String a2 = al.a(new com.tencent.mm.plugin.finder.loader.l(str2, str, str3, true));
                AppMethodBeat.o(246092);
                return a2;
            } else {
                al alVar2 = al.waC;
                String str4 = sVar.field_animationPagUrl;
                p.g(str4, "giftInfo.field_animationPagUrl");
                String str5 = sVar.field_name;
                p.g(str5, "giftInfo.field_name");
                String a3 = al.a(new com.tencent.mm.plugin.finder.loader.l(str4, str, str5, false));
                AppMethodBeat.o(246092);
                return a3;
            }
        } else if (z) {
            String str6 = "preview_" + str + ".pag";
            AppMethodBeat.o(246092);
            return str6;
        } else {
            String str7 = "gift_" + str + ".pag";
            AppMethodBeat.o(246092);
            return str7;
        }
    }

    public static void dfB() {
        AppMethodBeat.i(246094);
        for (int i2 = 0; i2 < 6; i2++) {
            s sVar = new s();
            sVar.field_rewardProductId = String.valueOf(i2);
            sVar.field_name = "礼物".concat(String.valueOf(i2));
            sVar.field_price = 10.0f;
            sVar.field_animationPagUrl = "gift_" + i2 + ".pag";
            sVar.field_previewPagUrl = "preview_" + i2 + ".pag";
            sVar.field_businessType = 0;
            Map<String, s> map = uiz;
            p.g(map, "giftCache");
            map.put(String.valueOf(i2), sVar);
        }
        AppMethodBeat.o(246094);
    }

    public static s atA(String str) {
        AppMethodBeat.i(246095);
        s sVar = uiz.get(str);
        AppMethodBeat.o(246095);
        return sVar;
    }

    public static boolean bg(String str, boolean z) {
        String str2;
        String str3 = null;
        AppMethodBeat.i(246096);
        s sVar = uiz.get(str);
        String str4 = TAG;
        StringBuilder append = new StringBuilder("isValidGift isPreview:").append(z).append(" id:");
        if (sVar != null) {
            str2 = sVar.field_rewardProductId;
        } else {
            str2 = null;
        }
        Log.i(str4, append.append(str2).append(" name:").append(sVar != null ? sVar.field_name : null).append(" previewMd5:").append(sVar != null ? sVar.field_previewPagMd5 : null).append(" filePreviewMd5:").append(uiB.get(str)).append(" fullMd5:").append(sVar != null ? sVar.field_animationPagMd5 : null).append(" fileFulMd5:").append(uiA.get(str)).toString());
        if (z) {
            if (sVar != null) {
                str3 = sVar.field_previewPagMd5;
            }
            boolean isEqual = Util.isEqual(str3, uiB.get(str));
            AppMethodBeat.o(246096);
            return isEqual;
        }
        if (sVar != null) {
            str3 = sVar.field_animationPagMd5;
        }
        boolean isEqual2 = Util.isEqual(str3, uiA.get(str));
        AppMethodBeat.o(246096);
        return isEqual2;
    }

    public static boolean atB(String str) {
        String str2;
        String str3 = null;
        AppMethodBeat.i(246097);
        s sVar = uiz.get(str);
        String str4 = TAG;
        StringBuilder sb = new StringBuilder("isPreciousGift id:");
        if (sVar != null) {
            str2 = sVar.field_rewardProductId;
        } else {
            str2 = null;
        }
        Log.i(str4, sb.append(str2).append(" name:").append(sVar != null ? sVar.field_name : null).append(" animationPagUrl:").append(sVar != null ? sVar.field_animationPagUrl : null).toString());
        if (bg(str, false)) {
            if (sVar != null) {
                str3 = sVar.field_animationPagUrl;
            }
            if (!Util.isNullOrNil(str3)) {
                AppMethodBeat.o(246097);
                return true;
            }
        }
        AppMethodBeat.o(246097);
        return false;
    }

    private static void dfC() {
        AppMethodBeat.i(246098);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(uiz);
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        synchronized (linkedHashMap2) {
            try {
                for (Map.Entry entry : linkedHashMap2.entrySet()) {
                    String str = (String) entry.getKey();
                    s sVar = (s) entry.getValue();
                    if (sVar.dxN()) {
                        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(bf(str, true));
                        if (oVar.exists()) {
                            String a2 = com.tencent.mm.b.g.a(oVar, (int) oVar.length());
                            Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + sVar.field_name + " isFullPag:" + sVar.dxN() + " filePreviewPagMd5:" + a2 + " giftInfo.field_previewPagMd5:" + sVar.field_previewPagMd5);
                            Map<String, String> map = uiB;
                            p.g(map, "giftPreviewPagMd5Map");
                            map.put(str, a2);
                        } else {
                            sVar.dxQ();
                            ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveGiftStorage().b(sVar);
                            Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + sVar.field_name + " isFullPag:" + sVar.dxN() + " pagFile not exist, skip check");
                        }
                        com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(bf(str, false));
                        if (oVar2.exists()) {
                            String a3 = com.tencent.mm.b.g.a(oVar2, (int) oVar2.length());
                            Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + sVar.field_name + " isFullPag:" + sVar.dxN() + " filePagMd5:" + a3 + " giftInfo.field_animationPagMd5:" + sVar.field_animationPagMd5);
                            Map<String, String> map2 = uiA;
                            p.g(map2, "giftFullPagMd5Map");
                            map2.put(str, a3);
                            Long l = uiC.get(str);
                            if (l == null) {
                                l = 0L;
                            }
                            if ((l instanceof Long) && 0 == l.longValue()) {
                                PAGView pAGView = new PAGView(MMApplicationContext.getContext());
                                pAGView.setFile(PAGFile.Load(bf(str, false)));
                                uiC.put(str, Long.valueOf(pAGView.duration()));
                                Log.i(TAG, "checkGiftMd5 giftFullPagDurationMap: giftId = " + str + ", duration = " + uiC.get(str));
                            }
                        } else {
                            sVar.dxQ();
                            ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveGiftStorage().b(sVar);
                            Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + sVar.field_name + " isFullPag:" + sVar.dxN() + " pagFile not exist, skip check");
                        }
                    } else {
                        com.tencent.mm.vfs.o oVar3 = new com.tencent.mm.vfs.o(bf(str, true));
                        if (oVar3.exists()) {
                            String a4 = com.tencent.mm.b.g.a(oVar3, (int) oVar3.length());
                            Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + sVar.field_name + " isFullPag:" + sVar.dxN() + " filePreviewPagMd5:" + a4 + " giftInfo.field_previewPagMd5:" + sVar.field_previewPagMd5);
                            Map<String, String> map3 = uiB;
                            p.g(map3, "giftPreviewPagMd5Map");
                            map3.put(str, a4);
                        } else {
                            sVar.dxQ();
                            ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveGiftStorage().b(sVar);
                            Log.i(TAG, "checkGiftMd5 id:" + str + " name:" + sVar.field_name + " isFullPag:" + sVar.dxN() + " pagFile not exist, skip check");
                        }
                    }
                }
                kotlin.x xVar = kotlin.x.SXb;
            } finally {
                AppMethodBeat.o(246098);
            }
        }
    }

    private static boolean a(String str, String str2, com.tencent.mm.i.e eVar) {
        AppMethodBeat.i(246099);
        try {
            String host = new URL(str).getHost();
            int a2 = com.tencent.mm.network.d.a(host, false, new ArrayList());
            int a3 = com.tencent.mm.network.d.a(host, true, new ArrayList());
            eVar.field_mediaId = MD5Util.getMD5String(str);
            eVar.url = str;
            eVar.host = host;
            eVar.gqq = str2;
            eVar.gqt = a2;
            eVar.gqu = a3;
            eVar.isColdSnsData = false;
            eVar.signalQuality = new StringBuilder().append(NetStatusUtil.getStrength(MMApplicationContext.getContext())).toString();
            eVar.snsScene = "";
            eVar.appType = 150;
            eVar.fileType = 20201;
            Log.i(TAG, "attachGiftPagTaskInfo imageUrl:%s", str);
            AppMethodBeat.o(246099);
            return true;
        } catch (MalformedURLException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            Log.w(TAG, "attachGiftPagTaskInfo fail:".concat(String.valueOf(e2)));
            AppMethodBeat.o(246099);
            return false;
        }
    }

    public static void release() {
        AppMethodBeat.i(246100);
        released = true;
        uiz.clear();
        uiA.clear();
        uiB.clear();
        AppMethodBeat.o(246100);
    }

    public static final /* synthetic */ void bh(String str, boolean z) {
        AppMethodBeat.i(246102);
        s sVar = uiz.get(str);
        if (sVar == null) {
            AppMethodBeat.o(246102);
        } else if (z) {
            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(bf(str, true));
            String a2 = com.tencent.mm.b.g.a(oVar, (int) oVar.length());
            Log.i(TAG, "updatePagMd5Cache isPreview:" + z + " id:" + str + " name:" + sVar.field_name + " fileMd5:" + a2 + " giftInfo.field_previewPagMd5:" + sVar.field_previewPagMd5);
            Map<String, String> map = uiB;
            p.g(map, "giftPreviewPagMd5Map");
            map.put(str, a2);
            AppMethodBeat.o(246102);
        } else {
            com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(bf(str, false));
            String a3 = com.tencent.mm.b.g.a(oVar2, (int) oVar2.length());
            Log.i(TAG, "updatePagMd5Cache isPreview:" + z + " id:" + str + " name:" + sVar.field_name + " fileMd5:" + a3 + " giftInfo.field_animationPagMd5:" + sVar.field_animationPagMd5 + ' ');
            Map<String, String> map2 = uiA;
            p.g(map2, "giftFullPagMd5Map");
            map2.put(str, a3);
            Long l = uiC.get(str);
            if (l == null) {
                l = 0L;
            }
            if (!(l instanceof Long)) {
                AppMethodBeat.o(246102);
                return;
            }
            if (0 == l.longValue()) {
                PAGView pAGView = new PAGView(MMApplicationContext.getContext());
                pAGView.setFile(PAGFile.Load(bf(str, false)));
                uiC.put(str, Long.valueOf(pAGView.duration()));
                Log.i(TAG, "updatePagMd5Cache giftFullPagDurationMap: giftId = " + str + ", duration = " + uiC.get(str));
            }
            AppMethodBeat.o(246102);
        }
    }
}

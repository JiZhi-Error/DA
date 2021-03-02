package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.i.c;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.d.b;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J8\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\fH\u0002J%\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "onCdnDownloadCallback", "Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "(Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;)V", "getOnCdnDownloadCallback", "()Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "attachSnsImgTaskInfo", "", "data", "imageUrl", "", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-finder_release"})
public final class f extends com.tencent.mm.loader.d.b<o> {
    public static final a uIq = new a((byte) 0);
    private final a.AbstractC1209a uIo;

    static {
        AppMethodBeat.i(166308);
        AppMethodBeat.o(166308);
    }

    public /* synthetic */ f() {
        this(null);
    }

    public f(a.AbstractC1209a aVar) {
        this.uIo = aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion;", "", "()V", "TAG", "", "OnCdnDownloadCallback", "plugin-finder_release"})
    public static final class a {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "", "onFinish", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "tmpFilePath", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.loader.f$a$a  reason: collision with other inner class name */
        public interface AbstractC1209a {
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.loader.d.b
    public final void a(com.tencent.mm.loader.h.a.a<o> aVar, g gVar, b.AbstractC0401b bVar) {
        String str;
        AppMethodBeat.i(166305);
        p.h(aVar, "item");
        p.h(gVar, "fileNameCreator");
        p.h(bVar, "callback");
        o value = aVar.value();
        if (value.djU() == x.FULL_IMAGE) {
            str = value.getUrl() + value.djW();
            Log.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + value.djU() + ' ' + value.djW() + " uniqueValue=" + value.auA() + ' ' + str);
        } else {
            str = value.aBE() + value.djX();
            Log.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + value.djU() + ' ' + value.djX() + " uniqueValue=" + value.auA() + ' ' + str);
        }
        ae aeVar = ae.SYK;
        p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        String format = String.format(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s", Arrays.copyOf(new Object[]{Integer.valueOf(d.KyO), com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(NetStatusUtil.getStrength(MMApplicationContext.getContext())), ""}, 5));
        p.g(format, "java.lang.String.format(format, *args)");
        e eVar = new e();
        eVar.taskName = "task_FinderCdnDownloader";
        al alVar = al.waC;
        p.g(value, "data");
        String a2 = al.a(value);
        s.deleteFile(a2);
        s.boN(new o(a2).getParent());
        if (a(value, str, a2, eVar, format)) {
            eVar.gqy = new b(value, bVar, a2);
            if (com.tencent.mm.an.f.baQ().e(eVar)) {
                Log.i("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask suc");
                AppMethodBeat.o(166305);
                return;
            }
            Log.w("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask failed");
            bVar.onError();
            AppMethodBeat.o(166305);
            return;
        }
        Log.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo failed");
        bVar.onError();
        AppMethodBeat.o(166305);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/loader/FinderCdnDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
    public static final class b implements g.a {
        final /* synthetic */ o uIr;
        final /* synthetic */ b.AbstractC0401b uIs;
        final /* synthetic */ String uIt;

        b(o oVar, b.AbstractC0401b bVar, String str) {
            this.uIr = oVar;
            this.uIs = bVar;
            this.uIt = str;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
            AppMethodBeat.i(166302);
            p.h(str, "mediaId");
            Log.i("Finder.FinderCdnDownloader", "mediaId " + str + " startRet " + i2 + " sceneResult " + dVar + " onlyCheckExist " + z + " retCode " + (dVar != null ? Integer.valueOf(dVar.field_retCode) : ""));
            if (dVar == null) {
                if (i2 != 0) {
                    this.uIs.onError();
                }
                AppMethodBeat.o(166302);
            } else if (this.uIr == null) {
                AppMethodBeat.o(166302);
            } else {
                if (dVar.field_retCode != 0) {
                    this.uIs.onError();
                } else {
                    b.AbstractC0401b bVar = this.uIs;
                    com.tencent.mm.loader.h.a az = com.tencent.mm.loader.h.a.az(this.uIt, "");
                    p.g(az, "HttpFileResponse.create(tmpFilePath, \"\")");
                    bVar.a(az);
                }
                AppMethodBeat.o(166302);
            }
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(166303);
            p.h(str, "mediaId");
            p.h(byteArrayOutputStream, "buff");
            AppMethodBeat.o(166303);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            AppMethodBeat.i(166304);
            p.h(str, "mediaId");
            p.h(bArr, "inbuf");
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(166304);
            return bArr2;
        }
    }

    private static boolean a(o oVar, String str, String str2, e eVar, String str3) {
        AppMethodBeat.i(166306);
        try {
            String host = new URL(str).getHost();
            ArrayList arrayList = new ArrayList();
            int a2 = com.tencent.mm.network.d.a(host, false, arrayList);
            ArrayList arrayList2 = new ArrayList();
            int a3 = com.tencent.mm.network.d.a(host, true, arrayList2);
            eVar.field_mediaId = MD5Util.getMD5String(str);
            eVar.url = str;
            eVar.snsCipherKey = oVar.djV();
            eVar.host = host;
            eVar.referer = str3;
            eVar.gqq = str2;
            eVar.gqr = ef(arrayList);
            eVar.gqs = ef(arrayList2);
            eVar.gqt = a2;
            eVar.gqu = a3;
            eVar.isColdSnsData = false;
            eVar.signalQuality = new StringBuilder().append(NetStatusUtil.getStrength(MMApplicationContext.getContext())).toString();
            eVar.snsScene = "";
            eVar.fuQ = 3;
            eVar.appType = 150;
            eVar.fileType = 20201;
            Log.i("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo decodeKey:%s, imageUrl:%s", oVar.djV(), str);
            AppMethodBeat.o(166306);
            return true;
        } catch (MalformedURLException e2) {
            Log.printErrStackTrace("Finder.FinderCdnDownloader", e2, "", new Object[0]);
            Log.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo fail:".concat(String.valueOf(e2)));
            AppMethodBeat.o(166306);
            return false;
        }
    }

    private static String[] ef(List<String> list) {
        AppMethodBeat.i(166307);
        String[] strArr = new String[list.size()];
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = list.get(i2);
        }
        AppMethodBeat.o(166307);
        return strArr;
    }
}

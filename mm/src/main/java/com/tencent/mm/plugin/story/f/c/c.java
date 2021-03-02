package com.tencent.mm.plugin.story.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.an.f;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.d.b;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0002J%\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0011J,\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ&\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/story/model/download/StoryDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "attachSnsImgTaskInfo", "", "story", "tmpFilePath", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "idDcIp", "scene", "Lcom/tencent/mm/storage/FROM_SCENE;", "url", "configTime", "", "hostname", "loadDataImp", "", "data", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-story_release"})
public final class c extends com.tencent.mm.loader.d.b<d> {
    public static final a FoB = new a((byte) 0);
    private static final String TAG = TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/model/download/StoryDownloader$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(118901);
        AppMethodBeat.o(118901);
    }

    @Override // com.tencent.mm.loader.d.b
    public final void a(com.tencent.mm.loader.h.a.a<d> aVar, g gVar, b.AbstractC0401b bVar) {
        String sb;
        AppMethodBeat.i(118898);
        p.h(aVar, "data");
        p.h(gVar, "fileNameCreator");
        p.h(bVar, "callback");
        d value = aVar.value();
        ae aeVar = ae.SYK;
        j.b bVar2 = j.Fmy;
        p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        String format = String.format(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s", Arrays.copyOf(new Object[]{Integer.valueOf(d.KyO), com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(NetStatusUtil.getStrength(MMApplicationContext.getContext())), ""}, 5));
        p.g(format, "java.lang.String.format(format, *args)");
        e eVar = new e();
        eVar.taskName = "task_StoryDownloader";
        Log.i(TAG, "loadDataImp " + aVar.value() + " story " + value.FoD.Url);
        StringBuilder sb2 = new StringBuilder();
        com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.FmK;
        String str = aVar.value().FoD.Url;
        String str2 = aVar.value().username;
        if (str == null) {
            sb = "";
        } else {
            byte[] bytes = str.getBytes(kotlin.n.d.UTF_8);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            sb = new StringBuilder().append(com.tencent.mm.plugin.story.f.l.jF(com.tencent.mm.plugin.story.f.l.aRU(str2) + "pic/", com.tencent.mm.b.g.getMessageDigest(bytes))).append(".d").toString();
        }
        String sb3 = sb2.append(sb).append(gVar.d(aVar)).toString();
        p.g(value, "story");
        if (a(value, sb3, eVar, format)) {
            eVar.gqy = new b(value, bVar, sb3);
            if (f.baQ().e(eVar)) {
                Log.i(TAG, "SubCoreCdnTransport addRecvTask suc");
                AppMethodBeat.o(118898);
                return;
            }
            Log.w(TAG, "SubCoreCdnTransport addRecvTask failed");
            bVar.onError();
            AppMethodBeat.o(118898);
            return;
        }
        Log.w(TAG, "attachSnsImgTaskInfo failed");
        bVar.onError();
        AppMethodBeat.o(118898);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/story/model/download/StoryDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
    public static final class b implements g.a {
        final /* synthetic */ d FoC;
        final /* synthetic */ b.AbstractC0401b uIs;
        final /* synthetic */ String uIt;

        b(d dVar, b.AbstractC0401b bVar, String str) {
            this.FoC = dVar;
            this.uIs = bVar;
            this.uIt = str;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
            AppMethodBeat.i(118895);
            p.h(str, "mediaId");
            Log.i(c.TAG, "mediaId " + str + " startRet " + i2 + " sceneResult " + dVar + " onlyCheckExist " + z);
            if (dVar != null) {
                if (this.FoC == null) {
                    AppMethodBeat.o(118895);
                    return 0;
                }
                b.AbstractC0401b bVar = this.uIs;
                com.tencent.mm.loader.h.a az = com.tencent.mm.loader.h.a.az(this.uIt, "");
                p.g(az, "HttpFileResponse.create(tmpFilePath, \"\")");
                bVar.a(az);
            }
            AppMethodBeat.o(118895);
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(118896);
            p.h(str, "mediaId");
            p.h(byteArrayOutputStream, "buff");
            AppMethodBeat.o(118896);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            AppMethodBeat.i(118897);
            p.h(str, "mediaId");
            p.h(bArr, "inbuf");
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(118897);
            return bArr2;
        }
    }

    private static String[] ef(List<String> list) {
        AppMethodBeat.i(118900);
        String[] strArr = new String[list.size()];
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = list.get(i2);
        }
        AppMethodBeat.o(118900);
        return strArr;
    }

    private static boolean a(d dVar, String str, e eVar, String str2) {
        AppMethodBeat.i(118899);
        try {
            edt edt = dVar.FoD;
            String host = new URL(edt.Msz).getHost();
            ArrayList arrayList = new ArrayList();
            int a2 = com.tencent.mm.network.d.a(host, false, arrayList);
            ArrayList arrayList2 = new ArrayList();
            int a3 = com.tencent.mm.network.d.a(host, true, arrayList2);
            eVar.field_mediaId = edt.Id + "_";
            eVar.url = edt.Msz;
            eVar.host = host;
            eVar.referer = str2;
            eVar.gqq = str;
            eVar.gqr = ef(arrayList);
            eVar.gqs = ef(arrayList2);
            eVar.gqt = a2;
            eVar.gqu = a3;
            eVar.isColdSnsData = false;
            eVar.signalQuality = new StringBuilder().append(NetStatusUtil.getStrength(MMApplicationContext.getContext())).toString();
            eVar.snsScene = "";
            eVar.snsCipherKey = dVar.FoD.MsR;
            eVar.fuQ = 3;
            eVar.appType = 100;
            eVar.fileType = 20201;
            Log.i(TAG, "attachSnsImgTaskInfo reqDownType:%s", eVar);
            AppMethodBeat.o(118899);
            return true;
        } catch (MalformedURLException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            Log.w(TAG, "attachSnsImgTaskInfo fail:".concat(String.valueOf(e2)));
            AppMethodBeat.o(118899);
            return false;
        }
    }
}

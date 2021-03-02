package com.tencent.mm.plugin.festival.model;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.b;
import com.tencent.mm.av.a.c.c;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.festival.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalStrangerAvatarLoader;", "Lcom/tencent/mm/modelimage/loader/listener/IImageDownload;", "()V", "downloadSync", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/festival/util/FestivalHttpsDownloadRequest;", "getImageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "url", "", "Companion", "plugin-festival_release"})
public final class w implements c {
    public static final a UyW = new a((byte) 0);

    static {
        AppMethodBeat.i(263066);
        AppMethodBeat.o(263066);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "errCode", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ i UyX;
        final /* synthetic */ CountDownLatch mVf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(i iVar, CountDownLatch countDownLatch) {
            super(1);
            this.UyX = iVar;
            this.mVf = countDownLatch;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(263063);
            int intValue = num.intValue();
            this.UyX.value = (T) Integer.valueOf(intValue);
            this.mVf.countDown();
            x xVar = x.SXb;
            AppMethodBeat.o(263063);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalStrangerAvatarLoader$Companion;", "", "()V", "TAG", "", "createImageLoader", "Lcom/tencent/mm/modelimage/loader/ImageLoader;", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.av.a.c.c
    public final com.tencent.mm.av.a.d.b OV(String str) {
        com.tencent.mm.av.a.d.b bVar;
        AppMethodBeat.i(263064);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            com.tencent.mm.av.a.d.b bVar2 = new com.tencent.mm.av.a.d.b(null, null);
            bVar2.status = 1;
            bVar2.from = 2;
            AppMethodBeat.o(263064);
            return bVar2;
        }
        x xVar = x.UyY;
        o bxw = x.bxw(str);
        if (a(new d(com.tencent.mm.plugin.festival.c.c.Avatar, str, bxw.getAbsolutePath())) == 0) {
            bVar = new com.tencent.mm.av.a.d.b(s.aW(bxw.getAbsolutePath(), 0, (int) bxw.length()), null);
            bVar.status = 0;
            bVar.from = 2;
        } else {
            bVar = new com.tencent.mm.av.a.d.b(null, null);
            bVar.status = 1;
            bVar.from = 2;
        }
        Log.d("MicroMsg.FestivalStrangerAvatarLoader", "getImageData(" + str + "), Response(status:" + bVar.status + ", from:" + bVar.from + ')');
        AppMethodBeat.o(263064);
        return bVar;
    }

    private static int a(d dVar) {
        AppMethodBeat.i(263065);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        i iVar = new i();
        com.tencent.mm.plugin.festival.c.b bVar = com.tencent.mm.plugin.festival.c.b.UGa;
        com.tencent.mm.plugin.festival.c.b.a(dVar, new b(iVar, countDownLatch));
        if (iVar.value != null) {
            T t = iVar.value;
            if (t == null) {
                p.hyc();
            }
            int intValue = t.intValue();
            AppMethodBeat.o(263065);
            return intValue;
        }
        try {
            countDownLatch.await(dVar.UGj + dVar.UGk, TimeUnit.SECONDS);
            T t2 = iVar.value;
            if (t2 == null) {
                p.hyc();
            }
            int intValue2 = t2.intValue();
            AppMethodBeat.o(263065);
            return intValue2;
        } catch (Exception e2) {
            Log.e("MicroMsg.FestivalStrangerAvatarLoader", "downloadSync with " + dVar.hSt() + ", await semaphore get exception:" + e2);
            AppMethodBeat.o(263065);
            return -1;
        }
    }

    public static final com.tencent.mm.av.a.a hRA() {
        AppMethodBeat.i(263067);
        com.tencent.mm.av.a.a aVar = new com.tencent.mm.av.a.a(new b.a(MMApplicationContext.getContext()).b(new w()).a(x.UyY).bdd());
        AppMethodBeat.o(263067);
        return aVar;
    }
}

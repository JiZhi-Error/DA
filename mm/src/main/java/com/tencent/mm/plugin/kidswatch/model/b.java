package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0002J\"\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader;", "", "imgPath", "", "iImgUploadCallback", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader$IImgUploadCallback;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader$IImgUploadCallback;)V", "cdnCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "mediaId", "st_new", "", "checkStringValid", "str", "genClientId", "prefix", "createTime", "suffix", "startUpload", "", "Companion", "IImgUploadCallback", "plugin-kidswatch_release"})
public final class b {
    public static int jSm = com.tencent.mm.i.a.MediaType_FILE;
    public static final a yAC = new a((byte) 0);
    public final String dRr;
    public final g.a iZc;
    private long jSo = System.currentTimeMillis();
    public final String mediaId;
    private final AbstractC1453b yAB;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader$IImgUploadCallback;", "", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "fileID", "aesKey", "plugin-kidswatch_release"})
    /* renamed from: com.tencent.mm.plugin.kidswatch.model.b$b  reason: collision with other inner class name */
    public interface AbstractC1453b {
        void aCF(String str);

        void ds(String str, String str2);
    }

    public b(String str, AbstractC1453b bVar) {
        p.h(str, "imgPath");
        p.h(bVar, "iImgUploadCallback");
        AppMethodBeat.i(256180);
        this.iZc = new c(this, bVar);
        this.dRr = str;
        this.yAB = bVar;
        String g2 = g("kidsupload", Util.nowMilliSecond(), String.valueOf(new Random().nextInt()));
        this.mediaId = g2 == null ? "" : g2;
        Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "KidsWatchHeadImageUploader imgPath:%s mediaId:%s", str, this.mediaId);
        AppMethodBeat.o(256180);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-kidswatch_release"})
    public static final class c implements g.a {
        final /* synthetic */ b yAD;
        final /* synthetic */ AbstractC1453b yAE;

        c(b bVar, AbstractC1453b bVar2) {
            this.yAD = bVar;
            this.yAE = bVar2;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
            AppMethodBeat.i(256176);
            p.h(str, "mediaId");
            if (i2 == -21005) {
                Log.d("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                AppMethodBeat.o(256176);
                return 0;
            } else if (dVar != null && dVar.field_retCode == 0) {
                Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], aesKey:" + dVar.field_aesKey, str, Integer.valueOf(i2), cVar, dVar);
                AbstractC1453b bVar = this.yAE;
                String str2 = dVar.field_fileId;
                p.g(str2, "sceneResult.field_fileId");
                String str3 = dVar.field_aesKey;
                p.g(str3, "sceneResult.field_aesKey");
                bVar.ds(str2, str3);
                Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "uploadsns cdndone pass: " + (System.currentTimeMillis() - this.yAD.jSo) + " " + dVar.field_filemd5);
                a aVar = b.yAC;
                new y(com.tencent.mm.plugin.report.a.t(0, 1, Long.valueOf(this.yAD.jSo), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(b.jSm), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                AppMethodBeat.o(256176);
                return 0;
            } else if (dVar != null && dVar.field_retCode != 0) {
                Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                a aVar2 = b.yAC;
                String t = com.tencent.mm.plugin.report.a.t(Integer.valueOf(dVar.field_retCode), 1, Long.valueOf(this.yAD.jSo), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(b.jSm), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk);
                new y(t).bfK();
                new w(t).bfK();
                this.yAE.aCF("doScene failed");
                AppMethodBeat.o(256176);
                return 0;
            } else if (i2 != 0) {
                Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                if (dVar != null) {
                    a aVar3 = b.yAC;
                    new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i2), 1, Long.valueOf(this.yAD.jSo), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(b.jSm), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                }
                this.yAE.aCF("doScene failed");
                AppMethodBeat.o(256176);
                return 0;
            } else {
                Log.d("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                AppMethodBeat.o(256176);
                return 0;
            }
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(256177);
            p.h(str, "mediaId");
            p.h(byteArrayOutputStream, "buff");
            AppMethodBeat.o(256177);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            AppMethodBeat.i(256178);
            p.h(str, "mediaId");
            p.h(bArr, "inbuf");
            AppMethodBeat.o(256178);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader$Companion;", "", "()V", "FILE_TYPE", "", "getFILE_TYPE", "()I", "setFILE_TYPE", "(I)V", "TAG", "", "plugin-kidswatch_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(256181);
        AppMethodBeat.o(256181);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String g(java.lang.String r9, long r10, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 272
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.kidswatch.model.b.g(java.lang.String, long, java.lang.String):java.lang.String");
    }
}

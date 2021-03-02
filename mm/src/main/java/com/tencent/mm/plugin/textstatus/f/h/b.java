package com.tencent.mm.plugin.textstatus.f.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\"\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader;", "", "()V", "TAG", "", "uploadFileToCDN", "", "mediaType", "", "filePath", "thumbPath", "uploadCallback", "Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$TextStatusUploadCallback;", "uploadImage", "cdnCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "uploadVideo", "TextStatusUploadCallback", "plugin-textstatus_release"})
public final class b {
    public static final b FZU = new b();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$TextStatusUploadCallback;", "", "onUploadEnd", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "isOk", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-textstatus_release"})
    public interface a {
        void a(int i2, boolean z, d dVar);
    }

    static {
        AppMethodBeat.i(216307);
        AppMethodBeat.o(216307);
    }

    private b() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$uploadFileToCDN$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-textstatus_release"})
    /* renamed from: com.tencent.mm.plugin.textstatus.f.h.b$b  reason: collision with other inner class name */
    public static final class C1823b implements g.a {
        final /* synthetic */ a FZV;

        C1823b(a aVar) {
            this.FZV = aVar;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(216304);
            p.h(str, "mediaId");
            if (i2 == -21005) {
                Log.d("MicroMsg.TxtStatus.TextStatusUploader", "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                AppMethodBeat.o(216304);
            } else if (dVar != null && dVar.field_retCode == 0) {
                Log.i("MicroMsg.TxtStatus.TextStatusUploader", "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                this.FZV.a(0, true, dVar);
                AppMethodBeat.o(216304);
            } else if (dVar != null && dVar.field_retCode != 0) {
                Log.i("MicroMsg.TxtStatus.TextStatusUploader", "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                this.FZV.a(dVar.field_retCode, false, dVar);
                AppMethodBeat.o(216304);
            } else if (i2 != 0) {
                Log.i("MicroMsg.TxtStatus.TextStatusUploader", "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                this.FZV.a(i2, false, dVar);
                AppMethodBeat.o(216304);
            } else {
                Log.d("MicroMsg.TxtStatus.TextStatusUploader", "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                AppMethodBeat.o(216304);
            }
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(216305);
            p.h(str, "mediaId");
            p.h(byteArrayOutputStream, "buff");
            AppMethodBeat.o(216305);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            AppMethodBeat.i(216306);
            p.h(str, "mediaId");
            p.h(bArr, "inbuf");
            AppMethodBeat.o(216306);
            return null;
        }
    }
}

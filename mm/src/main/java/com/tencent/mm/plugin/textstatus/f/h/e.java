package com.tencent.mm.plugin.textstatus.f.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.textstatus.f.h.b;
import com.tencent.mm.plugin.textstatus.g.g;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/upload/UploadTask;", "", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;)V", "doUpload", "", "Companion", "plugin-textstatus_release"})
public final class e {
    public static final a Gac = new a((byte) 0);
    final v FYQ;

    static {
        AppMethodBeat.i(216328);
        AppMethodBeat.o(216328);
    }

    public e(v vVar) {
        p.h(vVar, "postInfo");
        AppMethodBeat.i(216327);
        this.FYQ = vVar;
        AppMethodBeat.o(216327);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/upload/UploadTask$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/textstatus/model/upload/UploadTask$doUpload$uploadCallback$1", "Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$TextStatusUploadCallback;", "onUploadEnd", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "isOk", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-textstatus_release"})
    public static final class b implements b.a {
        final /* synthetic */ e Gad;
        final /* synthetic */ long qVz;

        b(e eVar, long j2) {
            this.Gad = eVar;
            this.qVz = j2;
        }

        @Override // com.tencent.mm.plugin.textstatus.f.h.b.a
        public final void a(int i2, boolean z, d dVar) {
            boolean z2;
            boolean z3;
            AppMethodBeat.i(216326);
            StringBuilder append = new StringBuilder("onUploadEnd cost").append(System.currentTimeMillis() - this.qVz).append(".errorCode").append(i2).append(",isOk").append(z).append(",mediaType");
            g gVar = this.Gad.FYQ.GaU;
            Log.i("MicroMsg.TxtStatus.UploadTask", append.append(gVar != null ? Integer.valueOf(gVar.Gat) : null).append(",sceneResult").append(dVar).toString());
            if (z && dVar != null) {
                String str = dVar.field_fileUrl;
                if (str == null || n.aL(str)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    String str2 = dVar.field_thumbUrl;
                    if (str2 == null || n.aL(str2)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        this.Gad.FYQ.GaU.Gav = dVar.field_fileUrl;
                        this.Gad.FYQ.GaU.Gax = dVar.field_thumbUrl;
                        new a(this.Gad.FYQ).fwb();
                        AppMethodBeat.o(216326);
                        return;
                    }
                }
            }
            c cVar = c.FZX;
            v vVar = this.Gad.FYQ;
            p.h(vVar, "postInfo");
            Log.i("MicroMsg.TxtStatus.UploadManager", "makeCdnFail " + vVar.Gba + ' ' + vVar.GaY + ' ' + vVar.GaZ);
            vVar.GaY++;
            c.a(vVar);
            com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
            com.tencent.mm.plugin.textstatus.k.a.c(vVar.VdX, 2L);
            c.dYH();
            AppMethodBeat.o(216326);
        }
    }
}

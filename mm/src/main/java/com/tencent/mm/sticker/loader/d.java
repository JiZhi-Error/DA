package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.b;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.b.a;
import com.tencent.mm.sticker.f;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J$\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00130\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J,\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/sticker/loader/StickerFileIdTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "aesKey", "fileId", "fileSize", "", "netScene", "Lcom/tencent/mm/sticker/net/NetSceneGetLensInfo;", "outputPath", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "zipPath", "call", "", "cancel", "fixBitmap", "path", "foreachFile", "file", "Lcom/tencent/mm/vfs/VFSFile;", "process", "Lkotlin/Function1;", "handleFile", "", "onResult", "success", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "runTask", "uniqueId", "plugin-sticker_release"})
public final class d extends g implements i {
    private final g BPr;
    private a NND;
    private String NNE;
    final String TAG = "MicroMsg.StickerTask";
    private String aesKey;
    private String fileId;
    private int fileSize;
    private final String rpE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(StickerLoadInfo stickerLoadInfo) {
        super(stickerLoadInfo);
        p.h(stickerLoadInfo, "info");
        AppMethodBeat.i(105924);
        this.fileId = stickerLoadInfo.fileId;
        this.aesKey = stickerLoadInfo.aesKey;
        this.fileSize = stickerLoadInfo.kKK;
        e eVar = e.NNN;
        this.rpE = e.biw(stickerLoadInfo.rnS);
        StringBuilder sb = new StringBuilder();
        e eVar2 = e.NNN;
        this.NNE = sb.append(e.gyY()).append(stickerLoadInfo.rnS).toString();
        this.BPr = new g();
        this.BPr.taskName = "task_StickerFileIdTask";
        this.BPr.gqy = new g.a(this) {
            /* class com.tencent.mm.sticker.loader.d.AnonymousClass1 */
            final /* synthetic */ d NNF;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.NNF = r1;
            }

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
                Integer num = null;
                AppMethodBeat.i(105918);
                String str2 = this.NNF.TAG;
                StringBuilder append = new StringBuilder("callback: ").append(str).append(", ").append(i2).append("; progress ").append(cVar != null ? Long.valueOf(cVar.field_toltalLength) : null).append(", ").append(cVar != null ? Long.valueOf(cVar.field_finishedLength) : null).append("; result ");
                if (dVar != null) {
                    num = Integer.valueOf(dVar.field_retCode);
                }
                Log.i(str2, append.append(num).toString());
                if (i2 == 0) {
                    if (dVar != null) {
                        if (dVar.field_retCode == 0 && this.NNF.hYe()) {
                            this.NNF.dQ(true);
                        }
                    }
                    AppMethodBeat.o(105918);
                    return 0;
                }
                this.NNF.dQ(false);
                AppMethodBeat.o(105918);
                return 0;
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                return new byte[0];
            }
        };
        AppMethodBeat.o(105924);
    }

    private final void YC() {
        AppMethodBeat.i(105920);
        if (!(this.fileId.length() == 0)) {
            if (!(this.aesKey.length() == 0)) {
                this.BPr.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
                this.BPr.field_needStorage = true;
                this.BPr.field_mediaId = "lensInfo_" + this.NNU.rnS;
                this.BPr.field_fileId = this.fileId;
                this.BPr.field_aesKey = this.aesKey;
                this.BPr.field_totalLen = this.fileSize;
                this.BPr.field_fullpath = this.NNE;
                f.baQ().e(this.BPr);
                AppMethodBeat.o(105920);
                return;
            }
        }
        dQ(false);
        AppMethodBeat.o(105920);
    }

    /* access modifiers changed from: package-private */
    public final boolean hYe() {
        AppMethodBeat.i(105921);
        s.boN(this.rpE);
        if (s.fW(this.NNE, this.rpE) == 0) {
            s.deleteFile(this.NNE);
            com.tencent.mm.sticker.f fVar = new com.tencent.mm.sticker.f();
            fVar.bip(this.rpE);
            fVar.biq(this.NNU.rnS);
            fVar.bis(this.rpE);
            AppMethodBeat.o(105921);
            return true;
        }
        s.deleteFile(this.NNE);
        s.deleteDir(this.rpE);
        AppMethodBeat.o(105921);
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        bpg bpg;
        String str2;
        String str3;
        int i4;
        cib cib;
        cib cib2;
        cib cib3;
        AppMethodBeat.i(105922);
        if (p.j(qVar, this.NND)) {
            b aAg = com.tencent.mm.kernel.g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().b(3903, this);
            a aVar = this.NND;
            if (aVar != null) {
                com.tencent.mm.bw.a aYK = aVar.rr.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensInfoResponse");
                    AppMethodBeat.o(105922);
                    throw tVar;
                }
                bpg = (bpg) aYK;
            } else {
                bpg = null;
            }
            if (i2 == 0 && i3 == 0 && bpg != null) {
                chz chz = bpg.LXA;
                if (chz == null || (cib3 = chz.Mns) == null || (str2 = cib3.KMl) == null) {
                    str2 = "";
                }
                this.fileId = str2;
                chz chz2 = bpg.LXA;
                if (chz2 == null || (cib2 = chz2.Mns) == null || (str3 = cib2.AesKey) == null) {
                    str3 = "";
                }
                this.aesKey = str3;
                chz chz3 = bpg.LXA;
                if (chz3 == null || (cib = chz3.Mns) == null) {
                    i4 = 0;
                } else {
                    i4 = cib.FileSize;
                }
                this.fileSize = i4;
                YC();
                AppMethodBeat.o(105922);
                return;
            }
            dQ(false);
        }
        AppMethodBeat.o(105922);
    }

    @Override // com.tencent.mm.sticker.loader.g
    public final void dQ(boolean z) {
        AppMethodBeat.i(105923);
        Log.i(this.TAG, "onResult: ".concat(String.valueOf(z)));
        super.dQ(z);
        AppMethodBeat.o(105923);
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        boolean z;
        AppMethodBeat.i(105919);
        if (this.NNU.rnS.length() == 0) {
            Log.w(this.TAG, "call: lensId is " + this.NNU.rnS);
            dQ(false);
            AppMethodBeat.o(105919);
            return;
        }
        f.a aVar = com.tencent.mm.sticker.f.NNw;
        if (f.a.biu(this.rpE)) {
            Log.i(this.TAG, "call: file exists " + this.rpE);
            dQ(true);
            AppMethodBeat.o(105919);
            return;
        }
        if (this.fileId.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (!(this.aesKey.length() == 0)) {
                YC();
                AppMethodBeat.o(105919);
                return;
            }
        }
        this.NND = new a();
        b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3903, this);
        b aAg2 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(this.NND);
        AppMethodBeat.o(105919);
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        return this.NNU.rnS;
    }
}

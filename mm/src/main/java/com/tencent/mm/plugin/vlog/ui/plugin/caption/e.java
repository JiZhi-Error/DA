package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00018B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\u001c\u0010(\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010+\u001a\u00020\u0004J\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#J\b\u0010-\u001a\u00020\u0004H\u0016J>\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010\u00112\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "captionType", "", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "dataOffset", "totalLen", "voiceId", "(ILcom/tencent/mm/protobuf/ByteString;IIILcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCaptionType", "()I", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isLastSeq", "", "()Z", "setLastSeq", "(Z)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSeq", "setSeq", "(I)V", "transRequest", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getVoiceId", "()Lcom/tencent/mm/protobuf/ByteString;", "setVoiceId", "(Lcom/tencent/mm/protobuf/ByteString;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getProgress", "getTransResult", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class e extends q implements m {
    public static final a GLm = new a((byte) 0);
    public final int GKp;
    public ArrayList<sy> GLj = new ArrayList<>();
    public boolean GLk;
    public b GLl;
    private i callback;
    public String filePath = "";
    private d hJu;
    public int jlm;

    static {
        AppMethodBeat.i(191745);
        AppMethodBeat.o(191745);
    }

    public e(int i2, b bVar, int i3, int i4, int i5, b bVar2) {
        AppMethodBeat.i(191744);
        this.GKp = i2;
        this.jlm = i3;
        this.GLl = bVar2;
        d.a aVar = new d.a();
        aVar.c(new sz());
        aVar.d(new ta());
        aVar.MB("/cgi-bin/micromsg-bin/mmccvoicetrans");
        aVar.sG(3835);
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.hJu = aXF;
        com.tencent.mm.bw.a aYJ = this.hJu.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransRequest");
            AppMethodBeat.o(191744);
            throw tVar;
        }
        sz szVar = (sz) aYJ;
        if (this.GLl == null) {
            String str = String.valueOf(System.currentTimeMillis()) + hashCode();
            Charset charset = kotlin.n.d.UTF_8;
            if (str == null) {
                t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(191744);
                throw tVar2;
            }
            byte[] bytes = str.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            this.GLl = new b(bytes);
        }
        szVar.LaW = this.GLl;
        szVar.jlm = this.jlm;
        szVar.LaX = bVar;
        szVar.LaY = i4;
        szVar.LaZ = i5;
        szVar.Lba = 10;
        if (bVar == null) {
            this.GLk = true;
            AppMethodBeat.o(191744);
            return;
        }
        if (bVar.zy.length + i4 >= i5) {
            this.GLk = true;
        }
        AppMethodBeat.o(191744);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void setFilePath(String str) {
        AppMethodBeat.i(191740);
        p.h(str, "<set-?>");
        this.filePath = str;
        AppMethodBeat.o(191740);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3835;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(191741);
        Log.i("MicroMsg.NetSceneGetVideoCaption", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(191741);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(191742);
        Log.i("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        if (!(i3 == 0 && i4 == 0)) {
            Log.e("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd error");
        }
        this.GLj.clear();
        ArrayList<sy> arrayList = this.GLj;
        com.tencent.mm.bw.a aYK = this.hJu.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
            AppMethodBeat.o(191742);
            throw tVar;
        }
        arrayList.addAll(((ta) aYK).Lbb);
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(191742);
            return;
        }
        AppMethodBeat.o(191742);
    }

    public final int getProgress() {
        AppMethodBeat.i(191743);
        com.tencent.mm.bw.a aYK = this.hJu.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
            AppMethodBeat.o(191743);
            throw tVar;
        }
        int i2 = ((ta) aYK).progress;
        AppMethodBeat.o(191743);
        return i2;
    }
}

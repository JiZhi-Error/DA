package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.model.ad;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\r¨\u0006&"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/MpShareVideoPlayUtil;", "", "()V", "TAG", "", "doingMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDoingMap", "()Ljava/util/HashMap;", "mpShareVideoBlock", "getMpShareVideoBlock", "()Ljava/lang/String;", "mpShareVideoErrorMsg", "getMpShareVideoErrorMsg", "mpShareVideoPlayInfo", "getMpShareVideoPlayInfo", "mpShareVideoPlayURL", "getMpShareVideoPlayURL", "mpShareVideoSaveTime", "getMpShareVideoSaveTime", "mpShareVideoSize", "getMpShareVideoSize", "doGetPlayUrlCgi", "mPShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "imgPath", "callBack", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "getPlayUrl", "key", "getPlayUrlInfo", "Lcom/tencent/mm/protocal/protobuf/MpShareVideoPlayUrlInfo;", "setPlayInfo", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetPlayUrlResp;", "app_release"})
public final class m {
    private static final String PBA = PBA;
    static final String PBB = PBB;
    private static final String PBC = PBC;
    private static final String PBD = PBD;
    static final HashMap<String, Boolean> PBE = new HashMap<>();
    public static final m PBF = new m();
    private static final String PBy = PBy;
    private static final String PBz = PBz;
    static final String TAG = TAG;

    static {
        AppMethodBeat.i(39742);
        AppMethodBeat.o(39742);
    }

    private m() {
    }

    public static HashMap<String, Boolean> gTg() {
        return PBE;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", m.PBD, "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    public static final class a implements IPCRunCgi.a {
        final /* synthetic */ String $key;
        final /* synthetic */ z.f PBG;

        a(String str, z.f fVar) {
            this.$key = str;
            this.PBG = fVar;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(final int i2, final int i3, final String str, final d dVar) {
            AppMethodBeat.i(39738);
            m mVar = m.PBF;
            Log.i(m.TAG, "getplayurl errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
            m mVar2 = m.PBF;
            m.gTg().remove(this.$key);
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.ui.chatting.gallery.m.a.AnonymousClass1 */
                final /* synthetic */ a PBH;

                {
                    this.PBH = r1;
                }

                public final void run() {
                    AppMethodBeat.i(39737);
                    IPCRunCgi.a aVar = (IPCRunCgi.a) this.PBH.PBG.SYG.get();
                    if (aVar != null) {
                        aVar.a(i2, i3, str, dVar);
                        AppMethodBeat.o(39737);
                        return;
                    }
                    AppMethodBeat.o(39737);
                }
            });
            AppMethodBeat.o(39738);
        }
    }

    public static String aiK(String str) {
        AppMethodBeat.i(39739);
        p.h(str, "key");
        ad.b G = ad.aVe().G(str, true);
        String string = G.getString(PBz, "");
        if (Math.abs(System.currentTimeMillis() - G.Fk(PBB)) > Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(39739);
            return null;
        }
        AppMethodBeat.o(39739);
        return string;
    }

    public static crj bnb(String str) {
        AppMethodBeat.i(39740);
        p.h(str, "key");
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV(PBy);
        crj crj = new crj();
        crj.Lia = singleMMKV.decodeInt(str + PBA, 0);
        crj.LZv = singleMMKV.decodeInt(str + PBC, 0);
        crj.LZw = singleMMKV.decodeString(str + PBD, "");
        AppMethodBeat.o(39740);
        return crj;
    }

    public static void a(String str, bsr bsr) {
        AppMethodBeat.i(39741);
        p.h(str, "key");
        p.h(bsr, "resp");
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV(PBy);
        singleMMKV.encode(str + PBA, bsr.Lia);
        singleMMKV.encode(str + PBC, bsr.LZv);
        singleMMKV.encode(str + PBD, bsr.LZw);
        ad.b G = ad.aVe().G(str, true);
        G.aK(PBz, bsr.CEI);
        G.y(PBB, System.currentTimeMillis());
        AppMethodBeat.o(39741);
    }
}

package com.tencent.mm.plugin.profile.ui.tab.data;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J$\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010 \u001a\u00020\u001eJ\u0010\u0010!\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\"\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0012\u0010#\u001a\u0004\u0018\u00010\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "Landroid/arch/lifecycle/LifecycleObserver;", "addContactScene", "", "bizUsername", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "(ILjava/lang/String;Lcom/tencent/mm/ui/MMActivity;)V", "bizProfileMsgResp", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "getBizProfileMsgResp", "()Landroid/arch/lifecycle/MutableLiveData;", "bizProfileVideoResp", "getBizProfileVideoResp", "isLoading", "", "isMsgLoading", "isVideoLoading", "profileInfo", "profileInitRespData", "getProfileInitRespData", "createFetchReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "dataType", "pageSize", "offset", "Lcom/tencent/mm/protobuf/ByteString;", "fetchBizInfo", "", "initFetch", "fetchInitPage", "fetchMessageList", "fetchVideoList", "loadCacheProfileInfo", "userName", "Companion", "app_release"})
public final class BizProfileDataFetcher implements LifecycleObserver {
    public static final a BmE = new a((byte) 0);
    private ph BiU = com.tencent.mm.plugin.profile.ui.newbizinfo.a.aKy(this.dVu);
    public final MutableLiveData<ph> BmA = new MutableLiveData<>();
    public final MutableLiveData<ph> BmB = new MutableLiveData<>();
    public boolean BmC;
    public boolean BmD;
    public final MutableLiveData<ph> Bmz = new MutableLiveData<>();
    private final String dVu;
    public final MMActivity gte;
    private boolean isLoading;
    private int kgm;

    static {
        AppMethodBeat.i(230713);
        AppMethodBeat.o(230713);
    }

    public BizProfileDataFetcher(int i2, String str, MMActivity mMActivity) {
        p.h(str, "bizUsername");
        p.h(mMActivity, "context");
        AppMethodBeat.i(230712);
        this.kgm = i2;
        this.dVu = str;
        this.gte = mMActivity;
        AppMethodBeat.o(230712);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher$Companion;", "", "()V", "ACTION_GET_ALL", "", "ACTION_GET_MSG_LIST", "ACTION_GET_VIDEO_LIST", "BLOCK_AVATAR", "BLOCK_BRAND_INFO", "BLOCK_MSG_LIST", "BLOCK_MSG_LIST_LIMIT", "BLOCK_SERVICE_LIST", "BLOCK_SUBSCRIPTION", "BLOCK_VIDEO_LIST", "BLOCK_VIDEO_LIST_LIMIT", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class d implements aa.a {
        final /* synthetic */ BizProfileDataFetcher BmF;

        public d(BizProfileDataFetcher bizProfileDataFetcher) {
            this.BmF = bizProfileDataFetcher;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
            AppMethodBeat.i(230709);
            p.g(dVar, "rr");
            ph phVar = (ph) dVar.aYK();
            if (i2 == 0 && i3 == 0 && phVar != null) {
                MutableLiveData<ph> mutableLiveData = this.BmF.BmA;
                ph phVar2 = new ph();
                phVar2.parseFrom(phVar.toByteArray());
                mutableLiveData.setValue(phVar2);
                this.BmF.BmC = false;
                AppMethodBeat.o(230709);
            } else {
                this.BmF.BmC = false;
                AppMethodBeat.o(230709);
            }
            return 0;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class c implements aa.a {
        final /* synthetic */ BizProfileDataFetcher BmF;

        public c(BizProfileDataFetcher bizProfileDataFetcher) {
            this.BmF = bizProfileDataFetcher;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
            AppMethodBeat.i(230708);
            p.g(dVar, "rr");
            ph phVar = (ph) dVar.aYK();
            if (i2 == 0 && i3 == 0 && phVar != null) {
                MutableLiveData<ph> mutableLiveData = this.BmF.BmB;
                ph phVar2 = new ph();
                phVar2.parseFrom(phVar.toByteArray());
                mutableLiveData.setValue(phVar2);
                this.BmF.BmD = false;
                AppMethodBeat.o(230708);
            } else {
                this.BmF.BmD = false;
                AppMethodBeat.o(230708);
            }
            return 0;
        }
    }

    public final void eFI() {
        AppMethodBeat.i(230711);
        if (this.isLoading) {
            Log.i("MicroMsg.BizProfileDataFetcher", "not obtailBizInfoFromCgi, use cache");
            AppMethodBeat.o(230711);
            return;
        }
        this.isLoading = true;
        d.a aVar = new d.a();
        aVar.sG(2656);
        aVar.MB("/cgi-bin/mmbiz-bin/bizattr/bizprofilev2");
        aVar.sI(0);
        aVar.sJ(0);
        pg pgVar = new pg();
        pgVar.KSV = this.dVu;
        pgVar.KWb = 0;
        pgVar.KWc = 5;
        pgVar.Scene = this.kgm;
        pgVar.KWd = ab.getSessionId();
        aVar.c(pgVar);
        aVar.d(new ph());
        aa.a(aVar.aXF(), new b(this, true), false, this.gte);
        AppMethodBeat.o(230711);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class b implements aa.a {
        final /* synthetic */ BizProfileDataFetcher BmF;
        final /* synthetic */ boolean BmG = true;

        b(BizProfileDataFetcher bizProfileDataFetcher, boolean z) {
            this.BmF = bizProfileDataFetcher;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
            AppMethodBeat.i(230707);
            Log.i("MicroMsg.BizProfileDataFetcher", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            p.g(dVar, "rr");
            ph phVar = (ph) dVar.aYK();
            if (i2 == 0 && i3 == 0 && phVar != null) {
                com.tencent.mm.plugin.profile.ui.newbizinfo.a aVar = com.tencent.mm.plugin.profile.ui.newbizinfo.a.BjZ;
                com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(phVar.KWg);
                if (this.BmG) {
                    try {
                        com.tencent.mm.plugin.profile.ui.newbizinfo.a.b(phVar);
                        this.BmF.Bmz.setValue(phVar);
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.BizProfileDataFetcher", e2, "profileInfo.parseFrom", new Object[0]);
                    }
                } else {
                    MutableLiveData<ph> mutableLiveData = this.BmF.BmA;
                    ph phVar2 = new ph();
                    phVar2.parseFrom(phVar.toByteArray());
                    mutableLiveData.setValue(phVar2);
                }
                this.BmF.isLoading = false;
                AppMethodBeat.o(230707);
            } else {
                AppMethodBeat.o(230707);
            }
            return 0;
        }
    }

    public static /* synthetic */ com.tencent.mm.ak.d a(BizProfileDataFetcher bizProfileDataFetcher, int i2, com.tencent.mm.bw.b bVar) {
        AppMethodBeat.i(230710);
        d.a aVar = new d.a();
        aVar.sG(2656);
        aVar.MB("/cgi-bin/mmbiz-bin/bizattr/bizprofilev2");
        aVar.sI(0);
        aVar.sJ(0);
        pg pgVar = new pg();
        pgVar.KSV = bizProfileDataFetcher.dVu;
        pgVar.KWb = i2;
        pgVar.KVZ = bVar;
        pgVar.KWc = 20;
        pgVar.Scene = bizProfileDataFetcher.kgm;
        pgVar.KWd = ab.getSessionId();
        aVar.c(pgVar);
        aVar.d(new ph());
        com.tencent.mm.ak.d aXF = aVar.aXF();
        p.g(aXF, "CommReqResp.Builder().ap…        }.buildInstance()");
        AppMethodBeat.o(230710);
        return aXF;
    }
}

package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.protocal.protobuf.eem;
import com.tencent.mm.protocal.protobuf.een;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Vector;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u0002022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u00103\u001a\u00020\u0004H\u0016J\b\u00104\u001a\u00020\u000bH\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u000207062\u0006\u00108\u001a\u000209H\u0002J\u0006\u0010:\u001a\u00020\bJ\u0006\u0010;\u001a\u00020\bJ\u0006\u0010<\u001a\u00020\bJ>\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010\u00042\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0012\"\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR\u0010\u0010#\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u000e\u0010,\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010/¨\u0006H"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "mRoomId", "source", "", "(Ljava/lang/String;JZLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMRoomId", "()Ljava/lang/String;", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "requestTime", "getRequestTime", "()I", "setRequestTime", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "sourceType", "getUserName", "setUserName", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getInfo", "getType", "insertList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryUserPageResponse;", "isFavSelectSource", "isFavSource", "isProfileSource", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class i extends q implements m {
    private static final Vector<String> DJt = new Vector<>();
    public static final a FnR = new a((byte) 0);
    private static final String TAG = TAG;
    private String DIL;
    public boolean DIe;
    private long DIf;
    private long DIg;
    private int DIi;
    public long DJB;
    private long FnD;
    private com.tencent.mm.ak.i callback;
    private boolean dJM;
    private final String gwx;
    private d rr;
    public final int source;
    private int sourceType;
    public String userName;
    public int wHW;

    public i(String str, long j2, boolean z, String str2, int i2) {
        int fqH;
        String aSu;
        p.h(str, "userName");
        p.h(str2, "mRoomId");
        AppMethodBeat.i(118841);
        this.userName = str;
        this.DIf = j2;
        this.dJM = z;
        this.gwx = str2;
        this.source = i2;
        this.DIL = "";
        if (this.DIf == 0) {
            Log.i(TAG, "fp mUserName " + this.userName);
        } else {
            Log.i(TAG, "np mUserName " + this.userName);
        }
        if (this.dJM) {
            a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
            fqH = com.tencent.mm.plugin.story.i.a.fqG();
        } else {
            a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
            fqH = com.tencent.mm.plugin.story.i.a.fqH();
        }
        this.sourceType = fqH;
        d.a aVar3 = new d.a();
        aVar3.c(new eem());
        aVar3.d(new een());
        aVar3.MB("/cgi-bin/micromsg-bin/mmstoryuserpage");
        aVar3.sG(273);
        aVar3.sI(400);
        aVar3.sJ(1000000400);
        d aXF = aVar3.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageRequest");
            AppMethodBeat.o(118841);
            throw tVar;
        }
        eem eem = (eem) aYJ;
        eem.UserName = this.userName;
        eem.MZh = this.DIf;
        eem.xub = this.source;
        this.DIe = this.DIf == 0;
        eem.Nau = 0;
        if (n.a((CharSequence) this.gwx, "@", 0, false, 6) > 0) {
            String str3 = this.gwx;
            int a2 = n.a((CharSequence) this.gwx, "@", 0, false, 6);
            if (str3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(118841);
                throw tVar2;
            }
            String substring = str3.substring(0, a2);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            eem.NeG = Util.safeParseLong(substring);
        }
        eem.Nav = 0;
        eem.KGO = this.gwx;
        if (this.DIe) {
            int i3 = this.source;
            a.C1768a aVar4 = com.tencent.mm.plugin.story.i.a.FvD;
            if (i3 == com.tencent.mm.plugin.story.i.a.frj()) {
                j.b bVar = j.Fmy;
                g fod = j.b.fod();
                String str4 = this.userName;
                p.h(str4, "userName");
                aSu = fod.aSt(str4).field_favoriteMd5;
                if (aSu == null) {
                    aSu = "";
                }
            } else {
                j.b bVar2 = j.Fmy;
                aSu = j.b.fod().aSu(this.userName);
            }
            this.DIL = aSu;
            if (this.DIL == null) {
                this.DIL = "";
            }
            eem.MZg = this.DIL;
        }
        this.FnD = this.DIf;
        Log.i(TAG, this + " req.mUserName:" + eem.UserName + " req.MaxId:" + eem.MZh + " req.MinFilterId:" + eem.Nau + " req.LastRequestTime:" + eem.Nav + " ChatRoomName " + this.gwx + " req.FirstPageMd5:" + eem.MZg + " souorce:" + this.source);
        AppMethodBeat.o(118841);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(String str, boolean z, String str2) {
        this(str, 0, z, str2, com.tencent.mm.plugin.story.i.a.frh());
        a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
        AppMethodBeat.i(118842);
        AppMethodBeat.o(118842);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage$Companion;", "", "()V", "TAG", "", "userPageLock", "Ljava/util/Vector;", "addStoryUserReq", "", "muserName", "removeUserReq", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(118843);
        AppMethodBeat.o(118843);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(118839);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(118839);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 273;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0354  */
    @Override // com.tencent.mm.network.m
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onGYNetEnd(int r11, int r12, int r13, java.lang.String r14, com.tencent.mm.network.s r15, byte[] r16) {
        /*
        // Method dump skipped, instructions count: 966
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.f.a.i.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void");
    }

    @Override // com.tencent.mm.ak.q
    public final String getInfo() {
        return this.userName;
    }
}

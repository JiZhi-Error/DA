package com.tencent.mm.plugin.gamelife.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.gamelife.b.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016JU\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2)\u0010\f\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00040\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfoService;", "()V", "getSessionId", "", "selfUsername", "", "talker", "scene", "", IssueStorage.COLUMN_EXT_INFO, "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfoService$SessionIdCallback;", "getSessionIdFromLocal", "getSessionIdFromServer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "sessionId", "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;", "getSessionInfoBySessionId", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "getTalkerFromLocal", "Companion", "plugin-gamelife_release"})
public final class b implements f {
    public static final a ycu = new a((byte) 0);

    static {
        AppMethodBeat.i(241424);
        AppMethodBeat.o(241424);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "sessionId", "", IssueStorage.COLUMN_EXT_INFO, "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.gamelife.j.b$b  reason: collision with other inner class name */
    static final class C1422b extends q implements m<String, com.tencent.mm.plugin.gamelife.b.c, x> {
        final /* synthetic */ String vdJ;
        final /* synthetic */ String yat;
        final /* synthetic */ f.a ycv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1422b(String str, String str2, f.a aVar) {
            super(2);
            this.yat = str;
            this.vdJ = str2;
            this.ycv = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(String str, com.tencent.mm.plugin.gamelife.b.c cVar) {
            AppMethodBeat.i(241419);
            String str2 = str;
            com.tencent.mm.plugin.gamelife.b.c cVar2 = cVar;
            p.h(str2, "sessionId");
            Log.i("GameLife.GameLifeSessionInfoService", "[getSessionId] " + this.yat + " to " + this.vdJ + " => " + str2 + ", from server.");
            if (str2.length() > 0) {
                ((PluginGameLife) g.ah(PluginGameLife.class)).getSessionInfoStorage().a(str2, this.yat, this.vdJ, cVar2);
            }
            this.ycv.onDone(str2);
            x xVar = x.SXb;
            AppMethodBeat.o(241419);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionIdResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ m nzd;

        c(m mVar) {
            this.nzd = mVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            String str;
            AppMethodBeat.i(241420);
            c.a aVar = (c.a) obj;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                m mVar = this.nzd;
                String str2 = ((i) aVar.iLC).session_id;
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                mVar.invoke(str, ((i) aVar.iLC).ybj);
            } else {
                this.nzd.invoke("", null);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(241420);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoService$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0121  */
    @Override // com.tencent.mm.plugin.gamelife.a.f
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r8, java.lang.String r9, int r10, com.tencent.mm.bw.b r11, com.tencent.mm.plugin.gamelife.a.f.a r12) {
        /*
        // Method dump skipped, instructions count: 321
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gamelife.j.b.a(java.lang.String, java.lang.String, int, com.tencent.mm.bw.b, com.tencent.mm.plugin.gamelife.a.f$a):void");
    }

    @Override // com.tencent.mm.plugin.gamelife.a.f
    public final e aAW(String str) {
        AppMethodBeat.i(241422);
        a aBc = ((PluginGameLife) g.ah(PluginGameLife.class)).getSessionInfoStorage().aBc(str);
        AppMethodBeat.o(241422);
        return aBc;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.f
    public final String avi(String str) {
        AppMethodBeat.i(241423);
        String str2 = ((PluginGameLife) g.ah(PluginGameLife.class)).getSessionInfoStorage().aBc(str).field_talker;
        if (str2 == null) {
            str2 = "";
        }
        AppMethodBeat.o(241423);
        return str2;
    }
}

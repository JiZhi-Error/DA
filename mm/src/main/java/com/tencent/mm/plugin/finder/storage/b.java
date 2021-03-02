package com.tencent.mm.plugin.finder.storage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.as;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.arq;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\u001a\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u001a\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderBlockPosterConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "()V", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "canAddList", "", "getCache", "getEmptyTips", "", "getInitData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getItemData", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getLastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "getNetScene", "lastBuff", "getSubTitleStr", "getTitleStrId", "", "needLoadMore", "onAddUserList", "", "nameList", "", "", "onItemDelete", "contact", "callBack", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onSearchBarClick", "context", "Landroid/content/Context;", "Companion", "plugin-finder_release"})
public final class b implements ak {
    public static final a vwr = new a((byte) 0);
    private final g uWD = new g("blockPoster.fp");

    static {
        AppMethodBeat.i(251522);
        AppMethodBeat.o(251522);
    }

    public b() {
        AppMethodBeat.i(251521);
        AppMethodBeat.o(251521);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderBlockPosterConfig$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final int dql() {
        return R.string.cgb;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final CharSequence hUL() {
        AppMethodBeat.i(261366);
        String string = MMApplicationContext.getContext().getString(R.string.d1l);
        p.g(string, "MMApplicationContext.get…d_block_poster_sub_title)");
        String str = string;
        AppMethodBeat.o(261366);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final boolean dqn() {
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final void fq(Context context) {
        AppMethodBeat.i(251514);
        p.h(context, "context");
        Intent intent = new Intent();
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        try {
            intent.putExtra("request_type", 8);
            intent.putExtra("need_history", false);
        } catch (Exception e2) {
        }
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.a(context, (aqw) null, intent);
        AppMethodBeat.o(251514);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/storage/FinderBlockPosterConfig$onItemDelete$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.storage.b$b  reason: collision with other inner class name */
    public static final class C1281b implements ai<ayu> {
        final /* synthetic */ ak.a vws;
        final /* synthetic */ FinderContact vwt;

        C1281b(ak.a aVar, FinderContact finderContact) {
            this.vws = aVar;
            this.vwt = finderContact;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
        @Override // com.tencent.mm.plugin.i.a.ai
        public final /* synthetic */ void a(ayu ayu, apg apg) {
            AppMethodBeat.i(251513);
            ayu ayu2 = ayu;
            p.h(ayu2, "req");
            p.h(apg, "ret");
            ak.a aVar = this.vws;
            if (aVar != null) {
                aVar.nN(apg.retCode == 0);
            }
            if (apg.retCode == 0 && ayu2.opType == 0) {
                c.a aVar2 = c.tsp;
                com.tencent.mm.plugin.finder.api.g asG = c.a.asG(this.vwt.username);
                if (asG != null) {
                    asG.field_extFlag &= -16385;
                    c.a aVar3 = c.tsp;
                    c.a.c(asG);
                    AppMethodBeat.o(251513);
                    return;
                }
            }
            AppMethodBeat.o(251513);
        }
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final void a(FinderContact finderContact, ak.a aVar) {
        AppMethodBeat.i(251515);
        p.h(finderContact, "contact");
        String str = finderContact.username;
        if (str != null) {
            p.g(str, LocaleUtil.ITALIAN);
            ((r) com.tencent.mm.kernel.g.af(r.class)).a(str, false, new C1281b(aVar, finderContact));
            AppMethodBeat.o(251515);
            return;
        }
        AppMethodBeat.o(251515);
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final q c(com.tencent.mm.bw.b bVar) {
        AppMethodBeat.i(251516);
        as asVar = new as(bVar);
        AppMethodBeat.o(251516);
        return asVar;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final com.tencent.mm.bw.b i(q qVar) {
        AppMethodBeat.i(251517);
        if (qVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneBlockPosterList");
            AppMethodBeat.o(251517);
            throw tVar;
        }
        arq cYd = ((as) qVar).cYd();
        if (cYd != null) {
            com.tencent.mm.bw.b bVar = cYd.lastBuffer;
            AppMethodBeat.o(251517);
            return bVar;
        }
        AppMethodBeat.o(251517);
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final LinkedList<FinderContact> j(q qVar) {
        AppMethodBeat.i(251518);
        if (qVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneBlockPosterList");
            AppMethodBeat.o(251518);
            throw tVar;
        }
        arq cYd = ((as) qVar).cYd();
        if (cYd != null) {
            LinkedList<FinderContact> linkedList = cYd.LCI;
            AppMethodBeat.o(251518);
            return linkedList;
        }
        AppMethodBeat.o(251518);
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final g dqo() {
        return this.uWD;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final LinkedList<FinderContact> dqp() {
        AppMethodBeat.i(251519);
        LinkedList<FinderContact> blq = this.uWD.blq();
        AppMethodBeat.o(251519);
        return blq;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final void es(List<String> list) {
        AppMethodBeat.i(251520);
        p.h(list, "nameList");
        AppMethodBeat.o(251520);
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final boolean dqq() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final CharSequence hUM() {
        AppMethodBeat.i(261367);
        String string = MMApplicationContext.getContext().getString(R.string.cim);
        p.g(string, "MMApplicationContext.get…inder_block_poster_empty)");
        String str = string;
        AppMethodBeat.o(261367);
        return str;
    }
}

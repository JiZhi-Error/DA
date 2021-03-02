package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.finder.cgi.br;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016J\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u001a\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0004H\u0002¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderNotSeeMyListConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "()V", "canAddList", "", "getCache", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "getEmptyTips", "", "getInitData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getItemData", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getLastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "getNetScene", "lastBuff", "getSubTitle", "getSubTitleStr", "getTitleStrId", "", "needLoadMore", "onAddUserList", "", "nameList", "", "", "onItemDelete", "contact", "callBack", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onSearchBarClick", "context", "Landroid/content/Context;", "setContactFlag", "userName", "setFlag", "Companion", "plugin-finder_release"})
public final class ae implements ak {
    public static final a vEW = new a((byte) 0);

    static {
        AppMethodBeat.i(251848);
        AppMethodBeat.o(251848);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "detailSuffix", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context) {
            super(1);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(261396);
            p.h(str, "detailSuffix");
            Intent intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4L);
            intent.putExtra("k_sns_from_settings_about_sns", 1);
            com.tencent.mm.br.c.b(this.$context, "sns", ".ui.SnsBlackDetailUI", intent);
            x xVar = x.SXb;
            AppMethodBeat.o(261396);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderNotSeeMyListConfig$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void avx(String str) {
        AppMethodBeat.i(251849);
        bu(str, false);
        AppMethodBeat.o(251849);
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final int dql() {
        return R.string.d3p;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final CharSequence hUL() {
        AppMethodBeat.i(261397);
        CharSequence hVl = hVl();
        AppMethodBeat.o(261397);
        return hVl;
    }

    private static CharSequence hVl() {
        AppMethodBeat.i(261398);
        Context context = MMApplicationContext.getContext();
        String string = context.getString(R.string.jcu);
        p.g(string, "context.getString(R.stri….finder_not_see_mine_sns)");
        String string2 = context.getString(R.string.j__, string);
        p.g(string2, "context.getString(R.stri…_like_feed, subTitleLink)");
        SpannableString spannableString = new SpannableString(string2);
        p.g(context, "context");
        spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(string, context.getResources().getColor(R.color.Link_80), context.getResources().getColor(R.color.ac_), false, false, new d(context)), 0, string.length(), 17);
        SpannableString spannableString2 = spannableString;
        AppMethodBeat.o(261398);
        return spannableString2;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final boolean dqn() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final void fq(Context context) {
        AppMethodBeat.i(251842);
        p.h(context, "context");
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.aE(context, "@finder.block.my.liked.android");
        AppMethodBeat.o(251842);
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final void a(FinderContact finderContact, ak.a aVar) {
        AppMethodBeat.i(251843);
        p.h(finderContact, "contact");
        LinkedList linkedList = new LinkedList();
        Log.d("FinderNotSeeMyListConfig", "deleted user:" + finderContact.username);
        String str = finderContact.username;
        if (str != null) {
            linkedList.add(str);
        }
        int i2 = h.aqJ().getInt("MMBatchModContactTypeMaxNumForServer", 30);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3990, new c(aVar));
        g.azz().b(new com.tencent.mm.modelmulti.c(linkedList, 134217728, 2, i2));
        AppMethodBeat.o(251843);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/storage/FinderNotSeeMyListConfig$onItemDelete$2", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class c implements i {
        final /* synthetic */ ak.a vEV;

        c(ak.a aVar) {
            this.vEV = aVar;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(251841);
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().b(3990, this);
            ak.a aVar = this.vEV;
            if (aVar != null) {
                aVar.nN(i2 == 0 && i3 == 0);
                AppMethodBeat.o(251841);
                return;
            }
            AppMethodBeat.o(251841);
        }
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final com.tencent.mm.ak.q c(com.tencent.mm.bw.b bVar) {
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final com.tencent.mm.bw.b i(com.tencent.mm.ak.q qVar) {
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final LinkedList<FinderContact> j(com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(251844);
        LinkedList<FinderContact> linkedList = new LinkedList<>();
        if (qVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetTagContact");
            AppMethodBeat.o(251844);
            throw tVar;
        }
        LinkedList<bdk> cYF = ((br) qVar).cYF();
        if (cYF != null) {
            Iterator<T> it = cYF.iterator();
            while (it.hasNext()) {
                FinderContact finderContact = it.next().contact;
                if (finderContact != null) {
                    linkedList.add(finderContact);
                }
            }
        }
        AppMethodBeat.o(251844);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final com.tencent.mm.plugin.finder.storage.data.g dqo() {
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final LinkedList<FinderContact> dqp() {
        AppMethodBeat.i(251845);
        LinkedList<FinderContact> linkedList = new LinkedList<>();
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        Cursor d2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().d(null, "", "@finder.block.my.liked.android", "", null);
        StringBuilder sb = new StringBuilder("count = ");
        p.g(d2, "dataCursor");
        Log.i("FinderNotSeeMyListConfig", sb.append(d2.getCount()).toString());
        while (d2.moveToNext()) {
            as asVar = new as();
            asVar.convertFrom(d2);
            FinderContact finderContact = new FinderContact();
            finderContact.username = asVar.getUsername();
            linkedList.add(finderContact);
        }
        AppMethodBeat.o(251845);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final void es(List<String> list) {
        AppMethodBeat.i(251846);
        p.h(list, "nameList");
        LinkedList<String> linkedList = new LinkedList();
        Log.d("FinderNotSeeMyListConfig", "add user:" + list.size());
        linkedList.addAll(list);
        for (String str : linkedList) {
            bu(str, true);
        }
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3990, new b(this, list));
        g.azz().b(new com.tencent.mm.modelmulti.c(linkedList, 134217728, 1, h.aqJ().getInt("MMBatchModContactTypeMaxNumForServer", 30)));
        AppMethodBeat.o(251846);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/storage/FinderNotSeeMyListConfig$onAddUserList$2", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class b implements i {
        final /* synthetic */ List vEU;
        final /* synthetic */ ae vEX;

        b(ae aeVar, List list) {
            this.vEX = aeVar;
            this.vEU = list;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            LinkedList<cpn> linkedList;
            AppMethodBeat.i(251840);
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().b(3990, this);
            if (qVar instanceof com.tencent.mm.modelmulti.c) {
                if (i2 == 0 && i3 == 0) {
                    kx bdI = ((com.tencent.mm.modelmulti.c) qVar).bdI();
                    if (bdI == null || (linkedList = bdI.KOP) == null) {
                        AppMethodBeat.o(251840);
                        return;
                    }
                    Iterator<T> it = linkedList.iterator();
                    while (it.hasNext()) {
                        String str2 = it.next().MvE.UserName;
                        p.g(str2, "it.ModOperation.UserName");
                        ae.avx(str2);
                    }
                    AppMethodBeat.o(251840);
                    return;
                }
                for (String str3 : this.vEU) {
                    ae.avx(str3);
                }
            }
            AppMethodBeat.o(251840);
        }
    }

    private static void bu(String str, boolean z) {
        AppMethodBeat.i(251847);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
        if (Kn != null) {
            if (z) {
                Kn.arl();
            } else {
                Kn.arm();
            }
            com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
            ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().c(Kn.getUsername(), Kn);
            AppMethodBeat.o(251847);
            return;
        }
        AppMethodBeat.o(251847);
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final boolean dqq() {
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak
    public final CharSequence hUM() {
        AppMethodBeat.i(261399);
        CharSequence hVl = hVl();
        AppMethodBeat.o(261399);
        return hVl;
    }
}

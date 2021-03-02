package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.model.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J@\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J \u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\rH\u0016¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "()V", "getCommentDetail", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedId", "", "objectNonceId", "", "getLayoutId", "", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class i extends e<f> {
    private static af tzB;
    public static final a tzC = new a((byte) 0);

    static {
        AppMethodBeat.i(165333);
        AppMethodBeat.o(165333);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ h qhp;
        final /* synthetic */ long txv;

        b(h hVar, long j2) {
            this.qhp = hVar;
            this.txv = j2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            String str;
            String str2 = null;
            AppMethodBeat.i(165329);
            c.a aVar = (c.a) obj;
            if (aVar == null) {
                Log.i("Finder.FeedMsgNotifyConvert", "get feed detail result is null");
                d n = com.tencent.mm.ui.base.h.n(this.qhp.getContext(), R.string.cny, 0);
                AppMethodBeat.o(165329);
                return n;
            }
            if (!(aVar.errType == 0 && aVar.errCode == 0)) {
                y yVar = y.vXH;
                if (!y.gp(aVar.errType, aVar.errCode)) {
                    if (aVar.errCode == -4011) {
                        d n2 = com.tencent.mm.ui.base.h.n(this.qhp.getContext(), R.string.cmw, 0);
                        AppMethodBeat.o(165329);
                        return n2;
                    }
                    if (aVar.errCode == -4033) {
                        d n3 = com.tencent.mm.ui.base.h.n(this.qhp.getContext(), R.string.cny, 0);
                        AppMethodBeat.o(165329);
                        return n3;
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(165329);
                    return xVar;
                }
            }
            FinderObject finderObject = ((ars) aVar.iLC).feedObject;
            if (finderObject != null) {
                Log.i("Finder.FeedMsgNotifyConvert", "get feed detail success");
                c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                if (!c.a.asI(finderObject.username)) {
                    FinderContact finderContact = new FinderContact();
                    FinderContact finderContact2 = finderObject.contact;
                    finderContact.username = finderContact2 != null ? finderContact2.username : null;
                    FinderContact finderContact3 = finderObject.contact;
                    if (finderContact3 != null) {
                        str = finderContact3.nickname;
                    } else {
                        str = null;
                    }
                    finderContact.nickname = str;
                    FinderContact finderContact4 = finderObject.contact;
                    if (finderContact4 != null) {
                        str2 = finderContact4.headUrl;
                    }
                    finderContact.headUrl = str2;
                    c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
                    c.a.b(finderContact);
                }
                e.a aVar4 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                FinderItem.a aVar5 = FinderItem.Companion;
                p.g(finderObject, "newFeed");
                e.a.n(FinderItem.a.a(finderObject, 32));
                Intent intent = new Intent();
                intent.putExtra("feed_object_id", this.txv);
                FinderReporterUIC.a aVar6 = FinderReporterUIC.wzC;
                Context context = this.qhp.getContext();
                p.g(context, "holder.context");
                FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar7 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context2 = this.qhp.getContext();
                p.g(context2, "holder.context");
                com.tencent.mm.plugin.finder.utils.a.I(context2, intent);
                x xVar2 = x.SXb;
                AppMethodBeat.o(165329);
                return xVar2;
            }
            AppMethodBeat.o(165329);
            return null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* bridge */ /* synthetic */ void a(h hVar, f fVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(165332);
        a(hVar, fVar);
        AppMethodBeat.o(165332);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert$Companion;", "", "()V", "TAG", "", "curCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "getCurCgi", "()Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "setCurCgi", "(Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.f3116f;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ i tzD;
        final /* synthetic */ f tzE;

        c(i iVar, f fVar, h hVar) {
            this.tzD = iVar;
            this.tzE = fVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(165330);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.storage.a finderActionStorage = ((PluginFinder) g.ah(PluginFinder.class)).getFinderActionStorage();
            long j2 = this.tzE.feedId;
            Log.i(com.tencent.mm.plugin.finder.storage.a.TAG, "markUnsentCommentsCanRemove ".concat(String.valueOf(j2)));
            for (T t : ((PluginFinder) g.ah(PluginFinder.class)).getFinderActionStorage().Fu(j2)) {
                ((an) t).field_canRemove = 1;
                com.tencent.mm.plugin.finder.storage.a.a(finderActionStorage, ((an) t).field_localCommentId, t);
            }
            this.tzE.uNO = 1;
            i.a(this.qhp, this.tzE.feedId, this.tzE.objectNonceId);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165330);
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(165331);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(165331);
    }

    public final void a(h hVar, f fVar) {
        AppMethodBeat.i(242791);
        p.h(hVar, "holder");
        p.h(fVar, "item");
        if (fVar.uNO == 1) {
            hVar.mf(R.id.fmk, 8);
        } else {
            hVar.mf(R.id.fmk, 0);
        }
        hVar.Mn(R.id.fmk).setOnClickListener(new c(this, fVar, hVar));
        AppMethodBeat.o(242791);
    }

    public static final /* synthetic */ void a(h hVar, long j2, String str) {
        AppMethodBeat.i(165334);
        af afVar = tzB;
        if (afVar != null) {
            afVar.cancel();
        }
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        af afVar2 = new af(j2, str, 5, 2, "", true, null, null, 0, null, false, false, null, fH != null ? fH.dIx() : null, 0, 24512);
        tzB = afVar2;
        afVar2.aYI().b(new b(hVar, j2));
        AppMethodBeat.o(165334);
    }
}

package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.h.c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u0006\u0010\"\u001a\u00020\u000eJ,\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\r2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u001cH\u0016J\u000e\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u001cH\u0002J\u001a\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020\u000eH\u0016J\u0016\u00106\u001a\u00020\u000e2\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0002J\u0006\u0010:\u001a\u00020\u000eR\u0010\u0010\b\u001a\u00020\tXD¢\u0006\u0004\n\u0002\b\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BAN_COMMENT_TIP_TIMEOUT", "", "BAN_COMMENT_TIP_TIMEOUT$1", "banCommentCallback", "Lkotlin/Function1;", "", "", "commentAdapter", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "commentListView", "Landroid/support/v7/widget/RecyclerView;", "enable", "", "isAnchor", "linkMicCallback", "Lkotlin/Function2;", "newTipGroup", "newTipTv", "Landroid/widget/TextView;", "readCount", "", "hideNewCommentTip", "keyboardChange", "show", "height", "mount", "onMsgPosted", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "showNewCommentTip", "count", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateComments", "newDatas", "", "Lcom/tencent/mm/live/view/adapter/CommentData;", "updateMessages", "Companion", "plugin-logic_release"})
public final class m extends a implements i {
    public static final a hPx = new a((byte) 0);
    private boolean dMz;
    private boolean enable;
    private final b hOy;
    private final ViewGroup hPq;
    private final TextView hPr;
    private final RecyclerView hPs;
    private final com.tencent.mm.live.view.a.c hPt = new com.tencent.mm.live.view.a.c();
    private final long hPu = 3000;
    private final kotlin.g.a.b<String, x> hPv = new b(this);
    private final kotlin.g.a.m<Boolean, String, x> hPw = new c(this);
    private int readCount;

    static {
        AppMethodBeat.i(207978);
        AppMethodBeat.o(207978);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "wording", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ m hPy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(m mVar) {
            super(1);
            this.hPy = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            final String str2;
            AppMethodBeat.i(207955);
            final String str3 = str;
            p.h(str3, "wording");
            Log.i("MicroMsg.LiveCommentPlugin", "receive BanCommenrCallback, wording:".concat(String.valueOf(str3)));
            if (!(str3.length() == 0)) {
                int a2 = n.a((CharSequence) str3, "：", 0, false, 6);
                if (a2 > 0) {
                    String substring = str3.substring(0, a2);
                    p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    str3 = str3.substring(a2 + 1, str3.length());
                    p.g(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    str2 = substring;
                } else {
                    str2 = "";
                }
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.live.c.m.b.AnonymousClass1 */
                    final /* synthetic */ b hPz;

                    {
                        this.hPz = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(207954);
                        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                        if (com.tencent.mm.live.b.x.aGr().KNv) {
                            com.tencent.mm.live.view.a.c cVar = this.hPz.hPy.hPt;
                            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                            cVar.aj(com.tencent.mm.live.b.x.aGp());
                            this.hPz.hPy.hPt.notifyDataSetChanged();
                            this.hPz.hPy.hPs.post(new Runnable(this) {
                                /* class com.tencent.mm.live.c.m.b.AnonymousClass1.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass1 hPA;

                                {
                                    this.hPA = r1;
                                }

                                public final void run() {
                                    AppMethodBeat.i(207952);
                                    RecyclerView recyclerView = this.hPA.hPz.hPy.hPs;
                                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(j.mZ(this.hPA.hPz.hPy.hPt.getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
                                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/live/plugin/LiveCommentPlugin$banCommentCallback$1$1$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                                    recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/live/plugin/LiveCommentPlugin$banCommentCallback$1$1$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                                    AppMethodBeat.o(207952);
                                }
                            });
                            Log.i("MicroMsg.LiveCommentPlugin", "notify by true");
                        } else {
                            m.c(this.hPz.hPy);
                            this.hPz.hPy.hPt.aj(new ArrayList());
                            this.hPz.hPy.hPt.notifyDataSetChanged();
                            Log.i("MicroMsg.LiveCommentPlugin", "notify by false");
                        }
                        o.d dVar = o.d.hGL;
                        final com.tencent.mm.live.view.a.a aVar = new com.tencent.mm.live.view.a.a(str2, "", str3, o.d.aFz(), cl.aWB());
                        com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                        com.tencent.mm.live.b.x.aGp().add(aVar);
                        this.hPz.hPy.hPt.a(aVar);
                        Log.i("MicroMsg.LiveCommentPlugin", "appendComment".concat(String.valueOf(aVar)));
                        com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
                        if (!com.tencent.mm.live.b.x.aGr().KNv) {
                            com.tencent.mm.ac.d.a(this.hPz.hPy.hPu, new kotlin.g.a.a<x>(this) {
                                /* class com.tencent.mm.live.c.m.b.AnonymousClass1.AnonymousClass2 */
                                final /* synthetic */ AnonymousClass1 hPA;

                                {
                                    this.hPA = r2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ x invoke() {
                                    AppMethodBeat.i(207953);
                                    com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                                    com.tencent.mm.live.b.x.aGp().remove(aVar);
                                    com.tencent.mm.live.view.a.c cVar = this.hPA.hPz.hPy.hPt;
                                    com.tencent.mm.live.view.a.a aVar = aVar;
                                    p.h(aVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
                                    int indexOf = cVar.hXy.indexOf(aVar);
                                    if (indexOf != -1) {
                                        cVar.hXy.remove(aVar);
                                        cVar.ck(indexOf);
                                    }
                                    Log.i("MicroMsg.LiveCommentPlugin", "removeComment:" + aVar);
                                    x xVar2 = x.SXb;
                                    AppMethodBeat.o(207953);
                                    return xVar2;
                                }
                            });
                        }
                        x xVar5 = x.SXb;
                        AppMethodBeat.o(207954);
                        return xVar5;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(207955);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "linked", "", "callingUser", "", "invoke"})
    static final class c extends q implements kotlin.g.a.m<Boolean, String, x> {
        final /* synthetic */ m hPy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(m mVar) {
            super(2);
            this.hPy = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, String str) {
            final String str2;
            AppMethodBeat.i(207957);
            boolean booleanValue = bool.booleanValue();
            String str3 = str;
            p.h(str3, "callingUser");
            Log.i("MicroMsg.LiveCommentPlugin", "receive linkMicCallback，linked:" + booleanValue + ", callingUser:" + str3);
            if (!Util.isNullOrNil(str3)) {
                Context context = this.hPy.hPs.getContext();
                p.g(context, "commentListView.context");
                final String string = context.getResources().getString(R.string.ejp);
                p.g(string, "commentListView.context.…live_sys_msg_system_name)");
                if (booleanValue) {
                    ae aeVar = ae.SYK;
                    Context context2 = this.hPy.hPs.getContext();
                    p.g(context2, "commentListView.context");
                    String string2 = context2.getResources().getString(R.string.ejo);
                    p.g(string2, "commentListView.context.…ng.live_sys_msg_link_mic)");
                    String format = String.format(string2, Arrays.copyOf(new Object[]{str3}, 1));
                    p.g(format, "java.lang.String.format(format, *args)");
                    str2 = format;
                } else {
                    ae aeVar2 = ae.SYK;
                    Context context3 = this.hPy.hPs.getContext();
                    p.g(context3, "commentListView.context");
                    String string3 = context3.getResources().getString(R.string.ejn);
                    p.g(string3, "commentListView.context.…e_sys_msg_close_link_mic)");
                    String format2 = String.format(string3, Arrays.copyOf(new Object[]{str3}, 1));
                    p.g(format2, "java.lang.String.format(format, *args)");
                    str2 = format2;
                }
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.live.c.m.c.AnonymousClass1 */
                    final /* synthetic */ c hPC;

                    {
                        this.hPC = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(207956);
                        o.d dVar = o.d.hGL;
                        com.tencent.mm.live.view.a.a aVar = new com.tencent.mm.live.view.a.a(string, "", str2, o.d.aFz(), cl.aWB());
                        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                        com.tencent.mm.live.b.x.aGp().add(aVar);
                        this.hPC.hPy.hPt.a(aVar);
                        Log.i("MicroMsg.LiveCommentPlugin", "linkMicMsg：".concat(String.valueOf(aVar)));
                        x xVar2 = x.SXb;
                        AppMethodBeat.o(207956);
                        return xVar2;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(207957);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/live/view/adapter/CommentData;", "invoke"})
    static final class d extends q implements kotlin.g.a.b<com.tencent.mm.live.view.a.a, Boolean> {
        final /* synthetic */ com.tencent.mm.ak.q hvN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(com.tencent.mm.ak.q qVar) {
            super(1);
            this.hvN = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.live.view.a.a aVar) {
            boolean z;
            AppMethodBeat.i(207958);
            com.tencent.mm.live.view.a.a aVar2 = aVar;
            p.h(aVar2, LocaleUtil.ITALIAN);
            if (!Util.isEqual(aVar2.hXr, ((s) this.hvN).content) || !Util.isEqual(aVar2.hXp, z.aTY())) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(207958);
            return valueOf;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(207977);
        this.hOy = bVar;
        View findViewById = viewGroup.findViewById(R.id.ege);
        p.g(findViewById, "root.findViewById(R.id.l…e_comment_list_tip_group)");
        this.hPq = (ViewGroup) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.egf);
        p.g(findViewById2, "root.findViewById(R.id.live_comment_list_tip_tv)");
        this.hPr = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.egd);
        p.g(findViewById3, "root.findViewById(R.id.live_comment_list)");
        this.hPs = (RecyclerView) findViewById3;
        RecyclerView recyclerView = this.hPs;
        viewGroup.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.hPs.setAdapter(this.hPt);
        com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.a(name(), this.hPv);
        com.tencent.mm.live.b.m mVar2 = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.a(name(), this.hPw);
        this.hPq.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.m.AnonymousClass1 */
            final /* synthetic */ m hPy;

            {
                this.hPy = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207948);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m.c(this.hPy);
                RecyclerView recyclerView = this.hPy.hPs;
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(com.tencent.mm.live.b.x.aGp().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207948);
            }
        });
        this.hPs.a(new RecyclerView.l(this) {
            /* class com.tencent.mm.live.c.m.AnonymousClass2 */
            final /* synthetic */ m hPy;

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(207950);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(207950);
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.hPy = r1;
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(207949);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                p.h(recyclerView, "recyclerView");
                RecyclerView.LayoutManager layoutManager = this.hPy.hPs.getLayoutManager();
                if (layoutManager == null) {
                    t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.o(207949);
                    throw tVar;
                }
                int ku = ((LinearLayoutManager) layoutManager).ku();
                m mVar = this.hPy;
                mVar.readCount = j.mZ(ku, mVar.readCount);
                if (ku == this.hPy.hPt.getItemCount() + -1) {
                    m.c(this.hPy);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommentPlugin$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(207949);
            }
        });
        if (isLandscape()) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(207977);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).width = (au.az(viewGroup.getContext()).x * 35) / 100;
        }
        AppMethodBeat.o(207977);
    }

    public static final /* synthetic */ void c(m mVar) {
        AppMethodBeat.i(207979);
        mVar.aHw();
        AppMethodBeat.o(207979);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveCommentPlugin$Companion;", "", "()V", "BAN_COMMENT_TIP_TIMEOUT", "", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final void aHw() {
        AppMethodBeat.i(207969);
        this.hPq.setVisibility(8);
        AppMethodBeat.o(207969);
    }

    public final void a(LiveConfig liveConfig) {
        AppMethodBeat.i(207970);
        p.h(liveConfig, "config");
        this.dMz = liveConfig.aBC() == LiveConfig.hvT;
        AppMethodBeat.o(207970);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ m hPy;

        h(m mVar) {
            this.hPy = mVar;
        }

        public final void run() {
            AppMethodBeat.i(207968);
            RecyclerView recyclerView = this.hPy.hPs;
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(j.mZ(this.hPy.hPt.getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/live/plugin/LiveCommentPlugin$updateMessages$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(207968);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-logic_release"})
    public static final class g extends c.a {
        final /* synthetic */ List hPD;
        final /* synthetic */ m hPy;

        g(m mVar, List list) {
            this.hPy = mVar;
            this.hPD = list;
        }

        @Override // android.support.v7.h.c.a
        public final int aB() {
            AppMethodBeat.i(207964);
            int size = this.hPy.hPt.hXy.size();
            AppMethodBeat.o(207964);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final int aC() {
            AppMethodBeat.i(207965);
            int size = this.hPD.size();
            AppMethodBeat.o(207965);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final boolean i(int i2, int i3) {
            AppMethodBeat.i(207966);
            boolean j2 = p.j(this.hPy.hPt.hXy.get(i2), (com.tencent.mm.live.view.a.a) this.hPD.get(i3));
            AppMethodBeat.o(207966);
            return j2;
        }

        @Override // android.support.v7.h.c.a
        public final boolean j(int i2, int i3) {
            AppMethodBeat.i(207967);
            boolean j2 = p.j(this.hPy.hPt.hXy.get(i2), (com.tencent.mm.live.view.a.a) this.hPD.get(i3));
            AppMethodBeat.o(207967);
            return j2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/live/plugin/LiveCommentPlugin$updateComments$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-logic_release"})
    public static final class f implements android.support.v7.h.d {
        final /* synthetic */ List hPD;
        final /* synthetic */ m hPy;

        f(m mVar, List list) {
            this.hPy = mVar;
            this.hPD = list;
        }

        @Override // android.support.v7.h.d
        public final void c(int i2, int i3, Object obj) {
            AppMethodBeat.i(207960);
            Log.d("MicroMsg.LiveCommentPlugin", "onChanged position:" + i2 + ", count:" + i3);
            this.hPy.hPt.hXy.clear();
            this.hPy.hPt.hXy.addAll(this.hPD);
            this.hPy.hPt.aq(i2, i3);
            AppMethodBeat.o(207960);
        }

        @Override // android.support.v7.h.d
        public final void l(int i2, int i3) {
            AppMethodBeat.i(207961);
            Log.d("MicroMsg.LiveCommentPlugin", "onMoved fromPosition:" + i2 + ", toPosition:" + i3);
            this.hPy.hPt.ar(i2, i3);
            AppMethodBeat.o(207961);
        }

        @Override // android.support.v7.h.d
        public final void f(int i2, int i3) {
            AppMethodBeat.i(207962);
            Log.d("MicroMsg.LiveCommentPlugin", "onInserted position:" + i2 + ", count:" + i3);
            this.hPy.hPt.hXy.clear();
            this.hPy.hPt.hXy.addAll(this.hPD);
            this.hPy.hPt.as(i2, i3);
            AppMethodBeat.o(207962);
        }

        @Override // android.support.v7.h.d
        public final void k(int i2, int i3) {
            AppMethodBeat.i(207963);
            Log.d("MicroMsg.LiveCommentPlugin", "onRemoved position:" + i2 + ", count:" + i3);
            this.hPy.hPt.hXy.clear();
            this.hPy.hPt.hXy.addAll(this.hPD);
            this.hPy.hPt.at(i2, i3);
            AppMethodBeat.o(207963);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void keyboardChange(boolean z, int i2) {
    }

    @Override // com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(207972);
        super.rg(i2);
        this.hPs.setVisibility(0);
        AppMethodBeat.o(207972);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(207973);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (n.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                rg(8);
                this.enable = false;
                AppMethodBeat.o(207973);
                return;
            case 5:
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.qY(com.tencent.mm.live.b.x.aGQ() + 1);
                aHw();
                RecyclerView recyclerView = this.hPs;
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(com.tencent.mm.live.b.x.aGp().size() - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/live/plugin/LiveCommentPlugin", "onMsgPosted", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                AppMethodBeat.o(207973);
                return;
            case 6:
                rg(0);
                this.enable = true;
                break;
        }
        AppMethodBeat.o(207973);
    }

    @Override // com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(207974);
        super.mount();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(904, this);
        AppMethodBeat.o(207974);
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(207975);
        super.unMount();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(904, this);
        AppMethodBeat.o(207975);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(207976);
        if ((qVar instanceof s) && i2 == 4 && i3 == -100048) {
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            kotlin.a.j.c((List) com.tencent.mm.live.b.x.aGp(), (kotlin.g.a.b) new d(qVar));
            com.tencent.mm.ac.d.h(new e(this));
        }
        AppMethodBeat.o(207976);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0107 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aHx() {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.c.m.aHx():void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ m hPy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(m mVar) {
            super(0);
            this.hPy = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(207959);
            com.tencent.mm.live.view.a.c cVar = this.hPy.hPt;
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            cVar.aj(com.tencent.mm.live.b.x.aGp());
            this.hPy.hPt.notifyDataSetChanged();
            x xVar2 = x.SXb;
            AppMethodBeat.o(207959);
            return xVar2;
        }
    }
}

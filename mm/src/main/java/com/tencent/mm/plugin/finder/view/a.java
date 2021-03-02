package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.utils.ap;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/CommentMenu;", "", "()V", "BottomSheetMenuListener", "Companion", "MenuItemCreateListener", "MenuItemSelectListener", "plugin-finder_release"})
public final class a {
    private static final int wjA = 0;
    private static final int wjB = 1;
    private static final int wjC = 2;
    private static final int wjD = 3;
    private static final int wjE = 999;
    public static final b wjF = new b((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/CommentMenu$Companion;", "", "()V", "MENU_BAN", "", "MENU_COPY", "MENU_DEBUG", "MENU_DEL", "MENU_EXPOSE", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(178469);
        AppMethodBeat.o(178469);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000b¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "isFinderScene", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;Z)V", "getFeedUsername", "()Ljava/lang/String;", "()Z", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
    public static final class c implements View.OnCreateContextMenuListener {
        private final String tug;
        private s wjG;
        private final boolean wjH;

        public c(s sVar, String str, boolean z) {
            p.h(sVar, "commentItem");
            p.h(str, "feedUsername");
            AppMethodBeat.i(168213);
            this.wjG = sVar;
            this.tug = str;
            this.wjH = z;
            AppMethodBeat.o(168213);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0077, code lost:
            if (com.tencent.mm.plugin.finder.utils.y.In(r9.tug) != false) goto L_0x0079;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCreateContextMenu(android.view.ContextMenu r10, android.view.View r11, android.view.ContextMenu.ContextMenuInfo r12) {
            /*
            // Method dump skipped, instructions count: 202
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.view.a.c.onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu$ContextMenuInfo):void");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B:\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\u001a\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016R7\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "exposeScene", "", "commentDelCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;ILkotlin/jvm/functions/Function1;)V", "getCommentDelCallback", "()Lkotlin/jvm/functions/Function1;", "setCommentDelCallback", "(Lkotlin/jvm/functions/Function1;)V", "getCommentItem", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "setCommentItem", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;)V", "getExposeScene", "()I", "setExposeScene", "(I)V", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "plugin-finder_release"})
    public static final class d implements o.g {
        private int tMM;
        private s wjG;
        private kotlin.g.a.b<? super s, x> wjI;

        public d(s sVar, int i2, kotlin.g.a.b<? super s, x> bVar) {
            p.h(sVar, "commentItem");
            AppMethodBeat.i(254618);
            this.wjG = sVar;
            this.tMM = i2;
            this.wjI = bVar;
            AppMethodBeat.o(254618);
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            an anVar;
            AppMethodBeat.i(168215);
            if (menuItem != null) {
                int itemId = menuItem.getItemId();
                if (itemId == a.wjA) {
                    if (!Util.isNullOrNil(this.wjG.uOf.getContent())) {
                        ClipboardHelper.setText(this.wjG.uOf.getContent());
                        Toast.makeText(MMApplicationContext.getContext(), (int) R.string.ta, 0).show();
                        ap apVar = ap.UVg;
                        ap.bc(5, this.wjG.uOf.dyb().commentId);
                        AppMethodBeat.o(168215);
                        return;
                    }
                } else if (itemId == a.wjB) {
                    kotlin.g.a.b<? super s, x> bVar = this.wjI;
                    if (bVar != null) {
                        bVar.invoke(this.wjG);
                    }
                    ap apVar2 = ap.UVg;
                    ap.bc(4, this.wjG.uOf.dyb().commentId);
                    AppMethodBeat.o(168215);
                    return;
                } else if (itemId == a.wjC) {
                    com.tencent.mm.plugin.finder.feed.logic.a aVar = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                    Context context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                    com.tencent.mm.plugin.finder.feed.logic.a.a(context, this.wjG.uOf.field_feedId, this.wjG.uOf.dyb().commentId, this.tMM);
                    ap apVar3 = ap.UVg;
                    ap.bc(6, this.wjG.uOf.dyb().commentId);
                    AppMethodBeat.o(168215);
                    return;
                } else if (itemId == a.wjD) {
                    k kVar = k.vfA;
                    Context context2 = MMApplicationContext.getContext();
                    p.g(context2, "MMApplicationContext.getContext()");
                    k.b(context2, 11, 4);
                    ((t) g.af(t.class)).a(this.wjG.lT(), this.wjG.uOf.field_feedId, this.wjG.uOf.getObjectNonceId(), new C1327a());
                    AppMethodBeat.o(168215);
                    return;
                } else if (itemId == a.wjE) {
                    s sVar = this.wjG;
                    ClipboardHelper.setText((sVar == null || (anVar = sVar.uOf) == null) ? null : anVar.toString());
                }
            }
            AppMethodBeat.o(168215);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.view.a$d$a  reason: collision with other inner class name */
        public static final class C1327a implements ai<ayt> {
            C1327a() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
            @Override // com.tencent.mm.plugin.i.a.ai
            public final /* synthetic */ void a(ayt ayt, apg apg) {
                AppMethodBeat.i(168214);
                p.h(ayt, "req");
                p.h(apg, "ret");
                Context context = MMApplicationContext.getContext();
                if (apg.retCode == 0) {
                    Log.i("Finder.MenuItemCreateListener", "comment black list succ");
                    p.g(context, "context");
                    u.makeText(context, context.getResources().getString(R.string.cyj), 0).show();
                    AppMethodBeat.o(168214);
                    return;
                }
                Log.i("Finder.MenuItemCreateListener", "comment black list failed:" + apg.retCode);
                p.g(context, "context");
                u.makeText(context, context.getResources().getString(R.string.cyk), 0).show();
                AppMethodBeat.o(168214);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/CommentMenu$BottomSheetMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;)V", "getFeedUsername", "()Ljava/lang/String;", "onCreateMMMenu", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.view.a$a  reason: collision with other inner class name */
    public static final class C1326a implements o.f {
        private final String tug;
        private s wjG;

        public C1326a(s sVar, String str) {
            p.h(sVar, "commentItem");
            p.h(str, "feedUsername");
            AppMethodBeat.i(254617);
            this.wjG = sVar;
            this.tug = str;
            AppMethodBeat.o(254617);
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(254616);
            p.h(mVar, "menu");
            y yVar = y.vXH;
            if (y.In(this.tug)) {
                mVar.kV(a.wjA, R.string.t_);
                boolean z = (p.j(this.wjG.uOf.getUsername(), z.aUg()) ^ true) && (p.j(this.wjG.uOf.getUsername(), z.aTY()) ^ true);
                if (z) {
                    mVar.kV(a.wjC, R.string.u7);
                }
                mVar.kV(a.wjB, R.string.tf);
                if (z) {
                    y yVar2 = y.vXH;
                    if (y.In(this.tug)) {
                        if (this.wjG.uOf.dyk()) {
                            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                            if (com.tencent.mm.plugin.finder.storage.c.drU()) {
                                mVar.kV(a.wjD, R.string.chp);
                                AppMethodBeat.o(254616);
                                return;
                            }
                        } else {
                            mVar.kV(a.wjD, R.string.chp);
                        }
                    }
                }
            }
            AppMethodBeat.o(254616);
        }
    }
}

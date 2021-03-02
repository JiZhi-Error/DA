package com.tencent.mm.plugin.gamelife.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bx.a.a;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.game.report.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.e.c;
import com.tencent.mm.plugin.gamelife.ui.b;
import com.tencent.mm.plugin.gamelife.ui.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0012\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u0006\u0010\u001f\u001a\u00020\u0015J\u001e\u0010 \u001a\u00020\u00152\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter;", "Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationPresenter;", "view", "Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationView;", "adapter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "(Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationView;Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;)V", "conversationService", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeConversationService;", "kotlin.jvm.PlatformType", "conversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "isInitialOnResume", "", "onConversationStorageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "onGameLifeContactStorageChange", "onItemClickListener", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter$onItemClickListener$1", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter$onItemClickListener$1;", "checkEmpty", "", "checkHistoryConversation", "loadInitial", "modifyChange", "obj", "", "onCreate", "onDestroy", "onLoadMore", "onResume", "refreshGameCenterMsg", "reportAllVisibleItems", "range", "Lkotlin/Pair;", "", "Companion", "plugin-gamelife_release"})
public final class e {
    public static final a ydc = new a((byte) 0);
    final MStorage.IOnStorageChange vHQ = new f(this);
    private final com.tencent.mm.plugin.gamelife.e.e yai = ((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getConversationStorage();
    boolean ycW = true;
    final com.tencent.mm.plugin.gamelife.a.c ycX = ((com.tencent.mm.plugin.gamelife.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.c.class));
    final i ycY = new i(this);
    final MStorage.IOnStorageChange ycZ = new h(this);
    h.a yda;
    public final b ydb;

    static {
        AppMethodBeat.i(241487);
        AppMethodBeat.o(241487);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "success", "", "result", "", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "invoke"})
    public static final class d extends q implements m<Boolean, List<? extends com.tencent.mm.plugin.gamelife.e.a>, x> {
        final /* synthetic */ e ydd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(e eVar) {
            super(2);
            this.ydd = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.tencent.mm.plugin.gamelife.ui.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, List<? extends com.tencent.mm.plugin.gamelife.e.a> list) {
            int i2;
            h.a aVar;
            AppMethodBeat.i(241473);
            boolean booleanValue = bool.booleanValue();
            List<? extends com.tencent.mm.plugin.gamelife.e.a> list2 = list;
            p.h(list2, "result");
            if (!booleanValue) {
                h.a aVar2 = this.ydd.yda;
                if (aVar2 != null) {
                    aVar2.dXs();
                }
            } else {
                this.ydd.ydb.fe(list2);
                h.a aVar3 = this.ydd.yda;
                if (aVar3 != null) {
                    aVar3.dXr();
                }
                if (list2.size() < 15 && (aVar = this.ydd.yda) != null) {
                    aVar.pY(true);
                }
                e.c(this.ydd);
                e.d(this.ydd);
                c.a aVar4 = com.tencent.mm.game.report.c.hhl;
                int size = this.ydd.ydb.ppH.size();
                com.tencent.mm.plugin.gamelife.i.a aVar5 = com.tencent.mm.plugin.gamelife.i.a.ycs;
                eq a2 = c.a.a(2, 202, 0, 1, com.tencent.mm.plugin.gamelife.i.a.dXm());
                a2.mZ((long) size);
                JSONObject jSONObject = new JSONObject();
                if (size == 0) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                jSONObject.put("list_state", i2);
                a2.rQ(URLEncoder.encode(jSONObject.toString()));
                a2.bfK();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(241473);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "success", "", "result", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "invoke", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter$modifyChange$2$2"})
    /* renamed from: com.tencent.mm.plugin.gamelife.ui.e$e  reason: collision with other inner class name */
    public static final class C1427e extends q implements m<Boolean, com.tencent.mm.plugin.gamelife.e.a, x> {
        final /* synthetic */ e ydd;
        final /* synthetic */ Object yde;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1427e(e eVar, Object obj) {
            super(2);
            this.ydd = eVar;
            this.yde = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, com.tencent.mm.plugin.gamelife.e.a aVar) {
            AppMethodBeat.i(241474);
            boolean booleanValue = bool.booleanValue();
            com.tencent.mm.plugin.gamelife.e.a aVar2 = aVar;
            p.h(aVar2, "result");
            if (booleanValue) {
                this.ydd.ydb.b(aVar2);
            } else {
                Log.e("GameLife.ConversationPresenter", "bindConversation fail!");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(241474);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        public static final g ydg = new g();

        static {
            AppMethodBeat.i(241479);
            AppMethodBeat.o(241479);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "success", "", "result", "", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "invoke"})
    public static final class j extends q implements m<Boolean, List<? extends com.tencent.mm.plugin.gamelife.e.a>, x> {
        final /* synthetic */ e ydd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(e eVar) {
            super(2);
            this.ydd = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.tencent.mm.plugin.gamelife.ui.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, List<? extends com.tencent.mm.plugin.gamelife.e.a> list) {
            h.a aVar;
            AppMethodBeat.i(241482);
            boolean booleanValue = bool.booleanValue();
            List<? extends com.tencent.mm.plugin.gamelife.e.a> list2 = list;
            p.h(list2, "result");
            if (!booleanValue) {
                h.a aVar2 = this.ydd.yda;
                if (aVar2 != null) {
                    aVar2.dXt();
                }
            } else {
                this.ydd.ydb.dR(list2);
                h.a aVar3 = this.ydd.yda;
                if (aVar3 != null) {
                    aVar3.OF(list2.size());
                }
                if (list2.size() < 10 && (aVar = this.ydd.yda) != null) {
                    aVar.pY(false);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(241482);
            return xVar;
        }
    }

    public e(h.a aVar, b bVar) {
        p.h(bVar, "adapter");
        AppMethodBeat.i(241486);
        this.yda = aVar;
        this.ydb = bVar;
        AppMethodBeat.o(241486);
    }

    public static final /* synthetic */ void d(e eVar) {
        AppMethodBeat.i(241489);
        eVar.dXq();
        AppMethodBeat.o(241489);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter$Companion;", "", "()V", "PAGE_COUNT", "", "PAGE_INITIAL_COUNT", "TAG", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter$onItemClickListener$1", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "pos", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "plugin-gamelife_release"})
    public static final class i implements b.c {
        final /* synthetic */ e ydd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(e eVar) {
            this.ydd = eVar;
        }

        @Override // com.tencent.mm.plugin.gamelife.ui.b.c
        public final void a(View view, com.tencent.mm.plugin.gamelife.e.a aVar) {
            AppMethodBeat.i(241481);
            p.h(view, "view");
            p.h(aVar, "conversation");
            ((com.tencent.mm.plugin.gamelife.a.d) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.d.class)).dXc();
            h.a aVar2 = this.ydd.yda;
            if (aVar2 != null) {
                String str = aVar.field_sessionId;
                p.g(str, "conversation.field_sessionId");
                String str2 = aVar.field_selfUserName;
                p.g(str2, "conversation.field_selfUserName");
                String str3 = aVar.field_talker;
                p.g(str3, "conversation.field_talker");
                aVar2.at(str, str2, str3);
                AppMethodBeat.o(241481);
                return;
            }
            AppMethodBeat.o(241481);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class f implements MStorage.IOnStorageChange {
        final /* synthetic */ e ydd;

        f(e eVar) {
            this.ydd = eVar;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(241478);
            Object obj = mStorageEventData.obj;
            if (obj instanceof com.tencent.mm.plugin.gamelife.e.a) {
                switch (mStorageEventData.eventId) {
                    case 1:
                    case 2:
                        c.a aVar = com.tencent.mm.plugin.gamelife.e.c.ybX;
                        c.a.a((com.tencent.mm.plugin.gamelife.e.a) obj, new m<Boolean, com.tencent.mm.plugin.gamelife.e.a, x>(this) {
                            /* class com.tencent.mm.plugin.gamelife.ui.e.f.AnonymousClass1 */
                            final /* synthetic */ f ydf;

                            {
                                this.ydf = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                            @Override // kotlin.g.a.m
                            public final /* synthetic */ x invoke(Boolean bool, com.tencent.mm.plugin.gamelife.e.a aVar) {
                                AppMethodBeat.i(241475);
                                boolean booleanValue = bool.booleanValue();
                                com.tencent.mm.plugin.gamelife.e.a aVar2 = aVar;
                                p.h(aVar2, "result");
                                if (booleanValue) {
                                    b bVar = this.ydf.ydd.ydb;
                                    p.h(aVar2, "conversation");
                                    com.tencent.mm.ac.d.h(new b.f(bVar, aVar2));
                                    e.c(this.ydf.ydd);
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(241475);
                                return xVar;
                            }
                        });
                        break;
                    case 3:
                        b bVar = this.ydd.ydb;
                        com.tencent.mm.plugin.gamelife.e.a aVar2 = (com.tencent.mm.plugin.gamelife.e.a) obj;
                        p.h(aVar2, "conversation");
                        com.tencent.mm.ac.d.h(new b.e(bVar, aVar2));
                        e.c(this.ydd);
                        break;
                    case 4:
                    case 5:
                        c.a aVar3 = com.tencent.mm.plugin.gamelife.e.c.ybX;
                        c.a.a((com.tencent.mm.plugin.gamelife.e.a) obj, new m<Boolean, com.tencent.mm.plugin.gamelife.e.a, x>(this) {
                            /* class com.tencent.mm.plugin.gamelife.ui.e.f.AnonymousClass2 */
                            final /* synthetic */ f ydf;

                            {
                                this.ydf = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                            @Override // kotlin.g.a.m
                            public final /* synthetic */ x invoke(Boolean bool, com.tencent.mm.plugin.gamelife.e.a aVar) {
                                AppMethodBeat.i(241476);
                                boolean booleanValue = bool.booleanValue();
                                com.tencent.mm.plugin.gamelife.e.a aVar2 = aVar;
                                p.h(aVar2, "result");
                                if (booleanValue) {
                                    this.ydf.ydd.ydb.b(aVar2);
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(241476);
                                return xVar;
                            }
                        });
                        break;
                    case 8:
                        c.a aVar4 = com.tencent.mm.plugin.gamelife.e.c.ybX;
                        c.a.a(0, this.ydd.ydb.ppH.size(), new m<Boolean, List<? extends com.tencent.mm.plugin.gamelife.e.a>, x>(this) {
                            /* class com.tencent.mm.plugin.gamelife.ui.e.f.AnonymousClass3 */
                            final /* synthetic */ f ydf;

                            {
                                this.ydf = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                            /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.tencent.mm.plugin.gamelife.ui.b */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.g.a.m
                            public final /* synthetic */ x invoke(Boolean bool, List<? extends com.tencent.mm.plugin.gamelife.e.a> list) {
                                AppMethodBeat.i(241477);
                                boolean booleanValue = bool.booleanValue();
                                List<? extends com.tencent.mm.plugin.gamelife.e.a> list2 = list;
                                p.h(list2, "list");
                                if (booleanValue) {
                                    this.ydf.ydd.ydb.fe(list2);
                                    e.c(this.ydf.ydd);
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(241477);
                                return xVar;
                            }
                        });
                        break;
                }
                Log.d("GameLife.ConversationPresenter", "conversationStorageChange " + mStorageEventData.obj + ' ' + mStorageEventData.eventId);
            }
            AppMethodBeat.o(241478);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class h implements MStorage.IOnStorageChange {
        final /* synthetic */ e ydd;

        h(e eVar) {
            this.ydd = eVar;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(241480);
            Log.i("GameLife.ConversationPresenter", "onGameLifeContactStorageChange eventId:[%d]", Integer.valueOf(mStorageEventData.eventId));
            switch (mStorageEventData.eventId) {
                case 3:
                    e.a(this.ydd, mStorageEventData.obj);
                    break;
            }
            AppMethodBeat.o(241480);
        }
    }

    public final void dXp() {
        AppMethodBeat.i(241483);
        c.a aVar = com.tencent.mm.plugin.gamelife.e.c.ybX;
        c.a.a(0, 15, new d(this));
        AppMethodBeat.o(241483);
    }

    /* access modifiers changed from: package-private */
    public final void dXq() {
        AppMethodBeat.i(241484);
        Log.i("GameLife.ConversationPresenter", "checkHistoryConversation");
        ((com.tencent.mm.plugin.game.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.c.class)).a(new c(this));
        AppMethodBeat.o(241484);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "gameLifeHistoryNode", "Lcom/tencent/mm/plugin/game/api/IGameExternalService$GameLifeHistoryNode;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class c implements c.a {
        final /* synthetic */ e ydd;

        c(e eVar) {
            this.ydd = eVar;
        }

        @Override // com.tencent.mm.plugin.game.api.c.a
        public final void a(c.b bVar) {
            com.tencent.mm.plugin.gamelife.e.e eVar;
            String str;
            int i2;
            AppMethodBeat.i(241472);
            if (bVar == null) {
                Log.i("GameLife.ConversationPresenter", "checkHistoryConversation gameLifeHistoryNode null");
                AppMethodBeat.o(241472);
            } else if (bVar.xtZ) {
                com.tencent.mm.plugin.gamelife.e.a dXl = this.ydd.yai.dXl();
                int i3 = bVar.xua;
                Log.i("GameLife.ConversationPresenter", "checkHistoryConversation sysrowid: " + dXl.systemRowid + " old: " + dXl.field_unReadCount + " new: " + i3);
                if (dXl.field_unReadCount == Integer.MAX_VALUE) {
                    AppMethodBeat.o(241472);
                    return;
                }
                if (dXl.systemRowid <= 0 || i3 > dXl.field_unReadCount) {
                    dXl.field_updateTime = cl.aWA();
                    dXl.field_unReadCount = i3;
                    dXl.field_sessionId = "@gamelifehistory";
                    dXl.field_digest = com.tencent.mm.cb.a.aI(MMApplicationContext.getContext(), R.string.dtk);
                    eVar = this.ydd.yai;
                    eVar.replace(dXl, false);
                    str = MStorageEventData.EventType.SINGLE;
                    i2 = dXl.systemRowid <= 0 ? 2 : 1;
                } else {
                    dXl.field_unReadCount = i3;
                    eVar = this.ydd.yai;
                    eVar.update(dXl.systemRowid, dXl, false);
                    str = MStorageEventData.EventType.SINGLE;
                    i2 = 4;
                }
                eVar.doNotify(str, i2, dXl);
                AppMethodBeat.o(241472);
            } else {
                Log.i("GameLife.ConversationPresenter", "checkHistoryConversation gameLifeNode.hasGameLife false");
                AppMethodBeat.o(241472);
            }
        }
    }

    public final void onLoadMore() {
        AppMethodBeat.i(241485);
        c.a aVar = com.tencent.mm.plugin.gamelife.e.c.ybX;
        c.a.a(this.ydb.ppH.size(), 10, new j(this));
        AppMethodBeat.o(241485);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e ydd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar) {
            super(0);
            this.ydd = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            AppMethodBeat.i(241471);
            h.a aVar = this.ydd.yda;
            if (aVar != null) {
                if (this.ydd.ydb.ppH.size() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                aVar.mB(z);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(241471);
            return xVar;
        }
    }

    public static final /* synthetic */ void c(e eVar) {
        AppMethodBeat.i(241488);
        com.tencent.mm.ac.d.h(new b(eVar));
        AppMethodBeat.o(241488);
    }

    public static final /* synthetic */ void a(e eVar, Object obj) {
        AppMethodBeat.i(241490);
        if (obj instanceof String) {
            if (((CharSequence) obj).length() > 0) {
                ArrayList<com.tencent.mm.plugin.gamelife.e.a> arrayList = new ArrayList();
                for (T t : eVar.ydb.ppH) {
                    T t2 = t;
                    if (p.j(((com.tencent.mm.plugin.gamelife.e.a) t2).field_selfUserName, obj) || p.j(((com.tencent.mm.plugin.gamelife.e.a) t2).field_talker, obj)) {
                        arrayList.add(t);
                    }
                }
                for (com.tencent.mm.plugin.gamelife.e.a aVar : arrayList) {
                    Log.i("GameLife.ConversationPresenter", "[onContactStorageChange] username=".concat(String.valueOf(obj)));
                    com.tencent.mm.bx.a.a gum = a.C0284a.gum();
                    if (gum != null) {
                        gum.aer(aVar.field_sessionId);
                        gum.aer(aVar.field_selfUserName);
                    }
                    c.a aVar2 = com.tencent.mm.plugin.gamelife.e.c.ybX;
                    c.a.a(aVar, new C1427e(eVar, obj));
                }
            }
        }
        AppMethodBeat.o(241490);
    }
}

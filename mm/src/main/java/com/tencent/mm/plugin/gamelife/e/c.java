package com.tencent.mm.plugin.gamelife.e;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class c {
    public static final a ybX = new a((byte) 0);

    static {
        AppMethodBeat.i(241351);
        AppMethodBeat.o(241351);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\nJ4\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0004\u0012\u00020\u00060\nJ6\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0004\u0012\u00020\u00060\nJ\u0016\u0010\u0012\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic$Companion;", "", "()V", "TAG", "", "bindConversationWithContactAsync", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "callback", "Lkotlin/Function2;", "", "conversations", "", "getConversations", "offset", "", "nextCount", "preloadSelfAvatar", "plugin-gamelife_release"})
    public static final class a {

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "success", "", "result", "", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.gamelife.e.c$a$a  reason: collision with other inner class name */
        public static final class C1418a extends q implements m<Boolean, List<? extends a>, x> {
            final /* synthetic */ m nzd;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1418a(m mVar) {
                super(2);
                this.nzd = mVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Boolean bool, List<? extends a> list) {
                AppMethodBeat.i(241345);
                boolean booleanValue = bool.booleanValue();
                List<? extends a> list2 = list;
                p.h(list2, "result");
                this.nzd.invoke(Boolean.valueOf(booleanValue), list2.get(0));
                x xVar = x.SXb;
                AppMethodBeat.o(241345);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "success", "", "result", "", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "invoke", "com/tencent/mm/plugin/gamelife/conversation/GameLifeConversationLogic$Companion$getConversations$1$1"})
        /* renamed from: com.tencent.mm.plugin.gamelife.e.c$a$c  reason: collision with other inner class name */
        public static final class C1419c extends q implements m<Boolean, List<? extends a>, x> {
            final /* synthetic */ m hVl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1419c(m mVar) {
                super(2);
                this.hVl = mVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Boolean bool, List<? extends a> list) {
                AppMethodBeat.i(241347);
                boolean booleanValue = bool.booleanValue();
                List<? extends a> list2 = list;
                p.h(list2, "result");
                this.hVl.invoke(Boolean.valueOf(booleanValue), list2);
                x xVar = x.SXb;
                AppMethodBeat.o(241347);
                return xVar;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(int i2, int i3, m<? super Boolean, ? super List<a>, x> mVar) {
            AppMethodBeat.i(241348);
            p.h(mVar, "callback");
            List<a> dP = ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage().dP(i2, i3);
            a aVar = c.ybX;
            Iterator<T> it = dP.iterator();
            while (it.hasNext()) {
                a.b.gov().fZ(((a) it.next()).field_selfUserName);
            }
            a aVar2 = c.ybX;
            d(dP, new C1419c(mVar));
            AppMethodBeat.o(241348);
        }

        public static void a(a aVar, m<? super Boolean, ? super a, x> mVar) {
            AppMethodBeat.i(241349);
            p.h(aVar, "conversation");
            p.h(mVar, "callback");
            d(j.listOf(aVar), new C1418a(mVar));
            AppMethodBeat.o(241349);
        }

        private static void d(List<a> list, m<? super Boolean, ? super List<a>, x> mVar) {
            AppMethodBeat.i(241350);
            p.h(list, "conversations");
            p.h(mVar, "callback");
            if (list.isEmpty()) {
                mVar.invoke(Boolean.TRUE, v.SXr);
                AppMethodBeat.o(241350);
                return;
            }
            HashSet hashSet = new HashSet();
            HashMap hashMap = new HashMap();
            for (T t : list) {
                List list2 = (List) hashMap.get(((a) t).field_talker);
                if (list2 != null) {
                    list2.add(t);
                } else {
                    a aVar = c.ybX;
                    String str = ((a) t).field_talker;
                    p.g(str, "it.field_talker");
                    hashMap.put(str, j.mutableListOf(t));
                }
                hashSet.add(((a) t).field_talker);
                hashSet.add(((a) t).field_selfUserName);
            }
            ((com.tencent.mm.plugin.gamelife.a.b) g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(j.p(hashSet), new b(mVar, list, hashMap));
            AppMethodBeat.o(241350);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012F\u0010\u0002\u001aB\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006 \u0005* \u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00070\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "map", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
        public static final class b implements b.c {
            final /* synthetic */ m nzd;
            final /* synthetic */ List ybY;
            final /* synthetic */ HashMap ybZ;

            b(m mVar, List list, HashMap hashMap) {
                this.nzd = mVar;
                this.ybY = list;
                this.ybZ = hashMap;
            }

            @Override // com.tencent.mm.plugin.gamelife.a.b.c
            public final void aj(Map<String, com.tencent.mm.plugin.gamelife.a.a> map) {
                AppMethodBeat.i(241346);
                p.g(map, "map");
                for (Map.Entry<String, com.tencent.mm.plugin.gamelife.a.a> entry : map.entrySet()) {
                    com.tencent.mm.plugin.gamelife.a.a value = entry.getValue();
                    p.g(value, "it.value");
                    if (!value.isValid()) {
                        Log.e("GameLife.ConversationLogic", "invalid contact, bind conversation failed!");
                        this.nzd.invoke(Boolean.FALSE, this.ybY);
                        AppMethodBeat.o(241346);
                        return;
                    }
                    List<a> list = (List) this.ybZ.get(entry.getKey());
                    if (list != null) {
                        for (a aVar : list) {
                            com.tencent.mm.plugin.gamelife.a.a value2 = entry.getValue();
                            if (value2 == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.contact.GameLifeContact");
                                AppMethodBeat.o(241346);
                                throw tVar;
                            }
                            com.tencent.mm.plugin.gamelife.d.a aVar2 = (com.tencent.mm.plugin.gamelife.d.a) value2;
                            p.h(aVar2, "contact");
                            aVar.ybV = aVar2;
                            as dWW = aVar2.dWW();
                            aVar.nickname = dWW.arJ();
                            SpannableString gBL = dWW.gBL();
                            if (gBL == null) {
                                gBL = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), aVar.nickname);
                            }
                            aVar.tyr = gBL;
                        }
                        continue;
                    }
                }
                this.nzd.invoke(Boolean.TRUE, this.ybY);
                AppMethodBeat.o(241346);
            }
        }
    }
}

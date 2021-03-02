package com.tencent.mm.plugin.gamelife.d;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.b.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0011\u001a\u00020\u000b2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\r\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J`\u0010\u0019\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a2H\u0010\u0012\u001aD\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000b0\u001bH\u0002J\u001e\u0010!\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0012\u0010%\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J,\u0010&\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\b\u0010\u0012\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0006H\u0002J\u001c\u0010+\u001a\u00020\u000b2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u001cH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService;", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "contactExtension", "com/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1;", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkContactExpired", ch.COL_USERNAME, "deleteCache", "getContact", "callback", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$ContactCallback;", "usernameList", "", "getContactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactExtension$plugin_gamelife_release", "getContactFromLocal", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "remain", "getContactFromServer", "isBlackListAssociateWithWAGame", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "removeCacheInWX", "removeOnStorageChange", "setBlackListAssociateWithWAGame", "setBlack", "", "isAssociate", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListSetCallback;", "updateCache", "contact", "Companion", "plugin-gamelife_release"})
public final class b implements com.tencent.mm.plugin.gamelife.a.b {
    public static final a ybH = new a((byte) 0);
    private final ConcurrentHashMap<String, a> cache = new ConcurrentHashMap<>();
    public final c ybG = new c(this);

    static {
        AppMethodBeat.i(241321);
        AppMethodBeat.o(241321);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "resultMap", "", "", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "remain", "", "invoke"})
    public static final class d extends q implements m<Map<String, ? extends a>, List<? extends String>, x> {
        final /* synthetic */ b ybJ;
        final /* synthetic */ HashMap ybK;
        final /* synthetic */ b.c ybL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, HashMap hashMap, b.c cVar) {
            super(2);
            this.ybJ = bVar;
            this.ybK = hashMap;
            this.ybL = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Map<String, ? extends a> map, List<? extends String> list) {
            AppMethodBeat.i(241302);
            Map<String, ? extends a> map2 = map;
            List<? extends String> list2 = list;
            p.h(map2, "resultMap");
            p.h(list2, "remain");
            this.ybK.putAll(map2);
            if (!list2.isEmpty()) {
                b.a(this.ybJ, list2, new b.c(this) {
                    /* class com.tencent.mm.plugin.gamelife.d.b.d.AnonymousClass1 */
                    final /* synthetic */ d ybM;

                    {
                        this.ybM = r1;
                    }

                    @Override // com.tencent.mm.plugin.gamelife.a.b.c
                    public final void aj(Map<String, com.tencent.mm.plugin.gamelife.a.a> map) {
                        AppMethodBeat.i(241301);
                        this.ybM.ybK.putAll(map);
                        this.ybM.ybL.aj(this.ybM.ybK);
                        AppMethodBeat.o(241301);
                    }
                });
            } else {
                this.ybL.aj(this.ybK);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(241302);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatUserInfoResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class f<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ List kPr;
        final /* synthetic */ b ybJ;
        final /* synthetic */ b.c ybN;
        final /* synthetic */ HashMap ybO;

        f(b bVar, HashMap hashMap, List list, b.c cVar) {
            this.ybJ = bVar;
            this.ybO = hashMap;
            this.kPr = list;
            this.ybN = cVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int update;
            AppMethodBeat.i(241304);
            c.a aVar = (c.a) obj;
            if (aVar.errType == 0 && aVar.errCode == 0 && ((k) aVar.iLC).ybl != null) {
                Log.i("GameLife.ContactService", "get contact from server success, count %d", Integer.valueOf(((k) aVar.iLC).ybl.size()));
                LinkedList<com.tencent.mm.plugin.gamelife.b.b> linkedList = ((k) aVar.iLC).ybl;
                p.g(linkedList, "result.resp.chat_user_info_list");
                LinkedList<com.tencent.mm.plugin.gamelife.b.b> linkedList2 = linkedList;
                ArrayList<a> arrayList = new ArrayList(j.a(linkedList2, 10));
                for (T t : linkedList2) {
                    p.g(t, LocaleUtil.ITALIAN);
                    a aVar2 = new a();
                    p.h(t, "$this$toContact");
                    p.h(aVar2, "contact");
                    aVar2.field_username = t.username;
                    aVar2.field_nickname = t.nickname;
                    aVar2.field_avatarURL = t.uNR;
                    aVar2.field_sex = t.fuA;
                    aVar2.field_tag = t.tag;
                    aVar2.field_jumpInfo = t.yaZ;
                    aVar2.field_accountType = t.yba;
                    arrayList.add(aVar2);
                }
                for (a aVar3 : arrayList) {
                    Log.d("GameLife.ContactService", "gamelife username:%s nickname:%s,avatarUrl:%s", aVar3.print(), aVar3.field_nickname, aVar3.field_avatarURL);
                    b.a(this.ybJ, aVar3);
                    c contactStorage = ((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getContactStorage();
                    p.h(aVar3, "contact");
                    aVar3.field_updateTime = cl.aWA();
                    String str = aVar3.field_username;
                    p.g(str, "contact.field_username");
                    if (contactStorage.aAZ(str) == null) {
                        p.h(aVar3, "contact");
                        update = (int) contactStorage.vDi.insert("GameLifeContact", ch.COL_USERNAME, aVar3.convertTo());
                        Log.i("GameLife.ContactStorage", "insertContact[" + update + "] " + aVar3.print());
                    } else {
                        p.h(aVar3, "contact");
                        ContentValues convertTo = aVar3.convertTo();
                        convertTo.remove("rowid");
                        update = contactStorage.vDi.update("GameLifeContact", convertTo, "username=?", new String[]{aVar3.field_username});
                        Log.i("GameLife.ContactStorage", "updateContact[" + update + "] " + aVar3.print());
                    }
                    if (update > 0) {
                        contactStorage.doNotify("GameLifeContact", 3, aVar3.getUsername());
                    }
                    this.ybO.put(aVar3.getUsername(), aVar3);
                }
            } else {
                Log.e("GameLife.ContactService", "get contact from server failed " + aVar.errType + ' ' + aVar.errCode + ' ' + aVar.errMsg);
            }
            for (String str2 : this.kPr) {
                if (!this.ybO.containsKey(str2)) {
                    a aVar4 = new a();
                    aVar4.field_username = str2;
                    aVar4.daZ = false;
                    this.ybO.put(str2, aVar4);
                }
            }
            b.c cVar = this.ybN;
            HashMap hashMap = this.ybO;
            if (hashMap == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, com.tencent.mm.plugin.gamelife.api.IGameLifeContact>");
                AppMethodBeat.o(241304);
                throw tVar;
            }
            cVar.aj(hashMap);
            x xVar = x.SXb;
            AppMethodBeat.o(241304);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetBlackListResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class g<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String hLl;
        final /* synthetic */ b.a ybP;

        g(String str, b.a aVar) {
            this.hLl = str;
            this.ybP = aVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            boolean z;
            AppMethodBeat.i(241305);
            c.a aVar = (c.a) obj;
            if (aVar.errCode == 0 && aVar.errType == 0) {
                boolean z2 = ((com.tencent.mm.plugin.gamelife.b.e) aVar.iLC).ybf;
                if (p.j(this.hLl, ((com.tencent.mm.plugin.gamelife.b.e) aVar.iLC).ybe.username)) {
                    z = ((com.tencent.mm.plugin.gamelife.b.e) aVar.iLC).ybe.yaY;
                } else {
                    z = false;
                }
                this.ybP.U(z2, z);
            } else {
                Log.e("GameLife.ContactService", "isBlackListAssociateWithWAGame errCode:%d,errType:%d", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType));
                this.ybP.U(false, false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(241305);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetBlackListResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
    static final class h<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ b.AbstractC1411b ybQ;

        h(b.AbstractC1411b bVar) {
            this.ybQ = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(241306);
            c.a aVar = (c.a) obj;
            if (aVar.errCode == 0 && aVar.errType == 0) {
                b.AbstractC1411b bVar = this.ybQ;
                if (bVar != null) {
                    bVar.mM(true);
                    x xVar = x.SXb;
                    AppMethodBeat.o(241306);
                    return xVar;
                }
                AppMethodBeat.o(241306);
                return null;
            }
            Log.e("GameLife.ContactService", "setBlackListAssociateWithWAGame errCode:%d,errType:%d", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType));
            b.AbstractC1411b bVar2 = this.ybQ;
            if (bVar2 != null) {
                bVar2.mM(false);
                x xVar2 = x.SXb;
                AppMethodBeat.o(241306);
                return xVar2;
            }
            AppMethodBeat.o(241306);
            return null;
        }
    }

    public b() {
        AppMethodBeat.i(241320);
        AppMethodBeat.o(241320);
    }

    public static final /* synthetic */ void a(b bVar, a aVar) {
        AppMethodBeat.i(241323);
        bVar.a(aVar);
        AppMethodBeat.o(241323);
    }

    public static final /* synthetic */ void a(b bVar, List list, b.c cVar) {
        AppMethodBeat.i(241322);
        bVar.b(list, cVar);
        AppMethodBeat.o(241322);
    }

    @Override // com.tencent.mm.plugin.gamelife.a.b
    public final /* synthetic */ com.tencent.mm.plugin.gamelife.a.a aAR(String str) {
        AppMethodBeat.i(241310);
        a aAX = aAX(str);
        AppMethodBeat.o(241310);
        return aAX;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService$Companion;", "", "()V", "CONTACT_EXPIRE_TIME", "", "TAG", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.gamelife.a.b
    public final void a(List<String> list, b.c cVar) {
        AppMethodBeat.i(241307);
        p.h(cVar, "callback");
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            cVar.aj(ae.emptyMap());
            AppMethodBeat.o(241307);
            return;
        }
        e eVar = new e(list, cVar);
        HashMap hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        for (T t : list) {
            if (t.length() == 0) {
                hashMap.put("", new a());
            } else {
                a aVar = this.cache.get(t);
                if (aVar != null) {
                    p.g(aVar, LocaleUtil.ITALIAN);
                    hashMap.put(t, aVar);
                } else {
                    linkedList.add(t);
                }
            }
        }
        if (linkedList.isEmpty()) {
            eVar.aj(hashMap);
            AppMethodBeat.o(241307);
            return;
        }
        c(linkedList, new d(this, hashMap, eVar));
        AppMethodBeat.o(241307);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012F\u0010\u0002\u001aB\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006 \u0005* \u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00070\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "result", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
    public static final class e implements b.c {
        final /* synthetic */ List kPr;
        final /* synthetic */ b.c ybN;

        e(List list, b.c cVar) {
            this.kPr = list;
            this.ybN = cVar;
        }

        @Override // com.tencent.mm.plugin.gamelife.a.b.c
        public final void aj(Map<String, com.tencent.mm.plugin.gamelife.a.a> map) {
            AppMethodBeat.i(241303);
            StringBuilder append = new StringBuilder("[getContact] usernameList=").append(this.kPr).append(" result=");
            p.g(map, "result");
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, com.tencent.mm.plugin.gamelife.a.a> entry : map.entrySet()) {
                StringBuilder append2 = new StringBuilder().append(entry.getKey()).append('=');
                com.tencent.mm.plugin.gamelife.a.a value = entry.getValue();
                p.g(value, "it.value");
                arrayList.add(append2.append(value.getNickname()).toString());
            }
            Log.i("GameLife.ContactService", append.append(arrayList).toString());
            this.ybN.aj(map);
            AppMethodBeat.o(241303);
        }
    }

    @Override // com.tencent.mm.plugin.gamelife.a.b
    public final void a(String str, b.c cVar) {
        AppMethodBeat.i(241308);
        p.h(str, ch.COL_USERNAME);
        p.h(cVar, "callback");
        a(j.mutableListOf(str), cVar);
        AppMethodBeat.o(241308);
    }

    public final a aAX(String str) {
        AppMethodBeat.i(241309);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(241309);
            return null;
        }
        a aVar = this.cache.get(str);
        if (aVar != null) {
            AppMethodBeat.o(241309);
            return aVar;
        }
        a aAZ = ((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getContactStorage().aAZ(str);
        if (aAZ != null) {
            a(aAZ);
            AppMethodBeat.o(241309);
            return aAZ;
        }
        AppMethodBeat.o(241309);
        return null;
    }

    private final void c(List<String> list, m<? super Map<String, a>, ? super List<String>, x> mVar) {
        AppMethodBeat.i(241311);
        Map<String, a> fd = ((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getContactStorage().fd(list);
        for (T t : fd.values()) {
            String username = t.getUsername();
            this.cache.put(username, t);
            aAY(username);
        }
        ArrayList arrayList = new ArrayList();
        for (T t2 : list) {
            if (!fd.containsKey(t2)) {
                arrayList.add(t2);
            }
        }
        mVar.invoke(fd, arrayList);
        AppMethodBeat.o(241311);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", ch.COL_USERNAME, "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-gamelife_release"})
    public static final class c implements bv.a {
        final /* synthetic */ b ybJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(b bVar) {
            this.ybJ = bVar;
        }

        @Override // com.tencent.mm.storage.bv.a
        public final void a(bv bvVar, as asVar) {
        }

        @Override // com.tencent.mm.storage.bv.a
        public final int b(as asVar, boolean z) {
            AppMethodBeat.i(241299);
            if (asVar == null) {
                AppMethodBeat.o(241299);
                return -1;
            } else if (!as.bju(asVar.getUsername())) {
                AppMethodBeat.o(241299);
                return -1;
            } else {
                AppMethodBeat.o(241299);
                return 1;
            }
        }

        @Override // com.tencent.mm.storage.bv.a
        public final as Kn(String str) {
            AppMethodBeat.i(241300);
            String str2 = str;
            if ((str2 == null || str2.length() == 0) || !as.bju(str)) {
                AppMethodBeat.o(241300);
                return null;
            }
            a aAX = this.ybJ.aAX(((com.tencent.mm.plugin.gamelife.a.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).avi(str));
            as dWW = aAX != null ? aAX.dWW() : new as();
            dWW.setUsername(str);
            AppMethodBeat.o(241300);
            return dWW;
        }
    }

    @Override // com.tencent.mm.plugin.gamelife.a.b
    public final void aAS(String str) {
        AppMethodBeat.i(241312);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            Log.e("GameLife.ContactService", "checkContactExpired userName empty");
            AppMethodBeat.o(241312);
            return;
        }
        a aAX = aAX(str);
        if (aAX == null) {
            Log.e("GameLife.ContactService", "checkContactExpired contact null username:%s", str);
            AppMethodBeat.o(241312);
            return;
        }
        long aWA = cl.aWA() - aAX.field_updateTime;
        Log.d("GameLife.ContactService", "syncTime diff:%d,contact.field_updateTime:%d", Long.valueOf(aWA), Long.valueOf(aAX.field_updateTime));
        if (aWA >= Util.MILLSECONDS_OF_DAY) {
            Log.i("GameLife.ContactService", "[checkContactExpired] diff:" + aWA + " limit:86400000 username:" + str);
            b(j.listOf(str), C1415b.ybI);
        }
        AppMethodBeat.o(241312);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012F\u0010\u0002\u001aB\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006 \u0005* \u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00070\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
    /* renamed from: com.tencent.mm.plugin.gamelife.d.b$b  reason: collision with other inner class name */
    static final class C1415b implements b.c {
        public static final C1415b ybI = new C1415b();

        static {
            AppMethodBeat.i(241298);
            AppMethodBeat.o(241298);
        }

        C1415b() {
        }

        @Override // com.tencent.mm.plugin.gamelife.a.b.c
        public final void aj(Map<String, com.tencent.mm.plugin.gamelife.a.a> map) {
        }
    }

    private final void b(List<String> list, b.c cVar) {
        AppMethodBeat.i(241313);
        new com.tencent.mm.plugin.gamelife.c.d(new LinkedList(list)).aYI().j(new f(this, new HashMap(), list, cVar));
        AppMethodBeat.o(241313);
    }

    @Override // com.tencent.mm.plugin.gamelife.a.b
    public final void m(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(241314);
        if (iOnStorageChange != null) {
            ((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getContactStorage().add(iOnStorageChange);
            AppMethodBeat.o(241314);
            return;
        }
        AppMethodBeat.o(241314);
    }

    @Override // com.tencent.mm.plugin.gamelife.a.b
    public final void l(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(241315);
        if (iOnStorageChange != null) {
            ((PluginGameLife) com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getContactStorage().remove(iOnStorageChange);
            AppMethodBeat.o(241315);
            return;
        }
        AppMethodBeat.o(241315);
    }

    @Override // com.tencent.mm.plugin.gamelife.a.b
    public final void a(String str, b.a aVar) {
        AppMethodBeat.i(241316);
        p.h(str, ch.COL_USERNAME);
        p.h(aVar, "callback");
        if (str.length() == 0) {
            Log.e("GameLife.ContactService", "isBlackListAssociateWithWAGame username null!");
            aVar.U(false, false);
        }
        Log.i("GameLife.ContactService", "isBlackListAssociateWithWAGame username:%s", str);
        new com.tencent.mm.plugin.gamelife.c.a(str).aYI().j(new g(str, aVar));
        AppMethodBeat.o(241316);
    }

    @Override // com.tencent.mm.plugin.gamelife.a.b
    public final void a(String str, boolean z, boolean z2, b.AbstractC1411b bVar) {
        AppMethodBeat.i(241317);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            Log.e("GameLife.ContactService", "setBlackListAssociateWithWAGame username null!");
            bVar.mM(false);
            AppMethodBeat.o(241317);
            return;
        }
        Log.i("GameLife.ContactService", "setBlackListAssociateWithWAGame username:%s,setBlack:%b,isAssociate:%b", str, Boolean.valueOf(z), Boolean.valueOf(z2));
        new com.tencent.mm.plugin.gamelife.c.e(str, z, z2).aYI().j(new h(bVar));
        AppMethodBeat.o(241317);
    }

    private final void a(a aVar) {
        AppMethodBeat.i(241318);
        String username = aVar.getUsername();
        this.cache.put(username, aVar);
        aAY(username);
        AppMethodBeat.o(241318);
    }

    private static void aAY(String str) {
        AppMethodBeat.i(241319);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().ayf(str);
        AppMethodBeat.o(241319);
    }
}

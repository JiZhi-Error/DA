package com.tencent.mm.plugin.textstatus.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.f.f.c;
import com.tencent.mm.plugin.textstatus.f.f.d;
import com.tencent.mm.plugin.textstatus.f.f.f;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.plugin.textstatus.g.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.y.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001JB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\u0016\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u000fJ\u0012\u0010/\u001a\u0004\u0018\u00010%2\b\u00100\u001a\u0004\u0018\u00010\u0006J\u001c\u00101\u001a\u00020#2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0006032\u0006\u0010.\u001a\u00020\u000fJ\u000e\u00104\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0006J\u000e\u00105\u001a\u00020#2\u0006\u0010.\u001a\u00020\u000fJ2\u00106\u001a\u00020#2\b\u00107\u001a\u0004\u0018\u00010\u00062\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J,\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\b\u0010@\u001a\u0004\u0018\u00010\u00062\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020DH\u0016J(\u0010E\u001a\u00020+2\u0006\u00100\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010G\u001a\u00020>J\u001d\u0010H\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010G\u001a\u00020>¢\u0006\u0002\u0010IR\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\u001f\u0010 ¨\u0006K"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager;", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusDataManager;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDataDB", "()Lcom/tencent/mm/storagebase/SqliteDB;", "dataDB$delegate", "Lkotlin/Lazy;", "getOtherTopicInfoListener", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$Callback;", "getSelfTopicInfoListener", "getTopicInfoListener", "infoUpdateListener", "likeStorage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "getLikeStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "likeStorage$delegate", "storage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", com.tencent.mm.plugin.appbrand.jsapi.storage.f.NAME, "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", "storage$delegate", "userNameMapStorage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusUserNameMapStorage;", "getUserNameMapStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusUserNameMapStorage;", "userNameMapStorage$delegate", "convert", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "info", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "deleteByRowId", "", "rowId", "", "getOtherTopicInfoAsyn", "userName", "listerner", "getStatus", ch.COL_USERNAME, "getTopicInfoAsyn", "topicIDs", "Ljava/util/LinkedList;", "isFriend", "listentoInfoUpdate", "onNewXmlReceived", "subType", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "self", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusInfo;", "update", "id", "state", "updateSelfState", "(Ljava/lang/Long;I)Z", "Callback", "plugin-textstatus_release"})
public final class f implements i, q, k {
    private static WeakReference<a> FXE;
    private static WeakReference<a> FXF;
    private static final kotlin.f FXG = g.ah(b.FXK);
    private static final kotlin.f FXH = g.ah(c.FXL);
    private static final kotlin.f FXI = g.ah(e.FXN);
    public static final f FXJ;
    private static final kotlin.f nDW = g.ah(d.FXM);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$Callback;", "", "onCall", "", "data", "plugin-textstatus_release"})
    public interface a {
        void dW(Object obj);
    }

    public static com.tencent.mm.plugin.textstatus.f.f.d fvM() {
        AppMethodBeat.i(216082);
        com.tencent.mm.plugin.textstatus.f.f.d dVar = (com.tencent.mm.plugin.textstatus.f.f.d) nDW.getValue();
        AppMethodBeat.o(216082);
        return dVar;
    }

    public static com.tencent.mm.plugin.textstatus.f.f.c fvN() {
        AppMethodBeat.i(216083);
        com.tencent.mm.plugin.textstatus.f.f.c cVar = (com.tencent.mm.plugin.textstatus.f.f.c) FXH.getValue();
        AppMethodBeat.o(216083);
        return cVar;
    }

    public static com.tencent.mm.plugin.textstatus.f.f.f fvO() {
        AppMethodBeat.i(216084);
        com.tencent.mm.plugin.textstatus.f.f.f fVar = (com.tencent.mm.plugin.textstatus.f.f.f) FXI.getValue();
        AppMethodBeat.o(216084);
        return fVar;
    }

    public static h getDataDB() {
        AppMethodBeat.i(216081);
        h hVar = (h) FXG.getValue();
        AppMethodBeat.o(216081);
        return hVar;
    }

    static {
        AppMethodBeat.i(216093);
        f fVar = new f();
        FXJ = fVar;
        com.tencent.mm.kernel.g.azz().a(6284, fVar);
        com.tencent.mm.kernel.g.azz().a(5215, fVar);
        com.tencent.mm.kernel.g.azz().a(6253, fVar);
        com.tencent.mm.kernel.g.azz().a(4099, fVar);
        com.tencent.mm.y.c.axV().a(new C1815f());
        AppMethodBeat.o(216093);
    }

    private f() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$badgeListener$1", "Lcom/tencent/mm/hub/NewBadge$ISourceListener;", "onChanged", "", "dataSourceKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "type", "", "value", "", "dataSourceId", "plugin-textstatus_release"})
    /* renamed from: com.tencent.mm.plugin.textstatus.b.f$f  reason: collision with other inner class name */
    public static final class C1815f implements a.AbstractC2176a {
        C1815f() {
        }

        @Override // com.tencent.mm.y.a.AbstractC2176a
        public final void D(int i2, String str) {
            AppMethodBeat.i(258312);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_TEXT_STATUS_LAST_MARK_READ_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
            Log.i("MicroMsg.TxtStatus.TextStatusInfoManager", "bradge mark read");
            AppMethodBeat.o(258312);
        }

        @Override // com.tencent.mm.y.a.AbstractC2176a
        public final void b(ar.a aVar) {
        }
    }

    public static com.tencent.mm.plugin.textstatus.f.f.a aTf(String str) {
        AppMethodBeat.i(216085);
        String str2 = str;
        if (str2 == null || n.aL(str2)) {
            AppMethodBeat.o(216085);
            return null;
        }
        com.tencent.mm.plugin.textstatus.f.f.a aTl = fvM().aTl(str);
        AppMethodBeat.o(216085);
        return aTl;
    }

    public static void a(LinkedList<String> linkedList, a aVar) {
        AppMethodBeat.i(216086);
        p.h(linkedList, "topicIDs");
        p.h(aVar, "listerner");
        com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.plugin.textstatus.f.h(linkedList));
        FXE = new WeakReference<>(aVar);
        AppMethodBeat.o(216086);
    }

    public static boolean c(Long l, int i2) {
        AppMethodBeat.i(216087);
        if (l == null) {
            AppMethodBeat.o(216087);
            return false;
        }
        com.tencent.mm.plugin.textstatus.f.f.a aVar = new com.tencent.mm.plugin.textstatus.f.f.a();
        if (fvM().get(l.longValue(), aVar)) {
            aVar.field_state = i2;
            boolean c2 = fvM().c(aVar);
            AppMethodBeat.o(216087);
            return c2;
        }
        AppMethodBeat.o(216087);
        return false;
    }

    public static /* synthetic */ long a(f fVar, String str, String str2, com.tencent.mm.plugin.textstatus.g.g gVar) {
        AppMethodBeat.i(216089);
        long a2 = a(str, str2, gVar, 0);
        AppMethodBeat.o(216089);
        return a2;
    }

    public static long a(String str, String str2, com.tencent.mm.plugin.textstatus.g.g gVar, int i2) {
        AppMethodBeat.i(216088);
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "id");
        p.h(gVar, "info");
        Log.i("MicroMsg.TxtStatus.TextStatusInfoManager", "username " + str + ' ' + str2 + ' ' + i2 + ' ' + gVar.Gax);
        if (p.j(str, com.tencent.mm.plugin.auth.a.a.ceA())) {
            com.tencent.mm.plugin.textstatus.f.f.a aTl = fvM().aTl(str);
            com.tencent.mm.plugin.textstatus.f.f.a aVar = new com.tencent.mm.plugin.textstatus.f.f.a();
            aVar.field_UserName = str;
            aVar.field_StatusID = str2;
            aVar.field_state = i2;
            a(aVar, gVar);
            if (aTl == null || aTl.field_CreateTime <= aVar.field_CreateTime) {
                if (fvM().b(aVar)) {
                    com.tencent.mm.plugin.textstatus.e.a aVar2 = com.tencent.mm.plugin.textstatus.e.a.FYI;
                    com.tencent.mm.plugin.textstatus.e.a.c(str, aVar);
                    Log.i("MicroMsg.TxtStatus.TextStatusInfoManager", "update deleteResult:" + fvM().ie(str, gVar.Gaz) + " create_time:" + gVar.Gaz);
                }
                long j2 = aVar.systemRowid;
                AppMethodBeat.o(216088);
                return j2;
            }
            Log.w("MicroMsg.TxtStatus.TextStatusInfoManager", "current postInfo is new.(cur:" + aTl.field_CreateTime + ", new:" + aVar.field_CreateTime + ')');
            AppMethodBeat.o(216088);
            return -1;
        }
        com.tencent.mm.plugin.textstatus.f.f.a aTl2 = fvM().aTl(str);
        if (aTl2 == null) {
            aTl2 = new com.tencent.mm.plugin.textstatus.f.f.a();
            com.tencent.mm.plugin.textstatus.j.a aVar3 = com.tencent.mm.plugin.textstatus.j.a.GfU;
            com.tencent.mm.plugin.textstatus.j.a.amg(str);
        } else {
            Log.i("MicroMsg.TxtStatus.TextStatusInfoManager", "last status:" + aTl2.field_StatusID + " state:" + aTl2.field_state + " createTime:" + aTl2.field_CreateTime + " mediaType:" + aTl2.field_MediaType + "  " + aTl2.field_MediaThumbUrl);
            if (!Util.isEqual(aTl2.field_StatusID, str2)) {
                com.tencent.mm.plugin.textstatus.j.a aVar4 = com.tencent.mm.plugin.textstatus.j.a.GfU;
                com.tencent.mm.plugin.textstatus.j.a.amg(str);
            }
        }
        aTl2.field_UserName = str;
        aTl2.field_StatusID = str2;
        aTl2.field_state = i2;
        a(aTl2, gVar);
        if (fvM().c(aTl2)) {
            com.tencent.mm.plugin.textstatus.e.a aVar5 = com.tencent.mm.plugin.textstatus.e.a.FYI;
            com.tencent.mm.plugin.textstatus.e.a.c(str, aTl2);
            Log.i("MicroMsg.TxtStatus.TextStatusInfoManager", "update deleteResult:" + fvM().ie(str, gVar.Gaz) + " create_time:" + gVar.Gaz);
        }
        long j3 = aTl2.systemRowid;
        AppMethodBeat.o(216088);
        return j3;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.q
    public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
        boolean z;
        int i2;
        com.tencent.mm.plugin.textstatus.f.f.b bVar;
        int i3;
        com.tencent.mm.plugin.textstatus.f.f.b bVar2;
        int i4;
        com.tencent.mm.plugin.textstatus.f.f.b bVar3;
        int i5;
        com.tencent.mm.plugin.textstatus.f.f.b bVar4;
        long j2;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(216090);
        if (map != null) {
            Log.i("MicroMsg.TxtStatus.TextStatusInfoManager", "subtype:" + str + ", values:" + map);
            if (str != null) {
                switch (str.hashCode()) {
                    case -1813338250:
                        if (str.equals("textstatuslike")) {
                            String str2 = map.get(".sysmsg.textstatuslike.HashUserName");
                            String str3 = map.get(".sysmsg.textstatuslike.TextStatusID");
                            String str4 = str3;
                            if (str4 == null || str4.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                String str5 = str2;
                                if (!(str5 == null || str5.length() == 0)) {
                                    String str6 = map.get(".sysmsg.textstatuslike.DeleteFlag");
                                    if (str6 != null) {
                                        i2 = Integer.parseInt(str6);
                                    } else {
                                        i2 = 0;
                                    }
                                    com.tencent.mm.plugin.textstatus.f.f.b lc = fvN().lc(str3, str2);
                                    if (i2 == 1 && lc != null) {
                                        fvN().b(lc, new String[0]);
                                    } else if (i2 != 1) {
                                        if (lc == null) {
                                            bVar = new com.tencent.mm.plugin.textstatus.f.f.b();
                                        } else {
                                            bVar = lc;
                                        }
                                        bVar.field_HashUserName = str2;
                                        bVar.field_TextStatusId = str3;
                                        String str7 = map.get(".sysmsg.textstatuslike.Type");
                                        if (str7 != null) {
                                            i3 = Integer.parseInt(str7);
                                            bVar2 = bVar;
                                        } else {
                                            i3 = 0;
                                            bVar2 = bVar;
                                        }
                                        bVar2.field_Type = i3;
                                        String str8 = map.get(".sysmsg.textstatuslike.Notify");
                                        if (str8 != null) {
                                            i4 = Integer.parseInt(str8);
                                            bVar3 = bVar;
                                        } else {
                                            i4 = 0;
                                            bVar3 = bVar;
                                        }
                                        bVar3.field_Notify = i4;
                                        String str9 = map.get(".sysmsg.textstatuslike.CreateTime");
                                        if (str9 != null) {
                                            i5 = Integer.parseInt(str9);
                                            bVar4 = bVar;
                                        } else {
                                            i5 = 0;
                                            bVar4 = bVar;
                                        }
                                        bVar4.field_CreateTime = i5;
                                        bVar.field_DisplayName = map.get(".sysmsg.textstatuslike.NickName");
                                        bVar.field_HeadImgUrl = map.get(".sysmsg.textstatuslike.HeadImgUrl");
                                        com.tencent.mm.plugin.textstatus.f.f.a aTm = fvM().aTm(str3);
                                        if (aTm != null) {
                                            bVar.field_Description = aTm.field_Description;
                                        }
                                        if (((int) bVar.systemRowid) == -1) {
                                            fvN().a(bVar);
                                        } else {
                                            fvN().a(bVar, new String[0]);
                                        }
                                        if (bVar.field_Notify == 1) {
                                            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                                            p.g(aAh, "MMKernel.storage()");
                                            long a2 = aAh.azQ().a(ar.a.USERINFO_TEXT_STATUS_LAST_MARK_READ_TIME_LONG_SYNC, 0);
                                            com.tencent.mm.plugin.textstatus.a.p.hXk();
                                            if (System.currentTimeMillis() - a2 > 0) {
                                                com.tencent.mm.y.c.axV().B(352280, true);
                                            }
                                        }
                                        boolean axS = com.tencent.mm.y.c.axV().axS();
                                        com.tencent.mm.plugin.textstatus.k.a aVar2 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                                        if (axS) {
                                            j2 = 5;
                                        } else {
                                            j2 = 6;
                                        }
                                        com.tencent.mm.plugin.textstatus.k.a.a(j2, (String) null, (String) null, 6);
                                    }
                                    com.tencent.mm.plugin.textstatus.f.f.a aTm2 = fvM().aTm(str3);
                                    if (aTm2 != null) {
                                        aTm2.field_LikeCount = Util.getInt(map.get(".sysmsg.textstatuslike.LikeCount"), 0);
                                        fvM().c(aTm2);
                                        AppMethodBeat.o(216090);
                                        return;
                                    }
                                }
                            }
                        }
                        break;
                    case -1306850335:
                        if (str.equals("modtextstatus")) {
                            String str10 = map.get(".sysmsg.modtextstatus.UserName");
                            String str11 = map.get(".sysmsg.modtextstatus.TextStatusID");
                            String str12 = map.get(".sysmsg.modtextstatus.TextStatusExtInfo");
                            String str13 = str10;
                            if (str13 == null || str13.length() == 0) {
                                AppMethodBeat.o(216090);
                                return;
                            }
                            String str14 = str11;
                            if (str14 == null || str14.length() == 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                String str15 = str12;
                                if (!(str15 == null || str15.length() == 0)) {
                                    z3 = false;
                                }
                                if (!z3) {
                                    com.tencent.mm.plugin.textstatus.g.g gVar = new com.tencent.mm.plugin.textstatus.g.g();
                                    gVar.parseFrom(Base64.decode(str12, 0));
                                    a(str10, str11, gVar, 4);
                                    AppMethodBeat.o(216090);
                                    return;
                                }
                            }
                            fvM().aTk(str10);
                            AppMethodBeat.o(216090);
                            return;
                        }
                        break;
                }
            } else {
                AppMethodBeat.o(216090);
                return;
            }
        }
        AppMethodBeat.o(216090);
    }

    public static void a(com.tencent.mm.plugin.textstatus.f.f.a aVar, com.tencent.mm.plugin.textstatus.g.g gVar) {
        byte[] bArr;
        AppMethodBeat.i(216091);
        p.h(aVar, "item");
        p.h(gVar, "info");
        aVar.field_Description = gVar.description;
        aVar.field_IconID = gVar.Gau.Gan;
        aVar.field_TopicId = gVar.Gau.GaI;
        aVar.field_MediaType = gVar.Gat;
        aVar.field_MediaUrl = gVar.Gav;
        aVar.field_MediaAESKey = gVar.Gaw;
        aVar.field_MediaThumbUrl = gVar.Gax;
        aVar.field_MediaThumbAESKey = gVar.Gay;
        aVar.field_PoiID = gVar.GaA;
        aVar.field_PoiName = gVar.iUX;
        aVar.field_Latitude = gVar.latitude;
        aVar.field_Longitude = gVar.longitude;
        aVar.field_Visibility = gVar.visibility;
        aVar.field_ExpireTime = gVar.pRN;
        aVar.field_CreateTime = gVar.Gaz;
        aVar.field_backgroundId = gVar.GaC;
        aVar.field_option = Long.valueOf(gVar.GaB);
        aVar.field_mediaWidth = gVar.zGN;
        aVar.field_mediaHeight = gVar.zGO;
        w wVar = gVar.Gau;
        if (wVar != null) {
            bArr = wVar.toByteArray();
        } else {
            bArr = null;
        }
        aVar.field_TopicInfo = bArr;
        AppMethodBeat.o(216091);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        a aVar;
        a aVar2;
        AppMethodBeat.i(216092);
        if (qVar instanceof com.tencent.mm.plugin.textstatus.f.h) {
            HashMap hashMap = new HashMap();
            Iterator<String> it = ((com.tencent.mm.plugin.textstatus.f.h) qVar).FZb.GaL.iterator();
            while (it.hasNext()) {
                String next = it.next();
                x xVar = new x();
                xVar.GaI = next;
                xVar.Gbg = "";
                xVar.GaE = j.a(new kotlin.k.f(0, 100), kotlin.j.c.SYP);
                hashMap.put(next, xVar);
            }
            WeakReference<a> weakReference = FXE;
            if (!(weakReference == null || (aVar2 = weakReference.get()) == null)) {
                aVar2.dW(hashMap);
            }
            FXE = null;
        }
        if (qVar instanceof com.tencent.mm.plugin.textstatus.f.c) {
            com.tencent.mm.plugin.textstatus.g.h hVar = new com.tencent.mm.plugin.textstatus.g.h();
            hVar.GaD = new Random().nextBoolean();
            hVar.GaE = j.a(new kotlin.k.f(0, 100), kotlin.j.c.SYP);
            WeakReference<a> weakReference2 = FXF;
            if (!(weakReference2 == null || (aVar = weakReference2.get()) == null)) {
                aVar.dW(hVar);
            }
            FXF = null;
        }
        AppMethodBeat.o(216092);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/storagebase/SqliteDB;", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.storagebase.h> {
        public static final b FXK = new b();

        static {
            AppMethodBeat.i(216074);
            AppMethodBeat.o(216074);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.storagebase.h invoke() {
            AppMethodBeat.i(216073);
            HashMap<Integer, h.b> hashMap = new HashMap<>();
            hashMap.put(Integer.valueOf(com.tencent.mm.plugin.textstatus.f.f.d.TABLE.hashCode()), new h.b() {
                /* class com.tencent.mm.plugin.textstatus.b.f.b.AnonymousClass1 */

                @Override // com.tencent.mm.storagebase.h.b
                public final String[] getSQLs() {
                    AppMethodBeat.i(216070);
                    d.b bVar = com.tencent.mm.plugin.textstatus.f.f.d.FZK;
                    String[] fvZ = com.tencent.mm.plugin.textstatus.f.f.d.fvZ();
                    AppMethodBeat.o(216070);
                    return fvZ;
                }
            });
            hashMap.put(Integer.valueOf(com.tencent.mm.plugin.textstatus.f.f.c.TABLE.hashCode()), new h.b() {
                /* class com.tencent.mm.plugin.textstatus.b.f.b.AnonymousClass2 */

                @Override // com.tencent.mm.storagebase.h.b
                public final String[] getSQLs() {
                    AppMethodBeat.i(216071);
                    c.a aVar = com.tencent.mm.plugin.textstatus.f.f.c.FZI;
                    String[] fvZ = com.tencent.mm.plugin.textstatus.f.f.c.fvZ();
                    AppMethodBeat.o(216071);
                    return fvZ;
                }
            });
            hashMap.put(Integer.valueOf("TextStatusUserNameMap".hashCode()), new h.b() {
                /* class com.tencent.mm.plugin.textstatus.b.f.b.AnonymousClass3 */

                @Override // com.tencent.mm.storagebase.h.b
                public final String[] getSQLs() {
                    AppMethodBeat.i(216072);
                    f.a aVar = com.tencent.mm.plugin.textstatus.f.f.f.FZO;
                    String[] fvZ = com.tencent.mm.plugin.textstatus.f.f.f.fvZ();
                    AppMethodBeat.o(216072);
                    return fvZ;
                }
            });
            com.tencent.mm.storagebase.h hVar = new com.tencent.mm.storagebase.h();
            StringBuilder sb = new StringBuilder();
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            hVar.a(sb.append(aAh.azM()).append("TextStatus.db").toString(), hashMap, true);
            AppMethodBeat.o(216073);
            return hVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.textstatus.f.f.d> {
        public static final d FXM = new d();

        static {
            AppMethodBeat.i(216078);
            AppMethodBeat.o(216078);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.textstatus.f.f.d invoke() {
            AppMethodBeat.i(216077);
            f fVar = f.FXJ;
            com.tencent.mm.plugin.textstatus.f.f.d dVar = new com.tencent.mm.plugin.textstatus.f.f.d(f.getDataDB());
            AppMethodBeat.o(216077);
            return dVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.textstatus.f.f.c> {
        public static final c FXL = new c();

        static {
            AppMethodBeat.i(216076);
            AppMethodBeat.o(216076);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.textstatus.f.f.c invoke() {
            AppMethodBeat.i(216075);
            f fVar = f.FXJ;
            com.tencent.mm.plugin.textstatus.f.f.c cVar = new com.tencent.mm.plugin.textstatus.f.f.c(f.getDataDB());
            AppMethodBeat.o(216075);
            return cVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusUserNameMapStorage;", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.textstatus.f.f.f> {
        public static final e FXN = new e();

        static {
            AppMethodBeat.i(216080);
            AppMethodBeat.o(216080);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.textstatus.f.f.f invoke() {
            AppMethodBeat.i(216079);
            f fVar = f.FXJ;
            com.tencent.mm.plugin.textstatus.f.f.f fVar2 = new com.tencent.mm.plugin.textstatus.f.f.f(f.getDataDB());
            AppMethodBeat.o(216079);
            return fVar2;
        }
    }
}

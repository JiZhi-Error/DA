package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0014J\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderDraftLogic;", "", "()V", "DRAFT_OP_ADD", "", "getDRAFT_OP_ADD", "()I", "setDRAFT_OP_ADD", "(I)V", "DRAFT_OP_DEL", "getDRAFT_OP_DEL", "setDRAFT_OP_DEL", "TAG", "", "deleteDraft", "", ch.COL_LOCALID, "", "getAllDrafts", "", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "isLocalSenderFeedExists", "", "notifyDeleteDraft", "notifyDraftEvent", "opCode", "notifySaveDraft", "replace", "draftItem", "saveDraftItem", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "plugin-finder_release"})
public final class h {
    private static final String TAG = TAG;
    public static int vDn = 100;
    private static int vDo = 110;
    public static final h vDp = new h();

    static {
        AppMethodBeat.i(251720);
        AppMethodBeat.o(251720);
    }

    private h() {
    }

    public static int dxo() {
        return vDn;
    }

    public static int dxp() {
        return vDo;
    }

    public static void Fx(long j2) {
        AppMethodBeat.i(251716);
        Log.i(TAG, "deleteDraft localId:".concat(String.valueOf(j2)));
        b.a(((PluginFinder) g.ah(PluginFinder.class)).getDraftStorage(), j2);
        aj(vDo, j2);
        AppMethodBeat.o(251716);
    }

    public final g a(csp csp) {
        boolean z;
        cjh cjh;
        LinkedList<aud> linkedList;
        FinderObjectDesc finderObjectDesc;
        LinkedList<FinderMedia> linkedList2;
        FinderObjectDesc finderObjectDesc2;
        LinkedList<FinderMedia> linkedList3;
        AppMethodBeat.i(251717);
        p.h(csp, "mvData");
        if (csp.localId > 0) {
            Fx(csp.localId);
        }
        Log.i(TAG, "saveDraftItem :" + csp.localId);
        g gVar = new g();
        gVar.field_createTime = cl.aWB();
        gVar.field_localFlag = 1;
        aud aud = new aud();
        aud.tuO = csp.MxE;
        FinderObject finderObject = aud.tuO;
        if (!(finderObject == null || (finderObjectDesc2 = finderObject.objectDesc) == null || (linkedList3 = finderObjectDesc2.media) == null)) {
            linkedList3.clear();
        }
        String str = csp.MxF;
        if (!(str == null || str.length() == 0)) {
            FinderMedia finderMedia = new FinderMedia();
            finderMedia.url = csp.MxF;
            finderMedia.thumbUrl = csp.MxF;
            finderMedia.mediaType = 2;
            Log.i(TAG, "saveDraftItem :" + finderMedia.url + " thumbUrl:" + finderMedia.thumbUrl);
            FinderObject finderObject2 = aud.tuO;
            if (!(finderObject2 == null || (finderObjectDesc = finderObject2.objectDesc) == null || (linkedList2 = finderObjectDesc.media) == null)) {
                linkedList2.add(finderMedia);
            }
        }
        aud.LEP = new anv();
        LinkedList<FinderObject> linkedList4 = csp.LDi;
        if (linkedList4 == null || linkedList4.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            anv anv = aud.LEP;
            if (anv != null) {
                anv.LzB = new cjh();
            }
            LinkedList<FinderObject> linkedList5 = csp.LDi;
            if (linkedList5 != null) {
                Iterator<T> it = linkedList5.iterator();
                while (it.hasNext()) {
                    aud aud2 = new aud();
                    aud2.tuO = it.next();
                    anv anv2 = aud.LEP;
                    if (!(anv2 == null || (cjh = anv2.LzB) == null || (linkedList = cjh.MoH) == null)) {
                        linkedList.add(aud2);
                    }
                }
            }
        }
        gVar.field_finderItem = aud;
        gVar.field_originMvInfo = csp.MxG;
        gVar.field_objectType = 2;
        aj(vDn, ((PluginFinder) g.ah(PluginFinder.class)).getDraftStorage().b(gVar));
        AppMethodBeat.o(251717);
        return gVar;
    }

    public static List<g> dxq() {
        AppMethodBeat.i(251718);
        b draftStorage = ((PluginFinder) g.ah(PluginFinder.class)).getDraftStorage();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = draftStorage.db.rawQuery("SELECT * FROM FinderDraftItem  WHERE " + draftStorage.vGK + " ORDER BY " + draftStorage.TABLE + ".localId DESC", null, 2);
        while (rawQuery.moveToNext()) {
            g gVar = new g();
            gVar.convertFrom(rawQuery);
            arrayList.add(gVar);
        }
        rawQuery.close();
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(251718);
        return arrayList2;
    }

    public static void aj(int i2, long j2) {
        AppMethodBeat.i(251719);
        hu huVar = new hu();
        huVar.dMq.dJY = i2;
        huVar.dMq.localId = j2;
        EventCenter.instance.publish(huVar);
        AppMethodBeat.o(251719);
    }
}

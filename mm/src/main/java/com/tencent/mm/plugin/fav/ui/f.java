package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/fav/ui/FavFinderLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "goFinderItem", "", "context", "Landroid/content/Context;", "finderItem", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "sendFavFinderToConversation", "toUser", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "ui-fav_release"})
public final class f {
    private static final String TAG = TAG;
    public static final f teu = new f();

    static {
        AppMethodBeat.i(164109);
        AppMethodBeat.o(164109);
    }

    private f() {
    }

    public static void a(String str, g gVar) {
        bcj guk;
        AppMethodBeat.i(164107);
        p.h(str, "toUser");
        if (gVar == null) {
            Log.w(TAG, "item info is null, send fav url fail, return");
            AppMethodBeat.o(164107);
            return;
        }
        anb anb = gVar.field_favProto;
        if (anb == null || (guk = anb.guk()) == null) {
            AppMethodBeat.o(164107);
            return;
        }
        k.b bVar = new k.b();
        com.tencent.mm.plugin.i.a.f fVar = new com.tencent.mm.plugin.i.a.f();
        fVar.jlg.objectId = guk.objectId;
        fVar.jlg.objectNonceId = guk.objectNonceId;
        fVar.jlg.vXJ = guk.vXJ;
        bcj bcj = fVar.jlg;
        String str2 = guk.uNR;
        if (str2 == null) {
            str2 = "";
        }
        bcj.uNR = str2;
        fVar.jlg.nickname = guk.nickname;
        fVar.jlg.desc = guk.desc;
        fVar.jlg.dJl = guk.dJl;
        LinkedList<bch> linkedList = fVar.jlg.mediaList;
        LinkedList<bch> linkedList2 = guk.mediaList;
        p.g(linkedList2, "favFeedItem.mediaList");
        LinkedList<bch> linkedList3 = linkedList2;
        ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
        for (T t : linkedList3) {
            bch bch = new bch();
            bch.mediaType = t.mediaType;
            bch.url = t.url;
            bch.thumbUrl = t.thumbUrl;
            bch.width = t.width;
            bch.height = t.height;
            arrayList.add(bch);
        }
        linkedList.addAll(arrayList);
        bVar.a(fVar);
        bVar.type = 51;
        bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
        bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
        Log.i(TAG, "share finderObject %s to %s", guk.objectId, str);
        w.a.aSz().a(bVar, "", "", str, "", null);
        AppMethodBeat.o(164107);
    }

    public static void a(Context context, bcj bcj) {
        AppMethodBeat.i(164108);
        p.h(context, "context");
        p.h(bcj, "finderItem");
        Intent intent = new Intent();
        intent.putExtra("report_scene", 4);
        intent.putExtra("from_user", z.aTY());
        intent.putExtra("feed_object_id", d.Ga(bcj.objectId));
        intent.putExtra("feed_object_nonceId", bcj.objectNonceId);
        intent.putExtra("key_finder_teen_mode_check", true);
        intent.putExtra("key_finder_teen_mode_scene", 3);
        intent.putExtra("key_finder_teen_mode_user_name", bcj.nickname);
        intent.putExtra("key_finder_teen_mode_user_id", bcj.username);
        intent.putExtra("business_type", 0);
        intent.putExtra("finder_user_name", bcj.username);
        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).enterFinderShareFeedUI(context, intent);
        AppMethodBeat.o(164108);
    }
}

package com.tencent.mm.live.b.d;

import android.os.Bundle;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.view.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J4\u0010\u000e\u001a\u00020\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/live/model/util/LiveMessageMergeUtil;", "", "()V", "MAX_MSG_COUNT", "", "checkHeadImgUrl", "", "liveMessage", "Lcom/tencent/mm/protocal/protobuf/LiveMessage;", "checkMsgListSize", ImagesContract.LOCAL, "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "merge", "remote", "", "selfID", "", "parseTemplateMsg", "parseTemplateMsgs", "msgList", "plugin-logic_release"})
public final class b {
    public static final b hLo = new b();

    static {
        AppMethodBeat.i(207865);
        AppMethodBeat.o(207865);
    }

    private b() {
    }

    public static void a(ArrayList<a> arrayList, List<? extends cix> list, String str) {
        a b2;
        AppMethodBeat.i(207860);
        p.h(arrayList, ImagesContract.LOCAL);
        p.h(list, "remote");
        p.h(str, "selfID");
        if (arrayList.size() == 0) {
            arrayList.addAll(ah(list));
            m(arrayList);
            AppMethodBeat.o(207860);
            return;
        }
        boolean z = false;
        int i2 = ((a) j.ku(arrayList)).hXs;
        for (T t : list) {
            if (t.MnS > i2) {
                z = true;
            }
            if (z && !p.j(t.MnR, str) && (b2 = b(t)) != null) {
                arrayList.add(b2);
            }
        }
        if (list.size() - arrayList.size() > 10) {
            arrayList.clear();
            arrayList.addAll(ah(list));
        }
        m(arrayList);
        AppMethodBeat.o(207860);
    }

    private static void m(ArrayList<a> arrayList) {
        AppMethodBeat.i(207861);
        if (arrayList.size() > 3000) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size() - 3000;
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(arrayList.get(i2));
            }
            arrayList.removeAll(arrayList2);
        }
        AppMethodBeat.o(207861);
    }

    private static void a(cix cix) {
        AppMethodBeat.i(207862);
        if (!Util.isNullOrNil(cix.gzC)) {
            String str = cix.gzC;
            p.g(str, "liveMessage.headimgurl");
            if (!n.nm(str, "/0")) {
                cix.gzC += "/0";
            }
        }
        AppMethodBeat.o(207862);
    }

    private static a b(cix cix) {
        String str;
        CharSequence obj;
        AppMethodBeat.i(207863);
        a(cix);
        int i2 = cix.ybm;
        o.d dVar = o.d.hGL;
        if (i2 == o.d.aFz()) {
            CharSequence b2 = ((e) g.af(e.class)).b(cix.content, new Bundle(), null, null);
            if (b2 == null || (obj = n.trim(b2)) == null) {
                AppMethodBeat.o(207863);
                return null;
            }
            int a2 = n.a(obj, "：", 0, false, 6);
            if (a2 > 0) {
                str = obj.subSequence(0, a2).toString();
                obj = obj.subSequence(a2 + 1, obj.length());
            } else {
                str = "";
            }
        } else {
            String str2 = cix.content;
            p.g(str2, "liveMessage.content");
            if (str2 == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                AppMethodBeat.o(207863);
                throw tVar;
            }
            str = cix.MnR;
            p.g(str, "liveMessage.identity_id");
            obj = n.trim(str2).toString();
        }
        String str3 = cix.gzC;
        p.g(str3, "liveMessage.headimgurl");
        a aVar = new a(str, str3, obj, cix.ybm, cix.MnS);
        AppMethodBeat.o(207863);
        return aVar;
    }

    private static List<a> ah(List<? extends cix> list) {
        AppMethodBeat.i(207864);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            a b2 = b(it.next());
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(207864);
        return arrayList2;
    }
}

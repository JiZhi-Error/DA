package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/DiffLiveList;", "", "()V", "incrementList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "getIncrementList", "()Ljava/util/ArrayList;", "setIncrementList", "(Ljava/util/ArrayList;)V", "incrementListUsername", "", "getIncrementListUsername", "()Ljava/lang/String;", "setIncrementListUsername", "(Ljava/lang/String;)V", "removeList", "getRemoveList", "setRemoveList", "removeListUsername", "getRemoveListUsername", "setRemoveListUsername", "Companion", "plugin-finder_release"})
public final class d {
    public static final a uNN = new a((byte) 0);
    public ArrayList<y> ofD = new ArrayList<>();
    public ArrayList<y> uNK = new ArrayList<>();
    public String uNL = "";
    public String uNM = "";

    static {
        AppMethodBeat.i(248704);
        AppMethodBeat.o(248704);
    }

    public d() {
        AppMethodBeat.i(248703);
        AppMethodBeat.o(248703);
    }

    public final void ae(ArrayList<y> arrayList) {
        AppMethodBeat.i(248699);
        p.h(arrayList, "<set-?>");
        this.uNK = arrayList;
        AppMethodBeat.o(248699);
    }

    public final void af(ArrayList<y> arrayList) {
        AppMethodBeat.i(248700);
        p.h(arrayList, "<set-?>");
        this.ofD = arrayList;
        AppMethodBeat.o(248700);
    }

    public final void auf(String str) {
        AppMethodBeat.i(248701);
        p.h(str, "<set-?>");
        this.uNL = str;
        AppMethodBeat.o(248701);
    }

    public final void aug(String str) {
        AppMethodBeat.i(248702);
        p.h(str, "<set-?>");
        this.uNM = str;
        AppMethodBeat.o(248702);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bJ\"\u0010\n\u001a\u00020\u000b2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bJ\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0006j\b\u0012\u0004\u0012\u00020\u000b`\b2\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/DiffLiveList$Companion;", "", "()V", "diff", "Lcom/tencent/mm/plugin/finder/model/DiffLiveList;", "localList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "remoteList", "getLiveListUsername", "", "list", "parseLiveListUsername", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d f(ArrayList<y> arrayList, ArrayList<y> arrayList2) {
            AppMethodBeat.i(248696);
            d dVar = new d();
            if (arrayList == null && arrayList2 == null) {
                AppMethodBeat.o(248696);
                return dVar;
            } else if (arrayList == null && arrayList2 != null) {
                dVar.ae(arrayList2);
                dVar.auf(ag(arrayList2));
                x.a aVar = x.uOn;
                Log.i(x.TAG, "[updateLiveList]increment list:".concat(String.valueOf(arrayList2)));
                AppMethodBeat.o(248696);
                return dVar;
            } else if (arrayList == null || arrayList2 != null) {
                if (arrayList == null) {
                    p.hyc();
                }
                ArrayList arrayList3 = new ArrayList(arrayList);
                ArrayList<y> arrayList4 = new ArrayList<>(arrayList);
                if (arrayList2 == null) {
                    p.hyc();
                }
                ArrayList<y> arrayList5 = new ArrayList<>(arrayList2);
                arrayList3.retainAll(arrayList5);
                arrayList4.removeAll(arrayList3);
                arrayList5.removeAll(arrayList3);
                x.a aVar2 = x.uOn;
                Log.i(x.TAG, "[updateLiveList]mix list:".concat(String.valueOf(arrayList3)));
                x.a aVar3 = x.uOn;
                Log.i(x.TAG, "[updateLiveList]remove list:".concat(String.valueOf(arrayList4)));
                x.a aVar4 = x.uOn;
                Log.i(x.TAG, "[updateLiveList]increment list:".concat(String.valueOf(arrayList5)));
                dVar.af(arrayList4);
                dVar.ae(arrayList5);
                dVar.aug(ag(arrayList4));
                dVar.auf(ag(arrayList5));
                AppMethodBeat.o(248696);
                return dVar;
            } else {
                dVar.af(arrayList);
                dVar.aug(ag(arrayList));
                x.a aVar5 = x.uOn;
                Log.i(x.TAG, "[updateLiveList]remove list:".concat(String.valueOf(arrayList)));
                AppMethodBeat.o(248696);
                return dVar;
            }
        }

        public static String ag(ArrayList<y> arrayList) {
            AppMethodBeat.i(248697);
            ArrayList<y> arrayList2 = arrayList;
            if (arrayList2 == null || arrayList2.isEmpty()) {
                AppMethodBeat.o(248697);
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                FinderContact finderContact = it.next().uOo.contact;
                jSONArray.put(finderContact != null ? finderContact.username : null);
            }
            String jSONArray2 = jSONArray.toString();
            p.g(jSONArray2, "array.toString()");
            AppMethodBeat.o(248697);
            return jSONArray2;
        }

        public static ArrayList<String> auh(String str) {
            AppMethodBeat.i(248698);
            p.h(str, "list");
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = jSONArray.optString(i2);
                    if (optString == null) {
                        optString = "";
                    }
                    arrayList.add(optString);
                }
            } catch (Exception e2) {
                x.a aVar = x.uOn;
                Log.e(x.TAG, e2.getMessage());
            }
            AppMethodBeat.o(248698);
            return arrayList;
        }
    }
}

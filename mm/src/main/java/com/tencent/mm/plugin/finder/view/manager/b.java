package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.utils.d;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;
import kotlin.x;

public final class b {
    public static final String TAG = TAG;
    public static final a wsM = new a((byte) 0);
    public final ArrayList<cjj> vTC = new ArrayList<>();
    public final HashMap<String, cjj> wsG = new HashMap<>(5);
    ArrayList<d.a> wsH = new ArrayList<>();
    public int wsI;
    public int wsJ;
    private ArrayList<o<String, Integer>> wsK = new ArrayList<>();
    private HashMap<String, ArrayList<Integer>> wsL = new HashMap<>();

    /* renamed from: com.tencent.mm.plugin.finder.view.manager.b$b */
    public static final class C1343b extends q implements kotlin.g.a.q<Integer, Integer, String, x> {
        final /* synthetic */ Spannable wsN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1343b(Spannable spannable) {
            super(3);
            this.wsN = spannable;
        }

        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(Integer num, Integer num2, String str) {
            AppMethodBeat.i(255247);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            p.h(str, "nickname");
            Spannable spannable = this.wsN;
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            spannable.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.x0)), intValue, intValue2, 17);
            x xVar = x.SXb;
            AppMethodBeat.o(255247);
            return xVar;
        }
    }

    public b() {
        AppMethodBeat.i(255251);
        AppMethodBeat.o(255251);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(255252);
        AppMethodBeat.o(255252);
    }

    public static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(255249);
        bVar.be(0, "");
        AppMethodBeat.o(255249);
    }

    public final void be(int i2, String str) {
        ArrayList<Integer> arrayList;
        AppMethodBeat.i(255248);
        p.h(str, "nickname");
        this.wsI++;
        if (i2 != 0) {
            this.wsJ++;
            this.wsK.add(new o<>(str, Integer.valueOf(i2)));
            ArrayList<Integer> arrayList2 = this.wsL.get(str);
            if (arrayList2 == null) {
                arrayList = new ArrayList<>();
            } else {
                arrayList = arrayList2;
            }
            arrayList.add(Integer.valueOf(i2));
            this.wsL.put(str, arrayList);
        }
        AppMethodBeat.o(255248);
    }

    public final ArrayList<cjj> dHz() {
        AppMethodBeat.i(255250);
        ArrayList arrayList = new ArrayList();
        Iterator<cjj> it = this.vTC.iterator();
        while (it.hasNext()) {
            cjj next = it.next();
            arrayList.add(next);
            ArrayList<Integer> arrayList2 = this.wsL.get(next.nickname);
            if (arrayList2 == null) {
                next.type = 1;
            } else if (arrayList2.size() > 0) {
                Integer remove = arrayList2.remove(0);
                p.g(remove, "types.removeAt(0)");
                next.type = remove.intValue();
            }
        }
        ArrayList<cjj> arrayList3 = this.vTC;
        AppMethodBeat.o(255250);
        return arrayList3;
    }
}

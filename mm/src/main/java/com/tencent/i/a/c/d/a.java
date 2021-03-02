package com.tencent.i.a.c.d;

import com.tencent.i.a.a.c;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.c.b.i;
import com.tencent.i.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class a {
    public c SqM;
    public h.a SqZ;
    public b Stj;
    public C0145a Stk = new C0145a();

    public a(c cVar) {
        this.SqM = cVar;
    }

    /* renamed from: com.tencent.i.a.c.d.a$a  reason: collision with other inner class name */
    public class C0145a {
        final HashMap<Integer, List<g>> Stl = new HashMap<>();
        final List<i> Stm = new ArrayList();
        final List<com.tencent.i.a.c.b.h> Stn = new ArrayList();
        HashMap<String, ArrayList<Object>> Sto = new HashMap<>();

        C0145a() {
            AppMethodBeat.i(214810);
            AppMethodBeat.o(214810);
        }

        public final void clearAll() {
            AppMethodBeat.i(214811);
            this.Stl.clear();
            this.Stm.clear();
            this.Stn.clear();
            AppMethodBeat.o(214811);
        }

        public static String mN(int i2, int i3) {
            AppMethodBeat.i(214813);
            String valueOf = String.valueOf(i2);
            if (i2 == 1) {
                valueOf = valueOf + "_" + String.valueOf(i3);
            }
            AppMethodBeat.o(214813);
            return valueOf;
        }

        static int brb(String str) {
            AppMethodBeat.i(214814);
            if (str.contains("_")) {
                int intValue = Integer.valueOf(str.split("_")[0]).intValue();
                AppMethodBeat.o(214814);
                return intValue;
            }
            int intValue2 = Integer.valueOf(str).intValue();
            AppMethodBeat.o(214814);
            return intValue2;
        }

        public final ArrayList<Object> bra(String str) {
            AppMethodBeat.i(214812);
            ArrayList<Object> arrayList = this.Sto.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Sto.put(str, arrayList);
            }
            AppMethodBeat.o(214812);
            return arrayList;
        }
    }
}

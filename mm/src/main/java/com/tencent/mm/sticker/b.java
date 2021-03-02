package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import org.json.JSONArray;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, hxF = {"toDoubleArray", "", "Lorg/json/JSONArray;", "toJsonArray", "plugin-sticker_release"})
public final class b {
    public static final double[] W(JSONArray jSONArray) {
        AppMethodBeat.i(105887);
        p.h(jSONArray, "$this$toDoubleArray");
        double[] dArr = new double[jSONArray.length()];
        Iterator it = j.mY(0, jSONArray.length()).iterator();
        while (it.hasNext()) {
            int nextInt = ((ab) it).nextInt();
            dArr[nextInt] = jSONArray.getDouble(nextInt);
        }
        AppMethodBeat.o(105887);
        return dArr;
    }

    public static final JSONArray c(double[] dArr) {
        AppMethodBeat.i(105888);
        p.h(dArr, "$this$toJsonArray");
        JSONArray jSONArray = new JSONArray();
        for (double d2 : dArr) {
            jSONArray.put(d2);
        }
        AppMethodBeat.o(105888);
        return jSONArray;
    }
}

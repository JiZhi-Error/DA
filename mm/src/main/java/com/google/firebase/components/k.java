package com.google.firebase.components;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class k {
    public final m bKR;
    public final Context mContext;

    public k(Context context) {
        this(context, new l((byte) 0));
        AppMethodBeat.i(4082);
        AppMethodBeat.o(4082);
    }

    private k(Context context, m mVar) {
        this.mContext = context;
        this.bKR = mVar;
    }

    public static List<e> z(List<String> list) {
        AppMethodBeat.i(4083);
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            try {
                Class<?> cls = Class.forName(str);
                if (!e.class.isAssignableFrom(cls)) {
                    String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar");
                } else {
                    arrayList.add((e) cls.newInstance());
                }
            } catch (ClassNotFoundException e2) {
                String.format("Class %s is not an found.", str);
            } catch (IllegalAccessException e3) {
                String.format("Could not instantiate %s.", str);
            } catch (InstantiationException e4) {
                String.format("Could not instantiate %s.", str);
            }
        }
        AppMethodBeat.o(4083);
        return arrayList;
    }
}

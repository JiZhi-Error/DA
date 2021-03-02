package com.tencent.mm.plugin.expt.hellhound.a.f.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.protocal.protobuf.dvd;
import java.lang.reflect.Field;
import java.util.Iterator;

public final class a {
    public static boolean a(Activity activity, dvd dvd) {
        boolean z;
        AppMethodBeat.i(122098);
        if (dvd.MWj.isEmpty()) {
            AppMethodBeat.o(122098);
            return true;
        }
        try {
            Iterator<dvc> it = dvd.MWj.iterator();
            while (it.hasNext()) {
                dvc next = it.next();
                if (activity == null && "MoreTabUI".equals(dvd.MWb)) {
                    activity = b.cNA();
                }
                if (activity == null || next == null) {
                    z = false;
                    continue;
                } else {
                    Class<?> cls = Class.forName(next.className);
                    if (next.dataPath == null || next.dataPath.isEmpty()) {
                        z = false;
                        continue;
                    } else {
                        String[] split = next.dataPath.split(",");
                        if (split.length <= 0) {
                            z = false;
                            continue;
                        } else {
                            String[] split2 = split[0].split("\\|");
                            Field declaredField = cls.getDeclaredField(split2[0]);
                            declaredField.setAccessible(true);
                            Object obj = declaredField.get(activity);
                            if (split.length != 1) {
                                for (int i2 = 1; i2 < split.length; i2++) {
                                    Class<?> cls2 = Class.forName(split2[1]);
                                    split2 = split[i2].split("\\|");
                                    Field declaredField2 = cls2.getDeclaredField(split2[0]);
                                    declaredField2.setAccessible(true);
                                    obj = declaredField2.get(obj);
                                }
                            }
                            z = next.MWc.equals(obj);
                            continue;
                        }
                    }
                }
                if (!z) {
                    AppMethodBeat.o(122098);
                    return false;
                }
            }
            AppMethodBeat.o(122098);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(122098);
            return false;
        }
    }
}

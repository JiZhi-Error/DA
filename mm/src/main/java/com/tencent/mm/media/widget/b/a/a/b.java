package com.tencent.mm.media.widget.b.a.a;

import android.hardware.camera2.CaptureRequest;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

public final class b {
    private static final String ioS = ioS;
    private static final String ioT = "level";
    private static final String ioU = ioU;
    private static final String ioV = ioV;
    private static final String ioW = ioW;
    private static final String ioX = ioX;
    private static final String ioY = ioY;
    private static final String ioZ = ioZ;
    public static final a ipa = new a((byte) 0);
    public int ioP;
    private CaptureRequest.Builder ioQ;
    public ArrayList<a> ioR;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(CaptureRequest.Builder builder, String str, ArrayList<a> arrayList) {
        int aPU;
        p.h(builder, "mRequest");
        p.h(str, "mCameraId");
        AppMethodBeat.i(94199);
        this.ioQ = builder;
        this.ioR = arrayList;
        if (p.j(str, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            com.tencent.mm.media.widget.b.a.b bVar = com.tencent.mm.media.widget.b.a.b.iop;
            aPU = com.tencent.mm.media.widget.b.a.b.aPT();
        } else {
            com.tencent.mm.media.widget.b.a.b bVar2 = com.tencent.mm.media.widget.b.a.b.iop;
            aPU = com.tencent.mm.media.widget.b.a.b.aPU();
        }
        this.ioP = aPU;
        AppMethodBeat.o(94199);
    }

    static {
        AppMethodBeat.i(94200);
        AppMethodBeat.o(94200);
    }

    public final boolean b(String str, boolean z, int i2) {
        AppMethodBeat.i(94194);
        p.h(str, "key");
        boolean a2 = a(str, (String) null, z, (Object) null, i2);
        AppMethodBeat.o(94194);
        return a2;
    }

    public final boolean a(String str, String str2, boolean z, int i2, int i3) {
        AppMethodBeat.i(94195);
        p.h(str, "key");
        p.h(str2, "child");
        boolean a2 = a(str, str2, z, Integer.valueOf(i2), i3);
        AppMethodBeat.o(94195);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0019 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r10, java.lang.String r11, boolean r12, java.lang.Object r13, int r14) {
        /*
        // Method dump skipped, instructions count: 158
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.b.a.a.b.a(java.lang.String, java.lang.String, boolean, java.lang.Object, int):boolean");
    }

    public final boolean af(String str, int i2) {
        T t;
        boolean z;
        Integer num;
        Integer num2;
        AppMethodBeat.i(94197);
        p.h(str, "key");
        ArrayList<a> arrayList = this.ioR;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                T t2 = next;
                if (!p.j(t2.ioJ, str) || (((num = t2.ioK) != null && (num.intValue() & this.ioP) == 0) || ((num2 = t2.ioO) != null && (num2.intValue() & i2) == 0))) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            if (t != null) {
                AppMethodBeat.o(94197);
                return true;
            }
        }
        AppMethodBeat.o(94197);
        return false;
    }

    public final ArrayList<String> ak(List<String> list) {
        a aVar;
        T t;
        boolean z;
        Integer num;
        AppMethodBeat.i(94198);
        ArrayList<String> arrayList = new ArrayList<>();
        if (list != null) {
            for (T t2 : list) {
                ArrayList<a> arrayList2 = this.ioR;
                if (arrayList2 != null) {
                    Iterator<T> it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        T next = it.next();
                        T t3 = next;
                        if (!p.j(t3.ioJ, t2) || ((num = t3.ioK) != null && (num.intValue() & this.ioP) == 0)) {
                            z = false;
                            continue;
                        } else {
                            z = true;
                            continue;
                        }
                        if (z) {
                            t = next;
                            break;
                        }
                    }
                    aVar = t;
                } else {
                    aVar = null;
                }
                if ((aVar != null ? aVar.ioN : null) != null) {
                    String str = aVar.ioN;
                    if (str == null) {
                        p.hyc();
                    }
                    arrayList.add(str);
                }
            }
        }
        AppMethodBeat.o(94198);
        return arrayList;
    }
}

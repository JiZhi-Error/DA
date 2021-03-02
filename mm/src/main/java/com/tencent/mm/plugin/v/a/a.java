package com.tencent.mm.plugin.v.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.je;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    private static final SparseIntArray BxP = new SparseIntArray() {
        /* class com.tencent.mm.plugin.v.a.a.AnonymousClass9 */

        {
            AppMethodBeat.i(51546);
            put(2, 1012);
            put(1, 1013);
            AppMethodBeat.o(51546);
        }

        public final int get(int i2) {
            AppMethodBeat.i(51547);
            int i3 = super.get(i2, 1011);
            AppMethodBeat.o(51547);
            return i3;
        }
    };
    private static final SparseIntArray BxQ = new SparseIntArray() {
        /* class com.tencent.mm.plugin.v.a.a.AnonymousClass10 */

        {
            AppMethodBeat.i(51548);
            put(2, 1048);
            put(1, 1049);
            AppMethodBeat.o(51548);
        }

        public final int get(int i2) {
            AppMethodBeat.i(51549);
            int i3 = super.get(i2, 1047);
            AppMethodBeat.o(51549);
            return i3;
        }
    };
    private static final SparseIntArray BxR = new SparseIntArray() {
        /* class com.tencent.mm.plugin.v.a.a.AnonymousClass2 */

        {
            AppMethodBeat.i(240701);
            put(2, 1125);
            put(1, 1126);
            AppMethodBeat.o(240701);
        }

        public final int get(int i2) {
            AppMethodBeat.i(240702);
            int i3 = super.get(i2, 1124);
            AppMethodBeat.o(240702);
            return i3;
        }
    };

    /* renamed from: com.tencent.mm.plugin.v.a.a$a  reason: collision with other inner class name */
    public interface AbstractC1847a {
        Context getContext();

        void sU(boolean z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:200:0x0c3f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x026a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(final com.tencent.mm.plugin.v.a.a.AbstractC1847a r16, final com.tencent.mm.modelsimple.l r17, final android.content.DialogInterface.OnClickListener r18, java.lang.String r19, final int r20, final int r21, java.lang.Runnable r22, android.os.Bundle r23) {
        /*
        // Method dump skipped, instructions count: 3234
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.v.a.a.a(com.tencent.mm.plugin.v.a.a$a, com.tencent.mm.modelsimple.l, android.content.DialogInterface$OnClickListener, java.lang.String, int, int, java.lang.Runnable, android.os.Bundle):boolean");
    }

    private static void a(final AbstractC1847a aVar, int i2, String str, int i3) {
        AppMethodBeat.i(51551);
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", Integer.valueOf(i2), str);
        Context context = aVar != null ? aVar.getContext() : null;
        if (context == null) {
            AppMethodBeat.o(51551);
            return;
        }
        final je jeVar = new je();
        jeVar.dNT.actionCode = i2;
        jeVar.dNT.result = str;
        jeVar.dNT.context = context;
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", i3);
        jeVar.dNT.dNV = bundle;
        jeVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.v.a.a.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(240705);
                if (aVar == null || jeVar == null || jeVar.dNU == null) {
                    AppMethodBeat.o(240705);
                } else if (jeVar.dNU.ret == 1) {
                    aVar.sU(true);
                    AppMethodBeat.o(240705);
                } else {
                    if (jeVar.dNU.ret == 2) {
                        aVar.sU(false);
                    }
                    AppMethodBeat.o(240705);
                }
            }
        };
        EventCenter.instance.asyncPublish(jeVar, Looper.myLooper());
        AppMethodBeat.o(51551);
    }

    protected static int Vl(int i2) {
        if (i2 == 30 || i2 == 37 || i2 == 38 || i2 == 40) {
            return 13;
        }
        if (i2 == 4 || i2 == 47) {
            return 12;
        }
        if (i2 == 34) {
            return 24;
        }
        return 0;
    }

    static {
        AppMethodBeat.i(51552);
        AppMethodBeat.o(51552);
    }
}

package com.tencent.mm.recoveryv2;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.a;
import com.tencent.mm.recoveryv2.j;
import com.tencent.mm.recoveryv2.l;
import java.util.HashMap;
import java.util.Map;

public class k {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile k NCr;
    public j NCs;
    public final Map<String, e> NCt = new HashMap();
    public Context mContext;

    public static k guX() {
        AppMethodBeat.i(193864);
        if (NCr == null) {
            synchronized (k.class) {
                try {
                    if (NCr == null) {
                        NCr = new k();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(193864);
                    throw th;
                }
            }
        }
        k kVar = NCr;
        AppMethodBeat.o(193864);
        return kVar;
    }

    private k() {
        AppMethodBeat.i(193865);
        AppMethodBeat.o(193865);
    }

    public final Context getContext() {
        AppMethodBeat.i(193866);
        if (this.mContext == null) {
            this.mContext = l.a.gva().getApplicationContext();
            l.checkNotNull(this.mContext, "Context should not be null");
        }
        Context context = this.mContext;
        AppMethodBeat.o(193866);
        return context;
    }

    public final k b(int i2, d dVar) {
        AppMethodBeat.i(193867);
        if (this.NCs == null) {
            guY();
        }
        this.NCs.a(i2, dVar);
        AppMethodBeat.o(193867);
        return this;
    }

    public final void unregister() {
        AppMethodBeat.i(193868);
        if (this.NCs != null) {
            this.NCs.finish();
        }
        AppMethodBeat.o(193868);
    }

    public final void ajx(int i2) {
        AppMethodBeat.i(193869);
        if (!l.cv(getContext(), "")) {
            a.C2043a.log(4, "MicroMsg.recovery", "not main proc, skip");
            AppMethodBeat.o(193869);
        } else if (this.NCs instanceof j.e) {
            ((j.e) this.NCs).aju(i2);
            AppMethodBeat.o(193869);
        } else if (this.NCs instanceof j.b) {
            ((j.b) this.NCs).ajt(i2);
            AppMethodBeat.o(193869);
        } else {
            new j.e(getContext()).aju(i2);
            AppMethodBeat.o(193869);
        }
    }

    public final void guY() {
        AppMethodBeat.i(193870);
        this.NCs = new j.b(getContext());
        AppMethodBeat.o(193870);
    }

    public final void a(String str, e eVar) {
        AppMethodBeat.i(193871);
        try {
            if (this.NCt.containsKey(str)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str + " has been registered! target = " + this.NCt.get(str));
                AppMethodBeat.o(193871);
                throw illegalArgumentException;
            }
            eVar.guu();
            this.NCt.put(str, eVar);
            AppMethodBeat.o(193871);
        } catch (Throwable th) {
            a.w("MicroMsg.recovery", "register actions fail", th);
            AppMethodBeat.o(193871);
        }
    }

    public static boolean iS(Context context) {
        AppMethodBeat.i(258773);
        boolean cv = l.cv(context, "");
        AppMethodBeat.o(258773);
        return cv;
    }

    public static boolean iT(Context context) {
        AppMethodBeat.i(193873);
        boolean cv = l.cv(context, ":recovery");
        AppMethodBeat.o(193873);
        return cv;
    }

    public static String guZ() {
        return ":recovery";
    }
}

package com.tencent.b.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class i {
    private static i dfM = null;
    static f dfN = null;
    public static volatile long dfO = 0;
    static h dfP = null;
    public static Context mContext = null;
    public static Handler mHandler = null;
    private g dfQ = null;

    private i(Context context) {
        AppMethodBeat.i(87653);
        HandlerThread handlerThread = new HandlerThread(i.class.getSimpleName());
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper());
        Context applicationContext = context.getApplicationContext();
        mContext = applicationContext;
        dfO = PreferenceManager.getDefaultSharedPreferences(applicationContext).getLong("__MID_LAST_CHECK_TIME__", 0);
        AppMethodBeat.o(87653);
    }

    public static i bq(Context context) {
        AppMethodBeat.i(87654);
        if (dfM == null) {
            synchronized (i.class) {
                try {
                    if (dfM == null) {
                        dfM = new i(context);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(87654);
                    throw th;
                }
            }
        }
        i iVar = dfM;
        AppMethodBeat.o(87654);
        return iVar;
    }

    public static void a(f fVar) {
        dfN = fVar;
    }

    public final String TZ() {
        int i2;
        AppMethodBeat.i(87655);
        if (this.dfQ == null || !s.eZ(this.dfQ.dfK)) {
            this.dfQ = r.bs(mContext).Ud();
            if (s.eZ(this.dfQ.dfK)) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            if (mHandler != null) {
                mHandler.post(new n(mContext, i2));
            }
            new StringBuilder("wx get mid:").append(this.dfQ.dfK);
        }
        String str = this.dfQ.dfK;
        AppMethodBeat.o(87655);
        return str;
    }

    public final String Ua() {
        AppMethodBeat.i(87656);
        if (this.dfQ == null || !s.eZ(this.dfQ.dfK)) {
            this.dfQ = r.bs(mContext).Ud();
        }
        String str = this.dfQ.dfK;
        AppMethodBeat.o(87656);
        return str;
    }
}

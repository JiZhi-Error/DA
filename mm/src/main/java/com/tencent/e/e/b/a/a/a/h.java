package com.tencent.e.e.b.a.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.e.e.b.a.a.a;
import com.tencent.e.e.b.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class h implements a {
    private c RNM;
    private String RNU = "";
    private int mErrorCode = -1;
    private long mTime = -1;

    @Override // com.tencent.e.e.b.a.a.a
    public final synchronized c kV(Context context) {
        c aqC;
        AppMethodBeat.i(138445);
        if (!dKp()) {
            this.mErrorCode = -205;
            aqC = c.aqC(this.mErrorCode);
            AppMethodBeat.o(138445);
        } else if (this.RNM == null || this.RNM.errorCode != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.mErrorCode = 0;
            try {
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                if (query == null) {
                    this.mErrorCode = -201;
                    aqC = c.aqC(this.mErrorCode);
                    AppMethodBeat.o(138445);
                } else {
                    if (query.moveToNext()) {
                        try {
                            this.RNU = query.getString(query.getColumnIndex("value"));
                            try {
                                query.close();
                            } catch (Throwable th) {
                            }
                        } catch (Throwable th2) {
                        }
                    } else {
                        this.mErrorCode = -202;
                    }
                    this.mTime = System.currentTimeMillis() - currentTimeMillis;
                    aqC = new c(this.RNU, this.mErrorCode);
                    AppMethodBeat.o(138445);
                }
            } catch (Throwable th3) {
                this.mErrorCode = -200;
                aqC = c.aqC(this.mErrorCode);
                AppMethodBeat.o(138445);
            }
        } else {
            aqC = this.RNM;
            AppMethodBeat.o(138445);
        }
        return aqC;
    }

    private static boolean dKp() {
        AppMethodBeat.i(138446);
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("get", String.class, String.class);
            method.setAccessible(true);
            boolean equals = "1".equals((String) method.invoke(cls, "persist.sys.identifierid.supported", AppEventsConstants.EVENT_PARAM_VALUE_NO));
            AppMethodBeat.o(138446);
            return equals;
        } catch (Throwable th) {
            AppMethodBeat.o(138446);
            return false;
        }
    }
}

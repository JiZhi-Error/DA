package com.b.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.os.Build;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.Base64;
import com.b.a.a.d;
import com.b.a.a.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import org.json.JSONObject;

final class r extends d {
    private static final DecimalFormat ckg = new DecimalFormat("0000000000");
    private static final DecimalFormat ckh = new DecimalFormat("0000000000000000");
    private static r cki;
    private String ckj;
    private String ckk;
    private final b ckl = new b((byte) 0);
    private int ckm;
    z ckn;
    private SharedPreferences cko;
    private f ckp;
    private final Object ckq = new Object();
    private final d ckr = new d(this, (byte) 0);
    q cks;
    String ckt;
    private int mRetryCount;

    static {
        AppMethodBeat.i(87891);
        AppMethodBeat.o(87891);
    }

    private r() {
        AppMethodBeat.i(87892);
        AppMethodBeat.o(87892);
    }

    static r Jg() {
        AppMethodBeat.i(87893);
        if (cki == null) {
            cki = new r();
        }
        r rVar = cki;
        AppMethodBeat.o(87893);
        return rVar;
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void au(Context context) {
        AppMethodBeat.i(87894);
        try {
            String str = this.ckt;
            if (TextUtils.isEmpty(str)) {
                str = "0000000000";
            }
            this.ckj = cD(str);
            this.ckk = a(Long.valueOf(System.currentTimeMillis() / 1000));
            this.ckp = new f(context);
        } catch (Exception e2) {
        }
        this.cko = context.getSharedPreferences("0-474-85242", 0);
        AppMethodBeat.o(87894);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void a(Context context, Handler handler, d.a aVar) {
        AppMethodBeat.i(87895);
        this.ckn = z.b(handler);
        Jh();
        AppMethodBeat.o(87895);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void av(Context context) {
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void IV() {
        this.cks = null;
    }

    /* access modifiers changed from: package-private */
    public final void Jh() {
        AppMethodBeat.i(87896);
        if (this.ckn != null) {
            try {
                this.ckn.execute(d.a(this.ckr));
                AppMethodBeat.o(87896);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(87896);
    }

    /* access modifiers changed from: package-private */
    public final void cB(String str) {
        AppMethodBeat.i(87897);
        if (this.ckn != null) {
            this.ckn.execute(new c(this, str, 0, 1, (byte) 0));
        }
        AppMethodBeat.o(87897);
    }

    /* access modifiers changed from: package-private */
    public final boolean Ji() {
        return this.ckl.code == 1;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static f h(String str, long j2, long j3) {
        AppMethodBeat.i(87898);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errorcode", -5);
            if (optInt != 0) {
                f fVar = new f(optInt, null, null, (byte) 0);
                AppMethodBeat.o(87898);
                return fVar;
            }
            long optLong = jSONObject.optLong("hitarea", 0);
            String str2 = new String(Base64.decode(jSONObject.optString("swdata", null), 0), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            if (y.cnn) {
                o.t("data_transaction_log_" + y.cnu, str2);
            }
            if (str2.length() <= h.chR || !str2.startsWith("$UP,")) {
                Exception exc = new Exception("OnlineModule: parse data upload reply and generate msg: invalid arg");
                AppMethodBeat.o(87898);
                throw exc;
            }
            switch (str2.charAt(h.chR)) {
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    f fVar2 = new f(0, null, str2.length() > h.chS ? str2.substring(h.chS) : null, (byte) 0);
                    AppMethodBeat.o(87898);
                    return fVar2;
                case '1':
                    if (str2.length() > h.chS) {
                        x o = o(str2.substring(h.chS), optLong);
                        o.cnb = j2;
                        o.ckz = j3;
                        f fVar3 = new f(1, o, null, (byte) 0);
                        AppMethodBeat.o(87898);
                        return fVar3;
                    }
                    break;
                case '2':
                    f fVar4 = new f(2, null, str2.length() > h.chS ? str2.substring(h.chS) : null, (byte) 0);
                    AppMethodBeat.o(87898);
                    return fVar4;
                case '3':
                    f fVar5 = new f(3, null, str2.length() > h.chS ? str2.substring(h.chS) : null, (byte) 0);
                    AppMethodBeat.o(87898);
                    return fVar5;
                case '4':
                    f fVar6 = new f(4, null, str2.length() > h.chS ? str2.substring(h.chS) : null, (byte) 0);
                    AppMethodBeat.o(87898);
                    return fVar6;
                case '5':
                    f fVar7 = new f(5, null, str2.length() > h.chS ? str2.substring(h.chS) : null, (byte) 0);
                    AppMethodBeat.o(87898);
                    return fVar7;
                case '6':
                    f fVar8 = new f(6, null, str2.length() > h.chS ? str2.substring(h.chS) : null, (byte) 0);
                    AppMethodBeat.o(87898);
                    return fVar8;
            }
            Exception exc2 = new Exception("OnlineModule: unable to parse data upload reply");
            AppMethodBeat.o(87898);
            throw exc2;
        } catch (Exception e2) {
            if (y.cnn) {
                o.t("data_transaction_log_" + y.cnu, "parse json data error");
            }
            Exception exc3 = new Exception("parse json data error");
            AppMethodBeat.o(87898);
            throw exc3;
        }
    }

    private static x o(String str, long j2) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        AppMethodBeat.i(87899);
        if (str != null) {
            String[] split = str.split(",", -1);
            if (split.length == 10) {
                try {
                    double parseDouble = Double.parseDouble(split[0]);
                    double parseDouble2 = Double.parseDouble(split[1]);
                    float parseFloat = Float.parseFloat(split[8]);
                    try {
                        i2 = Integer.parseInt(split[3]);
                    } catch (NumberFormatException e2) {
                        i2 = 0;
                    }
                    try {
                        i3 = Integer.parseInt(split[4]);
                    } catch (NumberFormatException e3) {
                        i3 = 0;
                    }
                    try {
                        i4 = Integer.parseInt(split[5]);
                    } catch (NumberFormatException e4) {
                        i4 = 0;
                    }
                    try {
                        i5 = Integer.parseInt(split[7]);
                    } catch (NumberFormatException e5) {
                    }
                    float f2 = 0.0f;
                    try {
                        f2 = Float.parseFloat(split[9]);
                    } catch (NumberFormatException e6) {
                    }
                    x xVar = new x();
                    xVar.latitude = parseDouble;
                    xVar.longitude = parseDouble2;
                    xVar.cmZ = split[2];
                    xVar.level = i2;
                    xVar.cna = (long) i3;
                    xVar.cnd = i4;
                    xVar.provider = split[6];
                    xVar.cne = i5;
                    xVar.cjn = parseFloat;
                    if (xVar.cnc == null) {
                        xVar.cnc = new x.a();
                    }
                    xVar.cnc.cnf = f2;
                    xVar.cjS = j2;
                    AppMethodBeat.o(87899);
                    return xVar;
                } catch (NumberFormatException e7) {
                }
            }
        }
        Exception exc = new Exception("OnlineModule: unable to get location from data upload reply");
        AppMethodBeat.o(87899);
        throw exc;
    }

    static /* synthetic */ void a(r rVar, String str, long j2) {
        AppMethodBeat.i(87910);
        rVar.p(str, j2);
        AppMethodBeat.o(87910);
    }

    private void p(String str, long j2) {
        String replace;
        String str2 = null;
        AppMethodBeat.i(87900);
        if (str != null && !str.startsWith("&OD[]=")) {
            String cF = v.cF(v.cG(str));
            if (cF == null) {
                replace = null;
            } else {
                replace = cF.replace("&MD=", "|MD,");
            }
            if (replace != null) {
                str2 = replace.replace("&WD[]=", "|WD,");
            }
            str = v.b(str2, j2, "1");
        }
        cC(str);
        AppMethodBeat.o(87900);
    }

    static /* synthetic */ void a(r rVar, String str) {
        AppMethodBeat.i(87911);
        rVar.cC(str);
        AppMethodBeat.o(87911);
    }

    @SuppressLint({"NewApi"})
    private void cC(String str) {
        AppMethodBeat.i(87901);
        if (str == null) {
            AppMethodBeat.o(87901);
            return;
        }
        synchronized (this.ckq) {
            try {
                String str2 = String.valueOf(Jl().getString("1-115-10127", "")) + str;
                int length = str2.length() - 307200;
                if (length > 0) {
                    int indexOf = str2.indexOf("&OD[]=", length);
                    str2 = indexOf >= length ? str2.substring(indexOf) : "";
                }
                if (Build.VERSION.SDK_INT >= 9) {
                    Jl().edit().putString("1-115-10127", str2).apply();
                } else {
                    Jl().edit().putString("1-115-10127", str2).commit();
                }
            } catch (Exception e2) {
            } catch (Error e3) {
                try {
                    if (Build.VERSION.SDK_INT >= 9) {
                        Jl().edit().putString("1-115-10127", "").apply();
                    } else {
                        Jl().edit().putString("1-115-10127", "").commit();
                    }
                } catch (Exception e4) {
                }
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(87901);
                throw th;
            }
        }
        AppMethodBeat.o(87901);
    }

    private String Jj() {
        AppMethodBeat.i(87902);
        try {
            String string = Jl().getString("1-115-10127", "");
            AppMethodBeat.o(87902);
            return string;
        } catch (Exception e2) {
            AppMethodBeat.o(87902);
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    private void Jk() {
        AppMethodBeat.i(87903);
        try {
            if (Build.VERSION.SDK_INT >= 9) {
                Jl().edit().remove("1-115-10127").apply();
                AppMethodBeat.o(87903);
                return;
            }
            Jl().edit().remove("1-115-10127").commit();
            AppMethodBeat.o(87903);
        } catch (Exception e2) {
            AppMethodBeat.o(87903);
        }
    }

    private SharedPreferences Jl() {
        AppMethodBeat.i(87904);
        if (this.cko == null) {
            Exception exc = new Exception("OnlineModule: data buffer unavailable");
            AppMethodBeat.o(87904);
            throw exc;
        }
        SharedPreferences sharedPreferences = this.cko;
        AppMethodBeat.o(87904);
        return sharedPreferences;
    }

    private synchronized void Jm() {
        AppMethodBeat.i(87905);
        String str = this.ckj;
        String str2 = this.ckk;
        b bVar = this.ckl;
        if (str == null || str2 == null || bVar == null) {
            Exception exc = new Exception("OnlineModule: authenticate: null arg");
            AppMethodBeat.o(87905);
            throw exc;
        }
        System.arraycopy((String.valueOf(str) + str2).getBytes(), 0, bVar.ckv, 0, 27);
        bVar.code = 1;
        AppMethodBeat.o(87905);
    }

    private static String cD(String str) {
        AppMethodBeat.i(87906);
        try {
            String str2 = "T" + ckh.format(Long.parseLong(str) + System.currentTimeMillis());
            AppMethodBeat.o(87906);
            return str2;
        } catch (NumberFormatException e2) {
            Exception exc = new Exception("OnlineModule: invalid device id, type: 0");
            AppMethodBeat.o(87906);
            throw exc;
        }
    }

    private static String a(Long l) {
        AppMethodBeat.i(87907);
        if (l == null) {
            Exception exc = new Exception("OnlineModule: null source id");
            AppMethodBeat.o(87907);
            throw exc;
        }
        try {
            String format = ckg.format(l);
            AppMethodBeat.o(87907);
            return format;
        } catch (NumberFormatException e2) {
            Exception exc2 = new Exception("OnlineModule: invalid source id");
            AppMethodBeat.o(87907);
            throw exc2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        final byte[] ckv;
        int code;
        private final byte[] sessionKey;

        private b() {
            AppMethodBeat.i(87885);
            this.code = -1;
            this.ckv = new byte[27];
            this.sessionKey = new byte[8];
            AppMethodBeat.o(87885);
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static abstract class a implements Runnable {
        private final WeakReference<r> cku;

        private a(r rVar) {
            this.cku = new WeakReference<>(rVar);
        }

        /* synthetic */ a(r rVar, byte b2) {
            this(rVar);
        }

        /* access modifiers changed from: package-private */
        public final r Jn() {
            r rVar = this.cku.get();
            if (rVar != null) {
                return rVar;
            }
            throw new Exception("OnlineModule.AbstractOnlineModuleRunnable: online module not available");
        }
    }

    /* access modifiers changed from: package-private */
    public static class d extends a {
        private boolean cky;

        /* synthetic */ d(r rVar, byte b2) {
            this(rVar);
        }

        private d(r rVar) {
            super(rVar, (byte) 0);
        }

        public final void run() {
            AppMethodBeat.i(87887);
            try {
                r.a(Jn());
                f fVar = Jn().ckp;
                try {
                    fVar.chG = Build.MODEL;
                    fVar.chH = Build.VERSION.RELEASE;
                    fVar.versionName = fVar.mPackageInfo.versionName;
                    CharSequence loadLabel = fVar.mContext.getApplicationInfo().loadLabel(fVar.chE);
                    fVar.chF = loadLabel != null ? loadLabel.toString() : "unknown";
                    if (fVar.mSensorManager != null) {
                        Sensor defaultSensor = fVar.mSensorManager.getDefaultSensor(1);
                        Sensor defaultSensor2 = fVar.mSensorManager.getDefaultSensor(4);
                        Sensor defaultSensor3 = fVar.mSensorManager.getDefaultSensor(2);
                        Sensor defaultSensor4 = fVar.mSensorManager.getDefaultSensor(11);
                        if (defaultSensor != null) {
                            fVar.chK = 1;
                        }
                        if (defaultSensor2 != null) {
                            fVar.chL = 1;
                        }
                        if (defaultSensor3 != null) {
                            fVar.chM = 1;
                        }
                        if (defaultSensor4 != null) {
                            fVar.chN = 1;
                        }
                    }
                } catch (Error | Exception e2) {
                }
            } catch (Exception e3) {
            }
            this.cky = false;
            AppMethodBeat.o(87887);
        }

        static /* synthetic */ d a(d dVar) {
            AppMethodBeat.i(87888);
            if (dVar.cky) {
                Exception exc = new Exception("OnlineModule: new-session runnable occupied");
                AppMethodBeat.o(87888);
                throw exc;
            }
            dVar.cky = true;
            AppMethodBeat.o(87888);
            return dVar;
        }
    }

    static class e extends a {
        private final int cjO;
        private final boolean ckA;
        private final String ckw;
        private final long ckx;
        private final long ckz;

        /* synthetic */ e(r rVar, String str, long j2, long j3, int i2) {
            this(rVar, str, j2, j3, i2, true);
        }

        private e(r rVar, String str, long j2, long j3, int i2, boolean z) {
            super(rVar, (byte) 0);
            this.ckw = str;
            this.ckx = j2;
            this.ckz = j3;
            this.cjO = i2;
            this.ckA = true;
        }

        public final void run() {
            AppMethodBeat.i(87889);
            try {
                r.a(Jn(), this.ckw, this.ckx, this.ckz, this.cjO, this.ckA);
                AppMethodBeat.o(87889);
            } catch (Exception e2) {
                AppMethodBeat.o(87889);
            }
        }
    }

    static class c extends a {
        private final String ckw;
        private final long ckx;
        private final int dataType;

        /* synthetic */ c(r rVar, String str, long j2, int i2, byte b2) {
            this(rVar, str, j2, i2);
        }

        private c(r rVar, String str, long j2, int i2) {
            super(rVar, (byte) 0);
            this.ckw = str;
            this.ckx = j2;
            this.dataType = i2;
        }

        public final void run() {
            AppMethodBeat.i(87886);
            try {
                switch (this.dataType) {
                    case 0:
                        r.a(Jn(), this.ckw, this.ckx);
                        AppMethodBeat.o(87886);
                        return;
                    case 1:
                        r.a(Jn(), this.ckw);
                        break;
                }
                AppMethodBeat.o(87886);
            } catch (Exception e2) {
                AppMethodBeat.o(87886);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class f extends p {
        final x ckB;
        final boolean ckC;
        final String message;
        final int resultCode;

        /* synthetic */ f(int i2, x xVar, String str, byte b2) {
            this(i2, xVar, str);
        }

        private f(int i2, x xVar, String str) {
            super(202);
            AppMethodBeat.i(87890);
            this.resultCode = i2;
            this.ckB = xVar;
            this.message = str;
            this.ckC = (this.resultCode < 0 || this.resultCode == 4 || this.resultCode == 2) ? false : true;
            AppMethodBeat.o(87890);
        }
    }

    static /* synthetic */ void a(r rVar) {
        AppMethodBeat.i(87908);
        try {
            rVar.Jm();
            if (rVar.Ji()) {
                rVar.ckm = 0;
                AppMethodBeat.o(87908);
                return;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(87908);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.b.a.a.r r18, java.lang.String r19, long r20, long r22, int r24, boolean r25) {
        /*
        // Method dump skipped, instructions count: 503
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.r.a(com.b.a.a.r, java.lang.String, long, long, int, boolean):void");
    }
}

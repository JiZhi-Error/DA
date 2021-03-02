package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.a;
import com.tencent.mm.recoveryv2.g;
import com.tencent.mm.recoveryv2.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class h {
    public int NBK = Math.max(this.NBQ.getInt("setting_threshold_1", 3), 2);
    public int NBL = Math.max(this.NBQ.getInt("setting_threshold_2", 5), 3);
    public long NBM;
    public long NBN;
    public long NBO;
    public long NBP;
    public g NBQ;

    public static h iM(Context context) {
        AppMethodBeat.i(193831);
        h hVar = new h(context);
        AppMethodBeat.o(193831);
        return hVar;
    }

    private h(Context context) {
        AppMethodBeat.i(193832);
        this.NBQ = new g.b(context, "recovery_setting");
        this.NBQ.guE();
        if (this.NBL < this.NBK) {
            this.NBL = this.NBK;
        }
        this.NBM = Math.max(this.NBQ.getLong("setting_crash_interval", 10000), 5000L);
        this.NBN = Math.max(this.NBQ.getLong("setting_crash_interval_sub", 30000), 5000L);
        this.NBO = Math.max(this.NBQ.getLong("setting_crash_minimal_interval", 1000), 0L);
        this.NBP = Math.max(this.NBQ.getLong("setting_reset_delay", 5000), 1000L);
        AppMethodBeat.o(193832);
    }

    public static class a {
        public final g NBQ;
        public boolean mEnabled = this.NBQ.getBoolean("enable", true);

        public static a iN(Context context) {
            AppMethodBeat.i(193821);
            a aVar = new a(context);
            AppMethodBeat.o(193821);
            return aVar;
        }

        private a(Context context) {
            AppMethodBeat.i(193822);
            this.NBQ = new g.b(context, "recovery_enable").guE();
            AppMethodBeat.o(193822);
        }
    }

    public static class b {
        private static final long kVD = (TimeUnit.DAYS.toMillis(1) / 2);
        private final g NBQ;
        long NBR = this.NBQ.getLong("internal_last_ui_launched", 0);
        long NBS = this.NBQ.getLong("internal_ui_launch_interval", kVD);

        static {
            AppMethodBeat.i(193826);
            AppMethodBeat.o(193826);
        }

        public static b iO(Context context) {
            AppMethodBeat.i(193823);
            b bVar = new b(context);
            AppMethodBeat.o(193823);
            return bVar;
        }

        private b(Context context) {
            AppMethodBeat.i(193824);
            this.NBQ = new g.b(context, "recovery_internal").guE();
            AppMethodBeat.o(193824);
        }

        public final void save() {
            AppMethodBeat.i(193825);
            this.NBQ.bT("internal_last_ui_launched", this.NBR).bT("internal_ui_launch_interval", this.NBS).guF();
            AppMethodBeat.o(193825);
        }
    }

    public static class c {
        private final g NBQ;
        public String NBT;
        private final Context mContext;

        public static c iP(Context context) {
            AppMethodBeat.i(193827);
            c cVar = new c(context);
            AppMethodBeat.o(193827);
            return cVar;
        }

        private c(Context context) {
            AppMethodBeat.i(193828);
            this.mContext = context;
            this.NBQ = new g.a(context, "recovery_log").guE();
            String absolutePath = new File(l.iU(context), ".log").getAbsolutePath();
            String string = this.NBQ.getString("setting_log_path", absolutePath);
            try {
                l.b.O(new File(string));
            } catch (Throwable th) {
                this.NBQ.bhB("setting_log_path");
                string = absolutePath;
            }
            this.NBT = string;
            AppMethodBeat.o(193828);
        }

        public final void guM() {
            AppMethodBeat.i(193829);
            a.C2043a.L(new File(this.NBT));
            AppMethodBeat.o(193829);
        }

        public final String guN() {
            BufferedReader bufferedReader;
            Throwable th;
            AppMethodBeat.i(193830);
            File file = new File(this.NBT);
            if (!file.exists()) {
                AppMethodBeat.o(193830);
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                            sb.append('\n');
                        } else {
                            l.b.closeQuietly(bufferedReader);
                            String sb2 = sb.toString();
                            AppMethodBeat.o(193830);
                            return sb2;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            a.w("MicroMsg.recovery.logConfig", "read log content fail", e);
                            l.b.closeQuietly(bufferedReader);
                            AppMethodBeat.o(193830);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            l.b.closeQuietly(bufferedReader);
                            AppMethodBeat.o(193830);
                            throw th;
                        }
                    }
                }
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
                a.w("MicroMsg.recovery.logConfig", "read log content fail", e);
                l.b.closeQuietly(bufferedReader);
                AppMethodBeat.o(193830);
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                l.b.closeQuietly(bufferedReader);
                AppMethodBeat.o(193830);
                throw th;
            }
        }
    }
}

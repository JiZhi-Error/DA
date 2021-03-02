package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class aq {
    private static aq IFm = new aq();
    public a IFk = new a();
    private boolean IFl;

    static {
        AppMethodBeat.i(117764);
        AppMethodBeat.o(117764);
    }

    public static aq fYk() {
        return IFm;
    }

    private aq() {
        AppMethodBeat.i(117760);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_FTS_DISCOVERY_RED_XML_STRING, "");
        a aVar = this.IFk;
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                aVar.id = Util.safeFormatString(split[0], new Object[0]);
                aVar.IFn = Util.safeParseInt(split[1]);
                aVar.IFo = Util.safeParseInt(split[2]);
                aVar.jIU = Util.safeParseLong(split[3]);
                aVar.IEj = Util.safeParseInt(split[4]);
                aVar.type = Util.safeParseInt(split[5]);
                aVar.text = split[6];
                aVar.icon = split[7];
                aVar.timestamp = Util.safeParseLong(split[8]);
                aVar.IFp = Util.safeParseInt(split[9]);
                aVar.iUm = Util.safeParseLong(split[10]);
                aVar.IFq = Util.safeParseInt(split[11]);
            }
            AppMethodBeat.o(117760);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchRedPointMgr", e2, "", new Object[0]);
            AppMethodBeat.o(117760);
        }
    }

    public final void save() {
        AppMethodBeat.i(117761);
        g.aAh().azQ().set(ar.a.USERINFO_FTS_DISCOVERY_RED_XML_STRING, this.IFk == null ? "" : this.IFk.bGg());
        AppMethodBeat.o(117761);
    }

    public static class a {
        public int IEj;
        public int IFn;
        public int IFo;
        public int IFp;
        int IFq;
        public int clear;
        public long iUm = System.currentTimeMillis();
        public String icon;
        public String id;
        public long jIU;
        public String text;
        public long timestamp;
        public int type;

        public a() {
            AppMethodBeat.i(117756);
            AppMethodBeat.o(117756);
        }

        private boolean isExpired() {
            AppMethodBeat.i(117757);
            if (System.currentTimeMillis() > this.iUm + (this.jIU * 1000)) {
                AppMethodBeat.o(117757);
                return true;
            }
            AppMethodBeat.o(117757);
            return false;
        }

        public final boolean isValid() {
            boolean z;
            AppMethodBeat.i(117758);
            if (this.clear == 1) {
                AppMethodBeat.o(117758);
                return false;
            } else if (this.IFo > d.KyO) {
                Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", this.id, Integer.valueOf(this.IFo), Integer.valueOf(d.KyO));
                AppMethodBeat.o(117758);
                return false;
            } else if (isExpired()) {
                Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", this.id);
                AppMethodBeat.o(117758);
                return false;
            } else {
                String str = this.IFn + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
                Object[] objArr = new Object[5];
                if (ai.aft(0) >= this.IEj) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = Integer.valueOf(this.IEj);
                objArr[2] = Integer.valueOf(ai.aft(0));
                objArr[3] = Long.valueOf(this.timestamp);
                objArr[4] = Long.valueOf(aq.fYl());
                Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", str, objArr);
                if (ai.aft(0) < this.IEj || this.timestamp <= aq.fYl()) {
                    AppMethodBeat.o(117758);
                    return false;
                }
                AppMethodBeat.o(117758);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final String bGg() {
            AppMethodBeat.i(117759);
            String str = this.id + "&" + this.IFn + "&" + this.IFo + "&" + this.jIU + "&" + this.IEj + "&" + this.type + "&" + this.text + "&" + this.icon + "&" + this.timestamp + "&" + this.IFp + "&" + this.iUm + "&" + this.IFq;
            AppMethodBeat.o(117759);
            return str;
        }
    }

    public static long fYl() {
        AppMethodBeat.i(117762);
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_SEARCH_REDDOT_LONG, (Object) null);
        if (obj == null) {
            AppMethodBeat.o(117762);
            return 0;
        }
        long longValue = ((Long) obj).longValue();
        AppMethodBeat.o(117762);
        return longValue;
    }

    public final void afy(int i2) {
        int i3 = 0;
        AppMethodBeat.i(117763);
        if (this.IFk != null) {
            boolean isValid = this.IFk.isValid();
            if (!this.IFl || i2 != 1 || isValid) {
                String str = this.IFk.id;
                if (str == null || str.equals(BuildConfig.COMMAND)) {
                    str = "";
                }
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(i2);
                if (isValid) {
                    i3 = 1;
                }
                objArr[1] = Integer.valueOf(i3);
                objArr[2] = str;
                objArr[3] = Long.valueOf(System.currentTimeMillis());
                String format = String.format("%d,%d,%s,%d", objArr);
                Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "report websearch reddot 17513: ".concat(String.valueOf(format)));
                e.INSTANCE.kvStat(17513, format);
                if (i2 == 1 && !isValid) {
                    this.IFl = true;
                }
            } else {
                AppMethodBeat.o(117763);
                return;
            }
        }
        AppMethodBeat.o(117763);
    }
}

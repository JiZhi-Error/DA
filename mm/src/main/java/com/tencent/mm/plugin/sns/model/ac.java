package com.tencent.mm.plugin.sns.model;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import java.util.concurrent.ExecutorService;

public final class ac {
    public static char[] DJH = new char[36];
    public static boolean yHD = false;
    public boolean DJE = false;
    public long DJF = 0;
    private int DJG = 0;
    private MMHandler handler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.sns.model.ac.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(95689);
            super.handleMessage(message);
            if (ac.this.DJG >= 5 || System.currentTimeMillis() - ac.this.DJF > 300000) {
                Log.d("MicroMsg.RemoveSnsTask", "cleanCount: " + ac.this.DJG);
                ac.yHD = false;
                AppMethodBeat.o(95689);
            } else if (ac.this.DJE) {
                AppMethodBeat.o(95689);
            } else {
                if (ac.yHD) {
                    new a().y("");
                }
                AppMethodBeat.o(95689);
            }
        }
    };

    public ac() {
        AppMethodBeat.i(95695);
        AppMethodBeat.o(95695);
    }

    static /* synthetic */ int d(ac acVar) {
        int i2 = acVar.DJG;
        acVar.DJG = i2 + 1;
        return i2;
    }

    static {
        int i2 = 0;
        int i3 = 48;
        while (i3 <= 57) {
            DJH[i2] = (char) i3;
            i3++;
            i2++;
        }
        int i4 = 97;
        while (i4 <= 122) {
            DJH[i2] = (char) i4;
            i4++;
            i2++;
        }
    }

    public class a extends n<String, String, Boolean> {
        private String DJJ;
        PInt DJK;
        PInt DJL;
        private String DJM;
        private String key;
        private SharedPreferences sp;
        private String username;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // com.tencent.mm.pluginsdk.model.n
        public final /* synthetic */ Boolean doInBackground(String[] strArr) {
            AppMethodBeat.i(202730);
            Boolean fag = fag();
            AppMethodBeat.o(202730);
            return fag;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.pluginsdk.model.n
        public final /* synthetic */ void onPostExecute(Boolean bool) {
            AppMethodBeat.i(95693);
            Boolean bool2 = bool;
            Log.d("MicroMsg.RemoveSnsTask", "onPostExecute ".concat(String.valueOf(bool2)));
            ac.d(ac.this);
            if (bool2.booleanValue()) {
                ac.b(this.DJK, this.DJL);
                if (this.sp != null) {
                    this.sp.edit().putInt(this.DJJ, this.DJK.value).apply();
                    this.sp.edit().putInt(this.key, this.DJL.value).apply();
                    Log.d("MicroMsg.RemoveSnsTask", "update dir " + this.DJK.value + " " + this.DJL.value + " cleanCount: " + ac.this.DJG);
                }
                ac.this.handler.sendEmptyMessageDelayed(0, 20000);
            }
            ac.this.DJE = false;
            AppMethodBeat.o(95693);
        }

        public a() {
            AppMethodBeat.i(95690);
            this.sp = null;
            this.DJJ = "";
            this.key = "";
            this.DJK = new PInt();
            this.DJL = new PInt();
            this.sp = MMApplicationContext.getContext().getSharedPreferences("preferences_remove_task", 0);
            g.aAi();
            if (!g.aAf().azp()) {
                AppMethodBeat.o(95690);
                return;
            }
            this.username = z.aTY();
            this.DJJ = "remove_key_base" + this.username;
            this.key = "remove_key" + this.username;
            g.aAi();
            if (!g.aAf().azp()) {
                AppMethodBeat.o(95690);
            } else if (aj.isInValid()) {
                AppMethodBeat.o(95690);
            } else if (aj.getDataDB() == null) {
                AppMethodBeat.o(95690);
            } else if (aj.faS() == null) {
                AppMethodBeat.o(95690);
            } else {
                l aQr = aj.faS().aQr(this.username);
                if (aQr != null) {
                    this.DJM = aQr.field_bgId;
                }
                Log.d("MicroMsg.RemoveSnsTask", "my bgid %s", this.DJM);
                ac.this.DJE = true;
                AppMethodBeat.o(95690);
            }
        }

        private Boolean fag() {
            AppMethodBeat.i(95691);
            Log.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
            if (!ac.yHD) {
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(95691);
                return bool;
            } else if (!ac.this.DJE) {
                Boolean bool2 = Boolean.FALSE;
                AppMethodBeat.o(95691);
                return bool2;
            } else if (aj.isInValid()) {
                ac.yHD = false;
                Boolean bool3 = Boolean.FALSE;
                AppMethodBeat.o(95691);
                return bool3;
            } else {
                this.DJK.value = this.sp.getInt(this.DJJ, 0);
                this.DJL.value = this.sp.getInt(this.key, 0);
                String accSnsPath = aj.getAccSnsPath();
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!ac.aM(accSnsPath + ac.DJH[this.DJK.value % 36] + FilePathGenerator.ANDROID_DIR_SEP + ac.DJH[this.DJL.value % 36], this.DJM, this.username)) {
                        Boolean bool4 = Boolean.FALSE;
                        AppMethodBeat.o(95691);
                        return bool4;
                    }
                    Log.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - currentTimeMillis) + " " + this.DJK.value + " " + this.DJL.value);
                    Boolean bool5 = Boolean.TRUE;
                    AppMethodBeat.o(95691);
                    return bool5;
                } catch (Exception e2) {
                }
            }
        }

        @Override // com.tencent.mm.pluginsdk.model.n
        public final ExecutorService eGk() {
            AppMethodBeat.i(179088);
            ExecutorService faA = aj.faA();
            AppMethodBeat.o(179088);
            return faA;
        }
    }

    public static void b(PInt pInt, PInt pInt2) {
        if (pInt2.value + 1 >= 36) {
            pInt2.value = 0;
            pInt.value = (pInt.value + 1) % 36;
            return;
        }
        pInt2.value = (pInt2.value + 1) % 36;
    }

    static /* synthetic */ boolean aM(String str, String str2, String str3) {
        AppMethodBeat.i(95696);
        for (e eVar : s.dC(str, false)) {
            if (!yHD) {
                Log.d("MicroMsg.RemoveSnsTask", "broken here by ??");
                AppMethodBeat.o(95696);
                return false;
            } else if (eVar.name != null && !Util.isNullOrNil(str2) && str3 != null && (eVar.name.contains(str2) || eVar.name.contains(str3))) {
                Log.d("MicroMsg.RemoveSnsTask", "do not delete my bg %s", str2);
            } else if (!eVar.RbJ && Util.milliSecondsToNow(eVar.RbI) > 604800000) {
                eVar.hdW();
            }
        }
        AppMethodBeat.o(95696);
        return true;
    }
}

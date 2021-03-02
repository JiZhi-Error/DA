package com.tencent.mm.plugin.emoji.magicemoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static final b xiO = new b("wx2690c73c8ea361df", "gh_487599f74952@app", 2);
    private static final b xiQ = new b("wxee05a56a82581763", "gh_d01293fea884@app", 0);
    private static final b xiR = new b("wx9d5f7f0bf2dc950c", "gh_2ae1569f5edf@app", 0);
    public static final List<b> xiS;
    public static b xiT = xiR;

    public static class b {
        public String appId;
        public int iOo;
        public String userName;

        public b(String str, String str2, int i2) {
            this.appId = str;
            this.userName = str2;
            this.iOo = i2;
        }

        public final String toString() {
            AppMethodBeat.i(258019);
            String str = "AppIdBundle{appId='" + this.appId + '\'' + ", userName='" + this.userName + '\'' + ", versionType=" + this.iOo + '}';
            AppMethodBeat.o(258019);
            return str;
        }
    }

    static {
        AppMethodBeat.i(258020);
        ArrayList arrayList = new ArrayList(2);
        xiS = arrayList;
        arrayList.add(xiQ);
        xiS.add(xiR);
        Log.i("MicroMsg.ConstantsMagicEmoji", "hy: using test mode: %b", Boolean.FALSE);
        AppMethodBeat.o(258020);
    }

    /* renamed from: com.tencent.mm.plugin.emoji.magicemoji.b.a$a  reason: collision with other inner class name */
    public enum EnumC0959a {
        Ok,
        NoPkg,
        DownloadFailed,
        CrashTooMuch,
        DisabledByServer,
        MemoryWarningTooMuch,
        DownloadSucc,
        qYD,
        DownloadFailedTooMuch;

        public static EnumC0959a valueOf(String str) {
            AppMethodBeat.i(199709);
            EnumC0959a aVar = (EnumC0959a) Enum.valueOf(EnumC0959a.class, str);
            AppMethodBeat.o(199709);
            return aVar;
        }

        static {
            AppMethodBeat.i(199710);
            AppMethodBeat.o(199710);
        }
    }

    public static boolean a(EnumC0959a aVar) {
        return aVar == EnumC0959a.CrashTooMuch || aVar == EnumC0959a.DisabledByServer || aVar == EnumC0959a.MemoryWarningTooMuch;
    }
}

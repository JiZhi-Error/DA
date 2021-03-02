package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.List;

public final class d {
    public static boolean bfn(String str) {
        AppMethodBeat.i(152380);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
            AppMethodBeat.o(152380);
            return false;
        }
        ao azQ = g.aAh().azQ();
        if (azQ == null) {
            Log.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
            AppMethodBeat.o(152380);
            return false;
        }
        a aVar = new a((byte) 0);
        aVar.aME((String) azQ.get(69121, (Object) null));
        if (!aVar.Dcn.contains(str)) {
            aVar.Dcn.add(str);
        }
        azQ.set(69121, aVar.gsd());
        AppMethodBeat.o(152380);
        return true;
    }

    public static boolean bfo(String str) {
        AppMethodBeat.i(152381);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
            AppMethodBeat.o(152381);
            return false;
        }
        ao azQ = g.aAh().azQ();
        if (azQ == null) {
            Log.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
            AppMethodBeat.o(152381);
            return false;
        }
        a aVar = new a((byte) 0);
        aVar.aME((String) azQ.get(69121, (Object) null));
        if (aVar.Dcn.contains(str)) {
            aVar.Dcn.remove(str);
        }
        azQ.set(69121, aVar.gsd());
        AppMethodBeat.o(152381);
        return true;
    }

    static class a {
        List<String> Dcn;

        private a() {
            AppMethodBeat.i(152377);
            this.Dcn = new ArrayList();
            AppMethodBeat.o(152377);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final String gsd() {
            AppMethodBeat.i(152378);
            if (this.Dcn == null || this.Dcn.size() == 0) {
                AppMethodBeat.o(152378);
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : this.Dcn) {
                stringBuffer.append(str);
                stringBuffer.append(";");
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(152378);
            return stringBuffer2;
        }

        /* access modifiers changed from: package-private */
        public final void aME(String str) {
            AppMethodBeat.i(152379);
            this.Dcn = new ArrayList();
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(152379);
                return;
            }
            for (String str2 : str.split(";")) {
                this.Dcn.add(str2);
            }
            AppMethodBeat.o(152379);
        }
    }
}

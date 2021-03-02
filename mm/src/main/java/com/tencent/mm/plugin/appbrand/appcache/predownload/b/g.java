package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.e;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.protocal.protobuf.fet;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class g extends a<Boolean, fet> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, java.lang.String, java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* synthetic */ Boolean c(String str, String str2, fet fet) {
        AppMethodBeat.i(44402);
        Boolean a2 = a(str, str2, fet);
        AppMethodBeat.o(44402);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* bridge */ /* synthetic */ fem cs(fet fet) {
        return fet.NzO;
    }

    private static Boolean a(String str, String str2, fet fet) {
        String sb;
        int i2;
        AppMethodBeat.i(44401);
        String str3 = fet.NAg;
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", str, str2);
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(44401);
            return bool;
        } else if (Util.isNullOrNil(fet.NnI)) {
            Log.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", str, str2);
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(44401);
            return bool2;
        } else {
            try {
                byte[] decode = Base64.decode(str3, 0);
                che che = new che();
                che.parseFrom(decode);
                if (che.MmA.LjS.zy.length == 0) {
                    Log.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", str, str2);
                    a aVar = a.INSTANCE;
                    a.F((long) fet.NzO.NzL, 105);
                    Boolean bool3 = Boolean.FALSE;
                    AppMethodBeat.o(44401);
                    return bool3;
                }
                a aVar2 = a.INSTANCE;
                a.F((long) fet.NzO.NzL, 104);
                LinkedList<Integer> linkedList = fet.NnI;
                long j2 = ((long) fet.NAh) & Util.MAX_32BIT_VALUE;
                long j3 = ((long) fet.NAi) & Util.MAX_32BIT_VALUE;
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                if (linkedList == null) {
                    sb = BuildConfig.COMMAND;
                } else if (Util.isNullOrNil(linkedList)) {
                    sb = "{}";
                } else {
                    StringBuilder sb2 = new StringBuilder("{");
                    for (Integer num : linkedList) {
                        sb2.append(num.toString()).append(',');
                    }
                    sb2.append("}");
                    sb = sb2.toString();
                }
                objArr[2] = sb;
                objArr[3] = Long.valueOf(j2);
                objArr[4] = Long.valueOf(j3);
                Log.i("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]", objArr);
                boolean a2 = ((e) n.W(e.class)).a(decode, str2, linkedList, j2, j3);
                a aVar3 = a.INSTANCE;
                int i3 = fet.NzO.NzL;
                if (a2) {
                    i2 = 107;
                } else {
                    i2 = 108;
                }
                a.F((long) i3, (long) i2);
                Boolean valueOf = Boolean.valueOf(a2);
                AppMethodBeat.o(44401);
                return valueOf;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", e2, "call[%s | %s], decode base64", str, str2);
                Boolean bool4 = Boolean.FALSE;
                AppMethodBeat.o(44401);
                return bool4;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final String bwQ() {
        return "CmdIssueLaunch";
    }
}

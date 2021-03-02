package com.tencent.mm.recovery.a;

import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.a;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;
import java.util.List;

public final class b {
    public static LinkedList<cxu> dZe() {
        List<a> ckR;
        AppMethodBeat.i(193911);
        LinkedList<cxu> linkedList = new LinkedList<>();
        long j2 = 0;
        try {
            j2 = ((long) com.tencent.mm.kernel.a.azs()) & Util.MAX_32BIT_VALUE;
            Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUtilCopycat", "uin is %s", Util.secPrint(String.valueOf(j2)));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUtilCopycat", e2, "tinker patch manager get uin failed.", new Object[0]);
        }
        try {
            linkedList.add(ih("code-version", BuildInfo.CLIENT_VERSION));
            linkedList.add(ih("code-reversion", BuildInfo.REV));
            linkedList.add(ih(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.valueOf(Build.VERSION.SDK_INT)));
            linkedList.add(ih("os-name", d.KyL));
            linkedList.add(ih("device-brand", d.KyI));
            linkedList.add(ih("device-name", d.DEVICE_NAME));
            linkedList.add(ih("support-64-bit", Build.SUPPORTED_64_BIT_ABIS.length > 0 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO));
            linkedList.add(ih("device-is-64-bit-runtime", q.is64BitRuntime() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO));
            linkedList.add(ih(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j2)));
            linkedList.add(ih(TencentLocation.NETWORK_PROVIDER, String.valueOf(NetStatusUtil.isWifi(MMApplicationContext.getContext()) ? 3 : 2)));
            c cVar = (c) g.af(c.class);
            if (!(cVar == null || (ckR = cVar.ckR()) == null)) {
                for (a aVar : ckR) {
                    linkedList.add(ih(Integer.toHexString(aVar.field_key), String.valueOf(aVar.field_dau)));
                }
            }
            Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUtilCopycat", "final conditions = ".concat(String.valueOf(linkedList)));
        } catch (Throwable th) {
            Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUtilCopycat", "final conditions = ".concat(String.valueOf(linkedList)));
            AppMethodBeat.o(193911);
            throw th;
        }
        AppMethodBeat.o(193911);
        return linkedList;
    }

    public static cxu ih(String str, String str2) {
        AppMethodBeat.i(193912);
        cxu cxu = new cxu();
        cxu.key = str;
        cxu.value = str2;
        AppMethodBeat.o(193912);
        return cxu;
    }
}

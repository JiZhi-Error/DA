package com.tencent.mm.plugin.hld.a;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ok;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/hld/model/ImeReporter;", "", "()V", "TAG", "", "appendPermissionList", "", "stringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "", "(Ljava/lang/StringBuilder;[Ljava/lang/String;I)V", "reportClientEnvironment", "reportFilter", "", "plugin-hld_release"})
public final class a {
    public static final a UXi = new a();

    static {
        AppMethodBeat.i(260022);
        AppMethodBeat.o(260022);
    }

    private a() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.hld.a.a$a  reason: collision with other inner class name */
    public static final class RunnableC1435a implements Runnable {
        public static final RunnableC1435a UXj = new RunnableC1435a();

        static {
            AppMethodBeat.i(260020);
            AppMethodBeat.o(260020);
        }

        RunnableC1435a() {
        }

        public final void run() {
            AppMethodBeat.i(260019);
            ok okVar = new ok();
            try {
                com.tencent.mm.plugin.hld.b.a aVar = com.tencent.mm.plugin.hld.b.a.UXp;
                okVar.atP(com.tencent.mm.plugin.hld.b.a.hVT());
            } catch (Exception e2) {
                Log.i("WxIme.ImeReporter", "getCurIme " + e2.getMessage());
            }
            StringBuilder sb = new StringBuilder();
            a aVar2 = a.UXi;
            a.a(sb, new String[]{"android.permission.READ_CONTACTS"}, 1);
            a aVar3 = a.UXi;
            a.a(sb, new String[]{"android.permission.WRITE_CONTACTS"}, 2);
            a aVar4 = a.UXi;
            a.a(sb, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 3);
            a aVar5 = a.UXi;
            a.a(sb, new String[]{"android.permission.RECORD_AUDIO"}, 4);
            a aVar6 = a.UXi;
            a.a(sb, new String[]{"android.permission.CAMERA"}, 5);
            a aVar7 = a.UXi;
            a.a(sb, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 6);
            a aVar8 = a.UXi;
            a.a(sb, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 7);
            a aVar9 = a.UXi;
            a.a(sb, new String[]{"android.permission.READ_PHONE_STATE"}, 8);
            a aVar10 = a.UXi;
            a.a(sb, new String[]{"android.permission.USE_FINGERPRINT"}, 9);
            okVar.awy(sb.toString());
            com.tencent.mm.plugin.hld.b.a aVar11 = com.tencent.mm.plugin.hld.b.a.UXp;
            okVar.PM(com.tencent.mm.plugin.hld.b.a.hVU());
            com.tencent.mm.plugin.hld.b.a aVar12 = com.tencent.mm.plugin.hld.b.a.UXp;
            okVar.PN(com.tencent.mm.plugin.hld.b.a.hVV());
            com.tencent.mm.plugin.hld.b.a aVar13 = com.tencent.mm.plugin.hld.b.a.UXp;
            okVar.PO(com.tencent.mm.plugin.hld.b.a.hVW());
            com.tencent.mm.plugin.hld.b.a aVar14 = com.tencent.mm.plugin.hld.b.a.UXp;
            okVar.axE(com.tencent.mm.plugin.hld.b.a.hVX());
            okVar.bfK();
            com.tencent.mm.plugin.hld.b.a aVar15 = com.tencent.mm.plugin.hld.b.a.UXp;
            MultiProcessMMKV kv = com.tencent.mm.plugin.hld.b.a.getKV();
            if (kv != null) {
                kv.putBoolean("ime_if_report_client_environment", true);
                AppMethodBeat.o(260019);
                return;
            }
            AppMethodBeat.o(260019);
        }
    }

    public static boolean hVR() {
        AppMethodBeat.i(260021);
        b bVar = b.UXo;
        if (b.hVS()) {
            AppMethodBeat.o(260021);
            return true;
        }
        AppMethodBeat.o(260021);
        return false;
    }

    public static final /* synthetic */ void a(StringBuilder sb, String[] strArr, int i2) {
        AppMethodBeat.i(260023);
        if (sb.length() > 0) {
            sb.append(";");
        }
        com.tencent.mm.plugin.hld.b.a aVar = com.tencent.mm.plugin.hld.b.a.UXp;
        if (com.tencent.mm.plugin.hld.b.a.ao(strArr)) {
            sb.append(i2);
        }
        AppMethodBeat.o(260023);
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016JY\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f25\u0010\u000f\u001a1\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000e0\u0010j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\u0014H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/IsoDepLogic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "()V", "TAG", "", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "tag", "Landroid/nfc/Tag;", "function", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "getHistoricalBytes", "", "isoDep", "Landroid/nfc/tech/IsoDep;", "getIsoDep", "luggage-commons-jsapi-nfc-ext_release"})
public final class b implements a {
    public static final b miy = new b();

    static {
        AppMethodBeat.i(207146);
        AppMethodBeat.o(207146);
    }

    private b() {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a
    public final void a(Tag tag, String str, kotlin.g.a.b<? super e<Object>, x> bVar) {
        e bVar2;
        AppMethodBeat.i(207145);
        p.h(tag, "tag");
        p.h(str, "function");
        p.h(bVar, "callback");
        Log.d("MicroMsg.AppBrand.IsoDepLogic", "execAsync, function: ".concat(String.valueOf(str)));
        IsoDep isoDep = IsoDep.get(tag);
        if (isoDep == null) {
            bVar.invoke(new e.a(13015, "unavailable tech"));
            AppMethodBeat.o(207145);
            return;
        }
        switch (str.hashCode()) {
            case -969018485:
                if (str.equals("getHistoricalBytes")) {
                    byte[] historicalBytes = isoDep.getHistoricalBytes();
                    if (historicalBytes != null) {
                        StringBuilder sb = new StringBuilder("historicalBytes: ");
                        String arrays = Arrays.toString(historicalBytes);
                        p.g(arrays, "java.util.Arrays.toString(this)");
                        Log.d("MicroMsg.AppBrand.IsoDepLogic", sb.append(arrays).toString());
                    } else {
                        historicalBytes = null;
                    }
                    bVar2 = new e.b(historicalBytes);
                    break;
                }
            default:
                bVar2 = new e.a(13024, "function not support");
                break;
        }
        bVar.invoke(bVar2);
        AppMethodBeat.o(207145);
    }
}

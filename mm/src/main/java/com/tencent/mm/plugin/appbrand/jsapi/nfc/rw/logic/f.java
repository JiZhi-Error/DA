package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016JY\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u001225\u0010\u0015\u001a1\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\r0\f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00140\u0016j\n\u0012\u0006\u0012\u0004\u0018\u00010\r`\u001aH\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NfcALogic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "()V", "TAG", "", "emptyByteArray", "", "getEmptyByteArray", "()[B", "emptyByteArray$delegate", "Lkotlin/Lazy;", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "tag", "Landroid/nfc/Tag;", "function", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "getAtqa", "nfcA", "Landroid/nfc/tech/NfcA;", "getNfcA", "getSak", "", "luggage-commons-jsapi-nfc-ext_release"})
public final class f implements a {
    private static final kotlin.f miX = g.a(k.NONE, a.miZ);
    public static final f miY = new f();

    static {
        AppMethodBeat.i(207164);
        AppMethodBeat.o(207164);
    }

    private f() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a
    public final void a(Tag tag, String str, b<? super e<Object>, x> bVar) {
        e bVar2;
        AppMethodBeat.i(207163);
        p.h(tag, "tag");
        p.h(str, "function");
        p.h(bVar, "callback");
        Log.d("MicroMsg.AppBrand.NfcALogic", "execAsync, function: ".concat(String.valueOf(str)));
        NfcA nfcA = NfcA.get(tag);
        if (nfcA == null) {
            bVar.invoke(new e.a(13015, "unavailable tech"));
            AppMethodBeat.o(207163);
            return;
        }
        switch (str.hashCode()) {
            case -1249350489:
                if (str.equals("getSak")) {
                    bVar2 = new e.b(Short.valueOf(nfcA.getSak()));
                    break;
                }
                bVar2 = new e.a(13024, "function not support");
                break;
            case -75677191:
                if (str.equals("getAtqa")) {
                    byte[] atqa = nfcA.getAtqa();
                    if (atqa == null) {
                        atqa = (byte[]) miX.getValue();
                    }
                    StringBuilder sb = new StringBuilder("atqa: ");
                    String arrays = Arrays.toString(atqa);
                    p.g(arrays, "java.util.Arrays.toString(this)");
                    Log.d("MicroMsg.AppBrand.NfcALogic", sb.append(arrays).toString());
                    bVar2 = new e.b(atqa);
                    break;
                }
                bVar2 = new e.a(13024, "function not support");
                break;
            default:
                bVar2 = new e.a(13024, "function not support");
                break;
        }
        bVar.invoke(bVar2);
        AppMethodBeat.o(207163);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<byte[]> {
        public static final a miZ = new a();

        static {
            AppMethodBeat.i(207162);
            AppMethodBeat.o(207162);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ byte[] invoke() {
            return new byte[0];
        }
    }
}

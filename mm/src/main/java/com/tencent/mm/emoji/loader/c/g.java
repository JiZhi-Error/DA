package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.d;
import com.tencent.mm.plugin.emoji.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J5\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiHttpFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "fetch", "getEmojiData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class g implements d {
    private final String TAG = "MicroMsg.EmojiLoader.EmojiHttpFetcher";
    private b<? super Boolean, x> callback;
    private e gVV;

    @Override // com.tencent.mm.emoji.loader.c.d
    public final void a(e eVar, b<? super Boolean, x> bVar) {
        com.tencent.mm.av.a.d.b bVar2;
        boolean z;
        AppMethodBeat.i(105439);
        p.h(eVar, "fetcherConfig");
        this.gVV = eVar;
        this.callback = bVar;
        e eVar2 = this.gVV;
        if (eVar2 != null) {
            switch (eVar2.gWn) {
                case 0:
                    d.CK(1);
                    break;
                case 1:
                    d.CK(6);
                    break;
                case 2:
                    d.CK(10);
                    break;
            }
        }
        e eVar3 = this.gVV;
        if (eVar3 != null) {
            bVar2 = new a().OV(eVar3.url);
        } else {
            bVar2 = null;
        }
        byte[] bArr = bVar2 != null ? bVar2.data : null;
        if (bArr != null) {
            if (bArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Log.i(this.TAG, "download success " + eVar.gWm.getMd5() + ", " + eVar.path);
                o heq = new o(eVar.path).heq();
                if (heq != null) {
                    heq.mkdirs();
                }
                s.C(eVar.path, bArr);
                dP(true);
                if (bVar != null) {
                    bVar.invoke(Boolean.TRUE);
                    AppMethodBeat.o(105439);
                    return;
                }
                AppMethodBeat.o(105439);
                return;
            }
        }
        Log.i(this.TAG, "download fail " + eVar.gWm.getMd5());
        dP(false);
        if (bVar != null) {
            bVar.invoke(Boolean.FALSE);
            AppMethodBeat.o(105439);
            return;
        }
        AppMethodBeat.o(105439);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final void dP(boolean z) {
        AppMethodBeat.i(105440);
        e eVar = this.gVV;
        if (eVar == null) {
            AppMethodBeat.o(105440);
        } else if (z) {
            d.CK(2);
            AppMethodBeat.o(105440);
        } else {
            d.CK(3);
            switch (eVar.gWn) {
                case 0:
                    d.a(eVar.gWm.getMd5(), 4, 1, 1, eVar.gWm.avy(), 1, eVar.gWm.field_designerID);
                    AppMethodBeat.o(105440);
                    return;
                case 1:
                    d.a(eVar.gWm.getMd5(), 2, 1, 1, eVar.gWm.avy(), 1, eVar.gWm.field_designerID);
                    AppMethodBeat.o(105440);
                    return;
                case 2:
                    d.a(eVar.gWm.getMd5(), 4, 1, 1, eVar.gWm.avy(), 1, eVar.gWm.field_designerID);
                    break;
            }
            AppMethodBeat.o(105440);
        }
    }
}

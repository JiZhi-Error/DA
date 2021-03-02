package com.tencent.mm.sticker.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.protocal.protobuf.chz;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\bH\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/sticker/task/IPCGetLensInfo;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-sticker_release"})
public final class m implements b<Bundle, Bundle> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        AppMethodBeat.i(105995);
        Bundle bundle2 = bundle;
        p.h(bundle2, "data");
        String string = bundle2.getString(f.NOo);
        if (string != null) {
            new e(null, string, new a(dVar));
            AppMethodBeat.o(105995);
        } else if (dVar != null) {
            dVar.bn(null);
            AppMethodBeat.o(105995);
        } else {
            AppMethodBeat.o(105995);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/sticker/task/IPCGetLensInfo$invoke$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-sticker_release"})
    public static final class a implements c {
        final /* synthetic */ d kFf;

        a(d dVar) {
            this.kFf = dVar;
        }

        @Override // com.tencent.mm.sticker.c.c
        public final void a(int i2, chz chz) {
            AppMethodBeat.i(105994);
            Bundle bundle = new Bundle();
            bundle.putInt(f.NOp, i2);
            if (chz == null) {
                d dVar = this.kFf;
                if (dVar != null) {
                    dVar.bn(bundle);
                    AppMethodBeat.o(105994);
                    return;
                }
                AppMethodBeat.o(105994);
                return;
            }
            bundle.putByteArray(f.NOq, chz.toByteArray());
            d dVar2 = this.kFf;
            if (dVar2 != null) {
                dVar2.bn(bundle);
                AppMethodBeat.o(105994);
                return;
            }
            AppMethodBeat.o(105994);
        }
    }
}

package com.tencent.mm.sticker.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.protocal.protobuf.bpi;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/sticker/task/IPCGetLensList;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-sticker_release"})
public final class n implements b<Bundle, Bundle> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        AppMethodBeat.i(105997);
        Bundle bundle2 = bundle;
        p.h(bundle2, "data");
        new j(bundle2.getInt(k.KEY_TYPE), bundle2.getByteArray(k.NOx), bundle2.getByteArray(k.NOy), null, new a(dVar));
        AppMethodBeat.o(105997);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/sticker/task/IPCGetLensList$invoke$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-sticker_release"})
    public static final class a implements h {
        final /* synthetic */ d kFf;

        a(d dVar) {
            this.kFf = dVar;
        }

        @Override // com.tencent.mm.sticker.c.h
        public final void a(int i2, int i3, bpi bpi) {
            byte[] byteArray;
            AppMethodBeat.i(105996);
            Bundle bundle = new Bundle();
            bundle.putInt(k.NOp, i2);
            bundle.putInt(k.NOz, i3);
            if (!(bpi == null || (byteArray = bpi.toByteArray()) == null)) {
                bundle.putByteArray(k.NOA, byteArray);
            }
            d dVar = this.kFf;
            if (dVar != null) {
                dVar.bn(bundle);
                AppMethodBeat.o(105996);
                return;
            }
            AppMethodBeat.o(105996);
        }
    }
}

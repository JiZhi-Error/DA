package com.tencent.mm.plugin.multitask;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/multitask/MultiTaskEvent;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "TAG", "", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-multitask_release"})
public final class e implements b<Bundle, Bundle> {
    private final String TAG = "MicroMsg.MultiTask.HideMultiTaskUIC";

    public e() {
        AppMethodBeat.i(200286);
        Log.i(this.TAG, "create add task info");
        AppMethodBeat.o(200286);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        String str;
        Integer num;
        Integer num2 = null;
        AppMethodBeat.i(200285);
        Bundle bundle2 = bundle;
        if (bundle2 != null) {
            str = bundle2.getString("id");
        } else {
            str = null;
        }
        if (bundle2 != null) {
            num = Integer.valueOf(bundle2.getInt("type"));
        } else {
            num = null;
        }
        if (bundle2 != null) {
            num2 = Integer.valueOf(bundle2.getInt("event_type"));
        }
        if (!(str == null || num == null || num2 == null)) {
            com.tencent.mm.ac.d.h(new a(num.intValue(), str, num2.intValue()));
        }
        AppMethodBeat.o(200285);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int $type;
        final /* synthetic */ String pAl;
        final /* synthetic */ int zZg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(int i2, String str, int i3) {
            super(0);
            this.$type = i2;
            this.pAl = str;
            this.zZg = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(200284);
            mt mtVar = new mt();
            mtVar.dSq.type = this.$type;
            mtVar.dSq.id = this.pAl;
            mtVar.dSq.dSr = this.zZg;
            EventCenter.instance.publish(mtVar);
            x xVar = x.SXb;
            AppMethodBeat.o(200284);
            return xVar;
        }
    }
}

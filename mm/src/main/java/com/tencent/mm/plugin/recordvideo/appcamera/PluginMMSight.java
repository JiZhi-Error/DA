package com.tencent.mm.plugin.recordvideo.appcamera;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.api.b;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.plugin.mmsight.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\nB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/appcamera/PluginMMSight;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/appcamera/IPluginMMSight;", "()V", "execute", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "name", "", "Companion", "plugin-recordvideo_release"})
public final class PluginMMSight extends f implements e {
    public static final a BKa = new a((byte) 0);
    private static final String TAG = TAG;

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public final String name() {
        return "plugin-recordvideo";
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(75152);
        if (gVar != null) {
            Log.i(TAG, "execute, process: %s", gVar.getProcessName());
        }
        b.zsZ = new b.a();
        MMSightRecordView.zsY = new c();
        com.tencent.mm.plugin.mmsight.api.a.zsW = new com.tencent.mm.plugin.api.a();
        if (gVar != null) {
            if (gVar.aBb()) {
                pin(new y(e.class));
            }
            AppMethodBeat.o(75152);
            return;
        }
        AppMethodBeat.o(75152);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/appcamera/PluginMMSight$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(75153);
        AppMethodBeat.o(75153);
    }
}

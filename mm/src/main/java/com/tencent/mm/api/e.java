package com.tencent.mm.api;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class e extends FrameLayout {
    z diE = new z() {
        /* class com.tencent.mm.api.e.AnonymousClass1 */

        @Override // com.tencent.mm.api.z
        public final void a(h hVar) {
            AppMethodBeat.i(149423);
            Log.i("MicroMsg.DrawingView", "Default [onSelectedFeature] features:%s", hVar.name());
            AppMethodBeat.o(149423);
        }

        @Override // com.tencent.mm.api.z
        public final void a(h hVar, int i2, Object obj) {
            AppMethodBeat.i(169116);
            Log.i("MicroMsg.DrawingView", "Default [onSelectedDetailFeature] features:%s index:%s", hVar.name(), Integer.valueOf(i2));
            AppMethodBeat.o(169116);
        }

        @Override // com.tencent.mm.api.z
        public final void cH(boolean z) {
        }
    };

    public abstract void setActionBarCallback(j jVar);

    public abstract void setActionBarVisible(boolean z);

    public abstract void setAutoShowFooterAndBar(boolean z);

    public abstract void setFooterVisible(boolean z);

    public e(Context context) {
        super(context);
    }

    public void setSelectedFeatureListener(z zVar) {
        this.diE = zVar;
    }

    public z getSelectedFeatureListener() {
        return this.diE;
    }
}

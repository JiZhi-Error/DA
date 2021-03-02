package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.s;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;

/* access modifiers changed from: package-private */
public final class d implements MMSightRecordView.f {
    private final f kSY;
    final s lPY = ((s) this.kSY.getJsRuntime().R(s.class));
    boolean lPZ;
    int lQa = Integer.MIN_VALUE;

    public d(f fVar) {
        AppMethodBeat.i(46217);
        this.kSY = fVar;
        AppMethodBeat.o(46217);
    }

    public final void a(MMSightRecordView mMSightRecordView) {
        AppMethodBeat.i(46218);
        this.lPZ = false;
        if (mMSightRecordView != null) {
            mMSightRecordView.a((ByteBuffer) null, (MMSightRecordView.f) null);
        }
        if (this.lQa != Integer.MIN_VALUE) {
            this.lPY.xZ(this.lQa);
            this.lQa = Integer.MIN_VALUE;
        }
        AppMethodBeat.o(46218);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f
    public final void bGa() {
        AppMethodBeat.i(46219);
        if (!this.lPZ) {
            Log.i("MicroMsg.FrameDataCallbackHelper", "onDateUpdate not need callback");
            AppMethodBeat.o(46219);
            return;
        }
        this.kSY.a(new a());
        AppMethodBeat.o(46219);
    }

    public class a extends bc {
        private static final int CTRL_INDEX = 637;
        public static final String NAME = "onCameraFrame";

        public a() {
        }
    }
}

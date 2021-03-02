package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class d {
    private com.tencent.mm.compatible.util.b dtz;
    a iBA;
    private boolean iBB = false;
    private b.a iBz;
    private Context mAppContext = MMApplicationContext.getContext();

    public interface a {
        void aTw();

        void aTx();

        void aTy();

        void aTz();
    }

    public d() {
        AppMethodBeat.i(150150);
        AppMethodBeat.o(150150);
    }

    public static d aTu() {
        AppMethodBeat.i(150151);
        d dVar = new d();
        AppMethodBeat.o(150151);
        return dVar;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(150152);
        this.iBA = aVar;
        boolean aTv = aTv();
        AppMethodBeat.o(150152);
        return aTv;
    }

    private boolean requestFocus() {
        AppMethodBeat.i(223527);
        if (this.dtz == null) {
            AppMethodBeat.o(223527);
            return false;
        } else if (this.iBB) {
            AppMethodBeat.o(223527);
            return false;
        } else {
            this.dtz.requestFocus();
            this.iBB = true;
            boolean z = this.iBB;
            AppMethodBeat.o(223527);
            return z;
        }
    }

    public final boolean aTv() {
        AppMethodBeat.i(223528);
        b bVar = new b(this, (byte) 0);
        if (this.dtz == null) {
            this.dtz = new com.tencent.mm.compatible.util.b(this.mAppContext);
        }
        if (this.iBz != bVar) {
            this.iBz = bVar;
        }
        this.dtz.a(this.iBz);
        boolean requestFocus = requestFocus();
        AppMethodBeat.o(223528);
        return requestFocus;
    }

    public final boolean apm() {
        AppMethodBeat.i(150153);
        boolean fp = fp(false);
        AppMethodBeat.o(150153);
        return fp;
    }

    public final boolean fp(boolean z) {
        boolean z2;
        AppMethodBeat.i(150154);
        if (this.dtz != null) {
            z2 = this.dtz.apm();
        } else {
            z2 = false;
        }
        this.iBB = false;
        if (z) {
            this.dtz = null;
            this.iBz = null;
            this.iBA = null;
        }
        AppMethodBeat.o(150154);
        return z2;
    }

    /* access modifiers changed from: package-private */
    public class b implements b.a {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.compatible.util.b.a
        public final void iZ(int i2) {
            AppMethodBeat.i(150149);
            switch (i2) {
                case -3:
                    Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    if (d.this.iBA != null) {
                        d.this.iBA.aTz();
                        AppMethodBeat.o(150149);
                        return;
                    }
                    break;
                case -2:
                    Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
                    if (d.this.iBA != null) {
                        d.this.iBA.aTy();
                        AppMethodBeat.o(150149);
                        return;
                    }
                    break;
                case -1:
                    Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
                    if (d.this.iBA != null) {
                        d.this.iBA.aTx();
                        AppMethodBeat.o(150149);
                        return;
                    }
                    break;
                case 0:
                default:
                    Log.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
                    break;
                case 1:
                    Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
                    if (d.this.iBA != null) {
                        d.this.iBA.aTw();
                        AppMethodBeat.o(150149);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(150149);
        }
    }
}

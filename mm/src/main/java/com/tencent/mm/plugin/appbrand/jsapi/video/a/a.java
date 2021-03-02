package com.tencent.mm.plugin.appbrand.jsapi.video.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a {
    private com.tencent.mm.compatible.util.b dtz;
    private boolean iBB = false;
    private b.a iBz;
    private Context mAppContext = MMApplicationContext.getContext();
    AbstractC0708a mxc;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0708a {
    }

    public a() {
        AppMethodBeat.i(234651);
        AppMethodBeat.o(234651);
    }

    public final boolean bJI() {
        AppMethodBeat.i(234652);
        this.mxc = null;
        boolean aTv = aTv();
        AppMethodBeat.o(234652);
        return aTv;
    }

    private boolean requestFocus() {
        AppMethodBeat.i(234653);
        if (this.dtz == null) {
            AppMethodBeat.o(234653);
            return false;
        } else if (this.iBB) {
            AppMethodBeat.o(234653);
            return false;
        } else {
            this.dtz.requestFocus();
            this.iBB = true;
            boolean z = this.iBB;
            AppMethodBeat.o(234653);
            return z;
        }
    }

    private boolean aTv() {
        AppMethodBeat.i(234654);
        b bVar = new b(this, (byte) 0);
        if (this.dtz == null) {
            this.dtz = new com.tencent.mm.compatible.util.b(this.mAppContext);
        }
        if (this.iBz != bVar) {
            this.iBz = bVar;
        }
        this.dtz.a(this.iBz);
        boolean requestFocus = requestFocus();
        AppMethodBeat.o(234654);
        return requestFocus;
    }

    public final boolean bJJ() {
        boolean z;
        AppMethodBeat.i(234655);
        if (this.dtz != null) {
            z = this.dtz.apm();
        } else {
            z = false;
        }
        this.iBB = false;
        AppMethodBeat.o(234655);
        return z;
    }

    /* access modifiers changed from: package-private */
    public class b implements b.a {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.compatible.util.b.a
        public final void iZ(int i2) {
            AppMethodBeat.i(234650);
            switch (i2) {
                case -3:
                    Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    if (a.this.mxc != null) {
                        AppMethodBeat.o(234650);
                        return;
                    }
                    break;
                case -2:
                    Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
                    if (a.this.mxc != null) {
                        AppMethodBeat.o(234650);
                        return;
                    }
                    break;
                case -1:
                    Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
                    if (a.this.mxc != null) {
                        AppMethodBeat.o(234650);
                        return;
                    }
                    break;
                case 0:
                default:
                    Log.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
                    break;
                case 1:
                    Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
                    if (a.this.mxc != null) {
                        AppMethodBeat.o(234650);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(234650);
        }
    }
}

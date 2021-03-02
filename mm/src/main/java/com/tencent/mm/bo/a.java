package com.tencent.mm.bo;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;

@TargetApi(3)
public final class a extends OrientationEventListener {
    private EnumC0280a jHY = EnumC0280a.NONE;
    private int jHZ = 45;
    private b jIa;

    public interface b {
        void a(EnumC0280a aVar, EnumC0280a aVar2);
    }

    /* renamed from: com.tencent.mm.bo.a$a  reason: collision with other inner class name */
    public enum EnumC0280a {
        NONE,
        PORTRAIT,
        LANDSCAPE,
        REVERSE_PORTRAIT,
        REVERSE_LANDSCAPE;

        public static EnumC0280a valueOf(String str) {
            AppMethodBeat.i(151340);
            EnumC0280a aVar = (EnumC0280a) Enum.valueOf(EnumC0280a.class, str);
            AppMethodBeat.o(151340);
            return aVar;
        }

        static {
            AppMethodBeat.i(151341);
            AppMethodBeat.o(151341);
        }
    }

    public a(Context context, b bVar) {
        super(context);
        this.jIa = bVar;
    }

    public final void enable() {
        AppMethodBeat.i(151342);
        super.enable();
        AppMethodBeat.o(151342);
    }

    public final void disable() {
        AppMethodBeat.i(151343);
        super.disable();
        this.jHY = EnumC0280a.NONE;
        AppMethodBeat.o(151343);
    }

    public final void onOrientationChanged(int i2) {
        AppMethodBeat.i(151344);
        if (i2 == -1) {
            AppMethodBeat.o(151344);
            return;
        }
        EnumC0280a aVar = this.jHY;
        if ((i2 >= 360 - this.jHZ && i2 < 360) || (i2 >= 0 && i2 <= this.jHZ + 0)) {
            aVar = EnumC0280a.PORTRAIT;
        } else if (i2 >= 270 - this.jHZ && i2 <= this.jHZ + 270) {
            aVar = EnumC0280a.LANDSCAPE;
        } else if (i2 >= 180 - this.jHZ && i2 <= this.jHZ + TXLiveConstants.RENDER_ROTATION_180) {
            aVar = EnumC0280a.REVERSE_PORTRAIT;
        } else if (i2 >= 90 - this.jHZ && i2 <= this.jHZ + 90) {
            aVar = EnumC0280a.REVERSE_LANDSCAPE;
        }
        if (aVar != this.jHY) {
            if (!(this.jIa == null || this.jHY == EnumC0280a.NONE)) {
                this.jIa.a(this.jHY, aVar);
            }
            this.jHY = aVar;
        }
        AppMethodBeat.o(151344);
    }
}

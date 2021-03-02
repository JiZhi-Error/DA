package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.f;

public final class a extends com.tencent.mm.ipcinvoker.extension.event.a<C0577a> {
    private static final a lpX = new a();

    static {
        AppMethodBeat.i(121570);
        AppMethodBeat.o(121570);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.a$a  reason: collision with other inner class name */
    public static class C0577a implements f {
        public int height;
        public String id;
        public int width;

        @Override // com.tencent.mm.ipcinvoker.extension.f
        public final void e(Parcel parcel) {
            AppMethodBeat.i(121568);
            parcel.writeString(this.id);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            AppMethodBeat.o(121568);
        }

        @Override // com.tencent.mm.ipcinvoker.extension.f
        public final void readFromParcel(Parcel parcel) {
            AppMethodBeat.i(121569);
            this.id = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
            AppMethodBeat.o(121569);
        }
    }
}

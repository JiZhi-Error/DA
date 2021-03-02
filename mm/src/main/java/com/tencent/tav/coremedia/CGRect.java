package com.tencent.tav.coremedia;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CGRect implements Cloneable {
    public final PointF origin;
    public final CGSize size;

    public CGRect(float f2, float f3, float f4, float f5) {
        this(new PointF(f2, f3), new CGSize(f4, f5));
        AppMethodBeat.i(199380);
        AppMethodBeat.o(199380);
    }

    public CGRect(PointF pointF, CGSize cGSize) {
        AppMethodBeat.i(199381);
        pointF = pointF == null ? new PointF() : pointF;
        cGSize = cGSize == null ? new CGSize() : cGSize;
        this.origin = pointF;
        this.size = cGSize;
        AppMethodBeat.o(199381);
    }

    public CGRect() {
        AppMethodBeat.i(199382);
        this.origin = new PointF();
        this.size = new CGSize();
        AppMethodBeat.o(199382);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(199383);
        if (this == obj) {
            AppMethodBeat.o(199383);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(199383);
            return false;
        } else {
            CGRect cGRect = (CGRect) obj;
            if (!this.origin.equals(cGRect.origin) || !this.size.equals(cGRect.size)) {
                AppMethodBeat.o(199383);
                return false;
            }
            AppMethodBeat.o(199383);
            return true;
        }
    }

    public String toString() {
        AppMethodBeat.i(199384);
        String str = "[" + this.origin + "," + this.size + "]";
        AppMethodBeat.o(199384);
        return str;
    }

    @Override // java.lang.Object
    public CGRect clone() {
        AppMethodBeat.i(199385);
        CGRect cGRect = new CGRect(this.origin.x, this.origin.y, this.size.width, this.size.height);
        AppMethodBeat.o(199385);
        return cGRect;
    }
}

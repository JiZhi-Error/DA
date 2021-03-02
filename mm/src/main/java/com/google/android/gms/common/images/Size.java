package com.google.android.gms.common.images;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Size {
    private final int zzps;
    private final int zzpt;

    public Size(int i2, int i3) {
        this.zzps = i2;
        this.zzpt = i3;
    }

    public static Size parseSize(String str) {
        AppMethodBeat.i(11737);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("string must not be null");
            AppMethodBeat.o(11737);
            throw illegalArgumentException;
        }
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            indexOf = str.indexOf(120);
        }
        if (indexOf < 0) {
            NumberFormatException zzi = zzi(str);
            AppMethodBeat.o(11737);
            throw zzi;
        }
        try {
            Size size = new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            AppMethodBeat.o(11737);
            return size;
        } catch (NumberFormatException e2) {
            NumberFormatException zzi2 = zzi(str);
            AppMethodBeat.o(11737);
            throw zzi2;
        }
    }

    private static NumberFormatException zzi(String str) {
        AppMethodBeat.i(11736);
        NumberFormatException numberFormatException = new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 16).append("Invalid Size: \"").append(str).append("\"").toString());
        AppMethodBeat.o(11736);
        throw numberFormatException;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.zzps == size.zzps && this.zzpt == size.zzpt;
    }

    public final int getHeight() {
        return this.zzpt;
    }

    public final int getWidth() {
        return this.zzps;
    }

    public final int hashCode() {
        return this.zzpt ^ ((this.zzps << 16) | (this.zzps >>> 16));
    }

    public final String toString() {
        AppMethodBeat.i(11735);
        int i2 = this.zzps;
        String sb = new StringBuilder(23).append(i2).append("x").append(this.zzpt).toString();
        AppMethodBeat.o(11735);
        return sb;
    }
}

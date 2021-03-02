package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j {
    public String cNw = "normal";
    public boolean cNx;
    public a cNy;
    public float fontSize;
    public Typeface sB = null;
    public float strokeWidth;

    j(String str, a aVar) {
        this.cNw = str;
        this.fontSize = 20.0f;
        this.cNx = false;
        this.strokeWidth = 0.0f;
        this.cNy = aVar;
    }

    public enum a {
        NORMAL(0),
        BOLD(1),
        ITALIC(2),
        BOLD_ITALIC(3);
        
        int cND;

        public static a valueOf(String str) {
            AppMethodBeat.i(140051);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(140051);
            return aVar;
        }

        static {
            AppMethodBeat.i(140052);
            AppMethodBeat.o(140052);
        }

        private a(int i2) {
            this.cND = i2;
        }

        public static a j(boolean z, boolean z2) {
            if (z && z2) {
                return BOLD_ITALIC;
            }
            if (z) {
                return ITALIC;
            }
            if (z2) {
                return BOLD;
            }
            return NORMAL;
        }

        public final boolean isItalic() {
            return this == ITALIC || this == BOLD_ITALIC;
        }

        public final boolean isBold() {
            return this == BOLD || this == BOLD_ITALIC;
        }
    }

    public final String toString() {
        AppMethodBeat.i(140053);
        String str = "MBFontStyle[" + this.cNw + "][" + this.fontSize + "][" + this.strokeWidth + "]";
        AppMethodBeat.o(140053);
        return str;
    }
}

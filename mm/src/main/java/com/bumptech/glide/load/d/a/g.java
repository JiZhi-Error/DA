package com.bumptech.glide.load.d.a;

import com.bumptech.glide.load.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class g {
    public static final g aKR = new e();
    public static final g aKS = new d();
    public static final g aKT = new a();
    public static final g aKU = new b();
    public static final g aKV = new c();
    public static final g aKW = new f();
    public static final g aKX = aKS;
    public static final h<g> aKY = h.c("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", aKX);

    public abstract float l(int i2, int i3, int i4, int i5);

    public abstract EnumC0074g pB();

    static class e extends g {
        e() {
        }

        @Override // com.bumptech.glide.load.d.a.g
        public final float l(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(77388);
            float min = Math.min(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
            AppMethodBeat.o(77388);
            return min;
        }

        @Override // com.bumptech.glide.load.d.a.g
        public final EnumC0074g pB() {
            return EnumC0074g.QUALITY;
        }
    }

    static class d extends g {
        d() {
        }

        @Override // com.bumptech.glide.load.d.a.g
        public final float l(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(77387);
            float max = Math.max(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
            AppMethodBeat.o(77387);
            return max;
        }

        @Override // com.bumptech.glide.load.d.a.g
        public final EnumC0074g pB() {
            return EnumC0074g.QUALITY;
        }
    }

    static class a extends g {
        a() {
        }

        @Override // com.bumptech.glide.load.d.a.g
        public final float l(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(77384);
            int min = Math.min(i3 / i5, i2 / i4);
            if (min == 0) {
                AppMethodBeat.o(77384);
                return 1.0f;
            }
            float highestOneBit = 1.0f / ((float) Integer.highestOneBit(min));
            AppMethodBeat.o(77384);
            return highestOneBit;
        }

        @Override // com.bumptech.glide.load.d.a.g
        public final EnumC0074g pB() {
            return EnumC0074g.QUALITY;
        }
    }

    static class b extends g {
        b() {
        }

        @Override // com.bumptech.glide.load.d.a.g
        public final float l(int i2, int i3, int i4, int i5) {
            int i6 = 1;
            AppMethodBeat.i(77385);
            int ceil = (int) Math.ceil((double) Math.max(((float) i3) / ((float) i5), ((float) i2) / ((float) i4)));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i6 = 0;
            }
            float f2 = 1.0f / ((float) (max << i6));
            AppMethodBeat.o(77385);
            return f2;
        }

        @Override // com.bumptech.glide.load.d.a.g
        public final EnumC0074g pB() {
            return EnumC0074g.MEMORY;
        }
    }

    static class f extends g {
        f() {
        }

        @Override // com.bumptech.glide.load.d.a.g
        public final float l(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }

        @Override // com.bumptech.glide.load.d.a.g
        public final EnumC0074g pB() {
            return EnumC0074g.QUALITY;
        }
    }

    static class c extends g {
        c() {
        }

        @Override // com.bumptech.glide.load.d.a.g
        public final float l(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(77386);
            float min = Math.min(1.0f, aKR.l(i2, i3, i4, i5));
            AppMethodBeat.o(77386);
            return min;
        }

        @Override // com.bumptech.glide.load.d.a.g
        public final EnumC0074g pB() {
            return EnumC0074g.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.load.d.a.g$g  reason: collision with other inner class name */
    public enum EnumC0074g {
        MEMORY,
        QUALITY;

        public static EnumC0074g valueOf(String str) {
            AppMethodBeat.i(77390);
            EnumC0074g gVar = (EnumC0074g) Enum.valueOf(EnumC0074g.class, str);
            AppMethodBeat.o(77390);
            return gVar;
        }

        static {
            AppMethodBeat.i(77391);
            AppMethodBeat.o(77391);
        }
    }
}

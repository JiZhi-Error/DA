package com.google.android.exoplayer2.f.g;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class e extends com.google.android.exoplayer2.f.a {
    public final long endTime;
    public final long startTime;

    public e(CharSequence charSequence) {
        this(charSequence, (byte) 0);
    }

    private e(CharSequence charSequence, byte b2) {
        this(0, 0, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public e(long j2, long j3, CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        super(charSequence, alignment, f2, i2, i3, f3, i4, f4);
        this.startTime = j2;
        this.endTime = j3;
    }

    public static final class a {
        Layout.Alignment bAb;
        float bAc;
        int bAd;
        float bAe;
        int bAf;
        SpannableStringBuilder bDE;
        long endTime;
        int lineType;
        long startTime;
        float width;

        public a() {
            AppMethodBeat.i(92894);
            reset();
            AppMethodBeat.o(92894);
        }

        public final void reset() {
            this.startTime = 0;
            this.endTime = 0;
            this.bDE = null;
            this.bAb = null;
            this.bAc = Float.MIN_VALUE;
            this.lineType = Integer.MIN_VALUE;
            this.bAd = Integer.MIN_VALUE;
            this.bAe = Float.MIN_VALUE;
            this.bAf = Integer.MIN_VALUE;
            this.width = Float.MIN_VALUE;
        }

        public final e wv() {
            AppMethodBeat.i(92895);
            if (this.bAe != Float.MIN_VALUE && this.bAf == Integer.MIN_VALUE) {
                ww();
            }
            e eVar = new e(this.startTime, this.endTime, this.bDE, this.bAb, this.bAc, this.lineType, this.bAd, this.bAe, this.bAf, this.width);
            AppMethodBeat.o(92895);
            return eVar;
        }

        private a ww() {
            AppMethodBeat.i(92896);
            if (this.bAb != null) {
                switch (AnonymousClass1.bDD[this.bAb.ordinal()]) {
                    case 1:
                        this.bAf = 0;
                        break;
                    case 2:
                        this.bAf = 1;
                        break;
                    case 3:
                        this.bAf = 2;
                        break;
                    default:
                        new StringBuilder("Unrecognized alignment: ").append(this.bAb);
                        this.bAf = 0;
                        break;
                }
            } else {
                this.bAf = Integer.MIN_VALUE;
            }
            AppMethodBeat.o(92896);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.f.g.e$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] bDD = new int[Layout.Alignment.values().length];

        static {
            AppMethodBeat.i(92893);
            try {
                bDD[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                bDD[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                bDD[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
                AppMethodBeat.o(92893);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(92893);
            }
        }
    }
}

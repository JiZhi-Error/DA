package com.google.android.exoplayer2.c;

public interface l {
    long L(long j2);

    long getDurationUs();

    boolean uu();

    public static final class a implements l {
        private final long bdJ;

        public a(long j2) {
            this.bdJ = j2;
        }

        @Override // com.google.android.exoplayer2.c.l
        public final boolean uu() {
            return false;
        }

        @Override // com.google.android.exoplayer2.c.l
        public final long getDurationUs() {
            return this.bdJ;
        }

        @Override // com.google.android.exoplayer2.c.l
        public final long L(long j2) {
            return 0;
        }
    }
}

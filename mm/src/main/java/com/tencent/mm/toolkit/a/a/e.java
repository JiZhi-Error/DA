package com.tencent.mm.toolkit.a.a;

public interface e {
    boolean bws();

    int getTimeout();

    public static class a implements e {
        private final int OvM;
        private final float OvN;
        private int OvO;
        private int OvP;

        public a() {
            this((byte) 0);
        }

        private a(byte b2) {
            this.OvP = 0;
            this.OvO = 5000;
            this.OvM = 3;
            this.OvN = 1.0f;
        }

        @Override // com.tencent.mm.toolkit.a.a.e
        public final int getTimeout() {
            return this.OvO;
        }

        @Override // com.tencent.mm.toolkit.a.a.e
        public final boolean bws() {
            this.OvP++;
            this.OvO = (int) (((float) this.OvO) + (((float) this.OvO) * this.OvN));
            return this.OvP < this.OvM;
        }
    }
}

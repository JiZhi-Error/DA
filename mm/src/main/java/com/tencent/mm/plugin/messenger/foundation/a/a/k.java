package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public interface k {

    public static class b {
        public byte[] buffer;
        public int cSx = -1;
        public int cmdId;
        public long iWh;
        public int id;
        public int zqr;
        public long zqs;
        public String zqt;
        public String zqu;
        public com.tencent.mm.bw.a zqv;

        public b(int i2) {
            this.cmdId = i2;
        }

        public int getCmdId() {
            return this.cmdId;
        }

        public final com.tencent.mm.bw.a eiR() {
            return this.zqv;
        }

        public final byte[] getBuffer() {
            AppMethodBeat.i(43081);
            if (this.buffer == null && this.zqv != null) {
                try {
                    this.buffer = this.zqv.toByteArray();
                } catch (IOException e2) {
                    Log.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + e2.getMessage());
                }
            }
            byte[] bArr = this.buffer;
            AppMethodBeat.o(43081);
            return bArr;
        }
    }

    public static class a extends b {
        private int cmdId;

        public a(int i2, com.tencent.mm.bw.a aVar) {
            super(i2);
            this.cmdId = i2;
            this.zqv = aVar;
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.a.k.b
        public final int getCmdId() {
            return this.cmdId;
        }
    }
}

package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public int channelCount = 0;
    public c dyI = null;
    public int dzj = -1;
    public RecordParam neo;
    public long nep = 0;
    public AbstractC0753a neq;
    public c.a ner = new c.a() {
        /* class com.tencent.mm.plugin.appbrand.media.record.record_imp.a.AnonymousClass1 */

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            AppMethodBeat.i(146185);
            Log.i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
            if (a.this.neq != null) {
                a.this.neq.w(bArr, i2);
            }
            AppMethodBeat.o(146185);
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
            AppMethodBeat.i(146186);
            Log.e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (a.this.neq != null) {
                a.this.neq.cj(i2, i3);
            }
            AppMethodBeat.o(146186);
        }
    };
    public int sampleRate = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.record_imp.a$a  reason: collision with other inner class name */
    public interface AbstractC0753a {
        void cj(int i2, int i3);

        void w(byte[] bArr, int i2);
    }

    public a(RecordParam recordParam) {
        AppMethodBeat.i(146187);
        recordParam = recordParam == null ? new RecordParam() : recordParam;
        this.sampleRate = recordParam.sampleRate;
        this.channelCount = recordParam.mFQ;
        this.dzj = recordParam.scene;
        this.neo = recordParam;
        AppMethodBeat.o(146187);
    }

    public final boolean ZZ() {
        boolean z;
        AppMethodBeat.i(146188);
        Log.i("MicroMsg.Record.AppBrandRecorder", JsApiStopRecordVoice.NAME);
        if (this.dyI != null) {
            z = this.dyI.ZZ();
        } else {
            z = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.nep -= currentTimeMillis;
        Log.i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", Long.valueOf(currentTimeMillis), Long.valueOf(this.nep));
        AppMethodBeat.o(146188);
        return z;
    }
}

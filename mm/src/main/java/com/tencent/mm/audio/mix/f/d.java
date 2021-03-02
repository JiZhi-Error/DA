package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.b;
import com.tencent.mm.audio.mix.a.e;
import java.util.List;

public final class d implements i {
    private h dwA;
    private int dwB = 4;

    @Override // com.tencent.mm.audio.mix.f.i
    public final void init() {
        h bVar;
        AppMethodBeat.i(136864);
        if (this.dwA == null) {
            switch (this.dwB) {
                case 1:
                    bVar = new n();
                    break;
                case 2:
                    bVar = new a();
                    break;
                case 3:
                    bVar = new k();
                    break;
                case 4:
                    bVar = new j();
                    break;
                case 5:
                    bVar = new m();
                    break;
                case 6:
                    bVar = new o();
                    break;
                case 7:
                    bVar = new l();
                    break;
                case 8:
                    bVar = new b();
                    break;
                default:
                    bVar = new j();
                    break;
            }
            this.dwA = bVar;
        }
        AppMethodBeat.o(136864);
    }

    @Override // com.tencent.mm.audio.mix.f.i
    public final b P(List<e> list) {
        AppMethodBeat.i(136865);
        if (this.dwA == null) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixer", "mixAlgorithm must be init, please call init() first");
            AppMethodBeat.o(136865);
            return null;
        }
        b YE = com.tencent.mm.audio.mix.b.b.YD().YE();
        if (!this.dwA.a(YE, list)) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixer", "mix audio fail");
            AppMethodBeat.o(136865);
            return null;
        }
        AppMethodBeat.o(136865);
        return YE;
    }
}

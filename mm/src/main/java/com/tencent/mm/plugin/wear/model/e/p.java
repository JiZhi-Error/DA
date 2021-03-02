package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.wear.model.d.c;
import com.tencent.mm.protocal.protobuf.ezu;
import com.tencent.mm.protocal.protobuf.ezv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.qqpinyin.voicerecoapi.c;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public final class p implements i {
    public static final String Iyx = (ar.NSe + "tmp_wearvoicetotext.spx");
    public d IyA;
    private int IyB = 0;
    public int IyC;
    public int IyD;
    public c Iyy;
    public com.tencent.qqpinyin.voicerecoapi.c Iyz;
    public boolean ehd = false;
    public LinkedList<Integer> ljc = new LinkedList<>();

    public p() {
        AppMethodBeat.i(30103);
        AppMethodBeat.o(30103);
    }

    static {
        AppMethodBeat.i(30107);
        AppMethodBeat.o(30107);
    }

    public final void reset() {
        AppMethodBeat.i(30104);
        Log.i("MicroMsg.Wear.VoiceToTextServer", "reset: sessionId=%s", Integer.valueOf(this.IyC));
        if (this.IyA != null) {
            this.IyA.abP();
            this.IyA = null;
            Log.i("MicroMsg.Wear.VoiceToTextServer", "reset speexWriter");
        }
        if (this.Iyz != null) {
            this.Iyz.stop();
            this.Iyz = null;
            Log.i("MicroMsg.Wear.VoiceToTextServer", "reset voiceDetectAPI");
        }
        if (this.Iyy != null) {
            this.Iyy.jul = true;
            bg.azz().b(349, this);
            bg.azz().a(this.Iyy);
            this.Iyy = null;
        }
        this.IyD = 0;
        this.ehd = false;
        this.IyB = 0;
        this.IyC = -1;
        this.ljc.clear();
        AppMethodBeat.o(30104);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(30105);
        if (qVar instanceof c) {
            c cVar = (c) qVar;
            if (i2 != 0 || i3 != 0) {
                bg.azz().b(349, this);
                ezv ezv = new ezv();
                ezv.MRZ = cVar.talker;
                ezv.KTg = "";
                ezv.KCD = -1;
                ezv.NvV = false;
                com.tencent.mm.plugin.wear.model.a.fVN().a(new a(cVar.dEb, ezv));
                AppMethodBeat.o(30105);
                return;
            } else if (cVar.Iyo) {
                bg.azz().b(349, this);
                ezv ezv2 = new ezv();
                ezv2.MRZ = cVar.talker;
                if (!Util.isNullOrNil(cVar.Iyn)) {
                    Log.i("MicroMsg.Wear.VoiceToTextServer", "receive text: %s", cVar.Iyn);
                    ezv2.KTg = cVar.Iyn;
                    ezv2.KCD = 0;
                    ezv2.NvV = true;
                } else {
                    ezv2.KTg = "";
                    ezv2.KCD = -1;
                    ezv2.NvV = false;
                }
                com.tencent.mm.plugin.wear.model.a.fVN().a(new a(cVar.dEb, ezv2));
            }
        }
        AppMethodBeat.o(30105);
    }

    class a extends com.tencent.mm.plugin.wear.model.f.c {
        public int IxV = 2;
        public ezv IyF;
        public int dEb;
        public int jiX;

        public a(int i2, ezv ezv) {
            this.dEb = i2;
            this.jiX = CdnLogic.kMediaLittleAppPacket;
            this.IyF = ezv;
        }

        @Override // com.tencent.mm.plugin.wear.model.f.c
        public final void send() {
            AppMethodBeat.i(30102);
            try {
                byte[] cx = com.tencent.mm.plugin.wear.model.a.fVM().cx(this.IyF.toByteArray());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeInt(this.IxV);
                    dataOutputStream.writeInt(this.dEb);
                    dataOutputStream.writeInt(this.jiX);
                    if (cx == null || cx.length <= 0) {
                        dataOutputStream.writeInt(0);
                    } else {
                        dataOutputStream.writeInt(cx.length);
                        dataOutputStream.write(cx);
                    }
                    Log.i("MicroMsg.Wear.VoiceToTextServer", "send data funId=%d length=%d", Integer.valueOf(this.jiX), Integer.valueOf(byteArrayOutputStream.toByteArray().length));
                    com.tencent.mm.plugin.wear.model.a.fVM().cv(byteArrayOutputStream.toByteArray());
                    AppMethodBeat.o(30102);
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e2, "gen response data error connectType=%d, sessionId=%d, funId=%d", Integer.valueOf(this.IxV), Integer.valueOf(this.dEb), Integer.valueOf(this.jiX));
                    AppMethodBeat.o(30102);
                }
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e3, "", new Object[0]);
                AppMethodBeat.o(30102);
            }
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final String getName() {
            return "WearVoiceToTextTask";
        }
    }

    public final void a(int i2, ezu ezu) {
        AppMethodBeat.i(30106);
        if (ezu.KKz == null) {
            Log.i("MicroMsg.Wear.VoiceToTextServer", "voice data is null");
            AppMethodBeat.o(30106);
            return;
        }
        byte[] byteArray = ezu.KKz.toByteArray();
        this.IyB += this.IyA.a(new g.a(byteArray, ezu.KUy), 0, false);
        Log.i("MicroMsg.Wear.VoiceToTextServer", "write bytes: %d", Integer.valueOf(this.IyB));
        short[] sArr = new short[(ezu.KUy / 2)];
        for (int i3 = 0; i3 < ezu.KUy / 2; i3++) {
            sArr[i3] = (short) ((byteArray[i3 * 2] & 255) | (byteArray[(i3 * 2) + 1] << 8));
        }
        c.a aVar = new c.a();
        this.Iyz.a(sArr, ezu.KUy / 2, aVar);
        Log.i("MicroMsg.Wear.VoiceToTextServer", "state.vad_flag: " + aVar.RKK);
        if (aVar.RKK == 2) {
            this.IyD = 1;
        } else if (aVar.RKK == 3) {
            this.IyD = 2;
        }
        if (this.IyD != 0) {
            if (this.IyD < 0) {
                if (this.ljc.size() > 10) {
                    this.ljc.removeLast();
                }
                this.ljc.addFirst(Integer.valueOf(i2));
            }
            if (this.IyD == 1) {
                ezv ezv = new ezv();
                ezv.MRZ = this.Iyy.talker;
                ezv.KTg = "";
                ezv.KCD = this.IyD;
                ezv.NvV = true;
                com.tencent.mm.plugin.wear.model.a.fVN().a(new a(this.Iyy.dEb, ezv));
                this.IyD = 0;
            }
        }
        if (!this.ehd && this.IyB > 3300) {
            this.ehd = true;
            bg.azz().a(this.Iyy, 0);
        }
        AppMethodBeat.o(30106);
    }
}

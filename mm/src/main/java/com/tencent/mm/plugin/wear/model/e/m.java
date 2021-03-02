package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.g.a.aan;
import com.tencent.mm.g.a.aap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.boots.a.b;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.ecw;
import com.tencent.mm.protocal.protobuf.eys;
import com.tencent.mm.protocal.protobuf.ezm;
import com.tencent.mm.protocal.protobuf.ezn;
import com.tencent.mm.protocal.protobuf.ezo;
import com.tencent.mm.protocal.protobuf.ezp;
import com.tencent.mm.protocal.protobuf.ezt;
import com.tencent.mm.protocal.protobuf.fbx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.ugc.TXRecordCommon;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class m extends a {
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30094);
        ArrayList arrayList = new ArrayList();
        arrayList.add(11022);
        arrayList.add(11023);
        arrayList.add(11025);
        arrayList.add(11024);
        arrayList.add(11026);
        arrayList.add(11029);
        AppMethodBeat.o(30094);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final boolean afh(int i2) {
        switch (i2) {
            case 11023:
            case 11025:
                return true;
            case 11024:
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        AppMethodBeat.i(30095);
        ((c) g.af(c.class)).fb(b.pkD, 1171);
        switch (i2) {
            case 11022:
                ezp ezp = new ezp();
                try {
                    ezp.parseFrom(bArr);
                } catch (IOException e2) {
                }
                com.tencent.mm.plugin.wear.model.a.fVN().a(new a(ezp));
                com.tencent.mm.plugin.wear.model.a.fVK().aWl(ezp.MRZ);
                com.tencent.mm.plugin.wear.model.c.a.jZ(2, ezp.Scene);
                com.tencent.mm.plugin.wear.model.c.a.aff(2);
                break;
            case 11023:
                ezo ezo = new ezo();
                try {
                    ezo.parseFrom(bArr);
                } catch (IOException e3) {
                }
                com.tencent.mm.plugin.messenger.a.g.eir().ad(ezo.MRZ, ezo.KTg, ab.JG(ezo.MRZ));
                bg.aVF();
                com.tencent.mm.model.c.aST().bka(ezo.MRZ);
                com.tencent.mm.plugin.wear.model.c.a.jZ(3, ezo.Scene);
                com.tencent.mm.plugin.wear.model.c.a.aff(5);
                break;
            case 11024:
                ezm ezm = new ezm();
                try {
                    ezm.parseFrom(bArr);
                } catch (IOException e4) {
                }
                ((d) g.ah(d.class)).getEmojiMgr().u(MMApplicationContext.getContext(), ezm.MRZ, ezm.MD5);
                bg.aVF();
                com.tencent.mm.model.c.aST().bka(ezm.MRZ);
                com.tencent.mm.plugin.wear.model.c.a.jZ(7, ezm.Scene);
                com.tencent.mm.plugin.wear.model.c.a.aff(3);
                break;
            case 11025:
                ezn ezn = new ezn();
                try {
                    ezn.parseFrom(bArr);
                } catch (IOException e5) {
                }
                com.tencent.mm.plugin.messenger.a.g.eir().ad(ezn.MRZ, ezn.KTg, ab.JG(ezn.MRZ));
                ((d) g.ah(d.class)).getEmojiMgr().u(MMApplicationContext.getContext(), ezn.MRZ, ezn.MD5);
                bg.aVF();
                com.tencent.mm.model.c.aST().bka(ezn.MRZ);
                com.tencent.mm.plugin.wear.model.c.a.jZ(8, ezn.Scene);
                com.tencent.mm.plugin.wear.model.c.a.aff(4);
                break;
            case 11026:
                ezt ezt = new ezt();
                try {
                    ezt.parseFrom(bArr);
                } catch (IOException e6) {
                }
                com.tencent.mm.plugin.wear.model.a.fVL();
                eys eys = com.tencent.mm.plugin.wear.model.a.fVM().IxH.Iyu;
                if (eys != null) {
                    Log.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", Integer.valueOf(ezt.NvS), f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, ezt.MDQ / 1000));
                    fbx fbx = new fbx();
                    ecw ecw = new ecw();
                    ecw.oUu = ezt.NvS > 0 ? ezt.NvS : 0;
                    ecw.Timestamp = (int) (ezt.MDQ / 1000);
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(ezt.MDQ);
                    ecw.Ndh = instance.get(1);
                    ecw.Ndi = instance.get(2) + 1;
                    ecw.Ndj = instance.get(5);
                    ecw.Ndk = instance.get(11);
                    ecw.Ndl = instance.get(12);
                    ecw.Ndm = instance.get(13);
                    fbx.NxX.add(ecw);
                    aap aap = new aap();
                    try {
                        aap.ehC.data = fbx.toByteArray();
                    } catch (IOException e7) {
                    }
                    aap.ehC.dDe = 4;
                    aap.ehC.dGL = eys.Nvp;
                    aap.ehC.dGP = "gh_43f2581f6fd6";
                    EventCenter.instance.publish(aap);
                    break;
                } else {
                    Log.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                    break;
                }
            case 11029:
                if (com.tencent.mm.plugin.wear.model.a.fVM().fVW() && h.aqJ().getInt("WearLuckyBlock", 0) == 0) {
                    long j2 = 0;
                    try {
                        j2 = Long.valueOf(new String(bArr)).longValue();
                    } catch (Exception e8) {
                    }
                    aan aan = new aan();
                    aan.ehq.action = 1;
                    aan.ehq.dFm = j2;
                    EventCenter.instance.asyncPublish(aan, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.jZ(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.aff(11);
                    break;
                } else {
                    AppMethodBeat.o(30095);
                    return null;
                }
                break;
        }
        AppMethodBeat.o(30095);
        return null;
    }

    static class a extends com.tencent.mm.plugin.wear.model.f.d {
        private ezp Iyw;

        public a(ezp ezp) {
            this.Iyw = ezp;
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final void execute() {
            AppMethodBeat.i(30093);
            String Rh = s.Rh(this.Iyw.MRZ);
            Log.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", Rh);
            String Y = s.Y(Rh, false);
            Log.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", Y);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.Iyw.KKz.toByteArray());
            com.tencent.mm.audio.e.c cVar = new com.tencent.mm.audio.e.c(TXRecordCommon.AUDIO_SAMPLERATE_8000, 16000);
            cVar.hz(Y);
            byte[] bArr = new byte[320];
            int i2 = 0;
            while (true) {
                try {
                    i2 = byteArrayInputStream.read(bArr, 0, 320);
                } catch (IOException e2) {
                }
                if (i2 > 0) {
                    cVar.a(new g.a(bArr, i2), 0, false);
                } else {
                    cVar.abP();
                    Log.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
                    s.aB(Rh, (int) this.Iyw.NvN);
                    o.bid().run();
                    Log.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
                    bg.aVF();
                    com.tencent.mm.model.c.aST().bka(this.Iyw.MRZ);
                    AppMethodBeat.o(30093);
                    return;
                }
            }
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final String getName() {
            return "SendVioceMsgTask";
        }
    }
}

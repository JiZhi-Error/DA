package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class VoiceInputBehavior extends a {
    public int cancel;
    public int chooseArea;
    public int chooseCantonese;
    public int clear;
    public int click;
    public int fail;
    public int fullScreenVoiceLongClick;
    public long fullScreenVoiceLongClickTime;
    public long initChoose;
    public int longClick;
    public long longClickTime;
    public int send;
    public int setDefaultLanguage;
    public int setSwitchCantonese;
    public int setlanguage;
    public int showInit;
    public int smileIconClick;
    public int textChangeCount;
    public int textChangeReturn;
    public long textChangeTime;
    public int textClick;
    public int voiceIconClick;
    public long voiceInputTime;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151541);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.cancel);
            aVar.aM(2, this.send);
            aVar.aM(3, this.click);
            aVar.aM(4, this.longClick);
            aVar.bb(5, this.longClickTime);
            aVar.aM(6, this.textClick);
            aVar.aM(7, this.textChangeCount);
            aVar.bb(8, this.textChangeTime);
            aVar.aM(9, this.textChangeReturn);
            aVar.bb(10, this.voiceInputTime);
            aVar.aM(11, this.fail);
            aVar.aM(12, this.clear);
            aVar.aM(13, this.smileIconClick);
            aVar.aM(14, this.voiceIconClick);
            aVar.aM(15, this.fullScreenVoiceLongClick);
            aVar.bb(16, this.fullScreenVoiceLongClickTime);
            aVar.aM(17, this.showInit);
            aVar.bb(18, this.initChoose);
            aVar.aM(19, this.chooseArea);
            aVar.aM(20, this.chooseCantonese);
            aVar.aM(21, this.setlanguage);
            aVar.aM(22, this.setSwitchCantonese);
            aVar.aM(23, this.setDefaultLanguage);
            AppMethodBeat.o(151541);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.cancel) + 0 + g.a.a.b.b.a.bu(2, this.send) + g.a.a.b.b.a.bu(3, this.click) + g.a.a.b.b.a.bu(4, this.longClick) + g.a.a.b.b.a.r(5, this.longClickTime) + g.a.a.b.b.a.bu(6, this.textClick) + g.a.a.b.b.a.bu(7, this.textChangeCount) + g.a.a.b.b.a.r(8, this.textChangeTime) + g.a.a.b.b.a.bu(9, this.textChangeReturn) + g.a.a.b.b.a.r(10, this.voiceInputTime) + g.a.a.b.b.a.bu(11, this.fail) + g.a.a.b.b.a.bu(12, this.clear) + g.a.a.b.b.a.bu(13, this.smileIconClick) + g.a.a.b.b.a.bu(14, this.voiceIconClick) + g.a.a.b.b.a.bu(15, this.fullScreenVoiceLongClick) + g.a.a.b.b.a.r(16, this.fullScreenVoiceLongClickTime) + g.a.a.b.b.a.bu(17, this.showInit) + g.a.a.b.b.a.r(18, this.initChoose) + g.a.a.b.b.a.bu(19, this.chooseArea) + g.a.a.b.b.a.bu(20, this.chooseCantonese) + g.a.a.b.b.a.bu(21, this.setlanguage) + g.a.a.b.b.a.bu(22, this.setSwitchCantonese) + g.a.a.b.b.a.bu(23, this.setDefaultLanguage);
            AppMethodBeat.o(151541);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(151541);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            VoiceInputBehavior voiceInputBehavior = (VoiceInputBehavior) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    voiceInputBehavior.cancel = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 2:
                    voiceInputBehavior.send = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 3:
                    voiceInputBehavior.click = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 4:
                    voiceInputBehavior.longClick = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 5:
                    voiceInputBehavior.longClickTime = aVar3.UbS.zl();
                    AppMethodBeat.o(151541);
                    return 0;
                case 6:
                    voiceInputBehavior.textClick = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 7:
                    voiceInputBehavior.textChangeCount = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 8:
                    voiceInputBehavior.textChangeTime = aVar3.UbS.zl();
                    AppMethodBeat.o(151541);
                    return 0;
                case 9:
                    voiceInputBehavior.textChangeReturn = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 10:
                    voiceInputBehavior.voiceInputTime = aVar3.UbS.zl();
                    AppMethodBeat.o(151541);
                    return 0;
                case 11:
                    voiceInputBehavior.fail = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 12:
                    voiceInputBehavior.clear = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 13:
                    voiceInputBehavior.smileIconClick = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 14:
                    voiceInputBehavior.voiceIconClick = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 15:
                    voiceInputBehavior.fullScreenVoiceLongClick = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 16:
                    voiceInputBehavior.fullScreenVoiceLongClickTime = aVar3.UbS.zl();
                    AppMethodBeat.o(151541);
                    return 0;
                case 17:
                    voiceInputBehavior.showInit = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 18:
                    voiceInputBehavior.initChoose = aVar3.UbS.zl();
                    AppMethodBeat.o(151541);
                    return 0;
                case 19:
                    voiceInputBehavior.chooseArea = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 20:
                    voiceInputBehavior.chooseCantonese = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 21:
                    voiceInputBehavior.setlanguage = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 22:
                    voiceInputBehavior.setSwitchCantonese = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                case 23:
                    voiceInputBehavior.setDefaultLanguage = aVar3.UbS.zi();
                    AppMethodBeat.o(151541);
                    return 0;
                default:
                    AppMethodBeat.o(151541);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151541);
            return -1;
        }
    }
}

package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bh;

public final class f {
    public int HH;
    public int mStatus;
    public a qYk;
    public EmotionSummary qYl;
    public EmotionBannerSet qYm;
    public int qYn;
    public String qYo;
    public boolean qYp;
    public boolean qYq = true;
    public boolean qYr = false;

    public enum a {
        summary,
        cellset;

        public static a valueOf(String str) {
            AppMethodBeat.i(108380);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(108380);
            return aVar;
        }

        static {
            AppMethodBeat.i(108381);
            AppMethodBeat.o(108381);
        }
    }

    public f(EmotionSummary emotionSummary) {
        this.qYl = emotionSummary;
        this.qYk = a.summary;
    }

    public f(EmotionBannerSet emotionBannerSet) {
        this.qYm = emotionBannerSet;
        this.qYk = a.cellset;
    }

    public final void setStatus(int i2) {
        if (i2 == 7 && this.mStatus == 6 && this.qYq) {
            this.qYp = true;
        }
        this.mStatus = i2;
    }

    public final void a(boolean z, bh bhVar, boolean z2) {
        AppMethodBeat.i(108382);
        EmotionSummary emotionSummary = this.qYl;
        if (emotionSummary == null) {
            AppMethodBeat.o(108382);
        } else if (z2) {
            setStatus(7);
            AppMethodBeat.o(108382);
        } else {
            boolean a2 = e.a(emotionSummary);
            boolean b2 = e.b(emotionSummary);
            boolean e2 = e.e(emotionSummary);
            boolean isEmpty = TextUtils.isEmpty(emotionSummary.PackPrice);
            if (!e2 || !b2) {
                if (!a2) {
                    if (!b2 && (z || !isEmpty)) {
                        this.qYn = 1;
                        if (z && bhVar != null) {
                            switch (bhVar.Opx) {
                                case 11:
                                    setStatus(11);
                                    break;
                                case 12:
                                    setStatus(4);
                                    break;
                                default:
                                    if (!(bhVar.Opv == 7 || bhVar.Opv == 6 || bhVar.Opv == 3)) {
                                        setStatus(10);
                                        break;
                                    }
                            }
                        } else if (z) {
                            setStatus(11);
                        } else {
                            setStatus(4);
                        }
                    } else {
                        setStatus(3);
                        this.qYn = 0;
                    }
                } else {
                    setStatus(3);
                    if (b2 || (!z && isEmpty)) {
                        this.qYn = 0;
                    } else {
                        this.qYn = 1;
                    }
                }
            } else {
                setStatus(8);
            }
            if (z && bhVar != null && !Util.isNullOrNil(bhVar.OpB)) {
                this.qYl.PackPrice = bhVar.OpB;
                this.qYl.PriceNum = bhVar.OpA;
                this.qYl.PriceType = bhVar.Opz;
            }
            AppMethodBeat.o(108382);
        }
    }
}

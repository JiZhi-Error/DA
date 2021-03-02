package com.tencent.mm.audio.c.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007Jh\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002J&\u0010'\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0007J \u0010*\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H\u0002J \u0010.\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0002J\u000e\u0010/\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0007J \u00100\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H\u0002J\u000e\u00101\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0007J \u00102\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0002J\b\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u00066"}, hxF = {"Lcom/tencent/mm/audio/utils/player/AudioPlayerReportUtil;", "", "()V", "mIsReportStart", "", "mRMSInOnePlayerProcess", "", "", "[Ljava/lang/Integer;", "mSystemVolumProcess", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkSystemVolume", "type", "volume", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "doAudioVolumeRecordKVReport", "streamType", "doPCMPlayerChecker", "doPCMPlayerPercentReport", FirebaseAnalytics.b.INDEX, "result", "", "doPCMPlayerResultReport", "doPcmPlayerReport", "doSystemVolumePercentReport", "doSystemVolumePlayerChecker", "doSystemVolumeResultReport", "getRMSInOnePlayerProcessReportSum", "getSystemVolumePercentReportSum", "Companion", "plugin-audiosdk_release"})
public final class a {
    public static final C0272a dAW = new C0272a((byte) 0);
    private boolean dAT;
    private Integer[] dAU;
    private Integer[] dAV;

    static {
        AppMethodBeat.i(130117);
        AppMethodBeat.o(130117);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/audio/utils/player/AudioPlayerReportUtil$Companion;", "", "()V", "RMS_TYPE_HIGH", "", "RMS_TYPE_LOW", "RMS_TYPE_MIDDLE", "RMS_TYPE_SILENT", "TAG", "", "plugin-audiosdk_release"})
    /* renamed from: com.tencent.mm.audio.c.a.a$a  reason: collision with other inner class name */
    public static final class C0272a {
        private C0272a() {
        }

        public /* synthetic */ C0272a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(130116);
        Integer[] numArr = new Integer[4];
        for (int i2 = 0; i2 < 4; i2++) {
            numArr[i2] = 0;
        }
        this.dAU = numArr;
        Integer[] numArr2 = new Integer[4];
        for (int i3 = 0; i3 < 4; i3++) {
            numArr2[i3] = 0;
        }
        this.dAV = numArr2;
        AppMethodBeat.o(130116);
    }

    public final void b(int i2, String str, int i3) {
        AppMethodBeat.i(130109);
        p.h(str, "featureKey");
        int aaz = aaz();
        if (aaz != 0) {
            int intValue = (this.dAU[0].intValue() * 100) / aaz;
            int intValue2 = (this.dAU[1].intValue() * 100) / aaz;
            int intValue3 = (this.dAU[2].intValue() * 100) / aaz;
            int intValue4 = (this.dAU[3].intValue() * 100) / aaz;
            int intValue5 = (this.dAV[0].intValue() * 100) / aaz;
            int intValue6 = (this.dAV[1].intValue() * 100) / aaz;
            int intValue7 = (this.dAV[2].intValue() * 100) / aaz;
            int intValue8 = (this.dAV[3].intValue() * 100) / aaz;
            Log.i("MicroMsg.AudioPlayerReportUtil", "audioType = 1 ,scenes = " + i2 + ",featureKey=" + str + ",pcmSilent=" + intValue + ", pcmLow=" + intValue2 + ",pcmMiddle=" + intValue3 + ",pcmHigh=" + intValue4 + ",systemSilent=" + intValue5 + ",systemLow=" + intValue6 + ",systemMiddle=" + intValue7 + ",systemHigh=" + intValue8 + ",streamType=" + i3 + '}');
            h.INSTANCE.a(18554, true, true, 1, Integer.valueOf(i2), str, Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3), Integer.valueOf(intValue4), Integer.valueOf(intValue5), Integer.valueOf(intValue6), Integer.valueOf(intValue7), Integer.valueOf(intValue8), Integer.valueOf(i3));
        }
        AppMethodBeat.o(130109);
    }

    public final void jm(int i2) {
        AppMethodBeat.i(130110);
        this.dAT = true;
        switch (i2) {
            case 0:
                c.aaA();
                AppMethodBeat.o(130110);
                return;
            case 1:
                b.aaA();
                break;
        }
        AppMethodBeat.o(130110);
    }

    public final void jn(int i2) {
        AppMethodBeat.i(130111);
        if (!this.dAT) {
            AppMethodBeat.o(130111);
            return;
        }
        int aaz = aaz();
        if (aaz != 0) {
            Integer[] numArr = this.dAU;
            int i3 = 0;
            int length = numArr.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = i3 + 1;
                int intValue = numArr[i4].intValue();
                long j2 = (long) ((intValue * 100) / aaz);
                if (this.dAT) {
                    switch (i2) {
                        case 0:
                            switch (i3) {
                                case 0:
                                    c.bv(j2);
                                    break;
                                case 1:
                                    c.bw(j2);
                                    break;
                                case 2:
                                    c.bx(j2);
                                    break;
                                case 3:
                                    c.by(j2);
                                    break;
                            }
                        case 1:
                            switch (i3) {
                                case 0:
                                    b.bv(j2);
                                    break;
                                case 1:
                                    b.bw(j2);
                                    break;
                                case 2:
                                    b.bx(j2);
                                    break;
                                case 3:
                                    b.by(j2);
                                    break;
                            }
                    }
                }
                int i6 = (intValue * 100) / aaz;
                if (this.dAT) {
                    switch (i2) {
                        case 0:
                            switch (i3) {
                                case 0:
                                    if (i6 != 0) {
                                        if (i6 > 20) {
                                            if (i6 > 40) {
                                                if (i6 > 60) {
                                                    if (i6 > 80) {
                                                        if (i6 == 100) {
                                                            c.aaG();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        c.aaF();
                                                        break;
                                                    }
                                                } else {
                                                    c.aaE();
                                                    break;
                                                }
                                            } else {
                                                c.aaD();
                                                break;
                                            }
                                        } else {
                                            c.aaC();
                                            break;
                                        }
                                    } else {
                                        c.aaB();
                                        continue;
                                        continue;
                                    }
                                case 1:
                                    if (i6 != 0) {
                                        if (i6 > 20) {
                                            if (i6 > 40) {
                                                if (i6 > 60) {
                                                    if (i6 > 80) {
                                                        if (i6 == 100) {
                                                            c.aaM();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        c.aaL();
                                                        break;
                                                    }
                                                } else {
                                                    c.aaK();
                                                    break;
                                                }
                                            } else {
                                                c.aaJ();
                                                break;
                                            }
                                        } else {
                                            c.aaI();
                                            break;
                                        }
                                    } else {
                                        c.aaH();
                                        continue;
                                    }
                                case 2:
                                    if (i6 != 0) {
                                        if (i6 > 20) {
                                            if (i6 > 40) {
                                                if (i6 > 60) {
                                                    if (i6 > 80) {
                                                        if (i6 == 100) {
                                                            c.aaS();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        c.aaR();
                                                        break;
                                                    }
                                                } else {
                                                    c.aaQ();
                                                    break;
                                                }
                                            } else {
                                                c.aaP();
                                                break;
                                            }
                                        } else {
                                            c.aaO();
                                            break;
                                        }
                                    } else {
                                        c.aaN();
                                        continue;
                                    }
                                case 3:
                                    if (i6 != 0) {
                                        if (i6 > 20) {
                                            if (i6 > 40) {
                                                if (i6 > 60) {
                                                    if (i6 > 80) {
                                                        if (i6 == 100) {
                                                            c.aaY();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        c.aaX();
                                                        break;
                                                    }
                                                } else {
                                                    c.aaW();
                                                    break;
                                                }
                                            } else {
                                                c.aaV();
                                                break;
                                            }
                                        } else {
                                            c.aaU();
                                            break;
                                        }
                                    } else {
                                        c.aaT();
                                        continue;
                                    }
                            }
                        case 1:
                            switch (i3) {
                                case 0:
                                    if (i6 != 0) {
                                        if (i6 > 20) {
                                            if (i6 > 40) {
                                                if (i6 > 60) {
                                                    if (i6 > 80) {
                                                        if (i6 <= 100) {
                                                            b.aaG();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        b.aaF();
                                                        break;
                                                    }
                                                } else {
                                                    b.aaE();
                                                    break;
                                                }
                                            } else {
                                                b.aaD();
                                                break;
                                            }
                                        } else {
                                            b.aaC();
                                            break;
                                        }
                                    } else {
                                        b.aaB();
                                        continue;
                                        continue;
                                    }
                                case 1:
                                    if (i6 != 0) {
                                        if (i6 > 20) {
                                            if (i6 > 40) {
                                                if (i6 > 60) {
                                                    if (i6 > 80) {
                                                        if (i6 <= 100) {
                                                            b.aaM();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        b.aaL();
                                                        break;
                                                    }
                                                } else {
                                                    b.aaK();
                                                    break;
                                                }
                                            } else {
                                                b.aaJ();
                                                break;
                                            }
                                        } else {
                                            b.aaI();
                                            break;
                                        }
                                    } else {
                                        b.aaH();
                                        continue;
                                    }
                                case 2:
                                    if (i6 != 0) {
                                        if (i6 > 20) {
                                            if (i6 > 40) {
                                                if (i6 > 60) {
                                                    if (i6 > 80) {
                                                        if (i6 <= 100) {
                                                            b.aaS();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        b.aaR();
                                                        break;
                                                    }
                                                } else {
                                                    b.aaQ();
                                                    break;
                                                }
                                            } else {
                                                b.aaP();
                                                break;
                                            }
                                        } else {
                                            b.aaO();
                                            break;
                                        }
                                    } else {
                                        b.aaN();
                                        continue;
                                    }
                                case 3:
                                    if (i6 != 0) {
                                        if (i6 > 20) {
                                            if (i6 > 40) {
                                                if (i6 > 60) {
                                                    if (i6 > 80) {
                                                        if (i6 <= 100) {
                                                            b.aaY();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        b.aaX();
                                                        break;
                                                    }
                                                } else {
                                                    b.aaW();
                                                    break;
                                                }
                                            } else {
                                                b.aaV();
                                                break;
                                            }
                                        } else {
                                            b.aaU();
                                            break;
                                        }
                                    } else {
                                        b.aaT();
                                        continue;
                                    }
                            }
                    }
                }
                i4++;
                i3 = i5;
            }
            Integer[] numArr2 = new Integer[4];
            for (int i7 = 0; i7 < 4; i7++) {
                numArr2[i7] = 0;
            }
            this.dAU = numArr2;
        }
        AppMethodBeat.o(130111);
    }

    public final void jo(int i2) {
        AppMethodBeat.i(130112);
        if (!this.dAT) {
            AppMethodBeat.o(130112);
            return;
        }
        Integer[] numArr = this.dAV;
        int length = numArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int intValue = i4 + numArr[i3].intValue();
            i3++;
            i4 = intValue;
        }
        if (i4 != 0) {
            Integer[] numArr2 = this.dAV;
            int i5 = 0;
            int length2 = numArr2.length;
            int i6 = 0;
            while (i6 < length2) {
                int i7 = i5 + 1;
                int intValue2 = numArr2[i6].intValue();
                long j2 = (long) ((intValue2 * 100) / i4);
                if (this.dAT) {
                    switch (i2) {
                        case 0:
                            switch (i5) {
                                case 0:
                                    c.bz(j2);
                                    break;
                                case 1:
                                    c.bA(j2);
                                    break;
                                case 2:
                                    c.bB(j2);
                                    break;
                                case 3:
                                    c.bC(j2);
                                    break;
                            }
                        case 1:
                            switch (i5) {
                                case 0:
                                    b.bz(j2);
                                    break;
                                case 1:
                                    b.bA(j2);
                                    break;
                                case 2:
                                    b.bB(j2);
                                    break;
                                case 3:
                                    b.bC(j2);
                                    break;
                            }
                    }
                }
                int i8 = (intValue2 * 100) / i4;
                if (this.dAT) {
                    switch (i2) {
                        case 0:
                            switch (i5) {
                                case 0:
                                    if (i8 != 0) {
                                        if (i8 > 20) {
                                            if (i8 > 40) {
                                                if (i8 > 60) {
                                                    if (i8 > 80) {
                                                        if (i8 == 100) {
                                                            c.abe();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        c.abd();
                                                        break;
                                                    }
                                                } else {
                                                    c.abc();
                                                    break;
                                                }
                                            } else {
                                                c.abb();
                                                break;
                                            }
                                        } else {
                                            c.aba();
                                            break;
                                        }
                                    } else {
                                        c.aaZ();
                                        continue;
                                        continue;
                                    }
                                case 1:
                                    if (i8 != 0) {
                                        if (i8 > 20) {
                                            if (i8 > 40) {
                                                if (i8 > 60) {
                                                    if (i8 > 80) {
                                                        if (i8 == 100) {
                                                            c.abk();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        c.abj();
                                                        break;
                                                    }
                                                } else {
                                                    c.abi();
                                                    break;
                                                }
                                            } else {
                                                c.abh();
                                                break;
                                            }
                                        } else {
                                            c.abg();
                                            break;
                                        }
                                    } else {
                                        c.abf();
                                        continue;
                                    }
                                case 2:
                                    if (i8 != 0) {
                                        if (i8 > 20) {
                                            if (i8 > 40) {
                                                if (i8 > 60) {
                                                    if (i8 > 80) {
                                                        if (i8 == 100) {
                                                            c.abq();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        c.abp();
                                                        break;
                                                    }
                                                } else {
                                                    c.abo();
                                                    break;
                                                }
                                            } else {
                                                c.abn();
                                                break;
                                            }
                                        } else {
                                            c.abm();
                                            break;
                                        }
                                    } else {
                                        c.abl();
                                        continue;
                                    }
                                case 3:
                                    if (i8 != 0) {
                                        if (i8 > 20) {
                                            if (i8 > 40) {
                                                if (i8 > 60) {
                                                    if (i8 > 80) {
                                                        if (i8 == 100) {
                                                            c.abw();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        c.abv();
                                                        break;
                                                    }
                                                } else {
                                                    c.abu();
                                                    break;
                                                }
                                            } else {
                                                c.abt();
                                                break;
                                            }
                                        } else {
                                            c.abs();
                                            break;
                                        }
                                    } else {
                                        c.abr();
                                        continue;
                                    }
                            }
                        case 1:
                            switch (i5) {
                                case 0:
                                    if (i8 != 0) {
                                        if (i8 > 20) {
                                            if (i8 > 40) {
                                                if (i8 > 60) {
                                                    if (i8 > 80) {
                                                        if (i8 <= 100) {
                                                            b.abe();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        b.abd();
                                                        break;
                                                    }
                                                } else {
                                                    b.abc();
                                                    break;
                                                }
                                            } else {
                                                b.abb();
                                                break;
                                            }
                                        } else {
                                            b.aba();
                                            break;
                                        }
                                    } else {
                                        b.aaZ();
                                        continue;
                                        continue;
                                    }
                                case 1:
                                    if (i8 != 0) {
                                        if (i8 > 20) {
                                            if (i8 > 40) {
                                                if (i8 > 60) {
                                                    if (i8 > 80) {
                                                        if (i8 <= 100) {
                                                            b.abk();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        b.abj();
                                                        break;
                                                    }
                                                } else {
                                                    b.abi();
                                                    break;
                                                }
                                            } else {
                                                b.abh();
                                                break;
                                            }
                                        } else {
                                            b.abg();
                                            break;
                                        }
                                    } else {
                                        b.abf();
                                        continue;
                                    }
                                case 2:
                                    if (i8 != 0) {
                                        if (i8 > 20) {
                                            if (i8 > 40) {
                                                if (i8 > 60) {
                                                    if (i8 > 80) {
                                                        if (i8 <= 100) {
                                                            b.abq();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        b.abp();
                                                        break;
                                                    }
                                                } else {
                                                    b.abo();
                                                    break;
                                                }
                                            } else {
                                                b.abn();
                                                break;
                                            }
                                        } else {
                                            b.abm();
                                            break;
                                        }
                                    } else {
                                        b.abl();
                                        continue;
                                    }
                                case 3:
                                    if (i8 != 0) {
                                        if (i8 > 20) {
                                            if (i8 > 40) {
                                                if (i8 > 60) {
                                                    if (i8 > 80) {
                                                        if (i8 <= 100) {
                                                            b.abw();
                                                            break;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        b.abv();
                                                        break;
                                                    }
                                                } else {
                                                    b.abu();
                                                    break;
                                                }
                                            } else {
                                                b.abt();
                                                break;
                                            }
                                        } else {
                                            b.abs();
                                            break;
                                        }
                                    } else {
                                        b.abr();
                                        continue;
                                    }
                            }
                    }
                }
                i6++;
                i5 = i7;
            }
            Integer[] numArr3 = new Integer[4];
            for (int i9 = 0; i9 < 4; i9++) {
                numArr3[i9] = 0;
            }
            this.dAV = numArr3;
        }
        AppMethodBeat.o(130112);
    }

    private final int aaz() {
        AppMethodBeat.i(130113);
        int i2 = 0;
        for (Integer num : this.dAU) {
            i2 += num.intValue();
        }
        AppMethodBeat.o(130113);
        return i2;
    }

    public final void ck(int i2, int i3) {
        AppMethodBeat.i(130114);
        if (!this.dAT) {
            AppMethodBeat.o(130114);
            return;
        }
        switch (i2) {
            case 0:
                if (i3 < 10) {
                    Integer[] numArr = this.dAV;
                    numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                    AppMethodBeat.o(130114);
                    return;
                } else if (i3 < 40) {
                    Integer[] numArr2 = this.dAV;
                    numArr2[1] = Integer.valueOf(numArr2[1].intValue() + 1);
                    AppMethodBeat.o(130114);
                    return;
                } else if (i3 < 80) {
                    Integer[] numArr3 = this.dAV;
                    numArr3[2] = Integer.valueOf(numArr3[2].intValue() + 1);
                    AppMethodBeat.o(130114);
                    return;
                } else if (i3 <= 100) {
                    Integer[] numArr4 = this.dAV;
                    numArr4[3] = Integer.valueOf(numArr4[3].intValue() + 1);
                    AppMethodBeat.o(130114);
                    return;
                } else {
                    AppMethodBeat.o(130114);
                    return;
                }
            case 1:
                if (i3 >= 10) {
                    if (i3 >= 40) {
                        if (i3 >= 80) {
                            if (i3 <= 100) {
                                Integer[] numArr5 = this.dAV;
                                numArr5[3] = Integer.valueOf(numArr5[3].intValue() + 1);
                                break;
                            }
                        } else {
                            Integer[] numArr6 = this.dAV;
                            numArr6[2] = Integer.valueOf(numArr6[2].intValue() + 1);
                            AppMethodBeat.o(130114);
                            return;
                        }
                    } else {
                        Integer[] numArr7 = this.dAV;
                        numArr7[1] = Integer.valueOf(numArr7[1].intValue() + 1);
                        AppMethodBeat.o(130114);
                        return;
                    }
                } else {
                    Integer[] numArr8 = this.dAV;
                    numArr8[0] = Integer.valueOf(numArr8[0].intValue() + 1);
                    AppMethodBeat.o(130114);
                    return;
                }
                break;
        }
        AppMethodBeat.o(130114);
    }

    public final void e(int i2, byte[] bArr) {
        AppMethodBeat.i(130115);
        p.h(bArr, "data");
        if (!this.dAT) {
            AppMethodBeat.o(130115);
            return;
        }
        if (i2 != 0) {
            short[] sArr = new short[(i2 / 2)];
            int length = sArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                sArr[i3] = (short) ((bArr[i3 * 2] & 255) | ((bArr[(i3 * 2) + 1] & 255) << 8));
            }
            int i4 = i2 / 2;
            double d2 = 0.0d;
            for (short s : sArr) {
                d2 += (double) (s * s);
            }
            double sqrt = Math.sqrt(d2 / ((double) i4));
            if (sqrt < 50.0d) {
                Integer[] numArr = this.dAU;
                numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                AppMethodBeat.o(130115);
                return;
            } else if (sqrt < 300.0d) {
                Integer[] numArr2 = this.dAU;
                numArr2[1] = Integer.valueOf(numArr2[1].intValue() + 1);
                AppMethodBeat.o(130115);
                return;
            } else if (sqrt < 2000.0d) {
                Integer[] numArr3 = this.dAU;
                numArr3[2] = Integer.valueOf(numArr3[2].intValue() + 1);
                AppMethodBeat.o(130115);
                return;
            } else {
                Integer[] numArr4 = this.dAU;
                numArr4[3] = Integer.valueOf(numArr4[3].intValue() + 1);
            }
        }
        AppMethodBeat.o(130115);
    }
}

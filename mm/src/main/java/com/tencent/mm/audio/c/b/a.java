package com.tencent.mm.audio.c.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0001\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0002J\u0018\u00101\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0004H\u0007J\u0018\u00103\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0004H\u0007J\u0018\u00104\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0004H\u0007J@\u00105\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0007J\u0018\u00106\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0004H\u0007J\u0010\u00107\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0010\u00108\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0010\u00109\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0010\u0010:\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J \u0010;\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020>H\u0002J \u0010?\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0004H\u0002J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0010\u0010A\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0010\u0010B\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, hxF = {"Lcom/tencent/mm/audio/utils/recorder/AudioRecordReportUtil;", "", "()V", "RMS_TYPE_HIGH", "", "RMS_TYPE_LOW", "RMS_TYPE_MIDDLE", "RMS_TYPE_SILENT", "TAG", "", "checkRecordingHasMusicPlayingHasBeenReport", "", "mRMSInOneRecordProcess", "", "[Ljava/lang/Integer;", "resultSize", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkRecordingHasMusicPlaying", "type", "checkZeroDataCauseHeadsetPlugged", "checkZeroDataCauseMicMute", "doAudioRecordHasBeenInitReport", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "mSampleRate", "mChannelConfig", "mRecordDetailState", "doAudioSourceSwitchFailedReport", "source", "doAudioSourceSwitchSuccessReport", "doAudioSourceUseErrorReport", "doAudioVolumeRecordKVReport", "doFinalAudioSourceRequstReport", "doMicroPhonesMuteReport", "doMinBufferSizeErrorReport", "doNewAudioRecordErrorReport", "doPCMRecordChecker", "doPCMRecordPercentReport", FirebaseAnalytics.b.INDEX, "result", "", "doPCMRecordResultReport", "doRecordModeNullErrorReport", "doRecordReport", "doStartRecordErrorReport", "plugin-audiosdk_release"})
public final class a {
    private static Integer[] dAZ;
    private static int dBa;
    private static boolean dBb;
    public static final a dBc = new a();

    static {
        AppMethodBeat.i(130251);
        Integer[] numArr = new Integer[4];
        for (int i2 = 0; i2 < 4; i2++) {
            numArr[i2] = 0;
        }
        dAZ = numArr;
        AppMethodBeat.o(130251);
    }

    private a() {
    }

    public static final void a(int i2, String str, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(130234);
        p.h(str, "featureKey");
        if (dBa != 0) {
            int intValue = (dAZ[0].intValue() * 100) / dBa;
            int intValue2 = (dAZ[1].intValue() * 100) / dBa;
            int intValue3 = (dAZ[2].intValue() * 100) / dBa;
            int intValue4 = (dAZ[3].intValue() * 100) / dBa;
            Log.i("MicroMsg.AudioRecordReportUtil", "audioType = 0 ,scenes = " + i2 + ",featureKey=" + str + ",pcmSilent=" + intValue + ", pcmLow=" + intValue2 + ",pcmMiddle=" + intValue3 + ",pcmHigh=" + intValue4 + ",systemSilent=0,systemLow=0,systemMiddle=0,systemHigh=0,audioSource=" + i3 + ",sampleRate=" + i4 + ",mChannelConfig=" + i5 + ",mRecordDetailState=" + i6);
            h.INSTANCE.a(18554, true, true, 0, Integer.valueOf(i2), str, Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3), Integer.valueOf(intValue4), 0, 0, 0, 0, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
            dBb = false;
        }
        AppMethodBeat.o(130234);
    }

    public static final void jp(int i2) {
        AppMethodBeat.i(130235);
        switch (i2) {
            case 0:
                c.abK();
                AppMethodBeat.o(130235);
                return;
            case 1:
                b.abK();
                break;
        }
        AppMethodBeat.o(130235);
    }

    public static final void jq(int i2) {
        AppMethodBeat.i(130236);
        switch (i2) {
            case 0:
                c.abJ();
                AppMethodBeat.o(130236);
                return;
            case 1:
                b.abJ();
                break;
        }
        AppMethodBeat.o(130236);
    }

    public static final void jr(int i2) {
        AppMethodBeat.i(130237);
        switch (i2) {
            case 0:
                c.abI();
                AppMethodBeat.o(130237);
                return;
            case 1:
                b.abI();
                break;
        }
        AppMethodBeat.o(130237);
    }

    public static final void js(int i2) {
        AppMethodBeat.i(130238);
        switch (i2) {
            case 0:
                c.abM();
                AppMethodBeat.o(130238);
                return;
            case 1:
                b.abM();
                break;
        }
        AppMethodBeat.o(130238);
    }

    public static final void jt(int i2) {
        AppMethodBeat.i(130239);
        switch (i2) {
            case 0:
                c.abN();
                AppMethodBeat.o(130239);
                return;
            case 1:
                b.abN();
                break;
        }
        AppMethodBeat.o(130239);
    }

    public static final void ju(int i2) {
        AppMethodBeat.i(130240);
        Log.i("MicroMsg.AudioRecordReportUtil", "current happened recording and music playing ");
        switch (i2) {
            case 0:
                if (!dBb) {
                    dBb = true;
                    c.abO();
                    AppMethodBeat.o(130240);
                    return;
                }
                break;
            case 1:
                if (!dBb) {
                    dBb = true;
                    b.abO();
                    break;
                }
                break;
        }
        AppMethodBeat.o(130240);
    }

    public static final void jv(int i2) {
        AppMethodBeat.i(130241);
        switch (i2) {
            case 0:
                c.abH();
                AppMethodBeat.o(130241);
                return;
            case 1:
                b.abH();
                break;
        }
        AppMethodBeat.o(130241);
    }

    public static final void jw(int i2) {
        AppMethodBeat.i(130242);
        switch (i2) {
            case 0:
                c.abG();
                AppMethodBeat.o(130242);
                return;
            case 1:
                b.abG();
                break;
        }
        AppMethodBeat.o(130242);
    }

    public static final void cl(int i2, int i3) {
        AppMethodBeat.i(130243);
        switch (i2) {
            case 0:
                switch (i3) {
                    case 1:
                        c.abD();
                        AppMethodBeat.o(130243);
                        return;
                    case 7:
                        c.abE();
                        AppMethodBeat.o(130243);
                        return;
                    default:
                        AppMethodBeat.o(130243);
                        return;
                }
            case 1:
                switch (i3) {
                    case 1:
                        b.abD();
                        AppMethodBeat.o(130243);
                        return;
                    case 7:
                        b.abE();
                        break;
                }
        }
        AppMethodBeat.o(130243);
    }

    public static final void jx(int i2) {
        AppMethodBeat.i(130244);
        switch (i2) {
            case 0:
                c.abF();
                AppMethodBeat.o(130244);
                return;
            case 1:
                b.abF();
                break;
        }
        AppMethodBeat.o(130244);
    }

    public static final void cm(int i2, int i3) {
        AppMethodBeat.i(130245);
        switch (i2) {
            case 0:
                switch (i3) {
                    case 1:
                        c.abx();
                        AppMethodBeat.o(130245);
                        return;
                    case 7:
                        c.aby();
                        AppMethodBeat.o(130245);
                        return;
                    default:
                        AppMethodBeat.o(130245);
                        return;
                }
            case 1:
                switch (i3) {
                    case 1:
                        b bVar = b.dBd;
                        b.abx();
                        AppMethodBeat.o(130245);
                        return;
                    case 7:
                        b bVar2 = b.dBd;
                        b.aby();
                        break;
                }
        }
        AppMethodBeat.o(130245);
    }

    public static final void cn(int i2, int i3) {
        AppMethodBeat.i(130246);
        switch (i2) {
            case 0:
                switch (i3) {
                    case 1:
                        c.abC();
                        AppMethodBeat.o(130246);
                        return;
                    case 7:
                        c.abA();
                        AppMethodBeat.o(130246);
                        return;
                    default:
                        AppMethodBeat.o(130246);
                        return;
                }
            case 1:
                switch (i3) {
                    case 1:
                        b.abC();
                        AppMethodBeat.o(130246);
                        return;
                    case 7:
                        b.abA();
                        break;
                }
        }
        AppMethodBeat.o(130246);
    }

    public static final void co(int i2, int i3) {
        AppMethodBeat.i(130247);
        switch (i2) {
            case 0:
                switch (i3) {
                    case 1:
                        c.abB();
                        AppMethodBeat.o(130247);
                        return;
                    case 7:
                        c.abz();
                        AppMethodBeat.o(130247);
                        return;
                    default:
                        AppMethodBeat.o(130247);
                        return;
                }
            case 1:
                switch (i3) {
                    case 1:
                        b.abB();
                        AppMethodBeat.o(130247);
                        return;
                    case 7:
                        b.abz();
                        break;
                }
        }
        AppMethodBeat.o(130247);
    }

    public static final void e(int i2, byte[] bArr) {
        AppMethodBeat.i(130248);
        p.h(bArr, "data");
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
                Integer[] numArr = dAZ;
                numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
            } else if (sqrt < 300.0d) {
                Integer[] numArr2 = dAZ;
                numArr2[1] = Integer.valueOf(numArr2[1].intValue() + 1);
            } else if (sqrt < 2000.0d) {
                Integer[] numArr3 = dAZ;
                numArr3[2] = Integer.valueOf(numArr3[2].intValue() + 1);
            } else {
                Integer[] numArr4 = dAZ;
                numArr4[3] = Integer.valueOf(numArr4[3].intValue() + 1);
            }
            dBa++;
        }
        AppMethodBeat.o(130248);
    }

    public static final void jy(int i2) {
        AppMethodBeat.i(130249);
        switch (i2) {
            case 0:
                c.abL();
                AppMethodBeat.o(130249);
                return;
            case 1:
                b.abL();
                break;
        }
        AppMethodBeat.o(130249);
    }

    public static final void jz(int i2) {
        AppMethodBeat.i(130250);
        if (dBa != 0) {
            Integer[] numArr = dAZ;
            int i3 = 0;
            int length = numArr.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = i3 + 1;
                int intValue = numArr[i4].intValue();
                long j2 = (long) ((intValue * 100) / dBa);
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
                int i6 = (intValue * 100) / dBa;
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
                i4++;
                i3 = i5;
            }
            dBa = 0;
            Integer[] numArr2 = new Integer[4];
            for (int i7 = 0; i7 < 4; i7++) {
                numArr2[i7] = 0;
            }
            dAZ = numArr2;
        }
        AppMethodBeat.o(130250);
    }
}

package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public class CMTime implements Cloneable {
    public static final CMTime CMTimeInvalid = new CMTime(Long.MIN_VALUE, 600, -1.0f, -1);
    public static final CMTime CMTimeOne = new CMTime(600, 600);
    public static final CMTime CMTimeZero = new CMTime(0, 600);
    public static final int DEFAULT_TIME_SCALE = 600;
    private static final long SECONDS_MS = 1000;
    private static final long SECONDS_US = 1000000;
    private final float time;
    public final int timeScale;
    private final long timeUs;
    public final long value;

    static {
        AppMethodBeat.i(199436);
        AppMethodBeat.o(199436);
    }

    public static CMTime fromSeconds(float f2) {
        AppMethodBeat.i(199409);
        CMTime cMTime = new CMTime(f2);
        AppMethodBeat.o(199409);
        return cMTime;
    }

    public static CMTime fromMs(long j2) {
        AppMethodBeat.i(199410);
        CMTime cMTime = new CMTime((((float) j2) * 1.0f) / 1000.0f);
        AppMethodBeat.o(199410);
        return cMTime;
    }

    public static CMTime fromUs(long j2) {
        AppMethodBeat.i(199411);
        CMTime cMTime = new CMTime((((float) j2) * 1.0f) / 1000000.0f);
        AppMethodBeat.o(199411);
        return cMTime;
    }

    public static int GCD(int i2, int i3) {
        int i4 = i2;
        while (i4 != 0) {
            int i5 = i3 % i4;
            i3 = i4;
            i4 = i5;
        }
        return i3;
    }

    public static int LCM(int i2, int i3) {
        AppMethodBeat.i(199412);
        int GCD = (i2 / GCD(i2, i3)) * i3;
        AppMethodBeat.o(199412);
        return GCD;
    }

    public static CMTime convertTimeScale(CMTime cMTime, int i2) {
        AppMethodBeat.i(199413);
        if (cMTime == CMTimeInvalid) {
            CMTime cMTime2 = CMTimeInvalid;
            AppMethodBeat.o(199413);
            return cMTime2;
        } else if (cMTime == CMTimeZero) {
            CMTime cMTime3 = new CMTime(0, i2);
            AppMethodBeat.o(199413);
            return cMTime3;
        } else {
            CMTime cMTime4 = new CMTime((cMTime.getValue() * ((long) i2)) / ((long) cMTime.getTimeScale()), i2);
            AppMethodBeat.o(199413);
            return cMTime4;
        }
    }

    public static CMTime add(CMTime cMTime, CMTime cMTime2) {
        AppMethodBeat.i(199414);
        if (cMTime == CMTimeInvalid) {
            CMTime clone = cMTime2.clone();
            AppMethodBeat.o(199414);
            return clone;
        } else if (cMTime2 == CMTimeInvalid) {
            CMTime clone2 = cMTime.clone();
            AppMethodBeat.o(199414);
            return clone2;
        } else {
            int LCM = LCM(cMTime.timeScale, cMTime2.timeScale);
            CMTime convertTimeScale = convertTimeScale(cMTime, LCM);
            CMTime convertTimeScale2 = convertTimeScale(cMTime2, LCM);
            CMTime cMTime3 = new CMTime(convertTimeScale2.getValue() + convertTimeScale.getValue(), convertTimeScale.timeScale);
            AppMethodBeat.o(199414);
            return cMTime3;
        }
    }

    public static CMTime sub(CMTime cMTime, CMTime cMTime2) {
        AppMethodBeat.i(199415);
        if (cMTime == CMTimeInvalid) {
            CMTime cMTime3 = new CMTime(-cMTime2.getValue());
            AppMethodBeat.o(199415);
            return cMTime3;
        } else if (cMTime2 == CMTimeInvalid) {
            CMTime clone = cMTime.clone();
            AppMethodBeat.o(199415);
            return clone;
        } else {
            int LCM = LCM(cMTime.timeScale, cMTime2.timeScale);
            CMTime convertTimeScale = convertTimeScale(cMTime, LCM);
            CMTime cMTime4 = new CMTime(convertTimeScale.getValue() - convertTimeScale(cMTime2, LCM).getValue(), convertTimeScale.timeScale);
            AppMethodBeat.o(199415);
            return cMTime4;
        }
    }

    public static CMTime min(CMTime cMTime, CMTime cMTime2) {
        AppMethodBeat.i(199416);
        if (cMTime.smallThan(cMTime2)) {
            AppMethodBeat.o(199416);
            return cMTime;
        }
        AppMethodBeat.o(199416);
        return cMTime2;
    }

    public static CMTime max(CMTime cMTime, CMTime cMTime2) {
        AppMethodBeat.i(199417);
        if (cMTime.bigThan(cMTime2)) {
            AppMethodBeat.o(199417);
            return cMTime;
        }
        AppMethodBeat.o(199417);
        return cMTime2;
    }

    public CMTime() {
        this(0, 600);
    }

    public CMTime(long j2) {
        this(j2, 600);
    }

    public CMTime(float f2) {
        this((long) (600.0f * f2), 600);
        AppMethodBeat.i(199418);
        AppMethodBeat.o(199418);
    }

    public CMTime(long j2, int i2) {
        AppMethodBeat.i(199419);
        this.value = j2;
        this.timeScale = i2;
        this.time = (((float) j2) * 1.0f) / ((float) i2);
        this.timeUs = (1000000 * j2) / ((long) i2);
        AppMethodBeat.o(199419);
    }

    private CMTime(long j2, int i2, float f2, long j3) {
        this.value = j2;
        this.timeUs = j3;
        this.time = f2;
        this.timeScale = i2;
    }

    public float getTimeSeconds() {
        return this.time;
    }

    public long getTimeUs() {
        return this.timeUs;
    }

    public long getValue() {
        return this.value;
    }

    public int getTimeScale() {
        return this.timeScale;
    }

    public CMTime add(long j2) {
        AppMethodBeat.i(199420);
        if (this == CMTimeInvalid) {
            CMTime clone = clone();
            AppMethodBeat.o(199420);
            return clone;
        }
        CMTime cMTime = new CMTime(getValue() + ((((long) this.timeScale) * j2) / TimeUnit.SECONDS.toMicros(1)), this.timeScale);
        AppMethodBeat.o(199420);
        return cMTime;
    }

    public CMTime add(CMTime cMTime) {
        AppMethodBeat.i(199421);
        CMTime add = add(this, cMTime);
        AppMethodBeat.o(199421);
        return add;
    }

    public CMTime sub(CMTime cMTime) {
        AppMethodBeat.i(199422);
        CMTime sub = sub(this, cMTime);
        AppMethodBeat.o(199422);
        return sub;
    }

    public CMTime multi(float f2) {
        AppMethodBeat.i(199423);
        if (this == CMTimeInvalid) {
            CMTime cMTime = CMTimeInvalid;
            AppMethodBeat.o(199423);
            return cMTime;
        }
        CMTime cMTime2 = new CMTime((long) (((float) getValue()) * f2), this.timeScale);
        AppMethodBeat.o(199423);
        return cMTime2;
    }

    public CMTime multi(CMTime cMTime) {
        AppMethodBeat.i(199424);
        int LCM = LCM(this.timeScale, cMTime.timeScale);
        CMTime cMTime2 = new CMTime(convertTimeScale(this, LCM).value * convertTimeScale(cMTime, LCM).value, LCM);
        AppMethodBeat.o(199424);
        return cMTime2;
    }

    public CMTime divide(float f2) {
        AppMethodBeat.i(199425);
        if (this == CMTimeInvalid) {
            CMTime cMTime = CMTimeInvalid;
            AppMethodBeat.o(199425);
            return cMTime;
        }
        CMTime cMTime2 = new CMTime((long) (((float) getValue()) / f2), this.timeScale);
        AppMethodBeat.o(199425);
        return cMTime2;
    }

    public CMTime divide(CMTime cMTime) {
        AppMethodBeat.i(199426);
        int LCM = LCM(this.timeScale, cMTime.timeScale);
        CMTime cMTime2 = new CMTime(convertTimeScale(this, LCM).value / convertTimeScale(cMTime, LCM).value, LCM);
        AppMethodBeat.o(199426);
        return cMTime2;
    }

    public boolean bigThan(CMTime cMTime) {
        AppMethodBeat.i(199427);
        if (getTimeUs() > cMTime.getTimeUs()) {
            AppMethodBeat.o(199427);
            return true;
        }
        AppMethodBeat.o(199427);
        return false;
    }

    public boolean smallThan(CMTime cMTime) {
        AppMethodBeat.i(199428);
        if (getTimeUs() < cMTime.getTimeUs()) {
            AppMethodBeat.o(199428);
            return true;
        }
        AppMethodBeat.o(199428);
        return false;
    }

    public boolean equalsTo(CMTime cMTime) {
        AppMethodBeat.i(199429);
        if (getTimeUs() == cMTime.getTimeUs()) {
            AppMethodBeat.o(199429);
            return true;
        }
        AppMethodBeat.o(199429);
        return false;
    }

    public int compare(CMTime cMTime) {
        AppMethodBeat.i(199430);
        long timeUs2 = getTimeUs() - cMTime.getTimeUs();
        if (timeUs2 > 0) {
            AppMethodBeat.o(199430);
            return 1;
        } else if (timeUs2 == 0) {
            AppMethodBeat.o(199430);
            return 0;
        } else {
            AppMethodBeat.o(199430);
            return -1;
        }
    }

    public CMTime limitMin(CMTime cMTime) {
        AppMethodBeat.i(199431);
        if (smallThan(cMTime)) {
            AppMethodBeat.o(199431);
            return cMTime;
        }
        AppMethodBeat.o(199431);
        return this;
    }

    public CMTime limitMax(CMTime cMTime) {
        AppMethodBeat.i(199432);
        if (bigThan(cMTime)) {
            AppMethodBeat.o(199432);
            return cMTime;
        }
        AppMethodBeat.o(199432);
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CMTime)) {
            return false;
        }
        if (this.value == ((CMTime) obj).value && this.timeScale == ((CMTime) obj).timeScale) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public CMTime clone() {
        AppMethodBeat.i(199433);
        CMTime cMTime = new CMTime(this.value, this.timeScale, this.time, this.timeUs);
        AppMethodBeat.o(199433);
        return cMTime;
    }

    public String toString() {
        AppMethodBeat.i(199434);
        String str = "[value = " + this.value + " timeScale = " + this.timeScale + " timeUs = " + this.timeUs + "]";
        AppMethodBeat.o(199434);
        return str;
    }
}

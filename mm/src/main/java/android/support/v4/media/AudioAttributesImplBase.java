package android.support.v4.media;

import java.util.Arrays;

public final class AudioAttributesImplBase implements AudioAttributesImpl {
    int FV = 0;
    int KN = 0;
    int KO = 0;
    int KP = -1;

    AudioAttributesImplBase() {
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.KO), Integer.valueOf(this.FV), Integer.valueOf(this.KN), Integer.valueOf(this.KP)});
    }

    public final boolean equals(Object obj) {
        int y;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.KO != audioAttributesImplBase.KO) {
            return false;
        }
        int i2 = this.FV;
        int i3 = audioAttributesImplBase.FV;
        if (audioAttributesImplBase.KP != -1) {
            y = audioAttributesImplBase.KP;
        } else {
            y = AudioAttributesCompat.y(audioAttributesImplBase.FV, audioAttributesImplBase.KN);
        }
        if (y == 6) {
            i3 |= 4;
        } else if (y == 7) {
            i3 |= 1;
        }
        if (i2 == (i3 & 273) && this.KN == audioAttributesImplBase.KN && this.KP == audioAttributesImplBase.KP) {
            return true;
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.KP != -1) {
            sb.append(" stream=").append(this.KP);
            sb.append(" derived");
        }
        sb.append(" usage=").append(AudioAttributesCompat.ay(this.KN)).append(" content=").append(this.KO).append(" flags=0x").append(Integer.toHexString(this.FV).toUpperCase());
        return sb.toString();
    }
}

package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
public final class AudioAttributesImplApi21 implements AudioAttributesImpl {
    AudioAttributes KL;
    int KM = -1;

    AudioAttributesImplApi21() {
    }

    public final int hashCode() {
        return this.KL.hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.KL.equals(((AudioAttributesImplApi21) obj).KL);
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.KL;
    }
}

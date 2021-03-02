package androidx.media;

import android.media.AudioAttributes;
import android.support.v4.media.AudioAttributesImplApi21;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(a aVar) {
        AppMethodBeat.i(107786);
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.mAudioAttributes = (AudioAttributes) aVar.a(audioAttributesImplApi21.mAudioAttributes, 1);
        audioAttributesImplApi21.mLegacyStreamType = aVar.aN(audioAttributesImplApi21.mLegacyStreamType, 2);
        AppMethodBeat.o(107786);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, a aVar) {
        AppMethodBeat.i(107787);
        aVar.writeParcelable(audioAttributesImplApi21.mAudioAttributes, 1);
        aVar.aM(audioAttributesImplApi21.mLegacyStreamType, 2);
        AppMethodBeat.o(107787);
    }
}

package androidx.media;

import android.support.v4.media.AudioAttributesImplBase;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(a aVar) {
        AppMethodBeat.i(107788);
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.mUsage = aVar.aN(audioAttributesImplBase.mUsage, 1);
        audioAttributesImplBase.mContentType = aVar.aN(audioAttributesImplBase.mContentType, 2);
        audioAttributesImplBase.mFlags = aVar.aN(audioAttributesImplBase.mFlags, 3);
        audioAttributesImplBase.mLegacyStream = aVar.aN(audioAttributesImplBase.mLegacyStream, 4);
        AppMethodBeat.o(107788);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, a aVar) {
        AppMethodBeat.i(107789);
        aVar.aM(audioAttributesImplBase.mUsage, 1);
        aVar.aM(audioAttributesImplBase.mContentType, 2);
        aVar.aM(audioAttributesImplBase.mFlags, 3);
        aVar.aM(audioAttributesImplBase.mLegacyStream, 4);
        AppMethodBeat.o(107789);
    }
}

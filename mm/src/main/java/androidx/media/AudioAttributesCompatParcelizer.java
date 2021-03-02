package androidx.media;

import android.support.v4.media.AudioAttributesCompat;
import android.support.v4.media.AudioAttributesImpl;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(a aVar) {
        AppMethodBeat.i(107784);
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.mImpl = (AudioAttributesImpl) aVar.d(audioAttributesCompat.mImpl);
        AppMethodBeat.o(107784);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, a aVar) {
        AppMethodBeat.i(107785);
        aVar.a(audioAttributesCompat.mImpl);
        AppMethodBeat.o(107785);
    }
}

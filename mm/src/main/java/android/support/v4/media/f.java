package android.support.v4.media;

import android.media.session.MediaSessionManager;
import android.support.v4.e.j;
import android.support.v4.media.d;

final class f extends e {

    /* access modifiers changed from: package-private */
    public static final class a implements d.b {
        final MediaSessionManager.RemoteUserInfo Mp;

        a(String str, int i2, int i3) {
            this.Mp = new MediaSessionManager.RemoteUserInfo(str, i2, i3);
        }

        public final int hashCode() {
            return j.hash(this.Mp);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            return this.Mp.equals(((a) obj).Mp);
        }
    }
}

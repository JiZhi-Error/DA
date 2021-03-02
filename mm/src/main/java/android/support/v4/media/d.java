package android.support.v4.media;

import android.os.Build;
import android.support.v4.media.f;
import android.support.v4.media.g;
import android.util.Log;

public final class d {
    static final boolean DEBUG = Log.isLoggable("MediaSessionManager", 3);
    private static final Object sLock = new Object();

    interface b {
    }

    public static final class a {
        b Mo;

        public a(String str, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.Mo = new f.a(str, i2, i3);
            } else {
                this.Mo = new g.a(str, i2, i3);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            return this.Mo.equals(((a) obj).Mo);
        }

        public final int hashCode() {
            return this.Mo.hashCode();
        }
    }
}

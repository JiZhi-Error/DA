package android.support.v4.media.session;

import android.media.session.MediaSession;

/* access modifiers changed from: package-private */
public final class d {
    public static Object A(Object obj) {
        if (obj instanceof MediaSession.Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}

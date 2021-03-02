package android.support.v4.media;

import android.media.browse.MediaBrowser;
import java.util.List;

final class a {

    /* renamed from: android.support.v4.media.a$a  reason: collision with other inner class name */
    interface AbstractC0026a {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    interface c {
        void j(List<?> list);
    }

    static class b<T extends AbstractC0026a> extends MediaBrowser.ConnectionCallback {
        protected final T Lu;

        public b(T t) {
            this.Lu = t;
        }

        public final void onConnected() {
            this.Lu.onConnected();
        }

        public final void onConnectionSuspended() {
            this.Lu.onConnectionSuspended();
        }

        public final void onConnectionFailed() {
            this.Lu.onConnectionFailed();
        }
    }

    static class d<T extends c> extends MediaBrowser.SubscriptionCallback {
        protected final T Lv;

        public d(T t) {
            this.Lv = t;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list) {
            this.Lv.j(list);
        }

        public void onError(String str) {
        }
    }
}

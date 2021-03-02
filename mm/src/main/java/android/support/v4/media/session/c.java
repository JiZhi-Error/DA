package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

final class c {

    public interface a {
        void d(int i2, int i3, int i4, int i5, int i6);

        void fb();

        void fe();

        void ff();

        void onQueueChanged(List<?> list);

        void onSessionDestroyed();

        void x(Object obj);

        void y(Object obj);
    }

    static class b<T extends a> extends MediaController.Callback {
        protected final T MR;

        public b(T t) {
            this.MR = t;
        }

        public final void onSessionDestroyed() {
            this.MR.onSessionDestroyed();
        }

        public final void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.d(bundle);
            this.MR.fb();
        }

        public final void onPlaybackStateChanged(PlaybackState playbackState) {
            this.MR.x(playbackState);
        }

        public final void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.MR.y(mediaMetadata);
        }

        @Override // android.media.session.MediaController.Callback
        public final void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.MR.onQueueChanged(list);
        }

        public final void onQueueTitleChanged(CharSequence charSequence) {
            this.MR.fe();
        }

        public final void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.d(bundle);
            this.MR.ff();
        }

        public final void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            int i2;
            T t = this.MR;
            int playbackType = playbackInfo.getPlaybackType();
            AudioAttributes audioAttributes = playbackInfo.getAudioAttributes();
            if ((audioAttributes.getFlags() & 1) != 1) {
                if ((audioAttributes.getFlags() & 4) != 4) {
                    switch (audioAttributes.getUsage()) {
                        case 1:
                        case 11:
                        case 12:
                        case 14:
                            i2 = 3;
                            break;
                        case 2:
                            i2 = 0;
                            break;
                        case 3:
                            i2 = 8;
                            break;
                        case 4:
                            i2 = 4;
                            break;
                        case 5:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            i2 = 5;
                            break;
                        case 6:
                            i2 = 2;
                            break;
                        case 13:
                            i2 = 1;
                            break;
                        default:
                            i2 = 3;
                            break;
                    }
                } else {
                    i2 = 6;
                }
            } else {
                i2 = 7;
            }
            t.d(playbackType, i2, playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }
}

package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class MediaControllerCompat {
    final b Mw;
    private final MediaSessionCompat.Token Mx;
    private final HashSet<a> My = new HashSet<>();

    interface b {
        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.Mx = token;
        if (Build.VERSION.SDK_INT >= 24) {
            this.Mw = new d(context, token);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.Mw = new c(context, token);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.Mw = new MediaControllerImplApi21(context, token);
        } else {
            this.Mw = new e(token);
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {
        HandlerC0028a MA;
        a MC;
        final Object Mz;

        public a() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.Mz = new c.b(new b(this));
                return;
            }
            c cVar = new c(this);
            this.MC = cVar;
            this.Mz = cVar;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, Object obj, Bundle bundle) {
            if (this.MA != null) {
                Message obtainMessage = this.MA.obtainMessage(i2, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        static class b implements c.a {
            private final WeakReference<a> MF;

            b(a aVar) {
                this.MF = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.c.a
            public final void onSessionDestroyed() {
                this.MF.get();
            }

            @Override // android.support.v4.media.session.c.a
            public final void fb() {
                a aVar = this.MF.get();
                if (aVar != null && aVar.MC != null) {
                    int i2 = Build.VERSION.SDK_INT;
                }
            }

            @Override // android.support.v4.media.session.c.a
            public final void x(Object obj) {
                a aVar = this.MF.get();
                if (aVar != null && aVar.MC == null) {
                    PlaybackStateCompat.B(obj);
                }
            }

            @Override // android.support.v4.media.session.c.a
            public final void y(Object obj) {
                if (this.MF.get() != null) {
                    MediaMetadataCompat.w(obj);
                }
            }

            @Override // android.support.v4.media.session.c.a
            public final void onQueueChanged(List<?> list) {
                if (this.MF.get() != null) {
                    MediaSessionCompat.QueueItem.l(list);
                }
            }

            @Override // android.support.v4.media.session.c.a
            public final void fe() {
                this.MF.get();
            }

            @Override // android.support.v4.media.session.c.a
            public final void ff() {
                this.MF.get();
            }

            @Override // android.support.v4.media.session.c.a
            public final void d(int i2, int i3, int i4, int i5, int i6) {
                if (this.MF.get() != null) {
                    new f(i2, i3, i4, i5, i6);
                }
            }
        }

        static class c extends a.AbstractBinderC0029a {
            private final WeakReference<a> MF;

            c(a aVar) {
                this.MF = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.a
            public final void d(String str, Bundle bundle) {
                a aVar = this.MF.get();
                if (aVar != null) {
                    aVar.a(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.a
            public void onSessionDestroyed() {
                a aVar = this.MF.get();
                if (aVar != null) {
                    aVar.a(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public final void a(PlaybackStateCompat playbackStateCompat) {
                a aVar = this.MF.get();
                if (aVar != null) {
                    aVar.a(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(MediaMetadataCompat mediaMetadataCompat) {
                a aVar = this.MF.get();
                if (aVar != null) {
                    aVar.a(3, mediaMetadataCompat, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
                a aVar = this.MF.get();
                if (aVar != null) {
                    aVar.a(5, list, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void onQueueTitleChanged(CharSequence charSequence) {
                a aVar = this.MF.get();
                if (aVar != null) {
                    aVar.a(6, charSequence, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public final void G(boolean z) {
                a aVar = this.MF.get();
                if (aVar != null) {
                    aVar.a(11, Boolean.valueOf(z), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public final void aA(int i2) {
                a aVar = this.MF.get();
                if (aVar != null) {
                    aVar.a(9, Integer.valueOf(i2), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public final void F(boolean z) {
            }

            @Override // android.support.v4.media.session.a
            public final void aB(int i2) {
                a aVar = this.MF.get();
                if (aVar != null) {
                    aVar.a(12, Integer.valueOf(i2), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void onExtrasChanged(Bundle bundle) {
                a aVar = this.MF.get();
                if (aVar != null) {
                    aVar.a(7, bundle, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                f fVar;
                a aVar = this.MF.get();
                if (aVar != null) {
                    if (parcelableVolumeInfo != null) {
                        fVar = new f(parcelableVolumeInfo.MY, parcelableVolumeInfo.MZ, parcelableVolumeInfo.Na, parcelableVolumeInfo.Nb, parcelableVolumeInfo.Nc);
                    } else {
                        fVar = null;
                    }
                    aVar.a(4, fVar, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public final void eR() {
                a aVar = this.MF.get();
                if (aVar != null) {
                    aVar.a(13, null, null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a  reason: collision with other inner class name */
        public class HandlerC0028a extends Handler {
            boolean MD;

            public final void handleMessage(Message message) {
                if (this.MD) {
                    switch (message.what) {
                        case 1:
                            MediaSessionCompat.d(message.getData());
                            Object obj = message.obj;
                            return;
                        case 2:
                            Object obj2 = message.obj;
                            return;
                        case 3:
                            Object obj3 = message.obj;
                            return;
                        case 4:
                            Object obj4 = message.obj;
                            return;
                        case 5:
                            Object obj5 = message.obj;
                            return;
                        case 6:
                            Object obj6 = message.obj;
                            return;
                        case 7:
                            MediaSessionCompat.d((Bundle) message.obj);
                            return;
                        case 8:
                        case 10:
                        default:
                            return;
                        case 9:
                            ((Integer) message.obj).intValue();
                            return;
                        case 11:
                            ((Boolean) message.obj).booleanValue();
                            return;
                        case 12:
                            ((Integer) message.obj).intValue();
                            return;
                    }
                }
            }
        }
    }

    public static final class f {
        private final int MM;
        private final int MN;
        private final int MO;
        private final int MP;
        private final int MQ;

        f(int i2, int i3, int i4, int i5, int i6) {
            this.MM = i2;
            this.MN = i3;
            this.MO = i4;
            this.MP = i5;
            this.MQ = i6;
        }
    }

    static class e implements b {
        private b ML;

        public e(MediaSessionCompat.Token token) {
            this.ML = b.a.d((IBinder) token.MV);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public final boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.ML.a(keyEvent);
                return false;
            } catch (RemoteException e2) {
                return false;
            }
        }
    }

    static class MediaControllerImplApi21 implements b {
        protected final Object MG;
        final List<a> MH = new ArrayList();
        HashMap<a, a> MI = new HashMap<>();
        final MediaSessionCompat.Token MJ;
        final Object mLock = new Object();

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.MJ = token;
            this.MG = new MediaController(context, (MediaSession.Token) this.MJ.MV);
            if (this.MG == null) {
                throw new RemoteException();
            } else if (this.MJ.MW == null) {
                ((MediaController) this.MG).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public final boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return ((MediaController) this.MG).dispatchMediaButtonEvent(keyEvent);
        }

        static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> MK;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.MK = new WeakReference<>(mediaControllerImplApi21);
            }

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i2, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.MK.get();
                if (!(mediaControllerImplApi21 == null || bundle == null)) {
                    synchronized (mediaControllerImplApi21.mLock) {
                        mediaControllerImplApi21.MJ.MW = b.a.d(android.support.v4.app.c.b(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                        mediaControllerImplApi21.MJ.MX = bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
                        if (mediaControllerImplApi21.MJ.MW != null) {
                            for (a aVar : mediaControllerImplApi21.MH) {
                                a aVar2 = new a(aVar);
                                mediaControllerImplApi21.MI.put(aVar, aVar2);
                                aVar.MC = aVar2;
                                try {
                                    mediaControllerImplApi21.MJ.MW.a(aVar2);
                                    aVar.a(13, null, null);
                                } catch (RemoteException e2) {
                                }
                            }
                            mediaControllerImplApi21.MH.clear();
                        }
                    }
                }
            }
        }

        static class a extends a.c {
            a(a aVar) {
                super(aVar);
            }

            @Override // android.support.v4.media.session.a, android.support.v4.media.session.MediaControllerCompat.a.c
            public final void onSessionDestroyed() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a, android.support.v4.media.session.MediaControllerCompat.a.c
            public final void a(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a, android.support.v4.media.session.MediaControllerCompat.a.c
            public final void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a, android.support.v4.media.session.MediaControllerCompat.a.c
            public final void onQueueTitleChanged(CharSequence charSequence) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a, android.support.v4.media.session.MediaControllerCompat.a.c
            public final void onExtrasChanged(Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a, android.support.v4.media.session.MediaControllerCompat.a.c
            public final void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        }
    }

    static class c extends MediaControllerImplApi21 {
        public c(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    static class d extends c {
        public d(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }
}

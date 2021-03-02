package android.support.v4.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.e.k;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.d;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
    final android.support.v4.e.a<IBinder, b> Lw = new android.support.v4.e.a<>();
    b Lx;
    final g Ly = new g();
    MediaSessionCompat.Token Lz;

    public static final class a {
        final String Lj;
        final Bundle mExtras;
    }

    interface e {
        void a(String str, MediaSessionCompat.Token token, Bundle bundle);

        void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2);

        IBinder asBinder();

        void eQ();
    }

    public abstract a eM();

    final class g extends Handler {
        private final d Mb = new d();

        g() {
        }

        public final void handleMessage(Message message) {
            boolean z = false;
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.d(bundle);
                    d dVar = this.Mb;
                    String string = data.getString("data_package_name");
                    int i2 = data.getInt("data_calling_pid");
                    int i3 = data.getInt("data_calling_uid");
                    f fVar = new f(message.replyTo);
                    MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                    if (string != null) {
                        String[] packagesForUid = mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i3);
                        int length = packagesForUid.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 < length) {
                                if (packagesForUid[i4].equals(string)) {
                                    z = true;
                                } else {
                                    i4++;
                                }
                            }
                        }
                    }
                    if (!z) {
                        throw new IllegalArgumentException("Package/uid mismatch: uid=" + i3 + " package=" + string);
                    }
                    MediaBrowserServiceCompat.this.Ly.f(new Runnable(fVar, string, i2, i3, bundle) {
                        /* class android.support.v4.media.MediaBrowserServiceCompat.d.AnonymousClass1 */
                        final /* synthetic */ e LR;
                        final /* synthetic */ String LS;
                        final /* synthetic */ int LT;
                        final /* synthetic */ int LU;
                        final /* synthetic */ Bundle LV;

                        {
                            this.LR = r2;
                            this.LS = r3;
                            this.LT = r4;
                            this.LU = r5;
                            this.LV = r6;
                        }

                        public final void run() {
                            IBinder asBinder = this.LR.asBinder();
                            MediaBrowserServiceCompat.this.Lw.remove(asBinder);
                            b bVar = new b(this.LS, this.LT, this.LU, this.LV, this.LR);
                            MediaBrowserServiceCompat.this.Lx = bVar;
                            bVar.LL = MediaBrowserServiceCompat.this.eM();
                            MediaBrowserServiceCompat.this.Lx = null;
                            if (bVar.LL == null) {
                                new StringBuilder("No root for client ").append(this.LS).append(" from service ").append(getClass().getName());
                                try {
                                    this.LR.eQ();
                                } catch (RemoteException e2) {
                                    new StringBuilder("Calling onConnectFailed() failed. Ignoring. pkg=").append(this.LS);
                                }
                            } else {
                                try {
                                    MediaBrowserServiceCompat.this.Lw.put(asBinder, bVar);
                                    asBinder.linkToDeath(bVar, 0);
                                    if (MediaBrowserServiceCompat.this.Lz != null) {
                                        this.LR.a(bVar.LL.Lj, MediaBrowserServiceCompat.this.Lz, bVar.LL.mExtras);
                                    }
                                } catch (RemoteException e3) {
                                    new StringBuilder("Calling onConnect() failed. Dropping client. pkg=").append(this.LS);
                                    MediaBrowserServiceCompat.this.Lw.remove(asBinder);
                                }
                            }
                        }
                    });
                    return;
                case 2:
                    d dVar2 = this.Mb;
                    MediaBrowserServiceCompat.this.Ly.f(new Runnable(new f(message.replyTo)) {
                        /* class android.support.v4.media.MediaBrowserServiceCompat.d.AnonymousClass2 */
                        final /* synthetic */ e LR;

                        {
                            this.LR = r2;
                        }

                        public final void run() {
                            b remove = MediaBrowserServiceCompat.this.Lw.remove(this.LR.asBinder());
                            if (remove != null) {
                                remove.LJ.asBinder().unlinkToDeath(remove, 0);
                            }
                        }
                    });
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.d(bundle2);
                    d dVar3 = this.Mb;
                    MediaBrowserServiceCompat.this.Ly.f(new Runnable(new f(message.replyTo), data.getString("data_media_item_id"), android.support.v4.app.c.b(data, "data_callback_token"), bundle2) {
                        /* class android.support.v4.media.MediaBrowserServiceCompat.d.AnonymousClass3 */
                        final /* synthetic */ e LR;
                        final /* synthetic */ IBinder LX;
                        final /* synthetic */ String val$id;
                        final /* synthetic */ Bundle val$options;

                        {
                            this.LR = r2;
                            this.val$id = r3;
                            this.LX = r4;
                            this.val$options = r5;
                        }

                        public final void run() {
                            b bVar = MediaBrowserServiceCompat.this.Lw.get(this.LR.asBinder());
                            if (bVar == null) {
                                new StringBuilder("addSubscription for callback that isn't registered id=").append(this.val$id);
                            } else {
                                MediaBrowserServiceCompat.this.a(this.val$id, bVar, this.LX, this.val$options);
                            }
                        }
                    });
                    return;
                case 4:
                    d dVar4 = this.Mb;
                    MediaBrowserServiceCompat.this.Ly.f(new Runnable(new f(message.replyTo), data.getString("data_media_item_id"), android.support.v4.app.c.b(data, "data_callback_token")) {
                        /* class android.support.v4.media.MediaBrowserServiceCompat.d.AnonymousClass4 */
                        final /* synthetic */ e LR;
                        final /* synthetic */ IBinder LX;
                        final /* synthetic */ String val$id;

                        {
                            this.LR = r2;
                            this.val$id = r3;
                            this.LX = r4;
                        }

                        public final void run() {
                            b bVar = MediaBrowserServiceCompat.this.Lw.get(this.LR.asBinder());
                            if (bVar == null) {
                                new StringBuilder("removeSubscription for callback that isn't registered id=").append(this.val$id);
                            } else if (!MediaBrowserServiceCompat.this.a(this.val$id, bVar, this.LX)) {
                                new StringBuilder("removeSubscription called for ").append(this.val$id).append(" which is not subscribed");
                            }
                        }
                    });
                    return;
                case 5:
                    d dVar5 = this.Mb;
                    String string2 = data.getString("data_media_item_id");
                    ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    f fVar2 = new f(message.replyTo);
                    if (!TextUtils.isEmpty(string2) && resultReceiver != null) {
                        MediaBrowserServiceCompat.this.Ly.f(new Runnable(fVar2, string2, resultReceiver) {
                            /* class android.support.v4.media.MediaBrowserServiceCompat.d.AnonymousClass5 */
                            final /* synthetic */ ResultReceiver LF;
                            final /* synthetic */ e LR;
                            final /* synthetic */ String LY;

                            {
                                this.LR = r2;
                                this.LY = r3;
                                this.LF = r4;
                            }

                            public final void run() {
                                b bVar = MediaBrowserServiceCompat.this.Lw.get(this.LR.asBinder());
                                if (bVar == null) {
                                    new StringBuilder("getMediaItem for callback that isn't registered id=").append(this.LY);
                                    return;
                                }
                                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                                String str = this.LY;
                                AnonymousClass2 r4 = new c<MediaBrowserCompat.MediaItem>(str, this.LF) {
                                    /* class android.support.v4.media.MediaBrowserServiceCompat.AnonymousClass2 */
                                    final /* synthetic */ ResultReceiver LF;

                                    {
                                        this.LF = r3;
                                    }

                                    /* access modifiers changed from: package-private */
                                    @Override // android.support.v4.media.MediaBrowserServiceCompat.c
                                    public final /* synthetic */ void eN() {
                                        if ((this.FV & 2) != 0) {
                                            this.LF.send(-1, null);
                                            return;
                                        }
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("media_item", null);
                                        this.LF.send(0, bundle);
                                    }
                                };
                                mediaBrowserServiceCompat.Lx = bVar;
                                r4.FV = 2;
                                r4.eP();
                                mediaBrowserServiceCompat.Lx = null;
                                if (!r4.isDone()) {
                                    throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=".concat(String.valueOf(str)));
                                }
                            }
                        });
                        return;
                    }
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.d(bundle3);
                    d dVar6 = this.Mb;
                    MediaBrowserServiceCompat.this.Ly.f(new Runnable(new f(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3) {
                        /* class android.support.v4.media.MediaBrowserServiceCompat.d.AnonymousClass6 */
                        final /* synthetic */ e LR;
                        final /* synthetic */ String LS;
                        final /* synthetic */ int LT;
                        final /* synthetic */ int LU;
                        final /* synthetic */ Bundle LV;

                        {
                            this.LR = r2;
                            this.LS = r3;
                            this.LT = r4;
                            this.LU = r5;
                            this.LV = r6;
                        }

                        public final void run() {
                            IBinder asBinder = this.LR.asBinder();
                            MediaBrowserServiceCompat.this.Lw.remove(asBinder);
                            b bVar = new b(this.LS, this.LT, this.LU, this.LV, this.LR);
                            MediaBrowserServiceCompat.this.Lw.put(asBinder, bVar);
                            try {
                                asBinder.linkToDeath(bVar, 0);
                            } catch (RemoteException e2) {
                            }
                        }
                    });
                    return;
                case 7:
                    d dVar7 = this.Mb;
                    MediaBrowserServiceCompat.this.Ly.f(new Runnable(new f(message.replyTo)) {
                        /* class android.support.v4.media.MediaBrowserServiceCompat.d.AnonymousClass7 */
                        final /* synthetic */ e LR;

                        {
                            this.LR = r2;
                        }

                        public final void run() {
                            IBinder asBinder = this.LR.asBinder();
                            b remove = MediaBrowserServiceCompat.this.Lw.remove(asBinder);
                            if (remove != null) {
                                asBinder.unlinkToDeath(remove, 0);
                            }
                        }
                    });
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.d(bundle4);
                    d dVar8 = this.Mb;
                    String string3 = data.getString("data_search_query");
                    ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    f fVar3 = new f(message.replyTo);
                    if (!TextUtils.isEmpty(string3) && resultReceiver2 != null) {
                        MediaBrowserServiceCompat.this.Ly.f(new Runnable(fVar3, string3, bundle4, resultReceiver2) {
                            /* class android.support.v4.media.MediaBrowserServiceCompat.d.AnonymousClass8 */
                            final /* synthetic */ ResultReceiver LF;
                            final /* synthetic */ e LR;
                            final /* synthetic */ String LZ;
                            final /* synthetic */ Bundle val$extras;

                            {
                                this.LR = r2;
                                this.LZ = r3;
                                this.val$extras = r4;
                                this.LF = r5;
                            }

                            public final void run() {
                                b bVar = MediaBrowserServiceCompat.this.Lw.get(this.LR.asBinder());
                                if (bVar == null) {
                                    new StringBuilder("search for callback that isn't registered query=").append(this.LZ);
                                    return;
                                }
                                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                                String str = this.LZ;
                                AnonymousClass3 r4 = new c<List<MediaBrowserCompat.MediaItem>>(str, this.LF) {
                                    /* class android.support.v4.media.MediaBrowserServiceCompat.AnonymousClass3 */
                                    final /* synthetic */ ResultReceiver LF;

                                    {
                                        this.LF = r3;
                                    }

                                    /* access modifiers changed from: package-private */
                                    @Override // android.support.v4.media.MediaBrowserServiceCompat.c
                                    public final /* synthetic */ void eN() {
                                        this.LF.send(-1, null);
                                    }
                                };
                                mediaBrowserServiceCompat.Lx = bVar;
                                r4.FV = 4;
                                r4.eP();
                                mediaBrowserServiceCompat.Lx = null;
                                if (!r4.isDone()) {
                                    throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=".concat(String.valueOf(str)));
                                }
                            }
                        });
                        return;
                    }
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.d(bundle5);
                    d dVar9 = this.Mb;
                    String string4 = data.getString("data_custom_action");
                    ResultReceiver resultReceiver3 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    f fVar4 = new f(message.replyTo);
                    if (!TextUtils.isEmpty(string4) && resultReceiver3 != null) {
                        MediaBrowserServiceCompat.this.Ly.f(new Runnable(fVar4, string4, bundle5, resultReceiver3) {
                            /* class android.support.v4.media.MediaBrowserServiceCompat.d.AnonymousClass9 */
                            final /* synthetic */ ResultReceiver LF;
                            final /* synthetic */ e LR;
                            final /* synthetic */ String val$action;
                            final /* synthetic */ Bundle val$extras;

                            {
                                this.LR = r2;
                                this.val$action = r3;
                                this.val$extras = r4;
                                this.LF = r5;
                            }

                            public final void run() {
                                b bVar = MediaBrowserServiceCompat.this.Lw.get(this.LR.asBinder());
                                if (bVar == null) {
                                    new StringBuilder("sendCustomAction for callback that isn't registered action=").append(this.val$action).append(", extras=").append(this.val$extras);
                                    return;
                                }
                                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                                String str = this.val$action;
                                Bundle bundle = this.val$extras;
                                AnonymousClass4 r5 = new c<Bundle>(str, this.LF) {
                                    /* class android.support.v4.media.MediaBrowserServiceCompat.AnonymousClass4 */
                                    final /* synthetic */ ResultReceiver LF;

                                    {
                                        this.LF = r3;
                                    }

                                    /* access modifiers changed from: package-private */
                                    @Override // android.support.v4.media.MediaBrowserServiceCompat.c
                                    public final void eO() {
                                        this.LF.send(-1, null);
                                    }

                                    /* access modifiers changed from: package-private */
                                    @Override // android.support.v4.media.MediaBrowserServiceCompat.c
                                    public final /* synthetic */ void eN() {
                                        this.LF.send(0, null);
                                    }
                                };
                                mediaBrowserServiceCompat.Lx = bVar;
                                if (r5.LP || r5.LQ) {
                                    throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + r5.LN);
                                }
                                r5.LQ = true;
                                r5.eO();
                                mediaBrowserServiceCompat.Lx = null;
                                if (!r5.isDone()) {
                                    throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
                                }
                            }
                        });
                        return;
                    }
                    return;
                default:
                    new StringBuilder("Unhandled message: ").append(message).append("\n  Service version: 2\n  Client version: ").append(message.arg1);
                    return;
            }
        }

        public final boolean sendMessageAtTime(Message message, long j2) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j2);
        }

        private void f(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements IBinder.DeathRecipient {
        public final String LG;
        public final d.a LH;
        public final Bundle LI;
        public final e LJ;
        public final HashMap<String, List<k<IBinder, Bundle>>> LK = new HashMap<>();
        public a LL;
        public final int pid;
        public final int uid;

        b(String str, int i2, int i3, Bundle bundle, e eVar) {
            this.LG = str;
            this.pid = i2;
            this.uid = i3;
            this.LH = new d.a(str, i2, i3);
            this.LI = bundle;
            this.LJ = eVar;
        }

        public final void binderDied() {
            MediaBrowserServiceCompat.this.Ly.post(new Runnable() {
                /* class android.support.v4.media.MediaBrowserServiceCompat.b.AnonymousClass1 */

                public final void run() {
                    MediaBrowserServiceCompat.this.Lw.remove(b.this.LJ.asBinder());
                }
            });
        }
    }

    public static class c<T> {
        int FV;
        final Object LN;
        private boolean LO;
        boolean LP;
        boolean LQ;

        c(Object obj) {
            this.LN = obj;
        }

        public final void eP() {
            if (this.LP || this.LQ) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.LN);
            }
            this.LP = true;
            eN();
        }

        /* access modifiers changed from: package-private */
        public final boolean isDone() {
            return this.LO || this.LP || this.LQ;
        }

        /* access modifiers changed from: package-private */
        public void eN() {
        }

        /* access modifiers changed from: package-private */
        public void eO() {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.LN);
        }
    }

    class d {
        d() {
        }
    }

    static class f implements e {
        final Messenger Ma;

        f(Messenger messenger) {
            this.Ma = messenger;
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.e
        public final IBinder asBinder() {
            return this.Ma.getBinder();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.e
        public final void a(String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            c(1, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.e
        public final void eQ() {
            c(2, null);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.e
        public final void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            c(3, bundle3);
        }

        private void c(int i2, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.Ma.send(obtain);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(final String str, final b bVar, IBinder iBinder, final Bundle bundle) {
        ArrayList arrayList;
        List<k<IBinder, Bundle>> list = bVar.LK.get(str);
        if (list == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        for (k<IBinder, Bundle> kVar : arrayList) {
            if (iBinder == kVar.first && c.a(bundle, kVar.second)) {
                return;
            }
        }
        arrayList.add(new k<>(iBinder, bundle));
        bVar.LK.put(str, arrayList);
        AnonymousClass1 r0 = new c<List<MediaBrowserCompat.MediaItem>>(str) {
            /* class android.support.v4.media.MediaBrowserServiceCompat.AnonymousClass1 */
            final /* synthetic */ Bundle LD = null;

            /* access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.c
            public final /* synthetic */ void eN() {
                List<MediaBrowserCompat.MediaItem> list = null;
                if (MediaBrowserServiceCompat.this.Lw.get(bVar.LJ.asBinder()) == bVar) {
                    if ((this.FV & 1) != 0) {
                        list = MediaBrowserServiceCompat.a(null, bundle);
                    }
                    try {
                        bVar.LJ.a(str, list, bundle, this.LD);
                    } catch (RemoteException e2) {
                        new StringBuilder("Calling onLoadChildren() failed for id=").append(str).append(" package=").append(bVar.LG);
                    }
                } else if (MediaBrowserServiceCompat.DEBUG) {
                    new StringBuilder("Not sending onLoadChildren result for connection that has been disconnected. pkg=").append(bVar.LG).append(" id=").append(str);
                }
            }
        };
        this.Lx = bVar;
        if (bundle != null) {
            r0.FV = 1;
        }
        this.Lx = null;
        if (!r0.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + bVar.LG + " id=" + str);
        }
        this.Lx = bVar;
        this.Lx = null;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str, b bVar, IBinder iBinder) {
        boolean z;
        boolean z2 = false;
        if (iBinder == null) {
            try {
                if (bVar.LK.remove(str) != null) {
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.Lx = bVar;
                this.Lx = null;
            }
        } else {
            List<k<IBinder, Bundle>> list = bVar.LK.get(str);
            if (list != null) {
                Iterator<k<IBinder, Bundle>> it = list.iterator();
                boolean z3 = false;
                while (it.hasNext()) {
                    if (iBinder == it.next().first) {
                        it.remove();
                        z3 = true;
                    }
                }
                if (list.size() == 0) {
                    bVar.LK.remove(str);
                }
                z2 = z3;
            }
            this.Lx = bVar;
            this.Lx = null;
            return z2;
        }
    }

    static List<MediaBrowserCompat.MediaItem> a(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        return null;
    }
}

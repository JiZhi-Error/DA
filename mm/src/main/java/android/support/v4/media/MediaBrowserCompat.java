package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class MediaBrowserCompat {
    static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
    public final d KQ;

    public static abstract class c {
    }

    public interface d {
        void connect();

        void disconnect();

        MediaSessionCompat.Token eK();
    }

    interface i {
        void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void a(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void b(Messenger messenger);
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.KQ = new g(context, componentName, bVar);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.KQ = new f(context, componentName, bVar, null);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.KQ = new e(context, componentName, bVar, null);
        } else {
            this.KQ = new h(context, componentName, bVar);
        }
    }

    public final void disconnect() {
        this.KQ.disconnect();
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            /* class android.support.v4.media.MediaBrowserCompat.MediaItem.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MediaItem[] newArray(int i2) {
                return new MediaItem[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }
        };
        private final int FV;
        private final MediaDescriptionCompat Ln;

        public static List<MediaItem> i(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object obj : list) {
                arrayList.add((obj == null || Build.VERSION.SDK_INT < 21) ? null : new MediaItem(MediaDescriptionCompat.v(((MediaBrowser.MediaItem) obj).getDescription()), ((MediaBrowser.MediaItem) obj).getFlags()));
            }
            return arrayList;
        }

        private MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (TextUtils.isEmpty(mediaDescriptionCompat.Mc)) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            } else {
                this.FV = i2;
                this.Ln = mediaDescriptionCompat;
            }
        }

        MediaItem(Parcel parcel) {
            this.FV = parcel.readInt();
            this.Ln = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.FV);
            this.Ln.writeToParcel(parcel, i2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=").append(this.FV);
            sb.append(", mDescription=").append(this.Ln);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class b {
        final Object KT;
        a KU;

        interface a {
            void onConnected();

            void onConnectionSuspended();
        }

        public b() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.KT = new a.b(new C0025b());
            } else {
                this.KT = null;
            }
        }

        public void onConnected() {
        }

        public void onConnectionSuspended() {
        }

        public void onConnectionFailed() {
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$b$b  reason: collision with other inner class name */
        class C0025b implements a.AbstractC0026a {
            C0025b() {
            }

            @Override // android.support.v4.media.a.AbstractC0026a
            public final void onConnected() {
                if (b.this.KU != null) {
                    b.this.KU.onConnected();
                }
                b.this.onConnected();
            }

            @Override // android.support.v4.media.a.AbstractC0026a
            public final void onConnectionSuspended() {
                if (b.this.KU != null) {
                    b.this.KU.onConnectionSuspended();
                }
                b.this.onConnectionSuspended();
            }

            @Override // android.support.v4.media.a.AbstractC0026a
            public final void onConnectionFailed() {
                b.this.onConnectionFailed();
            }
        }
    }

    public static abstract class l {
        final IBinder En = new Binder();
        final Object Lr;
        WeakReference<k> Ls;

        public l() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.Lr = new b.C0027b(new b());
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.Lr = new a.d(new a());
            } else {
                this.Lr = null;
            }
        }

        class a implements a.c {
            a() {
            }

            @Override // android.support.v4.media.a.c
            public final void j(List<?> list) {
                k kVar = l.this.Ls == null ? null : l.this.Ls.get();
                if (kVar == null) {
                    MediaItem.i(list);
                    return;
                }
                List<MediaItem> i2 = MediaItem.i(list);
                List<l> list2 = kVar.Lp;
                List<Bundle> list3 = kVar.Lq;
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    Bundle bundle = list3.get(i3);
                    if (!(bundle == null || i2 == null)) {
                        int i4 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                        int i5 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                        if (i4 != -1 || i5 != -1) {
                            int i6 = i5 * i4;
                            int i7 = i6 + i5;
                            if (i4 < 0 || i5 <= 0 || i6 >= i2.size()) {
                                Collections.emptyList();
                            } else {
                                if (i7 > i2.size()) {
                                    i7 = i2.size();
                                }
                                i2.subList(i6, i7);
                            }
                        }
                    }
                }
            }
        }

        class b extends a implements b.a {
            b() {
                super();
            }

            @Override // android.support.v4.media.b.a
            public final void k(List<?> list) {
                MediaItem.i(list);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class h implements d, i {
        final Bundle KY;
        final a KZ = new a(this);
        private final android.support.v4.e.a<String, k> La = new android.support.v4.e.a<>();
        j Lc;
        Messenger Ld;
        private MediaSessionCompat.Token Le;
        private Bundle Lf;
        final ComponentName Lg;
        final b Lh;
        a Li;
        private String Lj;
        final Context mContext;
        private Bundle mExtras;
        int mState = 1;

        public h(Context context, ComponentName componentName, b bVar) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (bVar == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            } else {
                this.mContext = context;
                this.Lg = componentName;
                this.Lh = bVar;
                this.KY = null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.d
        public final void connect() {
            if (this.mState == 0 || this.mState == 1) {
                this.mState = 2;
                this.KZ.post(new Runnable() {
                    /* class android.support.v4.media.MediaBrowserCompat.h.AnonymousClass1 */

                    public final void run() {
                        if (h.this.mState != 0) {
                            h.this.mState = 2;
                            if (MediaBrowserCompat.DEBUG && h.this.Li != null) {
                                throw new RuntimeException("mServiceConnection should be null. Instead it is " + h.this.Li);
                            } else if (h.this.Lc != null) {
                                throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + h.this.Lc);
                            } else if (h.this.Ld != null) {
                                throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + h.this.Ld);
                            } else {
                                Intent intent = new Intent("android.media.browse.MediaBrowserService");
                                intent.setComponent(h.this.Lg);
                                h.this.Li = new a();
                                boolean z = false;
                                try {
                                    z = h.this.mContext.bindService(intent, h.this.Li, 1);
                                } catch (Exception e2) {
                                    new StringBuilder("Failed binding to service ").append(h.this.Lg);
                                }
                                if (!z) {
                                    h.this.eL();
                                    h.this.Lh.onConnectionFailed();
                                }
                                if (MediaBrowserCompat.DEBUG) {
                                    h.this.dump();
                                }
                            }
                        }
                    }
                });
                return;
            }
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + az(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.d
        public final void disconnect() {
            this.mState = 0;
            this.KZ.post(new Runnable() {
                /* class android.support.v4.media.MediaBrowserCompat.h.AnonymousClass2 */

                public final void run() {
                    if (h.this.Ld != null) {
                        try {
                            h.this.Lc.a(2, null, h.this.Ld);
                        } catch (RemoteException e2) {
                            new StringBuilder("RemoteException during connect for ").append(h.this.Lg);
                        }
                    }
                    int i2 = h.this.mState;
                    h.this.eL();
                    if (i2 != 0) {
                        h.this.mState = i2;
                    }
                    if (MediaBrowserCompat.DEBUG) {
                        h.this.dump();
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public final void eL() {
            if (this.Li != null) {
                this.mContext.unbindService(this.Li);
            }
            this.mState = 1;
            this.Li = null;
            this.Lc = null;
            this.Ld = null;
            this.KZ.a(null);
            this.Lj = null;
            this.Le = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.i
        public final void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (a(messenger, "onConnect")) {
                if (this.mState != 2) {
                    new StringBuilder("onConnect from service while mState=").append(az(this.mState)).append("... ignoring");
                    return;
                }
                this.Lj = str;
                this.Le = token;
                this.mExtras = bundle;
                this.mState = 3;
                if (MediaBrowserCompat.DEBUG) {
                    dump();
                }
                this.Lh.onConnected();
                try {
                    for (Map.Entry<String, k> entry : this.La.entrySet()) {
                        String key = entry.getKey();
                        k value = entry.getValue();
                        List<l> list = value.Lp;
                        List<Bundle> list2 = value.Lq;
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            j jVar = this.Lc;
                            IBinder iBinder = list.get(i2).En;
                            Messenger messenger2 = this.Ld;
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("data_media_item_id", key);
                            android.support.v4.app.c.a(bundle2, "data_callback_token", iBinder);
                            bundle2.putBundle("data_options", list2.get(i2));
                            jVar.a(3, bundle2, messenger2);
                        }
                    }
                } catch (RemoteException e2) {
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.i
        public final void b(Messenger messenger) {
            new StringBuilder("onConnectFailed for ").append(this.Lg);
            if (a(messenger, "onConnectFailed")) {
                if (this.mState != 2) {
                    new StringBuilder("onConnect from service while mState=").append(az(this.mState)).append("... ignoring");
                    return;
                }
                eL();
                this.Lh.onConnectionFailed();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.i
        public final void a(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (a(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.DEBUG) {
                    new StringBuilder("onLoadChildren for ").append(this.Lg).append(" id=").append(str);
                }
                k kVar = this.La.get(str);
                if (kVar == null) {
                    boolean z = MediaBrowserCompat.DEBUG;
                } else if (kVar.c(bundle) == null) {
                } else {
                    if (bundle == null) {
                        if (list != null) {
                            this.Lf = bundle2;
                            this.Lf = null;
                        }
                    } else if (list != null) {
                        this.Lf = bundle2;
                        this.Lf = null;
                    }
                }
            }
        }

        private static String az(int i2) {
            switch (i2) {
                case 0:
                    return "CONNECT_STATE_DISCONNECTING";
                case 1:
                    return "CONNECT_STATE_DISCONNECTED";
                case 2:
                    return "CONNECT_STATE_CONNECTING";
                case 3:
                    return "CONNECT_STATE_CONNECTED";
                case 4:
                    return "CONNECT_STATE_SUSPENDED";
                default:
                    return "UNKNOWN/".concat(String.valueOf(i2));
            }
        }

        private boolean a(Messenger messenger, String str) {
            if (this.Ld == messenger && this.mState != 0 && this.mState != 1) {
                return true;
            }
            if (!(this.mState == 0 || this.mState == 1)) {
                new StringBuilder().append(str).append(" for ").append(this.Lg).append(" with mCallbacksMessenger=").append(this.Ld).append(" this=").append(this);
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final void dump() {
            new StringBuilder("  mServiceComponent=").append(this.Lg);
            new StringBuilder("  mCallback=").append(this.Lh);
            new StringBuilder("  mRootHints=").append(this.KY);
            new StringBuilder("  mState=").append(az(this.mState));
            new StringBuilder("  mServiceConnection=").append(this.Li);
            new StringBuilder("  mServiceBinderWrapper=").append(this.Lc);
            new StringBuilder("  mCallbacksMessenger=").append(this.Ld);
            new StringBuilder("  mRootId=").append(this.Lj);
            new StringBuilder("  mMediaSessionToken=").append(this.Le);
        }

        /* access modifiers changed from: package-private */
        public class a implements ServiceConnection {
            a() {
            }

            public final void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                f(new Runnable() {
                    /* class android.support.v4.media.MediaBrowserCompat.h.a.AnonymousClass1 */

                    public final void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            new StringBuilder("MediaServiceConnection.onServiceConnected name=").append(componentName).append(" binder=").append(iBinder);
                            h.this.dump();
                        }
                        if (a.this.A("onServiceConnected")) {
                            h.this.Lc = new j(iBinder, h.this.KY);
                            h.this.Ld = new Messenger(h.this.KZ);
                            h.this.KZ.a(h.this.Ld);
                            h.this.mState = 2;
                            try {
                                if (MediaBrowserCompat.DEBUG) {
                                    h.this.dump();
                                }
                                j jVar = h.this.Lc;
                                Context context = h.this.mContext;
                                Messenger messenger = h.this.Ld;
                                Bundle bundle = new Bundle();
                                bundle.putString("data_package_name", context.getPackageName());
                                bundle.putBundle("data_root_hints", jVar.KY);
                                jVar.a(1, bundle, messenger);
                            } catch (RemoteException e2) {
                                new StringBuilder("RemoteException during connect for ").append(h.this.Lg);
                                if (MediaBrowserCompat.DEBUG) {
                                    h.this.dump();
                                }
                            }
                        }
                    }
                });
            }

            public final void onServiceDisconnected(final ComponentName componentName) {
                f(new Runnable() {
                    /* class android.support.v4.media.MediaBrowserCompat.h.a.AnonymousClass2 */

                    public final void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            new StringBuilder("MediaServiceConnection.onServiceDisconnected name=").append(componentName).append(" this=").append(this).append(" mServiceConnection=").append(h.this.Li);
                            h.this.dump();
                        }
                        if (a.this.A("onServiceDisconnected")) {
                            h.this.Lc = null;
                            h.this.Ld = null;
                            h.this.KZ.a(null);
                            h.this.mState = 4;
                            h.this.Lh.onConnectionSuspended();
                        }
                    }
                });
            }

            private void f(Runnable runnable) {
                if (Thread.currentThread() == h.this.KZ.getLooper().getThread()) {
                    runnable.run();
                } else {
                    h.this.KZ.post(runnable);
                }
            }

            /* access modifiers changed from: package-private */
            public final boolean A(String str) {
                if (h.this.Li == this && h.this.mState != 0 && h.this.mState != 1) {
                    return true;
                }
                if (!(h.this.mState == 0 || h.this.mState == 1)) {
                    new StringBuilder().append(str).append(" for ").append(h.this.Lg).append(" with mServiceConnection=").append(h.this.Li).append(" this=").append(this);
                }
                return false;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.d
        public final MediaSessionCompat.Token eK() {
            boolean z;
            if (this.mState == 3) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return this.Le;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }
    }

    static class e implements b.a, d, i {
        protected final Object KX;
        protected final Bundle KY;
        protected final a KZ = new a(this);
        private final android.support.v4.e.a<String, k> La = new android.support.v4.e.a<>();
        protected int Lb;
        protected j Lc;
        protected Messenger Ld;
        private MediaSessionCompat.Token Le;
        private Bundle Lf;
        final Context mContext;

        e(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            this.mContext = context;
            this.KY = bundle != null ? new Bundle(bundle) : new Bundle();
            this.KY.putInt("extra_client_version", 1);
            bVar.KU = this;
            this.KX = new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) bVar.KT, this.KY);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.d
        public final void connect() {
            ((MediaBrowser) this.KX).connect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.d
        public final void disconnect() {
            if (!(this.Lc == null || this.Ld == null)) {
                try {
                    this.Lc.a(7, null, this.Ld);
                } catch (RemoteException e2) {
                }
            }
            ((MediaBrowser) this.KX).disconnect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.d
        public final MediaSessionCompat.Token eK() {
            if (this.Le == null) {
                this.Le = MediaSessionCompat.Token.z(((MediaBrowser) this.KX).getSessionToken());
            }
            return this.Le;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public final void onConnected() {
            Bundle extras = ((MediaBrowser) this.KX).getExtras();
            if (extras != null) {
                this.Lb = extras.getInt("extra_service_version", 0);
                IBinder b2 = android.support.v4.app.c.b(extras, "extra_messenger");
                if (b2 != null) {
                    this.Lc = new j(b2, this.KY);
                    this.Ld = new Messenger(this.KZ);
                    this.KZ.a(this.Ld);
                    try {
                        j jVar = this.Lc;
                        Context context = this.mContext;
                        Messenger messenger = this.Ld;
                        Bundle bundle = new Bundle();
                        bundle.putString("data_package_name", context.getPackageName());
                        bundle.putBundle("data_root_hints", jVar.KY);
                        jVar.a(6, bundle, messenger);
                    } catch (RemoteException e2) {
                    }
                }
                android.support.v4.media.session.b d2 = b.a.d(android.support.v4.app.c.b(extras, "extra_session_binder"));
                if (d2 != null) {
                    this.Le = MediaSessionCompat.Token.a(((MediaBrowser) this.KX).getSessionToken(), d2);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public final void onConnectionSuspended() {
            this.Lc = null;
            this.Ld = null;
            this.Le = null;
            this.KZ.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.i
        public final void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.i
        public final void b(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.i
        public final void a(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.Ld == messenger) {
                k kVar = this.La.get(str);
                if (kVar == null) {
                    boolean z = MediaBrowserCompat.DEBUG;
                } else if (kVar.c(bundle) == null) {
                } else {
                    if (bundle == null) {
                        if (list != null) {
                            this.Lf = bundle2;
                            this.Lf = null;
                        }
                    } else if (list != null) {
                        this.Lf = bundle2;
                        this.Lf = null;
                    }
                }
            }
        }
    }

    static class f extends e {
        f(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, null);
        }
    }

    static class g extends f {
        g(Context context, ComponentName componentName, b bVar) {
            super(context, componentName, bVar, null);
        }
    }

    static class k {
        final List<l> Lp = new ArrayList();
        final List<Bundle> Lq = new ArrayList();

        public final l c(Bundle bundle) {
            for (int i2 = 0; i2 < this.Lq.size(); i2++) {
                if (c.a(this.Lq.get(i2), bundle)) {
                    return this.Lp.get(i2);
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends Handler {
        private final WeakReference<i> KR;
        private WeakReference<Messenger> KS;

        a(i iVar) {
            this.KR = new WeakReference<>(iVar);
        }

        public final void handleMessage(Message message) {
            if (this.KS != null && this.KS.get() != null && this.KR.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.d(data);
                i iVar = this.KR.get();
                Messenger messenger = this.KS.get();
                try {
                    switch (message.what) {
                        case 1:
                            Bundle bundle = data.getBundle("data_root_hints");
                            MediaSessionCompat.d(bundle);
                            iVar.a(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle);
                            return;
                        case 2:
                            iVar.b(messenger);
                            return;
                        case 3:
                            Bundle bundle2 = data.getBundle("data_options");
                            MediaSessionCompat.d(bundle2);
                            Bundle bundle3 = data.getBundle("data_notify_children_changed_options");
                            MediaSessionCompat.d(bundle3);
                            iVar.a(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle2, bundle3);
                            return;
                        default:
                            new StringBuilder("Unhandled message: ").append(message).append("\n  Client version: 1\n  Service version: ").append(message.arg1);
                            return;
                    }
                } catch (BadParcelableException e2) {
                    if (message.what == 1) {
                        iVar.b(messenger);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(Messenger messenger) {
            this.KS = new WeakReference<>(messenger);
        }
    }

    /* access modifiers changed from: package-private */
    public static class j {
        Bundle KY;
        private Messenger Lo;

        public j(IBinder iBinder, Bundle bundle) {
            this.Lo = new Messenger(iBinder);
            this.KY = bundle;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, Bundle bundle, Messenger messenger) {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.Lo.send(obtain);
        }
    }

    static class ItemReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public final void onReceiveResult(int i2, Bundle bundle) {
            MediaSessionCompat.d(bundle);
            if (i2 == 0 && bundle != null && bundle.containsKey("media_item")) {
                bundle.getParcelable("media_item");
            }
        }
    }

    static class SearchResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public final void onReceiveResult(int i2, Bundle bundle) {
            Parcelable[] parcelableArray;
            MediaSessionCompat.d(bundle);
            if (i2 == 0 && bundle != null && bundle.containsKey("search_results") && (parcelableArray = bundle.getParcelableArray("search_results")) != null) {
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
        }
    }

    static class CustomActionResultReceiver extends ResultReceiver {
        private final c KW;
        private final Bundle mExtras;

        @Override // android.support.v4.os.ResultReceiver
        public final void onReceiveResult(int i2, Bundle bundle) {
            if (this.KW != null) {
                MediaSessionCompat.d(bundle);
                switch (i2) {
                    case -1:
                    case 0:
                    case 1:
                        return;
                    default:
                        new StringBuilder("Unknown result code: ").append(i2).append(" (extras=").append(this.mExtras).append(", resultData=").append(bundle).append(")");
                        return;
                }
            }
        }
    }
}

package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class s {

    public interface e {
        c a(c cVar);
    }

    public static class c {
        int HA;
        boolean HB;
        boolean HC;
        f HD;
        CharSequence HE;
        CharSequence[] HF;
        int HG;
        int HH;
        boolean HI;
        String HJ;
        boolean HK;
        String HL;
        public boolean HM;
        boolean HN;
        boolean HO;
        public String HP;
        Notification HQ;
        RemoteViews HR;
        RemoteViews HS;
        RemoteViews HT;
        int HU;
        String HV;
        int HW;
        public Notification HX;
        @Deprecated
        public ArrayList<String> HY;
        public ArrayList<a> Hr;
        ArrayList<a> Hs;
        CharSequence Ht;
        CharSequence Hu;
        public PendingIntent Hv;
        PendingIntent Hw;
        RemoteViews Hx;
        Bitmap Hy;
        CharSequence Hz;
        public String mChannelId;
        public int mColor;
        public Context mContext;
        Bundle mExtras;
        int mPriority;
        long mTimeout;
        int mVisibility;

        public c(Context context, String str) {
            this.Hr = new ArrayList<>();
            this.Hs = new ArrayList<>();
            this.HB = true;
            this.HM = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.HU = 0;
            this.HW = 0;
            this.HX = new Notification();
            this.mContext = context;
            this.mChannelId = str;
            this.HX.when = System.currentTimeMillis();
            this.HX.audioStreamType = -1;
            this.mPriority = 0;
            this.HY = new ArrayList<>();
        }

        @Deprecated
        public c(Context context) {
            this(context, null);
        }

        public final c i(long j2) {
            this.HX.when = j2;
            return this;
        }

        public final c as(int i2) {
            this.HX.icon = i2;
            return this;
        }

        public final c f(CharSequence charSequence) {
            this.Ht = j(charSequence);
            return this;
        }

        public final c g(CharSequence charSequence) {
            this.Hu = j(charSequence);
            return this;
        }

        public final c h(CharSequence charSequence) {
            this.HE = j(charSequence);
            return this;
        }

        public final c b(int i2, int i3, boolean z) {
            this.HG = i2;
            this.HH = i3;
            this.HI = z;
            return this;
        }

        public final c a(RemoteViews remoteViews) {
            this.HX.contentView = remoteViews;
            return this;
        }

        public final c a(PendingIntent pendingIntent) {
            this.Hv = pendingIntent;
            return this;
        }

        public final c b(PendingIntent pendingIntent) {
            this.HX.deleteIntent = pendingIntent;
            return this;
        }

        public final c c(PendingIntent pendingIntent) {
            this.Hw = pendingIntent;
            g(128, true);
            return this;
        }

        public final c i(CharSequence charSequence) {
            this.HX.tickerText = j(charSequence);
            return this;
        }

        public final c b(Bitmap bitmap) {
            if (bitmap != null && Build.VERSION.SDK_INT < 27) {
                Resources resources = this.mContext.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.y8);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.y7);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(min * ((double) bitmap.getHeight())), true);
                }
            }
            this.Hy = bitmap;
            return this;
        }

        public final c b(Uri uri) {
            this.HX.sound = uri;
            this.HX.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                this.HX.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public final c et() {
            g(2, true);
            return this;
        }

        public final c E(boolean z) {
            g(16, z);
            return this;
        }

        public final c u(String str) {
            this.HP = str;
            return this;
        }

        public final void g(int i2, boolean z) {
            if (z) {
                this.HX.flags |= i2;
                return;
            }
            this.HX.flags &= i2 ^ -1;
        }

        public final c eu() {
            this.mPriority = 1;
            return this;
        }

        public final Bundle getExtras() {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            return this.mExtras;
        }

        public final c a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.Hr.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public final c a(a aVar) {
            this.Hr.add(aVar);
            return this;
        }

        public final c a(f fVar) {
            if (this.HD != fVar) {
                this.HD = fVar;
                if (this.HD != null) {
                    this.HD.b(this);
                }
            }
            return this;
        }

        public final c b(RemoteViews remoteViews) {
            this.HR = remoteViews;
            return this;
        }

        public final c c(RemoteViews remoteViews) {
            this.HS = remoteViews;
            return this;
        }

        public final c d(RemoteViews remoteViews) {
            this.HT = remoteViews;
            return this;
        }

        public final Notification build() {
            Notification notification;
            t tVar = new t(this);
            f fVar = tVar.In.HD;
            if (fVar != null) {
                fVar.a(tVar);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                notification = tVar.mBuilder.build();
            } else if (Build.VERSION.SDK_INT >= 24) {
                notification = tVar.mBuilder.build();
                if (tVar.HW != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || tVar.HW != 2)) {
                        t.b(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && tVar.HW == 1) {
                        t.b(notification);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                tVar.mBuilder.setExtras(tVar.mExtras);
                notification = tVar.mBuilder.build();
                if (tVar.HR != null) {
                    notification.contentView = tVar.HR;
                }
                if (tVar.HS != null) {
                    notification.bigContentView = tVar.HS;
                }
                if (tVar.HT != null) {
                    notification.headsUpContentView = tVar.HT;
                }
                if (tVar.HW != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || tVar.HW != 2)) {
                        t.b(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && tVar.HW == 1) {
                        t.b(notification);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 20) {
                tVar.mBuilder.setExtras(tVar.mExtras);
                notification = tVar.mBuilder.build();
                if (tVar.HR != null) {
                    notification.contentView = tVar.HR;
                }
                if (tVar.HS != null) {
                    notification.bigContentView = tVar.HS;
                }
                if (tVar.HW != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || tVar.HW != 2)) {
                        t.b(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && tVar.HW == 1) {
                        t.b(notification);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 19) {
                SparseArray<Bundle> h2 = u.h(tVar.Io);
                if (h2 != null) {
                    tVar.mExtras.putSparseParcelableArray("android.support.actionExtras", h2);
                }
                tVar.mBuilder.setExtras(tVar.mExtras);
                notification = tVar.mBuilder.build();
                if (tVar.HR != null) {
                    notification.contentView = tVar.HR;
                }
                if (tVar.HS != null) {
                    notification.bigContentView = tVar.HS;
                }
            } else if (Build.VERSION.SDK_INT >= 16) {
                Notification build = tVar.mBuilder.build();
                Bundle a2 = s.a(build);
                Bundle bundle = new Bundle(tVar.mExtras);
                for (String str : tVar.mExtras.keySet()) {
                    if (a2.containsKey(str)) {
                        bundle.remove(str);
                    }
                }
                a2.putAll(bundle);
                SparseArray<Bundle> h3 = u.h(tVar.Io);
                if (h3 != null) {
                    s.a(build).putSparseParcelableArray("android.support.actionExtras", h3);
                }
                if (tVar.HR != null) {
                    build.contentView = tVar.HR;
                }
                if (tVar.HS != null) {
                    build.bigContentView = tVar.HS;
                }
                notification = build;
            } else {
                notification = tVar.mBuilder.getNotification();
            }
            if (tVar.In.HR != null) {
                notification.contentView = tVar.In.HR;
            }
            int i2 = Build.VERSION.SDK_INT;
            int i3 = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 16 && fVar != null) {
                s.a(notification);
            }
            return notification;
        }

        protected static CharSequence j(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    public static abstract class f {
        protected c Ij;
        CharSequence Ik;
        CharSequence Il;
        boolean Im = false;

        public final void b(c cVar) {
            if (this.Ij != cVar) {
                this.Ij = cVar;
                if (this.Ij != null) {
                    this.Ij.a(this);
                }
            }
        }

        public final Notification build() {
            if (this.Ij != null) {
                return this.Ij.build();
            }
            return null;
        }

        public void a(r rVar) {
        }
    }

    public static class b extends f {
        private CharSequence Hq;

        public b() {
        }

        public b(c cVar) {
            b(cVar);
        }

        public final b e(CharSequence charSequence) {
            this.Hq = c.j(charSequence);
            return this;
        }

        @Override // android.support.v4.app.s.f
        public final void a(r rVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(rVar.er()).setBigContentTitle(this.Ik).bigText(this.Hq);
                if (this.Im) {
                    bigText.setSummaryText(this.Il);
                }
            }
        }
    }

    public static class a {
        final x[] Hh;
        final x[] Hi;
        boolean Hj;
        boolean Hk;
        final int Hl;
        public PendingIntent actionIntent;
        public int icon;
        final Bundle mExtras;
        public CharSequence title;

        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true);
        }

        a(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, x[] xVarArr, x[] xVarArr2, boolean z, int i3, boolean z2) {
            this.Hk = true;
            this.icon = i2;
            this.title = c.j(charSequence);
            this.actionIntent = pendingIntent;
            this.mExtras = bundle == null ? new Bundle() : bundle;
            this.Hh = xVarArr;
            this.Hi = xVarArr2;
            this.Hj = z;
            this.Hl = i3;
            this.Hk = z2;
        }

        /* renamed from: android.support.v4.app.s$a$a  reason: collision with other inner class name */
        public static final class C0017a {
            public boolean Hj;
            private boolean Hk;
            private int Hl;
            private final int Hm;
            private final CharSequence Hn;
            private final PendingIntent Ho;
            private ArrayList<x> Hp;
            private final Bundle mExtras;

            public C0017a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i2, charSequence, pendingIntent, new Bundle());
            }

            private C0017a(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
                this.Hj = true;
                this.Hk = true;
                this.Hm = i2;
                this.Hn = c.j(charSequence);
                this.Ho = pendingIntent;
                this.mExtras = bundle;
                this.Hp = null;
                this.Hj = true;
                this.Hl = 0;
                this.Hk = true;
            }

            public final a es() {
                x[] xVarArr;
                x[] xVarArr2;
                boolean z;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (this.Hp != null) {
                    Iterator<x> it = this.Hp.iterator();
                    while (it.hasNext()) {
                        x next = it.next();
                        if (next.IL || (!(next.IK == null || next.IK.length == 0) || next.IM == null || next.IM.isEmpty())) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    xVarArr = null;
                } else {
                    xVarArr = (x[]) arrayList.toArray(new x[arrayList.size()]);
                }
                if (arrayList2.isEmpty()) {
                    xVarArr2 = null;
                } else {
                    xVarArr2 = (x[]) arrayList2.toArray(new x[arrayList2.size()]);
                }
                return new a(this.Hm, this.Hn, this.Ho, this.mExtras, xVarArr2, xVarArr, this.Hj, this.Hl, this.Hk);
            }
        }
    }

    public static final class d implements e {
        public a HZ;
        private Bitmap Hy;
        private int mColor = 0;

        private static Bundle a(a aVar) {
            Bundle bundle = new Bundle();
            String str = null;
            if (aVar.If != null && aVar.If.length > 1) {
                str = aVar.If[0];
            }
            Parcelable[] parcelableArr = new Parcelable[aVar.Ia.length];
            for (int i2 = 0; i2 < parcelableArr.length; i2++) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", aVar.Ia[i2]);
                bundle2.putString("author", str);
                parcelableArr[i2] = bundle2;
            }
            bundle.putParcelableArray("messages", parcelableArr);
            x xVar = aVar.Ib;
            if (xVar != null) {
                bundle.putParcelable("remote_input", new RemoteInput.Builder(xVar.II).setLabel(xVar.IJ).setChoices(xVar.IK).setAllowFreeFormInput(xVar.IL).addExtras(xVar.mExtras).build());
            }
            bundle.putParcelable("on_reply", aVar.Ic);
            bundle.putParcelable("on_read", aVar.Ie);
            bundle.putStringArray("participants", aVar.If);
            bundle.putLong(AppMeasurement.Param.TIMESTAMP, aVar.Ig);
            return bundle;
        }

        @Override // android.support.v4.app.s.e
        public final c a(c cVar) {
            if (Build.VERSION.SDK_INT >= 21) {
                Bundle bundle = new Bundle();
                if (this.Hy != null) {
                    bundle.putParcelable("large_icon", this.Hy);
                }
                if (this.mColor != 0) {
                    bundle.putInt("app_color", this.mColor);
                }
                if (this.HZ != null) {
                    bundle.putBundle("car_conversation", a(this.HZ));
                }
                cVar.getExtras().putBundle("android.car.EXTENSIONS", bundle);
            }
            return cVar;
        }

        public static class a {
            final String[] Ia;
            final x Ib;
            final PendingIntent Ic;
            final PendingIntent Ie;
            final String[] If;
            final long Ig;

            public a(String[] strArr, x xVar, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j2) {
                this.Ia = strArr;
                this.Ib = xVar;
                this.Ie = pendingIntent2;
                this.Ic = pendingIntent;
                this.If = strArr2;
                this.Ig = j2;
            }

            /* renamed from: android.support.v4.app.s$d$a$a  reason: collision with other inner class name */
            public static class C0018a {
                public x Ib;
                public PendingIntent Ic;
                public PendingIntent Ie;
                public long Ig;
                public final List<String> Ih = new ArrayList();
                public final String Ii;

                public C0018a(String str) {
                    this.Ii = str;
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return u.a(notification);
        }
        return null;
    }
}

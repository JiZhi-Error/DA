package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class d {
    private static d Je;
    private static final Object mLock = new Object();
    final HashMap<BroadcastReceiver, ArrayList<b>> Jb = new HashMap<>();
    private final HashMap<String, ArrayList<b>> Jc = new HashMap<>();
    final ArrayList<a> Jd = new ArrayList<>();
    final Context mAppContext;
    private final Handler mHandler;

    static final class b {
        boolean Jh;
        boolean Ji;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.receiver);
            sb.append(" filter=");
            sb.append(this.filter);
            if (this.Ji) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    static final class a {
        final ArrayList<b> Jg;
        final Intent intent;

        a(Intent intent2, ArrayList<b> arrayList) {
            this.intent = intent2;
            this.Jg = arrayList;
        }
    }

    public static d W(Context context) {
        d dVar;
        synchronized (mLock) {
            if (Je == null) {
                Je = new d(context.getApplicationContext());
            }
            dVar = Je;
        }
        return dVar;
    }

    private d(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            /* class android.support.v4.content.d.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
                r1 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
                if (r1 >= r5.length) goto L_0x000c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
                r6 = r5[r1];
                r7 = r6.Jg.size();
                r3 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
                if (r3 >= r7) goto L_0x0051;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
                r0 = r6.Jg.get(r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
                if (r0.Ji != false) goto L_0x004d;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
                r0.receiver.onReceive(r4.mAppContext, r6.intent);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x004d, code lost:
                r3 = r3 + 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x0051, code lost:
                r1 = r1 + 1;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void handleMessage(android.os.Message r11) {
                /*
                    r10 = this;
                    r2 = 0
                    int r0 = r11.what
                    switch(r0) {
                        case 1: goto L_0x000a;
                        default: goto L_0x0006;
                    }
                L_0x0006:
                    super.handleMessage(r11)
                L_0x0009:
                    return
                L_0x000a:
                    android.support.v4.content.d r4 = android.support.v4.content.d.this
                L_0x000c:
                    java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.support.v4.content.d$b>> r1 = r4.Jb
                    monitor-enter(r1)
                    java.util.ArrayList<android.support.v4.content.d$a> r0 = r4.Jd     // Catch:{ all -> 0x0019 }
                    int r0 = r0.size()     // Catch:{ all -> 0x0019 }
                    if (r0 > 0) goto L_0x001c
                    monitor-exit(r1)     // Catch:{ all -> 0x0019 }
                    goto L_0x0009
                L_0x0019:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0019 }
                    throw r0
                L_0x001c:
                    android.support.v4.content.d$a[] r5 = new android.support.v4.content.d.a[r0]
                    java.util.ArrayList<android.support.v4.content.d$a> r0 = r4.Jd
                    r0.toArray(r5)
                    java.util.ArrayList<android.support.v4.content.d$a> r0 = r4.Jd
                    r0.clear()
                    monitor-exit(r1)
                    r1 = r2
                L_0x002a:
                    int r0 = r5.length
                    if (r1 >= r0) goto L_0x000c
                    r6 = r5[r1]
                    java.util.ArrayList<android.support.v4.content.d$b> r0 = r6.Jg
                    int r7 = r0.size()
                    r3 = r2
                L_0x0036:
                    if (r3 >= r7) goto L_0x0051
                    java.util.ArrayList<android.support.v4.content.d$b> r0 = r6.Jg
                    java.lang.Object r0 = r0.get(r3)
                    android.support.v4.content.d$b r0 = (android.support.v4.content.d.b) r0
                    boolean r8 = r0.Ji
                    if (r8 != 0) goto L_0x004d
                    android.content.BroadcastReceiver r0 = r0.receiver
                    android.content.Context r8 = r4.mAppContext
                    android.content.Intent r9 = r6.intent
                    r0.onReceive(r8, r9)
                L_0x004d:
                    int r0 = r3 + 1
                    r3 = r0
                    goto L_0x0036
                L_0x0051:
                    int r0 = r1 + 1
                    r1 = r0
                    goto L_0x002a
                    switch-data {1->0x000a, }
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.d.AnonymousClass1.handleMessage(android.os.Message):void");
            }
        };
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.Jb) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<b> arrayList = this.Jb.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.Jb.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<b> arrayList2 = this.Jc.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.Jc.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.Jb) {
            ArrayList<b> remove = this.Jb.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    b bVar = remove.get(size);
                    bVar.Ji = true;
                    for (int i2 = 0; i2 < bVar.filter.countActions(); i2++) {
                        String action = bVar.filter.getAction(i2);
                        ArrayList<b> arrayList = this.Jc.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                b bVar2 = arrayList.get(size2);
                                if (bVar2.receiver == broadcastReceiver) {
                                    bVar2.Ji = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.Jc.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    public final boolean b(Intent intent) {
        ArrayList arrayList;
        synchronized (this.Jb) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                new StringBuilder("Resolving type ").append(resolveTypeIfNeeded).append(" scheme ").append(scheme).append(" of intent ").append(intent);
            }
            ArrayList<b> arrayList2 = this.Jc.get(intent.getAction());
            if (arrayList2 != null) {
                if (z) {
                    new StringBuilder("Action list: ").append(arrayList2);
                }
                ArrayList arrayList3 = null;
                int i2 = 0;
                while (i2 < arrayList2.size()) {
                    b bVar = arrayList2.get(i2);
                    if (z) {
                        new StringBuilder("Matching against filter ").append(bVar.filter);
                    }
                    if (bVar.Jh) {
                        if (z) {
                            arrayList = arrayList3;
                        }
                        arrayList = arrayList3;
                    } else {
                        int match = bVar.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                new StringBuilder("  Filter matched!  match=0x").append(Integer.toHexString(match));
                            }
                            if (arrayList3 == null) {
                                arrayList = new ArrayList();
                            } else {
                                arrayList = arrayList3;
                            }
                            arrayList.add(bVar);
                            bVar.Jh = true;
                        }
                        arrayList = arrayList3;
                    }
                    i2++;
                    arrayList3 = arrayList;
                }
                if (arrayList3 != null) {
                    for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                        ((b) arrayList3.get(i3)).Jh = false;
                    }
                    this.Jd.add(new a(intent, arrayList3));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}

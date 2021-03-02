package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.connector.a;
import com.google.firebase.iid.ai;
import com.google.firebase.iid.b;
import com.google.firebase.iid.o;
import com.google.firebase.iid.zzb;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FirebaseMessagingService extends zzb {
    private static final Queue<String> bMS = new ArrayDeque(10);

    static {
        AppMethodBeat.i(116785);
        AppMethodBeat.o(116785);
    }

    static void k(Bundle bundle) {
        AppMethodBeat.i(116783);
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && next.startsWith("google.c.")) {
                it.remove();
            }
        }
        AppMethodBeat.o(116783);
    }

    static boolean l(Bundle bundle) {
        AppMethodBeat.i(116784);
        if (bundle == null) {
            AppMethodBeat.o(116784);
            return false;
        }
        boolean equals = "1".equals(bundle.getString("google.c.a.e"));
        AppMethodBeat.o(116784);
        return equals;
    }

    public void a(RemoteMessage remoteMessage) {
    }

    public void a(String str, Exception exc) {
    }

    public void onDeletedMessages() {
    }

    @Override // com.google.firebase.iid.zzb
    public final Intent e(Intent intent) {
        AppMethodBeat.i(116780);
        Intent poll = o.yr().bLP.poll();
        AppMethodBeat.o(116780);
        return poll;
    }

    @Override // com.google.firebase.iid.zzb
    public final boolean h(Intent intent) {
        AppMethodBeat.i(116781);
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
            if (pendingIntent != null) {
                try {
                    pendingIntent.send();
                } catch (PendingIntent.CanceledException e2) {
                }
            }
            if (l(intent.getExtras())) {
                if (intent != null) {
                    if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                        a aVar = (a) com.google.firebase.a.xS().y(a.class);
                        Log.isLoggable("FirebaseMessaging", 3);
                        if (aVar != null) {
                            String stringExtra = intent.getStringExtra("google.c.a.c_id");
                            aVar.setUserProperty(AppMeasurement.FCM_ORIGIN, AppMeasurement.UserProperty.FIREBASE_LAST_NOTIFICATION, stringExtra);
                            Bundle bundle = new Bundle();
                            bundle.putString("source", "Firebase");
                            bundle.putString(FirebaseAnalytics.b.MEDIUM, "notification");
                            bundle.putString(FirebaseAnalytics.b.CAMPAIGN, stringExtra);
                            aVar.logEvent(AppMeasurement.FCM_ORIGIN, "_cmp", bundle);
                        }
                    } else {
                        Log.isLoggable("FirebaseMessaging", 3);
                    }
                }
                d.a("_no", intent);
            }
            AppMethodBeat.o(116781);
            return true;
        }
        AppMethodBeat.o(116781);
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.firebase.iid.zzb
    public final void f(Intent intent) {
        boolean z;
        Task a2;
        boolean z2;
        char c2 = 65535;
        boolean z3 = false;
        AppMethodBeat.i(116782);
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        switch (action.hashCode()) {
            case 75300319:
                if (action.equals("com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 366519424:
                if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                String stringExtra = intent.getStringExtra("google.message_id");
                if (TextUtils.isEmpty(stringExtra)) {
                    a2 = Tasks.forResult(null);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("google.message_id", stringExtra);
                    ai as = ai.as(this);
                    a2 = as.a(new b(as.yw(), bundle));
                }
                if (TextUtils.isEmpty(stringExtra)) {
                    z2 = false;
                } else if (bMS.contains(stringExtra)) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        String valueOf = String.valueOf(stringExtra);
                        if (valueOf.length() != 0) {
                            "Received duplicate message: ".concat(valueOf);
                        } else {
                            new String("Received duplicate message: ");
                        }
                    }
                    z2 = true;
                } else {
                    if (bMS.size() >= 10) {
                        bMS.remove();
                    }
                    bMS.add(stringExtra);
                    z2 = false;
                }
                if (!z2) {
                    String stringExtra2 = intent.getStringExtra("message_type");
                    if (stringExtra2 == null) {
                        stringExtra2 = GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE;
                    }
                    switch (stringExtra2.hashCode()) {
                        case -2062414158:
                            if (stringExtra2.equals(GoogleCloudMessaging.MESSAGE_TYPE_DELETED)) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 102161:
                            if (stringExtra2.equals(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 814694033:
                            if (stringExtra2.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR)) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 814800675:
                            if (stringExtra2.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_EVENT)) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            if (l(intent.getExtras())) {
                                d.a("_nr", intent);
                            }
                            Bundle extras = intent.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.remove("android.support.content.wakelockid");
                            if ("1".equals(c.c(extras, "gcm.n.e")) || c.c(extras, "gcm.n.icon") != null) {
                                z3 = true;
                            }
                            if (z3) {
                                if (!c.at(this).m(extras)) {
                                    if (l(extras)) {
                                        d.a("_nf", intent);
                                    }
                                }
                            }
                            a(new RemoteMessage(extras));
                            break;
                        case 1:
                            onDeletedMessages();
                            break;
                        case 2:
                            intent.getStringExtra("google.message_id");
                            break;
                        case 3:
                            String stringExtra3 = intent.getStringExtra("google.message_id");
                            if (stringExtra3 == null) {
                                stringExtra3 = intent.getStringExtra("message_id");
                            }
                            a(stringExtra3, new b(intent.getStringExtra("error")));
                            break;
                        default:
                            String valueOf2 = String.valueOf(stringExtra2);
                            if (valueOf2.length() == 0) {
                                new String("Received message with unknown type: ");
                                break;
                            } else {
                                "Received message with unknown type: ".concat(valueOf2);
                                break;
                            }
                    }
                }
                try {
                    Tasks.await(a2, 1, TimeUnit.SECONDS);
                    AppMethodBeat.o(116782);
                    return;
                } catch (InterruptedException | ExecutionException | TimeoutException e2) {
                    String valueOf3 = String.valueOf(e2);
                    new StringBuilder(String.valueOf(valueOf3).length() + 20).append("Message ack failed: ").append(valueOf3);
                    AppMethodBeat.o(116782);
                    return;
                }
            case true:
                if (l(intent.getExtras())) {
                    d.a("_nd", intent);
                    AppMethodBeat.o(116782);
                    return;
                }
                break;
            default:
                String valueOf4 = String.valueOf(intent.getAction());
                if (valueOf4.length() == 0) {
                    new String("Unknown intent action: ");
                    break;
                } else {
                    "Unknown intent action: ".concat(valueOf4);
                    AppMethodBeat.o(116782);
                    return;
                }
        }
        AppMethodBeat.o(116782);
    }
}

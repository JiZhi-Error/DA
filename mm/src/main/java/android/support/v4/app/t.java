package android.support.v4.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.s;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class t implements r {
    RemoteViews HR;
    RemoteViews HS;
    RemoteViews HT;
    int HW;
    final s.c In;
    final List<Bundle> Io = new ArrayList();
    final Notification.Builder mBuilder;
    final Bundle mExtras = new Bundle();

    t(s.c cVar) {
        Bundle bundle;
        this.In = cVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.mBuilder = new Notification.Builder(cVar.mContext, cVar.mChannelId);
        } else {
            this.mBuilder = new Notification.Builder(cVar.mContext);
        }
        Notification notification = cVar.HX;
        this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.Hx).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(cVar.Ht).setContentText(cVar.Hu).setContentInfo(cVar.Hz).setContentIntent(cVar.Hv).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(cVar.Hw, (notification.flags & 128) != 0).setLargeIcon(cVar.Hy).setNumber(cVar.HA).setProgress(cVar.HG, cVar.HH, cVar.HI);
        if (Build.VERSION.SDK_INT < 21) {
            this.mBuilder.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.mBuilder.setSubText(cVar.HE).setUsesChronometer(cVar.HC).setPriority(cVar.mPriority);
            Iterator<s.a> it = cVar.Hr.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            if (cVar.mExtras != null) {
                this.mExtras.putAll(cVar.mExtras);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (cVar.HM) {
                    this.mExtras.putBoolean("android.support.localOnly", true);
                }
                if (cVar.HJ != null) {
                    this.mExtras.putString("android.support.groupKey", cVar.HJ);
                    if (cVar.HK) {
                        this.mExtras.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.mExtras.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (cVar.HL != null) {
                    this.mExtras.putString("android.support.sortKey", cVar.HL);
                }
            }
            this.HR = cVar.HR;
            this.HS = cVar.HS;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.mBuilder.setShowWhen(cVar.HB);
            if (Build.VERSION.SDK_INT < 21 && cVar.HY != null && !cVar.HY.isEmpty()) {
                this.mExtras.putStringArray("android.people", (String[]) cVar.HY.toArray(new String[cVar.HY.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.mBuilder.setLocalOnly(cVar.HM).setGroup(cVar.HJ).setGroupSummary(cVar.HK).setSortKey(cVar.HL);
            this.HW = cVar.HW;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.mBuilder.setCategory(cVar.HP).setColor(cVar.mColor).setVisibility(cVar.mVisibility).setPublicVersion(cVar.HQ).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = cVar.HY.iterator();
            while (it2.hasNext()) {
                this.mBuilder.addPerson(it2.next());
            }
            this.HT = cVar.HT;
            if (cVar.Hs.size() > 0) {
                Bundle bundle2 = cVar.getExtras().getBundle("android.car.EXTENSIONS");
                if (bundle2 == null) {
                    bundle = new Bundle();
                } else {
                    bundle = bundle2;
                }
                Bundle bundle3 = new Bundle();
                for (int i2 = 0; i2 < cVar.Hs.size(); i2++) {
                    bundle3.putBundle(Integer.toString(i2), u.c(cVar.Hs.get(i2)));
                }
                bundle.putBundle("invisible_actions", bundle3);
                cVar.getExtras().putBundle("android.car.EXTENSIONS", bundle);
                this.mExtras.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.mBuilder.setExtras(cVar.mExtras).setRemoteInputHistory(cVar.HF);
            if (cVar.HR != null) {
                this.mBuilder.setCustomContentView(cVar.HR);
            }
            if (cVar.HS != null) {
                this.mBuilder.setCustomBigContentView(cVar.HS);
            }
            if (cVar.HT != null) {
                this.mBuilder.setCustomHeadsUpContentView(cVar.HT);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mBuilder.setBadgeIconType(cVar.HU).setShortcutId(cVar.HV).setTimeoutAfter(cVar.mTimeout).setGroupAlertBehavior(cVar.HW);
            if (cVar.HO) {
                this.mBuilder.setColorized(cVar.HN);
            }
            if (!TextUtils.isEmpty(cVar.mChannelId)) {
                this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
    }

    @Override // android.support.v4.app.r
    public final Notification.Builder er() {
        return this.mBuilder;
    }

    private void b(s.a aVar) {
        Bundle bundle;
        if (Build.VERSION.SDK_INT >= 20) {
            Notification.Action.Builder builder = new Notification.Action.Builder(aVar.icon, aVar.title, aVar.actionIntent);
            if (aVar.Hh != null) {
                for (RemoteInput remoteInput : x.b(aVar.Hh)) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (aVar.mExtras != null) {
                bundle = new Bundle(aVar.mExtras);
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.Hj);
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.Hj);
            }
            bundle.putInt("android.support.action.semanticAction", aVar.Hl);
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.Hl);
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.Hk);
            builder.addExtras(bundle);
            this.mBuilder.addAction(builder.build());
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.Io.add(u.a(this.mBuilder, aVar));
        }
    }

    static void b(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}

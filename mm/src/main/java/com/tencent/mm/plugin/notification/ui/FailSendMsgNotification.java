package com.tencent.mm.plugin.notification.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification {
    public s.c AHH = null;
    private int AHI = 0;
    public a AHJ = null;
    public b AHK = null;
    public c AHL = null;
    public String AHM = null;
    public String AHN = null;
    private PendingIntent AHO = null;
    private PendingIntent AHP = null;
    private PendingIntent AHQ = null;
    private PendingIntent AHR = null;
    public boolean AHS = false;
    public boolean AHT = false;
    public boolean AHU = true;
    Notification HX = null;
    private Intent cYF = null;
    public Context mContext;
    boolean mIsForeground = false;
    private boolean mIsInit = false;
    private int mType;

    public FailSendMsgNotification() {
    }

    public FailSendMsgNotification(int i2) {
        AppMethodBeat.i(26811);
        this.mType = i2;
        this.mContext = MMApplicationContext.getContext();
        this.AHH = a.cd(this.mContext, a.glE());
        this.AHU = true;
        this.AHN = "";
        try {
            if (this.AHU) {
                eyW();
            }
            eyX();
            this.mIsInit = true;
        } catch (Exception e2) {
            Log.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", e2.getMessage());
            this.mIsInit = false;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Boolean.valueOf(this.mContext == null);
        Log.d("MicroMsg.FailSendMsgNotification", "create FailSendMsgNotification, type:%d, context==null:%b", objArr);
        this.AHS = false;
        AppMethodBeat.o(26811);
    }

    private void eyW() {
        AppMethodBeat.i(26812);
        this.AHH.HM = true;
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.omit_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.omit_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.AHQ = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.AHH.a(R.drawable.cj_, this.mContext.getString(R.string.ffe), this.AHQ);
        Intent intent2 = new Intent();
        if (this.mType == 1) {
            intent2.setAction("com.tencent.failnotificaiton.resend_msg");
            intent2.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent2.setAction("com.tencent.failnotificaiton.resend_sns");
            intent2.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent2.putExtra("notification_type", this.mType);
        if (Build.VERSION.SDK_INT >= 16) {
            intent2.addFlags(268435456);
        }
        this.AHR = PendingIntent.getService(this.mContext, this.mType, intent2, 134217728);
        this.AHH.a(R.drawable.cja, this.mContext.getString(R.string.fff), this.AHR);
        AppMethodBeat.o(26812);
    }

    public final void eyX() {
        AppMethodBeat.i(26813);
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.click_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.click_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.AHO = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.AHH.Hv = this.AHO;
        Intent intent2 = new Intent();
        if (this.mType == 1) {
            intent2.setAction("com.tencent.failnotification.dismiss_msg");
            intent2.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent2.setAction("com.tencent.failnotification.dismiss_sns");
            intent2.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent2.putExtra("notification_type", this.mType);
        this.AHP = PendingIntent.getService(this.mContext, this.mType, intent2, 134217728);
        this.AHH.b(this.AHP);
        AppMethodBeat.o(26813);
    }

    public final void eyY() {
        AppMethodBeat.i(26815);
        Log.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", Boolean.FALSE);
        this.mIsForeground = false;
        AppMethodBeat.o(26815);
    }

    @TargetApi(16)
    public final void show() {
        AppMethodBeat.i(26816);
        if (!this.mIsInit) {
            Log.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
            AppMethodBeat.o(26816);
            return;
        }
        this.AHH.i(this.AHN);
        this.AHH.f(this.mContext.getText(R.string.wx));
        this.AHH.as(ezb());
        this.AHH.g(this.AHM);
        this.AHH.E(false);
        this.HX = this.AHH.build();
        if (Build.VERSION.SDK_INT >= 16 && !this.mIsForeground) {
            this.HX.priority = 2;
            Log.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
        }
        Log.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", Boolean.valueOf(this.mIsForeground));
        bg.getNotification().a(this.mType, this.HX, false);
        this.AHS = true;
        AppMethodBeat.o(26816);
    }

    public final void dismiss() {
        AppMethodBeat.i(26817);
        bg.getNotification().cancel(this.mType);
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
            this.mContext.stopService(intent);
        } else if (this.mType == 2) {
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
            this.mContext.stopService(intent);
        }
        this.mIsForeground = false;
        this.AHS = false;
        AppMethodBeat.o(26817);
    }

    public final void eyZ() {
        AppMethodBeat.i(26818);
        this.AHH.g(2, false);
        this.AHT = false;
        show();
        Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
        AppMethodBeat.o(26818);
    }

    public final void eza() {
        AppMethodBeat.i(26819);
        this.AHU = true;
        this.AHH = a.cd(this.mContext, a.glE());
        eyW();
        eyX();
        AppMethodBeat.o(26819);
    }

    private static int ezb() {
        if (Build.VERSION.SDK_INT < 19) {
            return R.drawable.cj7;
        }
        return R.drawable.cj8;
    }

    public static abstract class FailSendMsgNotificationService extends Service {
        protected IListener AHV = new IListener<nn>() {
            /* class com.tencent.mm.plugin.notification.ui.FailSendMsgNotification.FailSendMsgNotificationService.AnonymousClass1 */

            {
                AppMethodBeat.i(161407);
                this.__eventId = nn.class.getName().hashCode();
                AppMethodBeat.o(161407);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(nn nnVar) {
                AppMethodBeat.i(26810);
                int i2 = nnVar.dTH.type;
                if (i2 != FailSendMsgNotificationService.this.ezc()) {
                    Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, type mismatch, type:%d, getNotificationType:%d", Integer.valueOf(i2), Integer.valueOf(FailSendMsgNotificationService.this.ezc()));
                    AppMethodBeat.o(26810);
                } else {
                    Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, stop service and show notificaiton, type:%d", Integer.valueOf(i2));
                    FailSendMsgNotificationService.this.stopForeground(true);
                    if (FailSendMsgNotificationService.this.AHW != null) {
                        FailSendMsgNotificationService.this.AHW.mIsForeground = false;
                        FailSendMsgNotificationService.this.AHW.show();
                    }
                    FailSendMsgNotificationService.this.stopSelf();
                    AppMethodBeat.o(26810);
                }
                return false;
            }
        };
        protected FailSendMsgNotification AHW = null;

        /* access modifiers changed from: protected */
        public abstract int ezc();

        public void onCreate() {
            super.onCreate();
            Log.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
            EventCenter.instance.addListener(this.AHV);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        @TargetApi(16)
        public int onStartCommand(Intent intent, int i2, int i3) {
            boolean z;
            boolean z2;
            Log.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
            if (intent == null || intent.getExtras() == null) {
                Log.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
            } else {
                String action = intent.getAction();
                if (Util.isNullOrNil(action)) {
                    Log.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
                } else {
                    int i4 = intent.getExtras().getInt("notification_type", -1);
                    Log.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", Integer.valueOf(i4));
                    if (f.TU(i4) == null) {
                        Log.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                    } else {
                        Log.d("MicroMsg.FailSendMsgNotification", "action:%s", action);
                        this.AHW = f.TU(i4);
                        if (action.startsWith("com.tencent.failnotification.omit")) {
                            if (this.AHW.AHJ != null) {
                                Log.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", Integer.valueOf(i4));
                                this.AHW.AHJ.eyM();
                            }
                        } else if (action.startsWith("com.tencent.failnotificaiton.resend")) {
                            if (this.AHW.AHJ != null) {
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(i4);
                                if (this.AHW.HX == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                objArr[1] = Boolean.valueOf(z);
                                if (this.AHW.AHH == null) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                objArr[2] = Boolean.valueOf(z2);
                                Log.d("MicroMsg.FailSendMsgNotification", "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b", objArr);
                                if (this.AHW != null) {
                                    this.AHW.mIsForeground = true;
                                }
                                if (this.AHW.HX != null && Build.VERSION.SDK_INT >= 16) {
                                    this.AHW.HX.priority = 0;
                                }
                                if (this.AHW.HX == null) {
                                    this.AHW.show();
                                }
                                startForeground(i4, this.AHW.HX);
                                this.AHW.AHJ.eyL();
                                Log.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", Integer.valueOf(i4));
                            }
                        } else if (action.startsWith("com.tencent.failnotification.click")) {
                            if (this.AHW.AHK != null) {
                                Log.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", Integer.valueOf(i4));
                                this.AHW.AHK.eyN();
                            }
                        } else if (action.startsWith("com.tencent.failnotification.dismiss")) {
                            this.AHW.AHS = false;
                            this.AHW.mIsForeground = false;
                            if (this.AHW.AHL != null) {
                                Log.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
                                this.AHW.AHL.onDismiss();
                            }
                            stopSelf();
                        }
                    }
                }
            }
            return 2;
        }

        public void onDestroy() {
            super.onDestroy();
            Log.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
            EventCenter.instance.removeListener(this.AHV);
        }
    }

    public static class FailSendNormalMsgNotificationService extends FailSendMsgNotificationService {
        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.notification.ui.FailSendMsgNotification.FailSendMsgNotificationService
        public final int ezc() {
            return 1;
        }
    }

    public static class FailSendSnsMsgNotificationService extends FailSendMsgNotificationService {
        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.notification.ui.FailSendMsgNotification.FailSendMsgNotificationService
        public final int ezc() {
            return 2;
        }
    }

    public final void aJb(String str) {
        AppMethodBeat.i(26814);
        this.AHM = str;
        show();
        AppMethodBeat.o(26814);
    }
}

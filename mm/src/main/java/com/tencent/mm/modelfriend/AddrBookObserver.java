package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.a;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.service.MMService;
import java.util.Random;

public final class AddrBookObserver extends ContentObserver {
    private static MMHandler handler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.modelfriend.AddrBookObserver.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(127655);
            super.handleMessage(message);
            Context context = (Context) message.obj;
            if (AddrBookObserver.iUE == null) {
                Intent unused = AddrBookObserver.iUE = new Intent();
                AddrBookObserver.iUE.setClass(context, AddrBookService.class);
            }
            float nextFloat = new Random(System.currentTimeMillis()).nextFloat();
            AddrBookObserver.iUE.putExtra(AddrBookService.iUF, nextFloat);
            try {
                Log.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", Float.valueOf(nextFloat));
                c.startService(AddrBookObserver.iUE);
                AppMethodBeat.o(127655);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AddrBookObserver", e2, "startService failed", new Object[0]);
                AppMethodBeat.o(127655);
            }
        }
    };
    private static boolean iUD = false;
    private static Intent iUE;
    private final Context context;

    static {
        AppMethodBeat.i(127661);
        AppMethodBeat.o(127661);
    }

    public AddrBookObserver(Context context2) {
        super(MMHandler.createFreeHandler(Looper.myLooper()));
        AppMethodBeat.i(127659);
        this.context = context2;
        AppMethodBeat.o(127659);
    }

    public final void onChange(boolean z) {
        AppMethodBeat.i(127660);
        super.onChange(z);
        Log.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
        if (!iUD) {
            l.bod();
            handler.removeMessages(0);
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = this.context;
            obtainMessage.what = 0;
            handler.sendMessageDelayed(obtainMessage, 20000);
            AppMethodBeat.o(127660);
            return;
        }
        Log.e("MicroMsg.AddrBookObserver", "isSyncing:" + iUD + ", is time to sync:" + l.bod() + " , return");
        AppMethodBeat.o(127660);
    }

    public static class AddrBookService extends MMService {
        public static boolean iUD = false;
        public static String iUF = "key_sync_session";
        public static boolean isCanceled = false;
        private b iUG = new b() {
            /* class com.tencent.mm.modelfriend.AddrBookObserver.AddrBookService.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.account.a.a.b
            public final void fG(boolean z) {
                AppMethodBeat.i(127656);
                if (!z) {
                    Log.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
                    AddrBookService.this.stopSelf();
                    AddrBookService.iUD = false;
                    AppMethodBeat.o(127656);
                    return;
                }
                System.currentTimeMillis();
                l.boe();
                g.azz().a(new ao(l.boi(), l.boh()), 0);
                AddrBookService.this.stopSelf();
                AddrBookService.iUD = false;
                AppMethodBeat.o(127656);
            }
        };

        public AddrBookService() {
            AppMethodBeat.i(127657);
            AppMethodBeat.o(127657);
        }

        @Override // com.tencent.mm.service.MMService
        public final int onStartCommand(Intent intent, int i2, int i3) {
            AppMethodBeat.i(127658);
            super.onStartCommand(intent, i2, i3);
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(intent == null);
            Log.i("MicroMsg.AddrBookObserver", "service start intent:%b", objArr);
            if (intent == null) {
                Log.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
                stopSelf();
                AppMethodBeat.o(127658);
            } else {
                float floatExtra = intent.getFloatExtra(iUF, -1.0f);
                if (floatExtra == -1.0f) {
                    Log.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
                    stopSelf();
                    AppMethodBeat.o(127658);
                } else {
                    SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
                    float f2 = sharedPreferences.getFloat(iUF, 0.0f);
                    if (f2 == floatExtra) {
                        Log.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", Float.valueOf(f2));
                        stopSelf();
                        AppMethodBeat.o(127658);
                    } else {
                        sharedPreferences.edit().putFloat(iUF, floatExtra).commit();
                        Log.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", Float.valueOf(floatExtra));
                        if (isCanceled) {
                            Log.i("MicroMsg.AddrBookObserver", "service canceled");
                            isCanceled = false;
                            stopSelf();
                            AppMethodBeat.o(127658);
                        } else {
                            try {
                                if (!g.aAc()) {
                                    Log.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
                                    stopSelf();
                                    AppMethodBeat.o(127658);
                                } else {
                                    if (h.aqJ().getInt("WCOEntranceSwitch", 0) > 0) {
                                        EventCenter.instance.publish(new ky());
                                    }
                                    if (!l.boc() || l.bnY()) {
                                        Log.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
                                        stopSelf();
                                        AppMethodBeat.o(127658);
                                    } else {
                                        Log.i("MicroMsg.AddrBookObserver", "start sync");
                                        if (!t.dv(MMApplicationContext.getContext())) {
                                            iUD = true;
                                            a.syncAddrBook(this.iUG);
                                            AppMethodBeat.o(127658);
                                        } else {
                                            Log.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
                                            stopSelf();
                                            AppMethodBeat.o(127658);
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.AddrBookObserver", e2, "", new Object[0]);
                                Log.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", e2.getMessage());
                                stopSelf();
                            }
                        }
                    }
                }
            }
            return 2;
        }

        @Override // com.tencent.mm.service.MMService
        public final IBinder akL() {
            return null;
        }

        @Override // com.tencent.mm.service.MMService
        public final String getTag() {
            return "MicroMsg.AddrBookObserver";
        }
    }
}

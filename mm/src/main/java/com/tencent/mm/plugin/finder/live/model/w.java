package com.tencent.mm.plugin.finder.live.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0017J\u0017\u0010\u001a\u001a\u00020\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dR\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/SingleTaskLooper;", "", "name", "", "tag", "task", "Ljava/lang/Runnable;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V", "MSG_DISPATCH", "", "MSG_FINISH", "MSG_RUN", "TAG", "callback", "Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;", "finish", "", "getName", "()Ljava/lang/String;", "getTag", "workHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "finishTask", "", "isFinished", "removeTask", "tryRunTask", "delay", "", "(Ljava/lang/Long;)V", "plugin-finder_release"})
public final class w {
    final int MSG_FINISH;
    final String TAG;
    private final MMHandler.Callback callback;
    volatile boolean dgZ;
    final String name;
    private final String tag;
    final int ukk;
    final int ukl;
    final MMHandler workHandler;

    public w() {
        this(null, null, 7);
    }

    private w(String str, Runnable runnable) {
        MMHandler mMHandler;
        AppMethodBeat.i(246288);
        this.name = str;
        this.tag = null;
        this.TAG = "MicroMsg.SingleTaskLooper";
        this.ukl = 1;
        this.MSG_FINISH = 2;
        this.dgZ = true;
        this.callback = new a(this, runnable);
        if (Util.isNullOrNil(this.tag)) {
            mMHandler = new MMHandler(this.callback);
        } else {
            mMHandler = new MMHandler(this.tag, this.callback);
        }
        this.workHandler = mMHandler;
        AppMethodBeat.o(246288);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(String str, Runnable runnable, int i2) {
        this((i2 & 1) != 0 ? null : str, (i2 & 4) != 0 ? null : runnable);
        AppMethodBeat.i(246289);
        AppMethodBeat.o(246289);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class a implements MMHandler.Callback {
        final /* synthetic */ w ukm;
        final /* synthetic */ Runnable ukn;

        a(w wVar, Runnable runnable) {
            this.ukm = wVar;
            this.ukn = runnable;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(246284);
            int i2 = message.what;
            if (i2 == this.ukm.ukl) {
                if (message.obj instanceof Long) {
                    Object obj = message.obj;
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Long");
                        AppMethodBeat.o(246284);
                        throw tVar;
                    }
                    long longValue = ((Long) obj).longValue();
                    Log.i(this.ukm.TAG, this.ukm.name + " MSG_DISPATCH finish:" + this.ukm.dgZ + " delay:" + longValue);
                    if (this.ukm.dgZ) {
                        this.ukm.workHandler.sendEmptyMessageDelayed(this.ukm.ukk, longValue);
                        this.ukm.dgZ = false;
                    }
                }
            } else if (i2 == this.ukm.MSG_FINISH) {
                this.ukm.dgZ = true;
                Log.i(this.ukm.TAG, this.ukm.name + " MSG_FINISH finish:" + this.ukm.dgZ);
            } else if (i2 == this.ukm.ukk) {
                Log.i(this.ukm.TAG, this.ukm.name + " MSG_RUN finish:" + this.ukm.dgZ);
                Runnable runnable = this.ukn;
                if (runnable != null) {
                    runnable.run();
                }
            } else {
                Log.i(this.ukm.TAG, this.ukm.name + " invalid msg:" + message.what);
            }
            AppMethodBeat.o(246284);
            return true;
        }
    }

    public final void f(Long l) {
        AppMethodBeat.i(246285);
        Log.i(this.TAG, this.name + " tryRunTask isQuit:" + this.workHandler.isQuit());
        this.workHandler.obtainMessage(this.ukl, l).sendToTarget();
        AppMethodBeat.o(246285);
    }

    public final void dgD() {
        AppMethodBeat.i(246286);
        Log.i(this.TAG, this.name + " finishTask isQuit:" + this.workHandler.isQuit());
        this.workHandler.sendEmptyMessage(this.MSG_FINISH);
        AppMethodBeat.o(246286);
    }

    public final void dgE() {
        AppMethodBeat.i(246287);
        Log.i(this.TAG, this.name + " removeTask");
        this.workHandler.removeCallbacksAndMessages(null);
        this.dgZ = true;
        AppMethodBeat.o(246287);
    }
}

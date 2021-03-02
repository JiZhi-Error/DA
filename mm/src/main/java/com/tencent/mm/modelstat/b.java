package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class b {
    public static b jmd = new b();
    private IListener gmS = new IListener<tz>() {
        /* class com.tencent.mm.modelstat.b.AnonymousClass1 */

        {
            AppMethodBeat.i(161784);
            this.__eventId = tz.class.getName().hashCode();
            AppMethodBeat.o(161784);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tz tzVar) {
            AppMethodBeat.i(150974);
            tz tzVar2 = tzVar;
            if (tzVar2 instanceof tz) {
                b.this.s(tzVar2.eat.dCM);
            }
            AppMethodBeat.o(150974);
            return false;
        }
    };
    private boolean hasInit = false;
    public log_13835 jmc;
    private int jme = 1;
    private int jmf = 1;
    public Object lock = new Object();

    public enum a {
        OP_Chatting(1),
        OP_Msg(2);
        
        public int value = 0;

        public static a valueOf(String str) {
            AppMethodBeat.i(150978);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(150978);
            return aVar;
        }

        static {
            AppMethodBeat.i(150979);
            AppMethodBeat.o(150979);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    /* renamed from: com.tencent.mm.modelstat.b$b  reason: collision with other inner class name */
    public enum EnumC0457b {
        UnKnownType(0),
        expourse(1),
        click(2),
        send(3),
        fav(4),
        revoke(5),
        delete(6),
        voiceToText(7),
        translate(8),
        translateHidden(9),
        doubleClickText(10),
        imageSaveToLocal(11),
        playMusic(12),
        stopMusic(13);
        
        public int value = 0;

        public static EnumC0457b valueOf(String str) {
            AppMethodBeat.i(150981);
            EnumC0457b bVar = (EnumC0457b) Enum.valueOf(EnumC0457b.class, str);
            AppMethodBeat.o(150981);
            return bVar;
        }

        static {
            AppMethodBeat.i(150982);
            AppMethodBeat.o(150982);
        }

        private EnumC0457b(int i2) {
            this.value = i2;
        }
    }

    static {
        AppMethodBeat.i(151006);
        AppMethodBeat.o(151006);
    }

    private b() {
        AppMethodBeat.i(150983);
        EventCenter.instance.add(this.gmS);
        AppMethodBeat.o(150983);
    }

    public final boolean fP(String str) {
        AppMethodBeat.i(150984);
        if (Util.isNullOrNil(str)) {
            String mMStack = Util.getStack().toString();
            Log.e("MicroMsg.ChattingOperationUitl", "check error:%s", mMStack);
            log_13913 log_13913 = new log_13913();
            log_13913.scene_ = 1;
            log_13913.error_ = mMStack;
            h.INSTANCE.c(13913, log_13913);
            AppMethodBeat.o(150984);
            return false;
        }
        if (!(this.jmc == null || this.jmc.currChatName_ == null || this.jmc.currChatName_.equals(str))) {
            report();
        }
        if (this.jmc == null) {
            this.jmc = new log_13835();
            this.jmc.currChatName_ = str;
        }
        AppMethodBeat.o(150984);
        return true;
    }

    public final void report() {
        boolean z;
        AppMethodBeat.i(150985);
        if (!bfZ()) {
            AppMethodBeat.o(150985);
            return;
        }
        synchronized (this.lock) {
            try {
                z = this.jmc != null && !this.jmc.oplist_.isEmpty();
            } catch (Throwable th) {
                AppMethodBeat.o(150985);
                throw th;
            }
        }
        if (z) {
            if (this.jmf != 0) {
                Log.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
                h.INSTANCE.c(13835, this.jmc);
            }
            if (this.jme != 0) {
                String bfY = bfY();
                Log.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", bfY);
                h.INSTANCE.kvStat(13748, bfY);
            }
        }
        this.jmc = null;
        AppMethodBeat.o(150985);
    }

    public final void V(String str, boolean z) {
        int i2 = 1;
        AppMethodBeat.i(150986);
        if (!bfZ()) {
            AppMethodBeat.o(150986);
            return;
        }
        IMBehavior iMBehavior = new IMBehavior();
        iMBehavior.opType = 1;
        iMBehavior.chattingOp = new IMBehaviorChattingOP();
        IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
        if (!z) {
            i2 = 2;
        }
        iMBehaviorChattingOP.changeUnread = i2;
        report();
        if (!fP(str)) {
            AppMethodBeat.o(150986);
            return;
        }
        synchronized (this.lock) {
            try {
                this.jmc.oplist_.add(iMBehavior);
            } catch (Throwable th) {
                AppMethodBeat.o(150986);
                throw th;
            }
        }
        report();
        AppMethodBeat.o(150986);
    }

    public final void c(boolean z, String str, boolean z2) {
        int i2 = 1;
        AppMethodBeat.i(150987);
        if (!bfZ()) {
            AppMethodBeat.o(150987);
            return;
        }
        IMBehavior iMBehavior = new IMBehavior();
        iMBehavior.opType = 1;
        iMBehavior.chattingOp = new IMBehaviorChattingOP();
        IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
        if (!z2) {
            i2 = 2;
        }
        iMBehaviorChattingOP.changeTop = i2;
        if (z) {
            report();
        }
        if (!fP(str)) {
            AppMethodBeat.o(150987);
            return;
        }
        synchronized (this.lock) {
            try {
                this.jmc.oplist_.add(iMBehavior);
            } finally {
                AppMethodBeat.o(150987);
            }
        }
        if (z) {
            report();
        }
    }

    public final void W(String str, boolean z) {
        int i2 = 1;
        AppMethodBeat.i(150988);
        if (!bfZ()) {
            AppMethodBeat.o(150988);
        } else if (!fP(str)) {
            AppMethodBeat.o(150988);
        } else {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z) {
                i2 = 2;
            }
            iMBehaviorChattingOP.changeSaveAddress = i2;
            synchronized (this.lock) {
                try {
                    this.jmc.oplist_.add(iMBehavior);
                } finally {
                    AppMethodBeat.o(150988);
                }
            }
        }
    }

    private void a(IMBehavior iMBehavior) {
        boolean z;
        AppMethodBeat.i(150989);
        synchronized (this.lock) {
            try {
                if (iMBehavior.opType == a.OP_Chatting.value) {
                    this.jmc.oplist_.add(iMBehavior);
                    return;
                }
                Iterator<IMBehavior> it = this.jmc.oplist_.iterator();
                while (it.hasNext()) {
                    IMBehavior next = it.next();
                    if (next.opType == a.OP_Msg.value) {
                        IMBehaviorMsgOP iMBehaviorMsgOP = next.msgOp;
                        IMBehaviorMsgOP iMBehaviorMsgOP2 = iMBehavior.msgOp;
                        if (iMBehaviorMsgOP.msgOpType == iMBehaviorMsgOP2.msgOpType && iMBehaviorMsgOP.msgType == iMBehaviorMsgOP2.msgType && iMBehaviorMsgOP.appMsgInnerType == iMBehaviorMsgOP2.appMsgInnerType) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            next.msgOp.count++;
                            AppMethodBeat.o(150989);
                            return;
                        }
                    }
                }
                this.jmc.oplist_.add(iMBehavior);
                AppMethodBeat.o(150989);
            } finally {
                AppMethodBeat.o(150989);
            }
        }
    }

    public final void a(ca caVar, EnumC0457b bVar, int i2) {
        AppMethodBeat.i(150990);
        if (caVar == null || !fP(caVar.field_talker)) {
            AppMethodBeat.o(150990);
            return;
        }
        IMBehavior iMBehavior = new IMBehavior();
        iMBehavior.opType = 2;
        iMBehavior.msgOp = new IMBehaviorMsgOP();
        iMBehavior.msgOp.msgType = caVar.getType() & 65535;
        if (caVar.dOQ()) {
            iMBehavior.msgOp.appMsgInnerType = i2;
        }
        iMBehavior.msgOp.msgOpType = bVar.value;
        iMBehavior.msgOp.count = 1;
        a(iMBehavior);
        AppMethodBeat.o(150990);
    }

    public final void b(final ca caVar, final int i2) {
        AppMethodBeat.i(150991);
        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.mm.modelstat.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(150975);
                b.a(b.this, caVar, i2);
                AppMethodBeat.o(150975);
            }
        });
        AppMethodBeat.o(150991);
    }

    public final void s(final ca caVar) {
        AppMethodBeat.i(150992);
        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.mm.modelstat.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(150976);
                b.a(b.this, caVar, 0);
                AppMethodBeat.o(150976);
            }
        });
        AppMethodBeat.o(150992);
    }

    public final void c(ca caVar, int i2) {
        AppMethodBeat.i(150993);
        if (!bfZ()) {
            AppMethodBeat.o(150993);
            return;
        }
        a(caVar, EnumC0457b.fav, i2);
        AppMethodBeat.o(150993);
    }

    public final void ac(ca caVar) {
        AppMethodBeat.i(150994);
        if (!bfZ()) {
            AppMethodBeat.o(150994);
            return;
        }
        a(caVar, EnumC0457b.fav, 0);
        AppMethodBeat.o(150994);
    }

    public final void d(ca caVar, int i2) {
        AppMethodBeat.i(150995);
        if (!bfZ()) {
            AppMethodBeat.o(150995);
            return;
        }
        a(caVar, EnumC0457b.delete, i2);
        AppMethodBeat.o(150995);
    }

    public final void ad(ca caVar) {
        AppMethodBeat.i(150996);
        if (!bfZ()) {
            AppMethodBeat.o(150996);
            return;
        }
        a(caVar, EnumC0457b.delete, 0);
        AppMethodBeat.o(150996);
    }

    public final void ae(ca caVar) {
        AppMethodBeat.i(150997);
        if (!bfZ()) {
            AppMethodBeat.o(150997);
            return;
        }
        a(caVar, EnumC0457b.click, 0);
        AppMethodBeat.o(150997);
    }

    public final void a(ca caVar, boolean z) {
        AppMethodBeat.i(150999);
        if (!bfZ()) {
            AppMethodBeat.o(150999);
        } else if (!caVar.isText()) {
            AppMethodBeat.o(150999);
        } else {
            a(caVar, z ? EnumC0457b.translate : EnumC0457b.translateHidden, 0);
            AppMethodBeat.o(150999);
        }
    }

    public final void af(ca caVar) {
        AppMethodBeat.i(151000);
        if (!bfZ()) {
            AppMethodBeat.o(151000);
            return;
        }
        a(caVar, EnumC0457b.imageSaveToLocal, 0);
        AppMethodBeat.o(151000);
    }

    public final void a(ca caVar, boolean z, int i2) {
        AppMethodBeat.i(151001);
        if (!bfZ()) {
            AppMethodBeat.o(151001);
            return;
        }
        a(caVar, z ? EnumC0457b.playMusic : EnumC0457b.stopMusic, i2);
        AppMethodBeat.o(151001);
    }

    private String bfY() {
        StringBuilder append;
        String format;
        AppMethodBeat.i(151002);
        if (this.jmc == null) {
            AppMethodBeat.o(151002);
            return "";
        }
        String str = ",";
        LinkedList linkedList = new LinkedList();
        synchronized (this.lock) {
            try {
                linkedList.addAll(this.jmc.oplist_);
            } catch (Throwable th) {
                AppMethodBeat.o(151002);
                throw th;
            }
        }
        Iterator it = linkedList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            IMBehavior iMBehavior = (IMBehavior) it.next();
            if (!z) {
                str = str + "|";
            }
            String str2 = str + iMBehavior.opType + "#";
            if (iMBehavior.opType == 1) {
                append = new StringBuilder().append(str2);
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                format = "";
                if (iMBehaviorChattingOP.changeUnread != 0) {
                    format = format + "changeUnread=" + iMBehaviorChattingOP.changeUnread;
                }
                if (iMBehaviorChattingOP.changeTop != 0) {
                    format = format + "changeTop=" + iMBehaviorChattingOP.changeTop;
                }
                if (iMBehaviorChattingOP.changeNotifyStatus != 0) {
                    format = format + "changeNotifyStatus=" + iMBehaviorChattingOP.changeNotifyStatus;
                }
                if (iMBehaviorChattingOP.changeSaveAddress != 0) {
                    format = format + "changeSaveAddress=" + iMBehaviorChattingOP.changeSaveAddress;
                }
                if (iMBehaviorChattingOP.expose != 0) {
                    format = format + "expose=" + iMBehaviorChattingOP.expose;
                }
            } else {
                append = new StringBuilder().append(str2);
                IMBehaviorMsgOP iMBehaviorMsgOP = iMBehavior.msgOp;
                if (iMBehaviorMsgOP.msgType == 49) {
                    format = String.format(Locale.US, "msgType=%d&msgOpType=%d&appMsgInnerType=%d&count=%d", Integer.valueOf(iMBehaviorMsgOP.msgType), Integer.valueOf(iMBehaviorMsgOP.msgOpType), Integer.valueOf(iMBehaviorMsgOP.appMsgInnerType), Integer.valueOf(iMBehaviorMsgOP.count));
                } else {
                    format = String.format(Locale.US, "msgType=%d&msgOpType=%d&count=%d", Integer.valueOf(iMBehaviorMsgOP.msgType), Integer.valueOf(iMBehaviorMsgOP.msgOpType), Integer.valueOf(iMBehaviorMsgOP.count));
                }
            }
            str = append.append(format).toString();
            z = false;
        }
        String str3 = str + "," + this.jmc.currChatName_;
        AppMethodBeat.o(151002);
        return str3;
    }

    public final boolean bfZ() {
        AppMethodBeat.i(151003);
        bga();
        if (this.jme == 0 && this.jmf == 0) {
            AppMethodBeat.o(151003);
            return false;
        }
        AppMethodBeat.o(151003);
        return true;
    }

    private void bga() {
        AppMethodBeat.i(151004);
        if (this.hasInit) {
            AppMethodBeat.o(151004);
            return;
        }
        this.hasInit = true;
        if (!g.aAc()) {
            Log.w("MicroMsg.ChattingOperationUitl", "account has not ready");
            AppMethodBeat.o(151004);
            return;
        }
        c Fu = d.aXu().Fu("100148");
        if (Fu.isValid()) {
            this.jme = Util.getInt(Fu.gzz().get("needUploadData"), 1);
        }
        c Fu2 = d.aXu().Fu("100149");
        if (Fu2.isValid()) {
            this.jmf = Util.getInt(Fu2.gzz().get("needUploadData"), 1);
        }
        AppMethodBeat.o(151004);
    }

    static /* synthetic */ void a(b bVar, ca caVar, int i2) {
        AppMethodBeat.i(151005);
        ua uaVar = new ua();
        uaVar.eau.dCM = caVar;
        EventCenter.instance.publish(uaVar);
        if (bVar.bfZ()) {
            bVar.a(caVar, EnumC0457b.send, i2);
        }
        AppMethodBeat.o(151005);
    }
}

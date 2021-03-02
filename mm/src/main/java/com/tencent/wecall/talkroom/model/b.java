package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    talk Suj = new talk();

    public b() {
        AppMethodBeat.i(62557);
        com.tencent.pb.common.c.b.i("simon:TalkRoomContext", "construct engine:", this.Suj);
        AppMethodBeat.o(62557);
    }

    public final int uninitLive() {
        int i2;
        AppMethodBeat.i(62558);
        if (!a.RCk) {
            AppMethodBeat.o(62558);
            return 0;
        }
        try {
            if (this.Suj != null) {
                i2 = this.Suj.uninit();
                com.tencent.pb.common.c.b.i("simon:TalkRoomContext", "uninitLive ret: ", Integer.valueOf(i2));
                AppMethodBeat.o(62558);
                return i2;
            }
        } catch (Throwable th) {
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", "uninitLive ", th);
        }
        i2 = 0;
        com.tencent.pb.common.c.b.i("simon:TalkRoomContext", "uninitLive ret: ", Integer.valueOf(i2));
        AppMethodBeat.o(62558);
        return i2;
    }

    public final int Close() {
        int i2;
        AppMethodBeat.i(62559);
        if (!a.RCk) {
            AppMethodBeat.o(62559);
            return 0;
        }
        try {
            if (this.Suj != null) {
                i2 = this.Suj.close();
                com.tencent.pb.common.c.b.i("simon:TalkRoomContext", "Close ret: ", Integer.valueOf(i2));
                AppMethodBeat.o(62559);
                return i2;
            }
        } catch (Throwable th) {
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", "Close ", th);
        }
        i2 = 0;
        com.tencent.pb.common.c.b.i("simon:TalkRoomContext", "Close ret: ", Integer.valueOf(i2));
        AppMethodBeat.o(62559);
        return i2;
    }

    public final void OnMembersChanged(int[] iArr) {
        AppMethodBeat.i(62560);
        if (!a.RCk || this.Suj == null) {
            AppMethodBeat.o(62560);
            return;
        }
        this.Suj.OnMembersChanged(iArr);
        AppMethodBeat.o(62560);
    }

    public final byte[] hqV() {
        if (!a.RCk || this.Suj == null) {
            return new byte[0];
        }
        return this.Suj.field_capInfo;
    }

    public final void hqW() {
        if (a.RCk && this.Suj != null) {
            this.Suj.field_capInfo = null;
        }
    }

    public final int hqX() {
        AppMethodBeat.i(62561);
        try {
            if (!a.RCk || this.Suj == null) {
                AppMethodBeat.o(62561);
                return 0;
            }
            AtomicInteger atomicInteger = new AtomicInteger();
            AtomicInteger atomicInteger2 = new AtomicInteger();
            this.Suj.getChannelBytes(atomicInteger, atomicInteger2);
            int i2 = atomicInteger2.get();
            AppMethodBeat.o(62561);
            return i2;
        } catch (Throwable th) {
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", "getTotalWWANBytes: ", th);
            AppMethodBeat.o(62561);
            return 0;
        }
    }
}

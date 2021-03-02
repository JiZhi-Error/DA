package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.d.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {

    public static class a implements i {
        public a() {
            AppMethodBeat.i(182078);
            g.azz().a(3618, this);
            g.azz().a(3854, this);
            AppMethodBeat.o(182078);
        }

        /* access modifiers changed from: protected */
        public final void finalize() {
            AppMethodBeat.i(182079);
            g.azz().b(3618, this);
            g.azz().b(3854, this);
            super.finalize();
            AppMethodBeat.o(182079);
        }

        public static void a(String str, int i2, dqb dqb) {
            AppMethodBeat.i(182080);
            g.azz().a(new r(str, i2, dqb), 0);
            AppMethodBeat.o(182080);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(182081);
            Log.i("MicroMsg.roomTodo.RoomTodoMsg", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
            AppMethodBeat.o(182081);
        }
    }
}

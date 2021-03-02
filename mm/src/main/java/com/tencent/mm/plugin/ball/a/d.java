package com.tencent.mm.plugin.ball.a;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import java.util.HashMap;
import java.util.Map;

public final class d implements b {
    public Map<Integer, b> oWa;

    /* synthetic */ d(byte b2) {
        this();
    }

    public static class a {
        public static d oWb = new d((byte) 0);

        static {
            AppMethodBeat.i(176954);
            AppMethodBeat.o(176954);
        }
    }

    private d() {
        AppMethodBeat.i(176955);
        this.oWa = new HashMap();
        AppMethodBeat.o(176955);
    }

    @Override // com.tencent.mm.plugin.ball.a.b
    public final boolean a(Context context, BallInfo ballInfo) {
        AppMethodBeat.i(176956);
        b bVar = this.oWa.get(Integer.valueOf(ballInfo.type));
        if (bVar == null) {
            AppMethodBeat.o(176956);
            return false;
        }
        boolean a2 = bVar.a(context, ballInfo);
        AppMethodBeat.o(176956);
        return a2;
    }

    @Override // com.tencent.mm.plugin.ball.a.b
    public final boolean a(TextView textView, BallInfo ballInfo) {
        AppMethodBeat.i(176957);
        b bVar = this.oWa.get(Integer.valueOf(ballInfo.type));
        if (bVar == null) {
            AppMethodBeat.o(176957);
            return false;
        }
        boolean a2 = bVar.a(textView, ballInfo);
        AppMethodBeat.o(176957);
        return a2;
    }
}

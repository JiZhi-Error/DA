package io.flutter.plugins;

import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.d;
import io.flutter.embedding.engine.a;
import io.flutter.plugin.a.m;

public final class GeneratedPluginRegistrant {
    private static final String TAG = "MicroMsg.Flutter.GeneratedPluginRegistrant";

    public static void registerWith(m mVar) {
        AppMethodBeat.i(159080);
        b.i(TAG, "registerWith", new Object[0]);
        if (alreadyRegisteredWith(mVar)) {
            AppMethodBeat.o(159080);
            return;
        }
        try {
            Class.forName("com.tencent.mm.plugin.flutter.model.ChannelRegistrant").getMethod("registerWith", m.class).invoke(null, mVar);
            AppMethodBeat.o(159080);
        } catch (ClassNotFoundException e2) {
            try {
                Class.forName("com.tencent.mm.plugin.luggage.natives.flutter.channel.ChannelRegistrant").getMethod("registerWith", m.class).invoke(null, mVar);
                AppMethodBeat.o(159080);
            } catch (Exception e3) {
                AppMethodBeat.o(159080);
            }
        } catch (Exception e4) {
            AppMethodBeat.o(159080);
        }
    }

    private static boolean alreadyRegisteredWith(m mVar) {
        AppMethodBeat.i(214853);
        String canonicalName = GeneratedPluginRegistrant.class.getCanonicalName();
        if (mVar.bsW(canonicalName)) {
            AppMethodBeat.o(214853);
            return true;
        }
        mVar.bsX(canonicalName);
        AppMethodBeat.o(214853);
        return false;
    }

    public static void registerWith(a aVar) {
        AppMethodBeat.i(214852);
        aVar.SNX.a(new com.tencent.liteapp.b());
        aVar.SNX.a(new d());
        aVar.SNX.a(new io.flutter.plugins.a.a());
        aVar.SNX.a(new j.a.a.a());
        aVar.SNX.a(new com.tencent.j.b());
        aVar.SNX.a(new com.tencent.mm.flutter.plugins.a.d());
        aVar.SNX.a(new com.github.a.a.b());
        try {
            Class.forName("com.tencent.mm.plugin.flutter.model.ChannelRegistrant").getMethod("registerWith", a.class).invoke(null, aVar);
            AppMethodBeat.o(214852);
        } catch (ClassNotFoundException e2) {
            try {
                Class.forName("com.tencent.mm.plugin.luggage.natives.flutter.channel.ChannelRegistrant").getMethod("registerWith", a.class).invoke(null, aVar);
                AppMethodBeat.o(214852);
            } catch (Exception e3) {
                AppMethodBeat.o(214852);
            }
        } catch (Exception e4) {
            AppMethodBeat.o(214852);
        }
    }
}

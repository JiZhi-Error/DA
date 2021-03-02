package j.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.r;
import com.tencent.tav.core.AssetExtension;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class a implements io.flutter.embedding.engine.plugins.a, k.c {
    private static final Logger Upy = Logger.getLogger(a.class.getCanonicalName());
    private Runnable UpA;
    boolean UpB;
    private final Map<String, b> Upz = new HashMap();
    k bbv;
    private Context context;
    private final Handler handler = new Handler();

    static /* synthetic */ Map K(String str, Object obj) {
        AppMethodBeat.i(204507);
        Map<String, Object> J = J(str, obj);
        AppMethodBeat.o(204507);
        return J;
    }

    static {
        AppMethodBeat.i(204508);
        AppMethodBeat.o(204508);
    }

    public a() {
        AppMethodBeat.i(204501);
        AppMethodBeat.o(204501);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(204502);
        k kVar = new k(bVar.SOH, "xyz.luan/audioplayers");
        this.bbv = kVar;
        this.context = bVar.applicationContext;
        this.UpB = false;
        kVar.a(this);
        AppMethodBeat.o(204502);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
    }

    static Map<String, Object> J(String str, Object obj) {
        AppMethodBeat.i(204505);
        HashMap hashMap = new HashMap();
        hashMap.put("playerId", str);
        hashMap.put("value", obj);
        AppMethodBeat.o(204505);
        return hashMap;
    }

    /* renamed from: j.a.a.a$a  reason: collision with other inner class name */
    static final class RunnableC2256a implements Runnable {
        private final WeakReference<Map<String, b>> UpC;
        private final WeakReference<k> UpD;
        private final WeakReference<Handler> UpE;
        private final WeakReference<a> UpF;

        /* synthetic */ RunnableC2256a(Map map, k kVar, Handler handler, a aVar, byte b2) {
            this(map, kVar, handler, aVar);
        }

        private RunnableC2256a(Map<String, b> map, k kVar, Handler handler, a aVar) {
            AppMethodBeat.i(204499);
            this.UpC = new WeakReference<>(map);
            this.UpD = new WeakReference<>(kVar);
            this.UpE = new WeakReference<>(handler);
            this.UpF = new WeakReference<>(aVar);
            AppMethodBeat.o(204499);
        }

        public final void run() {
            AppMethodBeat.i(204500);
            Map<String, b> map = this.UpC.get();
            k kVar = this.UpD.get();
            Handler handler = this.UpE.get();
            a aVar = this.UpF.get();
            if (map == null || kVar == null || handler == null || aVar == null) {
                if (aVar != null) {
                    a.a(aVar);
                }
                AppMethodBeat.o(204500);
                return;
            }
            boolean z = true;
            for (b bVar : map.values()) {
                if (bVar.hRs()) {
                    z = false;
                    try {
                        String esX = bVar.esX();
                        int duration = bVar.getDuration();
                        int currentPosition = bVar.getCurrentPosition();
                        kVar.a("audio.onDuration", a.K(esX, Integer.valueOf(duration)), null);
                        kVar.a("audio.onCurrentPosition", a.K(esX, Integer.valueOf(currentPosition)), null);
                        if (aVar.UpB) {
                            kVar.a("audio.onSeekComplete", a.K(bVar.esX(), Boolean.TRUE), null);
                            aVar.UpB = false;
                        }
                    } catch (UnsupportedOperationException e2) {
                    }
                }
            }
            if (z) {
                a.a(aVar);
                AppMethodBeat.o(204500);
                return;
            }
            handler.postDelayed(this, 200);
            AppMethodBeat.o(204500);
        }
    }

    @Override // io.flutter.plugin.a.k.c
    public final void a(j jVar, k.d dVar) {
        b eVar;
        AppMethodBeat.i(204503);
        try {
            String str = (String) jVar.btq("playerId");
            String str2 = (String) jVar.btq("mode");
            if (!this.Upz.containsKey(str)) {
                if (str2.equalsIgnoreCase("PlayerMode.MEDIA_PLAYER")) {
                    eVar = new d(this, str);
                } else {
                    eVar = new e(this, str);
                }
                this.Upz.put(str, eVar);
            }
            b bVar = this.Upz.get(str);
            String str3 = jVar.method;
            char c2 = 65535;
            switch (str3.hashCode()) {
                case -1757019252:
                    if (str3.equals("getCurrentPosition")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -934426579:
                    if (str3.equals("resume")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -905798227:
                    if (str3.equals("setUrl")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -844904701:
                    if (str3.equals("earpieceOrSpeakersToggle")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case -402284771:
                    if (str3.equals("setPlaybackRate")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 3443508:
                    if (str3.equals(AssetExtension.SCENE_PLAY)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3526264:
                    if (str3.equals("seek")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3540994:
                    if (str3.equals("stop")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 85887754:
                    if (str3.equals("getDuration")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 106440182:
                    if (str3.equals("pause")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 670514716:
                    if (str3.equals(r.NAME)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1090594823:
                    if (str3.equals("release")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2096116872:
                    if (str3.equals("setReleaseMode")) {
                        c2 = 11;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    double doubleValue = ((Double) jVar.btq("volume")).doubleValue();
                    Integer num = (Integer) jVar.btq("position");
                    boolean booleanValue = ((Boolean) jVar.btq("respectSilence")).booleanValue();
                    boolean booleanValue2 = ((Boolean) jVar.btq("isLocal")).booleanValue();
                    bVar.a(booleanValue, ((Boolean) jVar.btq("stayAwake")).booleanValue(), this.context.getApplicationContext());
                    bVar.u(doubleValue);
                    bVar.a((String) jVar.btq("url"), booleanValue2, this.context.getApplicationContext());
                    if (num != null && !str2.equals("PlayerMode.LOW_LATENCY")) {
                        bVar.seek(num.intValue());
                    }
                    bVar.mb(this.context.getApplicationContext());
                    break;
                case 1:
                    bVar.mb(this.context.getApplicationContext());
                    break;
                case 2:
                    bVar.pause();
                    break;
                case 3:
                    bVar.stop();
                    break;
                case 4:
                    bVar.release();
                    break;
                case 5:
                    bVar.seek(((Integer) jVar.btq("position")).intValue());
                    break;
                case 6:
                    bVar.u(((Double) jVar.btq("volume")).doubleValue());
                    break;
                case 7:
                    bVar.a((String) jVar.btq("url"), ((Boolean) jVar.btq("isLocal")).booleanValue(), this.context.getApplicationContext());
                    break;
                case '\b':
                    dVar.ba(Integer.valueOf(bVar.P(((Double) jVar.btq("playbackRate")).doubleValue())));
                    AppMethodBeat.o(204503);
                    return;
                case '\t':
                    dVar.ba(Integer.valueOf(bVar.getDuration()));
                    AppMethodBeat.o(204503);
                    return;
                case '\n':
                    dVar.ba(Integer.valueOf(bVar.getCurrentPosition()));
                    AppMethodBeat.o(204503);
                    return;
                case 11:
                    bVar.a(c.valueOf(((String) jVar.btq("releaseMode")).substring(12)));
                    break;
                case '\f':
                    bVar.p((String) jVar.btq("playingRoute"), this.context.getApplicationContext());
                    break;
                default:
                    dVar.dLv();
                    AppMethodBeat.o(204503);
                    return;
            }
            dVar.ba(1);
            AppMethodBeat.o(204503);
        } catch (Exception e2) {
            Upy.log(Level.SEVERE, "Unexpected error!", (Throwable) e2);
            dVar.b("Unexpected error!", e2.getMessage(), e2);
            AppMethodBeat.o(204503);
        }
    }

    public final void hRr() {
        AppMethodBeat.i(204504);
        if (this.UpA == null) {
            this.UpA = new RunnableC2256a(this.Upz, this.bbv, this.handler, this, (byte) 0);
            this.handler.post(this.UpA);
        }
        AppMethodBeat.o(204504);
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(204506);
        aVar.UpA = null;
        aVar.handler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(204506);
    }
}

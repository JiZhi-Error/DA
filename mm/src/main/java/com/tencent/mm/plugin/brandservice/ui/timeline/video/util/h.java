package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.Settings;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0017\u0018\u0000 )2\u00020\u0001:\u0001)B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\u001a\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010#\u001a\u00020\u000fH\u0016J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0006\u0010'\u001a\u00020\u001fJ\u0016\u0010(\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005R(\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0004\n\u0002\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u00050\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\r¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "Landroid/hardware/SensorEventListener;", "ctx", "Landroid/content/Context;", "video", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "context", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "currentDisplayRotation", "", "mCurrentZ", "", "mSensor", "Landroid/hardware/Sensor;", "mSensorManager", "Landroid/hardware/SensorManager;", "orientationChangeListener", "com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1;", "videoView", "getVideoView", "setVideoView", "checkContext", "", "enable", "", "isLockRotation", "onAccuracyChanged", "p0", "p1", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "release", "setInitData", "Companion", "plugin-brandservice_release"})
public final class h implements SensorEventListener {
    public static final a pKN = new a((byte) 0);
    public int iqr;
    public WeakReference<Context> lAM;
    public SensorManager mSensorManager;
    public WeakReference<MPVideoView> pKJ;
    public Sensor pKK;
    private float pKL = 10.0f;
    public b pKM;

    static {
        AppMethodBeat.i(7306);
        AppMethodBeat.o(7306);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public h(Context context, MPVideoView mPVideoView) {
        p.h(context, "ctx");
        p.h(mPVideoView, "video");
        AppMethodBeat.i(7305);
        this.lAM = new WeakReference<>(context);
        this.pKJ = new WeakReference<>(mPVideoView);
        Context context2 = this.lAM.get();
        this.pKM = new b(this, context2 != null ? context2.getApplicationContext() : null);
        AppMethodBeat.o(7305);
    }

    public static final /* synthetic */ boolean a(h hVar) {
        AppMethodBeat.i(7307);
        boolean aQs = hVar.aQs();
        AppMethodBeat.o(7307);
        return aQs;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-brandservice_release"})
    public static final class b extends OrientationEventListener {
        final /* synthetic */ h pKO;

        /* JADX WARN: Incorrect types in method signature: (Landroid/content/Context;I)V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar, Context context) {
            super(context, 3);
            this.pKO = hVar;
        }

        public final void onOrientationChanged(int i2) {
            int i3;
            AppMethodBeat.i(7301);
            if (!h.a(this.pKO) || this.pKO.pKJ.get() == null) {
                AppMethodBeat.o(7301);
                return;
            }
            if (80 <= i2 && 100 >= i2) {
                i3 = -90;
            } else if (260 <= i2 && 280 >= i2) {
                i3 = 90;
            } else if (170 <= i2 && 190 >= i2) {
                i3 = 180;
            } else if (i2 < 10 || i2 > 350) {
                i3 = 0;
            } else {
                AppMethodBeat.o(7301);
                return;
            }
            if (this.pKO.iqr == i3) {
                AppMethodBeat.o(7301);
                return;
            }
            Log.v("MicroMsg.BizVideoOrientationHelper", "last rotation :" + this.pKO.iqr + " ,current rotation:" + i3);
            MPVideoView mPVideoView = this.pKO.pKJ.get();
            if (mPVideoView == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
                AppMethodBeat.o(7301);
                throw tVar;
            } else if (Util.isNullOrNil(mPVideoView.getVideoPath())) {
                AppMethodBeat.o(7301);
            } else {
                MPVideoView mPVideoView2 = this.pKO.pKJ.get();
                if (mPVideoView2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
                    AppMethodBeat.o(7301);
                    throw tVar2;
                }
                if (mPVideoView2.bJb()) {
                    if (i3 == 0) {
                        if (!this.pKO.cqX() && Math.abs(this.pKO.pKL) < 6.0f) {
                            MPVideoView mPVideoView3 = this.pKO.pKJ.get();
                            if (mPVideoView3 != null) {
                                mPVideoView3.p(false, 0);
                            }
                            this.pKO.iqr = 0;
                            AppMethodBeat.o(7301);
                            return;
                        }
                    } else if (i3 == 90) {
                        MPVideoView mPVideoView4 = this.pKO.pKJ.get();
                        if (mPVideoView4 != null) {
                            mPVideoView4.setFullScreenDirection(90);
                        }
                        Context context = this.pKO.lAM.get();
                        if (context == null) {
                            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                            AppMethodBeat.o(7301);
                            throw tVar3;
                        }
                        ((MMActivity) context).setRequestedOrientation(0);
                        this.pKO.iqr = 90;
                        AppMethodBeat.o(7301);
                        return;
                    } else {
                        if (i3 == -90) {
                            MPVideoView mPVideoView5 = this.pKO.pKJ.get();
                            if (mPVideoView5 != null) {
                                mPVideoView5.setFullScreenDirection(-90);
                            }
                            Context context2 = this.pKO.lAM.get();
                            if (context2 == null) {
                                t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                                AppMethodBeat.o(7301);
                                throw tVar4;
                            }
                            ((MMActivity) context2).setRequestedOrientation(8);
                            this.pKO.iqr = -90;
                        }
                        AppMethodBeat.o(7301);
                        return;
                    }
                } else if (!this.pKO.cqX() && (i3 == 90 || i3 == -90)) {
                    MPVideoView mPVideoView6 = this.pKO.pKJ.get();
                    if (mPVideoView6 != null) {
                        mPVideoView6.setFullScreenDirection(i3);
                    }
                    MPVideoView mPVideoView7 = this.pKO.pKJ.get();
                    if (mPVideoView7 != null) {
                        mPVideoView7.p(true, i3);
                    }
                    this.pKO.iqr = i3;
                }
                AppMethodBeat.o(7301);
            }
        }
    }

    public final boolean cqX() {
        AppMethodBeat.i(7302);
        if (this.lAM.get() == null) {
            AppMethodBeat.o(7302);
            return true;
        }
        Context context = this.lAM.get();
        if (context == null) {
            p.hyc();
        }
        p.g(context, "context.get()!!");
        int i2 = Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0);
        Log.i("MicroMsg.BizVideoOrientationHelper", "accRotation=".concat(String.valueOf(i2)));
        if (i2 == 0) {
            AppMethodBeat.o(7302);
            return true;
        }
        AppMethodBeat.o(7302);
        return false;
    }

    public final boolean aQs() {
        AppMethodBeat.i(7303);
        if (this.lAM.get() == null) {
            AppMethodBeat.o(7303);
            return false;
        }
        AppMethodBeat.o(7303);
        return true;
    }

    public final void release() {
        AppMethodBeat.i(175530);
        this.pKM.disable();
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this, this.pKK);
        }
        this.mSensorManager = null;
        this.pKK = null;
        AppMethodBeat.o(175530);
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.i(7304);
        if ((sensorEvent != null ? sensorEvent.sensor : null) == null) {
            AppMethodBeat.o(7304);
            return;
        }
        Sensor sensor = sensorEvent.sensor;
        p.g(sensor, "event.sensor");
        if (sensor.getType() == 1) {
            this.pKL = sensorEvent.values[2];
        }
        AppMethodBeat.o(7304);
    }
}
